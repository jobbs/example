/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SpecController.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     송승규         v1.0             최초생성
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

import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.catalg.service.SpecService;
import ncis.cpt.opr.catalg.vo.SpecSvo;
import ncis.cpt.opr.catalg.vo.SpecVo;
import ncis.cpt.sys.code.vo.CodeSearchVo;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 송승규
 *
 */
@Controller
@RequestMapping("/cpt/opr/catalg/spec")
public class SpecController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SpecController.class);

	@Resource(name="specService")
	private SpecService specService;

	@Resource(name="commonService")
	CommonService commonService;

	/**
	 * 스펙 목록조회
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/selectSpecList.do")
	public String selectSpecList(HttpServletRequest request, Model model, SpecSvo svo){

		List<SpecVo> list = specService.selectSpecList(svo);
		List<CodeVo> codes = commonService.selectCodeList("003", "021", true);

		model.addAttribute("specList", list);
		model.addAttribute("searchVo", svo);
	    model.addAttribute("code", codes);

		return portalTilesView(request);
	}

	/**
	 * 스펙 상세조회
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/selectSpec.do", method=RequestMethod.GET)
	public String selectSpecAix(HttpServletRequest request, Model model, SpecVo vo){

		SpecVo resultVo = specService.selectSpecDetail(vo);

		if( ObjectUtils.isEmpty(resultVo) ) {
            throw new DataNotFoundException(messageUtil.getMessage("message.error.dataNotFound"));
        }


		List<CodeVo> codes = commonService.selectCodeList("003", "102", false);
//		List<CodeVo> codes = commonService.selectCodeList("003", "120", false);

		model.addAttribute("vo", vo);
		model.addAttribute("resultVo", resultVo);
		model.addAttribute("code", codes);


		if(resultVo.getSpecClCd().equals("01")){
			return portalTilesView(request, "selectSpecLinux");
		}else if(resultVo.getSpecClCd().equals("02")){
			return portalTilesView(request, "selectSpecHp");
		}else if(resultVo.getSpecClCd().equals("03")){
			return portalTilesView(request, "selectSpecAix");
		}else if(resultVo.getSpecClCd().equals("04")){
			return portalTilesView(request, "selectSpecWin");
		}else if(resultVo.getSpecClCd().equals("05")){
			return portalTilesView(request, "selectSpecX86");
		}else if(resultVo.getSpecClCd().equals("09")){
			return portalTilesView(request, "selectSpecSolaris");
		}else {
			return portalTilesView(request, "selectSpecAtmScl");
		}
	}

	/**
	 * 스펙 상세수정
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="스펙 수정", desc="스펙 수정 처리", params={"SpecVo"}, actionType=ActionType.UPDATE)
	@RequestMapping(value="/updateSpec.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updateSpecDetail(@ModelAttribute("vo") SpecVo vo) throws Exception{

		ProcResultVo result = new ProcResultVo();
		vo.setUpdtUserId(getUserId());

		try {
			result = specService.updateSpecDetail(vo);
        }catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
        	logger.error(e.getMessage(), e);
        	result.setSuccess(false);
        	result.addMessage("스펙 수정에 실패하였습니다.");
        }

		return result;
	}

	/**
	 * 스펙생성 초기화면 (자동확장)
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/insertSpecAtmScl.do", method=RequestMethod.GET)
	public String insertSpec(HttpServletRequest request, Model model){

		List<CodeVo> codes = commonService.selectCodeList("003", "102",false);
		//List<CodeVo> codes = commonService.selectCodeList("003", "120",false);

		model.addAttribute("vo", new SpecVo());
		model.addAttribute("code", codes);

		return portalTilesView(request, "insertSpecAtmScl");
	}

	/**
	 * 스펙생성 초기화면 (AIX)
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/insertSpecAix.do", method=RequestMethod.GET)
	public String insertSpecAixView(HttpServletRequest request, Model model){

		List<CodeVo> codes = commonService.selectCodeList("003", "102",false);
		//List<CodeVo> codes = commonService.selectCodeList("003", "120",false);
		model.addAttribute("vo", new SpecVo());
		model.addAttribute("code", codes);

		return portalTilesView(request, "insertSpecAix");
	}

	/**
	 * 스펙생성 초기화면 (HP-UX)
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/insertSpecHp.do", method=RequestMethod.GET)
	public String insertSpecHpView(HttpServletRequest request, Model model){

		List<CodeVo> codes = commonService.selectCodeList("003", "102",false);
		//List<CodeVo> codes = commonService.selectCodeList("003", "120",false);
		model.addAttribute("vo", new SpecVo() );
		model.addAttribute("code", codes);

		return portalTilesView(request, "insertSpecHp");
	}

	/**
	 * 스펙생성 초기화면 (x86)
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/insertSpecX86.do", method=RequestMethod.GET)
	public String insertSpecX86View(HttpServletRequest request, Model model){

		List<CodeVo> codes = commonService.selectCodeList("003", "102",false);
		//List<CodeVo> codes = commonService.selectCodeList("003", "120",false);

		model.addAttribute("vo", new SpecVo() );
		model.addAttribute("code", codes);

		return portalTilesView(request, "insertSpecX86");
	}


	/**
	 * 스펙생성 초기화면 (Linux)
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/insertSpecLinux.do", method=RequestMethod.GET)
	public String insertSpecLinuxView(HttpServletRequest request, Model model){

		List<CodeVo> codes = commonService.selectCodeList("102", "003",false);

		model.addAttribute("vo", new SpecVo() );
		model.addAttribute("code", codes);

		return portalTilesView(request, "insertSpecLinux");
	}

	/**
	 * 스펙생성 초기화면 (Windows)
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/insertSpecWin.do", method=RequestMethod.GET)
	public String insertSpecWinView(HttpServletRequest request, Model model){

		List<CodeVo> codes = commonService.selectCodeList("102", "003",false);

		model.addAttribute("vo", new SpecVo() );
		model.addAttribute("code", codes);

		return portalTilesView(request, "insertSpecWin");
	}
	
	/**
	 * 스펙생성 초기화면 (Solaris)
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/insertSolaris.do", method=RequestMethod.GET)
	public String insertSpecSolarisView(HttpServletRequest request, Model model){

		List<CodeVo> codes = commonService.selectCodeList("003", "102",false);
		//List<CodeVo> codes = commonService.selectCodeList("003", "120",false);
		model.addAttribute("vo", new SpecVo());
		model.addAttribute("code", codes);

		return portalTilesView(request, "insertSpecSolaris");
	}


	/**
	 * 스펙 생성
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="스펙 생성", desc="스펙 생성 처리", params={"SpecVo"}, actionType=ActionType.INSERT)
	@RequestMapping(value="/insertSpec.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo insertSpec(@ModelAttribute("vo") SpecVo specVo) throws Exception{

		ProcResultVo result = new ProcResultVo();

		specVo.setCreUserId(getUserId());
		// 2016.12.14 수정자는 수정시에만 입력.
		//specVo.setUpdtUserId(getUserId());

		try {
			result = specService.insertSpec(specVo);
        }catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
        	logger.error(e.getMessage(), e);
        	result.setSuccess(false);
        	result.addMessage("스펙 생성에 실패하였습니다.");
        }

		return result;
	}

	/**
	 * 스펙 삭제
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="스펙 삭제", desc="스펙 삭제 처리", params={"SpecSvo"}, actionType=ActionType.DELETE)
	@RequestMapping(value="/deleteSpec.do")
	@ResponseBody
	public ProcResultVo deleteSpec(@ModelAttribute("vo") SpecSvo specSvo) throws Exception{

		ProcResultVo result = new ProcResultVo();

		try {
			specService.deleteSpec(specSvo);
			result.setProcType("delete");
			result.setSuccess(true);
        }catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
        	logger.error(e.getMessage(), e);
        	result.setSuccess(false);
        	result.addMessage("스펙 삭제에 실패하였습니다.");
        }

		return result;
	}

	/**
	 * 스펙 엑셀다운로드
	 * @param request
	 * @param response
	 * @param searchVo
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	@RequestMapping(value = "/selectSpecListXlsDwnl.do")
    public void selectSpecListXlsDwnl(HttpServletRequest request, HttpServletResponse response, SpecSvo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

		specService.selectSpecList(searchVo);
		searchVo.getPaginationInfo().setRecordCountPerPage(searchVo.getPaginationInfo().getTotalRecordCount());

		List<SpecVo> list = specService.selectSpecList(searchVo);
        // CusomSheet 생성
        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // 첫번째 Sheet Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("clCdNm", "구분");
        header.put("specClCdNm", "분류");
        header.put("specNm", "스펙명");

        header.put("vcoreMinVl", "최소 CPU(Core)");
        header.put("vcoreMaxl", "최대 CPU(Core)");
        header.put("memMinVl", "최소 메모리(GB)");
        header.put("memMaxVl", "최대 메모리(GB)");

        header.put("cpuVcore", "기본 CPU(Core)");
        header.put("ent", "Entitlement");
        header.put("mem", "기본 메모리(GB)");
        header.put("strgDfltVl", "스토리지(GB)");
        header.put("creUserNm", "생성자");
        header.put("creDate", "생성일자");
        header.put("updtUserNm", "수정자");
        header.put("updtDate", "수정일자");

        // Sheet Vo 생성
        List<SpecVo> datas = new ArrayList<SpecVo>();
        for (SpecVo specVo : list) {
        	SpecVo vo = new SpecVo();
        	vo.setClCdNm(specVo.getClCdNm());
    		vo.setSpecClCdNm(specVo.getSpecClCdNm());
            vo.setSpecNm(specVo.getSpecNm());
            vo.setVcoreMinVl(specVo.getVcoreMinVl());
            vo.setVcoreMaxVl(specVo.getVcoreMaxVl());
            vo.setMemMaxVl(specVo.getMemMaxVl());
            vo.setMemMaxVl(specVo.getMemMaxVl());
            vo.setCpuVcore(specVo.getCpuVcore());
            vo.setEnt(specVo.getEnt());
            vo.setMem(specVo.getMem());
            vo.setStrgDfltVl(specVo.getStrgDfltVl());
            vo.setCreUserNm(specVo.getCreUserNm());
            vo.setCreDate((new SimpleDateFormat("yyyy-MM-dd")).format(specVo.getCreDt()));

            if(specVo.getUpdtUserNm() != null) {
	            vo.setUpdtUserNm(specVo.getUpdtUserNm());
	            vo.setUpdtDate((new SimpleDateFormat("yyyy-MM-dd")).format(specVo.getUpdtDt()));
            }
            datas.add(vo);
        }

        // Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("Spec");
        sheet.setDatas(datas);
        sheet.setHreader(header);

        sheets.add(sheet);

        // Excel 생성
        ExcelUtil.downloadExcel(response, String.format("스펙_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

	/**
     * 스펙 목록
     *
     * @param svo
     * @return
     */
    @RequestMapping(value = "/selectSpecListJson.do")
    @ResponseBody
    public ProcResultVo selectSpecListJson(SpecSvo svo) {

    	List<SpecVo> list = specService.selectSpecList(svo);

    	if(list!=null){
    		return getSuccessProcResult("성공하였습니다.", null, list);
    	}else {
    		return getFailProcResult("오류가 발생하였습니다.");
    	}
    }

	/**
	 * 스펙 구분코드 목록 조회
	 *
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value = "/selectSpecClCdList.do")
	@ResponseBody
	public ProcResultVo selectRsrcReqTyCdList(SpecSvo searchVo) {
		ProcResultVo result = new ProcResultVo();

		CodeSearchVo codeSearchVo = new CodeSearchVo();
		codeSearchVo.setSearchParentCd("102");
		codeSearchVo.setSearchParentGrpCd("003");
		codeSearchVo.setSearchWhole(true);

		if (!"".equals(searchVo.getClCd())) {
			codeSearchVo.setSearchExtra1(searchVo.getClCd());
		}

		List<CodeVo> list = commonService.selectCodeList(codeSearchVo);
		result.setData(list);
		return result;
	}
}
