package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 배치작업실행이력 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class CmBtchExeHist {

    /**
     * 배치작업SEQ
     */
    @NotEmpty(message = "배치작업SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal btchWrkId;

    /**
     * 배치실행일시
     */
    @NotEmpty(message = "배치실행일시는(은) 필수입력 항목입니다.")
    private String btchExeDttm;

    /**
     * 배치작업명
     */
    private String btchWrkNm;

    /**
     * 배치실행완료일시
     */
    private String btchExeEndDttm;

    /**
     * 주기
     */
    private String cycle;

    /**
     * 수집상태코드
     */
    private String colctStatCd;

    /**
     * 작업결과내용
     */
    private String wrkRsltCn;

    public BigDecimal getBtchWrkId() {
        return btchWrkId;
    }

    public void setBtchWrkId(BigDecimal btchWrkId) {
        this.btchWrkId = btchWrkId;
    }

    public String getBtchExeDttm() {
        return btchExeDttm;
    }

    public void setBtchExeDttm(String btchExeDttm) {
        this.btchExeDttm = btchExeDttm;
    }

    public String getBtchWrkNm() {
        return btchWrkNm;
    }

    public void setBtchWrkNm(String btchWrkNm) {
        this.btchWrkNm = btchWrkNm;
    }

    public String getBtchExeEndDttm() {
        return btchExeEndDttm;
    }

    public void setBtchExeEndDttm(String btchExeEndDttm) {
        this.btchExeEndDttm = btchExeEndDttm;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getColctStatCd() {
        return colctStatCd;
    }

    public void setColctStatCd(String colctStatCd) {
        this.colctStatCd = colctStatCd;
    }

    public String getWrkRsltCn() {
        return wrkRsltCn;
    }

    public void setWrkRsltCn(String wrkRsltCn) {
        this.wrkRsltCn = wrkRsltCn;
    }

}
