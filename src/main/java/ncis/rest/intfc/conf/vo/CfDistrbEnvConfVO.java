package ncis.rest.intfc.conf.vo;


/**
 * @author YangJY
 *
 */
public class CfDistrbEnvConfVO {

	private String envVarNm; 	/* 환경변수명 */
	private String envVarVl; 	/* 환경변수값 */
	private String varVlTyCd; 	/* 변수값유형코드 */
	private String creDttm; 	/* 생성일시 */
	private String updtDttm; 	/* 수정일시 */
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
	/**
	 * @return the updtDttm
	 */
	public String getUpdtDttm() {
		return updtDttm;
	}
	/**
	 * @param updtDttm the updtDttm to set
	 */
	public void setUpdtDttm(String updtDttm) {
		this.updtDttm = updtDttm;
	}


}
