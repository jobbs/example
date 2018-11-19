/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmUsefulRngServiceImpl.java
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
package ncis.dsb.stts.specusert.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.dsb.stts.specusert.dao.VmUsefulRngDao;
import ncis.dsb.stts.specusert.service.VmUsefulRngService;
import ncis.dsb.stts.specusert.vo.VmUsefulRngSearchVo;
import ncis.dsb.stts.specusert.vo.VmUsefulMemVo;
import ncis.dsb.stts.specusert.vo.VmUsefulSanVo;
import org.springframework.stereotype.Service;

@Service("vmUsefulRngService")
public class VmUsefulRngServiceImpl implements VmUsefulRngService {

	@Resource(name="vmUsefulRngDao")
	private VmUsefulRngDao vmUsefulRngDao;

	/**
	 * 가상서버 건수 -MEM(GB)
	 * */
	@Override
	public List<VmUsefulMemVo> selectMemCntList(VmUsefulRngSearchVo searchVo) throws Exception {
		return vmUsefulRngDao.selectMemCntList(searchVo);
	}

	/**
	 * 가상서버 건수 -SAN(GB)
	 * */
	@Override
	public List<VmUsefulSanVo> selectSanCntList(VmUsefulRngSearchVo searchVo) throws Exception {
		return vmUsefulRngDao.selectSanCntList(searchVo);
	}

	/**
	 * 가상서버 비율 -MEM(GB)
	 * */
	@Override
	public List<VmUsefulMemVo> selectMemCntRtList(VmUsefulRngSearchVo searchVo) throws Exception {
		return vmUsefulRngDao.selectMemCntRtList(searchVo);
	}

	/**
	 * 가상서버 비율 -SAN(GB)
	 * */
	@Override
	public List<VmUsefulSanVo> selectSanCntRtList(VmUsefulRngSearchVo searchVo) throws Exception {
		return vmUsefulRngDao.selectSanCntRtList(searchVo);
	}
}

