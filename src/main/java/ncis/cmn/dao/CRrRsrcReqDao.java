package ncis.cmn.dao;

import ncis.cmn.entity.RrRsrcReq;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 자원요청 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrRsrcReqDao")
public class CRrRsrcReqDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 자원요청 등록
	 * @param rrRsrcReq
	 */
	public void insertRrRsrcReq(RrRsrcReq rrRsrcReq) {
		sqlSession.insert("ncis.sql.cmn.rrRsrcReq.insertRrRsrcReq", rrRsrcReq);
	}

	/**
	 * 자원요청 수정
	 * @param rrRsrcReq
	 */
	public void updateRrRsrcReq(RrRsrcReq rrRsrcReq) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReq.updateRrRsrcReq", rrRsrcReq);
	}

	/**
	 * 자원요청 자원요청진행상태코드 수정
	 * @param rrRsrcReq
	 */
	public void updateRsrcReqPrcssStatCd(RrRsrcReq rrRsrcReq) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReq.updateRsrcReqPrcssStatCd", rrRsrcReq);
	}

	/**
	 * 자원요청 삭제
	 * @param rrRsrcReq
	 */
	public void deleteRrRsrcReq(RrRsrcReq rrRsrcReq) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReq.deleteRrRsrcReq", rrRsrcReq);
	}


	/**
	 * 자원요청 실행정보 상태코드 수정
	 * @param rrRsrcReq
	 */
	public void updateRrRsrcReqExeInfo(RrRsrcReq rrRsrcReq) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReq.updateRrRsrcReqExeInfo", rrRsrcReq);
	}

	/**
	 * 자원요청 진행상태 수정
	 * @param rrRsrcReq
	 */
	public void updateRsrcReqPrcssStat(RrRsrcReq rrRsrcReq) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReq.updateRsrcReqPrcssStat", rrRsrcReq);
	}

	/**
	 * 자원요청 삭제여부 수정
	 * @param rrRsrcReq
	 */
	public void updateRsrcReqDeleteYn(RrRsrcReq rrRsrcReq) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReq.updateRsrcReqDeleteYn", rrRsrcReq);
	}
	
	/**
	 * 자동확장 등록
	 * @param rrRsrcReq
	 */
	public void insertRrRsrcReqAtmScl(RrRsrcReq rrRsrcReq) {
		sqlSession.insert("ncis.sql.cmn.rrRsrcReq.insertRrRsrcReqAtmScl", rrRsrcReq);
	}
	
	/**
	 * 자원요청 수정
	 * @param rrRsrcReq
	 */
	public void updateRsrcReq(RrRsrcReq rrRsrcReq) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReq.updateRsrcReq", rrRsrcReq);
	}

}
