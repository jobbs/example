package ncis.cpt.opr.req.rsrcreq.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author selim
 *
 */
public class RsrcReqDtlVmVo {

	private String rsrcReqNo;  /* 자원요청번호 */
	private String rsrcReqUsrId;  /* 자원요청자ID */
	private String rsrcReqUsrNm;  /* 자원요청자명 */
	private String rsrcReqDttm;  /* 자원요청일시 */
	private String rsrcReqPrcssStatCd;  /* 자원요청진행상태코드 */
	private String rsrcReqPrcssStatNm;  /* 자원요청진행상태명 */
	private String reqInstitutionId;  /* 요청기관ID */
	private String reqInstitutionNm;  /* 요청기관명 */
	private String reqDeptId;  /* 요청부서ID */
	private String reqDeptNm;  /* 요청부서명 */
	private String sbjct;  /* 제목 */
	private String ticktNo;  /* 티켓번호 */
	private String regionId;  /* 리전ID */
	private String regionNm;  /* 리전명 */
	private String testYn;  /* 테스트여부 */
	private String linkYn;  /* 연계여부 */
	private String comptDttm;  /* 완료일시 */
	private String regUserId;  /* 등록자ID */
	private String regDt;  /* 등록일자 */
	private BigDecimal rsrcReqSeq;  /* 자원요청일련번호 */
	private String rsrcReqCn;  /* 자원요청내용 */
	private String rsrcReqAreaClCd;  /* 자원요청영역구분코드 */
	private int procssInstSeq;  /* 프로세스인스턴스SEQ */
	private String exeUserId;  /* 실행자ID */
	private String exeUserNm;  /* 실행자명 */
	private String exeDttm;  /* 실행일시 */
	private String zoneNm;  /* 존명 */
	private String netNm;  /* 망명 */
	private String zoneId;  /* 존ID */
	private String netId;  /* 망ID */
	private String rsrcPoolId;  /* 자원풀ID */
	private String uuid;  /* UUID */
	private String rsrcReqTyCd;  /* 자원요청유형코드 */
	private String rsrcReqTyNm;  /* 자원요청유형명 */
	private String vmReqTyCd;  /* 가상서버요청유형코드 */
	private String vmId;  /* 가상서버ID */
	private String vmNm;  /* 가상서버명 */
	private String vmCompId;  /* 가상서버구성ID */
	private String hstNm;  /* 호스트명 */
	private String prposClCd;  /* 용도구분코드 */
	private String prposNm;  /* 용도명 */
	private String useGvDprtId;  /* 사용부처ID */
	private String useJobId;  /* 사용업무ID */
	private String vrCnvrSwTyCd;  /* 가상화SW유형코드 */
	private String vrCnvrSwTyNm; /* 가상화SW유형명 */
	private String os;  /* 운영체계 */
	private Integer clstrSeq;  /* 클러스터일련번호 */
	private String clstrNm;  /* 클러스터명 */
	private Integer pmSeq;  /* 물리서버일련번호 */
	private String pSrvrNm;  /* 물리서버명 */
	private String rsrcPoolNm;  /* 자원풀명 */
	private String ipAddr;  /* IP주소 */
	private String osTyCd;  /* OS유형코드 */
	private String osNm;  /* OS명 */
	private String swId;  /* 소프트웨어ID */
	private String servcStrtDt;  /* 서비스시작일자 */
	private String servcEndDt;  /* 서비스종료일자 */
	private String servcDtNm; /* 서비스시작일자~서비스종료일자 */
	private Integer reqCpuVcoreQty;  /* 요청CPU(vCore) */
	private Integer reqMemAsgnCapa;  /* 요청메모리(GB) */
	private String reqVrDskId;  /* 요청가상디스크ID */
	private String reqVrDskNm;  /* 요청가상디스크명 */
	private Integer strgAsgnCapa;  /* 스토리지할당용량(GB) */
	private String atchFileId;  /* 첨부파일ID */
	private String rmk;  /* 비고 */
	private String reqSpecSeq;  /* 요청스펙SEQ */
	private int tmplatSeq;  /* 템플릿 SEQ */
	private String tmplatNm;  /* 템플릿명 */
	private String vmChngClCd;  /* 가상서버변경구분코드 */
	private BigDecimal chngSpecSeq;  /* 변경전스펙SEQ */
	private String chngPreCpuVcoreQty;  /* 변경전CPU(vCore) */
	private String chngPreMemAsgnCapa;  /* 변경전메모리할당량(GB) */
	private String chngPreStrgAsgnCapa; /* 변경전스토리지할당량 */
	private BigDecimal chngPreSpecSeq;  /* 변경후스펙SEQ */
	private Integer strgAsgnReqCapa;  /* 스토리지할당요청량(GB) */
	private String asgnVrDskId;  /* 할당가상디스크ID */
	private String asgnVrDskNm;  /* 할당가상디스크명 */
	private String shareYn;  /* 공유여부  */
	private String ipAutoAsgnYn; /* 자동할당여부 */
	private String mobile;  /* 핸드폰 */
	private String email;   /* 이메일 */
	private String useGvDprtNm;  /* 사용부처명 */
	private String useJobNm;  /* 사용업무명 */
	private String rsrcPoolInfo;  /* 자원풀정보 */
	private String haGrpCd;  /* HA그룹정보 */
	private String haGrpId;  /* HA그룹ID */
	private String haGrpNm;  /* HA그룹명 */
	private String haVmNm;  /* HA가상서버명 */
	private String haYn;  /* HA여부 */
	private String haStrgCapa;  /* HA스토리지용량 */
	private String haStrgShareYn;  /* HA스토리지공유여부 */
	private String haStatNm;  /* HA상태명 */
	private List<RsrcReqNetwkIntfcVo> rsrcReqNetwkIntfc;  /* 네트워크인터페이스정보 */
	private String chngReqCpuVcoreQty;  /* 변경요청CPU */
	private String chngReqMemAsgnCapa;  /* 변경요청메모리 */
	private String chngReqStrgAsgnCapa;  /* 변경요청스토리지 */
	private String vmStatNm;   /* 가상서버상태 */
	private String rsrcReqDtlPrcssStatCd; /* 가상서버상세 상태코드 */
	private String pmNm; /* 물리서버명 */
	private String reqVrStrgId; /* 요청가상스토리지ID */
	private String nicPrposCd;  /* NIC용도코드 */
	private String osTyNm;  /* OS유형명 */
	private String haCompYn; /* HA구성여부 */

