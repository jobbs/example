/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetwkStackServiceImpl.java
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
package ncis.intfc.netwkstack.service.impl;

import javax.annotation.Resource;

import ncis.cmn.rest.RestSender;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.intfc.netwkstack.service.NetwkStackService;
import ncis.intfc.netwkstack.vo.LbBodyVO;
import ncis.intfc.netwkstack.vo.LoadbalancerVO;
import ncis.intfc.netwkstack.vo.MemberBodyVo;
import ncis.intfc.netwkstack.vo.ResultMemberVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * @author ShinKeeBong
 *
 */
@Service("netwkStackService")
public class NetwkStackServiceImpl implements NetwkStackService {

	@Resource(name="restSender") private RestSender restSender;

	private static final Logger logger = LoggerFactory.getLogger(NetwkStackServiceImpl.class);

	/**
	 * L4 LB 추가
	 * @param nsSid
	 * @param nfSid
	 * @param header
	 * @param loadbalancerVO
	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * --------------------------------------------------------------------------------------------
	 *
	 *          nsSid              아테네가 관리하는 네트워크 서비스의 고유ID               Y
	 *          nfSid              아테네가 관리하는 VNF의 ID                               Y
	 *
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 *
	 * @return
	 */
	@Override
	public LbBodyVO insertL4LB(String nsSid, String nfSid,
			RestHeaders headers, LoadbalancerVO loadbalancerVO)	throws Exception {

		String url = "/networks/l4/ns/" + nsSid + "/nf/" + nfSid + "/loadbalancer";

		LbBodyVO lbBodyVO = new LbBodyVO();
		lbBodyVO.setLoadbalancer(loadbalancerVO);

		return restSender.send(url, lbBodyVO, headers, LbBodyVO.class, HttpMethod.POST).getBody();
	}

	/**
	 * L4 멤버 추가
	 * @param nsSid
	 * @param nfSid
	 * @param loadbalancerId
	 * @param header
	 * @param memberVO
	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * --------------------------------------------------------------------------------------------
	 *
	 *          nsSid              아테네가 관리하는 네트워크 서비스의 고유ID               Y
	 *          nfSid              아테네가 관리하는 VNF의 ID                               Y
	 *          loadbalancerId     아테네가 관리하는 로드발란서의 ID                        Y
	 *
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 * @return
	 */
	@Override
	public ResultMemberVO insertL4Member(String nsSid, String nfSid,
			String loadbalancerId, RestHeaders headers, MemberBodyVo bodyVo) throws Exception {

		String url = "/networks/l4/ns/" + nsSid + "/nf/" + nfSid + "/loadbalancer/" + loadbalancerId + "/member";

		logger.debug("[SEND URL] = " +url);
		return restSender.send(url, bodyVo, headers, ResultMemberVO.class, HttpMethod.POST).getBody();

	}

}
