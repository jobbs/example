package ncis.cmn.dao;

import ncis.cmn.entity.RnNetwkSwtch;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 네크워크스위치 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRnNetwkSwtchDao")
public class CRnNetwkSwtchDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 네크워크스위치 등록
	 * @param rnNetwkSwtch
	 */
	public void insertRnNetwkSwtch(RnNetwkSwtch rnNetwkSwtch) {
		sqlSession.insert("ncis.sql.cmn.rnNetwkSwtch.insertRnNetwkSwtch", rnNetwkSwtch);
	}

	/**
	 * 네크워크스위치 수정
	 * @param rnNetwkSwtch
	 */
	public void updateRnNetwkSwtch(RnNetwkSwtch rnNetwkSwtch) {
		sqlSession.update("ncis.sql.cmn.rnNetwkSwtch.updateRnNetwkSwtch", rnNetwkSwtch);
		//sqlSession.update("ncis.sql.cmn.rnNetwkSwtch.updateNetVmInst", rnNetwkSwtch);
	}

	/**
	 * 네크워크스위치 수정 (L3-L4 관계설정)
	 * @param rnNetwkSwtch
	 * @since 2016.12.15 SQL 분리
	 */
	public void updateRnNetwkSwtchUpperVm(RnNetwkSwtch rnNetwkSwtch) {
		//sqlSession.update("ncis.sql.cmn.rnNetwkSwtch.updateRnNetwkSwtch", rnNetwkSwtch);
		sqlSession.update("ncis.sql.cmn.rnNetwkSwtch.updateNetVmInst", rnNetwkSwtch);
	}


	/**
	 * 네크워크스위치 삭제
	 * @param rnNetwkSwtch
	 */
	public void deleteRnNetwkSwtch(RnNetwkSwtch rnNetwkSwtch) {
		sqlSession.update("ncis.sql.cmn.rnNetwkSwtch.deleteRnNetwkSwtch", rnNetwkSwtch);
	}

}
