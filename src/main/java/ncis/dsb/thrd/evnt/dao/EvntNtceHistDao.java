/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * EvntNtceHistDao.java
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

import ncis.dsb.thrd.evnt.vo.EvntNtceHistVo;
import ncis.dsb.thrd.evnt.vo.EvntNtceHistSearchVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("evntNtceHistDao")
public class EvntNtceHistDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 이벤트 통보이력 목록조회
	 * @param searchVo
	 * @return
	 */
	public List<EvntNtceHistVo> selectEvntNtceHistList(EvntNtceHistSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.thrd.evntStte.selectEvntNtceHistList",searchVo);
	}
	/**
	 * 이벤트 통보이력 목록 건수조회
	 * @param searchVo
	 * @return
	 */
	public int selectEvntNtceHistListCnt(EvntNtceHistSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.dsb.thrd.evntStte.selectEvntNtceHistListCnt",searchVo);
	}

}
