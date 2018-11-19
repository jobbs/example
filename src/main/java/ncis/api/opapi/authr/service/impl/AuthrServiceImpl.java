/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename AuthrServiceImpl.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.     박희택         v1.0             최초생성
 *
 */
package ncis.api.opapi.authr.service.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ncis.api.opapi.authr.service.AuthrService;
import ncis.api.opapi.authr.vo.AuthrSearchVo;
import ncis.api.opapi.authr.vo.AuthrVo;
import ncis.cmn.couch.CouchDBRestTemplate;
import ncis.cmn.entity.couch.DocumentResponseVo;
import ncis.cmn.entity.couch.QueryParamVo;
import ncis.cmn.entity.couch.ViewResponseRowVo;
import ncis.cmn.entity.couch.ViewResponseVo;
import ncis.cmn.util.PropertiesUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

/**
 * @author 박희택
 *
 */

@Service("authrService")
public class AuthrServiceImpl implements AuthrService  {

	private final ParameterizedTypeReference<DocumentResponseVo> TYPE_DOCUMENT = new ParameterizedTypeReference<DocumentResponseVo>() {};
	private final ParameterizedTypeReference<ViewResponseVo<AuthrVo>> TYPE_VIEW_MANAGER = new ParameterizedTypeReference<ViewResponseVo<AuthrVo>>() {};

	@Autowired
	private CouchDBRestTemplate template;

	/**
	 * OpenApi 권한목록조회
	 * @param authrVo Authr 내용
	 */
	@Override
	public List<AuthrVo> selectAuthrList(AuthrSearchVo svo)  throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

		List<AuthrVo> resultList = new ArrayList<AuthrVo>();

		String dbUrl = PropertiesUtil.getProperty("gateway.openApiAuthr.url");
		String url = dbUrl+"/_design/all/_list/byParam/openApiAuthrList";

		int limit = svo.getPaginationInfo().getRecordCountPerPage();
		int skip = svo.getPaginationInfo().getFirstRecordIndex();

		// 쿼리 파라미터 생성
		QueryParamVo queryParam = new QueryParamVo();
		queryParam.setInclude_docs(true);
		queryParam.setDescending(false);

		// 조회 파라미터 생성 - body 에 담길 내용 조회니까 없다
		Map<String, Object> document = new HashMap<>();
		document.put("authrNm", svo.getSearchAuthrNm());

		// 목록 조회 요청
		ViewResponseVo<AuthrVo> response = template.post(url, queryParam, document, TYPE_VIEW_MANAGER);

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
		List<AuthrVo> result = new ArrayList<>();

		// 조회된 문서를 List로 담는다.
		if (response.getRows() != null && response.getRows().size() > 0) {
			for (ViewResponseRowVo<AuthrVo> row : response.getRows()) {
				result.add(row.getDoc());
			}

			for(int i=skip; i<selectCnt; i++){
				AuthrVo vo = new AuthrVo();
				vo.set_id(result.get(i).get_id());
				vo.set_rev(result.get(i).get_rev());
				vo.setAuthrId(result.get(i).get_id());
				vo.setAuthrNm(result.get(i).getAuthrNm());
				vo.setApiMapng(result.get(i).getApiMapng());
				vo.setDc(result.get(i).getDc());
				vo.setRegUserNm(result.get(i).getRegUserNm());
				vo.setRegDt(result.get(i).getRegDt());

				resultList.add(vo);
			}
		}

		return resultList;
	}

	/**
	 * OpenApi 권한등록
	 * @param authrVo authr 내용
	 */
	@Override
	public void insertAuthr(AuthrVo authrVo) throws Exception {

		/** api 호출 */
		Map<String, Object> document = new HashMap<String, Object>();
		document.put("_id", authrVo.get_id());
		document.put("authrNm", authrVo.getAuthrNm());
		document.put("apiMapng", authrVo.getApiMapng());
		document.put("dc", authrVo.getDc());
		document.put("regUserNm", authrVo.getRegUserNm());
		document.put("regDt", authrVo.getRegDt());

		String dbUrl = PropertiesUtil.getProperty("gateway.openApiAuthr.url");

		// 추가 요청
		//DocumentResponseVo response =
		template.post(dbUrl, null, document, TYPE_DOCUMENT);

	}

	/**
	 * OpenApi 권한상세조회
	 * @param authrVo authr 내용
	 */
	@Override
	public AuthrVo selectAuthr(String authrId) throws Exception {

		String dbUrl = PropertiesUtil.getProperty("gateway.openApiAuthr.url");
		String url = dbUrl+"/_design/all/_view/openApiAuthr";

		// 쿼리 파라미터 생성
		QueryParamVo queryParam = new QueryParamVo();
		queryParam.setKey(authrId);
		queryParam.setInclude_docs(true);

		// 조회 요청
		ViewResponseVo<AuthrVo> response = template.get(url, queryParam, TYPE_VIEW_MANAGER);


		// 조회 결과
		if (response.getRows() != null && response.getRows().size() == 1) {

			AuthrVo vo = new AuthrVo();

			vo.setAuthrId(response.getRows().get(0).getDoc().get_id());
			vo.setRev(response.getRows().get(0).getDoc().get_rev());
			vo.setAuthrNm(response.getRows().get(0).getDoc().getAuthrNm());
			vo.setApiMapng(response.getRows().get(0).getDoc().getApiMapng());
			vo.setRegUserNm(response.getRows().get(0).getDoc().getRegUserNm());
			vo.setRegDt(response.getRows().get(0).getDoc().getRegDt());
			vo.setDc(response.getRows().get(0).getDoc().getDc());

			return vo;
		}
		else {
			return null;
		}

	}

	/**
	 * OpenApi 권한수정
	 * @param authrVo authr 내용
	 */
	@Override
	public void updateAuthr(AuthrVo authrVo) throws Exception {

		/** api 호출 : UPDATE 요청시 _id, _rev 정보는 필수값이다.*/
		Map<String, Object> document = new HashMap<String, Object>();
		document.put("_rev", authrVo.getRev());
		document.put("authrNm", authrVo.getAuthrNm());
		document.put("apiMapng", authrVo.getApiMapng());
		document.put("dc", authrVo.getDc());
		document.put("regUserNm", authrVo.getRegUserNm());
		document.put("regDt", authrVo.getRegDt());

		String dbUrl = PropertiesUtil.getProperty("gateway.openApiAuthr.url");
		String url = dbUrl+"/"+ authrVo.getAuthrId();

		// 수정 요청
		//DocumentResponseVo response =
		template.put(url, null, document, TYPE_DOCUMENT);

	}

	/**
	 * OpenApi 권한삭제
	 * @param authrVo authr 내용
	 */
	@Override
	public void deleteAuthr(AuthrVo authrVo) throws Exception {

		// 쿼리 파라미터 생성
		QueryParamVo query = new QueryParamVo();
		query.setRev(authrVo.getRev());

		String dbUrl = PropertiesUtil.getProperty("gateway.openApiAuthr.url");
		String url = dbUrl+"/"+ authrVo.getAuthrId();

		// 삭제 요청
		//DocumentResponseVo response =
		template.delete(url, query, TYPE_DOCUMENT);

	}
}
