package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 통보설정 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class StDspthConf {

    /**
     * 통보설정ID
     */
    @NotEmpty(message = "통보설정ID는(은) 필수입력 항목입니다.")
    private BigDecimal dspthConfId;

    /**
     * 대상서버구분코드
     */
    @NotEmpty(message = "대상서버구분코드는(은) 필수입력 항목입니다.")
    private String trgtSrvrClCd;

    /**
     * 임계치대상서버ID
     */
    @NotEmpty(message = "임계치대상서버ID는(은) 필수입력 항목입니다.")
    private String thresTrgtSrvrId;

    /**
     * 장비권한자통보여부
     */
    private String eqpAuthrDspthYn;

    public BigDecimal getDspthConfId() {
        return dspthConfId;
    }

    public void setDspthConfId(BigDecimal dspthConfId) {
        this.dspthConfId = dspthConfId;
    }

    public String getTrgtSrvrClCd() {
        return trgtSrvrClCd;
    }

    public void setTrgtSrvrClCd(String trgtSrvrClCd) {
        this.trgtSrvrClCd = trgtSrvrClCd;
    }

    public String getThresTrgtSrvrId() {
        return thresTrgtSrvrId;
    }

    public void setThresTrgtSrvrId(String thresTrgtSrvrId) {
        this.thresTrgtSrvrId = thresTrgtSrvrId;
    }

    public String getEqpAuthrDspthYn() {
        return eqpAuthrDspthYn;
    }

    public void setEqpAuthrDspthYn(String eqpAuthrDspthYn) {
        this.eqpAuthrDspthYn = eqpAuthrDspthYn;
    }

}
