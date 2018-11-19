/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UseReqServiceImpl.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     박희택         v1.0             최초생성
 *
 */
package ncis.api.gw.use.service.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import ncis.api.cmn.tyk.service.TykApiService;
import ncis.api.cmn.tyk.vo.TykApiResponseVo;
import ncis.api.cmn.tyk.vo.TykApiVo;
import ncis.api.cmn.tyk.vo.TykKeyVo;
import ncis.api.gw.hstry.service.ReqstHstryService;
import ncis.api.gw.use.service.UseMngService;
import ncis.api.gw.user.service.UserMngService;
import ncis.api.gw.user.vo.UserMngSearchVo;
import ncis.api.gw.user.vo.UserMngVo;
import ncis.api.opapi.authr.service.AuthrService;
import ncis.api.opapi.authr.vo.AuthrSearchVo;
import ncis.api.opapi.authr.vo.AuthrVo;
import ncis.api.opapi.opapi.service.OpenApiService;
import ncis.api.opapi.opapi.vo.OpenApiSearchVo;
import ncis.api.opapi.opapi.vo.OpenApiVo;
import ncis.cmn.couch.CouchDBRestTemplate;
import ncis.cmn.entity.couch.DocumentResponseVo;
import ncis.cmn.entity.couch.QueryParamVo;
import ncis.cmn.entity.couch.ViewResponseVo;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.PropertiesUtil;
import ncis.cpt.rsrc.zone.service.RegionService;
import ncis.cpt.rsrc.zone.vo.RegionVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

/**
 * @author 박희택
 *
 */
@Service("useMngService")
public class UseMngServiceImpl implements UseMngService{


	@Resource(name="commonService")
	CommonService commonService;

	@Resource(name="reqstHstryService")
	ReqstHstryService reqstHstryService;

	@Resource(name="userService")
	UserService userService;

	@Resource(name="tykApiService")
	TykApiService tykApiService;

	@Resource(name="authrService")
	AuthrService authrService;

	@Resource(name="userMngService")
	UserMngService userMngService;

	@Resource(name="openApiService")
	OpenApiService openApiService;

	@Resource(name="regionService")
	RegionService regionService;

	private final ParameterizedTypeReference<DocumentResponseVo> TYPE_DOCUMENT = new ParameterizedTypeReference<DocumentResponseVo>() {};
	private final ParameterizedTypeReference<ViewResponseVo<UserMngVo>> TYPE_VIEW_MANAGER = new ParameterizedTypeReference<ViewResponseVo<UserMngVo>>() {};

	@Autowired
	private CouchDBRestTemplate template;

//	@Autowired
//	private JavaMailSender mailSender;
//


	/**
	 * 로그인 체크
	 * @param userMngVo ApiGwUser 내용
	 */
	@Override
	public UserMngVo apiLoginChk(UserMngVo userMngVo) throws Exception {

		String dbUrl = PropertiesUtil.getProperty("gateway.apiGwUser.url");
		String url = dbUrl+"/_design/all/_view/apiGwUser";

		// 쿼리 파라미터 생성
		QueryParamVo queryParam = new QueryParamVo();
		String useReqId = userMngVo.getRegionId()+"_"+userMngVo.getSysCd();
		queryParam.setKey(useReqId);
		queryParam.setInclude_docs(true);

		// 조회 요청
		ViewResponseVo<UserMngVo> response = template.get(url, queryParam, TYPE_VIEW_MANAGER);


		// 조회 결과
		if (response.getRows() != null && response.getRows().size() == 1) {

			UserMngVo vo = new UserMngVo();

			vo.setSysCd(response.getRows().get(0).getDoc().getSysCd());
			vo.setRev(response.getRows().get(0).getDoc().getRev());
			vo.setPasswd(response.getRows().get(0).getDoc().getPasswd());
			vo.setUseReqId(response.getRows().get(0).getDoc().get_id());

			return vo;
		}
		else {
			return null;
		}

	}

