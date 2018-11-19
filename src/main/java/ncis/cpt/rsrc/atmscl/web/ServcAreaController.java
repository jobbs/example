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
import ncis.cmn.exception.CommonException;
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.catalg.service.SpecService;
import ncis.cpt.opr.catalg.vo.SpecSvo;
import ncis.cpt.opr.catalg.vo.SpecVo;
import ncis.cpt.rsrc.atmscl.service.ServcAreaService;
import ncis.cpt.rsrc.atmscl.vo.PvSearchVo;
import ncis.cpt.rsrc.atmscl.vo.PvVo;
import ncis.cpt.rsrc.atmscl.vo.ServcAreaSearchVo;
import ncis.cpt.rsrc.atmscl.vo.ServcAreaVo;
import ncis.cpt.rsrc.atmscl.vo.ServcVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;

import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/cpt/rsrc/atmscl/servcarea")
public class ServcAreaController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(ServcAreaController.class);

	@Resource(name="servcAreaService")
	ServcAreaService servcAreaService;

	@Resource(name="specService")
	private SpecService specService;

	@Resource(name="commonService")
	CommonService commonService;


	/**
	 * 서비스영역 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectServcAreaList.do")
	public String selectServcAreaList(HttpServletRequest request, Model model, ServcAreaSearchVo searchVo) {
		List<ServcAreaVo> list = servcAreaService.selectServcAreaList(searchVo);
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		return portalTilesView(request);
	}


	/**
	 * 서비스영역  수정  조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectServcArea.do")
	public String updateServcArea(HttpServletRequest request, Model model, @RequestParam(required=true) int servcAreaSeq) throws Exception {

		ServcAreaVo servcAreaVo = servcAreaService.selectServcArea(servcAreaSeq);

		if( ObjectUtils.isEmpty(servcAreaVo) ) {
            throw new DataNotFoundException(messageUtil.getMessage("message.error.dataNotFound"));
        }

		model.addAttribute("servcAreaVo", servcAreaVo);

		//서비스정보
		List<ServcVo> servcList = servcAreaService.selectServcList(servcAreaSeq);
		model.addAttribute("servcList", servcList);

		//PV정보
		PvSearchVo pvSearchVo = new PvSearchVo();
		pvSearchVo.setServcAreaSeq(servcAreaSeq);
		List<PvVo> pvList = servcAreaService.selectPvList(pvSearchVo);

		model.addAttribute("pvList", pvList);

		return portalTilesView(request);
	}



	/**
	 * 서비스영역 수정
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="서비스영역 수정", desc="서비스영역 수정 처리", params={"ServcAreaVo"}, actionType=ActionType.INSERT)
	@RequestMapping(value="/updateServcArea.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updateServcArea(@ModelAttribute("vo") ServcAreaVo servcAreaVo) throws Exception{

		ProcResultVo result = new ProcResultVo();
		servcAreaVo.setUpdtUserId(getUserId());

		try {

			String resultmessage = servcAreaService.updateServcArea(servcAreaVo);
			result.setProcType(OprConstant.RSRC_PROC_TYPE_UPDATA);
			result.addMessage(resultmessage);
			result.setSuccess(true);
		}catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
			logger.error(e.toString(),e);
			result.setSuccess(false);
			result.addMessage(OprConstant.RX_CRE_FAIL_MSG   + ", error="+ e.getMessage());
		}

		return result;
	}


	/**
	 * 서비스영역 목록 정보 Excel Down
	 * @param request
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/selectServcAreaListXlsDwnl.do")
    public void selectServcAreaListXlsDwnl(HttpServletRequest request, HttpServletResponse response, ServcAreaSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("institutionNm", "부처명");
        header.put("jobNm", "업무명");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망구분");
        header.put("rsrcPoolNm", "자원풀");
        header.put("servcAreaNm", "서비스영역명");
        header.put("servcAreaId", "서비스영역ID");
        header.put("servcAreaCompId", "서비스영역구성ID");
        header.put("creUserNm", "생성자");
        header.put("creDttm", "생성일자");
        header.put("updtUserNm", "수정자");
        header.put("updtDttm", "수정일자");

        List<ServcAreaVo> list = servcAreaService.selectServcAreaList(searchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("서비스영역관리");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response,String.format("서비스영역관리_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }


	/**
	 * 서비스영역생성 화면
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/insertServcAreaView.do", method=RequestMethod.GET)
	public String insertServcArea(HttpServletRequest request, Model model){

		model.addAttribute("servcAreaVo", new ServcAreaVo());
		return portalTilesView(request, "insertServcArea");
	}


	/**
	 * 서비스영역 생성
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="서비스영역 생성", desc="서비스영역 생성 처리", params={"ServcAreaVo"}, actionType=ActionType.INSERT)
	@RequestMapping(value="/insertServcArea.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo insertServcArea(@ModelAttribute("vo") ServcAreaVo servcAreaVo) throws Exception{

		ProcResultVo result = new ProcResultVo();
		servcAreaVo.setCreUserId(getUserId());

		try {

			String resultmessage = servcAreaService.insertServcArea(servcAreaVo);
			result.setProcType(OprConstant.RSRC_PROC_TYPE_UPDATA);
			result.addMessage(resultmessage);
			result.setSuccess(true);
		}catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
			logger.error(e.toString(),e);
			result.setSuccess(false);
			result.addMessage(OprConstant.RX_CRE_FAIL_MSG   + ", error="+ e.getMessage());
		}

		return result;
	}


	/**
	 * 자동확장 스펙 조회 팝업 화면 호출
	 * @param request
	 * @param model
	 * @return
	 */
	 @RequestMapping(value = "/selectAtmSclSpecListPView")
	 public String selectAtmSclVmListPView(HttpServletRequest request, Model model, SpecSvo svo){

		 svo.setClCd("02"); //구분코드(자동확장)
		 List<SpecVo> list = specService.selectSpecList(svo);

		 model.addAttribute("specList", list);
		 model.addAttribute("searchVo", svo);
		 model.addAttribute("title","스펙 선택");
		 return popup(request, "selectAtmSclSpecListP");
	 }


	/**
	 * 스토리지선택 팝업화면
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/selectPvListP.do")
	public String selectPvListP(HttpServletRequest request, Model model, PvSearchVo searchVo) {

		List<PvVo> pvList = servcAreaService.selectPvList(searchVo);
		model.addAttribute("list", pvList);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("title","스토리지 추가");
		return popup(request, "selectPvListP");
	}


	/**
	 * 서비스영역 PV할당
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="서비스영역 PV할당", desc="서비스영역 PV할당 처리", params={"ServcAreaVo"}, actionType=ActionType.UPDATE)
	@RequestMapping(value="/insertServcAreaPvAsgn.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo insertServcAreaPvAsgn(@ModelAttribute("vo") ServcAreaVo servcAreaVo) throws Exception{

		ProcResultVo result = new ProcResultVo();

		try {
			String resultmessage = servcAreaService.updatePv(servcAreaVo);
			result.setProcType(OprConstant.RSRC_PROC_TYPE_UPDATA);
			result.addMessage(resultmessage);
			result.setSuccess(true);
		}catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
			logger.error(e.toString(),e);
			result.setSuccess(false);
			result.addMessage(OprConstant.RX_CRE_FAIL_MSG   + ", error="+ e.getMessage());
		}

		return result;
	}


	/**
	 * 서비스영역 PV할당 삭제
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="서비스영역 PV할당 삭제", desc="서비스영역 PV할당 삭제 처리", params={"PvVo"}, actionType=ActionType.UPDATE)
	@RequestMapping(value="/deleteServcAreaPvAsgn.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo deleteServcAreaPvAsgn(@ModelAttribute("pvVo") PvVo pvVo) throws Exception{

		ProcResultVo result = new ProcResultVo();

		try {
			String resultmessage = servcAreaService.deletePv(pvVo);
			result.setProcType(OprConstant.RSRC_PROC_TYPE_UPDATA);
			result.addMessage(resultmessage);
			result.setSuccess(true);
		}catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
			logger.error(e.toString(),e);
			result.setSuccess(false);
			result.addMessage(OprConstant.RX_CRE_FAIL_MSG   + ", error="+ e.getMessage());
		}

		return result;
	}


	/**
	 * 서비스영역 삭제
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateServcAreaDeleteYn.do", method = RequestMethod.POST)
	@OperateLog(action = "서비스영역 삭제여부 수정", desc = "서비스영역 삭제여부 수정 처리", params = {
			"ServcAreaVo" }, actionType = ActionType.DELETE)
	@ResponseBody
	public ProcResultVo updateServcAreaDeleteYn(HttpServletRequest request,
			@ModelAttribute("servcAreaVo") ServcAreaVo servcAreaVo) throws Exception{

		ProcResultVo result = new ProcResultVo();
		result.setProcType("update");
		try {
			servcAreaVo.setDelUserId(getUserId());
			String resultmessage = servcAreaService.updateServcAreaDeleteYn(servcAreaVo);
			result.setSuccess(true);
			result.addMessage(resultmessage);
		}catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException | CommonException e) {
			logger.error(e.getMessage(), e);
			result.setSuccess(false);
			result.addMessage(OprConstant.RX_DEL_FAIL_MSG   + ", error="+ e.getMessage());
		}

		return result;
	}

}
