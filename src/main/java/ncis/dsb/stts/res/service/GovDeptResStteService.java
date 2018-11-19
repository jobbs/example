/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * GovDeptResStteService.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 17
 * @lastmodified2016. 10. 17
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 17   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.res.service;

import ncis.dsb.stts.res.vo.GovDeptResStteCvo;
import ncis.dsb.stts.res.vo.GovDeptResStteSearchVo;

public interface GovDeptResStteService {



	public GovDeptResStteCvo selectGovDeptResList(GovDeptResStteSearchVo searchVo)throws Exception;

}
