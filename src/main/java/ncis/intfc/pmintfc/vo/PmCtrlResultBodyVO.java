/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PmCtrlResultBodyVO.java
 *
 * @author spa
 * @lastmodifier spa
 * @created 2016. 12. 5.
 * @lastmodified 2016. 12. 5.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 5.     spa         v1.0             최초생성
 *
 */
package ncis.intfc.pmintfc.vo;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

/**
 * @author ihjang
 *
 */
public class PmCtrlResultBodyVO extends SerializableSerializer{

	private static final long serialVersionUID = 1L;

	private String physicalServerId; //물리 서버 ID
	private String jobId;	   //작업 상태 ID
	public String getPhysicalServerId() {
		return physicalServerId;
	}
	public void setPhysicalServerId(String physicalServerId) {
		this.physicalServerId = physicalServerId;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

}
