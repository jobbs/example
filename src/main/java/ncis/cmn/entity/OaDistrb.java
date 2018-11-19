package ncis.cmn.entity;

import java.math.BigDecimal;

/**
 * 배포 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class OaDistrb {

    /**
     * 배포SEQ
     */
    private BigDecimal distrbSeq;

    /**
     * 배포일시
     */
    private String distrbDttm;

    /**
     * 배포사유코드
     */
    private String distrbReasnCd;

    /**
     * 배포경로
     */
    private String distrbPath;

    /**
     * 배포실행자ID
     */
    private String distrbExeUserId;

    /**
     * 티켓ID
     */
    private String ticketId;

    /**
     * 비고
     */
    private String rmk;

	public BigDecimal getDistrbSeq() {
		return distrbSeq;
	}

	public void setDistrbSeq(BigDecimal distrbSeq) {
		this.distrbSeq = distrbSeq;
	}

	public String getDistrbDttm() {
		return distrbDttm;
	}

	public void setDistrbDttm(String distrbDttm) {
		this.distrbDttm = distrbDttm;
	}

	public String getDistrbReasnCd() {
		return distrbReasnCd;
	}

	public void setDistrbReasnCd(String distrbReasnCd) {
		this.distrbReasnCd = distrbReasnCd;
	}

	public String getDistrbPath() {
		return distrbPath;
	}

	public void setDistrbPath(String distrbPath) {
		this.distrbPath = distrbPath;
	}

	public String getDistrbExeUserId() {
		return distrbExeUserId;
	}

	public void setDistrbExeUserId(String distrbExeUserId) {
		this.distrbExeUserId = distrbExeUserId;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}




}
