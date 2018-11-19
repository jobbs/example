package ncis.cpt.opr.req.rsrcreq.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ncis.cpt.opr.ip.vo.IpBndSearchVo;
import ncis.cpt.opr.ip.vo.IpBndVo;
import ncis.cpt.opr.ip.vo.IpSearchVo;
import ncis.cpt.opr.ip.vo.IpVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqDtlVmVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqNetwkIntfcVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.cpt.rsrc.strg.vo.RsrcPoolVrStrgVo;
import ncis.cpt.rsrc.strg.vo.VrStrgSearchVo;
import ncis.cpt.rsrc.strg.vo.VrStrgVo;
import ncis.intfc.ntops.vo.NTopsSendVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("rsrcReqVmDao")
public class RsrcReqVmDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 가상서버 생성요청 기본정보 조회
	 * @param searchVo
	 * @return
	 */
	public RsrcReqDtlVmVo selectRsrcReqVmCre(RsrcReqMngSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.vm.selectRsrcReqVmCre",searchVo);
	}

	/**
	 * 가상서버 생성요청 네트워크인터페이스 정보 조회
	 * @param searchVo
	 * @return
	 */
	public List<RsrcReqNetwkIntfcVo> selectRsrcReqNetwkIntfcList(String rsrcReqNo, String addHB) {
		Map<String, Object> param = new HashMap<String, Object>();
        param.put("rsrcReqNo", rsrcReqNo);
        param.put("addHB", addHB);

		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.vm.selectRsrcReqNetwkIntfcList",param);
//		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.vm.selectRsrcReqNetwkIntfcList", rsrcReqNo);
	}



	public List<RsrcReqNetwkIntfcVo> selectCancelReqNetwkIntfcList(String rsrcReqNo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.vm.selectCancelReqNetwkIntfcList",rsrcReqNo);
	}

	/**
	 * 가상서버 설정을 위한 클러스터 목록 조회
	 * @param rsrcPoolId
	 * @return
	 */
	public List<RsrcReqDtlVmVo> selectClstrList(String rsrcPoolId) {
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.vm.selectClstrList",rsrcPoolId);
	}

	/**
	 * 템플릿 사용여부 조회
	 * @param rsrcReqDtlVmVo
	 * @return
	 */
	public String selectTmplatVmCreYN(RsrcReqDtlVmVo rsrcReqDtlVmVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.vm.selectTmplatVmCreYN",rsrcReqDtlVmVo);
	}

	/**
	 * 가상서버ID 중복여부 조회
	 * @param rsrcReqDtlVmVo
	 * @return
	 */
	public String selectVmIdUseYN(RsrcReqDtlVmVo rsrcReqDtlVmVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.vm.selectVmIdUseYN",rsrcReqDtlVmVo);
	}


	/**
	 * 자동 IP정보 조회
	 * @param rsrcReqDtlVmVo
	 * @return
	 */
	public IpVo selectAutoIp(RsrcReqDtlVmVo rsrcReqDtlVmVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.vm.selectAutoIp",rsrcReqDtlVmVo);
	}

	/**
	 * 자동 물리서버정보 조회
	 * @param rsrcReqDtlVmVo
	 * @return
	 */
	public Integer selectAutoPmSeq(RsrcReqDtlVmVo rsrcReqDtlVmVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.vm.selectAutoPmSeq",rsrcReqDtlVmVo);
	}


	/**
	 * 가상서버 스펙변경 정보 조회
	 * @param rsrcReqNo
	 * @return
	 */
	public RsrcReqDtlVmVo selectRsrcReqVmSpecChng(RsrcReqMngSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.vm.selectRsrcReqVmSpecChng",searchVo);
	}


	/**
	 * 가상서버 - IP대역 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<IpBndVo> selectIpBndList(IpBndSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.ipbnd.selectIpBndList",searchVo);
	}

	/**
	 * 가상서버 팝업 - IP목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<IpVo> selectIpList(IpSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.ipbnd.selectIpList",searchVo);
	}

	/**
	 * 가상서버 팝업 -  가상스토리지 - 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<VrStrgVo> selectVrStrgList(VrStrgSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.cpt.rsrc.strg.vrStrg.selectVrStrgList",searchVo);
	}

	/**
	 * IP 상태 조회
	 * @param rsrcReqNetwkIntfcVo
	 * @return
	 */
	public int selectIpStatCheck(RsrcReqNetwkIntfcVo rsrcReqNetwkIntfcVo){
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.vm.selectIpStatCheck",rsrcReqNetwkIntfcVo);
	}

	/**
	 * 가상서버 삭제정보 조회
	 * @param rsrcReqNo
	 * @return
	 */
	public RsrcReqDtlVmVo selectRsrcReqVmDel(RsrcReqMngSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.vm.selectRsrcReqVmDel", searchVo);
	}

	/**
	 * 가상스위치 ID 정보 조회
	 * @param searchVo
	 * @return
	 */
	public int selectVrSwtchNetwkId(RsrcReqNetwkIntfcVo rsrcReqNetwkIntfcVo){
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.vm.selectVrSwtchNetwkId",rsrcReqNetwkIntfcVo);
	}

	/**
	 * 스토리지도메인 목록조회
	 * @param searchVo
	 * @return
	 */
	public List<RsrcPoolVrStrgVo> selectStrgDmnList(String rsrcPoolId){
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.vm.selectStrgDmnList",rsrcPoolId);
	}

	/**
	 * 자원요청 가상서버 HA목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<RsrcReqDtlVmVo> selectHaCompList(String rsrcReqNo){
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.vm.selectHaCompList",rsrcReqNo);
	}

	/**
	 * 가상서버 HA목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<RsrcReqDtlVmVo> selectVmHaCompList(RsrcReqDtlVmVo rsrcReqDtlVmVo){
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.vm.selectVmHaCompList",rsrcReqDtlVmVo);
	}


	/**
	 * 가상서버 생성요청 설정 기본정보 조회
	 * @param searchVo
	 * @return
	 */
	public RsrcReqDtlVmVo selectRsrcReqVmCreBaseInfo(RsrcReqMngSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.vm.selectRsrcReqVmCreBaseInfo",searchVo);
	}

	/**
	 * @param reqStrgDmnSeq
	 * @return
	 */
	public String isEqualStrgDmnSeq(RsrcReqDtlVmVo rsrcReqDtlVmVo)
	{
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.vm.isEqualStrgDmnSeq",rsrcReqDtlVmVo);
	}

	/**
	 * 기 생성된 가상서버가 있는지 확인한다.
	 * @param rsrcReqDtlVmVo
	 * @return
	 */
	public VmVo selectPreMakedVmInfo(RsrcReqDtlVmVo rsrcReqDtlVmVo)
	{
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.vm.selectPreMakedVmInfo",rsrcReqDtlVmVo);
	}

}
