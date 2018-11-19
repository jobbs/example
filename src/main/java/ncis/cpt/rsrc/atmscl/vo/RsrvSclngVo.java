package ncis.cpt.rsrc.atmscl.vo;

import ncis.cmn.entity.RxServcArea;

public class RsrvSclngVo extends RxServcArea {

    private Integer servcSeq;  /* 서비스SEQ */
    private String scalrId;  /* 스케일러ID */
    private String sclngClCd;  /* 스케일링구분코드 */
    private String scalrNm;  /* 스케일러명 */
    private Integer nowPodQty;  /* 현재POD수 */
    private Integer minPodQty;  /* 최소POD수 */
    private Integer maxPodQty;  /* 최대POD수 */
    private String useYn;  /* 사용여부 */
    private String alarmYn;  /* 알림여부 */
    private String sclConfCndClCd;  /* 스케일설정조건구분코드 */
    private String creDttm;  /* 생성일시 */
    private String updtDttm;  /* 수정일시 */
    private String lastSclDttm;  /* 최종스케일일시 */
    private String creUserId;  /* 생성자ID */
    private String updtUserId;  /* 수정자ID */
    private String rsrvStrtDt;  /* 예약시작일자 */
    private String rsrvEndDt;  /* 예약종료일자 */

    private String institutionNm; /*부처명*/
    private String jobNm; /*업무명*/
    private String servcNm; /*서미스명*/
    private String imgId; /*배포 이미지ID*/
    private String creUserNm;  /* 생성자명 */
    private String updtUserNm;  /* 수정자명 */
    private String regionId; /* 리전ID */
    private String zoneId; /* 존ID */
    private String netClCd; /* 망구분코드 */
    private String regionNm; /* 리전명 */
    private String zoneNm; /* 존명 */
    private String netNm; /* 망명 */
    private String netId; /* 망ID */
    private String rsrcPoolId; /* 자원풀ID */
    private String rsrcPoolNm; /* 자원풀명 */
    private String imgNm; /*배포이미지명*/
    private String sclGrpCd; //스케일그룹코드
    private String thresClCd; /*임계치 구분코드*/
    private String strtThresVl; // 시작임계치 값
    private String endThresVl; // 종료임계치 값
    private Integer rsrvCount; //스케일 예약설정 수
    private Integer opMultiSclCount; // 다차원 스케일링 예약 수
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
	 * @return the scalrNm
	 */
	public String getScalrNm() {
		return scalrNm;
	}
	/**
	 * @param scalrNm the scalrNm to set
	 */
	public void setScalrNm(String scalrNm) {
		this.scalrNm = scalrNm;
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
	 * @return the useYn
	 */
	public String getUseYn() {
		return useYn;
	}
	/**
	 * @param useYn the useYn to set
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
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
	 * @return the sclConfCndClCd
	 */
	public String getSclConfCndClCd() {
		return sclConfCndClCd;
	}
	/**
	 * @param sclConfCndClCd the sclConfCndClCd to set
	 */
	public void setSclConfCndClCd(String sclConfCndClCd) {
		this.sclConfCndClCd = sclConfCndClCd;
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
	 * @return the lastSclDttm
	 */
	public String getLastSclDttm() {
		return lastSclDttm;
	}
	/**
	 * @param lastSclDttm the lastSclDttm to set
	 */
	public void setLastSclDttm(String lastSclDttm) {
		this.lastSclDttm = lastSclDttm;
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
	 * @return the rsrvStrtDt
	 */
	public String getRsrvStrtDt() {
		return rsrvStrtDt;
	}
	/**
	 * @param rsrvStrtDt the rsrvStrtDt to set
	 */
	public void setRsrvStrtDt(String rsrvStrtDt) {
		this.rsrvStrtDt = rsrvStrtDt;
	}
	/**
	 * @return the rsrvEndDt
	 */
	public String getRsrvEndDt() {
		return rsrvEndDt;
	}
	/**
	 * @param rsrvEndDt the rsrvEndDt to set
	 */
	public void setRsrvEndDt(String rsrvEndDt) {
		this.rsrvEndDt = rsrvEndDt;
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
	 * @return the netId
	 */
	public String getNetId() {
		return netId;
	}
	/**
	 * @param netId the netId to set
	 */
	public void setNetId(String netId) {
		this.netId = netId;
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
	 * @return the rsrvCount
	 */
	public Integer getRsrvCount() {
		return rsrvCount;
	}
	/**
	 * @param rsrvCount the rsrvCount to set
	 */
	public void setRsrvCount(Integer rsrvCount) {
		this.rsrvCount = rsrvCount;
	}
	/**
	 * @return the opSclCount
	 */
	/**
	 * @return the opMultiSclCount
	 */
	public Integer getOpMultiSclCount() {
		return opMultiSclCount;
	}
	/**
	 * @param opMultiSclCount the opMultiSclCount to set
	 */
	public void setOpMultiSclCount(Integer opMultiSclCount) {
		this.opMultiSclCount = opMultiSclCount;
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