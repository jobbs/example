/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PackgAlrmController.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     이화영         v1.0             최초생성
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
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.patch.service.PackgAlrmService;
import ncis.cpt.opr.patch.service.VmPatchService;
import ncis.cpt.opr.patch.vo.PackgAlrmInfoVo;
import ncis.cpt.opr.patch.vo.PackgAlrmSearchVo;
import ncis.cpt.opr.patch.vo.PackgAlrmVo;
import ncis.cpt.opr.patch.vo.VmPatchVo;
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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 이화영
 *
 */
@Controller
@RequestMapping(value = "/cpt/opr/patch/packgAlrm")
public class PackgAlrmController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(PackgAlrmController.class);

	@Resource(name = "commonService")
    CommonService commonService;

	@Resource(name = "packgAlrmService")
	PackgAlrmService packgAlrmService;

	@Resource(name = "vmPatchService")
	VmPatchService vmPatchService;

	/**
     * 패치알림 목록 조회 화면
     *
     * @param request
     * @param model
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/selectPackgAlrmList.do")
    public String selectPackgAlrmList(HttpServletRequest request, Model model, PackgAlrmSearchVo searchVo) {

    	List<CodeVo> vrlzSwTyCdList = commonService.selectCodeList("001", "100"); // 가상화SW 코드

    	List<PackgAlrmVo> packgAlrmVoList = packgAlrmService.selectPackgAlrmList(searchVo);


    	 model.addAttribute("vrlzSwTyCdList", vrlzSwTyCdList);
    	 model.addAttribute("packgAlrmVoList", packgAlrmVoList);
    	 model.addAttribute("searchVo", searchVo);

    	return portalTilesView(request);

    }

    /**
	 * 패치알림 목록 정보 Excel Down
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/selectPackgAlrmListXlsDwnl.do")
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response, PackgAlrmSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

	   //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
	    header.put("confrmYnNm", "확인여부");
	    header.put("patchAlrmNm", "알림명");
	    header.put("patchAlrmDttm", "알림일자");
	    if (searchVo.isSysAdm()) {
	    	header.put("chargerNm", "담당자명");
	    }
	    header.put("vmNm", "가상서버명");
        header.put("packgNm", "대상 패키지명");
        header.put("ver", "대상버전");
        header.put("maxVer", "패치버전");
        header.put("institutionNm", "부처");
        header.put("jobsNm", "업무");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망구분");
        header.put("vrlzSwTyCdNm", "가상화SW");
        header.put("rsrcPoolNm", "자원풀");
        header.put("vmCompId", "가상서버구성ID");
        header.put("vmId", "가상서버ID");
        header.put("hstNm", "호스트명");
        header.put("rprsntIpAddr", "IP주소");

        List<PackgAlrmVo> list = packgAlrmService.selectPackgAlrmExcelList(searchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("패치알림 목록");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("패치알림_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

    /**
	 * 패치알림 상세 조회
	 * @param PackgAlrmVo
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/selectPackgAlrm.do")
	public String selectPackgAlrm(HttpServletRequest request, Model model, PackgAlrmVo packgAlrmVo) {


		//packgAlrmVo.setChargerId(getUserId());
		PackgAlrmInfoVo packgAlrmInfoVo = packgAlrmService.selectPackgAlrm(packgAlrmVo);
		VmPatchVo vmPatchVo = new VmPatchVo();
		vmPatchVo.setVmSeq(packgAlrmVo.getVmSeq());
		VmPatchVo vmPatch = vmPatchService.selectVmPatch(vmPatchVo);

		model.addAttribute("packgAlrmInfoVo", packgAlrmInfoVo);
		model.addAttribute("vmPatchVo", vmPatch);

		return portalTilesView(request);
	}

	/**
     * 패치알림확인
     * @param searchVo
     * @return
     */
	@OperateLog(action="패치 알림 학인", desc="패치알림을 확인한다.", params={"packgAlrmSearchVo"}, actionType=ActionType.UPDATE)
    @RequestMapping(value = "/updatePackgAlrm.do", method = RequestMethod.POST)
    @ResponseBody
	public ProcResultVo updatePackgAlrm(@ModelAttribute("packgAlrmSearchVo") PackgAlrmSearchVo packgAlrmSearchVo) {
		ProcResultVo result = new ProcResultVo();
        try {

        	packgAlrmService.updatePackgAlrm(packgAlrmSearchVo);
        	result.setProcType("update");
			result.setSuccess(true);

			result.addMessage("패치알림이 확인이 정상처리 되었습니다.");

		} catch (Exception e) {
			logger.error(e.toString(), e);
			result.setSuccess(false);
			result.addMessage("패치알림 확인에 실패하였습니다.");
        }
        return result;
	}


}
