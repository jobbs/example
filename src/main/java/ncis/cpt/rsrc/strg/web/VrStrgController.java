/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename vrStrgController.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.catalg.vo.TmplatSvo;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.pool.service.RsrcPoolService;
import ncis.cpt.rsrc.strg.config.VrConstants;
import ncis.cpt.rsrc.strg.service.LunService;
import ncis.cpt.rsrc.strg.service.VrDskService;
import ncis.cpt.rsrc.strg.service.VrStrgService;
import ncis.cpt.rsrc.strg.vo.LunSearchVo;
import ncis.cpt.rsrc.strg.vo.LunVo;
import ncis.cpt.rsrc.strg.vo.RsrcPoolVrStrgVo;
import ncis.cpt.rsrc.strg.vo.VrStrgSearchVo;
import ncis.cpt.rsrc.strg.vo.VrStrgVo;
import ncis.cpt.sys.code.vo.CodeVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 신재훈
 *
 */

@Controller
@RequestMapping(value = "/cpt/rsrc/strg/vrStrg")
public class VrStrgController extends BaseController {
    @Resource(name = "vrStrgService")
    VrStrgService vrStrgService;

    @Resource(name = "vrDskService")
    VrDskService vrDskService;

    @Resource(name = "commonService")
    CommonService commonService;

    @Resource(name = "rsrcPoolService")
    RsrcPoolService rsrcPoolService;

    @Resource(name = "lunService")
    LunService lunService;

    /**
     * 자원풀 목록 조회 (+ 가상스토리지 정보)
     *
     * @param request
     * @param model
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/selectVrStrgRsrcPoolList.do")
    public String selectVrStrgRsrcPoolListView(HttpServletRequest request, Model model, VrStrgSearchVo searchVo) {
        List<RsrcPoolVrStrgVo> rsrcPoolVrStrgList = rsrcPoolService.selectVrStrgRsrcPoolList(searchVo);

        List<CodeVo> vrlzSwTyCdList = commonService.selectCodeList(ComConstant.VRLZ_SW_TY_GRP_CD, ComConstant.VRLZ_SW_TY_PARENT_CD); // 가상화SW 코드

        model.addAttribute("rsrcPoolVrStrgList", rsrcPoolVrStrgList);
        model.addAttribute("vrlzSwTyCdList", vrlzSwTyCdList);
        model.addAttribute("searchVo", searchVo);

        return portalTilesView(request);
    }

    /**
     * 자원풀 목록 엑셀다운로드
     *
     * @param request
     * @param response
     * @param searchVo
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws IOException
     */
    @RequestMapping(value = "/selectVrStrgRsrcPoolListXlsDwnl.do")
    public void selectVrStrgRsrcPoolListXlsDwnl(HttpServletRequest request, HttpServletResponse response, VrStrgSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
        // CusomSheet 생성
        List<CustomSheet> sheets = rsrcPoolService.makeVrStrgRsrcPoolListExcelSheets(searchVo);

        // Excel 생성
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String curDate = format.format(Calendar.getInstance().getTime());
        ExcelUtil.downloadExcel(response, "가상스토리지_" + curDate, sheets);
    }

    /**
     * 스토리지 도메인 상세정보
     *
     * @param request
     * @param model
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/selectVrStrg.do")
    public String selectVrStrgView(HttpServletRequest request, Model model, VrStrgSearchVo searchVo, VmSearchVo vmSearchVo, TmplatSvo tmplatSearchVo, BigDecimal searchStrgDmnSeq) {
        searchVo.setSearchStrgDmnSeq(searchStrgDmnSeq);
        VrStrgVo vrStrgVo = vrStrgService.selectVrStrg(searchVo);

        if (searchStrgDmnSeq != null) {
            vmSearchVo.setSearchStrgDmnSeq(searchStrgDmnSeq);
            tmplatSearchVo.setSearchStrgDmnSeq(searchStrgDmnSeq);
        }

        List<VrStrgVo> vrStrgVmList = null;
        List<VrStrgVo> vrStrgTmplatList = null;

        if (null == searchVo.getSearchType()) {
            vrStrgVmList = vrStrgService.selectVrStrgVm(vmSearchVo);
            searchVo.setSearchType(VrConstants.VR_DSK_TAB_TYPE_VM);
        }
        else if (VrConstants.VR_DSK_TAB_TYPE_VM.equals(searchVo.getSearchType())) {
            vrStrgVmList = vrStrgService.selectVrStrgVm(vmSearchVo);
        }
        else if (VrConstants.VR_DSK_TAB_TYPE_TMPLAT.equals(searchVo.getSearchType())) {
            vrStrgTmplatList = vrStrgService.selectVrStrgTmplat(tmplatSearchVo);
        }

        List<CodeVo> useYnCode = commonService.selectCodeList("015", "114", true); // 사용여부
        List<CodeVo> osBitCode = commonService.selectCodeList("004", "103", true); // OS Bit
        List<CodeVo> tmplatClCdCode = commonService.selectCodeList("016", "115", true); // 템플릿용도
        List<CodeVo> vrlzSwTyCdList = commonService.selectCodeList("001", "100"); // 가상화SW
        List<CodeVo> osTyCdCode = commonService.selectCodeList("003", "102", true); // OS Type

        model.addAttribute("vrStrgVo", vrStrgVo);
        model.addAttribute("searchVo", searchVo);
        model.addAttribute("vmSearchVo", vmSearchVo);
        model.addAttribute("tmplatSearchVo", tmplatSearchVo);

        model.addAttribute("useYnCode", useYnCode);
        model.addAttribute("osBitCode", osBitCode);
        model.addAttribute("tmplatClCdCode", tmplatClCdCode);
        model.addAttribute("vrlzSwTyCdList", vrlzSwTyCdList);
        model.addAttribute("osTyCdCode", osTyCdCode);

        model.addAttribute("vrStrgVmList", vrStrgVmList);
        model.addAttribute("vrStrgTmplatList", vrStrgTmplatList);

        return portalTilesView(request);
    }

    /**
     * LUN 정보 조회 화면 호출
     *
     * @param request
     * @param model
     * @param vmSearchVo
     * @param ipBndVo
     * @return
     */
    @RequestMapping(value = "/selectLunListP.do")
    public String selectLunListView(HttpServletRequest request, Model model, LunSearchVo lunSearchVo, BigDecimal selectStrgDmnSeq) {
        if (selectStrgDmnSeq != null) {
            lunSearchVo.setSelectStrgDmnSeq(selectStrgDmnSeq);
        }
        List<LunVo> lunList = lunService.selectLunList(lunSearchVo);

        model.addAttribute("lunList", lunList);
        model.addAttribute("selectStrgDmnSeq", selectStrgDmnSeq);
        model.addAttribute("lunSearchVo", lunSearchVo);
        model.addAttribute("title", "LUN 정보 조회");

        return popup(request);
    }

