/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CmSelectboxController.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.component.web;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.rsrc.com.service.ClstrService;
import ncis.cpt.rsrc.com.vo.ClstrSearchVo;
import ncis.cpt.rsrc.com.vo.ClstrVo;
import ncis.cpt.rsrc.pool.service.RsrcPoolService;
import ncis.cpt.rsrc.pool.vo.RsrcPoolSearchVo;
import ncis.cpt.rsrc.pool.vo.RsrcPoolVo;
import ncis.cpt.rsrc.zone.service.NetService;
import ncis.cpt.rsrc.zone.service.ZoneService;
import ncis.cpt.rsrc.zone.vo.NetSearchVo;
import ncis.cpt.rsrc.zone.vo.NetVo;
import ncis.cpt.rsrc.zone.vo.ZoneSearchVo;
import ncis.cpt.rsrc.zone.vo.ZoneVo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 최진호
 *
 */
@Controller
@RequestMapping(value="/cmn/component")
public class CmSelectboxController extends BaseController  {

    @Resource(name="zoneService")
    ZoneService zoneService;

    @Resource(name="netService")
    NetService netService;

    @Resource(name="rsrcPoolService")
    RsrcPoolService rsrcPoolService;

    @Resource(name="clstrService")
    ClstrService  clstrService;

    /**
     * Zone 목록
     * @param regionId
     * @return
     */
    @RequestMapping(value="/zone/selectZoneList.do")
    @ResponseBody
    public ProcResultVo selectZoneList(ZoneSearchVo searchVo) {
        ProcResultVo result = new ProcResultVo();

        List<ZoneVo> list = zoneService.selectZoneListByRegion(searchVo);
        result.setData(list);
        return result;
    }

    /**
     * 망 선택 목록
     * @param zoneId
     * @return
     */
    @RequestMapping(value="/zone/selectNetList.do")
    @ResponseBody
    public ProcResultVo selectNetList(NetSearchVo searchVo) {
        ProcResultVo result = new ProcResultVo();
        List<NetVo> list = netService.selectNetListByZone(searchVo);
        result.setData(list);
        return result;
    }

    /**
     * 클러스터 목록
     * @param searchVo
     * @return
     */
    @RequestMapping(value="/clstr/selectClstrList.do")
    @ResponseBody
    public ProcResultVo selectClstrList(ClstrSearchVo searchVo) {

        ProcResultVo result = new ProcResultVo();
        List<ClstrVo> list = clstrService.selectClstrList(searchVo);
        result.setData(list);
        return result;
    }

    /**
     * 자원풀 목록
     * @param searchVo
     * @return
     */
    @RequestMapping(value="/pool/selectPoolList.do")
    @ResponseBody
    public ProcResultVo selectPoolList(RsrcPoolSearchVo searchVo) {

        ProcResultVo result = new ProcResultVo();
        List<RsrcPoolVo> list = rsrcPoolService.selectUserRsrcPoolList(searchVo);
        result.setData(list);
        return result;
    }

}
