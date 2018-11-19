/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ApiServiceImpl.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     박희택         v1.0             최초생성
 *
 */
package ncis.api.opapi.api.service.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import ncis.api.opapi.api.service.ApiService;
import ncis.api.opapi.api.vo.ApiSearchVo;
import ncis.api.opapi.api.vo.ApiVo;
import ncis.cmn.couch.CouchDBRestTemplate;
import ncis.cmn.entity.ReqParam;
import ncis.cmn.entity.RspnsResult;
import ncis.cmn.entity.couch.DocumentResponseVo;
import ncis.cmn.entity.couch.QueryParamVo;
import ncis.cmn.entity.couch.ViewResponseRowVo;
import ncis.cmn.entity.couch.ViewResponseVo;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.PropertiesUtil;
import ncis.cpt.sys.code.vo.CodeVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

/**
 * @author 박희택
 *
 */
@Service("apiService")
public class ApiServiceImpl implements ApiService{

	@Resource(name="commonService")
	CommonService commonService;

	private final ParameterizedTypeReference<DocumentResponseVo> TYPE_DOCUMENT = new ParameterizedTypeReference<DocumentResponseVo>() {};
	private final ParameterizedTypeReference<ViewResponseVo<ApiVo>> TYPE_VIEW_MANAGER = new ParameterizedTypeReference<ViewResponseVo<ApiVo>>() {};

	@Autowired
	private CouchDBRestTemplate template;

	/**
	 * OpenApi 목록조회
	 * @param openApiVo OpenApi 내용
	 */
	@Override
	public List<ApiVo> selectApiList(ApiSearchVo svo)  throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

		List<ApiVo> resultList = new ArrayList<ApiVo>();

		String dbUrl = PropertiesUtil.getProperty("gateway.api.url");
		String url = dbUrl+"/_design/all/_list/byParam/apiList";

		int limit = svo.getPaginationInfo().getRecordCountPerPage();
		int skip = svo.getPaginationInfo().getFirstRecordIndex();

		// 쿼리 파라미터 생성
		QueryParamVo queryParam = new QueryParamVo();
		queryParam.setInclude_docs(true);
		queryParam.setDescending(true);

		// 조회 파라미터 생성 - body 에 담길 내용 조회니까 없다
		Map<String, Object> document = new HashMap<>();
		document.put("stackClCd", svo.getSearchStackClCd());
		document.put("apiId", svo.getSearchApiId());
		document.put("apiNm", svo.getSearchApiNm());
		document.put("apiVerCd", svo.getSearchApiVerCd());
		document.put("methodCd", svo.getSearchMethodCd());
		document.put("uri", svo.getSearchUri());
		document.put("dc", svo.getSearchDc());

		// 목록 조회 요청
		ViewResponseVo<ApiVo> response = template.post(url, queryParam, document, TYPE_VIEW_MANAGER);

		// 전체목록 수
		int totCnt = response.getRows().size();
		int selectCnt = limit+skip;

		// 페이지 처리위한 count
		svo.getPaginationInfo().setTotalRecordCount(totCnt);

		// selectCnt결정
		if(totCnt < selectCnt){
			selectCnt = totCnt;
		}

		// 조회 결과
		List<ApiVo> result = new ArrayList<>();

		/** 코드조회 */
		List<CodeVo> stackClCd = commonService.selectCodeList("039", "201", true);	// 스택분류코드
		List<CodeVo> apiVerCd = commonService.selectCodeList("041", "203", true);	// API버전코드
		List<CodeVo> methodCd = commonService.selectCodeList("040", "202", true);	// Method코드

