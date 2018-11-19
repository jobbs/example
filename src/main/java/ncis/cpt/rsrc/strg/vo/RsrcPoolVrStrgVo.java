/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcPoolVrStrgVo.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 11. 1.
 * @lastmodified 2016. 11. 1.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 1.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.vo;

import java.math.BigDecimal;

/**
 * @author 신재훈
 *
 */
public class RsrcPoolVrStrgVo {
    // 공통
    private String regionId; // 센터아이디
    private String zoneId; // 존아이디
    private String netId; // 망아이디
    private String netClCd; // 망구분 아이디
    private String regionNm; // 센터명
    private String zoneNm; // 존명
    private String netNm; // 망명
    private String rsrcPoolId; // 자원풀명
    private String rsrcPoolNm; // 자원풀명
    private String vrlzSwTyCdNm; // 가상화구분 명
    private String vrlzSwTyCdId; // 가상화구분 아이디

    // 자원풀
    private BigDecimal sumWholeAsgnCapa; /* 전체할당용량(GB) 합계 */
    private BigDecimal sumStrgUseCapa; /* 스토리지사용용량(GB) 합계 */
    private BigDecimal sumVmAsgnCapa; /* 가상서버할당량(GB) 합계 */
    private BigDecimal sumStrMrgnCapa; /* 스토리지여유량(GB) 합계 */
    private BigDecimal sumTmplatAsgnCapa; /* 템플릿할당용량(GB) 합계 */
    private BigDecimal sumVmSnapshtAsgnCapa; /* VM스냅샷할당량(GB) 합계 */
    private int cnt; // 자원풀에 물려있는 스토리지 수
    private int rnkCnt;
    private int rnk;

    // 스토리지
    private String strgDmnSeq; // 스토리지도메인SEQ
    private String strgDmnNm; // 스토리지도메인명
    private BigDecimal wholeAsgnCapa; // 전체할당용량(GB)
    private BigDecimal strgUseCapa; // 스토리지사용용량(GB)
    private BigDecimal vmAsgnCapa; // 가상서버할당량(GB)
    private BigDecimal strMrgnCapa; // 스토리지여유량(GB)
    private BigDecimal tmplatAsgnCapa; // 템플릿할당용량(GB)
    private BigDecimal vmSnapshtAsgnCapa; // VM스냅샷할당량(GB)

    private BigDecimal vmAsgnCapaSingle; // VM할당량 개별(GB)
    private BigDecimal vmSnapshtAsgnCapaSingle; // VM스냅샷할당량 개별(GB)

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

    public String getStrgDmnSeq() {
        return strgDmnSeq;
    }

    public void setStrgDmnSeq(String strgDmnSeq) {
        this.strgDmnSeq = strgDmnSeq;
    }

    public String getStrgDmnNm() {
        return strgDmnNm;
    }

    public void setStrgDmnNm(String strgDmnNm) {
        this.strgDmnNm = strgDmnNm;
    }

    public BigDecimal getWholeAsgnCapa() {
        return wholeAsgnCapa;
    }

    public void setWholeAsgnCapa(BigDecimal wholeAsgnCapa) {
        this.wholeAsgnCapa = wholeAsgnCapa;
    }

    public BigDecimal getStrgUseCapa() {
        return strgUseCapa;
    }

    public void setStrgUseCapa(BigDecimal strgUseCapa) {
        this.strgUseCapa = strgUseCapa;
    }

    public BigDecimal getVmAsgnCapa() {
        return vmAsgnCapa;
    }

    public void setVmAsgnCapa(BigDecimal vmAsgnCapa) {
        this.vmAsgnCapa = vmAsgnCapa;
    }

    public BigDecimal getStrMrgnCapa() {
        return strMrgnCapa;
    }

    public void setStrMrgnCapa(BigDecimal strMrgnCapa) {
        this.strMrgnCapa = strMrgnCapa;
    }

    public BigDecimal getTmplatAsgnCapa() {
        return tmplatAsgnCapa;
    }

    public void setTmplatAsgnCapa(BigDecimal tmplatAsgnCapa) {
        this.tmplatAsgnCapa = tmplatAsgnCapa;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String getRsrcPoolId() {
        return rsrcPoolId;
    }

    public void setRsrcPoolId(String rsrcPoolId) {
        this.rsrcPoolId = rsrcPoolId;
    }

    @Override
    public String toString() {
        return "RsrcPoolVrStrgVo [regionId=" + regionId + ", zoneId=" + zoneId + ", netId=" + netId + ", regionNm=" + regionNm + ", zoneNm=" + zoneNm + ", netNm=" + netNm + ", rsrcPoolId=" + rsrcPoolId + ", rsrcPoolNm=" + rsrcPoolNm + ", vrlzSwTyCdNm=" + vrlzSwTyCdNm + ", vrlzSwTyCdId=" + vrlzSwTyCdId + ", sumWholeAsgnCapa=" + sumWholeAsgnCapa + ", sumStrgUseCapa=" + sumStrgUseCapa + ", sumVmAsgnCapa=" + sumVmAsgnCapa + ", sumStrMrgnCapa=" + sumStrMrgnCapa + ", sumTmplatAsgnCapa=" + sumTmplatAsgnCapa + ", cnt=" + cnt + ", strgDmnSeq=" + strgDmnSeq + ", strgDmnNm=" + strgDmnNm + ", wholeAsgnCapa=" + wholeAsgnCapa + ", strgUseCapa=" + strgUseCapa + ", vmAsgnCapa=" + vmAsgnCapa + ", strMrgnCapa=" + strMrgnCapa + ", tmplatAsgnCapa=" + tmplatAsgnCapa + "]";
    }

    public int getRnkCnt() {
        return rnkCnt;
    }

    public void setRnkCnt(int rnkCnt) {
        this.rnkCnt = rnkCnt;
    }

    public int getRnk() {
        return rnk;
    }

    public void setRnk(int rnk) {
        this.rnk = rnk;
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

    public BigDecimal getVmAsgnCapaSingle() {
        return vmAsgnCapaSingle;
    }

    public void setVmAsgnCapaSingle(BigDecimal vmAsgnCapaSingle) {
        this.vmAsgnCapaSingle = vmAsgnCapaSingle;
    }

    public BigDecimal getVmSnapshtAsgnCapaSingle() {
        return vmSnapshtAsgnCapaSingle;
    }

    public void setVmSnapshtAsgnCapaSingle(BigDecimal vmSnapshtAsgnCapaSingle) {
        this.vmSnapshtAsgnCapaSingle = vmSnapshtAsgnCapaSingle;
    }

}
