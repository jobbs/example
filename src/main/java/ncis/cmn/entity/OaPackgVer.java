package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 패키지버전 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class OaPackgVer {

    /**
     * 패키지ID
     */
    @NotEmpty(message = "패키지SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal packgSeq;

    /**
     * 버전
     */
    @NotEmpty(message = "버전는(은) 필수입력 항목입니다.")
    private String ver;

    /**
     * 등록일시
     */
    @NotEmpty(message = "등록일시는(은) 필수입력 항목입니다.")
    private String regDttm;

    /**
     * 등록자ID
     */
    @NotEmpty(message = "등록자ID는(은) 필수입력 항목입니다.")
    private String regUserId;

    /**
     * 등록부서ID
     */
    private String regDeptId;

    /**
     * 패키지내용
     */
    private String packgCn;

    /**
     * 릴리즈
     */
    private String release;

    /**
     * 파일크기
     */
    private BigDecimal fileSize;

    /**
     * 패키지파일위치
     */
    private String packgFileLoca;

    /**
	* 패키지파일명
	*/
    private String packgFileNm;

    /**
     * 내용
     */
    private String cn;

    /**
     * 삭제자Id
     */
    private String delUserId;

     /**
     * 삭제일시
     */
    private String delDttm;

	 /**
	 * 삭제여부
	 */
    private String delYn;

    public BigDecimal getPackgSeq() {
        return packgSeq;
    }

    public void setPackgSeq(BigDecimal packgSeq) {
        this.packgSeq = packgSeq;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(String regDttm) {
        this.regDttm = regDttm;
    }

    public String getRegUserId() {
        return regUserId;
    }

    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    public String getRegDeptId() {
        return regDeptId;
    }

    public void setRegDeptId(String regDeptId) {
        this.regDeptId = regDeptId;
    }

    public String getPackgCn() {
        return packgCn;
    }

    public void setPackgCn(String packgCn) {
        this.packgCn = packgCn;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public BigDecimal getFileSize() {
        return fileSize;
    }

    public void setFileSize(BigDecimal fileSize) {
        this.fileSize = fileSize;
    }

    public String getPackgFileLoca() {
        return packgFileLoca;
    }

    public void setPackgFileLoca(String packgFileLoca) {
        this.packgFileLoca = packgFileLoca;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getPackgFileNm()
	{
	    return packgFileNm;
	}

	public void setPackgFileNm(String packgFileNm)
	{
	    this.packgFileNm = packgFileNm;
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

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

}
