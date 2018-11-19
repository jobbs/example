package ncis.cmn.dao;

import java.math.BigDecimal;
import java.util.List;

import ncis.cmn.entity.RrRsrcReq;
import ncis.cmn.entity.RrRsrcReqDtlVm;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqDtlVmVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqNetwkIntfcVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 자원요청상세_가상서버 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrRsrcReqDtlVmDao")
public class CRrRsrcReqDtlVmDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 자원요청상세_가상서버 등록
	 * @param rrRsrcReqDtlVm
	 */
	public BigDecimal insertRrRsrcReqDtlVm(RrRsrcReqDtlVm rrRsrcReqDtlVm) {

		sqlSession.insert("ncis.sql.cmn.rrRsrcReqDtlVm.insertRrRsrcReqDtlVm", rrRsrcReqDtlVm);

		return rrRsrcReqDtlVm.getRsrcReqSeq();
	}

	/**
	 * 자원요청상세_가상서버 수정
	 * @param rrRsrcReqDtlVm
	 */
	public void updateRrRsrcReqDtlVm(RrRsrcReqDtlVm rrRsrcReqDtlVm) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReqDtlVm.updateRrRsrcReqDtlVm", rrRsrcReqDtlVm);
	}

	/**
	 * 자원요청상세_가상서버생성 수정
	 * @param rrRsrcReqDtlVm
	 */
	public void updateRrRsrcReqDtlVmCre(RrRsrcReqDtlVm rrRsrcReqDtlVm) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReqDtlVm.updateRrRsrcReqDtlVmCre", rrRsrcReqDtlVm);
	}

	/**
	 * 자원요청상세_가상서버스펙변경 수정
	 * @param rrRsrcReqDtlVm
	 */
	public void updateRrRsrcReqDtlVmSpecChng(RrRsrcReqDtlVm rrRsrcReqDtlVm) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReqDtlVm.updateRrRsrcReqDtlVmSpecChng", rrRsrcReqDtlVm);
	}

	/**
	 * 자원요청상세_가상서버 자원요청진행상태코드 수정
	 * @param rrRsrcReqDtlPRsrc
	 */
	public void updateRsrcReqPrcssStatCd(RrRsrcReq rrRsrcReq) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReqDtlVm.updateRsrcReqPrcssStatCd", rrRsrcReq);
	}

	/**
	 * 자원요청상세_가상서버 삭제
	 * @param rrRsrcReqDtlVm
	 */
	public void deleteRrRsrcReqDtlVm(RrRsrcReqDtlVm rrRsrcReqDtlVm) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReqDtlVm.deleteRrRsrcReqDtlVm", rrRsrcReqDtlVm);
	}

	/**
	 * 자원요청상세_가상서버 실행정보 초기화
	 * @param rrRsrcReqDtlPRsrc
	 */
	public void updateRrRsrcReqDtlVmInitExeInfo(RrRsrcReqDtlVm rrRsrcReqDtlVm) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReqDtlVm.updateRrRsrcReqDtlVmInitExeInfo", rrRsrcReqDtlVm);
	}

	/**
	 * 자원요청상세_가상서버 HA설정정보 초기화
	 * @param rrRsrcReqDtlPRsrc
	 */
	public void updateRrRsrcReqDtlVmHaInit(RrRsrcReqDtlVm rrRsrcReqDtlVm) {
		sqlSession.update("ncis.sql.cmn.rrRsrcReqDtlVm.updateRrRsrcReqDtlVmHaInit", rrRsrcReqDtlVm);
	}

	/**
	 * @param rsrcReqDtlVmVo
	 * @return
	 */
	public List<RsrcReqNetwkIntfcVo> selectRsrcReqNetwkIntfcVoList(RsrcReqDtlVmVo rsrcReqDtlVmVo)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
