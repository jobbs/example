package ncis.cmn.entity;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.com.validation.InsertClstrCreReqValidation;
import ncis.cpt.rsrc.com.validation.InsertClstrDelReqValidation;
import ncis.cpt.rsrc.com.validation.InsertPmCreReqValidation;
import ncis.cpt.rsrc.com.validation.InsertPmDelReqValidation;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 자원요청상세_물리자원 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author 심원보
 */

public class RrRsrcReqDtlPRsrc {

    /**
     * 자원요청번호
     */
    private String rsrcReqNo;

    /**
     * 자원요청일련번호
     */
    private BigDecimal rsrcReqSeq;

    /**
     * 자원요청진행상태코드
     */
    private String rsrcReqPrcssStatCd;

    /**
     * 프로세스인스턴스SEQ
     */
    private BigDecimal procssInstSeq;

    /**
     * 실행일시
     */
    private String exeDttm;

    /**
     * 자원요청내용
     */
    private String rsrcReqCn;

    /**
     * 존ID
     */
    @NotEmpty(message = "존을 선택해주세요.", groups = { InsertClstrCreReqValidation.class, InsertPmCreReqValidation.class })
    private String zoneId;

    /**
     * 망ID
     */
    @NotEmpty(message = "망을 선택해주세요.", groups = { InsertClstrCreReqValidation.class, InsertPmCreReqValidation.class })
    private String netId;

    /**
     * 클러스터구성ID
     */
    @Size(message = "클러스터구성ID는 {max}자 이내로 입력해주세요.", min = 0, max = ComConstant.CLSTR_COMP_ID_MAX_LENGTH, groups = { InsertClstrCreReqValidation.class})
    private String clstrCompId;

    /**
     * 물리서버구성ID
     */
    @Size(message = "물리서버구성ID는 {max}자 이내로 입력해주세요.", min = 0, max = ComConstant.PM_COMP_ID_MAX_LENGTH, groups = { InsertPmCreReqValidation.class})
    private String pmCompId;

    /**
     * 물리서버ID
     */
    private String pmId;

    /**
     * 클러스터명
     */
    @NotEmpty(message = "클러스터명을 입력해주세요.", groups = { InsertClstrCreReqValidation.class })
    @Size(message = "클러스터명은 {max}자 이내로 입력해주세요.", min = 1, max = ComConstant.CLSTR_NM_MAX_LENGTH, groups = { InsertClstrCreReqValidation.class })
    private String clstrNm;

    /**
     * 물리서버명
     */
    @NotEmpty(message = "물리서버명을 입력해주세요.", groups = { InsertPmCreReqValidation.class })
    @Size(message = "물리서버명은 {max}자 이내로 입력해주세요.", min = 1, max = ComConstant.PM_NM_MAX_LENGTH, groups = { InsertPmCreReqValidation.class })
    private String pmNm;

    /**
     * UUID
     */
    private String uuid;

    /**
     * 자원요청유형코드
     */
    private String rsrcReqTyCd;

    /**
     * 매니저ID
     */
    @NotEmpty(message = "자원풀을 선택해주세요.", groups = { InsertClstrCreReqValidation.class, InsertPmCreReqValidation.class })
    private String rsrcPoolId;

    /**
     * 클러스터ID
     */
    private String clstrId;

    /**
     * 완료일시
     */
    private String comptDttm;

    /**
     * 등록일시
     */
    private String regDttm;

    /**
     * 반려 유형
     */
    private String rjctTyCd;

    /**
     * 반려사유
     */
    private String rjctReasn;

    /**
     * 반려일시
     */
    private String rjctDttm;

    /**
     * IP주소
     */
    @NotEmpty(message = "IP주소를 입력해주세요.", groups = { InsertPmCreReqValidation.class })
    @Size(message = "IP주소는 {max}자 이내로 입력해주세요.", min = 7, max = ComConstant.IP_ADDR_MAX_LENGTH, groups = { InsertPmCreReqValidation.class })
    private String ipAddr;

    /**
     * 망구분코드
     */
    private String netClCd;

    /**
     * 물리서버SEQ
     */
    @NotNull(message = "물리서버를 선택해주세요.", groups = { InsertPmDelReqValidation.class})
    private BigDecimal pmSeq;

    /**
     * 클러스터SEQ
     */
    @NotNull(message = "클러스터를 선택해주세요.", groups = { InsertClstrDelReqValidation.class})
    private BigDecimal clstrSeq;

    private BigDecimal dataCntrSeq;

    public String getRsrcReqNo()
    {
        return rsrcReqNo;
    }

