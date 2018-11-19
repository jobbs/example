/**
 	* copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcReqPopCallController.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 11.
 * @lastmodified 2016. 10. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 11.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.web;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.config.OprConstant;
import ncis.cmn.exception.CommonException;
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.service.CommonService;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.catalg.service.TmplatService;
import ncis.cpt.opr.catalg.vo.TmplatSvo;
import ncis.cpt.opr.ip.vo.IpBndSearchVo;
import ncis.cpt.opr.ip.vo.IpBndVo;
import ncis.cpt.opr.ip.vo.IpSearchVo;
import ncis.cpt.opr.ip.vo.IpVo;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqMngService;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqNetwkService;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqPhyRsrcService;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqProcssService;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqVmService;
import ncis.cpt.opr.req.rsrcreq.vo.ProcssInstVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqDtlVmVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqVo;
import ncis.cpt.opr.req.rsrcreq.vo.UnitJobProcssSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.UnitJobProcssVo;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.com.service.PmService;
import ncis.cpt.rsrc.com.vo.PmSearchVo;
import ncis.cpt.rsrc.com.vo.PmVo;
import ncis.cpt.rsrc.pool.service.RsrcPoolService;
import ncis.cpt.rsrc.strg.vo.VrStrgSearchVo;
import ncis.cpt.rsrc.strg.vo.VrStrgVo;
import ncis.cpt.rsrc.zone.service.NetService;
import ncis.cpt.rsrc.zone.service.RegionService;
import ncis.cpt.sys.code.vo.CodeSearchVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.cpt.sys.instt.service.InsttService;
import ncis.cpt.sys.zone.service.ZoneMngService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 자원요청관리-팝업 호출  관리
 * @author 김봉민
 *
 */
@Controller
@RequestMapping(value="/cpt/opr/req/rsrcreq")
public class RsrcReqPopCallController extends BaseController{

	private final Logger logger = LoggerFactory.getLogger(RsrcReqPopCallController.class);

	@Resource(name="rsrcReqVmService")
	private RsrcReqVmService rsrcReqVmService;

	@Resource(name="rsrcReqPhyRsrcService")
	private RsrcReqPhyRsrcService rsrcReqPhyRsrcService;

	@Resource(name="rsrcReqNetwkService")
	private RsrcReqNetwkService rsrcReqNetwkService;

	@Resource(name="rsrcReqMngService")
	private RsrcReqMngService rsrcReqMngService;

	@Resource(name="commonService")
	protected CommonService commonService;

	@Resource(name = "pmService")
	protected PmService pmService;

    @Resource(name = "rsrcPoolService")
    protected RsrcPoolService rsrcPoolService;


	@Resource(name="tmplatService")
	private TmplatService tmplatService;

	@Resource(name="regionService")
	private RegionService regionService;

	@Resource(name="zoneMngService")
	private ZoneMngService zoneMngService;

	@Resource(name="netService")
	private NetService netService;

	@Resource(name="insttService")
	private InsttService insttService;

	@Resource(name="rsrcReqProcssService")
	private RsrcReqProcssService rsrcReqProcssService;


