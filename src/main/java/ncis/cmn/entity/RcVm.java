package ncis.cmn.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import ncis.cmn.validation.groups.UpdateProc;
import ncis.cpt.rsrc.com.config.ComConstant;

/**
 * 가상서버 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author 심원보
 */

public class RcVm {

    /**
     * 가상서버SEQ
     */
    private BigDecimal vmSeq;

    /**
     * 가상서버ID
     */
    private String vmId;

    /**
     * 가상서버명
     */
    private String vmNm;

    /**
     * 상태코드
     */
    private String statCd;

    /**
     * 서비스시작일자
     */
    private Date servcStrtDt;

    /**
     * 서비스종료일자
     */
    private Date servcEndDt;

    /**
     * 호스트명
     */
    private String hstNm;

    /**
     * CPU사용율
     */
    private Double cpuUseRt;

    /**
     * CPU엔타이틀먼트
     */
    private Double cpuEnt;

    /**
     * CPU(vCore)
     */
    private Integer cpuVcoreQty;

    /**
     * 할당메모리용량(MB)
     */
    private Integer memAsgnCapa;

    /**
     * 메모리사용율
     */
    private Double memUseRt;

    /**
     * 할당스토리지용량(GB)
     */
    private Integer strgAsgnCapa;

    /**
     * 대표IP주소
     */
    private String rprsntIpAddr;

    /**
     * 운영체제유형코드
     */
    private String osTyCd;

    /**
     * 플랫폼
     */
    private String pltfrm;

    /**
     * 운영체제비트
     */
    private String osBit;

    /**
     * 커널버전
     */
    private String krnlVer;

    /**
     * 패치버전
     */
    private String patchVer;

    /**
     * 언어
     */
    private String lang;

    /**
     * 운영체계명
     */
    private String osNm;

    /**
     * 운영체계버전
     */
    private String osVer;

    /**
     * 네트워크_IN(KB/Sec)
     */
    private Double netwkIn;

    /**
     * 네트워크_OUT(KB/Sec)
     */
    private Double netwkOut;

    /**
     * 기동일시
     */
    private Date strtupDttm;

    /**
     * 생성일시
     */
    private Date creDttm;



    /**
     * 가상서버구성ID
     */
    /*@NotEmpty(message = "가상서버구성ID를 입력해주세요.", groups = { UpdateProc.class }) 가상서버구성ID가 필수체크를 안하도록 변경*/
    @Size(message = "가상서버구성ID는 {max}자 이내로 입력해주세요.", min = 0, max = ComConstant.VM_COMP_ID_MAX_LENGTH, groups = { UpdateProc.class })
    private String vmCompId;

    /**
     * 가상서버구분코드
     */
    private String vmClCd;

    /**
     * 템플릿ID
     */
    private BigDecimal tmplatSeq;

    /**
     * 이중화(HA)여부
     */
    private String haYn;

    /**
     * 기관ID
     */
    private String institutionId;

    /**
     * 물리서버SEQ
     */
    private BigDecimal pmSeq;

    /**
     * UUID
     */
    private String uuid;

    /**
     * 등록자ID
     */
    private String regUserId;

    /**
     * 등록일시
     */
    private Timestamp regDttm;

    /**
     * 삭제자ID
     */
    private String delUserId;

    /**
     * 삭제일시
     */
    private Timestamp delDttm;

    /**
     * 삭제여부
     */
    private String delYn;

    /**
     * 수정자ID
     */
    private String updtUserId;

    /**
     * 수정일시
     */
    private Timestamp updtDttm;

    /**
     * 동기화일시
     */
    private Timestamp syncDttm;

    /**
     * 비고
     */
    @Size(message = "비고는 {max}자 이내로 입력해주세요.", min = 0, max = ComConstant.VM_RMK_MAX_LENGTH, groups = { UpdateProc.class })
    private String rmk;

    /**
     * 네트워크서비스SID
     */
    private String nsSid;

    /**
     * 네트워크기능SID
     */
    private String nfSid;

    /**
     * 네트워크유형구분코드
     */
    private String netwkTyClCd;

    /**
     * 클러스터SEQ
     */
    private BigDecimal clstrSeq;

    /**
     * 패키지 대상여부
     */
    private String packgMngTrgtYn;

