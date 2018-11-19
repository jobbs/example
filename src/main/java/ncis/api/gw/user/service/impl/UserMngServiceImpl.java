/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserMngServiceImpl.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 27.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 27.     박희택         v1.0             최초생성
 *
 */
package ncis.api.gw.user.service.impl;

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
import ncis.cmn.entity.couch.ViewResponseRowVo;
import ncis.cmn.entity.couch.ViewResponseVo;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.PropertiesUtil;
import ncis.cpt.rsrc.zone.service.RegionService;
import ncis.cpt.rsrc.zone.vo.RegionVo;
import ncis.cpt.sys.code.vo.CodeVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

/**
 * @author 박희택
 *
 */
@Service("userMngService")
public class UserMngServiceImpl implements UserMngService {

	@Resource(name="commonService")
	CommonService commonService;

	@Resource(name="reqstHstryService")
	ReqstHstryService reqstHstryService;

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

	//private static final Logger LOGGER = LoggerFactory.getLogger(UserMngServiceImpl.class);
	private final ParameterizedTypeReference<DocumentResponseVo> TYPE_DOCUMENT = new ParameterizedTypeReference<DocumentResponseVo>() {};
	private final ParameterizedTypeReference<ViewResponseVo<UserMngVo>> TYPE_VIEW_MANAGER = new ParameterizedTypeReference<ViewResponseVo<UserMngVo>>() {};


	@Autowired
	private CouchDBRestTemplate template;

	/**
	 * 사용자관리 목록조회
	 * @param svo
	 * @return UserMngSearchVo
	 */
	@Override
	public List<UserMngVo> selectUserMngList(UserMngSearchVo svo)  throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

		List<UserMngVo> resultList = new ArrayList<UserMngVo>();

		String dbUrl = PropertiesUtil.getProperty("gateway.apiGwUser.url");
		String url = dbUrl+"/_design/all/_list/byParam/apiGwUserList";

		int limit = svo.getPaginationInfo().getRecordCountPerPage();
		int skip = svo.getPaginationInfo().getFirstRecordIndex();

		// 쿼리 파라미터 생성
		QueryParamVo queryParam = new QueryParamVo();
		queryParam.setInclude_docs(true);
		queryParam.setDescending(true);

		// 조회 파라미터 생성 - body 에 담길 내용 조회니까 없다
		Map<String, Object> document = new HashMap<>();
		document.put("regionId", svo.getSearchRegionId());
		document.put("sysCd", svo.getSearchSysCd());
		document.put("statCd", svo.getSearchStatCd());
		document.put("reqUsrNm", svo.getSearchReqUsrNm());

		// 목록 조회 요청
		ViewResponseVo<UserMngVo> response = template.post(url, queryParam, document, TYPE_VIEW_MANAGER);

		// 전체목록 수
		int totCnt = response.getRows().size();

		// 페이지 처리위한 count
		svo.getPaginationInfo().setTotalRecordCount(totCnt);
		// selectCnt결정
		if(totCnt > limit+skip){
			totCnt = limit;
		}

		// 조회 결과
		List<UserMngVo> result = new ArrayList<>();

		/** 코드조회 */
		List<CodeVo> sysCd = commonService.selectCodeList("046", "208", true);	// 시스템코드
		List<CodeVo> statCd = commonService.selectCodeList("047", "209", true);	// 승인상태코드
        List<RegionVo> reginItems = regionService.selectRegionAllList();

		// 조회된 문서를 List로 담는다.
		if (response.getRows() != null && response.getRows().size() > 0) {
			for (ViewResponseRowVo<UserMngVo> row : response.getRows()) {
				result.add(row.getDoc());
			}

			for(int i=skip; i<totCnt; i++){
				UserMngVo vo = new UserMngVo();
				vo.set_id(result.get(i).get_id());
				vo.set_rev(result.get(i).get_rev());
				vo.setUseReqId(result.get(i).get_id());
				vo.setRegionId(result.get(i).getRegionId());
				vo.setReqUsrNm(result.get(i).getReqUsrNm());
				vo.setReqDt(result.get(i).getReqDt());
				vo.setSysCd(result.get(i).getSysCd());
				vo.setStatCd(result.get(i).getStatCd());
				vo.setPasswd(result.get(i).getPasswd());
				vo.setAccssKey(result.get(i).getAccssKey());
				vo.setIpAddr(result.get(i).getIpAddr());
				vo.setAuthrMapng(result.get(i).getAuthrMapng());
				vo.setReqReasn(result.get(i).getReqReasn());
				vo.setRjctReasn(result.get(i).getRjctReasn());

				// 코드값 세팅
	            for(int j=0; j<reginItems.size();j++){
					if(reginItems.get(j).getRegionId().equals(result.get(i).getRegionId())){
						vo.setRegionNm(reginItems.get(j).getRegionNm());
					}
				}
				for(int j=0; j<sysCd.size();j++){
					if(sysCd.get(j).getCd().equals(result.get(i).getSysCd())){
						vo.setSysNm(sysCd.get(j).getCdNm());
					}
				}
				for(int j=0; j<statCd.size();j++){
					if(statCd.get(j).getCd().equals(result.get(i).getStatCd())){
						vo.setStatNm(statCd.get(j).getCdNm());
					}
				}

				resultList.add(vo);
			}
		}

