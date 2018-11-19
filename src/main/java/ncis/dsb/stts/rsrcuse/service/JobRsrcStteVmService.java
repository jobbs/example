/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobRsrcStteVmService.java
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

import ncis.cmn.entity.RnSlb;
import ncis.cmn.entity.RnSlbIp;
import ncis.cpt.opr.ip.vo.IpBndVo;
import ncis.cpt.rsrc.atmscl.vo.ServcPodVo;
import ncis.cpt.rsrc.atmscl.vo.ServcVo;
import ncis.dsb.stts.rsrcuse.vo.JobRsrcStteVmSearchVo;
import ncis.dsb.stts.rsrcuse.vo.VmVo;

public interface JobRsrcStteVmService {

	public JobRsrcStteVmSearchVo selectJobNm(JobRsrcStteVmSearchVo vmSearchVo)throws Exception;

	public List<IpBndVo> selectIpBnd(String institutionId)throws Exception;

	public List<VmVo> selectVmList(JobRsrcStteVmSearchVo vmSearchVo, Boolean isPagination)throws Exception;

	public List<RnSlb> selectSlbList(JobRsrcStteVmSearchVo searchVo)throws Exception;

	public List<RnSlbIp> selectSlbIpList(JobRsrcStteVmSearchVo searchVo)throws Exception;

	public List<ServcVo> selectServcList(JobRsrcStteVmSearchVo searchVo)throws Exception;

	public List<ServcPodVo> selectPodList(JobRsrcStteVmSearchVo searchVo)throws Exception;


}
