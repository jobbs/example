/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename AuthProviderVo.java
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

/**
 * @author 이제율
 *
 */
public class AuthProviderVo {
	private String name;
	private String storage_engine;
	private MetaVo meta;
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
	 * @return the storage_engine
	 */
	public String getStorage_engine() {
		return storage_engine;
	}
	/**
	 * @param storage_engine the storage_engine to set
	 */
	public void setStorage_engine(String storage_engine) {
		this.storage_engine = storage_engine;
	}
	/**
	 * @return the meta
	 */
	public MetaVo getMeta() {
		return meta;
	}
	/**
	 * @param meta the meta to set
	 */
	public void setMeta(MetaVo meta) {
		this.meta = meta;
	}
}
