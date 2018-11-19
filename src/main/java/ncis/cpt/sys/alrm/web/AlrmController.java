/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename AlrmController.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.alrm.web;

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
import ncis.cpt.sys.alrm.service.AlrmService;
import ncis.cpt.sys.alrm.vo.AlrmSearchVo;
import ncis.cpt.sys.alrm.vo.AlrmVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 최진호
 *
 */
@Controller

/**
 * 알림 목록 조회
 * @author 최진호
 *
 */
@RequestMapping(value="/cpt/sys/alrm")
public class AlrmController extends BaseController {

    @Resource(name="alrmService") private AlrmService alrmService;

    @RequestMapping(value="/selectAlrmList.do")
    public String selectAlrmList(HttpServletRequest request, Model model, AlrmSearchVo searchVo) {
    	if( StringUtils.isEmpty(searchVo.getFirstSearch()) ) {
			searchVo.setSearchEndDate(DateUtil.getCurrentDate());
			searchVo.setSearchStartDate(DateUtil.dateToString(DateUtil.plusDate(new Date(), -1), "yyyy-MM-dd"));
			searchVo.setFirstSearch("N");
		}
    	List<AlrmVo> alrms =  alrmService.selectAlrmList(searchVo);

        model.addAttribute("list", alrms);
        model.addAttribute("searchVo", searchVo);

        return portalTilesView(request);

    }

    @RequestMapping(value="/selectAlrmListXlsDwnl.do")
    public void selectAlrmListXlsDwnl(HttpServletResponse response, Model model, AlrmSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("alrmSbjct","제목");
        header.put("statNm","상태");
        header.put("chargerNm","담당자");
        header.put("regDttm","등록일시");
        header.put("confrmDttm","확인일시");

        List<AlrmVo> list = alrmService.selectAlrmListXlsDwnl(searchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("알림정보관리 목록");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response,String.format("알림정보관리목록_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

}
