/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CmPopupController.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 30.
 * @lastmodified 2016. 9. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 30.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.component.web;

import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.component.service.MonitorService;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.DateUtil;
import ncis.cmn.vo.LineChartVo;
import ncis.cmn.vo.MonitorSearchVo;
import ncis.cmn.vo.Tree;
import ncis.cmn.vo.TreeNode;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.catalg.service.TmplatService;
import ncis.cpt.opr.ip.config.IpBndConstants;
import ncis.cpt.opr.ip.service.VrSwtchService;
import ncis.cpt.opr.ip.vo.IpBndVo;
import ncis.cpt.opr.ip.vo.VrSwtchSearchVo;
import ncis.cpt.opr.ip.vo.VrSwtchVo;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.com.service.VmService;
import ncis.cpt.rsrc.com.vo.PmVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.cpt.rsrc.pool.service.RsrcPoolService;
import ncis.cpt.rsrc.pool.vo.RsrcPoolSearchVo;
import ncis.cpt.rsrc.pool.vo.RsrcPoolVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.instt.service.InsttService;
import ncis.cpt.sys.instt.vo.InsttSearchVo;
import ncis.cpt.sys.instt.vo.InsttVo;
import ncis.cpt.sys.job.service.JobService;
import ncis.cpt.sys.job.vo.JobSearchVo;
import ncis.cpt.sys.job.vo.JobVo;
import ncis.cpt.sys.role.service.RoleService;
import ncis.cpt.sys.role.vo.RoleSearchVo;
import ncis.cpt.sys.role.vo.RoleVo;
import ncis.cpt.sys.user.service.UserService;
import ncis.cpt.sys.user.vo.UserSearchVo;
import ncis.cpt.sys.user.vo.UserVo;
import ncis.cpt.sys.zone.service.ZoneMngService;
import ncis.cpt.sys.zone.vo.ZoneVo;
import ncis.dsb.cmn.util.DsbUtil;
import ncis.dsb.cmn.vo.MainSearchVo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 최진호
 *
 */
@Controller
@RequestMapping(value = "/cmn/component")
public class CmPopupController extends BaseController {

    @Resource(name = "roleService")
    private RoleService roleService;

    @Resource(name = "jobService")
    private JobService jobService;

    @Resource(name = "vmService")
    VmService vmService;

    @Resource(name = "rsrcPoolService")
    RsrcPoolService rsrcPoolService;

    @Resource(name = "commonService")
    CommonService commonService;

    @Resource(name = "insttService")
    InsttService insttService;

    @Resource(name = "userService")
    UserService userService;

    @Resource(name = "vrSwtchService")
    VrSwtchService vrSwtchService;

    @Resource(name = "tmplatService")
    TmplatService tmplatService;

    @Resource(name = "zoneMngService")
    ZoneMngService zoneMngService;

    @Resource(name = "monitorService")
    MonitorService monitorService;

    /**
     * 권한 목록 조회 팝업
     *
     * @param request
     * @param model
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/role/selectRoleListP.do")
    public String selectRoleListView(HttpServletRequest request, Model model, RoleSearchVo searchVo) {

        List<RoleVo> list = roleService.selectRoleList(searchVo);

        model.addAttribute("title", "권한 정보");
        model.addAttribute("searchVo", searchVo);
        model.addAttribute("list", list);

        return popup(request);
    }

    /**
     * 부처 선택 화면 호출
     *
     * @param request
     * @param model
     * @param vmSearchVo
     * @param ipBndVo
     * @return
     */
    @RequestMapping(value = "/instt/selectInsttListP.do")
    public String selectInsttListView(HttpServletRequest request, Model model, InsttSearchVo searchVo) {
    	List<InsttVo> list = null;
    	list = insttService.selectInsttList(searchVo);

        model.addAttribute("title", "부처 정보");
        model.addAttribute("list", list);
        model.addAttribute("searchVo", searchVo);

        return popup(request);

    }

