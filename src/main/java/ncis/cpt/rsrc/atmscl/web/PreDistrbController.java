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
import ncis.cpt.rsrc.atmscl.service.PreDistrbService;
import ncis.cpt.rsrc.atmscl.vo.PreDistrbSearchVo;
import ncis.cpt.rsrc.atmscl.vo.PreDistrbVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.intfc.atmscl.service.PreDistrbAPIService;
import ncis.intfc.atmscl.vo.PreDistrbBodyVO;

import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/cpt/rsrc/atmscl/preDistrb")
public class PreDistrbController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(PreDistrbController.class);

	@Resource(name="preDistrbService")
	PreDistrbService preDistrbService;

	@Resource(name="commonService")
	CommonService commonService;

	@Resource(name="preDistrbAPIService")
	PreDistrbAPIService preDistrbAPIService;
	/**
	 * 사전배포 목록 조회
	 * @param request
	 * @param model
	 * @param preDistrbVo
	 * @return
	 */

	@RequestMapping(value="/selectPreDistrbList.do")
	public String selectPreDistrbList(HttpServletRequest request,Model model ,PreDistrbSearchVo preDistrbSearchVo){
		List<PreDistrbVo> list = preDistrbService.selectPreDistrbList(preDistrbSearchVo);
		model.addAttribute("list", list);
		model.addAttribute("preDistrbVo", preDistrbSearchVo);
		return portalTilesView(request);
	}
	/**
     * 사전배포 목록 엑셀 다운로드
     *
     * @param request
     * @param model
     * @param preDistrbSearchVo
     * @return
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    @RequestMapping(value = "/selectPreDistrbListXlsDwnl.do")
    public void selectPreDistrbListXlsDwnl(HttpServletRequest request, HttpServletResponse response, Model model, PreDistrbSearchVo preDistrbSearchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<PreDistrbVo> preDistrbVoList = preDistrbService.selectPreDistrbList(preDistrbSearchVo);

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("distrbStatNm", "상태");
        header.put("institutionNm", "부처");
        header.put("jobNm", "업무");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망");
        header.put("rsrcPoolNm", "자원풀");
        header.put("imgNm", "이미지명");
        header.put("creUserNm", "등록자");
        header.put("distrbReqDttm", "등록일시");




        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("사전배포");
        sheet.setDatas(preDistrbVoList);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("사전배포_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

    /**
	 * 사전배포 상세 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectPreDistrb.do")
	public String updatePreDistrbView(HttpServletRequest request, Model model, @RequestParam(required=true) Integer servcAreaSeq,  @RequestParam(required=true) Integer preDistrbReqSeq) throws Exception {

		try {
			PreDistrbVo updatePreDistrb = preDistrbService.updatePreDistrb(servcAreaSeq, preDistrbReqSeq);
			model.addAttribute("preDistrbVo", updatePreDistrb);
		}
		catch(IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) { logger.error(e.getMessage(),e); }

		return portalTilesView(request);
	}

    /**
     * 사전배포 요청 화면
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/insertPreDistrbView.do",method=RequestMethod.GET)
    public String insertPreDistrbView(HttpServletRequest request, Model model) {

        model.addAttribute("preDistrbVo", new PreDistrbVo());
        return portalTilesView(request,"insertPreDistrb");

    }

    /**
	 * 사전배포 생성
	 * @param request
	 * @param preDistrbVo
	 * @return
	 */
	@OperateLog(action="사전배포 생성", desc="사전배포 생성 처리", params={"preDistrbVo"}, actionType=ActionType.INSERT)
	@RequestMapping(value="/insertPreDistrb.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo insertPreDistrb(PreDistrbVo preDistrbVo,BindingResult bindResult) throws Exception{

		ProcResultVo result = getBindingResult(preDistrbVo, bindResult, InsertProc.class);
		String preDistrbId = commonService.selectSeqNum("RX_IMG_PRE_DISTRB_LST","ds");
		if (result.isSuccess()) {
			try {
				// 해더정보 셋팅
				RestHeaders headers = new RestHeaders();
				headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
				headers.setAreaId(preDistrbVo.getRegionId());
				headers.setZoneId(preDistrbVo.getZoneId());
				headers.setNetworkId(preDistrbVo.getNetClCd());
				headers.setManagerId(preDistrbVo.getRsrcPoolId());
				//API 값 셋팅
				PreDistrbBodyVO preDistrbBodyVo = new PreDistrbBodyVO();
				preDistrbBodyVo.setNamespace(preDistrbVo.getServcAreaId());
				preDistrbBodyVo.setName(preDistrbId);
				preDistrbBodyVo.setImage(preDistrbVo.getImgRepoDtlAddr());
				PreDistrbBodyVO preDistrbResult= preDistrbAPIService.insertPreDistrbApi(headers, preDistrbBodyVo);

				if (preDistrbResult.getDesiredNumberScheduled() != null){
					//DB Insert값 셋팅
					preDistrbVo.setDistrbReqUserId(getUserId());
					preDistrbVo.setDemonSetId(preDistrbId);
					preDistrbService.insertPreDistrb(preDistrbVo);
					result.setProcType("insert");
					result.addMessage("정상적으로 사전배포되었습니다.");
					result.setSuccess(true);
				}

			}catch(IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e){
				logger.error(e.toString(),e);
				result.setSuccess(false);
				result.addMessage("사전배포 시 오류가 발생했습니다., error="+ e.getMessage());
			}
		}
		return result;
	}

	 /**
		 * 사전배포 상태 조회
		 * @param request
		 * @param preDistrbVo
		 * @return
		 */
		@RequestMapping(value="/selectPreDistrbStat.do", method=RequestMethod.GET)
		@ResponseBody
		public ProcResultVo selectPreDistrbStat(PreDistrbVo preDistrbVo,BindingResult bindResult) throws Exception{


			ProcResultVo result= new ProcResultVo();
				try {
					// 해더정보 셋팅
					RestHeaders headers = new RestHeaders();
					headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
					headers.setAreaId(preDistrbVo.getRegionId());
					headers.setZoneId(preDistrbVo.getZoneId());
					headers.setNetworkId(preDistrbVo.getNetClCd());
					headers.setManagerId(preDistrbVo.getRsrcPoolId());
					//API 값 셋팅
					PreDistrbBodyVO preDistrbBodyVo = new PreDistrbBodyVO();
					preDistrbBodyVo.setNamespace(preDistrbVo.getServcAreaId());
					preDistrbBodyVo.setName(preDistrbVo.getDemonSetId());
					PreDistrbBodyVO resultPreDistrb = preDistrbAPIService.selectPreDistrbApi(headers, preDistrbBodyVo);

					//DB 사전배포 상태 코드 Update값 셋팅
					if(resultPreDistrb.getNumberMisscheduled() > 0 || resultPreDistrb.getFailedPods() > 0){
						preDistrbVo.setDistrbStatCd("03");
					}else if(resultPreDistrb.getDesiredNumberScheduled() == resultPreDistrb.getRunningPods()){
						preDistrbVo.setDistrbStatCd("02");
					}
					if(preDistrbVo.getDistrbStatCd().equals("02")){

							result = getBindingResult(preDistrbVo, bindResult, UpdateProc.class);
							if (result.isSuccess()) {
								preDistrbService.updatePreDistrbStat(preDistrbVo);
								PreDistrbVo updatePreDistrb = preDistrbService.updatePreDistrb(preDistrbVo.getServcAreaSeq(),preDistrbVo.getPreDistrbReqSeq());
								result.setProcType("update");
								result.setData(updatePreDistrb);
								result.setSuccess(true);
						}
					}

				}catch(IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e){
					logger.error(e.toString(),e);
					result.setSuccess(false);
					result.addMessage("사전배포 조회 시 오류가 발생했습니다., error="+ e.getMessage());
				}
			return result;
		}

		/**
		 * 사전 재배포
		 * @param request
		 * @param preDistrbVo
		 * @return
		 */
		@OperateLog(action="사전 재배포", desc="사전 재배포  처리", params={"preDistrbVo"}, actionType=ActionType.DELETE)
		@RequestMapping(value="/reInsertPreDistrb.do", method=RequestMethod.POST)
		@ResponseBody
		public ProcResultVo reInsertPreDistrb(PreDistrbVo preDistrbVo,BindingResult bindResult) throws Exception{
			ProcResultVo result= new ProcResultVo();
				try {
					// 해더정보 셋팅
					RestHeaders headers = new RestHeaders();
					headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
					headers.setAreaId(preDistrbVo.getRegionId());
					headers.setZoneId(preDistrbVo.getZoneId());
					headers.setNetworkId(preDistrbVo.getNetClCd());
					headers.setManagerId(preDistrbVo.getRsrcPoolId());
					//API 값 셋팅
					PreDistrbBodyVO preDistrbBodyVo = new PreDistrbBodyVO();
					preDistrbBodyVo.setNamespace(preDistrbVo.getServcAreaId());
					preDistrbBodyVo.setName(preDistrbVo.getDemonSetId());
					preDistrbBodyVo.setImage(preDistrbVo.getImgRepoDtlAddr());
					if(!"02".equals(preDistrbVo.getDistrbStatCd())){
						PreDistrbBodyVO rePreDistrbResult= preDistrbAPIService.reInsertPreDistrbApi(headers, preDistrbBodyVo);
						if("Success".equals(rePreDistrbResult.getStatus())){

							// 해더정보 셋팅
							headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));

							String preDistrbId = commonService.selectSeqNum("RX_IMG_PRE_DISTRB_LST","ds");
							preDistrbBodyVo.setName(preDistrbId);
							preDistrbBodyVo.setImage(preDistrbVo.getImgRepoDtlAddr());
							PreDistrbBodyVO reInsertPreDistrbResult = preDistrbAPIService.insertPreDistrbApi(headers, preDistrbBodyVo);

							if(reInsertPreDistrbResult.getDesiredNumberScheduled() != null){
								preDistrbVo.setDistrbStatCd("01");
								preDistrbVo.setDemonSetId(preDistrbId);
								result = getBindingResult(preDistrbVo, bindResult, UpdateProc.class);
								if(result.isSuccess()){
									preDistrbService.updateRePreDistrb(preDistrbVo);
									result.setProcType("update");
									result.addMessage("정상적으로 재배포되었습니다.");
									result.setSuccess(true);
								}
							}
						}else if("Failure".equals(rePreDistrbResult.getStatus() )&& "NotFound".equals(rePreDistrbResult.getReason()) ){
							// 해더정보 셋팅
							headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));

							String preDistrbId = commonService.selectSeqNum("RX_IMG_PRE_DISTRB_LST","ds");
							preDistrbBodyVo.setName(preDistrbId);
							preDistrbBodyVo.setImage(preDistrbVo.getImgRepoDtlAddr());
							PreDistrbBodyVO reInsertPreDistrbResult = preDistrbAPIService.insertPreDistrbApi(headers, preDistrbBodyVo);

							if(reInsertPreDistrbResult.getDesiredNumberScheduled() != null){
								preDistrbVo.setDistrbStatCd("01");
								preDistrbVo.setDemonSetId(preDistrbId);
								result = getBindingResult(preDistrbVo, bindResult, UpdateProc.class);
								if(result.isSuccess()){
									preDistrbService.updateRePreDistrb(preDistrbVo);
									result.setProcType("update");
									result.addMessage("정상적으로 재배포되었습니다.");
									result.setSuccess(true);
								}
							}
						}
						else{
							throw new Exception("사전배포 이미지 삭제 중 오류가 발생했습니다.");
						}
					}else{

							// 해더정보 셋팅
							headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));

							String preDistrbId = commonService.selectSeqNum("RX_IMG_PRE_DISTRB_LST","ds");
							preDistrbBodyVo.setName(preDistrbId);
							preDistrbBodyVo.setImage(preDistrbVo.getImgRepoDtlAddr());
							PreDistrbBodyVO reInsertPreDistrbResult = preDistrbAPIService.insertPreDistrbApi(headers, preDistrbBodyVo);

							if(reInsertPreDistrbResult.getDesiredNumberScheduled() != null){
								preDistrbVo.setDistrbStatCd("01");
								preDistrbVo.setDemonSetId(preDistrbId);
								result = getBindingResult(preDistrbVo, bindResult, UpdateProc.class);
								if(result.isSuccess()){
									preDistrbService.updateRePreDistrb(preDistrbVo);
									result.setProcType("update");
									result.addMessage("정상적으로 재배포되었습니다.");
									result.setSuccess(true);
								}
							}
					}


				}catch(IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e){
					logger.error(e.toString(),e);
					result.setSuccess(false);
					result.addMessage("재배포 시 오류가 발생했습니다., error="+ e.getMessage());
				}

			return result;
		}

		/**
		 * 사전 배포 삭제
		 * @param request
		 * @param preDistrbVo
		 * @return
		 */
		@OperateLog(action="사전 배포 삭제", desc="사전 배포  삭제 처리", params={"preDistrbVo"}, actionType=ActionType.DELETE)
		@RequestMapping(value="/deletePreDistrb.do", method=RequestMethod.POST)
		@ResponseBody
		public ProcResultVo deletePreDistrb(PreDistrbVo preDistrbVo,BindingResult bindResult) throws Exception{
			ProcResultVo result= new ProcResultVo();
				try {
					// 해더정보 셋팅
					RestHeaders headers = new RestHeaders();
					headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
					headers.setAreaId(preDistrbVo.getRegionId());
					headers.setZoneId(preDistrbVo.getZoneId());
					headers.setNetworkId(preDistrbVo.getNetClCd());
					headers.setManagerId(preDistrbVo.getRsrcPoolId());
					//API 값 셋팅
					PreDistrbBodyVO preDistrbBodyVo = new PreDistrbBodyVO();
					preDistrbBodyVo.setNamespace(preDistrbVo.getServcAreaId());
					preDistrbBodyVo.setName(preDistrbVo.getDemonSetId());
					preDistrbBodyVo.setImage(preDistrbVo.getImgRepoDtlAddr());
					PreDistrbBodyVO rePreDistrbResult= preDistrbAPIService.reInsertPreDistrbApi(headers, preDistrbBodyVo);

					if(rePreDistrbResult.getStatus().equals("Success") ){
								result.setProcType("delete");
								result.setSuccess(true);
					}
				}catch(IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e){
					logger.error(e.toString(),e);
					result.setSuccess(false);
					result.addMessage("사전배포 이미지 삭제 중 오류가 발생했습니다., error="+ e.getMessage());
				}

			return result;
		}
		 /**
	     * 사전배포 대상 검색
	     *
	     * @param request
	     * @param model
	     * @param preDistrbSearchVo
	     * @return
	     */
	    @RequestMapping(value = "/selectPreDistrbListViewP.do")
	    public String selectPreDistrbListViewP(HttpServletRequest request, Model model, PreDistrbSearchVo preDistrbSearchVo) {
	    	preDistrbSearchVo.setCtlTrgtYn("Y");
			List<PreDistrbVo> list = preDistrbService.selectPreDistrbListP(preDistrbSearchVo);
			model.addAttribute("title","이미지 선택");
			model.addAttribute("list", list);
			model.addAttribute("preDistrbVo", preDistrbSearchVo);
	        return popup(request);

	    }

	    /**
		 * 사전 배포 경과시간 초과
		 * @param request
		 * @param preDistrbVo
		 * @return
		 */
		@OperateLog(action="사전 배포  업데이트", desc="사전 배포   업데이트 처리", params={"preDistrbVo"}, actionType=ActionType.UPDATE)
		@RequestMapping(value="/updateLmtPreDistrb.do", method=RequestMethod.POST)
		@ResponseBody
		public ProcResultVo updateLmtPreDistrb(PreDistrbVo preDistrbVo,BindingResult bindResult) throws Exception{
			ProcResultVo result= new ProcResultVo();
				try {
					preDistrbVo.setDistrbStatCd("04");
					preDistrbService.updatePreDistrbStat(preDistrbVo);
					result.setProcType("delete");
					result.setSuccess(true);
				}catch(IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e){
					logger.error(e.toString(),e);
					result.setSuccess(false);
					result.addMessage("사전배포 이미지 업데이트 중 오류가 발생했습니다., error="+ e.getMessage());
				}

			return result;
		}
}
