/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SlaRprtController.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.slaRprt.web;

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

import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqMngService;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngVo;
import ncis.cpt.opr.req.slaRprt.service.SlaRprtService;
import ncis.cpt.opr.req.slaRprt.vo.SlaRprtSearchVo;
import ncis.cpt.opr.req.slaRprt.vo.SlaRprtVo;
import ncis.cpt.sys.code.vo.CodeSearchVo;
import ncis.cpt.sys.code.vo.CodeVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 이화영
 *
 */
@Controller
@RequestMapping(value="/cpt/opr/req/slaRprt")
public class SlaRprtController extends BaseController{

	@Resource(name="slaRprtService")
	SlaRprtService slaRprtService;

	@Resource(name="rsrcReqMngService")
	RsrcReqMngService rsrcReqMngService;

	@Resource(name = "commonService")
	CommonService commonService;

	/**
	 * SLA리포트 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectSlaRprt.do")
	public String selectSlaRprt(HttpServletRequest request, Model model, SlaRprtSearchVo searchVo ){

		if("".equals(searchVo.getSearchTime()) || searchVo.getSearchTime() == null){
			searchVo.setSearchTime("03");
		}

		SlaRprtVo slaRprtVo = slaRprtService.selectSlaRprt(searchVo);

		List<RsrcReqMngVo> list = null;

		RsrcReqMngSearchVo rsrcReqMngSearchVo = new RsrcReqMngSearchVo();
	    rsrcReqMngSearchVo.setRsrcReqDtStrt(searchVo.getSearchStartRegDt());
	    rsrcReqMngSearchVo.setRsrcReqDtEnd(searchVo.getSearchEndRegDt());
	    rsrcReqMngSearchVo.setRsrcReqTyCd(searchVo.getRsrcReqTyCd());
	    rsrcReqMngSearchVo.setReqInstitutionId(searchVo.getInstitutionId());
	    rsrcReqMngSearchVo.setPaginationInfo(searchVo.getPaginationInfo());



		if( null != rsrcReqMngSearchVo.getRsrcReqTyCd() && !"".equals(rsrcReqMngSearchVo.getRsrcReqTyCd()) ) {
            list = rsrcReqMngService.selectRsrcReqList(rsrcReqMngSearchVo);
		}

        model.addAttribute("list", list);
        model.addAttribute("rsrcReqMngSearchVo", rsrcReqMngSearchVo);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("slaRprtVo", slaRprtVo);

		return portalTilesView(request);
	}

	/**
	 * 자원요청 목록 정보 Excel Down
	 * @param request
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/selectSLAListXlsDwnl.do")
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response, SlaRprtSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //Header 생성
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

        RsrcReqMngSearchVo rsrcReqMngSearchVo = new RsrcReqMngSearchVo();
	    rsrcReqMngSearchVo.setRsrcReqDtStrt(searchVo.getSearchStartRegDt());
	    rsrcReqMngSearchVo.setRsrcReqDtEnd(searchVo.getSearchEndRegDt());
	    rsrcReqMngSearchVo.setRsrcReqTyCd(searchVo.getRsrcReqTyCd());
	    rsrcReqMngSearchVo.setReqInstitutionId(searchVo.getInstitutionId());
	    rsrcReqMngSearchVo.setPaginationInfo(searchVo.getPaginationInfo());

        List<RsrcReqMngVo> list = rsrcReqMngService.selectRsrcReqExcelList(rsrcReqMngSearchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("자원요청관리");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("자원요청목록_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
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
	public ProcResultVo selectRsrcReqTyCdList(SlaRprtSearchVo searchVo) {
		ProcResultVo result = new ProcResultVo();

		CodeSearchVo codeSearchVo = new CodeSearchVo();
		codeSearchVo.setSearchParentCd("107");
		codeSearchVo.setSearchParentGrpCd("008");
		codeSearchVo.setSearchWhole(true);

		if (!"".equals(searchVo.getSearchrSrcReqClCd())) {
			codeSearchVo.setSearchExtra1(searchVo.getSearchrSrcReqClCd());
		}

		List<CodeVo> list = commonService.selectCodeList(codeSearchVo); // 자원요청유형코드
		result.setData(list);
		return result;
	}
}
