/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PackgAlrmInfoVo.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 27.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 27.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.vo;

/**
 * @author 이화영
 *
 */
public class PackgAlrmInfoVo {

	private String patchAlrmSeq;
	private String patchAlrmNm;
	private String patchAlrmCn;
	private String patchAlrmDspthId;
	private String patchAlrmDspthNm;
	private String patchAlrmDttm;
	private String ver;
	private String release;
	private String maxVer;
	private String maxRelease;
	private String packgNm;
	private String confrmDt;

	public String getPatchAlrmSeq() {
		return patchAlrmSeq;
	}
	public void setPatchAlrmSeq(String patchAlrmSeq) {
		this.patchAlrmSeq = patchAlrmSeq;
	}
	public String getPatchAlrmNm() {
		return patchAlrmNm;
	}
	public void setPatchAlrmNm(String patchAlrmNm) {
		this.patchAlrmNm = patchAlrmNm;
	}
	public String getPatchAlrmCn() {
		return patchAlrmCn;
	}
	public void setPatchAlrmCn(String patchAlrmCn) {
		this.patchAlrmCn = patchAlrmCn;
	}
	public String getPatchAlrmDspthId() {
		return patchAlrmDspthId;
	}
	public void setPatchAlrmDspthId(String patchAlrmDspthId) {
		this.patchAlrmDspthId = patchAlrmDspthId;
	}
	public String getPatchAlrmDspthNm() {
		return patchAlrmDspthNm;
	}
	public void setPatchAlrmDspthNm(String patchAlrmDspthNm) {
		this.patchAlrmDspthNm = patchAlrmDspthNm;
	}
	public String getPatchAlrmDttm() {
		return patchAlrmDttm;
	}
	public void setPatchAlrmDttm(String patchAlrmDttm) {
		this.patchAlrmDttm = patchAlrmDttm;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public String getMaxVer() {
		return maxVer;
	}
	public void setMaxVer(String maxVer) {
		this.maxVer = maxVer;
	}
	public String getMaxRelease() {
		return maxRelease;
	}
	public void setMaxRelease(String maxRelease) {
		this.maxRelease = maxRelease;
	}
	public String getPackgNm() {
		return packgNm;
	}
	public void setPackgNm(String packgNm) {
		this.packgNm = packgNm;
	}
	public String getConfrmDt() {
		return confrmDt;
	}
	public void setConfrmDt(String confrmDt) {
		this.confrmDt = confrmDt;
	}



}
