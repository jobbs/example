/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   양정순         v1.0             최초생성
 */

package ncis.dsb.stts.rsrcuse.vo;

import java.math.BigDecimal;
import java.util.Date;
import ncis.cmn.entity.RcVm;

public class VmVo extends RcVm {

    private String regionId;

    private String regionNm;

    private String zoneId;

    private String zoneNm;

    private String netId;

    private String netNm;

    private String rsrcPoolId;

    private String rsrcPoolNm;

    private String vrlzSwTyCd;

    private String vrlzSwTyCdNm;

    private String clstrNm;

    private BigDecimal pmSeq;

    private String pmNm;

    private String pmCompId;

    private String haYnNm;

    private String statCdNm;

    private String osTyCdNm;

    private String vmClCdNm;

    private String institutionNm;

    private String jobsNm;


    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionNm() {
        return regionNm;
    }

    public void setRegionNm(String regionNm) {
        this.regionNm = regionNm;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneNm() {
        return zoneNm;
    }

    public void setZoneNm(String zoneNm) {
        this.zoneNm = zoneNm;
    }

    public String getNetId() {
        return netId;
    }

    public void setNetId(String netId) {
        this.netId = netId;
    }

    public String getNetNm() {
        return netNm;
    }

    public void setNetNm(String netNm) {
        this.netNm = netNm;
    }

    public String getRsrcPoolId() {
        return rsrcPoolId;
    }

    public void setRsrcPoolId(String rsrcPoolId) {
        this.rsrcPoolId = rsrcPoolId;
    }

    public String getRsrcPoolNm() {
        return rsrcPoolNm;
    }

    public void setRsrcPoolNm(String rsrcPoolNm) {
        this.rsrcPoolNm = rsrcPoolNm;
    }

    public String getVrlzSwTyCd() {
        return vrlzSwTyCd;
    }

    public void setVrlzSwTyCd(String vrlzSwTyCd) {
        this.vrlzSwTyCd = vrlzSwTyCd;
    }

    public String getVrlzSwTyCdNm() {
        return vrlzSwTyCdNm;
    }

    public void setVrlzSwTyCdNm(String vrlzSwTyCdNm) {
        this.vrlzSwTyCdNm = vrlzSwTyCdNm;
    }

    public String getClstrNm() {
        return clstrNm;
    }

    public void setClstrNm(String clstrNm) {
        this.clstrNm = clstrNm;
    }

    public BigDecimal getPmSeq() {
        return pmSeq;
    }

    public void setPmSeq(BigDecimal pmSeq) {
        this.pmSeq = pmSeq;
    }

    public String getPmNm() {
        return pmNm;
    }

    public void setPmNm(String pmNm) {
        this.pmNm = pmNm;
    }

    public String getPmCompId() {
        return pmCompId;
    }

    public void setPmCompId(String pmCompId) {
        this.pmCompId = pmCompId;
    }

    public String getHaYnNm() {
        return haYnNm;
    }

    public void setHaYnNm(String haYnNm) {
        this.haYnNm = haYnNm;
    }

    public String getStatCdNm() {
        return statCdNm;
    }

    public void setStatCdNm(String statCdNm) {
        this.statCdNm = statCdNm;
    }

    public String getOsTyCdNm() {
        return osTyCdNm;
    }

    public void setOsTyCdNm(String osTyCdNm) {
        this.osTyCdNm = osTyCdNm;
    }

    public String getVmClCdNm() {
        return vmClCdNm;
    }

    public void setVmClCdNm(String vmClCdNm) {
        this.vmClCdNm = vmClCdNm;
    }

    public String getInstitutionNm() {
        return institutionNm;
    }

    public void setInstitutionNm(String institutionNm) {
        this.institutionNm = institutionNm;
    }

    public String getJobsNm() {
        return jobsNm;
    }

    public void setJobsNm(String jobsNm) {
        this.jobsNm = jobsNm;
    }

    public String getUptime() {
        StringBuilder stringBuilder = new StringBuilder("");

        if (getStatCd() != null && getStatCd().equals("01") && getStrtupDttm() != null) {
            Date date = getStrtupDttm();
            Date now = new Date();
            long diff = (now.getTime() - date.getTime()) / 1000;
            long m = 60;
            long h = m * 60;
            long d = h * 24;
            long y = d * 365;

            long years = diff / y;
            diff %= y;
            long days = diff / d;
            diff %= d;
            long hours = diff / h;
            diff %= h;
            long minutes = diff / m;
            diff %= m;
            long seconds = diff;

            if (years > 0) {
                stringBuilder.append(years).append("년 ");
            }
            if (days > 0) {
                stringBuilder.append(days).append("일 ");
            }
            if (hours > 0) {
                stringBuilder.append(hours).append("시간 ");
            }
            if (minutes > 0) {
                stringBuilder.append(minutes).append("분 ");
            }
            if (seconds > 0) {
                stringBuilder.append(seconds).append("초");
            }
        }

        return stringBuilder.toString();
    }




}
