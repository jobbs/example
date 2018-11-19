package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 자원요청상세_가상서버 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrSrcReqDtlVm {

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
     * 자원요청내용
     */
    private String rsrcReqCn;

    /**
     * 자원요청영역구분코드
     */
    @NotEmpty(message = "자원요청영역구분코드는(은) 필수입력 항목입니다.")
    private String rsrcReqAreaClCd;

    /**
     * 자원요청진행상태코드
     */
    @NotEmpty(message = "자원요청진행상태코드는(은) 필수입력 항목입니다.")
    private String rsrcReqPrcssStatCd;

    /**
     * 프로세스인스턴스ID
     */
    private BigDecimal procssInstSeq;

    /**
     * 실행자ID
     */
    private String exeUserId;

    /**
     * 실행일시
     */
    private String exeDttm;

    /**
     * 리전ID
     */
    @NotEmpty(message = "리전ID는(은) 필수입력 항목입니다.")
    private String regionId;

    /**
     * 존ID
     */
    @NotEmpty(message = "존ID는(은) 필수입력 항목입니다.")
    private String zoneId;

    /**
     * 망ID
     */
    @NotEmpty(message = "망ID는(은) 필수입력 항목입니다.")
    private String netId;

    /**
     * 매니저ID
     */
    private BigDecimal mngId;

    /**
     * UUID
     */
    private String uuid;

    /**
     * 자원요청유형코드
     */
    private String rsrcReqTyCd;

    /**
     * 가상서버요청유형코드
     */
    private String vmReqTyCd;

    /**
     * 가상서버ID
     */
    @NotEmpty(message = "가상서버ID는(은) 필수입력 항목입니다.")
    private String vmId;

    /**
     * 가상서버명
     */
    private String vmNm;

    /**
     * 가상서버구성ID
     */
    private String vmCompId;

    /**
     * 호스트명
     */
    private String hstNm;

    /**
     * 용도코드
     */
    private String prposCd;

    /**
     * 사용부처ID
     */
    private BigDecimal useGvDprtId;

    /**
     * 사용업무ID
     */
    private BigDecimal useJobId;

    /**
     * 가상화SW유형코드
     */
    private String vrCnvrSwTyCd;

    /**
     * 운영체계
     */
    private String os;

    /**
     * 클러스터일련번호
     */
    private BigDecimal clstrSeq;

    /**
     * 물리서버일련번호
     */
    private BigDecimal pmSeq;

    /**
     * 자원풀명
     */
    private String rsrcPoolNm;

    /**
     * IP주소
     */
    private String ipAddr;

    /**
     * OS유형코드
     */
    private String osTyCd;

    /**
     * OS명
     */
    private String osNm;

    /**
     * 소프트웨어ID
     */
    private BigDecimal swId;

    /**
     * 서비스시작일자
     */
    private String servcStrtDt;

    /**
     * 서비스종료일자
     */
    private String servcEndDt;

    /**
     * 요청CPU(vCore)
     */
    private BigDecimal reqCpuVcore;

    /**
     * 요청메모리(MB)
     */
    private BigDecimal reqMem;

    /**
     * 요청가상디스크ID
     */
    private BigDecimal reqVrDskId;

    /**
     * 스토리지할당용량(GB)
     */
    private BigDecimal strgAsgnCapa;

    /**
     * 첨부파일ID
     */
    private BigDecimal atchFileId;

    /**
     * 비고
     */
    private String rmk;

    /**
     * 요청스펙ID
     */
    private BigDecimal reqSpecId;

    /**
     * 템플릿SEQ
     */
    private BigDecimal tmplatSeq;

    /**
     * 가상서버변경구분코드
     */
    private String vSrvrChngClCd;

    /**
     * 변경전스펙ID
     */
    private BigDecimal chngSpecId;

    /**
     * 변경전CPU(vCore)
     */
    private BigDecimal chngPreCpuQty;

    /**
     * 변경전메모리할당량(MB)
     */
    private BigDecimal chngPreMemAsgnCapa;

    /**
     * 변경후스펙ID
     */
    private BigDecimal chngPreSpecId;

    /**
     * 변경후CPU(vCore)
     */
    private BigDecimal chngPostCpuQty;

    /**
     * 변경후메모리할당량(MB)
     */
    private BigDecimal chngPostMemAsgnCapa;

    /**
     * 스토리지할당요청량(GB)
     */
    private BigDecimal strgAsgnReqCapa;

    /**
     * 할당가상디스크ID
     */
    private BigDecimal asgnVrDskId;

    /**
     * 공유여부
     */
    private String shareYn;

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

    public String getRsrcReqCn() {
        return rsrcReqCn;
    }

    public void setRsrcReqCn(String rsrcReqCn) {
        this.rsrcReqCn = rsrcReqCn;
    }

    public String getRsrcReqAreaClCd() {
        return rsrcReqAreaClCd;
    }

    public void setRsrcReqAreaClCd(String rsrcReqAreaClCd) {
        this.rsrcReqAreaClCd = rsrcReqAreaClCd;
    }

    public String getRsrcReqPrcssStatCd() {
        return rsrcReqPrcssStatCd;
    }

    public void setRsrcReqPrcssStatCd(String rsrcReqPrcssStatCd) {
        this.rsrcReqPrcssStatCd = rsrcReqPrcssStatCd;
    }

    public BigDecimal getProcssInstSeq() {
		return procssInstSeq;
	}

	public void setProcssInstSeq(BigDecimal procssInstSeq) {
		this.procssInstSeq = procssInstSeq;
	}

	public String getExeUserId() {
        return exeUserId;
    }

    public void setExeUserId(String exeUserId) {
        this.exeUserId = exeUserId;
    }

    public String getExeDttm() {
        return exeDttm;
    }

    public void setExeDttm(String exeDttm) {
        this.exeDttm = exeDttm;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getNetId() {
        return netId;
    }

    public void setNetId(String netId) {
        this.netId = netId;
    }

    public BigDecimal getMngId() {
        return mngId;
    }

    public void setMngId(BigDecimal mngId) {
        this.mngId = mngId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRsrcReqTyCd() {
        return rsrcReqTyCd;
    }

    public void setRsrcReqTyCd(String rsrcReqTyCd) {
        this.rsrcReqTyCd = rsrcReqTyCd;
    }

    public String getVmReqTyCd() {
        return vmReqTyCd;
    }

    public void setVmReqTyCd(String vmReqTyCd) {
        this.vmReqTyCd = vmReqTyCd;
    }

    public String getVmId() {
        return vmId;
    }

    public void setVmId(String vmId) {
        this.vmId = vmId;
    }

    public String getVmNm() {
        return vmNm;
    }

    public void setVmNm(String vmNm) {
        this.vmNm = vmNm;
    }

    public String getVmCompId() {
        return vmCompId;
    }

    public void setVmCompId(String vmCompId) {
        this.vmCompId = vmCompId;
    }

    public String getHstNm() {
        return hstNm;
    }

    public void setHstNm(String hstNm) {
        this.hstNm = hstNm;
    }

    public String getPrposCd() {
        return prposCd;
    }

    public void setPrposCd(String prposCd) {
        this.prposCd = prposCd;
    }

    public BigDecimal getUseGvDprtId() {
        return useGvDprtId;
    }

    public void setUseGvDprtId(BigDecimal useGvDprtId) {
        this.useGvDprtId = useGvDprtId;
    }

    public BigDecimal getUseJobId() {
        return useJobId;
    }

    public void setUseJobId(BigDecimal useJobId) {
        this.useJobId = useJobId;
    }

    public String getVrCnvrSwTyCd() {
        return vrCnvrSwTyCd;
    }

    public void setVrCnvrSwTyCd(String vrCnvrSwTyCd) {
        this.vrCnvrSwTyCd = vrCnvrSwTyCd;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public BigDecimal getClstrSeq() {
		return clstrSeq;
	}

	public void setClstrSeq(BigDecimal clstrSeq) {
		this.clstrSeq = clstrSeq;
	}

	public BigDecimal getPmSeq() {
		return pmSeq;
	}

	public void setPmSeq(BigDecimal pmSeq) {
		this.pmSeq = pmSeq;
	}

	public String getRsrcPoolNm() {
        return rsrcPoolNm;
    }

    public void setRsrcPoolNm(String rsrcPoolNm) {
        this.rsrcPoolNm = rsrcPoolNm;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getOsTyCd() {
        return osTyCd;
    }

    public void setOsTyCd(String osTyCd) {
        this.osTyCd = osTyCd;
    }

    public String getOsNm() {
        return osNm;
    }

    public void setOsNm(String osNm) {
        this.osNm = osNm;
    }

    public BigDecimal getSwId() {
        return swId;
    }

    public void setSwId(BigDecimal swId) {
        this.swId = swId;
    }

    public String getServcStrtDt() {
        return servcStrtDt;
    }

    public void setServcStrtDt(String servcStrtDt) {
        this.servcStrtDt = servcStrtDt;
    }

    public String getServcEndDt() {
        return servcEndDt;
    }

    public void setServcEndDt(String servcEndDt) {
        this.servcEndDt = servcEndDt;
    }

    public BigDecimal getReqCpuVcore() {
        return reqCpuVcore;
    }

    public void setReqCpuVcore(BigDecimal reqCpuVcore) {
        this.reqCpuVcore = reqCpuVcore;
    }

    public BigDecimal getReqMem() {
        return reqMem;
    }

    public void setReqMem(BigDecimal reqMem) {
        this.reqMem = reqMem;
    }

    public BigDecimal getReqVrDskId() {
        return reqVrDskId;
    }

    public void setReqVrDskId(BigDecimal reqVrDskId) {
        this.reqVrDskId = reqVrDskId;
    }

    public BigDecimal getStrgAsgnCapa() {
        return strgAsgnCapa;
    }

    public void setStrgAsgnCapa(BigDecimal strgAsgnCapa) {
        this.strgAsgnCapa = strgAsgnCapa;
    }

    public BigDecimal getAtchFileId() {
        return atchFileId;
    }

    public void setAtchFileId(BigDecimal atchFileId) {
        this.atchFileId = atchFileId;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

    public BigDecimal getReqSpecId() {
        return reqSpecId;
    }

    public void setReqSpecId(BigDecimal reqSpecId) {
        this.reqSpecId = reqSpecId;
    }

    public BigDecimal getTmplatSeq() {
		return tmplatSeq;
	}

	public void setTmplatSeq(BigDecimal tmplatSeq) {
		this.tmplatSeq = tmplatSeq;
	}

	public String getvSrvrChngClCd() {
        return vSrvrChngClCd;
    }

    public void setvSrvrChngClCd(String vSrvrChngClCd) {
        this.vSrvrChngClCd = vSrvrChngClCd;
    }

    public BigDecimal getChngSpecId() {
        return chngSpecId;
    }

    public void setChngSpecId(BigDecimal chngSpecId) {
        this.chngSpecId = chngSpecId;
    }

    public BigDecimal getChngPreCpuQty() {
        return chngPreCpuQty;
    }

    public void setChngPreCpuQty(BigDecimal chngPreCpuQty) {
        this.chngPreCpuQty = chngPreCpuQty;
    }

    public BigDecimal getChngPreMemAsgnCapa() {
        return chngPreMemAsgnCapa;
    }

    public void setChngPreMemAsgnCapa(BigDecimal chngPreMemAsgnCapa) {
        this.chngPreMemAsgnCapa = chngPreMemAsgnCapa;
    }

    public BigDecimal getChngPreSpecId() {
        return chngPreSpecId;
    }

    public void setChngPreSpecId(BigDecimal chngPreSpecId) {
        this.chngPreSpecId = chngPreSpecId;
    }

    public BigDecimal getChngPostCpuQty() {
        return chngPostCpuQty;
    }

    public void setChngPostCpuQty(BigDecimal chngPostCpuQty) {
        this.chngPostCpuQty = chngPostCpuQty;
    }

    public BigDecimal getChngPostMemAsgnCapa() {
        return chngPostMemAsgnCapa;
    }

    public void setChngPostMemAsgnCapa(BigDecimal chngPostMemAsgnCapa) {
        this.chngPostMemAsgnCapa = chngPostMemAsgnCapa;
    }

    public BigDecimal getStrgAsgnReqCapa() {
        return strgAsgnReqCapa;
    }

    public void setStrgAsgnReqCapa(BigDecimal strgAsgnReqCapa) {
        this.strgAsgnReqCapa = strgAsgnReqCapa;
    }

    public BigDecimal getAsgnVrDskId() {
        return asgnVrDskId;
    }

    public void setAsgnVrDskId(BigDecimal asgnVrDskId) {
        this.asgnVrDskId = asgnVrDskId;
    }

    public String getShareYn() {
        return shareYn;
    }

    public void setShareYn(String shareYn) {
        this.shareYn = shareYn;
    }

}
