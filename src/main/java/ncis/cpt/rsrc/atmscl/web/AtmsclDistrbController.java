package ncis.cpt.rsrc.atmscl.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.config.OprConstant;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.rsrc.atmscl.service.AtmsclDistrbService;
import ncis.cpt.rsrc.atmscl.service.BldService;
import ncis.cpt.rsrc.atmscl.service.RsrvSclngService;
import ncis.cpt.rsrc.atmscl.vo.AtmsclDistrbSearchVo;
import ncis.cpt.rsrc.atmscl.vo.AtmsclDistrbVo;
import ncis.cpt.rsrc.atmscl.vo.DistrbEnvConfVo;
import ncis.cpt.rsrc.atmscl.vo.PvcVo;
import ncis.cpt.rsrc.atmscl.vo.RsrvSclngVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.intfc.atmscl.service.AtmsclDistrbAPIService;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;

import org.apache.commons.beanutils.BeanUtils;
import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/cpt/rsrc/atmscl/atmsclDistrb")
public class AtmsclDistrbController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(AtmsclDistrbController.class);

	@Resource(name="atmsclDistrbService")
	AtmsclDistrbService atmsclDistrbService;

	@Resource(name="commonService")
	CommonService commonService;

	@Resource(name="atmsclDistrbAPIService")
	private AtmsclDistrbAPIService atmsclDistrbAPIService;

	@Resource(name="rsrvSclngService")
	RsrvSclngService rsrvSclngService;

	@Resource(name="bldService")
	BldService bldService;
	/**
	 * 배포 목록 조회
	 * @param request
	 * @param model
	 * @param distribVo
	 * @return
	 */

	@RequestMapping(value="/selectAtmsclDistrbList.do")
	public String selectAtmsclDistrbList(HttpServletRequest request,Model model ,AtmsclDistrbSearchVo atmsclDistrbSearchVo){
		List<AtmsclDistrbVo> list = atmsclDistrbService.selectAtmsclDistrbList(atmsclDistrbSearchVo);
		List<CodeVo> selectCodeList = commonService.selectCodeList("110", "311");
		model.addAttribute("list", list);
		model.addAttribute("atmsclDistrbVo", atmsclDistrbSearchVo);
		model.addAttribute("selectCodeList", selectCodeList);
		return portalTilesView(request);
	}
	/**
     * 배포 목록 엑셀 다운로드
     *
     * @param request
     * @param model
     * @param atmsclDistrbSearchVo
     * @return
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    @RequestMapping(value = "/selectAtmsclDistrbListXlsDwnl.do")
    public void selectAtmsclDistrbListXlsDwnl(HttpServletRequest request, HttpServletResponse response, Model model, AtmsclDistrbSearchVo atmsclDistrbSearchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<AtmsclDistrbVo> atmsclDistrbVoList = atmsclDistrbService.selectAtmsclDistrbList(atmsclDistrbSearchVo);

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("statCd", "배포상태");
        header.put("institutionNm", "부처");
        header.put("jobNm", "업무");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망구분");
        header.put("rsrcPoolNm", "자원풀");
        header.put("servcAreaNm", "서비스영역명");
        header.put("servcNm", "서비스명");
        header.put("imgNm", "배포이미지명");
        header.put("lastDistrbVer", "배포버전");
        header.put("creDttm", "생성일");


        for (int i = 0; i < atmsclDistrbVoList.size(); i++) {
            if(null != atmsclDistrbVoList.get(i).getStatCd()){
            	switch (atmsclDistrbVoList.get(i).getStatCd()) {
				case "01":
					atmsclDistrbVoList.get(i).setStatCd("진행중");
					break;
				case "02":
					atmsclDistrbVoList.get(i).setStatCd("완료");
					break;
				case "03":
					atmsclDistrbVoList.get(i).setStatCd("실패");
					break;
				case "04":
					atmsclDistrbVoList.get(i).setStatCd("취소");
					break;
				case "05":
					atmsclDistrbVoList.get(i).setStatCd("Pending");
					break;
				case "06":
					atmsclDistrbVoList.get(i).setStatCd("New");
					break;
				case "07":
					atmsclDistrbVoList.get(i).setStatCd("other");
					break;
				default:
					atmsclDistrbVoList.get(i).setStatCd("미배포");
					break;
				}
            }
        }

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("배포");
        sheet.setDatas(atmsclDistrbVoList);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("배포_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }
    /**
	 * 배포 상세 조회
	 * @param request
	 * @param model
	 * @param distribVo
	 * @return
     * @throws Exception
	 */

	@RequestMapping(value="/selectDetailAtmsclDistrb.do")
	public String selectDetailAtmsclDistrb(HttpServletRequest request,Model model ,AtmsclDistrbVo atmsclDistrbVo) throws Exception{
		String thresClCdCpu = "";
		String thresClCdMem = "";
		String thresClCdNet = "";
			List<CodeVo> selectCodeList = commonService.selectCodeList("110", "311");
			atmsclDistrbVo.setUpdtUserId(getUserId());
			//배포이력 및 설정 정보
			List<AtmsclDistrbVo> distrbHstry = atmsclDistrbService.selectDetailAtmsclDistrb(atmsclDistrbVo);
			model.addAttribute("distrbHstry", distrbHstry);

			AtmsclDistrbVo atmsclDistVo = new AtmsclDistrbVo();
				BeanUtils.copyProperties(atmsclDistVo,distrbHstry.get(0));
				atmsclDistVo.setUpdtUserId(getUserId());
			model.addAttribute("atmsclDistrbVo", atmsclDistVo);


			//자원확장 가능 여부
			Integer selectAutoSclingCheck = atmsclDistrbService.selectAutoSclingCheck(atmsclDistrbVo);


			//header값 셋팅
			atmsclDistrbVo.setRegionId(atmsclDistVo.getRegionId());
			atmsclDistrbVo.setZoneId(atmsclDistVo.getZoneId());
			atmsclDistrbVo.setNetClCd(atmsclDistVo.getNetClCd());
			atmsclDistrbVo.setRsrcPoolId(atmsclDistVo.getRsrcPoolId());

			//Pod API를 위한 값 셋팅
			atmsclDistrbVo.setServcId(atmsclDistVo.getServcId());
			atmsclDistrbVo.setServcAreaId(atmsclDistVo.getServcAreaId());
			atmsclDistrbVo.setServcSeq(atmsclDistVo.getServcSeq());

			//Pod 정보
			List<AtmsclDistrbVo> podInfo = atmsclDistrbService.selectDistrbPodInfo(atmsclDistrbVo);
			model.addAttribute("podInfo", podInfo);

			//오토스케일링 정보
			List<AtmsclDistrbVo> autoSclInfo = atmsclDistrbService.selectRsrvSclInfo(atmsclDistrbVo);
			model.addAttribute("autoSclInfo", autoSclInfo);

			//환경설정 정보
			List<DistrbEnvConfVo> selectDistrbEnvConfInfo = atmsclDistrbService.selectDistrbEnvConfInfo(atmsclDistrbVo);
			//스토리지 추가 정보
			List<PvcVo> selectDistrbPvc = atmsclDistrbService.selectDistrbPvc(atmsclDistrbVo);
			for (AtmsclDistrbVo v : autoSclInfo) {
				if (v.getThresClCd() != null){
					switch (v.getThresClCd()) {
					case "01":
						thresClCdCpu = v.getEndThresVl();
						break;
					case "02":
						thresClCdMem = v.getEndThresVl();
						break;
					case "03":
						thresClCdNet = v.getEndThresVl();
						break;

					default:
						break;
					}
				}
			}

			model.addAttribute("nowPod",podInfo.size());
//			model.addAttribute("reqUer", getUserId());
			model.addAttribute("selectCodeList", selectCodeList);
			model.addAttribute("distrbEnvList", selectDistrbEnvConfInfo);
			model.addAttribute("thresClCdCpu", thresClCdCpu);
			model.addAttribute("thresClCdMem", thresClCdMem);
			model.addAttribute("thresClCdNet", thresClCdNet);
			model.addAttribute("selectAutoSclingCheck", selectAutoSclingCheck);
			model.addAttribute("selectDistrbPvc", selectDistrbPvc);

		return portalTilesView(request);
	}

	 /**
		 * PVC 생성
		 * @param request
		 * @param model
		 * @param svo
		 * @return
	 * @throws Exception
		 */
		@OperateLog(action="PVC 생성", desc="PVC 생성 처리", params={"atmsclDistrbVo"}, actionType=ActionType.INSERT)
		@RequestMapping(value="/insertPvcStrgAdd.do", method=RequestMethod.POST)
		@ResponseBody
		public ProcResultVo insertPvcStrgAdd(@ModelAttribute("atmsclDistrbVo") AtmsclDistrbVo atmsclDistrbVo,BindingResult bindResult) throws Exception {

			ProcResultVo result = getBindingResult(atmsclDistrbVo, bindResult, InsertProc.class);
			if (result.isSuccess()) {
				try {
						AtmSclResultIfVo resultmessage = atmsclDistrbService.insertPvcStrgAdd(atmsclDistrbVo);
						if ("Y".equals(resultmessage.getSuccYn())) {
							result.setProcType("insert");
							result.addMessage("스토리지 할당에 성공하였습니다.");
							result.setSuccess(true);
						}else{
							result.setSuccess(false);
							result.addMessage("스토리지 할당에 실패했습니다.");
						}
				}catch(IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e){
					logger.error(e.toString(),e);
					result.setSuccess(false);
					result.addMessage("스토리지 할당 시 오류가 발생했습니다.");
				}
			}
			return result;
		}

		 /**
		 * 자원확장 생성
		 * @param request
		 * @param model
		 * @param svo
		 * @return
		 * @throws Exception
		 */
		@OperateLog(action="자원확장 생성", desc="자원확장 생성 처리", params={"atmsclDistrbVo"}, actionType=ActionType.INSERT)
		@RequestMapping(value="/insertReplicasAdd.do", method=RequestMethod.POST)
		@ResponseBody
		public ProcResultVo insertReplicasAdd(@ModelAttribute("atmsclDistrbVo") AtmsclDistrbVo atmsclDistrbVo,BindingResult bindResult) throws Exception {

			ProcResultVo result = getBindingResult(atmsclDistrbVo, bindResult, InsertProc.class);
			if (result.isSuccess()) {
						AtmSclResultIfVo resultmessage;
						try {
							int selectDitrbStatCnt = atmsclDistrbService.selectDitrbStatCnt(atmsclDistrbVo);
							if(selectDitrbStatCnt > 0){
								resultmessage = atmsclDistrbService.insertReplicasAdd(atmsclDistrbVo);
								if ( "Y".equals(resultmessage.getSuccYn())) {
									result.setProcType("insert");
									result.addMessage("자원확장 적용에 성공하였습니다.");
									result.setSuccess(true);
								}else{
									result.setSuccess(false);
									result.addMessage("자원 확장 적용에 실패했습니다.");
								}
							}else{
								result.setSuccess(false);
								result.addMessage("배포이력 중 상태 값(완료)가 없습니다. 배포를 먼저 실행하여 주세요.");
							}
						} catch(IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e){
							result.setSuccess(false);
							result.addMessage("자원 확장 적용에 실패했습니다.");
						}

			}
			return result;
		}
		/**
		 * 자원제한 설정
		 * @param request
		 * @param model
		 * @param svo
		 * @return
		 * @throws Exception
		 */
		@OperateLog(action="자원제한 설정", desc="자원제한 설정 처리", params={"atmsclDistrbVo"}, actionType=ActionType.UPDATE)
		@RequestMapping(value="/updateRsrcLt.do", method=RequestMethod.POST)
		@ResponseBody
		public ProcResultVo updateRsrcLt(@ModelAttribute("atmsclDistrbVo") AtmsclDistrbVo atmsclDistrbVo,BindingResult bindResult) throws Exception {

			ProcResultVo result = getBindingResult(atmsclDistrbVo, bindResult, UpdateProc.class);
			if (result.isSuccess()) {
				try {
					AtmSclResultIfVo resultmessage = atmsclDistrbService.updateRsrcLt(atmsclDistrbVo);
					if ("Y".equals(resultmessage.getSuccYn())) {
						result.setProcType("insert");
						result.addMessage("자원제한에 성공하였습니다.");
						result.setSuccess(true);
					}else{
						result.setSuccess(false);
						result.addMessage("자원제한에 실패했습니다.");
					}
				}catch(IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e){
					logger.error(e.toString(),e);
					result.setSuccess(false);
					result.addMessage("자원제한 시 오류가 발생했습니다.");
				}
			}
			return result;
		}

		/**
		 * 배포 설정
		 * @param request
		 * @param model
		 * @param svo
		 * @return
		 * @throws Exception
		 */
		@OperateLog(action="배포 설정", desc="배포 설정 처리", params={"atmsclDistrbVo"}, actionType=ActionType.UPDATE)
		@RequestMapping(value="/updateDistrbConf.do", method=RequestMethod.POST)
		@ResponseBody
		public ProcResultVo updateDistrbConf(@ModelAttribute("atmsclDistrbVo") AtmsclDistrbVo atmsclDistrbVo,BindingResult bindResult) throws Exception {

			ProcResultVo result = getBindingResult(atmsclDistrbVo, bindResult, UpdateProc.class);
			if (result.isSuccess()) {
				try {
					AtmSclResultIfVo resultmessage = atmsclDistrbService.updateDistrbConf(atmsclDistrbVo);
					if ( "Y".equals(resultmessage.getSuccYn())) {
						result.setProcType("update");
						result.addMessage("배포를 성공하였습니다.");
						result.setSuccess(true);
					}else{
						result.setSuccess(false);
						result.addMessage("배포를 실패했습니다.");
					}
				}catch(IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e){
					logger.error(e.toString(),e);
					result.setSuccess(false);
					result.addMessage("배포 시 오류가 발생했습니다.");
				}
			}
			return result;
		}

		/**
		 * 오토스케일 설정
		 * @param request
		 * @param model
		 * @param svo
		 * @return
		 * @throws Exception
		 */
		@OperateLog(action="오토스케일 설정", desc="오토스케일 설정 처리", params={"atmsclDistrbVo"}, actionType=ActionType.INSERT)
		@RequestMapping(value="/insertDistrbAutoSclConf.do", method=RequestMethod.POST)
		@ResponseBody
		public ProcResultVo insertDistrbAutoSclConf(@ModelAttribute("atmsclDistrbVo") AtmsclDistrbVo atmsclDistrbVo,BindingResult bindResult) throws Exception {

			ProcResultVo result = getBindingResult(atmsclDistrbVo, bindResult, InsertProc.class);

			if(result.isSuccess()){
					try {
						RsrvSclngVo rsrvSclngVo = new RsrvSclngVo();
						rsrvSclngVo.setServcSeq(atmsclDistrbVo.getServcSeq());
						RsrvSclngVo rsrvSclCount = rsrvSclngService.selectRsrvSclngCheck(rsrvSclngVo);

						if (rsrvSclCount.getRsrvCount() > 0){
							result.addMessage("이미 스케일예약설정된  서비스 입니다.\n 스케일예약설정 하시려면 다른 스케일설정을 삭제해주세요. ");
							result.setSuccess(false);
						}else if(rsrvSclCount.getOpMultiSclCount() > 0){
							result.addMessage("이미 스케일예약 설정된  서비스 입니다.\n 스케일예약설정 하시려면 다른 스케일설정을 삭제해주세요. ");
							result.setSuccess(false);
						}else {
								atmsclDistrbService.insertDistrbAutoConf(atmsclDistrbVo);
								result.setProcType("insert");
								result.addMessage("스케일 설정을 성공하였습니다.");
								result.setSuccess(true);
						}
					} catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
						result.setSuccess(false);
						result.addMessage("스케일 설정을  실패했습니다.");
					}
			}else{
				result.setSuccess(false);
			}

			return result;
		}

		 /**
		 * 배포 상태 조회
		 * @param request
		 * @param atmsclDistrbVo
		 * @return
		 */
		@RequestMapping(value="/selectDistrbStat.do", method=RequestMethod.GET)
		@ResponseBody
		public ProcResultVo selectDistrbStat(AtmsclDistrbVo atmsclDistrbVo,BindingResult bindResult) throws Exception{

			ProcResultVo result= new ProcResultVo();
			AtmSclResultIfVo distrbStat = atmsclDistrbService.selectDistrbStat(atmsclDistrbVo);

			if("Y".equals(distrbStat.getSuccYn())){
				result.setProcType("update");
				result.setSuccess(true);
			}else{
				result.setSuccess(false);
			}

			return result;
		}

		/**
		 * 배포 설정 저장
		 * @param request
		 * @param model
		 * @param svo
		 * @return
		 * @throws Exception
		 */
		@OperateLog(action="배포 설정 저장", desc="배포 설정 저장 처리", params={"atmsclDistrbVo"}, actionType=ActionType.UPDATE)
		@RequestMapping(value="/updateDistrbConfSave.do", method=RequestMethod.POST)
		@ResponseBody
		public ProcResultVo updateDistrbConfSave(@ModelAttribute("atmsclDistrbVo") AtmsclDistrbVo atmsclDistrbVo,BindingResult bindResult) throws Exception {

			ProcResultVo result = getBindingResult(atmsclDistrbVo, bindResult, UpdateProc.class);
			if (result.isSuccess()) {
				try {
					atmsclDistrbVo.setUpdtUserId(getUserId());
					atmsclDistrbService.updateDistrbConfSave(atmsclDistrbVo);
					result.setSuccess(true);
					result.setProcType("update");
					result.addMessage("배포설정 저장에 성공했습니다.");
				}catch(IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e){
					logger.error(e.toString(),e);
					result.setSuccess(false);
					result.addMessage("배포설정 저장 시 오류가 발생했습니다.");
				}
			}
			return result;
		}

		  /**
	     * 배포 스토리지 추가
	     *
	     * @param request
	     * @param model
	     * @param atmsclDistrbVo
	     * @return
	     */
	    @RequestMapping(value = "/atmsclDistrbStrgAddP.do")
	    public String atmsclDistrbStrgAddP(HttpServletRequest request, Model model, AtmsclDistrbSearchVo atmsclDistrbSearchVo
	    		,@RequestParam(required=true) String rsrcPoolId
	    		,@RequestParam(required=true) Integer servcAreaSeq
	    		,@RequestParam(required=true) Integer servcSeq
	    		,@RequestParam(required=true) String regionId
	    		,@RequestParam(required=true) String zoneId
	    		,@RequestParam(required=true) String netClCd
	    		,@RequestParam(required=true) String distrbConfId
	    		,@RequestParam(required=true) String servcAreaId
	    		) {
	    	atmsclDistrbSearchVo.setRsrcPoolId(rsrcPoolId);

	    	List<AtmsclDistrbVo> selectAtmsclStrg = atmsclDistrbService.selectAtmsclStrgP(atmsclDistrbSearchVo);
			model.addAttribute("selectAtmsclStrg", selectAtmsclStrg);
			model.addAttribute("servcAreaSeq", servcAreaSeq);
			model.addAttribute("servcSeq", servcSeq);
			model.addAttribute("regionId", regionId);
			model.addAttribute("rsrcPoolId", rsrcPoolId);
			model.addAttribute("zoneId", zoneId);
			model.addAttribute("netClCd", netClCd);
			model.addAttribute("distrbConfId", distrbConfId);
			model.addAttribute("servcAreaId", servcAreaId);
			model.addAttribute("title","스토리지 추가");
	        return popup(request);

	    }

	    /**
	     * 자원확장
	     *
	     * @param request
	     * @param model
	     * @param atmsclDistrbVo
	     * @return
	     * @throws Exception
	     */
	    @RequestMapping(value = "/atmsclDistrbReplicasP.do")
	    public String atmsclDistrbReplicasP(HttpServletRequest request, Model model, AtmsclDistrbVo atmsclDistrbVo
	    		,@RequestParam(required=true) String rsrcPoolId
	    		,@RequestParam(required=true) Integer servcAreaSeq
	    		,@RequestParam(required=true) Integer servcSeq
	    		,@RequestParam(required=true) String regionId
	    		,@RequestParam(required=true) String zoneId
	    		,@RequestParam(required=true) String netClCd
	    		,@RequestParam(required=true) String distrbConfId
	    		,@RequestParam(required=true) String servcAreaId
	    		,@RequestParam(required=true) Double avgMemUseRt
	    		,@RequestParam(required=true) Double avgCpuUseRt
	    		) throws Exception {

	    	atmsclDistrbVo.setRsrcPoolId(rsrcPoolId);
	    	atmsclDistrbVo.setRegionId(regionId);
	    	atmsclDistrbVo.setServcAreaSeq(servcAreaSeq);
	    	atmsclDistrbVo.setServcSeq(servcSeq);
	    	atmsclDistrbVo.setRegionId(regionId);
	    	atmsclDistrbVo.setZoneId(zoneId);
	    	atmsclDistrbVo.setNetClCd(netClCd);
	    	atmsclDistrbVo.setDistrbConfId(distrbConfId);
	    	atmsclDistrbVo.setServcAreaId(servcAreaId);

	    	RestHeaders headers = new RestHeaders();
			headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
			headers.setAreaId(atmsclDistrbVo.getRegionId());
			headers.setZoneId(atmsclDistrbVo.getZoneId());
			headers.setNetworkId(atmsclDistrbVo.getNetClCd());
			headers.setManagerId(atmsclDistrbVo.getRsrcPoolId());


	    	AtmSclResultIfVo selectPodCnt = atmsclDistrbAPIService.selectPodCnt(headers,atmsclDistrbVo);
	    	//if ("Y".equals(selectPodCnt.getSuccYn())) {
	    		model.addAttribute("servcAreaSeq", servcAreaSeq);
	    		model.addAttribute("servcSeq", servcSeq);
	    		model.addAttribute("regionId", regionId);
	    		model.addAttribute("rsrcPoolId", rsrcPoolId);
	    		model.addAttribute("zoneId", zoneId);
	    		model.addAttribute("netClCd", netClCd);
	    		model.addAttribute("distrbConfId", distrbConfId);
	    		model.addAttribute("servcAreaId", servcAreaId);
	    		model.addAttribute("avgMemUseRt", avgMemUseRt);
	    		model.addAttribute("avgCpuUseRt", avgCpuUseRt);
	    		model.addAttribute("nowPodQty", selectPodCnt.getPodsCnt());
	    		model.addAttribute("regUserId",getUserId());
	    		model.addAttribute("lastDistrbVer",selectPodCnt.getLatestVersion());
	    		model.addAttribute("title","자원 확장");
			//}
	        return popup(request);

	    }

	    /**
	     * 자원제한
	     *
	     * @param request
	     * @param model
	     * @param atmsclDistrbVo
	     * @return
	     * @throws Exception
	     */
	    @RequestMapping(value = "/atmsclDistrbRsrcLtP.do")
	    public String atmsclDistrbRsrcLtP(HttpServletRequest request, Model model, AtmsclDistrbVo atmsclDistrbVo
	    		,@RequestParam(required=true) String rsrcPoolId
	    		,@RequestParam(required=true) Integer servcAreaSeq
	    		,@RequestParam(required=true) Integer servcSeq
	    		,@RequestParam(required=true) String regionId
	    		,@RequestParam(required=true) String zoneId
	    		,@RequestParam(required=true) String netClCd
	    		,@RequestParam(required=true) String distrbConfId
	    		,@RequestParam(required=true) String servcAreaId
	    		,@RequestParam(required=false) double reqCpuCorQty
	    		,@RequestParam(required=false) double lmttCpuCorQty
	    		,@RequestParam(required=false) double reqMemCapa
	    		,@RequestParam(required=false) double lmttMemCapa
	    		,@RequestParam(required=true) String distrbId
	    		) throws Exception {

		    	atmsclDistrbVo.setRsrcPoolId(rsrcPoolId);
		    	atmsclDistrbVo.setRegionId(regionId);
		    	atmsclDistrbVo.setServcAreaSeq(servcAreaSeq);
		    	atmsclDistrbVo.setServcSeq(servcSeq);
		    	atmsclDistrbVo.setRegionId(regionId);
		    	atmsclDistrbVo.setZoneId(zoneId);
		    	atmsclDistrbVo.setNetClCd(netClCd);
		    	atmsclDistrbVo.setDistrbConfId(distrbConfId);
		    	atmsclDistrbVo.setServcAreaId(servcAreaId);
		    	atmsclDistrbVo.setDistrbId(distrbId);
		    	atmsclDistrbVo.setLmttTyCd("03");
		    	AtmsclDistrbVo selectPodQuata = atmsclDistrbService.selectPodQuata(atmsclDistrbVo);

	    		model.addAttribute("selectPodQuata", selectPodQuata);
	    		model.addAttribute("servcAreaSeq", servcAreaSeq);
	    		model.addAttribute("servcSeq", servcSeq);
	    		model.addAttribute("regionId", regionId);
	    		model.addAttribute("rsrcPoolId", rsrcPoolId);
	    		model.addAttribute("zoneId", zoneId);
	    		model.addAttribute("netClCd", netClCd);
	    		model.addAttribute("distrbConfId", distrbConfId);
	    		model.addAttribute("servcAreaId", servcAreaId);
	    		model.addAttribute("reqCpuCorQty", reqCpuCorQty);
	    		model.addAttribute("lmttCpuCorQty", lmttCpuCorQty);
	    		model.addAttribute("reqMemCapa", reqMemCapa);
	    		model.addAttribute("lmttMemCapa", lmttMemCapa);
	    		model.addAttribute("distrbId", distrbId);
	    		model.addAttribute("regUserId",getUserId());
	    		model.addAttribute("title","자원 제한(Resource Limit)");
	        return popup(request);

	    }


	    /**
	     * 오토스케일링 설정
	     *
	     * @param request
	     * @param model
	     * @param atmsclDistrbVo
	     * @return
	     */
	    @RequestMapping(value = "/atmsclDistrbAutoScP.do")
	    public String atmsclDistrbAutoScP(HttpServletRequest request, Model model, AtmsclDistrbVo atmsclDistrbVo
	    		,@RequestParam(required=true) String rsrcPoolId
	    		,@RequestParam(required=true) Integer servcAreaSeq
	    		,@RequestParam(required=true) Integer servcSeq
	    		,@RequestParam(required=true) String regionId
	    		,@RequestParam(required=true) String zoneId
	    		,@RequestParam(required=true) String netClCd
	    		,@RequestParam(required=true) String distrbConfId
	    		,@RequestParam(required=true) String servcAreaId
	    		,@RequestParam(required=true) String servcId
	    		) {

	    	List<CodeVo> selCodeSclGrpList= commonService.selectCodeList("112", "313"); //스케일 그룹코드
	    	List<CodeVo> selCodeThresConfList = commonService.selectCodeList("113", "314"); //스케일임계치구분코드
	    	List<CodeVo> selCodeSclList = commonService.selectCodeList("103", "304");  //스케일링구분코드
	    	atmsclDistrbVo.setRsrcPoolId(rsrcPoolId);
	    	atmsclDistrbVo.setRegionId(regionId);
	    	atmsclDistrbVo.setServcAreaSeq(servcAreaSeq);
	    	atmsclDistrbVo.setServcSeq(servcSeq);
	    	atmsclDistrbVo.setRegionId(regionId);
	    	atmsclDistrbVo.setZoneId(zoneId);
	    	atmsclDistrbVo.setNetClCd(netClCd);
	    	atmsclDistrbVo.setDistrbConfId(distrbConfId);
	    	atmsclDistrbVo.setServcAreaId(servcAreaId);
	    	atmsclDistrbVo.setServcId(servcId);
	    	//오토스케일링 정보
			List<AtmsclDistrbVo> autoSclInfo = atmsclDistrbService.selectRsrvSclInfo(atmsclDistrbVo);


	    	RestHeaders headers = new RestHeaders();
			headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
			headers.setAreaId(atmsclDistrbVo.getRegionId());
			headers.setZoneId(atmsclDistrbVo.getZoneId());
			headers.setNetworkId(atmsclDistrbVo.getNetClCd());
			headers.setManagerId(atmsclDistrbVo.getRsrcPoolId());


	    	AtmSclResultIfVo selectPodCnt = atmsclDistrbAPIService.selectPodCnt(headers,atmsclDistrbVo);
	    	if ("Y".equals(selectPodCnt.getSuccYn()) ) {
	    		model.addAttribute("servcAreaSeq", servcAreaSeq);
	    		model.addAttribute("servcId", servcId);
	    		model.addAttribute("servcSeq", servcSeq);
	    		model.addAttribute("regionId", regionId);
	    		model.addAttribute("rsrcPoolId", rsrcPoolId);
	    		model.addAttribute("zoneId", zoneId);
	    		model.addAttribute("netClCd", netClCd);
	    		model.addAttribute("distrbConfId", distrbConfId);
	    		model.addAttribute("servcAreaId", servcAreaId);
	    		model.addAttribute("nowPodQty", selectPodCnt.getPodsCnt());
	    		model.addAttribute("selCodeSclGrpList", selCodeSclGrpList);
	    		model.addAttribute("selCodeThresConfList", selCodeThresConfList);
	    		model.addAttribute("selCodeSclList", selCodeSclList);
	    		model.addAttribute("regUserId",getUserId());
	    		model.addAttribute("autoSclInfo", autoSclInfo);
	    		model.addAttribute("title","오토스케일(Autoscale)");
			}
	        return popup(request);

	    }
	    /**
		 * 오토스케일 설정 수정
		 * @param request
		 * @param model
		 * @param svo
		 * @return
	     * @throws Exception
		 */
		@OperateLog(action="오토스케일 설정 수정", desc="오토스케일 설정 수정 처리", params={"atmsclDistrbVo"}, actionType=ActionType.UPDATE)
		@RequestMapping(value="/updateDistrbAutoSclConf.do", method=RequestMethod.POST)
		@ResponseBody
		public ProcResultVo updateDistrbAutoSclConf(@ModelAttribute("atmsclDistrbVo") AtmsclDistrbVo atmsclDistrbVo,BindingResult bindResult) throws Exception {

			ProcResultVo result = getBindingResult(atmsclDistrbVo, bindResult, UpdateProc.class);

			if(result.isSuccess()){
//						List<CodeVo> selCodeSclConfList = commonService.selectCodeList("114", "315");  //스케일설정조건구분
						try {
							atmsclDistrbVo.setCreUserId(getUserId());
							atmsclDistrbService.updateDistrbAutoSclConf(atmsclDistrbVo);
							result.setProcType("update");
							result.addMessage("스케일 설정 수정을 성공하였습니다.");
							result.setSuccess(true);
						} catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
							result.setSuccess(false);
							result.addMessage("스케일 설정 수정을  실패했습니다."+e.getMessage());
						}

			}else{
				result.setSuccess(false);
			}

			return result;
		}
		/**
		 * 오토스케일 설정 삭제
		 * @param request
		 * @param model
		 * @param svo
		 * @return
		 * @throws Exception
		 */
		@OperateLog(action="오토스케일 설정 삭제", desc="오토스케일 설정 삭제 처리", params={"atmsclDistrbVo"}, actionType=ActionType.DELETE)
		@RequestMapping(value="/deleteDistrbAutoSclConf.do", method=RequestMethod.POST)
		@ResponseBody
		public ProcResultVo deleteDistrbAutoSclConf(@ModelAttribute("atmsclDistrbVo") AtmsclDistrbVo atmsclDistrbVo,BindingResult bindResult) throws Exception {

			ProcResultVo result = getBindingResult(atmsclDistrbVo, bindResult, UpdateProc.class);
					try {
						atmsclDistrbVo.setUpdtUserId(getUserId());
						atmsclDistrbService.deleteDistrbAutoSclConf(atmsclDistrbVo);
						result.setProcType("delete");
						result.addMessage("스케일 설정 삭제를 성공하였습니다.");
						result.setSuccess(true);
					} catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
						result.setSuccess(false);
						result.addMessage("스케일 설정 삭제를  실패했습니다."+e.getMessage());
					}


			return result;
		}
		/**
		 * 자원제한 설정 초기화
		 * @param request
		 * @param model
		 * @param svo
		 * @return
		 * @throws Exception
		 */
		@OperateLog(action="자원제한 설정 초기화", desc="자원제한 설정 초기화 처리", params={"atmsclDistrbVo"}, actionType=ActionType.UPDATE)
		@RequestMapping(value="/updateInitRsrcLt.do", method=RequestMethod.POST)
		@ResponseBody
		public ProcResultVo updateInitRsrcLt(@ModelAttribute("atmsclDistrbVo") AtmsclDistrbVo atmsclDistrbVo,BindingResult bindResult) throws Exception {

			ProcResultVo result = getBindingResult(atmsclDistrbVo, bindResult, UpdateProc.class);
			if (result.isSuccess()) {
				try {
					AtmSclResultIfVo resultmessage = atmsclDistrbService.updateInitRsrcLt(atmsclDistrbVo);
					if ("Y".equals(resultmessage.getSuccYn())) {
						result.setProcType("insert");
						result.addMessage("자원제한 초기화에 성공하였습니다.");
						result.setSuccess(true);
					}else{
						result.setSuccess(false);
						result.addMessage("자원제한 초기화에 실패했습니다.");
					}
				}catch(IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e){
					logger.error(e.toString(),e);
					result.setSuccess(false);
					result.addMessage("자원제한 초깋시 오류가 발생했습니다.");
				}
			}
			return result;
		}
		/**
		 * PVC 삭제
		 * @param request
		 * @param model
		 * @param svo
		 * @return
		 * @throws Exception
		 */
		@OperateLog(action="PVC 삭제", desc="PVC 삭제 처리", params={"atmsclDistrbVo"}, actionType=ActionType.DELETE)
		@RequestMapping(value="/deletePvc.do", method=RequestMethod.POST)
		@ResponseBody
		public ProcResultVo deletePvc(@ModelAttribute("atmsclDistrbVo") AtmsclDistrbVo atmsclDistrbVo,BindingResult bindResult) throws Exception {

			ProcResultVo result = getBindingResult(atmsclDistrbVo, bindResult, UpdateProc.class);
					try {
						AtmSclResultIfVo deletePvc = atmsclDistrbService.deletePvc(atmsclDistrbVo);
						if("Y".equals(deletePvc.getSuccYn())){
							result.setProcType("delete");
							result.addMessage("스토리지 삭제를 성공하였습니다.");
							result.setSuccess(true);
						}else{
							result.setSuccess(false);
							result.addMessage("스토리지 삭제를  실패했습니다.");
						}
					} catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
						result.setSuccess(false);
						result.addMessage("스토리지 삭제를  실패했습니다."+e.getMessage());
					}


			return result;
		}
}
