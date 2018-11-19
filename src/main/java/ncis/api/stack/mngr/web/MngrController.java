/**
 * copyright 2016 NCIS Cloud api-gateway System
 * @description
 * <pre></pre>
 *
 * @filename MngrController.java
 *
 * @author 정승용
 * @lastmodifier 정승용
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * 		Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.     정승용         		v1.0                   기능개발
 *
 */
package ncis.api.stack.mngr.web;

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

import ncis.api.stack.mngr.service.MngrService;
import ncis.api.stack.mngr.vo.MngrSearchVo;
import ncis.api.stack.mngr.vo.MngrVo;
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.DateUtil;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.rsrc.zone.service.NetService;
import ncis.cpt.rsrc.zone.vo.NetVo;
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

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @author 정승용
 *
 */
@Controller("mngController")
@RequestMapping(value="/api/stack/mngr")
public class MngrController extends BaseController {

	@Resource(name="mngrService")
	MngrService mngrService;

	@Resource(name="commonService")
	CommonService commonService;

	@Resource(name="netService")
	NetService netService;

	/**
	 * 매니저관리 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectMngrList.do")
	public String selectMngrList(HttpServletRequest request, Model model, MngrSearchVo searchVo) throws Exception {

		/** 망 코드 조회 */
		List<NetVo> netItems = netService.selectNetAllList();
		String netClCd="";
		String netCd = "";
		netCd = searchVo.getSearchNetId();	// 조회후 화면에 조회 값을 유지하기 위해 임시로 세팅
        for(int j=0; j<netItems.size();j++){
			if(netItems.get(j).getNetId().equals(searchVo.getSearchNetId())){
				netClCd = netItems.get(j).getNetClCd();
			}
		}
        searchVo.setSearchNetId(netClCd);

		/** 매니저 관리 목록 조회 */
		List<MngrVo> list = mngrService.selectMngrList(searchVo);

		if("".equals(searchVo.getSearchStackClCd()) || searchVo.getSearchStackClCd() == null){
			searchVo.setSearchStackClCd("all");
		}
		if("".equals(searchVo.getSearchMngrClCd()) || searchVo.getSearchMngrClCd() == null){
			searchVo.setSearchMngrClCd("all");
		}

		searchVo.setSearchNetId(netCd);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("list", list);