	/**
	 * 사용관리 조회
	 * @param userMngVo UserMng 내용
	 */
	@Override
	public UserMngVo selectUseMng(String sysCd) throws Exception {

		String dbUrl = PropertiesUtil.getProperty("gateway.apiGwUser.url");
		String url = dbUrl+"/_design/all/_view/apiGwUser";

		// 쿼리 파라미터 생성
		QueryParamVo queryParam = new QueryParamVo();
		queryParam.setKey(sysCd);
		queryParam.setInclude_docs(true);

		// 조회 요청
		ViewResponseVo<UserMngVo> response = template.get(url, queryParam, TYPE_VIEW_MANAGER);

		/** 코드조회 */
		List<CodeVo> sysCdList = commonService.selectCodeList("046", "208", true);	// 시스템코드
		List<RegionVo> reginItems = regionService.selectRegionAllList();

		// 조회 결과
		if (response.getRows() != null && response.getRows().size() == 1) {

			UserMngVo vo = new UserMngVo();
			vo.set_id(response.getRows().get(0).getDoc().get_id());
			vo.set_rev(response.getRows().get(0).getDoc().get_rev());
			vo.setUseReqId(response.getRows().get(0).getDoc().get_id());
			vo.setRev(response.getRows().get(0).getDoc().get_rev());
			vo.setRegionId(response.getRows().get(0).getDoc().getRegionId());
			vo.setReqUsrNm(response.getRows().get(0).getDoc().getReqUsrNm());
			vo.setReqDt(response.getRows().get(0).getDoc().getReqDt());
			vo.setSysCd(response.getRows().get(0).getDoc().getSysCd());
			vo.setStatCd(response.getRows().get(0).getDoc().getStatCd());
			vo.setChargerNm(response.getRows().get(0).getDoc().getChargerNm());
			vo.setPasswd(response.getRows().get(0).getDoc().getPasswd());
			vo.setAccssKey(response.getRows().get(0).getDoc().getAccssKey());
			vo.setIpAddr(response.getRows().get(0).getDoc().getIpAddr());
			vo.setAuthrMapng(response.getRows().get(0).getDoc().getAuthrMapng());
			vo.setReqReasn(response.getRows().get(0).getDoc().getReqReasn());
			vo.setRjctReasn(response.getRows().get(0).getDoc().getRjctReasn());
			vo.setApis(response.getRows().get(0).getDoc().getApis());

			// 코드값 세팅
			for(int j=0; j<reginItems.size();j++){
				if(reginItems.get(j).getRegionId().equals(response.getRows().get(0).getDoc().getRegionId())){
					vo.setRegionNm(reginItems.get(j).getRegionNm());
				}
			}
			for(int j=0; j<sysCdList.size();j++){
				if(sysCdList.get(j).getCd().equals(response.getRows().get(0).getDoc().getSysCd())){
					vo.setSysNm(sysCdList.get(j).getCdNm());
				}
			}

			return vo;
		}
		else {
			return null;
		}

	}

