/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * InsttRsrcUseStteService.java
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
 *
 */

package ncis.dsb.stts.rsrcuse.service;

import java.util.List;




import ncis.dsb.stts.rsrcuse.vo.InsttRsrcRxAsgnVo;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcRxMaxVo;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcUseStteSearchVo;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcUseStteAsgnVo;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcUseStteMaxVo;

public interface InsttRsrcUseStteService {



	public List<InsttRsrcUseStteAsgnVo> selectInsttRsrcUseStteAsgnList(InsttRsrcUseStteSearchVo searchVo)throws Exception;

	public List<InsttRsrcUseStteMaxVo> selectInsttRsrcUseStteMaxList(InsttRsrcUseStteSearchVo searchVo)throws Exception;

	public List<InsttRsrcRxAsgnVo> selectRxAsgnList(InsttRsrcUseStteSearchVo searchVo)throws Exception;

	public List<InsttRsrcRxMaxVo> selectRxMaxList(InsttRsrcUseStteSearchVo searchVo)throws Exception;



}
