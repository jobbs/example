package ncis.cpt.opr.req.rsrcreq.vo;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

public class RsrcReqMngVo{

	private String rsrcReqNo;  /* 자원요청번호 */
	private String rsrcReqUsrId;  /* 자원요청자ID */
	private String rsrcReqUsrNm;  /* 자원요청자명 */
	private String rsrcReqDttm;  /* 자원요청일시 */
	private String rsrcReqPrcssStatCd;  /* 자원요청진행상태코드 */
	private String rsrcReqPrcssStatNm;  /* 자원요청진행상태명 */
	private String reqInstitutionId;  /* 요청기관ID */
	private String reqInstitutionNm;  /* 요청기관명 */
	private String reqDeptId;  /* 요청부서ID */
	private String sbjct;  /* 제목 */
	private String ticktNo;  /* 티켓번호 */
	private String regionId;  /* 리전ID */
	private String regionNm;  /* 리전명 */
	private String testYn;  /* 테스트여부 */
	private String linkYn;  /* 연계여부 */
	private String comptDttm;  /* 완료일시 */
	private String regUserId;  /* 등록자ID */
	private String regDt;  /* 등록일자  */

	private BigDecimal rsrcReqSeq;  /* 자원요청일련번호 */
	private String rsrcReqCn;  /* 자원요청내용 */
	private String rsrcReqAreaClCd;  /* 자원요청영역구분코드 */
	private String procssInstSeq;  /* 프로세스인스턴스SEQ */
	private String exeUserId;  /* 실행자ID */
	private String exeUserNm;  /* 실행자명 */
	private String exeDttm;  /* 실행일시 */
	private String zoneId;  /* 존ID */
	private String netId;  /* 망ID */
	private String mngId;  /* 매니저ID */
	private String uuid;  /* UUID */
	private String rsrcReqTyCd;  /* 자원요청유형코드 */
	private String rsrcReqTyNm;  /* 자원요청유형명 */
	private String vmReqTyCd;  /* 가상서버요청유형코드 */
	private String vmId;  /* 가상서버ID */
	private String vmNm;  /* 가상서버명 */
	private String vmCompId;  /* 가상서버구성ID */
	private String hstNm;  /* 호스트명 */
	private String prposCd;  /* 용도코드 */
	private String useGvDprtId;  /* 사용부처ID */
	private String useJobId;  /* 사용업무ID */
	private String vrCnvrSwTyCd;  /* 가상화SW유형코드 */
	private String os;  /* 운영체계 */
	private String clstrId;  /* 클러스터ID */
	private String pmId;  /* 물리서버ID */
	private String rsrcPoolNm;  /* 자원풀명 */
	private String ipAddr;  /* IP주소 */
	private String osTyCd;  /* OS유형코드 */
	private String osNm;  /* OS명 */
	private String swId;  /* 소프트웨어ID */
	private String servcStrtDt;  /* 서비스시작일자 */
	private String servcEndDt;  /* 서비스종료일자 */
	private String reqCpuVcore;  /* 요청CPU(vCore) */
	private String reqMem;  /* 요청메모리(MB) */
	private String reqVrDskId;  /* 요청가상디스크ID */
	private String strgAsgnCapa;  /* 스토리지할당용량(GB) */
	private String atchFileId;  /* 첨부파일ID */
	private String rmk;  /* 비고 */
	private String reqSpecId;  /* 요청스펙ID */
	private String tmplatId;  /* 템플릿ID */
	private String vSrvrChngClCd;  /* 가상서버변경구분코드 */
	private String chngSpecId;  /* 변경전스펙ID */
	private String chngPreCpuQty;  /* 변경전CPU(vCore) */
	private String chngPreMemAsgnCapa;  /* 변경전메모리할당량(MB) */
	private String chngPreSpecId;  /* 변경후스펙ID */
	private String chngPostCpuQty;  /* 변경후CPU(vCore) */
	private String chngPostMemAsgnCapa;  /* 변경후메모리할당량(MB) */
	private String strgAsgnReqCapa;  /* 스토리지할당요청량(GB) */
	private String asgnVrDskId;  /* 할당가상디스크ID */
	private String shareYn;  /* 공유여부  */
	private String arrayRsrcReqNo;  /* 배열자원요청번호  */
	private String haVmNm;  /* HA가상서버명  */
	private String haGrpCd;  /* HA그룹코드  */
	private String haCompYn;  /* HA구성여부  */
	private String delUserId; /* 삭제자ID  */
	private String rsrcReqClCd;  /* 자원요청구분코드 */
	private String rsrcReqMobile; /* 요청자핸드폰번호 */
	private String rsrcReqEmail; /* 요청자이메일 */
	private String rsrcReqClNm;  /* 자원요청구분명 */
	private String rsrcReqUserId;  /* 자원요청자ID */
	private String rsrcReqUserNm;  /* 자원요청자ID */
	private String reqCn;  /* 요청내용 */
	private String savAtchFileNm;  /* 저장첨부파일명 */
	private String oriAtchFileNm;  /* 원본첨부파일명 */
	private String atchFilePath;  /* 첨부파일경로 */
	private long atchFileSize;  /* 첨부파일크기 */
	private MultipartFile uploadFile; /* 파일업로드정보 */
	private String regUserNm; /* 등록자명 */