	/**
	 * 사용신청 수정
	 * @param UseMngVo UseMng 내용
	 */
	@Override
	public void updateUseMng(UserMngVo userMngVo) throws Exception {

		/** 수정하기 전의 데이터 */
		UserMngVo preUserMngVo = userMngService.selectUserMng(userMngVo.getUseReqId());

		try{
			// 수정전 상태가 승인이고 IP가 변경되었을 경우 => 키 삭제 처리 : 사용자의 접근키 삭제
			if("02".equals(preUserMngVo.getStatCd()) && !preUserMngVo.getIpAddr().equals(userMngVo.getIpAddr())){

				/** tyk 호출 */
				TykApiResponseVo tykKeyResponseVo = new TykApiResponseVo();
				TykKeyVo tykKeyVo = new TykKeyVo();

				/** tyk key 정보 세팅 */
				tykKeyVo.setRegionId(preUserMngVo.getRegionId());	// key : 센터정보(header정보)

				/** tyk key 삭제 처리 */
				if(!"".equals(preUserMngVo.getAccssKey()) && preUserMngVo.getAccssKey() != null){		// 키 정보 유무
					// key 삭제  호출
					tykKeyVo.setKeyId(preUserMngVo.getAccssKey());
					tykKeyResponseVo = tykApiService.deleteTykKey(tykKeyVo);
					if(!"OK".equals(tykKeyResponseVo.getStatus().toUpperCase())){
						throw new Exception("TYK Key 삭제중 오류가 발생 하였습니다.");
					}
				}
			}

			/** 사용신청 재신청 시 변경사항 처리 */
			// IP가 변경되었을 경우
			if(!preUserMngVo.getIpAddr().equals(userMngVo.getIpAddr())){		// 초기화 처리 : 접근키, 반려사유, 담당자, 권한, 상태(미승인)
				userMngVo.setAccssKey("");
				userMngVo.setRjctReasn("");
				userMngVo.setChargerNm("");
				userMngVo.setAuthrMapng(new ArrayList<String>());
				userMngVo.setStatCd("01");
			}

			/** api 호출 : UPDATE 요청시 _id, _rev 정보는 필수값이다.*/
			Map<String, Object> document = new HashMap<String, Object>();
			document.put("_rev", userMngVo.getRev());
			document.put("regionId", userMngVo.getRegionId());
			document.put("reqUsrNm",userMngVo.getReqUsrNm());
			document.put("reqDt",userMngVo.getReqDt());
			document.put("chargerNm", userMngVo.getChargerNm());
			document.put("statCd", userMngVo.getStatCd());
			document.put("sysCd",userMngVo.getSysCd());
			document.put("passwd",userMngVo.getPasswd());
			document.put("accssKey", userMngVo.getAccssKey());
			document.put("authrMapng", userMngVo.getAuthrMapng());
			document.put("ipAddr",userMngVo.getIpAddr());
			document.put("reqReasn",userMngVo.getReqReasn());
			document.put("rjctReasn",userMngVo.getRjctReasn());
			document.put("apis",userMngVo.getApis());

			String dbUrl = PropertiesUtil.getProperty("gateway.apiGwUser.url");
			String url = dbUrl+"/"+ userMngVo.getUseReqId();

			// 수정 요청
			DocumentResponseVo response = template.put(url, null, document, TYPE_DOCUMENT);
			if(!response.isOk()){
				throw new Exception("update 처리중 오류가 발생 하였습니다.");
			}

			// 수정전 상태가 승인이고 IP가 변경되었을 경우
			// API 삭제 처리 : 기존권한의 openAPI에 설정되어있는 현재 사용자의 IP 삭제
			if("02".equals(preUserMngVo.getStatCd()) && !preUserMngVo.getIpAddr().equals(userMngVo.getIpAddr())){

				/** tyk 호출 */
				TykApiResponseVo tykApiResponseVo = new TykApiResponseVo();
				TykApiVo tykApiVo = new TykApiVo();
				tykApiVo.setRegionId(preUserMngVo.getRegionId());	// api : 센터정보(header정보)

				/** tyk api 삭제 처리*/
				if(preUserMngVo.getAuthrMapng() != null){		// 권한 매핑 정보 유무
					List<String> openApiList = new ArrayList<String>();
					Map<String, String> ipAddrMap = new HashMap<String, String>();

					openApiList = getOpenApiList(preUserMngVo);	// 사용중인 openAPI목록 조회
					ipAddrMap  = getIps(openApiList);	// openAPI를 사용하고 있는 IP들

					// openAPI의 IP 세팅(tyk 호출)
					for(int k=0; k < openApiList.size(); k++){	// 승인된 사용자의 openAPI정보

						OpenApiVo openApiVo = openApiService.selectOpenApi(openApiList.get(k));

						// 변경정보 입력
						tykApiVo.setName(openApiVo.getOpApiId());	// pk
						tykApiVo.setSlug(openApiVo.getOpApiId());	// name과 동일
						tykApiVo.setApi_id(openApiVo.getOpApiId());
						tykApiVo.setListenPath(openApiVo.getUri());

						// 상태가 활성,비활성일 경우
						if("Y".equals(openApiVo.getStatCd())){
							tykApiVo.setActive(true);
						}else{
							tykApiVo.setActive(false);
						}

						// virtual Path 설정
						// 체크요 : /(root) 로변경처리해야함
						if("/".equals(openApiVo.getUri())){
							tykApiVo.setUrlType("root");
						}else{
							tykApiVo.setUrlType("");
						}

						// 서비스디스커버리 여부
						tykApiVo.setSvcDscvryYn(openApiVo.getSvcDscvryYn());
						tykApiVo.setSvcDscvryQueryEp(openApiVo.getTargetHstAddr());

						// 사용자의 승인 처리시 세팅
						// 존망 처리 구분 : 존망일경우 무조건 127.0.0.1을 넣어준다.
						List<String> allowedIpsList = new ArrayList<String>();

						// ip 세팅
						for(String str:ipAddrMap.keySet()){
							if(str.equals(openApiVo.getOpApiId())){
								String [] ips = ipAddrMap.get(openApiVo.getOpApiId()+"").split("/");
								for(int x = 0; x < ips.length; x++){
									allowedIpsList.add(ips[x]);
								}
							}
						}
						tykApiVo.setAllowed_ips(allowedIpsList);
						tykApiResponseVo = tykApiService.insertTykApi(tykApiVo);

						if(!"OK".equals(tykApiResponseVo.getStatus().toUpperCase())){
							throw new Exception("TYK api 수정중 오류가 발생 하였습니다.");
						}
					}
				}
				// 처리 후 갱신
				tykApiService.reloadTyk(preUserMngVo.getRegionId());
			}

			// 이력관리에 데이터 저장
			reqstHstryService.insertReqstHstry(userMngVo);

		}catch(Exception e){

			UserMngVo updateUserMngVo = userMngService.selectUserMng(preUserMngVo.getUseReqId());

			/** api 호출 : UPDATE 요청시 _id, _rev 정보는 필수값이다.*/
			Map<String, Object> document = new HashMap<String, Object>();
			document.put("_rev", updateUserMngVo.get_rev());
			document.put("regionId", preUserMngVo.getRegionId());
			document.put("reqUsrNm",preUserMngVo.getReqUsrNm());
			document.put("reqDt",preUserMngVo.getReqDt());
			document.put("chargerNm", preUserMngVo.getChargerNm());
			document.put("statCd", preUserMngVo.getStatCd());
			document.put("sysCd",preUserMngVo.getSysCd());
			document.put("passwd",preUserMngVo.getPasswd());
			document.put("accssKey", preUserMngVo.getAccssKey());
			document.put("authrMapng", preUserMngVo.getAuthrMapng());
			document.put("ipAddr",preUserMngVo.getIpAddr());
			document.put("reqReasn",preUserMngVo.getReqReasn());
			document.put("rjctReasn",preUserMngVo.getRjctReasn());
			document.put("apis",userMngVo.getApis());

			String dbUrl = PropertiesUtil.getProperty("gateway.apiGwUser.url");
			String url = dbUrl+"/"+ preUserMngVo.getUseReqId();

			// 수정 요청
			DocumentResponseVo response = template.put(url, null, document, TYPE_DOCUMENT);

			if(!response.isOk()){
				throw new Exception("transaction 처리중 오류가 발생 하였습니다.");
			}else{
				throw new Exception(e.toString());
			}
		}
	}

