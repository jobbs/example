package ncis.cmn.entity;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.com.validation.InsertVmCreReqValidation;
import ncis.cpt.rsrc.com.validation.InsertVmDelReqValidation;
import ncis.cpt.rsrc.com.validation.InsertVmSpecModReqValidation;
import ncis.cpt.rsrc.com.validation.InsertVmStrgAddReqValidation;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 자원요청상세_가상서버 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author 심원보
 */

public class RrRsrcReqDtlVm {

    /**
     * 자원요청번호
     */
    private String rsrcReqNo;

    /**
     * 자원요청일련번호
     */
    private BigDecimal rsrcReqSeq;

    /**
     * 자원요청내용
     */
    private String rsrcReqCn;

    /**
     * 자원요청유형코드
     */
    private String rsrcReqTyCd;

    /**
     * 자원요청진행상태코드
     */
    private String rsrcReqPrcssStatCd;

    /**
     * 프로세스인스턴스ID
     */
    private int procssInstSeq;

    /**
     * 실행일시
     */
    private String exeDttm;

    /**
     * 반려유형코드
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
     * 존ID
     */
    private String zoneId;

    /**
     * 망ID
     */
    private String netId;

    /**
     * 매니저ID
     */
    private String rsrcPoolId;

    /**
     * UUID
     */
    private String uuid;

    /**
     * IP자동할당여부
     */
    private String ipAutoAsgnYn;

    /**
     * 가상서버ID
     */
    private String vmId;

    /**
     * 실행상태코드
     */
    private String exeStatCd;


    /**
     * 가상서버명
     */
    @NotEmpty(message = "가상서버명을 입력해주세요.", groups = { InsertVmCreReqValidation.class })
    @Size(message = "가상서버명은 {max}자 이내로 입력해주세요.", min = 0, max = ComConstant.VM_NM_MAX_LENGTH, groups = { InsertVmCreReqValidation.class })
    private String vmNm;

    /**
     * 가상서버구성ID
     */
    @Size(message = "가상서버구성ID는 {max}자 이내로 입력해주세요.", min = 0, max = ComConstant.VM_COMP_ID_MAX_LENGTH, groups = { InsertVmCreReqValidation.class })
    private String vmCompId;

    /**
     * 호스트명
     */
    @NotEmpty(message = "호스트명을 입력해주세요.", groups = { InsertVmCreReqValidation.class })
    @Size(message = "호스트명은 {max}자 이내로 입력해주세요.", min = 0, max = ComConstant.HST_NM_MAX_LENGTH, groups = { InsertVmCreReqValidation.class })
    private String hstNm;

    /**
     * 용도구분코드
     */
    @NotEmpty(message = "용도를 선택해주세요.", groups = { InsertVmCreReqValidation.class })
    private String prposClCd;

    /**
     * 사용부처ID
     */
    private String useGvDprtId;

    /**
     * 사용업무ID
     */
    @NotEmpty(message = "업무를 선택해주세요.", groups = { InsertVmCreReqValidation.class })
    private String useJobId;

    /**
     * 가상화SW유형코드
     */
    private String vrCnvrSwTyCd;

    /**
     * 클러스터SEQ
     */
    private Integer clstrSeq;

    /**
     * 물리서버SEQ
     */
    private Integer pmSeq;

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
    @NotEmpty(message = "OS유형을 선택해주세요.", groups = { InsertVmCreReqValidation.class })
    private String osTyCd;

    /**
     * OS명
     */
    private String osNm;

    /**
     * 소프트웨어SEQ
     */
    @NotNull(message = "소프트웨어를 입력해주세요.", groups = { InsertVmCreReqValidation.class })
    private Integer swSeq;

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
    @NotNull(message = "요청 CPU(vCore)를 입력해주세요.", groups = { InsertVmCreReqValidation.class })
    @DecimalMin(message = "요청 CPU(vCore)는 {value} 이상의 숫자를 입력해주세요.", value = "1", groups = { InsertVmCreReqValidation.class })
    @DecimalMax(message = "요청 CPU(vCore)는 {value} 이하의 숫자를 입력해주세요.", value = ComConstant.CPU_VCORE_QTY_MAX_VALUE, groups = { InsertVmCreReqValidation.class })
    private BigDecimal reqCpuVcoreQty;

