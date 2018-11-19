/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MacBndService.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.service;

import java.util.List;

import ncis.cpt.opr.ip.vo.MacBndSvo;
import ncis.cpt.opr.ip.vo.MacBndVo;

/**
 * @author 송승규
 *
 */
public interface MacBndService {

	/**
	 * MAC대역 목록조회
	 * @param svo
	 * @return
	 */
	public List<MacBndVo> selectMacBndList(MacBndSvo svo);

	/**
	 * MAC대역 상세조회
	 * @param svo
	 * @return
	 */
	public MacBndVo selectMacBnd(MacBndSvo svo);

	/**
	 * MAC대역 상세조회
	 * @param svo
	 * @return
	 */
	public List<MacBndVo> selectMacBndDetail(MacBndSvo svo);

	/**
	 * MAC대역 동기화
	 * @param svo
	 */
	public void updateMacBndIntfcAsgn(MacBndSvo svo);
}
