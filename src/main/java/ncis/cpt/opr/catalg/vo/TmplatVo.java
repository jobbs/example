/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TmplateVo.java
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

import java.util.ArrayList;

import ncis.cmn.entity.RrTmplat;

/**
 * @author 송승규
 *
 */
public class TmplatVo extends RrTmplat {

	/**
	 * 센터ID
	 */
	private String regionId;

	/**
	 * 센터명
	 */
	private String regionNm;

	/**
	 * 존ID
	 */
	private String zoneId;

	/**
	 * 존명
	 */
	private String zoneNm;

	/**
	 * 망ID
	 */
	private String netId;

	/**
	 * 망명
	 */
	private String netNm;

	/**
	 * 자원풀명
	 */
	private String poolId;

	/**
	 * 자원풀명
	 */
	private String rsrcPoolNm;

	/**
	 * 용도ArrayList
	 */
	private ArrayList<TmplatPrposVo> prposList;

	/**
	 * 용도(for excel)
	 */
	private String prpos;

	/**
	 * SWArrayList
	 */
	private ArrayList<TmplatSwVo> tmplatSwList;

	/**
	 * 소프트웨어(for excel)
	 */
	private String sw;

	/**
	 * 등록일시(for excel)
	 */
	private String regDt;

	/**
	 * 등록자명
	 */
	private String regUserNm;

	/**
	 * 수정자명
	 */
	private String updtUserNm;

	/**
	 * 용도선택 ArrayList
	 */
	private ArrayList<String> prposInsert;

	/**
	 * SW선택 ArrayList
	 */
	private ArrayList<Integer> swInsert;

	/**
	 * 용도 코드
	 * */
	private String prposCd;
	/**
	 * 용도 명
	 * */
	private String prposNm;

	/***
	 * 기싱SW 명
	 */
	private String vrlzSwTyNm;

	/**
	 * 템플릿 구분 코드 명
	 */
	private String tmplatClNm;

	/**
	 * 언어 설명
	 */
	private String langNm;

	/**
	 * OS 비트 설명
	 */
	private String osBitNm;


	/**
	 * 사용 여부 (한글)
	 */
	private String useYnNm;

	/**
	 * 기존 유효ID
	 */
	/*private String tmplatValidId;*/

	/**
	 * 망구분 코드
	 */
	private String netClCd;
	/**
	 * 망구분명
	 */
	private String netClNm;

	/**
	 * 스태틱라우팅 스크립트
	 */
	private String sRoutingScript;

	/**
	 * 가상서버생성진행여부
	 */
	private String vmCrePrcssYn;


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
	 * @return the regionNm
	 */
	public String getRegionNm() {
		return regionNm;
	}

	/**
	 * @param regionNm the regionNm to set
	 */
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
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
	 * @return the zoneNm
	 */
	public String getZoneNm() {
		return zoneNm;
	}

