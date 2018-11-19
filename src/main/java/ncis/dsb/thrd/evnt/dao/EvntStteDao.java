/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * EvntStteDao.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   김동훈         v1.0             최초생성
 *
 */
package ncis.dsb.thrd.evnt.dao;

import java.util.List;

import ncis.dsb.thrd.evnt.vo.EvntStteSearchVo;
import ncis.dsb.thrd.evnt.vo.EvntStteVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("evntStteDao")
public class EvntStteDao {

	@Autowired SqlSessionTemplate sqlSession;

	public List<EvntStteVo> selectEvntStteList(EvntStteSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.thrd.evntStte.selectEvntStteList",searchVo);
	}
	public int selectEvntStteListCnt(EvntStteSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.dsb.thrd.evntStte.selectEvntStteListCnt",searchVo);
	}

}
