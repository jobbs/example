/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserWrkHistController.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.hist.web;

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

import ncis.cmn.util.DateUtil;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.hist.service.UserWrkHistService;
import ncis.cpt.sys.hist.vo.UserWrkHistSearchVo;
import ncis.cpt.sys.hist.vo.UserWrkHistVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/cpt/sys/hist/userwrkhist")
public class UserWrkHistController extends BaseController {

	@Resource(name="userWrkHistService")
	UserWrkHistService userWrkHistService;

	/**
	 * 작업로그 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectUserWrkHistList.do")
	public String selectOperate(HttpServletRequest request, Model model, UserWrkHistSearchVo searchVo) {

		if( StringUtils.isEmpty(searchVo.getFirstSearch()) ) {
			searchVo.setSearchEndDate(DateUtil.getCurrentDate());
			searchVo.setSearchStartDate(DateUtil.dateToString(DateUtil.plusDate(new Date(), -7), "yyyy-MM-dd"));

			searchVo.setFirstSearch("N");
		}

		List<UserWrkHistVo> list = userWrkHistService.selectUserWrkHistList(searchVo);

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		return portalTilesView(request);
	}

	/**
	 * 작업이력 목록 엑셀 파일 다운로드
	 * @param request
	 * @param response
	 * @param searchVo
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	@RequestMapping(value="/selectDownloadUserWrkHist.do")
	public void selectDownloadUserWrkHist(HttpServletRequest request, HttpServletResponse response, UserWrkHistSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
		List<CustomSheet> sheets = new ArrayList<CustomSheet>();

		//Header 생성
		Map<String, String> header = new LinkedHashMap<String, String>();
		header.put("menuNm", "메뉴명");
		header.put("wrkInfo", "작업명");
		header.put("wrkDc", "작업설명");
		header.put("userId","작업자ID");
		header.put("userNm","작업자명");
		header.put("wrkIP","접속IP");
		header.put("wrkDttm","접속일시");

		List<UserWrkHistVo> list = userWrkHistService.selectDownloadUserWrkHist(searchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("작업 이력 목록");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response,String.format("작업이력목록_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
	}
}
