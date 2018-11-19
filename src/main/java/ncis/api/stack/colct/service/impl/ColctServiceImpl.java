/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ColctServiceImpl.java
 *
 * @author 최장성
 * @lastmodifier 최장성
 * @created 2016. 11. 11.
 * @lastmodified 2016. 11. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 11.     최장성         v1.0             최초생성
 *
 */
package ncis.api.stack.colct.service.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import ncis.api.stack.btch.vo.BtchVo;
import ncis.api.stack.colct.service.ColctService;
import ncis.api.stack.colct.vo.ColctSearchVo;
import ncis.api.stack.colct.vo.ColctVo;
import ncis.api.stack.colct.vo.ViewVo;
import ncis.cmn.couch.CouchDBRestTemplate;
import ncis.cmn.entity.couch.QueryParamVo;
import ncis.cmn.entity.couch.ViewResponseRowVo;
import ncis.cmn.entity.couch.ViewResponseVo;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.ObjectUtils;
import ncis.cmn.util.PropertiesUtil;
import ncis.cpt.rsrc.zone.service.NetService;
import ncis.cpt.rsrc.zone.service.RegionService;
import ncis.cpt.rsrc.zone.service.ZoneService;
import ncis.cpt.rsrc.zone.vo.RegionVo;
import ncis.cpt.rsrc.zone.vo.ZoneVo;
import ncis.cpt.sys.code.vo.CodeVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

/**
 * @author 최장성
 *
 */
@Service("colctService")
public class ColctServiceImpl implements ColctService {

    @Resource(name = "commonService")
    CommonService commonService;

    @Resource(name = "regionService")
    RegionService regionService;

    @Resource(name = "zoneService")
    ZoneService zoneService;

    @Resource(name = "netService")
    NetService netService;

    private final ParameterizedTypeReference<ViewResponseVo<ColctVo>> TYPE_VIEW_MANAGER = new ParameterizedTypeReference<ViewResponseVo<ColctVo>>() {};
    private final ParameterizedTypeReference<ViewResponseVo<ViewVo>> TYPE_VIEW_STTUS = new ParameterizedTypeReference<ViewResponseVo<ViewVo>>() {};
    private final ParameterizedTypeReference<BtchVo> TYPE_ROW_BTCH = new ParameterizedTypeReference<BtchVo>() {};

    private final Logger logger = LoggerFactory.getLogger(ColctServiceImpl.class);

    @Autowired
    private CouchDBRestTemplate template;

