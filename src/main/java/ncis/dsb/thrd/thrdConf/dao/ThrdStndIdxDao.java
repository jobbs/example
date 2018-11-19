/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ThrdStndIdxDao.java
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
package ncis.dsb.thrd.thrdConf.dao;

import java.util.List;

import ncis.dsb.thrd.thrdConf.vo.ThrdStndIdxSearchVo;
import ncis.dsb.thrd.thrdConf.vo.ThrdStndIdxVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("thrdStndIdxDao")
public class ThrdStndIdxDao {

	@Autowired SqlSessionTemplate sqlSession;

	public List<ThrdStndIdxVo> selectThrdStndIdxList(ThrdStndIdxSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.thrd.thrdStndIdx.selectThrdStndIdxList",searchVo);
	}
	public int selectThrdStndIdxTotCnt(ThrdStndIdxSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.dsb.thrd.thrdStndIdx.selectThrdStndIdxTotCnt",searchVo);
	}
	public ThrdStndIdxVo selectThrdStndIdx(ThrdStndIdxSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.dsb.thrd.thrdStndIdx.selectThrdStndIdxList",searchVo);
	}



}
