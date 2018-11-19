/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmBoardDao.java
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
package ncis.cmn.dao;

import ncis.cmn.entity.CmBoard;
import ncis.cmn.vo.CommonFileVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cCmBoardDao")
public class CCmBoardDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 게시판 등록
	 * @param cmBoard
	 */
	public void insertCmBoard(CmBoard cmBoard) {
		sqlSession.insert("ncis.sql.cmn.Cmboard.insertCmBoard", cmBoard);
	}

	/**
	 * 게시판 파일 등록
	 * @param file
	 */
	public void insertCmBoardFiles(CommonFileVo file) {
		sqlSession.insert("ncis.sql.cmn.Cmboard.insertCmBoardFiles", file);
	}

	/**
	 * 게시판 수정
	 * @param cmBoard
	 */
	public void updateCmBoard(CmBoard cmBoard) {
		sqlSession.update("ncis.sql.cmn.Cmboard.updateCmBoard", cmBoard);
	}

	/**
	 * 게시판에 등록된 파일 삭제
	 * @param cmBoard
	 */
	public void deleteCmBoardFiles(CmBoard cmBoard) {
		sqlSession.delete("ncis.sql.cmn.Cmboard.deleteCmBoardFiles", cmBoard);
	}

	/**
	 * @param deleteFileSeq
	 */
	public void deleteCmBoardFile(Long deleteFileSeq) {
		sqlSession.delete("ncis.sql.cmn.Cmboard.deleteCmBoardFile", deleteFileSeq);
	}

	/**
	 * 게시판 삭제
	 * @param cmBoard
	 */
	public void deleteCmBoard(Long boardSeq) {
		sqlSession.update("ncis.sql.cmn.Cmboard.deleteCmBoard", boardSeq);
	}

	/**
	 * @param boardSeq
	 */
	public void updateBoardHitCnt(Long boardSeq) {
		sqlSession.update("ncis.sql.cmn.Cmboard.updateBoardHitCnt", boardSeq);
	}

}
