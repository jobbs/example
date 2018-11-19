/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmPatchController.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 11.
 * @lastmodified 2016. 10. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 11.     이화영         v1.0             최초생성
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

import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.patch.service.VmPatchService;
import ncis.cpt.opr.patch.vo.VmPatchPackgVo;
import ncis.cpt.opr.patch.vo.VmPatchSearchVo;
import ncis.cpt.opr.patch.vo.VmPatchVo;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.sys.code.vo.CodeVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 이화영
 *
 */
@Controller
@RequestMapping(value = "/cpt/opr/patch/vmPatch")
public class VmPatchController extends BaseController {

	@Resource(name = "commonService")
    CommonService commonService;

	@Resource(name = "vmPatchService")
	VmPatchService vmPatchService;


	/**
     * 가상서버 패키지 목록 조회 화면
     *
     * @param request
     * @param model
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/selectVmPatchList.do")
    public String selectVmPatchList(HttpServletRequest request, Model model, VmPatchSearchVo searchVo) {

         List<CodeVo> vrlzSwTyCdList = commonService.selectCodeList(ComConstant.VRLZ_SW_TY_GRP_CD, ComConstant.VRLZ_SW_TY_PARENT_CD); // 가상화SW 코드
         List<CodeVo> osTyCdList = commonService.selectCodeList(ComConstant.OS_TY_GRP_CD, ComConstant.OS_TY_PARENT_CD, true); // 운영체제유형 코드
         List<CodeVo> statCdList = commonService.selectCodeList(ComConstant.VM_STAT_GRP_GRP_CD, ComConstant.VM_STAT_GRP_PARENT_CD, true); // 가상서버상태그룹 코드

         List<VmPatchVo> vmPatchVoList = vmPatchService.selectVmPatchList(searchVo);

         model.addAttribute("statCdList", statCdList);
         model.addAttribute("osTyCdList", osTyCdList);
         model.addAttribute("vrlzSwTyCdList", vrlzSwTyCdList);

         model.addAttribute("searchVo", searchVo);
         model.addAttribute("vmPatchVoList", vmPatchVoList);

    	return portalTilesView(request);

    }

    /**
	 * 가상서버 목록 정보 Excel Down
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/selectVmPatchListXlsDwnl.do")
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response, VmPatchSearchVo vmPatchSearchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

	   //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();

	    header.put("statGrpCdNm", "상태");
	    header.put("institutionNm", "부처");
        header.put("jobsNm", "업무");
        if (vmPatchSearchVo.isSysAdm() || vmPatchSearchVo.isOprAdm()) {
	        header.put("regionNm", "센터");
	        header.put("zoneNm", "존");
	        header.put("netNm", "망구분");
	        header.put("rsrcPoolNm", "자원풀");
	        header.put("vrlzSwTyCdNm", "가상화SW");
        }
        header.put("vmCompId", "가상서버구성ID");
        header.put("vmNm", "가상서버명");
        header.put("vmId", "가상서버ID");
        header.put("hstNm", "호스트명");
        header.put("rprsntIpAddr", "IP주소");
        header.put("osTyCdNm", "OS유형");
        header.put("regDt", "생성일자");

        List<VmPatchVo> list = vmPatchService.selectVmPatchExcelList(vmPatchSearchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("가상서버패키지 목록");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("가상서버패키지_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

    /**
     * 가상서버 패키지 상세 정보 조회 화면
     *
     * @param request
     * @param model
     * @param vmSeq
     * @return
     */
    @RequestMapping(value = "/selectVmPatch.do")
    public String selectVmPatch(HttpServletRequest request, Model model, VmPatchVo vmPatchVo) {

    	VmPatchVo vmPatchVo1 = vmPatchService.selectVmPatch(vmPatchVo);
    	List<VmPatchPackgVo> vmPatchPackgList = vmPatchService.selectVmPatchPackgList(vmPatchVo);

        model.addAttribute("vmPatchVo", vmPatchVo1);
        model.addAttribute("vmPatchPackgList", vmPatchPackgList);

        return portalTilesView(request);

    }

    /**
   	 * 패키지 설치 목록 정보 Excel Down
   	 * @param request
   	 * @param model
   	 * @return
   	 */
   	@RequestMapping(value="/selectVmPatchXlsDwnl.do")
       public void selectVmPatchXlsDwnl(HttpServletRequest request, HttpServletResponse response, VmPatchVo vmPatchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

   	   //CusomSheet 생성
   		List<VmPatchPackgVo> list = vmPatchService.selectVmPatchPackgList(vmPatchVo);

   	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

   	    //Header 생성
   	    Map<String, String> header = new LinkedHashMap<String, String>();
   	    header.put("packgNm", "패키지명");
   	    header.put("ver", "설치패키지 버전");
   	    header.put("release", "설치패키지 릴리즈");
   	    header.put("instlDt", "설치일자");
   	    header.put("lastVer", "최신패키지 버전");
   	    header.put("lastRelease", "최신패키지 릴리즈");
   	    header.put("repositNm", "레파지토리");
   	    header.put("updateYn", "업데이트 가능 여부");

   	 List<VmPatchPackgVo> datas = new ArrayList<VmPatchPackgVo>();
   	for (VmPatchPackgVo vmPatchPackgVo : list) {
   		VmPatchPackgVo vo = new VmPatchPackgVo();

   		vo.setPackgNm(vmPatchPackgVo.getPackgNm());
   		vo.setVer(vmPatchPackgVo.getVer());
   		vo.setRelease(vmPatchPackgVo.getRelease());
   		vo.setInstlDt(vmPatchPackgVo.getInstlDt());
   		vo.setLastVer(vmPatchPackgVo.getLastVer());
   		vo.setLastRelease(vmPatchPackgVo.getLastRelease());
   		vo.setRepositNm(vmPatchPackgVo.getRepositNm());

   		if(!vmPatchPackgVo.getVer().equals(vmPatchPackgVo.getLastVer()) || !vmPatchPackgVo.getRelease().equals(vmPatchPackgVo.getLastRelease())){
   			vo.setUpdateYn("가능");
   		}
   		datas.add(vo);
   	}

       CustomSheet sheet = new CustomSheet();
       sheet.setSheetName("패키지설치 목록");
       sheet.setDatas(datas);
       sheet.setHreader(header);
       sheets.add(sheet);

       ExcelUtil.downloadExcel(response, String.format("패키지설치_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
   }







}
