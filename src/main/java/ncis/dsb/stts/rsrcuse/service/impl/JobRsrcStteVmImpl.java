/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobRsrcStteVmImpl.java
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
package ncis.dsb.stts.rsrcuse.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.entity.RnSlb;
import ncis.cmn.entity.RnSlbIp;
import ncis.cpt.opr.ip.vo.IpBndVo;
import ncis.cpt.rsrc.atmscl.vo.ServcPodVo;
import ncis.cpt.rsrc.atmscl.vo.ServcVo;
import ncis.dsb.stts.rsrcuse.dao.JobRsrcStteVmDao;
import ncis.dsb.stts.rsrcuse.service.JobRsrcStteVmService;
import ncis.dsb.stts.rsrcuse.vo.JobRsrcStteVmSearchVo;
import ncis.dsb.stts.rsrcuse.vo.VmVo;

import org.springframework.stereotype.Service;

@Service("jobRsrcStteVmService")
public class JobRsrcStteVmImpl implements JobRsrcStteVmService {


	@Resource(name="jobRsrcStteVmDao")
	private JobRsrcStteVmDao jobRsrcStteVmDao;

	/**
	 * 업무조회
	 * */
	@Override
	public JobRsrcStteVmSearchVo selectJobNm(JobRsrcStteVmSearchVo vmSearchVo)throws Exception{
		JobRsrcStteVmSearchVo cmJob = jobRsrcStteVmDao.selectJobNm(vmSearchVo);


        return cmJob;
	}

	/**
	 * ip대역 정보 조회
	 * */
	@Override
	public List<IpBndVo> selectIpBnd(String institutionId)throws Exception{
		List<IpBndVo> list = jobRsrcStteVmDao.selectIpBnd(institutionId);


        return list;
	}
	/**
	 * 컴퓨팅 조회
	 * */
	@Override
	 public List<VmVo> selectVmList(JobRsrcStteVmSearchVo vmSearchVo, Boolean isPagination) throws Exception {

	        List<VmVo> vmList = null;

	        int vmTotalCount = jobRsrcStteVmDao.selectVmTotCnt(vmSearchVo);

	        if (isPagination && vmTotalCount > 0) {
	            vmSearchVo.getPaginationInfo().setTotalRecordCount(vmTotalCount); // 페이지 처리위한 count
	        }
	        else if (!isPagination) {
	            vmSearchVo.setPaginationInfo(null);
	        }

	        if (vmTotalCount > 0) {
	            vmList = jobRsrcStteVmDao.selectVmList(vmSearchVo);
	        }

	        return vmList;

	    }
	/**
	 * SLB 정보 조회
	 * */
	@Override
	public List<RnSlb> selectSlbList(JobRsrcStteVmSearchVo vmSearchVo) throws Exception{

		List<RnSlb> list = jobRsrcStteVmDao.selectSlbList(vmSearchVo);

        return list;
	}

	/**
	 * SLB 적용 대상 조회
	 * */
	@Override
	public List<RnSlbIp> selectSlbIpList(JobRsrcStteVmSearchVo vmSearchVo) throws Exception{

		List<RnSlbIp> list = jobRsrcStteVmDao.selectSlbIpList(vmSearchVo);

        return list;
	}

	@Override
	public List<ServcVo> selectServcList(JobRsrcStteVmSearchVo searchVo) throws Exception {
		List<ServcVo> list = jobRsrcStteVmDao.selectServcList(searchVo);
		return list;
	}

	@Override
	public List<ServcPodVo> selectPodList(JobRsrcStteVmSearchVo searchVo) throws Exception {
		List<ServcPodVo> list = jobRsrcStteVmDao.selectPodList(searchVo);
		return list;
	}


}
