package ncis.cmn.entity;

/**
 * ServcAreaPvAsgn Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author x
 */

public class RxServcAreaPvAsgn {

	private String rsrcPoolId;  /* 자원풀ID */
	private String pvId;  /* PV_ID */
	private Integer servcAreaSeq; /* 서비스영역SEQ */


	/**
	 * @return the rsrcPoolId
	 */
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	/**
	 * @param rsrcPoolId the rsrcPoolId to set
	 */
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}
	/**
	 * @return the pvId
	 */
	public String getPvId() {
		return pvId;
	}
	/**
	 * @param pvId the pvId to set
	 */
	public void setPvId(String pvId) {
		this.pvId = pvId;
	}
	/**
	 * @return the servcAreaSeq
	 */
	public Integer getServcAreaSeq() {
		return servcAreaSeq;
	}
	/**
	 * @param servcAreaSeq the servcAreaSeq to set
	 */
	public void setServcAreaSeq(Integer servcAreaSeq) {
		this.servcAreaSeq = servcAreaSeq;
	}

}
