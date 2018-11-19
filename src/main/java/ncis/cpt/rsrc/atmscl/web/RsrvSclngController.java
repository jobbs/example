package ncis.cpt.rsrc.atmscl.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
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
import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.rsrc.atmscl.service.AtmsclDistrbService;
import ncis.cpt.rsrc.atmscl.service.RsrvSclngService;
import ncis.cpt.rsrc.atmscl.vo.AtmsclDistrbSearchVo;
import ncis.cpt.rsrc.atmscl.vo.AtmsclDistrbVo;
import ncis.cpt.rsrc.atmscl.vo.RsrvSclngSearchVo;
import ncis.cpt.rsrc.atmscl.vo.RsrvSclngVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;

import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
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
@RequestMapping(value="/cpt/rsrc/atmscl/rsrvSclng")
public class RsrvSclngController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(RsrvSclngController.class);

	@Resource(name="rsrvSclngService")
	RsrvSclngService rsrvSclngService;

	@Resource(name="commonService")
	CommonService commonService;

	@Resource(name="atmsclDistrbService")
	AtmsclDistrbService atmsclDistrbService;

	/**
	 * 스케일 예약설정 목록 조회
	 * @param request
	 * @param model
	 * @param rsrvSclngVo
	 * @return
	 */

	@RequestMapping(value="/selectRsrvSclngList.do")
	public String selectRsrvSclngList(HttpServletRequest request,Model model ,RsrvSclngSearchVo rsrvSclngSearchVo){
		List<RsrvSclngVo> list = rsrvSclngService.selectRsrvSclngList(rsrvSclngSearchVo);
		model.addAttribute("list", list);
		model.addAttribute("rsrvSclngVo", rsrvSclngSearchVo);
		return portalTilesView(request);
	}
	/**
     * 스케일 예약설정 목록 엑셀 다운로드
     *
     * @param request
     * @param model
     * @param rsrvSclngSearchVo
     * @return
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    @RequestMapping(value = "/selectRsrvSclngListXlsDwnl.do")
    public void selectRsrvSclngListXlsDwnl(HttpServletRequest request, HttpServletResponse response, Model model, RsrvSclngSearchVo rsrvSclngSearchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<RsrvSclngVo> rsrvSclngVoList = rsrvSclngService.selectRsrvSclngList(rsrvSclngSearchVo);

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        SimpleDateFormat parseFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat applyFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("useYn", "사용여부");
        header.put("institutionNm", "부처");
        header.put("jobNm", "업무");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망구분");
        header.put("rsrcPoolNm", "자원풀");
        header.put("servcNm", "서비스명");
        header.put("scalrNm", "예약명");
        header.put("imgNm", "배포이미지명");
        header.put("rsrvStrtDt", "예약시작일자");
        header.put("rsrvEndDt", "예약종료일자");
        header.put("maxPodQty", "Pod 수");

        for (int i = 0; i < rsrvSclngVoList.size(); i++) {
            if(null != rsrvSclngVoList.get(i).getUseYn()){
            	switch (rsrvSclngVoList.get(i).getUseYn()) {
				case "Y":
					rsrvSclngVoList.get(i).setUseYn("사용");
					break;
				case "N":
					rsrvSclngVoList.get(i).setUseYn("미사용");
					break;
				}
            }
            if(null != rsrvSclngVoList.get(i).getRsrvStrtDt() && null != rsrvSclngVoList.get(i).getRsrvEndDt()){

            	try {
					date = parseFormat.parse(rsrvSclngVoList.get(i).getRsrvEndDt());
					rsrvSclngVoList.get(i).setRsrvEndDt(applyFormat.format(date));

					date = parseFormat.parse(rsrvSclngVoList.get(i).getRsrvStrtDt());
					rsrvSclngVoList.get(i).setRsrvStrtDt(applyFormat.format(date));
				} catch (ParseException e) {
					logger.error(e.getMessage(), e);
				}
            }
        }

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("스케일예약설정");
        sheet.setDatas(rsrvSclngVoList);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("스케일예약설정_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

    /**
     * 스케일 예약설정 요청 화면
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/insertRsrvSclngView.do",method=RequestMethod.GET)
    public String insertRsrvSclngView(HttpServletRequest request, Model model) {

        model.addAttribute("rsrvSclngVo", new RsrvSclngVo());
        return portalTilesView(request,"insertRsrvSclng");

    }

    /**
	 * 스케일예약설정 생성
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="스케일예약설정 생성", desc="스케일예약설정 생성 처리", params={"rsrvSclngVo"}, actionType=ActionType.INSERT)
	@RequestMapping(value="/insertRsrvSclng.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo insertRsrvSclng(@ModelAttribute("vo") RsrvSclngVo rsrvSclngVo,BindingResult bindResult) throws Exception{
		RsrvSclngSearchVo rsrvSclngSearchVo = new RsrvSclngSearchVo();
		ProcResultVo result = getBindingResult(rsrvSclngVo, bindResult, InsertProc.class);
		if (result.isSuccess()) {
			try {

				RsrvSclngVo rsrvSclCount = rsrvSclngService.selectRsrvSclngCheck(rsrvSclngVo);
//				if (rsrvSclCount.getRsrvCount() > 0){
//					result.addMessage("이미 스케일예약설정된  서비스 입니다.");
//					result.setSuccess(false);
//				}else
				if(rsrvSclCount.getOpMultiSclCount() > 0){
					result.addMessage("이미 openshift스케일링 또는 다차원 스케잉링 설정된  서비스 입니다.\n 스케일예약설정 하시려면 다른 스케일설정을 삭제해주세요. ");
					result.setSuccess(false);
				}else {
					rsrvSclngSearchVo.setServcSeq(rsrvSclngVo.getServcSeq());
					List<RsrvSclngVo> list = rsrvSclngService.selectRsrvSclngList(rsrvSclngSearchVo);
					SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
					SimpleDateFormat transInFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date stInDate = transInFormat.parse(rsrvSclngVo.getRsrvStrtDt());
					Date enInDate = transInFormat.parse(rsrvSclngVo.getRsrvEndDt());
					if(!ObjectUtils.isEmpty(list)){
						String rsrvNm = new String();
						Boolean dateDup = false;
						for (RsrvSclngVo dateCheck : list) {

							Date stBaseDate = transFormat.parse(dateCheck.getRsrvStrtDt());
							Date enBaseDate = transFormat.parse(dateCheck.getRsrvEndDt());

							if(stBaseDate.getTime() <= stInDate.getTime() && stInDate.getTime() <= enBaseDate.getTime()){ // 입력 < 기존값 작은 경우
								rsrvNm = dateCheck.getScalrNm();
								dateDup = true;
							}else if(stInDate.getTime() <= stBaseDate.getTime() && enBaseDate.getTime() <= enInDate.getTime()){
								rsrvNm = dateCheck.getScalrNm();
								dateDup = true;
							}else if(stBaseDate.getTime() <= enInDate.getTime() && enInDate.getTime() <= enBaseDate.getTime()){ //
								rsrvNm = dateCheck.getScalrNm();
								dateDup = true;
							}
						}
						if(!dateDup){
							rsrvSclngVo.setCreUserId(getUserId());
							rsrvSclngVo.setSclngClCd("03");
							rsrvSclngVo.setNowPodQty(1);
							rsrvSclngVo.setMinPodQty(1);
							String resultmessage = rsrvSclngService.insertRsrvSclng(rsrvSclngVo);
							result.setProcType("insert");
							result.addMessage(resultmessage);
							result.setSuccess(true);
						}else{
							result.setSuccess(false);
							result.addMessage("예약명 ("+rsrvNm+")의 예약일자와 설정하려는 예약일자가 중복되는 구간이 있습니다.");
						}
					}else{
						rsrvSclngVo.setCreUserId(getUserId());
						rsrvSclngVo.setSclngClCd("03");
						rsrvSclngVo.setNowPodQty(1);
						rsrvSclngVo.setMinPodQty(1);
						String resultmessage = rsrvSclngService.insertRsrvSclng(rsrvSclngVo);
						result.setProcType("insert");
						result.addMessage(resultmessage);
						result.setSuccess(true);
					}
				}

			}catch(IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e){
				logger.error(e.toString(),e);
				result.setSuccess(false);
				result.addMessage("스케일예약설정 시 오류가 발생했습니다., error="+ e.getMessage());
			}
		}else{
			result.setSuccess(false);
			result.addMessage("스케일예약설정 시 오류가 발생했습니다.");
		}
		return result;
	}

	/**
	 * 스케일예약설정 상세 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectAtmSclRsrvSclng.do")
	public String selectAtmSclRsrvSclng(HttpServletRequest request, Model model, @RequestParam(required=true) Integer servcSeq,  @RequestParam(required=true) String scalrId) throws Exception {

		try {
			//스케일예약설정 정보
			RsrvSclngVo updateAtmSclRsrvSclng = rsrvSclngService.selectAtmSclRsrvSclng(servcSeq, scalrId);
			model.addAttribute("rsrvSclngVo", updateAtmSclRsrvSclng);
		}
		catch(IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException ne) { logger.error(ne.getMessage(), ne); }


		return portalTilesView(request);
	}

	/**
	 * 스케일예약설정 수정
	 *
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateAtmSclRsrvSclng.do", method = RequestMethod.POST)
	@OperateLog(action = "스케일예약설정 수정", desc = "스케일예약설정 수정 처리",params={"rsrvSclngVo"}, actionType = ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateAtmSclRsrvSclng(HttpServletRequest request,
			@ModelAttribute("rsrvSclngVo") RsrvSclngVo rsrvSclngVo,BindingResult bindResult) throws Exception {
		ProcResultVo result = getBindingResult(rsrvSclngVo, bindResult, UpdateProc.class);
		RsrvSclngSearchVo rsrvSclngSearchVo = new RsrvSclngSearchVo();
	   if (result.isSuccess()){
			try {
				RsrvSclngVo rsrvSclCount = rsrvSclngService.selectRsrvSclngCheck(rsrvSclngVo);
				if(rsrvSclCount.getOpMultiSclCount() > 0){
					result.addMessage("이미 openshift스케일링 또는 다차원 스케잉링 설정된  서비스 입니다.\n 스케일예약설정 하시려면 다른 스케일설정을 삭제해주세요. ");
					result.setSuccess(false);
				}else{
					rsrvSclngSearchVo.setServcSeq(rsrvSclngVo.getServcSeq());
					rsrvSclngSearchVo.setScalrId(rsrvSclngVo.getScalrId());
					List<RsrvSclngVo> list = rsrvSclngService.selectRsrvSclngList(rsrvSclngSearchVo);
					SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
					SimpleDateFormat transInFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date stInDate = transInFormat.parse(rsrvSclngVo.getRsrvStrtDt());
					Date enInDate = transInFormat.parse(rsrvSclngVo.getRsrvEndDt());
					if(!ObjectUtils.isEmpty(list)){
						String rsrvNm = new String();
						Boolean dateDup = false;

						for (RsrvSclngVo dateCheck : list) {

							Date stBaseDate = transFormat.parse(dateCheck.getRsrvStrtDt());
							Date enBaseDate = transFormat.parse(dateCheck.getRsrvEndDt());

							if(stBaseDate.getTime() <= stInDate.getTime() && stInDate.getTime() <= enBaseDate.getTime()){ // 입력 < 기존값 작은 경우
								rsrvNm = dateCheck.getScalrNm();
								dateDup = true;
							}else if(stInDate.getTime() <= stBaseDate.getTime() && enBaseDate.getTime() <= enInDate.getTime()){
								rsrvNm = dateCheck.getScalrNm();
								dateDup = true;
							}else if(stBaseDate.getTime() <= enInDate.getTime() && enInDate.getTime() <= enBaseDate.getTime()){ //
								rsrvNm = dateCheck.getScalrNm();
								dateDup = true;
							}
						}
						if(!dateDup){
							rsrvSclngVo.setUpdtUserId(getUserId());
							rsrvSclngService.updateAtmSclRsrvSclng(rsrvSclngVo);
							result.setProcType("update");
							result.setSuccess(true);
							result.addMessage("정상적으로 수정되었습니다.");
						}else{
							result.setSuccess(false);
							result.addMessage("예약명 ("+rsrvNm+")의 예약일자와 설정하려는 예약일자가 중복되는 구간이 있습니다.");
						}
					}else{
						rsrvSclngVo.setUpdtUserId(getUserId());
						rsrvSclngService.updateAtmSclRsrvSclng(rsrvSclngVo);
						result.setProcType("update");
						result.setSuccess(true);
						result.addMessage("정상적으로 수정되었습니다.");
					}
				}

			} catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
				logger.error(e.getMessage(), e);
				result.setSuccess(false);
				result.addMessage("수정에 실패하였습니다.");
			}
	   }else{
			result.setSuccess(false);
			result.addMessage("수정에 실패하였습니다.");
	   }
		return result;
	}
	/**
	 * 스케일예약 삭제
	 *
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteSclYn.do", method = RequestMethod.POST)
	@OperateLog(action = "스케일예약 삭제", desc = "스케일예약 삭제 처리", params = {"rsrvSclngVo" }, actionType = ActionType.DELETE)
	@ResponseBody
	public ProcResultVo deleteSclYn(HttpServletRequest request, @ModelAttribute("rsrvSclngVo") RsrvSclngVo rsrvSclngVo,BindingResult bindResult) throws Exception {
		ProcResultVo result = getBindingResult(rsrvSclngVo, bindResult, UpdateProc.class);

		if (result.isSuccess()) {
			try {

				String resultmessage = rsrvSclngService.deleteSclYn(rsrvSclngVo);
				if("Y".equals(resultmessage)){
					result.setProcType("delete");
					result.setSuccess(true);
					result.addMessage(OprConstant.RX_DEL_SUCC_MSG);
				}else{
					result.setSuccess(false);
					result.addMessage(OprConstant.RX_DEL_FAIL_MSG);
				}
			} catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
				logger.error(e.getMessage(), e);
				result.setSuccess(false);
				result.addMessage(OprConstant.RX_DEL_FAIL_MSG);
			}
		}else{
			result.setSuccess(false);
			result.addMessage(OprConstant.RX_DEL_FAIL_MSG);
		}

		return result;
	}
	  /**
     * 스케일예약설정 대상 검색
     *
     * @param request
     * @param model
     * @param atmsclDistrbSearchVo
     * @return
     */
    @RequestMapping(value = "/selectDistrbListViewP.do")
    public String selectDistrbListViewP(HttpServletRequest request, Model model, AtmsclDistrbSearchVo atmsclDistrbSearchVo) {
    	atmsclDistrbSearchVo.setServcAreaClCd("02");
    	atmsclDistrbSearchVo.setCtlTrgtYn("Y");
		List<AtmsclDistrbVo> list = atmsclDistrbService.selectAtmsclDistrbListP(atmsclDistrbSearchVo);
		List<CodeVo> selectCodeList = commonService.selectCodeList("110", "311");
		model.addAttribute("title","서비스 선택");
		model.addAttribute("selectCodeList",selectCodeList);
		model.addAttribute("list", list);
		model.addAttribute("atmsclDistrbVo", atmsclDistrbSearchVo);
        return popup(request);

    }
}
