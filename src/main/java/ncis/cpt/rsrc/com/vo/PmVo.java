/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PmVo.java
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
import java.util.ArrayList;
import ncis.cmn.entity.RcPm;
import ncis.cmn.util.RequestUtils;

/**
 * @author 심원보
 *
 */
public class PmVo extends RcPm {

    private String regionId;
    private String regionNm;
    private String zoneId;
    private String zoneNm;
    private String netId;
    private String netNm;
    private String netClCd;
    private String netClCdNm;
    private String rsrcPoolId;
    private String rsrcPoolNm;
    private String ctlTrgtYn;
    private String clstrNm;
    private String vrlzSwTyCd;
    private String vrlzSwTyCdNm;
    private String statCdNm;
    private String delYnNm;
    private BigDecimal vmCnt;
    private BigDecimal totCpuVcoreQty;
    private BigDecimal totCpuEnt;
    private BigDecimal totMemAsgnCapa;
    private BigDecimal totStrgAsgnCapa;
    private ArrayList<OprRelateChargerVo> oprRelateChargerVoList;

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

    public String getRsrcPoolNm() {
        return rsrcPoolNm;
    }

    public void setRsrcPoolNm(String rsrcPoolNm) {
        this.rsrcPoolNm = rsrcPoolNm;
    }

    public String getClstrNm() {
        return clstrNm;
    }

    public void setClstrNm(String clstrNm) {
        this.clstrNm = clstrNm;
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

    public String getStatCdNm() {
        return statCdNm;
    }

    public void setStatCdNm(String statCdNm) {
        this.statCdNm = statCdNm;
    }

    public String getDelYnNm() {
        return delYnNm;
    }

    public void setDelYnNm(String delYnNm) {
        this.delYnNm = delYnNm;
    }

    public BigDecimal getVmCnt() {
        return vmCnt;
    }

    public void setVmCnt(BigDecimal vmCnt) {
        this.vmCnt = vmCnt;
    }

    public BigDecimal getTotCpuVcoreQty() {
        return totCpuVcoreQty;
    }

    public void setTotCpuVcoreQty(BigDecimal totCpuVcoreQty) {
        this.totCpuVcoreQty = totCpuVcoreQty;
    }

    public BigDecimal getTotCpuEnt() {
        return totCpuEnt.setScale(0, BigDecimal.ROUND_HALF_DOWN);
    }

    public void setTotCpuEnt(BigDecimal totCpuEnt) {
        this.totCpuEnt = totCpuEnt;
    }

    public BigDecimal getTotMemAsgnCapa() {
        return totMemAsgnCapa;
    }

    public void setTotMemAsgnCapa(BigDecimal totMemAsgnCapa) {
        this.totMemAsgnCapa = totMemAsgnCapa;
    }

    public BigDecimal getTotStrgAsgnCapa() {
        return totStrgAsgnCapa;
    }

    public void setTotStrgAsgnCapa(BigDecimal totStrgAsgnCapa) {
        this.totStrgAsgnCapa = totStrgAsgnCapa;
    }

    public Double getCpuVrlzRt() {
        Double doubleValue = 0.0;
        if (getCpuCoreQty() != null && getCpuCoreQty().intValue() > 0) {
            doubleValue = totCpuVcoreQty.doubleValue() * 100.0 / getCpuCoreQty().intValue();
        }

        return Math.round(doubleValue * 10) / 10.0;
    }

    public Double getMemVrlzRt() {
        Double doubleValue = 0.0;
        if (getMemCapa() != null && getMemCapa().intValue() > 0) {
            doubleValue = totMemAsgnCapa.doubleValue() * 100.0 / getMemCapa().intValue();

        }

        return Math.round(doubleValue * 10) / 10.0;
    }

    public String getUserId() {
        return RequestUtils.getUserId();
    }

    public ArrayList<OprRelateChargerVo> getOprRelateChargerVoList() {
        return oprRelateChargerVoList;
    }

    public void setOprRelateChargerVoList(
            ArrayList<OprRelateChargerVo> oprRelateChargerVoList) {
        this.oprRelateChargerVoList = oprRelateChargerVoList;
    }

    public int getCpuVrlzRtExcel() {
        return new BigDecimal(String.valueOf(getCpuVrlzRt())).setScale(0, BigDecimal.ROUND_HALF_DOWN).intValue();
    }

    public int getMemVrlzRtExcel() {
        return new BigDecimal(String.valueOf(getMemVrlzRt())).setScale(0, BigDecimal.ROUND_HALF_DOWN).intValue();
    }

    public int getCpuUseRtExcel() {
        return new BigDecimal(String.valueOf(super.getCpuUseRt())).setScale(0, BigDecimal.ROUND_HALF_DOWN).intValue();
    }

    public int getMemUseRtExcel() {
        return new BigDecimal(String.valueOf(super.getMemUseRt())).setScale(0, BigDecimal.ROUND_HALF_DOWN).intValue();
    }

    public int getTotMemAsgnCapaExcel() {
        return new BigDecimal(String.valueOf(totMemAsgnCapa)).setScale(0, BigDecimal.ROUND_HALF_DOWN).intValue();
    }

    public int getMemCapaExcel() {
        return new BigDecimal(String.valueOf(super.getMemCapa())).setScale(0, BigDecimal.ROUND_HALF_DOWN).intValue();
    }

    public int getTotStrgAsgnCapaExcel() {
        return new BigDecimal(String.valueOf(totStrgAsgnCapa)).setScale(0, BigDecimal.ROUND_HALF_DOWN).intValue();
    }

    public double getNetwkInExcel() {
        return new BigDecimal(String.valueOf(super.getNetwkIn())).setScale(1, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    public double getNetwkOutExcel() {
        return new BigDecimal(String.valueOf(super.getNetwkOut())).setScale(1, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

	public String getCtlTrgtYn() {
		return ctlTrgtYn;
	}

	public void setCtlTrgtYn(String ctlTrgtYn) {
		this.ctlTrgtYn = ctlTrgtYn;
	}

}