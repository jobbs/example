package ncis.cmn.entity;

import java.util.Date;

public class OperateLog {
	
	/**
	 * 작업이력 순번
	 */
	private Long operateSeq;
	/**
	 * 메뉴아이디
	 */
	private Long menuId;
	/**
	 * 메뉴명
	 */
	private String menuName;
	/**
	 * 작업 행위명
	 */
	private String operateInfo;
	/**
	 * 작업행위 설명
	 */
	private String operateDesc;
	/**
	 * 적용된 파라메타 정보
	 */
	private String operateParam;
	/**
	 * 작업타입
	 */
	private String operateType;
	/**
	 * 작업자 아이디
	 */
	private String userId;
	/**
	 * 작업자 명
	 */
	private String userName;
	/**
	 * 접속아이피
	 */
	private String operateIP;
	/**
	 * 작업일자
	 */
	private Date operateDate;
	
	/**
	 * @return the operateSeq
	 */
	public Long getOperateSeq() {
		return operateSeq;
	}
	/**
	 * @param operateSeq the operateSeq to set
	 */
	public void setOperateSeq(Long operateSeq) {
		this.operateSeq = operateSeq;
	}
	/**
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}
	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}
	/**
	 * @param menuName the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * @return the operateInfo
	 */
	public String getOperateInfo() {
		return operateInfo;
	}
	/**
	 * @param operateInfo the operateInfo to set
	 */
	public void setOperateInfo(String operateInfo) {
		this.operateInfo = operateInfo;
	}
	/**
	 * @return the operateDesc
	 */
	public String getOperateDesc() {
		return operateDesc;
	}
	/**
	 * @param operateDesc the operateDesc to set
	 */
	public void setOperateDesc(String operateDesc) {
		this.operateDesc = operateDesc;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the operateIP
	 */
	public String getOperateIP() {
		return operateIP;
	}
	/**
	 * @param operateIP the operateIP to set
	 */
	public void setOperateIP(String operateIP) {
		this.operateIP = operateIP;
	}
	/**
	 * @return the operateDate
	 */
	public Date getOperateDate() {
		return operateDate;
	}
	/**
	 * @param operateDate the operateDate to set
	 */
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	/**
	 * @return the operateParam
	 */
	public String getOperateParam() {
		return operateParam;
	}
	/**
	 * @param operateParam the operateParam to set
	 */
	public void setOperateParam(String operateParam) {
		this.operateParam = operateParam;
	}
	/**
	 * @return the operateType
	 */
	public String getOperateType() {
		return operateType;
	}
	/**
	 * @param operateType the operateType to set
	 */
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}


}
