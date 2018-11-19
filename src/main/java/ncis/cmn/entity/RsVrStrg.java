package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 가상스토리지 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RsVrStrg {

    /**
     * 스토리지도메인SEQ
     */
    @NotEmpty(message = "스토리지도메인SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal strgDmnSeq;

    /**
     * 스토리지도메인명
     */
    @NotEmpty(message = "스토리지도메인명는(은) 필수입력 항목입니다.")
    private String strgDmnNm;

    /**
     * 스토리지도메인유형코드
     */
    @NotEmpty(message = "스토리지도메인유형코드는(은) 필수입력 항목입니다.")
    private String strgDmnTyCd;

    /**
     * 생성일자
     */
    @NotEmpty(message = "생성일자는(은) 필수입력 항목입니다.")
    private String creDt;

    /**
     * 전체할당용량(GB)
     */
    private BigDecimal wholeAsgnCapa;

    /**
     * 스토리지사용용량(GB)
     */
    private BigDecimal strgUseCapa;

    /**
     * 가상서버할당량(GB)
     */
    private BigDecimal vmAsgnCapa;

    /**
     * 스토리지여유량(GB)
     */
    private BigDecimal strMrgnCapa;

    /**
     * 템플릿할당용량(GB)
     */
    private BigDecimal tmplatAsgnCapa;

    /**
     * UUID
     */
    private String uuid;

    /**
     * 자원풀ID
     */
    @NotEmpty(message = "자원풀ID는(은) 필수입력 항목입니다.")
    private String rsrcPoolId;

    /**
     * 삭제 사용자 ID
     */
    private String delUserId;

    /**
     * 삭제여부
     */
    private String delYn;

    /**
     * 삭제시간
     */
    private String delDttm;

    public BigDecimal getStrgDmnSeq() {
        return strgDmnSeq;
    }

    public void setStrgDmnSeq(BigDecimal strgDmnSeq) {
        this.strgDmnSeq = strgDmnSeq;
    }

    public String getStrgDmnNm() {
        return strgDmnNm;
    }

    public void setStrgDmnNm(String strgDmnNm) {
        this.strgDmnNm = strgDmnNm;
    }

    public String getStrgDmnTyCd() {
        return strgDmnTyCd;
    }

    public void setStrgDmnTyCd(String strgDmnTyCd) {
        this.strgDmnTyCd = strgDmnTyCd;
    }

    public String getCreDt() {
        return creDt;
    }

    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    public BigDecimal getWholeAsgnCapa() {
        return wholeAsgnCapa;
    }

    public void setWholeAsgnCapa(BigDecimal wholeAsgnCapa) {
        this.wholeAsgnCapa = wholeAsgnCapa;
    }

    public BigDecimal getStrgUseCapa() {
        return strgUseCapa;
    }

    public void setStrgUseCapa(BigDecimal strgUseCapa) {
        this.strgUseCapa = strgUseCapa;
    }

    public BigDecimal getVmAsgnCapa() {
        return vmAsgnCapa;
    }

    public void setVmAsgnCapa(BigDecimal vmAsgnCapa) {
        this.vmAsgnCapa = vmAsgnCapa;
    }

    public BigDecimal getStrMrgnCapa() {
        return strMrgnCapa;
    }

    public void setStrMrgnCapa(BigDecimal strMrgnCapa) {
        this.strMrgnCapa = strMrgnCapa;
    }

    public BigDecimal getTmplatAsgnCapa() {
        return tmplatAsgnCapa;
    }

    public void setTmplatAsgnCapa(BigDecimal tmplatAsgnCapa) {
        this.tmplatAsgnCapa = tmplatAsgnCapa;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    public String getDelDttm() {
        return delDttm;
    }

    public void setDelDttm(String delDttm) {
        this.delDttm = delDttm;
    }

}