    /**
     * 요청메모리(GB)
     */
    @NotNull(message = "요청 메모리(GB)를 입력해주세요.", groups = { InsertVmCreReqValidation.class })
    @DecimalMin(message = "요청 메모리(GB)는 {value} 이상의 숫자를 입력해주세요.", value = "1", groups = { InsertVmCreReqValidation.class })
    @DecimalMax(message = "요청 메모리(GB)는 {value} 이하의 숫자를 입력해주세요.", value = ComConstant.MEM_ASGN_CAPA_GB_MAX_VALUE, groups = { InsertVmCreReqValidation.class })
    private BigDecimal reqMemAsgnCapa;

    /**
     * 요청가상스토리ID
     */
    private String reqVrStrgId;

    /**
     * 스토리지할당용량(GB)
     */
    private Integer strgAsgnCapa;

    /**
     * 첨부파일ID
     */
    private String atchFileId;

    /**
     * 비고
     */
    private String rmk;

    /**
     * 요청스펙SEQ
     */
    private Integer reqSpecSeq;

    /**
     * 템플릿SEQ
     */
    private Integer tmplatSeq;

    /**
     * 가상서버변경구분코드
     */
    private String vmChngClCd;

    /**
     * 변경전스펙SEQ
     */
    private Integer chngPreSpecSeq;

    /**
     * 변경전CPU(vCore)
     */
    private Integer chngPreCpuVcoreQty;

    /**
     * 변경전메모리할당량(GB)
     */
    private Integer chngPreMemAsgnCapa;

    /**
     * 변경요청스펙SEQ
     */
    private Integer chngReqSpecSeq;

    /**
     * 변경요청CPU(vCore)
     */
    @NotNull(message = "변경 CPU(vCore)를 입력해주세요.", groups = { InsertVmSpecModReqValidation.class })
    @DecimalMin(message = "변경 CPU(vCore)는 {value} 이상의 숫자를 입력해주세요.", value = "1", groups = { InsertVmSpecModReqValidation.class })
    @DecimalMax(message = "변경 CPU(vCore)는 {value} 이하의 숫자를 입력해주세요.", value = ComConstant.CPU_VCORE_QTY_MAX_VALUE, groups = { InsertVmSpecModReqValidation.class })
    private Integer chngReqCpuVcoreQty;

    /**
     * 변경요청메모리할당량(GB)
     */
    @NotNull(message = "변경 메모리(GB)를 입력해주세요.", groups = { InsertVmSpecModReqValidation.class })
    @DecimalMin(message = "변경 메모리(GB)는 {value} 이상의 숫자를 입력해주세요.", value = "1", groups = { InsertVmSpecModReqValidation.class })
    @DecimalMax(message = "변경 메모리(GB)는 {value} 이하의 숫자를 입력해주세요.", value = ComConstant.MEM_ASGN_CAPA_GB_MAX_VALUE, groups = { InsertVmSpecModReqValidation.class })
    private Integer chngReqMemAsgnCapa;

    /**
     * 변경요청스토리지할당량(GB)
     */
    @NotNull(message = "추가 스토리지(GB)를 입력해주세요.", groups = { InsertVmStrgAddReqValidation.class })
    @DecimalMin(message = "추가 스토리지(GB)는 {value} 이상의 숫자를 입력해주세요.", value = "1", groups = { InsertVmStrgAddReqValidation.class })
    @DecimalMax(message = "추가 스토리지(GB)는 {value} 이하의 숫자를 입력해주세요.", value = ComConstant.STRG_ASGN_CAPA_GB_MAX_VALUE, groups = { InsertVmStrgAddReqValidation.class })
    private Integer chngReqStrgAsgnCapa;

    /**
     * 할당가상디스크ID
     */
    private String asgnVrDskId;

    /**
     * 공유여부
     */
    private String shareYn;

    /**
     * 망구분코드
     */
    @NotEmpty(message = "망을 선택해주세요.", groups = { InsertVmCreReqValidation.class })
    private String netClCd;

