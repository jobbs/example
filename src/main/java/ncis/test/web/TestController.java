/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TestController.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     박봉춘         v1.0             최초생성
 *
 */
package ncis.test.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.exception.CommonException;
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.exception.DownFileNotFoundException;
import ncis.cmn.exception.ExceptionScriptPrint;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.vo.CommonSearchVo;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.board.vo.BoardVo;
import ncis.cpt.cmn.vo.TestVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.worddicary.vo.WordDicaryVo;
import ncis.test.service.TestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Controller
@EnableWebMvc
@RequestMapping(value="/cpt/test")
public class TestController extends BaseController {

	Logger logger = LoggerFactory.getLogger(TestController.class);

	Logger logger2 = LoggerFactory.getLogger("vmRcLog");

	@Resource(name="testService")
	TestService testService;

	@Resource(name="commonService")
	CommonService commonService;

	@RequestMapping(value="/doSequenceTest.do")
	public void doSequenceTest(HttpServletRequest request) {
		testService.insertSequenceTest();
	}

	@RequestMapping(value="/doCommonException.do")
	public void doCommonException(HttpServletRequest request) {

        logger.debug("공통 오류 처리 입니다.");
        throw new CommonException("공통 오류 처리 입니다.");
	}

	@RequestMapping(value="/doDataNotFoundException.do")
    public void doDataNotFoundException(HttpServletRequest request) {
        throw new DataNotFoundException("해당 데이터가 없습니다.");
    }

	@RequestMapping(value="/doDownFileNotFoundException.do")
    public void doDownFileNotFoundException(HttpServletRequest request) {
        throw new DownFileNotFoundException("대상 파일이 존재하지 않습니다.");
    }

	@RequestMapping(value="/doExceptionScriptPrint.do")
    public void doExceptionScriptPrint(HttpServletRequest request) {
        throw new ExceptionScriptPrint("스크립트 오류 테스트");
    }

	@RequestMapping(value="/form/selectCodeList.do")
	@ResponseBody
    public ProcResultVo selectCodeList(@RequestParam(required=true) String grpCd,
            @RequestParam(required=true) String cd){

		logger2.info("Log4j Test.................................");

	    ProcResultVo result = new ProcResultVo();

	    List<CodeVo> codes = commonService.selectCodeList(grpCd, cd);
        result.setData(codes);
        return result;
    }

	@RequestMapping(value="/form/selectSeqnum.do", method=RequestMethod.POST)
	@ResponseBody
    public ProcResultVo selectSeqnum(Model model, @RequestParam(required=true) String classfy,
            @RequestParam(required=true) String format ){

	    ProcResultVo result = new ProcResultVo();

	    result.setData(testService.selectSeqNum(classfy, format));
	    result.setProcType("seqnum");

        return result;
    }

	@RequestMapping(value="/form/selectForm.do", method=RequestMethod.GET)
	public String testForm(HttpServletRequest request, Model model){

		model.addAttribute("searchVo", new CommonSearchVo());

		return portalTilesView(request);
	}

	@RequestMapping(value="/form/selectForm.do", method=RequestMethod.POST)
	public ProcResultVo testFormProc(HttpServletRequest request,
			TestVo testVo, BindingResult bindingResult){

		ProcResultVo result = getBindingResult(testVo, bindingResult, InsertProc.class);

		if( result.isSuccess() ) {
			result.setData(testVo);
			result.setProcType("insert");
		}

		return result;
	}


	@RequestMapping(value="/rest/selectRest.do", method=RequestMethod.GET)
	public String restView(HttpServletRequest request, Model model){

		return portalTilesView(request);
	}

	/**
	 * Rest Test를 위한 항목
	 * @param request
	 * @param sendType
	 * @return
	 */
	@RequestMapping(value="/rest/selectRest.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo rest(HttpServletRequest request, @RequestParam String sendType) {

		ProcResultVo result = null;

		if( "GET".equals(sendType)) {
			result = testService.selectRest();

		} else if( "POST".equals(sendType)) {
			result = testService.insertRest();

		} else if( "PUT".equals(sendType)) {
			result = testService.updateRest();

		} else if( "DELETE".equals(sendType)) {
			result = testService.deleteRest();

		}

		return result;

	}

	@RequestMapping(value="/rest/selectMachineList.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo selectMachineList(HttpServletRequest request) {

		return  testService.selectMachineList();

	}

	@RequestMapping(value="/rest/selectMachine.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo selectMachine(HttpServletRequest request) {
		return  testService.selectMachine();
	}

	@RequestMapping(value="/rest/selectNtops.do", method=RequestMethod.POST)
    @ResponseBody
    public ProcResultVo selectNtops(HttpServletRequest request) {
        return  testService.selectNtops();
    }

	@RequestMapping(value="/form/downfileExcel.do")
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("boardCd", "게시판타입");
        header.put("subject", "제목");
        header.put("contents", "내용");

	    // 첫번째 Sheet Vo 생성
        List<BoardVo> datas = new ArrayList<BoardVo>();
        BoardVo vo = new BoardVo();
        vo.setBoardCd("notice");
        vo.setBoardSeq(new Long(1));
        vo.setSbjct("Test Subject");
        vo.setContents("Test Content");
        datas.add(vo);

        vo = new BoardVo();
        vo.setBoardCd("qna");
        vo.setBoardSeq(new Long(1));
        vo.setSbjct("Test QNA Subject");
        vo.setContents("Test QNA Content");
        datas.add(vo);

        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("게시판");
        sheet.setDatas(datas);
        sheet.setHreader(header);

        sheets.add(sheet);

        //두번째 Sheet Header 생성
        header = new LinkedHashMap<String, String>();
        header.put("wordKr", "한글명");
        header.put("wordEn", "영문명");
        header.put("wordAbrv", "약어");

        // 두번째 Sheet Vo 생성
        List<WordDicaryVo> datas1 = new ArrayList<WordDicaryVo>();
        WordDicaryVo dicaryVo = new WordDicaryVo();
        dicaryVo.setWordKr("사용");
        dicaryVo.setWordEn("Use");
        dicaryVo.setWordAbrv("USE");
        datas1.add(dicaryVo);

        //두번째 Sheet setting
        CustomSheet sheet1 = new CustomSheet();
        sheet1.setSheetName("단어사전");
        sheet1.setDatas(datas1);
        sheet1.setHreader(header);
        sheets.add(sheet1);

        //Excel 생성
        ExcelUtil.downloadExcel(response, "한글테스트", sheets);
    }

}

