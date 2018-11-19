package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 서버구성정보 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class SiSrvrComp {

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
     * 네트워크영역구분코드
     */
    @NotEmpty(message = "네트워크영역구분코드는(은) 필수입력 항목입니다.")
    private String netwkAreaClCd;

    /**
     * 대표IP주소
     */
    private String rprsntId;

    /**
     * MAC주소
     */
    private String macAddr;

    /**
     * 서버용도
     */
    private String srvrPrpos;

    /**
     * CPU타입
     */
    private String cpuTy;

    /**
     * CPU제조사
     */
    private String cpuMnfctCo;

    /**
     * CPU코어구분
     */
    private String cpuCorCl;

    /**
     * 물리적CPU개수
     */
    private BigDecimal phyCpuQty;

    /**
     * 물리적CPU총개수
     */
    private BigDecimal phyCpuTotQty;

    /**
     * 사용논리CPU코어개수
     */
    private BigDecimal useLogicCoreQty;

    /**
     * 사용논리코어총개수
     */
    private BigDecimal useLogicCoreTotQty;

    /**
     * 설치메모리개수
     */
    private BigDecimal instlMemQty;

    /**
     * 설치메모리총개수
     */
    private BigDecimal instlMemTotQty;

    /**
     * 사용메모리용량(MB)
     */
    private BigDecimal useMemCapa;

    /**
     * 사용메모리총용량(MB)
     */
    private BigDecimal useMemTotCapa;

    /**
     * 내장디스크개수
     */
    private BigDecimal indcoDskQty;

    /**
     * 내장디스크총개수
     */
    private BigDecimal indcoDskTotQty;

    /**
     * 사용내장디스크용량(GB)
     */
    private BigDecimal useIndcoDskCapa;

    /**
     * 사용내장디스크총용량(GB)
     */
    private BigDecimal useIndcoDskTotCapa;

    /**
     * 스토리지연결여부
     */
    private String strgConnYn;

    /**
     * 할당스토리지총용량(GB)
     */
    private BigDecimal asgnStrgTotCapa;

    /**
     * 사용네트워크포트개수
     */
    private BigDecimal useNetwkPortQty;

    /**
     * KVM연결내용
     */
    private String kvmConnCn;

    /**
     * 운영체제명
     */
    private String osNm;

    /**
     * 운영체제버전
     */
    private String osVer;

    /**
     * 패치버전
     */
    private String patchVer;

    /**
     * 커널버전
     */
    private String krnlVer;

    /**
     * 가상머신유형코드
     */
    private String vmTyCd;

    /**
     * nSIMS용대표IP
     */
    private String rprsntIp;

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

    public String getNetwkAreaClCd() {
        return netwkAreaClCd;
    }

    public void setNetwkAreaClCd(String netwkAreaClCd) {
        this.netwkAreaClCd = netwkAreaClCd;
    }

    public String getRprsntId() {
        return rprsntId;
    }

    public void setRprsntId(String rprsntId) {
        this.rprsntId = rprsntId;
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    public String getSrvrPrpos() {
        return srvrPrpos;
    }

    public void setSrvrPrpos(String srvrPrpos) {
        this.srvrPrpos = srvrPrpos;
    }

    public String getCpuTy() {
        return cpuTy;
    }

    public void setCpuTy(String cpuTy) {
        this.cpuTy = cpuTy;
    }

    public String getCpuMnfctCo() {
        return cpuMnfctCo;
    }

    public void setCpuMnfctCo(String cpuMnfctCo) {
        this.cpuMnfctCo = cpuMnfctCo;
    }

    public String getCpuCorCl() {
        return cpuCorCl;
    }

    public void setCpuCorCl(String cpuCorCl) {
        this.cpuCorCl = cpuCorCl;
    }

    public BigDecimal getPhyCpuQty() {
        return phyCpuQty;
    }

    public void setPhyCpuQty(BigDecimal phyCpuQty) {
        this.phyCpuQty = phyCpuQty;
    }

    public BigDecimal getPhyCpuTotQty() {
        return phyCpuTotQty;
    }

    public void setPhyCpuTotQty(BigDecimal phyCpuTotQty) {
        this.phyCpuTotQty = phyCpuTotQty;
    }

    public BigDecimal getUseLogicCoreQty() {
        return useLogicCoreQty;
    }

    public void setUseLogicCoreQty(BigDecimal useLogicCoreQty) {
        this.useLogicCoreQty = useLogicCoreQty;
    }

    public BigDecimal getUseLogicCoreTotQty() {
        return useLogicCoreTotQty;
    }

    public void setUseLogicCoreTotQty(BigDecimal useLogicCoreTotQty) {
        this.useLogicCoreTotQty = useLogicCoreTotQty;
    }

    public BigDecimal getInstlMemQty() {
        return instlMemQty;
    }

    public void setInstlMemQty(BigDecimal instlMemQty) {
        this.instlMemQty = instlMemQty;
    }

    public BigDecimal getInstlMemTotQty() {
        return instlMemTotQty;
    }

    public void setInstlMemTotQty(BigDecimal instlMemTotQty) {
        this.instlMemTotQty = instlMemTotQty;
    }

    public BigDecimal getUseMemCapa() {
        return useMemCapa;
    }

    public void setUseMemCapa(BigDecimal useMemCapa) {
        this.useMemCapa = useMemCapa;
    }

    public BigDecimal getUseMemTotCapa() {
        return useMemTotCapa;
    }

    public void setUseMemTotCapa(BigDecimal useMemTotCapa) {
        this.useMemTotCapa = useMemTotCapa;
    }

    public BigDecimal getIndcoDskQty() {
        return indcoDskQty;
    }

    public void setIndcoDskQty(BigDecimal indcoDskQty) {
        this.indcoDskQty = indcoDskQty;
    }

    public BigDecimal getIndcoDskTotQty() {
        return indcoDskTotQty;
    }

    public void setIndcoDskTotQty(BigDecimal indcoDskTotQty) {
        this.indcoDskTotQty = indcoDskTotQty;
    }

    public BigDecimal getUseIndcoDskCapa() {
        return useIndcoDskCapa;
    }

    public void setUseIndcoDskCapa(BigDecimal useIndcoDskCapa) {
        this.useIndcoDskCapa = useIndcoDskCapa;
    }

    public BigDecimal getUseIndcoDskTotCapa() {
        return useIndcoDskTotCapa;
    }

    public void setUseIndcoDskTotCapa(BigDecimal useIndcoDskTotCapa) {
        this.useIndcoDskTotCapa = useIndcoDskTotCapa;
    }

    public String getStrgConnYn() {
        return strgConnYn;
    }

    public void setStrgConnYn(String strgConnYn) {
        this.strgConnYn = strgConnYn;
    }

    public BigDecimal getAsgnStrgTotCapa() {
        return asgnStrgTotCapa;
    }

    public void setAsgnStrgTotCapa(BigDecimal asgnStrgTotCapa) {
        this.asgnStrgTotCapa = asgnStrgTotCapa;
    }

    public BigDecimal getUseNetwkPortQty() {
        return useNetwkPortQty;
    }

    public void setUseNetwkPortQty(BigDecimal useNetwkPortQty) {
        this.useNetwkPortQty = useNetwkPortQty;
    }

    public String getKvmConnCn() {
        return kvmConnCn;
    }

    public void setKvmConnCn(String kvmConnCn) {
        this.kvmConnCn = kvmConnCn;
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

    public String getPatchVer() {
        return patchVer;
    }

    public void setPatchVer(String patchVer) {
        this.patchVer = patchVer;
    }

    public String getKrnlVer() {
        return krnlVer;
    }

    public void setKrnlVer(String krnlVer) {
        this.krnlVer = krnlVer;
    }

    public String getVmTyCd() {
        return vmTyCd;
    }

    public void setVmTyCd(String vmTyCd) {
        this.vmTyCd = vmTyCd;
    }

    public String getRprsntIp() {
        return rprsntIp;
    }

    public void setRprsntIp(String rprsntIp) {
        this.rprsntIp = rprsntIp;
    }

}
