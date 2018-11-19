/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PmController.java
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
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.security.vo.UserVo;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.ObjectUtils;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.com.service.ClstrService;
import ncis.cpt.rsrc.com.service.PmService;
import ncis.cpt.rsrc.com.service.RsrcReqService;
import ncis.cpt.rsrc.com.service.VmService;
import ncis.cpt.rsrc.com.util.InputValidationUtils;
import ncis.cpt.rsrc.com.validation.InsertPmCreReqValidation;
import ncis.cpt.rsrc.com.validation.InsertPmDelReqValidation;
import ncis.cpt.rsrc.com.vo.ClstrSearchVo;
import ncis.cpt.rsrc.com.vo.ClstrVo;
import ncis.cpt.rsrc.com.vo.PmSearchVo;
import ncis.cpt.rsrc.com.vo.PmVo;
import ncis.cpt.rsrc.com.vo.RsrcReqVo;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.cpt.rsrc.pool.service.RsrcPoolService;
import ncis.cpt.rsrc.zone.service.NetService;
import ncis.cpt.rsrc.zone.service.RegionService;
import ncis.cpt.rsrc.zone.service.ZoneService;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.user.service.UserService;

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
@RequestMapping(value = "/cpt/rsrc/com/pm")
public class PmController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(PmController.class);

	private  final String RC_PM_ADD = "물리서버 추가요청";
	private  final String RC_PM_DEL = "물리서버 삭제요청";

    @Resource(name = "pmService")
    PmService pmService;

    @Resource(name = "regionService")
    RegionService regionService;

    @Resource(name = "zoneService")
    ZoneService zoneService;

    @Resource(name = "netService")
    NetService netService;

    @Resource(name = "rsrcPoolService")
    RsrcPoolService rsrcPoolService;

    @Resource(name = "commonService")
    CommonService commonService;

    @Resource(name = "rsrcReqService")
    RsrcReqService rsrcReqService;

    @Resource(name = "userService")
    UserService userService;

    @Resource(name = "vmService")
    VmService vmService;

    @Resource(name = "clstrService")
    ClstrService clstrService;

    /**
     * 물리서버 목록 조회 화면
     *
     * @param request
     * @param model
     * @param pmSearchVo
     * @return
     */
    @RequestMapping(value = "/selectPmList.do")
    public String selectPmListView(HttpServletRequest request, Model model, PmSearchVo pmSearchVo) {

    	List<CodeVo> vrlzSwTyCdList = commonService.selectCodeList(ComConstant.VRLZ_SW_TY_GRP_CD, ComConstant.VRLZ_SW_TY_PARENT_CD); // 가상화SW 코드
    	List<CodeVo> statCdList = commonService.selectCodeList(ComConstant.PM_GRP_STAT_GRP_CD, ComConstant.PM_GRP_STAT_PARENT_CD, true); // 물리서버상태 코드

    	// 페이지 처음 진입시 가상화SW 구분값 세팅
    	if(pmSearchVo.getSearchVrlzSwTyCdList() == null || pmSearchVo.getSearchVrlzSwTyCdList().length == 0) {

    		List<String> list = new ArrayList<String>();
    		for (CodeVo codeVo : vrlzSwTyCdList) {
				list.add(codeVo.getCd());
			}
    		pmSearchVo.setSearchVrlzSwTyCdList( list.toArray(new String[list.size()]) );
    	}

    	// 물리서버 목록 조회
    	pmSearchVo.setSearchDelYn("N"); // 삭제 여부
    	pmSearchVo.setOrderBy("pmList");
        List<PmVo> pmVoList = pmService.selectPmList(pmSearchVo, true);


        model.addAttribute("vrlzSwTyCdList", vrlzSwTyCdList);
        model.addAttribute("statCdList", statCdList);

        model.addAttribute("pmVoList", pmVoList);
        model.addAttribute("pmSearchVo", pmSearchVo);

        return portalTilesView(request);

    }

    /**
     * 물리서버 목록 엑셀 다운로드
     *
     * @param request
     * @param model
     * @param pmSearchVo
     * @return
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    @RequestMapping(value = "/selectPmListXlsDwnl.do")
    public void selectPmListXlsDwnl(HttpServletRequest request, HttpServletResponse response, Model model, PmSearchVo pmSearchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        pmSearchVo.setSearchDelYn("N"); // 삭제 여부
        pmSearchVo.setOrderBy("pmList");
        List<PmVo> pmVoList = pmService.selectPmList(pmSearchVo, false);

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("statCdNm", "상태");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망");
        header.put("rsrcPoolNm", "자원풀");
        header.put("clstrNm", "클러스터");
        header.put("pmNm", "물리서버명");
        header.put("pmCompId", "물리서버구성ID");
        header.put("rprsntIpAddr", "IP주소");
        header.put("vrlzSwTyCdNm", "가상화SW");
        header.put("vmCnt", "가상서버수");
        header.put("cpuUseRtExcel", "CPU 사용률 (%)");
        header.put("cpuVrlzRtExcel", "CPU 가상화율 (%)");
        header.put("totCpuEnt", "CPU Ent");
        header.put("totCpuVcoreQty", "CPU vCore");
        header.put("cpuCoreQty", "CPU Core");
        header.put("memUseRtExcel", "메모리 사용률 (%)");
        header.put("memVrlzRtExcel", "메모리 가상화율 (%)");
        header.put("totMemAsgnCapaExcel", "메모리 할당량 (GB)");
        header.put("memCapaExcel", "메모리 전체량 (GB)");
        header.put("totStrgAsgnCapaExcel", "스토리지 (GB)");
        header.put("netwkInExcel", "네트워크 In (KB/Sec)");
        header.put("netwkOutExcel", "네트워크 Out (KB/Sec)");

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("물리서버");
        sheet.setDatas(pmVoList);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("물리서버_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

    /**
     * 물리서버 상세 정보 조회 화면
     *
     * @param request
     * @param model
     * @param pmSeq
     * @return
     */
    @RequestMapping(value = "/selectPm.do")
    public String selectPmView(HttpServletRequest request, Model model, @RequestParam(required = true) BigDecimal pmSeq) {

    	// 물리서버 상세정보 조회
        PmVo pmVo = pmService.selectPm(pmSeq);

        // 물리서버 하위 가상서버 정보 조회
        VmSearchVo vmSearchVo = new VmSearchVo();
        vmSearchVo.setEqualsPmSeq(pmSeq);
        List<VmVo> vmList = vmService.selectVmList(vmSearchVo);

        model.addAttribute("pmVo", pmVo);
        model.addAttribute("vmList", vmList);
        model.addAttribute("ivu", new InputValidationUtils());

        return portalTilesView(request);

    }

    /**
     * 물리서버 생성 요청 화면
     *
     * @param request
     * @param model
     * @param clstrSearchVo
     * @return
     */
    @RequestMapping(value = "/insertPmCreReq.do")
    public String insertPmCreReqView(HttpServletRequest request, Model model) {

    	 model.addAttribute("title" , RC_PM_ADD);
        model.addAttribute(new RsrcReqVo());
        model.addAttribute("ivu", new InputValidationUtils());

        return portalTilesView(request);

    }

    /**
     * 물리서버 추가 요청
     *
     * @param rsrcReqVo
     * @return
     */
    @RequestMapping(value = "/insertPmAddReq.do", method = RequestMethod.POST)
    @OperateLog(action = "물리서버 추가 요청", desc = "새 물리서버를 추가 요청한다.", params = {"rsrcReqVo", "bindingResult"})
    @ResponseBody
    public ProcResultVo insertPmCreReq(RsrcReqVo rsrcReqVo, BindingResult bindingResult) {

    	// 물리서버를 추가 할 클러스터 정보 조회 후 요청정보 세팅
    	ClstrVo selectClstr = clstrService.selectClstr(rsrcReqVo.getRsrcReqPmVoList().get(0).getClstrSeq());

    	rsrcReqVo.setRegionId(selectClstr.getRegionId());
    	rsrcReqVo.getRsrcReqPmVoList().get(0).setZoneId(selectClstr.getZoneId());
    	rsrcReqVo.getRsrcReqPmVoList().get(0).setNetId(selectClstr.getNetId());
    	rsrcReqVo.getRsrcReqPmVoList().get(0).setNetClCd(selectClstr.getNetClCd());
    	rsrcReqVo.getRsrcReqPmVoList().get(0).setRsrcPoolId(selectClstr.getRsrcPoolId());
    	rsrcReqVo.getRsrcReqPmVoList().get(0).setClstrCompId(selectClstr.getClstrCompId());

    	ProcResultVo procResultVo = getBindingResult(rsrcReqVo, bindingResult, InsertPmCreReqValidation.class);

        if (!procResultVo.isSuccess()) {
            return procResultVo;
        }

        try {
        	// 물리서버 추가요청 정보에 입력한 IP정보로 물리서버정보조회
        	String pmIpAddr = rsrcReqVo.getRsrcReqPmVoList().get(0).getIpAddr();
        	BigDecimal pmSeq = pmService.selectPmSeqByIpAddr(pmIpAddr);

        	// IP주소에 해당하는 물리서버 정보가 있는지 체크
        	if (null == pmIpAddr || ObjectUtils.isEmpty(pmSeq)) {
                return getFailProcResult(ComConstant.NOT_EXIST_PM_BY_IP_ADDR_MSG);
            }

        	rsrcReqVo.getRsrcReqPmVoList().get(0).setPmSeq(pmSeq);

        	UserVo userVo = getUser();
            if(userVo == null){
                return getFailProcResult(ComConstant.FAILED_TO_LOAD_REQUEST_USER_MSG);
            }

            rsrcReqVo.setRsrcReqUserId(userVo.getUserId());
            rsrcReqVo.setReqInstitutionId(userVo.getInstitutionId());
            rsrcReqVo.setRegUserId(userVo.getUserId());
            rsrcReqVo.setRsrcReqTyCd(ComConstant.RSRC_REQ_TY_CD_PM_CRE_CD); // 자원요청유형코드 - 물리서버 추가
            rsrcReqVo.setRsrcReqPrcssStatCd(ComConstant.RSRC_REQ_PRCSS_STAT_CD_REQ_CD); // 자원요청처리상태코드 - 요청

            // 물리서버 추가 요청
            rsrcReqService.insertRsrcReqPmCreReq(rsrcReqVo);

            return getSuccessProcResult(ComConstant.SUCCESS_MSG, ComConstant.INSERT, null);

        } catch (Exception e) {
        	logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }

    }

    /**
     * 물리서버 삭제 요청 화면
     *
     * @param request
     * @param model
     * @param pmSeq
     * @return
     */
    @RequestMapping(value = "/insertPmDelReq.do")
    public String insertPmDelReqView(HttpServletRequest request, Model model, @RequestParam(required = true) BigDecimal pmSeq) {

        PmVo pmVo = pmService.selectPm(pmSeq);

        model.addAttribute("title" , RC_PM_DEL);
        model.addAttribute("pmVo", pmVo);
        model.addAttribute(new RsrcReqVo());
        model.addAttribute("ivu", new InputValidationUtils());

        return portalTilesView(request);

    }

    /**
     * 물리서버 삭제 요청
     *
     * @param rsrcReqVo
     * @return
     */
    @RequestMapping(value = "/insertPmDelReq.do", method = RequestMethod.POST)
    @OperateLog(action = "물리서버 삭제 요청", desc = "물리서버를 삭제 요청한다.", params = {"rsrcReqVo", "bindingResult"})
    @ResponseBody
    public ProcResultVo insertPmDelReq(RsrcReqVo rsrcReqVo, BindingResult bindingResult) {

    	ProcResultVo procResultVo = getBindingResult(rsrcReqVo, bindingResult, InsertPmDelReqValidation.class);

        if (!procResultVo.isSuccess()) {
            return procResultVo;
        }

    	try {
    		if(null != rsrcReqVo.getRsrcReqPmVoList() && 0 < rsrcReqVo.getRsrcReqPmVoList().size()) {

    			PmVo selectPm = pmService.selectPm(rsrcReqVo.getRsrcReqPmVoList().get(0).getPmSeq());

    			// 삭제 할 물리서버에 하위 가상서버 정보가 있는지 체크
    			if(null != selectPm && 0 < selectPm.getVmCnt().intValue())
    				return getFailProcResult(ComConstant.PM_HAS_VM_MSG);
    		}

            UserVo userVo = getUser();
            if(userVo == null){
                return getFailProcResult(ComConstant.FAILED_TO_LOAD_REQUEST_USER_MSG);
            }

            rsrcReqVo.setRsrcReqUserId(userVo.getUserId());
            rsrcReqVo.setReqInstitutionId(userVo.getInstitutionId());
            rsrcReqVo.setRegUserId(userVo.getUserId());
            rsrcReqVo.setRsrcReqTyCd(ComConstant.RSRC_REQ_TY_CD_PM_DEL_CD); // 자원요청유형코드 - 물리서버 삭제
            rsrcReqVo.setRsrcReqPrcssStatCd(ComConstant.RSRC_REQ_PRCSS_STAT_CD_REQ_CD); // 자원요청처리상태코드 - 요청

            // 물리서버 삭제 요청
            rsrcReqService.insertRsrcReqPmDelReq(rsrcReqVo);

            return getSuccessProcResult(ComConstant.SUCCESS_MSG, ComConstant.INSERT, null);
        } catch (Exception e) {
        	logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }
    }

    /**
     * 물리서버 정보 수정
     *
     * @param pmVo
     * @return
     */
    @RequestMapping(value = "/updatePm.do", method = RequestMethod.POST)
    @OperateLog(action = "물리서버 정보 수정", desc = "물리서버 구성ID 수정", params = {"pmVo", "bindingResult"})
    @ResponseBody
    public ProcResultVo updatePm(PmVo pmVo, BindingResult bindingResult) {

        try {
        	UserVo userVo = getUser();
            if (userVo == null) {
                return getFailProcResult(ComConstant.FAILED_TO_LOAD_REQUEST_USER_MSG);
            }

            pmVo.setUpdtUserId(getUserId());

            PmVo pmVoForCompare = pmService.selectPm(pmVo.getPmSeq());

            // 수정 할 물리서버 정보 존재여부 체크
            if(pmVoForCompare == null){
                return getFailProcResult(ComConstant.NOT_EXIST_TARGET_PM_MSG);
            }

            // 입력한 물리서버구성ID를 사용중인지 체크
            if (null != pmVo.getPmCompId() && !pmVo.getPmCompId().equals(pmVoForCompare.getPmCompId()) && pmService.isExistsPmCompId(pmVo.getPmCompId())) {
                return getFailProcResult(ComConstant.PM_COMP_ID_ALREADY_EXISTS_MSG);
            }

            // 물리구성ID 및 비고 정보가 공백으로 왔을 시 DB에 업데이트하기 위해 null 처리
            if(null != pmVo.getPmCompId() && "".equals(pmVo.getPmCompId().trim()))
            	pmVo.setPmCompId(null);
        	if(null != pmVo.getRmk() && "".equals(pmVo.getRmk().trim()))
        		pmVo.setRmk(null);

            // 물리서버 정보 수정
        	pmService.updatePm(pmVo);

            return getSuccessProcResult(ComConstant.SUCCESS_MSG, ComConstant.UPDATE, null);
        } catch (Exception e) {
        	logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }

    }

    /**
     * 클러스터 목록 조회
     *
     * @param request
     * @param model
     * @param clstrSearchVo
     * @return
     */
    @RequestMapping(value = "/selectClstrListP.do")
    public String selectClstrList(HttpServletRequest request, Model model, ClstrSearchVo clstrSearchVo) {

    	clstrSearchVo.setEqualsUseYn("Y");
        List<ClstrVo> clstrVoList = clstrService.selectClstrList(clstrSearchVo);

        model.addAttribute("clstrVoList", clstrVoList);
        model.addAttribute("clstrSearchVo", clstrSearchVo);

        return jstlView(request);

    }

}
