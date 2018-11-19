package ncis.cpt.rsrc.atmscl.vo;


import java.util.List;

import ncis.cmn.entity.RxServcArea;

public class AtmsclDistrbVo extends RxServcArea {

  private Integer servcSeq;  /* 서비스SEQ */
  private String distrbConfId;  /* 배포설정ID */
  private String distrbConfNm;  /* 배포설정명 */

  private String distrbStatCd; /* 배포상태코드 */
  private String distrbStatNm; /* 배포상태명 */
  private String distrbVer;  /* 배포버전 */

  private String tmplatNm;  /* 템플릿명 */
  private String cntanrId;  /* 컨테이너ID */
  private String imgId;  /* 이미지ID */
  private String imgTag;  /* 이미지태그 */
  private String reStrtPolicyClCd;  /* 재기동정책구분코드 */
  private String dnsPolicyClCd;  /* DNS정책구분코드 */
  private Integer rplcaQty;  /* 복제수 */
  private String testYn;  /* 테스트여부 */
  private String lastDistrbDttm;  /* 최종배포일시 */
  private String lastDistrbVer;  /* 최종배포버전 */
  private String statCd;  /* 상태코드 */
  private String statNm;  /* 상태코드명 */
  private String rmk;  /* 비고 */
  private String creDttm;  /* 생성일시 */
  private String updtDttm;  /* 수정일시 */
  private String creUserId;  /* 생성자ID */
  private String updtUserId;  /* 수정자ID */
  //
  private String servcNm; /*서비스명*/
  private String institutionNm; /*부처명*/
  private String jobNm; /*업무명*/
  private String regionId; /* 리전ID */
  private String zoneId; /* 존ID */
  private String netClCd; /* 망구분코드 */
  private String regionNm; /* 리전명 */
  private String zoneNm; /* 존명 */
  private String netNm; /* 망명 */
  private String rsrcPoolId; /* 자원풀ID */
  private String rsrcPoolNm; /* 자원풀명 */
  private String imgNm;/*이미지명*/

  private String podNm;	/*Pod 명*/
  private double reqCpuCorQty; //요청CPU코어수
  private double reqMemCapa; //요청메모리용량
  private double lmttCpuCorQty; // 제한CPU코어수
  private double lmttMemCapa; //제한메모리용량
  private Integer cpuCorQty; //CPU코어수
  private Integer cpuUseRt; // CPU사용률
  private Integer memAsgnCapa; //메모리할당량
  private Integer memUseRt; // 메모리사용률
  private Integer netwkIn; //네트워크 IN
  private Integer netwkOut; //네트워크 OUT
  private String thresClCd; /*임계치 구분코드*/
  private String strtThresVl; // 시작임계치 값
  private String endThresVl; // 종료임계치 값
  private Integer nowPodQty; //현재 POD 수
  private Integer minPodQty; //최소 POD 수
  private Integer maxPodQty; //최대 POD 수
  private String alarmYn; //알림여부
  private String creUserNm; //생성자 명
  private String updtUserNm; //수정자 명
  private String pvId; // PV_ID
  private String pvNm; // PV명
  private String accssModeClCd; //접근모드구분코드
  private Integer strgAsgnCapa; //스토리지 할당량
  private String volumeNm;
  private String mountPath;
  private Integer reqStrgCapa;
  private String regUserId;
  private Integer chngPodQty; //변경POD 수
  private String sclReasn; // 스케일 사유
  private String distrbDttm; //배포일시
  private double avgCpuUseRt; /* CPU사용률 */
  private double avgMemUseRt; /* 메모리사용률 */
  private String distrbId; //배포 ID
  private String defaultYn;
  private String servcId;
  private String sclngClCd;
  private String checkCd;
  private String sclGrpCd;
  private String scalrId;

  private List<DistrbEnvConfVo> distrbEnvConfList; // StaticRouter 목록
  private List<RsrvSclngVo> distrbMultiSclList;

