/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BoardServiceImpl.java
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
package ncis.cpt.board.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.CCmBoardDao;
import ncis.cmn.util.ObjectUtils;
import ncis.cmn.vo.CommonFileVo;
import ncis.cpt.board.dao.BoardDao;
import ncis.cpt.board.service.BoardService;
import ncis.cpt.board.vo.BoardFileVo;
import ncis.cpt.board.vo.BoardSearchVo;
import ncis.cpt.board.vo.BoardVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	private final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Resource(name = "cCmBoardDao")
	private CCmBoardDao cCmBoardDao;
	@Resource(name = "boardDao")
	private BoardDao boardDao;

	@Override
	public List<BoardVo> selectBoardList(BoardSearchVo searchVo) {

		List<BoardVo> list = null;
		//게시물 총 개수 체크
		int totalCount = boardDao.selectBoardTotCnt(searchVo);
		//게시물 체크 후 리스트 불러오기
		if (totalCount > 0) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount); // 페이지 처리위한 count

			list = boardDao.selectBoardList(searchVo);
		}

		return list;
	}

	@Override
	public BoardVo selectBoard(Long boardSeq) {
		return boardDao.selectBoard(boardSeq);
	}

	@Override
	public BoardVo selectAnswer(Long boardSeq) {
		return boardDao.selectAnswer(boardSeq);
	}

	@Override
	public void insertBoard(BoardVo boardVo) {

		cCmBoardDao.insertCmBoard(boardVo);
		//업로드 파일 여부 체크
		if (!ObjectUtils.isEmpty(boardVo.getBoardFiles())) {
			int fileSize = boardVo.getBoardFiles().size();
			for (int i = 0; i < fileSize; i++) {
				BoardFileVo file = boardVo.getBoardFiles().get(i);
				file.setBoardSeq(boardVo.getBoardSeq());
				file.setOrder(i + 1);
				file.setRegId(boardVo.getRegId());

				cCmBoardDao.insertCmBoardFiles(file);
			}
		}
	}

	@Override
	public void updateBoard(BoardVo boardVo) throws Exception {

		cCmBoardDao.updateCmBoard(boardVo);

		// 삭제된 파일이 있으면
		CommonFileVo boardFile = null;
		String filePath = null;
		String fileNm = null;
		if (!ObjectUtils.isEmpty(boardVo.getDeleteFile())) {
			for (Long deleteFileSeq : boardVo.getDeleteFile() ) {
				boardFile =  boardDao.selectFile(deleteFileSeq);
				filePath = boardFile.getFilePath();
				fileNm = boardFile.getSaveFileName();

				try {
					new File(filePath, fileNm).delete();
				} catch (Exception e) {
					logger.error(e.getMessage());
				}

				cCmBoardDao.deleteCmBoardFile(deleteFileSeq);
			}
		}

		// 첨부된 파일이 있으면
		if (!ObjectUtils.isEmpty(boardVo.getBoardFiles())) {
			int fileSize = boardVo.getBoardFiles().size();
			for (int i = 0; i < fileSize; i++) {
				BoardFileVo file = boardVo.getBoardFiles().get(i);

				if (file.getSeq() == null) {
					file.setBoardSeq(boardVo.getBoardSeq());
					file.setOrder(i + 1);
					file.setRegId(boardVo.getRegId());

					cCmBoardDao.insertCmBoardFiles(file);
				}
			}
		}
	}

	@Override
	public void updateBoardHitCnt(Long boardSeq) {
		cCmBoardDao.updateBoardHitCnt(boardSeq);
	}

	@Override
	public void deleteBoard(Long boardSeq) {

		BoardVo tempVo = boardDao.selectBoard(boardSeq);
		//자식 게시판 삭제
		if( null != tempVo.getAnswer() ) {
			BoardVo child = tempVo.getAnswer();
			for (CommonFileVo fileVo : child.getBoardFiles()) {

				try {
					new File(fileVo.getFilePath(), fileVo.getSaveFileName()).delete();
				} catch (Exception e) {
					logger.error(e.getMessage());
				}

				cCmBoardDao.deleteCmBoardFile(fileVo.getSeq());

			}
			cCmBoardDao.deleteCmBoard(child.getBoardSeq());
		}

		for (CommonFileVo fileVo : tempVo.getBoardFiles()) {

			try {
				new File(fileVo.getFilePath(), fileVo.getSaveFileName()).delete();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}

			cCmBoardDao.deleteCmBoardFile(fileVo.getSeq());
		}

		cCmBoardDao.deleteCmBoard(boardSeq);

	}

	@Override
	public CommonFileVo selectFile(Long seq) {
		return boardDao.selectFile(seq);
	}

}