    /**
     * 배치 수집현황 목록조회
     *
     * @param ColctVo Colct 목록
     */
    @Override
    public List<ColctVo> selectColctList(ColctSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
    	logger.debug("[======= selectColctList start =======]");
        List<ColctVo> resultList = new ArrayList<ColctVo>();

        String dbUrl = PropertiesUtil.getProperty("gateway.stackMngr.url");
        String url = dbUrl + "/_design/all/_list/byParam/stackMngrList";

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
        ViewResponseVo<ColctVo> response = template.post(url, queryParam, document, TYPE_VIEW_MANAGER);

    	// 전체 목록
        List<ColctVo> result = new ArrayList<>();

        // 전체목록 수
        if (response.getRows() != null && response.getRows().size() > 0) {
        	for (ViewResponseRowVo<ColctVo> row : response.getRows()) {
        		if("COM".equals(row.getDoc().getStackClCd())){
        			ColctVo rowVo1 = new ColctVo();
        			rowVo1.set_id(row.getDoc().get_id());
        			rowVo1.setRegionId(row.getDoc().getRegionId());
        			rowVo1.setZoneId(row.getDoc().getZoneId());
        			rowVo1.setNetId(row.getDoc().getNetId());
        			rowVo1.setStackClCd(row.getDoc().getStackClCd());
        			rowVo1.setMngrClCd(row.getDoc().getMngrClCd());
        			rowVo1.setMngrVerCd(row.getDoc().getMngrVerCd());
        			if(!ObjectUtils.isEmpty(row.getDoc().getNowVerCd())) {
        				rowVo1.setNowVerCd(row.getDoc().getNowVerCd());
        			} else {
        				rowVo1.setNowVerCd(row.getDoc().getMngrVerCd());
        			}
        			rowVo1.setMngrNm(row.getDoc().getMngrNm());
        			rowVo1.setMonitoringYN(row.getDoc().getMonitoringYN());
        			rowVo1.setBtchColctCd("composition");
        			rowVo1.setBtchColctNm("구성정보");
        			result.add(rowVo1);
        			ColctVo rowVo2 = new ColctVo();
        			rowVo2.set_id(row.getDoc().get_id());
        			rowVo2.setRegionId(row.getDoc().getRegionId());
        			rowVo2.setZoneId(row.getDoc().getZoneId());
        			rowVo2.setNetId(row.getDoc().getNetId());
        			rowVo2.setStackClCd(row.getDoc().getStackClCd());
        			rowVo2.setMngrClCd(row.getDoc().getMngrClCd());
        			rowVo2.setMngrVerCd(row.getDoc().getMngrVerCd());
        			if(!ObjectUtils.isEmpty(row.getDoc().getNowVerCd())) {
        				rowVo2.setNowVerCd(row.getDoc().getNowVerCd());
        			} else {
        				rowVo2.setNowVerCd(row.getDoc().getMngrVerCd());
        			}
        			rowVo2.setMngrNm(row.getDoc().getMngrNm());
        			rowVo2.setMonitoringYN(row.getDoc().getMonitoringYN());
        			rowVo2.setBtchColctCd("performance");
        			rowVo2.setBtchColctNm("성능정보");
        			result.add(rowVo2);
        		} else if("NTW".equals(row.getDoc().getStackClCd())){
        			ColctVo rowVo1 = new ColctVo();
        			rowVo1.set_id(row.getDoc().get_id());
        			rowVo1.setRegionId(row.getDoc().getRegionId());
        			rowVo1.setZoneId(row.getDoc().getZoneId());
        			rowVo1.setNetId(row.getDoc().getNetId());
        			rowVo1.setStackClCd(row.getDoc().getStackClCd());
        			rowVo1.setMngrClCd(row.getDoc().getMngrClCd());
        			rowVo1.setMngrVerCd(row.getDoc().getMngrVerCd());
        			if(!ObjectUtils.isEmpty(row.getDoc().getNowVerCd())) {
        				rowVo1.setNowVerCd(row.getDoc().getNowVerCd());
        			} else {
        				rowVo1.setNowVerCd(row.getDoc().getMngrVerCd());
        			}
        			rowVo1.setMngrNm(row.getDoc().getMngrNm());
        			rowVo1.setMonitoringYN(row.getDoc().getMonitoringYN());
        			rowVo1.setBtchColctCd("composition");
        			rowVo1.setBtchColctNm("구성정보");
        			result.add(rowVo1);
        			ColctVo rowVo2 = new ColctVo();
        			rowVo2.set_id(row.getDoc().get_id());
        			rowVo2.setRegionId(row.getDoc().getRegionId());
        			rowVo2.setZoneId(row.getDoc().getZoneId());
        			rowVo2.setNetId(row.getDoc().getNetId());
        			rowVo2.setStackClCd(row.getDoc().getStackClCd());
        			rowVo2.setMngrClCd(row.getDoc().getMngrClCd());
        			rowVo2.setMngrVerCd(row.getDoc().getMngrVerCd());
        			if(!ObjectUtils.isEmpty(row.getDoc().getNowVerCd())) {
        				rowVo2.setNowVerCd(row.getDoc().getNowVerCd());
        			} else {
        				rowVo2.setNowVerCd(row.getDoc().getMngrVerCd());
        			}
        			rowVo2.setMngrNm(row.getDoc().getMngrNm());
        			rowVo2.setMonitoringYN(row.getDoc().getMonitoringYN());
        			rowVo2.setBtchColctCd("performance");
        			rowVo2.setBtchColctNm("성능정보");
        			result.add(rowVo2);
        		} else if("STG".equals(row.getDoc().getStackClCd())){
        			if(!("SAN".equals(row.getDoc().getMngrClCd()) && "uni_8.1.0.6".equals(row.getDoc().getMngrVerCd()))) {
	        			ColctVo rowVo1 = new ColctVo();
	        			rowVo1.set_id(row.getDoc().get_id());
	        			rowVo1.setRegionId(row.getDoc().getRegionId());
	        			rowVo1.setZoneId(row.getDoc().getZoneId());
	        			rowVo1.setNetId(row.getDoc().getNetId());
	        			rowVo1.setStackClCd(row.getDoc().getStackClCd());
	        			rowVo1.setMngrClCd(row.getDoc().getMngrClCd());
	        			rowVo1.setMngrVerCd(row.getDoc().getMngrVerCd());
	        			if(!ObjectUtils.isEmpty(row.getDoc().getNowVerCd())) {
	        				rowVo1.setNowVerCd(row.getDoc().getNowVerCd());
	        			} else {
	        				rowVo1.setNowVerCd(row.getDoc().getMngrVerCd());
	        			}
	        			rowVo1.setMngrNm(row.getDoc().getMngrNm());
	        			rowVo1.setMonitoringYN(row.getDoc().getMonitoringYN());
	        			rowVo1.setBtchColctCd("composition");
	        			rowVo1.setBtchColctNm("구성정보");
	        			result.add(rowVo1);
        			}
        			if(!("SAN".equals(row.getDoc().getMngrClCd()) && "SAN_3.0".equals(row.getDoc().getMngrVerCd()))) {
	        			ColctVo rowVo2 = new ColctVo();
	        			rowVo2.set_id(row.getDoc().get_id());
	        			rowVo2.setRegionId(row.getDoc().getRegionId());
	        			rowVo2.setZoneId(row.getDoc().getZoneId());
	        			rowVo2.setNetId(row.getDoc().getNetId());
	        			rowVo2.setStackClCd(row.getDoc().getStackClCd());
	        			rowVo2.setMngrClCd(row.getDoc().getMngrClCd());
	        			rowVo2.setMngrVerCd(row.getDoc().getMngrVerCd());
	        			if(!ObjectUtils.isEmpty(row.getDoc().getNowVerCd())) {
	        				rowVo2.setNowVerCd(row.getDoc().getNowVerCd());
	        			} else {
	        				rowVo2.setNowVerCd(row.getDoc().getMngrVerCd());
	        			}
	        			rowVo2.setMngrNm(row.getDoc().getMngrNm());
	        			rowVo2.setMonitoringYN(row.getDoc().getMonitoringYN());
	        			rowVo2.setBtchColctCd("performance");
	        			rowVo2.setBtchColctNm("성능정보");
	        			result.add(rowVo2);
        			}
        		} else if("OPR".equals(row.getDoc().getStackClCd())){
        			if("03".equals(row.getDoc().getZoneId())){
	        			ColctVo rowVo1 = new ColctVo();
	        			rowVo1.set_id(row.getDoc().get_id());
	        			rowVo1.setRegionId(row.getDoc().getRegionId());
	        			rowVo1.setZoneId(row.getDoc().getZoneId());
	        			rowVo1.setNetId(row.getDoc().getNetId());
	        			rowVo1.setStackClCd(row.getDoc().getStackClCd());
	        			rowVo1.setMngrClCd(row.getDoc().getMngrClCd());
	        			rowVo1.setMngrVerCd(row.getDoc().getMngrVerCd());
	        			if(!ObjectUtils.isEmpty(row.getDoc().getNowVerCd())) {
	        				rowVo1.setNowVerCd(row.getDoc().getNowVerCd());
	        			} else {
	        				rowVo1.setNowVerCd(row.getDoc().getMngrVerCd());
	        			}
	        			rowVo1.setMngrNm(row.getDoc().getMngrNm());
	        			rowVo1.setMonitoringYN(row.getDoc().getMonitoringYN());
	        			rowVo1.setBtchColctCd("operation1");
	        			rowVo1.setBtchColctNm("Repository 정보");
	        			result.add(rowVo1);
	        			ColctVo rowVo2 = new ColctVo();
	        			rowVo2.set_id(row.getDoc().get_id());
	        			rowVo2.setRegionId(row.getDoc().getRegionId());
	        			rowVo2.setZoneId(row.getDoc().getZoneId());
	        			rowVo2.setNetId(row.getDoc().getNetId());
	        			rowVo2.setStackClCd(row.getDoc().getStackClCd());
	        			rowVo2.setMngrClCd(row.getDoc().getMngrClCd());
	        			rowVo2.setMngrVerCd(row.getDoc().getMngrVerCd());
	        			if(!ObjectUtils.isEmpty(row.getDoc().getNowVerCd())) {
	        				rowVo2.setNowVerCd(row.getDoc().getNowVerCd());
	        			} else {
	        				rowVo2.setNowVerCd(row.getDoc().getMngrVerCd());
	        			}
	        			rowVo2.setMngrNm(row.getDoc().getMngrNm());
	        			rowVo2.setMonitoringYN(row.getDoc().getMonitoringYN());
	        			rowVo2.setBtchColctCd("operation2");
	        			rowVo2.setBtchColctNm("Repository 별 Package 정보");
	        			result.add(rowVo2);
        			}
        			ColctVo rowVo3 = new ColctVo();
        			rowVo3.set_id(row.getDoc().get_id());
        			rowVo3.setRegionId(row.getDoc().getRegionId());
        			rowVo3.setZoneId(row.getDoc().getZoneId());
        			rowVo3.setNetId(row.getDoc().getNetId());
        			rowVo3.setStackClCd(row.getDoc().getStackClCd());
        			rowVo3.setMngrClCd(row.getDoc().getMngrClCd());
        			rowVo3.setMngrVerCd(row.getDoc().getMngrVerCd());
        			if(!ObjectUtils.isEmpty(row.getDoc().getNowVerCd())) {
        				rowVo3.setNowVerCd(row.getDoc().getNowVerCd());
        			} else {
        				rowVo3.setNowVerCd(row.getDoc().getMngrVerCd());
        			}
        			rowVo3.setMngrNm(row.getDoc().getMngrNm());
        			rowVo3.setMonitoringYN(row.getDoc().getMonitoringYN());
        			rowVo3.setBtchColctCd("operation3");
        			rowVo3.setBtchColctNm("VM 별 Package 정보");
        			result.add(rowVo3);
        		} else if("ATS".equals(row.getDoc().getStackClCd())){
        			ColctVo rowVo1 = new ColctVo();
        			rowVo1.set_id(row.getDoc().get_id());
        			rowVo1.setRegionId(row.getDoc().getRegionId());
        			rowVo1.setZoneId(row.getDoc().getZoneId());
        			rowVo1.setNetId(row.getDoc().getNetId());
        			rowVo1.setStackClCd(row.getDoc().getStackClCd());
        			rowVo1.setMngrClCd(row.getDoc().getMngrClCd());
        			rowVo1.setMngrVerCd(row.getDoc().getMngrVerCd());
        			if(!ObjectUtils.isEmpty(row.getDoc().getNowVerCd())) {
        				rowVo1.setNowVerCd(row.getDoc().getNowVerCd());
        			} else {
        				rowVo1.setNowVerCd(row.getDoc().getMngrVerCd());
        			}
        			rowVo1.setMngrNm(row.getDoc().getMngrNm());
        			rowVo1.setMonitoringYN(row.getDoc().getMonitoringYN());
        			rowVo1.setBtchColctCd("composition");
        			rowVo1.setBtchColctNm("오토스케일-구성정보");
        			result.add(rowVo1);
        			ColctVo rowVo2 = new ColctVo();
        			rowVo2.set_id(row.getDoc().get_id());
        			rowVo2.setRegionId(row.getDoc().getRegionId());
        			rowVo2.setZoneId(row.getDoc().getZoneId());
        			rowVo2.setNetId(row.getDoc().getNetId());
        			rowVo2.setStackClCd(row.getDoc().getStackClCd());
        			rowVo2.setMngrClCd(row.getDoc().getMngrClCd());
        			rowVo2.setMngrVerCd(row.getDoc().getMngrVerCd());
        			if(!ObjectUtils.isEmpty(row.getDoc().getNowVerCd())) {
        				rowVo2.setNowVerCd(row.getDoc().getNowVerCd());
        			} else {
        				rowVo2.setNowVerCd(row.getDoc().getMngrVerCd());
        			}
        			rowVo2.setMngrNm(row.getDoc().getMngrNm());
        			rowVo2.setMonitoringYN(row.getDoc().getMonitoringYN());
        			rowVo2.setBtchColctCd("autoscaleper");
        			rowVo2.setBtchColctNm("오토스케일-성능정보");
        			result.add(rowVo2);
        			ColctVo rowVo3 = new ColctVo();
        			rowVo3.set_id(row.getDoc().get_id());
        			rowVo3.setRegionId(row.getDoc().getRegionId());
        			rowVo3.setZoneId(row.getDoc().getZoneId());
        			rowVo3.setNetId(row.getDoc().getNetId());
        			rowVo3.setStackClCd(row.getDoc().getStackClCd());
        			rowVo3.setMngrClCd(row.getDoc().getMngrClCd());
        			rowVo3.setMngrVerCd(row.getDoc().getMngrVerCd());
        			if(!ObjectUtils.isEmpty(row.getDoc().getNowVerCd())) {
        				rowVo3.setNowVerCd(row.getDoc().getNowVerCd());
        			} else {
        				rowVo3.setNowVerCd(row.getDoc().getMngrVerCd());
        			}
        			rowVo3.setMngrNm(row.getDoc().getMngrNm());
        			rowVo3.setMonitoringYN(row.getDoc().getMonitoringYN());
        			rowVo3.setBtchColctCd("autoscaleevent");
        			rowVo3.setBtchColctNm("오토스케일-이벤트");
        			result.add(rowVo3);
        		}
            }
        }
        int totCnt = result.size();
        int selectCnt = limit + skip;

        // 페이지 처리위한 count
        searchVo.getPaginationInfo().setTotalRecordCount(totCnt);

        // selectCnt결정
        if (totCnt < selectCnt) {
            selectCnt = totCnt;
        }

        /** 코드조회 */
        List<RegionVo> reginItems = regionService.selectRegionAllList();
        List<ZoneVo> zoneItems = zoneService.selectZoneAllList();
        List<CodeVo> netId = commonService.selectCodeList("067", "NETCD", true);	// 망코드;
        List<CodeVo> stackClCd = commonService.selectCodeList("039", "201", true); 	// 스택분류코드

        // 조회된 문서를 List로 담는다.
        if (result.size() > 0) {
            for (int i = skip; i < selectCnt; i++) {
            	ColctVo colctVo = new ColctVo();
            	colctVo.set_id(result.get(i).get_id());
                colctVo.setRegionId(result.get(i).getRegionId());
                colctVo.setZoneId(result.get(i).getZoneId());
                colctVo.setNetId(result.get(i).getNetId());
                colctVo.setStackClCd(result.get(i).getStackClCd());
                colctVo.setMngrClCd(result.get(i).getMngrClCd());
                colctVo.setMngrVerCd(result.get(i).getMngrVerCd());
                if(!ObjectUtils.isEmpty(result.get(i).getNowVerCd())) {
                	colctVo.setNowVerCd(result.get(i).getNowVerCd());
    			} else {
    				colctVo.setNowVerCd(result.get(i).getMngrVerCd());
    			}
                colctVo.setMngrNm(result.get(i).getMngrNm());
                colctVo.setMonitoringYN(result.get(i).getMonitoringYN());

                // 코드값 세팅
                for (int j = 0; j < reginItems.size(); j++) {
                    if (reginItems.get(j).getRegionId().equals(result.get(i).getRegionId())) {
                        colctVo.setRegionNm(reginItems.get(j).getRegionNm());
                    }
                }
                for (int j = 0; j < zoneItems.size(); j++) {
                    if (zoneItems.get(j).getZoneId().equals(result.get(i).getZoneId())) {
                        colctVo.setZoneNm(zoneItems.get(j).getZoneNm());
                    }
                }
				for (int j = 0; j < netId.size(); j++) {
					if (netId.get(j).getCd().equals(result.get(i).getNetId())) {
						colctVo.setNetNm(netId.get(j).getCdNm());
					}
				}
                for (int j = 0; j < stackClCd.size(); j++) {
                    if (stackClCd.get(j).getCd().equals(result.get(i).getStackClCd())) {
                    	colctVo.setStackClNm(stackClCd.get(j).getCdNm());
                    }
                }
                if(commonService.selectCode(colctVo.getMngrClCd(),"039") != null) {
                	colctVo.setMngrClNm(commonService.selectCode(colctVo.getMngrClCd(),"039").getCdNm());
                }
                if(commonService.selectCode(colctVo.getMngrVerCd(),"039") != null) {
                	colctVo.setMngrVerNm(commonService.selectCode(colctVo.getMngrVerCd(),"039").getCdNm());
                }
                if(commonService.selectCode(colctVo.getNowVerCd(),"039") != null) {
                	colctVo.setNowVerNm(commonService.selectCode(colctVo.getNowVerCd(),"039").getCdNm());
                }
                colctVo.setBtchColctCd(result.get(i).getBtchColctCd());
                colctVo.setBtchColctNm(result.get(i).getBtchColctNm());
                resultList.add(colctVo);
            }
        }

        logger.debug("[======= selectColctList end =======]");
        return resultList;
    }

