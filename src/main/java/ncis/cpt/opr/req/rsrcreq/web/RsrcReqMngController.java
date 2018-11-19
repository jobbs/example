package ncis.cpt.opr.req.rsrcreq.web;

import java.io.File;
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

import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.FileManageUtil;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqMngService;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngVo;
import ncis.cpt.sys.code.vo.CodeSearchVo;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/cpt/opr/req/rsrcreq")
public class RsrcReqMngController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(RsrcReqMngController.class);

	@Resource(name = "rsrcReqMngService")
	RsrcReqMngService rsrcReqMngService;

	@Resource(name = "commonService")
	CommonService commonService;

	/**
	 * 자원요청 목록 조회
	 *
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value = "/selectRsrcReqList.do")
	public String selectRsrcReqList(HttpServletRequest request, Model model, RsrcReqMngSearchVo searchVo) {

		List<RsrcReqMngVo> list = rsrcReqMngService.selectRsrcReqList(searchVo);

		List<CodeVo> rsrcReqPrcssStatCdList = commonService.selectCodeList("007", "106", true); // 자원요청상태코드

		model.addAttribute("rsrcReqPrcssStatCdList", rsrcReqPrcssStatCdList);
		model.addAttribute("list", list);

		model.addAttribute("searchVo", searchVo);
		return portalTilesView(request);
	}

	/**
	 * 자원요청 목록 정보 Excel Down
	 *
	 * @param request
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/excelDownRsrcReqList.do")
	public void downloadExcel(HttpServletRequest request, HttpServletResponse response, RsrcReqMngSearchVo searchVo)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

		// CusomSheet 생성
		List<CustomSheet> sheets = new ArrayList<CustomSheet>();

		// Header 생성
		Map<String, String> header = new LinkedHashMap<String, String>();
		header.put("rsrcReqPrcssStatNm", "상태");
		header.put("rsrcReqClNm", "구분");
		header.put("sbjct", "제목");
		header.put("ticktNo", "티켓번호");
		header.put("rsrcReqNo", "요청번호");
		header.put("rsrcReqTyNm", "요청유형");
		header.put("reqInstitutionNm", "요청기관");
		header.put("rsrcReqUsrNm", "요청자");
		header.put("rsrcReqDttm", "요청일시");
		header.put("exeUserNm", "실행자");
		header.put("comptDttm", "완료일시");

		List<RsrcReqMngVo> list = rsrcReqMngService.selectRsrcReqExcelList(searchVo);

		CustomSheet sheet = new CustomSheet();
		sheet.setSheetName("자원요청관리");
		sheet.setDatas(list);
		sheet.setHreader(header);
		sheets.add(sheet);

		ExcelUtil.downloadExcel(response,
				String.format("자원요청관리_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
	}

	/**
	 * 자원요청건 삭제
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateRsrcReqDeleteYn.do", method = RequestMethod.POST)
	@OperateLog(action = "자원요청건 삭제여부 수정", desc = "자원요청건 삭제여부 수정 처리", params = {
			"RsrcReqMngVo" }, actionType = ActionType.DELETE)
	@ResponseBody
	public ProcResultVo updateRsrcReqDeleteYn(HttpServletRequest request,
			@ModelAttribute("rsrcReqMngVo") RsrcReqMngVo rsrcReqMngVo) throws Exception {

		ProcResultVo result = new ProcResultVo();
		result.setProcType("update");
		try {
			rsrcReqMngVo.setDelUserId(getUserId());
			rsrcReqMngService.updateRsrcReqDeleteYn(rsrcReqMngVo);
			result.setSuccess(true);
			result.addMessage("정상적으로 삭제하였습니다");
		}catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
			logger.error(e.getMessage(), e);
			result.setSuccess(false);
			result.addMessage("삭제에 실패하였습니다.");
		}

		return result;
	}

	/**
	 * 자원요청 유형코드 목록 조회
	 *
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value = "/selectRsrcReqTyCdList.do")
	@ResponseBody
	public ProcResultVo selectRsrcReqTyCdList(RsrcReqMngSearchVo searchVo) {
		ProcResultVo result = new ProcResultVo();

		CodeSearchVo codeSearchVo = new CodeSearchVo();
		codeSearchVo.setSearchParentCd("107");
		codeSearchVo.setSearchParentGrpCd("008");
		codeSearchVo.setSearchWhole(true);

		if (!"".equals(searchVo.getRsrcReqClCd())) {
			codeSearchVo.setSearchExtra1(searchVo.getRsrcReqClCd());
		}

		List<CodeVo> list = commonService.selectCodeList(codeSearchVo); // 자원요청유형코드
		result.setData(list);
		return result;
	}

	/**
	 * 자동확장 요청 화면
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/insertRsrcReqAtmSclView.do", method = RequestMethod.GET)
	public String insertServcArea(HttpServletRequest request, Model model) {

		List<RsrcReqMngVo> regionList = rsrcReqMngService.selectRegionList(getUserId());

		model.addAttribute("rsrcReqMngVo", new RsrcReqMngVo());
		model.addAttribute("regionList", regionList);
		return portalTilesView(request, "insertRsrcReqAtmScl");
	}



	/**
	 * 자동확장 요청 수정  조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/updateRsrcReqAtmScl.do")
	public String updateRsrcReqAtmScl(HttpServletRequest request, Model model, @RequestParam(required=true) String schRsrcReqNo) throws Exception {

		RsrcReqMngVo rsrcReqMngVo = rsrcReqMngService.selectRsrcReq(schRsrcReqNo);

		if( ObjectUtils.isEmpty(rsrcReqMngVo) ) {
            throw new DataNotFoundException(messageUtil.getMessage("message.error.dataNotFound"));
        }

		model.addAttribute("rsrcReqMngVo", rsrcReqMngVo);

		return portalTilesView(request);
	}



	/**
	 * 자동확장 요청 등록
	 *
	 * @param rsrcReqMngVo
	 * @return
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@RequestMapping(value = "/insertRsrcReqMngAtmScl.do", method = RequestMethod.POST)
	@OperateLog(action = "지동확장 등록", desc = "자동확장 요청 정보를 등록한다.", params = {
			"rsrcReqMngVo" }, actionType = ActionType.INSERT)
	@ResponseBody
	public ProcResultVo insertRsrcReqAtmScl(@ModelAttribute("rsrcReqMngVo") RsrcReqMngVo rsrcReqMngVo,
			BindingResult bindResult) throws Exception{
		ProcResultVo result = getBindingResult(rsrcReqMngVo, bindResult, InsertProc.class);

		if (result.isSuccess()) {
			try {
				rsrcReqMngVo.setRegUserId(getUserId());
				String resultmessage = rsrcReqMngService.insertRsrcReqAtmScl(rsrcReqMngVo);
				result.setProcType("insert");
				result.addMessage(resultmessage);
				result.setSuccess(true);

			} catch (InstantiationException | IllegalAccessException | IOException e) {
				logger.error(e.getMessage());
				result.addMessage("자동확장 요청 시 오류가 발생하였습니다.");
				result.setSuccess(false);
			}catch(DataNotFoundException e1) {
				logger.error(e1.getMessage(),e1);
				result.setSuccess(false);
				result.addMessage(e1.getMessage());
			}
		}

		return result;
	}

	/**
	 * 자원요청 파일 다운 로드
	 *
	 * @param request
	 * @param response
	 * @param seq
	 * @throws IOException
	 */
	@RequestMapping(value = "/rsrcReqDownfile.do")
	@OperateLog(action = "자원요청 파일 다운로드", desc = "자원요청 파일 다운로드")
	public void rsrcReqDownfile(HttpServletRequest request, HttpServletResponse response, @RequestParam("rsrcReqNo") String rsrcReqNo) throws IOException {

		RsrcReqMngVo rsrcReqMngVo = rsrcReqMngService.selectRsrcReqFileInfo(rsrcReqNo);
		FileManageUtil.downFile(request, response, rsrcReqMngVo.getAtchFilePath()+File.separator+rsrcReqMngVo.getSavAtchFileNm(), rsrcReqMngVo.getOriAtchFileNm());
	}


	/**
	 * 자원요청건 수정
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateRsrcReqExeInfo.do", method = RequestMethod.POST)
	@OperateLog(action = "자원요청 완료", desc = "자원요청건 완료 처리", params = {
			"RsrcReqMngVo" }, actionType = ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateRsrcReqExeInfo(HttpServletRequest request,
			@ModelAttribute("rsrcReqMngVo") RsrcReqMngVo rsrcReqMngVo) throws Exception {

		ProcResultVo result = new ProcResultVo();
		result.setProcType("update");
		try {
			rsrcReqMngVo.setExeUserId(getUserId());
			rsrcReqMngService.updateRsrcReqExeInfo(rsrcReqMngVo);
			result.setSuccess(true);
			result.addMessage("정상적으로 완료되었습니다.");
		}catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
			logger.error(e.getMessage(), e);
			result.setSuccess(false);
			result.addMessage("완료에 실패하였습니다.");
		}

		return result;
	}

}