    /**
     * 업무 조회 팝업
     *
     * @param request
     * @param model
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/job/selectJobListP.do")
    public String selectJobListView(HttpServletRequest request, Model model, JobSearchVo searchVo) {

        List<JobVo> list = jobService.selectJobList(searchVo);

        if( null == searchVo.getSearchCludJob() )
            searchVo.setSearchCludJob("");

        model.addAttribute("title", "업무 정보");
        model.addAttribute("searchVo", searchVo);
        model.addAttribute("list", list);

        return popup(request);
    }

    /**
     * 로그인한 사용자가 보유하고 있는 자원풀 조회 팝업
     *
     * @param request
     * @param model
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/pool/selectUserPoolListP.do")
    public String selectUserPoolListView(HttpServletRequest request, Model model, RsrcPoolSearchVo searchVo) {

    	searchVo.setByRole(false);
        List<RsrcPoolVo> list = rsrcPoolService.selectUserRsrcPoolList(searchVo);

        model.addAttribute("title", "자원풀 정보");
        model.addAttribute("searchVo", searchVo);
        model.addAttribute("list", list);

        return popup(request, "selectPoolListP");
    }

    /**
     * 전체 존 선택 팝업
     *
     * @param request
     * @param model
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/zone/selectZoneListP.do")
    public String selectZoneListView(HttpServletRequest request, Model model) {

        model.addAttribute("title", "존 정보");
        return popup(request);
    }

    /**
     * 존 목록을 Tree 형태로 호출(자원풀을 제외한 조회, 공통 팝업에서 사용)
     *
     * @param parentSeq
     * @return
     */
    @RequestMapping(value = "/zone/selectZoneListTree.do")
    @ResponseBody
    public List<TreeNode<String, ZoneVo>> selectZoneListTree() {
        Tree<String, ZoneVo> tree = zoneMngService.selectZoneListTree();
        return tree.getRoot().getChildren();

    }

    /**
     * 자원풀 조회 팝업
     *
     * @param request
     * @param model
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/pool/selectPoolListP.do")
    public String selectPoolListView(HttpServletRequest request, Model model, RsrcPoolSearchVo searchVo) {

        List<RsrcPoolVo> list = rsrcPoolService.selectRsrcPoolList(searchVo);

        model.addAttribute("title", "자원풀 정보");
        model.addAttribute("searchVo", searchVo);
        model.addAttribute("list", list);

        return popup(request);
    }

    /**
     * 사용자 정보 검색
     *
     * @param request
     * @param model
     * @param vmSearchVo
     * @param ipBndVo
     * @return
     */
    @RequestMapping(value = "/user/selectUserListP.do")
    public String selectUserListView(HttpServletRequest request, Model model, UserSearchVo searchVo) {

        List<UserVo> list = userService.selectUserList(searchVo);

        model.addAttribute("title", "사용자 정보");
        model.addAttribute("list", list);
        model.addAttribute("searchVo", searchVo);
        return popup(request);

    }

    /**
     * 사용자 정보 검색
     *
     * @param request
     * @param model
     * @param vmSearchVo
     * @param ipBndVo
     * @return
     */
    @RequestMapping(value = "/user/selectUserViewListP.do")
    public String selectUserViewListView(HttpServletRequest request, Model model, UserSearchVo searchVo) {

        List<UserVo> list = userService.selectUserList(searchVo);

        model.addAttribute("title", "사용자 정보");
        model.addAttribute("list", list);
        model.addAttribute("searchVo", searchVo);
        return popup(request);

    }

    /**
     * 가상스위치 선택 화면 호출
     *
     * @param request
     * @param model
     * @param vmSearchVo
     * @param ipBndVo
     * @return
     */
    @RequestMapping(value = "/vrSwtch/selectVrSwtchListP.do")
    public String selectVrSwtchListView(HttpServletRequest request, Model model, VrSwtchSearchVo searchVo, IpBndVo ipBndVo) {
        if (null != ipBndVo.getRegionId()) {
            searchVo.setSearchRegionId(ipBndVo.getRegionId());
        }

        if (null != ipBndVo.getNetClCd()) {
            searchVo.setSearchNetClCd(ipBndVo.getNetClCd());
        }
        if(searchVo.getNetwkNm()==null) searchVo.setNetwkNm("");

        List<VrSwtchVo> vrList = vrSwtchService.selectVrSwtchList(searchVo);
        List<CodeVo> vrlzSwTyCdList = commonService.selectCodeList(ComConstant.VRLZ_SW_TY_GRP_CD, ComConstant.VRLZ_SW_TY_PARENT_CD); // 가상화SW 코드
        List<CodeVo> netList = commonService.selectCodeList(IpBndConstants.IP_BND_NET_GRP_CD, IpBndConstants.IP_BND_NET_PARENT_CD); // 망구분코드

        model.addAttribute("title", "가상스위치 선택");

        model.addAttribute("vrList", vrList);
        model.addAttribute("netList", netList);
        model.addAttribute("searchVo", searchVo);
        model.addAttribute("ipBndVo", ipBndVo);
        model.addAttribute("vrlzSwTyCdList", vrlzSwTyCdList);

        return popup(request);
    }

