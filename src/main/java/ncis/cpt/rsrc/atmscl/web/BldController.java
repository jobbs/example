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

import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.rsrc.atmscl.service.BldService;
import ncis.cpt.rsrc.atmscl.vo.BldSearchVo;
import ncis.cpt.rsrc.atmscl.vo.BldVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;

import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/cpt/rsrc/atmscl/bld")
public class BldController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(BldController.class);

	@Resource(name="bldService")
	BldService bldService;

	@Resource(name="commonService")
	CommonService commonService;


	/**
	 * 빌드 목록 조회
	 * @param request
	 * @param model
	 * @param bldVo
	 * @return
	 */

	@RequestMapping(value="/selectBldList.do")
	public String selectBldList(HttpServletRequest request,Model model ,BldSearchVo bldSearchVo){
		List<CodeVo> selectCodeList = commonService.selectCodeList("111", "312");
		List<BldVo> list = bldService.selectBldList(bldSearchVo);
		model.addAttribute("list", list);
		model.addAttribute("bldVo", bldSearchVo);
		model.addAttribute("selectCodeList", selectCodeList);
		return portalTilesView(request);
	}

    /**
     * 빌드 목록 엑셀 다운로드
     *
     * @param request
     * @param model
     * @param bldSearchVo
     * @return
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    @RequestMapping(value = "/selectBldListXlsDwnl.do")
    public void selectBldListXlsDwnl(HttpServletRequest request, HttpServletResponse response, Model model, BldSearchVo bldSearchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<BldVo> bldVoList = bldService.selectBldList(bldSearchVo);

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("bldStatCd", "빌드상태");
        header.put("institutionNm", "부처");
        header.put("jobNm", "업무");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망구분");
        header.put("rsrcPoolNm", "자원풀");
        header.put("servcNm", "서비스명");
        header.put("creImgNm", "빌드이미지명");
        header.put("lastBldVer", "빌드버전");
        header.put("creDttm", "생성일");


        for (int i = 0; i < bldVoList.size(); i++) {
            if(null != bldVoList.get(i).getBldStatCd()){
            	switch (bldVoList.get(i).getBldStatCd()) {
				case "01":
					bldVoList.get(i).setBldStatCd("진행중");
					break;
				case "02":
					bldVoList.get(i).setBldStatCd("완료");
					break;
				case "03":
					bldVoList.get(i).setBldStatCd("실패");
					break;
				case "04":
					bldVoList.get(i).setBldStatCd("취소");
					break;
				case "05":
					bldVoList.get(i).setBldStatCd("New");
					break;
				case "06":
					bldVoList.get(i).setBldStatCd("Pending");
					break;
				case "07":
					bldVoList.get(i).setBldStatCd("오류");
					break;
				case "08":
					bldVoList.get(i).setBldStatCd("기타");
					break;
				}
            }
        }

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("빌드");
        sheet.setDatas(bldVoList);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("빌드_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }
    /**
   	 * 빌드 목록 조회(팝업)
   	 * @param request
   	 * @param model
   	 * @param bldVo
   	 * @return
   	 */

   	@RequestMapping(value="/selectBldListP.do")
   	public String selectBldListP(HttpServletRequest request,Model model ,BldSearchVo bldSearchVo){
   		List<BldVo> list = bldService.selectBldList(bldSearchVo);
   		model.addAttribute("list", list);
   		model.addAttribute("bldVo", bldSearchVo);
   		return popup(request);
   	}

   	/**
	 * 빌드 상세 조회
	 * @param request
	 * @param model
	 * @param bldVo
	 * @return
	 */
	@RequestMapping(value="/selectDetailBld.do")
	public String updateBldView(HttpServletRequest request, Model model, @RequestParam(required=true) Integer servcSeq,@RequestParam(required=true) String bldId, @RequestParam(required=true) Integer servcAreaSeq) throws Exception {

		try {
			List<CodeVo> selectCodeList = commonService.selectCodeList("111", "312");
			String userId = getUserId();
			//빌드 상세 정보
			List<BldVo> updateBld = bldService.selectDetailBld(servcSeq,bldId,userId);
			model.addAttribute("bldVo", updateBld);
			model.addAttribute("selectCodeList", selectCodeList);

			List<BldVo> selectScrtky = bldService.selectScrtky(servcAreaSeq);
			model.addAttribute("selectScrtky", selectScrtky);
		}
		catch(IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException ne) { logger.error(ne.getMessage(), ne); }


		return portalTilesView(request);
	}
	 /**
		 * 빌드 처리
		 * @param request
		 * @param bldVo
		 * @return
		 */
		@RequestMapping(value="/bldRun.do", method=RequestMethod.POST)
		@ResponseBody
		public ProcResultVo bldRun(BldVo bldVo,BindingResult bindResult	) throws Exception{
			bldVo.setUpdtUserId(getUserId());
			ProcResultVo result = getBindingResult(bldVo, bindResult, InsertProc.class,UpdateProc.class);
			if(result.isSuccess()){
				result = bldService.bldRun(bldVo);
			}

			return result;

		}
		 /**
		 * 빌드 상태 조회 처리
		 * @param request
		 * @param bldVo
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="/selectBldStat.do", method=RequestMethod.GET)
		@ResponseBody
		public ProcResultVo selectBldStat(BldVo bldVo,BindingResult bindResult	) throws Exception{
			bldVo.setUpdtUserId(getUserId());
			ProcResultVo result = getBindingResult(bldVo, bindResult, InsertProc.class,UpdateProc.class);
			if(result.isSuccess()){
				bldVo.setUpdtUserId(getUserId());
				AtmSclResultIfVo selectBldStat = bldService.selectBldStat(bldVo);
				try {
					if("Y".equals(selectBldStat.getSuccYn())){
						result.setSuccess(true);
						result.setProcType("update");
					}
				} catch (BadSqlGrammarException e) {
					result.setSuccess(false);
					result.addMessage("빌드 상태 조회 처리를  실패했습니다.");
				}

			}else{
				result.setSuccess(false);
				result.addMessage("빌드 상태 조회 처리를  실패했습니다.");
			}

			return result;

		}
		/**
		 * 빌드설정 저장 처리
		 * @param request
		 * @param bldVo
		 * @return
		 */
		@OperateLog(action="빌드설정 저장", desc="빌드설정 저장 처리", params={"bldVo"}, actionType=ActionType.UPDATE)
		@RequestMapping(value="/updateBld.do", method=RequestMethod.POST)
		@ResponseBody
		public ProcResultVo updateBld(@ModelAttribute("bldVo") BldVo bldVo,BindingResult bindResult	) throws Exception{
			bldVo.setUpdtUserId(getUserId());
			ProcResultVo result = getBindingResult(bldVo, bindResult,UpdateProc.class);
			if(result.isSuccess()){
				try {

					bldService.updateRxBldConf(bldVo);
					result.setSuccess(true);
					result.setProcType("update");
					result.addMessage("빌드설정 정보 저장에 성공했습니다.");
				} catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
					result.setSuccess(false);
					result.addMessage("빌드설정 정보 저장에 실패했습니다."+e.getMessage());
				}
			}else{
				result.setSuccess(false);
				result.addMessage("빌드설정 정보 저장에 실패했습니다.");
			}

			return result;

		}
}
