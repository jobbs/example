/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetSwtchService.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.service;

import java.util.List;

import ncis.cpt.rsrc.net.vo.NetSwtchSvo;
import ncis.cpt.rsrc.net.vo.NetSwtchVo;

/**
 * @author 송승규
 *
 */
public interface NetSwtchService {

	/**
	 * 부처별 L3/L4 목록 조회
	 * @param svo
	 * @return
	 */
	public List<NetSwtchVo> selectNetSwtchList(NetSwtchSvo svo);

	/**
	 * 부처별 L3/L4 수정
	 * @param svo
	 */
	public void updateNetSwtch(NetSwtchVo vo, NetSwtchSvo svo);
}
