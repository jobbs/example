/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename OprstatService.java
 *
 * @author selim
 * @lastmodifier selim
 * @created 2017. 12. 7.
 * @lastmodified 2017. 12. 7.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 12. 7.     selim         v1.0             최초생성
 *
 */
package ncis.dsb.stts.etc.service;

import java.util.List;

import ncis.dsb.stts.etc.vo.OprStatSearchVo;
import ncis.dsb.stts.etc.vo.PmStatInfoVo;
import ncis.dsb.stts.etc.vo.PoolStatInfoVo;
import ncis.dsb.stts.etc.vo.VmStatInfoVo;

/**
 * @author selim
 *
 */
public interface OprStatService
{
	public List<PmStatInfoVo> selectOprStatPmMinList(OprStatSearchVo searchVo) throws Exception ;
	public List<PoolStatInfoVo> selectOprStatPoolList(OprStatSearchVo searchVo) throws Exception ;
	public List<VmStatInfoVo> selectOprStatVmList(OprStatSearchVo searchVo) throws Exception ;
	public List<PmStatInfoVo> selectOprStatPmList(OprStatSearchVo searchVo) throws Exception ;
}
