/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CmAlrmController.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 30.
 * @lastmodified 2016. 9. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 30.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.component.web;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.alrm.service.AlrmService;
import ncis.cpt.sys.alrm.vo.AlrmSearchVo;
import ncis.cpt.sys.alrm.vo.AlrmVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author 최진호
 *
 */
@Controller
@RequestMapping(value = "/cmn/component/alrm")
public class CmAlrmController extends BaseController {

    @Resource(name="alrmService") private AlrmService alrmService;

    @RequestMapping(value="/selectTopAlrmList.do")
    @ResponseBody
    public ProcResultVo selectCodeSearchList(HttpServletRequest request, Model model,
            AlrmSearchVo searchVo) {

        ProcResultVo resultVo = new ProcResultVo();
        searchVo.setSearchConfirmYn("N");
        List<AlrmVo> alrms =  alrmService.selectAlrmList(searchVo);
        resultVo.setData(alrms);
        return resultVo;

    }



    @RequestMapping(value="/updateTopAlrm.do")
    @ResponseBody
    public ProcResultVo updateTopAlrm(HttpServletRequest request, @RequestParam(required=true) Long alrmSeq) {

        AlrmVo alrmVo = new AlrmVo();
        alrmVo.setAlrmSeq(alrmSeq);
        alrmVo.setConfrmYn("Y");
        alrmService.updateAlrm(alrmVo);
        return getSuccessProcResult();

    }

}
