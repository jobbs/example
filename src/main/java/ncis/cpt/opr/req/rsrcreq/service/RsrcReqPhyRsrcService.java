package ncis.cpt.opr.req.rsrcreq.service;

import java.util.List;

import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqPhyRsrcVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqVo;

/**
 * 물리자원관리(추가,삭제)
 * @author 김봉민
 *
 */
public interface RsrcReqPhyRsrcService {

	/**
	 *
	 * @param searchVo
	 * @return
	 */
	RsrcReqVo selectRsrcReqInfo(RsrcReqMngSearchVo searchVo);

	/**
	 * 물리서버추가 정보 조회
	 * @param searchVo
	 * @return
	 */
	RsrcReqPhyRsrcVo selectRsrcReqPhySrvrAdd(String rsrcReqNo);

	/**
	 * 물리서버삭제 정보 조회
	 * @param searchVo
	 * @return
	 */
	RsrcReqPhyRsrcVo selectRsrcReqPhySrvrDel(String rsrcReqNo);

	/**
	 * 클러스터추가 정보 조회
	 * @param searchVo
	 * @return
	 */
	RsrcReqPhyRsrcVo selectRsrcReqClstrAdd(String rsrcReqNo);

	/**
	 * 클러스터삭제 정보 조회
	 * @param searchVo
	 * @return
	 */
	RsrcReqPhyRsrcVo selectRsrcReqClstrDel(String rsrcReqNo);

	/**
	 * 자원요청 물리서버 상태 업데이트 (실행)
	 * @param RsrcReqPhyRsrcVo
	 * @param searchVo
	 */
	String updateRsrcReqPhyRsrcExe(RsrcReqPhyRsrcVo vo, String exeUserId) throws Exception;

	/**
	 * 자원요청 물리서버 상태 업데이트 (반려)
	 * @param searchVo
	 * @param exeUserId
	 * @return
	 */
	String updateRsrcReqPhyRsrcRjct(RsrcReqPhyRsrcVo vo, String exeUserId) throws Exception;

	/**
	 * 데이터센터 목록 조회
	 * @param
	 * @return
	 */
	List<RsrcReqPhyRsrcVo> selectDataCntrList();

}