    private String tempVmCompId;//구성ID OLD


    /**
     * 최대할당메모리용량(GB)
     */
    private Integer maxMemAsgnCapa;

    /**
     * 최소할당메모리용량(GB)
     */
    private Integer minMemAsgnCapa	;

    /**
     * 최대CPU(vCore)
     */
    private Integer maxCpuVcoreQty;

    /**
     * 최소CPU(vCore)
     */
    private Integer minCpuVcoreQty;


    /**
     * HA그룹아이디
     */
    private String haGrpId;


    /**
	 * @return the tempVmCompId
	 */
	public String getTempVmCompId() {
		return tempVmCompId;
	}

	/**
	 * @param tempVmCompId the tempVmCompId to set
	 */
	public void setTempVmCompId(String tempVmCompId) {
		this.tempVmCompId = tempVmCompId;
	}

	public BigDecimal getVmSeq() {
        return vmSeq;
    }

    public void setVmSeq(BigDecimal vmSeq) {
        this.vmSeq = vmSeq;
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

    public String getStatCd() {
        return statCd;
    }

    public void setStatCd(String statCd) {
        this.statCd = statCd;
    }

    public Date getServcStrtDt() {
        return servcStrtDt;
    }

    public void setServcStrtDt(Date servcStrtDt) {
        this.servcStrtDt = servcStrtDt;
    }

    public Date getServcEndDt() {
        return servcEndDt;
    }

    public void setServcEndDt(Date servcEndDt) {
        this.servcEndDt = servcEndDt;
    }

    public String getHstNm() {
        return hstNm;
    }

    public void setHstNm(String hstNm) {
        this.hstNm = hstNm;
    }

    public Double getCpuUseRt() {
        return cpuUseRt;
    }

    public void setCpuUseRt(Double cpuUseRt) {
        this.cpuUseRt = cpuUseRt;
    }

    public Double getCpuEnt() {
        return cpuEnt;
    }

    public void setCpuEnt(Double cpuEnt) {
        this.cpuEnt = cpuEnt;
    }

    public Integer getCpuVcoreQty() {
        return cpuVcoreQty;
    }

    public void setCpuVcoreQty(Integer cpuVcoreQty) {
        this.cpuVcoreQty = cpuVcoreQty;
    }

    public Integer getMemAsgnCapa() {
        return memAsgnCapa;
    }

    public void setMemAsgnCapa(Integer memAsgnCapa) {
        this.memAsgnCapa = memAsgnCapa;
    }

    public Double getMemUseRt() {
        return memUseRt;
    }

    public void setMemUseRt(Double memUseRt) {
        this.memUseRt = memUseRt;
    }

    public Integer getStrgAsgnCapa() {
        return strgAsgnCapa;
    }

    public void setStrgAsgnCapa(Integer strgAsgnCapa) {
        this.strgAsgnCapa = strgAsgnCapa;
    }

    public String getRprsntIpAddr() {
        return rprsntIpAddr;
    }

    public void setRprsntIpAddr(String rprsntIpAddr) {
        this.rprsntIpAddr = rprsntIpAddr;
    }

    public String getOsTyCd() {
        return osTyCd;
    }

    public void setOsTyCd(String osTyCd) {
        this.osTyCd = osTyCd;
    }

    public String getPltfrm() {
        return pltfrm;
    }

    public void setPltfrm(String pltfrm) {
        this.pltfrm = pltfrm;
    }

    public String getOsBit() {
        return osBit;
    }

    public void setOsBit(String osBit) {
        this.osBit = osBit;
    }

    public String getKrnlVer() {
        return krnlVer;
    }

    public void setKrnlVer(String krnlVer) {
        this.krnlVer = krnlVer;
    }

    public String getPatchVer() {
        return patchVer;
    }

    public void setPatchVer(String patchVer) {
        this.patchVer = patchVer;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getOsNm() {
        return osNm;
    }

    public void setOsNm(String osNm) {
        this.osNm = osNm;
    }

    public String getOsVer() {
        return osVer;
    }

    public void setOsVer(String osVer) {
        this.osVer = osVer;
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

    public Date getStrtupDttm() {
        return strtupDttm;
    }

    public void setStrtupDttm(Date strtupDttm) {
        this.strtupDttm = strtupDttm;
    }

    public String getVmCompId() {
        return vmCompId;
    }

    public void setVmCompId(String vmCompId) {
        this.vmCompId = vmCompId;
    }

    public String getVmClCd() {
        return vmClCd;
    }

    public void setVmClCd(String vmClCd) {
        this.vmClCd = vmClCd;
    }

    public BigDecimal getTmplatSeq() {
        return tmplatSeq;
    }

    public void setTmplatSeq(BigDecimal tmplatSeq) {
        this.tmplatSeq = tmplatSeq;
    }

    public String getHaYn() {
        return haYn;
    }

    public void setHaYn(String haYn) {
        this.haYn = haYn;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public BigDecimal getPmSeq() {
        return pmSeq;
    }

    public void setPmSeq(BigDecimal pmSeq) {
        this.pmSeq = pmSeq;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRegUserId() {
        return regUserId;
    }

    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    public Timestamp getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(Timestamp regDttm) {
        this.regDttm = regDttm;
    }

    public String getDelUserId() {
        return delUserId;
    }

    public void setDelUserId(String delUserId) {
        this.delUserId = delUserId;
    }

    public Date getDelDttm() {
        return delDttm;
    }

    public void setDelDttm(Timestamp delDttm) {
        this.delDttm = delDttm;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    public String getUpdtUserId() {
        return updtUserId;
    }

    public void setUpdtUserId(String updtUserId) {
        this.updtUserId = updtUserId;
    }

    public Date getUpdtDttm() {
        return updtDttm;
    }

    public void setUpdtDttm(Timestamp updtDttm) {
        this.updtDttm = updtDttm;
    }

    public Date getSyncDttm() {
        return syncDttm;
    }

    public void setSyncDttm(Timestamp syncDttm) {
        this.syncDttm = syncDttm;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

    public String getNsSid() {
        return nsSid;
    }

    public void setNsSid(String nsSid) {
        this.nsSid = nsSid;
    }

    public String getNfSid() {
        return nfSid;
    }

    public void setNfSid(String nfSid) {
        this.nfSid = nfSid;
    }

    public String getNetwkTyClCd() {
        return netwkTyClCd;
    }

	public void setNetwkTyClCd(String netwkTyClCd) {
        this.netwkTyClCd = netwkTyClCd;
    }

    public String getPackgMngTrgtYn() {
        return packgMngTrgtYn;
    }

    public void setPackgMngTrgtYn(String packgMngTrgtYn) {
        this.packgMngTrgtYn = packgMngTrgtYn;
    }

	/**
	 * @return the clstrSeq
	 */
	public BigDecimal getClstrSeq() {
		return clstrSeq;
	}

	/**
	 * @param clstrSeq the clstrSeq to set
	 */
	public void setClstrSeq(BigDecimal clstrSeq) {
		this.clstrSeq = clstrSeq;
	}

	public Integer getMaxMemAsgnCapa() {
		return maxMemAsgnCapa;
	}

	public void setMaxMemAsgnCapa(Integer maxMemAsgnCapa) {
		this.maxMemAsgnCapa = maxMemAsgnCapa;
	}

	public Integer getMinMemAsgnCapa() {
		return minMemAsgnCapa;
	}

	public void setMinMemAsgnCapa(Integer minMemAsgnCapa) {
		this.minMemAsgnCapa = minMemAsgnCapa;
	}

	public Integer getMaxCpuVcoreQty() {
		return maxCpuVcoreQty;
	}

	public void setMaxCpuVcoreQty(Integer maxCpuVcoreQty) {
		this.maxCpuVcoreQty = maxCpuVcoreQty;
	}

	public Integer getMinCpuVcoreQty() {
		return minCpuVcoreQty;
	}

	public void setMinCpuVcoreQty(Integer minCpuVcoreQty) {
		this.minCpuVcoreQty = minCpuVcoreQty;
	}

	public String getHaGrpId() {
		return haGrpId;
	}

	public void setHaGrpId(String haGrpId) {
		this.haGrpId = haGrpId;
	}

	/**
	 * @return the creDttm
	 */
	public Date getCreDttm()
	{
		return creDttm;
	}

	/**
	 * @param creDttm the creDttm to set
	 */
	public void setCreDttm(Date creDttm)
	{
		this.creDttm = creDttm;
	}

}