    @RequestMapping(value={"/dsb/selectInsttDetailListP.do"})
	public String selectInsttDetailListView(HttpServletRequest request, Model model, @ModelAttribute MainSearchVo searchVo) throws Exception {
		if( null == getUser() ) {
			return redirect("/login.do");
		}

		boolean insttDetailView = false;

		List<String> list = selectUserRoleList();
		if(list != null){
			for(int i =0; i<list.size();i++){
				String UserRole = (String)list.get(i);
				if("SYSADM".equals(UserRole) || "OPRCHR".equals(UserRole)) insttDetailView = true;
			}
		}

		model.addAttribute("title", "부처별 구성정보");
		model.addAttribute("insttDetailView", insttDetailView);

		return popup(request);
	}


	@RequestMapping(value="/monitor/selectVmMonitorP.do")
	public String selectVmMonitorP(
			MonitorSearchVo searchVo,
			HttpServletRequest request,
			Model model) throws Exception{

		if("DD".equals(searchVo.getSearchTrmCd()) && StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("HH");
		}else if("MM".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("DD");
		}else if("QQ".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("HH".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("YY".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("DI".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("DD");
		}
		else if(StringUtils.isEmpty(searchVo.getSearchTrmCd()) && StringUtils.isEmpty(searchVo.getColctCd()))
		{
			searchVo.setSearchTrmCd("DD");
			searchVo.setColctCd("HH");
			searchVo.setDate(DateUtil.getCurrentDate());
		}

		List<LineChartVo> chartList = monitorService.selectMonitorVmList(searchVo);

		VmVo vmInfo = monitorService.selectVmInfo(searchVo);

		model.addAttribute("searchVo", searchVo);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("vmInfo",vmInfo);
		model.addAttribute("chartList",chartList);
		model.addAttribute("title", "자원사용률");


		return popup(request,"selectVmMornitorP");
	}


	@RequestMapping(value="/monitor/selectVmMornitorPXlsDown.do")
	public void selectVmMonitorPXlsDown(
			MonitorSearchVo searchVo,
			Model model , HttpServletRequest request, HttpServletResponse response ) throws Exception{

		if("DD".equals(searchVo.getSearchTrmCd()) && StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("HH");
		}else if("MM".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("DD");
		}else if("QQ".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("HH".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("YY".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("DI".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("DD");
		}
		else if(StringUtils.isEmpty(searchVo.getSearchTrmCd()) && StringUtils.isEmpty(searchVo.getColctCd()))
		{
			searchVo.setSearchTrmCd("DD");
			searchVo.setColctCd("HH");
			searchVo.setDate(DateUtil.getCurrentDate());
		}

		List<LineChartVo> chartList = monitorService.selectMonitorVmList(searchVo);

		VmVo vmInfo = monitorService.selectVmInfo(searchVo);


		String fileNm = "가상서버현황_"+vmInfo.getVmNm()+"_"+DateUtil.getCurrentDate("yyyyMMdd");
		String title = "가상서버 : "+vmInfo.getVmNm();
		if(null != vmInfo.getVmCompId())
		{
			title += "(" +vmInfo.getVmCompId()+")";
		}

		// CusomSheet 생성
		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("가상서버현황");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);

		Cell titleCell0 = row.createCell(0);	titleCell0.setCellValue( title );		titleCell0.setCellStyle(headerStyle);

		sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));//타이틀

		row = sheet.createRow(1);
		Cell pmTitleCell0 = row.createCell(0);	pmTitleCell0.setCellValue( "기간" );		pmTitleCell0.setCellStyle(headerStyle);
		Cell pmTitleCell1 = row.createCell(1);	pmTitleCell1.setCellValue( "CPU 사용률" );			pmTitleCell1.setCellStyle(headerStyle);
		Cell pmTitleCell2 = row.createCell(2);	pmTitleCell2.setCellValue( "MEMORY 사용률" );			pmTitleCell2.setCellStyle(headerStyle);
		Cell pmTitleCell3 = row.createCell(3);	pmTitleCell3.setCellValue( "스토리지 사용률" );		pmTitleCell3.setCellStyle(headerStyle);
		Cell pmTitleCell4 = row.createCell(4);	pmTitleCell4.setCellValue( "Network In 사용률" );	pmTitleCell4.setCellStyle(headerStyle);
		Cell pmTitleCell5 = row.createCell(5);	pmTitleCell5.setCellValue( "Network Out 사용률" );	pmTitleCell5.setCellStyle(headerStyle);

		for(int i = 0 ; i < 6  ;i++)
		{
			sheet.autoSizeColumn(i);
			sheet.setColumnWidth(i, (sheet.getColumnWidth(i) + 1024 ));
		}

		LineChartVo vo = null;
		if(null == chartList || chartList.size() == 0){
			Row tmpRow = sheet.createRow(2);
			Cell tmpDataCell = tmpRow.createCell(0);
			tmpDataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(2,2,0,5));
		}
		else
		{
			int rowCnt = 2;
			Row dataRow = null;
			for(int i=0; i<chartList.size(); i++){
				vo = chartList.get(i);
				dataRow = sheet.createRow(rowCnt+i);
				Cell dataCell0 = dataRow.createCell(0);	 	dataCell0.setCellValue(vo.getTime());
				Cell dataCell1 = dataRow.createCell(1);	 	dataCell1.setCellValue(DateUtil.stringValueOf(vo.getCpuUseRatio()));
				Cell dataCell2 = dataRow.createCell(2);	 	dataCell2.setCellValue(DateUtil.stringValueOf(vo.getMemUseRatio()));
				Cell dataCell3 = dataRow.createCell(3);	 	dataCell3.setCellValue(DateUtil.stringValueOf(vo.getSanUseRatio()));
				Cell dataCell4 = dataRow.createCell(4);	 	dataCell4.setCellValue(DateUtil.stringValueOf(vo.getInTrafficUsed()));
				Cell dataCell5 = dataRow.createCell(5);	 	dataCell5.setCellValue(DateUtil.stringValueOf(vo.getOutTrafficUsed()));
			}
		}

		// Excel 생성
		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String((fileNm).getBytes("KSC5601"),"8859_1") + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();
	}


	@RequestMapping(value="/monitor/selectPmMonitorP.do")
	public String selectPmMonitorP(
			MonitorSearchVo searchVo,
			HttpServletRequest request,
			Model model) throws Exception{

		if("DD".equals(searchVo.getSearchTrmCd()) && StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("HH");
		}else if("MM".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("DD");
		}else if("QQ".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("HH".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("YY".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("DI".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("DD");
		}
		else if(StringUtils.isEmpty(searchVo.getSearchTrmCd()) && StringUtils.isEmpty(searchVo.getColctCd()))
		{
			searchVo.setSearchTrmCd("DD");
			searchVo.setColctCd("HH");
			searchVo.setDate(DateUtil.getCurrentDate());
		}

		List<LineChartVo> chartList = monitorService.selectMonitorPmList(searchVo);

		PmVo pmInfo = monitorService.selectPmInfo(searchVo);

		model.addAttribute("searchVo", searchVo);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("pmInfo",pmInfo);
		model.addAttribute("chartList",chartList);
		model.addAttribute("title", "자원사용률");


		return popup(request,"selectPmMornitorP");
	}


	@RequestMapping(value="/monitor/selectPmMornitorPXlsDown.do")
	public void selectPmMonitorPXlsDown(
			MonitorSearchVo searchVo,
			Model model , HttpServletRequest request, HttpServletResponse response ) throws Exception{

		if("DD".equals(searchVo.getSearchTrmCd()) && StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("HH");
		}else if("MM".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("DD");
		}else if("QQ".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("HH".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("YY".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("DI".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("DD");
		}
		else if(StringUtils.isEmpty(searchVo.getSearchTrmCd()) && StringUtils.isEmpty(searchVo.getColctCd()))
		{
			searchVo.setSearchTrmCd("DD");
			searchVo.setColctCd("HH");
			searchVo.setDate(DateUtil.getCurrentDate());
		}

		List<LineChartVo> chartList = monitorService.selectMonitorPmList(searchVo);

		PmVo pmInfo = monitorService.selectPmInfo(searchVo);


		String fileNm = "물리서버현황_"+pmInfo.getPmNm()+"_"+DateUtil.getCurrentDate("yyyyMMdd");
		String title = "물리서버 : "+pmInfo.getPmNm();
		if(null != pmInfo.getPmCompId())
		{
			title += "(" +pmInfo.getPmCompId()+")";
		}

		// CusomSheet 생성
		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("물리서버현황");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);

		Cell titleCell0 = row.createCell(0);	titleCell0.setCellValue( title );		titleCell0.setCellStyle(headerStyle);

		sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));//타이틀

		row = sheet.createRow(1);
		Cell pmTitleCell0 = row.createCell(0);	pmTitleCell0.setCellValue( "기간" );		pmTitleCell0.setCellStyle(headerStyle);
		Cell pmTitleCell1 = row.createCell(1);	pmTitleCell1.setCellValue( "CPU 사용률" );			pmTitleCell1.setCellStyle(headerStyle);
		Cell pmTitleCell2 = row.createCell(2);	pmTitleCell2.setCellValue( "MEMORY 사용률" );			pmTitleCell2.setCellStyle(headerStyle);
		Cell pmTitleCell3 = row.createCell(3);	pmTitleCell3.setCellValue( "스토리지 사용률" );		pmTitleCell3.setCellStyle(headerStyle);
		Cell pmTitleCell4 = row.createCell(4);	pmTitleCell4.setCellValue( "Network In 사용률" );	pmTitleCell4.setCellStyle(headerStyle);
		Cell pmTitleCell5 = row.createCell(5);	pmTitleCell5.setCellValue( "Network Out 사용률" );	pmTitleCell5.setCellStyle(headerStyle);

		for(int i = 0 ; i < 6  ;i++)
		{
			sheet.autoSizeColumn(i);
			sheet.setColumnWidth(i, (sheet.getColumnWidth(i) + 1024 ));
		}

		LineChartVo vo = null;
		if(null == chartList || chartList.size() == 0){
			Row tmpRow = sheet.createRow(2);
			Cell tmpDataCell = tmpRow.createCell(0);
			tmpDataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(2,2,0,5));
		}
		else
		{
			int rowCnt = 2;
			Row dataRow = null;
			for(int i=0; i<chartList.size(); i++){
				vo = chartList.get(i);
				dataRow = sheet.createRow(rowCnt+i);
				Cell dataCell0 = dataRow.createCell(0);	 	dataCell0.setCellValue(vo.getTime());
				Cell dataCell1 = dataRow.createCell(1);	 	dataCell1.setCellValue(DateUtil.stringValueOf(vo.getCpuUseRatio()));
				Cell dataCell2 = dataRow.createCell(2);	 	dataCell2.setCellValue(DateUtil.stringValueOf(vo.getMemUseRatio()));
				Cell dataCell3 = dataRow.createCell(3);	 	dataCell3.setCellValue(DateUtil.stringValueOf(vo.getSanUseRatio()));
				Cell dataCell4 = dataRow.createCell(4);	 	dataCell4.setCellValue(DateUtil.stringValueOf(vo.getInTrafficUsed()));
				Cell dataCell5 = dataRow.createCell(5);	 	dataCell5.setCellValue(DateUtil.stringValueOf(vo.getOutTrafficUsed()));
			}
		}

		// Excel 생성
		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String((fileNm).getBytes("KSC5601"),"8859_1") + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();
	}
}
