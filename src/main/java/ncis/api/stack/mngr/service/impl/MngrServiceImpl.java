/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MngrServiceImpl.java
 *
 * @author 정승용
 * @lastmodifier 정승용
 * @created 2016. 10. 20.
 * @lastmodified 2016. 10. 20.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 20.     정승용         v1.0             최초생성
 *
 */
package ncis.api.stack.mngr.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import ncis.api.stack.mngr.service.MngrService;
import ncis.api.stack.mngr.vo.MngrSearchVo;
import ncis.api.stack.mngr.vo.MngrVo;
import ncis.cmn.couch.CouchDBRestTemplate;
import ncis.cmn.entity.couch.DocumentResponseVo;
import ncis.cmn.entity.couch.QueryParamVo;
import ncis.cmn.entity.couch.ViewResponseRowVo;
import ncis.cmn.entity.couch.ViewResponseVo;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.ObjectUtils;
import ncis.cmn.util.PropertiesUtil;
import ncis.cpt.rsrc.zone.service.NetService;
import ncis.cpt.rsrc.zone.service.RegionService;
import ncis.cpt.rsrc.zone.service.ZoneService;
import ncis.cpt.rsrc.zone.vo.RegionVo;
import ncis.cpt.rsrc.zone.vo.ZoneVo;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.intfc.apigwstatus.service.ApiGwStatusService;

import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 정승용
 *
 */
@Service("mngrService")
public class MngrServiceImpl implements MngrService {

	@Resource(name="commonService")
	CommonService commonService;

	@Resource(name="regionService")
	RegionService regionService;

	@Resource(name="zoneService")
	ZoneService zoneService;

	@Resource(name="netService")
	NetService netService;

	@Resource(name="apiGwStatusService")
	private ApiGwStatusService apiGwStatusService;

	private final ParameterizedTypeReference<DocumentResponseVo> TYPE_DOCUMENT = new ParameterizedTypeReference<DocumentResponseVo>() {};
	private final ParameterizedTypeReference<ViewResponseVo<MngrVo>> TYPE_VIEW_MANAGER = new ParameterizedTypeReference<ViewResponseVo<MngrVo>>() {};

	@Autowired
	private CouchDBRestTemplate template;

	private final Logger logger = LoggerFactory.getLogger(MngrServiceImpl.class);

