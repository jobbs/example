package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 스토리지구성정보 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class SiStrgComp {

    /**
     * 구성ID
     */
    @NotEmpty(message = "구성ID는(은) 필수입력 항목입니다.")
    private String compId;

    /**
     * 구성구분코드
     */
    @NotEmpty(message = "구성구분코드는(은) 필수입력 항목입니다.")
    private String compClCd;

    /**
     * 스토리지구분
     */
    @NotEmpty(message = "스토리지구분는(은) 필수입력 항목입니다.")
    private String strgCl;

    /**
     * 디스크채널유형코드
     */
    private String dskChnnlTyCd;

    /**
     * 스토리지연결방식
     */
    private String strgConnMethod;

    /**
     * RAID구성여부
     */
    private String raidCompYn;

    /**
     * 스토리지할당용량(GB)
     */
    private BigDecimal strgAsgnCapa;

    /**
     * 스토리지가용용량(GB)
     */
    private BigDecimal strgUsefulCapa;

    /**
     * 재기동주기일수
     */
    private BigDecimal reStrtCycleDtNo;

    /**
     * 최근재기동일자
     */
    private String rcntReStrtDt;

    /**
     * 재기동문자수신여부
     */
    private String reStrtLttrRcivYn;

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getCompClCd() {
        return compClCd;
    }

    public void setCompClCd(String compClCd) {
        this.compClCd = compClCd;
    }

    public String getStrgCl() {
        return strgCl;
    }

    public void setStrgCl(String strgCl) {
        this.strgCl = strgCl;
    }

    public String getDskChnnlTyCd() {
        return dskChnnlTyCd;
    }

    public void setDskChnnlTyCd(String dskChnnlTyCd) {
        this.dskChnnlTyCd = dskChnnlTyCd;
    }

    public String getStrgConnMethod() {
        return strgConnMethod;
    }

    public void setStrgConnMethod(String strgConnMethod) {
        this.strgConnMethod = strgConnMethod;
    }

    public String getRaidCompYn() {
        return raidCompYn;
    }

    public void setRaidCompYn(String raidCompYn) {
        this.raidCompYn = raidCompYn;
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

    public BigDecimal getReStrtCycleDtNo() {
        return reStrtCycleDtNo;
    }

    public void setReStrtCycleDtNo(BigDecimal reStrtCycleDtNo) {
        this.reStrtCycleDtNo = reStrtCycleDtNo;
    }

    public String getRcntReStrtDt() {
        return rcntReStrtDt;
    }

    public void setRcntReStrtDt(String rcntReStrtDt) {
        this.rcntReStrtDt = rcntReStrtDt;
    }

    public String getReStrtLttrRcivYn() {
        return reStrtLttrRcivYn;
    }

    public void setReStrtLttrRcivYn(String reStrtLttrRcivYn) {
        this.reStrtLttrRcivYn = reStrtLttrRcivYn;
    }

}
