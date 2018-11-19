/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobResStteService.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   양정순         v1.0             최초생성
 * 2017. 06. 10   양정순         v2.0             자동확장
 *
 */
package ncis.cmn.component.service;

import java.util.List;

import ncis.cmn.vo.LineChartVo;
import ncis.cmn.vo.MonitorSearchVo;
import ncis.cpt.rsrc.com.vo.PmVo;
import ncis.cpt.rsrc.com.vo.VmVo;


public interface MonitorService {

	public List<LineChartVo> selectMonitorVmList(MonitorSearchVo searchVo)throws Exception;
	/**
	 * @param searchVo
	 * @return
	 */
	public VmVo selectVmInfo(MonitorSearchVo searchVo);

	/**
	 * @param searchVo
	 * @return
	 */
	public List<LineChartVo> selectMonitorPmList(MonitorSearchVo searchVo) throws Exception ;

	/**
	 * @param searchVo
	 * @return
	 */
	public PmVo selectPmInfo(MonitorSearchVo searchVo);
}
