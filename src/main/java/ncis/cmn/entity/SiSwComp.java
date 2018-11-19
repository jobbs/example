package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 소프트웨어구성정보 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class SiSwComp {

    /**
     * 구성ID
     */
    @NotEmpty(message = "구성ID는(은) 필수입력 항목입니다.")
    private String compId;

    /**
     * 구성구분코드
     */
    @NotEmpty(message = "구성구분코드는(은) 필수입력 항목입니다.")
    private String compClCd;

    /**
     * 설치구성ID
     */
    @NotEmpty(message = "설치구성ID는(은) 필수입력 항목입니다.")
    private String instlCompId;

    /**
     * 설치구성자원명
     */
    private String instlCompRsrcNm;

    /**
     * 최초설치버전
     */
    private String frstInstlVer;

    /**
     * 현재패치버전
     */
    private String nowPatchVer;

    /**
     * 최초설치커널버전
     */
    private String frstInstlKrnlVer;

    /**
     * 현재커널버전
     */
    private String nowKrnlVer;

    /**
     * 라이선스유형
     */
    private BigDecimal licnseTy;

    /**
     * 소프트웨어구분
     */
    private String swCl;

    /**
     * 라이선스할당개수
     */
    private BigDecimal licnseAsgnQty;

    /**
     * 라이선스개수
     */
    private BigDecimal licnseQty;

    /**
     * 소프트웨어설치일자
     */
    private String swInstlDt;

    /**
     * 소스설치폴더
     */
    private String srcInstlFoldr;

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getCompClCd() {
        return compClCd;
    }

    public void setCompClCd(String compClCd) {
        this.compClCd = compClCd;
    }

    public String getInstlCompId() {
        return instlCompId;
    }

    public void setInstlCompId(String instlCompId) {
        this.instlCompId = instlCompId;
    }

    public String getInstlCompRsrcNm() {
        return instlCompRsrcNm;
    }

    public void setInstlCompRsrcNm(String instlCompRsrcNm) {
        this.instlCompRsrcNm = instlCompRsrcNm;
    }

    public String getFrstInstlVer() {
        return frstInstlVer;
    }

    public void setFrstInstlVer(String frstInstlVer) {
        this.frstInstlVer = frstInstlVer;
    }

    public String getNowPatchVer() {
        return nowPatchVer;
    }

    public void setNowPatchVer(String nowPatchVer) {
        this.nowPatchVer = nowPatchVer;
    }

    public String getFrstInstlKrnlVer() {
        return frstInstlKrnlVer;
    }

    public void setFrstInstlKrnlVer(String frstInstlKrnlVer) {
        this.frstInstlKrnlVer = frstInstlKrnlVer;
    }

    public String getNowKrnlVer() {
        return nowKrnlVer;
    }

    public void setNowKrnlVer(String nowKrnlVer) {
        this.nowKrnlVer = nowKrnlVer;
    }

    public BigDecimal getLicnseTy() {
        return licnseTy;
    }

    public void setLicnseTy(BigDecimal licnseTy) {
        this.licnseTy = licnseTy;
    }

    public String getSwCl() {
        return swCl;
    }

    public void setSwCl(String swCl) {
        this.swCl = swCl;
    }

    public BigDecimal getLicnseAsgnQty() {
        return licnseAsgnQty;
    }

    public void setLicnseAsgnQty(BigDecimal licnseAsgnQty) {
        this.licnseAsgnQty = licnseAsgnQty;
    }

    public BigDecimal getLicnseQty() {
        return licnseQty;
    }

    public void setLicnseQty(BigDecimal licnseQty) {
        this.licnseQty = licnseQty;
    }

    public String getSwInstlDt() {
        return swInstlDt;
    }

    public void setSwInstlDt(String swInstlDt) {
        this.swInstlDt = swInstlDt;
    }

    public String getSrcInstlFoldr() {
        return srcInstlFoldr;
    }

    public void setSrcInstlFoldr(String srcInstlFoldr) {
        this.srcInstlFoldr = srcInstlFoldr;
    }

}
