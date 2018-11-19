/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PrcssController.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 9. 30.
 * @lastmodified 2016. 9. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 30.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.catalg.service.PrcssService;
import ncis.cpt.opr.catalg.vo.PrcssSearchVo;
import ncis.cpt.opr.catalg.vo.PrcssVo;
import ncis.cpt.opr.catalg.vo.ProcssVarVo;
import ncis.cpt.opr.catalg.vo.UnitJobRelateVo;
import ncis.cpt.opr.catalg.vo.UnitJobVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 이화영
 *
 */
@Controller
@RequestMapping(value="/cpt/opr/catalg/prcss")
public class PrcssController extends BaseController{

	@Resource(name="prcssService")
	PrcssService prcssService;


	/**
	 * 프로세스 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectPrcssList.do")
	public String selectPrcssList(HttpServletRequest request, Model model, PrcssSearchVo searchVo){

		List<PrcssVo> list = prcssService.selectPrcssList(searchVo);	// 프로세스list 가져오기

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);

		return portalTilesView(request);
	}

	/**
	 * 프로세스 상세 조회
	 * @param procssSeq 프로세스Id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/selectPrcss.do")
	public String selectPrcss(HttpServletRequest request, Model model, @RequestParam(required = true) BigDecimal procssSeq){

		PrcssVo vo = prcssService.selectPrcss(procssSeq);//프로세스 기본정보
		List<UnitJobVo> unitJobList = prcssService.unitJobList(procssSeq);//단위업무 정보
		List<UnitJobRelateVo> unitJobRelateList = prcssService.unitJobRelateList(procssSeq);//단위업무 관계
		List<ProcssVarVo> procssVarList = prcssService.procssVarList(procssSeq);//프로세스 변수

		model.addAttribute("vo", vo);
		model.addAttribute("unitJobList", unitJobList);
		model.addAttribute("unitJobRelateList", unitJobRelateList);
		model.addAttribute("procssVarList", procssVarList);

		return portalTilesView(request);
	}

	/**
	 * 프로세스 목록 정보 Excel Down
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/selectPrcssListXlsDwnl.do")
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response, PrcssSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

	   //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
	    header.put("procssSeq", "프로세스ID");
	    header.put("procssNm", "프로세스명");
	    header.put("prcssDc", "설명");
        header.put("regUserNm", "등록자");
        header.put("regDt", "등록일자");

        List<PrcssVo> list = prcssService.selectPrcssExcelList(searchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("프로세스 목록");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("프로세스_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }



}
