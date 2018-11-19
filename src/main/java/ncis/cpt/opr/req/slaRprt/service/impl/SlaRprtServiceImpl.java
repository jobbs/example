/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SlaRprtServiceImpl.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 6.
 * @lastmodified 2016. 10. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 6.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.slaRprt.service.impl;

import javax.annotation.Resource;

import ncis.cpt.opr.req.slaRprt.dao.SlaRprtDao;
import ncis.cpt.opr.req.slaRprt.service.SlaRprtService;
import ncis.cpt.opr.req.slaRprt.vo.SlaRprtSearchVo;
import ncis.cpt.opr.req.slaRprt.vo.SlaRprtVo;

import org.springframework.stereotype.Service;

/**
 * @author 이화영
 *
 */
@Service("slaRprtService")
public class SlaRprtServiceImpl implements SlaRprtService {

	@Resource(name="slaRprtDao") private SlaRprtDao slaRprtDao;

	/**
	 * 검색 조건에 해당하는 SLA리포트  조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	public SlaRprtVo selectSlaRprt(SlaRprtSearchVo searchVo) {
		return slaRprtDao.selectSlaRprt(searchVo);
	}


}
