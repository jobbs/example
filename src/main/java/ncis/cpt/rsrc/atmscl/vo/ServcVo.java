package ncis.cpt.rsrc.atmscl.vo;

import java.util.List;

import ncis.cmn.entity.RxServc;

public class ServcVo extends RxServc {

	private String regionId; /* 리전ID */
    private String zoneId; /* 존ID */
    private String netClCd; /* 망구분코드 */
    private String regionNm; /* 리전명 */
    private String zoneNm; /* 존명 */
    private String netNm; /* 망명 */
    private String rsrcPoolId; /* 자원풀ID */
    private String rsrcPoolNm; /* 자원풀명 */
    private String servcAreaNm; /* 서비스영역명 */
    private String institutionNm; /* 부처명 */
    private String jobNm; /* 업무명 */
    private String creUserNm; /* 생성자명 */
    private String updtUserNm; /* 수정자명 */
    private double sumMemAsgnCapa; /* 메모리할당량 */
    private double avgMemUseRt; /* 메모리사용률 */
    private double sumCpuCorQty; /* CPU코어수 */
    private double avgCpuUseRt; /* CPU사용률 */
    private double netwkIn; /* 네트워크In */
    private double netwkOut; /* 네트워크Out */
    private Integer podQty;  /* Pod수 */
    private String hstNm;   /* 호스트명 */
    private String servcAreaId;  /* 서비스영역ID */
    private String imgId;  /* 베이스이미지ID */
    private String imgNm;  /* 베이스이미지명 */
    private String imgVer; /* 베이스이미지버전 */
    private String gitRepoAddr;  /* Git 소스 URL경로 */
    private String gitBrnchNm;  /* Git 브렌치 */
    private String gitBestPath;  /* Git 빌드 최상위경로 */
    private String gitScrtkyId;  /* Git 보안키 */
    private String targtPort;  /* 대상포트 */
    private Integer baseImgServcAreaSeq; /* 베이스이미지서비스영역SEQ */
    private String baseImgServcAreaId; /* 베이스이미지서비스영역ID */
    private String statCdNm;   /* 상태코드명 */
    private String bldId;  /* 빌드ID */
    private String lastBldVer;  /* 최종빌드버전 */
    private String distrbConfId;  /* 배포설정D */
    private String lastDistrbVer;  /* 최종배포버전*/
    private String deployFlag; /* 배포여부 */
    private String creImgId;  /* 생성이미지ID */
    private String ctlTrgtYn;  /* 제어여부 */

    private List<DistrbEnvConfVo> distrbEnvConfList; // StaticRouter 목록

