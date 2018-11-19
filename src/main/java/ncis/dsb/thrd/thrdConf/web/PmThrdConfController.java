/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * PmThrdConfController.java
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
 * 2017. 06. 10   양정순         v1.0             자동확장 추가
 *
 */
package ncis.dsb.thrd.thrdConf.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.service.CommonService;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.code.vo.CodeSearchVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.cpt.sys.user.vo.UserVo;
import ncis.dsb.thrd.thrdConf.service.PmThrdConfService;
import ncis.dsb.thrd.thrdConf.service.ThrdStndIdxService;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfCvo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfPSearchVo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfSearchVo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfVo;
import ncis.dsb.thrd.thrdConf.vo.ThrdStndIdxSearchVo;
import ncis.dsb.thrd.thrdConf.vo.ThrdStndIdxVo;
import ncis.dsb.thrd.thrdConf.vo.UserSearchVo;
import ncis.dsb.thrd.thrdConf.vo.AxThrdConfSearchVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * 물리서버 임계치 설정
 *
 */
@Controller("pmThrdConfController")
@RequestMapping(value={"/dsb/thrd/thrdConf/pmThrd", "/dsb/thrd/thrdConf/vmThrd", "/dsb/thrd/thrdConf/axThrd"})
public class PmThrdConfController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(PmThrdConfController.class);
	@Resource(name="pmThrdConfService")
	PmThrdConfService pmThrdConfService;

	@Resource(name="commonService")
	CommonService commonService;

	@Resource(name="thrdStndIdxService")
	ThrdStndIdxService thrdStndIdxService;
	/**
	 * 물리서버 임계치 설정 목록조회 화면 호출
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectPmThrdView.do")
	public String selectPmThrdView(
			HttpServletRequest request,
			Model model) throws Exception{



		return dashTilesView(request,"selectPmThrdList");
	}
	/**
	 * 물리서버 임계치 설정 목록조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectPmThrdConfList.do")
	public String selectPmThrdConfList(
			HttpServletRequest request,
			@ModelAttribute PmThrdConfSearchVo searchVo,
			Model model) throws Exception{

		List<PmThrdConfVo> list = pmThrdConfService.selectPmThrdConfList(searchVo);	// 게시글list 가져오기

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);

		return jstlView(request,"selectPmThrdTableList");
	}
	/**
	 * 임계치 통보 설정 저장 화면 호출
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectNtceConfP.do")
	public String selectNtceConfP(
			@ModelAttribute PmThrdConfPSearchVo searchVo,
			HttpServletRequest request,
			Model model) throws Exception{
		PmThrdConfCvo cvo = new PmThrdConfCvo();
		CodeSearchVo codeVo = new CodeSearchVo();
		String update="";
		if("03".equals(searchVo.getTrgtSrvrClCd())&&searchVo.getThresTrgtSrvrSeq()!=null){
			cvo = pmThrdConfService.selectNtceConf(searchVo);
		}

		if("02".equals(searchVo.getTrgtSrvrClCd())&&searchVo.getThresTrgtSrvrSeq()!=null){
			cvo = pmThrdConfService.selectNtceConf(searchVo);
		}

		if("01".equals(searchVo.getTrgtSrvrClCd())&&searchVo.getThresTrgtSrvrSeq()!=null){
			cvo = pmThrdConfService.selectNtceConf(searchVo);
		}

		if("03".equals(searchVo.getTrgtSrvrClCd())){
			codeVo.setSearchParentGrpCd("027");
			codeVo.setSearchParentCd("999");
			codeVo.setSearchExtra2("auto");
			codeVo.setSearchWhole(false);
		}else{
			codeVo.setSearchParentGrpCd("027");
			codeVo.setSearchParentCd("999");
			codeVo.setSearchExtra1("pmvm");
			codeVo.setSearchWhole(false);
		}
		BeanUtils.copyProperties(searchVo, cvo);

		List<CodeVo>  list1 = commonService.selectCodeList(codeVo);
		List<CodeVo>  list2 = commonService.selectCodeList("029", "999");

		model.addAttribute("grdCode", list1);
		model.addAttribute("ntceFormCode", list2);
		model.addAttribute("cvo", cvo);
		model.addAttribute("update", update);

		if("03".equals(searchVo.getTrgtSrvrClCd())){
			model.addAttribute("title", "서비스 임계치 통보 설정");

			return popup(request,"updateAxNtceConfP");
		}else{
			model.addAttribute("title", "임계치 통보 설정");
			return popup(request,"updateNtceConfP");
		}

	}
	/**
	 * 임계치 설정 저장 화면 호출
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectThrdConfP.do")
	public String selectThrdConfP(
			@ModelAttribute PmThrdConfPSearchVo searchVo,
			HttpServletRequest request,
			Model model) throws Exception{
		ThrdStndIdxSearchVo vo= new ThrdStndIdxSearchVo();
		PaginationInfo paginationInfo =new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		vo.setPaginationInfo(paginationInfo);
		List<ThrdStndIdxVo> list = thrdStndIdxService.selectThrdStndIdxList(vo);

		PmThrdConfSearchVo pmThrdConfSearchVo = new PmThrdConfSearchVo();
		pmThrdConfSearchVo.setPmSeq(searchVo.getThresTrgtSrvrSeq());
		PmThrdConfVo pmThrdConfVo = new PmThrdConfVo();
		pmThrdConfSearchVo.setTrgtSrvrClCd(searchVo.getTrgtSrvrClCd());
		if("03".equals(searchVo.getTrgtSrvrClCd())){
			pmThrdConfSearchVo.setServcSeq(searchVo.getThresTrgtSrvrSeq());
			pmThrdConfVo = pmThrdConfService.selectAxThrdConf(pmThrdConfSearchVo);
		}else{
			pmThrdConfVo = pmThrdConfService.selectPmThrdConf(pmThrdConfSearchVo);
		}
		if(pmThrdConfVo==null){
			pmThrdConfVo = new PmThrdConfVo();
		}
		BeanUtils.copyProperties(searchVo, pmThrdConfVo);

		model.addAttribute("list", list);
		model.addAttribute("pmThrdConfVo", pmThrdConfVo);
		if("03".equals(searchVo.getTrgtSrvrClCd())){
			model.addAttribute("title", "자동확장 임계치 설정");
			return popup(request,"updateAxThrdConfP");
		}else{
			model.addAttribute("title", "임계치 설정");
			return popup(request,"updateThrdConfP");
		}

	}

	/**
	 * 통보설정 수정
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateNtceConf.do")
	@OperateLog(action="통보설정 수정", desc="통보설정을 수정한다.",		params={"accessSeq","userId"}, actionType=ActionType.UPDATE)
	public @ResponseBody ProcResultVo updateNtceConf(
			@RequestBody PmThrdConfCvo pmThrdConfCvo,
			HttpServletRequest request,
			Model model) throws Exception{
		model.addAttribute("title", "임계치 설정");
		ProcResultVo result = new ProcResultVo();
		result.setProcType("update");
		result.setSuccess(true);
		try{
			pmThrdConfService.updateNtceConf(pmThrdConfCvo);;
		} catch (InstantiationException | IllegalAccessException | IOException | SQLException e) {
			logger.error("통보설정 수정 오류", e);
			result.setSuccess(false);
		}

		return result;
	}

	/**
	 * 통보설정 초기화
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@OperateLog(action="통보설정 초기화", desc="통보설정 초기화 처리")
	@RequestMapping(value="/deleteNtceConf.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo deleteNtceConf(
					AxThrdConfSearchVo searchVo,
					HttpServletRequest request,
					Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		result.setProcType("delete");
		try{
			pmThrdConfService.deleteNtceConf(searchVo);
			result.setSuccess(true);
		} catch (InstantiationException | IllegalAccessException | IOException | SQLException e) {
			logger.error("통보설정 초기화 오류", e);
			result.setSuccess(false);
		}


		return result;
	}
	/**
	 * 임계치 수정
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateThrdConf.do")
	@OperateLog(action="임계치 수정", desc="임계치를 수정한다.",		params={"accessSeq","userId"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateThrdConf(
			@RequestBody  PmThrdConfVo pmThrdConfVo,
			HttpServletRequest request,
			Model model) throws Exception{



		ProcResultVo result = new ProcResultVo();

		result.setProcType("update");
		result.setSuccess(true);


		try{
			pmThrdConfService.updateThrdConf(pmThrdConfVo);
		} catch (InstantiationException | IllegalAccessException | IOException | SQLException e) {
			logger.error(e.getMessage());
			result.setSuccess(false);
		}

		return result;
	}

	/**
	 * 임계치 초기화
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@OperateLog(action="임계치설정 초기화", desc="임계치설정 초기화 처리")
	@RequestMapping(value="/deleteThrdConf.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo deleteThrdConf(
					AxThrdConfSearchVo searchVo,
					HttpServletRequest request,
					Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		result.setProcType("delete");
		try{
			pmThrdConfService.deleteThrdConf(searchVo);
			result.setSuccess(true);
		} catch (InstantiationException | IllegalAccessException | IOException | SQLException e) {
			logger.error("임계치설정 초기화 오류", e);
			result.setSuccess(false);
		}


		return result;
	}

	/**
	 * 사용자 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/selectUserList.do")
	public ProcResultVo selectUserList(@ModelAttribute UserSearchVo searchVo,
			HttpServletRequest request, Model model) throws Exception {

		List<UserVo> list = pmThrdConfService.selectUserList(searchVo);

		ProcResultVo result = new ProcResultVo();
		result.setData(list);
		result.setSuccess(true);

		return result;
	}

}
