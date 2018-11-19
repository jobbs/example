/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcReqProcssService.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.service;

import java.math.BigDecimal;
import java.util.List;

import ncis.cmn.security.vo.UserVo;
import ncis.cpt.opr.req.rsrcreq.vo.ProcssInstVo;
import ncis.cpt.opr.req.rsrcreq.vo.UnitJobProcssVo;


/**
 * @author 김봉민
 *
 */
public interface RsrcReqProcssService {

	/**
	 * 프로세스 인스턴스 조회
	 * @param procssInstSeq
	 * @return
	 */
	ProcssInstVo selectProcssInst(BigDecimal procssInstSeq );

	/**
	 * 단위 작업 목록을 조회
	 * @param UnitJobProcssListVo
	 * @return
	 * @throws Exception
	 */
	List<UnitJobProcssVo> selectUnitJobProcssList(BigDecimal unitJobProcssListVo) throws Exception;

	/**
	 * 단위업무 상태를 변경
	 * @param unitJobProcssVo
	 * @throws Exception
	 */
	void updateUnitProcssJobStat(UnitJobProcssVo unitJobProcssVo) throws Exception;

	/**
	 * 프로세스 취소
	 * @param unitJobProcssVo
	 * @throws Exception
	 */
	void updateRsrcReqProcssCancel(UnitJobProcssVo unitJobProcssVo, String userId) throws Exception;

	/**
	 * 프로세스 강제완료
	 * @param unitJobProcssVo
	 * @throws Exception
	 */
	void updateRsrcReqProcssManualComplete(UnitJobProcssVo unitJobProcssVo, String reasn, UserVo userVo) throws Exception;

	/**
	 * @param unitJobProcssVo
	 * @param rmk
	 * @param user
	 */
	void updateRsrcReqAllManualComplete(UnitJobProcssVo unitJobProcssVo, String rmk, UserVo user)  throws Exception;
}