	private RsrcReqMngFileVo rsrcReqMngFileVo;

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
	public BigDecimal getRsrcReqSeq() {
		return rsrcReqSeq;
	}
	public void setRsrcReqSeq(BigDecimal rsrcReqSeq) {
		this.rsrcReqSeq = rsrcReqSeq;
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
	public String getProcssInstSeq() {
		return procssInstSeq;
	}
	public void setProcssInstSeq(String procssInstSeq) {
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
	public String getMngId() {
		return mngId;
	}
	public void setMngId(String mngId) {
		this.mngId = mngId;
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
	public String getPrposCd() {
		return prposCd;
	}
	public void setPrposCd(String prposCd) {
		this.prposCd = prposCd;
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
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getClstrId() {
		return clstrId;
	}
	public void setClstrId(String clstrId) {
		this.clstrId = clstrId;
	}

	public String getPmId() {
		return pmId;
	}
	public void setPmId(String pmId) {
		this.pmId = pmId;
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
	public String getReqCpuVcore() {
		return reqCpuVcore;
	}
	public void setReqCpuVcore(String reqCpuVcore) {
		this.reqCpuVcore = reqCpuVcore;
	}
	public String getReqMem() {
		return reqMem;
	}
	public void setReqMem(String reqMem) {
		this.reqMem = reqMem;
	}
	public String getReqVrDskId() {
		return reqVrDskId;
	}
	public void setReqVrDskId(String reqVrDskId) {
		this.reqVrDskId = reqVrDskId;
	}
	public String getStrgAsgnCapa() {
		return strgAsgnCapa;
	}
	public void setStrgAsgnCapa(String strgAsgnCapa) {
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
	public String getReqSpecId() {
		return reqSpecId;
	}
	public void setReqSpecId(String reqSpecId) {
		this.reqSpecId = reqSpecId;
	}
	public String getTmplatId() {
		return tmplatId;
	}
	public void setTmplatId(String tmplatId) {
		this.tmplatId = tmplatId;
	}
	public String getvSrvrChngClCd() {
		return vSrvrChngClCd;
	}
	public void setvSrvrChngClCd(String vSrvrChngClCd) {
		this.vSrvrChngClCd = vSrvrChngClCd;
	}
	public String getChngSpecId() {
		return chngSpecId;
	}
	public void setChngSpecId(String chngSpecId) {
		this.chngSpecId = chngSpecId;
	}
	public String getChngPreCpuQty() {
		return chngPreCpuQty;
	}
	public void setChngPreCpuQty(String chngPreCpuQty) {
		this.chngPreCpuQty = chngPreCpuQty;
	}
	public String getChngPreMemAsgnCapa() {
		return chngPreMemAsgnCapa;
	}
	public void setChngPreMemAsgnCapa(String chngPreMemAsgnCapa) {
		this.chngPreMemAsgnCapa = chngPreMemAsgnCapa;
	}
	public String getChngPreSpecId() {
		return chngPreSpecId;
	}
	public void setChngPreSpecId(String chngPreSpecId) {
		this.chngPreSpecId = chngPreSpecId;
	}
	public String getChngPostCpuQty() {
		return chngPostCpuQty;
	}
	public void setChngPostCpuQty(String chngPostCpuQty) {
		this.chngPostCpuQty = chngPostCpuQty;
	}
	public String getChngPostMemAsgnCapa() {
		return chngPostMemAsgnCapa;
	}
	public void setChngPostMemAsgnCapa(String chngPostMemAsgnCapa) {
		this.chngPostMemAsgnCapa = chngPostMemAsgnCapa;
	}
	public String getStrgAsgnReqCapa() {
		return strgAsgnReqCapa;
	}
	public void setStrgAsgnReqCapa(String strgAsgnReqCapa) {
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
	public String getHaVmNm() {
		return haVmNm;
	}
	public void setHaVmNm(String haVmNm) {
		this.haVmNm = haVmNm;
	}
	public String getHaGrpCd() {
		return haGrpCd;
	}
	public void setHaGrpCd(String haGrpCd) {
		this.haGrpCd = haGrpCd;
	}
	public String getHaCompYn() {
		return haCompYn;
	}
	public void setHaCompYn(String haCompYn) {
		this.haCompYn = haCompYn;
	}
	public String getArrayRsrcReqNo() {
		return arrayRsrcReqNo;
	}
	public void setArrayRsrcReqNo(String arrayRsrcReqNo) {
		this.arrayRsrcReqNo = arrayRsrcReqNo;
	}
	public String getDelUserId() {
		return delUserId;
	}
	public void setDelUserId(String delUserId) {
		this.delUserId = delUserId;
	}
	public String getRsrcReqClCd() {
		return rsrcReqClCd;
	}
	public void setRsrcReqClCd(String rsrcReqClCd) {
		this.rsrcReqClCd = rsrcReqClCd;
	}
	public String getRsrcReqClNm() {
		return rsrcReqClNm;
	}
	public void setRsrcReqClNm(String rsrcReqClNm) {
		this.rsrcReqClNm = rsrcReqClNm;
	}
	public String getRsrcReqUserId() {
		return rsrcReqUserId;
	}
	public void setRsrcReqUserId(String rsrcReqUserId) {
		this.rsrcReqUserId = rsrcReqUserId;
	}
	public String getReqCn() {
		return reqCn;
	}
	public void setReqCn(String reqCn) {
		this.reqCn = reqCn;
	}
	public String getSavAtchFileNm() {
		return savAtchFileNm;
	}
	public void setSavAtchFileNm(String savAtchFileNm) {
		this.savAtchFileNm = savAtchFileNm;
	}
	public String getOriAtchFileNm() {
		return oriAtchFileNm;
	}
	public void setOriAtchFileNm(String oriAtchFileNm) {
		this.oriAtchFileNm = oriAtchFileNm;
	}
	public String getAtchFilePath() {
		return atchFilePath;
	}
	public void setAtchFilePath(String atchFilePath) {
		this.atchFilePath = atchFilePath;
	}
	public long getAtchFileSize() {
		return atchFileSize;
	}
	public void setAtchFileSize(long atchFileSize) {
		this.atchFileSize = atchFileSize;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public RsrcReqMngFileVo getRsrcReqMngFileVo() {
		return rsrcReqMngFileVo;
	}
	public void setRsrcReqMngFileVo(RsrcReqMngFileVo rsrcReqMngFileVo) {
		this.rsrcReqMngFileVo = rsrcReqMngFileVo;
	}
	public String getRsrcReqMobile() {
		return rsrcReqMobile;
	}
	public void setRsrcReqMobile(String rsrcReqMobile) {
		this.rsrcReqMobile = rsrcReqMobile;
	}
	public String getRsrcReqEmail() {
		return rsrcReqEmail;
	}
	public void setRsrcReqEmail(String rsrcReqEmail) {
		this.rsrcReqEmail = rsrcReqEmail;
	}
	public String getRsrcReqUserNm() {
		return rsrcReqUserNm;
	}
	public void setRsrcReqUserNm(String rsrcReqUserNm) {
		this.rsrcReqUserNm = rsrcReqUserNm;
	}
	public String getRegionNm() {
		return regionNm;
	}
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}
	public String getRegUserNm() {
		return regUserNm;
	}
	public void setRegUserNm(String regUserNm) {
		this.regUserNm = regUserNm;
	}

}
