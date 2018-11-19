/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ZoneController.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.zone.web;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import ncis.cmn.service.CommonService;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.vo.Tree;
import ncis.cmn.vo.TreeNode;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.cpt.sys.zone.service.ZoneMngService;
import ncis.cpt.sys.zone.vo.NetVo;
import ncis.cpt.sys.zone.vo.RegionVo;
import ncis.cpt.sys.zone.vo.RsrcPoolVo;
import ncis.cpt.sys.zone.vo.ZoneNetVo;
import ncis.cpt.sys.zone.vo.ZoneVo;
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
@RequestMapping(value="/cpt/sys/zone")
public class ZoneMngController extends BaseController {

    @Resource(name="zoneMngService")
    private ZoneMngService zoneMngService;

    @Resource(name="commonService")
    private CommonService commonService;

    /**
     * 존관리 Index
     * @param request
     * @return
     */
    @RequestMapping(value="/selectZoneList.do")
    public String selectZoneList(HttpServletRequest request) {
        return portalTilesView(request);
    }

    /**
     * 존 목록을 Tree 형태로 호출(자원풀 포함)
     * @param parentSeq
     * @return
     */
    @RequestMapping(value="/selectZoneAndPoolListTree.do")
    @ResponseBody
    public List<TreeNode<String,ZoneVo>> selectZoneAndPoolListTree() {
        Tree<String,ZoneVo> tree = zoneMngService.selectZoneAndPoolListTree();
        return tree.getRoot().getChildren();
    }

    /**
     * 센터 상세 조회
     * @param request
     * @param model
     * @param menuSeq
     * @return
     */
    @RequestMapping(value="/selectRegion.do")
    public String selectRegion(HttpServletRequest request, Model model,
            @RequestParam(required=true)String regionId) {

        RegionVo region = zoneMngService.selectRegion(regionId);
        model.addAttribute("region", region);
        return jstlView(request);
    }

    /**
     * 센터 등록 화면 호출
     * @param request
     * @param model
     * @param menuSeq
     * @return
     */
    @RequestMapping(value="/insertRegion.do", method=RequestMethod.GET)
    public String insertRegionView(HttpServletRequest request, Model model) {
        model.addAttribute("region", new RegionVo());
        return jstlView(request,"formRegion");
    }

    /**
     * 센터 등록 프로세스 처리
     * @param request
     * @param model
     * @param menu
     * @return
     */
    @RequestMapping(value="/insertRegion.do", method=RequestMethod.POST)
    @OperateLog(action="존-센터정보 등록", desc="존관리 센터 정보 등록 처리", params={"regionId", "regionNm"}, actionType=ActionType.INSERT)
    @ResponseBody
    public ProcResultVo insertRegion(HttpServletRequest request, @Valid @ModelAttribute("region") RegionVo region, BindingResult bindingResult) {

        ProcResultVo result = getBindingResult(bindingResult);
        if( result.isSuccess() ) {

            region.setRegUserId(getUserId());
            region.setUpdtUserId(getUserId());
            zoneMngService.insertRegion(region);

            result.setProcType("regionInsert");
        }

        return result;
    }

    /**
     * 센터 수정 화면 호출
     * @param request
     * @param model
     * @param menuSeq
     * @return
     */
    @RequestMapping(value="/updateRegion.do", method=RequestMethod.GET)
    public String updateRegionView(HttpServletRequest request, Model model,
            @RequestParam(required=true)String regionId) {

        RegionVo region = zoneMngService.selectRegion(regionId);
        model.addAttribute("region", region);
        return jstlView(request,"formRegion");
    }