	/**
	 * 매니저관리 목록조회
	 * @param MngrVo Mngr 내용
	 */
	@Override
	public List<MngrVo> selectMngrList(MngrSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException{

		List<MngrVo> resultList = new ArrayList<MngrVo>();

		String dbUrl = PropertiesUtil.getProperty("gateway.stackMngr.url");
		String url = dbUrl+"/_design/all/_list/byParam/stackMngrList";

		int limit = searchVo.getPaginationInfo().getRecordCountPerPage();
		int skip = searchVo.getPaginationInfo().getFirstRecordIndex();

		// 쿼리 파라미터 생성
		QueryParamVo queryParam = new QueryParamVo();
		queryParam.setInclude_docs(true);
		queryParam.setDescending(false);

		// 조회 파라미터 생성 - body 에 담길 내용 조회니까 없다
		Map<String, Object> document = new HashMap<>();
		document.put("regionId", searchVo.getSearchRegionId());
		document.put("zoneId", searchVo.getSearchZoneId());
		document.put("netId", searchVo.getSearchNetId());
		document.put("stackClCd", searchVo.getSearchStackClCd());
		document.put("mngrClCd", searchVo.getSearchMngrClCd());
		//document.put("mngrVerCd", searchVo.getSearchMngrVerCd());
		document.put("nowVerCd", searchVo.getSearchNowVerCd());
		document.put("mngrNm", searchVo.getSearchMngrNm());

		// 목록 조회 요청
		ViewResponseVo<MngrVo> response = template.post(url, queryParam, document, TYPE_VIEW_MANAGER);

		// 전체목록 수
		int totCnt = response.getRows().size();
		int selectCnt = limit+skip;

		// 페이지 처리위한 count
		searchVo.getPaginationInfo().setTotalRecordCount(totCnt);

		// selectCnt결정
		if(totCnt < selectCnt){
			selectCnt = totCnt;
		}

		// 조회 결과
		List<MngrVo> result = new ArrayList<>();

		/** 코드조회 */
        List<RegionVo> reginItems = regionService.selectRegionAllList();
        List<ZoneVo> zoneItems  = zoneService.selectZoneAllList();

		List<CodeVo> stackClCd = commonService.selectCodeList("039", "201", true);	// 스택분류코드
		List<CodeVo> mngrClCd = null;

		List<CodeVo> mngrVerCd = null;
		List<CodeVo> netId = commonService.selectCodeList("067", "NETCD", true);	// 망코드;

		// 조회된 문서를 List로 담는다.
		if (response.getRows() != null && response.getRows().size() > 0) {
			for (ViewResponseRowVo<MngrVo> row : response.getRows()) {
				result.add(row.getDoc());
			}

			for(int i=skip; i<selectCnt; i++){

				MngrVo mngrVo = new MngrVo();
				mngrVo.set_id(result.get(i).get_id());
				mngrVo.set_rev(result.get(i).get_rev());
				mngrVo.setRegionId(result.get(i).getRegionId());
				mngrVo.setZoneId(result.get(i).getZoneId());
				mngrVo.setNetId(result.get(i).getNetId());
				mngrVo.setStackClCd(result.get(i).getStackClCd());
				mngrVo.setMngrClCd(result.get(i).getMngrClCd());
				mngrVo.setMngrVerCd(result.get(i).getMngrVerCd());
				mngrVo.setApiVerCd(result.get(i).getApiVerCd());
				if(!ObjectUtils.isEmpty(result.get(i).getNowVerCd())) {
					mngrVo.setNowVerCd(result.get(i).getNowVerCd());
				} else {
					mngrVo.setNowVerCd(result.get(i).getMngrVerCd());
				}
				mngrVo.setHostAddr(result.get(i).getHostAddr());
				mngrVo.setHostAddr2(result.get(i).getHostAddr2());
				mngrVo.setMngrId(result.get(i).getMngrId());
				mngrVo.setMngrPw(result.get(i).getMngrPw());
				mngrVo.setVirtlCnsleAccesIp(result.get(i).getVirtlCnsleAccesIp());
				mngrVo.setVirtlCnsleAccesPort(result.get(i).getVirtlCnsleAccesPort());
				mngrVo.setMngrNm(result.get(i).getMngrNm());
				mngrVo.setRegUserNm(result.get(i).getRegUserNm());
				mngrVo.setRegDt(result.get(i).getRegDt());
				mngrVo.setDc(result.get(i).getDc());
				mngrVo.setAuthenticate(result.get(i).getAuthenticate());
				if(!ObjectUtils.isEmpty(result.get(i).getMonitoringYN())) {
					mngrVo.setMonitoringYN(result.get(i).getMonitoringYN());
				} else {
					mngrVo.setMonitoringYN("Y");
				}

				// 코드값 조회
				mngrClCd = commonService.selectCodeList("039", result.get(i).getStackClCd(), true);	// 매니저분류코드
				mngrVerCd = commonService.selectCodeList("039", result.get(i).getMngrClCd(), true);	// 매니저버전코드

				// 코드값 세팅
	            for(int j=0; j<reginItems.size();j++){
					if(reginItems.get(j).getRegionId().equals(mngrVo.getRegionId())){
						mngrVo.setRegionNm(reginItems.get(j).getRegionNm());
					}
				}
	            for(int j=0; j<zoneItems.size();j++){
					if(zoneItems.get(j).getZoneId().equals(mngrVo.getZoneId())){
						mngrVo.setZoneNm(zoneItems.get(j).getZoneNm());
					}
				}
				for(int j=0; j<stackClCd.size();j++){
					if(stackClCd.get(j).getCd().equals(mngrVo.getStackClCd())){
						mngrVo.setStackClNm(stackClCd.get(j).getCdNm());
					}
				}
				for(int j=0; j<mngrClCd.size();j++){
					if(mngrClCd.get(j).getCd().equals(mngrVo.getMngrClCd())){
						mngrVo.setMngrClNm(mngrClCd.get(j).getCdNm());
					}
				}
				for(int j=0; j<mngrVerCd.size();j++){
					if(mngrVerCd.get(j).getCd().equals(mngrVo.getMngrVerCd())){
						mngrVo.setMngrVerNm(mngrVerCd.get(j).getCdNm());
					}
				}
				for(int j=0; j<mngrVerCd.size();j++){
					if(mngrVerCd.get(j).getCd().equals(mngrVo.getApiVerCd())){
						mngrVo.setApiVerNm(mngrVerCd.get(j).getCdNm());
					}
				}
				for(int j=0; j<mngrVerCd.size();j++){
					if(mngrVerCd.get(j).getCd().equals(mngrVo.getNowVerCd())){
						mngrVo.setNowVerNm(mngrVerCd.get(j).getCdNm());
					}
				}
				for(int j=0; j<netId.size();j++){
					if(netId.get(j).getCd().equals(mngrVo.getNetId())){
						mngrVo.setNetNm(netId.get(j).getCdNm());
					}
				}

				resultList.add(mngrVo);
			}
		}

		return resultList;
	}

	/**
	 * 매니저 상태 호출(목록 조회)
	 * @param  regionId
	 * @return list
	 * @throws Exception
	 */
	@Override
	public MngrVo selectMngrHealthCheck(String rowId, String regionId,
			String zoneId, String netId, String mngrId) throws Exception {

		RestHeaders headers = new RestHeaders();
		MngrVo healthVo = new MngrVo();
		healthVo.setStatus("down");

		try {
			headers.setAreaId(regionId);
			headers.setZoneId(zoneId);
			headers.setNetworkId(netId);
			headers.setManagerId(mngrId);
			headers.setSeq(" ");
			healthVo = apiGwStatusService.mngrHealthCheck(headers);
		} catch (HttpStatusCodeException e) {
			logger.error("[=====ManagerStatusCheck Exception=====] | RowID : " + rowId + " | Contents : " + e.getMessage());
			logger.error(e.getResponseBodyAsString(),e);

			healthVo = new MngrVo();
			healthVo.setStatus("error");
		}
		healthVo.set_id(rowId);

	    return healthVo;
	}

	/**
	 * 매니저 관리 상세 조회
	 * @param MngrVo Mngr 내용
	 */
	@Override
	public MngrVo selectMngr(String stackMngrId) throws Exception {

		String dbUrl = PropertiesUtil.getProperty("gateway.stackMngr.url");
		String url = dbUrl+"/_design/all/_view/stackMngr";

		QueryParamVo queryParam = new QueryParamVo();
		queryParam.setKey(stackMngrId);
		queryParam.setInclude_docs(true);

		ViewResponseVo<MngrVo> response = template.get(url, queryParam, TYPE_VIEW_MANAGER);

		if (response.getRows() != null && response.getRows().size() == 1) {
			MngrVo mngrVo = new MngrVo();
			String atchPath = dbUrl + "/" + response.getRows().get(0).getDoc().get_id() + "/" + response.getRows().get(0).getDoc().getAtchFileName();

			mngrVo.set_id(response.getRows().get(0).getDoc().get_id());
			mngrVo.set_rev(response.getRows().get(0).getDoc().get_rev());
			mngrVo.setRegionId(response.getRows().get(0).getDoc().getRegionId());
			mngrVo.setZoneId(response.getRows().get(0).getDoc().getZoneId());
			mngrVo.setNetId(response.getRows().get(0).getDoc().getNetId());
			mngrVo.setStackClCd(response.getRows().get(0).getDoc().getStackClCd());
			mngrVo.setMngrNm(response.getRows().get(0).getDoc().getMngrNm());
			mngrVo.setMngrClCd(response.getRows().get(0).getDoc().getMngrClCd());
			mngrVo.setMngrVerCd(response.getRows().get(0).getDoc().getMngrVerCd());
			mngrVo.setApiVerCd(response.getRows().get(0).getDoc().getApiVerCd());
			if(!ObjectUtils.isEmpty(response.getRows().get(0).getDoc().getNowVerCd())) {
				mngrVo.setNowVerCd(response.getRows().get(0).getDoc().getNowVerCd());
			} else {
				mngrVo.setNowVerCd(response.getRows().get(0).getDoc().getMngrVerCd());
			}
			mngrVo.setAtchFileName(response.getRows().get(0).getDoc().getAtchFileName());
			mngrVo.setAtchPath(atchPath);
			mngrVo.setHostAddr(response.getRows().get(0).getDoc().getHostAddr());
			mngrVo.setHostAddr2(response.getRows().get(0).getDoc().getHostAddr2());
			mngrVo.setAuthenticate(response.getRows().get(0).getDoc().getAuthenticate());
			mngrVo.setMngrId(response.getRows().get(0).getDoc().getMngrId());
			mngrVo.setMngrPw(response.getRows().get(0).getDoc().getMngrPw());
			mngrVo.setVirtlCnsleAccesIp(response.getRows().get(0).getDoc().getVirtlCnsleAccesIp());
			mngrVo.setVirtlCnsleAccesPort(response.getRows().get(0).getDoc().getVirtlCnsleAccesPort());
			mngrVo.setDc(response.getRows().get(0).getDoc().getDc());
			mngrVo.setRegUserNm(response.getRows().get(0).getDoc().getRegUserNm());
			mngrVo.setRegDt(response.getRows().get(0).getDoc().getRegDt());
			mngrVo.setMonitoringYN(response.getRows().get(0).getDoc().getMonitoringYN());

			/** 코드조회 */
	        List<RegionVo> reginItems = regionService.selectRegionAllList();
	        List<ZoneVo> zoneItems  = zoneService.selectZoneAllList();

			// 코드값 조회
	        List<CodeVo> netId = commonService.selectCodeList("067", "NETCD", true);	// 망코드
			List<CodeVo> stackClCd = commonService.selectCodeList("039", "201", true);	// 스택분류코드
			List<CodeVo> mngrClCd = commonService.selectCodeList("039", response.getRows().get(0).getDoc().getStackClCd(), true);	// 매니저분류코드
			List<CodeVo> mngrVerCd = commonService.selectCodeList("039", response.getRows().get(0).getDoc().getMngrClCd(), true);	// 매니저버전코드

			// 코드값 세팅
            for(int j=0; j<reginItems.size();j++){
				if(reginItems.get(j).getRegionId().equals(mngrVo.getRegionId())){
					mngrVo.setRegionNm(reginItems.get(j).getRegionNm());
				}
			}
            for(int j=0; j<zoneItems.size();j++){
				if(zoneItems.get(j).getZoneId().equals(mngrVo.getZoneId())){
					mngrVo.setZoneNm(zoneItems.get(j).getZoneNm());
				}
			}
            for(int j=0; j<netId.size();j++){
				if(netId.get(j).getCd().equals(mngrVo.getNetId())){
					mngrVo.setNetNm(netId.get(j).getCdNm());
				}
			}
			for(int j=0; j<stackClCd.size();j++){
				if(stackClCd.get(j).getCd().equals(mngrVo.getStackClCd())){
					mngrVo.setStackClNm(stackClCd.get(j).getCdNm());
				}
			}
			for(int j=0; j<mngrClCd.size();j++){
				if(mngrClCd.get(j).getCd().equals(mngrVo.getMngrClCd())){
					mngrVo.setMngrClNm(mngrClCd.get(j).getCdNm());
				}
			}
			for(int j=0; j<mngrVerCd.size();j++){
				if(mngrVerCd.get(j).getCd().equals(mngrVo.getMngrVerCd())){
					mngrVo.setMngrVerNm(mngrVerCd.get(j).getCdNm());
				}
			}
			for(int j=0; j<mngrVerCd.size();j++){
				if(mngrVerCd.get(j).getCd().equals(mngrVo.getApiVerCd())){
					mngrVo.setApiVerNm(mngrVerCd.get(j).getCdNm());
				}
			}
			for(int j=0; j<mngrVerCd.size();j++){
				if(mngrVerCd.get(j).getCd().equals(mngrVo.getNowVerCd())){
					mngrVo.setNowVerNm(mngrVerCd.get(j).getCdNm());
				}
			}

			return mngrVo;
		}

		return null;
	}

	/**
	 * 매니저 등록
	 * @param MngrVo Mngr 내용
	 */
	@Override
	public void insertMngr(MngrVo mngrVo) throws Exception {

		/** api 호출 */
		Map<String, Object> document = new HashMap<String, Object>();
		MultipartFile attachFile = mngrVo.getUploadFile();
		document.put("_id", mngrVo.get_id());
		document.put("regionId", mngrVo.getRegionId());
		document.put("zoneId", mngrVo.getZoneId());
		document.put("netId", mngrVo.getNetId());
		document.put("netCd", mngrVo.getNetCd());
		document.put("stackClCd", mngrVo.getStackClCd());
		document.put("mngrClCd", mngrVo.getMngrClCd());
		document.put("mngrVerCd", mngrVo.getMngrVerCd());
		document.put("apiVerCd", mngrVo.getApiVerCd());
		document.put("nowVerCd", mngrVo.getNowVerCd());
		document.put("mngrNm", mngrVo.getMngrNm());
		document.put("regUserNm", mngrVo.getRegUserNm());
		document.put("regDt", mngrVo.getRegDt());
		if (!ObjectUtils.isEmpty(attachFile)) document.put("atchFileName", attachFile.getOriginalFilename());
		document.put("hostAddr", mngrVo.getHostAddr());
		document.put("hostAddr2", mngrVo.getHostAddr2());
		document.put("authenticate", mngrVo.getAuthenticate());
		document.put("mngrId", mngrVo.getMngrId());
		document.put("mngrPw", mngrVo.getMngrPw());
		document.put("virtlCnsleAccesIp", mngrVo.getVirtlCnsleAccesIp());
		document.put("virtlCnsleAccesPort", mngrVo.getVirtlCnsleAccesPort());
		document.put("dc", mngrVo.getDc());
		document.put("monitoringYN", mngrVo.getMonitoringYN());

		String dbUrl = PropertiesUtil.getProperty("gateway.stackMngr.url");
		String hostInfo = PropertiesUtil.getProperty("gateway.hostInfo");

		// 추가 요청
		DocumentResponseVo response = template.post(dbUrl, null, document, TYPE_DOCUMENT);

		if (response.isOk()) {
			String receiveId = (String) response.getId();
			String receiveRev = (String) response.getRev();

			if (!ObjectUtils.isEmpty(attachFile)) {
				InputStream in = attachFile.getInputStream();
				String orgFilename = URLEncoder.encode(attachFile.getOriginalFilename(), "UTF-8");
				String conType = attachFile.getContentType();

				CouchDbProperties properties = new CouchDbProperties()
						.setDbName("stack_mngr").setCreateDbIfNotExist(true)
						.setProtocol("http").setHost(hostInfo).setPort(5984)
						// .setUsername("ncms").setPassword("ncms1216@")
						.setMaxConnections(100).setConnectionTimeout(0);
				CouchDbClient dbClient = new CouchDbClient(properties);

//				Response resAttach =
				dbClient.saveAttachment(in, orgFilename, conType, receiveId, receiveRev);

				in.close(); // close the stream
			}
		}

	}

	/**
	 * 매니저 수정
	 *  @param MngrVo Mngr 내용
	 */
	@Override
	public void updateMngr(MngrVo mngrVo) throws Exception {

		/** api 호출 : UPDATE 요청시 _id, _rev 정보는 필수값이다.*/
		Map<String, Object> document = new HashMap<String, Object>();
		MultipartFile attachFile = mngrVo.getUploadFile();
		document.put("_rev", mngrVo.getRev());
		document.put("regionId", mngrVo.getRegionId());
		document.put("zoneId", mngrVo.getZoneId());
		document.put("netId", mngrVo.getNetId());
		document.put("netCd", mngrVo.getNetCd());
		document.put("stackClCd", mngrVo.getStackClCd());
		document.put("mngrClCd", mngrVo.getMngrClCd());
		document.put("mngrVerCd", mngrVo.getMngrVerCd());
		document.put("apiVerCd", mngrVo.getApiVerCd());
		document.put("nowVerCd", mngrVo.getNowVerCd());
		document.put("mngrNm", mngrVo.getMngrNm());
		document.put("regUserNm", mngrVo.getRegUserNm());
		document.put("regDt", mngrVo.getRegDt());
		if (!ObjectUtils.isEmpty(attachFile)) document.put("atchFileName", attachFile.getOriginalFilename());
		document.put("hostAddr", mngrVo.getHostAddr());
		document.put("hostAddr2", mngrVo.getHostAddr2());
		document.put("authenticate", mngrVo.getAuthenticate());
		document.put("mngrId", mngrVo.getMngrId());
		document.put("mngrPw", mngrVo.getMngrPw());
		document.put("virtlCnsleAccesIp", mngrVo.getVirtlCnsleAccesIp());
		document.put("virtlCnsleAccesPort", mngrVo.getVirtlCnsleAccesPort());
		document.put("dc", mngrVo.getDc());
		document.put("monitoringYN", mngrVo.getMonitoringYN());

		String dbUrl = PropertiesUtil.getProperty("gateway.stackMngr.url");
		String url = dbUrl+"/"+ mngrVo.getStackMngrId();
		String hostInfo = PropertiesUtil.getProperty("gateway.hostInfo");

		// 수정 요청
		DocumentResponseVo response = template.put(url, null, document, TYPE_DOCUMENT);

		if (response.isOk()) {
			String receiveId = (String) response.getId();
			String receiveRev = (String) response.getRev();

			if (!ObjectUtils.isEmpty(attachFile)) {
				InputStream in = attachFile.getInputStream();
				String orgFilename = URLEncoder.encode(attachFile.getOriginalFilename(), "UTF-8");
				String conType = attachFile.getContentType();

				CouchDbProperties properties = new CouchDbProperties()						// 메이븐 라이브러리 추가(로컬에서 오류나시면 메이븐 업데이트 하세요)
						.setDbName("stack_mngr").setCreateDbIfNotExist(true)
						.setProtocol("http").setHost(hostInfo).setPort(5984)
						// .setUsername("ncms").setPassword("ncms1216@")
						.setMaxConnections(100).setConnectionTimeout(0);
				CouchDbClient dbClient = new CouchDbClient(properties);

//				Response resAttach =
				dbClient.saveAttachment(in, orgFilename, conType, receiveId, receiveRev);

				in.close(); // close the stream
			}
		}

	}

	/**
	 * 매니저 삭제
	 * @param  MngrVo Mngr 내용
	 */
	@Override
	public void deleteMngr(MngrVo mngrVo) throws Exception {

		RestHeaders headers = new RestHeaders();
		MngrVo delChckVo = new MngrVo();
		delChckVo.setStatus("fail");

		try {
			headers.setAreaId(mngrVo.getRegionId());
			headers.setZoneId(mngrVo.getZoneId());
			headers.setNetworkId(mngrVo.getNetId());
			headers.setManagerId(mngrVo.getStackMngrId());
//2018-07-30 : (본사) 메니저 정보 삭제 시 health체크하는 부분에서 메니저가 없는 경우 에러 발생. healthCheck 부분 로직 삭제 
//			delChckVo = apiGwStatusService.mngrDeleteCheck(headers);
		} catch (Exception e) {
			logger.error("[=====ManagerInfoDeleteCheck Exception=====] | DeleteStatus : " + delChckVo.getStatus() + " | Contents : " + e.getMessage());

			delChckVo = new MngrVo();
			delChckVo.setStatus("error");
		}
//2018-07-30 : (본사) 메니저 정보 삭제 시 health체크하는 부분에서 메니저가 없는 경우 에러 발생. healthCheck 부분 로직 삭제 
//		if ("ok".equals(delChckVo.getStatus())) {
			// 쿼리 파라미터 생성
			QueryParamVo query = new QueryParamVo();
			query.setRev(mngrVo.getRev());

			String dbUrl = PropertiesUtil.getProperty("gateway.stackMngr.url");
			String url = dbUrl + "/" + mngrVo.getStackMngrId();

			// 삭제 요청
			template.delete(url, query, TYPE_DOCUMENT);
//		}

	}

}