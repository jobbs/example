/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobResStteVo.java
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
 *
 */
package ncis.dsb.stts.res.vo;

import java.math.BigDecimal;


public class JobResStteVo {

	private String institutionNm;
	private String institutionId;
	private BigDecimal institutionCnt;
	private String jobId;
	private String jobNm;
	private BigDecimal web;
	private BigDecimal was;
	private BigDecimal db;
	private BigDecimal win;
	private BigDecimal test;
	private BigDecimal servcCnt;
	private BigDecimal podQty;
	private BigDecimal osWin;
	private BigDecimal osLinux;
	private BigDecimal osHp;
	private BigDecimal osAix;
	private BigDecimal osSolaris;
	private BigDecimal osEtc;
	private BigDecimal webVcore;
	private BigDecimal webCpuRt;
	private BigDecimal webMem;
	private BigDecimal webMemRt;
	private BigDecimal webStrg;
	private BigDecimal webStrgRt;
	private BigDecimal wasVcore;
	private BigDecimal wasCpuRt;
	private BigDecimal wasMem;
	private BigDecimal wasMemRt;
	private BigDecimal wasStrg;
	private BigDecimal wasStrgRt;
	private BigDecimal dbVcore;
	private BigDecimal dbCpuRt;
	private BigDecimal dbMem;
	private BigDecimal dbMemRt;
	private BigDecimal dbStrg;
	private BigDecimal dbStrgRt;
	private BigDecimal winVcore;
	private BigDecimal winCpuRt;
	private BigDecimal winMem;
	private BigDecimal winMemRt;
	private BigDecimal winStrg;
	private BigDecimal winStrgRt;
	private BigDecimal testVcore;
	private BigDecimal testCpuRt;
	private BigDecimal testMem;
	private BigDecimal testMemRt;
	private BigDecimal testStrg;
	private BigDecimal testStrgRt;
	private BigDecimal cpuCorQty;
	private BigDecimal avgCpuUseRt;
	private BigDecimal memTotCapa;
	private BigDecimal avgMemUseRt;
	private BigDecimal strgTotCapa;

	/**
	 * @return the institutionNm
	 */
	public String getInstitutionNm() {
		return institutionNm;
	}
	/**
	 * @param institutionNm the institutionNm to set
	 */
	public void setInstitutionNm(String institutionNm) {
		this.institutionNm = institutionNm;
	}

