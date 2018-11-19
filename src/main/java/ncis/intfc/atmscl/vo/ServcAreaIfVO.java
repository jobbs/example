/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename LbBodyVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 11. 11.
 * @lastmodified 2016. 11. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 11.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.vo;

import java.util.Map;

/**
 * @author x
 *
 */
public class ServcAreaIfVO {
	
	private String kind;
	private String apiVersion;
	
	private Map<String, Object> metadata;
	private Map<String, Object> spec;
	private Map<String, Object> status;
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getApiVersion() {
		return apiVersion;
	}
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	
	public Map<String, Object> getMetadata() {
		return metadata;
	}
	public void setMetadata(Map<String, Object> metadata) {
		this.metadata = metadata;
	}
	public Map<String, Object> getSpec() {
		return spec;
	}
	public void setSpec(Map<String, Object> spec) {
		this.spec = spec;
	}
	public Map<String, Object> getStatus() {
		return status;
	}
	public void setStatus(Map<String, Object> status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ServcAreaIfVO [kind=" + kind + ", apiVersion=" + apiVersion + ", metadata=" + metadata + ", spec="
				+ spec + ", status=" + status + ", getKind()=" + getKind() + ", getApiVersion()=" + getApiVersion()
				+ ", getMetadata()=" + getMetadata() + ", getSpec()=" + getSpec() + ", getStatus()=" + getStatus()
				+ "]";
	}

	
	
}
