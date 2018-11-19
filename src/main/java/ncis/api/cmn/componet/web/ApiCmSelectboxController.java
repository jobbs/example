/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CmZoneController.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     박희택         v1.0             최초생성
 *
 */
package ncis.api.cmn.componet.web;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.service.CommonService;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.code.vo.CodeVo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 박희택
 *
 */
@Controller
@RequestMapping(value="/api/cmn/component")
public class ApiCmSelectboxController extends BaseController  {

	@Resource(name="commonService")
	CommonService commonService;

    /**
     * 코드 목록
     * @param statckClCd
     * @return
     */
    @RequestMapping(value="/selectboxList.do")
    @ResponseBody
    public ProcResultVo selectMngrClList(@RequestParam(required=true) String parentGrpCd, String parentCd) {
        ProcResultVo result = new ProcResultVo();
        List<CodeVo> list = null;
        list = commonService.selectCodeList(parentGrpCd, parentCd, false);

        result.setData(list);
        return result;
    }

    /**
     * 매니저 분류 목록
     * @param statckClCd
     * @return
     */
    @RequestMapping(value="/selectboxMngrList.do")
    @ResponseBody
    public ProcResultVo selectboxMngrList(@RequestParam(required=true) String parentGrpCd, String parentCd, Boolean isWhole) {
        ProcResultVo result = new ProcResultVo();
        List<CodeVo> list = null;
        list = commonService.selectCodeList(parentGrpCd, parentCd, false);

        CodeVo code = new CodeVo();
        code.setCd("");
        if(isWhole){
        	code.setCdNm("전체");
        }else{
        	code.setCdNm("선택");
        }
        code.setCdOrder(0);
        list.add(0, code);

        result.setData(list);
        return result;
    }
}