    public void setRsrcReqNo(String rsrcReqNo)
    {
        this.rsrcReqNo = rsrcReqNo;
    }

    public BigDecimal getRsrcReqSeq()
    {
        return rsrcReqSeq;
    }

    public void setRsrcReqSeq(BigDecimal rsrcReqSeq)
    {
        this.rsrcReqSeq = rsrcReqSeq;
    }

    public String getRsrcReqPrcssStatCd()
    {
        return rsrcReqPrcssStatCd;
    }

    public void setRsrcReqPrcssStatCd(String rsrcReqPrcssStatCd)
    {
        this.rsrcReqPrcssStatCd = rsrcReqPrcssStatCd;
    }

    public BigDecimal getProcssInstSeq() {
        return procssInstSeq;
    }

    public void setProcssInstSeq(BigDecimal procssInstSeq) {
        this.procssInstSeq = procssInstSeq;
    }

    public String getExeDttm()
    {
        return exeDttm;
    }

    public void setExeDttm(String exeDttm)
    {
        this.exeDttm = exeDttm;
    }

    public String getRsrcReqCn()
    {
        return rsrcReqCn;
    }

    public void setRsrcReqCn(String rsrcReqCn)
    {
        this.rsrcReqCn = rsrcReqCn;
    }

    public String getZoneId()
    {
        return zoneId;
    }

    public void setZoneId(String zoneId)
    {
        this.zoneId = zoneId;
    }

    public String getNetId()
    {
        return netId;
    }

    public void setNetId(String netId)
    {
        this.netId = netId;
    }

    public String getClstrCompId()
    {
        return clstrCompId;
    }

    public void setClstrCompId(String clstrCompId)
    {
        this.clstrCompId = clstrCompId;
    }

    public String getPmCompId()
    {
        return pmCompId;
    }

    public void setPmCompId(String pmCompId)
    {
        this.pmCompId = pmCompId;
    }

    public String getPmId()
    {
        return pmId;
    }

    public void setPmId(String pmId)
    {
        this.pmId = pmId;
    }

    public String getClstrNm()
    {
        return clstrNm;
    }

    public void setClstrNm(String clstrNm)
    {
        this.clstrNm = clstrNm;
    }

    public String getPmNm()
    {
        return pmNm;
    }

    public void setPmNm(String pmNm)
    {
        this.pmNm = pmNm;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getRsrcReqTyCd()
    {
        return rsrcReqTyCd;
    }

    public void setRsrcReqTyCd(String rsrcReqTyCd)
    {
        this.rsrcReqTyCd = rsrcReqTyCd;
    }

    public String getRsrcPoolId()
    {
        return rsrcPoolId;
    }

    public void setRsrcPoolId(String rsrcPoolId)
    {
        this.rsrcPoolId = rsrcPoolId;
    }

    public String getClstrId()
    {
        return clstrId;
    }

    public void setClstrId(String clstrId)
    {
        this.clstrId = clstrId;
    }

    public String getComptDttm()
    {
        return comptDttm;
    }

    public void setComptDttm(String comptDttm)
    {
        this.comptDttm = comptDttm;
    }

    public String getRegDttm()
    {
        return regDttm;
    }

    public void setRegDttm(String regDttm)
    {
        this.regDttm = regDttm;
    }

    public String getRjctTyCd() {
        return rjctTyCd;
    }

    public void setRjctTyCd(String rjctTyCd) {
        this.rjctTyCd = rjctTyCd;
    }

    public String getRjctReasn() {
        return rjctReasn;
    }

    public void setRjctReasn(String rjctReasn) {
        this.rjctReasn = rjctReasn;
    }

    public String getRjctDttm() {
        return rjctDttm;
    }

    public void setRjctDttm(String rjctDttm) {
        this.rjctDttm = rjctDttm;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getNetClCd() {
        return netClCd;
    }

    public void setNetClCd(String netClCd) {
        this.netClCd = netClCd;
    }

    public BigDecimal getPmSeq() {
        return pmSeq;
    }

    public void setPmSeq(BigDecimal pmSeq) {
        this.pmSeq = pmSeq;
    }

    public BigDecimal getClstrSeq() {
        return clstrSeq;
    }

    public void setClstrSeq(BigDecimal clstrSeq) {
        this.clstrSeq = clstrSeq;
    }

	public BigDecimal getDataCntrSeq() {
		return dataCntrSeq;
	}

	public void setDataCntrSeq(BigDecimal dataCntrSeq) {
		this.dataCntrSeq = dataCntrSeq;
	}



}
