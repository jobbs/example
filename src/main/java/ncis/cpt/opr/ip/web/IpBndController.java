/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename IpBndController.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.entity.RnIp;
import ncis.cmn.exception.NotAllowedFileExtException;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.PropertiesUtil;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.ip.config.IpBndConstants;
import ncis.cpt.opr.ip.service.IpBndService;
import ncis.cpt.opr.ip.service.SRoutService;
import ncis.cpt.opr.ip.service.VrSwtchAsgnService;
import ncis.cpt.opr.ip.vo.IpBndInstVo;
import ncis.cpt.opr.ip.vo.IpBndPrposVo;
import ncis.cpt.opr.ip.vo.IpBndSearchVo;
import ncis.cpt.opr.ip.vo.IpBndVo;
import ncis.cpt.opr.ip.vo.IpVo;
import ncis.cpt.opr.ip.vo.SRoutVo;
import ncis.cpt.opr.ip.vo.VrSwtchAsgnVo;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.com.service.NetwkIntfcService;
import ncis.cpt.rsrc.com.service.VmService;
import ncis.cpt.rsrc.com.vo.NetwkIntfcVo;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.cpt.rsrc.pool.service.RsrcPoolService;
import ncis.cpt.rsrc.zone.service.NetService;
import ncis.cpt.rsrc.zone.service.RegionService;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.cpt.sys.instt.service.InsttService;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 신재훈
 *
 */

