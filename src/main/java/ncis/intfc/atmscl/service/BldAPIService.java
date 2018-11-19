/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NodeAPIService.java
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 06. 21.
 * @lastmodified 2017. 06. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 06. 21.     x         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.service;

import ncis.cmn.rest.vo.RestHeaders;
import ncis.cpt.rsrc.atmscl.vo.BldVo;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;


/**
 * @author x
 *
 */
public interface BldAPIService {

	/**
	 * @param headers
	 * @param bldVo
	 * @return
	 */
	AtmSclResultIfVo selectBldStat(RestHeaders headers, BldVo bldVo) throws Exception;

	/**
	 * @param headers
	 * @param lastBldVo
	 */
	AtmSclResultIfVo updateBldSync(RestHeaders headers, BldVo lastBldVo);

	/**
	 * @param headers
	 * @param lastBldVo
	 */
	AtmSclResultIfVo bldHstrySync(RestHeaders headers, BldVo lastBldVo) throws Exception;


}
