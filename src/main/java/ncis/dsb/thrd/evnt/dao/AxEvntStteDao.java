/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxEvntStteDao.java
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
package ncis.dsb.thrd.evnt.dao;

import java.util.List;

import ncis.dsb.thrd.evnt.vo.AxEvntStteSearchVo;
import ncis.dsb.thrd.evnt.vo.AxEvntStteVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("axEvntStteDao")
public class AxEvntStteDao {

	@Autowired SqlSessionTemplate sqlSession;

	public List<AxEvntStteVo> selectAxEvntStteList(AxEvntStteSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.thrd.axEvntStte.selectAxEvntStteList",searchVo);
	}
	public int selectAxEvntStteListCnt(AxEvntStteSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.dsb.thrd.axEvntStte.selectAxEvntStteListCnt",searchVo);
	}

}