    /**
     * 가상스토리지 상세 - 가상서버
     *
     * @param request
     * @param model
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/selectVrStrgVm.do")
    public String selectVrStrgVm(HttpServletRequest request, Model model, VmSearchVo vmSearchVo, BigDecimal selectStrgDmnSeq) {
        if (selectStrgDmnSeq != null) {
            vmSearchVo.setSearchStrgDmnSeq(selectStrgDmnSeq);
            vmSearchVo.setSearchType(VrConstants.VR_DSK_TAB_TYPE_VM);
        }

        List<VrStrgVo> vrStrgVmList = vrStrgService.selectVrStrgVm(vmSearchVo);
        List<CodeVo> vrlzSwTyCdList = commonService.selectCodeList("001", "100");

        model.addAttribute("vrlzSwTyCdList", vrlzSwTyCdList);
        model.addAttribute("vrStrgVmList", vrStrgVmList);
        model.addAttribute("vmSearchVo", vmSearchVo);

        return portalTilesView(request);
    }

    /**
     * 가상스토리지 상세 - 템플릿
     *
     * @param request
     * @param model
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/selectVrStrgTmplat.do")
    public String selectVrStrgTmplat(HttpServletRequest request, Model model, TmplatSvo tmplatSearchVo, BigDecimal selectStrgDmnSeq) {
        if (selectStrgDmnSeq != null) {
            tmplatSearchVo.setSearchStrgDmnSeq(selectStrgDmnSeq);
            tmplatSearchVo.setSearchType(VrConstants.VR_DSK_TAB_TYPE_TMPLAT);
        }

        List<VrStrgVo> vrStrgTmplatList = vrStrgService.selectVrStrgTmplat(tmplatSearchVo);

        List<CodeVo> useYnCode = commonService.selectCodeList("015", "114", true);
        List<CodeVo> osBitCode = commonService.selectCodeList("004", "103", true);
        List<CodeVo> tmplatClCdCode = commonService.selectCodeList("016", "115", true);
        List<CodeVo> osTyCdCode = commonService.selectCodeList("003", "102", true);
        List<CodeVo> vrlzSwTyCdList = commonService.selectCodeList("001", "100");

        model.addAttribute("useYnCode", useYnCode);
        model.addAttribute("osBitCode", osBitCode);
        model.addAttribute("tmplatClCdCode", tmplatClCdCode);
        model.addAttribute("osTyCdCode", osTyCdCode);
        model.addAttribute("vrlzSwTyCdList", vrlzSwTyCdList);
        model.addAttribute("vrStrgTmplatList", vrStrgTmplatList);
        model.addAttribute("tmplatSearchVo", tmplatSearchVo);

        return portalTilesView(request);
    }

    // /**
    // * 선택한 가상스토리지의 가상디스크 목록 조회
    // *
    // * @param request
    // * @param model
    // * @param vrStrgSeq
    // * @return
    // */
    // @RequestMapping(value = "/selectVrDskList.do")
    // public String selectVrDskListView(HttpServletRequest request, Model model, @RequestParam(required = true) BigDecimal strgDmnSeq) {
    // // TODO [신재훈] 가상디스크 상태코드가 "할당","미할당"이라면, 해당 속성에 대한 조건이 필요함.
    //
    // VrDskSearchVo vrDskSearchVo = new VrDskSearchVo();
    // vrDskSearchVo.setSearchVrStrgSeq(strgDmnSeq);
    // List<VrDskVo> vrDskList = vrDskService.selectVrDskList(vrDskSearchVo);
    //
    // model.addAttribute("vrDskList", vrDskList);
    // model.addAttribute("vrDskSearchVo", vrDskSearchVo);
    //
    // return jstlView(request);
    // }
    //
    //
    // /**
    // * 가상 디스크 상세정보
    // *
    // * @param request
    // * @param model
    // * @param userId
    // * @return
    // */
    // @RequestMapping(value = "/selectVrDsk.do")
    // public String selectVrDskView(HttpServletRequest request, Model model, VrDskSearchVo searchVo) {
    // VrDskVo vrDskVo = vrDskService.selectVrDsk(searchVo.getSearchVrDskSeq());
    // if (null == searchVo.getSearchType()) {
    // searchVo.setSearchType(VrConstants.VR_DSK_TAB_TYPE_VM);
    // }
    //
    // model.addAttribute("vrDskVo", vrDskVo);
    // return portalTilesView(request);
    // }
}
