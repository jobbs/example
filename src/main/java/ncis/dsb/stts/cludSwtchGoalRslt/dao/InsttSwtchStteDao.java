/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * DbmsSpaceUseRtDao.java
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
package ncis.dsb.stts.cludSwtchGoalRslt.dao;

import java.util.List;

import ncis.cmn.vo.CommonSearchVo;
import ncis.dsb.stts.cludSwtchGoalRslt.vo.InsttSwtchStteVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("insttSwtchStteDao")
public class InsttSwtchStteDao {

	@Autowired SqlSessionTemplate sqlSession;
	/**
	 * 기관별 전환 현황 목록조회
	 * */
	public List<InsttSwtchStteVo> selectInsttSwtchStteList(CommonSearchVo vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ncis.sql.dsb.stts.cludSwtchGoalRslt.insttSwtchStte.selectInsttSwtchStteList",vo);
	}
	/**
	 * 기관별 전환 현황 등록
	 * */
	public int insertCludReqPrcssStte(InsttSwtchStteVo vo)throws Exception{
		return sqlSession.delete("ncis.sql.cmn.stInsttSwtchStte.insertStInsttSwtchStte",vo);
	}
	/**
	 * 기관별 전환 현황 삭제
	 * */
	public int deleteCludReqPrcssStte()throws Exception{
		return sqlSession.delete("ncis.sql.cmn.stInsttSwtchStte.deleteStInsttSwtchStte");
	}
}
