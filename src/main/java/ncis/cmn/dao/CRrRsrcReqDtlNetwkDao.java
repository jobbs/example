package ncis.cmn.dao;

import java.math.BigDecimal;

import ncis.cmn.entity.RrRsrcReqDtlNetwk;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 자원요청상세_네트워크 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrRsrcReqDtlNetwkDao")
public class CRrRsrcReqDtlNetwkDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 자원요청상세_네트워크 등록
	 * @param rrRsrcReqDtlNetwk
	 */
	public BigDecimal insertRrRsrcReqDtlNetwk(RrRsrcReqDtlNetwk rrRsrcReqDtlNetwk) {

		sqlSession.insert("ncis.sql.cmn.rrRsrcReqDtlNetwk.insertRrRsrcReqDtlNetwk", rrRsrcReqDtlNetwk);

		return rrRsrcReqDtlNetwk.getRsrcReqSeq();
	}

	/**
	 * 자원요청상세_네트워크 수정
	 * @param rrRsrcReqDtlNetwk
	 */
	public void updateRrRsrcReqDtlNetwk(RrRsrcReqDtlNetwk rrRsrcReqDtlNetwk) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReqDtlNetwk.updateRrRsrcReqDtlNetwk", rrRsrcReqDtlNetwk);
	}


	/**
	 * 자원요청상세_네트워크 상태 수정
	 */
	public void updateRsrcReqNetwkPrcssStatCd(RrRsrcReqDtlNetwk rrRsrcReqDtlNetwk) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReqDtlNetwk.updateRsrcReqNetwkPrcssStatCd", rrRsrcReqDtlNetwk);
	}

	/**
	 * 자원요청상세_네트워크 삭제
	 * @param rrRsrcReqDtlNetwk
	 */
	public void deleteRrRsrcReqDtlNetwk(RrRsrcReqDtlNetwk rrRsrcReqDtlNetwk) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReqDtlNetwk.deleteRrRsrcReqDtlNetwk", rrRsrcReqDtlNetwk);
	}

	/**
	 * 자원요청상세_네트워크 초기화
	 * @param rrRsrcReqDtlNetwk
	 */
	public void updateRrRsrcReqDtlNetwkInitExeInfo(RrRsrcReqDtlNetwk rrRsrcReqDtlNetwk) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReqDtlNetwk.updateRrRsrcReqDtlNetwkInitExeInfo", rrRsrcReqDtlNetwk);
	}



}
