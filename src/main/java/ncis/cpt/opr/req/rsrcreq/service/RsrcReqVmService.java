package ncis.cpt.opr.req.rsrcreq.service;

import java.util.List;

import ncis.cpt.opr.ip.vo.IpBndSearchVo;
import ncis.cpt.opr.ip.vo.IpBndVo;
import ncis.cpt.opr.ip.vo.IpSearchVo;
import ncis.cpt.opr.ip.vo.IpVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqDtlVmVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqNetwkIntfcVo;
import ncis.cpt.rsrc.strg.vo.RsrcPoolVrStrgVo;
import ncis.cpt.rsrc.strg.vo.VrStrgSearchVo;
import ncis.cpt.rsrc.strg.vo.VrStrgVo;

public interface RsrcReqVmService {

	/**
	 * 자원요청 가상서버생성 조회
	 * @param rsrcReqNo
	 * @return
	 */
	RsrcReqDtlVmVo selectRsrcReqVmCre(String rsrcReqNo) throws Exception;


	/**
	 * 자원요청 네트워크인터페이스 조회
	 * @param rsrcReqNo
	 * @return
	 */
	List<RsrcReqNetwkIntfcVo> selectRsrcReqNetwkIntfcList(String rsrcReqNo, String addHB) throws Exception;


	/**
	 * 가상서버 설정을 위한 클러스터 목록 조회
	 * @param mngId
	 * @return
	 */
	List<RsrcReqDtlVmVo> selectClstrList(String mngId) throws Exception;



	/**
	 * 가상서버생성 실행정보 업데이트
	 * @param rsrcReqDtlVmVo
	 */
	void updateRsrcReqVmCreInfo(RsrcReqDtlVmVo rsrcReqDtlVmVo) throws Exception;


	/**
	 * 자원요청 가상서버스펙변경 조회
	 * @param rsrcReqNo
	 * @return
	 */
	RsrcReqDtlVmVo selectRsrcReqVmSpecChng(String rsrcReqNo) throws Exception;

	/**
	 * 자원요청 가상서버 삭제 정보 조회
	 * @param rsrcReqNo
	 * @return
	 * @throws Exception
	 */
	RsrcReqDtlVmVo selectRsrcReqVmDel(String rsrcReqNo) throws Exception;


	/**
	 * 가상서버스펙변경 실행정보 업데이트
	 * @param rsrcReqDtlVmVo
	 */
	void updateRsrcReqSpecChngInfo(RsrcReqDtlVmVo rsrcReqDtlVmVo) throws Exception;

	/**
	 * ip 대역 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<IpBndVo> selectIpBndList(IpBndSearchVo searchVo);

	/**
	 * ip 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<IpVo> selectUnasgnIpList(IpSearchVo searchVo);

	/**
	 * 가상 스토리지 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<VrStrgVo> selectVrStrgList(VrStrgSearchVo searchVo);

	/**
	 * 가상서버- 반려 처리
	 * @param vo
	 * @throws Exception
	 */
	void updateRsrcReqVmRjct(RsrcReqDtlVmVo reqDtlVmVo, String exeUserId) throws Exception;

	/**
	 * 가상서버 실행취소
	 * @param regionId
	 * @param zoneId
	 * @param netClCd
	 * @param poolId
	 * @param uuid
	 * @throws Exception
	 */
	void updateRsrcReqCancelExecInfo(String regionId, String zoneId, String netClCd, String poolId, String uuid) throws Exception;

	/**
	 * 스토리지도메인 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<RsrcPoolVrStrgVo> selectStrgDmnList(String rsrcPoolId);

	/**
	 * 자원요청 가상서버 HA목록 조회
	 * @param rsrcReqNo
	 * @return
	 */
	List<RsrcReqDtlVmVo> selectHaCompList(String rsrcReqNo) throws Exception;

	/**
	 * 가상서버 HA목록 조회
	 * @param rsrcReqNo
	 * @return
	 */
	List<RsrcReqDtlVmVo> selectVmHaCompList(RsrcReqDtlVmVo rsrcReqDtlVmVo) throws Exception;

	/**
	 * HA 가상서버생성 실행정보 업데이트
	 * @param rsrcReqDtlVmVo
	 */
	void updateRsrcReqHaVmCreInfo(RsrcReqDtlVmVo rsrcReqDtlVmVo) throws Exception;

	/**
	 * HA 가상서버 수동 실행
	 * @param rsrcReqDtlVmVo
	 * @throws Exception
	 */
	void updateRsrcReqHaVmCreInfoForManaul(RsrcReqDtlVmVo rsrcReqDtlVmVo) throws Exception;

	/**
	 * 자원요청 가상서버생성 기본설정정보 조회
	 * @param rsrcReqNo
	 * @return
	 */
	RsrcReqDtlVmVo selectRsrcReqVmCreBaseInfo(String rsrcReqNo) throws Exception;


	/**
	 * 가상서버- 설정취소 실행
	 * @param vo
	 * @throws Exception
	 */
	void updateRsrcReqHaVmInfoInit(RsrcReqDtlVmVo reqDtlVmVo) throws Exception;


	/**
	 * 가상서버 생성 - 수동 완료
	 *
	 * @param rsrcReqDtlVmVo
	 */
	void updateRsrcReqVmCreInfoForManaul(RsrcReqDtlVmVo rsrcReqDtlVmVo) throws Exception;


	/**
	 * 가상서버 변경 - 수동 완료
	 * @param rsrcReqDtlVmVo
	 * @throws Exception
	 */
	void updateRsrcReqSpecChngInfoForManaul(RsrcReqDtlVmVo rsrcReqDtlVmVo) throws Exception;


}
