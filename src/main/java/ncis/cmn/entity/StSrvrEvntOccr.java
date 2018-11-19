package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 서버별이벤트발생 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class StSrvrEvntOccr {

    /**
     * 지표항목ID
     */
    @NotEmpty(message = "지표항목ID는(은) 필수입력 항목입니다.")
    private BigDecimal idxItmId;

    /**
     * 임계치대상서버ID
     */
    @NotEmpty(message = "임계치대상서버ID는(은) 필수입력 항목입니다.")
    private String thresTrgtSrvrId;

    /**
     * 임계등급ID
     */
    @NotEmpty(message = "임계등급ID는(은) 필수입력 항목입니다.")
    private BigDecimal thresGrdId;

    /**
     * 최근발생일시
     */
    private String rcntOccrDttm;

    /**
     * 연속발생횟수
     */
    @NotEmpty(message = "연속발생횟수는(은) 필수입력 항목입니다.")
    private BigDecimal contOccrCnt;

    public BigDecimal getIdxItmId() {
        return idxItmId;
    }

    public void setIdxItmId(BigDecimal idxItmId) {
        this.idxItmId = idxItmId;
    }

    public String getThresTrgtSrvrId() {
        return thresTrgtSrvrId;
    }

    public void setThresTrgtSrvrId(String thresTrgtSrvrId) {
        this.thresTrgtSrvrId = thresTrgtSrvrId;
    }

    public BigDecimal getThresGrdId() {
        return thresGrdId;
    }

    public void setThresGrdId(BigDecimal thresGrdId) {
        this.thresGrdId = thresGrdId;
    }

    public String getRcntOccrDttm() {
        return rcntOccrDttm;
    }

    public void setRcntOccrDttm(String rcntOccrDttm) {
        this.rcntOccrDttm = rcntOccrDttm;
    }

    public BigDecimal getContOccrCnt() {
        return contOccrCnt;
    }

    public void setContOccrCnt(BigDecimal contOccrCnt) {
        this.contOccrCnt = contOccrCnt;
    }

}