    /**
     * 센터 수정 프로세스 처리
     * @param request
     * @param model
     * @param menu
     * @return
     */
    @RequestMapping(value="/updateRegion.do", method=RequestMethod.POST)
    @OperateLog(action="존-센터정보 수정", desc="존관리 센터 정보 수정 처리", params={"regionId", "regionNm"}, actionType=ActionType.UPDATE)
    @ResponseBody
    public ProcResultVo updateRegion(HttpServletRequest request, Model model,
            @Valid @ModelAttribute("region") RegionVo region, BindingResult bindingResult) {

        ProcResultVo result = getBindingResult(bindingResult);
        if( result.isSuccess() ) {

            region.setUpdtUserId(getUserId());
            zoneMngService.updateRegion(region);

            result.setProcType("regionUpdate");
        }

        return result;
    }


    /**
     * 센터 삭제
     * @param request
     * @param model
     * @param menu
     * @return
     */
    @RequestMapping(value="/deleteRegion.do", method=RequestMethod.POST)
    @OperateLog(action="존-센터정보 삭제", desc="존관리 센터 정보 삭제 처리", params={"regionId"}, actionType=ActionType.DELETE)
    @ResponseBody
    public ProcResultVo deleteRegion(HttpServletRequest request, Model model,
            @RequestParam(required=true) String regionId) {

        if( zoneMngService.selectExistZoneByRegion(regionId) ) {
            return getFailProcResult("센터에 속한 존이 존재합니다. 존을 먼저 삭제해 주시기 바랍니다.");
        }

        zoneMngService.deleteRegion(regionId);
        return getSuccessProcResult("regionDelete");
    }


    /**
     * 존 상세 조회
     * @param request
     * @param model
     * @param menuSeq
     * @return
     */
    @RequestMapping(value="/selectZone.do")
    public String selectZone(HttpServletRequest request, Model model,
            @RequestParam(required=true)String zoneId) {

        ZoneVo zone = zoneMngService.selectZone(zoneId);
        model.addAttribute("zone", zone);
        return jstlView(request);
    }

    /**
     * 존 등록 화면 호출
     * @param request
     * @param model
     * @param menuSeq
     * @return
     */
    @RequestMapping(value="/insertZone.do", method=RequestMethod.GET)
    public String insertZoneView(HttpServletRequest request, @RequestParam(required=true)String regionId, Model model) {

        ZoneVo zone = new ZoneVo();
        zone.setRegionId(regionId);
        zone.setRegion(zoneMngService.selectRegion(regionId));
        model.addAttribute("zone", zone);
        return jstlView(request,"formZone");
    }

    /**
     * 존 등록 프로세스 처리
     * @param request
     * @param model
     * @param menu
     * @return
     */
    @RequestMapping(value="/insertZone.do", method=RequestMethod.POST)
    @OperateLog(action="존-존 정보 등록", desc="존관리 존 정보 등록 처리", params={"regionId", "regionNm"}, actionType=ActionType.INSERT)
    @ResponseBody
    public ProcResultVo insertZone(HttpServletRequest request, Model model,
            @Valid @ModelAttribute("zone") ZoneVo zone, BindingResult bindingResult) {

        ProcResultVo result = getBindingResult(bindingResult);
        if( result.isSuccess() ) {

            zone.setRegUserId(getUserId());
            zone.setUpdtUserId(getUserId());
            zoneMngService.insertZone(zone);

            result.setData(zoneMngService.selectZone(zone.getZoneId()));
            result.setProcType("zoneInsert");
        }

        return result;
    }

    /**
     * 존 수정 화면 호출
     * @param request
     * @param model
     * @param menuSeq
     * @return
     */
    @RequestMapping(value="/updateZone.do", method=RequestMethod.GET)
    public String updateZoneView(HttpServletRequest request, @RequestParam(required=true)String zoneId, Model model) {

        ZoneVo zone = zoneMngService.selectZone(zoneId);
        model.addAttribute("zone", zone);
        return jstlView(request,"formZone");
    }

