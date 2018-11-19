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

import java.util.List;

import ncis.cmn.entity.RxDistrbConf;
import ncis.cmn.entity.RxMnulScl;
import ncis.cmn.entity.RxPvc;
import ncis.cmn.entity.RxRsrvSclng;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cpt.rsrc.atmscl.vo.AtmsclDistrbVo;
import ncis.cpt.rsrc.atmscl.vo.DistrbEnvConfVo;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;

/**
 * @author x
 *
 */
public interface AtmsclDistrbAPIService {

	/**
	 * @param headers
	 * @param rxPvc
	 */
	AtmSclResultIfVo pvcCre(RestHeaders headers, RxPvc rxPvc) throws Exception;

	/**
	 * @param headers
	 * @param rxPvc
	 */
	AtmSclResultIfVo pvcInfo(RestHeaders headers, RxPvc rxPvc) throws Exception;

	/**
	 * @param headers
	 * @param rxPvc
	 */
	AtmSclResultIfVo deployConf(RestHeaders headers, RxPvc rxPvc) throws Exception;

	/**
	 * @param headers
	 * @param atmsclDistrbVo
	 */
	AtmSclResultIfVo selectPodCnt(RestHeaders headers, AtmsclDistrbVo atmsclDistrbVo);

	/**
	 * @param headers
	 * @param rxMnulScl
	 */
	AtmSclResultIfVo putReplicasAdd(RestHeaders headers, RxMnulScl rxMnulScl);

	/**
	 * @param headers
	 * @param disConf
	 */
	AtmSclResultIfVo updateRsrcLtApi(RestHeaders headers, RxDistrbConf disConf)  throws Exception;

	/**
	 * @param headers
	 * @param atmsclDistrbVo
	 * @param selectDistrbEnvConfExcept
	 */
	AtmSclResultIfVo updateDistrbConfApi(RestHeaders headers,AtmsclDistrbVo atmsclDistrbVo, List<DistrbEnvConfVo> selectDistrbEnvConfExcept) throws Exception;

	/**
	 * @param headers
	 * @param atmsclDistrbVo
	 */
	AtmSclResultIfVo selectDistrbStat(RestHeaders headers, AtmsclDistrbVo atmsclDistrbVo) throws Exception;

	/**
	 * @param headers
	 * @param rxRsrvSclng
	 */
	AtmSclResultIfVo updateDistrbAutoConf(RestHeaders headers, RxRsrvSclng rxRsrvSclng) throws Exception;

	/**
	 * @param headers
	 * @param rxRsrvSclng
	 */
	AtmSclResultIfVo insertDistrbAutoConf(RestHeaders headers, RxRsrvSclng rxRsrvSclng) throws Exception;

	/**
	 * @param headers
	 * @param rxRsrvSclng
	 */
	AtmSclResultIfVo deleteDistrbAutoSclConf(RestHeaders headers, RxRsrvSclng rxRsrvSclng) throws Exception;

	/**
	 * @param headers
	 * @param disConf
	 * @return
	 */
	AtmSclResultIfVo updateInitRsrcLtApi(RestHeaders headers,RxDistrbConf disConf) throws Exception;

	/**
	 * @param headers
	 * @param rxPvc
	 * @return
	 */
	AtmSclResultIfVo deletePvc(RestHeaders headers, RxPvc rxPvc)throws Exception;

	/**
	 * @param headers
	 * @param atmsclDistrbVo
	 * @return
	 */
	AtmSclResultIfVo updateDistrbSync(RestHeaders headers,AtmsclDistrbVo atmsclDistrbVo) throws Exception;

	/**
	 * @param headers
	 * @param atmsclDistVo
	 */
	AtmSclResultIfVo distrbHstrySync(RestHeaders headers, AtmsclDistrbVo atmsclDistVo) throws Exception;

}
