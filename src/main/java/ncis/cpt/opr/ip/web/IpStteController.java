/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename IpStteController.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 17.
 * @lastmodified 2016. 10. 17.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 17.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.ip.config.IpBndConstants;
import ncis.cpt.opr.ip.service.IpService;
import ncis.cpt.opr.ip.vo.IpSearchVo;
import ncis.cpt.opr.ip.vo.IpVo;
import ncis.cpt.sys.code.vo.CodeVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 신재훈
 *
 */

@Controller
@RequestMapping(value = "/cpt/opr/ip/ipStte")
public class IpStteController extends BaseController {

    @Resource(name = "ipService")
    IpService ipService;

    @Resource(name = "commonService")
    CommonService commonService;

    /**
     * 검색조건에 맞는 IP 목록조회
     *
     * @param request
     * @param model
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/selectIpStteList.do")
    public String selectIpStteListView(HttpServletRequest request, Model model, IpSearchVo searchVo) {
        List<CodeVo> ipStatCdList = commonService.selectCodeList(IpBndConstants.IP_STAT_GRP_CD, IpBndConstants.IP_STAT_PARENT_CD, true); // IP상태코드

        List<IpVo> list = ipService.selectIpStteList(searchVo);

        model.addAttribute("ipStatCdList", ipStatCdList);

        model.addAttribute("list", list);
        model.addAttribute("searchVo", searchVo);

        return portalTilesView(request);
    }

    /**
     * 검색조건에 맞는 IP 목록 엑셀 다운로드
     *
     * @param request
     * @param response
     * @param searchVo
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws IOException
     */
    @RequestMapping(value = "/selectIPListXlsDwnl.do")
    public void selectIpListXlsDwnl(HttpServletRequest request, HttpServletResponse response, IpSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
        List<IpVo> list = ipService.selectIpStteListXlsDwnl(searchVo);

        // CusomSheet 생성
        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // 첫번째 Sheet Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("ipStatCdNm", "상태");
        header.put("ipAddr", "IP주소");
        header.put("vmCompId", "가상서버 구성ID");
        header.put("netNm", "망구분");
        header.put("institutionNm", "사용부처");
        header.put("ipBndNm", "IP대역명");
        header.put("macAddr", "MAC주소");
        header.put("vmNm", "가상서버명");
        header.put("asgnDtToString", "할당일자");
        header.put("withdrawDtToString", "회수일자");

        // Sheet Vo 생성
        List<IpVo> datas = new ArrayList<IpVo>();
        datas.addAll(list);

        // Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("IP현황목록");
        sheet.setDatas(datas);
        sheet.setHreader(header);

        sheets.add(sheet);

        // Excel 생성
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String curDate = format.format(Calendar.getInstance().getTime());
        ExcelUtil.downloadExcel(response, "IP현황_" + curDate, sheets);

    }

}
