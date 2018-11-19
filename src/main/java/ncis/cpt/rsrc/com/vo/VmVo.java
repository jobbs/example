/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmVo.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.vo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import ncis.cmn.entity.RcVm;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.strg.vo.VrDskVo;

/**
 * @author 심원보
 *
 */
public class VmVo extends RcVm {

    private String regionId;

    private String regionNm;

    private String zoneId;

    private String zoneNm;

    private String netId;

    private String netNm;

    private String netClCd;

    private String netClCdNm;

    private String netwkTyClCdNm; //network유형구분코드 ex(l4,l3)

    private String rsrcPoolId;

    private String rsrcPoolNm;

    private String rsrcPoolVersion;

    private String vrlzSwTyCd;

    private String vrlzSwTyCdNm;

    private String ctlTrgtYn;

    private BigDecimal clstrSeq;

    private String clstrNm;

    private BigDecimal pmSeq;

    private String pmNm;

    private String pmCompId;

    private String haYnNm;

    private String statCdNm;

    private String statGrpCdNm;

    private String statGrpCd;

    private String osTyCdNm;

    private String vmClCdNm;

    private String institutionNm;

    private String jobsNm;

    private ArrayList<VmJobVo> vmJobVoList;

    private ArrayList<NetwkIntfcVo> netwkIntfcVoList;

    private ArrayList<VrDskVo> vrDskVoList;

    private ArrayList<OprRelateChargerVo> oprRelateChargerVoList;

    private ArrayList<VmProcssMsgVo> vmProcssMsgVoList;

    private ArrayList<VmSwVo> vmSwVoList;

    // 가상서버선택
    private String testId;

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

    public String getNetClCd() {
        return netClCd;
    }

    public void setNetClCd(String netClCd) {
        this.netClCd = netClCd;
    }

    public String getNetClCdNm() {
        return netClCdNm;
    }

    public void setNetClCdNm(String netClCdNm) {
        this.netClCdNm = netClCdNm;
    }

    public String getRsrcPoolId() {
        return rsrcPoolId;
    }

    public void setRsrcPoolId(String rsrcPoolId) {
        this.rsrcPoolId = rsrcPoolId;
    }

    /**
	 * @return the rsrcPoolVersion
	 */
	public String getRsrcPoolVersion()
	{
		return rsrcPoolVersion;
	}

	/**
	 * @param rsrcPoolVersion the rsrcPoolVersion to set
	 */
	public void setRsrcPoolVersion(String rsrcPoolVersion)
	{
		this.rsrcPoolVersion = rsrcPoolVersion;
	}

	/**
	 * @return the netwkTyClCdNm
	 */
	public String getNetwkTyClCdNm() {
		return netwkTyClCdNm;
	}

	/**
	 * @param netwkTyClCdNm the netwkTyClCdNm to set
	 */
	public void setNetwkTyClCdNm(String netwkTyClCdNm) {
		this.netwkTyClCdNm = netwkTyClCdNm;
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

    public String getCtlTrgtYn() {
        return ctlTrgtYn;
    }

    public void setCtlTrgtYn(String ctlTrgtYn) {
        this.ctlTrgtYn = ctlTrgtYn;
    }

    public BigDecimal getClstrSeq() {
        return clstrSeq;
    }

    public void setClstrSeq(BigDecimal clstrSeq) {
        this.clstrSeq = clstrSeq;
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

    public String getStatGrpCdNm() {
        return statGrpCdNm;
    }

    public void setStatGrpCdNm(String statGrpCdNm) {
        this.statGrpCdNm = statGrpCdNm;
    }

    public String getStatGrpCd() {
        return statGrpCd;
    }

    public void setStatGrpCd(String statGrpCd) {
        this.statGrpCd = statGrpCd;
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

        if (getStatCd() != null && getStatCd().equals(ComConstant.VM_STAT_CD_UP) && getStrtupDttm() != null) {
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
                if (stringBuilder.length() > 0)
                    stringBuilder.append(" ");
                stringBuilder.append(days).append("일");
            }
            if (hours > 0) {
                if (stringBuilder.length() > 0)
                    stringBuilder.append(" ");
                stringBuilder.append(hours).append("시간");
            }
            if (minutes > 0) {
                if (stringBuilder.length() > 0)
                    stringBuilder.append(" ");
                stringBuilder.append(minutes).append("분");
            }
            if (seconds > 0) {
                if (stringBuilder.length() > 0)
                    stringBuilder.append(" ");
                stringBuilder.append(seconds).append("초");
            }
        }

        return stringBuilder.toString();
    }

    public ArrayList<VmJobVo> getVmJobVoList() {
        return vmJobVoList;
    }

    public void setVmJobVoList(ArrayList<VmJobVo> vmJobVoList) {
        this.vmJobVoList = vmJobVoList;
    }

    public ArrayList<NetwkIntfcVo> getNetwkIntfcVoList() {
        return netwkIntfcVoList;
    }

    public void setNetwkIntfcVoList(ArrayList<NetwkIntfcVo> netwkIntfcVoList) {
        this.netwkIntfcVoList = netwkIntfcVoList;
    }

    public ArrayList<VrDskVo> getVrDskVoList() {
        return vrDskVoList;
    }

    public void setVrDskVoList(ArrayList<VrDskVo> vrDskVoList) {
        this.vrDskVoList = vrDskVoList;
    }

    public ArrayList<OprRelateChargerVo> getOprRelateChargerVoList() {
        return oprRelateChargerVoList;
    }

    public void setOprRelateChargerVoList(ArrayList<OprRelateChargerVo> oprRelateChargerVoList) {
        this.oprRelateChargerVoList = oprRelateChargerVoList;
    }

    public String getStrtupDttmToString() {
        return (null == getStrtupDttm() ? null : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getStrtupDttm()));
    }

    public String getRegDttmToString() {
        return (null == getRegDttm() ? null : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getRegDttm()));
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public ArrayList<VmProcssMsgVo> getVmProcssMsgVoList() {
        return vmProcssMsgVoList;
    }

    public void setVmProcssMsgVoList(ArrayList<VmProcssMsgVo> vmProcssMsgVoList) {
        this.vmProcssMsgVoList = vmProcssMsgVoList;
    }

    public ArrayList<VmSwVo> getVmSwVoList() {
        return vmSwVoList;
    }

    public void setVmSwVoList(ArrayList<VmSwVo> vmSwVoList) {
        this.vmSwVoList = vmSwVoList;
    }

}
