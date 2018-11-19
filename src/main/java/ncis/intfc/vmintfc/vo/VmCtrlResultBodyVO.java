/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmCtrlResultBodyVO.java
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

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

/**
 * @author ShinKeeBong
 *
 */
public class VmCtrlResultBodyVO extends SerializableSerializer {

	private static final long serialVersionUID = 1L;

	private String machineId; //가상 서버 ID
	private String jobId;	   //작업 상태 ID

	public String getMachineId() {
		return machineId;
	}
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

}
