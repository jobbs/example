package ncis.rest.intfc.conf.vo;


/**
 * @author LeeJiHun
 *
 */
public class CfImgVO {

	private String rsrcPoolId; /* 자원풀ID */
	private String imgId; /* 이미지ID */
	private String imgNm; /* 이미지명 */
	private String imgUid; /* 이미지UID */
	private String imgRepoAddr; /* 이미지저장소주소 */
	private Integer servcAreaSeq; /* 서비스영역SEQ */
	private String imgVer; /* 이미지버전 */
	
	private Integer basImgCapa; /* 베이스이미지용량 */
	private String imgTyNm; /* 이미지유형명 */
	private String basImgYn; /* 베이스이미지여부 */
	private String imgCapa; /* 이미지용량 */
	private String wrkPathNm; /* 작업경로명 */
	private String imgTyCd; /* 이미지유형코드 */
	private String rmk; /* 비고 */
	private String useYn; /* 사용여부 */
	private String creDttm; /* 생성일시 */
	private String updtDttm; /* 수정일시 */
	private String creUserId; /* 생성자ID */
	private String updtUserId; /* 수정자ID */

	/**
	 * @return the rsrcPoolId
	 */
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}

	/**
	 * @param rsrcPoolId
	 *            the rsrcPoolId to set
	 */
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}

	/**
	 * @return the imgId
	 */
	public String getImgId() {
		return imgId;
	}

	/**
	 * @param imgId
	 *            the imgId to set
	 */
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	/**
	 * @return the imgNm
	 */
	public String getImgNm() {
		return imgNm;
	}

	/**
	 * @param imgNm
	 *            the imgNm to set
	 */
	public void setImgNm(String imgNm) {
		this.imgNm = imgNm;
	}

	/**
	 * @return the imgUid
	 */
	public String getImgUid() {
		return imgUid;
	}

	/**
	 * @param imgUid
	 *            the imgUid to set
	 */
	public void setImgUid(String imgUid) {
		this.imgUid = imgUid;
	}

	/**
	 * @return the imgRepoAddr
	 */
	public String getImgRepoAddr() {
		return imgRepoAddr;
	}

	/**
	 * @param imgRepoAddr
	 *            the imgRepoAddr to set
	 */
	public void setImgRepoAddr(String imgRepoAddr) {
		this.imgRepoAddr = imgRepoAddr;
	}

	/**
	 * @return the servcAreaSeq
	 */
	public Integer getServcAreaSeq() {
		return servcAreaSeq;
	}

	/**
	 * @param servcAreaSeq
	 *            the servcAreaSeq to set
	 */
	public void setServcAreaSeq(Integer servcAreaSeq) {
		this.servcAreaSeq = servcAreaSeq;
	}

	/**
	 * @return the imgVer
	 */
	public String getImgVer() {
		return imgVer;
	}

	/**
	 * @param imgVer
	 *            the imgVer to set
	 */
	public void setImgVer(String imgVer) {
		this.imgVer = imgVer;
	}
	/**
	 * @return the basImgCapa
	 */
	public Integer getBasImgCapa() {
	    return basImgCapa;
	}
	/**
	 * @param basImgCapa the basImgCapa to set
	 */
	public void setBasImgCapa(Integer basImgCapa) {
	    this.basImgCapa = basImgCapa;
	}
	/**
	 * @return the imgTyNm
	 */
	public String getImgTyNm() {
	    return imgTyNm;
	}
	/**
	 * @param imgTyNm the imgTyNm to set
	 */
	public void setImgTyNm(String imgTyNm) {
	    this.imgTyNm = imgTyNm;
	}
	/**
	 * @return the basImgYn
	 */
	public String getBasImgYn() {
		return basImgYn;
	}

	/**
	 * @param basImgYn
	 *            the basImgYn to set
	 */
	public void setBasImgYn(String basImgYn) {
		this.basImgYn = basImgYn;
	}

	/**
	 * @return the imgCapa
	 */
	public String getImgCapa() {
		return imgCapa;
	}

	/**
	 * @param imgCapa
	 *            the imgCapa to set
	 */
	public void setImgCapa(String imgCapa) {
		this.imgCapa = imgCapa;
	}

	/**
	 * @return the wrkPathNm
	 */
	public String getWrkPathNm() {
		return wrkPathNm;
	}

	/**
	 * @param wrkPathNm
	 *            the wrkPathNm to set
	 */
	public void setWrkPathNm(String wrkPathNm) {
		this.wrkPathNm = wrkPathNm;
	}

	/**
	 * @return the imgTyCd
	 */
	public String getImgTyCd() {
		return imgTyCd;
	}

	/**
	 * @param imgTyCd
	 *            the imgTyCd to set
	 */
	public void setImgTyCd(String imgTyCd) {
		this.imgTyCd = imgTyCd;
	}

	/**
	 * @return the rmk
	 */
	public String getRmk() {
		return rmk;
	}

	/**
	 * @param rmk
	 *            the rmk to set
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	/**
	 * @return the useYn
	 */
	public String getUseYn() {
		return useYn;
	}

	/**
	 * @param useYn
	 *            the useYn to set
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	/**
	 * @return the creDttm
	 */
	public String getCreDttm() {
		return creDttm;
	}

	/**
	 * @param creDttm
	 *            the creDttm to set
	 */
	public void setCreDttm(String creDttm) {
		this.creDttm = creDttm;
	}

	/**
	 * @return the updtDttm
	 */
	public String getUpdtDttm() {
		return updtDttm;
	}

	/**
	 * @param updtDttm
	 *            the updtDttm to set
	 */
	public void setUpdtDttm(String updtDttm) {
		this.updtDttm = updtDttm;
	}

	/**
	 * @return the creUserId
	 */
	public String getCreUserId() {
		return creUserId;
	}

	/**
	 * @param creUserId
	 *            the creUserId to set
	 */
	public void setCreUserId(String creUserId) {
		this.creUserId = creUserId;
	}

	/**
	 * @return the updtUserId
	 */
	public String getUpdtUserId() {
		return updtUserId;
	}

	/**
	 * @param updtUserId
	 *            the updtUserId to set
	 */
	public void setUpdtUserId(String updtUserId) {
		this.updtUserId = updtUserId;
	}

}
