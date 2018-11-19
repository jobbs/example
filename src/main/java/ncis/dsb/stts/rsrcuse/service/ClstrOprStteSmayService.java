/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ClstrOprStteSmayService.java
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


import ncis.dsb.stts.rsrcuse.vo.ClstrOprStteSmaySearchVo;
import ncis.dsb.stts.rsrcuse.vo.ClstrOprStteSmayVo;

public interface ClstrOprStteSmayService {



	public List<ClstrOprStteSmayVo> selectClstrOprStteSmayList(ClstrOprStteSmaySearchVo searchVo)throws Exception;

	public List<ClstrOprStteSmayVo> selectClstrOprStteSmayRsAutoList(ClstrOprStteSmaySearchVo searchVo);



}