	/**
	 * IP 주소 선택 (미할당 IP중 선택) 팝업
	 * @param request
	 * @param model
	 * @param useGvDprtId	기간 ID
	 * @param prposCd		용도 코드
	 * @param nicPrposCd	nic 용도 코드
	 * @param netId			net id
	 * @return
	 */
	@RequestMapping("/selectRsrcReqIpAddrP.do")
	public String selectRsrcReqIpAddrPView(HttpServletRequest request, Model model, IpBndSearchVo searchVo){
		List<IpBndVo> resultIpBndList = rsrcReqVmService.selectIpBndList(searchVo);	//IP대역정보 목록
		List<IpVo> resultUnasgnIpList = null; 	//미할당IP 목록
		if(resultIpBndList != null && resultIpBndList.size()>0){
			IpSearchVo ipSearchVo = new IpSearchVo();
			ipSearchVo.setNatYn(searchVo.getNatYn());
			if(searchVo.getBndSeq()==null){
				ipSearchVo.setBndSeq(resultIpBndList.get(0).getBndSeq());	//선택된 것이 없을 경우 최초 값을 선택으로 한다.
			}else{
				ipSearchVo.setBndSeq(searchVo.getBndSeq());
			}

			if(searchVo.getBndSeq()==null){
				searchVo.setSearchBndSeq(resultIpBndList.get(0).getBndSeq());
			}

			resultUnasgnIpList = rsrcReqVmService.selectUnasgnIpList(ipSearchVo);
		}

		//title
		model.addAttribute("title", "IP 주소 선택");
		// 센터
		model.addAttribute("regionVo", regionService.selectRegion(searchVo.getSearchRegion()) );
		//망구분
		model.addAttribute("netCodeVo", commonService.selectCode(searchVo.getNetClCd(), "067"));
		//기관 정보
		model.addAttribute("insttVo", insttService.selectInstt(searchVo.getInstitutionId()));
		//용도
		model.addAttribute("prposCodeVo", commonService.selectCode( searchVo.getPrposClCd(), "019"));
		//IP대역정보 목록
		model.addAttribute("ipBndList", resultIpBndList);
		//미할당IP 목록
		model.addAttribute("unasgnIpList", resultUnasgnIpList);
		model.addAttribute("searchVo", searchVo);
		return popup(request, "selectRsrcReqIpAddrP");
	}


	/**
	 * 물리서버 선택 팝업
	 * @param request
	 * @param model
	 * @param institutionId
	 * @param regionId
	 * @param zoneId
	 * @param netId
	 * @return
	 */
	@RequestMapping("/selectRsrcReqPhySrvrP.do")
	public String selectRsrcReqPhySrvrPView(HttpServletRequest request, Model model, PmSearchVo pmSearchVo){
		 if(pmSearchVo.getSearchVrCnvrSwTyCd() != null && !pmSearchVo.getSearchVrCnvrSwTyCd().equals("")){
			 String[] searchVrlzSwTyCdList =  {pmSearchVo.getSearchVrCnvrSwTyCd()} ;
			pmSearchVo.setSearchVrlzSwTyCdList(searchVrlzSwTyCdList);
		 }

		pmSearchVo.setSearchDelYn("N"); // 삭제 여부
        List<PmVo> pmVoList = pmService.selectPmList(pmSearchVo, false);
        List<CodeVo> vrlzSwTyCdList = commonService.selectCodeList(ComConstant.VRLZ_SW_TY_GRP_CD, ComConstant.VRLZ_SW_TY_PARENT_CD); // 가상화SW 코드
    	List<CodeVo> statCdList = commonService.selectCodeList(ComConstant.PM_GRP_STAT_GRP_CD, ComConstant.PM_GRP_STAT_PARENT_CD, true); // 물리서버상태 코드

        model.addAttribute("vrlzSwTyCdList", vrlzSwTyCdList);
        model.addAttribute("statCdList", statCdList);
        model.addAttribute("pmVoList", pmVoList);
        model.addAttribute("pmSearchVo", pmSearchVo);

        model.addAttribute("title","물리서버 선택");
		return popup(request, "selectRsrcReqPhySrvrP");
	}

	/**
	 * 가상 스토리지 선택
	 * @param request
	 * @param model
	 * @param institutionId
	 * @param regionId
	 * @param zoneId
	 * @param netId
	 * @return
	 */
	@RequestMapping("/selectRsrcReqStrgP.do")
	public String selectRsrcReqStrgPView(HttpServletRequest request, Model model, VrStrgSearchVo searchVo){

		searchVo.setPaginationInfo(null);
		List<VrStrgVo> list = this.rsrcReqVmService.selectVrStrgList(searchVo);

		model.addAttribute("title","스토리지 선택");
		model.addAttribute("searchVo" , searchVo);
		model.addAttribute("list" , list);

		return popup(request, "selectRsrcReqStrgP");
	}

