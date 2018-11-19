package ncis.cpt.opr.req.rsrcreq.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.config.OprConstant;
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.service.CommonService;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqMngService;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqVmService;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqDtlVmVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqNetwkIntfcVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqVo;
import ncis.cpt.rsrc.com.service.VmService;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.cpt.rsrc.strg.service.VrDskService;
import ncis.cpt.rsrc.strg.vo.RsrcPoolVrStrgVo;
import ncis.cpt.rsrc.strg.vo.VrDskSearchVo;
import ncis.cpt.rsrc.strg.vo.VrDskVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.intfc.ntops.service.NtopsIntfcService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/cpt/opr/req/rsrcreq")
public class RsrcReqVmController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(RsrcReqVmController.class);
	//자원요청관리
	private final String RR_VM_CRE = "가상서버 생성요청";
	private final String RR_VM_SPEC_CHG = "가상서버 스펙변경요청";
	private final String RR_VM_DEL = "가상서버 삭제요청";
	private final String RR_VM_STRG_ADD = "가상서버 스토리지 추가요청";

	@Resource(name="rsrcReqVmService")
	RsrcReqVmService rsrcReqVmService;

	@Resource(name="rsrcReqMngService")
	RsrcReqMngService rsrcReqMngService;

	@Resource(name="commonService")
	CommonService commonService;

	@Resource(name = "vmService")
    VmService vmService;

	@Resource(name = "vrDskService")
	VrDskService vrDskService;

	@Resource(name = "ntopsIntfcService")
	private NtopsIntfcService ntopsService;


	/**
	 * 가상서버생성 요청정보 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectRsrcReqVmCre.do")
	public String selectRsrcReqVmCre(HttpServletRequest request, Model model, @RequestParam(required=true) String schRsrcReqNo) throws Exception {
		try {
			String addHB = "N";
			RsrcReqDtlVmVo rsrcReqVmCreInfo = rsrcReqVmService.selectRsrcReqVmCre(schRsrcReqNo);

			if( ObjectUtils.isEmpty(rsrcReqVmCreInfo) ) {
	            throw new DataNotFoundException(messageUtil.getMessage("message.error.dataNotFound"));
	        }

			// HA 가상서버 여부 조회
			List<RsrcReqDtlVmVo> rsrcReqHaVmList = rsrcReqVmService.selectHaCompList(schRsrcReqNo);
			if(rsrcReqHaVmList.size() >0) {
				rsrcReqVmCreInfo.setHaYn("Y");
				rsrcReqVmCreInfo.setHaStrgCapa(rsrcReqHaVmList.get(0).getHaStrgCapa());
				model.addAttribute("rsrcReqHaVmList", rsrcReqHaVmList);

				// HA 공통정보는 이미 설정완료된 정보로 셋팅한다.
				for(RsrcReqDtlVmVo haVo : rsrcReqHaVmList) {
					if("02".equals(haVo.getExeStatCd()) && rsrcReqVmCreInfo.getTmplatNm() == null) {
						RsrcReqDtlVmVo saveRsrcReqVmCreInfo = rsrcReqVmService.selectRsrcReqVmCreBaseInfo(haVo.getRsrcReqNo());
						rsrcReqVmCreInfo.setTmplatNm(saveRsrcReqVmCreInfo.getTmplatNm());
						rsrcReqVmCreInfo.setTmplatSeq(saveRsrcReqVmCreInfo.getTmplatSeq());
						rsrcReqVmCreInfo.setRsrcPoolId(saveRsrcReqVmCreInfo.getRsrcPoolId());
						rsrcReqVmCreInfo.setRsrcPoolInfo(saveRsrcReqVmCreInfo.getRsrcPoolInfo());
						rsrcReqVmCreInfo.setRsrcPoolNm(saveRsrcReqVmCreInfo.getRsrcPoolNm());
						rsrcReqVmCreInfo.setClstrNm(saveRsrcReqVmCreInfo.getClstrNm());
						rsrcReqVmCreInfo.setClstrSeq(saveRsrcReqVmCreInfo.getClstrSeq());
						rsrcReqVmCreInfo.setVrCnvrSwTyCd(saveRsrcReqVmCreInfo.getVrCnvrSwTyCd());
						rsrcReqVmCreInfo.setZoneId(saveRsrcReqVmCreInfo.getZoneId());
						rsrcReqVmCreInfo.setNetId(saveRsrcReqVmCreInfo.getNetId());
						rsrcReqVmCreInfo.setReqMaxCpuVcoreQty(saveRsrcReqVmCreInfo.getReqMaxCpuVcoreQty());
						rsrcReqVmCreInfo.setReqMaxMemAsgnCapa(saveRsrcReqVmCreInfo.getReqMaxMemAsgnCapa());
						rsrcReqVmCreInfo.setReqMinCpuVcoreQty(saveRsrcReqVmCreInfo.getReqMinCpuVcoreQty());
						rsrcReqVmCreInfo.setReqMinMemAsgnCapa(saveRsrcReqVmCreInfo.getReqMinMemAsgnCapa());
						rsrcReqVmCreInfo.setReqEntDfltVl(saveRsrcReqVmCreInfo.getReqEntDfltVl());
						rsrcReqVmCreInfo.setReqEntMaxVl(saveRsrcReqVmCreInfo.getReqEntMaxVl());
						rsrcReqVmCreInfo.setReqEntMinVl(saveRsrcReqVmCreInfo.getReqEntMinVl());
					}
				}
			}
			else {
				if(null != rsrcReqVmCreInfo.getPrposNm() && "DB".equals(rsrcReqVmCreInfo.getPrposNm())){
					if(null != rsrcReqVmCreInfo.getOsNm() && "HP-UX".equals(rsrcReqVmCreInfo.getOsNm())){
						addHB = "Y";
					}
				}
			}
			// 20170905 HA가 'N' 일 때, 용도가 DB이고, OS유형이 HP-UX 일 경우이면 Heartbeat를 정보를 추가해 줘야 함.
			// NetworkInterface 정보를 가져올 때, 추가적으로 변수 하나를 추가하여 조회하도록 함.
			List<RsrcReqNetwkIntfcVo> rsrcReqNetwkIntfcList = rsrcReqVmService.selectRsrcReqNetwkIntfcList(schRsrcReqNo, addHB);
//			rsrcReqVmCreInfo.setRsrcReqNetwkIntfc(rsrcReqNetwkIntfcList);
			if(addHB.equals("Y")){
				if(null != rsrcReqNetwkIntfcList && rsrcReqNetwkIntfcList.size() == 2){
					RsrcReqNetwkIntfcVo netwkIntfcVo = new RsrcReqNetwkIntfcVo();
					netwkIntfcVo.setNetwkIntfcId("Heartbeat"); //netwkIntfcId
					netwkIntfcVo.setNicPrposCd("03");//nicPrposCd
					netwkIntfcVo.setIpAddr("");//ipAddr
					netwkIntfcVo.setIpAutoAsgnYn("N");//ipAutoAsgnYn
					netwkIntfcVo.setNatYn("N");//natYn
					rsrcReqNetwkIntfcList.add(netwkIntfcVo);
				}
			}

			rsrcReqVmCreInfo.setRsrcReqNetwkIntfc(rsrcReqNetwkIntfcList);

			model.addAttribute("title",RR_VM_CRE);
			model.addAttribute("rsrcReqVmCreInfo", rsrcReqVmCreInfo);

		}
		catch(NullPointerException ne) { logger.error(ne.getMessage(), ne); }
		catch(RuntimeException re) { logger.error(re.getMessage(),re); }
		catch(Exception e) { logger.error(e.getMessage(),e); }

		return portalTilesView(request, "formRsrcReqVmCre");
	}

	/**
	 * 가상서버 설정을 위한 클러스터 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectClstrList.do")
	@ResponseBody
	public ProcResultVo selectClstrList(HttpServletRequest request, Model model, @RequestParam(required=true) String rsrcPoolId) throws Exception {
		ProcResultVo result = new ProcResultVo();
		List<RsrcReqDtlVmVo> list = rsrcReqVmService.selectClstrList(rsrcPoolId);
		result.setData(list);
		result.setSuccess(true);
		return result;
	}


	/**
	 * 가상서버생성 요청정보 실행
	 * @param rsrcReqPhyRsrcVo
	 * @param bindResult
	 * @return
	 */

	@RequestMapping(value="/formRsrcReqVmCreExec.do", method=RequestMethod.POST)
	@OperateLog(action="가상서버 생성정보 수정", desc="가상서버 생성처리 호출", params={"rsrcReqSeq", "rsrcReqNo"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo formRsrcReqVmCreExec(HttpServletRequest request, @ModelAttribute("rsrcReqVmCreInfo") RsrcReqDtlVmVo rsrcReqDtlVmVo) throws Exception{
		ProcResultVo result = new ProcResultVo();
		String resultMsg = OprConstant.RSRC_EXEC_SUCC_MSG;
		try {

			if(!"N".equals(rsrcReqDtlVmVo.getVmIdAutoYn()) ) { //가상서버 ID 자동생성일 경우
				String seqNum = ""; //가상서버 채번
				String vmId = rsrcReqDtlVmVo.getVmId()+"_";
				// 채번정보를(순번3자리) 조회하여 가상서버ID를 구성한다. (가상서버ID : 부처ID 앞3자리 + 망구분코드 + 업무ID 앞3자리 + 용도명 앞1자리 + 순번3자리)
				seqNum = commonService.selectSeqNum("RC_VM", vmId);
				rsrcReqDtlVmVo.setVmId(seqNum);
			}

			rsrcReqDtlVmVo.setExeUserId(getUserId()); //실행자ID

			//HA건일 경우
			if("Y".equals(rsrcReqDtlVmVo.getHaYn())) {
				if("M".equals(rsrcReqDtlVmVo.getExeType())) {
					rsrcReqVmService.updateRsrcReqHaVmCreInfoForManaul(rsrcReqDtlVmVo); //자원요청상세 VM생성정보 수동완료 업데이트
					resultMsg = OprConstant.RSRC_EXEC_SUCC_MSG;
				}
				else
				{
					rsrcReqVmService.updateRsrcReqHaVmCreInfo(rsrcReqDtlVmVo); //자원요청상세 HA VM생성정보 업데이트
					if("E".equals(rsrcReqDtlVmVo.getExeType()))
					{
						resultMsg = OprConstant.RSRC_EXEC_SUCC_MSG;
					}
					else
					{
						resultMsg = OprConstant.RSRC_SAVE_SUCC_MSG;
					}
				}

			}else {
				if("M".equals(rsrcReqDtlVmVo.getExeType())) {
					resultMsg = OprConstant.RSRC_MANUAL_EXEC_SUCC_MSG;
					rsrcReqVmService.updateRsrcReqVmCreInfoForManaul(rsrcReqDtlVmVo); //자원요청상세 VM생성정보 수동완료 업데이트
				}
				else
				{
					rsrcReqVmService.updateRsrcReqVmCreInfo(rsrcReqDtlVmVo); //자원요청상세 VM생성정보 업데이트
				}
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




		/**
		 * 가상서버생성 요청정보 실행
		 * @param rsrcReqPhyRsrcVo
		 * @param bindResult
		 * @return
		 */

		@RequestMapping(value="/resendResultToNtops.do", method=RequestMethod.POST)
		@OperateLog(action="처리결과 NTOPS 전송", desc="처리결과 NTOPS 전송", params={"rsrcReqSeq", "rsrcReqNo" , "rsrcReqTyCd"}, actionType=ActionType.UPDATE)
		@ResponseBody
		public ProcResultVo resendResultToNtopsExec(HttpServletRequest request, @RequestParam(required=true) String rsrcReqNo , @RequestParam(required=true) String rsrcReqTyCd ) throws Exception{
			ProcResultVo result = new ProcResultVo();
			try {
				boolean resultBool = false;
				if(OprConstant.RSRC_REQ_TY_CD_VM_CRE.equals(rsrcReqTyCd))
				{
					resultBool = ntopsService.sendVmCreateNTopsResult(rsrcReqNo);
				}
				else if(OprConstant.RSRC_REQ_TY_CD_VM_SPEC_CHNG.equals(rsrcReqTyCd) )
				{
					resultBool = ntopsService.sendVmSpecChangeNTopsResult(rsrcReqNo);
				}
				else if(OprConstant.RSRC_REQ_TY_CD_VM_STRG_ADD.equals(rsrcReqTyCd))
				{
					resultBool = ntopsService.sendVmStorageAddNTopsResult(rsrcReqNo);
				}
				else if(OprConstant.RSRC_REQ_TY_CD_VM_DEL.equals(rsrcReqTyCd))
				{
					resultBool = ntopsService.sendVmDeleteNTopsResult(rsrcReqNo);
				}


				result.setProcType(OprConstant.RSRC_PROC_TYPE_UPDATA);
				result.addMessage(OprConstant.RX_REQ_SUCC_MSG);

				if(!resultBool)
				{
					result.addMessage(OprConstant.RX_REQ_FAIL_MSG);
				}

				result.setSuccess(resultBool);

				return result;
			}catch(DataNotFoundException e1) {
				logger.error(e1.getMessage(),e1);
				result.setSuccess(false);
				result.addMessage(e1.getMessage());
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



	/**
	 * 가상서버생성 설정취소 실행
	 * @param rsrcReqPhyRsrcVo
	 * @param bindResult
	 * @return
	 */

	@RequestMapping(value="/formRsrcReqVmCancelExec.do", method=RequestMethod.POST)
	@OperateLog(action="가상서버 설정 수정", desc="가상서버 설정취소처리 호출", params={"rsrcReqSeq", "rsrcReqNo"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo formRsrcReqVmCancelExec(HttpServletRequest request, @ModelAttribute("rsrcReqVmCreInfo") RsrcReqDtlVmVo rsrcReqDtlVmVo) throws Exception{
		ProcResultVo result = new ProcResultVo();
		String resultMsg = OprConstant.RSRC_SAVE_CANCEL_SUCC_MSG;
		try {
			rsrcReqDtlVmVo.setExeUserId(getUserId()); //실행자ID
			rsrcReqVmService.updateRsrcReqHaVmInfoInit(rsrcReqDtlVmVo); //설정정보를 초기화
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



	/**
	 * 가상서버스펙변경 요청정보 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/formRsrcReqVmSpecChng.do")
	public String formRsrcReqVmSpecChng(HttpServletRequest request, Model model, @RequestParam(required=true) String schRsrcReqNo) throws Exception {

		try {
			RsrcReqDtlVmVo rsrcReqVmSpecChng = rsrcReqVmService.selectRsrcReqVmSpecChng(schRsrcReqNo); //스펙변경요청정보 조회

			VmSearchVo searchVo = new VmSearchVo();
			searchVo.setEqualsVmSeq(rsrcReqVmSpecChng.getVmSeq());
			searchVo.setAll(true);

			if(searchVo.getEqualsVmSeq()==null){
				throw new Exception("가상서버 SEQ가 존재하지 않습니다. [자원요청번호:"+ schRsrcReqNo+"]");
			}

			VmVo vmVo = vmService.selectVmByVmSearchVo(searchVo); //가상서버 상세정보 조회

			if(vmVo.getHaGrpId() != null) {
				rsrcReqVmSpecChng.setHaGrpId(vmVo.getHaGrpId());
			}

			// HA여부 조회 및 셋팅
			List<RsrcReqDtlVmVo> rsrcReqHaVmList = rsrcReqVmService.selectVmHaCompList(rsrcReqVmSpecChng);
			if(rsrcReqHaVmList.size() >0) {
				rsrcReqVmSpecChng.setHaCompYn("Y");
				model.addAttribute("rsrcReqHaVmList", rsrcReqHaVmList);
			}

			VrDskSearchVo vrDskSearchVo = new VrDskSearchVo();
			vrDskSearchVo.setSearchVmSeq(vmVo.getVmSeq());
			List<VrDskVo> vrDskList = vrDskService.selectVrDskList(vrDskSearchVo);
			List<RsrcPoolVrStrgVo> strgDmnList = rsrcReqVmService.selectStrgDmnList(vmVo.getRsrcPoolId());

			if(rsrcReqVmSpecChng.getVmChngClCd().equals("01")){
				model.addAttribute("title",RR_VM_SPEC_CHG);
			}else if(rsrcReqVmSpecChng.getVmChngClCd().equals("02")){
				model.addAttribute("title",RR_VM_STRG_ADD);
				model.addAttribute("vrDskListVo", vrDskList);
				model.addAttribute("strgDmnListVo", strgDmnList);
			}

			model.addAttribute("rsrcReqVmSpecChngInfo", rsrcReqVmSpecChng);
			if(rsrcReqVmSpecChng!=null && vmVo!=null) {
				model.addAttribute("vmVo", vmVo);
			}else {
				logger.error("가상서버정보가 없습니다. [가상서버SEQ: "+ searchVo.getEqualsVmSeq()+"]");
			}
			return portalTilesView(request, "formRsrcReqVmSpecChng");
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
			model.addAttribute("errormsg", e.getMessage());
			return portalTilesView(request, "viewRsrcReqError");
		}
	}


	/**
	 * 가상서버 스펙변경 요청정보 실행
	 * @param rsrcReqPhyRsrcVo
	 * @param bindResult
	 * @return
	 */

	@RequestMapping(value="/formRsrcReqVmSpecChngExec.do", method=RequestMethod.POST)
	@OperateLog(action="가상서버 스펙변경정보 수정", desc="가상서버 스펙변경처리 호출", params={"rsrcReqSeq", "rsrcReqNo"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo formRsrcReqVmSpecChngExec(HttpServletRequest request, @ModelAttribute("rsrcReqVmSpecChngInfo") RsrcReqDtlVmVo rsrcReqDtlVmVo) throws Exception{
		ProcResultVo result = new ProcResultVo();

		try {
			rsrcReqDtlVmVo.setExeUserId(getUserId()); //실행자ID

			if("M".equals(rsrcReqDtlVmVo.getExeType()) )
			{
				rsrcReqVmService.updateRsrcReqSpecChngInfoForManaul(rsrcReqDtlVmVo); //자원요청상세 VM스펙변경정보 수동완료
			}
			else
			{
				rsrcReqVmService.updateRsrcReqSpecChngInfo(rsrcReqDtlVmVo); //자원요청상세 VM스펙변경정보 업데이트
			}

			result.setProcType(OprConstant.RSRC_PROC_TYPE_UPDATA);
			result.addMessage(OprConstant.RSRC_EXEC_SUCC_MSG);
			result.setSuccess(true);
			return result;
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
			result.setSuccess(false);
			//result.addMessage(OprConstant.RSRC_EXEC_FAIL_MSG);
			result.addMessage(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value="/updateRsrcReqVmExe.do", method=RequestMethod.POST)
	@OperateLog(action="가상서버 스펙변경정보 삭제", desc="가상서버 스펙변경처리 삭제", params={"rsrcReqSeq", "rsrcReqNo"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateRsrcReqVmExe(@ModelAttribute("rsrcReqVmSpecChngInfo")  RsrcReqDtlVmVo rsrcReqDtlVmVo, BindingResult bindResult) {
		ProcResultVo result = new ProcResultVo();
		try {
			rsrcReqDtlVmVo.setExeUserId(getUserId()); //실행자ID
			rsrcReqDtlVmVo.setVmChngClCd("03");

			if("M".equals(rsrcReqDtlVmVo.getExeType()) )
			{
				rsrcReqVmService.updateRsrcReqSpecChngInfoForManaul(rsrcReqDtlVmVo); //자원요청상세 VM스펙변경정보 수동완료
			}
			else
			{
				rsrcReqVmService.updateRsrcReqSpecChngInfo(rsrcReqDtlVmVo); //자원요청상세 VM스펙변경정보 업데이트
			}
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
	 * 가상서버 자원요청 반려 처리
	 * @param request
	 * @param rsrcReqDtlVmVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateRsrcReqVmRjct.do", method=RequestMethod.POST)
	@OperateLog(action="가상서버 반려", desc="가상서버 반려 요청 처리", params={"rsrcReqNo", "rsrcReqSeq"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateRsrcReqVmRjct(@ModelAttribute("rsrcReqVo") RsrcReqVo rsrcReqVo, BindingResult bindResult) {
		ProcResultVo result = new ProcResultVo();
		result.setProcType("update");
		try {
			RsrcReqDtlVmVo reqDtlVmVo =  new RsrcReqDtlVmVo();
			reqDtlVmVo.setRsrcReqNo(rsrcReqVo.getRsrcReqNo());
			reqDtlVmVo.setRsrcReqSeq(rsrcReqVo.getRsrcReqSeq());
			reqDtlVmVo.setRsrcReqTyCd(rsrcReqVo.getRsrcReqTyCd());
			reqDtlVmVo.setRsrcReqPrcssStatCd(OprConstant.RSRC_REQ_PRCSS_STAT_RJCT);
			reqDtlVmVo.setRjctTyCd(rsrcReqVo.getRjctTyCd());
			reqDtlVmVo.setRjctReasn(rsrcReqVo.getRjctReasn());

			rsrcReqVmService.updateRsrcReqVmRjct(reqDtlVmVo, getUserId());
			result.setSuccess(true);
			result.addMessage("가상서버 반려 요청이 성공하였습니다.");
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			result.setSuccess(false);
			result.addMessage("가상서버 반려 요청이 실패하였습니다.");
		}
		return result;
	}

	/**
	 * 가상서버 삭제
	 * @param request
	 * @param model
	 * @param schRsrcReqNo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/formRsrcReqVmDel.do")
	public String selectRsrcReqVmDelView(HttpServletRequest request, Model model, @RequestParam(required=true) String schRsrcReqNo) throws Exception {
		try {
			RsrcReqDtlVmVo rrDtlVo = rsrcReqVmService.selectRsrcReqVmDel(schRsrcReqNo); //스펙변경요청정보 조회

			VmSearchVo searchVo = new VmSearchVo();
			searchVo.setEqualsVmSeq(rrDtlVo.getVmSeq());
			searchVo.setAll(true);

			if(searchVo.getEqualsVmSeq()==null){
				throw new Exception("가상서버 SEQ가 존재하지 않습니다. [자원요청번호:"+ schRsrcReqNo+"]");
			}
			VmVo vmVo = vmService.selectVmByVmSearchVo(searchVo); //가상서버 상세정보 조회

			model.addAttribute("title",RR_VM_DEL);
			model.addAttribute("rrDtlVo", rrDtlVo);
			if(rrDtlVo!=null && vmVo!=null) {
				model.addAttribute("vmVo", vmVo);
			}else {
				logger.error("가상서버정보가 없습니다. [가상서버SEQ: "+ searchVo.getEqualsVmSeq()+"]");
			}
			return portalTilesView(request, "formRsrcReqVmDel");
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
			model.addAttribute("errormsg", e.getMessage());
			return portalTilesView(request, "viewRsrcReqError");
		}
	}

}
