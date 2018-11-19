/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename GatewayServiceImpl.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 9. 23.
 * @lastmodified 2016. 9. 23.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 23.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.gateway.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.CCmGatewayDao;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cpt.sys.gateway.dao.GatewayDao;
import ncis.cpt.sys.gateway.service.GatewayService;
import ncis.cpt.sys.gateway.vo.GatewaySearchVo;
import ncis.cpt.sys.gateway.vo.GatewayVo;
import ncis.intfc.apigwstatus.service.ApiGwStatusService;
import ncis.intfc.apigwstatus.vo.ResultHealthCheckVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * @author 박봉춘
 *
 */
@Service("GatewayService")
public class GatewayServiceImpl implements GatewayService {

    private final Logger logger = LoggerFactory.getLogger(GatewayServiceImpl.class);

	@Resource(name="cCmGatewayDao") private CCmGatewayDao cGatewayDao;
	@Resource(name="GatewayDao") private GatewayDao gatewayDao;

	@Resource(name="apiGwStatusService") private ApiGwStatusService apiGwStatusService;

	@Override
	public List<GatewayVo> selectGatewayList(GatewaySearchVo searchVo) {

		List<GatewayVo> list = null;

		int totalCount = gatewayDao.selectGatewayTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = gatewayDao.selectGatewayList(searchVo);
		}


		return list;
	}

	@Override
	public List<GatewayVo> selectGatewayHealthCheck(String regionId) throws Exception {

	    List<GatewayVo> list = new ArrayList<GatewayVo>();

	    RestHeaders headers = new RestHeaders();
	    ResultHealthCheckVO healthVo = null;
	    GatewayVo gateway = null;

        gateway = new GatewayVo();
        gateway.setGatewaySeq(new Long(0));
        gateway.setRegionId(regionId);

        try {
            headers.setAreaId(regionId);
            healthVo = apiGwStatusService.healthCheck(headers);
            gateway.setHealth(healthVo);
        } catch (HttpStatusCodeException e) {
            logger.error(e.getResponseBodyAsString(), e);

            healthVo = new ResultHealthCheckVO();
            healthVo.setCondition("fail");
            gateway.setHealth(healthVo);
        }

        list.add(gateway);

	    return list;
	}

	@Override
	public void insertGateway(GatewayVo gatewayvo){
		cGatewayDao.insertCmGateway(gatewayvo);
	}

	@Override
	public void updateGateway(GatewayVo gatewayvo){
		cGatewayDao.updateCmGateway(gatewayvo);
	}

	@Override
	public GatewayVo selectGateway(Long gatewaySeq) {
		return gatewayDao.selectGateway(gatewaySeq);
	}

	@Override
	public int selectRegionCnt(String regionId, Long gatewaySeq) {
		return gatewayDao.selectRegionCnt(regionId, gatewaySeq);
	}

	@Override
	public void deleteGateway(Long gatewaySeq) {
		cGatewayDao.deleteCmGateway(gatewaySeq);
	}


}

