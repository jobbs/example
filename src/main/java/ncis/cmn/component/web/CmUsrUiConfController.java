/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CmUsrUiConfController.java
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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import ncis.cmn.component.service.UsrUiConfService;
import ncis.cmn.entity.CmUsrUiConf;
import ncis.cmn.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author 최진호
 *
 */
@Controller
@RequestMapping(value = "/cmn/component/usruiconf")
public class CmUsrUiConfController extends BaseController {

    @Resource(name="usrUiConfService") private UsrUiConfService usrUiConfService;

    @RequestMapping(value="/updateUsrUiConf.do")
    @ResponseBody
    public void selectCodeSearchList(HttpServletRequest request, CmUsrUiConf confVo) {
        confVo.setUsrId(getUserId());
        usrUiConfService.updateCmUsrUiConf(confVo);
        getUser().updateUiConf(confVo);
    }

}
