/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetPmController.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.web;

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

import ncis.cmn.security.vo.UserVo;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.ip.config.IpBndConstants;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.com.util.InputValidationUtils;
import ncis.cpt.rsrc.net.service.NetPmService;
import ncis.cpt.rsrc.net.service.NetVmService;
import ncis.cpt.rsrc.net.vo.NetPmSearchVo;
import ncis.cpt.rsrc.net.vo.NetPmVo;
import ncis.cpt.rsrc.net.vo.NetVmSvo;
import ncis.cpt.rsrc.net.vo.NetVmVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 최경철
 *
 */
@Controller
@RequestMapping(value = "/cpt/rsrc/net/pm")
public class NetPmController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(NetPmController.class.getName());

    @Resource(name = "netPmService")
    NetPmService netPmService;

    @Resource(name = "commonService")
    CommonService commonService;

    @Resource(name = "netVmService")
    NetVmService netVmService;

    /**
     * 네트워크 물리서버 목록 조회 화면
     *
     * @param request
     * @param model
     * @param netPmSearchVo
     * @return
     */
    @RequestMapping(value = "/selectNetPmList.do")
    public String selectNetPmListView(HttpServletRequest request, Model model, NetPmSearchVo netPmSearchVo) {

        List<CodeVo> vrlzSwTyCdList = commonService.selectCodeList(ComConstant.VRLZ_SW_TY_GRP_CD, ComConstant.VRLZ_SW_TY_PARENT_CD); // 가상화SW 코드
        List<CodeVo> statCdList = commonService.selectCodeList(ComConstant.PM_GRP_STAT_GRP_CD, ComConstant.PM_GRP_STAT_PARENT_CD, true); // 물리서버상태 코드
        List<CodeVo> netVoList = commonService.selectCodeList(IpBndConstants.IP_BND_NET_GRP_CD, IpBndConstants.IP_BND_NET_PARENT_CD, true); // 망구분코드

        // 페이지 처음 진입시 가상화SW 구분값 세팅
    	if(netPmSearchVo.getSearchVrlzSwTyCdList() == null || netPmSearchVo.getSearchVrlzSwTyCdList().length == 0) {

    		List<String> list = new ArrayList<String>();
    		for (CodeVo codeVo : vrlzSwTyCdList) {
				list.add(codeVo.getCd());
			}
    		netPmSearchVo.setSearchVrlzSwTyCdList( list.toArray(new String[list.size()]) );
    	}

        netPmSearchVo.setSearchDelYn("N"); // 삭제 여부
        List<NetPmVo> netPmVoList = netPmService.selectNetPmList(netPmSearchVo, true);

        model.addAttribute("vrlzSwTyCdList", vrlzSwTyCdList);
        model.addAttribute("statCdList", statCdList);

        model.addAttribute("netVoList", netVoList);
        model.addAttribute("netPmVoList", netPmVoList);
        model.addAttribute("netPmSearchVo", netPmSearchVo);

        return portalTilesView(request);

    }

    /**
     * 네트워크 물리서버 목록 엑셀 다운로드
     *
     * @param request
     * @param model
     * @param pmSearchVo
     * @return
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    @RequestMapping(value = "/selectNetPmListXlsDwnl.do")
    public void selectNetPmListXlsDwnl(HttpServletRequest request, HttpServletResponse response, Model model, NetPmSearchVo netPmSearchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        netPmSearchVo.setSearchDelYn("N"); // 삭제 여부

        List<NetPmVo> netPmVoList = netPmService.selectNetPmList(netPmSearchVo, false);

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("statCdNm", "상태");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망");
        header.put("rsrcPoolNm", "자원풀");
        header.put("pmNm", "물리서버명");
        header.put("pmCompId", "물리서버구성ID");
        header.put("rprsntIpAddr", "IP주소");
        header.put("vrlzSwTyCdNm", "가상화SW");
        header.put("vmCnt", "가상서버수");
        header.put("cpuUseRtExcel", "CPU 사용률 (%)");
        header.put("cpuVrlzRtExcel", "CPU 가상화율 (%)");
        header.put("totCpuEnt", "CPU Ent");
        header.put("totCpuVcoreQty", "CPU vCore");
        header.put("cpuCoreQty", "CPU Core");
        header.put("memUseRtExcel", "메모리 사용률 (%)");
        header.put("memVrlzRtExcel", "메모리 가상화율 (%)");
        header.put("totMemAsgnCapaExcel", "메모리 할당량 (GB)");
        header.put("memCapaExcel", "메모리 전체량 (GB)");
        header.put("totStrgAsgnCapaExcel", "스토리지 (GB)");
        header.put("netwkInExcel", "네트워크 In (KB/Sec)");
        header.put("netwkOutExcel", "네트워크 Out (KB/Sec)");

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("네트워크 물리서버");
        sheet.setDatas(netPmVoList);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response, String.format("네트워크 물리서버_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

    /**
     * 네트워크 물리서버 상세 정보 조회 화면
     *
     * @param request
     * @param model
     * @param pmSeq
     * @return
     */
    @RequestMapping(value = "/selectNetPm.do")
    public String selectNetPmView(HttpServletRequest request, Model model, @RequestParam(required = true) BigDecimal pmSeq) {

    	// 네트워크 물리서버 상세 조회
        NetPmVo netPmVo = netPmService.selectNetPm(pmSeq);

        // 네트워크 물리서버의 하위 가상서버 정보 조회
        NetVmSvo vmSearchVo = new NetVmSvo();
        vmSearchVo.setPmSeq(pmSeq);
        List<NetVmVo> vmList = netVmService.selectNetVmList(vmSearchVo, false);

        model.addAttribute("netPmVo", netPmVo);
        model.addAttribute("vmList", vmList);
        model.addAttribute("ivu", new InputValidationUtils());

        return portalTilesView(request);

    }

    /**
     * 네트워크 물리서버 정보 수정
     *
     * @param netPmVo
     * @return
     */
    @RequestMapping(value = "/updateNetPm.do", method = RequestMethod.POST)
    @OperateLog(action = "네트워크 물리서버 정보 수정", desc = "네트워크 물리서버 구성ID 수정", params = {"netPmVo", "bindingResult"})
    @ResponseBody
    public ProcResultVo updateNetPm(NetPmVo netPmVo, BindingResult bindingResult) {

        try {
        	UserVo userVo = getUser();
            if (userVo == null) {
                return getFailProcResult(ComConstant.FAILED_TO_LOAD_REQUEST_USER_MSG);
            }

            netPmVo.setUpdtUserId(getUserId());

            NetPmVo pmVoForCompare = netPmService.selectNetPm(netPmVo.getPmSeq());

            // 수정 할 물리서버 정보 존재여부 체크
            if(pmVoForCompare == null){
                return getFailProcResult(ComConstant.NOT_EXIST_TARGET_PM_MSG);
            }

            // 입력한 물리서버구성ID를 사용중인지 체크
            if (null != netPmVo.getPmCompId() && !netPmVo.getPmCompId().equals(pmVoForCompare.getPmCompId()) && netPmService.isExistsPmCompId(netPmVo.getPmCompId())) {
                return getFailProcResult(ComConstant.PM_COMP_ID_ALREADY_EXISTS_MSG);
            }

            // 물리구성ID 및 비고 정보가 공백으로 왔을 시 DB에 업데이트하기 위해 null 처리
            if(null != netPmVo.getPmCompId() && "".equals(netPmVo.getPmCompId().trim()))
            	netPmVo.setPmCompId(null);
        	if(null != netPmVo.getRmk() && "".equals(netPmVo.getRmk().trim()))
        		netPmVo.setRmk(null);

            // 물리서버 정보 수정
            netPmService.updateNetPm(netPmVo);

            return getSuccessProcResult(ComConstant.SUCCESS_MSG, ComConstant.UPDATE, null);
        } catch (Exception e) {
        	logger.error(e.getMessage());
            return getFailProcResult(ComConstant.ERROR_MSG);
        }

    }


}
