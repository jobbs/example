/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename WordDicaryController.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.worddicary.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.cpt.worddicary.service.WordDicaryService;
import ncis.cpt.worddicary.vo.WordDicarySearchVo;
import ncis.cpt.worddicary.vo.WordDicaryVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author selim
 *
 */
@Controller
@RequestMapping(value="/cpt/worddicary/word/")
public class WordDicaryController extends BaseController {

	@Resource(name="wordDicaryService")
	WordDicaryService wordDicaryService;

	/**
	 * 용어사전 목록 조회
	 * @param boardId
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectWordDicaryList.do")
	public String selectWordDicaryList(HttpServletRequest request, Model model, WordDicarySearchVo searchVo){

		searchVo.setSearchDiv("W");
		List<WordDicaryVo> list = wordDicaryService.selectWordDicaryList(searchVo);	// 게시글list 가져오기

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);

		return portalTilesView(request);
	}

	/**
	 * 용어사전 등록 화면
	 * @param boardId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/insertWordDicary.do", method=RequestMethod.GET)
	public String insertWordDicaryView(HttpServletRequest request, Model model){

		model.addAttribute("vo", new WordDicaryVo());

		return portalTilesView(request, "formWordDicary");
	}

	/**
	 * 용어사전 등록 프로세스
	 * @param boardId
	 * @param boardVo
	 * @return
	 */
	@RequestMapping(value="/insertWordDicary.do", method=RequestMethod.POST)
	@OperateLog(action="용어사전 등록", desc="용어사전 내용 등록 처리", params={"boardCd"}, actionType=ActionType.INSERT)
	@ResponseBody
	public ProcResultVo insertWordDicary(@ModelAttribute("vo") WordDicaryVo wordDicaryVo, BindingResult bindResult) {

		ProcResultVo result = getBindingResult(wordDicaryVo, bindResult, InsertProc.class);

		if( result.isSuccess() ) {

			wordDicaryVo.setDicaryDiv("W");
			wordDicaryVo.setRegId(getUserId());
			wordDicaryVo.setModId(getUserId());

			wordDicaryService.insertWordDicary(wordDicaryVo);

			result.setProcType("insert");
		}

		return result;
	}

	/**
	 * 용어사전 상세 조회
	 * @param boardId
	 * @param request
	 * @param model
	 * @param boardSeq
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectWordDicary.do")
	public String selectWordDicary(HttpServletRequest request,
			Model model, @RequestParam("wordSeq") Long wordSeq){

		WordDicaryVo vo = wordDicaryService.selecWordDicary(wordSeq);

		model.addAttribute("vo", vo);
		return portalTilesView(request);
	}

	/**
	 * 용어사전 업데이트 화면
	 * @param boardId
	 * @param request
	 * @param model
	 * @param boardSeq
	 * @return
	 */
	@RequestMapping(value="/updateWordDicary.do", method=RequestMethod.GET)
	public String updateWordDicaryView(HttpServletRequest request, Model model, @RequestParam("wordSeq") Long wordSeq){

		WordDicaryVo vo = wordDicaryService.selecWordDicary(wordSeq);

		model.addAttribute("vo", vo);
		return portalTilesView(request, "formWordDicary");
	}

	/**
	 * 용어사전 업데이트 프로세스
	 * @param boardId
	 * @param boardVo
	 * @return
	 */
	@RequestMapping(value="/updateWordDicary.do", method=RequestMethod.POST)
	@OperateLog(action="용어사전 수정", desc="용어사전 내용 수정 처리", params={"wordSeq", "wordKr"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateWordDicary(@ModelAttribute("vo") WordDicaryVo wordDicaryVo) {

		ProcResultVo result = new ProcResultVo();

		wordDicaryVo.setRegId(getUserId());
		wordDicaryVo.setModId(getUserId());

		wordDicaryService.updateWordDicary(wordDicaryVo);

		result.setProcType("update");
		result.setSuccess(true);

		return result;
	}

	/**
	 * 용어사전 삭제
	 * @param boardId
	 * @param boardVo
	 * @return
	 */
	@RequestMapping(value="/deleteWordDicary.do", method=RequestMethod.POST)
	@OperateLog(action="용어사전 삭제", desc="용어사전 내용 삭제 처리")
	@ResponseBody
	public ProcResultVo delete(@RequestParam(name="wordSeq")Long wordSeq) {

		ProcResultVo result = new ProcResultVo();

		wordDicaryService.deleteWordDicary(wordSeq);

		result.setSuccess(true);

		return result;
	}


}
