/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SlaRprtDao.java
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
package ncis.cpt.opr.req.slaRprt.dao;

import ncis.cpt.opr.req.slaRprt.vo.SlaRprtSearchVo;
import ncis.cpt.opr.req.slaRprt.vo.SlaRprtVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 이화영
 *
 */
@Repository("slaRprtDao")
public class SlaRprtDao {

	@Autowired SqlSessionTemplate sqlSession;

	/** 검색 조건에 해당하는 SLA리포트 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	public SlaRprtVo selectSlaRprt(SlaRprtSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.slaRprt.selectSlaRprt", searchVo);
	}


}