    private BldVo bldVo;  /* 빌드설정정보 */
    private AtmsclDistrbVo atmsclDistrbVo;  /* 배포설정정보 */

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
	public String getNetClCd() {
		return netClCd;
	}
	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
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
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}
	public String getInstitutionNm() {
		return institutionNm;
	}
	public void setInstitutionNm(String institutionNm) {
		this.institutionNm = institutionNm;
	}
	public String getJobNm() {
		return jobNm;
	}
	public void setJobNm(String jobNm) {
		this.jobNm = jobNm;
	}
	public String getRsrcPoolNm() {
		return rsrcPoolNm;
	}
	public void setRsrcPoolNm(String rsrcPoolNm) {
		this.rsrcPoolNm = rsrcPoolNm;
	}
	public String getCreUserNm() {
		return creUserNm;
	}
	public void setCreUserNm(String creUserNm) {
		this.creUserNm = creUserNm;
	}
	public String getUpdtUserNm() {
		return updtUserNm;
	}
	public void setUpdtUserNm(String updtUserNm) {
		this.updtUserNm = updtUserNm;
	}
	public double getSumMemAsgnCapa() {
		return sumMemAsgnCapa;
	}
	public void setSumMemAsgnCapa(double sumMemAsgnCapa) {
		this.sumMemAsgnCapa = sumMemAsgnCapa;
	}
	public double getAvgMemUseRt() {
		return avgMemUseRt;
	}
	public void setAvgMemUseRt(double avgMemUseRt) {
		this.avgMemUseRt = avgMemUseRt;
	}
	public double getSumCpuCorQty() {
		return sumCpuCorQty;
	}
	public void setSumCpuCorQty(double sumCpuCorQty) {
		this.sumCpuCorQty = sumCpuCorQty;
	}
	public double getAvgCpuUseRt() {
		return avgCpuUseRt;
	}
	public void setAvgCpuUseRt(double avgCpuUseRt) {
		this.avgCpuUseRt = avgCpuUseRt;
	}
	public double getNetwkIn() {
		return netwkIn;
	}
	public void setNetwkIn(double netwkIn) {
		this.netwkIn = netwkIn;
	}
	public double getNetwkOut() {
		return netwkOut;
	}
	public void setNetwkOut(double netwkOut) {
		this.netwkOut = netwkOut;
	}
	public Integer getPodQty() {
		return podQty;
	}
	public void setPodQty(Integer podQty) {
		this.podQty = podQty;
	}
	public String getServcAreaNm() {
		return servcAreaNm;
	}
	public void setServcAreaNm(String servcAreaNm) {
		this.servcAreaNm = servcAreaNm;
	}
	public String getHstNm() {
		return hstNm;
	}
	public void setHstNm(String hstNm) {
		this.hstNm = hstNm;
	}
	public String getServcAreaId() {
		return servcAreaId;
	}
	public void setServcAreaId(String servcAreaId) {
		this.servcAreaId = servcAreaId;
	}
	public String getImgId() {
		return imgId;
	}
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	public String getImgNm() {
		return imgNm;
	}
	public void setImgNm(String imgNm) {
		this.imgNm = imgNm;
	}
	public String getGitRepoAddr() {
		return gitRepoAddr;
	}
	public void setGitRepoAddr(String gitRepoAddr) {
		this.gitRepoAddr = gitRepoAddr;
	}
	public String getGitBrnchNm() {
		return gitBrnchNm;
	}
	public void setGitBrnchNm(String gitBrnchNm) {
		this.gitBrnchNm = gitBrnchNm;
	}
	public String getGitBestPath() {
		return gitBestPath;
	}
	public void setGitBestPath(String gitBestPath) {
		this.gitBestPath = gitBestPath;
	}
	public String getGitScrtkyId() {
		return gitScrtkyId;
	}
	public void setGitScrtkyId(String gitScrtkyId) {
		this.gitScrtkyId = gitScrtkyId;
	}
	public String getImgVer() {
		return imgVer;
	}
	public void setImgVer(String imgVer) {
		this.imgVer = imgVer;
	}
	public String getTargtPort() {
		return targtPort;
	}
	public void setTargtPort(String targtPort) {
		this.targtPort = targtPort;
	}
	public Integer getBaseImgServcAreaSeq() {
		return baseImgServcAreaSeq;
	}
	public void setBaseImgServcAreaSeq(Integer baseImgServcAreaSeq) {
		this.baseImgServcAreaSeq = baseImgServcAreaSeq;
	}
	public String getStatCdNm() {
		return statCdNm;
	}
	public void setStatCdNm(String statCdNm) {
		this.statCdNm = statCdNm;
	}
	public String getBldId() {
		return bldId;
	}
	public void setBldId(String bldId) {
		this.bldId = bldId;
	}
	public String getDeployFlag() {
		return deployFlag;
	}
	public void setDeployFlag(String deployFlag) {
		this.deployFlag = deployFlag;
	}
	public String getBaseImgServcAreaId() {
		return baseImgServcAreaId;
	}
	public void setBaseImgServcAreaId(String baseImgServcAreaId) {
		this.baseImgServcAreaId = baseImgServcAreaId;
	}

	public String getCreImgId() {
		return creImgId;
	}
	public void setCreImgId(String creImgId) {
		this.creImgId = creImgId;
	}
	public List<DistrbEnvConfVo> getDistrbEnvConfList() {
		return distrbEnvConfList;
	}
	public void setDistrbEnvConfList(List<DistrbEnvConfVo> distrbEnvConfList) {
		this.distrbEnvConfList = distrbEnvConfList;
	}
	public BldVo getBldVo() {
		return bldVo;
	}
	public void setBldVo(BldVo bldVo) {
		this.bldVo = bldVo;
	}
	public String getDistrbConfId() {
		return distrbConfId;
	}
	public void setDistrbConfId(String distrbConfId) {
		this.distrbConfId = distrbConfId;
	}
	public AtmsclDistrbVo getAtmsclDistrbVo() {
		return atmsclDistrbVo;
	}
	public void setAtmsclDistrbVo(AtmsclDistrbVo atmsclDistrbVo) {
		this.atmsclDistrbVo = atmsclDistrbVo;
	}
	public String getLastBldVer() {
		return lastBldVer;
	}
	public void setLastBldVer(String lastBldVer) {
		this.lastBldVer = lastBldVer;
	}
	public String getLastDistrbVer() {
		return lastDistrbVer;
	}
	public void setLastDistrbVer(String lastDistrbVer) {
		this.lastDistrbVer = lastDistrbVer;
	}
	public String getCtlTrgtYn() {
		return ctlTrgtYn;
	}
	public void setCtlTrgtYn(String ctlTrgtYn) {
		this.ctlTrgtYn = ctlTrgtYn;
	}

}
