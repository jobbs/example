/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ReqstHstryServiceImpl.java
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
package ncis.api.gw.hstry.service.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import ncis.api.gw.hstry.service.ReqstHstryService;
import ncis.api.gw.use.vo.ReqstHstrySearchVo;
import ncis.api.gw.use.vo.ReqstHstryVo;
import ncis.api.gw.user.vo.UserMngVo;
import ncis.cmn.couch.CouchDBRestTemplate;
import ncis.cmn.entity.couch.DocumentResponseVo;
import ncis.cmn.entity.couch.QueryParamVo;
import ncis.cmn.entity.couch.ViewResponseRowVo;
import ncis.cmn.entity.couch.ViewResponseVo;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.DateUtil;
import ncis.cmn.util.PropertiesUtil;
import ncis.cpt.sys.code.vo.CodeVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

/**
 * @author 박희택
 *
 */
@Service("reqstHstryService")
public class ReqstHstryServiceImpl implements ReqstHstryService{

	@Resource(name="commonService")
	CommonService commonService;

	private final ParameterizedTypeReference<DocumentResponseVo> TYPE_DOCUMENT = new ParameterizedTypeReference<DocumentResponseVo>() {};
	private final ParameterizedTypeReference<ViewResponseVo<ReqstHstryVo>> TYPE_VIEW_MANAGER = new ParameterizedTypeReference<ViewResponseVo<ReqstHstryVo>>() {};

	@Autowired
	private CouchDBRestTemplate template;


	public void insertReqstHstry(UserMngVo vo) throws Exception {

		/** 신청일자 세팅 */
		int year = DateUtil.getCurrentYear();


		/** ID Generation Service : 구분자, 업무구분_년도_001 ~*/
		String reqstHstryId = commonService.selectSeqNum("COUCH_REQSTHSTRY", "REQSTHSTRY_"+year+"_");

		/** api 호출 */
		Map<String, Object> document = new HashMap<String, Object>();

		document.put("_id", reqstHstryId);
		document.put("reqHstryId", vo.getUseReqId());
		document.put("reqHstryNm", vo.getReqReasn());
		document.put("reqHstrystatCd", vo.getStatCd());
		document.put("reqhstryUsrNm", vo.getReqUsrNm());
		document.put("chargerNm", vo.getChargerNm());
		document.put("reqHstryDt", vo.getReqDt());

		String dbUrl = PropertiesUtil.getProperty("gateway.apiReqstHstry.url");

		// 추가 요청
		//DocumentResponseVo response =
		template.post(dbUrl, null, document, TYPE_DOCUMENT);
	}

	/**
	 * 사용신청이력 목록조회
	 * @param svo
	 * @return ReqstHstrySearchVo
	 */
	public List<ReqstHstryVo> selectReqstHistryList(ReqstHstrySearchVo svo)  throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

		List<ReqstHstryVo> resultList = new ArrayList<ReqstHstryVo>();

		String dbUrl = PropertiesUtil.getProperty("gateway.apiReqstHstry.url");
		String url = dbUrl+"/_design/all/_list/byParam/reqstHstry";

		int limit = svo.getPaginationInfo().getRecordCountPerPage();
		int skip = svo.getPaginationInfo().getFirstRecordIndex();

		// 쿼리 파라미터 생성
		QueryParamVo queryParam = new QueryParamVo();
		queryParam.setInclude_docs(true);
		queryParam.setDescending(true);

		// 조회 파라미터 생성 -
		Map<String, Object> document = new HashMap<>();
		document.put("reqHstryId", svo.getUseReqId());

		// 목록 조회 요청
		ViewResponseVo<ReqstHstryVo> response = template.post(url, queryParam, document, TYPE_VIEW_MANAGER);


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
		List<ReqstHstryVo> result = new ArrayList<>();

		/** 코드조회 */
		List<CodeVo> sysCd = commonService.selectCodeList("046", "208", true);			// 시스템코드
		List<CodeVo> reqHstrystatCd = commonService.selectCodeList("047", "209", true);	// 승인상태코드

		// 조회된 문서를 List로 담는다.
		if (response.getRows() != null && response.getRows().size() > 0) {



			for (ViewResponseRowVo<ReqstHstryVo> row : response.getRows()) {
				result.add(row.getDoc());
			}


			for(int i=skip; i<selectCnt; i++){
				ReqstHstryVo vo = new ReqstHstryVo();
				vo.set_id(result.get(i).get_id());
				vo.set_rev(result.get(i).get_rev());
				vo.setReqHstryId(result.get(i).getReqHstryId());
				vo.setReqHstryNm(result.get(i).getReqHstryNm());
				vo.setReqHstrystatCd(result.get(i).getReqHstrystatCd());
				vo.setReqhstryUsrNm(result.get(i).getReqhstryUsrNm());
				vo.setChargerNm(result.get(i).getChargerNm());
				vo.setReqHstryDt(result.get(i).getReqHstryDt());

				// 코드값 세팅
				for(int j=0; j<sysCd.size();j++){
					if(sysCd.get(j).getCd().equals(result.get(i).getReqHstryId())){
						vo.setSysNm(sysCd.get(j).getCdNm());
					}
				}
				for(int j=0; j<reqHstrystatCd.size();j++){
					if(reqHstrystatCd.get(j).getCd().equals(result.get(i).getReqHstrystatCd())){
						vo.setReqHstrystatNm(reqHstrystatCd.get(j).getCdNm());
					}
				}

				resultList.add(vo);
			}
		}

		return resultList;
	}
}
