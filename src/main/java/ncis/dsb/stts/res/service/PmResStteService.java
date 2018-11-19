/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * PmResStteService.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   김동훈         v1.0             최초생성
 *
 */
package ncis.dsb.stts.res.service;

import java.util.List;
import java.util.Map;

import ncis.dsb.stts.res.vo.PmResSearchVo;
import ncis.dsb.stts.res.vo.PmResStteVo;
import ncis.dsb.stts.res.vo.PmTimeResUseRtVo;


public interface PmResStteService {

	public List<PmResStteVo> selectPmResStteList(PmResSearchVo searchVo)throws Exception;
	public List<PmTimeResUseRtVo> selectPmTimeResUseRtCpu(PmResSearchVo searchVo)throws Exception;
	public List<Map<String,String>> selectPmTimeResUseRtPivot(PmResSearchVo searchVo)throws Exception;
	public List<Map<String,String>> selectClstrTimeResUseRtPivot(PmResSearchVo searchVo)throws Exception;
	public List<PmTimeResUseRtVo> selectPmTimeResUseRtMem(PmResSearchVo searchVo)throws Exception;
	public List<PmTimeResUseRtVo> selectPmTimeResUseRtSan(PmResSearchVo searchVo)throws Exception;
	public List<Map<String,String>> selectPmResStteVmList(PmResSearchVo searchVo)throws Exception;
	public List<Map<String,String>> selectClstrResStteVmList(PmResSearchVo searchVo)throws Exception;


}
