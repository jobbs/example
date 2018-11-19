/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CodeController.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 29.
 * @lastmodified 2016. 9. 29.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 29.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.code.web;

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
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.vo.Tree;
import ncis.cmn.vo.TreeNode;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.code.service.CodeService;
import ncis.cpt.sys.code.vo.CodeSearchVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 최진호
 *
 */
@Controller
@RequestMapping(value="/cpt/sys/code")
public class CodeController extends BaseController {

    @Resource(name="codeService")
    private CodeService codeService;

    /**
     * 코드관리 Index
     * @param request
     * @return
     */
    @RequestMapping(value="/selectCodeList.do")
    public String selectCodeList(HttpServletRequest request) {
        return portalTilesView(request);
    }

    /**
     * 코드관리 검색 목록
     * @param request
     * @return
     */
    @RequestMapping(value="/selectCodeSearchList.do")
    public String selectCodeSearchList(HttpServletRequest request, Model model,
            CodeSearchVo searchVo) {

        //searchVo.getPaginationInfo().setRecordCountPerPage(20);

        List<CodeVo> codes =  codeService.selectCodeSearchList(searchVo);

        model.addAttribute("list", codes);
        model.addAttribute("searchVo", searchVo);
        return jstlView(request);
    }

    /**
     * 코드 목록을 Tree 형태로 호출
     * @param parentSeq
     * @return
     */
    @RequestMapping(value="/selectCodeListTree.do")
    @ResponseBody
    public List<TreeNode<String,CodeVo>> selectCodeListTree(
            @RequestParam(required=false)String parentCd, @RequestParam(required=false)String parentGrpCd ) {

        Tree<String,CodeVo> tree = codeService.selectCodeListTree(parentCd, parentGrpCd, false);
        return tree.getRoot().getChildren();

    }

    /**
     * 코드 상세 조회
     * @param request
     * @param model
     * @param menuSeq
     * @return
     */
    @RequestMapping(value="/selectCode.do")
    public String selectCode(HttpServletRequest request, Model model,
            @RequestParam(required=true)String cd, @RequestParam(required=true)String grpCd, CodeSearchVo searchVo) {

        CodeVo code = codeService.selectCode(cd, grpCd);
        model.addAttribute("vo", code);
        model.addAttribute("searchVo", searchVo);
        return jstlView(request);
    }

    /**
     * 메뉴 등록 화면 호출
     * @param request
     * @param model
     * @param parentSeq
     * @return
     */
    @RequestMapping(value="/insertCode.do", method=RequestMethod.GET)
    public String insertCodeView(HttpServletRequest request, Model model,
            @RequestParam(required=true) String parentCd, @RequestParam(required=true) String parentGrpCd) {

        CodeVo code = new CodeVo();
        code.setParentCd(parentCd);
        code.setParentGrpCd(parentGrpCd);
        code.setGrpCd(parentGrpCd);
        code.setUseYn("Y");

        code.setParent(codeService.selectCode(parentCd, parentGrpCd));

        model.addAttribute("code", code);
        model.addAttribute("searchVo", new CodeSearchVo());
        return jstlView(request,"formCode");
    }

    /**
     * 메뉴 등록 프로세스 처리
     * @param request
     * @param model
     * @param menu
     * @return
     */
    @RequestMapping(value="/insertCode.do", method=RequestMethod.POST)
    @OperateLog(action="코드등록", desc="코드등록 처리 호출", params={"cdNm", "cd", "grpCd"})
    @ResponseBody
    public ProcResultVo insertCode(HttpServletRequest request, Model model,
            @ModelAttribute("vo") CodeVo code, BindingResult bindingResult) {

        ProcResultVo result = getBindingResult(code, bindingResult, InsertProc.class);
        if( result.isSuccess() ) {

            if( "000".equals( code.getGrpCd() ) ) {
                code.setCdLevel(1);
            } else {

                if( codeService.selectExistsCd(code.getCd(), code.getGrpCd())) {
                    return getFailProcResult("해당 그룹에 동일한 코드가 존재합니다.\n\n다른 코드를 입력하여 주시기 바랍니다.");
                }

                CodeVo parent = codeService.selectCode(code.getParentCd(), code.getParentGrpCd());
                code.setCdLevel(parent.getCdLevel()+1);
            }

            code.setRegUserId(getUserId());
            code.setUpdtUserId(getUserId());
            codeService.insertCode(code);

            result.setProcType("insert");
        }

        return result;
    }

