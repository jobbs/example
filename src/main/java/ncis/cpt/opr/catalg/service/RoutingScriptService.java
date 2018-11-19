/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PrcssService.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 9. 30.
 * @lastmodified 2016. 9. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 30.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.service;

import java.util.List;

import ncis.cmn.entity.RnSRoutingScript;
import ncis.cpt.opr.catalg.vo.RoutingScriptSearchVo;
import ncis.cpt.opr.catalg.vo.RoutingScriptVo;

/**
 * @author 이화영
 *
 */
public interface RoutingScriptService {

	/**
	 * 검색 조건에 해당하는 스태틱라우팅 스크립트 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	List<RoutingScriptVo> selectScriptList(RoutingScriptSearchVo searchVo);

	/**
	 * 스태틱라우팅 스크립트 상세 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	RoutingScriptVo selectScript(Long routingScriptSeq);

	/**
	 * 스태틱라우팅 스크립트 등록
	 * @param rnSRoutingScript
	 */
	void insertScript(RnSRoutingScript rnSRoutingScript);

	/**
	 * 스태틱라우팅 스크립트 수정
	 * @param rnSRoutingScript
	 */
	void updateScript(RnSRoutingScript rnSRoutingScript);

	/**
	 * 스태틱라우팅 스크립트 삭제
	 * @param rnSRoutingScript
	 */
	void deleteScript(Long sRoutingScriptSeq);

	/**
	 * 동일한 OS유형에 OS버전에 존재하는지 여부 판단.
	 * @param osTyCd
	 * @param osVer
	 * @param getsRoutingScriptSeq
	 * @return
	 */
	boolean selectExistRoutingScript(String osTyCd, String osVer, Long RoutingScriptSeq);

}