@Controller
@RequestMapping(value = "/cpt/opr/ip/ipBnd")
public class IpBndController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(IpBndController.class);

    @Resource(name = "ipBndService")
    IpBndService ipBndService;

    @Resource(name = "commonService")
    CommonService commonService;

    @Resource(name = "regionService")
    RegionService regionService;

    @Resource(name = "netService")
    NetService netService;

    @Resource(name = "vmService")
    VmService vmService;

    @Resource(name = "vrSwtchAsgnService")
    VrSwtchAsgnService vrSwtchAsgnService;

    @Resource(name = "sRoutService")
    SRoutService sRoutService;

    @Resource(name = "rsrcPoolService")
    RsrcPoolService rsrcPoolService;

    @Resource(name = "netwkIntfcService")
    NetwkIntfcService netwkIntfcService;

    @Resource(name="insttService")
    InsttService insttService;


    /**
     * 검색조건에 맞는 IP대역 목록조회
     *
     * @param request
     * @param model
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/selectIpBndList.do")
    public String selectipBndListView(HttpServletRequest request, Model model, IpBndSearchVo searchVo) {
        List<IpBndVo> list = ipBndService.selectIpBndList(searchVo); // IP대역 조회
        List<CodeVo> prposList = commonService.selectCodeList(IpBndConstants.IP_BND_PRPOS_GRP_CD, IpBndConstants.IP_BND_PRPOS_PARENT_CD); // IP대역용도 목록조회
        List<CodeVo> netList = commonService.selectCodeList(IpBndConstants.IP_BND_NET_GRP_CD, IpBndConstants.IP_BND_NET_PARENT_CD, true); // 망구분코드 목록조회

        model.addAttribute("list", list);
        model.addAttribute("searchVo", searchVo);
        model.addAttribute("prposList", prposList);
        model.addAttribute("netList", netList);
        return portalTilesView(request);
    }

    /**
     * 검색조건에 맞는 IP대역 엑셀다운로드
     *
     * @param request
     * @param response
     * @param searchVo
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws IOException
     */
    @RequestMapping(value = "/selectIPBndListXlsDwnl.do")
    public void selectIpBndListXlsDwnl(HttpServletRequest request, HttpServletResponse response, IpBndSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
        List<IpBndVo> list = ipBndService.selectIpBndListXlsDwnl(searchVo);
        // CusomSheet 생성
        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // 첫번째 Sheet Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("useYn", "사용여부");
        header.put("regionNm", "센터");
        header.put("netNm", "망구분");
        header.put("prposNm", "용도");
        header.put("ipBndNm", "IP대역명");
        header.put("institutionNm", "사용부처");
        header.put("bndStrtIp", "시작IP");
        header.put("bndEndIp", "종료IP");
        header.put("gtwyIpAddr", "게이트웨이");
        header.put("subnetMask", "서브넷마스크");
        header.put("vlan", "VLAN");
        header.put("asgnIpQty", "할당 IP수");
        header.put("unasgnIpQty", "미할당 IP수");
        header.put("blkIpQty", "Block IP수");

        // Sheet Vo 생성
        List<IpBndVo> datas = new ArrayList<IpBndVo>();

        for (int i = 0; i < list.size(); i++) {
            if (null != list.get(i).getUseYn()) {
                list.get(i).setUseYn(list.get(i).getUseYn().equals("Y") ? "사용" : "미사용");
            }
        }
        datas.addAll(list);

        // Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("IP대역");
        sheet.setDatas(datas);
        sheet.setHreader(header);

        sheets.add(sheet);

        // Excel 생성
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String curDate = format.format(Calendar.getInstance().getTime());
        ExcelUtil.downloadExcel(response, "IP대역_" + curDate, sheets);
    }

    /**
     * IP대역 상세 - 할당목록 엑셀다운로드
     *
     * @param request
     * @param response
     * @param vo
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws IOException
     */
    @RequestMapping(value = "/selectIpAsgnListXlsDwnl.do")
    public void selectIpAsgnListXlsDwnl(HttpServletRequest request, HttpServletResponse response, IpVo vo, IpBndVo ipBndVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
        List<IpVo> assigns = ipBndService.selectIp(vo.getSelectBndSeq(), IpBndConstants.IP_BND_STAT_CD_ASGN);

        // CusomSheet 생성
        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // Sheet Header 생성
        Map<String, String> asgnHeader = new LinkedHashMap<String, String>();
        asgnHeader.put("vmCompId", "가상서버 구성ID");
        asgnHeader.put("ipAddr", "IP");
        asgnHeader.put("natIpAddr", "IP(NAT)");
        asgnHeader.put("vmNm", "가상서버명");
        asgnHeader.put("hstNm", "호스트명");
        asgnHeader.put("macAddr", "MAC주소");
        asgnHeader.put("hypervisor", "가상화SW");
        asgnHeader.put("vipYn", "VIP여부");
        asgnHeader.put("asgnDtToString", "할당일자");
        asgnHeader.put("rmk", "비고");

        // Sheet Vo 생성
        List<IpVo> asgnDatas = new ArrayList<IpVo>();

        asgnDatas.addAll(assigns);

        // Sheet setting
        CustomSheet asgnSheet = new CustomSheet();
        asgnSheet.setSheetName("할당목록");
        asgnSheet.setDatas(asgnDatas);
        asgnSheet.setHreader(asgnHeader);

        sheets.add(asgnSheet);

        // Excel 생성
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String curDate = format.format(Calendar.getInstance().getTime());
        ExcelUtil.downloadExcel(response, "IP할당_" + curDate, sheets);

    }

    /**
     * IP대역 상세 - 미할당목록 엑셀다운로드
     *
     * @param request
     * @param response
     * @param vo
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws IOException
     */
    @RequestMapping(value = "/selectIpUnasgnListXlsDwnl.do")
    public void selectIpUnasgnListXlsDwnl(HttpServletRequest request, HttpServletResponse response, IpVo vo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
        List<IpVo> unassigns = ipBndService.selectIp(vo.getSelectBndSeq(), IpBndConstants.IP_BND_STAT_CD_UNASGN);

        // CusomSheet 생성
        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // Sheet Header 생성
        Map<String, String> unasgnHeader = new LinkedHashMap<String, String>();
        unasgnHeader.put("ipAddr", "IP");
        unasgnHeader.put("natIpAddr", "IP(NAT)");
        unasgnHeader.put("vipYn", "VIP여부");
        unasgnHeader.put("withdrawDtToString", "회수일자");
        unasgnHeader.put("rmk", "비고");

        // Sheet Vo 생성
        List<IpVo> unasgnDatas = new ArrayList<IpVo>();
        unasgnDatas.addAll(unassigns);

        // Sheet setting
        CustomSheet unasgnSheet = new CustomSheet();
        unasgnSheet.setSheetName("미할당목록");
        unasgnSheet.setDatas(unasgnDatas);
        unasgnSheet.setHreader(unasgnHeader);

        sheets.add(unasgnSheet);

        // Excel 생성
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String curDate = format.format(Calendar.getInstance().getTime());
        ExcelUtil.downloadExcel(response, "IP미할당_" + curDate, sheets);
    }

    /**
     * IP대역 상세 - 블락목록 엑셀다운로드
     *
     * @param request
     * @param response
     * @param vo
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws IOException
     */
    @RequestMapping(value = "/selectIpBlkListXlsDwnl.do")
    public void selectIpBlkListXlsDwnl(HttpServletRequest request, HttpServletResponse response, IpVo vo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
        List<IpVo> blocks = ipBndService.selectIp(vo.getSelectBndSeq(), IpBndConstants.IP_BND_STAT_CD_BLK);

        // CusomSheet 생성
        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // Sheet Header 생성
        Map<String, String> blkHeader = new LinkedHashMap<String, String>();
        blkHeader.put("ipAddr", "IP");
        blkHeader.put("natIpAddr", "IP(NAT)");
        blkHeader.put("vipYn", "VIP여부");
        blkHeader.put("rmk", "비고");

        // Sheet Vo 생성
        List<IpVo> blkDatas = new ArrayList<IpVo>();
        blkDatas.addAll(blocks);

        // Sheet setting
        CustomSheet blkSheet = new CustomSheet();
        blkSheet.setSheetName("블락목록");
        blkSheet.setDatas(blkDatas);
        blkSheet.setHreader(blkHeader);

        sheets.add(blkSheet);

        // Excel 생성
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String curDate = format.format(Calendar.getInstance().getTime());
        ExcelUtil.downloadExcel(response, "IP블락_" + curDate, sheets);
    }

    /**
     * IP대역 추가 화면 호출
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/insertIpBndView.do", method = RequestMethod.GET)
    public String insertIpBndView(HttpServletRequest request, Model model) {
        List<CodeVo> prposClCdList = commonService.selectCodeList(IpBndConstants.IP_BND_PRPOS_GRP_CD, IpBndConstants.IP_BND_PRPOS_PARENT_CD, false); // IP대역용도

        model.addAttribute("ipBndVo", new IpBndVo());
        model.addAttribute("prposClCdList", prposClCdList);
        return portalTilesView(request, "insertIpBnd");
    }

    /**
     * IP대역 추가
     *
     * @param request
     * @param ipBndVo
     * @return
     */
    @RequestMapping(value = "/insertIpBnd.do", method = RequestMethod.POST)
    @OperateLog(action = "IP대역 추가", desc = "IP대역 추가.", params = { "ipBndVo", "bindingResult" })
    @ResponseBody
    public ProcResultVo insertIpBnd(@ModelAttribute("ipBndVo") IpBndVo ipBndVo, BindingResult bindingResult) {
        ProcResultVo result = getBindingResult(ipBndVo, bindingResult, InsertProc.class);

        if (!result.isSuccess()) {
            return getFailProcResult(IpBndConstants.ERROR_MSG);
        }
        try {
            // 1. 용도 선택 확인
            if (null == ipBndVo.getPrposClCdList() || 0 == ipBndVo.getPrposClCdList().size()) {
                return getFailProcResult(IpBndConstants.ERROR_MSG + "[" + IpBndConstants.ERROR_MSG_IPBND_EMPTY_PRPOS + "]");
            }

            // 2. 추가하려는 IP대역의 IP 중복체크 (센터-망-용도 별)
            boolean checkDuplicate = true;
            for (String clcd : ipBndVo.getPrposClCdList()) { // HEARTBEAT일때는 중복체크를 하지 않음
                if (clcd.equals("09") || clcd.equals("10") || clcd.equals("11") || clcd.equals("12")) {
                    checkDuplicate = false;
                }
            }

            if (checkDuplicate) {
                List<IpVo> list = ipBndService.selectCheckIpRange(ipBndVo.getBndStrtIp(), ipBndVo.getBndEndIp(), ipBndVo.getRegionId(), ipBndVo.getNetClCd(), ipBndVo.getPrposClCdList());
                if (null == list || 0 < list.size()) {
                    return getFailProcResult("[" + IpBndConstants.ERROR_MSG_IPBND_USED_IP + "]");
                }
            }

            // 3. IP대역 추가
            ipBndService.insertIpBnd(ipBndVo);
            return getSuccessProcResult(IpBndConstants.SUCCESS_MSG, IpBndConstants.INSERT, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(IpBndConstants.ERROR_MSG);
        }
    }

    /**
     * IP대역 상세조회 (수정화면)
     *
     * @param request
     * @param model
     * @param userId
     * @return
     */
    @RequestMapping(value = "/selectIpBnd.do")
    public String selectIpBndView(HttpServletRequest request, Model model, IpBndSearchVo searchVo) {
        logger.debug("########################################################################");
        IpBndVo ipBndVo = ipBndService.selectIpBnd(searchVo.getBndSeq());

        if (null == searchVo.getSearchType()) {
            searchVo.setSearchType(IpBndConstants.IP_BND_TAB_TYPE_INFO); // 기본정보 탭
        }

        if (IpBndConstants.IP_BND_TAB_TYPE_ASGN.equals(searchVo.getSearchType())) {
            List<IpVo> assigns = ipBndService.selectIp(searchVo.getBndSeq(), IpBndConstants.IP_BND_STAT_CD_ASGN); // 할당 탭
            model.addAttribute("assigns", assigns);
        }
        else if (IpBndConstants.IP_BND_TAB_TYPE_UNASGN.equals(searchVo.getSearchType())) {
            List<IpVo> unassigns = ipBndService.selectIp(searchVo.getBndSeq(), IpBndConstants.IP_BND_STAT_CD_UNASGN); // 미할당
            model.addAttribute("unassigns", unassigns);
        }
        else if (IpBndConstants.IP_BND_TAB_TYPE_BLOCK.equals(searchVo.getSearchType())) {
            List<IpVo> blocks = ipBndService.selectIp(searchVo.getBndSeq(), IpBndConstants.IP_BND_STAT_CD_BLK); // Block 탭
            model.addAttribute("blocks", blocks);
        }

        List<CodeVo> prposClCdList = commonService.selectCodeList(IpBndConstants.IP_BND_PRPOS_GRP_CD, IpBndConstants.IP_BND_PRPOS_PARENT_CD, false); // IP대역용도
        List<CodeVo> netList = commonService.selectCodeList(IpBndConstants.IP_BND_NET_GRP_CD, IpBndConstants.IP_BND_NET_PARENT_CD); // 망구분코드

        model.addAttribute("ipBndVo", ipBndVo);
        model.addAttribute("ipVo", new IpVo());

        model.addAttribute("netList", netList);
        model.addAttribute("prposClCdList", prposClCdList);
        model.addAttribute("vrSwtchlist", ipBndVo.getVrSwtchList());
        model.addAttribute("vrSwtchlistCnt", ipBndVo.getVrSwtchList().size());
        model.addAttribute("list", ipBndVo.getsRoutLists());
        model.addAttribute("sRoutVo", new SRoutVo());
        model.addAttribute("searchVo", searchVo);

        model.addAttribute("sRoutListCnt", ipBndVo.getsRoutLists().size());
        model.addAttribute("gwIpAddrLength", ipBndVo.getGtwyIpAddr().length());
        model.addAttribute("ipAsgnCnt", ipBndVo.getAsgnIpQty());
        model.addAttribute("instituionList", ipBndVo.getIpBndInstVoList());
        return portalTilesView(request);
    }

    /**
     * IP대역 기본정보 수정
     *
     * @param request
     * @param model
     * @param ipBndSeq
     * @return
     */
    @RequestMapping(value = "updateIpBnd.do", method = RequestMethod.POST)
    @OperateLog(action = "IP대역 수정", desc = "IP대역 수정.", params = { "ipBndVo", "bindingResult" })
    @ResponseBody
    public ProcResultVo updateIpBndInfo(IpBndVo ipBndVo, BindingResult bindingResult) throws Exception {
        ProcResultVo result = getBindingResult(ipBndVo, bindingResult, UpdateProc.class);
        if (!result.isSuccess()) {
            return getFailProcResult(IpBndConstants.ERROR_MSG);
        }
        try {
            // 1. 기존정보 가져오기.
            IpBndVo ipBndVoForUpdate = ipBndService.selectIpBnd(ipBndVo.getBndSeq());

            if (null == ipBndVoForUpdate) {
                return getFailProcResult(IpBndConstants.ERROR_MSG);
            }
            if (null == ipBndVo.getPrposClCdList() || 0 == ipBndVo.getPrposClCdList().size()) {
                return getFailProcResult(IpBndConstants.ERROR_MSG + "[" + IpBndConstants.ERROR_MSG_IPBND_EMPTY_PRPOS + "]");
            }

            // 2. 기존 정보 비교시, 망구분, 용도가 변경되지 않았을 시에는 중복체크를 하지 않음.
            boolean changeNetId = true; // 망구분이 변경되었는지 판단.
            boolean changePrposCd = true; // 용도가 변경되었는지 판단.

            if (ipBndVoForUpdate.getNetClCd().equals(ipBndVo.getNetClCd())) {
                changeNetId = false;
            }

            for (int i = 0; i < ipBndVoForUpdate.getIpBndPrposVoList().size(); i++) {
                for (String prposCd : ipBndVo.getPrposClCdList()) {
                    if (ipBndVoForUpdate.getIpBndPrposVoList().get(i).getPrposClCd().equals(prposCd)) {
                        changePrposCd = false;
                        break;
                    }
                }
            }

            if (changeNetId || changePrposCd) {
                // 3. 수정하려는 IP대역의 IP 중복체크 (센터-망-용도 별)
                boolean checkDuplicate = true;
                for (String clcd : ipBndVo.getPrposClCdList()) { // HEARTBEAT일때는 중복체크를 하지 않음
                    if (clcd.equals("09") || clcd.equals("10") || clcd.equals("11") || clcd.equals("12")) {
                        checkDuplicate = false;
                    }
                }
                if (checkDuplicate) {
                    List<IpVo> list = ipBndService.selectCheckIpRange(ipBndVo.getBndStrtIp(), ipBndVo.getBndEndIp(), ipBndVo.getRegionId(), ipBndVo.getNetClCd(), ipBndVo.getPrposClCdList());
                    if (null == list || 0 < list.size()) {
                        return getFailProcResult("[" + IpBndConstants.ERROR_MSG_IPBND_USED_IP + "]");
                    }
                }
            }

            // 4. 업데이트 될 정보 IP대역 기본정보 설정
            ipBndVoForUpdate.setIpBndNm(ipBndVo.getIpBndNm());
            ipBndVoForUpdate.setUseYn(ipBndVo.getUseYn() != null ? ipBndVo.getUseYn() : "N");
            ipBndVoForUpdate.setNetClCd(ipBndVo.getNetClCd());
            ipBndVoForUpdate.setSubnetMask(ipBndVo.getSubnetMask());
            ipBndVoForUpdate.setGtwyIpAddr(ipBndVo.getGtwyIpAddr());
            ipBndVoForUpdate.setVlan(ipBndVo.getVlan());

            // 5. 부처정보 설정
            List<IpBndInstVo> ipBndInstVoList = new ArrayList<IpBndInstVo>();
            if (ipBndVo.getIpBndInstVoList() != null) {
                for (IpBndInstVo vo : ipBndVo.getIpBndInstVoList()) {
                    IpBndInstVo ipBndInstVoForInsert = new IpBndInstVo();
                    ipBndInstVoForInsert.setBndSeq(ipBndVo.getBndSeq());
                    ipBndInstVoForInsert.setInstitutionId(vo.getInstitutionId());
                    ipBndInstVoList.add(ipBndInstVoForInsert);
                }
            }

            // 6. 용도정보 설정
            List<IpBndPrposVo> ipBndPrposVoList = new ArrayList<IpBndPrposVo>();
            for (String prposClCd : ipBndVo.getPrposClCdList()) {
                IpBndPrposVo ipBndPrposVoForUpdate = new IpBndPrposVo();
                ipBndPrposVoForUpdate.setBndSeq(ipBndVo.getBndSeq());
                ipBndPrposVoForUpdate.setPrposClCd(prposClCd);
                ipBndPrposVoList.add(ipBndPrposVoForUpdate);
            }

            // 7. 가상스위치 정보 설정
            List<VrSwtchAsgnVo> vrSwtchAsgnVoList = new ArrayList<VrSwtchAsgnVo>();
            if (null != ipBndVo.getVrSwtchList() && ipBndVo.getVrSwtchList().size() > 0) {
                for (int i = 0; i < ipBndVo.getVrSwtchList().size(); i++) {
                    VrSwtchAsgnVo vrSwtchAsgnVo = new VrSwtchAsgnVo();
                    vrSwtchAsgnVo.setBndSeq(ipBndVo.getBndSeq());
                    vrSwtchAsgnVo.setVrSwtchSeq(ipBndVo.getVrSwtchList().get(i).getVrSwtchSeq());
                    vrSwtchAsgnVoList.add(vrSwtchAsgnVo);
                }
            }

            // 8. IP대역 수정
            ipBndService.updateRnIpBndInfo(ipBndVoForUpdate, ipBndPrposVoList, vrSwtchAsgnVoList, ipBndInstVoList);
            return getSuccessProcResult(IpBndConstants.SUCCESS_MSG, IpBndConstants.UPDATE, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(IpBndConstants.ERROR_MSG);
        }
    }

    /**
     * 동기화
     *
     * @param bndSeq
     * @return
     */
    @RequestMapping(value = "/updateIpBndListSync.do", method = RequestMethod.POST)
    @OperateLog(action = "IP대역 동기화", desc = "IP대역 동기화를 수행한다.", params = { "searchVo" })
    @ResponseBody
    public ProcResultVo updateIpBndListSync(IpBndSearchVo searchVo) {
        try {
            ipBndService.updateIpBndSync(searchVo);
            return getSuccessProcResult(IpBndConstants.SUCCESS_MSG, IpBndConstants.UPDATE, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(IpBndConstants.ERROR_MSG);
        }
    }

    /**
     * IP상세 - 할당해제
     *
     * @param ipVo
     * @return
     */
    @RequestMapping(value = "/updateAsgnToUnasgnIps.do", method = RequestMethod.POST)
    @OperateLog(action = "IP 할당해제", desc = "선택한 IP들을 미할당 상태로 변경한다.", params = { "ipVo" })
    @ResponseBody
    public ProcResultVo updateAsgnToUnasgnIps(IpVo ipVo) {
        try {
            ipBndService.updateAsgnToUnasgnIps(ipVo);
            return getSuccessProcResult(IpBndConstants.SUCCESS_MSG, IpBndConstants.UPDATE, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(IpBndConstants.ERROR_MSG);
        }
    }

    /**
     * IP상세 - 수동할당
     *
     * @param ipVo
     * @return
     */
    @RequestMapping(value = "/updateUnasgnToAsgnIps.do", method = RequestMethod.POST)
    @OperateLog(action = "IP 수동할당", desc = "선택한 IP들을 선택한 가상서버에 할당한다.", params = { "ipVo" })
    @ResponseBody
    public ProcResultVo updateUnasgnToAsgnIps(IpVo ipVo) {
        try {
            ipBndService.updateUnasgnToAsgnIps(ipVo.getSelectNetwkIntfcSeq(), ipVo);
            return getSuccessProcResult(IpBndConstants.SUCCESS_MSG, IpBndConstants.UPDATE, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(IpBndConstants.ERROR_MSG);
        }
    }

    /**
     * IP상세 - 블락설정
     *
     * @param ipVo
     * @return
     */
    @RequestMapping(value = "/updateUnasgnToBlkIps.do", method = RequestMethod.POST)
    @OperateLog(action = "IP 블락설정", desc = "선택한 IP들을 블락상태로 변경한다.", params = { "ipVo" })
    @ResponseBody
    public ProcResultVo updateUnasgnToBlkIps(IpVo ipVo) {
        try {
            ipBndService.updateUnasgnToBlkIps(ipVo);
            return getSuccessProcResult(IpBndConstants.SUCCESS_MSG, IpBndConstants.UPDATE, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(IpBndConstants.ERROR_MSG);
        }
    }

    /**
     * IP상세 - 블락해제
     *
     * @param ipVo
     * @return
     */
    @RequestMapping(value = "/updateBlkToUnasgnIps.do", method = RequestMethod.POST)
    @OperateLog(action = "IP 블락해제", desc = "선택한 IP들을 미할당 상태로 변경한다.", params = { "ipVo" })
    @ResponseBody
    public ProcResultVo updateBlkToUnasgnIps(IpVo ipVo) {
        try {
            ipBndService.updateBlkToUnasgnIps(ipVo);
            return getSuccessProcResult(IpBndConstants.SUCCESS_MSG, IpBndConstants.UPDATE, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(IpBndConstants.ERROR_MSG);
        }
    }

    /**
     * IP - 상세(할당) 정보수정
     *
     * @param ipBndVo
     * @return
     */
    @RequestMapping(value = "/updateAsgnIpList.do", method = RequestMethod.POST)
    @OperateLog(action = "IP 할당목록 정보수정", desc = "IP 할당목록의 정보를 수정한다.", params = { "ipVo" })
    @ResponseBody
    public ProcResultVo updateAsgnIpList(IpVo ipVo) {
        try {
            ipBndService.updateIpList(getIpVoListByStringParser(ipVo.getCheckDataList()));
            return getSuccessProcResult(IpBndConstants.SUCCESS_MSG, IpBndConstants.UPDATE, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(IpBndConstants.ERROR_MSG);
        }

    }

    /**
     * IP - 상세(미할당) 정보수정
     *
     * @param ipBndVo
     * @return
     */
    @RequestMapping(value = "/updateUnasgnIpList.do", method = RequestMethod.POST)
    @OperateLog(action = "IP 미할당목록 정보수정", desc = "IP 미할당목록의 정보를 수정한다.", params = { "ipVo" })
    @ResponseBody
    public ProcResultVo updateUnasgnIpList(IpVo ipVo) {
        try {
            ipBndService.updateIpList(getIpVoListByStringParser(ipVo.getCheckDataList()));
            return getSuccessProcResult(IpBndConstants.SUCCESS_MSG, IpBndConstants.UPDATE, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(IpBndConstants.ERROR_MSG);
        }
    }

    /**
     * IP - 상세(블락) 정보수정
     *
     * @param ipVoList
     * @return
     */
    @RequestMapping(value = "/updateBlkIpList.do", method = RequestMethod.POST)
    @OperateLog(action = "IP 블락목록 정보수정", desc = "IP 블락목록의 정보를 수정한다.", params = { "ipVo" })
    @ResponseBody
    public ProcResultVo updateBlkIpList(IpVo ipVo) {
        try {
            ipBndService.updateIpList(getIpVoListByStringParser(ipVo.getCheckDataList()));
            return getSuccessProcResult(IpBndConstants.SUCCESS_MSG, IpBndConstants.UPDATE, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(IpBndConstants.ERROR_MSG);
        }
    }

    /**
     * IP대역 삭제
     *
     * @param request
     * @param ipBndVo
     * @return
     */
    @RequestMapping(value = "/deleteIpBnd.do", method = RequestMethod.POST)
    @OperateLog(action = "IP 대역 삭제", desc = "선택한 IP대역을 삭제한다.", params = { "searchVo" })
    @ResponseBody
    public ProcResultVo deleteIpBnd(BigDecimal bndSeq, String ipBndUseYn, String strtIp, String endIp) {
        // 사용여부가 N일 경우
        if (ipBndUseYn.toUpperCase().equals(IpBndConstants.IP_BND_USE_YN)) {
            return getFailProcResult(IpBndConstants.ERROR_MSG_IPBND_USE);
        }
        try {
            ipBndService.deleteIpBnd(bndSeq); // IP대역삭제, 가상스위치 할당정보 삭제
            return getSuccessProcResult(IpBndConstants.SUCCESS_MSG, IpBndConstants.UPDATE, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(IpBndConstants.ERROR_MSG);
        }
    }

    // /////////////////// Static Router //////////////////////////////////////////
    /**
     * 스태틱라우터 정보 저장
     *
     * @param ipBndVo
     * @return
     */
    @RequestMapping(value = "/updateSRoutList.do", method = RequestMethod.POST)
    @OperateLog(action = "스태틱라우터 정보 수정", desc = "스태틱라우터 정보를 수정한다.", params = { "sRoutVo" })
    @ResponseBody
    public ProcResultVo updateSRoutList(SRoutVo sRoutVo) {
        List<SRoutVo> preSRoutVoList = null; // 기존 Static Router 목록
        try {
            // 1. 기존 Static Router 목록 크기 조회
            if (sRoutVo.getIpBndSeq() != null) {
                preSRoutVoList = sRoutService.selectSRoutList(sRoutVo.getIpBndSeq());
            }

            if (preSRoutVoList == null) {
                // 2. 기존 목록 크기가 0이고, 전달받은 목록 크기가 0 보다 큰 경우
                if (sRoutVo.getsRoutList() != null) {
                    // insert
                    sRoutService.insertSRout(sRoutVo.getsRoutList());
                }
                else {
                    logger.info(IpBndConstants.NOTING_MSG);
                }
            }
            else {
                // 3. 기존 목록 크기가 0보다 크고, 전달받은 목록 크기가 0인 경우.
                if (sRoutVo.getsRoutList() == null || sRoutVo.getsRoutList().size() == 0) {
                    // delete
                    sRoutVo.setBndSeq(sRoutVo.getIpBndSeq());
                    sRoutService.deleteSRout(sRoutVo);
                }
                else if (sRoutVo.getsRoutList() != null || sRoutVo.getsRoutList().size() > 0) {
                    // Update (delete -> insert)
                    sRoutVo.setBndSeq(sRoutVo.getIpBndSeq());
                    sRoutService.updateSRout(sRoutVo.getsRoutList(), sRoutVo);
                }
            }
            return getSuccessProcResult(IpBndConstants.SUCCESS_MSG, IpBndConstants.UPDATE, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(IpBndConstants.ERROR_MSG);
        }
    }

    /**
     * Static Router 삭제
     *
     * @param request
     * @param ipBndVo
     * @return
     */
    @RequestMapping(value = "/deleteSRout.do", method = RequestMethod.POST)
    @OperateLog(action = "스태틱라우터 정보 삭제", desc = "스태틱라우터 정보를 삭제한다.", params = { "sRoutVo" })
    @ResponseBody
    public ProcResultVo deleteSRout(SRoutVo sRoutVo) {
        try {
            sRoutService.deleteSRout(sRoutVo);
            return getSuccessProcResult(IpBndConstants.SUCCESS_MSG, IpBndConstants.UPDATE, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return getFailProcResult(IpBndConstants.ERROR_MSG);
        }
    }

    /**
     * 가상서버 선택 화면 호출
     *
     * @param request
     * @param model
     * @param vmSearchVo
     * @param ipBndVo
     * @return
     */
    @RequestMapping(value = "/selectVmListP.do")
    public String selectVmListView(HttpServletRequest request, Model model, VmSearchVo vmSearchVo, IpVo ipVo, String netClCd, String regionId) {
        if (null != netClCd) {
            ipVo.setSelectNetClCd(netClCd);
        }
        if (null != regionId) {
            ipVo.setSelectRegionId(regionId);
        }

        if (null != ipVo.getSelectRegionId()) {
            vmSearchVo.setEqualsRegionId(ipVo.getSelectRegionId());
        }
        if (null != ipVo.getSelectNetClCd()) {
            vmSearchVo.setEqualsNetClCd(ipVo.getSelectNetClCd());
        }

        vmSearchVo.setOrderBy("vmP");
        List<VmVo> vmVoList = vmService.selectVmListPaging(vmSearchVo);
        List<CodeVo> vrlzSwTyCdList = commonService.selectCodeList(ComConstant.VRLZ_SW_TY_GRP_CD, ComConstant.VRLZ_SW_TY_PARENT_CD); // 가상화SW 코드
        List<CodeVo> osTyCdList = commonService.selectCodeList(ComConstant.OS_TY_GRP_CD, ComConstant.OS_TY_PARENT_CD, true); // 운영체제유형 코드
        List<CodeVo> statCdList = commonService.selectCodeList(ComConstant.VM_STAT_GRP_GRP_CD, ComConstant.VM_STAT_GRP_PARENT_CD, true); // 가상서버상태 코드
        List<CodeVo> netList = commonService.selectCodeList(IpBndConstants.IP_BND_NET_GRP_CD, IpBndConstants.IP_BND_NET_PARENT_CD); // 망구분코드

        model.addAttribute("title", "가상서버 선택");

        model.addAttribute("netList", netList);
        model.addAttribute("vrlzSwTyCdList", vrlzSwTyCdList);
        model.addAttribute("osTyCdList", osTyCdList);
        model.addAttribute("statCdList", statCdList);
        model.addAttribute("vmVoList", vmVoList);
        model.addAttribute("vmSearchVo", vmSearchVo);
        model.addAttribute("vmVo", new VmVo());
        model.addAttribute("ipVo", ipVo);

        return popup(request);
    }

    /**
     * NIC 목록 조회
     *
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/selectNetwkIntfcListP.do")
    public String selectNetwkIntfcList(HttpServletRequest request, Model model, @RequestParam(required = true) BigDecimal vmSeq) throws Exception {
        NetwkIntfcVo vo = new NetwkIntfcVo();
        vo.setVmSeq(vmSeq);

        List<NetwkIntfcVo> netwkIntfcList = netwkIntfcService.selectNetwkIntfcList(vo);
        model.addAttribute("netwkIntfcList", netwkIntfcList);
        return jstlView(request);
    }


    /**
    * IP대역관리 샘플 다운로드
    * @param request
    * @param response
    * @throws Exception
    */
    @RequestMapping(value = "/selectCsvDwnload.do")
    public void ipCsvDwnload(HttpServletRequest request, HttpServletResponse response) throws Exception{

	try{
	    ipBndService.exampleFileDwnLoad(request, response);
	}catch(IOException ie){
	    logger.error("IOException", ie);
	}catch(Exception e){
	    logger.error("Exception", e);
	}
    }

    /**
     * IP대역관리 엑셀(CSV) 파일 업로드
     * @param files
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws InvalidFormatException
     * @throws NotAllowedFileExtException
     */
     @OperateLog(action="IP대역 DB 업로드", desc="IP대역 DB 업로드 처리", params={"MultipartFile"}, actionType=ActionType.INSERT)
     @RequestMapping(value = "/insertCsvUpload.do", method = RequestMethod.POST)
     @ResponseBody
     public ProcResultVo csvUpload (@RequestParam(value="files") MultipartFile[] files) throws IOException, FileNotFoundException, InvalidFormatException, NotAllowedFileExtException {

     	ProcResultVo result = new ProcResultVo();

     	try{
     	    //final String path = "Z:\\Develop\\Repository\\attach\\ip";

     	    final String path =PropertiesUtil.getProperty("UPLOAD_FILE_PATH") + "/ip";

     	    File dir = new File(path);

     	    if(!dir.exists()){
     		boolean bResult = dir.mkdirs();
     		if(!bResult){
     		    throw new IOException("mkdir error");
 		}
     	    }

     	    for(MultipartFile file : files){
     		File newFile = new File(path+"/"+file.getOriginalFilename());
     		try{
     		    FileUtils.writeByteArrayToFile(newFile, file.getBytes());
     		    if(fileUpLoadForm(newFile)){
     			result.setSuccess(true);
     			result.setProcType("insert");
     		    }else{
     			result.setSuccess(false);
     			result.addMessage("IP대역 업로드에 실패하였습니다.<br>업로드 파일이 양식에 맞는지 확인해주세요.");
     		    }
     		} catch(IOException ie){
     		    result.setSuccess(false);
     		    result.addMessage("IP대역 업로드에 실패하였습니다.");
     		    logger.error("IOException", ie);
     		} catch (Exception e) {
     		    result.setSuccess(false);
     		    result.addMessage("IP대역 업로드에 실패하였습니다.");
     		    logger.error("Exception", e);
     		} finally{
     		    newFile.delete(); //서버 업로드 파일 삭제
     		}

     	    } //End of for
     	} catch (NullPointerException ne) {
     	result.setSuccess(false);
     	result.addMessage("IP대역 업로드에 실패하였습니다.");
 	logger.error("NullPointerException", ne);
     } catch (RuntimeException re) {
     	result.setSuccess(false);
     	result.addMessage("IP대역 업로드에 실패하였습니다.");
     	logger.error("RuntimeException", re);
     } catch (Exception e) {
     	result.setSuccess(false);
     	result.addMessage("IP대역 업로드에 실패하였습니다.");
     	logger.error("Exception", e);
     }

     	return result;
     }

     /**
      * IP대역관리 엑셀(CSV) 업로드 파일 파싱(VO Setting)
      * @param newFile
      */
     public boolean fileUpLoadForm(File newFile){

	 BufferedReader br    = null;
	 String line          = null;
	 String csvSplitBy    = ",";
	 String csvSplitByArr = "\\\\";

	 try{

	     //센터;IP대역명;망구분;시작IP;종료IP;서브넷마스크;게이트웨이;VLAN;사용부처;용도;스태틱라우터IP;스태틱라우터서브넷마스크;스태틱라우터게이트웨이;블록IP
	     //0    1        2      3      4      5            6          7    8        9    10             11                       12                     13
	     br = new BufferedReader(new InputStreamReader(new FileInputStream(newFile), "UTF8"));
	     br.readLine();

	     while((line = br.readLine()) !=null){   //Header 제외하고 읽는다.
		 IpBndVo ipBndVo = null;             //IP대역VO
		 IpVo blIp       = null;             //BlockIpVO
		 SRoutVo sRoutVo = null;             //스택틱라우터VO
		 List<IpBndInstVo> instList = null;  //부처VO
		 List<String> prposClCdList = null;  //용도 코드 리스트
		 List<SRoutVo> sRoutList    = null;  //스택틱라우터 리스트
		 List<String> blockIpList   = null;  //block 리스트
		 String[] prposClCd   = null;        //용도
		 String[] blockIp     = null;        //blockIp
		 String[] field       = null;
		 if(line.length() < 1 ){
		     continue;
		 }else{
		     field = line.split(csvSplitBy);
		 }

		 //logger.debug(String.format("CSV Read -> %d.[ %s | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s ]\n", cnt, field[0],field[1],field[2],field[3],field[4],field[5],field[6],field[7],field[8],field[9],field[10],field[11],field[12],field[13]));
		 //VO세팅(set)

		 ipBndVo = new IpBndVo();
		 ipBndVo.setRegionId(field[0]);   //0.regionId(센터명)
		 ipBndVo.setIpBndNm(field[1]);    //1.IP대역명
		 ipBndVo.setUseYn("Y");	          //사용여부(Y)
		 ipBndVo.setNetClCd(field[2]);    //2.망구분
		 ipBndVo.setBndStrtIp(field[3]);  //3.시작IP
		 ipBndVo.setBndEndIp(field[4]);   //4.종료IP
		 ipBndVo.setSubnetMask(field[5]); //5.서브넷마스크
		 if(field[6].length() > 0 && field[6] != null){
		     ipBndVo.setGtwyIpAddr(field[6]); //6.게이트웨이 (null 가능)
		 }else{
		     ipBndVo.setGtwyIpAddr("");
		 }
		 if(field[7].length() > 0 && field[7] !=null){
		     ipBndVo.setVlan(field[7]);	  //7.VLAN (null 가능)
		 }

		 //8.사용부처(array가능) (null 가능)
		 if(field[8].length() > 0 && field[8] != null){
		     instList = new ArrayList<IpBndInstVo>();
		     instList = parseIpBndInst(field[8]);
		     if(instList.size() > 0){ //부처 존재여부를 체크한다.
			 ipBndVo.setIpBndInstVoList(instList);
		     }else{ // 사용부처가 null이 아니면서 해당 부처는 존재하지않을때 스킵
			 continue;
		     }
		 }

		 //9.용도(array가능)
		 //  용도코드
		 //  WEB | WAS | DB | WEB BACKUP NAS | WAS BACKUP NAS | DB BACKUP NAS | WEB HEARTBEAT | WAS HEARTBEAT | DB HEARTBEAT
		 //  01  | 02  | 03 | 05             | 06             | 07            | 09            | 10            | 11
		 if(field[9].length() > 0 && field[9] != null){

		    prposClCdList = new ArrayList<String>();

		    if(field[9].length() == 1){
			prposClCdList.add("0"+field[9]); //사용자가 용도코드를 두자리로 맞추지않고 그냥 업로드 할경우 체크하여 두자리로 세팅한다.
		    }else{
			prposClCd = field[9].split(csvSplitByArr);

			for (String clCd : prposClCd) {
			    prposClCdList.add(clCd);
			}
		    }

		    ipBndVo.setPrposClCdList(prposClCdList);
		 }

		 // 추가하려는 IP대역의 IP 중복체크 (센터-망-용도 별)
		 boolean checkDuplicate = true;
		 for (String clcd : ipBndVo.getPrposClCdList()) { // HEARTBEAT일때는 중복체크를 하지 않음
		     if (clcd.equals("09") || clcd.equals("10") || clcd.equals("11") || clcd.equals("12")) {
			 checkDuplicate = false;
		     }
		 }

		 logger.debug(String.format("CSV Read -> selectCheckIpRange arg.[ strtIp :%s,  endIp : %s, regionId : %s, netId : %s]\n", field[3], field[4], field[0], field[2]));
		 if (checkDuplicate) {
		     List<IpVo> list = ipBndService.selectCheckIpRange(field[3], field[4], field[0], field[2], ipBndVo.getPrposClCdList());
		     if (0 < list.size()) {
			 continue;
		     }
		 }

		//스태틱라우터IP
		if((field.length > 10 && field[10].length() > 0) && (field.length > 11 && field[11].length() > 0) && (field.length > 12 && field[12].length() > 0)){

		    sRoutVo   = new SRoutVo();
		    sRoutList = new ArrayList<SRoutVo>();

		    sRoutVo.setIpBndAddr(field[10]);  //10.스태틱라우터IP
		    sRoutVo.setSubnetMask(field[11]); //11.스태틱라우터서브넷마스크
		    sRoutVo.setGtwyNm(field[12]);     //12.스태틱라우터게이트웨이
		    sRoutList.add(sRoutVo);
		    ipBndVo.setsRoutLists(sRoutList);
		}

		 //13.블록IP(array가능)
		if(field.length > 13 && field[13].length() > 0){
		    blockIp = field[13].split(csvSplitByArr);

		    blockIpList = new ArrayList<String>();
		    blIp        = new IpVo();
		    for (String ip : blockIp) {
			blockIpList.add(ip);
		    }
		    blIp.setCheckIps(blockIpList);
		}

		 ipBndService.insertIpBnd(ipBndVo);
		 if(field.length > 13 && blIp != null){
		     ipBndService.updateUnasgnToBlkIps(blIp);
		 }

	     } //End of while

	 }catch(FileNotFoundException e){
	     e.printStackTrace();
	 }catch(IOException e){
	     e.printStackTrace();
	 }finally{
	     if(br !=null){
		 try{
		     br.close();
		 }catch(IOException e){
		     e.printStackTrace();
		 }
	     }
	 }
	 return true;
     }

     /**
      * csv 배열필드 체크
      * @param field
      * @return
      */
     public boolean fieldArrChk(String field){
	 String[] fieldLen    = null;
	 String csvSplitByArr = "\\\\";
	 if(field.length() > 0){
	     fieldLen = field.split(csvSplitByArr);

	     if(fieldLen.length > 1){
		 return true;
	     }else{
		 return false;
	     }
	 }
	return false;
     }

     /**
      * csv 부처필드 가공(array)
      * @param field
      * @return
      */
     public List<IpBndInstVo> parseIpBndInst(String field){
	 List<IpBndInstVo> resultList = new ArrayList<IpBndInstVo>();
	 String[] fieldInst   = null;
	 String csvSplitByArr = "\\\\";


	 fieldInst = field.split(csvSplitByArr);

	 for (String instNm : fieldInst) {
	     IpBndInstVo inVo = new IpBndInstVo();
	     String insttId   = null;

	     insttId = insttService.selectInsttId(instNm);
	     if(insttId != null && !("").equals(insttId)){
		 inVo.setInstitutionId(insttService.selectInsttId(instNm)); //기관명으로 기관ID를 조회해야함
		 resultList.add(inVo);
	     }else{
		 logger.info("[ "+ instNm + " ] 해당 부처는 존재하지 않습니다.");
	     }
	}
	return resultList;
     }


     public List<IpVo> getIpVoListByStringParser2(List<RnIp> list){
    	 if(list != null)
    	 {
    		 List<IpVo> ipList = new ArrayList<IpVo>();
    		 IpVo vo = null;
    		 for(RnIp ip : list)
    		 {
    			 vo = new IpVo();
    			 vo.setBndSeq(ip.getBndSeq());
    			 vo.setIpAddr(ip.getIpAddr());
    			 vo.setNatIpAddr(ip.getNatIpAddr());
    			 vo.setVipYn(ip.getVipYn());
    			 vo.setRmk(ip.getRmk());
    			 ipList.add(vo);
    		 }

    		 return ipList;
    	 }

    	 return null;
     }


     public List<IpVo> getIpVoListByStringParser(List<String> list){

    	 String pattern = "\"[\\w]+\":\"[\\/\\!\\#\\$\\%\\.\\-\\_\\:\\[\\]\\{\\}\\(\\)\\w\\s가-힣0-9]*\"";
    	 String pattern2 = "\"[\\/\\!\\#\\$\\%\\.\\-\\_\\:\\[\\]\\{\\}\\(\\)\\w\\s가-힣0-9]*\"";

    	 List<IpVo> ipList = new ArrayList<IpVo>();
    	 IpVo vo = null;

    	 System.out.println(list.toString());

    	 if(null != list){
    		 String  input = list.toString();
    		 String[] tmpArr = null;
    		 String tmp = null;
    		 Pattern p = Pattern.compile(pattern);
    		 Matcher m = p.matcher(input);

    		 while(m.find()){

    			 tmp = input.substring(m.start() , m.end());

    			 Pattern p2 = Pattern.compile(pattern2);
        		 Matcher m2 = p2.matcher(tmp);

        		 tmpArr = new String[2];

        		 while(m2.find())
        		 {
        			 if(null == tmpArr[0])
        			 {
        				 tmpArr[0] = tmp.substring(m2.start() + 1 , m2.end() -1);
        			 }
        			 else
        			 {
        				 tmpArr[1] = tmp.substring(m2.start() + 1 , m2.end() -1);
        			 }
        		 }

				 if(null == vo) vo = new IpVo();

				 if("bndSeq".equals(tmpArr[0]) )
				 {
					 vo.setBndSeq(new Integer(tmpArr[1]));
				 }
				 else if("ipAddr".equals(tmpArr[0]) )
				 {
					 vo.setIpAddr(tmpArr[1]);
				 }
				 else if("natIpAddr".equals(tmpArr[0]) )
				 {
					 vo.setNatIpAddr(tmpArr[1]);
				 }
				 else if("vipYn".equals(tmpArr[0]) )
				 {
					 vo.setVipYn(tmpArr[1]);
				 }
				 else if("rmk".equals(tmpArr[0]) )
				 {
					 vo.setRmk(tmpArr[1]);
					 ipList.add(vo);

					 vo = null;
				 }
    		 }
    	 }
    	 return ipList;
     }
}