		return apiTilesView(request);
	}

	/**
	 * 매니저 상태 호출(목록 조회)
	 * @param request
	 * @param model
	 * @return result
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectMngrHealthCheck.do")
	@ResponseBody
	public ProcResultVo selectMngrHealthCheck(HttpServletRequest request, Model model,
			@RequestParam(required = true) String rowId, @RequestParam(required = true) String regionId,
			@RequestParam(required = true) String zoneId, @RequestParam(required = true) String netId,
			@RequestParam(required = true) String mngrId) throws Exception {

		ProcResultVo result = new ProcResultVo();
		result.setData(mngrService.selectMngrHealthCheck(rowId, regionId, zoneId, netId, mngrId));

		return result;
	}

	/**
	 * 매니저관리 상세
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectMngr.do")
	public String selectMngr(HttpServletRequest request, Model model, @RequestParam("stackMngrId") String stackMngrId) throws Exception {

		/** 매니저 관리 상세 조회 */
		MngrVo mngrVo = mngrService.selectMngr(stackMngrId);
		if( null == mngrVo ) throw new DataNotFoundException("존재하지 않는 데이터 입니다.");

		/** 모니터리여부 초기값 세팅 */
		if(mngrVo.getMonitoringYN() == null) {
			mngrVo.setMonitoringYN("Y");
		}

		model.addAttribute("mngrVo", mngrVo);

		return apiTilesView(request);
	}

	/**
	 * 매니저관리 등록 화면
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/insertMngr.do", method = RequestMethod.GET)
	public String insertMngrView(HttpServletRequest request, Model model) {

		MngrVo mngrVo = new MngrVo();
		/** 모니터리여부 초기값 세팅 */
		mngrVo.setMonitoringYN("Y");

		model.addAttribute("mngrVo", mngrVo);

		return apiTilesView(request, "insertMngr");
	}

	/**
	 * 매니저관리 등록 프로세스
	 *
	 * @param request
	 * @param model
	 * @param MngrVo
	 * @return
	 */
	@RequestMapping(value="/insertMngr.do", method=RequestMethod.POST)
	@OperateLog(action = "매니저 등록", desc = "매니저 정보 등록 처리", params = { "mngrVo" }, actionType = ActionType.INSERT)
	@ResponseBody
	public ProcResultVo insertMngr(@ModelAttribute("mngrVo") MngrVo mngrVo, BindingResult bindResult) throws Exception{

		// validate 체크
		ProcResultVo result = getBindingResult(mngrVo, bindResult, InsertProc.class);

		if (result.isSuccess()) {
			/** 사용자 세팅 */
			mngrVo.setRegUserNm(getUserName());

			/** 등록일자 세팅 */
			mngrVo.setRegDt(DateUtil.getCurrentDate());

			/** ID Generation Service : 구분자, 지역: 대전 / 존: C / 망: 인터넷망 / 스택: 컴퓨팅 / 매니저버전: EVM_4.0 / 순번: 1001 ~*/

			/** 망 코드 조회 */
			List<NetVo> netItems = netService.selectNetAllList();
			String netClCd="";
			mngrVo.setNetCd(mngrVo.getNetId());
            for(int j=0; j<netItems.size();j++){
				if(netItems.get(j).getNetId().equals(mngrVo.getNetId())){
					netClCd = netItems.get(j).getNetClCd();
				}
			}

            mngrVo.setNetId(netClCd);
			mngrVo.set_id(commonService.selectSeqNum("COUCH_STACKMNGR", mngrVo.getRegionId()+"_"+mngrVo.getZoneId()+"_"+netClCd+"_"+mngrVo.getStackClCd()+"_"+mngrVo.getMngrVerCd()+"_"));

			mngrService.insertMngr(mngrVo);

			result.addMessage("저장되었습니다.");
			result.setProcType("insert");
		}

		return result;
	}

	/**
	 * 매니저관리 수정 프로세스
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/updateMngr.do", method=RequestMethod.POST)
	@OperateLog(action = "매니저 수정", desc = "매니저 정보 수정 처리", params = { "mngrVo" }, actionType = ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateMngr(@ModelAttribute("mngrVo") MngrVo mngrVo, BindingResult bindResult) throws Exception{
		// validate 체크
		ProcResultVo result = getBindingResult(mngrVo, bindResult, InsertProc.class);

		if (result.isSuccess()) {
			/** 사용자 세팅 */
			mngrVo.setRegUserNm(getUserName());

			/** 등록일자 세팅 */
			mngrVo.setRegDt(DateUtil.getCurrentDate());

			mngrService.updateMngr(mngrVo);

			result.addMessage("수정되었습니다.");
			result.setProcType("update");
		}

		return result;
	}

	/**
	 * 매니저정보 삭제 프로세스
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/deleteMngr.do", method=RequestMethod.POST)
	@OperateLog(action = "매니저 삭제", desc = "매니저 정보 삭제 처리", params = { "mngrVo" }, actionType = ActionType.DELETE)
	@ResponseBody
	public ProcResultVo deleteMngr(@ModelAttribute("mngrVo") MngrVo mngrVo, BindingResult bindResult) throws Exception{

		// 결과 return Vo
		ProcResultVo result = new ProcResultVo();

		mngrService.deleteMngr(mngrVo);

		result.addMessage("삭제되었습니다.");
		result.setProcType("delete");

		return result;
	}

	/**
	 * 매니저정보 일괄/선택 삭제 프로세스
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/deleteChkMngr.do", method=RequestMethod.POST)
	@OperateLog(action = "매니저 일괄/선택 삭제", desc = "매니저 정보 일괄/선택 삭제 처리", params = { "mngrVo" }, actionType = ActionType.DELETE)
	@ResponseBody
	public ProcResultVo deleteChkMngr(@ModelAttribute("mngrVo") MngrVo mngrVo, BindingResult bindResult) throws Exception{

		List<String> delKeys = mngrVo.getDelKey();
		List<String> delRevs = mngrVo.getDelRev();

		for (int i = 0; i < delKeys.size(); i++) {
			MngrVo vo = new MngrVo();

			vo = mngrService.selectMngr(delKeys.get(i));
			vo.setStackMngrId(delKeys.get(i));
			vo.setRev(delRevs.get(i));

			mngrService.deleteMngr(vo);
		}

		// 결과 return Vo
		ProcResultVo result = new ProcResultVo();

		result.addMessage("삭제되었습니다.");
		result.setProcType("delete");

		return result;
	}

	/**
	 * 매니저정보 엑셀다운로드
	 * @param request
	 * @param response
	 * @param searchVo
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	@RequestMapping(value = "/selectMngrListXlsDwnl.do")
    public void selectMngrListXlsDwnl(HttpServletRequest request, HttpServletResponse response, MngrSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

		// 목록조회
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo = searchVo.getPaginationInfo();
		paginationInfo.setRecordCountPerPage(9999);
		searchVo.setPaginationInfo(paginationInfo);
		List<MngrVo> list = mngrService.selectMngrList(searchVo);
        // CusomSheet 생성
        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // 첫번째 Sheet Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();

        header.put("regionNm", "지역");
        header.put("ZoneNm", "Zone");
        header.put("netNm", "망");
        header.put("stackClNm", "스택분류");
        header.put("mngrClNm", "매니저분류");
        //header.put("mngrVerNm", "매니저버전");
        header.put("nowVerNm", "매니저버전");
        header.put("mngrNm", "매니저명");
        header.put("hostAddr", "호스트 주소");
        header.put("mngrId", "매니저ID");
        header.put("mngrPw", "매니저비밀번호");
        header.put("virtlCnsleAccesIp", "가상접근콘솔IP");
        header.put("virtlCnsleAccesPort", "가상접근콘솔PORT");
        header.put("regUserNm", "등록자명");
        header.put("regDt", "등록일자");
        header.put("dc", "설명");
        header.put("monitoringYN", "수집여부");

        // Sheet Vo 생성
        List<MngrVo> datas = new ArrayList<MngrVo>();
        for (MngrVo mngrVo : list) {
        	MngrVo vo = new MngrVo();

        	vo.setRegionNm(mngrVo.getRegionNm());
        	vo.setZoneNm(mngrVo.getZoneNm());
        	vo.setNetNm(mngrVo.getNetNm());
        	vo.setStackClNm(mngrVo.getStackClNm());
        	vo.setMngrClNm(mngrVo.getMngrClNm());
        	//vo.setMngrVerNm(mngrVo.getMngrVerNm());
        	vo.setNowVerNm(mngrVo.getNowVerNm());
        	vo.setMngrNm(mngrVo.getMngrNm());
        	vo.setHostAddr(mngrVo.getHostAddr());
        	vo.setMngrId(mngrVo.getMngrId());
        	vo.setMngrPw(mngrVo.getMngrPw());
        	vo.setVirtlCnsleAccesIp(mngrVo.getVirtlCnsleAccesIp());
        	vo.setVirtlCnsleAccesPort(mngrVo.getVirtlCnsleAccesPort());
        	vo.setRegUserNm(mngrVo.getRegUserNm());
        	vo.setRegDt(mngrVo.getRegDt());
        	vo.setDc(mngrVo.getDc());
        	vo.setMonitoringYN(mngrVo.getMonitoringYN());

            datas.add(vo);
        }

        // Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("MngrVo");
        sheet.setDatas(datas);
        sheet.setHreader(header);

        sheets.add(sheet);

        // Excel 생성
        ExcelUtil.downloadExcel(response, String.format("Mngr_%s", (new SimpleDateFormat("yyyyMMddhhmmss")).format(new Date())), sheets);
    }

}