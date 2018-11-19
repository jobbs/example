/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CptCmnController.java
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
package ncis.cpt.cmn.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.util.PropertiesUtil;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.board.service.BoardService;
import ncis.cpt.board.vo.BoardSearchVo;
import ncis.cpt.board.vo.BoardVo;
import ncis.cpt.rsrc.atmscl.service.ServcService;
import ncis.cpt.rsrc.atmscl.vo.ServcSearchVo;
import ncis.cpt.rsrc.atmscl.vo.ServcVo;
import ncis.cpt.rsrc.com.service.VmService;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.cpt.sys.alrm.service.AlrmService;
import ncis.cpt.sys.alrm.vo.AlrmSearchVo;
import ncis.cpt.sys.user.service.UserService;
import ncis.cpt.sys.user.vo.UserVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqre.lib.CQJava;
import com.gpki.gpkiapi.GpkiApi;
import com.gpki.gpkiapi.cert.X509Certificate;
import com.gpki.gpkiapi.exception.GpkiApiException;
import com.gpki.gpkiapi.ivs.VerifyCert;
import com.gpki.gpkiapi.storage.Disk;

@Controller("cptCmnController")
public class CptCmnController extends BaseController {

	@Resource(name="boardService")
	private BoardService boardService;

	@Resource(name="vmService")
    private VmService vmService;

	@Resource(name="alrmService")
    private AlrmService alrmService;

	@Resource(name="userService")
    private UserService userService;

	@Resource(name="servcService")
	ServcService servcService;


//	private static String[] ipList = {"127.0.0.1","10.180.227.225", "10.180.227.9",
//										"10.183.45.108", "10.183.45.56",
//										"10.180.234.126","10.180.234.131","10.180.249.65","10.180.249.68",
//										"10.180.249.60", "10.180.249.66","10.180.249.115","10.180.249.118","10.180.249.121","10.180.249.122",
//										"10.183.45.56", "10.183.45.110", "10.183.45.108","10.183.45.101", "10.180.245.12"
//// 대전 클라우드 운영팀 테스트용
//										, "10.180.227.57" , "10.180.227.75" , "10.180.227.77" , "10.180.227.73" , "10.180.227.58" , "10.180.227.88" , "10.180.227.59"
//
//										};

	/**
	 * <pre>
	 * 로그인 화면을 호출한다.
	 * </pre>
	 *
	 * @return
	 */
	@RequestMapping(value = "/login.do")
	public String login(HttpServletRequest request, Model model, String error) {
		model.addAttribute("error", error);
		return "cmn/login";
	}

	@RequestMapping(value = "/super/login.do")
    public String superUserlogin(HttpServletRequest request) {

//		String localAddr = request.getRemoteAddr();
//
//		System.out.println("localhost ip ::"+localAddr);
//
//		boolean hasAuth = false;
//		for(String tmp : ipList)
//		{
//			if(tmp.equals(localAddr))
//			{
//				hasAuth = true;
//				break;
//			}
//		}
//
//		if(hasAuth)
//		{
//			return "cmn/superUserlogin";
//		}
//		else
//		{
//			return "error/accessDenied";
//		}
        return "cmn/superUserlogin";
    }

	@RequestMapping(value="/error/common.do")
    public String handlerError(HttpServletRequest request) {
        return jstlView("error/common");
    }


