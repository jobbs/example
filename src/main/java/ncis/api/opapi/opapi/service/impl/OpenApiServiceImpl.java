/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename OpenApiServiceImpl.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     박희택         v1.0             최초생성
 *
 */
package ncis.api.opapi.opapi.service.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import ncis.api.cmn.tyk.service.TykApiService;
import ncis.api.cmn.tyk.vo.TykApiResponseVo;
import ncis.api.cmn.tyk.vo.TykApiVo;
import ncis.api.opapi.opapi.service.OpenApiService;
import ncis.api.opapi.opapi.vo.OpenApiSearchVo;
import ncis.api.opapi.opapi.vo.OpenApiVo;
import ncis.cmn.couch.CouchDBRestTemplate;
import ncis.cmn.entity.couch.DocumentResponseVo;
import ncis.cmn.entity.couch.QueryParamVo;
import ncis.cmn.entity.couch.ViewResponseRowVo;
import ncis.cmn.entity.couch.ViewResponseVo;
import ncis.cmn.util.PropertiesUtil;
import ncis.cpt.rsrc.zone.service.RegionService;
import ncis.cpt.rsrc.zone.vo.RegionVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

/**
 * @author 박희택
 *
 */

@Service("openApiService")
public class OpenApiServiceImpl implements OpenApiService {

	private final ParameterizedTypeReference<DocumentResponseVo> TYPE_DOCUMENT = new ParameterizedTypeReference<DocumentResponseVo>() {};
	private final ParameterizedTypeReference<ViewResponseVo<OpenApiVo>> TYPE_VIEW_MANAGER = new ParameterizedTypeReference<ViewResponseVo<OpenApiVo>>() {};

	@Autowired
	private CouchDBRestTemplate template;

	@Resource(name="regionService")
	RegionService regionService;

	@Resource(name="tykApiService")
	TykApiService tykApiService;

	/**
	 * OpenApi 등록
	 * @param openApiVo OpenApi 내용
	 */
	@Override
	public void insertOpenApi(OpenApiVo openApiVo) throws Exception {
		try{
			/** TYK 호출 시작 */
			// Tyk에 등록요청
			TykApiResponseVo tykApiResponseVo = new TykApiResponseVo();

//			TykApiResponseVo tykApReloadiResponseVo = new TykApiResponseVo();

			TykApiVo tykApiVo = new TykApiVo();

			// 변경정보 입력
			tykApiVo.setName(openApiVo.get_id());	// pk
			tykApiVo.setSlug(openApiVo.get_id());	// name과 동일
			tykApiVo.setApi_id(openApiVo.get_id());
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

			tykApiVo.setAllowed_ips(allowedIpsList);

			// header정보
			tykApiVo.setRegionId(openApiVo.getRegionId());

			// tyk 호출
			tykApiResponseVo = tykApiService.insertTykApi(tykApiVo);

			//tykApReloadiResponseVo =
			tykApiService.reloadTyk(openApiVo.getRegionId());

			/** TYK 제어 호출 끝 */
			if("OK".equals(tykApiResponseVo.getStatus().toUpperCase())){

				/** api 호출 */
				Map<String, Object> document = new HashMap<String, Object>();
				document.put("_id", openApiVo.get_id());
				document.put("regionId", openApiVo.getRegionId());
				document.put("opApiNm", openApiVo.getOpApiNm());
				document.put("uri", openApiVo.getUri());
				document.put("svcDscvryYn", openApiVo.getSvcDscvryYn());
				document.put("statCd", openApiVo.getStatCd());
				document.put("regUserNm", openApiVo.getRegUserNm());
				document.put("regDt", openApiVo.getRegDt());
				document.put("targetHstAddr", openApiVo.getTargetHstAddr());
				document.put("dc", openApiVo.getDc());

				String dbUrl = PropertiesUtil.getProperty("gateway.openApi.url");

				// 추가 요청
				//DocumentResponseVo response =
				template.post(dbUrl, null, document, TYPE_DOCUMENT);
			}else{
				throw new Exception("TYK 호출시 오류가 발생하였습니다.");
			}
		}catch(Exception e){
			throw new Exception(e.toString());
		}
	}

