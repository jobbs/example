/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmController.java
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
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.config.OprConstant;
import ncis.cmn.entity.RrHaComp;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.security.vo.UserVo;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.DateUtil;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.catalg.service.SpecService;
import ncis.cpt.opr.catalg.service.TmplatService;
import ncis.cpt.opr.catalg.vo.SpecSvo;
import ncis.cpt.opr.catalg.vo.SpecVo;
import ncis.cpt.opr.catalg.vo.TmplatSvo;
import ncis.cpt.opr.catalg.vo.TmplatSwVo;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.com.logger.VmRcLogger;
import ncis.cpt.rsrc.com.service.PmService;
import ncis.cpt.rsrc.com.service.RsrcReqService;
import ncis.cpt.rsrc.com.service.VmService;
import ncis.cpt.rsrc.com.util.InputValidationUtils;
import ncis.cpt.rsrc.com.validation.InsertVmCreReqValidation;
import ncis.cpt.rsrc.com.validation.InsertVmDelReqValidation;
import ncis.cpt.rsrc.com.validation.InsertVmSpecModReqValidation;
import ncis.cpt.rsrc.com.validation.InsertVmStrgAddReqValidation;
import ncis.cpt.rsrc.com.vo.PmSearchVo;
import ncis.cpt.rsrc.com.vo.PmVo;
import ncis.cpt.rsrc.com.vo.RsrcReqVmVo;
import ncis.cpt.rsrc.com.vo.RsrcReqVo;
import ncis.cpt.rsrc.com.vo.ViewFocusHandlerVo;
import ncis.cpt.rsrc.com.vo.VmCompHistSearchVo;
import ncis.cpt.rsrc.com.vo.VmCompHistVo;
import ncis.cpt.rsrc.com.vo.VmMigrHistSearchVo;
import ncis.cpt.rsrc.com.vo.VmMigrHistVo;
import ncis.cpt.rsrc.com.vo.VmMigrVo;
import ncis.cpt.rsrc.com.vo.VmProcssMsgVo;
import ncis.cpt.rsrc.com.vo.VmProcssVo;
import ncis.cpt.rsrc.com.vo.VmRcKey;
import ncis.cpt.rsrc.com.vo.VmResHistSearchVo;
import ncis.cpt.rsrc.com.vo.VmResHistVo;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.com.vo.VmSnapHistSearchVo;
import ncis.cpt.rsrc.com.vo.VmSnapHistVo;
import ncis.cpt.rsrc.com.vo.VmSnapReqVo;
import ncis.cpt.rsrc.com.vo.VmSnapVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.cpt.rsrc.pool.service.RsrcPoolService;
import ncis.cpt.rsrc.pool.vo.RsrcPoolVo;
import ncis.cpt.rsrc.strg.service.VrStrgService;
import ncis.cpt.rsrc.strg.vo.VrStrgVo;
import ncis.cpt.sys.code.vo.CodeSearchVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.cpt.sys.hist.vo.UserWrkHistVo;
import ncis.intfc.vmintfc.service.VmIntfcService;
import ncis.intfc.vmintfc.vo.GraphicConsoleResultBodyVO;
import ncis.intfc.vmintfc.vo.GraphicConsoleVO;
import ncis.intfc.vmintfc.vo.VmStatusResultBodyVO;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 심원보
 *
 */
