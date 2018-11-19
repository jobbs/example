/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ClstrVo.java
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

import java.util.ArrayList;
import ncis.cmn.entity.RcClstr;
import ncis.cmn.util.RequestUtils;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cpt.rsrc.com.validation.InsertClstrCreReqValidation;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 심원보
 *
 */
public class ClstrVo extends RcClstr {

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

    private String vrlzSwTyCd;

    private String vrlzSwTyCdNm;

    private String ctlTrgtYn;

    private String useYnNm;

    private String testYnNm;

    private Integer pmCnt;

    private Integer vmCnt;

    private Integer totCpuCoreQty;

    private Integer totCpuVcoreQty;

    private Double totCpuEnt;

    private Integer totMemCapa;

    private Integer totMemAsgnCapa;

    private Integer totStrgAsgnCapa;

    private Double totNetwkIn;

    private Double totNetwkOut;

    private Double avgCpuUseRt;

    private Double avgMemUseRt;

    private ArrayList<ClstrPrposVo> clstrPrposVoList;

    @NotEmpty(message = "클러스터 용도를 선택해주세요.", groups = { UpdateProc.class, InsertClstrCreReqValidation.class })
    private ArrayList<String> prposClCdList;

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

    public String getUseYnNm() {
        return useYnNm;
    }

    public void setUseYnNm(String useYnNm) {
        this.useYnNm = useYnNm;
    }

    public String getTestYnNm() {
        return testYnNm;
    }

    public void setTestYnNm(String testYnNm) {
        this.testYnNm = testYnNm;
    }

    public Integer getPmCnt() {
        return pmCnt;
    }

    public void setPmCnt(Integer pmCnt) {
        this.pmCnt = pmCnt;
    }

    public Integer getVmCnt() {
        return vmCnt;
    }

    public void setVmCnt(Integer vmCnt) {
        this.vmCnt = vmCnt;
    }

    public Integer getTotCpuCoreQty() {
        return totCpuCoreQty;
    }

    public void setTotCpuCoreQty(Integer totCpuCoreQty) {
        this.totCpuCoreQty = totCpuCoreQty;
    }

    public Integer getTotCpuVcoreQty() {
        return totCpuVcoreQty;
    }

    public void setTotCpuVcoreQty(Integer totCpuVcoreQty) {
        this.totCpuVcoreQty = totCpuVcoreQty;
    }

    public Double getTotCpuEnt() {
        return totCpuEnt;
    }

    public void setTotCpuEnt(Double totCpuEnt) {
        this.totCpuEnt = totCpuEnt;
    }

    public Integer getTotMemCapa() {
        return totMemCapa;
    }

    public void setTotMemCapa(Integer totMemCapa) {
        this.totMemCapa = totMemCapa;
    }

    public Integer getTotMemAsgnCapa() {
        return totMemAsgnCapa;
    }

    public void setTotMemAsgnCapa(Integer totMemAsgnCapa) {
        this.totMemAsgnCapa = totMemAsgnCapa;
    }

    public Integer getTotStrgAsgnCapa() {
        return totStrgAsgnCapa;
    }

    public void setTotStrgAsgnCapa(Integer totStrgAsgnCapa) {
        this.totStrgAsgnCapa = totStrgAsgnCapa;
    }

    public Double getTotNetwkIn() {
        return totNetwkIn;
    }

    public void setTotNetwkIn(Double totNetwkIn) {
        this.totNetwkIn = totNetwkIn;
    }

    public Double getTotNetwkOut() {
        return totNetwkOut;
    }

    public void setTotNetwkOut(Double totNetwkOut) {
        this.totNetwkOut = totNetwkOut;
    }

    public Double getAvgCpuUseRt() {
        return avgCpuUseRt;
    }

    public void setAvgCpuUseRt(Double avgCpuUseRt) {
        this.avgCpuUseRt = avgCpuUseRt;
    }

    public Double getAvgMemUseRt() {
        return avgMemUseRt;
    }

    public void setAvgMemUseRt(Double avgMemUseRt) {
        this.avgMemUseRt = avgMemUseRt;
    }

    public Double getCpuVrlzRt() {
        Double doubleValue = 0.0;
        if (totCpuCoreQty.intValue() > 0) {
            doubleValue = totCpuVcoreQty.doubleValue() * 100.0 / totCpuCoreQty.intValue();
        }
        return Math.round(doubleValue * 10) / 10.0;
    }

    public Double getMemVrlzRt() {
        Double doubleValue = 0.0;
        if (totMemCapa.intValue() > 0) {
            doubleValue = totMemAsgnCapa.doubleValue() * 100.0 / totMemCapa.intValue();
        }
        return Math.round(doubleValue * 10) / 10.0;
    }

    public ArrayList<ClstrPrposVo> getClstrPrposVoList() {
        return clstrPrposVoList;
    }

    public void setClstrPrposVoList(ArrayList<ClstrPrposVo> clstrPrposVoList) {
        this.clstrPrposVoList = clstrPrposVoList;
    }

    public ArrayList<String> getPrposClCdList() {
        return prposClCdList;
    }

    public void setPrposClCdList(ArrayList<String> prposClCdList) {
        this.prposClCdList = prposClCdList;
    }

    public String getUserId() {
        return RequestUtils.getUserId();
    }

}