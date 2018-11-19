package ncis.cmn.entity;

/**
 * Scrtky Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author x
 */

public class RxScrtky {

    private Integer servcAreaSeq;  /* 서비스영역SEQ */
    private String scrtkyId;  /* 보안키ID */
    private String crtfcMthdClCd;  /* 인증방식구분코드 */
    private String id;  /* ID */
    private String passwd;  /* 비밀번호 */
    private String sshKey;  /* SSH키 */


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
	/**
	 * @return the scrtkyId
	 */
	public String getScrtkyId() {
		return scrtkyId;
	}
	/**
	 * @param scrtkyId the scrtkyId to set
	 */
	public void setScrtkyId(String scrtkyId) {
		this.scrtkyId = scrtkyId;
	}
	/**
	 * @return the crtfcMthdClCd
	 */
	public String getCrtfcMthdClCd() {
		return crtfcMthdClCd;
	}
	/**
	 * @param crtfcMthdClCd the crtfcMthdClCd to set
	 */
	public void setCrtfcMthdClCd(String crtfcMthdClCd) {
		this.crtfcMthdClCd = crtfcMthdClCd;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	/**
	 * @return the sshKey
	 */
	public String getSshKey() {
		return sshKey;
	}
	/**
	 * @param sshKey the sshKey to set
	 */
	public void setSshKey(String sshKey) {
		this.sshKey = sshKey;
	}



}
