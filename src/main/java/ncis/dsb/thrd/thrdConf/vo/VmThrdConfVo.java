/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmThrdConfVo.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   김동훈         v1.0             최초생성
 *
 */
package ncis.dsb.thrd.thrdConf.vo;

public class VmThrdConfVo extends ThrdStndIdxVo {


	private String path;
	private String vmNm;
	private String vmId;
	private Long vmSeq;
	private String vmCompId;
	//private String zone;
	private String trgtSrvrClCd;
	private Long thresTrgtSrvrSeq;

	private String userNm;
	private int userCnt;
	private String grdNm;

	private String institutionId;
	private String jobId;

	private String gubun;
	private String searchUserId;

	/// 임계치 대상서버
    // 지표항목ID
    private String idxItmId;
    // 임계등급 ID
    private String thresGrdId;
    // 대상서버구분코드
    // 임계치설정값
    private Long thresConfVl;
    // 설정비교기준
    private String confCmprStdr;
    // 설정연속횟수
    private Long confContCnt;
    // 설정시간(범위)
    private String confTime;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getVmNm() {
		return vmNm;
	}
	public void setVmNm(String vmNm) {
		this.vmNm = vmNm;
	}
	public String getVmId() {
		return vmId;
	}
	public void setVmId(String vmId) {
		this.vmId = vmId;
	}
	public Long getVmSeq() {
		return vmSeq;
	}
	public void setVmSeq(Long vmSeq) {
		this.vmSeq = vmSeq;
	}
	public String getTrgtSrvrClCd() {
		return trgtSrvrClCd;
	}
	public void setTrgtSrvrClCd(String trgtSrvrClCd) {
		this.trgtSrvrClCd = trgtSrvrClCd;
	}
	public Long getThresTrgtSrvrSeq() {
		return thresTrgtSrvrSeq;
	}
	public void setThresTrgtSrvrSeq(Long thresTrgtSrvrSeq) {
		this.thresTrgtSrvrSeq = thresTrgtSrvrSeq;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public int getUserCnt() {
		return userCnt;
	}
	public void setUserCnt(int userCnt) {
		this.userCnt = userCnt;
	}
	public String getGrdNm() {
		return grdNm;
	}
	public void setGrdNm(String grdNm) {
		this.grdNm = grdNm;
	}
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public String getSearchUserId() {
		return searchUserId;
	}
	public void setSearchUserId(String searchUserId) {
		this.searchUserId = searchUserId;
	}
	public String getIdxItmId() {
		return idxItmId;
	}
	public void setIdxItmId(String idxItmId) {
		this.idxItmId = idxItmId;
	}
	public String getThresGrdId() {
		return thresGrdId;
	}
	public void setThresGrdId(String thresGrdId) {
		this.thresGrdId = thresGrdId;
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
	public String getVmCompId() {
		return vmCompId;
	}
	public void setVmCompId(String vmCompId) {
		this.vmCompId = vmCompId;
	}


}
