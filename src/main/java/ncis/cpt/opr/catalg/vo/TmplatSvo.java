/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TmplatSvo.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import ncis.cmn.util.ObjectUtils;
import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 송승규
 *
 */
public class TmplatSvo extends CommonSearchVo {

    /**
     * 사용여부
     */
    private String useYn;

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
     * 가상화구분(자원풀명)
     */
    private String poolId;

    /**
     * OS Bits
     */
    private String osBit;

    /**
     * 템플릿구분코드
     */
    private String tmplatClCd;

    /**
     * 템플릿명
     */
    private String tmplatNm;

    /**
     * 가상화SW유형코드
     */
    private String vrlzSwTyCd;

    /**
     * 운영체제유형코드
     */
    private String osTyCd;

    /**
     * 운영체제명
     */
    private String osNm;

    /**
     * 사용/미사용 처리 List
     */
    private ArrayList<Integer> updtCheck;

    /**
     * 소프트웨어 구성ID
     */
    private String compId;

    /**
     * 소프트웨어명
     */
    private String swNm;

    /**
     * 소프트웨어 버전
     */
    private String swVer;

    /**
     * 소프트웨어 제조사
     */
    private String swMnfctCo;

    /**
     * 용도
     * */
    private String prposCd;

    /**
     * 망구분
     */
    private String netClCd;
    /**
     * 가상화구분 리스트
     */
    private String[] vrlzSwTyCdList;

    /**
     * 가상스토리지 도메인SEQ
     */
    private BigDecimal searchStrgDmnSeq;


    /**
	 * 가상서버생성진행여부
	 */
	private String vmCrePrcssYn;


    /**
     * @return the useYn
     */
    public String getUseYn() {
        return useYn;
    }

    /**
     * @param useYn the useYn to set
     */
    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    /**
     * @return the regionId
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * @param regionId the regionId to set
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    /**
     * @return the zoneId
     */
    public String getZoneId() {
        return zoneId;
    }

    /**
     * @param zoneId the zoneId to set
     */
    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    /**
     * @return the netId
     */
    public String getNetId() {
        return netId;
    }

    /**
     * @param netId the netId to set
     */
    public void setNetId(String netId) {
        this.netId = netId;
    }

    /**
     * @return the poolId
     */
    public String getPoolId() {
        return poolId;
    }

    /**
     * @param poolId the poolId to set
     */
    public void setPoolId(String poolId) {
        this.poolId = poolId;
    }

    /**
     * @return the osBit
     */
    public String getOsBit() {
        return osBit;
    }

    /**
     * @param osBit the osBit to set
     */
    public void setOsBit(String osBit) {
        this.osBit = osBit;
    }

    /**
     * @return the tmplatClCd
     */
    public String getTmplatClCd() {
        return tmplatClCd;
    }

    /**
     * @param tmplatClCd the tmplatClCd to set
     */
    public void setTmplatClCd(String tmplatClCd) {
        this.tmplatClCd = tmplatClCd;
    }

    /**
     * @return the tmplatNm
     */
    public String getTmplatNm() {
        return tmplatNm;
    }

    /**
     * @param tmplatNm the tmplatNm to set
     */
    public void setTmplatNm(String tmplatNm) {
        this.tmplatNm = tmplatNm;
    }

    /**
     * @return the vrlzSwTyCd
     */
    public String getVrlzSwTyCd() {
        return vrlzSwTyCd;
    }

    /**
     * @param vrlzSwTyCd the vrlzSwTyCd to set
     */
    public void setVrlzSwTyCd(String vrlzSwTyCd) {
        this.vrlzSwTyCd = vrlzSwTyCd;
    }

    /**
     * @return the osTyCd
     */
    public String getOsTyCd() {
        return osTyCd;
    }

    /**
     * @param osTyCd the osTyCd to set
     */
    public void setOsTyCd(String osTyCd) {
        this.osTyCd = osTyCd;
    }

    /**
     * @return the osNm
     */
    public String getOsNm() {
        return osNm;
    }

    /**
     * @param osNm the osNm to set
     */
    public void setOsNm(String osNm) {
        this.osNm = osNm;
    }

    /**
     * @return the updtCheck
     */
    @SuppressWarnings("unchecked")
	public ArrayList<Integer> getUpdtCheck() {
        if (ObjectUtils.isEmpty(updtCheck)) {
            updtCheck = new ArrayList<Integer>();
        }
        return (ArrayList<Integer>) updtCheck.clone();
    }

    /**
     * @param updtCheck the updtCheck to set
     */
    @SuppressWarnings("unchecked")
	public void setUpdtCheck(ArrayList<Integer> updtCheck) {
        this.updtCheck = (ArrayList<Integer>) updtCheck.clone();
    }

    /**
     * @return the compId
     */
    public String getCompId() {
        return compId;
    }

    /**
     * @param compId the compId to set
     */
    public void setCompId(String compId) {
        this.compId = compId;
    }

    /**
     * @return the swNm
     */
    public String getSwNm() {
        return swNm;
    }

    /**
     * @param swNm the swNm to set
     */
    public void setSwNm(String swNm) {
        this.swNm = swNm;
    }

    /**
     * @return the swVer
     */
    public String getSwVer() {
        return swVer;
    }

    /**
     * @param swVer the swVer to set
     */
    public void setSwVer(String swVer) {
        this.swVer = swVer;
    }

    /**
     * @return the swMnfctCo
     */
    public String getSwMnfctCo() {
        return swMnfctCo;
    }

    /**
     * @param swMnfctCo the swMnfctCo to set
     */
    public void setSwMnfctCo(String swMnfctCo) {
        this.swMnfctCo = swMnfctCo;
    }

    public String getPrposCd() {
        return prposCd;
    }

    public void setPrposCd(String prposCd) {
        this.prposCd = prposCd;
    }

    public String[] getVrlzSwTyCdList() {
        if (null != this.vrlzSwTyCdList) {
            this.vrlzSwTyCdList = (vrlzSwTyCdList == null ? null : Arrays.copyOf(vrlzSwTyCdList, vrlzSwTyCdList.length));
            return this.vrlzSwTyCdList;
        }
        return null;

    }

    public void setVrlzSwTyCdList(String[] vrlzSwTyCdList) {
        this.vrlzSwTyCdList = (vrlzSwTyCdList == null ? null : Arrays.copyOf(vrlzSwTyCdList, vrlzSwTyCdList.length));
    }

    public BigDecimal getSearchStrgDmnSeq() {
        return searchStrgDmnSeq;
    }

    public void setSearchStrgDmnSeq(BigDecimal searchStrgDmnSeq) {
        this.searchStrgDmnSeq = searchStrgDmnSeq;
    }

    public String getNetClCd() {
		return netClCd;
	}

	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}

	public String getVmCrePrcssYn() {
		return vmCrePrcssYn;
	}

	public void setVmCrePrcssYn(String vmCrePrcssYn) {
		this.vmCrePrcssYn = vmCrePrcssYn;
	}


}
