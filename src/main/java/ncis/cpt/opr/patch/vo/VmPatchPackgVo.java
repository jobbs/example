/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmPatchPackg.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.vo;


/**
 * @author 이화영
 *
 */
public class VmPatchPackgVo {

	private String packgNm;
	private String ver;
	private String instlDt;
	private String release;
	private String lastVer;
	private String lastRelease;
	private String repositNm;
	private String updateYn;

	public String getPackgNm() {
		return packgNm;
	}
	public void setPackgNm(String packgNm) {
		this.packgNm = packgNm;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public String getInstlDt() {
		return instlDt;
	}
	public void setInstlDt(String instlDt) {
		this.instlDt = instlDt;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public String getLastVer() {
		return lastVer;
	}
	public void setLastVer(String lastVer) {
		this.lastVer = lastVer;
	}
	public String getLastRelease() {
		return lastRelease;
	}
	public void setLastRelease(String lastRelease) {
		this.lastRelease = lastRelease;
	}
	public String getRepositNm() {
		return repositNm;
	}
	public void setRepositNm(String repositNm) {
		this.repositNm = repositNm;
	}
	public String getUpdateYn() {
		return updateYn;
	}
	public void setUpdateYn(String updateYn) {
		this.updateYn = updateYn;
	}


}
