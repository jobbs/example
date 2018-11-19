package ncis.cmn.dao;

import ncis.cmn.entity.StVmColctSum;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 가상서버_수집집계 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cStVmColctSumDao")
public class CStVmColctSumDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 가상서버_수집집계 등록
	 * @param stVmColctSum
	 */
	public void insertStVmColctSum(StVmColctSum stVmColctSum) {
		sqlSession.insert("ncis.sql.cmn.stVmColctSum.insertStVmColctSum", stVmColctSum);
	}

	/**
	 * 가상서버_수집집계 수정
	 * @param stVmColctSum
	 */
	public void updateStVmColctSum(StVmColctSum stVmColctSum) {
		sqlSession.update("ncis.sql.cmn.stVmColctSum.updateStVmColctSum", stVmColctSum);
	}

	/**
	 * 가상서버_수집집계 삭제
	 * @param stVmColctSum
	 */
	public void deleteStVmColctSum(StVmColctSum stVmColctSum) {
		sqlSession.update("ncis.sql.cmn.stVmColctSum.deleteStVmColctSum", stVmColctSum);
	}

}
