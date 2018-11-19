package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 물리스토리지_공통 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RsPStrgComm {

    /**
     * 물리스토리지ID
     */
    @NotEmpty(message = "물리스토리지ID는(은) 필수입력 항목입니다.")
    private String phyStrgId;

    /**
     * 물리스토리지명
     */
    @NotEmpty(message = "물리스토리지명는(은) 필수입력 항목입니다.")
    private String phyStrgNm;

    /**
     * 구성구분코드
     */
    private String compClCd;

    /**
     * 리전ID
     */
    @NotEmpty(message = "리전ID는(은) 필수입력 항목입니다.")
    private String regionId;

    /**
     * 자산ID
     */
    private String assetsId;

    /**
     * 구성ID
     */
    private String compId;

    /**
     * 구성자원명
     */
    private String compRsrcNm;

    /**
     * 상위구성ID
     */
    private String upperCompId;

    /**
     * 모델코드
     */
    private String modlCd;

    /**
     * 제조사코드
     */
    private String mnfctCoCd;

    /**
     * 시리얼번호
     */
    private String serialNo;

    /**
     * 장비고유식별번호
     */
    private String eqpUniqIdNo;

    /**
     * 사용부서ID
     */
    private String useDeptId;

    /**
     * 운영상태코드
     */
    private String oprStatCd;

    /**
     * 운영담당자ID
     */
    private String oprChargerId;

    /**
     * 위탁운영사용자ID
     */
    private String cnsgnOprUserId;

    /**
     * 스토리지할당용량(GB)
     */
    private BigDecimal strgAsgnCapa;

    /**
     * 스토리지가용용량(GB)
     */
    private BigDecimal strgUsefulCapa;

    /**
     * 스토리지사용용량(GB)
     */
    private BigDecimal strgUseCapa;

    /**
     * 자원풀ID
     */
    @NotEmpty(message = "자원풀ID는(은) 필수입력 항목입니다.")
    private String rsrcPoolId;

    /**
     * 삭제자ID
     */
    private String delUserId;

    /**
     * 삭제일시
     */
    private String delDttm;

    /**
     * 삭제여부
     */
    private String delYn;


    public String getPhyStrgId() {
        return phyStrgId;
    }

    public void setPhyStrgId(String phyStrgId) {
        this.phyStrgId = phyStrgId;
    }

    public String getPhyStrgNm() {
        return phyStrgNm;
    }

    public void setPhyStrgNm(String phyStrgNm) {
        this.phyStrgNm = phyStrgNm;
    }

    public String getCompClCd() {
        return compClCd;
    }

    public void setCompClCd(String compClCd) {
        this.compClCd = compClCd;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(String assetsId) {
        this.assetsId = assetsId;
    }

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getCompRsrcNm() {
        return compRsrcNm;
    }

    public void setCompRsrcNm(String compRsrcNm) {
        this.compRsrcNm = compRsrcNm;
    }

    public String getUpperCompId() {
        return upperCompId;
    }

    public void setUpperCompId(String upperCompId) {
        this.upperCompId = upperCompId;
    }

    public String getModlCd() {
        return modlCd;
    }

    public void setModlCd(String modlCd) {
        this.modlCd = modlCd;
    }

    public String getMnfctCoCd() {
        return mnfctCoCd;
    }

    public void setMnfctCoCd(String mnfctCoCd) {
        this.mnfctCoCd = mnfctCoCd;
    }

    public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getEqpUniqIdNo() {
        return eqpUniqIdNo;
    }

    public void setEqpUniqIdNo(String eqpUniqIdNo) {
        this.eqpUniqIdNo = eqpUniqIdNo;
    }

    public String getUseDeptId() {
        return useDeptId;
    }

    public void setUseDeptId(String useDeptId) {
        this.useDeptId = useDeptId;
    }

    public String getOprStatCd() {
        return oprStatCd;
    }

    public void setOprStatCd(String oprStatCd) {
        this.oprStatCd = oprStatCd;
    }

    public String getOprChargerId() {
        return oprChargerId;
    }

    public void setOprChargerId(String oprChargerId) {
        this.oprChargerId = oprChargerId;
    }

    public String getCnsgnOprUserId() {
        return cnsgnOprUserId;
    }

    public void setCnsgnOprUserId(String cnsgnOprUserId) {
        this.cnsgnOprUserId = cnsgnOprUserId;
    }

    public BigDecimal getStrgAsgnCapa() {
        return strgAsgnCapa;
    }

    public void setStrgAsgnCapa(BigDecimal strgAsgnCapa) {
        this.strgAsgnCapa = strgAsgnCapa;
    }

    public BigDecimal getStrgUsefulCapa() {
        return strgUsefulCapa;
    }

    public void setStrgUsefulCapa(BigDecimal strgUsefulCapa) {
        this.strgUsefulCapa = strgUsefulCapa;
    }

    public BigDecimal getStrgUseCapa() {
        return strgUseCapa;
    }

    public void setStrgUseCapa(BigDecimal strgUseCapa) {
        this.strgUseCapa = strgUseCapa;
    }

    public String getRsrcPoolId() {
        return rsrcPoolId;
    }

    public void setRsrcPoolId(String rsrcPoolId) {
        this.rsrcPoolId = rsrcPoolId;
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

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
}
