/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MngmObjVmController.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.web;

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

import ncis.cmn.service.CommonService;
import ncis.cmn.util.ObjectUtils;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.ip.config.IpBndConstants;
import ncis.cpt.opr.patch.service.MngmObjVmService;
import ncis.cpt.opr.patch.vo.MngmObjVmSearchVo;
import ncis.cpt.opr.patch.vo.MngmObjVmVo;
import ncis.cpt.rsrc.com.service.VmService;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.intfc.seoa.service.SeoaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 최경철
 *
 */
@Controller
@RequestMapping(value = "/cpt/opr/patch/mngmObjVm")
public class MngmObjVmController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(MngmObjVmController.class);

	@Resource(name = "mngmObjVmService")
	MngmObjVmService mngmObjVmService;

	@Resource(name = "vmService")
    VmService vmService;

	@Resource(name = "seoaService")
	SeoaService seoaService;

	@Resource(name = "commonService")
    CommonService commonService;

    /**
     * 관리대상 가상서버 목록 조회 화면
     *
     * @param request
     * @param model
     * @param mngmObjVmSearchVo
     * @return
     */
    @RequestMapping(value = "/selectMngmObjVmList.do")
    public String selectMngmObjVmListView(HttpServletRequest request, Model model, MngmObjVmSearchVo mngmObjVmSearchVo) {

        List<MngmObjVmVo> mngmObjVmVoList = mngmObjVmService.selectMngmObjVmList(mngmObjVmSearchVo, true);
        List<CodeVo> netList = commonService.selectCodeList(IpBndConstants.IP_BND_NET_GRP_CD, IpBndConstants.IP_BND_NET_PARENT_CD, true); // 망구분코드

        model.addAttribute("mngmObjVmVoList", mngmObjVmVoList);
        model.addAttribute("mngmObjVmSearchVo", mngmObjVmSearchVo);
        model.addAttribute("netList", netList);

        return portalTilesView(request);

    }

    /**
     * 관리대상 가상서버 목록 엑셀 다운로드
     *
     * @param request
     * @param model
     * @param mngmObjVmSearchVo
     * @return
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    @RequestMapping(value = "/selectMngmObjVmListXlsDwnl.do")
    public void selectMngmObjVmListXlsDwnl(HttpServletRequest request, HttpServletResponse response, Model model, MngmObjVmSearchVo mngmObjVmSearchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<MngmObjVmVo> mngmObjVmVoList = mngmObjVmService.selectMngmObjVmList(mngmObjVmSearchVo, false);

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("regionNm", "센터");
        header.put("netNm", "망");
        header.put("insttNm", "부처");
        header.put("mngmVmCnt", "관리대상 가상서버수");
        header.put("vmCnt", "전체 가상서버수");

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("관리대상 가상서버");
        sheet.setDatas(mngmObjVmVoList);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("관리대상 가상서버_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

    /**
     * 관리대상 가상서버 상세 정보 조회 화면
     *
     * @param request
     * @param model
     * @param mngmObjVmSearchVo
     * @return
     */
    @RequestMapping(value = "/selectMngmObjVm.do")
    public String selectMngmObjVmView(HttpServletRequest request, Model model, MngmObjVmSearchVo mngmObjVmSearchVo) {

    	// 관리대상 가상서버 상세 정보 조회
        MngmObjVmVo mngmObjVmVo = mngmObjVmService.selectMngmObjVm(mngmObjVmSearchVo);

        // 가상서버 정보 조회
        VmSearchVo vmSearchVo = new VmSearchVo();
        vmSearchVo.setEqualsVmClCd("01");	// 가상서버구분코드
        vmSearchVo.setEqualsOsTyCd("01");	// OS타입
//        vmSearchVo.setExistsVrlzSwTyCdList(new String[]{"01", "02"});
        vmSearchVo.setEqualsInstitutionId(mngmObjVmSearchVo.getInsttId());	// 기관ID
        vmSearchVo.setEqualsRegionId(mngmObjVmSearchVo.getRegionId());		// 리전ID
        vmSearchVo.setEqualsNetClCd(mngmObjVmSearchVo.getNetClCd());		// 망구분코드
        vmSearchVo.setSearchPackgMngTrgtYn(mngmObjVmSearchVo.getSearchPackgMngTrgtYn());	// 패키지대상여부
        List<VmVo> vmList = vmService.selectVmList(vmSearchVo);

        model.addAttribute("vmList", vmList);
        model.addAttribute("mngmObjVmVo", mngmObjVmVo);
        model.addAttribute("mngmObjVmSearchVo", mngmObjVmSearchVo);

        return portalTilesView(request);

    }

    /**
     * 관리대상 가상서버 정보 수정
     *
     * @param mngmObjVmSearchVo
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/updateMngmObjVm.do", method = RequestMethod.POST)
    @OperateLog(action = "가상서버 정보 수정", desc = "패키지 대상 여부 변경", params = { "mngmObjVmSearchVo", "bindingResult" })
    @ResponseBody
    public ProcResultVo updateMngmObjVm(MngmObjVmSearchVo mngmObjVmSearchVo, BindingResult bindingResult) {

        try {
        	List<BigDecimal> updtCheck = mngmObjVmSearchVo.getUpdtCheck();

        	if(ObjectUtils.isEmpty(updtCheck)) {
        		return getFailProcResult("선택된 가상서버 정보가 없습니다.");
        	}

        	mngmObjVmService.updateMngmObjVm(mngmObjVmSearchVo);

            return getSuccessProcResult("정상 처리되었습니다.", "update", null);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return getFailProcResult("오류가 발생하였습니다.");
        }
    }

    /**
     * 관리대상 가상서버 동기화
     *
     * @param mngmObjVmSearchVo
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/updateMngmObjVmSync.do", method = RequestMethod.POST)
    @OperateLog(action = "가상서버 정보 동기화", desc = "정보 동기화", params = { "mngmObjVmSearchVo", "bindingResult" })
    @ResponseBody
    public ProcResultVo updateMngmObjVmSync(MngmObjVmSearchVo mngmObjVmSearchVo, BindingResult bindingResult) {

        try {

        	List<BigDecimal> updtCheck = mngmObjVmSearchVo.getUpdtCheck();

        	if(ObjectUtils.isEmpty(updtCheck)) {
        		return getFailProcResult("선택된 가상서버 정보가 없습니다.");
        	}

        	mngmObjVmService.updateMngmObjVmSync(mngmObjVmSearchVo);

            return getSuccessProcResult("정상 처리되었습니다.", "update", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult("오류가 발생하였습니다.");
        }
    }

}
