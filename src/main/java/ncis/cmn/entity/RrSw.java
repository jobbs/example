package ncis.cmn.entity;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 소프트웨어 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrSw {

    /**
     * 소프트웨어ID
     */
    private Integer swSeq;

    /**
     * 소프트웨어명
     */
    @NotEmpty(message = "소프트웨어명은 필수입력 항목입니다.")
    @Size(max=60, message="소프트웨어명의 최대 길이는 최대 60자까지 허용합니다.")
    private String swNm;

    /**
     * 구성ID
     */
    private String compId;

    /**
     * 소프트웨어버전
     */
    @NotEmpty(message = "소프트웨어버전은 필수입력 항목입니다.")
    @Size(max=30, message="소프트웨어버전의 최대 길이는 최대 30자까지 허용합니다.")
    private String swVer;

    /**
     * 소프트웨어제조사
     */
    @Size(max=30, message="소프트웨어제조사의 최대 길이는 최대 30자까지 허용합니다.")
    private String swMnfctCo;

    /**
     * 비고
     */
    @Size(max=1000, message="비고의 최대 길이는 최대 1000자까지 허용합니다.")
    private String rmk;

    /**
     * 생성자ID
     */
    private String creUserId;

    /**
     * 수정자ID
     */
    private String updtUserId;

    /**
     * 생성일시
     */
    private Date creDttm;

    /**
     * 수정일시
     */
    private Date updtDttm;

	/**
	 * @return the swSeq
	 */
	public Integer getSwSeq() {
		return swSeq;
	}

	/**
	 * @param swSeq the swSeq to set
	 */
	public void setSwSeq(Integer swSeq) {
		this.swSeq = swSeq;
	}

	/**
	 * @return the swNm
	 */
	public String getSwNm() {
		return swNm;
	}

	/**
	 * @param swNm the swNm to set
	 */
	public void setSwNm(String swNm) {
		this.swNm = swNm;
	}

	/**
	 * @return the compId
	 */
	public String getCompId() {
		return compId;
	}

	/**
	 * @param compId the compId to set
	 */
	public void setCompId(String compId) {
		this.compId = compId;
	}

	/**
	 * @return the swVer
	 */
	public String getSwVer() {
		if(null == swVer){
			return null;
		}
		return swVer.trim();
	}

	/**
	 * @param swVer the swVer to set
	 */
	public void setSwVer(String swVer) {
		this.swVer = swVer;
	}

	/**
	 * @return the swMnfctCo
	 */
	public String getSwMnfctCo() {
		return swMnfctCo;
	}

	/**
	 * @param swMnfctCo the swMnfctCo to set
	 */
	public void setSwMnfctCo(String swMnfctCo) {
		this.swMnfctCo = swMnfctCo;
	}

	/**
	 * @return the rmk
	 */
	public String getRmk() {
		return rmk;
	}

	/**
	 * @param rmk the rmk to set
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	/**
	 * @return the creUserId
	 */
	public String getCreUserId() {
		return creUserId;
	}

	/**
	 * @param creUserId the creUserId to set
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
	 * @param updtUserId the updtUserId to set
	 */
	public void setUpdtUserId(String updtUserId) {
		this.updtUserId = updtUserId;
	}

	/**
	 * @return the creDttm
	 */
	public Date getCreDttm() {
		return creDttm;
	}

	/**
	 * @param creDttm the creDttm to set
	 */
	public void setCreDttm(Date creDttm) {
		this.creDttm = creDttm;
	}

	/**
	 * @return the updtDttm
	 */
	public Date getUpdtDttm() {
		return updtDttm;
	}

	/**
	 * @param updtDttm the updtDttm to set
	 */
	public void setUpdtDttm(Date updtDttm) {
		this.updtDttm = updtDttm;
	}


}