	/**
	 * OpenApi 목록조회
	 * @param openApiVo OpenApi 내용
	 */
	@Override
	public List<OpenApiVo> selectOpenApiList(OpenApiSearchVo svo)  throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

		List<OpenApiVo> resultList = new ArrayList<OpenApiVo>();

		String dbUrl = PropertiesUtil.getProperty("gateway.openApi.url");
		String url = dbUrl+"/_design/all/_list/byParam/openApiList";

		int limit = svo.getPaginationInfo().getRecordCountPerPage();
		int skip = svo.getPaginationInfo().getFirstRecordIndex();

		// 쿼리 파라미터 생성
		QueryParamVo queryParam = new QueryParamVo();
		queryParam.setInclude_docs(true);
		queryParam.setDescending(false);

		// 조회 파라미터 생성 - body 에 담길 내용 조회니까 없다
		Map<String, Object> document = new HashMap<>();
		document.put("opApiNm", svo.getSearchOpenApiNm());
		document.put("statCd", svo.getSearchStatCd());
		document.put("uri", svo.getSearchUri());

		// 목록 조회 요청
		ViewResponseVo<OpenApiVo> response = template.post(url, queryParam, document, TYPE_VIEW_MANAGER);

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
		List<OpenApiVo> result = new ArrayList<>();

		/** 코드조회 */
        List<RegionVo> reginItems = regionService.selectRegionAllList();

		// 조회된 문서를 List로 담는다.
		if (response.getRows() != null && response.getRows().size() > 0) {
			for (ViewResponseRowVo<OpenApiVo> row : response.getRows()) {
				result.add(row.getDoc());
			}


			for(int i=skip; i<selectCnt; i++){
				OpenApiVo vo = new OpenApiVo();
				vo.set_id(result.get(i).get_id());
				vo.set_rev(result.get(i).get_rev());
				vo.setOpApiId(result.get(i).get_id());
				vo.setRegionId(result.get(i).getRegionId());
				vo.setOpApiNm(result.get(i).getOpApiNm());
				vo.setUri(result.get(i).getUri());
				vo.setSvcDscvryYn(result.get(i).getSvcDscvryYn());
				vo.setStatCd(result.get(i).getStatCd());
				vo.setRegUserNm(result.get(i).getRegUserNm());
				vo.setRegDt(result.get(i).getRegDt());
				vo.setTargetHstAddr(result.get(i).getTargetHstAddr());
				vo.setDc(result.get(i).getDc());

				// 코드값 세팅
	            for(int j=0; j<reginItems.size();j++){
					if(reginItems.get(j).getRegionId().equals(result.get(i).getRegionId())){
						vo.setRegionNm(reginItems.get(j).getRegionNm());
					}
				}

				resultList.add(vo);
			}
		}

