package ncis.cmn.entity;

public class RxRsrvSclng  {

    private Integer servcSeq;  /* 서비스SEQ */
    private String scalrId;  /* 스케일러ID */
    private String sclngClCd;  /* 스케일링구분코드 */
    private String scalrNm;  /* 스케일러명 */
    private Integer nowPodQty;  /* 현재POD수 */
    private Integer minPodQty;  /* 최소POD수 */
    private Integer maxPodQty;  /* 최대POD수 */
    private String useYn;  /* 사용여부 */
    private String creDttm;  /* 생성일시 */
    private String updtDttm;  /* 수정일시 */
    private String creUserId;  /* 생성자ID */
    private String updtUserId;  /* 수정자ID */
    private String rsrvStrtDt;  /* 예약시작일자 */
    private String rsrvEndDt;  /* 예약종료일자 */
    private String servcNm; /*서미스명*/
    private String imgId; /*배포 이미지ID*/
    private String imgNm; /*배포 이미지ID*/
    private String creUserNm;  /* 생성자명 */
    private String updtUserNm;  /* 수정자명 */
    private String strtThresVl; //시작임계치값
    private String endThresVl; //종료임계치값
    private String thresClCd; //임계치구분코드
    private String sclGrpCd; //스케일그룹코드
    private String alarmYn; //알림여부
    private String sclConfCndClCd; // 스케일설정조건구분코드
    private String servcId;
    private String servcAreaId;
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
	 * @return the servcAreaId
	 */
	public String getServcAreaId() {
		return servcAreaId;
	}
	/**
	 * @param servcAreaId the servcAreaId to set
	 */
	public void setServcAreaId(String servcAreaId) {
		this.servcAreaId = servcAreaId;
	}





}