/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PrcssDao.java
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
package ncis.cpt.opr.catalg.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ncis.cpt.opr.catalg.vo.RoutingScriptSearchVo;
import ncis.cpt.opr.catalg.vo.RoutingScriptVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 이화영
 *
 */
@Repository("routingScriptDao")
public class RoutingScriptDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색 조건에 해당하는 스태틱라우팅 스크립트 목록 카운트
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	public int selectScriptListTotCnt(RoutingScriptSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.routingscript.selectScriptListTotCnt", searchVo);
	}

	/**
	 * 검색 조건에 해당하는 스태틱라우팅 스크립트 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	public List<RoutingScriptVo> selectScriptList(RoutingScriptSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.routingscript.selectScriptList", searchVo);
	}

	/** 스태틱라우팅 스크립트 상세조회
	 * @param procssSeq	스태틱라우팅 스크립트Id
	 * @return
	 */
	public RoutingScriptVo selectScript(Long routingScriptSeq) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.routingscript.selectScript", routingScriptSeq);
	}

	/**
	 * 동일한 OS유형에 OS버전에 존재하는지 여부 판단.
	 * @param routingScript
	 * @return
	 */
	public int selectExistRoutingScript(String osTyCd, String osVer, Long routingScriptSeq) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("osTyCd", osTyCd);
		params.put("osVer", osVer);
		params.put("routingScriptSeq", routingScriptSeq);

		return sqlSession.selectOne("ncis.sql.cpt.opr.routingscript.selectExistRoutingScript", params);
	}

}

