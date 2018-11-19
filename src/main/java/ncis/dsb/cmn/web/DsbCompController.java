/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DsbCompController.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 11. 14.
 * @lastmodified 2016. 11. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 14.     양정순         v1.0             최초생성
 *
 */
package ncis.dsb.cmn.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.Tree;
import ncis.cmn.vo.TreeNode;
import ncis.cmn.web.BaseController;
import ncis.dsb.cmn.service.DsbCmmService;
import ncis.dsb.cmn.vo.MainCvo;
import ncis.dsb.cmn.vo.MainSearchVo;
import ncis.dsb.stts.servstte.service.ServStteService;
import ncis.dsb.stts.servstte.vo.ServStteCvo;
import ncis.dsb.stts.servstte.vo.ServStteSearchVo;
import ncis.dsb.thrd.evnt.vo.InstitutionToVmVo;
import ncis.dsb.thrd.evnt.vo.InstitutionToAxVo;
import ncis.dsb.thrd.evnt.vo.RegionToPmVo;
import ncis.dsb.thrd.thrdConf.service.ThrdStndIdxService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 양정순
 *
 */
@Controller
@RequestMapping(value = "/cmn/component/dsb")
public class DsbCompController extends BaseController {
	@Resource(name="thrdStndIdxService")
	ThrdStndIdxService thrdStndIdxService;

	@Resource(name="dsbCmmService")
	DsbCmmService dsbCmmService;

	@Resource(name="servStteService")
	ServStteService servStteService;

	/**
	 * 센터~물리서버까지 트리 조회
	 * @param parentId
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectRegionToPmTree.do")
	@ResponseBody
	public List<TreeNode<String,RegionToPmVo>> selectRegionToPmTree(
					@RequestParam(required=false)String parentId,
					@RequestParam(required=false)String pmTree,
					HttpServletRequest request,
					Model model) throws Exception{
		//ProcResultVo result = new ProcResultVo();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", this.getUserId());
		param.put("parentId", parentId);
		param.put("pmTree", pmTree);
		param.put("role", RequestUtils.isAllRsrcPoolAuth());//시스템관리자,운영관리자 여부
		Tree<String,RegionToPmVo> tree = thrdStndIdxService.selectRegionToPmTree(param);
		return tree.getRoot().getChildren();
	}

	/**
	 * 기관~가상서버까지 트리 조회
	 * @param parentId
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectInstitutionToVmTree.do")
	@ResponseBody
	public List<TreeNode<String,InstitutionToVmVo>> selectInstitutionToVmTree(
					@RequestParam(required=false)String parentId,
					@RequestParam(required=false)String vmTree,
					HttpServletRequest request,
					Model model) throws Exception{
		//ProcResultVo result = new ProcResultVo();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", this.getUserId());
		param.put("parentId", parentId);
		param.put("vmTree", vmTree);
		param.put("role", RequestUtils.isAllJobAuth());//시스템관리자,운영관리자 여부
		Tree<String,InstitutionToVmVo> tree = thrdStndIdxService.selectInstitutionToVmTree(param);
		return tree.getRoot().getChildren();
	}

	/**
	 * 기관~자동확장까지 트리 조회
	 * @param parentId
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectInstitutionToAxTree.do")
	@ResponseBody
	public List<TreeNode<String,InstitutionToAxVo>> selectInstitutionToAxTree(
					@RequestParam(required=false)String parentId,
					HttpServletRequest request,
					Model model) throws Exception{
		//ProcResultVo result = new ProcResultVo();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", this.getUserId());
		param.put("parentId", parentId);
		param.put("role", RequestUtils.isAllJobAuth());//시스템관리자,운영관리자 여부
		Tree<String,InstitutionToAxVo> tree = thrdStndIdxService.selectInstitutionToAxTree(param);
		return tree.getRoot().getChildren();
	}
	/**
	 * 자원풀 구성정보
	 *
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectPmIdxList.do")
	public String selectPmIdxList(
			HttpServletRequest request,
			@ModelAttribute MainSearchVo searchVo,
			Model model) throws Exception{
		searchVo.setView("PM");
		MainCvo mainCvo = dsbCmmService.selectMainList(searchVo);	// 게시글list 가져오기
		//MainCvo mainCvo = null;


		model.addAttribute("mainCvo", mainCvo);
		model.addAttribute("searchVo", searchVo);

		return jstlView(request,"selectPmIdxList");
	}

	/**
	 * 기관별 구성정보
	 *
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */

