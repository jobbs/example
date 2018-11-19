/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SpecVo.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.vo;

import ncis.cmn.entity.RxImg;


/**
 * @author x
 *
 */
public class BaseImgVo extends RxImg {

	private String imgTyCdNm;  /* 이미지유형코드명 */
	private String creUserNm;  /* 생성자 */
	private String updtUserNm;  /* 수정자 */
	private String regionId; /* 리전ID */
    private String zoneId; /* 존ID */
    private String netClCd; /* 망구분코드 */
    private String regionNm; /* 리전명 */
    private String zoneNm; /* 존명 */
    private String netNm; /* 망명 */
    private String rsrcPoolNm; /* 자원풀명 */
    private Integer port;  /* 포트 */
    private String prtcl;  /* 프로토콜 */
    private String portInfo; /* 포트정보 */
    private String servcAreaId; /* 서비스영역ID */
    private String baseImgRsrcPoolId;  /* 베이스이미지자원풀ID */
    private Integer servcAreaSeq;  /* 서비스영역SEQ */

	/**
	 * @return the imgTyCdNm
	 */
	public String getImgTyCdNm() {
		return imgTyCdNm;
	}
	/**
	 * @param imgTyCdNm the imgTyCdNm to set
	 */
	public void setImgTyCdNm(String imgTyCdNm) {
		this.imgTyCdNm = imgTyCdNm;
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
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}
	/**
	 * @return the prtcl
	 */
	public String getPrtcl() {
		return prtcl;
	}
	/**
	 * @param prtcl the prtcl to set
	 */
	public void setPrtcl(String prtcl) {
		this.prtcl = prtcl;
	}
	/**
	 * @return the portInfo
	 */
	public String getPortInfo() {
		return portInfo;
	}
	/**
	 * @param portInfo the portInfo to set
	 */
	public void setPortInfo(String portInfo) {
		this.portInfo = portInfo;
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
	/**
	 * @return the baseImgRsrcPoolId
	 */
	public String getBaseImgRsrcPoolId() {
		return baseImgRsrcPoolId;
	}
	/**
	 * @param baseImgRsrcPoolId the baseImgRsrcPoolId to set
	 */
	public void setBaseImgRsrcPoolId(String baseImgRsrcPoolId) {
		this.baseImgRsrcPoolId = baseImgRsrcPoolId;
	}
	/**
	 * @return the servcAreaSeq
	 */
	public Integer getServcAreaSeq() {
		return servcAreaSeq;
	}
	/**
	 * @param servcAreaSeq the servcAreaSeq to set
	 */
	public void setServcAreaSeq(Integer servcAreaSeq) {
		this.servcAreaSeq = servcAreaSeq;
	}

}
