/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RestHeaders.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.rest.vo;

/**
 * @author 최진호
 *
 */
public class RestHeaders {

    private String areaId;

    private String zoneId;

    private String networkId;

    private String managerId;

    private String Authorization;

    private String seq;

    private String action;

    private String machineIp;

    private String xTykAuthorization;

    private String accept;

    /**
     * @return the areaId
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * @param areaId the areaId to set
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
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
     * @return the networkId
     */
    public String getNetworkId() {
        return networkId;
    }

    /**
     * @param networkId the networkId to set
     */
    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    /**
     * @return the managerId
     */
    public String getManagerId() {
        return managerId;
    }

    /**
     * @param managerId the managerId to set
     */
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    /**
     * @return the authorization
     */
    public String getAuthorization() {
        return Authorization;
    }

    /**
     * @param authorization the authorization to set
     */
    public void setAuthorization(String authorization) {
        Authorization = authorization;
    }

    /**
     * @return the seq
     */
    public String getSeq() {
        return seq;
    }

    /**
     * @param seq the seq to set
     */
    public void setSeq(String seq) {
        this.seq = seq;
    }

    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return the machineIp
     */
    public String getMachineIp() {
        return machineIp;
    }

    /**
     * @param machineIp the machineIp to set
     */
    public void setMachineIp(String machineIp) {
        this.machineIp = machineIp;
    }

    /**
     * @return the xTykAuthrization
     */
    public String getxTykAuthorization() {
        return xTykAuthorization;
    }

    /**
     * @param xTykAuthrization the xTykAuthrization to set
     */
    public void setxTykAuthorization(String xTykAuthorization) {
        this.xTykAuthorization = xTykAuthorization;
    }

	/**
	 * @param applicationJsonValue
	 */
	public void setAccept(String accept)
	{
		this.accept = accept;
	}

	public String getAccept()
	{
		return this.accept;
	}
}
