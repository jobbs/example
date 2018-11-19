/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PrcssServiceImpl.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 9. 30.
 * @lastmodified 2016. 9. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 30.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.CRnSRoutingScriptDao;
import ncis.cmn.entity.RnSRoutingScript;
import ncis.cpt.opr.catalg.dao.RoutingScriptDao;
import ncis.cpt.opr.catalg.service.RoutingScriptService;
import ncis.cpt.opr.catalg.vo.RoutingScriptSearchVo;
import ncis.cpt.opr.catalg.vo.RoutingScriptVo;

import org.springframework.stereotype.Service;

/**
 * @author 이화영
 *
 */
@Service("routingScriptService")
public class RoutingScriptServiceImpl implements RoutingScriptService {

	@Resource(name="cRnSRoutingScriptDao") private CRnSRoutingScriptDao cRnSRoutingScriptDao;
	@Resource(name="routingScriptDao") private RoutingScriptDao routingScriptDao;

	@Override
	public List<RoutingScriptVo> selectScriptList(RoutingScriptSearchVo searchVo) {

		List<RoutingScriptVo> list = null;

		int totalCount = routingScriptDao.selectScriptListTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = routingScriptDao.selectScriptList(searchVo);
		}
		return list;
	}

	@Override
	public RoutingScriptVo selectScript(Long routingScriptSeq) {
		return routingScriptDao.selectScript(routingScriptSeq);
	}

	@Override
	public void insertScript(RnSRoutingScript rnSRoutingScript) {
		cRnSRoutingScriptDao.insertRnSRoutingScript(rnSRoutingScript);

	}

	@Override
	public void updateScript(RnSRoutingScript rnSRoutingScript) {
		cRnSRoutingScriptDao.updateRnSRoutingScript(rnSRoutingScript);
	}

	@Override
	public void deleteScript(Long sRoutingScriptSeq) {
		cRnSRoutingScriptDao.deleteRnSRoutingScript(sRoutingScriptSeq);
	}

	@Override
	public boolean selectExistRoutingScript(String osTyCd, String osVer, Long routingScriptSeq) {
		return routingScriptDao.selectExistRoutingScript(osTyCd, osVer, routingScriptSeq)>0 ? true:false;
	}
}