	/**
	 * @return the institutionId
	 */
	public String getInstitutionId() {
		return institutionId;
	}
	/**
	 * @param institutionId the institutionId to set
	 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	/**
	 * @return the institutionCnt
	 */
	public BigDecimal getInstitutionCnt() {
		return institutionCnt;
	}
	/**
	 * @param institutionCnt the institutionCnt to set
	 */
	public void setInstitutionCnt(BigDecimal institutionCnt) {
		this.institutionCnt = institutionCnt;
	}
	/**
	 * @return the jobId
	 */
	public String getJobId() {
		return jobId;
	}
	/**
	 * @param jobNm the jobNm to set
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	/**
	 * @return the jobNm
	 */
	public String getJobNm() {
		return jobNm;
	}
	/**
	 * @param jobNm the jobNm to set
	 */
	public void setJobNm(String jobNm) {
		this.jobNm = jobNm;
	}
	/**
	 * @return the web
	 */
	public BigDecimal getWeb() {
		return web;
	}
	/**
	 * @param web the web to set
	 */
	public void setWeb(BigDecimal web) {
		this.web = web;
	}
	/**
	 * @return the was
	 */
	public BigDecimal getWas() {
		return was;
	}
	/**
	 * @param was the was to set
	 */
	public void setWas(BigDecimal was) {
		this.was = was;
	}
	/**
	 * @return the db
	 */
	public BigDecimal getDb() {
		return db;
	}
	/**
	 * @param db the db to set
	 */
	public void setDb(BigDecimal db) {
		this.db = db;
	}
	/**
	 * @return the win
	 */
	public BigDecimal getWin() {
		return win;
	}
	/**
	 * @param win the win to set
	 */
	public void setWin(BigDecimal win) {
		this.win = win;
	}
	/**
	 * @return the test
	 */
	public BigDecimal getTest() {
		return test;
	}
	/**
	 * @param test the test to set
	 */
	public void setTest(BigDecimal test) {
		this.test = test;
	}
	/**
	 * @return the servcCnt
	 */
	public BigDecimal getServcCnt() {
		return servcCnt;
	}
	/**
	 * @param servcCnt the servcCnt to set
	 */
	public void setServcCnt(BigDecimal servcCnt) {
		this.servcCnt = servcCnt;
	}
	/**
	 * @return the podQty
	 */
	public BigDecimal getPodQty() {
		return podQty;
	}
	/**
	 * @param podQty the podQty to set
	 */
	public void setPodQty(BigDecimal podQty) {
		this.podQty = podQty;
	}
	/**
	 * @return the osWin
	 */
	public BigDecimal getOsWin() {
		return osWin;
	}
	/**
	 * @param osWin the osWin to set
	 */
	public void setOsWin(BigDecimal osWin) {
		this.osWin = osWin;
	}
	/**
	 * @return the osLinux
	 */
	public BigDecimal getOsLinux() {
		return osLinux;
	}
	/**
	 * @param osLinux the osLinux to set
	 */
	public void setOsLinux(BigDecimal osLinux) {
		this.osLinux = osLinux;
	}
	/**
	 * @return the osHp
	 */
	public BigDecimal getOsHp() {
		return osHp;
	}
	/**
	 * @param osHp the osHp to set
	 */
	public void setOsHp(BigDecimal osHp) {
		this.osHp = osHp;
	}
	/**
	 * @return the osAix
	 */
	public BigDecimal getOsAix() {
		return osAix;
	}
	/**
	 * @param osAix the osAix to set
	 */
	public void setOsAix(BigDecimal osAix) {
		this.osAix = osAix;
	}
	/**
	 * @return the osSolaris
	 */
	public BigDecimal getOsSolaris() {
		return osSolaris;
	}
	/**
	 * @param osSolaris the osSolaris to set
	 */
	public void setOsSolaris(BigDecimal osSolaris) {
		this.osSolaris = osSolaris;
	}
	/**
	 * @return the osEtc
	 */
	public BigDecimal getOsEtc() {
		return osEtc;
	}
	/**
	 * @param osEtc the osEtc to set
	 */
	public void setOsEtc(BigDecimal osEtc) {
		this.osEtc = osEtc;
	}
	/**
	 * @return the webVcore
	 */
	public BigDecimal getWebVcore() {
		return webVcore;
	}
	/**
	 * @param webVcore the webVcore to set
	 */
	public void setWebVcore(BigDecimal webVcore) {
		this.webVcore = webVcore;
	}
	/**
	 * @return the webCpuRt
	 */
	public BigDecimal getWebCpuRt() {
		return webCpuRt;
	}
	/**
	 * @param webCpuRt the webCpuRt to set
	 */
	public void setWebCpuRt(BigDecimal webCpuRt) {
		this.webCpuRt = webCpuRt;
	}
	/**
	 * @return the webMem
	 */
	public BigDecimal getWebMem() {
		return webMem;
	}
	/**
	 * @param webMem the webMem to set
	 */
	public void setWebMem(BigDecimal webMem) {
		this.webMem = webMem;
	}
	/**
	 * @return the webMemRt
	 */
	public BigDecimal getWebMemRt() {
		return webMemRt;
	}
	/**
	 * @param webMemRt the webMemRt to set
	 */
	public void setWebMemRt(BigDecimal webMemRt) {
		this.webMemRt = webMemRt;
	}
	/**
	 * @return the webStrg
	 */
	public BigDecimal getWebStrg() {
		return webStrg;
	}
	/**
	 * @param webStrg the webStrg to set
	 */
	public void setWebStrg(BigDecimal webStrg) {
		this.webStrg = webStrg;
	}
	/**
	 * @return the webStrgRt
	 */
	public BigDecimal getWebStrgRt() {
		return webStrgRt;
	}
	/**
	 * @param webStrgRt the webStrgRt to set
	 */
	public void setWebStrgRt(BigDecimal webStrgRt) {
		this.webStrgRt = webStrgRt;
	}
	/**
	 * @return the wasVcore
	 */
	public BigDecimal getWasVcore() {
		return wasVcore;
	}
	/**
	 * @param wasVcore the wasVcore to set
	 */
	public void setWasVcore(BigDecimal wasVcore) {
		this.wasVcore = wasVcore;
	}
	/**
	 * @return the wasCpuRt
	 */
	public BigDecimal getWasCpuRt() {
		return wasCpuRt;
	}
	/**
	 * @param wasCpuRt the wasCpuRt to set
	 */
	public void setWasCpuRt(BigDecimal wasCpuRt) {
		this.wasCpuRt = wasCpuRt;
	}
	/**
	 * @return the wasMem
	 */
	public BigDecimal getWasMem() {
		return wasMem;
	}
	/**
	 * @param wasMem the wasMem to set
	 */
	public void setWasMem(BigDecimal wasMem) {
		this.wasMem = wasMem;
	}
	/**
	 * @return the wasMemRt
	 */
	public BigDecimal getWasMemRt() {
		return wasMemRt;
	}
	/**
	 * @param wasMemRt the wasMemRt to set
	 */
	public void setWasMemRt(BigDecimal wasMemRt) {
		this.wasMemRt = wasMemRt;
	}
	/**
	 * @return the wasStrg
	 */
	public BigDecimal getWasStrg() {
		return wasStrg;
	}
	/**
	 * @param wasStrg the wasStrg to set
	 */
	public void setWasStrg(BigDecimal wasStrg) {
		this.wasStrg = wasStrg;
	}
	/**
	 * @return the wasStrgRt
	 */
	public BigDecimal getWasStrgRt() {
		return wasStrgRt;
	}
	/**
	 * @param wasStrgRt the wasStrgRt to set
	 */
	public void setWasStrgRt(BigDecimal wasStrgRt) {
		this.wasStrgRt = wasStrgRt;
	}
	/**
	 * @return the dbVcore
	 */
	public BigDecimal getDbVcore() {
		return dbVcore;
	}
	/**
	 * @param dbVcore the dbVcore to set
	 */
	public void setDbVcore(BigDecimal dbVcore) {
		this.dbVcore = dbVcore;
	}
	/**
	 * @return the dbCpuRt
	 */
	public BigDecimal getDbCpuRt() {
		return dbCpuRt;
	}
	/**
	 * @param dbCpuRt the dbCpuRt to set
	 */
	public void setDbCpuRt(BigDecimal dbCpuRt) {
		this.dbCpuRt = dbCpuRt;
	}
	/**
	 * @return the dbMem
	 */
	public BigDecimal getDbMem() {
		return dbMem;
	}
	/**
	 * @param dbMem the dbMem to set
	 */
	public void setDbMem(BigDecimal dbMem) {
		this.dbMem = dbMem;
	}
	/**
	 * @return the dbMemRt
	 */
	public BigDecimal getDbMemRt() {
		return dbMemRt;
	}
	/**
	 * @param dbMemRt the dbMemRt to set
	 */
	public void setDbMemRt(BigDecimal dbMemRt) {
		this.dbMemRt = dbMemRt;
	}
	/**
	 * @return the dbStrg
	 */
	public BigDecimal getDbStrg() {
		return dbStrg;
	}
	/**
	 * @param dbStrg the dbStrg to set
	 */
	public void setDbStrg(BigDecimal dbStrg) {
		this.dbStrg = dbStrg;
	}
	/**
	 * @return the dbStrgRt
	 */
	public BigDecimal getDbStrgRt() {
		return dbStrgRt;
	}
	/**
	 * @param dbStrgRt the dbStrgRt to set
	 */
	public void setDbStrgRt(BigDecimal dbStrgRt) {
		this.dbStrgRt = dbStrgRt;
	}
	/**
	 * @return the winVcore
	 */
	public BigDecimal getWinVcore() {
		return winVcore;
	}
	/**
	 * @param winVcore the winVcore to set
	 */
	public void setWinVcore(BigDecimal winVcore) {
		this.winVcore = winVcore;
	}
	/**
	 * @return the winCpuRt
	 */
	public BigDecimal getWinCpuRt() {
		return winCpuRt;
	}
	/**
	 * @param winCpuRt the winCpuRt to set
	 */
	public void setWinCpuRt(BigDecimal winCpuRt) {
		this.winCpuRt = winCpuRt;
	}
	/**
	 * @return the winMem
	 */
	public BigDecimal getWinMem() {
		return winMem;
	}
	/**
	 * @param winMem the winMem to set
	 */
	public void setWinMem(BigDecimal winMem) {
		this.winMem = winMem;
	}
	/**
	 * @return the winMemRt
	 */
	public BigDecimal getWinMemRt() {
		return winMemRt;
	}
	/**
	 * @param winMemRt the winMemRt to set
	 */
	public void setWinMemRt(BigDecimal winMemRt) {
		this.winMemRt = winMemRt;
	}
	/**
	 * @return the winStrg
	 */
	public BigDecimal getWinStrg() {
		return winStrg;
	}
	/**
	 * @param winStrg the winStrg to set
	 */
	public void setWinStrg(BigDecimal winStrg) {
		this.winStrg = winStrg;
	}
	/**
	 * @return the winStrgRt
	 */
	public BigDecimal getWinStrgRt() {
		return winStrgRt;
	}
	/**
	 * @param winStrgRt the winStrgRt to set
	 */
	public void setWinStrgRt(BigDecimal winStrgRt) {
		this.winStrgRt = winStrgRt;
	}
	/**
	 * @return the testVcore
	 */
	public BigDecimal getTestVcore() {
		return testVcore;
	}
	/**
	 * @param testVcore the testVcore to set
	 */
	public void setTestVcore(BigDecimal testVcore) {
		this.testVcore = testVcore;
	}
	/**
	 * @return the testCpuRt
	 */
	public BigDecimal getTestCpuRt() {
		return testCpuRt;
	}
	/**
	 * @param testCpuRt the testCpuRt to set
	 */
	public void setTestCpuRt(BigDecimal testCpuRt) {
		this.testCpuRt = testCpuRt;
	}
	/**
	 * @return the testMem
	 */
	public BigDecimal getTestMem() {
		return testMem;
	}
	/**
	 * @param testMem the testMem to set
	 */
	public void setTestMem(BigDecimal testMem) {
		this.testMem = testMem;
	}
	/**
	 * @return the testMemRt
	 */
	public BigDecimal getTestMemRt() {
		return testMemRt;
	}
	/**
	 * @param testMemRt the testMemRt to set
	 */
	public void setTestMemRt(BigDecimal testMemRt) {
		this.testMemRt = testMemRt;
	}
	/**
	 * @return the testStrg
	 */
	public BigDecimal getTestStrg() {
		return testStrg;
	}
	/**
	 * @param testStrg the testStrg to set
	 */
	public void setTestStrg(BigDecimal testStrg) {
		this.testStrg = testStrg;
	}
	/**
	 * @return the testStrgRt
	 */
	public BigDecimal getTestStrgRt() {
		return testStrgRt;
	}
	/**
	 * @param testStrgRt the testStrgRt to set
	 */
	public void setTestStrgRt(BigDecimal testStrgRt) {
		this.testStrgRt = testStrgRt;
	}
	/**
	 * @return the cpuCorQty
	 */
	public BigDecimal getCpuCorQty() {
		return cpuCorQty;
	}
	/**
	 * @param cpuCorQty the cpuCorQty to set
	 */
	public void setCpuCorQty(BigDecimal cpuCorQty) {
		this.cpuCorQty = cpuCorQty;
	}
	/**
	 * @return the avgCpuUseRt
	 */
	public BigDecimal getAvgCpuUseRt() {
		return avgCpuUseRt;
	}
	/**
	 * @param avgCpuUseRt the avgCpuUseRt to set
	 */
	public void setAvgCpuUseRt(BigDecimal avgCpuUseRt) {
		this.avgCpuUseRt = avgCpuUseRt;
	}
	/**
	 * @return the memTotCapa
	 */
	public BigDecimal getMemTotCapa() {
		return memTotCapa;
	}
	/**
	 * @param memTotCapa the memTotCapa to set
	 */
	public void setMemTotCapa(BigDecimal memTotCapa) {
		this.memTotCapa = memTotCapa;
	}
	/**
	 * @return the avgMemUseRt
	 */
	public BigDecimal getAvgMemUseRt() {
		return avgMemUseRt;
	}
	/**
	 * @param avgMemUseRt the avgMemUseRt to set
	 */
	public void setAvgMemUseRt(BigDecimal avgMemUseRt) {
		this.avgMemUseRt = avgMemUseRt;
	}
	/**
	 * @return the strgTotCapa
	 */
	public BigDecimal getStrgTotCapa() {
		return strgTotCapa;
	}
	/**
	 * @param strgTotCapa the strgTotCapa to set
	 */
	public void setStrgTotCapa(BigDecimal strgTotCapa) {
		this.strgTotCapa = strgTotCapa;
	}



}
