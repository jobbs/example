/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename vrStrgVo.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.vo;

import java.math.BigDecimal;
import ncis.cmn.entity.RsVrStrg;

/**
 * @author 신재훈
 *
 */
public class VrStrgVo extends RsVrStrg {
    private String strgDmnTyNm; /* 스토리지도메인유형코드 명 */
    private String regionId; // 센터아이디
    private String zoneId; // 존아이디
    private String netId; // 망아이디
    private String netClCd; // 망구분아이디
    private String regionNm; // 센터명
    private String zoneNm; // 존명
    private String netNm; // 망명
    private String rsrcPoolNm; // 자원풀명

    private String vrlzSwTyCdNm; // 가상화구분 명
    private String vrlzSwTyCdId; // 가상화구분 아이디

    private BigDecimal sumWholeAsgnCapa; /* 전체할당용량(GB) 합계 */
    private BigDecimal sumStrgUseCapa; /* 스토리지사용용량(GB) 합계 */
    private BigDecimal sumVmAsgnCapa; /* 가상서버할당량(GB) 합계 */
    private BigDecimal sumStrMrgnCapa; /* 스토리지여유량(GB) 합계 */
    private BigDecimal sumTmplatAsgnCapa; /* 템플릿할당용량(GB) 합계 */
    private BigDecimal sumVmSnapshtAsgnCapa; // VM스냅샷할당량(GB) 합계
    private BigDecimal vmSnapshtAsgnCapa; // VM스냅샷할당량(GB)

    /* 가상스토리지 상세 - 가상서버 탭 */
    private String vmId; // 가상서버 아이디
    private String vmNm; // 가상서버 명
    private String vmCompId; // 가상서버 구성아이디
    private String pmNm; // 물리서버 명
    private String pmCompId; // 물리서버 구성아이디
    private String clstrNm; // 클러스터 명
    private String institutionId; // 부처 아이디
    private String institutionNm; // 부처 명
    private String jobNm; // 업무 명
    private BigDecimal strgAsgnCapa_vm; // 할당량
    private BigDecimal strgAsgmCapa_vm_sum; // 할당량 총합
    private BigDecimal vmSnapshtAsgnCapa_sum; // 스냅샷할당량

    /* 가상스토리지 상세 - 템플릿 탭 */
    private String tmplatNm; // 템플릿 명
    private String tmplatClNm; // 템플릿 구분코드명
    private String useYnNm; // 사용유무
    private String osTyCdNm; // OS유형코드
    private String osBitNm; // OS Bit
    private String osNm; // 운영체제 명
    private String osVer; // OS버전
    private String pltfrm; // 플랫폼
    private BigDecimal strgAsgnCapa_tmplat; // 할당량
    private String prposNm; // 용도 명
    private String swNm; // 소프트웨어

    public String getRegionNm() {
        return regionNm;
    }

    public void setRegionNm(String regionNm) {
        this.regionNm = regionNm;
    }

    public String getZoneNm() {
        return zoneNm;
    }

    public void setZoneNm(String zoneNm) {
        this.zoneNm = zoneNm;
    }

    public String getNetNm() {
        return netNm;
    }

    public void setNetNm(String netNm) {
        this.netNm = netNm;
    }

    public String getRsrcPoolNm() {
        return rsrcPoolNm;
    }

    public void setRsrcPoolNm(String rsrcPoolNm) {
        this.rsrcPoolNm = rsrcPoolNm;
    }

    public String getVrlzSwTyCdNm() {
        return vrlzSwTyCdNm;
    }

    public void setVrlzSwTyCdNm(String vrlzSwTyCdNm) {
        this.vrlzSwTyCdNm = vrlzSwTyCdNm;
    }

    public String getVrlzSwTyCdId() {
        return vrlzSwTyCdId;
    }

    public void setVrlzSwTyCdId(String vrlzSwTyCdId) {
        this.vrlzSwTyCdId = vrlzSwTyCdId;
    }

    public String getStrgDmnTyNm() {
        return strgDmnTyNm;
    }

