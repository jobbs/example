/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RemoveClusterVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 9. 21.
 * @lastmodified 2016. 9. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 21.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.request.vo;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author wisecom
 *
 */
public class CreateVmVmInfoVO {

	@ApiModelProperty(value = "가상서버구성ID", required = true)
	private String vmConfId;     /* 가상서버구성ID   */
	@ApiModelProperty(value = "망구분코드", required = false)
	private String networkCode;	/*망구분코드*/
	@ApiModelProperty(value = "용도코드", required = false)
	private String purposeCode;	/*용도코드*/
	@ApiModelProperty(value = "용도코드", required = false)
	private String osCode;	/*	OS용도코드*/
	@ApiModelProperty(value = "부처", required = false)
	private String custId;	/*	부처*/
	@ApiModelProperty(value = "업무", required = false)
	private String applId;	/*	업무*/
	@ApiModelProperty(value = "호스트명", required = false)
	private String hostNm;	/*	호스트명*/
	@ApiModelProperty(value = "운영담당자ID(정)", required = false)
	private String opr1UserId;	/*	운영담당자ID(정)*/
	@ApiModelProperty(value = "운영사업자(정)", required = false)
	private String oprMainId;	/*	운영사업자(정)*/
	@ApiModelProperty(value = "가상서버명", required = false)
	private String vmName;	/*	가상서버명*/
	@ApiModelProperty(value = "임대시작날짜", required = false)
	private String leaseStartDate;	/*	임대시작날짜*/
	@ApiModelProperty(value = "임대만료날짜", required = false)
	private String leaseExpiredDate;	/*	임대만료날짜*/
	@ApiModelProperty(value = "템플릿ID", required = false)
	private BigDecimal templateId;	/*	템플릿ID*/
	@ApiModelProperty(value = "템플릿 SW ID", required = false)
	private BigDecimal templateSwId;	/*	템플릿 SW ID*/
	@ApiModelProperty(value = "스펙ID", required = false)
	private BigDecimal instanceTypeId;	/*	스펙ID*/
	@ApiModelProperty(value = "가상코어수", required = false)
	private BigDecimal vcore;	/*	가상코어수*/
	@ApiModelProperty(value = "메모리", required = false)
	private BigDecimal memory;	/*	메모리*/
	@ApiModelProperty(value = "추가디스크용량", required = false)
	private BigDecimal diskSize;	/*	추가디스크용량*/
	@ApiModelProperty(value = "추가 디스크 공유여부", required = false)
	private String isShare;	/*	추가 디스크 공유여부*/
	
	@ApiModelProperty(value = "가상서버 IP할당 요청정보", required = true)
	private List<IpInfoVO> ipInfos; /*가상서버 IP할당 요청정보*/
	
	@ApiModelProperty(value = "HA구성여부", required = true)
	private String isHa;	/*HA구성여부*/
	@ApiModelProperty(value = "HA상태", required = true)
	private String haState;	/*HA상태*/
	@ApiModelProperty(value = "HA그룹코드", required = true)
	private String haGroupId;	/*HA그룹코드*/
	@ApiModelProperty(value = "HA그룹코드명", required = true)
	private String haGroupNm;	/*HA그룹코드명*/
	@ApiModelProperty(value = "HA스토리지용량", required = true)
	private BigDecimal haStorageSize;	/*HA스토리지용량*/
	@ApiModelProperty(value = "HA호스트명", required = true)
	private String haHostNm;	/*HA호스트명*/
	@ApiModelProperty(value = "HA가상서버명", required = true)
	private String haVmName;	/*HA가상서버명*/

	/**
	 * @return the vmConfId
	 */
	public String getVmConfId() {
		return vmConfId;
	}

	/**
	 * @param vmConfId the vmConfId to set
	 */
	public void setVmConfId(String vmConfId) {
		this.vmConfId = vmConfId;
	}

	/**
	 * @return the networkCode
	 */
	public String getNetworkCode() {
		return networkCode;
	}

	/**
	 * @param networkCode the networkCode to set
	 */
	public void setNetworkCode(String networkCode) {
		this.networkCode = networkCode;
	}

	/**
	 * @return the purposeCode
	 */
	public String getPurposeCode() {
		return purposeCode;
	}

	/**
	 * @param purposeCode the purposeCode to set
	 */
	public void setPurposeCode(String purposeCode) {
		this.purposeCode = purposeCode;
	}

	/**
	 * @return the osCode
	 */
	public String getOsCode() {
		return osCode;
	}

	/**
	 * @param osCode the osCode to set
	 */
	public void setOsCode(String osCode) {
		this.osCode = osCode;
	}

	/**
	 * @return the custId
	 */
	public String getCustId() {
		return custId;
	}

	/**
	 * @param custId the custId to set
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}

	/**
	 * @return the applId
	 */
	public String getApplId() {
		return applId;
	}

	/**
	 * @param applId the applId to set
	 */
	public void setApplId(String applId) {
		this.applId = applId;
	}

	/**
	 * @return the hostNm
	 */
	public String getHostNm() {
		return hostNm;
	}

	/**
	 * @param hostNm the hostNm to set
	 */
	public void setHostNm(String hostNm) {
		this.hostNm = hostNm;
	}

	/**
	 * @return the opr1UserId
	 */
	public String getOpr1UserId() {
		return opr1UserId;
	}

