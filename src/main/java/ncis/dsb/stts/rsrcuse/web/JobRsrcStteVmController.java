/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobRsrcStteVmController.java
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
package ncis.dsb.stts.rsrcuse.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.entity.RnSlb;
import ncis.cmn.entity.RnSlbIp;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.ip.vo.IpBndVo;
import ncis.cpt.rsrc.atmscl.vo.ServcPodVo;
import ncis.cpt.rsrc.atmscl.vo.ServcVo;
import ncis.cpt.rsrc.com.service.VmService;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.cpt.rsrc.net.service.NetVmService;
import ncis.cpt.rsrc.net.vo.NetVmSvo;
import ncis.cpt.rsrc.net.vo.NetVmVo;
import ncis.dsb.stts.rsrcuse.service.JobRsrcStteVmService;
import ncis.dsb.stts.rsrcuse.vo.JobRsrcStteVmSearchVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("jobRsrcStteVmController")
@RequestMapping("/dsb/stts/rsrcuse/job")
public class JobRsrcStteVmController extends BaseController {


	@Resource(name="jobRsrcStteVmService")
	JobRsrcStteVmService jobRsrcStteVmService;

	@Resource(name = "vmService")
    VmService vmService;

	@Resource(name="netVmService")
	private NetVmService netVmService;

	/**
	 * 업무별 자원현황 상세
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectJobRsrcStteVmList.do")
	public String selectJobRsrcStteVmList( HttpServletRequest request,JobRsrcStteVmSearchVo searchVo,
			Model model, @RequestParam("jobId") String jobId,@RequestParam("jobNm") String jobNm, @RequestParam("institutionId") String institutionId) throws Exception{

		searchVo.setInstitutionId(institutionId);
		searchVo.setJobId(jobId);
		searchVo.setJobNm(jobNm);

		NetVmSvo svo = new NetVmSvo();
		VmSearchVo vmSearchVo = new VmSearchVo();
		vmSearchVo.setEqualsJobId(jobId);
		svo.setJobId(jobId);
		JobRsrcStteVmSearchVo cmJob  = jobRsrcStteVmService.selectJobNm(searchVo);

		List<IpBndVo> IpBndList = jobRsrcStteVmService.selectIpBnd(institutionId);

		List<VmVo> vmVoList = vmService.selectVmListPaging(vmSearchVo);

		List<NetVmVo> NetVmVo = netVmService.selectNetVmList(svo, true);
		List<RnSlb> rnSlbList = jobRsrcStteVmService.selectSlbList(searchVo);
		List<RnSlbIp> rnSlbIpList = jobRsrcStteVmService.selectSlbIpList(searchVo);
		List<ServcVo> selectServcList = jobRsrcStteVmService.selectServcList(searchVo);
		List<ServcPodVo> selectPodList = jobRsrcStteVmService.selectPodList(searchVo);

		model.addAttribute("cmJob", cmJob);
		model.addAttribute("IpBndList", IpBndList);
		model.addAttribute("vmVoList", vmVoList);
		model.addAttribute("NetVmVo", NetVmVo);
		model.addAttribute("rnSlbList", rnSlbList);
		model.addAttribute("rnSlbIpList", rnSlbIpList);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("selectServcList", selectServcList);
		model.addAttribute("selectPodList", selectPodList);

		return dashTilesView(request,"selectJobRsrcStteVmList");
	}



}

