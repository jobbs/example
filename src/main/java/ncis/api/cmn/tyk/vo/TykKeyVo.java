/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TykKeyVo.java
 *
 * @author 이제율
 * @lastmodifier 이제율
 * @created 2016. 10. 31.
 * @lastmodified 2016. 10. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 31.     이제율	     v1.0	             최초생성
 *
 */
package ncis.api.cmn.tyk.vo;

import java.util.List;

/**
 * @author 이제율
 *
 */
public class TykKeyVo {
	private boolean is_inactive;
    private String apply_policy_id;
    private String keyId;
    private String regionId;
    private List<String> openApiId;

    /**
	 * @return the is_inactive
	 */
	public boolean isIs_inactive() {
		return is_inactive;
	}
	/**
	 * @param is_inactive the is_inactive to set
	 */
	public void setIs_inactive(boolean is_inactive) {
		this.is_inactive = is_inactive;
	}
	/**
	 * @return the apply_policy_id
	 */
	public String getApply_policy_id() {
		return apply_policy_id;
	}
	/**
	 * @param apply_policy_id the apply_policy_id to set
	 */
	public void setApply_policy_id(String apply_policy_id) {
		this.apply_policy_id = apply_policy_id;
	}
	/**
	 * @return the keyId
	 */
	public String getKeyId() {
		return keyId;
	}
	/**
	 * @param keyId the keyId to set
	 */
	public void setKeyId(String keyId) {
		this.keyId = keyId;
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
	 * @return the openApiId
	 */
	public List<String> getOpenApiId() {
		return openApiId;
	}
	/**
	 * @param openApiId the openApiId to set
	 */
	public void setOpenApiId(List<String> openApiId) {
		this.openApiId = openApiId;
	}

}
