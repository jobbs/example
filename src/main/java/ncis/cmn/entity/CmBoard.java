/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CmBoard.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 14.
 * @lastmodified 2016. 10. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 14.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cmn.entity;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class CmBoard {

	/**
	 * 시퀀스
	 */
	private Long boardSeq;

	/**
	 * 부모 시퀀스
	 */
	private Long parentSeq;

	/**
	 * 게시판 코드
	 */
	private String boardCd;

	/**
	 * 등록자명
	 */
	private String regNm;

	@NotEmpty(message="게시판 제목을 입력하세요.")
	@Size(min=1, max=4000)
	private String sbjct;

	@NotEmpty(message="내용을 입력하세요.")
	@Size(min=1, max=4000)
	private String contents;

	/**
	 * 조회수
	 */
	private int hitCnt;

	/**
	 * 등록일자
	 */
	private Date regDt;
	/**
	 * 등록자아이디
	 */
	private String regId;
	/**
	 * 수정일자
	 */
	private Date updtDt;
	/**
	 * 수정자아이디
	 */
	private String updtId;
	/**
	 * @return the boardSeq
	 */
	public Long getBoardSeq() {
		return boardSeq;
	}
	/**
	 * @param boardSeq the boardSeq to set
	 */
	public void setBoardSeq(Long boardSeq) {
		this.boardSeq = boardSeq;
	}
	/**
	 * @return the parentSeq
	 */
	public Long getParentSeq() {
		return parentSeq;
	}
	/**
	 * @param parentSeq the parentSeq to set
	 */
	public void setParentSeq(Long parentSeq) {
		this.parentSeq = parentSeq;
	}
	/**
	 * @return the boardCd
	 */
	public String getBoardCd() {
		return boardCd;
	}
	/**
	 * @param boardCd the boardCd to set
	 */
	public void setBoardCd(String boardCd) {
		this.boardCd = boardCd;
	}
	/**
	 * @return the regNm
	 */
	public String getRegNm() {
		return regNm;
	}
	/**
	 * @param regNm the regNm to set
	 */
	public void setRegNm(String regNm) {
		this.regNm = regNm;
	}
	/**
	 * @return the sbjct
	 */
	public String getSbjct() {
		return sbjct;
	}
	/**
	 * @param sbjct the sbjct to set
	 */
	public void setSbjct(String sbjct) {
		this.sbjct = sbjct;
	}
	/**
	 * @return the contents
	 */
	public String getContents() {
		return contents;
	}
	/**
	 * @param contents the contents to set
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}
	/**
	 * @return the regDt
	 */
	public Date getRegDt() {
		return regDt;
	}
	/**
	 * @param regDt the regDt to set
	 */
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}
	/**
	 * @return the regId
	 */
	public String getRegId() {
		return regId;
	}
	/**
	 * @param regId the regId to set
	 */
	public void setRegId(String regId) {
		this.regId = regId;
	}
	/**
	 * @return the updtDt
	 */
	public Date getUpdtDt() {
		return updtDt;
	}
	/**
	 * @param updtDt the updtDt to set
	 */
	public void setUpdtDt(Date updtDt) {
		this.updtDt = updtDt;
	}
	/**
	 * @return the updtId
	 */
	public String getUpdtId() {
		return updtId;
	}
	/**
	 * @param updtId the updtId to set
	 */
	public void setUpdtId(String updtId) {
		this.updtId = updtId;
	}
	/**
	 * @return the hitCnt
	 */
	public int getHitCnt() {
		return hitCnt;
	}
	/**
	 * @param hitCnt the hitCnt to set
	 */
	public void setHitCnt(int hitCnt) {
		this.hitCnt = hitCnt;
	}

}
