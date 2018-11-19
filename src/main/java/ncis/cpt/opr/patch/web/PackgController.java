/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PackgController.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.web;

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

import ncis.cmn.entity.OaPackgReposit;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.ip.config.IpBndConstants;
import ncis.cpt.opr.patch.service.PackgService;
import ncis.cpt.opr.patch.service.VmPatchService;
import ncis.cpt.opr.patch.vo.PackgInfoVo;
import ncis.cpt.opr.patch.vo.PackgSearchVo;
import ncis.cpt.opr.patch.vo.PackgVo;
import ncis.cpt.opr.patch.vo.VmPatchSearchVo;
import ncis.cpt.opr.patch.vo.VmPatchVo;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.sys.code.vo.CodeSearchVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 이화영
 *
 */
@Controller
@RequestMapping(value = "/cpt/opr/patch/packg")
public class PackgController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(PackgController.class);

	private final String PATCH_ALRM_CODE_PARENT_CD= "132";		//패치 알림 유형 코드
	private final String PATCH_ALRM_CODE_PARENT_GRP_CD= "049";	//패치 알림 유형 코드

	@Resource(name = "packgService")
	PackgService packgService;

	@Resource(name = "vmPatchService")
	VmPatchService vmPatchService;

	@Resource(name = "commonService")
    CommonService commonService;

	/**
     * 패키지 목록 조회 화면
     *
     * @param request
     * @param model
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/selectPackgList.do")
    public String selectPackgList(HttpServletRequest request, Model model, PackgSearchVo searchVo) {

    	List<PackgVo> packgVoList = packgService.selectPackgList(searchVo);

    	//List<RcNet> netVoList = null;
    	List<CodeVo> netVoList = commonService.selectCodeList(IpBndConstants.IP_BND_NET_GRP_CD, IpBndConstants.IP_BND_NET_PARENT_CD, true); // 망구분코드
    	List<OaPackgReposit> repositVoList = null;

    	/*if( null != searchVo.getSearchRegionId() && !"".equals(searchVo.getSearchRegionId())) {
    		//netVoList = packgService.selectPackgNetListByRegion(searchVo.getSearchRegionId());
    	}*/
    	if( null != searchVo.getSearchNetClCd() && !"".equals(searchVo.getSearchNetClCd())
    			|| null != searchVo.getSearchRegionId() && !"".equals(searchVo.getSearchRegionId())) {
    		repositVoList = packgService.selectPackgRepositListByNet(searchVo);
    	}

        model.addAttribute("packgVoList", packgVoList);
        model.addAttribute("repositVoList", repositVoList);
        model.addAttribute("netVoList", netVoList);
    	model.addAttribute("searchVo", searchVo);

    	return portalTilesView(request);

    }

    /**
     * 망 선택 목록
     * @param zoneId
     * @return
     */
   /* @RequestMapping(value="/selectPackgNetList.do")
    @ResponseBody
    public ProcResultVo selectPackgNetList(@RequestParam(required=true) String regionId) {
        ProcResultVo result = new ProcResultVo();
        //List<RcNet> list = packgService.selectPackgNetListByRegion(regionId);
        List<CodeVo> netVoList = commonService.selectCodeList(IpBndConstants.IP_BND_NET_GRP_CD, IpBndConstants.IP_BND_NET_PARENT_CD, true); // 망구분코드
        result.setData(netVoList);
        return result;
    }*/

    /**
     * 레파지토리 선택 목록
     * @param netId
     * @return
     */
    @RequestMapping(value="/selectPackgRepositList.do")
    @ResponseBody
    public ProcResultVo selectPackgRepositList(PackgSearchVo searchVo) {
        ProcResultVo result = new ProcResultVo();
        List<OaPackgReposit> list = packgService.selectPackgRepositListByNet(searchVo);
        result.setData(list);
        return result;
    }

    /**
	 * 패키지 목록 정보 Excel Down
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/selecthPackgListXlsDwnl.do")
    public void downloadPackgExcel(HttpServletRequest request, HttpServletResponse response, PackgSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

	   //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
	    header.put("regionNm", "센터");
        header.put("netNm", "망");
        header.put("repositNm", "레파지토리");
        header.put("packgNm", "패키지명");
        header.put("ver", "버전");
        header.put("release", "릴리즈");
        header.put("regDt", "등록일자");

        List<PackgVo> list = packgService.selectPackgExcelList(searchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("패키지 목록");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("패키지_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }


    /**
	 * 패키지 상세 조회
	 * @param packgSeq
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/selectPackg.do")
	public String selectPackg(HttpServletRequest request, Model model,PackgVo packgVo) {

		
		System.out.println("++++++"+packgVo.getPackgSeq());
		PackgInfoVo packgInfoVo = packgService.selectPackg(packgVo);

		VmPatchSearchVo vmPatchSearchVo = new VmPatchSearchVo();
		vmPatchSearchVo.setSearchPackgNm(packgVo.getPackgNm());

		PackgSearchVo packgSearchVo= new PackgSearchVo();
		packgSearchVo.setPackgSeq(packgVo.getPackgSeq());
		packgSearchVo.setSearchPackgNm(packgVo.getPackgNm());
		packgSearchVo.setSearchVer(packgVo.getVer());

		List<VmPatchVo> vmPatchVoList = vmPatchService.selectVmPatchList(vmPatchSearchVo);
		List<PackgVo> patchTrgtVoList = packgService.selectPatchTrgtList(packgSearchVo);

		model.addAttribute("packgInfoVo", packgInfoVo);
		model.addAttribute("vmPatchVoList", vmPatchVoList);
		model.addAttribute("patchTrgtVoList", patchTrgtVoList);
		model.addAttribute("vmPatchSearchVo", vmPatchSearchVo);
		model.addAttribute("packgSearchVo", packgSearchVo);

		return portalTilesView(request);
	}

	/**
	 * 가상서버 목록 정보 Excel Down
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/excelDownVmPatchList.do")
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response, @RequestParam(required=true) String packgNm) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

	   //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("institutionNm", "부처명");
        header.put("jobsNm", "업무명");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망구분");
        header.put("vrlzSwTyCdNm", "가상화SW");
        header.put("rsrcPoolNm", "자원풀");
        header.put("vmNm", "가상서버명");
        header.put("vmCompId", "가상서버구성ID");
        header.put("vmId", "가상서버ID");
        header.put("hstNm", "호스트명");
        header.put("rprsntIpAddr", "IP주소");
        header.put("osTyCdNm", "OS타입");
        header.put("regDt", "생성일자");

        VmPatchSearchVo vmPatchSearchVo = new VmPatchSearchVo();
        vmPatchSearchVo.setSearchPackgNm(packgNm);

        List<VmPatchVo> list = vmPatchService.selectVmPatchExcelList(vmPatchSearchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("가상서버 목록");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("가상서버_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

	/**
	 * 가상서버 목록 정보 Excel Down
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/excelDownPatchTrgList.do")
    public void downloadPatchTrgExcel(HttpServletRequest request, HttpServletResponse response, @RequestParam(required=true) String packgSeq, @RequestParam(required=true) String packgNm, @RequestParam(required=true) String ver) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

	   //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
	    header.put("ver", "패키지 버전");
        header.put("institutionNm", "부처명");
        header.put("jobsNm", "업무명");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망구분");
        header.put("vrlzSwTyCdNm", "가상화SW");
        header.put("rsrcPoolNm", "자원풀");
        header.put("vmNm", "가상서버명");
        header.put("vmCompId", "가상서버구성ID");
        header.put("vmId", "가상서버ID");
        header.put("hstNm", "호스트명");
        header.put("rprsntIpAddr", "IP주소");
        header.put("osTyCdNm", "OS타입");
        header.put("regDt", "생성일자");

        PackgSearchVo packgSearchVo= new PackgSearchVo();
		packgSearchVo.setPackgSeq(packgSeq);
		packgSearchVo.setSearchPackgNm(packgNm);
		packgSearchVo.setSearchVer(ver);

        List<PackgVo> list = packgService.selectPatchTrgtList(packgSearchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("패치대상 가상서버 목록");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("패치대상 가상서버_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

	/**
	 * 패키지 이전 버전 조회 화면 호출
	 * @param request
	 * @param model
	 * @return
	 */
	 @RequestMapping(value = "/selectPackgVerListP.do")
	 public String selectPackgVerListP(HttpServletRequest request, Model model, PackgSearchVo packgSearchVo) {

		 List<PackgVo> packgVoList = packgService.selectPackgVerList(packgSearchVo);

		 model.addAttribute("packgVoList", packgVoList);
		 model.addAttribute("searchVo", packgSearchVo);
		 model.addAttribute("title","패키지버전 조회");
		 return popup(request, "selectPackgVerListP");
	 }

	/**
	 * 패치알림 등록 화면 호출
	 * @param request
	 * @param model
	 * @return
	 */
	 @RequestMapping(value = "/insertPatchAlrmPView.do")
	 public String insertPatchAlrmPView(HttpServletRequest request, Model model, @RequestParam(required=true) String packgSeq,
			 @RequestParam(required=true) String packgNm, @RequestParam(required=true) String ver, @RequestParam(required=true) String release) {

		 CodeSearchVo searchVo = new CodeSearchVo();
		 searchVo.setSearchParentCd(PATCH_ALRM_CODE_PARENT_CD);
		 searchVo.setSearchParentGrpCd(PATCH_ALRM_CODE_PARENT_GRP_CD);
		 searchVo.setSearchUseYn("Y");
		 List<CodeVo> patchAlrmTyCdList = commonService.selectCodeList(searchVo);

		 PackgVo packgVo = new PackgVo();
		 packgVo.setTrgPackgSeq(packgSeq);
		 packgVo.setTrgPackgNm(packgNm);
		 packgVo.setTrgPackgVer(ver);
		 packgVo.setTrgRelease(release);

		 model.addAttribute("patchAlrmTyCdList", patchAlrmTyCdList);
		 model.addAttribute("packgVo", packgVo);
		 model.addAttribute("title","알림 등록");
		 return popup(request, "insertPatchAlrmP");

	 }

	 /**
	 * 패치 알림 등록
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="패치 알림 등록", desc="패치알림을 등록한다.", params={"PackgVo"}, actionType=ActionType.INSERT)
	@RequestMapping(value="/insertPatchAlrm.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo insertPatchAlrm(@ModelAttribute("packgVo") PackgVo packgVo) throws Exception{

		ProcResultVo result = new ProcResultVo();

		try {
			packgService.insertPatchAlrm(packgVo);
			result.setProcType("insert");
			result.setSuccess(true);
		} catch (InstantiationException | IllegalAccessException | IOException e) {
			 logger.error(e.getMessage());
			 result.addMessage(ComConstant.ERROR_MSG);
			 result.setSuccess(false);
        }
		 return result;
	}




}
