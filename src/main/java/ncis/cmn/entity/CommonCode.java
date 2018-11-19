package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 공통코드 관리 테이블 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class CommonCode {

    /**
     * 코드
     */
    @NotEmpty(message = "코드는(은) 필수입력 항목입니다.")
    private String code;

    /**
     * 부모코드
     */
    private String parentCode;

    /**
     * 코드명
     */
    @NotEmpty(message = "코드명는(은) 필수입력 항목입니다.")
    private String codeName;

    /**
     * 코드설명
     */
    private String codeDesc;

    /**
     * 코드레벨
     */
    @NotEmpty(message = "코드레벨는(은) 필수입력 항목입니다.")
    private BigDecimal codeLevel;

    /**
     * 사용여부
     */
    @NotEmpty(message = "사용여부는(은) 필수입력 항목입니다.")
    private String codeUseYn;

    /**
     * 코드순번
     */
    @NotEmpty(message = "코드순번는(은) 필수입력 항목입니다.")
    private BigDecimal codeOrder;

    /**
     * 등록일시
     */
    @NotEmpty(message = "등록일시는(은) 필수입력 항목입니다.")
    private String regDate;

    /**
     * 등록자아이디
     */
    @NotEmpty(message = "등록자아이디는(은) 필수입력 항목입니다.")
    private String regId;

    /**
     * 수정일시
     */
    @NotEmpty(message = "수정일시는(은) 필수입력 항목입니다.")
    private String modDate;

    /**
     * 수정자아이디
     */
    @NotEmpty(message = "수정자아이디는(은) 필수입력 항목입니다.")
    private String modId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    public BigDecimal getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(BigDecimal codeLevel) {
        this.codeLevel = codeLevel;
    }

    public String getCodeUseYn() {
        return codeUseYn;
    }

    public void setCodeUseYn(String codeUseYn) {
        this.codeUseYn = codeUseYn;
    }

    public BigDecimal getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(BigDecimal codeOrder) {
        this.codeOrder = codeOrder;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getModDate() {
        return modDate;
    }

    public void setModDate(String modDate) {
        this.modDate = modDate;
    }

    public String getModId() {
        return modId;
    }

    public void setModId(String modId) {
        this.modId = modId;
    }

}