	/** <pre>
	 * 사용자 index 화면 호출
	 * </pre>
	 *
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={"/", "/index.do", "/cpt/","/cpt/index.do"})
	public String index(HttpServletRequest request, Model model) {

		if( null == getUser() ) {
			return redirect("/login.do");
		}

		//공지사항
		BoardSearchVo noticeSearchVo = new BoardSearchVo();
		noticeSearchVo.setBoardCd("notice");
		noticeSearchVo.getPaginationInfo().setRecordCountPerPage(9);
		List<BoardVo> noticeList = boardService.selectBoardList(noticeSearchVo);

		//가상서버목록
		VmSearchVo vmSearchVo = new VmSearchVo();
		vmSearchVo.getPaginationInfo().setRecordCountPerPage(15);
		vmSearchVo.setOrderBy("rt");
		List<VmVo> vmList = vmService.selectVmListPaging(vmSearchVo);

		//자동확장서비스목록
		ServcSearchVo servcSearchVo = new ServcSearchVo();
		servcSearchVo.getPaginationInfo().setRecordCountPerPage(15);
		servcSearchVo.setSearchType("usage_order");
		List<ServcVo> servcList = servcService.selectServcList(servcSearchVo);


		AlrmSearchVo alrmSearchVo = new AlrmSearchVo();
		alrmSearchVo.setSearchConfirmYn("N");
		int cntAlrm = alrmService.selectAlrmTotCnt(alrmSearchVo);

		model.addAttribute("vmList", vmList);
		model.addAttribute("cntAlrm", cntAlrm);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("servcList", servcList);

		return "portalIndex";
	}

	@RequestMapping(value = "/insertPKI.do", method=RequestMethod.GET)
    public String insertPKIView(HttpServletRequest request) {
        return popup("cmn/insertPKIP");
    }

    @RequestMapping(value = "/insertPKI.do", method=RequestMethod.POST)
    @ResponseBody
    public ProcResultVo insertPKI(HttpServletRequest request, UserVo user) {

    	try {
	    	String serviceIniKey = PropertiesUtil.getProperty("pki.service.ini.key");

	        int isError = -1;

	//        if( "".equals(user.getUserId()) || "".equals(user.getPasswd()) || "".equals(user.getCrtfctKey()) || "".equals(user.getOrgMsg())) {
	        if( "".equals(user.getUserId()) || "".equals(user.getCrtfctKey()) || "".equals(user.getOrgMsg())) {
	            return getFailProcResult("아이디를 입력하여 주시기 바랍니다.");
	        }

	        UserVo tmpUser = userService.selectUser(user.getUserId());
			if( null == tmpUser ) {
				return getFailProcResult("사용자 정보가 올바르지 않습니다.");
			}

	//		if( !tmpUser.getPasswd().equals(user.getPasswd()) ) {
	//            return getFailProcResult("비밀번호가 일치하지 않습니다.");
	//        }

	        isError = CQJava.CQJInit(serviceIniKey);
	        if( isError != 0 ) {
//	            return getFailProcResult("Error Num [100] : 인증서 초기화 실패");
	        	return getFailProcResult("Error Num [" + CQJava.CQJGetErrorNum() + "] : " + CQJava.CQJGetErrorMsg());
	        }

	        //TODO KEY 변경 필요
	    	String strVerifiedData = CQJava.CQJVerifyData(serviceIniKey, 1, user.getCrtfctKey(), user.getOrgMsg());
	    	if("".equals(strVerifiedData))
	    	{
	    		return getFailProcResult("Error Num [" + CQJava.CQJGetErrorNum() + "] : " + CQJava.CQJGetErrorMsg());
	    	}

	    	String strCert = CQJava.CQJGetCertificateFromSignedData(user.getCrtfctKey());
	    	if("".equals(strCert))
	    	{
	    		return getFailProcResult("Error Num [" + CQJava.CQJGetErrorNum() + "] : " + CQJava.CQJGetErrorMsg());
	    	}

	    	String dn = CQJava.CQJGetCertInfoFromSignedData(user.getCrtfctKey(), "CERT_SUBJECT");


	    	/* *************************************************************************************
	    	 * GPKI IVS 테스트 시작
	    	 * 		GPKI를 통하여 인증서 만료 및 폐기에 대한 유효성 체크 처리
	    	 * *************************************************************************************/
	    	strCert = "-----BEGIN CERTIFICATE-----" + strCert + "-----END CERTIFICATE-----";

	    	GpkiApi.init(PropertiesUtil.getProperty("pki.gpki.conf.dir"));
	    	X509Certificate myCert = Disk.readCert(PropertiesUtil.getProperty("pki.server.cert"));

			X509Certificate cert = new X509Certificate(strCert);
	    	VerifyCert verifyCert = new VerifyCert(PropertiesUtil.getProperty("pki.gpki.conf"));

			verifyCert.setMyCert(myCert);
			verifyCert.verify(cert);
			/* *************************************************************************************
	    	 * GPKI IVS 테스트 종료
	    	 * *************************************************************************************/

			String strSubAlt = CQJava.CQJGetCertInfoFromSignedData(user.getCrtfctKey(), "CERT_SUBJECT_ALT_NAME");

	    	//TOD-DO 해당 이름만 잘라서 사용자명과 비교하여 등록되도록 처리
			String divStr = "실제이름=";
			int strLen = divStr.length();
			String userNm = strSubAlt.substring( strSubAlt.indexOf(divStr) + strLen, strSubAlt.indexOf(",", strSubAlt.indexOf(divStr) ));

			if( !tmpUser.getUserNm().equals(userNm) ) {
				return getFailProcResult("Error Num [200] : 인증서와 동일한 사용자가 아닙니다. 다시 확인하여 주시기 바랍니다.");
			}

	    	user.setCrtfctKey(dn);

	        //동일한 인증서로 등록된 사용자가 있는지 확인
	        tmpUser = userService.selectUserByDn(user.getCrtfctKey());
	        if( null != tmpUser ) {
	            return getFailProcResult("Error Num [300] : 동일한 인증서로 사용자가 등록되어 있습니다.");
	        }

	        userService.updateUserDn(user);

	        return getSuccessProcResult("인증서가 등록되었습니다.", "insertPKI");

    	} catch (GpkiApiException e) {
    		// 인증서 오류
    		return getFailProcResult(e.getMessage());
		}
     }

}
