/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ServcAreaAPIServiceImpl.java
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 06. 01.
 * @lastmodified 2017. 06. 01.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 06. 01.     x         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.service.impl;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import ncis.cmn.config.OpenShiftJsonConstant;
import ncis.cmn.config.OpenShiftPathConstant;
import ncis.cmn.config.OpenShiftURIConstant;
import ncis.cmn.exception.CommonException;
import ncis.cmn.rest.RestSender;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cpt.rsrc.atmscl.vo.BldVo;
import ncis.intfc.atmscl.service.BldAPIService;
import ncis.intfc.atmscl.utils.AtmSclUtil;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

/**
 * @author x
 *
 */
@Service("bldApiService")
public class BldAPIServiceImpl implements BldAPIService {

	@Resource(name="restSender") private RestSender restSender;

	@SuppressWarnings("unused")
	private DocumentContext context;

	@Override
	public AtmSclResultIfVo selectBldStat(RestHeaders headers, BldVo bldVo) throws Exception {
		AtmSclResultIfVo atmResult = new AtmSclResultIfVo();
		String buildId = bldVo.getBldId()+"-"+bldVo.getLastBldVer();
		String bldStatUrl = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_BUILDS_PARAM, bldVo.getServcAreaId(), buildId);
		String originRes = restSender.send(bldStatUrl, headers, String.class, HttpMethod.GET).getBody();

		Map<String, Object> mapInfo = AtmSclUtil.getMapInfo(originRes, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_BUILD__STATUS);
		if(null != mapInfo){
			atmResult.setSuccYn("Y");
			String bldStat = mapInfo.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_PHASE).toString();
			switch (bldStat) {
			case "Running":
				atmResult.setStatCd("01");
				break;
			case "Complete":
				atmResult.setStatCd("02");
				break;
			case "Failed":
				atmResult.setStatCd("03");
				break;
			case "Canceled":
				atmResult.setStatCd("04");
				break;
			case "New":
				atmResult.setStatCd("05");
				break;
			case "Pending":
				atmResult.setStatCd("06");
				break;
			case "Error":
				atmResult.setStatCd("07");
				break;
			case "other":
				atmResult.setStatCd("08");
				break;
			default:
				atmResult.setSuccYn("N");
				break;
			}

		}
		return atmResult;
	}


	@Override
	public AtmSclResultIfVo updateBldSync(RestHeaders headers, BldVo lastBldVo) {
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_BUILDCONFIGS_PARAM,lastBldVo.getServcAreaId(),lastBldVo.getBldId());

		AtmSclResultIfVo bldSyncResult =new AtmSclResultIfVo();

		//buildConfigs 조회  API 호출 (GET)
		String resultJson = restSender.send(url, headers, String.class, HttpMethod.GET).getBody();

		Map<String, Object> buildConfResult = AtmSclUtil.getMapInfo(resultJson, "$.status");

		if(!ObjectUtils.isEmpty(buildConfResult.get("lastVersion"))){
			String chkVer = buildConfResult.get("lastVersion").toString();
			String lastBldVer = lastBldVo.getBldVer();
			if(!chkVer.equals(lastBldVer)){
				//동기화 (o)
				bldSyncResult.setSuccYn("Y");
				int lastVer = Integer.valueOf(chkVer);
				bldSyncResult.setLatestVersion(lastVer);
			}else{
				//동기화 (x)
				bldSyncResult.setSuccYn("N");
			}
		}else{
			//동기화 (x)
			bldSyncResult.setSuccYn("N");
		}
		return bldSyncResult;
	}


	@Override
	public AtmSclResultIfVo bldHstrySync(RestHeaders headers, BldVo lastBldVo) throws Exception {
		String buildId = lastBldVo.getBldId()+"-"+lastBldVo.getLastBldVer();
		String bldStatUrl = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_BUILDS_PARAM, lastBldVo.getServcAreaId(), buildId);

		@SuppressWarnings("unchecked")
		Map<String,Object> responseMap = restSender.send(bldStatUrl, headers, Map.class, HttpMethod.GET).getBody();

		Map<String, Object> sourceMapInfo = JsonPath.parse(responseMap).read(OpenShiftPathConstant.OPENSHIFT_JSON_PATH_BUILD_SOURCE);
		@SuppressWarnings("unchecked")
		Map<String,Object> st = (Map<String, Object>) sourceMapInfo.get(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_GIT);
		String img = JsonPath.parse(responseMap).read(OpenShiftPathConstant.OPENSHIFT_JSON_PATH_BUILD_OUTPUT_TO_NAME);

		AtmSclResultIfVo setAtmSclResultInfo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		if(!ObjectUtils.isEmpty(sourceMapInfo.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TYPE))){
			if("Git".equals(sourceMapInfo.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TYPE).toString())){
				setAtmSclResultInfo.setRepoTyCd("01");
			}else if("SVN".equals(sourceMapInfo.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TYPE).toString())){
				setAtmSclResultInfo.setRepoTyCd("02");
			}
		}
		if(!ObjectUtils.isEmpty(st.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_URI))){
			setAtmSclResultInfo.setRepoAddr(st.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_URI).toString());
		}
		if(!ObjectUtils.isEmpty(st.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_REF))){
			setAtmSclResultInfo.setGitBrnchNm(st.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_REF).toString());
		}
		if(!ObjectUtils.isEmpty(img)){
			String[] split = img.split(":");
			setAtmSclResultInfo.setCreImgNm(img);
			setAtmSclResultInfo.setCreImgId(split[0]);
			setAtmSclResultInfo.setImgTag(split[1]);
		}


		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
			Date parsedDate = dateFormat.parse(setAtmSclResultInfo.getCreationTime());
			Timestamp ts = new Timestamp(parsedDate.getTime());
			setAtmSclResultInfo.setLastBldDttm(ts);
		} catch (ParseException e) {
			throw new CommonException("생성일자 변환시 오류가 발생했습니다."+e.getMessage());
		}
		return setAtmSclResultInfo;
	}



}
