/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxSpecPerPoolDao.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 10. 10
 * @lastmodified2017. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.axusert.dao;

import java.util.List;

import ncis.dsb.stts.axusert.vo.AxSpecPerPoolSearchVo;
import ncis.dsb.stts.axusert.vo.AxSpecPerPoolVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("axSpecPerPoolDao")
public class AxSpecPerPoolDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색 조건에 해당하는자원풀별 자동확장사양분포 조회
	 * @param searchVo
	 * @return
	 */
	public int selectAxSpecPerPoolTotCnt(AxSpecPerPoolSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.dsb.stts.axusert.axSpecPerPool.selectAxSpecPerPoolTotCnt", searchVo);
	}

	/**
	 * 자원풀별 자동확장사양분포 조회
	 * @param searchVo
	 * @return
	 */
	public List<AxSpecPerPoolVo> selectAxSpecPerPoolList(AxSpecPerPoolSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.axusert.axSpecPerPool.selectAxSpecPerPoolList", searchVo);
	}

}