	private String rjctTyCd; /* 반려코드 */
	private String rjctReasn; /* 반려코드 */
	private String schRsrcReqNo; /* 검색 자원요청번호 */

	private String clstrPrposClNm; /* 클러스터용도명 */
	private String clstrPrposClCd; /* 클러스터용도명 */

	private String reqStrgDmnNm; /* 요청스토리지도메인명 */
	private Integer reqStrgDmnSeq; /* 요청스토리지도메인SEQ */

	private String netClCd;	/*망 구분 코드  */
	private String natYn; /* NAT 여부  */
	private BigDecimal vmSeq;	/* 가성서버 SEQ */

	private String vmIdAutoYn; /* 가성서버ID 직접입력여부 */

	private String swTyNm; /* 소프트웨어명 */
	private String exeStatNm; /* 실행상태 */
	private String exeStatCd; /* 실행상태코드 */
	private String exeType; /* 실행유형 */
	private String procssStatCd; /* 프로세스상태코드 */
	private Integer reqMaxMemAsgnCapa;  /* 요청최대메모리 */
	private Integer reqMaxCpuVcoreQty;  /* 요청최대CPU(vCore) */
	private Integer reqMinMemAsgnCapa;  /* 요청최소메모리 */
	private Integer reqMinCpuVcoreQty;  /* 요청최소CPU(vCore) */
	private BigDecimal reqEntMinVl;  /* 요청엔타이틀먼트최소값 */
	private BigDecimal reqEntMaxVl;  /* 요청엔타이틀먼트최대값 */
	private BigDecimal reqEntDfltVl; /* 요청엔타이틀먼트기본값 */
	private String vmStopYn;   /* 가상서버중지여부 */
	private String reqStrgAsgnPolicyCd;  /* 요청스토리지할당정책코드 */