	/**
	 * @param zoneNm the zoneNm to set
	 */
	public void setZoneNm(String zoneNm) {
		this.zoneNm = zoneNm;
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
	 * @return the netNm
	 */
	public String getNetNm() {
		return netNm;
	}

	/**
	 * @param netNm the netNm to set
	 */
	public void setNetNm(String netNm) {
		this.netNm = netNm;
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
	 * @return the rsrcPoolNm
	 */
	public String getRsrcPoolNm() {
		return rsrcPoolNm;
	}

	/**
	 * @param rsrcPoolNm the rsrcPoolNm to set
	 */
	public void setRsrcPoolNm(String rsrcPoolNm) {
		this.rsrcPoolNm = rsrcPoolNm;
	}

	/**
	 * @return the prposList
	 */
	public ArrayList<TmplatPrposVo> getPrposList() {
		return prposList;
	}

	/**
	 * @param prposList the prposList to set
	 */
	public void setPrposList(ArrayList<TmplatPrposVo> prposList) {
		this.prposList = prposList;
	}

	/**
	 * @return the prpos
	 */
	public String getPrpos() {
		return prpos;
	}

	/**
	 * @param prpos the prpos to set
	 */
	public void setPrpos(String prpos) {
		this.prpos = prpos;
	}

	/**
	 * @return the tmplatSwList
	 */
	public ArrayList<TmplatSwVo> getTmplatSwList() {
		return tmplatSwList;
	}

	/**
	 * @param tmplatSwList the tmplatSwList to set
	 */
	public void setTmplatSwList(ArrayList<TmplatSwVo> tmplatSwList) {
		this.tmplatSwList = tmplatSwList;
	}

	/**
	 * @return the sw
	 */
	public String getSw() {
		return sw;
	}

	/**
	 * @param sw the sw to set
	 */
	public void setSw(String sw) {
		this.sw = sw;
	}

	/**
	 * @return the regDt
	 */
	public String getRegDt() {
		return regDt;
	}

	/**
	 * @param regDt the regDt to set
	 */
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	/**
	 * @return the regUserNm
	 */
	public String getRegUserNm() {
		return regUserNm;
	}

	/**
	 * @param regUserNm the regUserNm to set
	 */
	public void setRegUserNm(String regUserNm) {
		this.regUserNm = regUserNm;
	}

	/**
	 * @return the updtUserNm
	 */
	public String getUpdtUserNm() {
		return updtUserNm;
	}

	/**
	 * @param updtUserNm the updtUserNm to set
	 */
	public void setUpdtUserNm(String updtUserNm) {
		this.updtUserNm = updtUserNm;
	}

	/**
	 * @return the prposInsert
	 */
	public ArrayList<String> getPrposInsert() {
		return prposInsert;
	}

	/**
	 * @param prposInsert the prposInsert to set
	 */
	public void setPrposInsert(ArrayList<String> prposInsert) {
		this.prposInsert = prposInsert;
	}

	/**
	 * @return the swInsert
	 */
	public ArrayList<Integer> getSwInsert() {
		return swInsert;
	}

	/**
	 * @param swInsert the swInsert to set
	 */
	public void setSwInsert(ArrayList<Integer> swInsert) {
		this.swInsert = swInsert;
	}

	/**
	 * @return the prposCd
	 */
	public String getPrposCd() {
		return prposCd;
	}

	/**
	 * @param prposCd the prposCd to set
	 */
	public void setPrposCd(String prposCd) {
		this.prposCd = prposCd;
	}

	/**
	 * @return the prposNm
	 */
	public String getPrposNm() {
		return prposNm;
	}

	/**
	 * @param prposNm the prposNm to set
	 */
	public void setPrposNm(String prposNm) {
		this.prposNm = prposNm;
	}

	/**
	 * @return the vrlzSwTyNm
	 */
	public String getVrlzSwTyNm() {
		return vrlzSwTyNm;
	}

	/**
	 * @param vrlzSwTyNm the vrlzSwTyNm to set
	 */
	public void setVrlzSwTyNm(String vrlzSwTyNm) {
		this.vrlzSwTyNm = vrlzSwTyNm;
	}

	/**
	 * @return the tmplatClNm
	 */
	public String getTmplatClNm() {
		return tmplatClNm;
	}

	/**
	 * @param tmplatClNm the tmplatClNm to set
	 */
	public void setTmplatClNm(String tmplatClNm) {
		this.tmplatClNm = tmplatClNm;
	}

	/**
	 * @return the langNm
	 */
	public String getLangNm() {
		return langNm;
	}

	/**
	 * @param langNm the langNm to set
	 */
	public void setLangNm(String langNm) {
		this.langNm = langNm;
	}

	/**
	 * @return the osBitNm
	 */
	public String getOsBitNm() {
		return osBitNm;
	}

	/**
	 * @param osBitNm the osBitNm to set
	 */
	public void setOsBitNm(String osBitNm) {
		this.osBitNm = osBitNm;
	}

	/**
	 * @return the useYnNm
	 */
	public String getUseYnNm() {
		return useYnNm;
	}

	/**
	 * @param useYnNm the useYnNm to set
	 */
	public void setUseYnNm(String useYnNm) {
		this.useYnNm = useYnNm;
	}



	public String getNetClCd() {
		return netClCd;
	}

	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}

	public String getNetClNm() {
		return netClNm;
	}

	public void setNetClNm(String netClNm) {
		this.netClNm = netClNm;
	}

	/**
	 * @return the sRoutingScript
	 */
	public String getsRoutingScript() {
		return sRoutingScript;
	}

	/**
	 * @param sRoutingScript the sRoutingScript to set
	 */
	public void setsRoutingScript(String sRoutingScript) {
		this.sRoutingScript = sRoutingScript;
	}

	public String getVmCrePrcssYn() {
		return vmCrePrcssYn;
	}

	public void setVmCrePrcssYn(String vmCrePrcssYn) {
		this.vmCrePrcssYn = vmCrePrcssYn;
	}

}
