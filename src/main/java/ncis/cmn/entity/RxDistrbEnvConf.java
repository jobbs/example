package ncis.cmn.entity;

/**
 * 환경변수 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author x
 */

public class RxDistrbEnvConf {

    private Integer servcSeq;  /* 서비스SEQ */
    private String distrbConfId;  /* 배포설정ID */
    private String envVarNm;  /* 환경변수명 */
    private String envVarVl;  /* 환경변수값 */
    private String varVlTyCd;  /* 변수값유형코드 */
    private String creDttm;  /* 생성일시 */
	/**
	 * @return the servcSeq
	 */
	public Integer getServcSeq() {
		return servcSeq;
	}
	/**
	 * @param servcSeq the servcSeq to set
	 */
	public void setServcSeq(Integer servcSeq) {
		this.servcSeq = servcSeq;
	}
	/**
	 * @return the distrbConfId
	 */
	public String getDistrbConfId() {
		return distrbConfId;
	}
	/**
	 * @param distrbConfId the distrbConfId to set
	 */
	public void setDistrbConfId(String distrbConfId) {
		this.distrbConfId = distrbConfId;
	}
	/**
	 * @return the envVarNm
	 */
	public String getEnvVarNm() {
		return envVarNm;
	}
	/**
	 * @param envVarNm the envVarNm to set
	 */
	public void setEnvVarNm(String envVarNm) {
		this.envVarNm = envVarNm;
	}
	/**
	 * @return the envVarVl
	 */
	public String getEnvVarVl() {
		return envVarVl;
	}
	/**
	 * @param envVarVl the envVarVl to set
	 */
	public void setEnvVarVl(String envVarVl) {
		this.envVarVl = envVarVl;
	}
	/**
	 * @return the varVlTyCd
	 */
	public String getVarVlTyCd() {
		return varVlTyCd;
	}
	/**
	 * @param varVlTyCd the varVlTyCd to set
	 */
	public void setVarVlTyCd(String varVlTyCd) {
		this.varVlTyCd = varVlTyCd;
	}
	/**
	 * @return the creDttm
	 */
	public String getCreDttm() {
		return creDttm;
	}
	/**
	 * @param creDttm the creDttm to set
	 */
	public void setCreDttm(String creDttm) {
		this.creDttm = creDttm;
	}



}