	/**
	 * 사용자가 사용하고 있는 openAPI 목록
	 * @param UseMngVo UseMngVo
	 * @return List<String>
	 */
	public List<String> getOpenApiList(UserMngVo vo) throws Exception {

//		/** 전체 권한 조회 */
//		AuthrSearchVo authrSearcVo = new AuthrSearchVo();
//		List<AuthrVo> authrList = authrService.selectAuthrList(authrSearcVo);
//		Map<String, AuthrVo> authrMap = new HashMap<String, AuthrVo>();
//
//		/** 전체 openApi 조회 */
//		OpenApiSearchVo openApiSearchVo = new OpenApiSearchVo();
//		List<OpenApiVo> openApiList = openApiService.selectOpenApiList(openApiSearchVo);
//		Map<String, OpenApiVo> openApiMap = new HashMap<String, OpenApiVo>();
//
//		// 권한 정보를 map에 담음
//		for (AuthrVo tmpVo : authrList) {
//			authrMap.put(tmpVo.get_id(), tmpVo);
//		}
//
//		// openApi 정보를 map에 담음
//		for (OpenApiVo tmpVo : openApiList) {
//			openApiMap.put(tmpVo.get_id(), tmpVo);
//		}
//
//		// 사용자에 설정된 openApi 정보
//		List<String> tmpOpenApiList = new ArrayList<String>();
//		for( String tmpAuthr : vo.getAuthrMapng()) {						// 사용자가 사용하고 있는 권한 목록
//			tmpAuthr = tmpAuthr.substring(0, 14);
//			if( authrMap.containsKey(tmpAuthr) ) {
//				AuthrVo authr = authrMap.get(tmpAuthr);
//				for( String tmpOpenApi : authr.getApiMapng() ) {			// 권한이 사용하고 있는 openAPI 목록
//					tmpOpenApi = tmpOpenApi.substring(0,16);
//					if( openApiMap.containsKey(tmpOpenApi)) {				// 해당권한일 경우
//						tmpOpenApiList.add(tmpOpenApi);						// 에만 리스트에 담는다.
//					}
//				}
//			}
//		}

		// 권한에 설정되 있는 openApi ID 추출
		List<String> tmpList = new ArrayList<String>();
		for (int i=0; i< vo.getAuthrMapng().size(); i++) {
			String authrId = vo.getAuthrMapng().get(i).substring(0, 14);

			// 사용자가 가지고 권한ID를 가지고 openAPI 조회
			AuthrVo authrVo = authrService.selectAuthr(authrId);
			// 권한에 속해있는 openAPI ID 를 보내줘야 함
			for (String opApiId : authrVo.getApiMapng()) {
				if(!tmpList.contains(opApiId.substring(0, 16))){
					tmpList.add(opApiId.substring(0, 16));
				}
			}
		}

		// 중복 제거
		HashSet<String> distnictData = new HashSet<String>(tmpList);
		List<String> useOpenApiList = new ArrayList<String>(distnictData);

		return useOpenApiList;
	}

