package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 스토리지삭제요청목록 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrStrgDelReqList {

    /**
     * 가상디스크ID
     */
    @NotEmpty(message = "가상디스크ID는(은) 필수입력 항목입니다.")
    private Integer vrDskId;

    /**
     * 자원요청번호
     */
    @NotEmpty(message = "자원요청번호는(은) 필수입력 항목입니다.")
    private String rsrcReqNo;

    /**
     * 자원요청일련번호
     */
    @NotEmpty(message = "자원요청일련번호는(은) 필수입력 항목입니다.")
    private BigDecimal rsrcReqSeq;

    public Integer getVrDskId() {
        return vrDskId;
    }

    public void setVrDskId(Integer vrDskId) {
        this.vrDskId = vrDskId;
    }

    public String getRsrcReqNo() {
        return rsrcReqNo;
    }

    public void setRsrcReqNo(String rsrcReqNo) {
        this.rsrcReqNo = rsrcReqNo;
    }

    public BigDecimal getRsrcReqSeq() {
        return rsrcReqSeq;
    }

    public void setRsrcReqSeq(BigDecimal rsrcReqSeq) {
        this.rsrcReqSeq = rsrcReqSeq;
    }

}