    /**
     * 존 수정 프로세스 처리
     * @param request
     * @param model
     * @param menu
     * @return
     */
    @RequestMapping(value="/updateZone.do", method=RequestMethod.POST)
    @OperateLog(action="존-존 정보 수정", desc="존관리 존 정보 수정 처리", params={"regionId", "regionNm"}, actionType=ActionType.UPDATE)
    @ResponseBody
    public ProcResultVo updateZone(HttpServletRequest request, Model model,
            @Valid @ModelAttribute("zone") ZoneVo zone, BindingResult bindingResult) {

        ProcResultVo result = getBindingResult(bindingResult);
        if( result.isSuccess() ) {

            zone.setUpdtUserId(getUserId());
            zoneMngService.updateZone(zone);

            result.setProcType("zoneUpdate");
        }

        return result;
    }

    /**
     * 존 삭제
     * @param request
     * @param model
     * @param menu
     * @return
     */
    @RequestMapping(value="/deleteZone.do", method=RequestMethod.POST)
    @OperateLog(action="존-존정보 삭제", desc="존관리 존 정보 삭제 처리", params={"zoneId"}, actionType=ActionType.DELETE)
    @ResponseBody
    public ProcResultVo deleteZone(HttpServletRequest request, Model model,
            @RequestParam(required=true) String zoneId) {

        if( zoneMngService.selectExistNetByZone(zoneId) ) {
            return getFailProcResult("존에 속한 망이 존재합니다. 망을 먼저 삭제해 주시기 바랍니다.");
        }

        zoneMngService.deleteZone(zoneId);
        return getSuccessProcResult("zoneDelete");
    }

    /**
     * 망 상세 조회
     * @param request
     * @param model
     * @param menuSeq
     * @return
     */
    @RequestMapping(value="/selectNet.do")
    public String selectNet(HttpServletRequest request, Model model,
            @RequestParam(required=true)String netId) {

        NetVo net = zoneMngService.selectNet(netId);
        model.addAttribute("net", net);
        return jstlView(request);
    }

    /**
     * 망 등록 화면 호출
     * @param request
     * @param model
     * @param menuSeq
     * @return
     */
    @RequestMapping(value="/insertNet.do", method=RequestMethod.GET)
    public String insertNetView(HttpServletRequest request, @RequestParam(required=true)String zoneId, Model model) {

        NetVo net = new NetVo();

        ZoneNetVo zoneNet = new ZoneNetVo();
        zoneNet.setZoneId(zoneId);
        zoneNet.setZone(zoneMngService.selectZone(zoneId));
        net.setZoneNet(zoneNet);

        model.addAttribute("net", net);
        return jstlView(request,"formNet");
    }

    /**
     * 망 등록 프로세스 처리
     * @param request
     * @param model
     * @param menu
     * @return
     */
    @RequestMapping(value="/insertNet.do", method=RequestMethod.POST)
    @OperateLog(action="존-망 정보 등록", desc="존관리 망 정보 등록 처리", params={"netId", "netNm"}, actionType=ActionType.INSERT)
    @ResponseBody
    public ProcResultVo insertNet(HttpServletRequest request, Model model,
            @Valid @ModelAttribute("zone") NetVo net, BindingResult bindingResult) {

        ProcResultVo result = getBindingResult(bindingResult);
        if( result.isSuccess() ) {

            String netId = commonService.selectSeqNum("RC_NET", "NET");

            net.setNetId(netId);

            net.getZoneNet().setNetId(netId);
            net.getZoneNet().setRegUserId(getUserId());
            net.getZoneNet().setUpdtUserId(getUserId());
            zoneMngService.insertNet(net);

            result.setData(zoneMngService.selectNet(netId));
            result.setProcType("netInsert");
        }

        return result;
    }

    /**
     * 망 수정 화면 호출
     * @param request
     * @param model
     * @param menuSeq
     * @return
     */
    @RequestMapping(value="/updateNet.do", method=RequestMethod.GET)
    public String updateNetView(HttpServletRequest request,
                @RequestParam(required=true)String netId, Model model) {

        NetVo net = zoneMngService.selectNet(netId);

        model.addAttribute("net", net);
        return jstlView(request,"formNet");
    }

