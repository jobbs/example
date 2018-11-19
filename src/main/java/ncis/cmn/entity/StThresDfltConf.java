package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

public class StThresDfltConf {

	/**
	 * 프로파일ID
	 */
	private Long profId;
	//지표항목 ID
	@NotEmpty(message="지표항목ID를 입력하세요.")
	private Long idxItmId;
	//임계등급ID
	@NotEmpty(message="임계등급ID를 입력하세요.")
	private String thresGrdId;
	//비교기준
	private String cmprStdr;
	//기본임계값
	private Long dfltThresVl;
	//임계치기본연속횟수
	private Long thresDfltContCnt;
	public Long getProfId() {
		return profId;
	}
	public void setProfId(Long profId) {
		this.profId = profId;
	}
	public Long getIdxItmId() {
		return idxItmId;
	}
	public void setIdxItmId(Long idxItmId) {
		this.idxItmId = idxItmId;
	}
	public String getThresGrdId() {
		return thresGrdId;
	}
	public void setThresGrdId(String thresGrdId) {
		this.thresGrdId = thresGrdId;
	}
	public String getCmprStdr() {
		return cmprStdr;
	}
	public void setCmprStdr(String cmprStdr) {
		this.cmprStdr = cmprStdr;
	}
	public Long getDfltThresVl() {
		return dfltThresVl;
	}
	public void setDfltThresVl(Long dfltThresVl) {
		this.dfltThresVl = dfltThresVl;
	}
	public Long getThresDfltContCnt() {
		return thresDfltContCnt;
	}
	public void setThresDfltContCnt(Long thresDfltContCnt) {
		this.thresDfltContCnt = thresDfltContCnt;
	}



}
