package ncis.cmn.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.validation.constraints.Size;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cpt.rsrc.com.config.ComConstant;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 클러스터 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author 심원보
 */

public class RcClstr {

    /**
     * 클러스터SEQ
     */
    private BigDecimal clstrSeq;

    /**
     * 클러스터ID
     */
    private String clstrId;

    /**
     * 클러스터명
     */
    private String clstrNm;

    /**
     * 클러스터구성ID
     */
    /*@NotEmpty(message = "클러스터구성ID를 입력해주세요.", groups = { UpdateProc.class })*/
    @Size(message = "클러스터구성ID는 {max}자 이내로 입력해주세요.", min = 0, max = ComConstant.CLSTR_COMP_ID_MAX_LENGTH, groups = { UpdateProc.class })
    private String clstrCompId;

    /**
     * 사용여부
     */
    @NotEmpty(message = "사용여부를 선택해주세요.", groups = { UpdateProc.class })
    private String useYn;

    /**
     * 테스트여부
     */
    private String testYn;

    /**
     * 삭제여부
     */
    private String delYn;

    /**
     * UUID
     */
    private String uuid;

    /**
     * 등록자ID
     */
    private String regUserId;

    /**
     * 등록일시
     */
    private Timestamp regDttm;

    /**
     * 삭제자ID
     */
    private String delUserId;

    /**
     * 삭제일시
     */
    private Timestamp delDttm;

    /**
     * 수정자ID
     */
    private String updtUserId;

    /**
     * 수정일시
     */
    private Timestamp updtDttm;

    /**
     * 자원풀ID
     */
    private String rsrcPoolId;

    /**
     * 비고
     */
    @Size(message = "비고는 {max}자 이내로 입력해주세요.", min = 0, max = ComConstant.CLSTR_RMK_MAX_LENGTH, groups = { UpdateProc.class })
    private String rmk;

    public BigDecimal getClstrSeq() {
        return clstrSeq;
    }

    public void setClstrSeq(BigDecimal clstrSeq) {
        this.clstrSeq = clstrSeq;
    }

    public String getClstrId() {
        return clstrId;
    }

    public void setClstrId(String clstrId) {
        this.clstrId = clstrId;
    }

    public String getClstrNm() {
        return clstrNm;
    }

    public void setClstrNm(String clstrNm) {
        this.clstrNm = clstrNm;
    }

    public String getClstrCompId() {
        return clstrCompId;
    }

    public void setClstrCompId(String clstrCompId) {
        this.clstrCompId = clstrCompId;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    public String getTestYn() {
        return testYn;
    }

    public void setTestYn(String testYn) {
        this.testYn = testYn;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRegUserId() {
        return regUserId;
    }

    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    public Timestamp getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(Timestamp regDttm) {
        this.regDttm = regDttm;
    }

    public String getDelUserId() {
        return delUserId;
    }

    public void setDelUserId(String delUserId) {
        this.delUserId = delUserId;
    }

    public Timestamp getDelDttm() {
        return delDttm;
    }

    public void setDelDttm(Timestamp delDttm) {
        this.delDttm = delDttm;
    }

    public String getUpdtUserId() {
        return updtUserId;
    }

    public void setUpdtUserId(String updtUserId) {
        this.updtUserId = updtUserId;
    }

    public Timestamp getUpdtDttm() {
        return updtDttm;
    }

    public void setUpdtDttm(Timestamp updtDttm) {
        this.updtDttm = updtDttm;
    }

    public String getRsrcPoolId() {
        return rsrcPoolId;
    }

    public void setRsrcPoolId(String rsrcPoolId) {
        this.rsrcPoolId = rsrcPoolId;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

}
