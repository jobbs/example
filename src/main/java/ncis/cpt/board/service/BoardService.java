/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BoardService.java
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
package ncis.cpt.board.service;

import java.util.List;

import ncis.cmn.vo.CommonFileVo;
import ncis.cpt.board.vo.BoardSearchVo;
import ncis.cpt.board.vo.BoardVo;

public interface BoardService {

	/**
	 * 검색 조건에 해당하는 게시판 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	List<BoardVo> selectBoardList(BoardSearchVo searchVo);

	/**
	 * Sequence에 해당하는 게시판 정보 조회(게시판 상세 조회)
	 * @param boardSeq
	 * @return
	 */
	BoardVo selectBoard(Long boardSeq);

	/**
	 * Sequence에 해당하는 게시판 답변 조회(게시판 상세 조회)
	 * @param boardSeq
	 * @return
	 */
	BoardVo selectAnswer(Long boardSeq);

	/**
	 * 게시판 등록
	 * @param boardVo 게시판 내용
	 */
	void insertBoard(BoardVo boardVo);

	/**
	 * 게시판 업데이트
	 * @param boardVo	게시판 내용
	 */
	void updateBoard(BoardVo boardVo) throws Exception;

	/**
	 * 게시판 삭제
	 * @param boardVo	게시판 내용
	 */
	void deleteBoard(Long boardSeq);

	/**
	 * 게시판에 등록되어 있는 파일 정보 확인
	 * @param seq	게시판 Sequence
	 * @return
	 */
	CommonFileVo selectFile(Long seq);

	/**
	 * 조회 수 증가
	 * @param boardSeq
	 */
	void updateBoardHitCnt(Long boardSeq);

}
