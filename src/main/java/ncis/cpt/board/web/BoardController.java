/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BoardController.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 9. 30.
 * @lastmodified 2016. 9. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 30.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.board.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.util.FileManageUtil;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.vo.CommonFileVo;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.board.service.BoardService;
import ncis.cpt.board.vo.BoardFileVo;
import ncis.cpt.board.vo.BoardSearchVo;
import ncis.cpt.board.vo.BoardVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("boardController")
@RequestMapping(value = { "/cpt/board", "/api/board" })
public class BoardController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(BoardController.class);

	private final String FILE_PATH = "board";

	@Resource(name = "boardService")
	BoardService boardService;

	/**
	 * 게시판 목록 조회
	 *
	 * @param boardId
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value = "/{boardCd}/selectBoardList.do")
	public String selectBoardList(@PathVariable("boardCd") String boardCd, HttpServletRequest request, Model model, BoardSearchVo searchVo) {

		List<BoardVo> list = boardService.selectBoardList(searchVo); // 게시글list 가져오기

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);

		// 포털, api gateway 구분
		if (boardCd.contains("api")) {
			return apiTilesView(request);
		} else {
			return portalTilesView(request);
		}
	}

	/**
	 * 게시판 등록 화면
	 *
	 * @param boardId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{boardCd}/insertBoard.do", method = RequestMethod.GET)
	public String insertBoardView(@PathVariable("boardCd") String boardCd, HttpServletRequest request, Model model) {

		model.addAttribute("vo", new BoardVo());

		// 포털, api gateway 구분
		if (boardCd.contains("api")) {
			return apiTilesView(request, "formBoard");
		} else {
			return portalTilesView(request, "formBoard");
		}
	}

	/**
	 * 게시판 등록 프로세스
	 *
	 * @param boardId
	 * @param boardVo
	 * @return
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@RequestMapping(value = "/{boardCd}/insertBoard.do", method = RequestMethod.POST)
	@OperateLog(action = "게시판 등록", desc = "게시판 내용 등록 처리", params = { "boardCd" }, actionType = ActionType.INSERT)
	@ResponseBody
	public ProcResultVo insertBoard(HttpServletRequest request,  @PathVariable("boardCd") String boardCd, @ModelAttribute("vo") BoardVo boardVo, BindingResult bindResult) {
		//validation 체크
        ProcResultVo result = getBindingResult(boardVo, bindResult, InsertProc.class);

        try {
        	//최대 업로드 용량 체크
        	if( null != request.getAttribute("MaxUPloadSizeExceededException") ) {
        		return getFailProcResult("최대 업로드 용량을 초과했습니다.");
        	}

	        if (result.isSuccess()) {
	        	//업로드 파일이 존재할 시 파일 업로드
	            if (!ObjectUtils.isEmpty(boardVo.getUploadFile())) {
	                boardVo.setBoardFiles(FileManageUtil.uploadFiles(boardVo.getUploadFile(), FILE_PATH, BoardFileVo.class, FileManageUtil.FileType.DEFAULT));
                }
	            //게시판 생성자 이름 체크
	            if (null == boardVo.getRegNm() || "".equals(boardVo.getRegNm())) {
	                boardVo.setRegNm(getUserName());
	            }
	            boardVo.setBoardCd(boardCd);
	            boardVo.setRegId(getUserId());
	            boardVo.setUpdtId(getUserId());

	            boardService.insertBoard(boardVo);
	            result.setProcType("insert");
	        }

        } catch (InstantiationException | IllegalAccessException | IOException e) {
            logger.error(e.getMessage());

            result.addMessage("게시판 저장 시 오류가 발생하였습니다.");
            result.setSuccess(false);
        }


	    return result;

	}

	/**
	 * 게시판 상세 조회
	 *
	 * @param boardId
	 * @param request
	 * @param model
	 * @param boardSeq
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value = "/{boardCd}/selectBoard.do")
	public String selectBoard(@PathVariable("boardCd") String boardCd, HttpServletRequest request, Model model, @RequestParam("boardSeq") Long boardSeq, BoardSearchVo searchVo) {

		BoardVo vo = boardService.selectBoard(boardSeq);

		//vo에 값이 없으면 오류화면 호출
		if( ObjectUtils.isEmpty(vo) ) {
            throw new DataNotFoundException(messageUtil.getMessage("message.error.dataNotFound"));
        }

		//조회 수 증가
		boardService.updateBoardHitCnt(boardSeq);

		BoardVo answervo = boardService.selectAnswer(boardSeq);

		model.addAttribute("vo", vo);
		model.addAttribute("answervo", answervo);
		model.addAttribute("searchVo", searchVo);

		// 포털, api gateway 구분
		if (boardCd.startsWith("api")) {
			return apiTilesView(request);
		} else {
			return portalTilesView(request);
		}
	}

	/**
	 * 게시판 업데이트 화면
	 *
	 * @param boardId
	 * @param request
	 * @param model
	 * @param boardSeq
	 * @return
	 */
	@RequestMapping(value = "/{boardCd}/updateBoard.do", method = RequestMethod.GET)
	public String updateBoardView(@PathVariable("boardCd") String boardCd, HttpServletRequest request, Model model, @RequestParam("boardSeq") Long boardSeq) {

		BoardVo vo = boardService.selectBoard(boardSeq);
		//vo가 없으면 오류화면 호출
		if( ObjectUtils.isEmpty(vo) ) {
            throw new DataNotFoundException(messageUtil.getMessage("message.error.dataNotFound"));
        }

		model.addAttribute("vo", vo);

		// 포털, api gateway 구분
		if (boardCd.contains("api")) {
			return apiTilesView(request, "formBoard");
		} else {
			return portalTilesView(request, "formBoard");
		}
	}

	/**
	 * 게시판 업데이트 프로세스
	 *
	 * @param boardId
	 * @param boardVo
	 * @return
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@RequestMapping(value = "/{boardCd}/updateBoard.do", method = RequestMethod.POST)
	@OperateLog(action = "게시판 수정", desc = "게시판 내용 수정 처리", params = { "boardCd", "boardSeq" }, actionType = ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateBoard(@PathVariable("boardCd") String boardCd, @ModelAttribute("vo") BoardVo boardVo)  throws Exception {

		ProcResultVo result = new ProcResultVo();

		try {
			//업로드 파일 여부 체크
    		if (!ObjectUtils.isEmpty(boardVo.getUploadFile())) {
    			boardVo.setBoardFiles(FileManageUtil.uploadFiles(boardVo.getUploadFile(), FILE_PATH, BoardFileVo.class, FileManageUtil.FileType.DEFAULT));
    		}

    		boardVo.setBoardCd(boardCd);
    		boardVo.setRegNm(getUserName());
    		boardVo.setRegId(getUserId());
    		boardVo.setUpdtId(getUserId());

    		boardService.updateBoard(boardVo);

    		result.setProcType("update");
    		result.setSuccess(true);

		} catch (InstantiationException | IllegalAccessException | IOException e) {
            logger.error(e.getMessage());

            result.addMessage("게시판 저장 시 오류가 발생하였습니다.");
            result.setSuccess(false);
        }
		return result;
	}

	/**
	 * 게시판 삭제
	 *
	 * @param boardId
	 * @param boardVo
	 * @return
	 */
	@RequestMapping(value = "/{boardCd}/deleteBoard.do", method = RequestMethod.POST)
	@OperateLog(action = "게시판 삭제", desc = "게시판 내용 삭제 처리")
	@ResponseBody
	public ProcResultVo delete(@PathVariable("boardCd") String boardCd, @RequestParam(required=true) Long boardSeq) {

		boardService.deleteBoard(boardSeq);
		return getSuccessProcResult("게시물이 삭제되었습니다.", "delete");
	}

	/**
	 * 게시판 파일 다운 로드
	 *
	 * @param request
	 * @param response
	 * @param seq
	 * @throws IOException
	 */
	@RequestMapping(value = "/{boardCd}/downfile.do")
	@OperateLog(action = "게시판 파일 다운로드", desc = "게시판 파일 다운로드")
	public void downFile(HttpServletRequest request, HttpServletResponse response, @PathVariable("boardCd") String boardCd, @RequestParam("seq") Long seq) throws IOException {

		CommonFileVo file = boardService.selectFile(seq);
		FileManageUtil.downFile(request, response, file.getDownFileName(), file.getOriginFileName());
	}

	/**
	 * 답변 등록 화면
	 *
	 * @param boardId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{boardCd}/insertAnswer.do", method = RequestMethod.GET)
	public String insertAnswerView(@PathVariable("boardCd") String boardCd, @RequestParam("boardSeq") Long boardSeq, HttpServletRequest request, Model model) {
		BoardVo vo = boardService.selectBoard(boardSeq);

		model.addAttribute("vo", vo);
		model.addAttribute("answervo", new BoardVo());

		// 포털, api gateway 구분
		if (boardCd.contains("api")) {
			return apiTilesView(request, "formAnswer");
		} else {
			return portalTilesView(request, "formAnswer");
		}
	}

	/**
	 * 답변 등록 프로세스
	 *
	 * @param boardId
	 * @param boardVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/{boardCd}/insertAnswer.do", method = RequestMethod.POST)
	@OperateLog(action = "답변 등록", desc = "답변 내용 등록 처리", params = { "boardCd" }, actionType = ActionType.INSERT)
	@ResponseBody
	public ProcResultVo insertAnswer(@PathVariable("boardCd") String boardCd, @ModelAttribute("vo") BoardVo boardVo, BindingResult bindResult) {
		//validation 체크
		ProcResultVo result = getBindingResult(boardVo, bindResult, InsertProc.class);

		try {
    		if (result.isSuccess()) {
    			//파일 업로드 여부 체크
    			if (!ObjectUtils.isEmpty(boardVo.getUploadFile())) {
    			    boardVo.setBoardFiles(FileManageUtil.uploadFiles(boardVo.getUploadFile(), FILE_PATH, BoardFileVo.class, FileManageUtil.FileType.DEFAULT));
            	}
    			//게시판 생성자 이름 여부 체크
    			if (null == boardVo.getRegNm() || "".equals(boardVo.getRegNm())) {
    				boardVo.setRegNm(getUserName());
    			}

    			boardVo.setBoardCd(boardCd);
    			boardVo.setRegId(getUserId());
    			boardVo.setUpdtId(getUserId());

    			boardService.insertBoard(boardVo);

    			result.setProcType("insert");
    		}

        } catch (InstantiationException | IllegalAccessException | IOException e) {
            logger.error(e.getMessage());

            result.addMessage("게시판 답변 저장 시 오류가 발생하였습니다.");
            result.setSuccess(false);
        }


		return result;
	}



	/**
	 * 답변 업데이트 화면
	 *
	 * @param boardId
	 * @param request
	 * @param model
	 * @param boardSeq
	 * @return
	 */
	@RequestMapping(value = "/{boardCd}/updateAnswer.do", method = RequestMethod.GET)
	public String updateAnswerView(@PathVariable("boardCd") String boardCd, HttpServletRequest request, Model model, @RequestParam("boardSeq") Long boardSeq, @RequestParam("parentSeq") Long parentSeq) {

		BoardVo vo = boardService.selectBoard(boardSeq);
		BoardVo answervo = boardService.selectBoard(parentSeq);

		model.addAttribute("vo", vo);
		model.addAttribute("answervo", answervo);

		// 포털, api gateway 구분
		if (boardCd.contains("api")) {
			return apiTilesView(request, "formAnswer");
		} else {
			return portalTilesView(request, "formAnswer");
		}
	}

	/**
	 * 답변 업데이트 프로세스
	 *
	 * @param boardId
	 * @param boardVo
	 * @return
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@RequestMapping(value = "/{boardCd}/updateAnswer.do", method = RequestMethod.POST)
	@OperateLog(action = "답변 수정", desc = "답변 내용 수정 처리", params = { "boardCd", "boardSeq" }, actionType = ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateAnswer(@PathVariable("boardCd") String boardCd, @ModelAttribute("answervo") BoardVo answervo, BindingResult bindResult)  throws Exception {
		//validation 체크
	    ProcResultVo result = getBindingResult(answervo, bindResult, InsertProc.class);

		try {
		    if (result.isSuccess()) {
		    	//업로드 파일 여부 체크
        		if (!ObjectUtils.isEmpty(answervo.getUploadFile())) {
        			answervo.setBoardFiles(FileManageUtil.uploadFiles(answervo.getUploadFile(), FILE_PATH, BoardFileVo.class, FileManageUtil.FileType.DEFAULT));
        		}

        		answervo.setBoardCd(boardCd);
        		answervo.setRegNm(getUserName());
        		answervo.setRegId(getUserId());
        		answervo.setUpdtId(getUserId());

        		boardService.updateBoard(answervo);

        		result.setProcType("update");
        		result.setSuccess(true);
		    }

		} catch (InstantiationException | IllegalAccessException | IOException e) {
            logger.error(e.getMessage());

            result.addMessage("게시판 답변 저장 시 오류가 발생하였습니다.");
            result.setSuccess(false);
        }

		return result;
	}

}
