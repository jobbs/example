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

import ncis.dsb.stts.res.vo.AxNodeResSearchVo;
import ncis.dsb.stts.res.vo.AxNodeResStteVo;



public interface AxNodeResStteService {

	public List<AxNodeResStteVo> selectAxNodeResStteList(AxNodeResSearchVo searchVo)throws Exception;
	public List<Map<String,String>> selectAxNodeResStteNodeList(AxNodeResSearchVo searchVo)throws Exception;
	public List<Map<String,String>> selectAxNodeTimeResUseRtPivot(AxNodeResSearchVo searchVo)throws Exception;


}
