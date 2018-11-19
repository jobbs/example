/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * HiperVisorCntVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.res.vo;

import ncis.cmn.vo.CommonSearchVo;

public class HiperVisorCntVo extends CommonSearchVo {

	private long total;
	private long rhev;
	private long vmware;
	private long ibm;
	private long hp;
	private long openstack;
	private long docker;

	/**
	 * @return the rhev
	 */
	public long getTotal() {
		return total;
	}
	/**
	 * @param rhev the rhev to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * @return the rhev
	 */
	public long getRhev() {
		return rhev;
	}
	/**
	 * @param rhev the rhev to set
	 */
	public void setRhev(long rhev) {
		this.rhev = rhev;
	}
	/**
	 * @return the vmware
	 */
	public long getVmware() {
		return vmware;
	}
	/**
	 * @param vmware the vmware to set
	 */
	public void setVmware(long vmware) {
		this.vmware = vmware;
	}
	/**
	 * @return the ibm
	 */
	public long getIbm() {
		return ibm;
	}
	/**
	 * @param ibm the ibm to set
	 */
	public void setIbm(long ibm) {
		this.ibm = ibm;
	}
	/**
	 * @return the hp
	 */
	public long getHp() {
		return hp;
	}
	/**
	 * @param hp the hp to set
	 */
	public void setHp(long hp) {
		this.hp = hp;
	}
	/**
	 * @return the openstack
	 */
	public long getOpenstack() {
		return openstack;
	}
	/**
	 * @param openstack the openstack to set
	 */
	public void setOpenstack(long openstack) {
		this.openstack = openstack;
	}
	/**
	 * @return the docker
	 */
	public long getDocker() {
		return docker;
	}
	/**
	 * @param docker the docker to set
	 */
	public void setDocker(long docker) {
		this.docker = docker;
	}


}
