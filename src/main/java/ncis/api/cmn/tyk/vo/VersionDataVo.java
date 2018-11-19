/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename versionDataVo.java
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
 * 2016. 10. 31.     이제율        	 v1.0    	         최초생성
 *
 */
package ncis.api.cmn.tyk.vo;

/**
 * @author 이제율
 *
 */
public class VersionDataVo {
	private boolean not_versioned = true;
	private VersionsVo versions;
	/**
	 * @return the not_versioned
	 */
	public boolean isNot_versioned() {
		return not_versioned;
	}
	/**
	 * @param not_versioned the not_versioned to set
	 */
	public void setNot_versioned(boolean not_versioned) {
		this.not_versioned = not_versioned;
	}
	/**
	 * @return the versions
	 */
	public VersionsVo getVersions() {
		return versions;
	}
	/**
	 * @param versions the versions to set
	 */
	public void setVersions(VersionsVo versions) {
		this.versions = versions;
	}
}
