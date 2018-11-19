/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MacBndController.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.web;

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
import ncis.cpt.opr.ip.service.MacBndService;
import ncis.cpt.opr.ip.vo.MacBndIntfcAsgnVo;
import ncis.cpt.opr.ip.vo.MacBndSvo;
import ncis.cpt.opr.ip.vo.MacBndVo;
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
@RequestMapping("/cpt/opr/ip/macBnd")
public class MacBndController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(MacBndController.class);

	@Resource(name="macBndService")
	private MacBndService macBndService;

	@Resource(name="commonService")
	CommonService commonService;

	/**
	 * MAC대역 목록조회
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/selectMacBndList.do")
	public String selectMacBndList(HttpServletRequest request, Model model, MacBndSvo svo){

		List<MacBndVo> list = macBndService.selectMacBndList(svo);

		model.addAttribute("searchVo", svo);
		model.addAttribute("macBndList", list);

		return portalTilesView(request);
	}

	/**
	 * MAC대역 상세조회
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/selectMacBnd.do")
	public String selectMacBndDetail(HttpServletRequest request, Model model, MacBndSvo svo){

		MacBndVo macBnd = macBndService.selectMacBnd(svo);
		if( null == macBnd )
			throw new DataNotFoundException("조회 대상 데이터가 존재하지 않습니다.");

		List<MacBndVo> list = macBndService.selectMacBndDetail(svo);

		model.addAttribute("macBnd", macBnd);
		model.addAttribute("list", list);
		model.addAttribute("searchVo", svo);

		return portalTilesView(request);
	}

	/**
	 * MAC대역 엑셀다운로드
	 * @param request
	 * @param response
	 * @param searchVo
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	@RequestMapping(value = "/selectMacBndListXlsDwnl.do")
    public void selectMacBndListXlsDwnl(HttpServletRequest request, HttpServletResponse response, MacBndSvo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

		macBndService.selectMacBndList(searchVo);
		searchVo.getPaginationInfo().setRecordCountPerPage(searchVo.getPaginationInfo().getTotalRecordCount());

		List<MacBndVo> list = macBndService.selectMacBndList(searchVo);

        // CusomSheet 생성
        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // 첫번째 Sheet Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netClCdNm", "망구분");
        header.put("rsrcPoolNm", "자원풀");
        header.put("macBndNm", "MAC대역명");
        header.put("macStrtAddr", "MAC시작주소");
        header.put("macEndAddr", "MAC종료주소");
        header.put("asgnCnt", "할당");

        // Sheet Vo 생성
        List<MacBndVo> datas = new ArrayList<MacBndVo>();
        for (MacBndVo macBndVo : list) {
        	MacBndVo vo = new MacBndVo();

    		vo.setRegionNm(macBndVo.getRegionNm());
            vo.setZoneNm(macBndVo.getZoneNm());
            vo.setNetClCdNm(macBndVo.getNetClCdNm());
            vo.setRsrcPoolNm(macBndVo.getRsrcPoolNm());
            vo.setMacBndNm(macBndVo.getMacBndNm());
            vo.setMacStrtAddr(macBndVo.getMacStrtAddr());
            vo.setMacEndAddr(macBndVo.getMacEndAddr());
            vo.setAsgnCnt(macBndVo.getAsgnCnt());
            datas.add(vo);
        }

        // Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("MacBnd");
        sheet.setDatas(datas);
        sheet.setHreader(header);

        sheets.add(sheet);

        // Excel 생성
        ExcelUtil.downloadExcel(response, String.format("MAC대역_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
	}

	/**
	 * MAC대역 주소 엑셀다운로드
	 * @param request
	 * @param response
	 * @param searchVo
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	@RequestMapping(value = "/selectMacBndDetailXlsDwnl.do")
    public void selectMacBndDetailXlsDwnl(HttpServletRequest request, HttpServletResponse response, MacBndSvo svo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

		macBndService.selectMacBndDetail(svo);
		svo.getPaginationInfo().setRecordCountPerPage(svo.getPaginationInfo().getTotalRecordCount());

		List<MacBndVo> list = null;
		list = macBndService.selectMacBndDetail(svo);

        // CusomSheet 생성
        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // 첫번째 Sheet Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("asgnYn", "할당여부");
        header.put("macAddr", "MAC주소");
        header.put("institutionNm", "부처명");
        header.put("job", "업무명");
        header.put("rsrcPoolNm", "자원풀명");
        header.put("vmNm", "가상서버명");
        header.put("vmCompId", "가상서버구성ID");
        header.put("netwkIntfcNm", "인터페이스명");
        header.put("asgnDate", "할당일자");

        // Sheet Vo 생성
        List<MacBndIntfcAsgnVo> datas = new ArrayList<MacBndIntfcAsgnVo>();
        for (MacBndVo asgnVo : list) {
        	MacBndIntfcAsgnVo vo = new MacBndIntfcAsgnVo();

        	if(("Y").equals(asgnVo.getAsgnYn())){
        		vo.setAsgnYn("할당");
        	}else if(("N").equals(asgnVo.getAsgnYn())){
        		vo.setAsgnYn("미할당");
        	}else{
        		vo.setAsgnYn(asgnVo.getAsgnYn());
        	}
            vo.setMacAddr(asgnVo.getMacAddr());
            vo.setInstitutionNm(asgnVo.getInstitutionNm());
            vo.setJob(asgnVo.getVmJob());
            vo.setRsrcPoolNm(asgnVo.getRsrcPoolNm());
            vo.setVmNm(asgnVo.getVmNm());
            vo.setVmCompId(asgnVo.getVmCompId());
            vo.setNetwkIntfcNm(asgnVo.getNetwkIntfcNm());
            if(!("").equals(asgnVo.getAsgnDt()) && asgnVo.getAsgnDt() != null){
            	vo.setAsgnDate((new SimpleDateFormat("yyyy-MM-dd")).format(asgnVo.getAsgnDt()));
            }
            datas.add(vo);
        }

        // Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("MacBndDetail");
        sheet.setDatas(datas);
        sheet.setHreader(header);

        sheets.add(sheet);

        // Excel 생성
        ExcelUtil.downloadExcel(response, String.format("MAC대역상세_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

	/**
	 * MAC대역 동기화
	 * @param vo
	 * @return
	 */
	@OperateLog(action="MAC대역 동기화", desc="MAC대역 동기화 처리", params={"MacBndSvo"}, actionType=ActionType.UPDATE)
	@RequestMapping(value="/updateMacBndIntfcAsgn.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updateMacBndIntfcAsgn(@ModelAttribute("svo") MacBndSvo svo) throws Exception {

		ProcResultVo result = new ProcResultVo();

		if(!svo.getUpdtCheck().isEmpty()){
			if(svo.getUpdtCheck().size() > 0){
				try {
					macBndService.updateMacBndIntfcAsgn(svo);;
					result.setProcType("update");
					result.setSuccess(true);
		        } catch (NullPointerException ne) {
		        	result.setSuccess(false);
		        	result.addMessage("MAC대역 동기화에 실패하였습니다.");
		        	logger.error("NullPointerException", ne);
		        } catch (RuntimeException re) {
		        	result.setSuccess(false);
		        	result.addMessage("MAC대역 동기화에 실패하였습니다.");
		        	logger.error("RuntimeException",re);
		        } catch (Exception e) {
		        	result.setSuccess(false);
		        	result.addMessage("MAC대역 동기화에 실패하였습니다.");
		        	logger.error("Exception",e);
		        }
			}
		}
		return result;
	}
}