    /**
     * 망 수정 프로세스 처리
     * @param request
     * @param model
     * @param menu
     * @return
     */
    @RequestMapping(value="/updateNet.do", method=RequestMethod.POST)
    @OperateLog(action="존-망 정보 수정", desc="존관리 망 정보 수정 처리", params={"netId", "netNm"}, actionType=ActionType.UPDATE)
    @ResponseBody
    public ProcResultVo updateNet(HttpServletRequest request, Model model,
            @Valid @ModelAttribute("net") NetVo net, BindingResult bindingResult) {

        ProcResultVo result = getBindingResult(bindingResult);
        if( result.isSuccess() ) {
            zoneMngService.updateNet(net);

            result.setProcType("netupdate");
        }

        return result;
    }

    /**
     * 망 삭제
     * @param request
     * @param model
     * @param menu
     * @return
     */
    @RequestMapping(value="/deleteNet.do", method=RequestMethod.POST)
    @OperateLog(action="존-망정보 삭제", desc="존관리 망 정보 삭제 처리", params={"netId"}, actionType=ActionType.DELETE)
    @ResponseBody
    public ProcResultVo deleteNet(HttpServletRequest request, Model model,
            @RequestParam(required=true) String netId) {

        if( zoneMngService.selectExistPoolByNet(netId) ) {
            return getFailProcResult("망에 속한 자원풀이 존재합니다. 자원풀을 먼저 삭제해 주시기 바랍니다.");
        }

        zoneMngService.deleteNet(netId);
        return getSuccessProcResult("netDelete");
    }

    /**
     * 자원풀 상세 조회
     * @param request
     * @param model
     * @param menuSeq
     * @return
     */
    @RequestMapping(value="/selectPool.do")
    public String selectPool(HttpServletRequest request, Model model,
            @RequestParam(required=true)String rsrcPoolId) {

        RsrcPoolVo pool = zoneMngService.selectPool(rsrcPoolId);
        model.addAttribute("pool", pool);
        return jstlView(request);
    }

    /**
     * 망에 속한 자원풀 조회
     * @param request
     * @param model
     * @param menuSeq
     * @return
     */
    @RequestMapping(value="/selectNetListByPoolP.do")
    public String selectNetListByPool(HttpServletRequest request, Model model,
            @RequestParam(required=true)String zoneId, @RequestParam(required=true)String netClCd ) {

        ZoneVo zone = zoneMngService.selectZone(zoneId);
        List<NetVo> nets = zoneMngService.selectNetListByPool(zoneId, netClCd);

        model.addAttribute("title", "망 선택");
        model.addAttribute("zone", zone);
        model.addAttribute("nets", nets);
        return popup(request);
    }

    /**
     * 존 위치이동
     * @param request
     * @param model
     * @param menu
     * @return
     */
    @RequestMapping(value="/updateMoveRsrcPool.do", method=RequestMethod.POST)
    @OperateLog(action="존-자원풀 위치 이동", desc="존관리 자원풀 위치 이동 처리", params={"zoneId", "netId"}, actionType=ActionType.UPDATE)
    @ResponseBody
    public ProcResultVo updateMoveRsrcPool(HttpServletRequest request, Model model, @RequestParam(required=true) String netId, @RequestParam(required=true) String poolId) {
        zoneMngService.updateMoveRsrcPool(netId, poolId);
        return getSuccessProcResult("poolMove");
    }

    /**
	 * 자원풀 수정
	 * @param poolVo
	 * @return
	 */
	@RequestMapping(value = "/updatePool.do", method = RequestMethod.POST)
	@OperateLog(action="자원풀 정보 수정", desc="자원풀 사용여부 정보 수정", params={"rsrcPoolId", "ctlTrgtYn"}, actionType=ActionType.UPDATE)
    @ResponseBody
    public ProcResultVo updatePool(HttpServletRequest request, @ModelAttribute("pool") RsrcPoolVo poolVo){
		zoneMngService.updatePool(poolVo);
		return getSuccessProcResult("자원풀을 수정하였습니다.", "update");
    }
}