		return resultList;
	}

	/**
	 * OpenApi 조회
	 * @param openApiVo OpenApi 내용
	 */
	@Override
	public OpenApiVo selectOpenApi(String openApiId) throws Exception {

		String dbUrl = PropertiesUtil.getProperty("gateway.openApi.url");
		String url = dbUrl+"/_design/all/_view/openApi";

		// 쿼리 파라미터 생성
		QueryParamVo queryParam = new QueryParamVo();
		queryParam.setKey(openApiId);
		queryParam.setInclude_docs(true);

		// 조회 요청
		ViewResponseVo<OpenApiVo> response = template.get(url, queryParam, TYPE_VIEW_MANAGER);


		// 조회 결과
		if (response.getRows() != null && response.getRows().size() == 1) {

			OpenApiVo vo = new OpenApiVo();

			vo.setOpApiId(response.getRows().get(0).getDoc().get_id());
			vo.setRev(response.getRows().get(0).getDoc().get_rev());
			vo.setRegionId(response.getRows().get(0).getDoc().getRegionId());
			vo.setOpApiNm(response.getRows().get(0).getDoc().getOpApiNm());
			vo.setUri(response.getRows().get(0).getDoc().getUri());
			vo.setSvcDscvryYn(response.getRows().get(0).getDoc().getSvcDscvryYn());
			vo.setStatCd(response.getRows().get(0).getDoc().getStatCd());
			vo.setRegUserNm(response.getRows().get(0).getDoc().getRegUserNm());
			vo.setRegDt(response.getRows().get(0).getDoc().getRegDt());
			vo.setTargetHstAddr(response.getRows().get(0).getDoc().getTargetHstAddr());
			vo.setDc(response.getRows().get(0).getDoc().getDc());

			return vo;
		}
		else {
			return null;
		}

	}

	/**
	 * OpenApi 수정
	 * @param openApiVo OpenApi 내용
	 */
	@Override
	public void updateOpenApi(OpenApiVo openApiVo) throws Exception {

		try{
			/** TYK 호출 시작 */
			// Tyk에 등록요청
			TykApiResponseVo tykApiResponseVo = new TykApiResponseVo();
//			TykApiResponseVo tykApReloadiResponseVo = new TykApiResponseVo();
			TykApiVo tykApiVo = new TykApiVo();

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

			tykApiVo.setAllowed_ips(allowedIpsList);

			// header정보
			tykApiVo.setRegionId(openApiVo.getRegionId());

			// tyk 호출
			tykApiResponseVo = tykApiService.insertTykApi(tykApiVo);

			//tykApReloadiResponseVo =
			tykApiService.reloadTyk(openApiVo.getRegionId());

			/** TYK 제어 호출 끝 */
			if("OK".equals(tykApiResponseVo.getStatus().toUpperCase())){
				/** api 호출 : UPDATE 요청시 _id, _rev 정보는 필수값이다.*/
				Map<String, Object> document = new HashMap<String, Object>();
				document.put("_rev", openApiVo.getRev());
				document.put("regionId", openApiVo.getRegionId());
				document.put("opApiNm", openApiVo.getOpApiNm());
				document.put("uri", openApiVo.getUri());
				document.put("svcDscvryYn", openApiVo.getSvcDscvryYn());
				document.put("statCd", openApiVo.getStatCd());
				document.put("regUserNm", openApiVo.getRegUserNm());
				document.put("regDt", openApiVo.getRegDt());
				document.put("targetHstAddr", openApiVo.getTargetHstAddr());
				document.put("dc", openApiVo.getDc());

				String dbUrl = PropertiesUtil.getProperty("gateway.openApi.url");
				String url = dbUrl+"/"+ openApiVo.getOpApiId();

				// 수정 요청
//				DocumentResponseVo response =
				template.put(url, null, document, TYPE_DOCUMENT);
			}else{
				throw new Exception("TYK 호출시 오류가 발생하였습니다.");
			}
		}catch(Exception e){
			throw new Exception(e.toString());
		}
	}

	/**
	 * OpenApi 삭제
	 * @param openApiVo OpenApi 내용
	 */
	@Override
	public void deleteOpenApi(OpenApiVo openApiVo) throws Exception {

		try{
			/** TYK 호출 시작 */
			// Tyk에 등록요청
			TykApiResponseVo tykApiResponseVo = new TykApiResponseVo();
//			TykApiResponseVo tykApReloadiResponseVo = new TykApiResponseVo();
			TykApiVo tykApiVo = new TykApiVo();
			tykApiVo.setApi_id(openApiVo.getOpApiId());
			// header정보
			tykApiVo.setRegionId(openApiVo.getRegionId());

			// tyk 삭제 호출
			tykApiResponseVo = tykApiService.deleteTykApi(tykApiVo);
//			tykApReloadiResponseVo =
			tykApiService.reloadTyk(openApiVo.getRegionId());

			/** TYK 제어 호출 끝 */
			if("OK".equals(tykApiResponseVo.getStatus().toUpperCase())){
				// 쿼리 파라미터 생성
				QueryParamVo query = new QueryParamVo();
				query.setRev(openApiVo.getRev());

				String dbUrl = PropertiesUtil.getProperty("gateway.openApi.url");
				String url = dbUrl+"/"+ openApiVo.getOpApiId();

				// 삭제 요청
//				DocumentResponseVo response =
				template.delete(url, query, TYPE_DOCUMENT);
			}else{
				throw new Exception("TYK 호출시 오류가 발생하였습니다.");
			}
		}catch (Exception e){
			throw new Exception(e.toString());
		}
	}
}
