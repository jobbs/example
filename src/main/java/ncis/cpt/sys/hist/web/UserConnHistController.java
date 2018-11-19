/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserConnRecController.java
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
import ncis.cpt.sys.hist.service.UserConnHistService;
import ncis.cpt.sys.hist.vo.UserConnHistSearchVo;
import ncis.cpt.sys.hist.vo.UserConnHistVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/cpt/sys/hist/userconnhist")
public class UserConnHistController extends BaseController {

	@Resource(name="userConnHistService")
	UserConnHistService userConnHistService;

	/**
	 * 접속이력 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectUserConnHistList.do")
	public String selectUserConnHistList(HttpServletRequest request, Model model, UserConnHistSearchVo searchVo) {

		if( StringUtils.isEmpty(searchVo.getFirstSearch()) ) {
			searchVo.setSearchEndDate(DateUtil.getCurrentDate());
			searchVo.setSearchStartDate(DateUtil.dateToString(DateUtil.plusDate(new Date(), -7), "yyyy-MM-dd"));

			searchVo.setFirstSearch("N");
		}

		List<UserConnHistVo> list = userConnHistService.selectUserConnHistList(searchVo);

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		return portalTilesView(request);
	}


	/**
	 * 접속이력 목록 엑셀 파일 다운로드
	 * @param request
	 * @param response
	 * @param searchVo
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	@RequestMapping(value="/selectDownloadUserConnHist.do")
	public void selectDownloadUserConnHist(HttpServletRequest request, HttpServletResponse response, UserConnHistSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
		List<CustomSheet> sheets = new ArrayList<CustomSheet>();

		//Header 생성
		Map<String, String> header = new LinkedHashMap<String, String>();
		header.put("userId","아이디");
		header.put("userNm","이름");
		header.put("connIp","접속IP");
		header.put("connDt","접속일시");

		List<UserConnHistVo> list = userConnHistService.selectDownloadUserConnHist(searchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("사용자 접속 이력 목록");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response,String.format("사용자접속이력목록_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
	}
}