	/**
	 * @param opr1UserId the opr1UserId to set
	 */
	public void setOpr1UserId(String opr1UserId) {
		this.opr1UserId = opr1UserId;
	}

	/**
	 * @return the oprMainId
	 */
	public String getOprMainId() {
		return oprMainId;
	}

	/**
	 * @param oprMainId the oprMainId to set
	 */
	public void setOprMainId(String oprMainId) {
		this.oprMainId = oprMainId;
	}

	/**
	 * @return the vmName
	 */
	public String getVmName() {
		return vmName;
	}

	/**
	 * @param vmName the vmName to set
	 */
	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

	/**
	 * @return the leaseStartDate
	 */
	public String getLeaseStartDate() {
		return leaseStartDate;
	}

	/**
	 * @param leaseStartDate the leaseStartDate to set
	 */
	public void setLeaseStartDate(String leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}

	/**
	 * @return the leaseExpiredDate
	 */
	public String getLeaseExpiredDate() {
		return leaseExpiredDate;
	}

	/**
	 * @param leaseExpiredDate the leaseExpiredDate to set
	 */
	public void setLeaseExpiredDate(String leaseExpiredDate) {
		this.leaseExpiredDate = leaseExpiredDate;
	}

	/**
	 * @return the templateId
	 */
	public BigDecimal getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(BigDecimal templateId) {
		this.templateId = templateId;
	}

	/**
	 * @return the templateSwId
	 */
	public BigDecimal getTemplateSwId() {
		return templateSwId;
	}

	/**
	 * @param templateSwId the templateSwId to set
	 */
	public void setTemplateSwId(BigDecimal templateSwId) {
		this.templateSwId = templateSwId;
	}

	/**
	 * @return the instanceTypeId
	 */
	public BigDecimal getInstanceTypeId() {
		return instanceTypeId;
	}

	/**
	 * @param instanceTypeId the instanceTypeId to set
	 */
	public void setInstanceTypeId(BigDecimal instanceTypeId) {
		this.instanceTypeId = instanceTypeId;
	}

	/**
	 * @return the vcore
	 */
	public BigDecimal getVcore() {
		return vcore;
	}

	/**
	 * @param vcore the vcore to set
	 */
	public void setVcore(BigDecimal vcore) {
		this.vcore = vcore;
	}

	/**
	 * @return the memory
	 */
	public BigDecimal getMemory() {
		return memory;
	}

	/**
	 * @param memory the memory to set
	 */
	public void setMemory(BigDecimal memory) {
		this.memory = memory;
	}

	/**
	 * @return the diskSize
	 */
	public BigDecimal getDiskSize() {
		return diskSize;
	}

	/**
	 * @param diskSize the diskSize to set
	 */
	public void setDiskSize(BigDecimal diskSize) {
		this.diskSize = diskSize;
	}

	/**
	 * @return the isShare
	 */
	public String getIsShare() {
		return isShare;
	}

	/**
	 * @param isShare the isShare to set
	 */
	public void setIsShare(String isShare) {
		this.isShare = isShare;
	}

	/**
	 * @return the ipInfos
	 */
	public List<IpInfoVO> getIpInfos() {
		return ipInfos;
	}

	/**
	 * @param ipInfos the ipInfos to set
	 */
	public void setIpInfos(List<IpInfoVO> ipInfos) {
		this.ipInfos = ipInfos;
	}

	/**
	 * @return the isHa
	 */
	public String getIsHa() {
		return isHa;
	}

	/**
	 * @param isHa the isHa to set
	 */
	public void setIsHa(String isHa) {
		this.isHa = isHa;
	}

	/**
	 * @return the haState
	 */
	public String getHaState() {
		return haState;
	}

	/**
	 * @param haState the haState to set
	 */
	public void setHaState(String haState) {
		this.haState = haState;
	}

	/**
	 * @return the haGroupId
	 */
	public String getHaGroupId() {
		return haGroupId;
	}

	/**
	 * @param haGroupId the haGroupId to set
	 */
	public void setHaGroupId(String haGroupId) {
		this.haGroupId = haGroupId;
	}

	/**
	 * @return the haGroupNm
	 */
	public String getHaGroupNm() {
		return haGroupNm;
	}

	/**
	 * @param haGroupNm the haGroupNm to set
	 */
	public void setHaGroupNm(String haGroupNm) {
		this.haGroupNm = haGroupNm;
	}

	/**
	 * @return the haStorageSize
	 */
	public BigDecimal getHaStorageSize() {
		return haStorageSize;
	}

	/**
	 * @param haStorageSize the haStorageSize to set
	 */
	public void setHaStorageSize(BigDecimal haStorageSize) {
		this.haStorageSize = haStorageSize;
	}

	/**
	 * @return the haHostNm
	 */
	public String getHaHostNm() {
		return haHostNm;
	}

	/**
	 * @param haHostNm the haHostNm to set
	 */
	public void setHaHostNm(String haHostNm) {
		this.haHostNm = haHostNm;
	}

	/**
	 * @return the haVmName
	 */
	public String getHaVmName() {
		return haVmName;
	}

	/**
	 * @param haVmName the haVmName to set
	 */
	public void setHaVmName(String haVmName) {
		this.haVmName = haVmName;
	}

	


}
