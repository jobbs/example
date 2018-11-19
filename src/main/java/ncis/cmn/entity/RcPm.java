/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RcPm.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     심원보         v1.0             최초생성
 *
 */
package ncis.cmn.entity;

import java.math.BigDecimal;
import javax.validation.constraints.Size;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cpt.rsrc.com.config.ComConstant;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 심원보
 *
 */
public class RcPm {

    private BigDecimal pmSeq; /* 물리서버SEQ */
    private String pmId; /* 물리서버ID */
    private String pmNm; /* 물리서버명 */
    private String statCd; /* 상태코드 */
    private String rprsntIpAddr; /* 대표IP주소 */
    private Double cpuUseRt; /* CPU사용율 */
    private BigDecimal cpuCoreQty; /* 물리CPU(코어) */
    private BigDecimal memCapa; /* 총메모리용량(MB) */
    private Double memUseRt; /* 메모리사용율 */
    private String uuid; /* UUID */
    @NotEmpty(message = "물리서버구성ID를 입력해주세요.", groups = { UpdateProc.class })
    @Size(message = "물리서버구성ID는 {max}자 이내로 입력해주세요.", min = 0, max = ComConstant.PM_COMP_ID_MAX_LENGTH, groups = { UpdateProc.class })
    private String pmCompId; /* 물리서버구성ID */
    private BigDecimal clstrSeq; /* 클러스터SEQ */
    private String pmClCd; /* 물리서버구분코드 */
    private String regUserId; /* 등록자ID */
    private String regDttm; /* 등록일시 */
    private String delUserId; /* 삭제자ID */
    private String delDttm; /* 삭제일시 */
    private String updtUserId; /* 수정자ID */
    private String updtDttm; /* 수정일시 */
    private Double netwkIn; /* 네트워크_IN(KB/Sec) */
    private Double netwkOut; /* 네트워크_OUT(KB/Sec) */
    @Size(message = "비고는 {max}자 이내로 입력해주세요.", min = 0, max = ComConstant.PM_RMK_MAX_LENGTH, groups = { UpdateProc.class })
    private String rmk; /* 비고 */
    private String delYn;

    public BigDecimal getPmSeq() {
        return pmSeq;
    }

    public void setPmSeq(BigDecimal pmSeq) {
        this.pmSeq = pmSeq;
    }

    public String getPmId() {
        return pmId;
    }

    public void setPmId(String pmId) {
        this.pmId = pmId;
    }

    public String getPmNm() {
        return pmNm;
    }

    public void setPmNm(String pmNm) {
        this.pmNm = pmNm;
    }

    public String getStatCd() {
        return statCd;
    }

    public void setStatCd(String statCd) {
        this.statCd = statCd;
    }

    public String getRprsntIpAddr() {
        return rprsntIpAddr;
    }

    public void setRprsntIpAddr(String rprsntIpAddr) {
        this.rprsntIpAddr = rprsntIpAddr;
    }

    public Double getCpuUseRt() {
        return cpuUseRt;
    }

    public void setCpuUseRt(Double cpuUseRt) {
        this.cpuUseRt = cpuUseRt;
    }

    public BigDecimal getCpuCoreQty() {
        return cpuCoreQty;
    }

    public void setCpuCoreQty(BigDecimal cpuCoreQty) {
        this.cpuCoreQty = cpuCoreQty;
    }

    public BigDecimal getMemCapa() {
        return memCapa;
    }

    public void setMemCapa(BigDecimal memCapa) {
        this.memCapa = memCapa;
    }

    public Double getMemUseRt() {
        return memUseRt;
    }

    public void setMemUseRt(Double memUseRt) {
        this.memUseRt = memUseRt;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPmCompId() {
        return pmCompId;
    }

    public void setPmCompId(String pmCompId) {
        this.pmCompId = pmCompId;
    }

    public BigDecimal getClstrSeq() {
        return clstrSeq;
    }

    public void setClstrSeq(BigDecimal clstrSeq) {
        this.clstrSeq = clstrSeq;
    }

    public String getPmClCd() {
        return pmClCd;
    }

    public void setPmClCd(String pmClCd) {
        this.pmClCd = pmClCd;
    }

    public String getRegUserId() {
        return regUserId;
    }

    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    public String getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(String regDttm) {
        this.regDttm = regDttm;
    }

    public String getDelUserId() {
        return delUserId;
    }

    public void setDelUserId(String delUserId) {
        this.delUserId = delUserId;
    }

    public String getDelDttm() {
        return delDttm;
    }

    public void setDelDttm(String delDttm) {
        this.delDttm = delDttm;
    }

    public String getUpdtUserId() {
        return updtUserId;
    }

    public void setUpdtUserId(String updtUserId) {
        this.updtUserId = updtUserId;
    }

    public String getUpdtDttm() {
        return updtDttm;
    }

    public void setUpdtDttm(String updtDttm) {
        this.updtDttm = updtDttm;
    }

    public Double getNetwkIn() {
        return netwkIn;
    }

    public void setNetwkIn(Double netwkIn) {
        this.netwkIn = netwkIn;
    }

    public Double getNetwkOut() {
        return netwkOut;
    }

    public void setNetwkOut(Double netwkOut) {
        this.netwkOut = netwkOut;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
}
