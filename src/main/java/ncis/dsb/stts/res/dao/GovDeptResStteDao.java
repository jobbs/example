/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * GovDeptResStteDao.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 17
 * @lastmodified2016. 10. 17
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 17   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.res.dao;

import java.util.List;

import ncis.dsb.stts.res.vo.GovAxCntVo;
import ncis.dsb.stts.res.vo.GovDeptResInfoVo;
import ncis.dsb.stts.res.vo.GovDeptResStteSearchVo;
import ncis.dsb.stts.res.vo.GovDeptResStteVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("govDeptResStteDao")
public class GovDeptResStteDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 부처업무 가상서버 정보 조회
	 * @param searchVo
	 * @return
	 */
	public GovDeptResInfoVo selectGovDeptResInfo(GovDeptResStteSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.stts.res.GovDeptResStte.selectGovDeptResInfo", SearchVo);

	}

	/**
	 * Ax
	 * @param searchVo
	 * @return
	 */
	public GovAxCntVo selectAxCnt(GovDeptResStteSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.stts.res.GovDeptResStte.selectGovAxCnt", SearchVo);

	}


	/**
	 * 부처 자원 현황 조회
	 * @param searchVo
	 * @return
	 */
	public List<GovDeptResStteVo> selectGovDeptResList(GovDeptResStteSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.GovDeptResStte.selectGovDeptResList", searchVo);
	}


}
