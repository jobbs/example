/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxThrdConfDao.java
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
package ncis.dsb.thrd.thrdConf.dao;

import java.util.List;

import ncis.dsb.thrd.thrdConf.vo.AxThrdConfSearchVo;
import ncis.dsb.thrd.thrdConf.vo.AxThrdConfVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("axThrdConfDao")
public class AxThrdConfDao {

	@Autowired SqlSessionTemplate sqlSession;

	public List<AxThrdConfVo> selectAxThrdConfList(AxThrdConfSearchVo paramVo){
		return sqlSession.selectList("ncis.sql.dsb.thrd.axThrdConf.selectAxThrdConfList",paramVo);
	}
	public int selectAxThrdConfListCount(AxThrdConfSearchVo paramVo){
		return sqlSession.selectOne("ncis.sql.dsb.thrd.axThrdConf.selectAxThrdConfListCount",paramVo);
	}

}
