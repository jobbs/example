/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CommonFileVo.java
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


/**
 * <pre></pre>
 *
 * @author kamsi76
 *
 */
public class CommonFileVo extends FileVo {

	private Long seq; //파일 시퀀스
	private Long parentSeq;	// 게시글 시퀀스
	private String regId;	// 등록자 ID
	private Integer order;	// 순서

	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public Long getParentSeq() {
		return parentSeq;
	}
	public void setParentSeq(Long parentSeq) {
		this.parentSeq = parentSeq;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
}
