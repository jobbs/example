/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MacBndSvo.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.vo;

import java.util.ArrayList;
import java.util.List;

import ncis.cmn.util.ObjectUtils;
import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 송승규
 *
 */
public class MacBndSvo extends CommonSearchVo {

	/**
	 * 리전ID
	 */
	private String regionId;

	/**
	 * 리전명
	 */
	private String regionNm;

	/**
	 * 존ID
	 */
	private String zoneId;

	/**
	 * 존명
	 */
	private String zoneNm;

	/**
	 * 망ID
	 */
	private String netId;
	/**
	 * 망구분코드
	 */
	private String netClCd;

	/**
	 * 망명
	 */
	private String netNm;

	/**
	 * 자원풀ID
	 */
	private String poolId;

	/**
	 * 자원풀명
	 */
	private String rsrcPoolNm;

	/**
	 * 자원풀 구분 코드
	 */
	private String rsrcPoolClCd;

	/**
	 * MAC대역명
	 */
	private String macBndNm;

	/**
	 * MAC주소
	 */
	private String macAddr;

	/**
	 * MAC대역SEQ
	 */
	private Integer macBndSeq;

	/**
	 * 할당여부
	 */
	private String asgnYn;

	/**
	 * 가상서버구성ID
	 */
	private String vmCompId;

	/**
	 * 가상서버구성명
	 */
	private String vmNm;

	/**
	 * MAC시작주소
	 */
	private String macStrtAddr;

	/**
	 * MAC종료주소
	 */
	private String macEndAddr;

	/**
	 * 할당건수
	 */
	private String asgnCnt;

	/**
	 * 설명
	 */
	private String dc;

	/**
	 * 동기화 List
	 */
	private List<Integer> updtCheck;




	/**
	 * @return the rsrcPoolClCd
	 */
	public String getRsrcPoolClCd() {
		return rsrcPoolClCd;
	}

	/**
	 * @param rsrcPoolClCd the rsrcPoolClCd to set
	 */
	public void setRsrcPoolClCd(String rsrcPoolClCd) {
		this.rsrcPoolClCd = rsrcPoolClCd;
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
	 * @return the netId
	 */
	public String getNetId() {
		return netId;
	}

	/**
	 * @param netId the netId to set
	 */
	public void setNetId(String netId) {
		this.netId = netId;
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
	 * @return the poolId
	 */
	public String getPoolId() {
		return poolId;
	}

	/**
	 * @param poolId the poolId to set
	 */
	public void setPoolId(String poolId) {
		this.poolId = poolId;
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
	 * @return the macBndNm
	 */
	public String getMacBndNm() {
		return macBndNm;
	}

	/**
	 * @param macBndNm the macBndNm to set
	 */
	public void setMacBndNm(String macBndNm) {
		this.macBndNm = macBndNm;
	}

	/**
	 * @return the macAddr
	 */
	public String getMacAddr() {
		return macAddr;
	}

	/**
	 * @param macAddr the macAddr to set
	 */
	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
	}

	/**
	 * @return the macBndSeq
	 */
	public Integer getMacBndSeq() {
		return macBndSeq;
	}

	/**
	 * @param macBndSeq the macBndSeq to set
	 */
	public void setMacBndSeq(Integer macBndSeq) {
		this.macBndSeq = macBndSeq;
	}

	/**
	 * @return the asgnYn
	 */
	public String getAsgnYn() {
		return asgnYn;
	}

	/**
	 * @param asgnYn the asgnYn to set
	 */
	public void setAsgnYn(String asgnYn) {
		this.asgnYn = asgnYn;
	}

	/**
	 * @return the vmCompId
	 */
	public String getVmCompId() {
		return vmCompId;
	}

	/**
	 * @param vmCompId the vmCompId to set
	 */
	public void setVmCompId(String vmCompId) {
		this.vmCompId = vmCompId;
	}

	/**
	 * @return the macStrtAddr
	 */
	public String getMacStrtAddr() {
		return macStrtAddr;
	}

	/**
	 * @param macStrtAddr the macStrtAddr to set
	 */
	public void setMacStrtAddr(String macStrtAddr) {
		this.macStrtAddr = macStrtAddr;
	}

	/**
	 * @return the macEndAddr
	 */
	public String getMacEndAddr() {
		return macEndAddr;
	}

	/**
	 * @param macEndAddr the macEndAddr to set
	 */
	public void setMacEndAddr(String macEndAddr) {
		this.macEndAddr = macEndAddr;
	}

	/**
	 * @return the asgnCnt
	 */
	public String getAsgnCnt() {
		return asgnCnt;
	}

	/**
	 * @param asgnCnt the asgnCnt to set
	 */
	public void setAsgnCnt(String asgnCnt) {
		this.asgnCnt = asgnCnt;
	}

	/**
	 * @return the dc
	 */
	public String getDc() {
		return dc;
	}

	/**
	 * @param dc the dc to set
	 */
	public void setDc(String dc) {
		this.dc = dc;
	}

	/**
	 * @return the updtCheck
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> getUpdtCheck() {
		if(ObjectUtils.isEmpty(updtCheck)){
			updtCheck = new ArrayList<Integer>();
		}
		return (List<Integer>) ((ArrayList<Integer>) updtCheck).clone();
	}

	/**
	 * @param updtCheck the updtCheck to set
	 */
	@SuppressWarnings("unchecked")
	public void setUpdtCheck(List<Integer> updtCheck) {
		this.updtCheck = (List<Integer>) ((ArrayList<Integer>) updtCheck).clone();
	}

	/**
     * 조회 시 권한 관련
     */
	public boolean isSysadm() {
        return "SYSADM".equals(RequestUtils.getUser().getSuperposedUserRole());
    }

    public boolean isOpradm() {
        return "OPRADM".equals(RequestUtils.getUser().getSuperposedUserRole());
    }

    public String getUserId() {
        return RequestUtils.getUserId();
    }

    /**
	 * @return the vmNm
	 */
	public String getVmNm() {
		return vmNm;
	}

	/**
	 * @param vmNm the vmNm to set
	 */
	public void setVmNm(String vmNm) {
		this.vmNm = vmNm;
	}
}
