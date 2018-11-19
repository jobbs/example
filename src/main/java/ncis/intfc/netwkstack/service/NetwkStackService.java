/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetwkStackService.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 21.
 * @lastmodified 2016. 10. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 21.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.netwkstack.service;

import ncis.cmn.rest.vo.RestHeaders;
import ncis.intfc.netwkstack.vo.LbBodyVO;
import ncis.intfc.netwkstack.vo.LoadbalancerVO;
import ncis.intfc.netwkstack.vo.MemberBodyVo;
import ncis.intfc.netwkstack.vo.ResultMemberVO;

/**
 * @author ShinKeeBong
 *
 */
public interface NetwkStackService {

	/**
	 * L4 LB 추가
	 * @param nsSid
	 * @param nfSid
	 * @param header
	 * @param loadbalancerVO
	 * @return
	 */
	LbBodyVO insertL4LB(String nsSid, String nfSid, RestHeaders headers, LoadbalancerVO loadbalancerVO) throws Exception;


	/**
	 * L4 멤버 추가
	 * @param nsSid
	 * @param nfSid
	 * @param loadbalancerId
	 * @param header
	 * @param memberVO
	 * @return
	 */
	ResultMemberVO insertL4Member(String nsSid, String nfSid, String loadbalancerId, RestHeaders headers, MemberBodyVo bodyVo) throws Exception;
}
