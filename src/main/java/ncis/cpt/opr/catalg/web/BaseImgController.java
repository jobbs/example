package ncis.cpt.opr.catalg.web;

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
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.catalg.service.BaseImgService;
import ncis.cpt.opr.catalg.vo.BaseImgSearchVo;
import ncis.cpt.opr.catalg.vo.BaseImgVo;
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
@RequestMapping(value = "/cpt/opr/catalg/baseimg")
public class BaseImgController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(BaseImgController.class);

	@Resource(name = "baseImgService")
	BaseImgService baseImgService;

	@Resource(name = "commonService")
	CommonService commonService;

	/**
	 * 베이스이미지 목록 조회
	 *
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value = "/selectBaseImgList.do")
	public String selectBaseImgList(HttpServletRequest request, Model model, BaseImgSearchVo searchVo) {

		searchVo.setBasImgYn("Y");
		List<BaseImgVo> list = baseImgService.selectBaseImgList(searchVo);

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		return portalTilesView(request);
	}

	/**
	 * 베이스이미지 목록 정보 Excel Down
	 *
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value = "/selectBaseImgListXlsDwnl.do")
	public void selectBaseImgListXlsDwnl(HttpServletRequest request, HttpServletResponse response, BaseImgSearchVo searchVo)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

		// CusomSheet 생성
		List<CustomSheet> sheets = new ArrayList<CustomSheet>();

		// Header 생성
		Map<String, String> header = new LinkedHashMap<String, String>();
		header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망구분");
        header.put("rsrcPoolNm", "자원풀");
		header.put("useYn", "사용여부");
		header.put("imgTyCdNm", "이미지유형");
		header.put("imgNm", "이미지명");
		header.put("imgCapa", "용량(GB)");
		header.put("creUserNm", "생성자");
		header.put("creDttm", "생성일시");
		header.put("updtUserNm", "수정자");
		header.put("updtDttm", "수정일시");
		header.put("rmk", "비고");

		List<BaseImgVo> list = baseImgService.selectBaseImgList(searchVo);

		CustomSheet sheet = new CustomSheet();
		sheet.setSheetName("베이스이미지관리");
		sheet.setDatas(list);
		sheet.setHreader(header);
		sheets.add(sheet);

		ExcelUtil.downloadExcel(response,
				String.format("베이스이미지관리_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
	}


	/**
	 * 베이스이미지  수정  조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectBaseImg.do")
	public String updateBaseImg(HttpServletRequest request, Model model, @RequestParam(required=true) String baseImgRsrcPoolId,  @RequestParam(required=true) String imgId, @RequestParam(required=true) int servcAreaSeq) {

		BaseImgVo baseImgVo = baseImgService.selectBaseImg(baseImgRsrcPoolId, imgId, servcAreaSeq);

		if( ObjectUtils.isEmpty(baseImgVo) ) {
            throw new DataNotFoundException(messageUtil.getMessage("message.error.dataNotFound"));
        }

		model.addAttribute("baseImgVo", baseImgVo);

		return portalTilesView(request);
	}


	/**
	 * 베이스이미지 수정
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateBaseImg.do", method = RequestMethod.POST)
	@OperateLog(action = "베이스이미지 수정", desc = "베이스이미지 수정 처리", params = {
			"RsrcReqMngVo" }, actionType = ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateBaseImg(HttpServletRequest request,
			@ModelAttribute("baseImgVo") BaseImgVo baseImgVo) throws Exception {

		ProcResultVo result = new ProcResultVo();
		result.setProcType("update");

		try {
			baseImgVo.setUpdtUserId(getUserId());
			baseImgService.updateBaseImg(baseImgVo);
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