		return resultList;
	}

	/**
	 * 사용자관리 조회
	 * @param userMngVo UserMng 내용
	 */
	@Override
	public UserMngVo selectUserMng(String useReqId) throws Exception {

		String dbUrl = PropertiesUtil.getProperty("gateway.apiGwUser.url");
		String url = dbUrl+"/_design/all/_view/apiGwUser";

		// 쿼리 파라미터 생성
		QueryParamVo queryParam = new QueryParamVo();
		queryParam.setKey(useReqId);
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
			vo.setRegionId(response.getRows().get(0).getDoc().getRegionId());
			vo.setReqUsrNm(response.getRows().get(0).getDoc().getReqUsrNm());
			vo.setReqDt(response.getRows().get(0).getDoc().getReqDt());
			vo.setSysCd(response.getRows().get(0).getDoc().getSysCd());
			vo.setStatCd(response.getRows().get(0).getDoc().getStatCd());
			vo.setAccssKey(response.getRows().get(0).getDoc().getAccssKey());
			vo.setPasswd(response.getRows().get(0).getDoc().getPasswd());
			vo.setIpAddr(response.getRows().get(0).getDoc().getIpAddr());
			vo.setAuthrMapng(response.getRows().get(0).getDoc().getAuthrMapng());
			vo.setReqReasn(response.getRows().get(0).getDoc().getReqReasn());
			vo.setRjctReasn(response.getRows().get(0).getDoc().getRjctReasn());
			vo.setApis(response.getRows().get(0).getDoc().getApis());

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
	 * 사용자관리 수정
	 * @param UserMngVo UserMng 내용
	 */
	@Override
	public void updateUserMng(UserMngVo userMngVo) throws Exception {

		/** 수정하기 전의 데이터 */
		UserMngVo preUserMngVo = userMngService.selectUserMng(userMngVo.getUseReqId());

		try{
			/** 변경내용 수정 */
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
			document.put("ipAddr",userMngVo.getIpAddr());
			if("01".equals(userMngVo.getStatCd())){		// 미승인일때 키 생성 및 수정처리
				userMngVo.setReqReasn("미승인처리");
				userMngVo.setAuthrMapng(new ArrayList<String>()); // 권한 초기화
			}else if("02".equals(userMngVo.getStatCd())){		// 승인일때 키 생성 및 수정처리
				userMngVo.setReqReasn("승인처리");
			}else if("03".equals(userMngVo.getStatCd())){		// 반려일때 키 생성 및 수정처리
				userMngVo.setReqReasn("반려처리");
				userMngVo.setAuthrMapng(new ArrayList<String>()); // 권한 초기화
			}
			document.put("authrMapng", userMngVo.getAuthrMapng());
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

			// tyk 처리 여부 구분
			if("02".equals(preUserMngVo.getStatCd()) || "02".equals(userMngVo.getStatCd())){		// 이전 상태가 승인이거나 변경상태가 승인인 경우

				/** tyk 호출 */
				TykApiResponseVo tykKeyResponseVo = new TykApiResponseVo();
				TykKeyVo tykKeyVo = new TykKeyVo();
				String newAccssKey = "";

				/** 이전 openAPI 목록 조회 */
				List<String> preTmpList = new ArrayList<String>();
				if("02".equals(preUserMngVo.getStatCd())){
					preTmpList = getOpenApiList(preUserMngVo);
				}

				/** 변경 openAPI 목록 조회 */
				List<String> updateTmpList = new ArrayList<String>();
				updateTmpList = getOpenApiList(userMngVo);

				/** tyk key 정보 세팅 */
				tykKeyVo.setOpenApiId(updateTmpList);				// key : openAPI목록
				tykKeyVo.setRegionId(preUserMngVo.getRegionId());	// key : 센터정보(header정보)

				// key 생성,수정 과 삭제 구분
				if("02".equals(userMngVo.getStatCd())){		// 변경상태가 승인인 경우
					// key 생성 과 삭제 구분
					if("02".equals(preUserMngVo.getStatCd())){	// 이전상태가 승인인 경우
						// key 수정 API 호출
						tykKeyVo.setKeyId(preUserMngVo.getAccssKey());
						tykKeyResponseVo = tykApiService.updateTykKey(tykKeyVo);
					}else{
						// key 생성 API 호출
						tykKeyResponseVo = tykApiService.insertTykKey(tykKeyVo);
					}
					newAccssKey = tykKeyResponseVo.getKey();
				}else{										// 변경상태가 미승인,반려인 경우
					// key 삭제 API 호출
					tykKeyVo.setKeyId(preUserMngVo.getAccssKey());
					tykKeyResponseVo = tykApiService.deleteTykKey(tykKeyVo);
				}

				if(!"OK".equals(tykKeyResponseVo.getStatus().toUpperCase())){
					throw new Exception("TYK Key 처리중 오류가 발생 하였습니다.");
				}


				/** key 정보 */
				UserMngVo upTmpVo = userMngService.selectUserMng(userMngVo.getUseReqId());
				document.put("_rev", upTmpVo.get_rev());
				document.put("accssKey", newAccssKey);

				// 수정 요청
				DocumentResponseVo response2 = template.put(url, null, document, TYPE_DOCUMENT);
				if(!response2.isOk()){
					throw new Exception("접근키 update 처리중 오류가 발생 하였습니다.");
				}

				if(userMngVo.getAuthrMapng() != null){
					/** tyk 호출 */
					boolean preIsOk = true;
					boolean updateIsOk = true;
					Map<String, String> preIpAddrMap = new HashMap<String, String>();
					Map<String, String> updateIpAddrMap = new HashMap<String, String>();
					TykApiResponseVo tykApiResponseVo = new TykApiResponseVo();
					TykApiVo tykApiVo = new TykApiVo();

					tykApiVo.setRegionId(preUserMngVo.getRegionId());	// api : 센터정보(header정보)

					if("02".equals(preUserMngVo.getStatCd())){
						// 이전 openAPI에서 해당 IP 삭제
						preIpAddrMap  = getIps(preTmpList);		//	#############################
						preIsOk = ipSetting(tykApiResponseVo, tykApiVo, preTmpList, preIpAddrMap);	// tykAPI 호출 #############################
					}

					TykApiVo tykApiVo2 = new TykApiVo();
					tykApiVo2.setRegionId(preUserMngVo.getRegionId());	// api : 센터정보(header정보)

					// 변경 openAPI에서 해당 IP 추가
					updateIpAddrMap  = getIps(updateTmpList);	// #############################
					updateIsOk = ipSetting(tykApiResponseVo, tykApiVo2, updateTmpList, updateIpAddrMap);	// tykAPI 호출 #############################

					if(!preIsOk && !updateIsOk){
						throw new Exception("TYK API 호출중 오류가 발생 하였습니다.");
					}
				}
				// 처리 후 갱신
				tykApiService.reloadTyk(preUserMngVo.getRegionId());
			}

			// 이력관리에 데이터 저장
			reqstHstryService.insertReqstHstry(userMngVo);
		}catch(Exception e){
			/** 오류 발생 시 원복 처리함*/
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
			document.put("accssKey", preUserMngVo.getPasswd());
			document.put("ipAddr",preUserMngVo.getIpAddr());
			document.put("authrMapng", preUserMngVo.getAuthrMapng());
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
	 * 사용자관리 삭제
	 * @param UserMngVo UserMng 내용
	 */
	@Override
	public void deleteUserMng(UserMngVo userMngVo) throws Exception {

		/** 사용자정보 조회 */
		UserMngVo userInfoVo = userMngService.selectUserMng(userMngVo.getUseReqId());

		try{
			/** 키 삭제 처리 */	// 상태가 승인일 경우 => 키삭제 처리 : 사용자의 접근키 삭제
			if("02".equals(userInfoVo.getStatCd())){

				TykApiResponseVo tykKeyResponseVo = new TykApiResponseVo();
				TykKeyVo tykKeyVo = new TykKeyVo();

				// header정보
				tykKeyVo.setRegionId(userInfoVo.getRegionId());
				tykKeyVo.setKeyId(userInfoVo.getAccssKey());

				// key 삭제 호출
				tykKeyResponseVo = tykApiService.deleteTykKey(tykKeyVo);
				if(!"OK".equals(tykKeyResponseVo.getStatus().toUpperCase())){
					throw new Exception("TYK Key 처리중 오류가 발생 하였습니다.");
				}
			}

			/** 사용자 삭제 처리 */
			// 쿼리 파라미터 생성
			QueryParamVo query = new QueryParamVo();

			query.setRev(userMngVo.getRev());

			String dbUrl = PropertiesUtil.getProperty("gateway.apiGwUser.url");
			String url = dbUrl+"/"+ userInfoVo.getUseReqId();

			// 삭제 요청
			DocumentResponseVo response = template.delete(url, query, TYPE_DOCUMENT);
			if(!response.isOk()){
				throw new Exception("delete 처리중 오류가 발생 하였습니다.");
			}

			/** API 삭제 처리  */	// 상태가 승인일 경우 => 기존권한의 openAPI에 설정되어있는 현재 사용자의 IP 삭제
			if("02".equals(userInfoVo.getStatCd())){

				boolean isOk = true;
				TykApiResponseVo tykApiResponseVo = new TykApiResponseVo();
				TykApiVo tykApiVo = new TykApiVo();
				tykApiVo.setRegionId(userInfoVo.getRegionId());	// api : 센터정보(header정보)

				/** tyk api 삭제 처리*/
				if(userInfoVo.getAuthrMapng() != null){		// 권한 매핑 정보 유무
					List<String> openApiList = new ArrayList<String>();
					Map<String, String> ipAddrMap = new HashMap<String, String>();

					openApiList = getOpenApiList(userInfoVo);	// 사용중인 openAPI목록 조회
					ipAddrMap  = getIps(openApiList);			// openAPI를 사용하고 있는 IP들

					// openAPI의 IP 세팅(tyk 호출)
					isOk = ipSetting(tykApiResponseVo, tykApiVo, openApiList, ipAddrMap);	// tykAPI 호출 #############################
					if(!isOk){
						throw new Exception("TYK api 처리중 오류가 발생 하였습니다.");
					}
				}
				// 처리 후 갱신
				tykApiService.reloadTyk(userInfoVo.getRegionId());
			}
		}catch(Exception e){
			/** api 호출 */
			Map<String, Object> document = new HashMap<String, Object>();

			document.put("_id", userInfoVo.getUseReqId());
			document.put("regionId", userInfoVo.getRegionId());
			document.put("reqUsrNm",userInfoVo.getReqUsrNm());
			document.put("reqDt",userInfoVo.getReqDt());
			document.put("chargerNm", userInfoVo.getChargerNm());
			document.put("statCd", userInfoVo.getStatCd());
			document.put("sysCd",userInfoVo.getSysCd());
			document.put("accssKey", userInfoVo.getAccssKey());
			document.put("authrMapng", userInfoVo.getAuthrMapng());
			document.put("passwd",userInfoVo.getPasswd());
			document.put("ipAddr",userInfoVo.getIpAddr());
			document.put("reqReasn",userInfoVo.getReqReasn());
			document.put("rjctReasn",userInfoVo.getRjctReasn());

			String dbUrl = PropertiesUtil.getProperty("gateway.apiGwUser.url");

			// 추가 요청
			DocumentResponseVo response = template.post(dbUrl, null, document, TYPE_DOCUMENT);

			if(!response.isOk()){
				throw new Exception("transaction 처리중 오류가 발생 하였습니다.");
			}else{
				throw new Exception(e.toString());
			}
		}
	}

	/**
	 * 키재발급
	 * @param UserMngVo UserMng 내용
	 */
	@Override
	public void reIssuedUserMng(UserMngVo userMngVo) throws Exception {

		boolean preIsOk = true;
		/** 수정하기 전의 데이터 */
		UserMngVo preUserMngVo = userMngService.selectUserMng(userMngVo.getUseReqId());

		try{
			/** tyk 호출 */
			TykApiResponseVo tykKeyDelResponseVo = new TykApiResponseVo();
			TykApiResponseVo tykKeyInsResponseVo = new TykApiResponseVo();
			TykKeyVo tykKeyVo = new TykKeyVo();

			/** tyk key 정보 세팅 */
			tykKeyVo.setRegionId(preUserMngVo.getRegionId());	// key : 센터정보(header정보)

			// 이전 openAPI에서 해당 IP 삭제
			List<String> preTmpList = new ArrayList<String>();
			preTmpList = getOpenApiList(preUserMngVo);

			/** tyk key 정보 세팅 */
			tykKeyVo.setOpenApiId(preTmpList);				// key : openAPI목록
			tykKeyVo.setRegionId(preUserMngVo.getRegionId());	// key : 센터정보(header정보)
			// key 생성 API 호출
			tykKeyInsResponseVo = tykApiService.insertTykKey(tykKeyVo);

			if(!preIsOk){
				throw new Exception("TYK Key 등록중 오류가 발생 하였습니다.");
			}

			// key 삭제 API 삭제
			tykKeyVo.setKeyId(preUserMngVo.getAccssKey());
			tykKeyDelResponseVo = tykApiService.deleteTykKey(tykKeyVo);

			if(!"OK".equals(tykKeyDelResponseVo.getStatus().toUpperCase())){
				throw new Exception("TYK Key 삭제중 오류가 발생 하였습니다.");
			}

			/** 새로 발급받은 접근키 update */
			/** api 호출 : UPDATE 요청시 _id, _rev 정보는 필수값이다.*/
			Map<String, Object> document = new HashMap<String, Object>();
			document.put("_rev", preUserMngVo.get_rev());
			document.put("regionId", preUserMngVo.getRegionId());
			document.put("reqUsrNm",preUserMngVo.getReqUsrNm());
			document.put("reqDt",preUserMngVo.getReqDt());
			document.put("chargerNm", preUserMngVo.getChargerNm());
			document.put("statCd", preUserMngVo.getStatCd());
			document.put("sysCd",preUserMngVo.getSysCd());
			document.put("passwd",preUserMngVo.getPasswd());
			document.put("accssKey", tykKeyInsResponseVo.getKey());
			document.put("authrMapng", preUserMngVo.getAuthrMapng());
			document.put("ipAddr",preUserMngVo.getIpAddr());
			preUserMngVo.setReqReasn("키 재발급 요청");
			document.put("reqReasn",preUserMngVo.getReqReasn());
			document.put("rjctReasn",preUserMngVo.getRjctReasn());

			String dbUrl = PropertiesUtil.getProperty("gateway.apiGwUser.url");
			String url = dbUrl+"/"+ preUserMngVo.getUseReqId();

			// 수정 요청
			DocumentResponseVo response = template.put(url, null, document, TYPE_DOCUMENT);

			if(!response.isOk()){
				throw new Exception("udpate 처리중 오류가 발생 하였습니다.");
			}

			// 이력관리에 데이터 저장
			reqstHstryService.insertReqstHstry(userMngVo);

		}catch(Exception e){
			throw new Exception(e.toString());
		}

	}

	/**
	 * 사용자가 사용하고 있는 openAPI 목록
	 * @param UseMngVo UseMngVo
	 * @return List<String>
	 */
	public List<String> getOpenApiList(UserMngVo vo) throws Exception {

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
	 * TYK API 호출
	 * @param TykApiResponseVo tykApiResponseVo, TykApiVo tykApiVo,List<String> tmpList, Map<String, String> tmpMap
	 * @return boolean
	 */
	public boolean ipSetting(TykApiResponseVo tykApiResponseVo, TykApiVo tykApiVo,List<String> tmpList, Map<String, String> tmpMap) throws Exception{

		boolean isOk = true;

		for(int k=0; k < tmpList.size(); k++){	// 승인된 사용자의 openAPI정보

			OpenApiVo openApiVo = openApiService.selectOpenApi(tmpList.get(k));

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
			for(String str:tmpMap.keySet()){
				if(str.equals(openApiVo.getOpApiId())){
					String [] ips = tmpMap.get(openApiVo.getOpApiId()+"").split("/");
					for(int x = 0; x < ips.length; x++){
						allowedIpsList.add(ips[x]);
					}
				}
			}
			tykApiVo.setAllowed_ips(allowedIpsList);

			tykApiResponseVo = tykApiService.insertTykApi(tykApiVo);
			if(!"OK".equals(tykApiResponseVo.getStatus().toUpperCase())){
				isOk = false;
			}
		}
		return isOk;
	}
}
