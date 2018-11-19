/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * EvntStteController.java
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
package ncis.dsb.thrd.evnt.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ncis.cmn.service.CommonService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.util.DateUtil;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.rsrc.pool.service.RsrcPoolService;
import ncis.cpt.rsrc.zone.service.NetService;
import ncis.cpt.rsrc.zone.service.RegionService;
import ncis.cpt.rsrc.zone.service.ZoneService;
import ncis.cpt.sys.code.vo.CodeSearchVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.dsb.thrd.evnt.service.EvntStteService;
import ncis.dsb.thrd.evnt.vo.EvntStteSearchVo;
import ncis.dsb.thrd.evnt.vo.EvntStteVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("evntStteController")
@RequestMapping("/dsb/thrd/evnt/evntStte")
public class EvntStteController extends BaseController {


	@Resource(name="evntStteService")
	EvntStteService evntStteService;

	@Resource(name = "regionService")
    RegionService regionService;

	@Resource(name = "zoneService")
    ZoneService zoneService;

    @Resource(name = "netService")
    NetService netService;

    @Resource(name = "rsrcPoolService")
    RsrcPoolService rsrcPoolService;

    @Resource(name="commonService")
	CommonService commonService;

	/**
	 * 이벤트 현황 목록조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectEvntStteList.do")
	public String selectEvntStteList(  EvntStteSearchVo searchVo, HttpServletRequest request,
			Model model) throws Exception{
		if(searchVo.getSearchTrmCd()==null){
			searchVo.setSearchTrmCd("01");//최근1시간 기본 셋팅
		}
		CodeSearchVo codeVo = new CodeSearchVo();
		codeVo.setSearchParentGrpCd("027");
		codeVo.setSearchParentCd("999");
		codeVo.setSearchWhole(false);

		List<EvntStteVo> list = evntStteService.selectEvntStteList(searchVo);	//
		List<CodeVo>  list1 = commonService.selectCodeList(codeVo);

		/*ncis.cmn.security.vo.UserVo user = RequestUtils.getUser();
		List<Grant> grants = user.getRoleList();
		for(Grant grant:grants){
			String a = grant.getAuthority();
			System.out.println(a);

		}*/

		//List<RegionVo> regionVoList = regionService.selectRegionList(new RegionSearchVo());
        //List<ZoneVo> zoneVoList = zoneService.selectZoneList(new ZoneSearchVo());
        //List<NetVo> netVoList = netService.selectNetList(new NetSearchVo());
        //List<RsrcPoolVo> rsrcPoolVoList = rsrcPoolService.selectRsrcPoolList(new RsrcPoolSearchVo());

        //model.addAttribute("regionVoList", regionVoList);
        //model.addAttribute("zoneVoList", zoneVoList);
        //model.addAttribute("netVoList", netVoList);
        //model.addAttribute("rsrcPoolVoList", rsrcPoolVoList);
		model.addAttribute("grdCode", list1);
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);


		return dashTilesView(request,"selectEvntStteList");
	}
	/**
	 * 이벤트현황 확인
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateEvntConfrm.do")
	@OperateLog(action="이벤트 확인 처리", desc="이벤트 확인 처리한다.",		params={"evntSeq","userId"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateEvntConfrm(  @RequestParam("evntSeq") String evntSeq, HttpServletRequest request,
			Model model) throws Exception{

		ProcResultVo result = new ProcResultVo();

		evntStteService.updateEvntConfrm(evntSeq);

		result.setProcType("update");
		result.setSuccess(true);

		return result;
	}
	/**
	 * 이벤트현황  취소
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateEvntConfrmCncl.do")
	@OperateLog(action="이벤트 확인 취소 처리", desc="이벤트 확인 취소 처리한다.",		params={"evntSeq","userId"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateEvntConfrmCncl(  @RequestParam("evntSeq") String evntSeq, HttpServletRequest request,
			Model model) throws Exception{

		ProcResultVo result = new ProcResultVo();

		evntStteService.updateEvntConfrmCncl(evntSeq);

		result.setProcType("update");
		result.setSuccess(true);

		return result;
	}
	/**
	 * 이벤트 현황 엑셀다운로드
	 * @param searchVo
	 * @param request
	 * @param response
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 * @throws Exception
	 */
	@RequestMapping(value="/selectEvntStteXlsDown.do")
	public void selectEvntStteXlsDown(
			EvntStteSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{
		if(searchVo.getSearchTrmCd()==null){
			searchVo.setSearchTrmCd("01");//최근1시간 기본 셋팅
		}
		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<EvntStteVo> list = evntStteService.selectEvntStteList(searchVo);	//
		if(list==null){
			list = new ArrayList<EvntStteVo>();
		}
	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("thresGrdNm", "등급");
        header.put("occrDttm", "발생일시");
        header.put("institutionNm", "부처명");
        header.put("jobNm", "업무명");
        header.put("trgtNm", "대상");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망구분");
        header.put("rsrcPoolNm", "자원풀");
        header.put("evntCn", "내용");
        header.put("userNm", "확인자");
        header.put("confrmDt", "확인일시");
        header.put("thresNm", "임계치");


        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("이벤트 현황");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "이벤트 현황_"+DateUtil.getCurrentDate("yyyyMMdd"), sheets);
    }

}
