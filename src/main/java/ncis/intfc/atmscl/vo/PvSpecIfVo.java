/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NamespaceVO.java
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 05. 31.
 * @lastmodified 2017. 05. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 05. 31.     x         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.vo;

import java.util.List;

/**
 * @author x
 *
 */
public class PvSpecIfVo {

	private CapacityIfVo capacity;
	private List<String> accessModes;
	private GlusterfsIfVo glusterfs;
	private String persistentVolumeReclaimPolicy;

	/**
	 * @return the capacity
	 */
	public CapacityIfVo getCapacity() {
		return capacity;
	}
	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(CapacityIfVo capacity) {
		this.capacity = capacity;
	}
	/**
	 * @return the accessModes
	 */
	public List<String> getAccessModes() {
		return accessModes;
	}
	/**
	 * @param accessModes the accessModes to set
	 */
	public void setAccessModes(List<String> accessModes) {
		this.accessModes = accessModes;
	}
	/**
	 * @return the glusterfs
	 */
	public GlusterfsIfVo getGlusterfs() {
		return glusterfs;
	}
	/**
	 * @param glusterfs the glusterfs to set
	 */
	public void setGlusterfs(GlusterfsIfVo glusterfs) {
		this.glusterfs = glusterfs;
	}
	/**
	 * @return the persistentVolumeReclaimPolicy
	 */
	public String getPersistentVolumeReclaimPolicy() {
		return persistentVolumeReclaimPolicy;
	}
	/**
	 * @param persistentVolumeReclaimPolicy the persistentVolumeReclaimPolicy to set
	 */
	public void setPersistentVolumeReclaimPolicy(
			String persistentVolumeReclaimPolicy) {
		this.persistentVolumeReclaimPolicy = persistentVolumeReclaimPolicy;
	}
}
