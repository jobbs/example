/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PhyStrgMngController.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.exception.CommonException;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.rsrc.strg.service.PhyStrgService;
import ncis.cpt.rsrc.strg.vo.PhyStrgSearchVo;
import ncis.cpt.rsrc.strg.vo.PhyStrgVo;
import ncis.cpt.rsrc.strg.vo.VrStrgSearchVo;
import ncis.cpt.rsrc.strg.vo.VrStrgVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 김봉민
 *
 */
@Controller
@RequestMapping(value = "/cpt/rsrc/strg/phystrg")
public class PhyStrgController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(PhyStrgController.class);

	@Resource(name="phyStrgService")
	private PhyStrgService phyStrgService;

	@Resource(name="commonService")
	private CommonService commonService;


	/**
	 * 물리스토리지 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectPhystrgList.do")
	public String selectPStrgList(HttpServletRequest request, Model model, PhyStrgSearchVo searchVo) throws Exception{
		try{
			model.addAttribute("vrlzSwTyCdList", commonService.selectCodeList("065", "140", false)); //자원요청상태코드
			model.addAttribute("list", phyStrgService.selectPhyStrgList(searchVo));
			model.addAttribute("searchVo", searchVo);
			return portalTilesView(request);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			throw e;
		}
	}

	/**
	 * 엑셀저장
	 * @param request
	 * @param response
	 * @param model
	 * @param searchVo
	 * @throws Exception
	 */
	 @RequestMapping(value = "/selectPhystrgListXlsDwnl.do")
	 public void selectNetVmListXlsDwnl(HttpServletRequest request, HttpServletResponse response, Model model, PhyStrgSearchVo searchVo) throws Exception{
		 List<CustomSheet>  sheets=  phyStrgService.makePhyStrgListExcelSheets(searchVo);
		 try {
			ExcelUtil.downloadExcel(response, String.format("스토리지_물리스토리지_%s",(new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date())),sheets);
		} catch (NoSuchMethodException | IllegalAccessException
				| InvocationTargetException | IOException e) {
			logger.error(e.getMessage(),e);
			 throw new Exception("엑셀 저장 중 오류가 발생하였습니다.");
		}
	 }

	/**
	 * 물리 스토리지 상세 - SAN
	 * @param request
	 * @param model
	 * @param srchPhyStrgId
	 * @return
	 */
	@RequestMapping(value="/formPhystrgDtlSan.do")
	public String selectPStrgDtlSanView(HttpServletRequest request, Model model, @RequestParam(required=true) String srchPhyStrgId){
		try{
			PhyStrgSearchVo pSearchVo = new PhyStrgSearchVo();
			pSearchVo.setPhyStrgId(srchPhyStrgId);
			PhyStrgVo pstrgVo = phyStrgService.selectPhyStrgList(pSearchVo) != null ? phyStrgService.selectPhyStrgList(pSearchVo).get(0): null ;

			VrStrgSearchVo vRsearchVo = new VrStrgSearchVo();
			vRsearchVo.setSearchPhyStrgId(srchPhyStrgId);
			List<VrStrgVo> vrStrgList  = phyStrgService.selectVrStrgCapaList(vRsearchVo);

			model.addAttribute("searchVo", vRsearchVo);
			model.addAttribute("pstrgVo",  pstrgVo);
			model.addAttribute("vrStrgList",  vrStrgList);
			return portalTilesView(request, "formPhystrgDtlSan");
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			throw e;
		}


	}

	/**
	 * 검색조건에 맞는 물리스토리지 목록을 엑셀다운로드
	 * @param request
	 * @param response
	 * @param model
	 * @param searchVo
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectVrStrgListInPhystrgXlsDwnl.do")
	public void selectVrStrgListInPhystrgXlsDwnl(HttpServletRequest request, HttpServletResponse response, Model model, VrStrgSearchVo searchVo) throws Exception {
		 List<CustomSheet>  sheets=  phyStrgService.makeVrStrgListInPhyStrgExcelSheets(searchVo);
		 try {
			ExcelUtil.downloadExcel(response, String.format("스토리지_물리스토리지_%s",(new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date())),sheets);
		} catch (NoSuchMethodException | IllegalAccessException
				| InvocationTargetException | IOException e) {
			logger.error(e.getMessage(),e);
			 throw new Exception("엑셀 저장 중 오류가 발생하였습니다.");
		}
	}

	/**
	 * 물리스토리지 상세 - NAS
	 * @param request
	 * @param model
	 * @param srchPhyStrgId
	 * @return
	 */
	@RequestMapping(value="/formPhystrgDtlNas.do")
	public String selectPStrgDtlNasView(HttpServletRequest request, Model model, @RequestParam(required=true) String srchPhyStrgId){
		/**
		 * TODO : 인터페이스 및 내용이 정의 후 구현
		 */
		PhyStrgSearchVo searchVo = new PhyStrgSearchVo();
		searchVo.setPhyStrgId(srchPhyStrgId);
		model.addAttribute("pstrgVo", phyStrgService.selectPhyStrgList(searchVo)!=null ? phyStrgService.selectPhyStrgList(searchVo).get(0): null);
		return portalTilesView(request, "formPhystrgDtlNas");

	}

	/**
	 * 물리스토리지 상세 - DFS
	 * @param request
	 * @param model
	 * @param srchPhyStrgId
	 * @return
	 */
	@RequestMapping(value="/formPhystrgDtlDfs.do")
	public String selectPStrgDtlDfsView(HttpServletRequest request, Model model, @RequestParam(required=true) String srchPhyStrgId){
		/**
		 * TODO : 인터페이스 및 내용이 정의 후 구현
		 */
		PhyStrgSearchVo searchVo = new PhyStrgSearchVo();
		searchVo.setPhyStrgId(srchPhyStrgId);
		model.addAttribute("pstrgVo", phyStrgService.selectPhyStrgList(searchVo)!=null ? phyStrgService.selectPhyStrgList(searchVo).get(0): null);
		return portalTilesView(request, "formPhystrgDtlDfs");
	}


	@RequestMapping(value="/updatePStrgCommInfo.do", method=RequestMethod.POST)
	@OperateLog(action="물리스토리 정보 수정", desc="물리스토리 정보 수정", params={"pstrgVo"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updatePStrgCompId(@ModelAttribute("pstrgVo") PhyStrgVo pstrgVo , BindingResult bindResult){
		logger.error("getPhyStrgId = " + pstrgVo.getPhyStrgId() +", getCompId = "+ pstrgVo.getCompId());

		ProcResultVo result =  getBindingResult(pstrgVo, bindResult, UpdateProc.class);
		result.setProcType("update");
		try {
			PhyStrgSearchVo searchVo = new PhyStrgSearchVo();
			searchVo.setCompId(pstrgVo.getCompId());
			List<PhyStrgVo> list =  this.phyStrgService.selectPhyStrgList(searchVo);
			if(list != null && list.size()>0){
				throw new CommonException("동일한 물리스토리지 구성 ID가 존재합니다.");
			}
			this.phyStrgService.updatePhyStrgCommInfo(pstrgVo);
			result.setSuccess(true);
			result.addMessage("물리스토리지 수정이 성공하였습니다.");
		}catch(CommonException e){
			logger.error(e.getMessage(),e);
			result.setSuccess(false);
			result.addMessage("물리스토리지 수정이 실패하였습니다. \n-"+e.getMessage());
		}
		return result;
	}


}