	/**
	 * openAPI를 사용하고 있는 사용자의 IP 정보 조회
	 * @param UseMngVo UseMngVo
	 * @return Map
	 */
	public Map<String, String> getIps(List<String> useOpenApiList) throws InvocationTargetException,IOException, NoSuchMethodException,IllegalAccessException {

		/** 전체 사용자 조회 */
		UserMngSearchVo userMngSearchVo = new UserMngSearchVo();
		List<UserMngVo> userList = userMngService.selectUserMngList(userMngSearchVo);

		/** 전체 권한 조회 */
		AuthrSearchVo authrSearcVo = new AuthrSearchVo();
		List<AuthrVo> authrList = authrService.selectAuthrList(authrSearcVo);
		Map<String, AuthrVo> authrMap = new HashMap<String, AuthrVo>();

		/** 전체 openApi 조회 */
		OpenApiSearchVo openApiSearchVo = new OpenApiSearchVo();
		List<OpenApiVo> openApiList = openApiService.selectOpenApiList(openApiSearchVo);
		Map<String, OpenApiVo> openApiMap = new HashMap<String, OpenApiVo>();

		// 권한 정보를 map에 담음
		for (AuthrVo tmpVo : authrList) {
			authrMap.put(tmpVo.get_id(), tmpVo);
		}

		// openApi 정보를 map에 담음
		for (OpenApiVo tmpVo : openApiList) {
			openApiMap.put(tmpVo.get_id(), tmpVo);
		}

		// openApi를 사용하고 있는 사용자의 IP 정보
		Map<String, String> ipsMap = new HashMap<String, String>();

		// 사용중인 openAPI를 사용하고 있는 권한 목록
		for( int i = 0; i < useOpenApiList.size(); i++ ) {	// 사용자가 사용하고 있는 openAPI 목록
			List<String>tmpIpList = new ArrayList<String>();
			String tmpIps = "";

			for(int j = 0; j< authrList.size(); j++){	// 권한  목록
				AuthrVo authr = authrList.get(j);
				for(int k = 0; k < authr.getApiMapng().size(); k++){	// 권한이 사용하고 있는 openAPI 목록
					if( authr.getApiMapng().get(k).substring(0, 16).indexOf(useOpenApiList.get(i)) >= 0 ) {	// openAPI를 사용하고 있는 지 체크

						for(int m = 0; m < userList.size(); m++){	// 사용자 목록
							UserMngVo user = userList.get(m);
							if(user.getAuthrMapng() != null){	// 미승인 경우 없는 권한이 없음
								for(int n = 0; n < user.getAuthrMapng().size(); n++){	// 사용자가 사용하고 있는 권한 목록
									if( user.getAuthrMapng().get(n).substring(0, 14).indexOf(authr.get_id()) >= 0 ) {	// 권한을 사용하고 있는지 체크

										for(int y=0; y < user.getIpAddr().size(); y++){	// 사용자의 ip 목록
											if(!tmpIpList.contains(user.getIpAddr().get(y))){
												tmpIpList.add(user.getIpAddr().get(y));
											}
										}

									}
								}
							}
						}

					}
				}
			}

			for(int z=0; z<tmpIpList.size(); z++){
				tmpIps += tmpIpList.get(z);
				if(z != (tmpIpList.size()-1)){
					tmpIps +="/";
				}
			}
			ipsMap.put(useOpenApiList.get(i), tmpIps);				// openAPI를 사용하고 있는 사용자의 IP들
		}

		return ipsMap;

	}

	/**
	 * 비밀번호 초기화 설정 후 메일 전송(일단 제외 처리됨)
	 * @param UseMngVo UseMng 내용
	 */
	@Override
	public void sendMail(UserMngVo userMngVo) throws Exception {

		// 이력관리 리스트의 최종 담당자의 ID를 가져와야 한다
		//userService.selectUser(userId);
//
//		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//		mailSender.setHost("111,222,33,44");	//SMTP 서버 가필요함
//
//		// 메일 내용을 작성한다.
//		SimpleMailMessage msg = new SimpleMailMessage();
//		msg.setFrom(("aaa@bbb.co.kr"));
//		msg.setTo(new String[] {"ccc@ddd.co.kr","eee@fff.co.kr"});
//		msg.setSubject("제목이 이러저러 합니다.");
//		msg.setText("본문이 어쩌구저쩌구합니다.");
//
//		try{
//			mailSender.send(msg);
//
//		}catch(MailException ex){
//			logger.error(ex);
//		}

	}

}
