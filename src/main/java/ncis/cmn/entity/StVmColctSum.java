package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 가상서버_수집집계 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class StVmColctSum {

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
     * 가상서버ID
     */
    @NotEmpty(message = "가상서버ID는(은) 필수입력 항목입니다.")
    private String vmId;

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
     * 최종vCore수
     */
    private BigDecimal lastVcoreQty;

    /**
     * 합계vCore수
     */
    private BigDecimal sumVcoreQty;

    /**
     * 평균vCore수
     */
    private BigDecimal avgVcoreQty;

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
     * 최빈CPU사용율
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
     * 최빈메모리사용율
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
     * 최소스토리지사용율
     */
    private BigDecimal minStrgUseCapa;

    /**
     * 평균스토리지사용율
     */
    private BigDecimal avgStrgUseRt;

    /**
     * 최대스토리지사용율
     */
    private BigDecimal maxStrgUseRt;

    /**
     * 합계IN_트래픽
     */
    private BigDecimal sumInTrfic;

    /**
     * 평균IN_트래픽
     */
    private BigDecimal avgInTrfic;

    /**
     * 최대IN_트래픽
     */
    private BigDecimal maxInTrfic;

    /**
     * 최소IN_트래픽
     */
    private BigDecimal minInTrfic;

    /**
     * 합계OUT_트래픽
     */
    private BigDecimal sumOutTrfic;

    /**
     * 평균OUT_트래픽
     */
    private BigDecimal avgOutTrfic;

    /**
     * 최대OUT_트래픽
     */
    private BigDecimal maxOutTrfic;

    /**
     * 최소OUT_트래픽
     */
    private BigDecimal minOutTrfic;

    /**
     * 수집건수
     */
    private BigDecimal colctCnt;

    /**
     * 최근1시간CPU사용율평균
     */
    private BigDecimal rc1hCpuUseRtAvg;

    /**
     * 최근1시간메모리사용율평균
     */
    private BigDecimal rc1hMemUseRtAvg;

    /**
     * 최근1시간스토리지사용율평균
     */
    private BigDecimal rc1hStrgUseRtAvg;

    /**
     * 합계포인트
     */
    private BigDecimal sumPnt;

    /**
     * 최빈스토리지사용율
     */
    private BigDecimal minStrgUseRt;

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

    public String getVmId() {
        return vmId;
    }

    public void setVmId(String vmId) {
        this.vmId = vmId;
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

    public BigDecimal getLastVcoreQty() {
        return lastVcoreQty;
    }

    public void setLastVcoreQty(BigDecimal lastVcoreQty) {
        this.lastVcoreQty = lastVcoreQty;
    }

    public BigDecimal getSumVcoreQty() {
        return sumVcoreQty;
    }

    public void setSumVcoreQty(BigDecimal sumVcoreQty) {
        this.sumVcoreQty = sumVcoreQty;
    }

    public BigDecimal getAvgVcoreQty() {
        return avgVcoreQty;
    }

    public void setAvgVcoreQty(BigDecimal avgVcoreQty) {
        this.avgVcoreQty = avgVcoreQty;
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

    public BigDecimal getAvgStrgUseRt() {
        return avgStrgUseRt;
    }

    public void setAvgStrgUseRt(BigDecimal avgStrgUseRt) {
        this.avgStrgUseRt = avgStrgUseRt;
    }

    public BigDecimal getMaxStrgUseRt() {
        return maxStrgUseRt;
    }

    public void setMaxStrgUseRt(BigDecimal maxStrgUseRt) {
        this.maxStrgUseRt = maxStrgUseRt;
    }

    public BigDecimal getSumInTrfic() {
        return sumInTrfic;
    }

    public void setSumInTrfic(BigDecimal sumInTrfic) {
        this.sumInTrfic = sumInTrfic;
    }

    public BigDecimal getAvgInTrfic() {
        return avgInTrfic;
    }

    public void setAvgInTrfic(BigDecimal avgInTrfic) {
        this.avgInTrfic = avgInTrfic;
    }

    public BigDecimal getMaxInTrfic() {
        return maxInTrfic;
    }

    public void setMaxInTrfic(BigDecimal maxInTrfic) {
        this.maxInTrfic = maxInTrfic;
    }

    public BigDecimal getMinInTrfic() {
        return minInTrfic;
    }

    public void setMinInTrfic(BigDecimal minInTrfic) {
        this.minInTrfic = minInTrfic;
    }

    public BigDecimal getSumOutTrfic() {
        return sumOutTrfic;
    }

    public void setSumOutTrfic(BigDecimal sumOutTrfic) {
        this.sumOutTrfic = sumOutTrfic;
    }

    public BigDecimal getAvgOutTrfic() {
        return avgOutTrfic;
    }

    public void setAvgOutTrfic(BigDecimal avgOutTrfic) {
        this.avgOutTrfic = avgOutTrfic;
    }

    public BigDecimal getMaxOutTrfic() {
        return maxOutTrfic;
    }

    public void setMaxOutTrfic(BigDecimal maxOutTrfic) {
        this.maxOutTrfic = maxOutTrfic;
    }

    public BigDecimal getMinOutTrfic() {
        return minOutTrfic;
    }

    public void setMinOutTrfic(BigDecimal minOutTrfic) {
        this.minOutTrfic = minOutTrfic;
    }

    public BigDecimal getColctCnt() {
        return colctCnt;
    }

    public void setColctCnt(BigDecimal colctCnt) {
        this.colctCnt = colctCnt;
    }

    public BigDecimal getRc1hCpuUseRtAvg() {
        return rc1hCpuUseRtAvg;
    }

    public void setRc1hCpuUseRtAvg(BigDecimal rc1hCpuUseRtAvg) {
        this.rc1hCpuUseRtAvg = rc1hCpuUseRtAvg;
    }

    public BigDecimal getRc1hMemUseRtAvg() {
        return rc1hMemUseRtAvg;
    }

    public void setRc1hMemUseRtAvg(BigDecimal rc1hMemUseRtAvg) {
        this.rc1hMemUseRtAvg = rc1hMemUseRtAvg;
    }

    public BigDecimal getRc1hStrgUseRtAvg() {
        return rc1hStrgUseRtAvg;
    }

    public void setRc1hStrgUseRtAvg(BigDecimal rc1hStrgUseRtAvg) {
        this.rc1hStrgUseRtAvg = rc1hStrgUseRtAvg;
    }

    public BigDecimal getSumPnt() {
        return sumPnt;
    }

    public void setSumPnt(BigDecimal sumPnt) {
        this.sumPnt = sumPnt;
    }

    public BigDecimal getMinStrgUseRt() {
        return minStrgUseRt;
    }

    public void setMinStrgUseRt(BigDecimal minStrgUseRt) {
        this.minStrgUseRt = minStrgUseRt;
    }

}
