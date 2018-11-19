/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcReqNetwk.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 10.
 * @lastmodified 2016. 10. 10.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.service;

import java.util.List;

import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqNetwkSlbConfIpReqVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqNetwkVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqVo;

/**
 * 자원요청상세_네트워크 관리
 * @author 김봉민
 *
 */
public interface RsrcReqNetwkService {

	/**
	 *자원요청 기본정보 조회
	 * @param rsrcReqNo
	 * @return
	 */
	RsrcReqVo selectRsrcReqInfo(String rsrcReqNo);

	/**
	 * 자원요청상세 - 네트워크 정보 조회
	 * @param searchVo
	 * @return
	 */
	RsrcReqNetwkVo selectRsrcReqNetwk(RsrcReqMngSearchVo searchVo);

	/**
	 * 자원정보상세- 네트워크 정보 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<RsrcReqNetwkVo> selectRsrcReqNetwkList(RsrcReqMngSearchVo searchVo);

	/**
	 * 자원정보상세- SLB설정 IP목록 조회
	 * @param searchVo
	 * @return
	 */
	List<RsrcReqNetwkSlbConfIpReqVo> selectRsrcReqNetwkSlbConfIpReqList(RsrcReqMngSearchVo searchVo);

	/**
	 * 자원요청상세_네트워크 실행
	 * @param rsrcReqNetwkVo
	 * @param exeUserId
	 * @return
	 * @throws Exception
	 */
	String updateRsrcReqNetwkSlbExe(RsrcReqNetwkVo rsrcReqNetwkVo, String exeUserId) throws Exception;
	//

	/**
	 * 자원요청상세_네트워크 반려
	 * @param rsrcReqNetwkVo
	 * @param exeUserId
	 * @return
	 * @throws Exception
	 */
	String updateRsrcReqNetwkRjct(RsrcReqNetwkVo rsrcReqNetwkVo, String exeUserId) throws Exception;
}
