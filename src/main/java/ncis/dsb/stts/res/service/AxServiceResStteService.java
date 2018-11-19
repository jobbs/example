/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxNodeResStteService.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 05. 10
 * @lastmodified2017. 05. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 05. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.res.service;

import java.util.List;
import java.util.Map;

import ncis.dsb.stts.res.vo.AxServiceResSearchVo;
import ncis.dsb.stts.res.vo.AxServiceResStteVo;



public interface AxServiceResStteService {

	public List<AxServiceResStteVo> selectAxServiceResStteList(AxServiceResSearchVo searchVo)throws Exception;
	public List<Map<String,String>> selectAxServiceResSttePodList(AxServiceResSearchVo searchVo)throws Exception;
	public List<Map<String,String>> selectAxServiceTimeResUseRtPivot(AxServiceResSearchVo searchVo)throws Exception;


}
