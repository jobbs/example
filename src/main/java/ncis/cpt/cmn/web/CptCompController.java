/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CmEvntStteController.java
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
package ncis.cpt.cmn.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqMngService;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngSearchVo;
import ncis.cpt.rsrc.com.service.ComService;
import ncis.cpt.sys.user.service.UserService;
import ncis.cpt.sys.user.vo.UserSearchVo;
import ncis.dsb.thrd.evnt.service.EvntStteService;
import ncis.dsb.thrd.evnt.vo.EvntStteSearchVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author 최진호
 *
 */
@Controller
@RequestMapping(value = "/cmn/component/cpt")
public class CptCompController extends BaseController {

    @Resource(name="evntStteService")
    private EvntStteService evntStteService;

    @Resource(name="rsrcReqMngService")
    private RsrcReqMngService rsrcReqMngService;

    @Resource(name = "comService")
    private ComService comService;

    @Resource(name = "userService")
    private UserService userService;



    /**
     * 메인 또는 서브페이지 우측 이벤트 목록 조회
     * @param request
     * @param searchVo
     * @return
     */
    @RequestMapping(value="/evntstte/selectEvntStteList.do")
    @ResponseBody
    public ProcResultVo selectEvntStteList(HttpServletRequest request, EvntStteSearchVo searchVo) {

        ProcResultVo resultVo = new ProcResultVo();
        // 이벤트현황
        searchVo.setSearchTrmCd("01");// 최근1시간 기본 셋팅
        resultVo.setData( evntStteService.selectEvntStteList(searchVo) );
        return resultVo;
    }

    /**
     * 메인 또는 서브페이지 자원요청사항 조회
     * @param request
     * @param searchVo
     * @return
     */
    @RequestMapping(value="/rsrcreq/selectRsrcReqList.do")
    @ResponseBody
    public ProcResultVo selectRsrcReqList(HttpServletRequest request, RsrcReqMngSearchVo searchVo) {

        ProcResultVo resultVo = new ProcResultVo();
        searchVo.getPaginationInfo().setRecordCountPerPage(9);
        resultVo.setData( rsrcReqMngService.selectRsrcReqList(searchVo) );

        return resultVo;
    }

    /**
     * 메인 또는 서브페이지 물리서버 가상서버 수를 조회
     * @param request
     * @param searchVo
     * @return
     */
    @RequestMapping(value="/comstts/selectComSttsByUser.do")
    @ResponseBody
    public ProcResultVo selectComSttsByUser(HttpServletRequest request, RsrcReqMngSearchVo searchVo) {

        ProcResultVo resultVo = new ProcResultVo();
        resultVo.setData( comService.selectComSttsByUser() );

        return resultVo;
    }

    /**
     * 사용자 검색
     * @param request
     * @param searchVo
     * @return
     */
    @RequestMapping(value="/usr/selectUsr.do")
    @ResponseBody
    public ProcResultVo selectUsr(HttpServletRequest request, UserSearchVo searchVo) {

        ProcResultVo resultVo = new ProcResultVo();
        resultVo.setData( userService.selectUserList(searchVo) );

        return resultVo;
    }

}
