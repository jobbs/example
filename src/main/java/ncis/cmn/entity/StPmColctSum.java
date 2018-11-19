package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 물리서버_수집집계 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class StPmColctSum {

    /**
     * 수집일자
     */
    @NotEmpty(message = "수집일자는(은) 필수입력 항목입니다.")
    private String colctDt;

    /**
     * 수집시간
     */
    @NotEmpty(message = "수집시간는(은) 필수입력 항목입니다.")
    private String colctHour;

    /**
     * 수집분
     */
    @NotEmpty(message = "수집분는(은) 필수입력 항목입니다.")
    private String colctMi;

    /**
     * 물리서버ID
     */
    @NotEmpty(message = "물리서버ID는(은) 필수입력 항목입니다.")
    private String pmId;

    /**
     * 기관ID
     */
    private String institutionId;

    /**
     * 업무ID
     */
    private String jobId;

    /**
     * 리전ID
     */
    private String regionId;

    /**
     * 존ID
     */
    private String zoneId;

    /**
     * 망ID
     */
    private String netId;

    /**
     * 자원풀ID
     */
    private String rsrcPoolId;

    /**
     * 수집주기
     */
    private String colctCycle;

    /**
     * 최종서버상태코드
     */
    private String lastSrvrStatCd;

    /**
     * 최종가상서버개수
     */
    private BigDecimal lastVSrvrQty;

    /**
     * 합계가상서버개수
     */
    private BigDecimal sumVSrvrQty;

    /**
     * 평균가상서버개수
     */
    private BigDecimal avgVSrvrQty;

    /**
     * 최종CPU물리적코어개수
     */
    @NotEmpty(message = "최종CPU물리적코어개수는(은) 필수입력 항목입니다.")
    private BigDecimal lastCpuCorQty;

    /**
     * 합계CPU물리적코어개수
     */
    private BigDecimal sumCpuCorQty;

    /**
     * 평균CPU물리적코어개수
     */
    private BigDecimal avgCpuCorQty;

    /**
     * 최종할당vCore개수
     */
    private BigDecimal lastAsgnVcorQty;

    /**
     * 합계할당vCore개수
     */
    private BigDecimal sumAsgnVcorQty;

    /**
     * 평균할당vCore개수
     */
    private BigDecimal avgAsgnVcorQty;

    /**
     * 합계CPU사용율
     */
    private BigDecimal sumCpuUseRt;

    /**
     * 평균CPU사용율
     */
    private BigDecimal avgCpuUseRt;

    /**
     * 최대CPU사용율
     */
    private BigDecimal maxCpuUseRt;

    /**
     * 최소CPU사용율
     */
    private BigDecimal minCpuUseRt;

    /**
     * 최종메모리총용량
     */
    private BigDecimal lastMemSumCapa;

    /**
     * 합계메모리총용량
     */
    private BigDecimal sumMemSumCapa;

    /**
     * 평균메모리총용량
     */
    private BigDecimal avgMemSumCapa;

    /**
     * 최종할당메모리용량
     */
    private BigDecimal lastAsgnMemCapa;

    /**
     * 합계할당메모리총용량
     */
    private BigDecimal sumAsgnMemCapa;

    /**
     * 평균할당메모리총용량
     */
    private BigDecimal avgAsgnMemCapa;

    /**
     * 합계메모리사용량
     */
    private BigDecimal sumMemUseCapa;

    /**
     * 최대메모리사용량
     */
    private BigDecimal maxMemUseCapa;

    /**
     * 최소메모리사용량
     */
    private BigDecimal minMemUseCapa;

    /**
     * 평균메모리사용량
     */
    private BigDecimal avgMemUseCapa;

    /**
     * 평균메모리사용율
     */
    private BigDecimal avgMemUseRt;

    /**
     * 최대메모리사용율
     */
    private BigDecimal maxMemUseRt;

    /**
     * 최소메모리사용율
     */
    private BigDecimal minMemUseRt;

    /**
     * 최종스토리지총용량
     */
    private BigDecimal lastStrgSumCapa;

    /**
     * 합계스토리지총용량
     */
    private BigDecimal sumStrgSumCapa;

    /**
     * 평균스토리지총용량
     */
    private BigDecimal avgStrgSumCapa;

    /**
     * 합계스토리지사용량
     */
    private BigDecimal sumStrgUseCapa;

    /**
     * 평균스토리지사용량
     */
    private BigDecimal avgStrgUseCapa;

    /**
     * 최대스토리지사용량
     */
    private BigDecimal maxStrgUseCapa;

    /**
     * 최소스토리지사용량
     */
    private BigDecimal minStrgUseCapa;

    public String getColctDt() {
        return colctDt;
    }

    public void setColctDt(String colctDt) {
        this.colctDt = colctDt;
    }

    public String getColctHour() {
        return colctHour;
    }

    public void setColctHour(String colctHour) {
        this.colctHour = colctHour;
    }

    public String getColctMi() {
        return colctMi;
    }

    public void setColctMi(String colctMi) {
        this.colctMi = colctMi;
    }

    public String getPmId() {
        return pmId;
    }

    public void setPmId(String pmId) {
        this.pmId = pmId;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
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

    public String getRsrcPoolId() {
        return rsrcPoolId;
    }

    public void setRsrcPoolId(String rsrcPoolId) {
        this.rsrcPoolId = rsrcPoolId;
    }

    public String getColctCycle() {
        return colctCycle;
    }

    public void setColctCycle(String colctCycle) {
        this.colctCycle = colctCycle;
    }

    public String getLastSrvrStatCd() {
        return lastSrvrStatCd;
    }

    public void setLastSrvrStatCd(String lastSrvrStatCd) {
        this.lastSrvrStatCd = lastSrvrStatCd;
    }

    public BigDecimal getLastVSrvrQty() {
        return lastVSrvrQty;
    }

    public void setLastVSrvrQty(BigDecimal lastVSrvrQty) {
        this.lastVSrvrQty = lastVSrvrQty;
    }

    public BigDecimal getSumVSrvrQty() {
        return sumVSrvrQty;
    }

    public void setSumVSrvrQty(BigDecimal sumVSrvrQty) {
        this.sumVSrvrQty = sumVSrvrQty;
    }

    public BigDecimal getAvgVSrvrQty() {
        return avgVSrvrQty;
    }

    public void setAvgVSrvrQty(BigDecimal avgVSrvrQty) {
        this.avgVSrvrQty = avgVSrvrQty;
    }

    public BigDecimal getLastCpuCorQty() {
        return lastCpuCorQty;
    }

    public void setLastCpuCorQty(BigDecimal lastCpuCorQty) {
        this.lastCpuCorQty = lastCpuCorQty;
    }

    public BigDecimal getSumCpuCorQty() {
        return sumCpuCorQty;
    }

    public void setSumCpuCorQty(BigDecimal sumCpuCorQty) {
        this.sumCpuCorQty = sumCpuCorQty;
    }

    public BigDecimal getAvgCpuCorQty() {
        return avgCpuCorQty;
    }

    public void setAvgCpuCorQty(BigDecimal avgCpuCorQty) {
        this.avgCpuCorQty = avgCpuCorQty;
    }

    public BigDecimal getLastAsgnVcorQty() {
        return lastAsgnVcorQty;
    }

    public void setLastAsgnVcorQty(BigDecimal lastAsgnVcorQty) {
        this.lastAsgnVcorQty = lastAsgnVcorQty;
    }

    public BigDecimal getSumAsgnVcorQty() {
        return sumAsgnVcorQty;
    }

    public void setSumAsgnVcorQty(BigDecimal sumAsgnVcorQty) {
        this.sumAsgnVcorQty = sumAsgnVcorQty;
    }

    public BigDecimal getAvgAsgnVcorQty() {
        return avgAsgnVcorQty;
    }

    public void setAvgAsgnVcorQty(BigDecimal avgAsgnVcorQty) {
        this.avgAsgnVcorQty = avgAsgnVcorQty;
    }

    public BigDecimal getSumCpuUseRt() {
        return sumCpuUseRt;
    }

    public void setSumCpuUseRt(BigDecimal sumCpuUseRt) {
        this.sumCpuUseRt = sumCpuUseRt;
    }

    public BigDecimal getAvgCpuUseRt() {
        return avgCpuUseRt;
    }

    public void setAvgCpuUseRt(BigDecimal avgCpuUseRt) {
        this.avgCpuUseRt = avgCpuUseRt;
    }

    public BigDecimal getMaxCpuUseRt() {
        return maxCpuUseRt;
    }

    public void setMaxCpuUseRt(BigDecimal maxCpuUseRt) {
        this.maxCpuUseRt = maxCpuUseRt;
    }

    public BigDecimal getMinCpuUseRt() {
        return minCpuUseRt;
    }

    public void setMinCpuUseRt(BigDecimal minCpuUseRt) {
        this.minCpuUseRt = minCpuUseRt;
    }

    public BigDecimal getLastMemSumCapa() {
        return lastMemSumCapa;
    }

    public void setLastMemSumCapa(BigDecimal lastMemSumCapa) {
        this.lastMemSumCapa = lastMemSumCapa;
    }

    public BigDecimal getSumMemSumCapa() {
        return sumMemSumCapa;
    }

    public void setSumMemSumCapa(BigDecimal sumMemSumCapa) {
        this.sumMemSumCapa = sumMemSumCapa;
    }

    public BigDecimal getAvgMemSumCapa() {
        return avgMemSumCapa;
    }

    public void setAvgMemSumCapa(BigDecimal avgMemSumCapa) {
        this.avgMemSumCapa = avgMemSumCapa;
    }

    public BigDecimal getLastAsgnMemCapa() {
        return lastAsgnMemCapa;
    }

    public void setLastAsgnMemCapa(BigDecimal lastAsgnMemCapa) {
        this.lastAsgnMemCapa = lastAsgnMemCapa;
    }

    public BigDecimal getSumAsgnMemCapa() {
        return sumAsgnMemCapa;
    }

    public void setSumAsgnMemCapa(BigDecimal sumAsgnMemCapa) {
        this.sumAsgnMemCapa = sumAsgnMemCapa;
    }

    public BigDecimal getAvgAsgnMemCapa() {
        return avgAsgnMemCapa;
    }

    public void setAvgAsgnMemCapa(BigDecimal avgAsgnMemCapa) {
        this.avgAsgnMemCapa = avgAsgnMemCapa;
    }

    public BigDecimal getSumMemUseCapa() {
        return sumMemUseCapa;
    }

    public void setSumMemUseCapa(BigDecimal sumMemUseCapa) {
        this.sumMemUseCapa = sumMemUseCapa;
    }

    public BigDecimal getMaxMemUseCapa() {
        return maxMemUseCapa;
    }

    public void setMaxMemUseCapa(BigDecimal maxMemUseCapa) {
        this.maxMemUseCapa = maxMemUseCapa;
    }

    public BigDecimal getMinMemUseCapa() {
        return minMemUseCapa;
    }

    public void setMinMemUseCapa(BigDecimal minMemUseCapa) {
        this.minMemUseCapa = minMemUseCapa;
    }

    public BigDecimal getAvgMemUseCapa() {
        return avgMemUseCapa;
    }

    public void setAvgMemUseCapa(BigDecimal avgMemUseCapa) {
        this.avgMemUseCapa = avgMemUseCapa;
    }

    public BigDecimal getAvgMemUseRt() {
        return avgMemUseRt;
    }

    public void setAvgMemUseRt(BigDecimal avgMemUseRt) {
        this.avgMemUseRt = avgMemUseRt;
    }

    public BigDecimal getMaxMemUseRt() {
        return maxMemUseRt;
    }

    public void setMaxMemUseRt(BigDecimal maxMemUseRt) {
        this.maxMemUseRt = maxMemUseRt;
    }

    public BigDecimal getMinMemUseRt() {
        return minMemUseRt;
    }

    public void setMinMemUseRt(BigDecimal minMemUseRt) {
        this.minMemUseRt = minMemUseRt;
    }

    public BigDecimal getLastStrgSumCapa() {
        return lastStrgSumCapa;
    }

    public void setLastStrgSumCapa(BigDecimal lastStrgSumCapa) {
        this.lastStrgSumCapa = lastStrgSumCapa;
    }

    public BigDecimal getSumStrgSumCapa() {
        return sumStrgSumCapa;
    }

    public void setSumStrgSumCapa(BigDecimal sumStrgSumCapa) {
        this.sumStrgSumCapa = sumStrgSumCapa;
    }

    public BigDecimal getAvgStrgSumCapa() {
        return avgStrgSumCapa;
    }

    public void setAvgStrgSumCapa(BigDecimal avgStrgSumCapa) {
        this.avgStrgSumCapa = avgStrgSumCapa;
    }

    public BigDecimal getSumStrgUseCapa() {
        return sumStrgUseCapa;
    }

    public void setSumStrgUseCapa(BigDecimal sumStrgUseCapa) {
        this.sumStrgUseCapa = sumStrgUseCapa;
    }

    public BigDecimal getAvgStrgUseCapa() {
        return avgStrgUseCapa;
    }

    public void setAvgStrgUseCapa(BigDecimal avgStrgUseCapa) {
        this.avgStrgUseCapa = avgStrgUseCapa;
    }

    public BigDecimal getMaxStrgUseCapa() {
        return maxStrgUseCapa;
    }

    public void setMaxStrgUseCapa(BigDecimal maxStrgUseCapa) {
        this.maxStrgUseCapa = maxStrgUseCapa;
    }

    public BigDecimal getMinStrgUseCapa() {
        return minStrgUseCapa;
    }

    public void setMinStrgUseCapa(BigDecimal minStrgUseCapa) {
        this.minStrgUseCapa = minStrgUseCapa;
    }

}
