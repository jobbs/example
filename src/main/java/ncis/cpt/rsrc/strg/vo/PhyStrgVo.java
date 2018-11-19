/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PStrgVo.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.vo;

import ncis.cmn.entity.RsPStrgComm;

/**
 * 물리스토리지 Vo
 * @author 김봉민
 *
 */
public class PhyStrgVo extends RsPStrgComm{

	private String regionNm;		/* 센터 명*/
	private String zoneId;			/* 존 명 */
	private String zoneNm;			/* 존 명 */
	private String netId;			/* 망 명 */
	private String netNm;			/* 망 명 */
	private String compClNm;		/* 구성 구분 명 */
	private String rsrcPoolNm;		/* 클러스터 명 */

	private String vrlzSwTyCd;		/* 가상화 SW 코드 */
	private String vrlzSwTyNm;		/* 가상화 SW 코드 */
	private String oprStatNm;		/* 운영상태코드 명 */
	private String oprChargerNm;	/* 운영자 명  */
	private String institutionNm;	/* 부처 명 */

	private String delUserNm;		/* 삭제자 명 */
    private String mnfctCoNm;		/* 제조사명 */

    private String strgTyCd;		/* 스토리지유형코드  */
    private String strgTyNm;		/* 스토리지유형코드 명 */

    private String netClCd; 	/* 망구분 코드 */
    private String netClNm; 	/* 망구분 코드 명*/

	public String getRegionNm() {
		return regionNm;
	}
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}
	public String getZoneNm() {
		return zoneNm;
	}
	public void setZoneNm(String zoneNm) {
		this.zoneNm = zoneNm;
	}
	public String getNetNm() {
		return netNm;
	}
	public void setNetNm(String netNm) {
		this.netNm = netNm;
	}
	public String getCompClNm() {
		return compClNm;
	}
	public void setCompClNm(String compClNm) {
		this.compClNm = compClNm;
	}
	public String getRsrcPoolNm() {
		return rsrcPoolNm;
	}
	public void setRsrcPoolNm(String rsrcPoolNm) {
		this.rsrcPoolNm = rsrcPoolNm;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public String getNetId() {
		return netId;
	}
	public void setNetId(String netId) {
		this.netId = netId;
	}
	public String getVrlzSwTyCd() {
		return vrlzSwTyCd;
	}
	public void setVrlzSwTyCd(String vrlzSwTyCd) {
		this.vrlzSwTyCd = vrlzSwTyCd;
	}
	public String getVrlzSwTyNm() {
		return vrlzSwTyNm;
	}
	public void setVrlzSwTyNm(String vrlzSwTyNm) {
		this.vrlzSwTyNm = vrlzSwTyNm;
	}
	public String getOprStatNm() {
		return oprStatNm;
	}
	public void setOprStatNm(String oprStatNm) {
		this.oprStatNm = oprStatNm;
	}
	public String getOprChargerNm() {
		return oprChargerNm;
	}
	public void setOprChargerNm(String oprChargerNm) {
		this.oprChargerNm = oprChargerNm;
	}
	public String getInstitutionNm() {
		return institutionNm;
	}
	public void setInstitutionNm(String institutionNm) {
		this.institutionNm = institutionNm;
	}
	public String getDelUserNm() {
		return delUserNm;
	}
	public void setDelUserNm(String delUserNm) {
		this.delUserNm = delUserNm;
	}
	public String getMnfctCoNm() {
		return mnfctCoNm;
	}
	public void setMnfctCoNm(String mnfctCoNm) {
		this.mnfctCoNm = mnfctCoNm;
	}
	public String getStrgTyCd() {
		return strgTyCd;
	}
	public void setStrgTyCd(String strgTyCd) {
		this.strgTyCd = strgTyCd;
	}
	public String getStrgTyNm() {
		return strgTyNm;
	}
	public void setStrgTyNm(String strgTyNm) {
		this.strgTyNm = strgTyNm;
	}
	public String getNetClCd() {
		return netClCd;
	}
	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}
	public String getNetClNm() {
		return netClNm;
	}
	public void setNetClNm(String netClNm) {
		this.netClNm = netClNm;
	}
}
