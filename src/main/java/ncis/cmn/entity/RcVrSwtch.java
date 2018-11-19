package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 가상스위치(VLAN) Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RcVrSwtch {

    /**
     * 가상스위치SEQ
     */
    @NotEmpty(message = "가상스위치SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal vrSwtchSeq;

    /**
     * 네트워크명
     */
    @NotEmpty(message = "네트워크명는(은) 필수입력 항목입니다.")
    private String netwkNm;

    /**
     * 가상스위치UUID
     */
    private String vrSwtchUuid;

    /**
     * VLAN
     */
    private String vlan;

    /**
     * 자원풀ID
     */
    @NotEmpty(message = "자원풀ID는(은) 필수입력 항목입니다.")
    private String rsrcPoolId;

    public String getNetwkNm() {
        return netwkNm;
    }

    public void setNetwkNm(String netwkNm) {
        this.netwkNm = netwkNm;
    }

    public String getVrSwtchUuid() {
        return vrSwtchUuid;
    }

    public void setVrSwtchUuid(String vrSwtchUuid) {
        this.vrSwtchUuid = vrSwtchUuid;
    }

    public String getVlan() {
        return vlan;
    }

    public void setVlan(String vlan) {
        this.vlan = vlan;
    }

    public String getRsrcPoolId() {
        return rsrcPoolId;
    }

    public void setRsrcPoolId(String rsrcPoolId) {
        this.rsrcPoolId = rsrcPoolId;
    }

    public BigDecimal getVrSwtchSeq() {
        return vrSwtchSeq;
    }

    public void setVrSwtchSeq(BigDecimal vrSwtchSeq) {
        this.vrSwtchSeq = vrSwtchSeq;
    }

}
