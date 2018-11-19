/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmSpecPerPoolController.java
 *
 * @author 이권기
 * @lastmodifier 이권기
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   이권기         v1.0             최초생성
 *
 */
package ncis.dsb.stts.specusert.web;

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
import ncis.cmn.web.BaseController;
import ncis.dsb.cmn.util.DsbUtil;
import ncis.dsb.stts.specusert.service.VmSpecPerPoolService;
import ncis.dsb.stts.specusert.vo.VmSpecPerPoolSearchVo;
import ncis.dsb.stts.specusert.vo.VmSpecPerPoolVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("vmSpecPerPoolController")
@RequestMapping("/dsb/stts/specusert/vmSpecPerPool")
public class VmSpecPerPoolController extends BaseController {


	@Resource(name="vmSpecPerPoolService")
	VmSpecPerPoolService vmSpecPerPoolService;

	/**
	 * 자원풀별 가상서버 사양 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectVmSpecPerPoolList.do")
	public String selectVmSpecPerPoolList( HttpServletRequest request,
			Model model, VmSpecPerPoolSearchVo searchVo) throws Exception{

		List<VmSpecPerPoolVo> list = null;

		if(request.getParameter("regionId") != null){
			list = vmSpecPerPoolService.selectVmSpecPerPoolList(searchVo);
		}

		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectVmSpecPerPoolList");
	}

	/**
	 * 자원풀별 가상서버 사양 조회 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectVmSpecPerPoolXlsDown.do")
	public void selectVmSpecPerPoolXlsDown(VmSpecPerPoolSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<VmSpecPerPoolVo> list = vmSpecPerPoolService.selectVmSpecPerPoolList(searchVo);

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("no", "No.");
        header.put("rsrcPoolNm", "자원풀");
        header.put("minAvgVcoreQty", "vCore 최저");
        header.put("avgAvgVcoreQty", "vCore 평균");
        header.put("maxAvgVcoreQty", "vCore 최고");
        header.put("minMemSumCapa", "MEM 최저(GB)");
        header.put("avgMemSumCapa", "MEM 평균(GB)");
        header.put("maxMemSumCapa", "MEM 최고(GB)");
        header.put("minStrgSumCapa", "SAN 최저(GB)");
        header.put("avgStrgSumCapa", "SAN 평균(GB)");
        header.put("maxStrgSumCapa", "SAN 최고(GB)");


        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("자원풀별 가상서버 사양");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "자원풀별 가상서버 사양_"+DateUtil.getCurrentDate("yyyyMMdd"), sheets);
    }
}