@Controller
@RequestMapping(value = "/cpt/rsrc/com/vm")
public class VmController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(VmController.class);

  //컴퓨팅>가상서버관리
    private final String RC_VM_CRE = "가상서버 생성요청";
    private final String RC_VM_SPEC_CHG = "가상서버 스펙변경요청";
  	private final String RC_VM_DEL = "가상서버 삭제요청";
  	private final String RC_VM_STRG_ADD = "가상서버 스토리지 추가요청";


    @Resource(name = "vmService")
    VmService vmService;

    @Resource(name = "pmService")
    PmService pmService;

    @Resource(name = "rsrcPoolService")
    RsrcPoolService rsrcPoolService;

    @Resource(name = "commonService")
    CommonService commonService;

    @Resource(name = "rsrcReqService")
    RsrcReqService rsrcReqService;

    @Resource(name = "specService")
    SpecService specService;

    @Resource(name = "tmplatService")
    TmplatService tmplatService;

    @Resource(name = "vmIntfcService")
    VmIntfcService vmIntfcService;

    @Resource(name = "vrStrgService")
    VrStrgService vrStrgService;

    /**
     * 가상서버 목록 조회 화면
     *
     * @param request
     * @param model
     * @param vmSearchVo
     * @return
     */
    @RequestMapping(value = "/selectVmList.do")
    public String selectVmListView(HttpServletRequest request, Model model, VmSearchVo vmSearchVo) {
    	List<VmVo> vmVoList = vmService.selectVmListPaging(vmSearchVo);
        List<CodeVo> vrlzSwTyCdList = commonService.selectCodeList(ComConstant.VRLZ_SW_TY_GRP_CD, ComConstant.VRLZ_SW_TY_PARENT_CD); // 가상화SW 코드

        CodeSearchVo codeSearchVo = new CodeSearchVo();
		codeSearchVo.setSearchParentCd(ComConstant.OS_TY_PARENT_CD);
		codeSearchVo.setSearchParentGrpCd(ComConstant.OS_TY_GRP_CD);
		codeSearchVo.setSearchWhole(true);
		codeSearchVo.setSearchExtra1("01");
        //List<CodeVo> osTyCdList = commonService.selectCodeList(ComConstant.OS_TY_GRP_CD, ComConstant.OS_TY_PARENT_CD); // 운영체제유형 코드
		List<CodeVo> osTyCdList = commonService.selectCodeList(codeSearchVo); // 운영체제유형 코드
        List<CodeVo> statGrpCdList = commonService.selectCodeList(ComConstant.VM_STAT_GRP_GRP_CD, ComConstant.VM_STAT_GRP_PARENT_CD, true); // 가상서버상태그룹 코드

        model.addAttribute("vrlzSwTyCdList", vrlzSwTyCdList);
        model.addAttribute("osTyCdList", osTyCdList);
        model.addAttribute("statGrpCdList", statGrpCdList);
        model.addAttribute("vmVoList", vmVoList);
        model.addAttribute("vmSearchVo", vmSearchVo);
        model.addAttribute("ivu", new InputValidationUtils());

        return portalTilesView(request);

    }

    /**
     * 가상서버 상세 정보 조회 화면
     *
     * @param request
     * @param model
     * @param vmSearchVo
     * @return
     */
    @RequestMapping(value = "/selectVm.do")
    public String selectVmView(HttpServletRequest request, Model model, VmSearchVo vmSearchVo) {

        if (null == vmSearchVo || null == vmSearchVo.getVmSeq()) {
            model.addAttribute("message", ComConstant.NOT_EXIST_TARGET_VM_MSG);
            return jstlView("/error/common");
        }

        vmSearchVo.setEqualsVmSeq(vmSearchVo.getVmSeq());
        VmVo vmVo = vmService.selectVmDetailByVmSearchVo(vmSearchVo);

        if (null == vmVo) {
            model.addAttribute("message", ComConstant.NOT_EXIST_TARGET_VM_MSG);
            return jstlView("/error/common");
        }

        if (null == vmSearchVo.getSearchType()) {
            vmSearchVo.setSearchType(ComConstant.VM_TAB_INFO);
        }

        if (ComConstant.VM_TAB_SNAP.equals(vmSearchVo.getSearchType())) {

            VmProcssVo vmProcssVo = new VmProcssVo();
            vmProcssVo.setVarVl(vmSearchVo.getVmSeq().toString());
            vmProcssVo.setProcssSeq(OprConstant.VM_REQ_COM_PROCESS_ID);
            vmProcssVo.setRefJobIdList(new String[] { OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_CRE, OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_RESTOR, OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_DEL });
            vmProcssVo = vmService.selectVmProcss(vmProcssVo);

            List<VmSnapVo> vmSnapVoList = vmService.selectVmSnapList(vmSearchVo.getVmSeq());
            int vmSnapVoCount = vmSnapVoList.size();

            model.addAttribute("vmProcssVo", vmProcssVo);
            model.addAttribute("vmSnapVoList", vmSnapVoList);
            model.addAttribute("vmSnapVoCount", vmSnapVoCount);
        }
        else if (ComConstant.VM_TAB_HIST.equals(vmSearchVo.getSearchType())) {

            List<CodeVo> vmReqCdList = commonService.selectCodeList(ComConstant.VM_REQ_GRP_CD, ComConstant.VM_REQ_PARENT_CD, true); // 가상서버요청유형 코드
            List<String> resList = new ArrayList<String>();
            List<String> migrList = new ArrayList<String>();
            List<String> snapList = new ArrayList<String>();
            List<String> compList = new ArrayList<String>();

            for (CodeVo codeVo : vmReqCdList) {

                if (null != codeVo.getVarVl1() && ComConstant.VM_REQ_RES_CD.equals(codeVo.getVarVl1())) {
                    resList.add(codeVo.getCd());
                }
                else if (null != codeVo.getVarVl1() && ComConstant.VM_REQ_MIGR_CD.equals(codeVo.getVarVl1())) {
                    migrList.add(codeVo.getCd());
                }
                else if (null != codeVo.getVarVl1() && ComConstant.VM_REQ_SNAP_CD.equals(codeVo.getVarVl1())) {
                    snapList.add(codeVo.getCd());
                }
                else if (null != codeVo.getVarVl1() && ComConstant.VM_REQ_COMP_CD.equals(codeVo.getVarVl1())) {
                    compList.add(codeVo.getCd());
                }
            }

            VmResHistSearchVo vmResHistSearchVo = new VmResHistSearchVo();
            VmMigrHistSearchVo vmMigrHistSearchVo = new VmMigrHistSearchVo();
            VmSnapHistSearchVo vmSnapHistSearchVo = new VmSnapHistSearchVo();
            VmCompHistSearchVo vmCompHistSearchVo = new VmCompHistSearchVo();

            vmResHistSearchVo.setSearchVmSeq(vmSearchVo.getVmSeq());
            vmResHistSearchVo.setVmReqTyCdList(resList.toArray(new String[resList.size()]));
            vmMigrHistSearchVo.setSearchVmSeq(vmSearchVo.getVmSeq());
            vmMigrHistSearchVo.setVmReqTyCdList(migrList.toArray(new String[migrList.size()]));
            vmSnapHistSearchVo.setSearchVmSeq(vmSearchVo.getVmSeq());
            vmSnapHistSearchVo.setVmReqTyCdList(snapList.toArray(new String[snapList.size()]));
            vmCompHistSearchVo.setSearchVmSeq(vmSearchVo.getVmSeq());
            vmCompHistSearchVo.setVmReqTyCdList(compList.toArray(new String[compList.size()]));

            vmResHistSearchVo.getPaginationInfo().setRecordCountPerPage(Integer.MAX_VALUE);
            vmMigrHistSearchVo.getPaginationInfo().setRecordCountPerPage(Integer.MAX_VALUE);
            vmSnapHistSearchVo.getPaginationInfo().setRecordCountPerPage(Integer.MAX_VALUE);
            vmCompHistSearchVo.getPaginationInfo().setRecordCountPerPage(Integer.MAX_VALUE);

            List<VmResHistVo> vmResHistVoList = vmService.selectVmResHistList(vmResHistSearchVo, true);
            List<VmMigrHistVo> vmMigrHistVoList = vmService.selectVmMigrHistList(vmMigrHistSearchVo, true);
            List<VmSnapHistVo> vmSnapHistVoList = vmService.selectVmSnapHistList(vmSnapHistSearchVo, true);
            List<VmCompHistVo> vmCompHistVoList = vmService.selectVmCompHistList(vmCompHistSearchVo, true);

            model.addAttribute("vmResHistVoList", vmResHistVoList);
            model.addAttribute("vmResHistSearchVo", vmResHistSearchVo);
            model.addAttribute("vmMigrHistVoList", vmMigrHistVoList);
            model.addAttribute("vmMigrHistSearchVo", vmMigrHistSearchVo);
            model.addAttribute("vmSnapHistVoList", vmSnapHistVoList);
            model.addAttribute("vmSnapHistSearchVo", vmSnapHistSearchVo);
            model.addAttribute("vmCompHistVoList", vmCompHistVoList);
            model.addAttribute("vmCompHistSearchVo", vmCompHistSearchVo);

        }

        model.addAttribute("vmVo", vmVo);
        model.addAttribute("vmSearchVo", vmSearchVo);
        model.addAttribute("ivu", new InputValidationUtils());

        return portalTilesView(request);

    }

    /**
     * 가상서버 목록 엑셀 다운로드
     *
     * @param request
     * @param model
     * @param vmSearchVo
     * @return
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    @RequestMapping(value = "/selectVmListXlsDwnl.do")
    public void selectVmListXlsDwnl(HttpServletRequest request, HttpServletResponse response, Model model, VmSearchVo vmSearchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<VmVo> vmVoList = vmService.selectVmList(vmSearchVo);

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        Map<String, String> header = new LinkedHashMap<String, String>();

        header.put("statGrpCdNm", "상태");
        header.put("institutionNm", "부처");
        header.put("jobsNm", "업무");
        if(vmSearchVo.isNetVmSltAt()){
        	header.put("netwkTyClCdNm", "네트워크유형");
        }
        if (vmSearchVo.isSysAdm() || vmSearchVo.isOprAdm()) { // 담당자 화면은 해당 항목 제외
            header.put("regionNm", "센터");
            header.put("zoneNm", "존");
            header.put("netClCdNm", "망구분");
            /*header.put("netNm", "망");*/
            header.put("rsrcPoolNm", "자원풀");
            header.put("clstrNm", "클러스터");
            header.put("pmNm", "물리서버명");
            header.put("pmCompId", "물리서버구성ID");
        }
        header.put("vmNm", "가상서버명");
        header.put("vmId", "가상서버ID");
        header.put("vmCompId", "가상서버구성ID");
        header.put("hstNm", "호스트명");
        header.put("rprsntIpAddr", "IP주소"); //
        header.put("osTyCdNm", "운영체제");
        if (vmSearchVo.isSysAdm() || vmSearchVo.isOprAdm()) { // 담당자 화면은 해당 항목 제외
            header.put("vrlzSwTyCdNm", "가상화SW");
        }
        header.put("cpuUseRt", "CPU 사용률 (%)");
        header.put("cpuEnt", "CPU (Ent)");
        header.put("cpuVcoreQty", "CPU (vCore)");
        header.put("memUseRt", "메모리 사용률 (%)");
        header.put("memAsgnCapa", "메모리 (GB)");
        header.put("strgAsgnCapa", "스토리지 (GB)");
        header.put("netwkIn", "네트워크 In (KB/S)");
        header.put("netwkOut", "네트워크 Out (KB/S)");
        header.put("uptime", "가동시간");

		//본사
		header.put("getStrtupDttmToString", "기동일시");
        header.put("regDttmToString", "생성일시");
		
		//센터
		//header.put("strtupDttm", "기동일시");
        //header.put("creDttm", "생성일시");


        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("가상서버");
        sheet.setDatas(vmVoList);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("가상서버_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

    /**
     * 가상서버 생성 요청 화면
     *
     * @param request
     * @param model
     * @param vmSeq
     * @return
     */
    @RequestMapping(value = "/insertVmCreReq.do")
    public String insertVmCreReqView(HttpServletRequest request, Model model) {

        List<CodeVo> prposClCdList = commonService.selectCodeList(ComConstant.CLSTR_PRPOS_GRP_CD, ComConstant.CLSTR_PRPOS_PARENT_CD); // 클러스터 용도 코드

        CodeSearchVo codeSearchVo = new CodeSearchVo();
		codeSearchVo.setSearchParentCd(ComConstant.OS_TY_PARENT_CD);
		codeSearchVo.setSearchParentGrpCd(ComConstant.OS_TY_GRP_CD);
		codeSearchVo.setSearchWhole(false);
		codeSearchVo.setSearchExtra1("01");

        //List<CodeVo> osTyCdList = commonService.selectCodeList(ComConstant.OS_TY_GRP_CD, ComConstant.OS_TY_PARENT_CD); // 운영체제유형 코드
		List<CodeVo> osTyCdList = commonService.selectCodeList(codeSearchVo); // 운영체제유형 코드
        List<CodeVo> netClCdList = commonService.selectCodeList(ComConstant.NET_CL_GRP_CD, ComConstant.NET_CL_PARENT_CD); // 망구분 코드

        List<CodeVo> haStatCdList = commonService.selectCodeList("089", "148"); // HA상태

        TmplatSvo tmplatSearchVo = new TmplatSvo();
        List<TmplatSwVo> tmplatSwVoList = tmplatService.selectSwList(tmplatSearchVo);

        RsrcReqVo reqVo = new RsrcReqVo();
        reqVo.setHaCompYn("N");
        reqVo.setTestYn("N");

        model.addAttribute("title" , RC_VM_CRE);
        model.addAttribute("prposClCdList", prposClCdList);
        model.addAttribute("osTyCdList", osTyCdList);
        model.addAttribute("tmplatSwVoList", tmplatSwVoList);
        model.addAttribute("netClCdList", netClCdList);

        model.addAttribute("haStatCdList", haStatCdList);

        model.addAttribute("rsrcReqVo", reqVo);
        model.addAttribute("ivu", new InputValidationUtils());

        return portalTilesView(request);

    }

    /**
     * 가상서버 생성 요청
     *
     * @param rsrcReqVo
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/insertVmCreReq.do", method = RequestMethod.POST)
    @OperateLog(action = "가상서버 생성 요청", desc = "가상서버를 생성 요청한다.", params = { "rsrcReqVo", "bindingResult" })
    @ResponseBody
    public ProcResultVo insertVmCreReq(RsrcReqVo rsrcReqVo, BindingResult bindingResult) {

        ProcResultVo procResultVo = getBindingResult(rsrcReqVo, bindingResult, InsertVmCreReqValidation.class);

        if (!procResultVo.isSuccess()) {
            return procResultVo;
        }

        try {

            for (ListIterator<RsrcReqVmVo> listIterator = rsrcReqVo.getRsrcReqVmVoList().listIterator(); listIterator.hasNext();) { // 가상서버구성ID 존재여부
                int i = listIterator.nextIndex();
                RsrcReqVmVo rsrcReqVmVo = listIterator.next();
                if (null != rsrcReqVmVo.getVmCompId() && !rsrcReqVmVo.getVmCompId().isEmpty() && vmService.isExistsVmCompId(rsrcReqVmVo.getVmCompId())) {
                    return getFailProcResult(ComConstant.VM_COMP_ID_ALREADY_EXISTS_MSG, ComConstant.INSERT, new ViewFocusHandlerVo(String.format("rsrcReqVmVoList[%d]", i), new ViewFocusHandlerVo("vmCompId")));
                }
            }

            UserVo userVo = getUser();

            rsrcReqVo.setRsrcReqUserId(userVo.getUserId());
            rsrcReqVo.setReqInstitutionId(userVo.getInstitutionId());
            rsrcReqVo.setRegUserId(userVo.getUserId());
            rsrcReqVo.setRsrcReqTyCd(ComConstant.RSRC_REQ_TY_CD_VM_CRE_CD); // 자원요청유형코드 - 가상서버 생성
            rsrcReqVo.setRsrcReqPrcssStatCd(ComConstant.RSRC_REQ_PRCSS_STAT_CD_REQ_CD); // 자원요청처리상태코드 - 요청

            //HA요청건일 경우 HA그룹ID는 채번테이블을 통해 셋팅
            if("Y".equals(rsrcReqVo.getHaCompYn())) {
            	RrHaComp rrHaComp = rsrcReqVo.getHaComp();
            	rrHaComp.setHaGrpId(commonService.selectSeqNum("RR_HA_COMP", "HA"));
            	rsrcReqVo.setHaComp(rrHaComp);
            }

            rsrcReqService.insertRsrcReqVmCreReq(rsrcReqVo);
            return getSuccessProcResult(ComConstant.SUCCESS_MSG, ComConstant.INSERT, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }

    }

    /**
     * 가상서버 스펙변경 요청 화면
     *
     * @param request
     * @param model
     * @param vmSeq
     * @return
     */
    @RequestMapping(value = "/insertVmSpecModReq.do")
    public String insertVmSpecModReqView(HttpServletRequest request, Model model, @RequestParam(required = true) BigDecimal vmSeq) {

        if (null == vmSeq) {
            model.addAttribute("message", ComConstant.NOT_EXIST_TARGET_VM_MSG);
            return jstlView("/error/common");
        }

        VmSearchVo vmSearchVo = new VmSearchVo();
        vmSearchVo.setEqualsVmSeq(vmSeq);
        VmVo vmVo = vmService.selectVmByVmSearchVo(vmSearchVo);

        if (null == vmVo) {
            model.addAttribute("message", ComConstant.NOT_EXIST_TARGET_VM_MSG);
            return jstlView("/error/common");
        }

        if (null == vmVo.getCtlTrgtYn() || "N".equals(vmVo.getCtlTrgtYn())) {
            model.addAttribute("message", ComConstant.NOT_CONTROL_TARGET_RSRC_POOL);
            return jstlView("/error/common");
        }

        SpecSvo specSearchVo = new SpecSvo();

        model.addAttribute("vmVo", vmVo);
        model.addAttribute("rsrcReqVo", new RsrcReqVo());
        if (vmVo.getOsTyCd() != null) {
        	specSearchVo.setSpecClCd(vmVo.getOsTyCd());
//            if ("02".equals(vmVo.getOsTyCd())) { // OS유형에 맞는 스펙 조회
//                specSearchVo.setSpecClCd("02");
//            }
//            else if ("03".equals(vmVo.getOsTyCd())) {
//                specSearchVo.setSpecClCd("01");
//            }
//            else {
//                specSearchVo.setSpecClCd("03");
//            }

            List<SpecVo> specVoList = specService.selectSpecList(specSearchVo);
            if (null != specVoList && !specVoList.isEmpty()) {
                for (int i = 0; i < specVoList.size(); i++) {
                    if (specVoList.get(i).getCpuVcore() == vmVo.getCpuVcoreQty() && specVoList.get(i).getMem() == vmVo.getMemAsgnCapa()) { // 동일 스펙 제외
                        specVoList.remove(i);
                    }
                }
                model.addAttribute("specVoList", specVoList);
            }
        }

        model.addAttribute("title" , RC_VM_SPEC_CHG);
        model.addAttribute("ivu", new InputValidationUtils());

        return portalTilesView(request);

    }

    /**
     * 가상서버 스펙변경 요청
     *
     * @param rsrcReqVo
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/insertVmSpecModReq.do", method = RequestMethod.POST)
    @OperateLog(action = "가상서버 스펙변경 요청", desc = "가상서버의 스펙을 변경요청한다.", params = { "rsrcReqVo", "bindingResult" })
    @ResponseBody
    public ProcResultVo insertVmSpecModReq(RsrcReqVo rsrcReqVo, BindingResult bindingResult) {

        ProcResultVo procResultVo = getBindingResult(rsrcReqVo, bindingResult, InsertVmSpecModReqValidation.class);

        if (!procResultVo.isSuccess()) {
            return procResultVo;
        }

        try {

            UserVo userVo = getUser();

            for (RsrcReqVmVo rsrcReqVmVo : rsrcReqVo.getRsrcReqVmVoList()) {
                VmVo vmVo = vmService.selectVm(rsrcReqVmVo.getVmSeq());
                rsrcReqVmVo.setChngPreCpuVcoreQty(vmVo.getCpuVcoreQty());
                rsrcReqVmVo.setChngPreMemAsgnCapa(vmVo.getMemAsgnCapa());
            }

            rsrcReqVo.setRsrcReqUserId(userVo.getUserId());
            rsrcReqVo.setReqInstitutionId(userVo.getInstitutionId());
            rsrcReqVo.setRegUserId(userVo.getUserId());
            rsrcReqVo.setRsrcReqTyCd(ComConstant.RSRC_REQ_TY_CD_VM_SPEC_MOD_CD); // 자원요청유형코드 - 가상서버스펙변경
            rsrcReqVo.setRsrcReqPrcssStatCd(ComConstant.RSRC_REQ_PRCSS_STAT_CD_REQ_CD); // 자원요청처리상태코드 - 요청

            rsrcReqService.insertRsrcReqVmSpecModReq(rsrcReqVo);

            return getSuccessProcResult(ComConstant.SUCCESS_MSG, ComConstant.INSERT, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }

    }

    /**
     * 가상서버 스토리지추가 요청 화면
     *
     * @param request
     * @param model
     * @param vmSeq
     * @return
     */
    @RequestMapping(value = "/insertVmStrgAddReq.do")
    public String insertVmStrgAddReqView(HttpServletRequest request, Model model, @RequestParam(required = true) BigDecimal vmSeq) {

        if (null == vmSeq) {
            model.addAttribute("message", ComConstant.NOT_EXIST_TARGET_VM_MSG);
            return jstlView("/error/common");
        }

        VmSearchVo vmSearchVo = new VmSearchVo();
        vmSearchVo.setEqualsVmSeq(vmSeq);
        VmVo vmVo = vmService.selectVmByVmSearchVo(vmSearchVo);

        if (null == vmVo) {
            model.addAttribute("message", ComConstant.NOT_EXIST_TARGET_VM_MSG);
            return jstlView("/error/common");
        }

        if (null == vmVo.getCtlTrgtYn() || "N".equals(vmVo.getCtlTrgtYn())) {
            model.addAttribute("message", ComConstant.NOT_CONTROL_TARGET_RSRC_POOL);
            return jstlView("/error/common");
        }

        model.addAttribute("title" , RC_VM_STRG_ADD);
        model.addAttribute("vmVo", vmVo);
        model.addAttribute("rsrcReqVo", new RsrcReqVo());
        model.addAttribute("ivu", new InputValidationUtils());

        return portalTilesView(request);

    }

    /**
     * 가상서버 스토리지추가 요청
     *
     * @param rsrcReqVo
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/insertVmStrgAddReq.do", method = RequestMethod.POST)
    @OperateLog(action = "가상서버 스토리지추가 요청", desc = "가상서버의 스토리지를 추가요청한다.", params = { "rsrcReqVo", "bindingResult" })
    @ResponseBody
    public ProcResultVo insertVmStrgAddReq(RsrcReqVo rsrcReqVo, BindingResult bindingResult) {

        ProcResultVo procResultVo = getBindingResult(rsrcReqVo, bindingResult, InsertVmStrgAddReqValidation.class);

        if (!procResultVo.isSuccess()) {
            return procResultVo;
        }

        try {
            UserVo userVo = getUser();

            for (RsrcReqVmVo rsrcReqVmVo : rsrcReqVo.getRsrcReqVmVoList()) {
                VmVo vmVo = vmService.selectVm(rsrcReqVmVo.getVmSeq());
                rsrcReqVmVo.setChngPreStrgAsgnCapa(vmVo.getStrgAsgnCapa());
            }

            rsrcReqVo.setRsrcReqUserId(userVo.getUserId());
            rsrcReqVo.setReqInstitutionId(userVo.getInstitutionId());
            rsrcReqVo.setRegUserId(userVo.getUserId());
            rsrcReqVo.setRsrcReqTyCd(ComConstant.RSRC_REQ_TY_CD_VM_STRG_ADD_CD); // 자원요청유형코드 - 가상서버스토리지추가
            rsrcReqVo.setRsrcReqPrcssStatCd(ComConstant.RSRC_REQ_PRCSS_STAT_CD_REQ_CD); // 자원요청처리상태코드 - 요청

            rsrcReqService.insertRsrcReqVmStrgAddReq(rsrcReqVo);

            return getSuccessProcResult(ComConstant.SUCCESS_MSG, ComConstant.INSERT, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }

    }

    /**
     * 가상서버 스토리지삭제 요청 화면(사용안함)
     *
     * @param request
     * @param model
     * @param vmSeq
     * @return
     */
    /*
     * @RequestMapping(value = "/insertVmStrgDelReq.do")
     * public String insertVmStrgDelReqView(HttpServletRequest request, Model model, @RequestParam(required = true) BigDecimal vmSeq) {
     * VmSearchVo vmSearchVo = new VmSearchVo();
     * vmSearchVo.setEqualsVmSeq(vmSeq);
     * VmVo vmVo = vmService.selectVmByVmSearchVo(vmSearchVo);
     * model.addAttribute("vmVo", vmVo);
     * model.addAttribute("rsrcReqVo", new RsrcReqVo());
     * model.addAttribute("ivu", new InputValidationUtils());
     * return portalTilesView(request);
     * }
     */

    /**
     * 가상서버 스토리지삭제 요청(사용안함)
     *
     * @param rsrcReqVo
     * @param bindingResult
     * @return
     */
    /*
     * @RequestMapping(value = "/insertVmStrgDelReq.do", method = RequestMethod.POST)
     * @OperateLog(action = "가상서버 스토리지삭제 요청", desc = "가상서버의 스토리지를 삭제요청한다.", params = { "rsrcReqVo", "bindingResult" })
     * @ResponseBody
     * public ProcResultVo insertVmStrgDelReq(RsrcReqVo rsrcReqVo, BindingResult bindingResult) {
     * ProcResultVo procResultVo = getBindingResult(rsrcReqVo, bindingResult, InsertVmStrgDelReqValidation.class);
     * if (!procResultVo.isSuccess()) {
     * return procResultVo;
     * }
     * try {
     * UserVo userVo = getUser();
     * rsrcReqVo.setRsrcReqUserId(userVo.getUserId());
     * rsrcReqVo.setReqInstitutionId(userVo.getInstitutionId());
     * rsrcReqVo.setRegUserId(userVo.getUserId());
     * rsrcReqVo.setRsrcReqTyCd(ComConstant.RSRC_REQ_TY_CD_VM_STRG_DEL_CD); // 자원요청유형코드 - 가상서버스토리지삭제
     * rsrcReqVo.setRsrcReqPrcssStatCd(ComConstant.RSRC_REQ_PRCSS_STAT_CD_REQ_CD); // 자원요청처리상태코드 - 요청
     * rsrcReqService.insertRsrcReqVmSpecModReq(rsrcReqVo);
     * return getSuccessProcResult(ComConstant.SUCCESS_MSG, ComConstant.INSERT, null);
     * } catch (Exception e) {
     * logger.error(e.getMessage());
     * return getFailProcResult(ComConstant.ERROR_MSG);
     * }
     * }
     */

    /**
     * 가상서버 삭제 요청 화면
     *
     * @param request
     * @param model
     * @param vmSeq
     * @return
     */
    @RequestMapping(value = "/insertVmDelReq.do")
    public String insertVmDelReqView(HttpServletRequest request, Model model, @RequestParam(required = true) BigDecimal vmSeq) {

        if (null == vmSeq) {
            model.addAttribute("message", ComConstant.NOT_EXIST_TARGET_VM_MSG);
            return jstlView("/error/common");
        }

        VmSearchVo vmSearchVo = new VmSearchVo();
        vmSearchVo.setEqualsVmSeq(vmSeq);
        VmVo vmVo = vmService.selectVmByVmSearchVo(vmSearchVo);

        if (null == vmVo) {
            model.addAttribute("message", ComConstant.NOT_EXIST_TARGET_VM_MSG);
            return jstlView("/error/common");
        }

        if (null == vmVo.getCtlTrgtYn() || "N".equals(vmVo.getCtlTrgtYn())) {
            model.addAttribute("message", ComConstant.NOT_CONTROL_TARGET_RSRC_POOL);
            return jstlView("/error/common");
        }

        model.addAttribute("title" , RC_VM_DEL);
        model.addAttribute("vmVo", vmVo);
        model.addAttribute("rsrcReqVo", new RsrcReqVo());
        model.addAttribute("ivu", new InputValidationUtils());

        return portalTilesView(request);

    }

    /**
     * 가상서버 삭제 요청
     *
     * @param rsrcReqVo
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/insertVmDelReq.do", method = RequestMethod.POST)
    @OperateLog(action = "가상서버 삭제 요청", desc = "가상서버를 삭제 요청한다.", params = { "rsrcReqVo", "bindingResult" })
    @ResponseBody
    public ProcResultVo insertVmDelReq(RsrcReqVo rsrcReqVo, BindingResult bindingResult) {

        ProcResultVo procResultVo = getBindingResult(rsrcReqVo, bindingResult, InsertVmDelReqValidation.class);

        if (!procResultVo.isSuccess()) {
            return procResultVo;
        }

        try {
            UserVo userVo = getUser();

            rsrcReqVo.setRsrcReqUserId(userVo.getUserId());
            rsrcReqVo.setReqInstitutionId(userVo.getInstitutionId());
            rsrcReqVo.setRegUserId(userVo.getUserId());
            rsrcReqVo.setRsrcReqTyCd(ComConstant.RSRC_REQ_TY_CD_VM_DEL_CD); // 자원요청유형코드 - 가상서버 삭제
            rsrcReqVo.setRsrcReqPrcssStatCd(ComConstant.RSRC_REQ_PRCSS_STAT_CD_REQ_CD); // 자원요청처리상태코드 - 요청

            rsrcReqService.insertRsrcReqVmDelReq(rsrcReqVo);

            return getSuccessProcResult(ComConstant.SUCCESS_MSG, ComConstant.INSERT, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }

    }

    /**
     * 가상서버 정보 수정
     *
     * @param vmVo
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/updateVm.do", method = RequestMethod.POST)
    @OperateLog(action = "가상서버 정보 수정", desc = "가상서버 구성ID 변경", params = { "vmVo", "bindingResult" })
    @ResponseBody
    public ProcResultVo updateVm(VmVo vmVo, BindingResult bindingResult) {

        ProcResultVo procResultVo = getBindingResult(vmVo, bindingResult, UpdateProc.class);

        if (!procResultVo.isSuccess()) {
            return procResultVo;
        }

        try {
            VmVo vmVoOld = vmService.selectVm(vmVo.getVmSeq());
            if (null == vmVoOld) {
                return getFailProcResult(ComConstant.NOT_EXIST_TARGET_VM_MSG);
            }
            //공백일때 비교하지 않도록 변경
            String tmpVmCompId = vmVo.getVmCompId().replaceAll(" ", "");

            if (!"".equals(tmpVmCompId) && !vmVo.getVmCompId().equals(vmVoOld.getVmCompId()) && vmService.isExistsVmCompId(vmVo.getVmCompId())) {
                return getFailProcResult(ComConstant.VM_COMP_ID_ALREADY_EXISTS_MSG, ComConstant.UPDATE, new ViewFocusHandlerVo("vmCompId"));
            }
            vmVo.setUpdtUserId(getUserId());
            if (!vmVo.getVmCompId().equals(vmVoOld.getVmCompId())) {
                VmResHistVo vmResHistVo = new VmResHistVo();
                vmResHistVo.setVmSeq(vmVoOld.getVmSeq());
                vmResHistVo.setLgcyCompId(vmVoOld.getVmCompId());
                vmResHistVo.setChngCompId(vmVo.getVmCompId());
                vmResHistVo.setVmReqTyCd(ComConstant.VM_REQ_TY_CD_CHG_COMP_ID);
                vmResHistVo.setWrkId(getUserId());
                vmResHistVo.setRsrcReqNo(ComConstant.RSRC_REQ_NO_DEFAULT_VALUE); // NULL을 허용하지 않아 기본값으로 대체
                vmResHistVo.setRsrcReqSeq(new BigDecimal(0)); // NULL을 허용하지 않아 기본값으로 대체
                vmService.updateVm(vmVo, vmResHistVo);
            }
            else {
                vmService.updateVm(vmVo, null);
            }

            return getSuccessProcResult(ComConstant.SUCCESS_MSG, ComConstant.UPDATE, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }
    }

    /**
     * 가상서버 시작
     *
     * @param vmSeq
     * @return
     */
    @RequestMapping(value = "/executeVmStart.do", method = RequestMethod.POST)
    @OperateLog(action = "가상서버 시작", desc = "가상서버 시작", params = { "vmSeq" })
    @ResponseBody
    public ProcResultVo executeVmStart(@RequestParam(required = true) BigDecimal vmSeq) {

        if (null == vmSeq) {
            return getFailProcResult(ComConstant.NOT_EXIST_TARGET_VM_MSG);
        }

        try {
            VmSearchVo vmSearchVo = new VmSearchVo();
            vmSearchVo.setEqualsVmSeq(vmSeq);
            VmVo vmVo = vmService.selectVmByVmSearchVo(vmSearchVo);

            RestHeaders restHeaders = new RestHeaders();
            restHeaders.setAreaId(vmVo.getRegionId());
            restHeaders.setZoneId(vmVo.getZoneId());
            restHeaders.setNetworkId(vmVo.getNetClCd());
            restHeaders.setManagerId(vmVo.getRsrcPoolId());
            VmStatusResultBodyVO vmStatusResultBodyVoBefore = vmIntfcService.status(vmVo.getUuid(), restHeaders);
            if (null == vmStatusResultBodyVoBefore.getState()) {
                return getFailProcResult(ComConstant.FAILED_TO_GET_VM_STATUS_MSG);
            }
            if (!vmStatusResultBodyVoBefore.getState().equals(vmVo.getStatCd())) {
                vmVo.setStatCd(vmStatusResultBodyVoBefore.getState());
                vmService.updateVmStatSync(vmVo);
            }
            if (ComConstant.VM_STAT_CD_DOWN.equals(vmStatusResultBodyVoBefore.getState())) {
                restHeaders.setSeq(commonService.selectSeqNum("GW_IF_JOB", "GwJob"));
                vmIntfcService.start(vmVo.getUuid(), restHeaders, null);

                VmStatusResultBodyVO vmStatusResultBodyVoAfter = vmIntfcService.status(vmVo.getUuid(), restHeaders);
                if (null == vmStatusResultBodyVoAfter.getState()) {
                    return getFailProcResult(ComConstant.FAILED_TO_GET_VM_STATUS_MSG);
                }
                if (!vmStatusResultBodyVoAfter.getState().equals(vmVo.getStatCd())) {
                    vmVo.setStatCd(vmStatusResultBodyVoAfter.getState());
                    vmService.updateVmStatSync(vmVo);
                }

                return getSuccessProcResult(ComConstant.SUCCESS_MSG, null, vmVo);
            }
            else {
                return getFailProcResult(ComConstant.VM_STATUS_NOT_SYNCHRONIZED_MSG);
            }
        } catch (HttpStatusCodeException e) {
        	logger.error(e.getResponseBodyAsString(), e);
        	return getFailProcResult(ComConstant.ERROR_MSG);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }
    }

    /**
     * 가상서버 중지
     *
     * @param vmSeq
     * @return
     */
    @RequestMapping(value = "/executeVmShutdown.do", method = RequestMethod.POST)
    @OperateLog(action = "가상서버 중지", desc = "가상서버 중지", params = { "vmSeq" })
    @ResponseBody
    public ProcResultVo executeVmShutdown(@RequestParam(required = true) BigDecimal vmSeq) {

        if (null == vmSeq) {
            return getFailProcResult(ComConstant.NOT_EXIST_TARGET_VM_MSG);
        }

        try {

            VmSearchVo vmSearchVo = new VmSearchVo();
            vmSearchVo.setEqualsVmSeq(vmSeq);
            VmVo vmVo = vmService.selectVmByVmSearchVo(vmSearchVo);

            RestHeaders restHeaders = new RestHeaders();
            restHeaders.setAreaId(vmVo.getRegionId());
            restHeaders.setZoneId(vmVo.getZoneId());
            restHeaders.setNetworkId(vmVo.getNetClCd());
            restHeaders.setManagerId(vmVo.getRsrcPoolId());
            VmStatusResultBodyVO vmStatusResultBodyVoBefore = vmIntfcService.status(vmVo.getUuid(), restHeaders);
            if (null == vmStatusResultBodyVoBefore.getState()) {
                return getFailProcResult(ComConstant.FAILED_TO_GET_VM_STATUS_MSG);
            }
            if (!vmStatusResultBodyVoBefore.getState().equals(vmVo.getStatCd())) {
                vmVo.setStatCd(vmStatusResultBodyVoBefore.getState());
                vmService.updateVmStatSync(vmVo);
            }
            if (ComConstant.VM_STAT_CD_UP.equals(vmStatusResultBodyVoBefore.getState())) {
                restHeaders.setSeq(commonService.selectSeqNum("GW_IF_JOB", "GwJob"));
                vmIntfcService.shutdown(vmVo.getUuid(), restHeaders);

                VmStatusResultBodyVO vmStatusResultBodyVoAfter = vmIntfcService.status(vmVo.getUuid(), restHeaders);
                if (null == vmStatusResultBodyVoAfter.getState()) {
                    return getFailProcResult(ComConstant.FAILED_TO_GET_VM_STATUS_MSG);
                }
                if (!vmStatusResultBodyVoAfter.getState().equals(vmVo.getStatCd())) {
                    vmVo.setStatCd(vmStatusResultBodyVoAfter.getState());
                    vmService.updateVmStatSync(vmVo);
                }

                return getSuccessProcResult(ComConstant.SUCCESS_MSG, null);
            }
            else {
                return getFailProcResult(ComConstant.VM_STATUS_NOT_SYNCHRONIZED_MSG);
            }
        } catch (HttpStatusCodeException e) {
        	logger.error(e.getResponseBodyAsString(), e);
        	return getFailProcResult(ComConstant.ERROR_MSG);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }
    }

    /**
     * 가상서버 재시작
     *
     * @param vmSeq
     * @return
     */
    @RequestMapping(value = "/executeVmRestart.do", method = RequestMethod.POST)
    @OperateLog(action = "가상서버 재시작", desc = "가상서버 재시작", params = { "vmSeq" })
    @ResponseBody
    public ProcResultVo executeVmRestart(@RequestParam(required = true) BigDecimal vmSeq) {

        if (null == vmSeq) {
            return getFailProcResult(ComConstant.NOT_EXIST_TARGET_VM_MSG);
        }

        try {

            VmSearchVo vmSearchVo = new VmSearchVo();
            vmSearchVo.setEqualsVmSeq(vmSeq);
            VmVo vmVo = vmService.selectVmByVmSearchVo(vmSearchVo);

            RestHeaders restHeaders = new RestHeaders();
            restHeaders.setAreaId(vmVo.getRegionId());
            restHeaders.setZoneId(vmVo.getZoneId());
            restHeaders.setNetworkId(vmVo.getNetClCd());
            restHeaders.setManagerId(vmVo.getRsrcPoolId());
            VmStatusResultBodyVO vmStatusResultBodyVoBefore = vmIntfcService.status(vmVo.getUuid(), restHeaders);
            if (null == vmStatusResultBodyVoBefore.getState()) {
                return getFailProcResult(ComConstant.FAILED_TO_GET_VM_STATUS_MSG);
            }
            if (!vmStatusResultBodyVoBefore.getState().equals(vmVo.getStatCd())) {
                vmVo.setStatCd(vmStatusResultBodyVoBefore.getState());
                vmService.updateVmStatSync(vmVo);
            }
            if (ComConstant.VM_STAT_CD_UP.equals(vmStatusResultBodyVoBefore.getState())) {
                restHeaders.setSeq(commonService.selectSeqNum("GW_IF_JOB", "GwJob"));
                vmIntfcService.restart(vmVo.getUuid(), restHeaders);

                VmStatusResultBodyVO vmStatusResultBodyVoAfter = vmIntfcService.status(vmVo.getUuid(), restHeaders);
                if (null == vmStatusResultBodyVoAfter.getState()) {
                    return getFailProcResult(ComConstant.FAILED_TO_GET_VM_STATUS_MSG);
                }
                if (!vmStatusResultBodyVoAfter.getState().equals(vmVo.getStatCd())) {
                    vmVo.setStatCd(vmStatusResultBodyVoAfter.getState());
                    vmService.updateVmStatSync(vmVo);
                }

                return getSuccessProcResult(ComConstant.SUCCESS_MSG, null);
            }
            else {
                return getFailProcResult(ComConstant.VM_STATUS_NOT_SYNCHRONIZED_MSG);
            }
        } catch (HttpStatusCodeException e) {
        	logger.error(e.getResponseBodyAsString(), e);
        	return getFailProcResult(ComConstant.ERROR_MSG);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }
    }

    /**
     * 가상서버 강제종료
     *
     * @param vmSeq
     * @return
     */
    @RequestMapping(value = "/executeVmStop.do", method = RequestMethod.POST)
    @OperateLog(action = "가상서버 강제종료", desc = "가상서버 강제종료", params = { "vmSeq" })
    @ResponseBody
    public ProcResultVo executeVmStop(@RequestParam(required = true) BigDecimal vmSeq) {

        if (null == vmSeq) {
            return getFailProcResult(ComConstant.NOT_EXIST_TARGET_VM_MSG);
        }

        try {

            VmSearchVo vmSearchVo = new VmSearchVo();
            vmSearchVo.setEqualsVmSeq(vmSeq);
            VmVo vmVo = vmService.selectVmByVmSearchVo(vmSearchVo);

            RestHeaders restHeaders = new RestHeaders();
            restHeaders.setAreaId(vmVo.getRegionId());
            restHeaders.setZoneId(vmVo.getZoneId());
            restHeaders.setNetworkId(vmVo.getNetClCd());
            restHeaders.setManagerId(vmVo.getRsrcPoolId());
            VmStatusResultBodyVO vmStatusResultBodyVoBefore = vmIntfcService.status(vmVo.getUuid(), restHeaders);
            if (null == vmStatusResultBodyVoBefore.getState()) {
                return getFailProcResult(ComConstant.FAILED_TO_GET_VM_STATUS_MSG);
            }
            if (!vmStatusResultBodyVoBefore.getState().equals(vmVo.getStatCd())) {
                vmVo.setStatCd(vmStatusResultBodyVoBefore.getState());
                vmService.updateVmStatSync(vmVo);
            }
            if (ComConstant.VM_STAT_CD_UP.equals(vmStatusResultBodyVoBefore.getState())) {
                restHeaders.setSeq(commonService.selectSeqNum("GW_IF_JOB", "GwJob"));
                vmIntfcService.stop(vmVo.getUuid(), restHeaders);

                VmStatusResultBodyVO vmStatusResultBodyVoAfter = vmIntfcService.status(vmVo.getUuid(), restHeaders);
                if (null == vmStatusResultBodyVoAfter.getState()) {
                    return getFailProcResult(ComConstant.FAILED_TO_GET_VM_STATUS_MSG);
                }
                if (!vmStatusResultBodyVoAfter.getState().equals(vmVo.getStatCd())) {
                    vmVo.setStatCd(vmStatusResultBodyVoAfter.getState());
                    vmService.updateVmStatSync(vmVo);
                }

                return getSuccessProcResult(ComConstant.SUCCESS_MSG, null);
            }
            else {
                return getFailProcResult(ComConstant.VM_STATUS_NOT_SYNCHRONIZED_MSG);
            }

        } catch (HttpStatusCodeException e) {
        	logger.error(e.getResponseBodyAsString(), e);
        	return getFailProcResult(ComConstant.ERROR_MSG);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return getFailProcResult(ComConstant.ERROR_MSG);
        }
    }

    /**
     * 가상서버 상세정보 조회(REST)
     *
     * @param vmSeq
     * @return
     */
    @RequestMapping(value = "/selectVmStatSync.do", method = RequestMethod.POST)
    @ResponseBody
    public ProcResultVo selectVmStatSync(@RequestParam(required = true) BigDecimal vmSeq) {

        if (null == vmSeq) {
            return getFailProcResult(ComConstant.NOT_EXIST_TARGET_VM_MSG);
        }

        try {

            VmSearchVo vmSearchVo = new VmSearchVo();
            vmSearchVo.setEqualsVmSeq(vmSeq);
            VmVo vmVo = vmService.selectVmDetailByVmSearchVo(vmSearchVo);
            return getSuccessProcResult(ComConstant.SUCCESS_MSG, null, vmVo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }
    }

    /**
     * 가상서버 상태정보 동기화
     * --- 실행이지만 키인이나 마우스 클릭이 아닌 자동 동기화하기 때문에 권한 없이 실행이 가능해야 함. 그래서 execute에서 select로 변경
     * @param vmSeq
     * @return
     */
    @RequestMapping(value = "/selectExecVmStatSync.do", method = RequestMethod.POST)
    @OperateLog(action = "가상서버 상태정보 동기화", desc = "가상서버 상태정보 동기화", params = { "vmSeq" })
    @ResponseBody
    public ProcResultVo executeVmStatSync(@RequestParam(required = true) BigDecimal vmSeq) {

        if (null == vmSeq) {
            return getFailProcResult(ComConstant.NOT_EXIST_TARGET_VM_MSG);
        }

        try {

            VmSearchVo vmSearchVo = new VmSearchVo();
            vmSearchVo.setEqualsVmSeq(vmSeq);
            VmVo vmVo = vmService.selectVmByVmSearchVo(vmSearchVo);

            RestHeaders restHeaders = new RestHeaders();
            restHeaders.setAreaId(vmVo.getRegionId());
            restHeaders.setZoneId(vmVo.getZoneId());
            restHeaders.setNetworkId(vmVo.getNetClCd());
            restHeaders.setManagerId(vmVo.getRsrcPoolId());
            VmStatusResultBodyVO vmStatusResultBodyVo = vmIntfcService.status(vmVo.getUuid(), restHeaders);
            if (vmStatusResultBodyVo == null) {
            	return getFailProcResult(ComConstant.FAILED_TO_GET_VM_STATUS_MSG);
            }
            if (null == vmStatusResultBodyVo.getState()) {
                return getFailProcResult(ComConstant.FAILED_TO_GET_VM_STATUS_MSG);
            }

            logger.debug(String.format("vm.status ====== vm: %s, status: %s, startup: %s" , vmVo.getVmSeq(), vmStatusResultBodyVo.getState(), vmStatusResultBodyVo.getStarted()));
            //상태를 rest API로 가져와 현재 상태와 다를경우 상태를 업데이트 한다.
            if (!vmStatusResultBodyVo.getState().equals(vmVo.getStatCd())
            	|| !StringUtils.defaultString(vmStatusResultBodyVo.getStarted()).equals(DateUtil.dateToString(vmVo.getStrtupDttm(), "yyyy-MM-dd HH:mm:ss"))) {
            	//gateway에 요청하여 가져온 상태를 현재 상태와 비교 후 다를 경우 gateway에서 가져온 데이터로 stateCd상태를 변경한다.
                vmVo.setStatCd(vmStatusResultBodyVo.getState());
                if (vmStatusResultBodyVo.getStarted()!=null) vmVo.setStrtupDttm(DateUtil.stringToDate(vmStatusResultBodyVo.getStarted(), "yyyy-MM-dd HH:mm:ss"));
                //상태를 rest API로 가져와 현재 상태와 다를경우 DB에 상태를 업데이트 한다.
                vmService.updateVmStatSync(vmVo);
            }
            return getSuccessProcResult(ComConstant.SUCCESS_MSG, null, vmVo);
        } catch (HttpStatusCodeException e) {
        	logger.error(e.getResponseBodyAsString(), e);
        	return getFailProcResult(ComConstant.ERROR_MSG);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return getFailProcResult(ComConstant.ERROR_MSG);
        }
    }

    /**
     * 가상서버 마이그레이션
     *
     * @param vmSeq
     * @return
     */
    @RequestMapping(value = "/executeVmMigr.do", method = RequestMethod.POST)
    @OperateLog(action = "가상서버 마이그레이션", desc = "가상서버 마이그레이션", params = { "vmSeq" })
    @ResponseBody
    public ProcResultVo executeVmMigr(VmMigrVo vmMigrVo, BindingResult bindingResult) {

        ProcResultVo procResultVo = getBindingResult(vmMigrVo, bindingResult);

        if (!procResultVo.isSuccess()) {
            return procResultVo;
        }

        try {
        	vmMigrVo.setUserId(getUserId());
            vmService.executeProcess(getUserId(), OprConstant.PROCESS_REF_JOB_KEY_VM_MIG, vmMigrVo, vmMigrVo.getVmSeq(), vmMigrVo.getVmSeq().toString());
            return getSuccessProcResult(ComConstant.SUCCESS_MSG, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }

    }

    /**
     * 가상서버 마이그레이션 화면
     *
     * @param request
     * @param model
     * @param vmSeq
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/executeVmMigr.do")
    public String executeVmMigrView(HttpServletRequest request, Model model, @RequestParam(required = true) BigDecimal vmSeq) throws JsonParseException, JsonMappingException, IOException {

        if (null == vmSeq) {
            model.addAttribute("message", ComConstant.NOT_EXIST_TARGET_VM_MSG);
            return jstlView("/error/common");
        }

        VmSearchVo vmSearchVo = new VmSearchVo();
        vmSearchVo.setEqualsVmSeq(vmSeq);
        VmVo vmVo = vmService.selectVmByVmSearchVo(vmSearchVo);

        if (null == vmVo) {
            model.addAttribute("message", ComConstant.NOT_EXIST_TARGET_VM_MSG);
            return jstlView("/error/common");
        }

        if (null == vmVo.getCtlTrgtYn() || "N".equals(vmVo.getCtlTrgtYn())) {
            model.addAttribute("message", ComConstant.NOT_CONTROL_TARGET_RSRC_POOL);
            return jstlView("/error/common");
        }

        model.addAttribute("vmVo", vmVo);
        model.addAttribute("vmMigrVo", new VmMigrVo());

        List<VmProcssMsgVo> vmProcssMsgVoList = vmService.selectVmProcssMsgList(vmVo.getVmSeq());
        if (null != vmProcssMsgVoList && vmProcssMsgVoList.size() > 0) {
            for (VmProcssMsgVo vmProcssMsgVo : vmProcssMsgVoList) {
                if ("05".equals(vmProcssMsgVo.getProcssClCd())) {
                    PmVo sourcePmVo = pmService.selectPm(vmVo.getPmSeq());
                    model.addAttribute("pmVo", sourcePmVo);

                    model.addAttribute("vmProcssMsgVo", vmProcssMsgVo);
                    ObjectMapper objectMapper = new ObjectMapper();
                    VmMigrVo vmMigrVo = objectMapper.readValue(vmService.selectVmProcssVarList(vmProcssMsgVo.getProcssInstSeq()), new TypeReference<VmMigrVo>() {
                    });

                    PmVo targetPmVo = pmService.selectPm(vmMigrVo.getPmSeq());
                    model.addAttribute("targetPmVo", targetPmVo);

                    return portalTilesView(request);
                }
            }
        }

        PmSearchVo pmSearchVo = new PmSearchVo();
        pmSearchVo.setSearchClstrSeq(vmVo.getClstrSeq());
        pmSearchVo.setOrderBy("migr");
        List<PmVo> pmVoList = pmService.selectPmList(pmSearchVo, false);
        if (null != pmVoList && !pmVoList.isEmpty()) {
            for (int i = 0; i < pmVoList.size(); i++) {
                if (null != vmVo.getPmSeq() && pmVoList.get(i).getPmSeq().equals(vmVo.getPmSeq())) {
                    model.addAttribute("pmVo", pmVoList.get(i));
                    pmVoList.remove(i);
                    break;
                }
            }
            model.addAttribute("pmVoList", pmVoList);
        }

        return portalTilesView(request);

    }

    /**
     * 가상서버 원격콘솔 티켓요청
     *
     * @param request
     * @param model
     * @param vmSeq
     * @return
     */
    @RequestMapping(value = "/executeVmRc.do", method = RequestMethod.POST)
    @OperateLog(action = "가상서버 원격콘솔 티켓요청", desc = "가상서버 원격콘솔 티켓요청", params = { "vmSeq" })
    @ResponseBody
    public ProcResultVo executeVmRc(@RequestParam(required = true) BigDecimal vmSeq) {

        if (null == vmSeq) {
            return getFailProcResult(ComConstant.NOT_EXIST_TARGET_VM_MSG);
        }

        try {
            VmSearchVo vmSearchVo = new VmSearchVo();
            vmSearchVo.setEqualsVmSeq(vmSeq);
            VmVo vmVo = vmService.selectVmByVmSearchVo(vmSearchVo);

            RsrcPoolVo rsrcPoolVo = rsrcPoolService.selectRsrcPool(vmVo.getRsrcPoolId());
            String host = rsrcPoolVo.getMngConnAddr();
            String port = rsrcPoolVo.getMngProxyPort();
            if (null == host || null == port || host.isEmpty() || port.isEmpty()) {
                return getFailProcResult(ComConstant.NOT_EXIST_TARGET_HOST_CONNECTION_INFO);
            }
            if (!ComConstant.VRLZ_SW_TY_CD_EV.equals(rsrcPoolVo.getVrlzSwTyCd())) {
                return getFailProcResult(ComConstant.NOT_SUPPORT_VM_GRAPHIC_CONSOLE);
            }

            RestHeaders restHeaders = new RestHeaders();
            restHeaders.setAreaId(vmVo.getRegionId());
            restHeaders.setZoneId(vmVo.getZoneId());
            restHeaders.setNetworkId(vmVo.getNetClCd());
            restHeaders.setManagerId(vmVo.getRsrcPoolId());
            VmStatusResultBodyVO vmStatusResultBodyVO = vmIntfcService.status(vmVo.getUuid(), restHeaders);
            if (null == vmStatusResultBodyVO.getState()) {
                return getFailProcResult(ComConstant.FAILED_TO_GET_VM_STATUS_MSG);
            }
            if (!vmStatusResultBodyVO.getState().equals(vmVo.getStatCd())) {
                vmVo.setStatCd(vmStatusResultBodyVO.getState());
                vmService.updateVmStatSync(vmVo);
            }
//            if (ComConstant.VM_STAT_CD_UP.equals(vmStatusResultBodyVO.getState())) {
            if (!ComConstant.VM_STAT_CD_DOWN.equals(vmStatusResultBodyVO.getState())) {
                GraphicConsoleResultBodyVO graphicConsoleResultBodyVO = vmIntfcService.selectGraphicsConsoles(vmVo.getUuid(), restHeaders);
                if (null == graphicConsoleResultBodyVO) {
                    return getFailProcResult(ComConstant.FAILED_TO_GET_VM_GRAPHIC_CONSOLE_MSG);
                }
                for (GraphicConsoleVO graphicConsoleVO : graphicConsoleResultBodyVO.getGraphics_consoles()) {
                    if (ComConstant.VM_GRAPHIC_PROTOCOL_SPICE.equals(graphicConsoleVO.getProtocol())) {
                        // 프로토콜
                        String protocol = graphicConsoleVO.getProtocol();
                        // 접속티켓 요청
                        restHeaders.setSeq(commonService.selectSeqNum("GW_IF_JOB", "GwJob"));
                        String password = vmIntfcService.selectTicket4VmConsole(vmVo.getUuid(), restHeaders);
                        // 프록시티켓 요청
                        restHeaders.setSeq(commonService.selectSeqNum("GW_IF_JOB", "GwJob"));
                        String path = vmIntfcService.selectProxyTicket(vmVo.getUuid(), graphicConsoleVO.getId(), restHeaders);
                        if (null == password || null == path) {
                            return getFailProcResult(ComConstant.ERROR_MSG);
                        }
                        HashMap<String, Object> map = new HashMap<String, Object>();
                        map.put("host", host);
                        map.put("port", port);
                        map.put("password", password);
                        map.put("path", path);
                        map.put("protocol", protocol);
                        return getSuccessProcResult(ComConstant.SUCCESS_MSG, null, map);
                    }
                }
                return getFailProcResult(ComConstant.NOT_EXIST_CONNECTABLE_VM_GRAPHIC_CONSOLE_MSG);

            }
            else {
                return getFailProcResult(ComConstant.VM_STATUS_NOT_SYNCHRONIZED_MSG);
            }

        } catch (Exception e) {
        	logger.error(e.getMessage(),e);
            return getFailProcResult(ComConstant.ERROR_MSG);
        }

    }

    @RequestMapping(value = "/executeVmRcPki.do")
    public void executeVmRcPki(HttpServletRequest request, HttpServletResponse response, Model model, BigDecimal vmSeq) {

        if (null == vmSeq) {
            return;
        }

        VmVo vmVo = vmService.selectVm(vmSeq);

        RsrcPoolVo rsrcPoolVo = rsrcPoolService.selectRsrcPool(vmVo.getRsrcPoolId());
        String host = rsrcPoolVo.getMngConnAddr();
        if (null == host || host.isEmpty()) {
            return;
        }
        if (!ComConstant.VRLZ_SW_TY_CD_EV.equals(rsrcPoolVo.getVrlzSwTyCd())) {
            return;
        }
        HttpEntity<String> entity = new HttpEntity<String>("");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<byte[]> responseEntity = restTemplate.exchange(String.format("https://%s/ovirt-engine/services/pki-resource?resource=ca-certificate&format=X509-PEM-CA", host), HttpMethod.GET, entity, byte[].class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            response.setContentType("application/x-x509-ca-cert;charset=ISO-8859-1;");
            response.setHeader("Content-Disposition", "attachment;filename=\"pki-resource.cer\"");
            response.setContentLength(responseEntity.getBody().length);
            try {
                response.getOutputStream().write(responseEntity.getBody());
            } catch (IOException e) {
            	logger.error(e.getMessage(),e);
                return;
            }
        }
    }

    static {
        disableSslVerification();
    }

    private static void disableSslVerification() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(X509Certificate[] certs, String autyType) {
                        }

                        public void checkServerTrusted(X509Certificate[] certs, String autyType) {
                        }
                    }
            };

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            HostnameVerifier allHostsValid = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (Exception e) {
        	logger.error(e.getMessage(),e);
        }

    }

    /**
     * 가상서버 원격콘솔 팝업 화면 (spice)
     *
     * @param request
     * @param model
     * @param vmSeq
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/selectVmRcSpiceP.do")
    public String selectVmRcSpicePView(HttpServletRequest request, Model model, @RequestParam(required = true) BigDecimal vmSeq, @RequestParam(required = true) String vmCompId, @RequestParam(required = false) String vmId) throws Exception {
    	//|VM_SEQ|가상서버구성ID|가상서버ID|원격사용자접속IP|사용자ID|입력키 정보
        if (null == vmSeq) {
            model.addAttribute("message", ComConstant.NOT_EXIST_TARGET_VM_MSG);
            return popup("/error/common");
        }

        logger.info("vmid::"+vmId);
        logger.info("vmcompid::"+vmCompId);

        model.addAttribute("title", "가상서버 원격제어");
        model.addAttribute("vmSeq", vmSeq);
        model.addAttribute("vmCompId", vmCompId);
        model.addAttribute("vmId", vmId);

        return popup(request);
    }

    /**
     * 가상서버 원격콘솔 팝업 화면 (vnc)(사용안함)
     *
     * @param request
     * @param model
     * @param vmSeq
     * @return
     * @throws Exception
     */
    /*
     * @RequestMapping(value = "/selectVmRcVncP.do")
     * public String selectVmRcVncPView(HttpServletRequest request, Model model, @RequestParam(required = true) BigDecimal vmSeq) throws Exception {
     * model.addAttribute("title", "가상서버 원격제어");
     * model.addAttribute("vmSeq", vmSeq);
     * return popup(request);
     * }
     */

    /**
     * 가상서버 원격콘솔 키입력 로그
     *
     * @param vmRcKey
     * @return
     */
    @RequestMapping(value = "/executeVmRcKeyLog.do", method = RequestMethod.POST)
    @ResponseBody
    public ProcResultVo executeVmRcKeyLog(HttpServletRequest request, VmRcKey vmRcKey) {

        String ip = request.getHeader("X-Forwarded-For");
        if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_Client-IP");
        }
        if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if (null != vmRcKey && null != vmRcKey.getCmdCd() && null != vmRcKey.getVmSeq()) {

            UserVo userVo = getUser();
            String path = request.getRequestURI().substring(request.getContextPath().length(), request.getRequestURI().lastIndexOf("/") + 1);

            UserWrkHistVo log = new UserWrkHistVo();
            log.setUserId(userVo.getUserId());
            log.setUserNm(userVo.getUserNm());
            log.setWrkIP(ip);
            log.setWrkParam(String.format("vmSeq:%s", vmRcKey.getVmSeq().toString()));
            log.setWrkTy(ActionType.ACTION.name());
            log.setMenuPattern(path);

            if (ComConstant.VM_RC_CMD_CD_CONNECT_CD.equals(vmRcKey.getCmdCd().toString())) {

                log.setWrkInfo("가상서버 원격콘솔 연결");
                log.setWrkDc("가상서버 원격콘솔 연결 호출");
                commonService.insertUserWrkHist(log);

                return getSuccessProcResult(ComConstant.SUCCESS_MSG, null);
            }
            else if (ComConstant.VM_RC_CMD_CD_DISCONNECT_CD.equals(vmRcKey.getCmdCd().toString())) {

                log.setWrkInfo("가상서버 원격콘솔 연결 종료");
                log.setWrkDc("가상서버 원격콘솔 연결 종료 호출");
                commonService.insertUserWrkHist(log);

                return getSuccessProcResult(ComConstant.SUCCESS_MSG, null);
            }

        }

        if (null == vmRcKey || null == vmRcKey.getKeys() || vmRcKey.getKeys().isEmpty()) {
            return getSuccessProcResult(ComConstant.SUCCESS_MSG, null);
        }
        try {
            Logger vmRcLogger = VmRcLogger.getLogger(vmRcKey.getVmSeq());
            // 2016.12.22   |VM_SEQ |구성ID|가상서버ID |IP |USER_ID |KEY
            //vmRcLogger.info(String.format("[VM_SEQ:%s] [IP:%s] [USER:%s] [KEYS:%s]", vmRcKey.getVmSeq().toString(), ip, getUserId(), vmRcKey.getKeys()));

            /*◦로그기록일시(yyyy-mm-dd hh24:mi:ss)|VM_SEQ|가상서버구성ID|가상서버ID|원격사용자접속IP|사용자ID|입력키 정보
                             의 형태로 아래와 같이 변경 필요.2016-12-21 14:41:13 |43    |VM00000000|135_I_W20_D_021 |10.180.231.199  |pt001      |ll(Enter)*/

            vmRcLogger.info(String.format("|%s|%s|%s|%s|%s|%s", vmRcKey.getVmSeq().toString(), vmRcKey.getVmCompId() , vmRcKey.getVmId(), ip, getUserId(), vmRcKey.getKeys()));
            return getSuccessProcResult(ComConstant.SUCCESS_MSG, null);
        } catch (IOException e) {
        	logger.error(e.getMessage(),e);
            return getSuccessProcResult(ComConstant.ERROR_MSG);
        }

    }

    /**
     * 가상서버 스냅샷 목록 엑셀 다운로드
     *
     * @param request
     * @param response
     * @param vmSeq
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws IOException
     */
    @RequestMapping(value = "/selectVmSnapListXlsDwnl.do")
    public void selectVmSnapListXlsDwnl(HttpServletRequest request, HttpServletResponse response, @RequestParam("vmSeq") BigDecimal vmSeq) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<VmSnapVo> vmSnapVoList = vmService.selectVmSnapList(vmSeq);

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("snapshtCreDt", "생성일시");
        header.put("snapshtNm", "스냅샷명");
        header.put("dskNo", "디스크번호");
        header.put("rmk", "비고");

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("가상서버 스냅샷");
        sheet.setDatas(vmSnapVoList);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("가상서버 스냅샷_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

    /**
     * 가상서버 스냅샷 생성 화면
     *
     * @param request
     * @param model
     * @param vmSeq
     * @return
     */
    @RequestMapping(value = "/insertVmSnap.do")
    public String insertVmSnapView(HttpServletRequest request, Model model, @RequestParam(required = true) BigDecimal vmSeq) {

        VmVo vmVo = vmService.selectVm(vmSeq);

        model.addAttribute("vmVo", vmVo);
        model.addAttribute("vmSnapVo", new VmSnapVo());
        model.addAttribute("ivu", new InputValidationUtils());
        model.addAttribute("title", "스냅샷 생성");

        return popup(request);

    }

    /**
     * 가상서버 스냅샷 생성
     *
     * @param vmSnapVo
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/insertVmSnap.do", method = RequestMethod.POST)
    @OperateLog(action = "가상서버 스냅샷 생성", desc = "가상서버 스냅샷을 생성한다.", params = { "vmSnapVo", "bindingResult" })
    @ResponseBody
    public ProcResultVo insertVmSnap(VmSnapVo vmSnapVo, BindingResult bindingResult) {

        try {
        	// 스냅샷 생성 가능한지 가상스토리지 용량 체크
        	List<VrStrgVo> vrStrgVoList = vrStrgService.selectVrStrgAsgnInfoOfVm(vmSnapVo.getVmSeq());
        	for (VrStrgVo vrStrgVo : vrStrgVoList) {
        		// 스토리지 여유량
				int mrgnCapa = vrStrgVo.getWholeAsgnCapa().intValue() - vrStrgVo.getVmAsgnCapa().intValue() - vrStrgVo.getTmplatAsgnCapa().intValue() - vrStrgVo.getVmSnapshtAsgnCapa().intValue();
				// 스토리지에 할당 된 총 디스크량
				int asgnCapa = vrStrgVo.getStrgAsgmCapa_vm_sum().intValue();

				if(mrgnCapa < asgnCapa)
					return getFailProcResult(ComConstant.FAILED_SNAP_OVER_VR_STRG_CAPA_MSG);
			}

        	VmSearchVo vmSearchVo = new VmSearchVo();
        	vmSearchVo.setEqualsVmSeq(vmSnapVo.getVmSeq());
            VmVo vmVo = vmService.selectVmDetailByVmSearchVo(vmSearchVo);

            // 가상화SW에 따른 스냅샷 생성 여부 체크
            if( ("01".equals(vmVo.getVrlzSwTyCd()) || "02".equals(vmVo.getVrlzSwTyCd())) && !"02".equals(vmVo.getStatGrpCd()) ) {
            	return getFailProcResult(ComConstant.FAILED_VM_STAT_ON_PROCESS_MSG);
        	}
        	else if("04".equals(vmVo.getVrlzSwTyCd()) && !"01".equals(vmVo.getStatGrpCd())) {
        		return getFailProcResult(ComConstant.FAILED_VM_STAT_OFF_PROCESS_MSG);
        	}
        	else if("03".equals(vmVo.getVrlzSwTyCd())) {
        		// 2017-07-17 가상화SW유형 '05' 제거 [openstack]
        		return getFailProcResult(ComConstant.FAILED_VM_NOT_PROCESS_INFO_MSG);
        	}

        	// 처리진행중인 스냅샷 정보가 있는지 체크
            VmProcssVo vmProcssVo = new VmProcssVo();
            vmProcssVo.setVarVl(vmSnapVo.getVmSeq().toString());
            vmProcssVo.setProcssSeq(OprConstant.VM_REQ_COM_PROCESS_ID);
            vmProcssVo.setRefJobIdList(new String[] { OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_CRE, OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_RESTOR, OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_DEL });
            vmProcssVo = vmService.selectVmProcss(vmProcssVo);

            if (null != vmProcssVo)
                return getFailProcResult(ComConstant.FAILED_SNAP_PROCESS_INFO_MSG);

            // 스냅샷 최대수량 체크
            List<VmSnapVo> vmSnapVoList = vmService.selectVmSnapList(vmSnapVo.getVmSeq());
            if (null != vmSnapVoList && vmSnapVoList.size() >= 5)
                return getFailProcResult(ComConstant.FAILED_SNAP_OVER_COUNT_MSG);

            VmSnapReqVo vmSnapReq = vmService.selectVmSnapReq(vmSnapVo);
            vmSnapReq.setSnapshtNm(vmSnapVo.getSnapshtNm());
            vmSnapReq.setRmk(vmSnapVo.getRmk());
            vmSnapReq.setUserId(getUserId());
            vmService.executeProcess(getUserId(), OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_CRE, vmSnapReq, vmSnapReq.getVmSeq(), "");

            return getSuccessProcResult(ComConstant.SUCCESS_MSG, ComConstant.INSERT, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }

    }

    /**
     * 가상서버 스냅샷 복원
     *
     * @param vmSnapVo
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/procVmSnapRestor.do", method = RequestMethod.POST)
    @OperateLog(action = "가상서버 스냅샷 복원", desc = "가상서버 스냅샷을 복원한다.", params = { "vmSnapVo", "vmVo", "bindingResult" }) //17.07.24 vmVO 추가 [openstack]
    @ResponseBody
    public ProcResultVo procVmSnapRestor(VmSnapVo vmSnapVo,VmVo vmVo ,BindingResult bindingResult) {	//17.07.24 vmVO 추가 [openstack]

        try {
            VmProcssVo vmProcssVo = new VmProcssVo();
            vmProcssVo.setVarVl(vmSnapVo.getVmSeq().toString());
            vmProcssVo.setProcssSeq(OprConstant.VM_REQ_COM_PROCESS_ID);
            vmProcssVo.setRefJobIdList(new String[] { OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_CRE, OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_RESTOR, OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_DEL });
            vmProcssVo = vmService.selectVmProcss(vmProcssVo);

            if (null != vmProcssVo)
                return getFailProcResult(ComConstant.FAILED_SNAP_PROCESS_INFO_MSG);

            VmSnapReqVo vmSnapReq = vmService.selectVmSnapReq(vmSnapVo);
            vmSnapReq.setUserId(getUserId()); // 누락추가

            if (null != vmSnapReq.getStatGrpCd() && !"01".equals(vmSnapReq.getStatGrpCd()))
                return getFailProcResult(ComConstant.FAILED_VM_STAT_OFF_PROCESS_MSG);

            vmService.executeProcess(getUserId(), OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_RESTOR, vmSnapReq, vmSnapReq.getVmSeq(), "스냅샷번호");

            return getSuccessProcResult(ComConstant.SUCCESS_MSG, ComConstant.INSERT, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }

    }

    /**
     * 가상서버 스냅샷 삭제
     *
     * @param vmSnapVo
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/deleteVmSnap.do", method = RequestMethod.POST)
    @OperateLog(action = "가상서버 스냅샷 삭제", desc = "가상서버 스냅샷을 삭제한다.", params = { "vmSnapVo", "bindingResult" })
    @ResponseBody
    public ProcResultVo deleteVmSnap(VmSnapVo vmSnapVo, BindingResult bindingResult) {

        try {
            VmProcssVo vmProcssVo = new VmProcssVo();
            vmProcssVo.setVarVl(vmSnapVo.getVmSeq().toString());
            vmProcssVo.setProcssSeq(OprConstant.VM_REQ_COM_PROCESS_ID);
            vmProcssVo.setRefJobIdList(new String[] { OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_CRE, OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_RESTOR, OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_DEL });
            vmProcssVo = vmService.selectVmProcss(vmProcssVo);

            if (null != vmProcssVo)
                return getFailProcResult(ComConstant.FAILED_SNAP_PROCESS_INFO_MSG);

            VmSnapReqVo vmSnapReq = vmService.selectVmSnapReq(vmSnapVo);
            vmSnapReq.setUserId(getUserId()); // 누락추가

            if (null != vmSnapReq.getStatGrpCd() && !"01".equals(vmSnapReq.getStatGrpCd()))
                return getFailProcResult(ComConstant.FAILED_VM_STAT_OFF_PROCESS_MSG);

            vmService.executeProcess(getUserId(), OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_DEL, vmSnapReq, vmSnapReq.getVmSeq(), "스냅샷번호");

            return getSuccessProcResult(ComConstant.SUCCESS_MSG, ComConstant.INSERT, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }

    }

    /**
     * 가상서버 자원 이력 엑셀 다운로드
     *
     * @param request
     * @param response
     * @param model
     * @param vmResHistSearchVo
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws IOException
     */
    @RequestMapping(value = "/selectVmResHistListXlsDwnl.do")
    public void selectVmResHistListXlsDwnl(HttpServletRequest request, HttpServletResponse response, Model model, VmResHistSearchVo vmResHistSearchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<CodeVo> vmReqCdList = commonService.selectCodeList(ComConstant.VM_REQ_GRP_CD, ComConstant.VM_REQ_PARENT_CD, true); // 가상서버요청유형 코드
        List<String> resList = new ArrayList<String>();

        for (CodeVo codeVo : vmReqCdList) {

            if (null != codeVo.getVarVl1() && ComConstant.VM_REQ_RES_CD.equals(codeVo.getVarVl1())) {
                resList.add(codeVo.getCd());
            }
        }

        vmResHistSearchVo.setVmReqTyCdList(resList.toArray(new String[resList.size()]));

        List<VmResHistVo> vmResHistVoList = vmService.selectVmResHistList(vmResHistSearchVo, false);

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("cdNm", "이력구분");
        header.put("wrkDt", "이력일시");
        header.put("wrkNm", "담당자");
        header.put("beforeInfo", "변경전 상세내용");
        header.put("afterInfo", "변경후 상세내용");

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("가상서버 자원 이력");
        sheet.setDatas(vmResHistVoList);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("가상서버 자원 이력_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

    /**
     * 가상서버 마이그레이션 이력 엑셀 다운로드
     *
     * @param request
     * @param response
     * @param model
     * @param vmMigrHistSearchVo
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws IOException
     */
    @RequestMapping(value = "/selectVmMigrHistListXlsDwnl.do")
    public void selectVmMigrHistListXlsDwnl(HttpServletRequest request, HttpServletResponse response, Model model, VmMigrHistSearchVo vmMigrHistSearchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<CodeVo> vmReqCdList = commonService.selectCodeList(ComConstant.VM_REQ_GRP_CD, ComConstant.VM_REQ_PARENT_CD, true); // 가상서버요청유형 코드
        List<String> migrList = new ArrayList<String>();

        for (CodeVo codeVo : vmReqCdList) {

            if (null != codeVo.getVarVl1() && ComConstant.VM_REQ_MIGR_CD.equals(codeVo.getVarVl1())) {
                migrList.add(codeVo.getCd());
            }
        }

        vmMigrHistSearchVo.setVmReqTyCdList(migrList.toArray(new String[migrList.size()]));

        List<VmMigrHistVo> vmMigrHistVoList = vmService.selectVmMigrHistList(vmMigrHistSearchVo, false);

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("cdNm", "이력구분");
        header.put("wrkDt", "이력일시");
        header.put("wrkNm", "담당자");
        header.put("beforeInfo", "변경전 상세내용");
        header.put("afterInfo", "변경후 상세내용");

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("가상서버 마이그레이션 이력");
        sheet.setDatas(vmMigrHistVoList);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("가상서버 마이그레이션 이력_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

    /**
     * 가상서버 스냅샷 엑셀 다운로드
     *
     * @param request
     * @param response
     * @param model
     * @param vmSnapHistSearchVo
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws IOException
     */
    @RequestMapping(value = "/selectVmSnapHistListXlsDwnl.do")
    public void selectVmSnapHistListXlsDwnl(HttpServletRequest request, HttpServletResponse response, Model model, VmSnapHistSearchVo vmSnapHistSearchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<CodeVo> vmReqCdList = commonService.selectCodeList(ComConstant.VM_REQ_GRP_CD, ComConstant.VM_REQ_PARENT_CD, true); // 가상서버요청유형 코드
        List<String> snapList = new ArrayList<String>();

        for (CodeVo codeVo : vmReqCdList) {

            if (null != codeVo.getVarVl1() && ComConstant.VM_REQ_SNAP_CD.equals(codeVo.getVarVl1())) {
                snapList.add(codeVo.getCd());
            }
        }

        vmSnapHistSearchVo.setVmReqTyCdList(snapList.toArray(new String[snapList.size()]));

        List<VmSnapHistVo> vmSnapHistVoList = vmService.selectVmSnapHistList(vmSnapHistSearchVo, false);

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("cdNm", "이력구분");
        header.put("wrkDt", "이력일시");
        header.put("wrkNm", "담당자");
        header.put("detailInfo", "상세내용");

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("가상서버 스냅샷 이력");
        sheet.setDatas(vmSnapHistVoList);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("가상서버 스냅샷 이력_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

    /**
     * 가상서버 구성변경 이력 엑셀 다운로드
     *
     * @param request
     * @param response
     * @param model
     * @param vmCompHistSearchVo
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws IOException
     */
    @RequestMapping(value = "/selectVmCompHistListXlsDwnl.do")
    public void selectVmCompHistListXlsDwnl(HttpServletRequest request, HttpServletResponse response, Model model, VmCompHistSearchVo vmCompHistSearchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<CodeVo> vmReqCdList = commonService.selectCodeList(ComConstant.VM_REQ_GRP_CD, ComConstant.VM_REQ_PARENT_CD, true); // 가상서버요청유형 코드
        List<String> compList = new ArrayList<String>();

        for (CodeVo codeVo : vmReqCdList) {

            if (null != codeVo.getVarVl1() && ComConstant.VM_REQ_COMP_CD.equals(codeVo.getVarVl1())) {
                compList.add(codeVo.getCd());
            }
        }

        vmCompHistSearchVo.setVmReqTyCdList(compList.toArray(new String[compList.size()]));

        List<VmCompHistVo> vmCompHistVoList = vmService.selectVmCompHistList(vmCompHistSearchVo, false);

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("cdNm", "이력구분");
        header.put("wrkDt", "이력일시");
        header.put("wrkNm", "담당자");
        header.put("beforeInfo", "변경전 상세내용");
        header.put("afterInfo", "변경후 상세내용");

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("가상서버 구성변경 이력");
        sheet.setDatas(vmCompHistVoList);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("가상서버 구성변경 이력_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

}
