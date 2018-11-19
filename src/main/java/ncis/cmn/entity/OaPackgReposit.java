/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename OaPackgReposit.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     이화영         v1.0             최초생성
 *
 */
package ncis.cmn.entity;

/**
 * @author 이화영
 *
 */
public class OaPackgReposit {

	/**
	* 레파지토리ID
	*/
    private String repositId;

    /**
	* 레파지토리명
	*/
    private String repositNm;

    /**
	* 레파지토리주소
	*/
    private String repositAddr;

    /**
	* 리전ID
	*/
    private String regionId;

    /**
  	* 망ID
  	*/
    private String netId;

	public String getRepositId() {
		return repositId;
	}

	public void setRepositId(String repositId) {
		this.repositId = repositId;
	}

	public String getRepositNm() {
		return repositNm;
	}

	public void setRepositNm(String repositNm) {
		this.repositNm = repositNm;
	}

	public String getRepositAddr() {
		return repositAddr;
	}

	public void setRepositAddr(String repositAddr) {
		this.repositAddr = repositAddr;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getNetId() {
		return netId;
	}

	public void setNetId(String netId) {
		this.netId = netId;
	}





}
