package ncis.cpt.rsrc.atmscl.web;

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

import ncis.cmn.config.OprConstant;
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.rsrc.atmscl.service.NodeService;
import ncis.cpt.rsrc.atmscl.vo.NodeSearchVo;
import ncis.cpt.rsrc.atmscl.vo.NodeVo;
import ncis.cpt.rsrc.atmscl.vo.ServcPodVo;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.com.service.VmService;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.cpt.rsrc.pool.service.RsrcPoolService;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;

import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/cpt/rsrc/atmscl/node")
public class NodeController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(NodeController.class);

	@Resource(name="nodeService")
	NodeService nodeService;

	@Resource(name="commonService")
	CommonService commonService;

	@Resource(name = "vmService")
    VmService vmService;

	@Resource(name = "rsrcPoolService")
	RsrcPoolService rsrcPoolService;


	/**
	 * 노드 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectNodeList.do")
	public String selectNodeList(HttpServletRequest request, Model model, NodeSearchVo searchVo) {
		List<NodeVo> list = nodeService.selectNodeList(searchVo);
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		return portalTilesView(request);
	}

	/**
	 * 노드 목록 정보 Excel Down
	 * @param request
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/selectNodeListXlsDwnl.do")
    public void selectNodeListXlsDwnl(HttpServletRequest request, HttpServletResponse response, NodeSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("statCdNm", "상태");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망구분");
        header.put("rsrcPoolNm", "자원풀");
        header.put("atmsclNodeTyCdNm", "노드유형");
        header.put("atmsclNodeNm", "노드명");
        header.put("atmsclNodeIpAddr", "IP주소");
        header.put("podQty", "Pod수");
        header.put("sumCpuCorQty", "CPU Core");
        header.put("avgCpuUseRt", "CPU 사용률(%)");
        header.put("sumMemAsgnCapa", "메모리 할당량(GB)");
        header.put("avgMemUseRt", "메모리 사용률(%)");
        header.put("netwkIn", "네트워크 In(KB/Sec)");
        header.put("netwkOut", "네트워크 Out(KB/Sec)");
        header.put("creDttm", "생성일자");

        List<NodeVo> list = nodeService.selectNodeList(searchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("노드관리");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response,String.format("노드관리_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }


	/**
	 * 노드생성 화면
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/insertNodeView.do", method=RequestMethod.GET)
	public String insertNode(HttpServletRequest request, Model model){
		model.addAttribute("nodeVo", new NodeVo());
		return portalTilesView(request, "insertNode");
	}


	/**
	 * 노드 생성
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@OperateLog(action="노드 생성", desc="노드 생성 처리", params={"NodeVo"}, actionType=ActionType.INSERT)
	@RequestMapping(value="/insertNode.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo insertNode(@ModelAttribute("vo") NodeVo nodeVo) throws Exception{

		ProcResultVo result = new ProcResultVo();
		nodeVo.setCreUserId(getUserId());

		try {

			String resultmessage = nodeService.insertNode(nodeVo);
			result.setProcType(OprConstant.RSRC_PROC_TYPE_UPDATA);
			result.addMessage(resultmessage);
			result.setSuccess(true);
		}catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
			logger.error(e.getMessage(), e);
			result.setSuccess(false);
			result.addMessage(OprConstant.RX_CRE_FAIL_MSG   + ", error="+ e.getMessage());
		}

		return result;
	}


    /**
	 * 가상서버 조회 화면 호출
	 * @param request
	 * @param model
	 * @return
	 */
	 @RequestMapping(value = "/selectAtmSclVmListPView.do")
	 public String selectAtmSclVmListPView(HttpServletRequest request, Model model, VmSearchVo vmSearchVo) {

		 String[] existsVrlzSwTyCdArr = new String[1];
		 existsVrlzSwTyCdArr[0] = "01"; //RHEV 대상임.
		 vmSearchVo.setExistsVrlzSwTyCdList(existsVrlzSwTyCdArr);
		 //vmSearchVo.setEqualsOsTyCd("01");

		 vmSearchVo.setEqualsRegionId(vmSearchVo.getEqualsRegionId());
		 vmSearchVo.setEqualsZoneId(vmSearchVo.getEqualsZoneId());
		 vmSearchVo.setEqualsNetClCd(vmSearchVo.getEqualsNetClCd());
		 //vmSearchVo.setEqualsRsrcPoolId(vmSearchVo.getEqualsRsrcPoolId());

		 List<VmVo> vmVoList = vmService.selectVmListPaging(vmSearchVo);
		 // List<CodeVo> vrlzSwTyCdList = commonService.selectCodeList(ComConstant.VRLZ_SW_TY_GRP_CD, ComConstant.VRLZ_SW_TY_PARENT_CD); // 가상화SW 코드
		 List<CodeVo> osTyCdList = commonService.selectCodeList(ComConstant.OS_TY_GRP_CD, ComConstant.OS_TY_PARENT_CD, true); // 운영체제유형 코드
		 List<CodeVo> statCdList = commonService.selectCodeList(ComConstant.VM_STAT_GRP_GRP_CD, ComConstant.VM_STAT_GRP_PARENT_CD, true); // 가상서버상태 코드

		 //model.addAttribute("vrlzSwTyCdList", vrlzSwTyCdList);
		 model.addAttribute("osTyCdList", osTyCdList);
		 model.addAttribute("statCdList", statCdList);
		 model.addAttribute("vmVoList", vmVoList);
		 model.addAttribute("vmSearchVo", vmSearchVo);
		 model.addAttribute("vmVo", new VmVo());

		 model.addAttribute("title","가상서버 선택");
		 return popup(request, "selectAtmSclVmListP");
	 }




	/**
	 * 노드  수정  조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectNode.do")
	public String updateNode(HttpServletRequest request, Model model, @RequestParam(required=true) String nodeRsrcPoolId,  @RequestParam(required=true) String atmsclNodeId) throws Exception {

		//노드정보
		NodeVo nodeVo = nodeService.selectNode(nodeRsrcPoolId, atmsclNodeId);
		model.addAttribute("nodeVo", nodeVo);

		if( ObjectUtils.isEmpty(nodeVo) ) {
            throw new DataNotFoundException(messageUtil.getMessage("message.error.dataNotFound"));
        }

		//Pod정보
		List<ServcPodVo> servcPodList = nodeService.selectServcPodList(nodeRsrcPoolId, atmsclNodeId);
		model.addAttribute("servcPodList", servcPodList);

		return portalTilesView(request);
	}


	/**
	 * 노드 수정
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateNode.do", method = RequestMethod.POST)
	@OperateLog(action = "노드 수정", desc = "노드 수정 처리", params = {
			"NodeVo" }, actionType = ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateNode(HttpServletRequest request,
			@ModelAttribute("nodeVo") NodeVo nodeVo) throws Exception {

		ProcResultVo result = new ProcResultVo();
		result.setProcType("update");
		try {
			nodeVo.setUpdtUserId(getUserId());
			nodeService.updateNode(nodeVo);
			result.setSuccess(true);
			result.addMessage("정상적으로 수정되었습니다.");
		}catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
			logger.error(e.getMessage(), e);
			result.setSuccess(false);
			result.addMessage("수정에 실패하였습니다.");
		}

		return result;
	}
}
