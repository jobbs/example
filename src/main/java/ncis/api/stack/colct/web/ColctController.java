/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ColctController.java
 *
 * @author 최장성
 * @lastmodifier 최장성
 * @created 2016. 11. 11.
 * @lastmodified 2016. 11. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 11.     최장성         v1.0             최초생성
 *
 */
package ncis.api.stack.colct.web;

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

import ncis.api.stack.colct.service.ColctService;
import ncis.api.stack.colct.vo.ColctSearchVo;
import ncis.api.stack.colct.vo.ColctVo;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.rsrc.zone.service.NetService;
import ncis.cpt.rsrc.zone.vo.NetVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @author 최장성
 *
 */
@Controller
@RequestMapping(value="/api/stack/colct")
public class ColctController extends BaseController {

	@Resource(name="colctService")
	ColctService colctService;

	@Resource(name="commonService")
	CommonService commonService;

	@Resource(name="netService")
	NetService netService;

	private final Logger logger = LoggerFactory.getLogger(ColctController.class);

	/**
	 * 배치 수집현황 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectColctList.do")
	public String selectMngrList(HttpServletRequest request, Model model, ColctSearchVo searchVo) throws Exception {
		logger.debug("[========== 배치 수집현황 목록 - Start==========]");

		/** 망 코드 조회 */
		List<NetVo> netItems = netService.selectNetAllList();
		String netClCd="";
		String netCd = "";
		netCd = searchVo.getSearchNetId();	// 조회후 화면에 조회 값을 유지하기 위해 임시로 세팅
        for(int j=0; j<netItems.size();j++){
			if(netItems.get(j).getNetId().equals(searchVo.getSearchNetId())){
				netClCd = netItems.get(j).getNetClCd();
			}
		}
        searchVo.setSearchNetId(netClCd);
		List<ColctVo> list = colctService.selectColctList(searchVo);

		if("".equals(searchVo.getSearchStackClCd()) || searchVo.getSearchStackClCd() == null){
			searchVo.setSearchStackClCd("all");
		}
		if("".equals(searchVo.getSearchMngrClCd()) || searchVo.getSearchMngrClCd() == null){
			searchVo.setSearchMngrClCd("all");
		}

		searchVo.setSearchNetId(netCd);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("list", list);

		return apiTilesView(request);
	}

	@RequestMapping(value = "/selectColctHealthCheck.do")
	@ResponseBody
    public ProcResultVo selectColctHealthCheck(HttpServletRequest request, Model model,
    		@RequestParam(required=true)String colctId, @RequestParam(required=true)String mngrId,
    		@RequestParam(required=true)String stackClCd, @RequestParam(required=true)String btchColctCd) throws Exception {

       ProcResultVo result = new ProcResultVo();
       result.setData(colctService.selectColctHealthCheck(colctId, mngrId, stackClCd, btchColctCd));
       return result;
    }


	/**
	 * 배치 수집현황 엑셀다운로드
	 * @param request
	 * @param response
	 * @param searchVo
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	@RequestMapping(value = "/selectColctListXlsDwnl.do")
    public void selectIPBndListXlsDwnl(HttpServletRequest request, HttpServletResponse response, ColctSearchVo searchVo) throws Exception {

		// 목록조회
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo = searchVo.getPaginationInfo();
		paginationInfo.setRecordCountPerPage(9999);
		searchVo.setPaginationInfo(paginationInfo);
		List<ColctVo> list = colctService.selectColctList(searchVo);
        // CusomSheet 생성
        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // 첫번째 Sheet Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();

        header.put("regionNm", "지역");
        header.put("ZoneNm", "Zone");
        header.put("netNm", "망");
        header.put("stackClNm", "스택분류");
        header.put("mngrClNm", "매니저분류");
        //header.put("mngrVerNm", "매니저버전");
        header.put("nowVerNm", "매니저버전");
        header.put("mngrNm", "매니저명");
        header.put("btchColctNm", "수집구분");
        header.put("btchSttusNm", "상태");

        // Sheet Vo 생성
        List<ColctVo> datas = new ArrayList<ColctVo>();
        for (ColctVo colctVo : list) {
        	ColctVo vo = new ColctVo();
        	vo.setRegionNm(colctVo.getRegionNm());
        	vo.setZoneNm(colctVo.getZoneNm());
        	vo.setNetNm(colctVo.getNetNm());
        	vo.setStackClNm(colctVo.getStackClNm());
        	vo.setMngrClNm(colctVo.getMngrClNm());
        	//vo.setMngrVerNm(colctVo.getMngrVerNm());
        	vo.setNowVerNm(colctVo.getNowVerNm());
        	vo.setMngrNm(colctVo.getMngrNm());
        	vo.setBtchColctNm(colctVo.getBtchColctNm());

        	if("N".equals(colctVo.getMonitoringYN())) {
        		vo.setBtchSttusNm("중지");
        	} else {
	        	ColctVo sttus = colctService.selectColctHealthCheck("1", colctVo.get_id(), colctVo.getStackClCd(), colctVo.getBtchColctCd());
	        	if(sttus.isBtchSttus()){
	        		vo.setBtchSttusNm("정상");
	        	} else {
	        		vo.setBtchSttusNm("지연");
	        	}
        	}
            datas.add(vo);
        }

        // Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("ColctVo");
        sheet.setDatas(datas);
        sheet.setHreader(header);

        sheets.add(sheet);

        // Excel 생성
        ExcelUtil.downloadExcel(response, String.format("Colct_%s", (new SimpleDateFormat("yyyyMMddhhmmss")).format(new Date())), sheets);
    }

}
