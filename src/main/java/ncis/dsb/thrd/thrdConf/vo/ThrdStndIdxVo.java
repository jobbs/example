/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ThrdStndIdxVo.java
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


public class ThrdStndIdxVo {

	private Long profId;
	//@NotEmpty(message="프로파일명을 입력하세요.")
	private String profNm;
	private String dc;

	private Long serverStatContCnt;
	private String serverStatCmprStdr;

	private Long warningStatContCnt;
	private String warningStatCmprStdr;

	private Long criticalCpuUseRtVl;
	private String criticalCpuUseRtCmprStdr;
	private Long criticalCpuUseRtContCnt;

	private Long majorCpuUseRtVl;
	private String majorCpuUseRtCmprStdr;
	private Long majorCpuUseRtContCnt;

	private Long criticalCpuVrlzRtVl;
	private String criticalCpuVrlzRtCmprStdr;
	private Long criticalCpuVrlzRtContCnt;

	private Long majorCpuVrlzRtVl;
	private String majorCpuVrlzRtCmprStdr;
	private Long majorCpuVrlzRtContCnt;

	private Long criticalMemUseRtVl;
	private String criticalMemUseRtCmprStdr;
	private Long criticalMemUseRtContCnt;

	private Long majorMemUseRtVl;
	private String majorMemUseRtCmprStdr;
	private Long majorMemUseRtContCnt;

	private Long criticalMemVrlzRtVl;
	private String criticalMemVrlzRtCmprStdr;
	private Long criticalMemVrlzRtContCnt;

	private Long majorMemVrlzRtVl;
	private String majorMemVrlzRtCmprStdr;
	private Long majorMemVrlzRtContCnt;