    /**
     * 코드 수정 화면 호출
     * @param request
     * @param model
     * @param menuSeq
     * @return
     */
    @RequestMapping(value="/updateCode.do", method=RequestMethod.GET)
    public String updateCodeView(HttpServletRequest request, Model model,
            @RequestParam(required=true)String cd, @RequestParam(required=true)String grpCd, CodeSearchVo searchVo) {

        CodeVo code = codeService.selectCode(cd, grpCd);
        model.addAttribute("code", code);
        model.addAttribute("searchVo", searchVo);
        return jstlView(request,"formCode");
    }

    /**
     * 코드 수정 프로세스 처리
     * @param request
     * @param model
     * @param menu
     * @return
     */
    @RequestMapping(value="/updateCode.do", method=RequestMethod.POST)
    @OperateLog(action="코드수정", desc="코드수정 처리 호출", params={"cdNm", "cd", "grpCd"}, actionType=ActionType.UPDATE)
    @ResponseBody
    public ProcResultVo updateCode(HttpServletRequest request, Model model,
            @ModelAttribute("code") CodeVo code, BindingResult bindingResult) {

        ProcResultVo result = getBindingResult(code, bindingResult, UpdateProc.class);
        if( result.isSuccess() ) {

            code.setUpdtUserId(getUserId());
            codeService.updateCode(code);

            result.setProcType("update");
        }

        return result;
    }

    /** <pre>
     * 메뉴순서를 위로 이동시킨다.
     * </pre>
     *
     * @param request
     * @param menuSeq
     * @param parentSeq
     * @return
     */
    @RequestMapping(value="/updateCodeOrderUp.do", method=RequestMethod.POST)
    @OperateLog(action="코드 순서변경", desc="코드를 한단계 위로 이동 처리", params={"cd", "grpCd"})
    @ResponseBody
    public ProcResultVo updateCodeOrderUp(HttpServletRequest request,
            @RequestParam(required=true) String cd, @RequestParam(required=true) String parentCd,
            @RequestParam(required=true) String grpCd, @RequestParam(required=true) String parentGrpCd){

        ProcResultVo procResultVO = new ProcResultVo();
        codeService.updatCodeOrderUp(cd, grpCd, parentCd, parentGrpCd);
        procResultVO.setSuccess(true);
        procResultVO.setData("before");
        return procResultVO;
    }

    /** <pre>
     * 메뉴순서를 아래로 이동시킨다.
     * </pre>
     *
     * @param request
     * @param menuSeq
     * @param parentSeq
     * @return
     */
    @RequestMapping(value="/updateCodeOrderDown.do", method=RequestMethod.POST)
    @OperateLog(action="코드 순서변경", desc="코드를 한단계 아래로 이동 처리", params={"cd", "grpCd"})
    @ResponseBody
    public ProcResultVo updateCodeOrderDown(HttpServletRequest request,
            @RequestParam(required=true) String cd, @RequestParam(required=true) String parentCd,
            @RequestParam(required=true) String grpCd, @RequestParam(required=true) String parentGrpCd){

        ProcResultVo procResultVO = new ProcResultVo();
        codeService.updateCodeOrderDown(cd, grpCd, parentCd, parentGrpCd);
        procResultVO.setSuccess(true);
        procResultVO.setData("after");
        return procResultVO;
    }

    /**
     * 코드 검색목록 엑셀 다운로드
     * @param response
     * @param model
     * @param searchVo
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws IOException
     */
    @RequestMapping(value="/selectCodeListXlsDwnl.do")
    public void selectCodeListXlsDwnl(HttpServletResponse response, Model model, CodeSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("cd","코드");
        header.put("grpCd","그룹코드");
        header.put("parentCd","부모코드");
        header.put("parentGrpCd","부모그룹코드");
        header.put("cdNm","코드명");
        header.put("useYn","사용여부");

        List<CodeVo> list = codeService.selectCodeListXlsDwnl(searchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("코드검색 목록");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response,String.format("코드검색목록_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

}