    /**
     * 배치 수집현황 체크
     *
     * @param ColctVo Colct
     */
    @Override
    public ColctVo selectColctHealthCheck(String colctId, String mngrId, String stackClCd, String btchColctCd) throws Exception {
    	ColctVo result = new ColctVo();
    	result.set_id(colctId);
    	result.setBtchSttus(false);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");

		String url = "";
		if("composition".equals(btchColctCd)){
			url = PropertiesUtil.getProperty("gateway.composition.url") + "/_design/colctdttmdoc/_view/basicview";
		} else if("operation1".equals(btchColctCd)){
			url = PropertiesUtil.getProperty("gateway.composition.url") + "/_design/colctdttmdoc/_view/oper1view";
		} else if("operation2".equals(btchColctCd)){
			url = PropertiesUtil.getProperty("gateway.composition.url") + "/_design/colctdttmdoc/_view/oper2view";
		} else if("operation3".equals(btchColctCd)){
			url = PropertiesUtil.getProperty("gateway.composition.url") + "/_design/colctdttmdoc/_view/oper3view";
		} else if("performance".equals(btchColctCd)){
			if("STG".equals(stackClCd)){
				url = PropertiesUtil.getProperty("gateway.performanceStg.url") + "/_design/colctdttmdoc/_view/performanceview";
			} else {
				url = PropertiesUtil.getProperty("gateway.performancePm.url") + "/_design/colctdttmdoc/_view/performanceview";
			}
		} else if("event".equals(btchColctCd)){
			url = PropertiesUtil.getProperty("gateway.event.url") + "/_design/colctdttmdoc/_view/eventview";
		} else if("autoscaleper".equals(btchColctCd)){
			url = PropertiesUtil.getProperty("gateway.autoscalePerNode.url") + "/_design/colctdttmdoc/_view/performanceview";
		} else if("autoscaleevent".equals(btchColctCd)){
			url = PropertiesUtil.getProperty("gateway.autoscaleEvent.url") + "/_design/colctdttmdoc/_view/eventview";
		}

		if(!"".equals(url)) {
	        // 쿼리 파라미터 생성
	        QueryParamVo queryParam = new QueryParamVo();
	        String[] startKey = new String[2];
	        startKey[0] = mngrId;
	        startKey[1] = "99999999 999999";
	        queryParam.setStartkey(startKey);
	        String[] endKey = new String[2];
	        endKey[0] = mngrId;
	        endKey[1] = "00000000 000000";
	        queryParam.setEndkey(endKey);
	        queryParam.setDescending(true);
	        queryParam.setLimit(1);

	        // 목록 조회 요청
	        ViewResponseVo<ViewVo> response = template.get(url, queryParam, TYPE_VIEW_STTUS);
	        if (response.getRows() != null && response.getRows().size() > 0) {
	        	ViewVo rowVo = response.getRows().get(0).getValue();
	        	if(rowVo.getColctDttm() != null && !"".equals(rowVo.getColctDttm())) {
		        	String value = rowVo.getColctDttm();
		        	String btchTime = getBtchTime(btchColctCd);
		        	if(value != null) {
			        	try {
			        		Date valueDate = formatter.parse(value);
			        		Date btchDate = formatter.parse(btchTime);
			        		if((valueDate.getTime() - btchDate.getTime()) >= 0) {
			        			result.setBtchSttus(true);
			        		}
			        	} catch (Exception e) {
			        		result.setBtchSttus(false);
			        	}
		        	}
	        	}
	        }
		} else {
			result.setBtchSttus(true);
		}

		return result;
    }

