/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ProcResultVo.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.vo;

import java.util.ArrayList;
import java.util.List;

public class ProcResultVo {

	private boolean success; // 성공여부
	private List<String> messageList; // 메시지정보
	private Object data; // 관련데이타
	private String procType;

	public ProcResultVo() {
		this.success = true;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the messageList
	 */
	public List<String> getMessageList() {
		return messageList;
	}

	/**
	 * @param messageList the messageList to set
	 */
	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}

	public void addMessage(String msg){
		if(messageList == null){
			messageList = new ArrayList<String>();
		}
		messageList.add(msg);
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the procType
	 */
	public String getProcType() {
		return procType;
	}

	/**
	 * @param procType the procType to set
	 */
	public void setProcType(String procType) {
		this.procType = procType;
	}

	@Override
	public String toString() {

		StringBuffer strBuf = new StringBuffer()
			.append("{ \n")
			.append("	success : ").append( this.success ).append(", \n")
			.append("	messageList : ").append( this.messageList ).append(", \n")
			.append("	data : ").append( this.data ).append(", \n")
			.append("	procType : ").append( this.procType ).append(" \n")
			.append("}");

		return strBuf.toString();
	}

}
