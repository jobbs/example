/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DefaultVo.java
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
 * 2016. 10. 31.     이제율         v1.0             최초생성
 *
 */
package ncis.api.cmn.tyk.vo;

import java.util.List;

/**
 * @author 이제율
 *
 */
public class VersionNameVo {
	private String name = "Default";
	private String expires;
	private PathsVo paths;
	private boolean use_extended_paths = true;
	private ExtendedPathsVo extended_paths;
	private GlobalheadersVo global_headers;
    private List<String> global_headers_remove;
    private Integer global_size_limit = 0;
    private String override_target;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the expires
	 */
	public String getExpires() {
		return expires;
	}
	/**
	 * @param expires the expires to set
	 */
	public void setExpires(String expires) {
		this.expires = expires;
	}
	/**
	 * @return the paths
	 */
	public PathsVo getPaths() {
		return paths;
	}
	/**
	 * @param paths the paths to set
	 */
	public void setPaths(PathsVo paths) {
		this.paths = paths;
	}
	/**
	 * @return the use_extended_paths
	 */
	public boolean isUse_extended_paths() {
		return use_extended_paths;
	}
	/**
	 * @param use_extended_paths the use_extended_paths to set
	 */
	public void setUse_extended_paths(boolean use_extended_paths) {
		this.use_extended_paths = use_extended_paths;
	}
	/**
	 * @return the extended_paths
	 */
	public ExtendedPathsVo getExtended_paths() {
		return extended_paths;
	}
	/**
	 * @param extended_paths the extended_paths to set
	 */
	public void setExtended_paths(ExtendedPathsVo extended_paths) {
		this.extended_paths = extended_paths;
	}
	/**
	 * @return the global_headers
	 */
	public GlobalheadersVo getGlobal_headers() {
		return global_headers;
	}
	/**
	 * @param global_headers the global_headers to set
	 */
	public void setGlobal_headers(GlobalheadersVo global_headers) {
		this.global_headers = global_headers;
	}
	/**
	 * @return the global_headers_remove
	 */
	public List<String> getGlobal_headers_remove() {
		return global_headers_remove;
	}
	/**
	 * @param global_headers_remove the global_headers_remove to set
	 */
	public void setGlobal_headers_remove(List<String> global_headers_remove) {
		this.global_headers_remove = global_headers_remove;
	}
	/**
	 * @return the global_size_limit
	 */
	public Integer getGlobal_size_limit() {
		return global_size_limit;
	}
	/**
	 * @param global_size_limit the global_size_limit to set
	 */
	public void setGlobal_size_limit(Integer global_size_limit) {
		this.global_size_limit = global_size_limit;
	}
	/**
	 * @return the override_target
	 */
	public String getOverride_target() {
		return override_target;
	}
	/**
	 * @param override_target the override_target to set
	 */
	public void setOverride_target(String override_target) {
		this.override_target = override_target;
	}

}