	@RequestMapping(value="/selectVmIdxList.do")
	public String selectVmIdxList(
			HttpServletRequest request,
			@ModelAttribute MainSearchVo searchVo,
			Model model) throws Exception{
		searchVo.setView("VM");
		MainCvo mainCvo = dsbCmmService.selectMainIncList(searchVo);	// 게시글list 가져오기
		//MainCvo mainCvo = null;

		model.addAttribute("mainCvo", mainCvo);
		model.addAttribute("searchVo", searchVo);

		return jstlView(request,"selectPmIdxList");
	}

	/**
	 * 서비스 및 서버 현황
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectServStteList.do")
	public String selectServStteList( HttpServletRequest request,
			Model model, ServStteSearchVo searchVo) throws Exception{

		ServStteCvo list = servStteService.selectServStteList(searchVo);


		model.addAttribute("ServStteCvo", list);
		model.addAttribute("searchVo", searchVo);

		return dashIndexTilesView(request);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////// 온나라 테스트 //////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 센터~물리서버까지 트리 조회
	 * @param parentId
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectRegionToPmTreeByOnnara.do")
	@ResponseBody
	public List<TreeNode<String,RegionToPmVo>> selectRegionToPmTreeByOnnara(
					@RequestParam(required=false)String parentId,
					@RequestParam(required=false)String pmTree,
					HttpServletRequest request,
					Model model) throws Exception{
		//ProcResultVo result = new ProcResultVo();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", this.getUserId());
		param.put("parentId", parentId);
		param.put("pmTree", pmTree);
		param.put("role", RequestUtils.isAllRsrcPoolAuth());//시스템관리자,운영관리자 여부
		Tree<String,RegionToPmVo> tree = thrdStndIdxService.selectRegionToPmTreeByOnnara(param);
		return tree.getRoot().getChildren();
	}

	/**
	 * 기관~가상서버까지 트리 조회
	 * @param parentId
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectInstitutionToVmTreeByOnnara.do")
	@ResponseBody
	public List<TreeNode<String,InstitutionToVmVo>> selectInstitutionToVmTreeByOnnara(
					@RequestParam(required=false)String parentId,
					@RequestParam(required=false)String vmTree,
					@RequestParam(required=false)String searchGubun,
					HttpServletRequest request,
					Model model) throws Exception{
		//ProcResultVo result = new ProcResultVo();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", this.getUserId());
		param.put("parentId", parentId);
		param.put("vmTree", vmTree);
		param.put("searchGubun", searchGubun);
		param.put("role", RequestUtils.isAllJobAuth());//시스템관리자,운영관리자 여부
		Tree<String,InstitutionToVmVo> tree = thrdStndIdxService.selectInstitutionToVmTreeByOnnara(param);
		return tree.getRoot().getChildren();
	}

	/**
	 * 자원풀 구성정보
	 *
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectPmIdxListByOnnara.do")
	public String selectPmIdxListByOnnara(
			HttpServletRequest request,
			@ModelAttribute MainSearchVo searchVo,
			Model model) throws Exception{
		searchVo.setView("PM");
		MainCvo mainCvo = dsbCmmService.selectMainListByOnnara(searchVo);	// 게시글list 가져오기
		//MainCvo mainCvo = null;


		model.addAttribute("mainCvo", mainCvo);
		model.addAttribute("searchVo", searchVo);

		return jstlView(request,"selectPmIdxList");
	}

	/**
	 * 기관별 구성정보
	 *
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */

	@RequestMapping(value="/selectVmIdxListByOnnara.do")
	public String selectVmIdxListByOnnara(
			HttpServletRequest request,
			@ModelAttribute MainSearchVo searchVo,
			Model model) throws Exception{
		searchVo.setView("VM");
		MainCvo mainCvo = dsbCmmService.selectMainIncListByOnnara(searchVo);	// 게시글list 가져오기
		//MainCvo mainCvo = null;

		model.addAttribute("mainCvo", mainCvo);
		model.addAttribute("searchVo", searchVo);

		return jstlView(request,"selectPmIdxList");
	}
}


