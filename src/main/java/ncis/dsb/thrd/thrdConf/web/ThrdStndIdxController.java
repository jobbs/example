/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ThrdStndIdxController.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   김동훈         v1.0             최초생성
 *
 */
package ncis.dsb.thrd.thrdConf.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.vo.Tree;
import ncis.cmn.vo.TreeNode;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.dsb.thrd.evnt.vo.InstitutionToVmVo;
import ncis.dsb.thrd.evnt.vo.RegionToPmVo;
import ncis.dsb.thrd.thrdConf.service.ThrdStndIdxService;
import ncis.dsb.thrd.thrdConf.vo.ThrdStndIdxSearchVo;
import ncis.dsb.thrd.thrdConf.vo.ThrdStndIdxVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 임계치 표준 지표 설정
 */
@SuppressWarnings({"unchecked","rawtypes"})
@Controller("ThrdStndIdxController")
@RequestMapping("/dsb/thrd/thrdConf/stndIdx")
public class ThrdStndIdxController extends BaseController {


	@Resource(name="thrdStndIdxService")
	ThrdStndIdxService thrdStndIdxService;

	/**
	 * 임계치 표준지표 목록조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectThrdStndIdxList.do")
	public String selectThrdStndIdxList(
					ThrdStndIdxSearchVo searchVo,
					HttpServletRequest request,
					Model model) throws Exception{

		List<ThrdStndIdxVo> list = thrdStndIdxService.selectThrdStndIdxList(searchVo);	// 게시글list 가져오기

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);


		return dashTilesView(request,"selectThrdStndIdxList");
	}
	/**
	 * 임계치 표준지표 수정화면 호출
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateThrdStndIdxView.do")
	public String updateThrdStndIdxView(
					ThrdStndIdxSearchVo searchVo,
					HttpServletRequest request,
					Model model) throws Exception{
		Long profId = searchVo.getProfId();
		ThrdStndIdxVo vo = new ThrdStndIdxVo();
		if(profId!=null){
			vo  = thrdStndIdxService.selectThrdStndIdx(searchVo);	// 게시글list 가져오기
		}

		model.addAttribute("thrdStndIdxVo", vo);
		model.addAttribute("searchVo", searchVo);


		return dashTilesView(request,"updateThrdStndIdx");
	}
	/**
	 * 임계치 표준지표 수정
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@OperateLog(action="임계치 표준지표 수정", desc="임계치 표준지표  수정 처리")
	@RequestMapping(value="/updateThrdStndIdx.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updateThrdStndIdx(
					ThrdStndIdxVo vo,
					HttpServletRequest request,
					Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		thrdStndIdxService.updateThrdStndIdx(vo);
		result.setSuccess(true);

		return result;
	}
	/**
	 * 임계치 표준지표 삭제
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@OperateLog(action="임계치 표준지표 삭제", desc="임계치 표준지표  삭제 처리")
	@RequestMapping(value="/deleteThrdStndIdx.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo deleteThrdStndIdx(
					ThrdStndIdxSearchVo searchVo,
					HttpServletRequest request,
					Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		thrdStndIdxService.deleteThrdStndIdx(searchVo.getProfId());

		result.setSuccess(true);

		return result;
	}


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
					HttpServletRequest request,
					Model model) throws Exception{
		//ProcResultVo result = new ProcResultVo();
		Map param = new HashMap();
		param.put("userId", this.getUserId());
		param.put("parentId", parentId);
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
					HttpServletRequest request,
					Model model) throws Exception{
		//ProcResultVo result = new ProcResultVo();
		Map param = new HashMap();
		param.put("userId", this.getUserId());
		param.put("parentId", parentId);
		param.put("role", RequestUtils.isAllJobAuth());//시스템관리자,운영관리자 여부
		Tree<String,InstitutionToVmVo> tree = thrdStndIdxService.selectInstitutionToVmTree(param);
		return tree.getRoot().getChildren();
	}
}

