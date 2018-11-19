/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ServcUseStteSearchVo.java
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

package ncis.dsb.stts.reqPrcssStte.vo;


public class ReqPrcssStteVo  {
	private String regionId;
	private String regionNm;
	private String zoneId;
	private String znoeNm;
	private String netId;
	private String netNm;
	private String rsrcPoolId;
	private String rsrcPoolNm;
	private String ym;
	private String ymNm;
	private String institutionId;
	private String institutionNm;
	private String yy;
	private String mm;
	private long vmCreateQty;
	private long vmRemoveQty;
	private long specUpdateQty;
	private long sanAddQty;
	private long withdrawQty;
	private long tot;
	private long rnk;
	private int totalCount;
	public ReqPrcssStteVo(){}
	public String getYm() {
		return ym;
	}
	public void setYm(String ym) {
		this.ym = ym;
	}
	public long getVmCreateQty() {
		return vmCreateQty;
	}
	public void setVmCreateQty(long vmCreateQty) {
		this.vmCreateQty = vmCreateQty;
	}
	public long getVmRemoveQty() {
		return vmRemoveQty;
	}
	public void setVmRemoveQty(long vmRemoveQty) {
		this.vmRemoveQty = vmRemoveQty;
	}
	public long getSpecUpdateQty() {
		return specUpdateQty;
	}
	public void setSpecUpdateQty(long specUpdateQty) {
		this.specUpdateQty = specUpdateQty;
	}
	public long getSanAddQty() {
		return sanAddQty;
	}
	public void setSanAddQty(long sanAddQty) {
		this.sanAddQty = sanAddQty;
	}
	public long getWithdrawQty() {
		return withdrawQty;
	}
	public void setWithdrawQty(long withdrawQty) {
		this.withdrawQty = withdrawQty;
	}
	public long getTot() {
		return tot;
	}
	public void setTot(long tot) {
		this.tot = tot;
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
	public String getYmNm() {
		return ymNm;
	}
	public void setYmNm(String ymNm) {
		this.ymNm = ymNm;
	}
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
	public String getZnoeNm() {
		return znoeNm;
	}
	public void setZnoeNm(String znoeNm) {
		this.znoeNm = znoeNm;
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
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getMm() {
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public String getYy() {
		return yy;
	}
	public void setYy(String yy) {
		this.yy = yy;
	}
	public long getRnk() {
		return rnk;
	}
	public void setRnk(long rnk) {
		this.rnk = rnk;
	}
}