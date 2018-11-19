/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetVmController.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.web;

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

import ncis.cmn.entity.RrRsrcReqDtlNetwk;
import ncis.cmn.entity.RrSlbConfIpReqList;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.com.vo.ViewFocusHandlerVo;
import ncis.cpt.rsrc.com.vo.VmResHistVo;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.cpt.rsrc.net.service.NetVmService;
import ncis.cpt.rsrc.net.vo.NetVmSvo;
import ncis.cpt.rsrc.net.vo.NetVmVo;
import ncis.cpt.rsrc.net.vo.SlbReqVo;
import ncis.cpt.rsrc.pool.vo.RsrcPoolVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 송승규
 *
 */
@Controller
@RequestMapping("/cpt/rsrc/net/vm")
public class NetVmController extends BaseController{

	private final Logger logger = LoggerFactory.getLogger(NetVmController.class.getName());
	//네트워크>가상서버관리
	private final String RN_VM_SLB_CONF = "SLB 설정요청";

	@Resource(name="netVmService")
	private NetVmService netVmService;

	@Resource(name="commonService")
	CommonService commonService;

	/**
	 * 네트워크 가상서버 목록조회
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/selectNetVmList.do")
	public String selectNetVmList(HttpServletRequest request, Model model, NetVmSvo svo){

		List<NetVmVo> list = netVmService.selectNetVmList(svo, true);
		List<CodeVo> statCdCode = commonService.selectCodeList("074", "109", true);
		List<CodeVo> vrlzSwTyCdCode = commonService.selectCodeList("001", "100", false);
		List<CodeVo> osTyCdCode = commonService.selectCodeList("003", "102", true);
		List<CodeVo> netwkTyClCdCode = commonService.selectCodeList("061", "134", true);

		model.addAttribute("searchVo", svo);
		model.addAttribute("netVmList", list);
		model.addAttribute("statCdCode", statCdCode);
		model.addAttribute("vrlzSwTyCdCode", vrlzSwTyCdCode);
		model.addAttribute("osTyCdCode", osTyCdCode);
		model.addAttribute("netwkTyClCdCode", netwkTyClCdCode);

		return portalTilesView(request);
	}



	/**
     * 네트워크 가상서버 목록 엑셀 다운로드
     * @param request
     * @param model
     * @param svo
     * @return
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    @RequestMapping(value = "/selectNetVmListXlsDwnl.do")
    public void selectNetVmListXlsDwnl(HttpServletRequest request, HttpServletResponse response, Model model, NetVmSvo svo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

    	netVmService.selectNetVmList(svo, true);
    	svo.getPaginationInfo().setRecordCountPerPage(svo.getPaginationInfo().getTotalRecordCount());

    	List<NetVmVo> list = netVmService.selectNetVmList(svo, true);

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("statCdNm", "상태");
        header.put("institutionNm", "부처");
        header.put("netwkTyClCdNm", "네트워크유형");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netClCdNm", "망구분");
        header.put("rsrcPoolNm", "자원풀");
        header.put("clstrNm", "클러스터명");
        header.put("pmNm", "물리서버명");
        header.put("pmCompId", "물리서버구성ID");
        header.put("vmId", "가상서버ID");
        header.put("vmNm", "가상서버명");
        header.put("vmCompId", "가상서버구성ID");
        header.put("hstNm", "호스트명");
        header.put("rprsntIpAddr", "IP주소");
        header.put("vrlzSwTyCdNm", "가상화SW");
        header.put("cpuUseRt", "CPU 사용률(%)");
        header.put("cpuEnt", "CPU Ent");
        header.put("cpuVcoreQty", "CPU vCore");
        header.put("memUseRt", "메모리 사용률(%)");
        header.put("memAsgnCapa", "메모리 할당량(GB)");
        header.put("strgAsgnCapa", "스토리지(GB)");
        header.put("netwkIn", "네트워크 In(KB/S)");
        header.put("netwkOut", "네트워크 Out(KB/S)");
        header.put("strtupDt", "기동일시");
        header.put("uptime", "가동시간");
        header.put("regDt", "생성일시");

        List<NetVmVo> datas = new ArrayList<NetVmVo>();

        for(NetVmVo netVmvo : list){
        	NetVmVo vo = new NetVmVo();

        	vo.setStatCdNm(netVmvo.getStatCdNm());
        	vo.setInstitutionNm(netVmvo.getInstitutionNm());
        	vo.setNetwkTyClCdNm(netVmvo.getNetwkTyClCdNm());
        	vo.setRegionNm(netVmvo.getRegionNm());
        	vo.setZoneNm(netVmvo.getZoneNm());
        	vo.setNetClCdNm(netVmvo.getNetClCdNm());
        	vo.setRsrcPoolNm(netVmvo.getRsrcPoolNm());
        	vo.setClstrNm(netVmvo.getClstrNm());
        	vo.setPmNm(netVmvo.getPmNm());
        	vo.setPmCompId(netVmvo.getPmCompId());
        	vo.setVmId(netVmvo.getVmId());
        	vo.setVmNm(netVmvo.getVmNm());
        	vo.setVmCompId(netVmvo.getVmCompId());
        	vo.setHstNm(netVmvo.getHstNm());
        	vo.setRprsntIpAddr(netVmvo.getRprsntIpAddr());
        	vo.setVrlzSwTyCdNm(netVmvo.getVrlzSwTyCdNm());
        	vo.setCpuUseRt(netVmvo.getCpuUseRt());
        	vo.setCpuEnt(netVmvo.getCpuEnt());
        	vo.setCpuVcoreQty(netVmvo.getCpuVcoreQty());
        	vo.setMemUseRt(netVmvo.getMemUseRt());
        	vo.setMemAsgnCapa(netVmvo.getMemAsgnCapa());
        	vo.setStrgAsgnCapa(netVmvo.getStrgAsgnCapa());
        	vo.setNetwkIn(netVmvo.getNetwkIn());
        	vo.setNetwkOut(netVmvo.getNetwkOut());
        	if(!("").equals(netVmvo.getStrtupDttm()) && netVmvo.getStrtupDttm() != null){
        		vo.setStrtupDt((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(netVmvo.getStrtupDttm()));
        	}
        	vo.setUptime(netVmvo.getUptime());
        	if(!("").equals(netVmvo.getRegDttm()) && netVmvo.getRegDttm() != null){
        		vo.setRegDt((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(netVmvo.getRegDttm()));
        	}
        	datas.add(vo);
        }

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("네트워크 가상서버");
        sheet.setDatas(datas);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("네트워크 가상서버_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

    /**
	 * 네트워크 가상서버 상세조회
	 * @param request
	 * @param model
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/selectNetVm.do", method=RequestMethod.GET)
	public String selectNetVmDetail(HttpServletRequest request, Model model, NetVmVo vo){

		NetVmVo resultVo = netVmService.selectNetVm(vo);
		List<CodeVo> statCdCode = commonService.selectCodeList("074", "109", true);
		List<CodeVo> vrlzSwTyCdCode = commonService.selectCodeList("001", "100", false);
		List<CodeVo> osTyCdCode = commonService.selectCodeList("003", "102", true);

		model.addAttribute("vo", resultVo);
		model.addAttribute("statCdCode", statCdCode);
		model.addAttribute("vrlzSwTyCdCode", vrlzSwTyCdCode);
		model.addAttribute("osTyCdCode", osTyCdCode);

		return portalTilesView(request, "selectNetVm");
	}

	 /**
		 * 네트워크 가상서버 상세조회
		 * @param request
		 * @param model
		 * @param vo
		 * @return
		 */
		@RequestMapping(value="/updateNetVm.do", method=RequestMethod.POST)
		@OperateLog(action = "네트워크 가상서버 정보 수정", desc = "네트워크 가상서버 구성ID 변경", params = { "vo", "bindingResult" })
	    @ResponseBody
		public ProcResultVo selectNetVmUpdate(NetVmVo vo, BindingResult bindingResult){

			ProcResultVo procResultVo = getBindingResult(vo, bindingResult, UpdateProc.class);

	        if (!procResultVo.isSuccess()) {
	            return procResultVo;
	        }
	        //공백일때는 비교하지 않도록 변경
	        String tempVmCompID = vo.getVmCompId().replaceAll(" ", "");

            if (tempVmCompID != "" && !vo.getVmCompId().equals(vo.getTempVmCompId()) && netVmService.isExistsVmCompId(vo.getVmCompId())) {
                return getFailProcResult(ComConstant.VM_COMP_ID_ALREADY_EXISTS_MSG, ComConstant.UPDATE, new ViewFocusHandlerVo("vmCompId"));
            }

		    try{

		    	 vo.setUpdtUserId(getUserId());
		    	 VmResHistVo vmResHistVo = new VmResHistVo();

		    	 if (!vo.getVmCompId().equals(vo.getTempVmCompId())) {
	                vmResHistVo.setVmSeq(vo.getVmSeq());
	                vmResHistVo.setLgcyCompId(vo.getTempVmCompId());
	                vmResHistVo.setChngCompId(vo.getVmCompId());
	                vmResHistVo.setVmReqTyCd(ComConstant.VM_REQ_TY_CD_CHG_COMP_ID);
	                vmResHistVo.setWrkId(getUserId());
	                vmResHistVo.setRsrcReqNo(ComConstant.RSRC_REQ_NO_DEFAULT_VALUE); // NULL을 허용하지 않아 기본값으로 대체
	                vmResHistVo.setRsrcReqSeq(new BigDecimal(0)); // NULL을 허용하지 않아 기본값으로 대체
	                netVmService.updateNetVm(vo, vmResHistVo);
	            }else{
	            	netVmService.updateNetVm(vo, null);
	            }

				return getSuccessProcResult(ComConstant.SUCCESS_MSG, ComConstant.UPDATE, null);
			} catch (Exception e) {
	            logger.error(e.getMessage());
	            return getFailProcResult(ComConstant.ERROR_MSG);
	        }
		}

