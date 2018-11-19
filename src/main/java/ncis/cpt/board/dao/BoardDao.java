/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BoardDao.java
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
package ncis.cpt.board.dao;

import java.util.List;
import ncis.cmn.vo.CommonFileVo;
import ncis.cpt.board.vo.BoardSearchVo;
import ncis.cpt.board.vo.BoardVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDao")
public class BoardDao {

//	@Resource(name="slaveSqlSession")
    @Autowired
    SqlSessionTemplate sqlSession;

	/**
	 * 검색 조건에 해당하는 게시판 글수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectBoardTotCnt(BoardSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.board.selectBoardTotCnt", searchVo);
	}

	/**
	 * 게시판 조회
	 * @param searchVo
	 * @return
	 */
	public List<BoardVo> selectBoardList(BoardSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.board.selectBoardList", searchVo);
	}

	/**
	 * 게시판 상세 조회
	 * @param boardSeq
	 * @return
	 */
	public BoardVo selectBoard(Long boardSeq) {
		return sqlSession.selectOne("ncis.sql.cpt.board.selectBoard", boardSeq);
	}

	/**
	 * 게시판 답변 조회
	 * @param boardSeq
	 * @return
	 */
	public BoardVo selectAnswer(Long boardSeq) {
		return sqlSession.selectOne("ncis.sql.cpt.board.selectAnswer", boardSeq);
	}

	/**
	 * 파일조회(다운로드시 사용)
	 * @param seq
	 * @return
	 */
	public CommonFileVo selectFile(Long seq) {
		return sqlSession.selectOne("ncis.sql.cpt.board.selectFile", seq);
	}
}