	/**
	 * 배치시간 조회
	 * @param BtchVo 배치관리 내용
	 */
	private String getBtchTime(String btchColctCd) throws Exception {
		String btchTime = "";

		String dbUrl = PropertiesUtil.getProperty("gateway.batchSchedule.url");
		String url = dbUrl+"/"+btchColctCd;

		QueryParamVo queryParam = new QueryParamVo();
		queryParam.setInclude_docs(true);

		// 목록 조회 요청
		BtchVo responseVo = template.get(url, queryParam, TYPE_ROW_BTCH);

		// 조회된 문서를 List로 담는다.
		if (responseVo.getCronExpression() != null && !"".equals(responseVo.getCronExpression())) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");

			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());

			String[] cronPart = responseVo.getCronExpression().split(" ");
			if("*".equals(cronPart[1])) {
				cal.add(Calendar.MINUTE, -1);
			} else if(cronPart[1].indexOf("/") > 0){
				cal.add(Calendar.MINUTE, -1*(Integer.parseInt((cronPart[1].split("/"))[1])));
			} else if("*".equals(cronPart[2])) {
				cal.add(Calendar.HOUR_OF_DAY, -1);
			} else if(cronPart[2].indexOf("/") > 0){
				cal.add(Calendar.HOUR_OF_DAY, -1*(Integer.parseInt((cronPart[2].split("/"))[1])));
			} else if("*".equals(cronPart[3])) {
				cal.add(Calendar.DATE, -1);
			} else if(cronPart[3].indexOf("/") > 0){
				cal.add(Calendar.DATE, -1*(Integer.parseInt((cronPart[3].split("/"))[1])));
			} else if("*".equals(cronPart[4])) {
				cal.add(Calendar.DAY_OF_MONTH, -1);
			} else if(cronPart[4].indexOf("/") > 0){
				cal.add(Calendar.DAY_OF_MONTH, -1*(Integer.parseInt((cronPart[4].split("/"))[1])));
			}
			btchTime = formatter.format(cal.getTime());
		}
		return btchTime;
	}

}
