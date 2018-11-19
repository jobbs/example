/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * EvntNtceHistController.java
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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.service.CommonService;
import ncis.cmn.util.DateUtil;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.web.BaseController;
import ncis.cpt.rsrc.pool.service.RsrcPoolService;
import ncis.cpt.rsrc.zone.service.NetService;
import ncis.cpt.rsrc.zone.service.RegionService;
import ncis.cpt.rsrc.zone.service.ZoneService;
import ncis.cpt.sys.code.vo.CodeSearchVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.dsb.thrd.evnt.service.EvntNtceHistService;
import ncis.dsb.thrd.evnt.vo.EvntNtceHistSearchVo;
import ncis.dsb.thrd.evnt.vo.EvntNtceHistVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("evntNtceHistController")
@RequestMapping("/dsb/thrd/evnt/evntNtceHist")
public class EvntNtceHistController extends BaseController {


	@Resource(name="evntNtceHistService")
	EvntNtceHistService evntNtceHistService;

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
	 * 이벤트 통보이력 목록조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectEvntNtceHistList.do")
	//@ResponseBody
	public  String selectEvntNtceHistList( EvntNtceHistSearchVo searchVo,
			HttpServletRequest request,
			//BindingResult bindResult,
			Model model) throws Exception{

		if(searchVo.getSearchTrmCd()==null){
			searchVo.setSearchTrmCd("01");//최근1시간 기본 셋팅
		}
		CodeSearchVo codeVo = new CodeSearchVo();
		codeVo.setSearchParentGrpCd("027");
		codeVo.setSearchParentCd("999");
		codeVo.setSearchWhole(false);
		List<EvntNtceHistVo> list = evntNtceHistService.selectEvntNtceHistList(searchVo);	//
		List<CodeVo>  list1 = commonService.selectCodeList(codeVo);

		//List<RegionVo> regionVoList = regionService.selectRegionList(new RegionSearchVo());
        /*List<ZoneVo> zoneVoList = zoneService.selectZoneList(new ZoneSearchVo());
        List<NetVo> netVoList = netService.selectNetList(new NetSearchVo());
        List<RsrcPoolVo> rsrcPoolVoList = rsrcPoolService.selectRsrcPoolList(new RsrcPoolSearchVo());*/

        //model.addAttribute("regionVoList", regionVoList);
        /*model.addAttribute("zoneVoList", zoneVoList);
        model.addAttribute("netVoList", netVoList);
        model.addAttribute("rsrcPoolVoList", rsrcPoolVoList);*/

		model.addAttribute("grdCode", list1);
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);


		return dashTilesView(request,"selectEvntNtceHistList");
	}
	/**
	 * 이벤트 통보이력 엑셀 다운로드
	 * @param searchVo
	 * @param request
	 * @param response
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 * @throws Exception
	 */
	@RequestMapping(value="/selectEvntNtceHistXlsDown.do")
	public void selectEvntNtceHistXlsDown(
			EvntNtceHistSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<EvntNtceHistVo> list = evntNtceHistService.selectEvntNtceHistList(searchVo);	//
		if(list==null){
			list = new ArrayList<EvntNtceHistVo>();
		}
	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("dspthStatNm", "상태");
        header.put("thresGrdNm", "등급");
        header.put("dspthDttm", "통보일자");
        header.put("trgtSrvrNm", "대상명");
        //header.put("path", "경로");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망구분");
        header.put("rsrcPoolNm", "자원풀");
        header.put("cn", "내용");
        header.put("dspthTyNm", "통보형식");
        header.put("userNm", "수신자");


        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("이벤트 통보이력");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "이벤트 통보 이력_"+DateUtil.getCurrentDate("yyyyMMdd"), sheets);
    }


}
