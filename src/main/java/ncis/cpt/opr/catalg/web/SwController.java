/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SwController.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2017. 1. 11.
 * @lastmodified 2017. 1. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 1. 11.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.web;

import java.io.File;
import java.io.FileNotFoundException;
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

import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.exception.NotAllowedFileExtException;
import ncis.cmn.util.PropertiesUtil;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.catalg.service.SwService;
import ncis.cpt.opr.catalg.vo.SwSearchVo;
import ncis.cpt.opr.catalg.vo.SwVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 이화영
 *
 */
@Controller
@RequestMapping("/cpt/opr/catalg/sw")
public class SwController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(SwController.class);

	@Resource(name="swService")
	private SwService swService;

	/**
	 * 소프트웨어 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectSwList.do")
	public String selectSwMngList(HttpServletRequest request, Model model, SwSearchVo svo) {

		List<SwVo> list = swService.selectSwMngList(svo);

		model.addAttribute("list", list);
        model.addAttribute("searchVo", svo);

        return portalTilesView(request);
	}

	/**
	 * 소프트웨어 목록 정보 Excel Down
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/selectSwListXlsDwnl.do")
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response, SwSearchVo svo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

	   //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
	    header.put("swNm", "소프트웨어 명");
	    header.put("swVer", "소프트웨어 버전");
	    header.put("swMnfctCo", "소프트웨어 제조사");

        List<SwVo> list = swService.selectSwExcelList(svo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("소프트웨어 목록");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("소프트웨어_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

	/**
	 * 소프트웨어 상세 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectSw.do")
	public String selectSw(HttpServletRequest request, Model model, @RequestParam(required = true) BigDecimal swSeq){

		SwVo swVo = swService.selectSw(swSeq);//소프트웨어 기본정보

        model.addAttribute("swVo", swVo);

        return portalTilesView(request);
	}

	/**
	 * 소프트웨어 등록 화면 호출
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/insertSw.do", method = RequestMethod.GET)
	public String insertSwView(HttpServletRequest request, Model model){

		model.addAttribute("swVo", new SwVo());
		return portalTilesView(request);
	}

	/**
	 * 소프트웨어 등록 프로세스
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/insertSw.do", method = RequestMethod.POST)
	@OperateLog(action = "소프트웨어 등록", desc = "소프트웨어 등록 처리", params = { "swNm", "swVer", "swMnfctCo" }, actionType = ActionType.INSERT)
	@ResponseBody
	public ProcResultVo insertSw(HttpServletRequest request, @ModelAttribute("swVo") SwVo swVo, BindingResult bindResult) {

		ProcResultVo result = getBindingResult(swVo, bindResult, InsertProc.class);

		  if (result.isSuccess()) {
	        	boolean existSw = swService.selectSwInfoCheck(
	        			swVo.getSwNm(),
	        			swVo.getSwVer(),
	        			null
	        		);
	        	if( existSw )
	        		return getFailProcResult("동일한 소프트웨어 정보가 존재합니다.");

	        	swVo.setCreUserId(getUserId());
				swService.insertSw(swVo);
	            result.setProcType("insert");
		  }

	    return result;
	}

	/**
	 * 소프트웨어 수정 화면 호출
	 * @param request
	 * @param swSeq
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateSw.do", method = RequestMethod.GET)
	public String updateSwView(HttpServletRequest request, @RequestParam(required=true)BigDecimal swSeq, Model model) {

		SwVo swVo = swService.selectSw(swSeq);//소프트웨어 기본정보

		if( ObjectUtils.isEmpty(swVo) )
			throw new DataNotFoundException("소프트웨어 데이터가 없습니다.");

		model.addAttribute("swVo", swVo);
		return portalTilesView(request, "insertSw");
	}

	/**
	 * 소프트웨어 수정 프로세스
	 * @param request
	 * @param bindResult
	 * @return
	 */
	@RequestMapping(value = "/updateSw.do", method = RequestMethod.POST)
	@OperateLog(action = "소프트웨어 수정", desc = "소프트웨어 수정 처리", params = { "swNm", "swVer", "swMnfctCo" }, actionType = ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateSw(HttpServletRequest request, @ModelAttribute("swVo") SwVo swVo, BindingResult bindResult) {

		//validation 체크
        ProcResultVo result = getBindingResult(swVo, bindResult, UpdateProc.class);

        if (result.isSuccess()) {

        	boolean existSw = swService.selectSwInfoCheck(
        			swVo.getSwNm(),
        			swVo.getSwVer(),
        			new BigDecimal(swVo.getSwSeq())
        		);
        	if( existSw )
        		return getFailProcResult("동일한 소프트웨어 정보가 존재합니다.");
        		swVo.setUpdtUserId(getUserId());
	        	swService.updateSw(swVo);
	            result.setProcType("update");
        }
	    return result;
	}

	/**
	 * 소프트웨어 삭제 프로세스(list)
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteListSw.do", method = RequestMethod.POST)
	@OperateLog(action = "소프트웨어 삭제", desc = "소프트웨어 삭제 처리", params = { "SwVo" }, actionType = ActionType.DELETE)
	@ResponseBody
	public ProcResultVo deleteListSw(HttpServletRequest request,@ModelAttribute("swVo") SwVo swVo) {

		swService.deleteListSw(swVo);
		return getSuccessProcResult("템플릿에서 사용중인 소프트웨어를 제외하고 삭제하였습니다.", "delete");
	}

	/**
	 * 소프트웨어 삭제 프로세스
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteSw.do", method = RequestMethod.POST)
	@OperateLog(action = "소프트웨어 삭제", desc = "소프트웨어 삭제 처리", params = { "swSeq" }, actionType = ActionType.DELETE)
	@ResponseBody
	public ProcResultVo deleteSw(HttpServletRequest request, @RequestParam(required=true)BigDecimal swSeq) {

		if(swService.selectSwUseYn(swSeq)){
			return getFailProcResult("해당 소프트웨어를 사용중인 템플릿이 존재하여, 삭제할 수 없습니다.");
		}
		swService.deleteSw(swSeq);
		return getSuccessProcResult("소프트웨어를 삭제하였습니다.", "delete");
	}

	/**
	 * SW양식 다운로드
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectSwXlsDwnload.do")
	public void swXlsDwnload(HttpServletRequest request, HttpServletResponse response) throws Exception{

		try{
			swService.exampleFileDwnLoad(request, response);
		}catch(IOException ie){
			logger.error("IOException", ie);
		}catch(Exception e){
			logger.error("Exception", e);
		}
	}

	/**
	 * SW 업로드
	 * @param files
	 * @return
	 */
	@OperateLog(action="소프트웨어 DB 업로드", desc="소프트웨어 DB 업로드 처리", params={"MultipartFile"}, actionType=ActionType.INSERT)
	@RequestMapping(value = "/insertSwXlsUpload.do", method = RequestMethod.POST)
	@ResponseBody
	public ProcResultVo swXlsUpload (@RequestParam(value="files") MultipartFile[] files) throws IOException, FileNotFoundException, InvalidFormatException, NotAllowedFileExtException {

		ProcResultVo result = new ProcResultVo();

		try{

			final String path = PropertiesUtil.getProperty("UPLOAD_FILE_PATH") + "/sw";

			File dir = new File(path);

			if(!dir.exists()){
				boolean bResult = dir.mkdir();
				if(!bResult){
					throw new IOException("mkdir error");
				}
			}

			for(MultipartFile file : files){
				File newFile = new File(path+"/"+file.getOriginalFilename());
				try{
					FileUtils.writeByteArrayToFile(newFile, file.getBytes());
					if(swService.fileUpLoadForm(newFile, getUserId())){
						result.setSuccess(true);
						result.setProcType("insert");
					}else{
						result.setSuccess(false);
						result.addMessage("소프트웨어 업로드에 실패하였습니다.<br>업로드 파일이 양식에 맞는지 확인해주세요.");
					}
				} catch(IOException ie){
					result.setSuccess(false);
					result.addMessage("소프트웨어 업로드에 실패하였습니다.");
					logger.error("IOException", ie);
				} catch (Exception e) {
		        	result.setSuccess(false);
		        	result.addMessage("소프트웨어 업로드에 실패하였습니다.");
		        	logger.error("Exception", e);
		        } finally{
					newFile.delete(); //서버 업로드 파일 삭제
				}

			}
		} catch (NullPointerException ne) {
        	result.setSuccess(false);
        	result.addMessage("소프트웨어 업로드에 실패하였습니다.");
        	logger.error("NullPointerException", ne);
        } catch (RuntimeException re) {
        	result.setSuccess(false);
        	result.addMessage("소프트웨어 업로드에 실패하였습니다.");
        	logger.error("RuntimeException", re);
        } catch (Exception e) {
        	result.setSuccess(false);
        	result.addMessage("소프트웨어 업로드에 실패하였습니다.");
        	logger.error("Exception", e);
        }

		return result;
	}




}
