package ncis.cmn.dao;

import ncis.cmn.entity.StPmColctSum;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 물리서버_수집집계 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cStPmColctSumDao")
public class CStPmColctSumDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 물리서버_수집집계 등록
	 * @param stPmColctSum
	 */
	public void insertStPmColctSum(StPmColctSum stPmColctSum) {
		sqlSession.insert("ncis.sql.cmn.stPmColctSum.insertStPmColctSum", stPmColctSum);
	}

	/**
	 * 물리서버_수집집계 수정
	 * @param stPmColctSum
	 */
	public void updateStPmColctSum(StPmColctSum stPmColctSum) {
		sqlSession.update("ncis.sql.cmn.stPmColctSum.updateStPmColctSum", stPmColctSum);
	}

	/**
	 * 물리서버_수집집계 삭제
	 * @param stPmColctSum
	 */
	public void deleteStPmColctSum(StPmColctSum stPmColctSum) {
		sqlSession.update("ncis.sql.cmn.stPmColctSum.deleteStPmColctSum", stPmColctSum);
	}

}
