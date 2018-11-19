/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetSwtchController.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.entity.RnNetwkSwtch;
import ncis.cmn.service.CommonService;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.rsrc.net.service.NetSwtchService;
import ncis.cpt.rsrc.net.vo.NetSwtchSvo;
import ncis.cpt.rsrc.net.vo.NetSwtchVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 송승규
 *
 */
@Controller
@RequestMapping("/cpt/rsrc/net/swtch")
public class NetSwtchController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(NetVmController.class.getName());

	@Resource(name="netSwtchService")
	private NetSwtchService netSwtchService;

	@Resource(name="commonService")
	CommonService commonService;

	/**
	 * 부처별 L3/L4 목록 조회
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/selectNetSwtchList.do")
	public String selectNetSwtchList(HttpServletRequest request, Model model, NetSwtchSvo svo){

		List<NetSwtchVo> list = netSwtchService.selectNetSwtchList(svo);
		List<CodeVo> netwkTyClCdCode = commonService.selectCodeList("061", "134", true);

		model.addAttribute("searchVo", svo);
		model.addAttribute("list", list);
		model.addAttribute("vo", new NetSwtchVo());
		model.addAttribute("netSwtchList", new RnNetwkSwtch());
		model.addAttribute("netwkTyClCdCode", netwkTyClCdCode);

		return portalTilesView(request);
	}

	/**
	 * 부처별 L3/L4 수정
	 * @param vo
	 * @return
	 */
	@OperateLog(action="부처별 L3/L4 수정", desc="부처별 L3/L4 처리", params={"NetSwtchVo"}, actionType=ActionType.UPDATE)
	@RequestMapping(value="/updateNetSwtch.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updateNetSwtch(@ModelAttribute("vo") NetSwtchVo vo, NetSwtchSvo svo) throws NullPointerException, RuntimeException, Exception {

		ProcResultVo result = new ProcResultVo();

		if(!vo.getNetSwtchList().isEmpty()){

			try {
				netSwtchService.updateNetSwtch(vo, svo);
				result.setProcType("update");
				result.setSuccess(true);
		    } catch (NullPointerException ne) {
		    	result.setSuccess(false);
		    	result.addMessage("부처별 L3/L4 수정에 실패하였습니다.");
		    	logger.error("NullPointerException", ne);
		    } catch (RuntimeException re) {
		    	result.setSuccess(false);
		    	result.addMessage("부처별 L3/L4 수정에 실패하였습니다.");
		    	logger.error("RuntimeException", re);
		    } catch (Exception e) {
		    	result.setSuccess(false);
		    	result.addMessage("부처별 L3/L4 수정에 실패하였습니다.");
		    	logger.error("Exception", e);
		    }
		}

		return result;
	}
}
