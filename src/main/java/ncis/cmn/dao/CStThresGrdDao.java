package ncis.cmn.dao;

import ncis.cmn.entity.StThresGrd;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 임계등급 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cStThresGrdDao")
public class CStThresGrdDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 임계등급 등록
	 * @param stThresGrd
	 */
	public void insertStThresGrd(StThresGrd stThresGrd) {
		sqlSession.insert("ncis.sql.cmn.stThresGrd.insertStThresGrd", stThresGrd);
	}

	/**
	 * 임계등급 수정
	 * @param stThresGrd
	 */
	public void updateStThresGrd(StThresGrd stThresGrd) {
		sqlSession.update("ncis.sql.cmn.stThresGrd.updateStThresGrd", stThresGrd);
	}

	/**
	 * 임계등급 삭제
	 * @param stThresGrd
	 */
	public void deleteStThresGrd(StThresGrd stThresGrd) {
		sqlSession.update("ncis.sql.cmn.stThresGrd.deleteStThresGrd", stThresGrd);
	}

}
