/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ClstrController.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.security.vo.UserVo;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.com.service.ClstrService;
import ncis.cpt.rsrc.com.service.PmService;
import ncis.cpt.rsrc.com.service.RsrcReqService;
import ncis.cpt.rsrc.com.util.InputValidationUtils;
import ncis.cpt.rsrc.com.validation.InsertClstrCreReqValidation;
import ncis.cpt.rsrc.com.validation.InsertClstrDelReqValidation;
import ncis.cpt.rsrc.com.vo.ClstrPrposVo;
import ncis.cpt.rsrc.com.vo.ClstrSearchVo;
import ncis.cpt.rsrc.com.vo.ClstrVo;
import ncis.cpt.rsrc.com.vo.PmSearchVo;
import ncis.cpt.rsrc.com.vo.PmVo;
import ncis.cpt.rsrc.com.vo.RsrcReqPhyRsrcVo;
import ncis.cpt.rsrc.com.vo.RsrcReqVo;
import ncis.cpt.rsrc.com.vo.ViewFocusHandlerVo;
import ncis.cpt.sys.code.service.CodeService;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 심원보
 *
 */
@Controller
@RequestMapping(value = "/cpt/rsrc/com/clstr")
public class ClstrController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(VmController.class);

  	private final String RC_CLSTR_CRE = "클러스터 생성요청";
  	private final String RC_CLSTR_DEL = "클러스터 삭제요청";

    @Resource(name = "clstrService")
    ClstrService clstrService;

    @Resource(name = "pmService")
    PmService pmService;

    @Resource(name = "commonService")
    CommonService commonService;

    @Resource(name = "codeService")
    CodeService codeService;

    @Resource(name = "rsrcReqService")
    RsrcReqService rsrcReqService;

    /**
     * 클러스터 목록 조회 화면
     *
     * @param request
     * @param model
     * @param clstrSearchVo
     * @return
     */
    @RequestMapping(value = "/selectClstrList.do")
    public String selectClstrListView(HttpServletRequest request, Model model, ClstrSearchVo clstrSearchVo) {

        List<ClstrVo> clstrVoList = clstrService.selectClstrListPaging(clstrSearchVo);
        List<CodeVo> vrlzSwTyCdList = commonService.selectCodeList(ComConstant.VRLZ_SW_TY_GRP_CD, ComConstant.VRLZ_SW_TY_PARENT_CD); // 가상화SW 코드

        model.addAttribute("vrlzSwTyCdList", vrlzSwTyCdList);
        model.addAttribute("clstrVoList", clstrVoList);
        model.addAttribute("clstrSearchVo", clstrSearchVo);
        model.addAttribute("ivu", new InputValidationUtils());

        return portalTilesView(request);

    }

    /**
     * 클러스터 목록 엑셀 다운로드
     *
     * @param request
     * @param model
     * @param clstrSearchVo
     * @return
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    @RequestMapping(value = "/selectClstrListXlsDwnl.do")
    public void selectClstrListXlsDwnl(HttpServletRequest request, HttpServletResponse response, Model model, ClstrSearchVo clstrSearchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<ClstrVo> clstrVoList = clstrService.selectClstrList(clstrSearchVo);

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("useYnNm", "사용여부");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netClCdNm", "망구분");
        /*header.put("netNm", "망");*/
        header.put("rsrcPoolNm", "자원풀");
        header.put("clstrId", "클러스터ID");
        header.put("clstrNm", "클러스터명");
        header.put("vrlzSwTyCdNm", "가상화SW");
        header.put("pmCnt", "물리서버수");
        header.put("vmCnt", "가상서버수");
        header.put("avgCpuUseRt", "CPU 사용률 (%)");
        header.put("cpuVrlzRt", "CPU 가상화율 (%)");
        header.put("totCpuEnt", "CPU (Ent)");
        header.put("totCpuVcoreQty", "CPU (vCore)");
        header.put("totCpuCoreQty", "CPU (Core)");
        header.put("avgMemUseRt", "메모리 사용률 (%)");
        header.put("memVrlzRt", "메모리 가상화율 (%)");
        header.put("totMemAsgnCapa", "메모리 할당량 (GB)");
        header.put("totMemCapa", "메모리 전체량 (GB)");
        header.put("totStrgAsgnCapa", "스토리지 (GB)");
        header.put("totNetwkIn", "네트워크 In (KB/S)");
        header.put("totNetwkOut", "네트워크 Out (KB/S)");

        for (int i = 0; i < clstrVoList.size(); i++) {
            if(null != clstrVoList.get(i).getUseYn()){
                clstrVoList.get(i).setUseYnNm(clstrVoList.get(i).getUseYn().equals("Y") ? "사용" : "미사용");
            }
        }

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("클러스터");
        sheet.setDatas(clstrVoList);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("클러스터_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

    /**
     * 클러스터 상세 정보 조회 화면
     *
     * @param request
     * @param model
     * @param clstrSeq
     * @return
     */
    @RequestMapping(value = "/selectClstr.do")
    public String selectClstrView(HttpServletRequest request, Model model, @RequestParam(required = true) BigDecimal clstrSeq) {

        if (null == clstrSeq) {
            model.addAttribute("message", ComConstant.NOT_EXIST_TARGET_CLSTR_MSG);
            return jstlView("/error/common");
        }

        ClstrVo clstrVo = clstrService.selectClstr(clstrSeq);

        if (null == clstrVo) {
            model.addAttribute("message", ComConstant.NOT_EXIST_TARGET_CLSTR_MSG);
            return jstlView("/error/common");
        }

        List<CodeVo> prposClCdList = commonService.selectCodeList(ComConstant.CLSTR_PRPOS_GRP_CD, ComConstant.CLSTR_PRPOS_PARENT_CD); // 클러스터 용도 코드

        PmSearchVo pmSearchVo = new PmSearchVo();
        pmSearchVo.setSearchClstrSeq(clstrSeq);
        List<PmVo> pmVoList = pmService.selectPmList(pmSearchVo, false);

        model.addAttribute("prposClCdList", prposClCdList);
        model.addAttribute("clstrVo", clstrVo);
        model.addAttribute("pmVoList", pmVoList);
        model.addAttribute("ivu", new InputValidationUtils());

        return portalTilesView(request);

    }

    /**
     * 클러스터 생성 요청 화면
     *
     * @param request
     * @param model
     * @param clstrSeq
     * @return
     */
    @RequestMapping(value = "/insertClstrCreReq.do")
    public String insertClstrCreReqView(HttpServletRequest request, Model model) {

        List<CodeVo> prposClCdList = commonService.selectCodeList(ComConstant.CLSTR_PRPOS_GRP_CD, ComConstant.CLSTR_PRPOS_PARENT_CD); // 클러스터 용도 코드

        model.addAttribute("title" , RC_CLSTR_CRE);
        model.addAttribute("prposClCdList", prposClCdList);
        model.addAttribute("rsrcReqVo", new RsrcReqVo());
        model.addAttribute("rsrcReqPhyRsrcVo", new RsrcReqPhyRsrcVo());
        model.addAttribute("ivu", new InputValidationUtils());

        return portalTilesView(request);

    }

    /**
     * 클러스터 생성 요청
     *
     * @param rsrcReqVo
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/insertClstrCreReq.do", method = RequestMethod.POST)
    @OperateLog(action = "클러스터 생성 요청", desc = "새 클러스터를 생성 요청한다.", params = { "rsrcReqVo", "bindingResult" })
    @ResponseBody
    public ProcResultVo insertClstrCreReq(RsrcReqVo rsrcReqVo, BindingResult bindingResult) {

        ProcResultVo procResultVo = getBindingResult(rsrcReqVo, bindingResult, InsertClstrCreReqValidation.class);

        if (!procResultVo.isSuccess()) {
            return procResultVo;
        }

        try {

            for (ListIterator<RsrcReqPhyRsrcVo> listIterator = rsrcReqVo.getRsrcReqPhyRsrcVoList().listIterator(); listIterator.hasNext();) {
                int i = listIterator.nextIndex();
                RsrcReqPhyRsrcVo rsrcReqPhyRsrcVo = listIterator.next();
                if (null != rsrcReqPhyRsrcVo.getClstrCompId() && !rsrcReqPhyRsrcVo.getClstrCompId().isEmpty() && clstrService.isExistsClstrCompId(rsrcReqPhyRsrcVo.getClstrCompId())) {
                    return getFailProcResult(ComConstant.CLSTR_COMP_ID_ALREADY_EXISTS_MSG, ComConstant.INSERT, new ViewFocusHandlerVo(String.format("rsrcReqPhyRsrcVoList[%d]", i), new ViewFocusHandlerVo("clstrCompId")));
                }
            }

            UserVo userVo = getUser();

            rsrcReqVo.setRsrcReqUserId(userVo.getUserId());
            rsrcReqVo.setReqInstitutionId(userVo.getInstitutionId());
            rsrcReqVo.setRegUserId(userVo.getUserId());
            rsrcReqVo.setRsrcReqTyCd(ComConstant.RSRC_REQ_TY_CD_CLSTR_CRE_CD); // 자원요청유형코드 - 클러스터 생성
            rsrcReqVo.setRsrcReqPrcssStatCd(ComConstant.RSRC_REQ_PRCSS_STAT_CD_REQ_CD); // 자원요청처리상태코드 - 요청

            rsrcReqService.insertRsrcReqClstrCreReq(rsrcReqVo);

            return getSuccessProcResult(ComConstant.SUCCESS_MSG, ComConstant.INSERT);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }
    }

    /**
     * 클러스터 삭제 요청 화면
     *
     * @param request
     * @param model
     * @param clstrSeq
     * @return
     */
    @RequestMapping(value = "/insertClstrDelReq.do")
    public String insertClstrDelReqView(HttpServletRequest request, Model model, @RequestParam(required = true) BigDecimal clstrSeq) {

        if (null == clstrSeq) {
            model.addAttribute("message", ComConstant.NOT_EXIST_TARGET_CLSTR_MSG);
            return jstlView("/error/common");
        }

        ClstrVo clstrVo = clstrService.selectClstr(clstrSeq);

        if (null == clstrVo) {
            model.addAttribute("message", ComConstant.NOT_EXIST_TARGET_CLSTR_MSG);
            return jstlView("/error/common");
        }

        if (null == clstrVo.getCtlTrgtYn() || "N".equals(clstrVo.getCtlTrgtYn())) {
            model.addAttribute("message", ComConstant.NOT_CONTROL_TARGET_RSRC_POOL);
            return jstlView("/error/common");
        }

        RsrcReqVo rsrcReqVo = new RsrcReqVo();

        model.addAttribute("title" , RC_CLSTR_DEL);
        model.addAttribute("clstrVo", clstrVo);
        model.addAttribute("rsrcReqVo", rsrcReqVo);
        model.addAttribute("ivu", new InputValidationUtils());

        return portalTilesView(request);

    }

    /**
     * 클러스터 삭제 요청
     *
     * @param rsrcReqVo
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/insertClstrDelReq.do", method = RequestMethod.POST)
    @OperateLog(action = "클러스터 삭제 요청", desc = "클러스터를 삭제 요청한다.", params = { "rsrcReqVo", "bindingResult" })
    @ResponseBody
    public ProcResultVo insertClstrDelReq(RsrcReqVo rsrcReqVo, BindingResult bindingResult) {

        ProcResultVo procResultVo = getBindingResult(rsrcReqVo, bindingResult, InsertClstrDelReqValidation.class);
        if (!procResultVo.isSuccess()) {
            return procResultVo;
        }

        try {

            for (RsrcReqPhyRsrcVo rsrcReqPhyRsrcVo : rsrcReqVo.getRsrcReqPhyRsrcVoList()) {
                ClstrVo clstrVo = clstrService.selectClstr(rsrcReqPhyRsrcVo.getClstrSeq());
                if (clstrVo.getPmCnt() > 0 || clstrVo.getVmCnt() > 0) {
                    return getFailProcResult(ComConstant.UNABLE_TO_DELETE_CLSTR_HAS_PM_OR_VM_MSG);
                }
            }

            UserVo userVo = getUser();

            rsrcReqVo.setRsrcReqUserId(userVo.getUserId());
            rsrcReqVo.setReqInstitutionId(userVo.getInstitutionId());
            rsrcReqVo.setRegUserId(userVo.getUserId());
            rsrcReqVo.setRsrcReqTyCd(ComConstant.RSRC_REQ_TY_CD_CLSTR_DEL_CD); // 자원요청유형코드 - 클러스터 삭제
            rsrcReqVo.setRsrcReqPrcssStatCd(ComConstant.RSRC_REQ_PRCSS_STAT_CD_REQ_CD); // 자원요청처리상태코드 - 요청

            rsrcReqService.insertRsrcReqClstrDelReq(rsrcReqVo);
            return getSuccessProcResult(ComConstant.SUCCESS_MSG, ComConstant.INSERT);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }
    }

    /**
     * 클러스터 정보 수정
     *
     * @param clstrVo
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/updateClstr.do", method = RequestMethod.POST)
    @OperateLog(action = "클러스터 정보 수정", desc = "클러스터 구성ID, 사용여부 및 용도 정보 수정", params = { "clstrVo", "bindingResult" })
    @ResponseBody
    public ProcResultVo updateClstr(ClstrVo clstrVo, BindingResult bindingResult) {

        ProcResultVo procResultVo = getBindingResult(clstrVo, bindingResult, UpdateProc.class);
        if (!procResultVo.isSuccess()) {
            return procResultVo;
        }

        try {
            ClstrVo clstrVoOld = clstrService.selectClstr(clstrVo.getClstrSeq());
            if (null == clstrVoOld) {
                return getFailProcResult(ComConstant.NOT_EXIST_TARGET_CLUSTER_MSG);
            }
            if (!clstrVo.getClstrCompId().equals(clstrVoOld.getClstrCompId()) && !"".equals(clstrVo.getClstrCompId()) && clstrService.isExistsClstrCompId(clstrVo.getClstrCompId())) {
                return getFailProcResult(ComConstant.CLSTR_COMP_ID_ALREADY_EXISTS_MSG, ComConstant.UPDATE, new ViewFocusHandlerVo("clstrCompId"));
            }
            if (null != clstrVo.getUseYn() && "N".equals(clstrVo.getUseYn()) && !clstrVo.getUseYn().equals(clstrVoOld.getUseYn())) {
                if (clstrVoOld.getPmCnt() > 0 || clstrVoOld.getVmCnt() > 0) {
                    return getFailProcResult(ComConstant.CANNOT_CHANGE_AVAILABLITY_CLSTR_HAS_PM_OR_VM_MSG, ComConstant.UPDATE, new ViewFocusHandlerVo("useYn"));
                }
            }
            clstrVo.setUpdtUserId(getUserId());
            List<ClstrPrposVo> clstrPrposVoList = new ArrayList<ClstrPrposVo>();
            for (String prposClCd : clstrVo.getPrposClCdList()) {
                ClstrPrposVo clstrPrposVoForUpdate = new ClstrPrposVo();
                clstrPrposVoForUpdate.setClstrSeq(clstrVo.getClstrSeq());
                clstrPrposVoForUpdate.setPrposClCd(prposClCd);
                clstrPrposVoList.add(clstrPrposVoForUpdate);
            }
            clstrService.updateClstrAndClstrPrposList(clstrVo, clstrPrposVoList);

            return getSuccessProcResult(ComConstant.SUCCESS_MSG, ComConstant.UPDATE);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }

    }

}
