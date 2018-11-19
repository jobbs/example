/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxLogDao.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 08. 10
 * @lastmodified2017. 08. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 08. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.log.axLog.dao;

import java.util.List;

import ncis.dsb.stts.log.axLog.vo.AxLogSearchVo;
import ncis.dsb.stts.log.axLog.vo.AxLogVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("axLogDao")
public class AxLogDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 자동확장 로그 조회
	 * */
	public int selectAxLogTotCnt(AxLogSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.dsb.stts.axlog.selectAxLogTotCnt",searchVo);
	}

	public List<AxLogVo> selectAxLogList(AxLogSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.axlog.selectAxLogList",searchVo);
	}

}