	/**
	 * 템플릿 조회
	 * @param request
	 * @param model
	 * @param institutionId
	 * @return
	 */
	@RequestMapping("/selectRsrcReqTmplatP.do")
	public String selectRsrcReqTemplatePView(HttpServletRequest request, Model model, TmplatSvo searchVo){

		searchVo.setPaginationInfo(null);

		model.addAttribute("title","템플릿 선택");
		model.addAttribute("regionVo", zoneMngService.selectRegion(searchVo.getRegionId()));
		model.addAttribute("netClVo", commonService.selectCode(searchVo.getNetClCd(), "067"));
		model.addAttribute("osTyCd", commonService.selectCode(searchVo.getOsTyCd(), "003"));
		model.addAttribute("prpos", commonService.selectCode(searchVo.getPrposCd(), "019"));
		model.addAttribute("list", tmplatService.selectRrVmTmplatList(searchVo));
		model.addAttribute("searchVo", searchVo);
		return popup(request, "selectRsrcReqTmplatP");
	}

	/**
	 * 실행내역조회 팝업
	 * @param request
	 * @param model
	 * @param institutionId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/selectRsrcReqExeListP.do")
	public String selectRsrcReqExeListPView(HttpServletRequest request, Model model , UnitJobProcssSearchVo searchVo) throws Exception{
		try{
			RsrcReqVo rrVo = this.rsrcReqMngService.selectRsrcReqDtl(searchVo.getRsrcReqNo());
			BigDecimal procssInstSeq = rrVo.getProcssInstSeq();

			if(procssInstSeq == null  ){
				throw new CommonException("진행중인 프로세스 인스턴스가 없습니다.");
			}

			searchVo.setProcssInstSeq(procssInstSeq);
			ProcssInstVo procssInstVo =this.rsrcReqProcssService.selectProcssInst(procssInstSeq);
			//조회를 위한 설정
			List<UnitJobProcssVo> list =  rsrcReqProcssService.selectUnitJobProcssList(procssInstSeq);

			model.addAttribute("title","실행내역조회");
			model.addAttribute("searchVo", searchVo);
			model.addAttribute("rsrcReqgVo", rrVo);
			model.addAttribute("procssInstVo", procssInstVo);
			model.addAttribute("list", list);
			return popup(request, "selectRsrcReqExeListP");

		}catch(Exception e){
			throw e;
		}
	}

	/**
	 * 마이크레이션 진행 내역 조회 팝업(프로세스 인스턴스 SEQ)
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/selectRsrcReqExeListMigrP.do")
	public String selectRsrcReqExeListMigrPView(HttpServletRequest request, Model model , UnitJobProcssSearchVo searchVo) throws Exception{
		try{
			BigDecimal procssInstSeq = searchVo.getProcssInstSeq();
			if(procssInstSeq == null  ){
				throw new Exception("진행중인 프로세스 인스턴스가 없습니다.");
			}

			ProcssInstVo procssInstVo =this.rsrcReqProcssService.selectProcssInst(procssInstSeq);
			//조회를 위한 설정
			List<UnitJobProcssVo> list =  rsrcReqProcssService.selectUnitJobProcssList(procssInstSeq);

			UnitJobProcssVo info = null;
			if(list != null && list.size()>0){
				info = list.get(0);
			}

			model.addAttribute("title","실행내역조회");
			model.addAttribute("searchVo", searchVo);
			model.addAttribute("info", info );
			model.addAttribute("procssInstVo", procssInstVo);
			model.addAttribute("list", list);
			return popup(request, "selectRsrcReqExeListMigrP");
		}catch(Exception e){
			throw e;
		}
	}

	/**
	 * 진행 내역 조회 - reflash
	 * @param request
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectRsrcReqExeListPSub.do", method = RequestMethod.POST)
    @ResponseBody
	public ProcResultVo selectRsrcReqExeListPSubView(UnitJobProcssSearchVo searchVo) {
		try {
			List<UnitJobProcssVo> list =  rsrcReqProcssService.selectUnitJobProcssList(searchVo.getProcssInstSeq());
            return getSuccessProcResult("success", "select",  list);
        } catch (Exception e) {
        	logger.error(e.getMessage(),e);
            return getFailProcResult("error");
        }
	}

	/**
	 * 진행 내역 조회(Header) - reflash
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value = "/selectRsrcReqExeListPSubHeader.do", method = RequestMethod.POST)
    @ResponseBody
	public ProcResultVo selectRsrcReqExeListPSubHeaderView(UnitJobProcssSearchVo searchVo){
		try{
			RsrcReqVo rrVo = this.rsrcReqMngService.selectRsrcReqDtl(searchVo.getRsrcReqNo());
	        return getSuccessProcResult("success", "select",  rrVo);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			return getFailProcResult("error");
		}
	}

	/**
	 * 자원요청반려 팝업
	 * @param request
	 * @param model
	 * @param rsrcReqNo  - 자원요청번호
	 * @param rsrcReqTyCd - 자원요청구분코드
	 * @return
	 */
	@RequestMapping("/selectRsrcReqRjctP.do")
	public String selectRsrcReqRjctPView(HttpServletRequest request, Model model,@RequestParam("rsrcReqNo") String rsrcReqNo
			, @RequestParam("rsrcReqSeq") BigDecimal rsrcReqSeq
			, @RequestParam("rsrcReqTyCd") String rsrcReqTyCd ) {
		CodeSearchVo searchVo = new CodeSearchVo();

		final String RJCT_CODE_PARENT_CD= "108";			//반려 상태 코드
		searchVo.setSearchParentCd(RJCT_CODE_PARENT_CD);
		List<CodeVo> codeList = commonService.selectCodeList(searchVo);

		RsrcReqVo rsrcReqVo = new RsrcReqVo();
		rsrcReqVo.setRsrcReqNo(rsrcReqNo);
		rsrcReqVo.setRsrcReqSeq(rsrcReqSeq);
		rsrcReqVo.setRsrcReqTyCd(rsrcReqTyCd);

		model.addAttribute("title", "자원요청반려");
		model.addAttribute("rsrcReqVo", rsrcReqVo);
		model.addAttribute("codeList",codeList );
		return popup(request, "selectRsrcReqRjctP");
	}




