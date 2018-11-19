package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 패키지 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class OaPackg {

    /**
     * 패키지ID
     */
    @NotEmpty(message = "패키지ID는(은) 필수입력 항목입니다.")
    private BigDecimal packgId;

    /**
     * 패키지명
     */
    @NotEmpty(message = "패키지명는(은) 필수입력 항목입니다.")
    private String packgNm;

    /**
     * 사용용도
     */
    @NotEmpty(message = "사용용도는(은) 필수입력 항목입니다.")
    private String usePrpos;

    /**
     * 시스템종류코드
     */
    private String sysKndCd;

    /**
     * 제공회사
     */
    private String supplyCo;

    /**
     * 라이선스
     */
    private String licnse;

    /**
     * 리전ID
     */
    @NotEmpty(message = "리전ID는(은) 필수입력 항목입니다.")
    private String regionId;

    /**
     * 망구분코드
     */
    @NotEmpty(message = "망구분코드는(은) 필수입력 항목입니다.")
    private String netClCd;

    /**
	* 레파지토리ID
	*/
    private String repositId;

	/**
	* 삭제여부
	*/
    private String delYn;

	/**
	* 삭제자ID
	*/
    private String delUserId;

	/**
	* 삭제일시
	*/
    private String delDttm;

    public BigDecimal getPackgId() {
        return packgId;
    }

    public void setPackgId(BigDecimal packgId) {
        this.packgId = packgId;
    }

    public String getPackgNm() {
        return packgNm;
    }

    public void setPackgNm(String packgNm) {
        this.packgNm = packgNm;
    }

    public String getUsePrpos() {
        return usePrpos;
    }

    public void setUsePrpos(String usePrpos) {
        this.usePrpos = usePrpos;
    }

    public String getSysKndCd() {
        return sysKndCd;
    }

    public void setSysKndCd(String sysKndCd) {
        this.sysKndCd = sysKndCd;
    }

    public String getSupplyCo() {
        return supplyCo;
    }

    public void setSupplyCo(String supplyCo) {
        this.supplyCo = supplyCo;
    }

    public String getLicnse() {
        return licnse;
    }

    public void setLicnse(String licnse) {
        this.licnse = licnse;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getNetClCd() {
        return netClCd;
    }

    public void setNetClCd(String netClCd) {
        this.netClCd = netClCd;
    }

    public String getRepositId() {
		return repositId;
	}

	public void setRepositId(String repositId) {
		this.repositId = repositId;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getDelUserId() {
		return delUserId;
	}

	public void setDelUserId(String delUserId) {
		this.delUserId = delUserId;
	}

	public String getDelDttm() {
		return delDttm;
	}

	public void setDelDttm(String delDttm) {
		this.delDttm = delDttm;
	}

}
