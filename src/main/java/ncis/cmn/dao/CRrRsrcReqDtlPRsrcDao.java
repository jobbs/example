package ncis.cmn.dao;

import ncis.cmn.entity.RrRsrcReq;
import ncis.cmn.entity.RrRsrcReqDtlPRsrc;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 자원요청상세_물리자원 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrRsrcReqDtlPRsrcDao")
public class CRrRsrcReqDtlPRsrcDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 자원요청상세_물리자원 등록
	 * @param rrRsrcReqDtlPRsrc
	 */
	public void insertRrRsrcReqDtlPRsrc(RrRsrcReqDtlPRsrc rrRsrcReqDtlPRsrc) {
		sqlSession.insert("ncis.sql.cmn.rrRsrcReqDtlPRsrc.insertRrRsrcReqDtlPRsrc", rrRsrcReqDtlPRsrc);
	}

	/**
	 * 자원요청상세_물리자원 수정
	 * @param rrRsrcReqDtlPRsrc
	 */
	public void updateRrRsrcReqDtlPRsrc(RrRsrcReqDtlPRsrc rrRsrcReqDtlPRsrc) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReqDtlPRsrc.updateRrRsrcReqDtlPRsrc", rrRsrcReqDtlPRsrc);
	}

	/**
	 * 자원요청상세_물리자원 자원요청진행상태코드 수정
	 * @param rrRsrcReqDtlPRsrc
	 */
	public void updateRsrcReqPrcssStatCd(RrRsrcReq rrRsrcReq) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReqDtlPRsrc.updateRsrcReqPrcssStatCd", rrRsrcReq);
	}

	/**
	 * 자원요청 상세_물리자원 상태 진행상태 및 실행 반려 시간 수정
	 * @param rrRsrcReqDtlPRsrc
	 */
	public void updateRsrcReqPhyRsrcPrcssStatCd(RrRsrcReqDtlPRsrc rrRsrcReqDtlPRsrc){
		sqlSession.update("ncis.sql.cmn.rrRsrcReqDtlPRsrc.updateRsrcReqPhyRsrcPrcssStatCd", rrRsrcReqDtlPRsrc);
	}

	/**
	 * 자원요청상세_물리자원 삭제
	 * @param rrRsrcReqDtlPRsrc
	 */
	public void deleteRrRsrcReqDtlPRsrc(RrRsrcReqDtlPRsrc rrRsrcReqDtlPRsrc) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReqDtlPRsrc.deleteRrRsrcReqDtlPRsrc", rrRsrcReqDtlPRsrc);
	}

	/**
	 * 자원요청상세_실행 초기화
	 * @param rrRsrcReqDtlPRsrc
	 */
	public void updateRrRsrcReqDtlPRsrcInitExeInfo(RrRsrcReqDtlPRsrc rrRsrcReqDtlPRsrc){
		sqlSession.update("ncis.sql.cmn.rrRsrcReqDtlPRsrc.updateRrRsrcReqDtlPRsrcInitExeInfo", rrRsrcReqDtlPRsrc);
	}

}