    /**
     * 등록일시
     */
    private String regDttm;

    /**
     * 완료일시
     */
    private String comptDttm;

    /**
     * 운영담당자ID
     */
    private String oprChargerId;

    /**
     * 운영사업자ID
     */
    private String oprBusnssOperId;

    /**
     * 클러스터용도구분코드
     */
    private String clstrPrposClCd;

    /**
     * 변경전스토리지할당량(GB)
     */
    private Integer chngPreStrgAsgnCapa;

    /**
     * 요청스토리지도메인SEQ
     */
    private Integer reqStrgDmnSeq;

    /**
     * 요청최대메모리
     */
    private Integer reqMaxMemAsgnCapa;  /* 요청최대메모리 */

    /**
     * 요청최대CPU(vCore)
     */
	private Integer reqMaxCpuVcoreQty;  /* 요청최대CPU(vCore) */

	/**
     * 요청최소메모리
     */
	private Integer reqMinMemAsgnCapa;  /* 요청최소메모리 */

	/**
     * 요청최소CPU(vCore)
     */
	private Integer reqMinCpuVcoreQty;  /* 요청최소CPU(vCore) */

	/**
     * 청엔타이틀먼트최소값
     */
	private BigDecimal reqEntMinVl;  /* 요청엔타이틀먼트최소값 */

	/**
     * 요청엔타이틀먼트최대값
     */
	private BigDecimal reqEntMaxVl;  /* 요청엔타이틀먼트최대값 */

	/**
     * 요청엔타이틀먼트기본값
     */
	private BigDecimal reqEntDfltVl; /* 요청엔타이틀먼트기본값 */

	/**
     * 가상서버중지여부
     */
	private String vmStopYn;  /* 가상서버중지여부 */

	/**
     * 요청스토리지할당정책코드
     */
	private String reqStrgAsgnPolicyCd;   /* 요청스토리지할당정책코드 */




    /**
     * 가상서버SEQ
     */
    @NotNull(message = "가상서버를 선택해주세요.", groups = { InsertVmSpecModReqValidation.class, InsertVmStrgAddReqValidation.class, InsertVmDelReqValidation.class })
    private BigDecimal vmSeq;

    public String getRsrcReqNo()
    {
        return rsrcReqNo;
    }

    public void setRsrcReqNo(String rsrcReqNo)
    {
        this.rsrcReqNo = rsrcReqNo;
    }

    public BigDecimal getRsrcReqSeq() {
        return rsrcReqSeq;
    }

    public void setRsrcReqSeq(BigDecimal rsrcReqSeq) {
        this.rsrcReqSeq = rsrcReqSeq;
    }

    public String getRsrcReqCn()
    {
        return rsrcReqCn;
    }

    public void setRsrcReqCn(String rsrcReqCn)
    {
        this.rsrcReqCn = rsrcReqCn;
    }

    public String getRsrcReqTyCd()
    {
        return rsrcReqTyCd;
    }

    public void setRsrcReqTyCd(String rsrcReqTyCd)
    {
        this.rsrcReqTyCd = rsrcReqTyCd;
    }

    public String getRsrcReqPrcssStatCd()
    {
        return rsrcReqPrcssStatCd;
    }

    public void setRsrcReqPrcssStatCd(String rsrcReqPrcssStatCd)
    {
        this.rsrcReqPrcssStatCd = rsrcReqPrcssStatCd;
    }

    public int getProcssInstSeq() {
        return procssInstSeq;
    }

