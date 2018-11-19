/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxServcUsefulRngServiceImpl.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 08. 10
 * @lastmodified2017. 08. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 08. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.axusert.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.dsb.stts.axusert.dao.AxServcUsefulRngDao;
import ncis.dsb.stts.axusert.service.AxServcUsefulRngService;
import ncis.dsb.stts.axusert.vo.AxServcUsefulRngSearchVo;
import ncis.dsb.stts.axusert.vo.AxServcUsefulMemVo;
import ncis.dsb.stts.axusert.vo.AxServcUsefulSanVo;
import org.springframework.stereotype.Service;

@Service("axServcUsefulRngService")
public class AxServcUsefulRngServiceImpl implements AxServcUsefulRngService {

	@Resource(name="axServcUsefulRngDao")
	private AxServcUsefulRngDao axServcUsefulRngDao;

	/**
	 * 자동확장 건수 -MEM(GB)
	 * */
	@Override
	public List<AxServcUsefulMemVo> selectMemCntList(AxServcUsefulRngSearchVo searchVo) throws Exception {
		return axServcUsefulRngDao.selectMemCntList(searchVo);
	}

	/**
	 * 자동확장 건수 -SAN(GB)
	 * */
	@Override
	public List<AxServcUsefulSanVo> selectSanCntList(AxServcUsefulRngSearchVo searchVo) throws Exception {
		return axServcUsefulRngDao.selectSanCntList(searchVo);
	}

	/**
	 * 자동확장 비율 -MEM(GB)
	 * */
	@Override
	public List<AxServcUsefulMemVo> selectMemCntRtList(AxServcUsefulRngSearchVo searchVo) throws Exception {
		return axServcUsefulRngDao.selectMemCntRtList(searchVo);
	}

	/**
	 * 자동확장 비율 -SAN(GB)
	 * */
	@Override
	public List<AxServcUsefulSanVo> selectSanCntRtList(AxServcUsefulRngSearchVo searchVo) throws Exception {
		return axServcUsefulRngDao.selectSanCntRtList(searchVo);
	}
}

