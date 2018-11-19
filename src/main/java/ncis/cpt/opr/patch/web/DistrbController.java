/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DistrbController.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 21.
 * @lastmodified 2016. 10. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 21.     이화영         v1.0             최초생성
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

import ncis.cmn.config.OprConstant;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.FileManageUtil;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.patch.service.DistrbService;
import ncis.cpt.opr.patch.vo.DistrbFileVo;
import ncis.cpt.opr.patch.vo.DistrbSearchVo;
import ncis.cpt.opr.patch.vo.DistrbVo;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.com.service.VmService;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.cpt.sys.code.vo.CodeSearchVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 이화영
 *
 */
@Controller
@RequestMapping(value = "/cpt/opr/patch/distrb")
public class DistrbController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(DistrbController.class);

	private final String FILE_PATH = "distrb";

	private final String DISTRB_REASN_CD_PARENT_CD= "137";		//배포사유 코드

	@Resource(name = "distrbService")
	DistrbService distrbService;

	@Resource(name = "commonService")
    CommonService commonService;

	@Resource(name = "vmService")
    VmService vmService;

	/**
     * 배포관리 조회 화면
     *
     * @param request
     * @param model
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/selectDistrbList.do")
    public String selectDistrbList(HttpServletRequest request, Model model, DistrbSearchVo searchVo) {

    	List<DistrbVo> distrbVoList = distrbService.selectDistrbList(searchVo);

    	model.addAttribute("distrbVoList", distrbVoList);
    	model.addAttribute("distrbSearchVo", searchVo);

    	return portalTilesView(request);
    }

    /**
	 * 가상서버 목록 정보 Excel Down
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/excelDownDistrbList.do")
    public void downloadDistrbExcel(HttpServletRequest request, HttpServletResponse response, DistrbSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

	   //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
	    header.put("ticketId", "티켓번호");
        header.put("distrbReasnNm", "배포사유");
        header.put("rmk", "배포내용");
        header.put("distrbPath", "배포경로");
        header.put("vmCompId", "가상서버구성ID");
        header.put("distrbExeUserNm", "배포실행자");
        header.put("distrbDttm", "배포일시");

        List<DistrbVo> list = distrbService.selectDistrbExcelList(searchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("배포이력 목록");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("버포이력_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

    /**
	 * 가상서버 조회 화면 호출
	 * @param request
	 * @param model
	 * @return
	 */
	 @RequestMapping(value = "/selectDistrVmListPView.do")
	 public String selectDistrVmListPView(HttpServletRequest request, Model model, VmSearchVo vmSearchVo) {

		 vmSearchVo.setEqualsOsTyCd("01");
		 vmSearchVo.setSearchPackgMngTrgtYn("Y");
		 List<VmVo> vmVoList = vmService.selectVmListPaging(vmSearchVo);
		 List<CodeVo> vrlzSwTyCdList = commonService.selectCodeList(ComConstant.VRLZ_SW_TY_GRP_CD, ComConstant.VRLZ_SW_TY_PARENT_CD); // 가상화SW 코드
		 List<CodeVo> osTyCdList = commonService.selectCodeList(ComConstant.OS_TY_GRP_CD, ComConstant.OS_TY_PARENT_CD, true); // 운영체제유형 코드
		 List<CodeVo> statCdList = commonService.selectCodeList(ComConstant.VM_STAT_GRP_GRP_CD, ComConstant.VM_STAT_GRP_PARENT_CD, true); // 가상서버상태 코드

		 model.addAttribute("vrlzSwTyCdList", vrlzSwTyCdList);
		 model.addAttribute("osTyCdList", osTyCdList);
		 model.addAttribute("statCdList", statCdList);
		 model.addAttribute("vmVoList", vmVoList);
		 model.addAttribute("vmSearchVo", vmSearchVo);
		 model.addAttribute("vmVo", new VmVo());

		 model.addAttribute("title","가상서버 선택");
		 return popup(request, "selectDistrVmListP");
	 }

	 /**
	 * 배포 정보 등록 화면 호출
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/insertDisrb.do", method = RequestMethod.GET)
	public String insertDisrbView(HttpServletRequest request, Model model){

		CodeSearchVo codeSearchVo = new CodeSearchVo();
    	codeSearchVo.setSearchParentCd(DISTRB_REASN_CD_PARENT_CD);
    	codeSearchVo.setSearchUseYn("Y");
    	List<CodeVo> patchAlrmTyCdList = commonService.selectCodeList(codeSearchVo);

    	DistrbVo distrbVo = new DistrbVo();
    	distrbVo.setDistrbPath(OprConstant.DISTRB_FILE_DEFAUlT_PATH);

    	model.addAttribute("patchAlrmTyCdList", patchAlrmTyCdList);
    	model.addAttribute("distrbVo", distrbVo);

		return portalTilesView(request);
	}

	 /**
	 * 배포 정보 등록
	 * @param distrbVo
	 * @return
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	 @RequestMapping(value = "/insertDisrb.do", method = RequestMethod.POST)
	 @OperateLog(action = "배포 정보 등록", desc = "배포 정보 내용을 등록한다.", params = { "distrbVo" }, actionType = ActionType.INSERT)
	 @ResponseBody
	 public ProcResultVo insertDisrb(@ModelAttribute("distrbVo") DistrbVo distrbVo, BindingResult bindResult) {

		 ProcResultVo result = getBindingResult(distrbVo, bindResult, InsertProc.class);

		 if (result.isSuccess()) {
			 try {
				 if (!ObjectUtils.isEmpty(distrbVo.getUploadFile())) {

					 distrbVo.setDistrbFile(FileManageUtil.uploadFile(distrbVo.getUploadFile(), FILE_PATH, DistrbFileVo.class, FileManageUtil.FileType.DEFAULT, new Long(10*1024*1024)));

				 }

				 distrbVo.setDistrbExeUserId(getUserId());
				 distrbVo.getDistrVmList();
				 distrbService.insertDisrb(distrbVo);
				 result.setProcType("insert");

			 } catch (InstantiationException | IllegalAccessException | IOException e) {

				 logger.error(e.getMessage());
				 result.addMessage("배포 정보 저장 시 오류가 발생하였습니다.");
				 result.setSuccess(false);
			}
		 }

		 return result;
	 }

}
