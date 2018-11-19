/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * InsttChngStteDao.java
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

import ncis.dsb.stts.use.serv.vo.InsttChngStteSearchVo;
import ncis.dsb.stts.use.serv.vo.InsttChngStteVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("insttChngStteDao")
public class InsttChngStteDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 기관별 변동 현황 목록
	 * */
	public List<InsttChngStteVo> selectInsttChngStteList(InsttChngStteSearchVo searchVo){

		return sqlSession.selectList("ncis.sql.dsb.stts.insttChngStte.selectInsttChngStteList",searchVo);
	}

	/**
	 * 기관별 변동 현황 목록 건수
	 * */
	public int selectInsttChngStteTotCnt(InsttChngStteSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.dsb.stts.insttChngStte.selectInsttChngStteTotCnt",searchVo);
	}

}
