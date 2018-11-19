package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 자원요청 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrSrcReq {

    /**
     * 자원요청번호
     */
    @NotEmpty(message = "자원요청번호는(은) 필수입력 항목입니다.")
    private String rsrcReqNo;

    /**
     * 자원요청자ID
     */
    @NotEmpty(message = "자원요청자ID는(은) 필수입력 항목입니다.")
    private String rsrcReqUsrId;

    /**
     * 자원요청일시
     */
    @NotEmpty(message = "자원요청일시는(은) 필수입력 항목입니다.")
    private String rsrcReqDttm;

    /**
     * 자원요청진행상태코드
     */
    @NotEmpty(message = "자원요청진행상태코드는(은) 필수입력 항목입니다.")
    private String rsrcReqPrcssStatCd;

    /**
     * 요청기관ID
     */
    @NotEmpty(message = "요청기관ID는(은) 필수입력 항목입니다.")
    private String reqInstitutionId;

    /**
     * 요청부서ID
     */
    @NotEmpty(message = "요청부서ID는(은) 필수입력 항목입니다.")
    private String reqDeptId;

    /**
     * 제목
     */
    private String sbjct;

    /**
     * 티켓번호
     */
    private String ticktNo;

    /**
     * 리전ID
     */
    private String regionId;

    /**
     * 테스트여부
     */
    private String testYn;

    /**
     * 연계여부
     */
    private String linkYn;

    /**
     * 완료일시
     */
    private String comptDttm;

    /**
     * 등록자ID
     */
    private String regUserId;

    /**
     * 등록일자
     */
    private String regDt;

    public String getRsrcReqNo() {
        return rsrcReqNo;
    }

    public void setRsrcReqNo(String rsrcReqNo) {
        this.rsrcReqNo = rsrcReqNo;
    }

    public String getRsrcReqUsrId() {
        return rsrcReqUsrId;
    }

    public void setRsrcReqUsrId(String rsrcReqUsrId) {
        this.rsrcReqUsrId = rsrcReqUsrId;
    }

    public String getRsrcReqDttm() {
        return rsrcReqDttm;
    }

    public void setRsrcReqDttm(String rsrcReqDttm) {
        this.rsrcReqDttm = rsrcReqDttm;
    }

    public String getRsrcReqPrcssStatCd() {
        return rsrcReqPrcssStatCd;
    }

    public void setRsrcReqPrcssStatCd(String rsrcReqPrcssStatCd) {
        this.rsrcReqPrcssStatCd = rsrcReqPrcssStatCd;
    }

    public String getReqInstitutionId() {
        return reqInstitutionId;
    }

    public void setReqInstitutionId(String reqInstitutionId) {
        this.reqInstitutionId = reqInstitutionId;
    }

    public String getReqDeptId() {
        return reqDeptId;
    }

    public void setReqDeptId(String reqDeptId) {
        this.reqDeptId = reqDeptId;
    }

    public String getSbjct() {
        return sbjct;
    }

    public void setSbjct(String sbjct) {
        this.sbjct = sbjct;
    }

    public String getTicktNo() {
        return ticktNo;
    }

    public void setTicktNo(String ticktNo) {
        this.ticktNo = ticktNo;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getTestYn() {
        return testYn;
    }

    public void setTestYn(String testYn) {
        this.testYn = testYn;
    }

    public String getLinkYn() {
        return linkYn;
    }

    public void setLinkYn(String linkYn) {
        this.linkYn = linkYn;
    }

    public String getComptDttm() {
        return comptDttm;
    }

    public void setComptDttm(String comptDttm) {
        this.comptDttm = comptDttm;
    }

    public String getRegUserId() {
        return regUserId;
    }

    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    public String getRegDt() {
        return regDt;
    }

    public void setRegDt(String regDt) {
        this.regDt = regDt;
    }

}
