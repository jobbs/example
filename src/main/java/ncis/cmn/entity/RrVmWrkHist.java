package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 가상서버작업이력 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrVmWrkHist {

    /**
     * 가상서버SEQ
     */
    @NotEmpty(message = "가상서버ID는(은) 필수입력 항목입니다.")
    private BigDecimal vmSeq;

    /**
     * 작업일시
     */
    @NotEmpty(message = "작업일시는(은) 필수입력 항목입니다.")
    private String wrkDt;

    /**
     * 가상서버요청유형코드
     */
    @NotEmpty(message = "가상서버요청유형코드는(은) 필수입력 항목입니다.")
    private String vmReqTyCd;

    /**
     * 작업자ID
     */
    private String wrkId;

    /**
     * 변경전CPU(vCore)
     */
    private BigDecimal chBefCpuQty;

    /**
     * 변경후CPU(vCore)
     */
    private BigDecimal chAftCpuQty;

    /**
     * 변경전메모리할당량(MB)
     */
    private BigDecimal chBefMemAsgnCapa;

    /**
     * 변경후메모리할당량(MB)
     */
    private BigDecimal chAftMemAsgnCapa;

    /**
     * 변경전스토리지할당량(GB)
     */
    private BigDecimal chBefStrgAsgnCapa;

    /**
     * 변경후스토리지할당량(GB)
     */
    private BigDecimal chAftStrgAsgnCapa;

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

    /**
     * 기존물리서버ID
     */
    private BigDecimal lgcyPSrvrId;

    /**
     * 변경후물리서버ID
     */
    private BigDecimal chngPSrvrId;

    /**
     * 스냅샷명
     */
    private String snapshtNm;

    /**
     * 디스크번호
     */
    private BigDecimal dskNo;

    /**
     * 스냅샷이력구분코드
     */
    private String snapshtHstryClCd;

    /**
     * 기존구성ID
     */
    private String lgcyCompId;

    /**
     * 변경구성ID
     */
    private String chngCompId;

    public BigDecimal getVmSeq() {
        return vmSeq;
    }

    public void setVmSeq(BigDecimal vmSeq) {
        this.vmSeq = vmSeq;
    }

    public String getWrkDt() {
        return wrkDt;
    }

    public void setWrkDt(String wrkDt) {
        this.wrkDt = wrkDt;
    }

    public String getVmReqTyCd() {
        return vmReqTyCd;
    }

    public void setVmReqTyCd(String vmReqTyCd) {
        this.vmReqTyCd = vmReqTyCd;
    }

    public String getWrkId() {
        return wrkId;
    }

    public void setWrkId(String wrkId) {
        this.wrkId = wrkId;
    }

    public BigDecimal getChBefCpuQty() {
        return chBefCpuQty;
    }

    public void setChBefCpuQty(BigDecimal chBefCpuQty) {
        this.chBefCpuQty = chBefCpuQty;
    }

    public BigDecimal getChAftCpuQty() {
        return chAftCpuQty;
    }

    public void setChAftCpuQty(BigDecimal chAftCpuQty) {
        this.chAftCpuQty = chAftCpuQty;
    }

    public BigDecimal getChBefMemAsgnCapa() {
        return chBefMemAsgnCapa;
    }

    public void setChBefMemAsgnCapa(BigDecimal chBefMemAsgnCapa) {
        this.chBefMemAsgnCapa = chBefMemAsgnCapa;
    }

    public BigDecimal getChAftMemAsgnCapa() {
        return chAftMemAsgnCapa;
    }

    public void setChAftMemAsgnCapa(BigDecimal chAftMemAsgnCapa) {
        this.chAftMemAsgnCapa = chAftMemAsgnCapa;
    }

    public BigDecimal getChBefStrgAsgnCapa() {
        return chBefStrgAsgnCapa;
    }

    public void setChBefStrgAsgnCapa(BigDecimal chBefStrgAsgnCapa) {
        this.chBefStrgAsgnCapa = chBefStrgAsgnCapa;
    }

    public BigDecimal getChAftStrgAsgnCapa() {
        return chAftStrgAsgnCapa;
    }

    public void setChAftStrgAsgnCapa(BigDecimal chAftStrgAsgnCapa) {
        this.chAftStrgAsgnCapa = chAftStrgAsgnCapa;
    }

    public BigDecimal getLgcyPSrvrId() {
        return lgcyPSrvrId;
    }

    public void setLgcyPSrvrId(BigDecimal lgcyPSrvrId) {
        this.lgcyPSrvrId = lgcyPSrvrId;
    }

    public BigDecimal getChngPSrvrId() {
        return chngPSrvrId;
    }

    public void setChngPSrvrId(BigDecimal chngPSrvrId) {
        this.chngPSrvrId = chngPSrvrId;
    }

    public String getSnapshtNm() {
        return snapshtNm;
    }

    public void setSnapshtNm(String snapshtNm) {
        this.snapshtNm = snapshtNm;
    }

    public BigDecimal getDskNo() {
        return dskNo;
    }

    public void setDskNo(BigDecimal dskNo) {
        this.dskNo = dskNo;
    }

    public String getSnapshtHstryClCd() {
        return snapshtHstryClCd;
    }

    public void setSnapshtHstryClCd(String snapshtHstryClCd) {
        this.snapshtHstryClCd = snapshtHstryClCd;
    }

    public String getLgcyCompId() {
        return lgcyCompId;
    }

    public void setLgcyCompId(String lgcyCompId) {
        this.lgcyCompId = lgcyCompId;
    }

    public String getChngCompId() {
        return chngCompId;
    }

    public void setChngCompId(String chngCompId) {
        this.chngCompId = chngCompId;
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
