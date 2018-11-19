/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TmplatController.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 5.
 * @lastmodified 2016. 10. 5.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 5.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.web;

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

import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.catalg.service.RoutingScriptService;
import ncis.cpt.opr.catalg.service.TmplatService;
import ncis.cpt.opr.catalg.vo.RoutingScriptSearchVo;
import ncis.cpt.opr.catalg.vo.RoutingScriptVo;
import ncis.cpt.opr.catalg.vo.TmplatSvo;
import ncis.cpt.opr.catalg.vo.TmplatSwVo;
import ncis.cpt.opr.catalg.vo.TmplatVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @author 송승규
 *
 */
@Controller
@RequestMapping("/cpt/opr/catalg/tmplat")
public class TmplatController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(TmplatController.class);

	@Resource(name="tmplatService")
	private TmplatService tmplatService;

	@Resource(name="routingScriptService")
	private RoutingScriptService routingScriptService;

	@Resource(name="commonService")
	CommonService commonService;

	/**
	 * 템플릿목록조회
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/selectTmplatList.do")
	public String selectTmplatList(HttpServletRequest request, Model model, TmplatSvo svo){

		List<TmplatVo> list = tmplatService.selectTmplatList(svo);
		List<CodeVo> osBitCode = commonService.selectCodeList("004", "103", true);
		List<CodeVo> tmplatClCdCode = commonService.selectCodeList("016", "115", true);
		List<CodeVo> vrlzSwTyCdCode = commonService.selectCodeList("001", "100", true);
		List<CodeVo> osTyCdCode = commonService.selectCodeList("003", "102", true);

		model.addAttribute("searchVo", svo);
		model.addAttribute("tmplatList", list);
		model.addAttribute("osBitCode", osBitCode);
		model.addAttribute("tmplatClCdCode", tmplatClCdCode);
		model.addAttribute("vrlzSwTyCdCode", vrlzSwTyCdCode);
		model.addAttribute("osTyCdCode", osTyCdCode);

		return portalTilesView(request);
	}

	/**
	 * 템플릿상세조회
	 * @param request
	 * @param model
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/selectTmplat.do", method=RequestMethod.GET)
	public String selectTmplatDetail(HttpServletRequest request, Model model, TmplatVo vo){

		TmplatVo resultVo = tmplatService.selectTmplatDetail(vo);
		List<CodeVo> osBitCode = commonService.selectCodeList("004", "103", false);
		List<CodeVo> tmplatClCdCode = commonService.selectCodeList("016", "115", false);
		List<CodeVo> vrlzSwTyCdCode = commonService.selectCodeList("001", "100", false);
		List<CodeVo> osTyCdCode = commonService.selectCodeList("003", "102", false);
		List<CodeVo> langCode = commonService.selectCodeList("017", "116", false);
		List<CodeVo> prposCode = commonService.selectCodeList("019", "118", false);

		model.addAttribute("vo", resultVo);
		model.addAttribute("osBitCode", osBitCode);
		model.addAttribute("tmplatClCdCode", tmplatClCdCode);
		model.addAttribute("vrlzSwTyCdCode", vrlzSwTyCdCode);
		model.addAttribute("osTyCdCode", osTyCdCode);
		model.addAttribute("langCode", langCode);
		model.addAttribute("prposCode", prposCode);

		return portalTilesView(request, "selectTmplat");
	}

	/**
	 * 템플릿 사용 수정
	 * @param vo
	 * @return
	 */
	@OperateLog(action="템플릿 사용 수정", desc="템플릿 사용 수정 처리", params={"TmplatSvo"}, actionType=ActionType.UPDATE)
	@RequestMapping(value="/updateTmplatUseY.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updateTmplatUseY(@ModelAttribute("svo") TmplatSvo svo) throws Exception {

		ProcResultVo result = new ProcResultVo();
		if(svo.getUpdtCheck().size() > 0){
			try {
				tmplatService.updateTmplatUseY(svo);
				result.setProcType("update");
				result.setSuccess(true);
	        } catch (NullPointerException ne) {
	        	result.setSuccess(false);
	        	result.addMessage("템플릿 사용 처리에 실패하였습니다.");
	        	logger.error("NullPointerException", ne);
	        } catch (RuntimeException re) {
	        	result.setSuccess(false);
	        	result.addMessage("템플릿 사용 처리에 실패하였습니다.");
	        	logger.error("RuntimeException", re);
	        } catch (Exception e) {
	        	result.setSuccess(false);
	        	result.addMessage("템플릿 사용 처리에 실패하였습니다.");
	        	logger.error("Exception", e);
	        }
		}
		return result;
	}

	/**
	 * 템플릿 미사용 수정
	 * @param vo
	 * @return
	 */
	@OperateLog(action="템플릿 미사용 수정", desc="템플릿 미사용 수정 처리", params={"TmplatSvo"}, actionType=ActionType.UPDATE)
	@RequestMapping(value="/updateTmplatUseN.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updateTmplatUseN(@ModelAttribute("svo") TmplatSvo svo) throws Exception {

		ProcResultVo result = new ProcResultVo();

		if(svo.getUpdtCheck().size() > 0){
			try {
				tmplatService.updateTmplatUseN(svo);
				result.setProcType("update");
				result.setSuccess(true);
	        } catch (NullPointerException ne) {
	        	result.setSuccess(false);
	        	result.addMessage("템플릿 미사용 처리에 실패하였습니다.");
	        	logger.error("NullPointerException", ne);
	        } catch (RuntimeException re) {
	        	result.setSuccess(false);
	        	result.addMessage("템플릿 미사용 처리에 실패하였습니다.");
	        	logger.error("RuntimeException", re);
	        } catch (Exception e) {
	        	result.setSuccess(false);
	        	result.addMessage("템플릿 미사용 처리에 실패하였습니다.");
	        	logger.error("Exception", e);
	        }
		}
		return result;
	}

	/**
	 * 템플릿상세수정
	 * @param vo
	 * @return
	 */
	@OperateLog(action="템플릿 수정", desc="템플릿 수정 처리", params={"TmplatVo"}, actionType=ActionType.UPDATE)
	@RequestMapping(value="/updateTmplat.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updateTmplat(@ModelAttribute("vo") TmplatVo vo) throws NullPointerException, RuntimeException, Exception {

		ProcResultVo result = new ProcResultVo();
		vo.setUpdtUserId(getUserId());

		try {
			tmplatService.updateTmplatDetail(vo);
			result.setProcType("update");
			result.setSuccess(true);
        } catch (NullPointerException ne) {
        	result.setSuccess(false);
        	result.addMessage("템플릿 수정에 실패하였습니다.");
        	logger.error("NullPointerException", ne);
        } catch (RuntimeException re) {
        	result.setSuccess(false);
        	result.addMessage("템플릿 수정에 실패하였습니다.");
        	logger.error("RuntimeException", re);
        } catch (Exception e) {
        	result.setSuccess(false);
        	result.addMessage("템플릿 수정에 실패하였습니다.");
        	logger.error("Exception", e);
        }

		return result;
	}

	/**
	 * 템플릿 엑셀다운로드
	 * @param request
	 * @param response
	 * @param searchVo
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	@RequestMapping(value = "/selectTmplatListXlsDwnl.do")
    public void selectTmplatListXlsDwnl(HttpServletRequest request, HttpServletResponse response, TmplatSvo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

		tmplatService.selectTmplatList(searchVo);
		searchVo.getPaginationInfo().setRecordCountPerPage(searchVo.getPaginationInfo().getTotalRecordCount());

		List<TmplatVo> list = tmplatService.selectTmplatList(searchVo);
        // CusomSheet 생성
        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // 첫번째 Sheet Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("useYn", "사용여부");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망");
        header.put("rsrcPoolNm", "자원풀");
        header.put("tmplatId", "템플릿ID");
        header.put("tmplatNm", "템플릿명");
        header.put("tmplatClCd", "템플릿구분");
        header.put("tmplatVer", "템플릿버전");
        header.put("vrlzSwTyCd", "가상화SW");
        header.put("osTyCd", "OS 유형");
        header.put("osNm", "운영체제");
        header.put("osVer", "OS 버전");
        header.put("prpos", "용도");
        header.put("pltfrm", "Platform");
        header.put("osBit", "OS Bit");
        header.put("krnlVer", "Kernel");
        header.put("lang", "언어");
        header.put("strgAsgnCapa", "스토리지(GB)");
        header.put("regDt", "생성일자");

        // Sheet Vo 생성
        List<TmplatVo> datas = new ArrayList<TmplatVo>();
        for (TmplatVo tmplatVo : list) {
        	TmplatVo vo = new TmplatVo();

        	if(("Y").equals(tmplatVo.getUseYn())){
        		vo.setUseYn("사용");
        	}else if(("N").equals(tmplatVo.getUseYn())){
        		vo.setUseYn("미사용");
        	}else{
        		vo.setUseYn(tmplatVo.getUseYn());
        	}
            vo.setRegionNm(tmplatVo.getRegionNm());
            vo.setZoneNm(tmplatVo.getZoneNm());
            vo.setNetNm(tmplatVo.getNetNm());
            vo.setRsrcPoolNm(tmplatVo.getRsrcPoolNm());
            vo.setTmplatId(tmplatVo.getTmplatId());
            vo.setTmplatNm(tmplatVo.getTmplatNm());
            vo.setTmplatClCd(tmplatVo.getTmplatClCd());
            vo.setTmplatVer(tmplatVo.getTmplatVer());
            vo.setVrlzSwTyCd(tmplatVo.getVrlzSwTyCd());
        	vo.setOsTyCd(tmplatVo.getOsTyCd());
        	vo.setOsNm(tmplatVo.getOsNm());
            vo.setOsVer(tmplatVo.getOsVer());
            vo.setPrpos(tmplatVo.getPrpos());
            vo.setPltfrm(tmplatVo.getPltfrm());
            vo.setOsBit(tmplatVo.getOsBit());
            vo.setKrnlVer(tmplatVo.getKrnlVer());
            vo.setLang(tmplatVo.getLang());
            vo.setStrgAsgnCapa(tmplatVo.getStrgAsgnCapa());
            if(!("").equals(tmplatVo.getRegDttm()) && tmplatVo.getRegDttm() != null){
            	vo.setRegDt((new SimpleDateFormat("yyyy-MM-dd")).format(tmplatVo.getRegDttm()));
            }
            datas.add(vo);
        }

        // Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("Tmplat");
        sheet.setDatas(datas);
        sheet.setHreader(header);

        sheets.add(sheet);

        // Excel 생성
        ExcelUtil.downloadExcel(response, String.format("템플릿_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

	/**
     * 소프트웨어 목록팝업
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/selectSwListP.do")
    public String selectSwPopup(HttpServletRequest request, Model model, TmplatSvo svo) {

        List<TmplatSwVo> list = tmplatService.selectSwList(svo);

        model.addAttribute("title", "소프트웨어");
        model.addAttribute("searchVo", svo);
        model.addAttribute("list", list);

        return popup(request);
    }

	/**
	 * 스태틱라우팅 스크립트 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectScriptListP.do")
	public String selectPrcssList(HttpServletRequest request, Model model, RoutingScriptSearchVo searchVo){

		searchVo.setSearchUseYn("Y");
		List<RoutingScriptVo> list = routingScriptService.selectScriptList(searchVo);

		CodeVo code = commonService.selectCode(searchVo.getSearchOSType(), "003");
		String osTyNm = "";
		if( null != code )
			osTyNm = code.getCdNm();

		model.addAttribute("title", "스태틱라우팅 스트립트[" + osTyNm + "]");
		model.addAttribute("list", list);
		model.addAttribute("osTyNm", osTyNm);
		model.addAttribute("searchVo", searchVo);

		return popup(request);
	}
}
