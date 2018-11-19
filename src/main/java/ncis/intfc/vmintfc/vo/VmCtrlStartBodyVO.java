/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmCtrlStartVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 20.
 * @lastmodified 2016. 10. 20.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 20.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.vmintfc.vo;

import java.util.List;

/**
 * @author ShinKeeBong
 *
 */
public class VmCtrlStartBodyVO {

	private boolean useCloudInit;                    //cloud-init 사용여부
	private String hostName;                          //CloudInit 설정 Guest OS 호스트네임
	private String dnsServers;                        //CloudInit 설정 Guest OS 도메인 서버
	private List<NicConfiguration> nicConfigurations; //CloudInit 설정 Guest OS 네트워크 설정 정보
	private String customScript;                      //사용자 스크립트

	public boolean isUseCloudInit() {
		return useCloudInit;
	}
	public void setUseCloudInit(boolean useCloudInit) {
		this.useCloudInit = useCloudInit;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getDnsServers() {
		return dnsServers;
	}
	public void setDnsServers(String dnsServers) {
		this.dnsServers = dnsServers;
	}
	public List<NicConfiguration> getNicConfigurations() {
		return nicConfigurations;
	}
	public void setNicConfigurations(List<NicConfiguration> nicConfigurations) {
		this.nicConfigurations = nicConfigurations;
	}
	public String getCustomScript() {
		return customScript;
	}
	public void setCustomScript(String customScript) {
		this.customScript = customScript;
	}

}