	/**
	 * SLB 생성요청 화면
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/insertSlbReq.do", method=RequestMethod.GET)
	public String insertSlbReq(HttpServletRequest request, Model model){

		List<CodeVo> prtclCode = commonService.selectCodeList("023", "122", false);
		List<CodeVo> slbTyCdCode = commonService.selectCodeList("024", "123", false);
		List<CodeVo> sessMntncTyCdCode = commonService.selectCodeList("025", "124", false);

		model.addAttribute("title", RN_VM_SLB_CONF);
		model.addAttribute("vo", new SlbReqVo());
		model.addAttribute("reqNetList", new RrRsrcReqDtlNetwk());
		model.addAttribute("reqSlbList", new RrSlbConfIpReqList());
		model.addAttribute("prtclCode", prtclCode);
		model.addAttribute("slbTyCdCode", slbTyCdCode);
		model.addAttribute("sessMntncTyCdCode", sessMntncTyCdCode);

		return portalTilesView(request, "insertSlb");
	}

	/**
	 * 네트워크 자원풀 조회 (사용하지 않음)
	 * @param request
	 * @param model
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/selectNetRsrcPoolList.do")
	@ResponseBody
	public ProcResultVo selectNetRsrcPoolList(HttpServletRequest request, Model model, String regionId, String zoneId, String netId){

		ProcResultVo result = new ProcResultVo();

		NetVmSvo svo = new NetVmSvo();

		svo.setRegionId(regionId);
		svo.setZoneId(zoneId);
		svo.setNetId(netId);

		List<RsrcPoolVo> list = netVmService.selectNetRsrcPoolList(svo);

		result.setSuccess(true);
		result.setData(list);
        return result;
	}

	/**
	 * SLB 생성요청
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/insertSlb.do", method = RequestMethod.POST)
    @OperateLog(action = "SLB 생성 요청", desc = "SLB 생성 자원요청 처리.", params = {"vo"})
    @ResponseBody
    public ProcResultVo insertSlb(SlbReqVo vo){

		ProcResultVo result = new ProcResultVo();

		vo.setRsrcReqUserId(getUserId());
		vo.setRegUserId(getUserId());

		try{
			netVmService.insertSlb(vo);
			result.setProcType("insert");
			result.setSuccess(true);
		} catch (NullPointerException ne) {
        	result.setSuccess(false);
        	result.addMessage("SLB 생성에 실패하였습니다.");
        	logger.error("NullPointerException", ne);
        } catch (RuntimeException re) {
        	result.setSuccess(false);
        	result.addMessage("SLB 생성에 실패하였습니다.");
        	logger.error("RuntimeException", re);
        } catch (Exception e) {
        	result.setSuccess(false);
        	result.addMessage("SLB 생성에 실패하였습니다.");
        	logger.error("Exception", e);
        }

		return result;
	}

	/**
	 * 가상서버 목록 팝업
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
    @RequestMapping(value = "/selectComVmListP.do")
    public String selectComVmListPopup(HttpServletRequest request, Model model, VmSearchVo svo) {

        List<VmVo> list = netVmService.selectComVmList(svo);

        List<CodeVo> vrlzSwTyCdList = commonService.selectCodeList(ComConstant.VRLZ_SW_TY_GRP_CD, ComConstant.VRLZ_SW_TY_PARENT_CD); // 가상화SW 코드
        List<CodeVo> osTyCdList = commonService.selectCodeList(ComConstant.OS_TY_GRP_CD, ComConstant.OS_TY_PARENT_CD, true); // 운영체제유형 코드
        List<CodeVo> statCdList = commonService.selectCodeList(ComConstant.VM_STAT_GRP_GRP_CD, ComConstant.VM_STAT_GRP_PARENT_CD, true); // 가상서버상태 코드

        model.addAttribute("vrlzSwTyCdList", vrlzSwTyCdList);
        model.addAttribute("osTyCdList", osTyCdList);
        model.addAttribute("statCdList", statCdList);
        model.addAttribute("title", "가상서버 목록");
        model.addAttribute("vmSearchVo", svo);
        model.addAttribute("vmVoList", list);

        return popup(request);
    }
}
