/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UseReqServiceImpl.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 25.
 * @lastmodified 2016. 10. 25.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 25.     박희택         v1.0             최초생성
 *
 */
package ncis.api.gw.req.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import ncis.api.gw.hstry.service.ReqstHstryService;
import ncis.api.gw.req.service.UseReqService;
import ncis.api.gw.use.service.impl.UseMngServiceImpl;
import ncis.api.gw.user.vo.UserMngVo;
import ncis.cmn.couch.CouchDBRestTemplate;
import ncis.cmn.entity.couch.DocumentResponseVo;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.PropertiesUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

/**
 * @author 박희택
 *
 */
@Service("useReqService")
public class UseReqServiceImpl implements UseReqService {

	@Resource(name="commonService")
	CommonService commonService;

	@Resource(name="reqstHstryService")
	ReqstHstryService reqstHstryService;

	private final ParameterizedTypeReference<DocumentResponseVo> TYPE_DOCUMENT = new ParameterizedTypeReference<DocumentResponseVo>() {};
	private final Logger logger = LoggerFactory.getLogger(UseMngServiceImpl.class);

	@Autowired
	private CouchDBRestTemplate template;

	/**
	 * gateway 사용 등록
	 * @param UserMngVo ApiGwUser 내용
	 */
	@Override
	public void insertUseReq(UserMngVo userMngVo) throws Exception {

		try{
			/** api 호출 */
			// 상태 입력
			userMngVo.setStatCd("01");	// 미승인

			Map<String, Object> document = new HashMap<String, Object>();

			document.put("_id", userMngVo.getUseReqId());
			document.put("regionId", userMngVo.getRegionId());
			document.put("reqUsrNm",userMngVo.getReqUsrNm());
			document.put("reqDt",userMngVo.getReqDt());
			document.put("chargerNm", "");
			document.put("statCd", userMngVo.getStatCd());
			document.put("sysCd",userMngVo.getSysCd());
			document.put("accssKey", userMngVo.getAccssKey());
			document.put("authrMapng", userMngVo.getAuthrMapng());
			document.put("passwd",userMngVo.getPasswd());
			document.put("ipAddr",userMngVo.getIpAddr());
			document.put("reqReasn",userMngVo.getReqReasn());
			document.put("rjctReasn",userMngVo.getRjctReasn());
			document.put("apis",userMngVo.getApis());


			String dbUrl = PropertiesUtil.getProperty("gateway.apiGwUser.url");

			// 추가 요청
			DocumentResponseVo response = template.post(dbUrl, null, document, TYPE_DOCUMENT);

			if(response.isOk()){
				// 신청이력등록 호출
				reqstHstryService.insertReqstHstry(userMngVo);
			}
		}catch(Exception e){
			logger.error("Exception",e.toString());
		}

	}

}
