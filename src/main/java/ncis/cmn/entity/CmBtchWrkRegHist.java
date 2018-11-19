package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 배치작업등록이력 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class CmBtchWrkRegHist {

    /**
     * 배치작업SEQ
     */
    @NotEmpty(message = "배치작업SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal btchWrkId;

    /**
     * 등록일시
     */
    @NotEmpty(message = "등록일시는(은) 필수입력 항목입니다.")
    private String regDttm;

    /**
     * 배치작업명
     */
    private String btchWrkNm;

    /**
     * 주기
     */
    private BigDecimal cycle;

    /**
     * 시점
     */
    private String time;

    /**
     * 상태
     */
    private String stat;

    /**
     * 유효시작일자
     */
    private String validStrtDt;

    /**
     * 유효종료일자
     */
    private String validEndDt;

    /**
     * 등록사용자ID
     */
    private String regUserId;

    public BigDecimal getBtchWrkId() {
        return btchWrkId;
    }

    public void setBtchWrkId(BigDecimal btchWrkId) {
        this.btchWrkId = btchWrkId;
    }

    public String getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(String regDttm) {
        this.regDttm = regDttm;
    }

    public String getBtchWrkNm() {
        return btchWrkNm;
    }

    public void setBtchWrkNm(String btchWrkNm) {
        this.btchWrkNm = btchWrkNm;
    }

    public BigDecimal getCycle() {
        return cycle;
    }

    public void setCycle(BigDecimal cycle) {
        this.cycle = cycle;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getValidStrtDt() {
        return validStrtDt;
    }

    public void setValidStrtDt(String validStrtDt) {
        this.validStrtDt = validStrtDt;
    }

    public String getValidEndDt() {
        return validEndDt;
    }

    public void setValidEndDt(String validEndDt) {
        this.validEndDt = validEndDt;
    }

    public String getRegUserId() {
        return regUserId;
    }

    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

}
