package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * LUN Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RsLun {

    /**
     * LUN_ID
     */
    @NotEmpty(message = "LUN_ID는(은) 필수입력 항목입니다.")
    private BigDecimal lunId;

    /**
     * LUN명
     */
    @NotEmpty(message = "LUN명는(은) 필수입력 항목입니다.")
    private String lunNm;

    /**
     * 용량
     */
    private BigDecimal capa;

    /**
     * 스토리지유형코드
     */
    private String strgTyCd;

    /**
     * 정의여부
     */
    private String dfnYn;

    /**
     * 자원풀ID
     */
    @NotEmpty(message = "자원풀ID는(은) 필수입력 항목입니다.")
    private String rsrcPoolId;

    /**
     * 할당여부
     */
    private String asgnYn;

    /**
     * WWID
     */
    private String wwid;

    /**
     * 스토리지도메인SEQ
     */
    @NotEmpty(message = "스토리지도메인SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal strgDmnId;

    /**
     * 물리스토리지ID
     */
    @NotEmpty(message = "물리스토리지ID는(은) 필수입력 항목입니다.")
    private String phyStrgId;

    public BigDecimal getLunId() {
        return lunId;
    }

    public void setLunId(BigDecimal lunId) {
        this.lunId = lunId;
    }

    public String getLunNm() {
        return lunNm;
    }

    public void setLunNm(String lunNm) {
        this.lunNm = lunNm;
    }

    public BigDecimal getCapa() {
        return capa;
    }

    public void setCapa(BigDecimal capa) {
        this.capa = capa;
    }

    public String getStrgTyCd() {
        return strgTyCd;
    }

    public void setStrgTyCd(String strgTyCd) {
        this.strgTyCd = strgTyCd;
    }

    public String getDfnYn() {
        return dfnYn;
    }

    public void setDfnYn(String dfnYn) {
        this.dfnYn = dfnYn;
    }

    public String getRsrcPoolId() {
        return rsrcPoolId;
    }

    public void setRsrcPoolId(String rsrcPoolId) {
        this.rsrcPoolId = rsrcPoolId;
    }

    public String getAsgnYn() {
        return asgnYn;
    }

    public void setAsgnYn(String asgnYn) {
        this.asgnYn = asgnYn;
    }

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public BigDecimal getStrgDmnId() {
        return strgDmnId;
    }

    public void setStrgDmnId(BigDecimal strgDmnId) {
        this.strgDmnId = strgDmnId;
    }

    public String getPhyStrgId() {
        return phyStrgId;
    }

    public void setPhyStrgId(String phyStrgId) {
        this.phyStrgId = phyStrgId;
    }

}