	public Long getProfId() {
		return profId;
	}
	public void setProfId(Long profId) {
		this.profId = profId;
	}
	public String getProfNm() {
		return profNm;
	}
	public void setProfNm(String profNm) {
		this.profNm = profNm;
	}
	public String getDc() {
		return dc;
	}
	public void setDc(String dc) {
		this.dc = dc;
	}
	public Long getServerStatContCnt() {
		return serverStatContCnt;
	}
	public void setServerStatContCnt(Long serverStatContCnt) {
		this.serverStatContCnt = serverStatContCnt;
	}
	public Long getWarningStatContCnt() {
		return warningStatContCnt;
	}
	public void setWarningStatContCnt(Long warningStatContCnt) {
		this.warningStatContCnt = warningStatContCnt;
	}
	public Long getCriticalCpuUseRtVl() {
		return criticalCpuUseRtVl;
	}
	public void setCriticalCpuUseRtVl(Long criticalCpuUseRtVl) {
		this.criticalCpuUseRtVl = criticalCpuUseRtVl;
	}
	public String getCriticalCpuUseRtCmprStdr() {
		return criticalCpuUseRtCmprStdr;
	}
	public void setCriticalCpuUseRtCmprStdr(String criticalCpuUseRtCmprStdr) {
		this.criticalCpuUseRtCmprStdr = criticalCpuUseRtCmprStdr;
	}
	public Long getMajorCpuUseRtVl() {
		return majorCpuUseRtVl;
	}
	public void setMajorCpuUseRtVl(Long majorCpuUseRtVl) {
		this.majorCpuUseRtVl = majorCpuUseRtVl;
	}
	public String getMajorCpuUseRtCmprStdr() {
		return majorCpuUseRtCmprStdr;
	}
	public void setMajorCpuUseRtCmprStdr(String majorCpuUseRtCmprStdr) {
		this.majorCpuUseRtCmprStdr = majorCpuUseRtCmprStdr;
	}
	public Long getCriticalCpuVrlzRtVl() {
		return criticalCpuVrlzRtVl;
	}
	public void setCriticalCpuVrlzRtVl(Long criticalCpuVrlzRtVl) {
		this.criticalCpuVrlzRtVl = criticalCpuVrlzRtVl;
	}
	public String getCriticalCpuVrlzRtCmprStdr() {
		return criticalCpuVrlzRtCmprStdr;
	}
	public void setCriticalCpuVrlzRtCmprStdr(String criticalCpuVrlzRtCmprStdr) {
		this.criticalCpuVrlzRtCmprStdr = criticalCpuVrlzRtCmprStdr;
	}
	public Long getMajorCpuVrlzRtVl() {
		return majorCpuVrlzRtVl;
	}
	public void setMajorCpuVrlzRtVl(Long majorCpuVrlzRtVl) {
		this.majorCpuVrlzRtVl = majorCpuVrlzRtVl;
	}
	public String getMajorCpuVrlzRtCmprStdr() {
		return majorCpuVrlzRtCmprStdr;
	}
	public void setMajorCpuVrlzRtCmprStdr(String majorCpuVrlzRtCmprStdr) {
		this.majorCpuVrlzRtCmprStdr = majorCpuVrlzRtCmprStdr;
	}
	public String getCriticalMemUseRtCmprStdr() {
		return criticalMemUseRtCmprStdr;
	}
	public void setCriticalMemUseRtCmprStdr(String criticalMemUseRtCmprStdr) {
		this.criticalMemUseRtCmprStdr = criticalMemUseRtCmprStdr;
	}
	public Long getMajorMemUseRtVl() {
		return majorMemUseRtVl;
	}
	public void setMajorMemUseRtVl(Long majorMemUseRtVl) {
		this.majorMemUseRtVl = majorMemUseRtVl;
	}
	public String getMajorMemUseRtCmprStdr() {
		return majorMemUseRtCmprStdr;
	}
	public void setMajorMemUseRtCmprStdr(String majorMemUseRtCmprStdr) {
		this.majorMemUseRtCmprStdr = majorMemUseRtCmprStdr;
	}
	public Long getCriticalMemVrlzRtVl() {
		return criticalMemVrlzRtVl;
	}
	public void setCriticalMemVrlzRtVl(Long criticalMemVrlzRtVl) {
		this.criticalMemVrlzRtVl = criticalMemVrlzRtVl;
	}
	public String getCriticalMemVrlzRtCmprStdr() {
		return criticalMemVrlzRtCmprStdr;
	}
	public void setCriticalMemVrlzRtCmprStdr(String criticalMemVrlzRtCmprStdr) {
		this.criticalMemVrlzRtCmprStdr = criticalMemVrlzRtCmprStdr;
	}
	public Long getMajorMemVrlzRtVl() {
		return majorMemVrlzRtVl;
	}
	public void setMajorMemVrlzRtVl(Long majorMemVrlzRtVl) {
		this.majorMemVrlzRtVl = majorMemVrlzRtVl;
	}
	public String getMajorMemVrlzRtCmprStdr() {
		return majorMemVrlzRtCmprStdr;
	}
	public void setMajorMemVrlzRtCmprStdr(String majorMemVrlzRtCmprStdr) {
		this.majorMemVrlzRtCmprStdr = majorMemVrlzRtCmprStdr;
	}
	public Long getCriticalMemUseRtVl() {
		return criticalMemUseRtVl;
	}
	public void setCriticalMemUseRtVl(Long criticalMemUseRtVl) {
		this.criticalMemUseRtVl = criticalMemUseRtVl;
	}
	public String getServerStatCmprStdr() {
		return serverStatCmprStdr;
	}
	public void setServerStatCmprStdr(String serverStatCmprStdr) {
		this.serverStatCmprStdr = serverStatCmprStdr;
	}
	public String getWarningStatCmprStdr() {
		return warningStatCmprStdr;
	}
	public void setWarningStatCmprStdr(String warningStatCmprStdr) {
		this.warningStatCmprStdr = warningStatCmprStdr;
	}
	public Long getCriticalCpuUseRtContCnt() {
		return criticalCpuUseRtContCnt;
	}
	public void setCriticalCpuUseRtContCnt(Long criticalCpuUseRtContCnt) {
		this.criticalCpuUseRtContCnt = criticalCpuUseRtContCnt;
	}
	public Long getMajorCpuUseRtContCnt() {
		return majorCpuUseRtContCnt;
	}
	public void setMajorCpuUseRtContCnt(Long majorCpuUseRtContCnt) {
		this.majorCpuUseRtContCnt = majorCpuUseRtContCnt;
	}
	public Long getCriticalCpuVrlzRtContCnt() {
		return criticalCpuVrlzRtContCnt;
	}
	public void setCriticalCpuVrlzRtContCnt(Long criticalCpuVrlzRtContCnt) {
		this.criticalCpuVrlzRtContCnt = criticalCpuVrlzRtContCnt;
	}
	public Long getMajorCpuVrlzRtContCnt() {
		return majorCpuVrlzRtContCnt;
	}
	public void setMajorCpuVrlzRtContCnt(Long majorCpuVrlzRtContCnt) {
		this.majorCpuVrlzRtContCnt = majorCpuVrlzRtContCnt;
	}
	public Long getCriticalMemUseRtContCnt() {
		return criticalMemUseRtContCnt;
	}
	public void setCriticalMemUseRtContCnt(Long criticalMemUseRtContCnt) {
		this.criticalMemUseRtContCnt = criticalMemUseRtContCnt;
	}
	public Long getMajorMemUseRtContCnt() {
		return majorMemUseRtContCnt;
	}
	public void setMajorMemUseRtContCnt(Long majorMemUseRtContCnt) {
		this.majorMemUseRtContCnt = majorMemUseRtContCnt;
	}
	public Long getCriticalMemVrlzRtContCnt() {
		return criticalMemVrlzRtContCnt;
	}
	public void setCriticalMemVrlzRtContCnt(Long criticalMemVrlzRtContCnt) {
		this.criticalMemVrlzRtContCnt = criticalMemVrlzRtContCnt;
	}
	public Long getMajorMemVrlzRtContCnt() {
		return majorMemVrlzRtContCnt;
	}
	public void setMajorMemVrlzRtContCnt(Long majorMemVrlzRtContCnt) {
		this.majorMemVrlzRtContCnt = majorMemVrlzRtContCnt;
	}

}
