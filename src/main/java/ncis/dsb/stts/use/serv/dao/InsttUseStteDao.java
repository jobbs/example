/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * InsttUseStteDao.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.use.serv.dao;

import java.util.List;

import ncis.dsb.stts.use.serv.vo.InsttUseStteSearchVo;
import ncis.dsb.stts.use.serv.vo.InsttUseStteVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("insttUseStteDao")
public class InsttUseStteDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 기관별 이용 현황 목록
	 * */
	public List<InsttUseStteVo> selectInsttUseStteList(InsttUseStteSearchVo searchVo){

		return sqlSession.selectList("ncis.sql.dsb.stts.instt.selectInsttUseStteList", searchVo);
	}
	/**
	 * 기관별 이용 현황 건수
	 * */
	public int selectInsttUseStteTotCnt(InsttUseStteSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.dsb.stts.instt.selectInsttUseStteTotCnt",searchVo);
	}
	/**
	 * 기관별 이용 현황 목록
	 * */
	public List<InsttUseStteVo> selectInsttUseStteAtmSclList(InsttUseStteSearchVo searchVo){

		return sqlSession.selectList("ncis.sql.dsb.stts.instt.selectInsttUseStteAtmSclList", searchVo);
	}

}
