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
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.catalg.service.BaseImgService;
import ncis.cpt.opr.catalg.vo.BaseImgSearchVo;
import ncis.cpt.opr.catalg.vo.BaseImgVo;
import ncis.cpt.rsrc.atmscl.service.ServcAreaService;
import ncis.cpt.rsrc.atmscl.service.ServcService;
import ncis.cpt.rsrc.atmscl.vo.AtmsclDistrbVo;
import ncis.cpt.rsrc.atmscl.vo.BldVo;
import ncis.cpt.rsrc.atmscl.vo.ScrtkyVo;
import ncis.cpt.rsrc.atmscl.vo.ServcAreaSearchVo;
import ncis.cpt.rsrc.atmscl.vo.ServcAreaVo;
import ncis.cpt.rsrc.atmscl.vo.ServcPodVo;
import ncis.cpt.rsrc.atmscl.vo.ServcPortVo;
import ncis.cpt.rsrc.atmscl.vo.ServcRouteVo;
import ncis.cpt.rsrc.atmscl.vo.ServcSclngVo;
import ncis.cpt.rsrc.atmscl.vo.ServcSearchVo;
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
@RequestMapping(value="/cpt/rsrc/atmscl/servc")
public class ServcController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(ServcController.class);

	@Resource(name="servcAreaService")
	ServcAreaService servcAreaService;

	@Resource(name="servcService")
	ServcService servcService;

	@Resource(name = "baseImgService")
	BaseImgService baseImgService;

	@Resource(name="commonService")
	CommonService commonService;


	/**
	 * 서비스 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectServcList.do")
	public String selectServcList(HttpServletRequest request, Model model, ServcSearchVo searchVo) {
		List<ServcVo> list = servcService.selectServcList(searchVo);
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		return portalTilesView(request);
	}


	/**
	 * 서비스 목록 정보 Excel Down
	 * @param request
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/selectServcListXlsDwnl.do")
    public void selectServcListXlsDwnl(HttpServletRequest request, HttpServletResponse response, ServcSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();

        header.put("institutionNm", "부처명");
        header.put("jobNm", "업무명");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망");
        header.put("rsrcPoolNm", "자원풀");
        header.put("servcAreaNm", "서비스영역명");
        header.put("ServcNm", "서비스명");
        header.put("podQty", "Pod수");
        header.put("sumCpuCorQty", "CPU Core");
        header.put("avgCpuUseRt", "CPU 사용률(%)");
        header.put("sumMemAsgnCapa", "메모리 할당량(GB)");
        header.put("avgMemUseRt", "메모리 사용률(%)");
        header.put("netwkIn", "네트워크 In(KB/Sec)");
        header.put("netwkOut", "네트워크 Out(KB/Sec)");
        header.put("creDttm", "생성일자");

        List<ServcVo> list = servcService.selectServcList(searchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("서비스관리");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response,String.format("서비스관리_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }


	/**
	 * 서비스 화면
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/insertServcView.do", method=RequestMethod.GET)
	public String insertServc(HttpServletRequest request, Model model){

		model.addAttribute("servcVo", new ServcVo());
		return portalTilesView(request, "insertServc");
	}


	/**
	 * 보안키 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectScrtKyList.do")
	@ResponseBody
	public ProcResultVo selectScrtKyList(HttpServletRequest request, Model model, @RequestParam(required=true) Integer servcAreaSeq) throws Exception {
		ProcResultVo result = new ProcResultVo();
		List<ScrtkyVo> list = servcService.selectScrtKyList(servcAreaSeq);
		result.setData(list);
		result.setSuccess(true);
		return result;
	}


	/**
	 * 보안키생성 팝업화면
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/insertScrtkyP.do")
	public String insertScrtkyP(HttpServletRequest request, Model model, ScrtkyVo scrtkyVo) {

		model.addAttribute("scrtkyVo", scrtkyVo);
		model.addAttribute("title","보안키 생성");
		return popup(request, "insertScrtkyP");
	}


	/**
	 * 보안키 생성
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="보안키생성", desc="보안키생성 처리", params={"ScrtkyVo"}, actionType=ActionType.INSERT)
	@RequestMapping(value="/insertScrtky.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo insertScrtky(@ModelAttribute("vo") ScrtkyVo scrtkyVo) throws Exception{

		ProcResultVo result = new ProcResultVo();

		try {

			String resultmessage = servcService.insertScrtky(scrtkyVo);
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
	 * 서비스영역 조회 팝업 화면 호출
	 * @param request
	 * @param model
	 * @return
	 */
	 @RequestMapping(value = "/selectServcAreaListPView")
	 public String selectServcAreaListPView(HttpServletRequest request, Model model, ServcAreaSearchVo searchVo){

		searchVo.setServcAreaClCd("02");
		searchVo.setCtlTrgtYn("Y");
		List<ServcAreaVo> list = servcAreaService.selectServcAreaList(searchVo);

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("title","서비스영역 선택");
		return popup(request, "selectServcAreaListP");
	 }


	 /**
	 * 베이스이미지 조회 팝업 화면 호출
	 * @param request
	 * @param model
	 * @return
	 */
	 @RequestMapping(value = "/selectBaseImgListPView")
	 public String selectBaseImgListPView(HttpServletRequest request, Model model, BaseImgSearchVo searchVo){

		 searchVo.setBasImgYn("Y");
		 searchVo.setUseYn("Y");
		 searchVo.setRegionId(searchVo.getRegionId());
		 searchVo.setZoneId(searchVo.getZoneId());
		 searchVo.setNetClCd(searchVo.getNetClCd());
		 searchVo.setRsrcPoolId(searchVo.getRsrcPoolId());

		 List<BaseImgVo> list = baseImgService.selectBaseImgList(searchVo);

		 model.addAttribute("list", list);
		 model.addAttribute("searchVo", searchVo);
		 model.addAttribute("title","베이스이미지 선택");
		 return popup(request, "selectBaseImgListP");
	 }


	/**
	 * 서비스 생성
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="서비스생성", desc="서비스생성 처리", params={"ServcVo"}, actionType=ActionType.INSERT)
	@RequestMapping(value="/insertServc.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo insertServc(@ModelAttribute("vo") ServcVo ServcVo) throws Exception{

		ProcResultVo result = new ProcResultVo();
		ServcVo.setCreUserId(getUserId());

		try {

			String resultmessage = servcService.insertServc(ServcVo);
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
	 * 서비스  수정  조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectServc.do")
	public String updateServcArea(HttpServletRequest request, Model model, @RequestParam(required=true) int servcSeq) throws Exception {

		ServcVo servcVo = servcService.selectServc(servcSeq);

		if( ObjectUtils.isEmpty(servcVo) ) {
            throw new DataNotFoundException(messageUtil.getMessage("message.error.dataNotFound"));
        }

		model.addAttribute("servcVo", servcVo);

		return portalTilesView(request);
	}


	/**
	 * 대상포트 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectTargetPortList.do")
	@ResponseBody
	public ProcResultVo selectTargetPortList(HttpServletRequest request, Model model, @RequestParam(required=true) String rsrcPoolId, String imgId, Integer servcAreaSeq) throws Exception {
		ProcResultVo result = new ProcResultVo();
		List<BaseImgVo> baseImgPortList = servcService.selectTargetPortList(rsrcPoolId, imgId, servcAreaSeq);
		result.setData(baseImgPortList);
		result.setSuccess(true);
		return result;
	}


	/**
	 * 빌드이력 생성
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="빌드이력 생성", desc="빌드이력 생성 처리", params={"ServcVo"}, actionType=ActionType.INSERT)
	@RequestMapping(value="/insertBldHstry.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo insertBldHstry(@ModelAttribute("vo") ServcVo servcVo) throws Exception{

		ProcResultVo result = new ProcResultVo();
		servcVo.setCreUserId(getUserId());

		try {
			String resultmessage = servcService.insertBldHstry(servcVo);
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
	 * 서비스 라우트 생성 팝업화면
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/insertServcRouteP.do")
	public String insertServcRoute(HttpServletRequest request, Model model, ServcRouteVo servcRouteVo) {

		//대상포트 정보를 조회한다.
		List<ServcPortVo> servcPortList = servcService.selectServcPortList(servcRouteVo.getServcSeq());

		model.addAttribute("servcPortList", servcPortList);
		model.addAttribute("servcRouteVo", servcRouteVo);
		model.addAttribute("title","서비스 라우트 생성");
		return popup(request, "insertServcRouteP");
	}


	/**
	 * 배포 실행
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="배포 실행", desc="배포 실행 처리", params={"ServcVo"}, actionType=ActionType.INSERT)
	@RequestMapping(value="/updateDeploymentConfig.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updateDeploymentConfig(@ModelAttribute("vo") ServcVo servcVo) throws Exception{

		ProcResultVo result = new ProcResultVo();
		servcVo.setCreUserId(getUserId());

		try {

			String resultmessage = servcService.updateDeploymentConfig(servcVo);
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
	 * 서비스 라우트 생성
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="라우트 생성", desc="라우트 생성 처리", params={"ServcRouteVo"}, actionType=ActionType.INSERT)
	@RequestMapping(value="/insertServcRoute.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo insertServcRoute(@ModelAttribute("vo") ServcRouteVo servcRouteVo) throws Exception{

		ProcResultVo result = new ProcResultVo();
		servcRouteVo.setCreUserId(getUserId());

		try {
			String resultmessage = servcService.insertServcRoute(servcRouteVo);
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
	 * Pod정보 조회
	 * @param request
	 * @param model
	 * @param servcSeq
	 * @return
	 */
	@RequestMapping(value="/selectPodListT.do")
	public String selectPodListT(HttpServletRequest request, Model model, Integer servcSeq) {

		List<ServcPodVo> list = servcService.selectServcPodList(servcSeq);
		model.addAttribute("list", list);

		return jstlView(request);
	}


	/**
	 * 라우트정보 조회
	 * @param request
	 * @param model
	 * @param servcSeq
	 * @return
	 */
	@RequestMapping(value="/selectRouteListT.do")
	public String selectRouteListT(HttpServletRequest request, Model model, Integer servcSeq) {

		List<ServcRouteVo> list = servcService.selectServcRouteList(servcSeq);

		ServcRouteVo servcRouteVo = new ServcRouteVo();

		if(!ObjectUtils.isEmpty(list) ) {
			servcRouteVo.setServcSeq(servcSeq);
			servcRouteVo.setServcAreaId(list.get(0).getServcAreaId());
			servcRouteVo.setRegionId(list.get(0).getRegionId());
			servcRouteVo.setZoneId(list.get(0).getZoneId());
			servcRouteVo.setNetClCd(list.get(0).getNetClCd());
			servcRouteVo.setRsrcPoolId(list.get(0).getRsrcPoolId());
		}

		model.addAttribute("servcRouteVo", servcRouteVo);
		model.addAttribute("list", list);

		return jstlView(request);
	}


	/**
	 * 오토스케일정보 조회
	 * @param request
	 * @param model
	 * @param servcSeq
	 * @return
	 */
	@RequestMapping(value="/selectAtmSclListT.do")
	public String selectAtmSclListT(HttpServletRequest request, Model model, Integer servcSeq) {

		List<ServcSclngVo> list = servcService.selecServcSclngList(servcSeq);
		ServcSclngVo servcSclngVo = new ServcSclngVo();

		if(!ObjectUtils.isEmpty(list)) {
			servcSclngVo = list.get(0);
			model.addAttribute("list", list);
		}

		model.addAttribute("servcSclngVo", servcSclngVo);

		return jstlView(request);
	}


	/**
	 * 제한정보 조회
	 * @param request
	 * @param model
	 * @param servcSeq
	 * @return
	 */
	@RequestMapping(value="/selectLimitListT.do")
	public String selectLimitListT(HttpServletRequest request, Model model, Integer servcSeq) {

		AtmsclDistrbVo atmsclDistrbVo = servcService.selectLimit(servcSeq);

		model.addAttribute("atmsclDistrbVo", atmsclDistrbVo);
		return jstlView(request);
	}


	/**
	 * 빌드정보 조회
	 * @param request
	 * @param model
	 * @param servcSeq
	 * @return
	 */
	@RequestMapping(value="/selectBldListT.do")
	public String selectBldList(HttpServletRequest request, Model model, Integer servcSeq) {

		List<BldVo> list = servcService.selectBldList(servcSeq);
		model.addAttribute("list", list);
		return jstlView(request);
	}


	/**
	 * 배포정보 조회
	 * @param request
	 * @param model
	 * @param servcSeq
	 * @return
	 */
	@RequestMapping(value="/selectDistrbListT.do")
	public String selectDistrbListT(HttpServletRequest request, Model model, Integer servcSeq) {

		List<AtmsclDistrbVo> list = servcService.selectDistrbList(servcSeq);
		model.addAttribute("list", list);
		return jstlView(request);
	}


	/**
	 * 이미지정보 조회
	 * @param request
	 * @param model
	 * @param servcSeq
	 * @return
	 */
	@RequestMapping(value="/selectImgListT.do")
	public String selectImgListT(HttpServletRequest request, Model model, Integer servcSeq) {

		List<BaseImgVo> list = servcService.selectImgList(servcSeq);
		model.addAttribute("list", list);
		return jstlView(request);
	}


	/**
	 * 서비스 수정
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="서비스 수정", desc="서비스 수정 처리", params={"ServcVo"}, actionType=ActionType.UPDATE)
	@RequestMapping(value="/updateServc.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updateServc(@ModelAttribute("vo") ServcVo servcVo) throws Exception{

		ProcResultVo result = new ProcResultVo();
		servcVo.setUpdtUserId(getUserId());

		try {
			String resultmessage = servcService.updateServc(servcVo);

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
	 * 서비스 상태 수정
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="서비스 상태 수정", desc="서비스 상태 수정 처리", params={"ServcVo"}, actionType=ActionType.UPDATE)
	@RequestMapping(value="/selectServcStat.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo selectServcStat(@ModelAttribute("vo") ServcVo servcVo) throws Exception{

		ProcResultVo result = new ProcResultVo();
		servcVo.setUpdtUserId(getUserId());

		try {
			String resulStat = servcService.updateServcStat(servcVo);
			ServcVo vo = servcService.selectServc(servcVo.getServcSeq()); // 구성정보가 수행될수 있기 때문에 서비스 상태를 다시 조회
			result.setProcType(OprConstant.RSRC_PROC_TYPE_UPDATA);
			result.addMessage(resulStat);
			result.setSuccess(true);
			result.setData(vo);
		}catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
			logger.error(e.toString(),e);
			result.setSuccess(false);
			result.addMessage(OprConstant.RX_CRE_FAIL_MSG   + ", error="+ e.getMessage());
		}

		return result;
	}


	/**
	 * 서비스 삭제
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="서비스 삭제", desc="서비스 삭제 처리", params={"ServcVo"}, actionType=ActionType.DELETE)
	@RequestMapping(value="/deleteServc.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo deleteServc(@ModelAttribute("vo") ServcVo servcVo) throws Exception{

		ProcResultVo result = new ProcResultVo();
		servcVo.setDelUserId(getUserId());

		try {
			String resultmessage = servcService.deleteServc(servcVo);
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
	 * 라우트 삭제
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="라우트 삭제", desc="라우트 삭제 처리", params={"RouteVo"}, actionType=ActionType.DELETE)
	@RequestMapping(value="/deleteServcRoute.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo deleteServcRoute(@ModelAttribute("vo") ServcRouteVo servcRouteVo) throws Exception{

		ProcResultVo result = new ProcResultVo();

		try {
			String resultmessage = servcService.deleteServcRoute(servcRouteVo);
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
}