		// 조회된 문서를 List로 담는다.
		if (response.getRows() != null && response.getRows().size() > 0) {
			for (ViewResponseRowVo<ApiVo> row : response.getRows()) {
				result.add(row.getDoc());
			}


			for(int i=skip; i<selectCnt; i++){
				ApiVo vo = new ApiVo();

				vo.set_id(result.get(i).get_id());
				vo.set_rev(result.get(i).get_rev());
				vo.setApiId(result.get(i).getApiId());
				vo.setApiNm(result.get(i).getApiNm());
				vo.setApiVerCd(result.get(i).getApiVerCd());
				vo.setMethodCd(result.get(i).getMethodCd());
				vo.setStackClCd(result.get(i).getStackClCd());
				vo.setUri(result.get(i).getUri());
				vo.setDc(result.get(i).getDc());
				vo.setRegUserNm(result.get(i).getRegUserNm());
				vo.setRegDt(result.get(i).getRegDt());

				// 코드값 세팅
				for(int j=0; j<apiVerCd.size();j++){
					if(apiVerCd.get(j).getCd().equals(result.get(i).getApiVerCd())){
						vo.setApiVerNm(apiVerCd.get(j).getCdNm());
					}
				}

				for(int j=0; j<methodCd.size();j++){
					if(methodCd.get(j).getCd().equals(result.get(i).getMethodCd())){
						vo.setMethodNm(methodCd.get(j).getCdNm());
					}
				}

				for(int j=0; j<stackClCd.size();j++){
					if(stackClCd.get(j).getCd().equals(result.get(i).getStackClCd())){
						vo.setStackClNm(stackClCd.get(j).getCdNm());
					}
				}

				resultList.add(vo);
			}
		}