	/**
	 * 프로세스 진행상태를 진행중으로 변경
	 * @param rsrcReqPhyRsrcVo
	 * @param bindResult
	 * @return
	 */

	@RequestMapping(value="/updateRsrcReqProcssJobStat.do", method=RequestMethod.POST)
	@OperateLog(action="재처리", desc="재처리", params={"procssInstSeq", "procssJobInstSeq"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateRsrcReqReProcssJobStat(HttpServletRequest request, @ModelAttribute("unitJobProcssVo") UnitJobProcssVo unitJobProcssVo) throws Exception{
		ProcResultVo result = new ProcResultVo();
		try {
			rsrcReqProcssService.updateUnitProcssJobStat(unitJobProcssVo); //단위업무 상태를 진행중으로 변경
			result.setProcType(OprConstant.RSRC_PROC_TYPE_UPDATA);
			result.addMessage(OprConstant.RSRC_EXEC_SUCC_MSG);
			result.setSuccess(true);
			return result;
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
			result.setSuccess(false);
			result.addMessage(OprConstant.RSRC_EXEC_FAIL_MSG);
		}
		return result;
	}


	/**
	 * 프로세스 실행 취소
	 * @param rsrcReqPhyRsrcVo
	 * @param bindResult
	 * @return
	 */

	@RequestMapping(value="/updateRsrcReqProcssCancel.do", method=RequestMethod.POST)
	@OperateLog(action="프로세스실행 취소", desc="프로세스실행취소", params={"procssInstSeq", "procssJobInstSeq"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateRsrcReqProcssCancel(HttpServletRequest request, @ModelAttribute("unitJobProcssVo") UnitJobProcssVo unitJobProcssVo) throws Exception{
		ProcResultVo result = new ProcResultVo();
		try {
			if(unitJobProcssVo.getRsrcReqNo() != null){
				logger.debug("자원요청 정보가 있을 경우 연계를 통한 취소를 요청한다. [No:"+unitJobProcssVo.getRsrcReqNo()+"]");
				reqCancelExeTyk(unitJobProcssVo);
			}

			rsrcReqProcssService.updateRsrcReqProcssCancel(unitJobProcssVo, getUserId()); //단위업무 상태를 진행중으로 변경
			result.setProcType(OprConstant.RSRC_PROC_TYPE_UPDATA);
			result.addMessage(OprConstant.RSRC_EXEC_SUCC_MSG);
			result.setSuccess(true);
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
			result.setSuccess(false);
			result.addMessage(OprConstant.RSRC_EXEC_FAIL_MSG+"\n-"+e.getMessage());
		}
		return result;
	}

	/**
	 * TYK 요청 취소 (연계)
	 * @param vmVo
	 */
	private void reqCancelExeTyk(UnitJobProcssVo unitJobProcssVo){
		try{
			RsrcReqVo rrVo =this.rsrcReqMngService.selectRsrcReqDtlPoolInfo(unitJobProcssVo.getRsrcReqNo());

			if(rrVo.getUuid() == null){
				throw new Exception("장치 식별ID가 존재하지 않습니다.");
			}

			this.rsrcReqVmService.updateRsrcReqCancelExecInfo( rrVo.getRegionId(),  rrVo.getZoneId(),  rrVo.getNetClCd(), rrVo.getRsrcPoolId(), rrVo.getUuid());
		}catch(Exception e){
			logger.error(e.getMessage());
		}
   	}

	@RequestMapping(value="/updateRsrcReqProcssManualComplete.do", method=RequestMethod.POST)
	@OperateLog(action="프로세스실행 깅제완료", desc="프로세스실행 강제완료", params={"procssInstSeq", "procssJobInstSeq"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateRsrcReqProcssManualComplete(HttpServletRequest request, @ModelAttribute("unitJobProcssVo") UnitJobProcssVo unitJobProcssVo) throws Exception{
		ProcResultVo result = new ProcResultVo();
		try{
			this.rsrcReqProcssService.updateRsrcReqProcssManualComplete(unitJobProcssVo, unitJobProcssVo.getRmk() , getUser());
			result.setProcType(OprConstant.RSRC_PROC_TYPE_UPDATA);
			result.addMessage(OprConstant.RSRC_EXEC_SUCC_MSG);
			result.setSuccess(true);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			result.setSuccess(false);
			result.addMessage(OprConstant.RSRC_EXEC_FAIL_MSG+"\n-"+e.getMessage());
		}
		return result;
	}

	@RequestMapping(value="/updateRsrcReqAllManualComplete.do", method=RequestMethod.POST)
	@OperateLog(action="자원요청 강제완료", desc="자원요청 강제완료", params={"procssInstSeq", "procssJobInstSeq"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateRsrcReqAllManualComplete(HttpServletRequest request, @ModelAttribute("unitJobProcssVo") UnitJobProcssVo unitJobProcssVo) throws Exception{
		ProcResultVo result = new ProcResultVo();
		try{
			this.rsrcReqProcssService.updateRsrcReqAllManualComplete(unitJobProcssVo, unitJobProcssVo.getRmk() , getUser());
			result.setProcType(OprConstant.RSRC_PROC_TYPE_UPDATA);
			result.addMessage(OprConstant.RSRC_EXEC_SUCC_MSG);
			result.setSuccess(true);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			result.setSuccess(false);
			result.addMessage(OprConstant.RSRC_EXEC_FAIL_MSG+"\n-"+e.getMessage());
		}
		return result;
	}


	/**
	 * 가상서버생성 요청정보 실행
	 * @param rsrcReqPhyRsrcVo
	 * @param bindResult
	 * @return
	 */

	@RequestMapping(value="/manualVmCreExec.do", method=RequestMethod.POST)
	@OperateLog(action="가상서버 생성정보 수정", desc="가상서버 생성처리 호출", params={"rsrcReqType", "rsrcReqNo"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo manualVmCreExec(HttpServletRequest request, @RequestParam(required=true) String rsrcReqNo , @RequestParam(required=true) String rsrcReqType ) throws Exception{
		ProcResultVo result = new ProcResultVo();
		String resultMsg = OprConstant.RSRC_EXEC_SUCC_MSG;
		try {

			if(OprConstant.RSRC_REQ_TY_CD_VM_CRE.equals(rsrcReqType) )
			{
				RsrcReqDtlVmVo rsrcReqDtlVmVo = rsrcReqVmService.selectRsrcReqVmCre(rsrcReqNo);

				if(null == rsrcReqDtlVmVo.getVmId() && !"N".equals(rsrcReqDtlVmVo.getVmIdAutoYn()) ) { //가상서버 ID 자동생성일 경우
					String seqNum = ""; //가상서버 채번
					String vmId = rsrcReqDtlVmVo.getVmId()+"_";
					// 채번정보를(순번3자리) 조회하여 가상서버ID를 구성한다. (가상서버ID : 부처ID 앞3자리 + 망구분코드 + 업무ID 앞3자리 + 용도명 앞1자리 + 순번3자리)
					seqNum = commonService.selectSeqNum("RC_VM", vmId);
					rsrcReqDtlVmVo.setVmId(seqNum);
				}

				rsrcReqDtlVmVo.setExeUserId(getUserId()); //실행자ID

				resultMsg = OprConstant.RSRC_MANUAL_EXEC_SUCC_MSG;
				if(null == rsrcReqDtlVmVo.getHaYn() && !"N".equals(rsrcReqDtlVmVo.getHaYn()) )
				{
					rsrcReqVmService.updateRsrcReqHaVmCreInfoForManaul(rsrcReqDtlVmVo); //자원요청상세 VM생성정보 수동완료 업데이트
				}
				else
				{
					rsrcReqVmService.updateRsrcReqVmCreInfoForManaul(rsrcReqDtlVmVo); //자원요청상세 VM생성정보 수동완료 업데이트
				}
			}
			else if(OprConstant.RSRC_REQ_TY_CD_VM_DEL.equals(rsrcReqType)
					|| OprConstant.RSRC_REQ_TY_CD_VM_SPEC_CHNG.equals(rsrcReqType)
					|| OprConstant.RSRC_REQ_TY_CD_VM_STRG_ADD.equals(rsrcReqType))
			{
				RsrcReqDtlVmVo rsrcReqDtlVmVo = rsrcReqVmService.selectRsrcReqVmSpecChng(rsrcReqNo);
				rsrcReqDtlVmVo.setExeUserId(getUserId()); //실행자ID

				resultMsg = OprConstant.RSRC_MANUAL_EXEC_SUCC_MSG;
				rsrcReqVmService.updateRsrcReqSpecChngInfoForManaul(rsrcReqDtlVmVo); //자원요청상세 VM생성정보 수동완료 업데이트
			}


			result.setProcType(OprConstant.RSRC_PROC_TYPE_UPDATA);
			result.addMessage(resultMsg);
			result.setSuccess(true);
			return result;
		}catch(DataNotFoundException e1) {
			logger.error(e1.getMessage(),e1);
			result.setSuccess(false);
			result.addMessage(e1.getMessage());
		}catch(NullPointerException e2) {
			logger.error(e2.getMessage(),e2);
			result.setSuccess(false);
			result.addMessage(OprConstant.RSRC_EXEC_PM_NULL_MSG);
		}catch(RuntimeException re) {
			logger.error(re.getMessage(),re);
			result.setSuccess(false);
			result.addMessage(re.getMessage());
		}
		catch(Exception e3) {
			logger.error(e3.getMessage(),e3);
			result.setSuccess(false);
			result.addMessage(OprConstant.RSRC_EXEC_FAIL_MSG);
		}
		return result;
	}
}
