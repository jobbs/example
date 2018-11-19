/**
 * copyright 2016 NCIS Cloud api-gateway System
 * @description
 * <pre></pre>
 *
 * @filename OpenApiController.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 11.
 * @lastmodified 2016. 10. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 11.     박희택         v1.0             최초생성
 *
 */
package ncis.api.opapi.opapi.web;

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

import ncis.api.opapi.authr.service.AuthrService;
import ncis.api.opapi.authr.vo.AuthrSearchVo;
import ncis.api.opapi.authr.vo.AuthrVo;
import ncis.api.opapi.opapi.service.OpenApiService;
import ncis.api.opapi.opapi.vo.OpenApiSearchVo;
import ncis.api.opapi.opapi.vo.OpenApiVo;
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.DateUtil;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
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
 * @author 박희택
 *
 */
@Controller
@RequestMapping(value="/api/opapi/opapi")
public class OpenApiController extends BaseController {

	@Resource(name="openApiService")
	OpenApiService openApiService;

	@Resource(name="commonService")
	CommonService commonService;

	@Resource(name="authrService")
	AuthrService authrService;

	/**
	 * OpenAPI 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectOpenApiList.do")
	public String selectOpenApiList(HttpServletRequest request, Model model, OpenApiSearchVo searchVo) throws Exception {

		/** OpenAPI 목록 조회 */
		List<OpenApiVo> list = openApiService.selectOpenApiList(searchVo);

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);


		return apiTilesView(request);
	}

	/**
	 * OpenAPI 상세 조회
	 * @param request
	 * @param model
	 * @param institutionId
	 * @return
	 */
	@RequestMapping(value="/selectOpenApi.do")
	public String selectOpenApi(HttpServletRequest request, Model model, @RequestParam("opApiId") String opApiId) throws Exception {

		OpenApiVo openApiVo = openApiService.selectOpenApi(opApiId);
		if (null == openApiVo) throw new DataNotFoundException("존재하지 않는 데이터 입니다.");

		model.addAttribute("openApiVo", openApiVo);

		return apiTilesView(request);
	}

	/**
	 * OpenAPI 등록 화면
	 *
	 * @param boardId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/insertOpenApi.do", method = RequestMethod.GET)
	public String insertOpenApiView(HttpServletRequest request, Model model) {

		model.addAttribute("vo", new OpenApiVo());

		return apiTilesView(request, "insertOpenApi");
	}

	/**
	 * OpenAPI 등록 프로세스
	 * @param request
	 * @param model
	 * @param openApiVo
	 * @return
	 */
	@RequestMapping(value="/insertOpenApi.do", method=RequestMethod.POST)
	@OperateLog(action = "OpenAPI 등록", desc = "OpenAPI 등록 처리", params = { "vo" }, actionType = ActionType.INSERT)
	@ResponseBody
	public ProcResultVo insertOpenApi(@ModelAttribute("vo") OpenApiVo openApiVo, BindingResult bindResult) throws Exception{

		// validate 체크
		ProcResultVo result = getBindingResult(openApiVo, bindResult, InsertProc.class);

		if (result.isSuccess()) {


			/** 전체 OpenAPI 조회 */
			OpenApiSearchVo openApiSearchVo = new OpenApiSearchVo();
			List<OpenApiVo> openApiList = openApiService.selectOpenApiList(openApiSearchVo);

			int chkCnt = 0;
			for (OpenApiVo chkVo : openApiList) {
				if(openApiVo.getUri().equals(chkVo.getUri()) && openApiVo.getRegionId().equals(chkVo.getRegionId())){
					chkCnt++;
				}
			}

			if(chkCnt > 0){
				result.addMessage("이미 존재하는 URI 입니다.");
			}else{
				/** 사용자 세팅 */
				openApiVo.setRegUserNm(getUserName());

				/** 등록일자 세팅 */
				openApiVo.setRegDt(DateUtil.getCurrentDate());
				int year = DateUtil.getCurrentYear();

				/** ID Generation Service : 구분자, 업무구분_년도_001 ~*/
				openApiVo.set_id(commonService.selectSeqNum("COUCH_OPENAPI", "OPENAPI_"+year+"_"));

				openApiService.insertOpenApi(openApiVo);

				result.addMessage("저장되었습니다.");
				result.setProcType("insert");
			}
		}

		return result;
	}

	/**
	 * OpenAPI 수정 프로세스
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/updateOpenApi.do", method=RequestMethod.POST)
	@OperateLog(action = "OpenAPI 수정", desc = "OpenAPI 수정 처리", params = { "openApiVo" }, actionType = ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateOpenApi(@ModelAttribute("openApiVo") OpenApiVo openApiVo, BindingResult bindResult) throws Exception{

		// validate 체크
		ProcResultVo result = getBindingResult(openApiVo, bindResult, InsertProc.class);
		boolean check = false;

		if (result.isSuccess()) {

			// 사용여부 체크 호출
			check = useCheck(openApiVo.getOpApiId());

			if(check){
				result.addMessage("사용중인 OpenAPI 입니다. \n 사용중인 권한의 OpenApi를 변경해야 합니다");
				result.setProcType("using");
			}else{
				/** 전체 OpenAPI 조회 */
				OpenApiSearchVo openApiSearchVo = new OpenApiSearchVo();
				List<OpenApiVo> openApiList = openApiService.selectOpenApiList(openApiSearchVo);

				int chkCnt = 0;
				for (OpenApiVo chkVo : openApiList) {
					if(openApiVo.getUri().equals(chkVo.getUri()) && openApiVo.getRegionId().equals(chkVo.getRegionId()) && !openApiVo.getOpApiId().equals(chkVo.getOpApiId())){
						chkCnt++;
					}
				}

				if(chkCnt > 0){
					result.addMessage("이미 존재하는 URI 입니다.");
				}else{
					/** 사용자 세팅 */
					openApiVo.setRegUserNm(getUserName());

					/** 등록일자 세팅 */
					openApiVo.setRegDt(DateUtil.getCurrentDate());

					openApiService.updateOpenApi(openApiVo);

					result.addMessage("수정되었습니다.");
					result.setProcType("update");
				}
			}
		}

		return result;
	}

	/**
	 * OpenAPI 삭제 프로세스
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/deleteOpenApi.do", method=RequestMethod.POST)
	@OperateLog(action = "OpenAPI 삭제", desc = "OpenAPI 삭제 처리", params = { "openApiVo" }, actionType = ActionType.DELETE)
	@ResponseBody
	public ProcResultVo deleteOpenApi(@ModelAttribute("openApiVo") OpenApiVo openApiVo, BindingResult bindResult) throws Exception{

		boolean check = false;

		// 결과 return Vo
		ProcResultVo result = new ProcResultVo();

		// 사용여부 체크 호출
		check = useCheck(openApiVo.getOpApiId());

		if(check){
			result.addMessage("사용중인 OpenAPI 입니다. \n 사용중인 권한의 OpenAPI를 변경해야 합니다");
			result.setProcType("using");
		}else{
			openApiService.deleteOpenApi(openApiVo);
			result.addMessage("삭제되었습니다.");
			result.setProcType("delete");
		}

		return result;
	}

	/**
	 * OpenAPI 일괄/선택 삭제 프로세스
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/deleteChkOpenApi.do", method=RequestMethod.POST)
	@OperateLog(action = "OpenAPI 일괄/선택 삭제", desc = "OpenAPI 일괄/선택 삭제 처리", params = { "openApiVo" }, actionType = ActionType.DELETE)
	@ResponseBody
	public ProcResultVo deleteChkOpenApi(@ModelAttribute("openApiVo") OpenApiVo openApiVo, BindingResult bindResult) throws Exception{

		List<String> delKeys = openApiVo.getDelKey();
		List<String> delRevs = openApiVo.getDelRev();
		boolean check = false;
		int checkCnt = 0;

		// 사용여부 체크
		for(int i=0; i < delKeys.size(); i++ ) {
			OpenApiVo vo = new OpenApiVo();
			vo.setOpApiId(delKeys.get(i));
			vo.setRev(delRevs.get(i));

			// 사용여부 체크 호출
			check = useCheck(vo.getOpApiId());
			if(check){
				checkCnt++;
			}
		}

		// 결과 return Vo
		ProcResultVo result = new ProcResultVo();

		if(checkCnt > 0){
			result.addMessage("사용중인 OpenAPI 입니다. \n 사용중인 권한의 OpenAPI를 변경해야 합니다");
		}else{

			// 삭제처리
			for(int i=0; i < delKeys.size(); i++ ) {
				OpenApiVo vo = new OpenApiVo();
				vo.setOpApiId(delKeys.get(i));
				vo.setRev(delRevs.get(i));
				OpenApiVo checkVo = openApiService.selectOpenApi(vo.getOpApiId());
				vo.setRegionId(checkVo.getRegionId());

				openApiService.deleteOpenApi(vo);
			}
			result.addMessage("삭제되었습니다.");
		}

		result.setProcType("delete");

		return result;
	}

	/**
	 * OpenAPI 엑셀다운로드
	 * @param request
	 * @param response
	 * @param searchVo
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	@RequestMapping(value = "/selectOpenApiListXlsDwnl.do")
    public void selectOpenApiListXlsDwnl(HttpServletRequest request, HttpServletResponse response, OpenApiSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

		// 목록조회
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo = searchVo.getPaginationInfo();
		paginationInfo.setRecordCountPerPage(9999);
		searchVo.setPaginationInfo(paginationInfo);
		List<OpenApiVo> list = openApiService.selectOpenApiList(searchVo);
        // CusomSheet 생성
        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // 첫번째 Sheet Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("regionNm", "센터");
        header.put("opApiNm", "openApi명");
        header.put("uri", "URI");
        header.put("svcDscvryYn", "서비스Discovery사용여부");
        header.put("targetHstAddr", "targetHost주소");
        header.put("statCd", "상태");
        header.put("regUserNm", "등록자명");
        header.put("regDt", "등록일자");
        header.put("dc", "설명");

        // Sheet Vo 생성
        List<OpenApiVo> datas = new ArrayList<OpenApiVo>();
        for (OpenApiVo openApiVo : list) {
        	OpenApiVo vo = new OpenApiVo();

        	vo.setRegionNm(openApiVo.getRegionNm());
    		vo.setOpApiNm(openApiVo.getOpApiNm());
    		vo.setUri(openApiVo.getUri());
    		vo.setSvcDscvryYn(openApiVo.getSvcDscvryYn());
    		vo.setTargetHstAddr(openApiVo.getTargetHstAddr());
    		if(openApiVo.getStatCd().equals("Y")){
    			vo.setStatCd("활성");
    		}else if(openApiVo.getStatCd().equals("N")){
    			vo.setStatCd("비활성");
    		}
    		vo.setRegUserNm(openApiVo.getRegUserNm());
    		vo.setRegDt(openApiVo.getRegDt());
    		vo.setDc(openApiVo.getDc());

            datas.add(vo);
        }

        // Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("OpenApiVo");
        sheet.setDatas(datas);
        sheet.setHreader(header);

        sheets.add(sheet);

        // Excel 생성
        ExcelUtil.downloadExcel(response, String.format("OpenApi_%s", (new SimpleDateFormat("yyyyMMddhhmmss")).format(new Date())), sheets);
    }


	/**
	 * OpenAPI 사용여부 체크
	 * @param openApiId
	 * @throws Exception
	 */
	public boolean useCheck(String opApiId) throws Exception{

		boolean check = false;

		/** OpenAPI 권한 목록 조회 */
		AuthrSearchVo searchVo = new AuthrSearchVo();
		List<AuthrVo> list = authrService.selectAuthrList(searchVo);

		/** OpenAPI URL 정보조회 */
		OpenApiVo uriChkVo = openApiService.selectOpenApi(opApiId);

		for(int k=0; k< list.size();k++){
			List<String> uri = list.get(k).getApiMapng();
			if(uri != null){
				for(int j=0;j <uri.size(); j++){
					if((opApiId+"&"+uriChkVo.getUri()).equals(uri.get(j))){
						check = true;
					}
				}
			}

		}

		return check;
	}
}