	public String getChngPreCpuVcoreQty() {
		return chngPreCpuVcoreQty;
	}
	public void setChngPreCpuVcoreQty(String chngPreCpuVcoreQty) {
		this.chngPreCpuVcoreQty = chngPreCpuVcoreQty;
	}
	public String getChngReqCpuVcoreQty() {
		return chngReqCpuVcoreQty;
	}
	public void setChngReqCpuVcoreQty(String chngReqCpuVcoreQty) {
		this.chngReqCpuVcoreQty = chngReqCpuVcoreQty;
	}
	public String getRsrcReqNo() {
		return rsrcReqNo;
	}
	public void setRsrcReqNo(String rsrcReqNo) {
		this.rsrcReqNo = rsrcReqNo;
	}
	public String getRsrcReqUsrId() {
		return rsrcReqUsrId;
	}
	public void setRsrcReqUsrId(String rsrcReqUsrId) {
		this.rsrcReqUsrId = rsrcReqUsrId;
	}
	public String getRsrcReqDttm() {
		return rsrcReqDttm;
	}
	public void setRsrcReqDttm(String rsrcReqDttm) {
		this.rsrcReqDttm = rsrcReqDttm;
	}
	public String getRsrcReqPrcssStatCd() {
		return rsrcReqPrcssStatCd;
	}
	public void setRsrcReqPrcssStatCd(String rsrcReqPrcssStatCd) {
		this.rsrcReqPrcssStatCd = rsrcReqPrcssStatCd;
	}
	public String getReqInstitutionId() {
		return reqInstitutionId;
	}
	public void setReqInstitutionId(String reqInstitutionId) {
		this.reqInstitutionId = reqInstitutionId;
	}
	public String getReqDeptId() {
		return reqDeptId;
	}
	public void setReqDeptId(String reqDeptId) {
		this.reqDeptId = reqDeptId;
	}
	public String getReqDeptNm() {
		return reqDeptNm;
	}
	public void setReqDeptNm(String reqDeptNm) {
		this.reqDeptNm = reqDeptNm;
	}
	public String getSbjct() {
		return sbjct;
	}
	public void setSbjct(String sbjct) {
		this.sbjct = sbjct;
	}
	public String getTicktNo() {
		return ticktNo;
	}
	public void setTicktNo(String ticktNo) {
		this.ticktNo = ticktNo;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getTestYn() {
		return testYn;
	}
	public void setTestYn(String testYn) {
		this.testYn = testYn;
	}
	public String getLinkYn() {
		return linkYn;
	}
	public void setLinkYn(String linkYn) {
		this.linkYn = linkYn;
	}
	public String getComptDttm() {
		return comptDttm;
	}
	public void setComptDttm(String comptDttm) {
		this.comptDttm = comptDttm;
	}
	public String getRegUserId() {
		return regUserId;
	}
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public String getRsrcReqCn() {
		return rsrcReqCn;
	}
	public void setRsrcReqCn(String rsrcReqCn) {
		this.rsrcReqCn = rsrcReqCn;
	}
	public String getRsrcReqAreaClCd() {
		return rsrcReqAreaClCd;
	}
	public void setRsrcReqAreaClCd(String rsrcReqAreaClCd) {
		this.rsrcReqAreaClCd = rsrcReqAreaClCd;
	}
	public BigDecimal getRsrcReqSeq() {
		return rsrcReqSeq;
	}
	public void setRsrcReqSeq(BigDecimal rsrcReqSeq) {
		this.rsrcReqSeq = rsrcReqSeq;
	}
	public int getProcssInstSeq() {
		return procssInstSeq;
	}
	public void setProcssInstSeq(int procssInstSeq) {
		this.procssInstSeq = procssInstSeq;
	}
	public String getExeUserId() {
		return exeUserId;
	}
	public void setExeUserId(String exeUserId) {
		this.exeUserId = exeUserId;
	}
	public String getExeDttm() {
		return exeDttm;
	}
	public void setExeDttm(String exeDttm) {
		this.exeDttm = exeDttm;
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
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getRsrcReqTyCd() {
		return rsrcReqTyCd;
	}
	public void setRsrcReqTyCd(String rsrcReqTyCd) {
		this.rsrcReqTyCd = rsrcReqTyCd;
	}
	public String getVmReqTyCd() {
		return vmReqTyCd;
	}
	public void setVmReqTyCd(String vmReqTyCd) {
		this.vmReqTyCd = vmReqTyCd;
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
	public String getHstNm() {
		return hstNm;
	}
	public void setHstNm(String hstNm) {
		this.hstNm = hstNm;
	}
	public String getPrposClCd() {
		return prposClCd;
	}
	public void setPrposClCd(String prposClCd) {
		this.prposClCd = prposClCd;
	}
	public String getUseGvDprtId() {
		return useGvDprtId;
	}
	public void setUseGvDprtId(String useGvDprtId) {
		this.useGvDprtId = useGvDprtId;
	}
	public String getUseJobId() {
		return useJobId;
	}
	public void setUseJobId(String useJobId) {
		this.useJobId = useJobId;
	}
	public String getVrCnvrSwTyCd() {
		return vrCnvrSwTyCd;
	}
	public void setVrCnvrSwTyCd(String vrCnvrSwTyCd) {
		this.vrCnvrSwTyCd = vrCnvrSwTyCd;
	}
	public String getVrCnvrSwTyNm() {
		return vrCnvrSwTyNm;
	}
	public void setVrCnvrSwTyNm(String vrCnvrSwTyNm) {
		this.vrCnvrSwTyNm = vrCnvrSwTyNm;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public Integer getClstrSeq() {
		return clstrSeq;
	}
	public void setClstrSeq(Integer clstrSeq) {
		this.clstrSeq = clstrSeq;
	}
	public Integer getPmSeq() {
		return pmSeq;
	}
	public void setPmSeq(Integer pmSeq) {
		this.pmSeq = pmSeq;
	}
	public String getRsrcPoolNm() {
		return rsrcPoolNm;
	}
	public void setRsrcPoolNm(String rsrcPoolNm) {
		this.rsrcPoolNm = rsrcPoolNm;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public String getOsTyCd() {
		return osTyCd;
	}
	public void setOsTyCd(String osTyCd) {
		this.osTyCd = osTyCd;
	}
	public String getOsNm() {
		return osNm;
	}
	public void setOsNm(String osNm) {
		this.osNm = osNm;
	}
	public String getSwId() {
		return swId;
	}
	public void setSwId(String swId) {
		this.swId = swId;
	}
	public String getServcStrtDt() {
		return servcStrtDt;
	}
	public void setServcStrtDt(String servcStrtDt) {
		this.servcStrtDt = servcStrtDt;
	}
	public String getServcEndDt() {
		return servcEndDt;
	}
	public void setServcEndDt(String servcEndDt) {
		this.servcEndDt = servcEndDt;
	}
	public Integer getReqCpuVcoreQty() {
		return reqCpuVcoreQty;
	}
	public void setReqCpuVcoreQty(Integer reqCpuVcoreQty) {
		this.reqCpuVcoreQty = reqCpuVcoreQty;
	}
	public Integer getReqMemAsgnCapa() {
		return reqMemAsgnCapa;
	}
	public void setReqMemAsgnCapa(Integer reqMemAsgnCapa) {
		this.reqMemAsgnCapa = reqMemAsgnCapa;
	}
	public String getReqVrDskId() {
		return reqVrDskId;
	}
	public void setReqVrDskId(String reqVrDskId) {
		this.reqVrDskId = reqVrDskId;
	}
	public Integer getStrgAsgnCapa() {
		return strgAsgnCapa;
	}
	public void setStrgAsgnCapa(Integer strgAsgnCapa) {
		this.strgAsgnCapa = strgAsgnCapa;
	}
	public String getAtchFileId() {
		return atchFileId;
	}
	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	public int getTmplatSeq() {
		return tmplatSeq;
	}
	public void setTmplatSeq(int tmplatSeq) {
		this.tmplatSeq = tmplatSeq;
	}
	public String getVmChngClCd() {
		return vmChngClCd;
	}
	public void setVmChngClCd(String vmChngClCd) {
		this.vmChngClCd = vmChngClCd;
	}

	public String getChngPreMemAsgnCapa() {
		return chngPreMemAsgnCapa;
	}
	public void setChngPreMemAsgnCapa(String chngPreMemAsgnCapa) {
		this.chngPreMemAsgnCapa = chngPreMemAsgnCapa;
	}

	public Integer getStrgAsgnReqCapa() {
		return strgAsgnReqCapa;
	}
	public void setStrgAsgnReqCapa(Integer strgAsgnReqCapa) {
		this.strgAsgnReqCapa = strgAsgnReqCapa;
	}
	public String getAsgnVrDskId() {
		return asgnVrDskId;
	}
	public void setAsgnVrDskId(String asgnVrDskId) {
		this.asgnVrDskId = asgnVrDskId;
	}
	public String getShareYn() {
		return shareYn;
	}
	public void setShareYn(String shareYn) {
		this.shareYn = shareYn;
	}
	public String getRsrcReqUsrNm() {
		return rsrcReqUsrNm;
	}
	public void setRsrcReqUsrNm(String rsrcReqUsrNm) {
		this.rsrcReqUsrNm = rsrcReqUsrNm;
	}
	public String getReqInstitutionNm() {
		return reqInstitutionNm;
	}
	public void setReqInstitutionNm(String reqInstitutionNm) {
		this.reqInstitutionNm = reqInstitutionNm;
	}
	public String getExeUserNm() {
		return exeUserNm;
	}
	public void setExeUserNm(String exeUserNm) {
		this.exeUserNm = exeUserNm;
	}
	public String getRsrcReqTyNm() {
		return rsrcReqTyNm;
	}
	public void setRsrcReqTyNm(String rsrcReqTyNm) {
		this.rsrcReqTyNm = rsrcReqTyNm;
	}
	public String getRsrcReqPrcssStatNm() {
		return rsrcReqPrcssStatNm;
	}
	public void setRsrcReqPrcssStatNm(String rsrcReqPrcssStatNm) {
		this.rsrcReqPrcssStatNm = rsrcReqPrcssStatNm;
	}
	public String getIpAutoAsgnYn() {
		return ipAutoAsgnYn;
	}
	public void setIpAutoAsgnYn(String ipAutoAsgnYn) {
		this.ipAutoAsgnYn = ipAutoAsgnYn;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUseGvDprtNm() {
		return useGvDprtNm;
	}
	public void setUseGvDprtNm(String useGvDprtNm) {
		this.useGvDprtNm = useGvDprtNm;
	}
	public String getUseJobNm() {
		return useJobNm;
	}
	public void setUseJobNm(String useJobNm) {
		this.useJobNm = useJobNm;
	}
	public String getPrposNm() {
		return prposNm;
	}
	public void setPrposNm(String prposNm) {
		this.prposNm = prposNm;
	}
	public String getServcDtNm() {
		return servcDtNm;
	}
	public void setServcDtNm(String servcDtNm) {
		this.servcDtNm = servcDtNm;
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
	public String getClstrNm() {
		return clstrNm;
	}
	public void setClstrNm(String clstrNm) {
		this.clstrNm = clstrNm;
	}
	public String getpSrvrNm() {
		return pSrvrNm;
	}
	public void setpSrvrNm(String pSrvrNm) {
		this.pSrvrNm = pSrvrNm;
	}
	public String getReqVrDskNm() {
		return reqVrDskNm;
	}
	public void setReqVrDskNm(String reqVrDskNm) {
		this.reqVrDskNm = reqVrDskNm;
	}
	public String getTmplatNm() {
		return tmplatNm;
	}
	public void setTmplatNm(String tmplatNm) {
		this.tmplatNm = tmplatNm;
	}
	public String getAsgnVrDskNm() {
		return asgnVrDskNm;
	}
	public void setAsgnVrDskNm(String asgnVrDskNm) {
		this.asgnVrDskNm = asgnVrDskNm;
	}
	public String getRsrcPoolInfo() {
		return rsrcPoolInfo;
	}
	public void setRsrcPoolInfo(String rsrcPoolInfo) {
		this.rsrcPoolInfo = rsrcPoolInfo;
	}
	public List<RsrcReqNetwkIntfcVo> getRsrcReqNetwkIntfc() {
		return rsrcReqNetwkIntfc;
	}
	public void setRsrcReqNetwkIntfc(List<RsrcReqNetwkIntfcVo> rsrcReqNetwkIntfc) {
		this.rsrcReqNetwkIntfc = rsrcReqNetwkIntfc;
	}
	public String getHaGrpCd() {
		return haGrpCd;
	}
	public void setHaGrpCd(String haGrpCd) {
		this.haGrpCd = haGrpCd;
	}

	public String getChngReqMemAsgnCapa() {
		return chngReqMemAsgnCapa;
	}
	public void setChngReqMemAsgnCapa(String chngReqMemAsgnCapa) {
		this.chngReqMemAsgnCapa = chngReqMemAsgnCapa;
	}
	public String getChngReqStrgAsgnCapa() {
		return chngReqStrgAsgnCapa;
	}
	public void setChngReqStrgAsgnCapa(String chngReqStrgAsgnCapa) {
		this.chngReqStrgAsgnCapa = chngReqStrgAsgnCapa;
	}
	public String getVmStatNm() {
		return vmStatNm;
	}
	public void setVmStatNm(String vmStatNm) {
		this.vmStatNm = vmStatNm;
	}
	public String getRsrcReqDtlPrcssStatCd() {
		return rsrcReqDtlPrcssStatCd;
	}
	public void setRsrcReqDtlPrcssStatCd(String rsrcReqDtlPrcssStatCd) {
		this.rsrcReqDtlPrcssStatCd = rsrcReqDtlPrcssStatCd;
	}
	public String getPmNm() {
		return pmNm;
	}
	public void setPmNm(String pmNm) {
		this.pmNm = pmNm;
	}
	public String getReqVrStrgId() {
		return reqVrStrgId;
	}
	public void setReqVrStrgId(String reqVrStrgId) {
		this.reqVrStrgId = reqVrStrgId;
	}
	public String getNicPrposCd() {
		return nicPrposCd;
	}
	public void setNicPrposCd(String nicPrposCd) {
		this.nicPrposCd = nicPrposCd;
	}
	public String getOsTyNm() {
		return osTyNm;
	}
	public void setOsTyNm(String osTyNm) {
		this.osTyNm = osTyNm;
	}
	public String getRjctTyCd() {
		return rjctTyCd;
	}
	public void setRjctTyCd(String rjctTyCd) {
		this.rjctTyCd = rjctTyCd;
	}
	public String getRjctReasn() {
		return rjctReasn;
	}
	public void setRjctReasn(String rjctReasn) {
		this.rjctReasn = rjctReasn;
	}
	public String getSchRsrcReqNo() {
		return schRsrcReqNo;
	}
	public void setSchRsrcReqNo(String schRsrcReqNo) {
		this.schRsrcReqNo = schRsrcReqNo;
	}
	public String getReqSpecSeq() {
		return reqSpecSeq;
	}
	public void setReqSpecSeq(String reqSpecSeq) {
		this.reqSpecSeq = reqSpecSeq;
	}
	public BigDecimal getChngSpecSeq() {
		return chngSpecSeq;
	}
	public void setChngSpecSeq(BigDecimal chngSpecSeq) {
		this.chngSpecSeq = chngSpecSeq;
	}
	public BigDecimal getChngPreSpecSeq() {
		return chngPreSpecSeq;
	}
	public void setChngPreSpecSeq(BigDecimal chngPreSpecSeq) {
		this.chngPreSpecSeq = chngPreSpecSeq;
	}
	public String getClstrPrposClNm() {
		return clstrPrposClNm;
	}
	public void setClstrPrposClNm(String clstrPrposClNm) {
		this.clstrPrposClNm = clstrPrposClNm;
	}
	public String getClstrPrposClCd() {
		return clstrPrposClCd;
	}
	public void setClstrPrposClCd(String clstrPrposClCd) {
		this.clstrPrposClCd = clstrPrposClCd;
	}
	public String getReqStrgDmnNm() {
		return reqStrgDmnNm;
	}
	public void setReqStrgDmnNm(String reqStrgDmnNm) {
		this.reqStrgDmnNm = reqStrgDmnNm;
	}
	public Integer getReqStrgDmnSeq() {
		return reqStrgDmnSeq;
	}
	public void setReqStrgDmnSeq(Integer reqStrgDmnSeq) {
		this.reqStrgDmnSeq = reqStrgDmnSeq;
	}
	public String getNetClCd() {
		return netClCd;
	}
	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}
	public String getNatYn() {
		return natYn;
	}
	public void setNatYn(String natYn) {
		this.natYn = natYn;
	}
	public BigDecimal getVmSeq() {
		return vmSeq;
	}
	public void setVmSeq(BigDecimal vmSeq) {
		this.vmSeq = vmSeq;
	}
	public String getSwTyNm() {
		return swTyNm;
	}
	public void setSwTyNm(String swTyNm) {
		this.swTyNm = swTyNm;
	}
	public String getVmIdAutoYn() {
		return vmIdAutoYn;
	}
	public void setVmIdAutoYn(String vmIdAutoYn) {
		this.vmIdAutoYn = vmIdAutoYn;
	}
	public String getChngPreStrgAsgnCapa() {
		return chngPreStrgAsgnCapa;
	}
	public void setChngPreStrgAsgnCapa(String chngPreStrgAsgnCapa) {
		this.chngPreStrgAsgnCapa = chngPreStrgAsgnCapa;
	}
	public String getHaVmNm() {
		return haVmNm;
	}
	public void setHaVmNm(String haVmNm) {
		this.haVmNm = haVmNm;
	}
	public String getHaYn() {
		return haYn;
	}
	public void setHaYn(String haYn) {
		this.haYn = haYn;
	}
	public String getExeStatNm() {
		return exeStatNm;
	}
	public void setExeStatNm(String exeStatNm) {
		this.exeStatNm = exeStatNm;
	}
	public String getHaStrgCapa() {
		return haStrgCapa;
	}
	public void setHaStrgCapa(String haStrgCapa) {
		this.haStrgCapa = haStrgCapa;
	}
	public String getHaStrgShareYn() {
		return haStrgShareYn;
	}
	public void setHaStrgShareYn(String haStrgShareYn) {
		this.haStrgShareYn = haStrgShareYn;
	}
	public String getHaStatNm() {
		return haStatNm;
	}
	public void setHaStatNm(String haStatNm) {
		this.haStatNm = haStatNm;
	}
	public String getExeType() {
		return exeType;
	}
	public void setExeType(String exeType) {
		this.exeType = exeType;
	}
	public String getExeStatCd() {
		return exeStatCd;
	}
	public void setExeStatCd(String exeStatCd) {
		this.exeStatCd = exeStatCd;
	}
	public String getProcssStatCd() {
		return procssStatCd;
	}
	public void setProcssStatCd(String procssStatCd) {
		this.procssStatCd = procssStatCd;
	}
	public String getHaGrpNm() {
		return haGrpNm;
	}
	public void setHaGrpNm(String haGrpNm) {
		this.haGrpNm = haGrpNm;
	}
	public String getHaGrpId() {
		return haGrpId;
	}
	public void setHaGrpId(String haGrpId) {
		this.haGrpId = haGrpId;
	}
	public Integer getReqMaxMemAsgnCapa() {
		return reqMaxMemAsgnCapa;
	}
	public void setReqMaxMemAsgnCapa(Integer reqMaxMemAsgnCapa) {
		this.reqMaxMemAsgnCapa = reqMaxMemAsgnCapa;
	}
	public Integer getReqMaxCpuVcoreQty() {
		return reqMaxCpuVcoreQty;
	}
	public void setReqMaxCpuVcoreQty(Integer reqMaxCpuVcoreQty) {
		this.reqMaxCpuVcoreQty = reqMaxCpuVcoreQty;
	}
	public Integer getReqMinMemAsgnCapa() {
		return reqMinMemAsgnCapa;
	}
	public void setReqMinMemAsgnCapa(Integer reqMinMemAsgnCapa) {
		this.reqMinMemAsgnCapa = reqMinMemAsgnCapa;
	}
	public Integer getReqMinCpuVcoreQty() {
		return reqMinCpuVcoreQty;
	}
	public void setReqMinCpuVcoreQty(Integer reqMinCpuVcoreQty) {
		this.reqMinCpuVcoreQty = reqMinCpuVcoreQty;
	}
	public BigDecimal getReqEntMinVl() {
		return reqEntMinVl;
	}
	public void setReqEntMinVl(BigDecimal reqEntMinVl) {
		this.reqEntMinVl = reqEntMinVl;
	}
	public BigDecimal getReqEntMaxVl() {
		return reqEntMaxVl;
	}
	public void setReqEntMaxVl(BigDecimal reqEntMaxVl) {
		this.reqEntMaxVl = reqEntMaxVl;
	}
	public BigDecimal getReqEntDfltVl() {
		return reqEntDfltVl;
	}
	public void setReqEntDfltVl(BigDecimal reqEntDfltVl) {
		this.reqEntDfltVl = reqEntDfltVl;
	}
	public String getVmStopYn() {
		return vmStopYn;
	}
	public void setVmStopYn(String vmStopYn) {
		this.vmStopYn = vmStopYn;
	}
	public String getHaCompYn() {
		return haCompYn;
	}
	public void setHaCompYn(String haCompYn) {
		this.haCompYn = haCompYn;
	}
	public String getReqStrgAsgnPolicyCd() {
		return reqStrgAsgnPolicyCd;
	}
	public void setReqStrgAsgnPolicyCd(String reqStrgAsgnPolicyCd) {
		this.reqStrgAsgnPolicyCd = reqStrgAsgnPolicyCd;
	}

}