    public void setProcssInstSeq(int procssInstSeq) {
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

    public String getRjctTyCd()
    {
        return rjctTyCd;
    }

    public void setRjctTyCd(String rjctTyCd)
    {
        this.rjctTyCd = rjctTyCd;
    }

    public String getRjctReasn()
    {
        return rjctReasn;
    }

    public void setRjctReasn(String rjctReasn)
    {
        this.rjctReasn = rjctReasn;
    }

    public String getRjctDttm()
    {
        return rjctDttm;
    }

    public void setRjctDttm(String rjctDttm)
    {
        this.rjctDttm = rjctDttm;
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

    public String getRsrcPoolId()
    {
        return rsrcPoolId;
    }

    public void setRsrcPoolId(String rsrcPoolId)
    {
        this.rsrcPoolId = rsrcPoolId;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getIpAutoAsgnYn()
    {
        return ipAutoAsgnYn;
    }

    public void setIpAutoAsgnYn(String ipAutoAsgnYn)
    {
        this.ipAutoAsgnYn = ipAutoAsgnYn;
    }

    public String getVmId()
    {
        return vmId;
    }

    public void setVmId(String vmId)
    {
        this.vmId = vmId;
    }

    public String getVmNm()
    {
        return vmNm;
    }

    public void setVmNm(String vmNm)
    {
        this.vmNm = vmNm;
    }

    public String getVmCompId()
    {
        return vmCompId;
    }

    public void setVmCompId(String vmCompId)
    {
        this.vmCompId = vmCompId;
    }

    public String getHstNm()
    {
        return hstNm;
    }

    public void setHstNm(String hstNm)
    {
        this.hstNm = hstNm;
    }

    public String getPrposClCd()
    {
        return prposClCd;
    }

    public void setPrposClCd(String prposClCd)
    {
        this.prposClCd = prposClCd;
    }

    public String getUseGvDprtId()
    {
        return useGvDprtId;
    }

    public void setUseGvDprtId(String useGvDprtId)
    {
        this.useGvDprtId = useGvDprtId;
    }

    public String getUseJobId()
    {
        return useJobId;
    }

    public void setUseJobId(String useJobId)
    {
        this.useJobId = useJobId;
    }

    public String getVrCnvrSwTyCd()
    {
        return vrCnvrSwTyCd;
    }

    public void setVrCnvrSwTyCd(String vrCnvrSwTyCd)
    {
        this.vrCnvrSwTyCd = vrCnvrSwTyCd;
    }

    public Integer getClstrSeq() {
        return clstrSeq;
    }

    public void setClstrSeq(Integer clstrSeq) {
        this.clstrSeq = clstrSeq;
    }

    public Integer getPmSeq() {
        return pmSeq;
    }

    public void setPmSeq(Integer pmSeq) {
        this.pmSeq = pmSeq;
    }

    public String getRsrcPoolNm()
    {
        return rsrcPoolNm;
    }

    public void setRsrcPoolNm(String rsrcPoolNm)
    {
        this.rsrcPoolNm = rsrcPoolNm;
    }

    public String getIpAddr()
    {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr)
    {
        this.ipAddr = ipAddr;
    }

    public String getOsTyCd()
    {
        return osTyCd;
    }

    public void setOsTyCd(String osTyCd)
    {
        this.osTyCd = osTyCd;
    }

    public String getOsNm()
    {
        return osNm;
    }

    public void setOsNm(String osNm)
    {
        this.osNm = osNm;
    }

    public Integer getSwSeq()
    {
        return swSeq;
    }

    public void setSwSeq(Integer swSeq)
    {
        this.swSeq = swSeq;
    }

    public String getServcStrtDt()
    {
        return servcStrtDt;
    }

    public void setServcStrtDt(String servcStrtDt)
    {
        this.servcStrtDt = servcStrtDt;
    }

    public String getServcEndDt()
    {
        return servcEndDt;
    }

    public void setServcEndDt(String servcEndDt)
    {
        this.servcEndDt = servcEndDt;
    }

    public BigDecimal getReqCpuVcoreQty()
    {
        return reqCpuVcoreQty;
    }

    public void setReqCpuVcoreQty(BigDecimal reqCpuVcoreQty)
    {
        this.reqCpuVcoreQty = reqCpuVcoreQty;
    }

    public BigDecimal getReqMemAsgnCapa()
    {
        return reqMemAsgnCapa;
    }

    public void setReqMemAsgnCapa(BigDecimal reqMemAsgnCapa)
    {
        this.reqMemAsgnCapa = reqMemAsgnCapa;
    }

    public String getReqVrStrgId()
    {
        return reqVrStrgId;
    }

    public void setReqVrStrgId(String reqVrStrgId)
    {
        this.reqVrStrgId = reqVrStrgId;
    }

    public Integer getStrgAsgnCapa()
    {
        return strgAsgnCapa;
    }

    public void setStrgAsgnCapa(Integer strgAsgnCapa)
    {
        this.strgAsgnCapa = strgAsgnCapa;
    }

    public String getAtchFileId()
    {
        return atchFileId;
    }

    public void setAtchFileId(String atchFileId)
    {
        this.atchFileId = atchFileId;
    }

    public String getRmk()
    {
        return rmk;
    }

    public void setRmk(String rmk)
    {
        this.rmk = rmk;
    }

    public Integer getReqSpecSeq()
    {
        return reqSpecSeq;
    }

    public void setReqSpecSeq(Integer reqSpecSeq)
    {
        this.reqSpecSeq = reqSpecSeq;
    }

    public Integer getTmplatSeq()
    {
        return tmplatSeq;
    }

    public void setTmplatSeq(Integer tmplatSeq)
    {
        this.tmplatSeq = tmplatSeq;
    }

    public String getVmChngClCd() {
        return vmChngClCd;
    }

    public void setVmChngClCd(String vmChngClCd) {
        this.vmChngClCd = vmChngClCd;
    }

    public Integer getChngPreSpecSeq()
    {
        return chngPreSpecSeq;
    }

    public void setChngPreSpecSeq(Integer chngPreSpecSeq)
    {
        this.chngPreSpecSeq = chngPreSpecSeq;
    }

    public Integer getChngPreCpuVcoreQty()
    {
        return chngPreCpuVcoreQty;
    }

    public void setChngPreCpuVcoreQty(Integer chngPreCpuVcoreQty)
    {
        this.chngPreCpuVcoreQty = chngPreCpuVcoreQty;
    }

    public Integer getChngPreMemAsgnCapa()
    {
        return chngPreMemAsgnCapa;
    }

    public void setChngPreMemAsgnCapa(Integer chngPreMemAsgnCapa)
    {
        this.chngPreMemAsgnCapa = chngPreMemAsgnCapa;
    }

    public Integer getChngReqSpecSeq()
    {
        return chngReqSpecSeq;
    }

    public void setChngReqSpecSeq(Integer chngReqSpecSeq)
    {
        this.chngReqSpecSeq = chngReqSpecSeq;
    }

    public Integer getChngReqCpuVcoreQty()
    {
        return chngReqCpuVcoreQty;
    }

    public void setChngReqCpuVcoreQty(Integer chngReqCpuVcoreQty)
    {
        this.chngReqCpuVcoreQty = chngReqCpuVcoreQty;
    }

    public Integer getChngReqMemAsgnCapa()
    {
        return chngReqMemAsgnCapa;
    }

    public void setChngReqMemAsgnCapa(Integer chngReqMemAsgnCapa)
    {
        this.chngReqMemAsgnCapa = chngReqMemAsgnCapa;
    }

    public Integer getChngReqStrgAsgnCapa()
    {
        return chngReqStrgAsgnCapa;
    }

    public void setChngReqStrgAsgnCapa(Integer chngReqStrgAsgnCapa)
    {
        this.chngReqStrgAsgnCapa = chngReqStrgAsgnCapa;
    }

    public String getAsgnVrDskId()
    {
        return asgnVrDskId;
    }

    public void setAsgnVrDskId(String asgnVrDskId)
    {
        this.asgnVrDskId = asgnVrDskId;
    }

    public String getShareYn()
    {
        return shareYn;
    }

    public void setShareYn(String shareYn)
    {
        this.shareYn = shareYn;
    }

    public String getNetClCd()
    {
        return netClCd;
    }

    public void setNetClCd(String netClCd)
    {
        this.netClCd = netClCd;
    }

    public String getRegDttm()
    {
        return regDttm;
    }

    public void setRegDttm(String regDttm)
    {
        this.regDttm = regDttm;
    }

    public String getComptDttm()
    {
        return comptDttm;
    }

    public void setComptDttm(String comptDttm)
    {
        this.comptDttm = comptDttm;
    }

    public String getOprChargerId()
    {
        return oprChargerId;
    }

    public void setOprChargerId(String oprChargerId)
    {
        this.oprChargerId = oprChargerId;
    }

    public String getOprBusnssOperId()
    {
        return oprBusnssOperId;
    }

    public void setOprBusnssOperId(String oprBusnssOperId)
    {
        this.oprBusnssOperId = oprBusnssOperId;
    }

    public Integer getChngPreStrgAsgnCapa()
    {
        return chngPreStrgAsgnCapa;
    }

    public void setChngPreStrgAsgnCapa(Integer chngPreStrgAsgnCapa)
    {
        this.chngPreStrgAsgnCapa = chngPreStrgAsgnCapa;
    }

    public String getClstrPrposClCd() {
        return clstrPrposClCd;
    }

    public void setClstrPrposClCd(String clstrPrposClCd) {
        this.clstrPrposClCd = clstrPrposClCd;
    }

    /**
     * @return the reqStrgDmnSeq
     */
    public Integer getReqStrgDmnSeq() {
        return reqStrgDmnSeq;
    }

    /**
     * @param reqStrgDmnSeq the reqStrgDmnSeq to set
     */
    public void setReqStrgDmnSeq(Integer reqStrgDmnSeq) {
        this.reqStrgDmnSeq = reqStrgDmnSeq;
    }

    public BigDecimal getVmSeq() {
        return vmSeq;
    }

    public void setVmSeq(BigDecimal vmSeq) {
        this.vmSeq = vmSeq;
    }

	public String getExeStatCd() {
		return exeStatCd;
	}

	public void setExeStatCd(String exeStatCd) {
		this.exeStatCd = exeStatCd;
	}

	public Integer getReqMaxMemAsgnCapa() {
		return reqMaxMemAsgnCapa;
	}

	public void setReqMaxMemAsgnCapa(Integer reqMaxMemAsgnCapa) {
		this.reqMaxMemAsgnCapa = reqMaxMemAsgnCapa;
	}

	public Integer getReqMaxCpuVcoreQty() {
		return reqMaxCpuVcoreQty;
	}

	public void setReqMaxCpuVcoreQty(Integer reqMaxCpuVcoreQty) {
		this.reqMaxCpuVcoreQty = reqMaxCpuVcoreQty;
	}

	public Integer getReqMinMemAsgnCapa() {
		return reqMinMemAsgnCapa;
	}

	public void setReqMinMemAsgnCapa(Integer reqMinMemAsgnCapa) {
		this.reqMinMemAsgnCapa = reqMinMemAsgnCapa;
	}

	public Integer getReqMinCpuVcoreQty() {
		return reqMinCpuVcoreQty;
	}

	public void setReqMinCpuVcoreQty(Integer reqMinCpuVcoreQty) {
		this.reqMinCpuVcoreQty = reqMinCpuVcoreQty;
	}

	public BigDecimal getReqEntMinVl() {
		return reqEntMinVl;
	}

	public void setReqEntMinVl(BigDecimal reqEntMinVl) {
		this.reqEntMinVl = reqEntMinVl;
	}

	public BigDecimal getReqEntMaxVl() {
		return reqEntMaxVl;
	}

	public void setReqEntMaxVl(BigDecimal reqEntMaxVl) {
		this.reqEntMaxVl = reqEntMaxVl;
	}

	public BigDecimal getReqEntDfltVl() {
		return reqEntDfltVl;
	}

	public void setReqEntDfltVl(BigDecimal reqEntDfltVl) {
		this.reqEntDfltVl = reqEntDfltVl;
	}

	public String getVmStopYn() {
		return vmStopYn;
	}

	public void setVmStopYn(String vmStopYn) {
		this.vmStopYn = vmStopYn;
	}

	public String getReqStrgAsgnPolicyCd() {
		return reqStrgAsgnPolicyCd;
	}

	public void setReqStrgAsgnPolicyCd(String reqStrgAsgnPolicyCd) {
		this.reqStrgAsgnPolicyCd = reqStrgAsgnPolicyCd;
	}


}
