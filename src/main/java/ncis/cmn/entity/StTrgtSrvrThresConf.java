package ncis.cmn.entity;

public class StTrgtSrvrThresConf {
    // 임계치 대상서버
    private Long thresTrgtSrvrSeq;
    // 지표항목ID
    private Long idxItmId;
    // 임계등급 ID
    private String thresGrdId;
    // 대상서버구분코드
    private String trgtSrvrClCd;
    // 임계치설정값
    private Long thresConfVl;
    // 설정비교기준
    private String confCmprStdr;
    // 설정연속횟수
    private Long confContCnt;
    // 설정시간(범위)
    private String confTime;
	public Long getThresTrgtSrvrSeq() {
		return thresTrgtSrvrSeq;
	}
	public void setThresTrgtSrvrSeq(Long thresTrgtSrvrSeq) {
		this.thresTrgtSrvrSeq = thresTrgtSrvrSeq;
	}
	public Long getIdxItmId() {
		return idxItmId;
	}
	public void setIdxItmId(Long idxItmId) {
		this.idxItmId = idxItmId;
	}
	public String getThresGrdId() {
		return thresGrdId;
	}
	public void setThresGrdId(String thresGrdId) {
		this.thresGrdId = thresGrdId;
	}
	public String getTrgtSrvrClCd() {
		return trgtSrvrClCd;
	}
	public void setTrgtSrvrClCd(String trgtSrvrClCd) {
		this.trgtSrvrClCd = trgtSrvrClCd;
	}
	public Long getThresConfVl() {
		return thresConfVl;
	}
	public void setThresConfVl(Long thresConfVl) {
		this.thresConfVl = thresConfVl;
	}
	public String getConfCmprStdr() {
		return confCmprStdr;
	}
	public void setConfCmprStdr(String confCmprStdr) {
		this.confCmprStdr = confCmprStdr;
	}
	public Long getConfContCnt() {
		return confContCnt;
	}
	public void setConfContCnt(Long confContCnt) {
		this.confContCnt = confContCnt;
	}
	public String getConfTime() {
		return confTime;
	}
	public void setConfTime(String confTime) {
		this.confTime = confTime;
	}



}
