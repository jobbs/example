/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DeployConfig.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 21.
 * @lastmodified 2016. 10. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 21.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.seoa.vo;

/**
 * @author ShinKeeBong
 *
 */
public class DeployConfigVO {

	private String machineIp;       //TargetVM 의 아이피
	private String loginId;         //TargetVM 의 root 권한 아이디
	private String loginPassWord;   //TargetVM 의 root 권한 패스워드
	private String fileName;        //TargetVM 에 들어갈 파일이름
	private String destinationPath;  //TargetVM 에 들어갈 파일위치
	private String fileContent;     //파일에 들어갈 내용


	public String getMachineIp() {
		return machineIp;
	}
	public void setMachineIp(String machineIp) {
		this.machineIp = machineIp;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPassWord() {
		return loginPassWord;
	}
	public void setLoginPassWord(String loginPassWord) {
		this.loginPassWord = loginPassWord;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	public String getDestinationPath() {
		return destinationPath;
	}
	public void setDestinationPath(String destinationPath) {
		this.destinationPath = destinationPath;
	}



}