  private String maxCpuCorQty;
  private String minCpuCorQty;
  private String maxMemCapa;
  private String minMemCapa;
  private String lmttTyCd;
  private String pvcId;
  private String bldStatCd;
  private String ctlTrgtYn;
/**
 * @return the servcSeq
 */
public Integer getServcSeq() {
	return servcSeq;
}
/**
 * @param servcSeq the servcSeq to set
 */
public void setServcSeq(Integer servcSeq) {
	this.servcSeq = servcSeq;
}
/**
 * @return the distrbConfId
 */
public String getDistrbConfId() {
	return distrbConfId;
}
/**
 * @param distrbConfId the distrbConfId to set
 */
public void setDistrbConfId(String distrbConfId) {
	this.distrbConfId = distrbConfId;
}
/**
 * @return the distrbConfNm
 */
public String getDistrbConfNm() {
	return distrbConfNm;
}
/**
 * @param distrbConfNm the distrbConfNm to set
 */
public void setDistrbConfNm(String distrbConfNm) {
	this.distrbConfNm = distrbConfNm;
}
/**
 * @return the tmplatNm
 */
public String getTmplatNm() {
	return tmplatNm;
}
/**
 * @param tmplatNm the tmplatNm to set
 */
public void setTmplatNm(String tmplatNm) {
	this.tmplatNm = tmplatNm;
}
/**
 * @return the cntanrId
 */
public String getCntanrId() {
	return cntanrId;
}
/**
 * @param cntanrId the cntanrId to set
 */
public void setCntanrId(String cntanrId) {
	this.cntanrId = cntanrId;
}
/**
 * @return the imgId
 */
public String getImgId() {
	return imgId;
}
/**
 * @param imgId the imgId to set
 */
public void setImgId(String imgId) {
	this.imgId = imgId;
}
/**
 * @return the imgTag
 */
public String getImgTag() {
	return imgTag;
}
/**
 * @param imgTag the imgTag to set
 */
public void setImgTag(String imgTag) {
	this.imgTag = imgTag;
}
/**
 * @return the reStrtPolicyClCd
 */
public String getReStrtPolicyClCd() {
	return reStrtPolicyClCd;
}
/**
 * @param reStrtPolicyClCd the reStrtPolicyClCd to set
 */
public void setReStrtPolicyClCd(String reStrtPolicyClCd) {
	this.reStrtPolicyClCd = reStrtPolicyClCd;
}
/**
 * @return the dnsPolicyClCd
 */
public String getDnsPolicyClCd() {
	return dnsPolicyClCd;
}
/**
 * @param dnsPolicyClCd the dnsPolicyClCd to set
 */
public void setDnsPolicyClCd(String dnsPolicyClCd) {
	this.dnsPolicyClCd = dnsPolicyClCd;
}
/**
 * @return the rplcaQty
 */
public Integer getRplcaQty() {
	return rplcaQty;
}
/**
 * @param rplcaQty the rplcaQty to set
 */
public void setRplcaQty(Integer rplcaQty) {
	this.rplcaQty = rplcaQty;
}
/**
 * @return the testYn
 */
public String getTestYn() {
	return testYn;
}
/**
 * @param testYn the testYn to set
 */
public void setTestYn(String testYn) {
	this.testYn = testYn;
}
/**
 * @return the lastDistrbDttm
 */
public String getLastDistrbDttm() {
	return lastDistrbDttm;
}
/**
 * @param lastDistrbDttm the lastDistrbDttm to set
 */
public void setLastDistrbDttm(String lastDistrbDttm) {
	this.lastDistrbDttm = lastDistrbDttm;
}
/**
 * @return the lastDistrbVer
 */
public String getLastDistrbVer() {
	return lastDistrbVer;
}
/**
 * @param lastDistrbVer the lastDistrbVer to set
 */
public void setLastDistrbVer(String lastDistrbVer) {
	this.lastDistrbVer = lastDistrbVer;
}
/**
 * @return the statCd
 */
public String getStatCd() {
	return statCd;
}
/**
 * @param statCd the statCd to set
 */
public void setStatCd(String statCd) {
	this.statCd = statCd;
}
/**
 * @return the statNm
 */
public String getStatNm() {
	return statNm;
}
/**
 * @param statNm the statNm to set
 */
public void setStatNm(String statNm) {
	this.statNm = statNm;
}
/**
 * @return the rmk
 */
public String getRmk() {
	return rmk;
}
/**
 * @param rmk the rmk to set
 */
public void setRmk(String rmk) {
	this.rmk = rmk;
}
/**
 * @return the creDttm
 */
public String getCreDttm() {
	return creDttm;
}
/**
 * @param creDttm the creDttm to set
 */
public void setCreDttm(String creDttm) {
	this.creDttm = creDttm;
}
/**
 * @return the updtDttm
 */
public String getUpdtDttm() {
	return updtDttm;
}
/**
 * @param updtDttm the updtDttm to set
 */
public void setUpdtDttm(String updtDttm) {
	this.updtDttm = updtDttm;
}
/**
 * @return the creUserId
 */
public String getCreUserId() {
	return creUserId;
}
/**
 * @param creUserId the creUserId to set
 */
public void setCreUserId(String creUserId) {
	this.creUserId = creUserId;
}
/**
 * @return the updtUserId
 */
public String getUpdtUserId() {
	return updtUserId;
}
/**
 * @param updtUserId the updtUserId to set
 */
public void setUpdtUserId(String updtUserId) {
	this.updtUserId = updtUserId;
}
/**
 * @return the servcNm
 */
public String getServcNm() {
	return servcNm;
}
/**
 * @param servcNm the servcNm to set
 */
public void setServcNm(String servcNm) {
	this.servcNm = servcNm;
}
/**
 * @return the institutionNm
 */
public String getInstitutionNm() {
	return institutionNm;
}
/**
 * @param institutionNm the institutionNm to set
 */
public void setInstitutionNm(String institutionNm) {
	this.institutionNm = institutionNm;
}
/**
 * @return the jobNm
 */
public String getJobNm() {
	return jobNm;
}
/**
 * @param jobNm the jobNm to set
 */
public void setJobNm(String jobNm) {
	this.jobNm = jobNm;
}
/**
 * @return the regionId
 */
public String getRegionId() {
	return regionId;
}
/**
 * @param regionId the regionId to set
 */
public void setRegionId(String regionId) {
	this.regionId = regionId;
}
/**
 * @return the zoneId
 */
public String getZoneId() {
	return zoneId;
}
/**
 * @param zoneId the zoneId to set
 */
public void setZoneId(String zoneId) {
	this.zoneId = zoneId;
}
/**
 * @return the netClCd
 */
public String getNetClCd() {
	return netClCd;
}
/**
 * @param netClCd the netClCd to set
 */
public void setNetClCd(String netClCd) {
	this.netClCd = netClCd;
}
/**
 * @return the regionNm
 */
public String getRegionNm() {
	return regionNm;
}
/**
 * @param regionNm the regionNm to set
 */
public void setRegionNm(String regionNm) {
	this.regionNm = regionNm;
}
/**
 * @return the zoneNm
 */
public String getZoneNm() {
	return zoneNm;
}
/**
 * @param zoneNm the zoneNm to set
 */
public void setZoneNm(String zoneNm) {
	this.zoneNm = zoneNm;
}
/**
 * @return the netNm
 */
public String getNetNm() {
	return netNm;
}
/**
 * @param netNm the netNm to set
 */
public void setNetNm(String netNm) {
	this.netNm = netNm;
}
/**
 * @return the rsrcPoolId
 */
public String getRsrcPoolId() {
	return rsrcPoolId;
}
/**
 * @param rsrcPoolId the rsrcPoolId to set
 */
public void setRsrcPoolId(String rsrcPoolId) {
	this.rsrcPoolId = rsrcPoolId;
}
/**
 * @return the rsrcPoolNm
 */
public String getRsrcPoolNm() {
	return rsrcPoolNm;
}
/**
 * @param rsrcPoolNm the rsrcPoolNm to set
 */
public void setRsrcPoolNm(String rsrcPoolNm) {
	this.rsrcPoolNm = rsrcPoolNm;
}
/**
 * @return the imgNm
 */
public String getImgNm() {
	return imgNm;
}
/**
 * @param imgNm the imgNm to set
 */
public void setImgNm(String imgNm) {
	this.imgNm = imgNm;
}
/**
 * @return the podNm
 */
public String getPodNm() {
	return podNm;
}
/**
 * @param podNm the podNm to set
 */
public void setPodNm(String podNm) {
	this.podNm = podNm;
}
/**
 * @return the reqCpuCorQty
 */
public double getReqCpuCorQty() {
	return reqCpuCorQty;
}
/**
 * @param reqCpuCorQty the reqCpuCorQty to set
 */
public void setReqCpuCorQty(double reqCpuCorQty) {
	this.reqCpuCorQty = reqCpuCorQty;
}
/**
 * @return the reqMemCapa
 */
public double getReqMemCapa() {
	return reqMemCapa;
}
/**
 * @param reqMemCapa the reqMemCapa to set
 */
public void setReqMemCapa(double reqMemCapa) {
	this.reqMemCapa = reqMemCapa;
}
/**
 * @return the lmttCpuCorQty
 */
public double getLmttCpuCorQty() {
	return lmttCpuCorQty;
}
/**
 * @param lmttCpuCorQty the lmttCpuCorQty to set
 */
public void setLmttCpuCorQty(double lmttCpuCorQty) {
	this.lmttCpuCorQty = lmttCpuCorQty;
}
/**
 * @return the lmttMemCapa
 */
public double getLmttMemCapa() {
	return lmttMemCapa;
}
/**
 * @param lmttMemCapa the lmttMemCapa to set
 */
public void setLmttMemCapa(double lmttMemCapa) {
	this.lmttMemCapa = lmttMemCapa;
}
/**
 * @return the cpuCorQty
 */
public Integer getCpuCorQty() {
	return cpuCorQty;
}
/**
 * @param cpuCorQty the cpuCorQty to set
 */
public void setCpuCorQty(Integer cpuCorQty) {
	this.cpuCorQty = cpuCorQty;
}
/**
 * @return the cpuUseRt
 */
public Integer getCpuUseRt() {
	return cpuUseRt;
}
/**
 * @param cpuUseRt the cpuUseRt to set
 */
public void setCpuUseRt(Integer cpuUseRt) {
	this.cpuUseRt = cpuUseRt;
}
/**
 * @return the memAsgnCapa
 */
public Integer getMemAsgnCapa() {
	return memAsgnCapa;
}
/**
 * @param memAsgnCapa the memAsgnCapa to set
 */
public void setMemAsgnCapa(Integer memAsgnCapa) {
	this.memAsgnCapa = memAsgnCapa;
}
/**
 * @return the memUseRt
 */
public Integer getMemUseRt() {
	return memUseRt;
}
/**
 * @param memUseRt the memUseRt to set
 */
public void setMemUseRt(Integer memUseRt) {
	this.memUseRt = memUseRt;
}
/**
 * @return the netwkIn
 */
public Integer getNetwkIn() {
	return netwkIn;
}
/**
 * @param netwkIn the netwkIn to set
 */
public void setNetwkIn(Integer netwkIn) {
	this.netwkIn = netwkIn;
}
/**
 * @return the netwkOut
 */
public Integer getNetwkOut() {
	return netwkOut;
}
/**
 * @param netwkOut the netwkOut to set
 */
public void setNetwkOut(Integer netwkOut) {
	this.netwkOut = netwkOut;
}
/**
 * @return the thresClCd
 */
public String getThresClCd() {
	return thresClCd;
}
/**
 * @param thresClCd the thresClCd to set
 */
public void setThresClCd(String thresClCd) {
	this.thresClCd = thresClCd;
}
/**
 * @return the strtThresVl
 */
public String getStrtThresVl() {
	return strtThresVl;
}
/**
 * @param strtThresVl the strtThresVl to set
 */
public void setStrtThresVl(String strtThresVl) {
	this.strtThresVl = strtThresVl;
}
/**
 * @return the endThresVl
 */
public String getEndThresVl() {
	return endThresVl;
}
/**
 * @param endThresVl the endThresVl to set
 */
public void setEndThresVl(String endThresVl) {
	this.endThresVl = endThresVl;
}
/**
 * @return the nowPodQty
 */
public Integer getNowPodQty() {
	return nowPodQty;
}
/**
 * @param nowPodQty the nowPodQty to set
 */
public void setNowPodQty(Integer nowPodQty) {
	this.nowPodQty = nowPodQty;
}
/**
 * @return the minPodQty
 */
public Integer getMinPodQty() {
	return minPodQty;
}
/**
 * @param minPodQty the minPodQty to set
 */
public void setMinPodQty(Integer minPodQty) {
	this.minPodQty = minPodQty;
}
/**
 * @return the maxPodQty
 */
public Integer getMaxPodQty() {
	return maxPodQty;
}
/**
 * @param maxPodQty the maxPodQty to set
 */
public void setMaxPodQty(Integer maxPodQty) {
	this.maxPodQty = maxPodQty;
}
/**
 * @return the alarmYn
 */
public String getAlarmYn() {
	return alarmYn;
}
/**
 * @param alarmYn the alarmYn to set
 */
public void setAlarmYn(String alarmYn) {
	this.alarmYn = alarmYn;
}
/**
 * @return the creUserNm
 */
public String getCreUserNm() {
	return creUserNm;
}
/**
 * @param creUserNm the creUserNm to set
 */
public void setCreUserNm(String creUserNm) {
	this.creUserNm = creUserNm;
}
/**
 * @return the updtUserNm
 */
public String getUpdtUserNm() {
	return updtUserNm;
}
/**
 * @param updtUserNm the updtUserNm to set
 */
public void setUpdtUserNm(String updtUserNm) {
	this.updtUserNm = updtUserNm;
}
/**
 * @return the distrbVer
 */
public String getDistrbVer() {
	return distrbVer;
}
/**
 * @param distrbVer the distrbVer to set
 */
public void setDistrbVer(String distrbVer) {
	this.distrbVer = distrbVer;
}
/**
 * @return the distrbStatCd
 */
public String getDistrbStatCd() {
	return distrbStatCd;
}
/**
 * @param distrbStatCd the distrbStatCd to set
 */
public void setDistrbStatCd(String distrbStatCd) {
	this.distrbStatCd = distrbStatCd;
}
/**
 * @return the distrbStatNm
 */
public String getDistrbStatNm() {
	return distrbStatNm;
}
/**
 * @param distrbStatNm the distrbStatNm to set
 */
public void setDistrbStatNm(String distrbStatNm) {
	this.distrbStatNm = distrbStatNm;
}
/**
 * @return the pvId
 */
public String getPvId() {
	return pvId;
}
/**
 * @param pvId the pvId to set
 */
public void setPvId(String pvId) {
	this.pvId = pvId;
}
/**
 * @return the pvNm
 */
public String getPvNm() {
	return pvNm;
}
/**
 * @param pvNm the pvNm to set
 */
public void setPvNm(String pvNm) {
	this.pvNm = pvNm;
}
/**
 * @return the accssModeClCd
 */
public String getAccssModeClCd() {
	return accssModeClCd;
}
/**
 * @param accssModeClCd the accssModeClCd to set
 */
public void setAccssModeClCd(String accssModeClCd) {
	this.accssModeClCd = accssModeClCd;
}
/**
 * @return the strgAsgnCapa
 */
public Integer getStrgAsgnCapa() {
	return strgAsgnCapa;
}
/**
 * @param strgAsgnCapa the strgAsgnCapa to set
 */
public void setStrgAsgnCapa(Integer strgAsgnCapa) {
	this.strgAsgnCapa = strgAsgnCapa;
}
/**
 * @return the volumeNm
 */
public String getVolumeNm() {
	return volumeNm;
}
/**
 * @param volumeNm the volumeNm to set
 */
public void setVolumeNm(String volumeNm) {
	this.volumeNm = volumeNm;
}
/**
 * @return the mountPath
 */
public String getMountPath() {
	return mountPath;
}
/**
 * @param mountPath the mountPath to set
 */
public void setMountPath(String mountPath) {
	this.mountPath = mountPath;
}
/**
 * @return the reqStrgCapa
 */
public Integer getReqStrgCapa() {
	return reqStrgCapa;
}
/**
 * @param reqStrgCapa the reqStrgCapa to set
 */
public void setReqStrgCapa(Integer reqStrgCapa) {
	this.reqStrgCapa = reqStrgCapa;
}
/**
 * @return the regUserId
 */
public String getRegUserId() {
	return regUserId;
}
/**
 * @param regUserId the regUserId to set
 */
public void setRegUserId(String regUserId) {
	this.regUserId = regUserId;
}
/**
 * @return the chngPodQty
 */
public Integer getChngPodQty() {
	return chngPodQty;
}
/**
 * @param chngPodQty the chngPodQty to set
 */
public void setChngPodQty(Integer chngPodQty) {
	this.chngPodQty = chngPodQty;
}
/**
 * @return the sclReasn
 */
public String getSclReasn() {
	return sclReasn;
}
/**
 * @param sclReasn the sclReasn to set
 */
public void setSclReasn(String sclReasn) {
	this.sclReasn = sclReasn;
}
/**
 * @return the distrbDttm
 */
public String getDistrbDttm() {
	return distrbDttm;
}
/**
 * @param distrbDttm the distrbDttm to set
 */
public void setDistrbDttm(String distrbDttm) {
	this.distrbDttm = distrbDttm;
}
/**
 * @return the avgCpuUseRt
 */
public double getAvgCpuUseRt() {
	return avgCpuUseRt;
}
/**
 * @param avgCpuUseRt the avgCpuUseRt to set
 */
public void setAvgCpuUseRt(double avgCpuUseRt) {
	this.avgCpuUseRt = avgCpuUseRt;
}
/**
 * @return the avgMemUseRt
 */
public double getAvgMemUseRt() {
	return avgMemUseRt;
}
/**
 * @param avgMemUseRt the avgMemUseRt to set
 */
public void setAvgMemUseRt(double avgMemUseRt) {
	this.avgMemUseRt = avgMemUseRt;
}
/**
 * @return the distrbId
 */
public String getDistrbId() {
	return distrbId;
}
/**
 * @param distrbId the distrbId to set
 */
public void setDistrbId(String distrbId) {
	this.distrbId = distrbId;
}
/**
 * @return the distrbEnvConfList
 */
public List<DistrbEnvConfVo> getDistrbEnvConfList() {
	return distrbEnvConfList;
}
/**
 * @param distrbEnvConfList the distrbEnvConfList to set
 */
public void setDistrbEnvConfList(List<DistrbEnvConfVo> distrbEnvConfList) {
	this.distrbEnvConfList = distrbEnvConfList;
}
/**
 * @return the defaultYn
 */
public String getDefaultYn() {
	return defaultYn;
}
/**
 * @param defaultYn the defaultYn to set
 */
public void setDefaultYn(String defaultYn) {
	this.defaultYn = defaultYn;
}
/**
 * @return the servcId
 */
public String getServcId() {
	return servcId;
}
/**
 * @param servcId the servcId to set
 */
public void setServcId(String servcId) {
	this.servcId = servcId;
}
/**
 * @return the distrbMultiSclList
 */
public List<RsrvSclngVo> getDistrbMultiSclList() {
	return distrbMultiSclList;
}
/**
 * @param distrbMultiSclList the distrbMultiSclList to set
 */
public void setDistrbMultiSclList(List<RsrvSclngVo> distrbMultiSclList) {
	this.distrbMultiSclList = distrbMultiSclList;
}
/**
 * @return the sclngClCd
 */
public String getSclngClCd() {
	return sclngClCd;
}
/**
 * @param sclngClCd the sclngClCd to set
 */
public void setSclngClCd(String sclngClCd) {
	this.sclngClCd = sclngClCd;
}
/**
 * @return the checkCd
 */
public String getCheckCd() {
	return checkCd;
}
/**
 * @param checkCd the checkCd to set
 */
public void setCheckCd(String checkCd) {
	this.checkCd = checkCd;
}
/**
 * @return the sclGrpCd
 */
public String getSclGrpCd() {
	return sclGrpCd;
}
/**
 * @param sclGrpCd the sclGrpCd to set
 */
public void setSclGrpCd(String sclGrpCd) {
	this.sclGrpCd = sclGrpCd;
}
/**
 * @return the scalrId
 */
public String getScalrId() {
	return scalrId;
}
/**
 * @param scalrId the scalrId to set
 */
public void setScalrId(String scalrId) {
	this.scalrId = scalrId;
}
/**
 * @return the maxCpuCorQty
 */
public String getMaxCpuCorQty() {
	return maxCpuCorQty;
}
/**
 * @param maxCpuCorQty the maxCpuCorQty to set
 */
public void setMaxCpuCorQty(String maxCpuCorQty) {
	this.maxCpuCorQty = maxCpuCorQty;
}
/**
 * @return the minCpuCorQty
 */
public String getMinCpuCorQty() {
	return minCpuCorQty;
}
/**
 * @param minCpuCorQty the minCpuCorQty to set
 */
public void setMinCpuCorQty(String minCpuCorQty) {
	this.minCpuCorQty = minCpuCorQty;
}
/**
 * @return the maxMemCapa
 */
public String getMaxMemCapa() {
	return maxMemCapa;
}
/**
 * @param maxMemCapa the maxMemCapa to set
 */
public void setMaxMemCapa(String maxMemCapa) {
	this.maxMemCapa = maxMemCapa;
}
/**
 * @return the minMemCapa
 */
public String getMinMemCapa() {
	return minMemCapa;
}
/**
 * @param minMemCapa the minMemCapa to set
 */
public void setMinMemCapa(String minMemCapa) {
	this.minMemCapa = minMemCapa;
}
/**
 * @return the lmttTyCd
 */
public String getLmttTyCd() {
	return lmttTyCd;
}
/**
 * @param lmttTyCd the lmttTyCd to set
 */
public void setLmttTyCd(String lmttTyCd) {
	this.lmttTyCd = lmttTyCd;
}
/**
 * @return the pvcId
 */
public String getPvcId() {
	return pvcId;
}
/**
 * @param pvcId the pvcId to set
 */
public void setPvcId(String pvcId) {
	this.pvcId = pvcId;
}
/**
 * @return the bldStatCd
 */
public String getBldStatCd() {
	return bldStatCd;
}
/**
 * @param bldStatCd the bldStatCd to set
 */
public void setBldStatCd(String bldStatCd) {
	this.bldStatCd = bldStatCd;
}
/**
 * @return the ctlTrgtYn
 */
public String getCtlTrgtYn() {
	return ctlTrgtYn;
}
/**
 * @param ctlTrgtYn the ctlTrgtYn to set
 */
public void setCtlTrgtYn(String ctlTrgtYn) {
	this.ctlTrgtYn = ctlTrgtYn;
}


}