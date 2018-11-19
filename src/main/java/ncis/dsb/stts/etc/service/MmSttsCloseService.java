/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * MmSttsCloseService.java
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
 * 2017. 05. 21   양정순         v2.0             자동확장 추가
 *
 */
package ncis.dsb.stts.etc.service;

import java.util.List;

import ncis.dsb.stts.etc.vo.MmSttsCloseSearchVo;
import ncis.dsb.stts.etc.vo.MmSttsCloseVo;
import ncis.dsb.stts.etc.vo.AxMmSttsCloseVo;

public interface MmSttsCloseService {

	public List<MmSttsCloseVo> selectMmSttsCloseList(MmSttsCloseSearchVo searchVo) throws Exception;

	public List<MmSttsCloseVo> selectVmCloseList(MmSttsCloseSearchVo searchVo) throws Exception;

	public List<AxMmSttsCloseVo> selectAxMmSttsCloseList(MmSttsCloseSearchVo searchVo) throws Exception;

	public List<AxMmSttsCloseVo> selectAxCloseList(MmSttsCloseSearchVo searchVo) throws Exception;


}
