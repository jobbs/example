package ncis.dsb.cmn.vo;

import java.util.List;

public class MainCvo {

	private PmResSttsVo pmResSttsVo;
	private PodResSttsVo podResSttsVo;
	private int dept;
	private int job;
	private int vcore;

	private List<VmInfoVo> vmInfoList;
	private List<PodInfoVo> podInfoList;
	private List<RtVo> vmCpuList;
	private List<RtVo> vmMemList;
	private List<NetTrficVo> vmNetTrficList;
	private List<ManagerSttsVo> managerSttsList;


	public PmResSttsVo getPmResSttsVo(){
	    return pmResSttsVo;
	}

	public void setPmResSttsVo(PmResSttsVo pmResSttsVo){
	    this.pmResSttsVo = pmResSttsVo;
	}

	public PodResSttsVo getPodResSttsVo(){
	    return podResSttsVo;
	}

	public void setPodResSttsVo(PodResSttsVo podResSttsVo){
	    this.podResSttsVo = podResSttsVo;
	}

	public int getDept(){
		return dept;
	}

	public void setDept(int dept){
		this.dept = dept;
	}

	public int getJob(){
		return job;
	}

	public void setJob(int job){
		this.job = job;
	}

	public int getVcore(){
		return vcore;
	}

	public void setVcore(int vcore){
		this.vcore = vcore;
	}


	public List<VmInfoVo> getVmInfoList(){
		return vmInfoList;
	}

	public void setVmInfoList(List<VmInfoVo> vmInfoList){
		this.vmInfoList = vmInfoList;
	}

	public List<PodInfoVo> getPodInfoList(){
		return podInfoList;
	}

	public void setPodInfoList(List<PodInfoVo> podInfoList){
		this.podInfoList = podInfoList;
	}

	public List<RtVo> getVmCpuList(){
		return vmCpuList;
	}

	public void setVmCpuList(List<RtVo> vmCpuList){
		this.vmCpuList = vmCpuList;
	}

	public List<RtVo> getVmMemList(){
		return vmMemList;
	}

	public void setVmMemList(List<RtVo> vmMemList){
		this.vmMemList = vmMemList;
	}

	public List<NetTrficVo> getVmNetTrficList(){
		return vmNetTrficList;
	}

	public void setVmNetTrficList(List<NetTrficVo> vmNetTrficList){
		this.vmNetTrficList = vmNetTrficList;
	}

	public List<ManagerSttsVo> getManagerSttsList(){
		return managerSttsList;
	}

	public void setManagerSttsList(List<ManagerSttsVo> managerSttsList){
		this.managerSttsList = managerSttsList;
	}

}
