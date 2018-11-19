/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MngmObjVmService.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.service;

import java.math.BigDecimal;
import java.util.List;

import ncis.cpt.opr.patch.vo.MngmObjVmSearchVo;
import ncis.cpt.opr.patch.vo.MngmObjVmVo;

/**
 * @author 최경철
 *
 */
public interface MngmObjVmService {

	/**
	 * 관리대상 가상서버 목록 조회
	 * @param mngmObjVmSearchVo
	 * @return
	 */
	List<MngmObjVmVo> selectMngmObjVmList(MngmObjVmSearchVo mngmObjVmSearchVo, boolean isPagination);

	/**
	 * 관리대상 가상서버 상세조회
	 * @param mngmObjVmSearchVo
	 * @return
	 */
	MngmObjVmVo selectMngmObjVm(MngmObjVmSearchVo mngmObjVmSearchVo);

	/**
	 * 관리대상 가상서버 요청정보 조회
	 * @param vmSeq
	 * @return
	 */
	MngmObjVmVo selectMngmObjVmReq(BigDecimal vmSeq);

	/**
	 * 가상서버 패키지관리대상 등록 및 삭제
	 * @param mngmObjVmSearchVo
	 * @throws Exception
	 */
	void updateMngmObjVm(MngmObjVmSearchVo mngmObjVmSearchVo) throws Exception;

	/**
	 * 가상서버 패키지 동기화
	 * @param mngmObjVmSearchVo
	 * @throws Exception
	 */
	void updateMngmObjVmSync(MngmObjVmSearchVo mngmObjVmSearchVo) throws Exception;

}
