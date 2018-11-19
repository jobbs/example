/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PackgInfoVo.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 14.
 * @lastmodified 2016. 10. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 14.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.vo;

import ncis.cmn.entity.OaPackg;

/**
 * @author 이화영
 *
 */
public class PackgInfoVo extends OaPackg {

	private String packgSeq;
	private String regionNm;
	private String netNm;
	private String repositNm;
	private String ver;
	private String release;
	private String fileSize;
	private String regDttm;
	private String packgCn;
	private String regDt;

	public String getPackgSeq() {
		return packgSeq;
	}
	public void setPackgSeq(String packgSeq) {
		this.packgSeq = packgSeq;
	}
	public String getRegionNm() {
		return regionNm;
	}
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}
	public String getNetNm() {
		return netNm;
	}
	public void setNetNm(String netNm) {
		this.netNm = netNm;
	}
	public String getRepositNm() {
		return repositNm;
	}
	public void setRepositNm(String repositNm) {
		this.repositNm = repositNm;
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
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getRegDttm() {
		return regDttm;
	}
	public void setRegDttm(String regDttm) {
		this.regDttm = regDttm;
	}
	public String getPackgCn() {
		return packgCn;
	}
	public void setPackgCn(String packgCn) {
		this.packgCn = packgCn;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}



}