    public void setStrgDmnTyNm(String strgDmnTyNm) {
        this.strgDmnTyNm = strgDmnTyNm;
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

    public BigDecimal getSumWholeAsgnCapa() {
        return sumWholeAsgnCapa;
    }

    public void setSumWholeAsgnCapa(BigDecimal sumWholeAsgnCapa) {
        this.sumWholeAsgnCapa = sumWholeAsgnCapa;
    }

    public BigDecimal getSumStrgUseCapa() {
        return sumStrgUseCapa;
    }

    public void setSumStrgUseCapa(BigDecimal sumStrgUseCapa) {
        this.sumStrgUseCapa = sumStrgUseCapa;
    }

    public BigDecimal getSumVmAsgnCapa() {
        return sumVmAsgnCapa;
    }

    public void setSumVmAsgnCapa(BigDecimal sumVmAsgnCapa) {
        this.sumVmAsgnCapa = sumVmAsgnCapa;
    }

    public BigDecimal getSumStrMrgnCapa() {
        return sumStrMrgnCapa;
    }

    public void setSumStrMrgnCapa(BigDecimal sumStrMrgnCapa) {
        this.sumStrMrgnCapa = sumStrMrgnCapa;
    }

    public BigDecimal getSumTmplatAsgnCapa() {
        return sumTmplatAsgnCapa;
    }

    public void setSumTmplatAsgnCapa(BigDecimal sumTmplatAsgnCapa) {
        this.sumTmplatAsgnCapa = sumTmplatAsgnCapa;
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

    public String getPmNm() {
        return pmNm;
    }

    public void setPmNm(String pmNm) {
        this.pmNm = pmNm;
    }

    public String getClstrNm() {
        return clstrNm;
    }

    public void setClstrNm(String clstrNm) {
        this.clstrNm = clstrNm;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionNm() {
        return institutionNm;
    }

    public void setInstitutionNm(String institutionNm) {
        this.institutionNm = institutionNm;
    }

    public String getPmCompId() {
        return pmCompId;
    }

    public void setPmCompId(String pmCompId) {
        this.pmCompId = pmCompId;
    }

    public String getJobNm() {
        return jobNm;
    }

    public void setJobNm(String jobNm) {
        this.jobNm = jobNm;
    }

    public BigDecimal getStrgAsgnCapa_vm() {
        return strgAsgnCapa_vm;
    }

    public void setStrgAsgnCapa_vm(BigDecimal strgAsgnCapa_vm) {
        this.strgAsgnCapa_vm = strgAsgnCapa_vm;
    }

    public String getTmplatNm() {
        return tmplatNm;
    }

    public void setTmplatNm(String tmplatNm) {
        this.tmplatNm = tmplatNm;
    }

    public String getUseYnNm() {
        return useYnNm;
    }

    public void setUseYnNm(String useYnNm) {
        this.useYnNm = useYnNm;
    }

    public String getOsBitNm() {
        return osBitNm;
    }

    public void setOsBitNm(String osBitNm) {
        this.osBitNm = osBitNm;
    }

    public String getOsNm() {
        return osNm;
    }

    public void setOsNm(String osNm) {
        this.osNm = osNm;
    }

    public String getPltfrm() {
        return pltfrm;
    }

    public void setPltfrm(String pltfrm) {
        this.pltfrm = pltfrm;
    }

    public BigDecimal getStrgAsgnCapa_tmplat() {
        return strgAsgnCapa_tmplat;
    }

    public void setStrgAsgnCapa_tmplat(BigDecimal strgAsgnCapa_tmplat) {
        this.strgAsgnCapa_tmplat = strgAsgnCapa_tmplat;
    }

    public String getPrposNm() {
        return prposNm;
    }

    public void setPrposNm(String prposNm) {
        this.prposNm = prposNm;
    }

    public String getOsTyCdNm() {
        return osTyCdNm;
    }

    public void setOsTyCdNm(String osTyCdNm) {
        this.osTyCdNm = osTyCdNm;
    }

    public String getSwNm() {
        return swNm;
    }

    public void setSwNm(String swNm) {
        this.swNm = swNm;
    }

    public String getOsVer() {
        return osVer;
    }

    public void setOsVer(String osVer) {
        this.osVer = osVer;
    }

    public BigDecimal getStrgAsgmCapa_vm_sum() {
        return strgAsgmCapa_vm_sum;
    }

    public void setStrgAsgmCapa_vm_sum(BigDecimal strgAsgmCapa_vm_sum) {
        this.strgAsgmCapa_vm_sum = strgAsgmCapa_vm_sum;
    }

    public String getTmplatClNm() {
        return tmplatClNm;
    }

    public void setTmplatClNm(String tmplatClNm) {
        this.tmplatClNm = tmplatClNm;
    }

    public String getNetClCd() {
        return netClCd;
    }

    public void setNetClCd(String netClCd) {
        this.netClCd = netClCd;
    }

    public BigDecimal getVmSnapshtAsgnCapa() {
        return vmSnapshtAsgnCapa;
    }

    public void setVmSnapshtAsgnCapa(BigDecimal vmSnapshtAsgnCapa) {
        this.vmSnapshtAsgnCapa = vmSnapshtAsgnCapa;
    }

    public BigDecimal getSumVmSnapshtAsgnCapa() {
        return sumVmSnapshtAsgnCapa;
    }

    public void setSumVmSnapshtAsgnCapa(BigDecimal sumVmSnapshtAsgnCapa) {
        this.sumVmSnapshtAsgnCapa = sumVmSnapshtAsgnCapa;
    }

    public BigDecimal getVmSnapshtAsgnCapa_sum() {
        return vmSnapshtAsgnCapa_sum;
    }

    public void setVmSnapshtAsgnCapa_sum(BigDecimal vmSnapshtAsgnCapa_sum) {
        this.vmSnapshtAsgnCapa_sum = vmSnapshtAsgnCapa_sum;
    }
}
