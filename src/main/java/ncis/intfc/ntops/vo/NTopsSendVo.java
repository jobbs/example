package ncis.intfc.ntops.vo;


/**
 * @author selim
 *
 */
public class NTopsSendVo {

	private String ticktNo;  /* 티켓번호 */
	private String vmCompId;  /* 가상서버구성ID */
	private String sendDate;  /* 전송일시 */
	private Integer totalStrgAsgnCapa;  /* 총스토리지 */
	private String linkYn; /* 연계여부 */

	public String getTicktNo() {
		return ticktNo;
	}
	public void setTicktNo(String ticktNo) {
		this.ticktNo = ticktNo;
	}
	public String getVmCompId() {
		return vmCompId;
	}
	public void setVmCompId(String vmCompId) {
		this.vmCompId = vmCompId;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public Integer getTotalStrgAsgnCapa() {
		return totalStrgAsgnCapa;
	}
	public void setTotalStrgAsgnCapa(Integer totalStrgAsgnCapa) {
		this.totalStrgAsgnCapa = totalStrgAsgnCapa;
	}
	public String getLinkYn() {
		return linkYn;
	}
	public void setLinkYn(String linkYn) {
		this.linkYn = linkYn;
	}

}
