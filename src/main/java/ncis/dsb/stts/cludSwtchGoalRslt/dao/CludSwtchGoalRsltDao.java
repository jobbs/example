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
import java.util.Map;

import ncis.cmn.entity.StCludSwtchGoalRslt;
import ncis.dsb.stts.cludSwtchGoalRslt.vo.CludSwtchGoalRsltVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cludSwtchGoalRsltDao")
public class CludSwtchGoalRsltDao {

	@Autowired SqlSessionTemplate sqlSession;
	/**
	 * 클라우드 전환 목표 실적 목록조회
	 * */
	public List<CludSwtchGoalRsltVo> selectCludSwtchGoalRsltList() throws Exception {
		return sqlSession.selectList("ncis.sql.dsb.stts.cludSwtchGoalRslt.selectCludSwtchGoalRslt");
	}
	/**
	 * 클라우드 전환 실적 상세조회
	 * */
	public List<Map<String, Object>> selectCludSwtchRsltDtl(List<String> list) throws Exception {
		return sqlSession.selectList("ncis.sql.dsb.stts.cludSwtchGoalRslt.selectCludSwtchRsltDtl",list);
	}
	/**
	 * 2011년부터 현재년도 목록조회
	 * */
	public List<String> select2011toCurrentYear() throws Exception {
		return sqlSession.selectList("ncis.sql.dsb.stts.cludSwtchGoalRslt.select2011toCurrentYear");
	}
	/**
	 * 클라우드 전환 목표 실적 상세조회
	 * */
	public List<Map<String, Object>> selectCludSwtchGoalRsltDtl(List<String> yearList) throws Exception {
		return sqlSession.selectList("ncis.sql.dsb.stts.cludSwtchGoalRslt.selectCludSwtchGoalRsltDtl",yearList);
	}
	/**
	 * 클라우드 전환 목표 실적 삭제
	 * */
	public int deleteCludSwtchGoalRslt()throws Exception{
		return sqlSession.delete("ncis.sql.cmn.StCludSwtchGoalRslt.deleteStCludSwtchGoalRslt");
	}
	/**
	 * 클라우드 전환 목표 실적 등록
	 * */
	public int insertCludSwtchGoalRslt(StCludSwtchGoalRslt vo)throws Exception{
		return sqlSession.insert("ncis.sql.cmn.StCludSwtchGoalRslt.insertStCludSwtchGoalRslt",vo);
	}
}
