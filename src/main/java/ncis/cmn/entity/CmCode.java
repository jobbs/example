package ncis.cmn.entity;

import java.util.Date;
import javax.validation.constraints.Size;
import ncis.cmn.validation.groups.InsertProc;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 공통코드 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class CmCode {

    /**
    * 코드
    */
    @NotEmpty(message="코드는 필수입력 항목입니다.", groups={InsertProc.class})
    @Size(max=30, message="코드는 최대 30자만 허용합니다.")
    private String cd;

    /**
    * 그룹코드
    */
    @NotEmpty(message="그룹코드는(은) 필수입력 항목입니다.", groups={InsertProc.class})
    private String grpCd;

    /**
    * 부모코드
    */
    @NotEmpty(message="부모코드는(은) 필수입력 항목입니다.", groups={InsertProc.class})
    private String parentCd;

    /**
    * 부모그룹코드
    */
    @NotEmpty(message="부모그룹코드는(은) 필수입력 항목입니다.", groups={InsertProc.class})
    private String parentGrpCd;

    /**
    * 코드명
    */
    @NotEmpty(message="코드명 필수입력 항목입니다.")
    @Size(max=100, message="코드명은 최대 100자만 허용합니다.")
    private String cdNm;

    /**
    * 코드설명
    */
    @Size(max=1000, message="코드설명은 최대 1000자만 허용합니다.")
    private String cdDesc;

    /**
    * 코드레벨
    */
    private Integer cdLevel;

    /**
    * 사용여부
    */
    private String useYn;

    /**
    * 코드순번
    */
    private Integer cdOrder;

    /**
    * 등록일시
    */
    private Date regDttm;

    /**
    * 등록자ID
    */
    private String regUserId;

    /**
    * 수정일시
    */
    private Date updtDttm;

    /**
    * 수정자ID
    */
    private String updtUserId;

    /**
    * 변수값1
    */
    @Size(max=30, message="기타필드는 최대 30자만 허용합니다.")
    private String varVl1;

    /**
    * 변수값2
    */
    @Size(max=30, message="기타필드는 최대 30자만 허용합니다.")
    private String varVl2;

    /**
    * 변수값3
    */
    @Size(max=30, message="기타필드는 최대 30자만 허용합니다.")
    private String varVl3;

    /**
    * 변수값4
    */
    @Size(max=30, message="기타필드는 최대 30자만 허용합니다.")
    private String varVl4;

    /**
    * 변수값5
    */
    @Size(max=30, message="기타필드는 최대 30자만 허용합니다.")
    private String varVl5;

    /**
     * @return the cd
     */
    public String getCd() {
        return cd;
    }

    /**
     * @param cd the cd to set
     */
    public void setCd(String cd) {
        this.cd = cd;
    }

    /**
     * @return the grpCd
     */
    public String getGrpCd() {
        return grpCd;
    }

    /**
     * @param grpCd the grpCd to set
     */
    public void setGrpCd(String grpCd) {
        this.grpCd = grpCd;
    }

    /**
     * @return the parentCd
     */
    public String getParentCd() {
        return parentCd;
    }

    /**
     * @param parentCd the parentCd to set
     */
    public void setParentCd(String parentCd) {
        this.parentCd = parentCd;
    }

    /**
     * @return the parentGrpCd
     */
    public String getParentGrpCd() {
        return parentGrpCd;
    }

    /**
     * @param parentGrpCd the parentGrpCd to set
     */
    public void setParentGrpCd(String parentGrpCd) {
        this.parentGrpCd = parentGrpCd;
    }

    /**
     * @return the cdNm
     */
    public String getCdNm() {
        return cdNm;
    }

    /**
     * @param cdNm the cdNm to set
     */
    public void setCdNm(String cdNm) {
        this.cdNm = cdNm;
    }

    /**
     * @return the cdDesc
     */
    public String getCdDesc() {
        return cdDesc;
    }

    /**
     * @param cdDesc the cdDesc to set
     */
    public void setCdDesc(String cdDesc) {
        this.cdDesc = cdDesc;
    }

    /**
     * @return the cdLevel
     */
    public Integer getCdLevel() {
        return cdLevel;
    }

    /**
     * @param cdLevel the cdLevel to set
     */
    public void setCdLevel(Integer cdLevel) {
        this.cdLevel = cdLevel;
    }

    /**
     * @return the useYn
     */
    public String getUseYn() {
        return useYn;
    }

    /**
     * @param useYn the useYn to set
     */
    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    /**
     * @return the cdOrder
     */
    public Integer getCdOrder() {
        return cdOrder;
    }

    /**
     * @param cdOrder the cdOrder to set
     */
    public void setCdOrder(Integer cdOrder) {
        this.cdOrder = cdOrder;
    }

    /**
     * @return the regDttm
     */
    public Date getRegDttm() {
        return regDttm;
    }

    /**
     * @param regDttm the regDttm to set
     */
    public void setRegDttm(Date regDttm) {
        this.regDttm = regDttm;
    }

    /**
     * @return the regUserId
     */
    public String getRegUserId() {
        return regUserId;
    }

    /**
     * @param regUserId the regUserId to set
     */
    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    /**
     * @return the updtDttm
     */
    public Date getUpdtDttm() {
        return updtDttm;
    }

    /**
     * @param updtDttm the updtDttm to set
     */
    public void setUpdtDttm(Date updtDttm) {
        this.updtDttm = updtDttm;
    }

    /**
     * @return the updtUserId
     */
    public String getUpdtUserId() {
        return updtUserId;
    }

    /**
     * @param updtUserId the updtUserId to set
     */
    public void setUpdtUserId(String updtUserId) {
        this.updtUserId = updtUserId;
    }

    /**
     * @return the varVl1
     */
    public String getVarVl1() {
        return varVl1;
    }

    /**
     * @param varVl1 the varVl1 to set
     */
    public void setVarVl1(String varVl1) {
        this.varVl1 = varVl1;
    }

    /**
     * @return the varVl2
     */
    public String getVarVl2() {
        return varVl2;
    }

    /**
     * @param varVl2 the varVl2 to set
     */
    public void setVarVl2(String varVl2) {
        this.varVl2 = varVl2;
    }

    /**
     * @return the varVl3
     */
    public String getVarVl3() {
        return varVl3;
    }

    /**
     * @param varVl3 the varVl3 to set
     */
    public void setVarVl3(String varVl3) {
        this.varVl3 = varVl3;
    }

    /**
     * @return the varVl4
     */
    public String getVarVl4() {
        return varVl4;
    }

    /**
     * @param varVl4 the varVl4 to set
     */
    public void setVarVl4(String varVl4) {
        this.varVl4 = varVl4;
    }

    /**
     * @return the varVl5
     */
    public String getVarVl5() {
        return varVl5;
    }

    /**
     * @param varVl5 the varVl5 to set
     */
    public void setVarVl5(String varVl5) {
        this.varVl5 = varVl5;
    }



}


