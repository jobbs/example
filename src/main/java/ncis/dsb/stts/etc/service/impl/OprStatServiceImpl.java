/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename OprStatServiceImpl.java
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
package ncis.dsb.stts.etc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.dsb.stts.etc.dao.OprStatDao;
import ncis.dsb.stts.etc.service.OprStatService;
import ncis.dsb.stts.etc.vo.OprStatSearchVo;
import ncis.dsb.stts.etc.vo.PmStatInfoVo;
import ncis.dsb.stts.etc.vo.PoolStatInfoVo;
import ncis.dsb.stts.etc.vo.VmStatInfoVo;

import org.springframework.stereotype.Service;


/**
 * @author selim
 *
 */
@Service("oprStatService")
public class OprStatServiceImpl implements OprStatService
{

	@Resource(name="oprStatDao")
	private OprStatDao oprStatDao;

	/* (non-Javadoc)
	 * @see ncis.dsb.stts.etc.service.OprstatService#selectOprStatPmMinList(ncis.dsb.stts.etc.vo.OprStatSearchVo)
	 */
	@Override
	public List<PmStatInfoVo> selectOprStatPmMinList(OprStatSearchVo searchVo) throws Exception
	{
		return oprStatDao.selectOprStatPmMinList(searchVo);
	}

	/* (non-Javadoc)
	 * @see ncis.dsb.stts.etc.service.OprstatService#selectOprStatPoolList(ncis.dsb.stts.etc.vo.OprStatSearchVo)
	 */
	@Override
	public List<PoolStatInfoVo> selectOprStatPoolList(OprStatSearchVo searchVo) throws Exception
	{
		return oprStatDao.selectOprStatPoolList(searchVo);
	}

	/* (non-Javadoc)
	 * @see ncis.dsb.stts.etc.service.OprstatService#selectOprStatVmList(ncis.dsb.stts.etc.vo.OprStatSearchVo)
	 */
	@Override
	public List<VmStatInfoVo> selectOprStatVmList(OprStatSearchVo searchVo) throws Exception
	{
		return oprStatDao.selectOprStatVmList(searchVo);
	}

	/* (non-Javadoc)
	 * @see ncis.dsb.stts.etc.service.OprstatService#selectOprStatPmList(ncis.dsb.stts.etc.vo.OprStatSearchVo)
	 */
	@Override
	public List<PmStatInfoVo> selectOprStatPmList(OprStatSearchVo searchVo) throws Exception
	{
		return oprStatDao.selectOprStatPmList(searchVo);
	}

}
