package ncis.rest.intfc.conf.vo;

import java.util.List;


/**
 * @author YangJY
 *
 */
public class CfDistrbConfVO {

	private Integer servcSeq; /* 서비스SEQ */
	private String distrbConfId; /* 배포설정ID */
	private String distrbConfNm; /* 배포설정명 */

	private List<CfDistrbEnvConfVO> distrbEnvConfInfos; /* 배포 환경 정보 */
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
	 * @return the distrbConfNm
	 */
	public String getDistrbConfNm() {
		return distrbConfNm;
	}
	/**
	 * @param distrbConfNm the distrbConfNm to set
	 */
	public void setDistrbConfNm(String distrbConfNm) {
		this.distrbConfNm = distrbConfNm;
	}

	public List<CfDistrbEnvConfVO> getDistrbEnvConfInfos() {
		return distrbEnvConfInfos;
	}
	public void setDistrbEnvConfInfos(List<CfDistrbEnvConfVO> distrbEnvConfInfos) {
		this.distrbEnvConfInfos = distrbEnvConfInfos;
	}



}
