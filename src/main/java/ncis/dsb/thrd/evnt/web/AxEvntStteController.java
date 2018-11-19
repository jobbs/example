/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxEvntStteController.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 10. 10
 * @lastmodified2017. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.thrd.evnt.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.dsb.thrd.evnt.service.AxEvntStteService;
import ncis.dsb.thrd.evnt.vo.AxEvntStteSearchVo;
import ncis.dsb.thrd.evnt.vo.AxEvntStteVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("axEvntStteController")
@RequestMapping("/dsb/thrd/evnt/axEvntStte")
public class AxEvntStteController extends BaseController {


	@Resource(name="axEvntStteService")
	AxEvntStteService axEvntStteService;

	@Resource(name = "regionService")
    RegionService regionService;

	@Resource(name = "zoneService")
    ZoneService zoneService;

    @Resource(name = "netService")
    NetService netService;

    @Resource(name = "rsrcPoolService")
    RsrcPoolService rsrcPoolService;

	/**
	 * 자동확장 이벤트 현황 목록조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAxEvntStteList.do")
	public String selectAxEvntStteList(  AxEvntStteSearchVo searchVo, HttpServletRequest request,
			Model model) throws Exception{
		if(searchVo.getSearchTrmCd()==null){
			searchVo.setSearchTrmCd("01");//최근1시간 기본 셋팅
		}
		List<AxEvntStteVo> list = axEvntStteService.selectAxEvntStteList(searchVo);	//
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);


		return dashTilesView(request,"selectAxEvntStteList");
	}
	/**
	 * 자동확장 이벤트현황 확인
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateAxEvntConfrm.do")
	@OperateLog(action="이벤트 확인 처리", desc="이벤트 확인 처리한다.",		params={"evntSeq","userId"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateAxEvntConfrm(  @RequestParam("evntSeq") String evntSeq, HttpServletRequest request,
			Model model) throws Exception{

		ProcResultVo result = new ProcResultVo();

		axEvntStteService.updateAxEvntConfrm(evntSeq);

		result.setProcType("update");
		result.setSuccess(true);

		return result;
	}
	/**
	 * 자동확장 이벤트현황  취소
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateAxEvntConfrmCncl.do")
	@OperateLog(action="이벤트 확인 취소 처리", desc="이벤트 확인 취소 처리한다.",		params={"evntSeq","userId"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateAxEvntConfrmCncl(  @RequestParam("evntSeq") String evntSeq, HttpServletRequest request,
			Model model) throws Exception{

		ProcResultVo result = new ProcResultVo();

		axEvntStteService.updateAxEvntConfrmCncl(evntSeq);

		result.setProcType("update");
		result.setSuccess(true);

		return result;
	}
	/**
	 * 자동확장 이벤트 현황 엑셀다운로드
	 * @param searchVo
	 * @param request
	 * @param response
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAxEvntStteXlsDown.do")
	public void selectAxEvntStteXlsDown(
			AxEvntStteSearchVo searchVo,
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

		List<AxEvntStteVo> list = axEvntStteService.selectAxEvntStteList(searchVo);	//
		if(list==null){
			list = new ArrayList<AxEvntStteVo>();
		}
	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("occrDttm", "발생일시");
        header.put("evntOccrReasn", "발생유형");
        header.put("occrObjectId", "발생대상");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망구분");
        header.put("rsrcPoolNm", "자원풀");
        header.put("msgCn", "내용");

        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("자동확장 이벤트 현황");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "자동확장 이벤트 현황_"+DateUtil.getCurrentDate("yyyyMMdd"), sheets);
    }

}
