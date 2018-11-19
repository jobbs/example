/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ResultVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.cmm.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author ShinKeeBong
 * @param <T>
 *
 */
@JsonInclude(Include.NON_NULL)
public class ResultVO<T> {

	private String resultCode;    /* 결과 코드   */
	private Integer resultCnt;    /* 결과 개수   */
	private String message;       /* 결과 메시지 */
	private String gatherDate;     /* 수집시간      */

	private List<T> zoneInfos;         /* 결과 데이터 List */
	private List<T> clusterInfos;         /* 결과 데이터 List */
	private List<T> pmInfos;         /* 결과 데이터 List */
	private List<T> vmInfos;         /* 결과 데이터 List */
	private List<T> templateInfos;         /* 결과 데이터 List */
	private List<T> swInfos;         /* 결과 데이터 List */
	private List<T> swTemplateInfos;         /* 결과 데이터 List */
	private List<T> specInfos;         /* 결과 데이터 List */
	private List<T> codeInfos;         /* 결과 데이터 List */
	private List<T> applInfos;         /* 결과 데이터 List */
	private List<T> servcNsInfos;      /* 결과 데이터 List */
	private List<T> servcInfos;        /* 결과 데이터 List */
	private List<T> baseImgInfos;      /* 결과 데이터 List */
	private List<T> bldConfInfos;      /* 결과 데이터 List */
	private List<T> distrbConfInfos;      /* 결과 데이터 List */
	private List<T> sclngThresConfInfos;      /* 결과 데이터 List */


	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public Integer getResultCnt() {
		return resultCnt;
	}
	public void setResultCnt(Integer resultCnt) {
		this.resultCnt = resultCnt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the gatherDate
	 */
	public String getGatherDate() {
		return gatherDate;
	}
	/**
	 * @param gatherDate the gatherDate to set
	 */
	public void setGatherDate(String gatherDate) {
		this.gatherDate = gatherDate;
	}
	/**
	 * @return the zoneInfos
	 */
	public List<T> getZoneInfos() {
		return zoneInfos;
	}
	/**
	 * @param zoneInfos the zoneInfos to set
	 */
	public void setZoneInfos(List<T> zoneInfos) {
		this.zoneInfos = zoneInfos;
	}
	/**
	 * @return the clusterInfos
	 */
	public List<T> getClusterInfos() {
		return clusterInfos;
	}
	/**
	 * @param clusterInfos the clusterInfos to set
	 */
	public void setClusterInfos(List<T> clusterInfos) {
		this.clusterInfos = clusterInfos;
	}
	/**
	 * @return the vmInfos
	 */
	public List<T> getVmInfos() {
		return vmInfos;
	}
	/**
	 * @param vmInfos the vmInfos to set
	 */
	public void setVmInfos(List<T> vmInfos) {
		this.vmInfos = vmInfos;
	}
	/**
	 * @return the templateInfos
	 */
	public List<T> getTemplateInfos() {
		return templateInfos;
	}
	/**
	 * @param templateInfos the templateInfos to set
	 */
	public void setTemplateInfos(List<T> templateInfos) {
		this.templateInfos = templateInfos;
	}
	/**
	 * @return the pmInfos
	 */
	public List<T> getPmInfos() {
		return pmInfos;
	}
	/**
	 * @param pmInfos the pmInfos to set
	 */
	public void setPmInfos(List<T> pmInfos) {
		this.pmInfos = pmInfos;
	}
	/**
	 * @return the swInfos
	 */
	public List<T> getSwInfos() {
		return swInfos;
	}
	/**
	 * @param swInfos the swInfos to set
	 */
	public void setSwInfos(List<T> swInfos) {
		this.swInfos = swInfos;
	}
	/**
	 * @return the swTemplateInfos
	 */
	public List<T> getSwTemplateInfos() {
		return swTemplateInfos;
	}
	/**
	 * @param swTemplateInfos the swTemplateInfos to set
	 */
	public void setSwTemplateInfos(List<T> swTemplateInfos) {
		this.swTemplateInfos = swTemplateInfos;
	}
	/**
	 * @return the specInfos
	 */
	public List<T> getSpecInfos() {
		return specInfos;
	}
	/**
	 * @param specInfos the specInfos to set
	 */
	public void setSpecInfos(List<T> specInfos) {
		this.specInfos = specInfos;
	}
	/**
	 * @return the codeInfos
	 */
	public List<T> getCodeInfos() {
		return codeInfos;
	}
	/**
	 * @param codeInfos the codeInfos to set
	 */
	public void setCodeInfos(List<T> codeInfos) {
		this.codeInfos = codeInfos;
	}
	/**
	 * @return the applInfos
	 */
	public List<T> getApplInfos() {
		return applInfos;
	}
	/**
	 * @param applInfos the applInfos to set
	 */
	public void setApplInfos(List<T> applInfos) {
		this.applInfos = applInfos;
	}
	/**
	 * @return the servcNsInfos
	 */
	public List<T> getServcNsInfos() {
	    return servcNsInfos;
	}
	/**
	 * @param servcNsInfos the servcNsInfos to set
	 */
	public void setServcNsInfos(List<T> servcNsInfos) {
	    this.servcNsInfos = servcNsInfos;
	}
	/**
	 * @return the servcInfos
	 */
	public List<T> getServcInfos() {
	    return servcInfos;
	}
	/**
	 * @param servcInfos the servcInfos to set
	 */
	public void setServcInfos(List<T> servcInfos) {
	    this.servcInfos = servcInfos;
	}
	/**
	 * @return the baseImgInfos
	 */
	public List<T> getBaseImgInfos() {
	    return baseImgInfos;
	}
	/**
	 * @param baseImgInfos the baseImgInfos to set
	 */
	public void setBaseImgInfos(List<T> baseImgInfos) {
	    this.baseImgInfos = baseImgInfos;
	}
	/**
	 * @return the bldConfInfos
	 */
	public List<T> getBldConfInfos() {
	    return bldConfInfos;
	}
	/**
	 * @param bldConfInfos the bldConfInfos to set
	 */
	public void setBldConfInfos(List<T> bldConfInfos) {
	    this.bldConfInfos = bldConfInfos;
	}

	/**
	 * @return the distrbConfInfos
	 */
	public List<T> getDistrbConfInfos() {
	    return distrbConfInfos;
	}
	/**
	 * @param distrbConfInfos the distrbConfInfos to set
	 */
	public void setDistrbConfInfos(List<T> distrbConfInfos) {
	    this.distrbConfInfos = distrbConfInfos;
	}

	/**
	 * @return the sclngThresConfInfos
	 */
	public List<T> getSclngThresConfInfos() {
	    return sclngThresConfInfos;
	}
	/**
	 * @param sclngThresConfInfos the sclngThresConfInfos to set
	 */
	public void setSclngThresConfInfos(List<T> sclngThresConfInfos) {
	    this.sclngThresConfInfos = sclngThresConfInfos;
	}


}
