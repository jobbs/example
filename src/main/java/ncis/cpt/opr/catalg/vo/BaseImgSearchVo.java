/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SwSearchVo.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2017. 1. 16.
 * @lastmodified 2017. 1. 16.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 1. 16.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author x
 *
 */
public class BaseImgSearchVo extends CommonSearchVo {

	private String imgTyCd;  /* 이미지유형코드 */
    private String imgNm;  /* 이미지명 */
    private String useYn;  /* 사용여부 */
    private String rsrcPoolId;  /* 자원풀ID */
    private String imgId;  /* 이미지ID */
    private String basImgYn;  /* 베이스이미지여부 */
    private String regionId; /* 리전ID */
    private String zoneId; /* 존ID */
    private String netClCd; /* 망구분코드 */

    
	/**
	 * @return the imgTyCd
	 */
	public String getImgTyCd() {
		return imgTyCd;
	}
	/**
	 * @param imgTyCd the imgTyCd to set
	 */
	public void setImgTyCd(String imgTyCd) {
		this.imgTyCd = imgTyCd;
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
	 * @return the basImgYn
	 */
	public String getBasImgYn() {
		return basImgYn;
	}
	/**
	 * @param basImgYn the basImgYn to set
	 */
	public void setBasImgYn(String basImgYn) {
		this.basImgYn = basImgYn;
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
	
}
