package ncis.cmn.entity;


import org.hibernate.validator.constraints.NotEmpty;

public class StProf {

	/**
	 * 시퀀스
	 */
	private Long profId;


	/**
	 * 한글명
	 */
	@NotEmpty(message="프로파일명을 입력하세요.")
	private String profNm;

	/**
	 * 영문명
	 */
	private String dc;

	public Long getProfId() {
		return profId;
	}

	public void setProfId(Long profId) {
		this.profId = profId;
	}

	public String getProfNm() {
		return profNm;
	}

	public void setProfNm(String profNm) {
		this.profNm = profNm;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}




}