		return resultList;
	}

	/**
	 * Api 등록
	 * @param ApiVo Api 내용
	 */
	@Override
	public void insertApi(ApiVo apiVo) throws Exception {

		/** api 호출 */
		Map<String, Object> document = new HashMap<String, Object>();
		document.put("_id", apiVo.get_id());
		document.put("apiId", apiVo.getApiId());
		document.put("apiNm", apiVo.getApiNm());
		document.put("apiVerCd", apiVo.getApiVerCd());
		document.put("methodCd", apiVo.getMethodCd());
		document.put("stackClCd", apiVo.getStackClCd());
		document.put("uri", apiVo.getUri());
		document.put("dc", apiVo.getDc());
		document.put("regUserNm", apiVo.getRegUserNm());
		document.put("regDt", apiVo.getRegDt());
		document.put("cnvrRules", apiVo.getCnvrRules());
		document.put("reqParams", apiVo.getReqParams());
		document.put("rspnsResults", apiVo.getRspnsResults());


		String dbUrl = PropertiesUtil.getProperty("gateway.api.url");

		// 추가 요청
		//DocumentResponseVo response =
		template.post(dbUrl, null, document, TYPE_DOCUMENT);
	}

	/**
	 * Api 조회
	 * @param ApiVo Api 내용
	 */
	@Override
	public ApiVo selectApi(String keyId) throws Exception {

		String dbUrl = PropertiesUtil.getProperty("gateway.api.url");
		String url = dbUrl+"/_design/all/_view/api";

		// 쿼리 파라미터 생성
		QueryParamVo queryParam = new QueryParamVo();
		queryParam.setKey(keyId);
		queryParam.setInclude_docs(true);

		// 조회 요청
		ViewResponseVo<ApiVo> response = template.get(url, queryParam, TYPE_VIEW_MANAGER);

		// 조회 결과
		if (response.getRows() != null && response.getRows().size() == 1) {

			ApiVo vo = new ApiVo();

			vo.set_id(response.getRows().get(0).getDoc().get_id());
			vo.set_rev(response.getRows().get(0).getDoc().get_rev());
			vo.setApiId(response.getRows().get(0).getDoc().getApiId());
			vo.setApiNm(response.getRows().get(0).getDoc().getApiNm());
			vo.setApiVerCd(response.getRows().get(0).getDoc().getApiVerCd());
			vo.setMethodCd(response.getRows().get(0).getDoc().getMethodCd());
			vo.setStackClCd(response.getRows().get(0).getDoc().getStackClCd());
			vo.setUri(response.getRows().get(0).getDoc().getUri());
			vo.setDc(response.getRows().get(0).getDoc().getDc());
			vo.setRegUserNm(response.getRows().get(0).getDoc().getRegUserNm());
			vo.setRegDt(response.getRows().get(0).getDoc().getRegDt());
			vo.setCnvrRules(response.getRows().get(0).getDoc().getCnvrRules());

			if(commonService.selectCode(response.getRows().get(0).getDoc().getApiVerCd(),"041") != null) {
				vo.setApiVerNm(commonService.selectCode(response.getRows().get(0).getDoc().getApiVerCd(),"041").getCdNm());
			}

			if(commonService.selectCode(response.getRows().get(0).getDoc().getMethodCd(),"040") != null) {
				vo.setMethodNm(commonService.selectCode(response.getRows().get(0).getDoc().getMethodCd(),"040").getCdNm());
			}

			if(commonService.selectCode(response.getRows().get(0).getDoc().getStackClCd(),"039") != null) {
				vo.setStackClNm(commonService.selectCode(response.getRows().get(0).getDoc().getStackClCd(),"039").getCdNm());
			}

			// 없으면 세팅하지 않음
			if(response.getRows().get(0).getDoc().getReqParams() !=null){
				List<ReqParam> reqParamList = new ArrayList<ReqParam>();
				for (ReqParam reqParam : response.getRows().get(0).getDoc().getReqParams()) {

					if(commonService.selectCode(reqParam.getReqParamClCd(),"080") != null) {
						reqParam.setReqParamClNm(commonService.selectCode(reqParam.getReqParamClCd(),"080").getCdNm());
					}
					if(commonService.selectCode(reqParam.getReqParamType(),"081") != null) {
						reqParam.setReqParamTypeNm(commonService.selectCode(reqParam.getReqParamType(),"081").getCdNm());
					}

					if("Y".equals(reqParam.getReqParamEssntlAt())){
						reqParam.setReqParamEssntlAtNm("O");
					}else{
						reqParam.setReqParamEssntlAtNm(" ");
					}

					reqParamList.add(reqParam);
				}
				vo.setReqParams(reqParamList);
			}

			// 없으면 세팅하지 않음
			if(response.getRows().get(0).getDoc().getReqParams() !=null){
				List<RspnsResult> rspnsResultList = new ArrayList<RspnsResult>();
				for (RspnsResult rspnsResult : response.getRows().get(0).getDoc().getRspnsResults()) {

					if(commonService.selectCode(rspnsResult.getRspnsResultType(),"081") != null) {
						rspnsResult.setRspnsResultTypeNm(commonService.selectCode(rspnsResult.getRspnsResultType(),"081").getCdNm());
					}

					if("Y".equals(rspnsResult.getRspnsResultEssntlAt())){
						rspnsResult.setRspnsResultEssntlAtNm("O");
					}else{
						rspnsResult.setRspnsResultEssntlAtNm(" ");
					}

					rspnsResultList.add(rspnsResult);
				}

				vo.setRspnsResults(rspnsResultList);
			}

			return vo;
		} else {
			return null;
		}

	}

	/**
	 * Api 수정
	 * @param ApiVo Api 내용
	 */
	@Override
	public void updateApi(ApiVo apiVo) throws Exception {

		/** api 호출 : UPDATE 요청시 _id, _rev 정보는 필수값이다.*/
		Map<String, Object> document = new HashMap<String, Object>();
		document.put("_rev", apiVo.getRev());
		document.put("apiId", apiVo.getApiId());
		document.put("apiNm", apiVo.getApiNm());
		document.put("apiVerCd", apiVo.getApiVerCd());
		document.put("methodCd", apiVo.getMethodCd());
		document.put("stackClCd", apiVo.getStackClCd());
		document.put("uri", apiVo.getUri());
		document.put("dc", apiVo.getDc());
		document.put("regUserNm", apiVo.getRegUserNm());
		document.put("regDt", apiVo.getRegDt());
		document.put("cnvrRules", apiVo.getCnvrRules());
		document.put("reqParams", apiVo.getReqParams());
		document.put("rspnsResults", apiVo.getRspnsResults());

		String dbUrl = PropertiesUtil.getProperty("gateway.api.url");
		String url = dbUrl+"/"+ apiVo.getKeyId();

		// 수정 요청
		//DocumentResponseVo response =
		template.put(url, null, document, TYPE_DOCUMENT);

	}

	/**
	 * Api 삭제
	 * @param ApiVo Api 내용
	 */
	@Override
	public void deleteApi(ApiVo apiVo) throws Exception {

		// 쿼리 파라미터 생성
		QueryParamVo query = new QueryParamVo();
		query.setRev(apiVo.getRev());

		String dbUrl = PropertiesUtil.getProperty("gateway.api.url");
		String url = dbUrl+"/"+ apiVo.getKeyId();

		// 삭제 요청
		//DocumentResponseVo response =
		template.delete(url, query, TYPE_DOCUMENT);

	}
}
