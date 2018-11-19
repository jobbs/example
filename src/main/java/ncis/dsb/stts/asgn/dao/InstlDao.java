/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * InstlDao.java
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
 * 2016. 12. 10   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.asgn.dao;

import java.util.List;

import ncis.dsb.stts.asgn.vo.InstlSearchVo;
import ncis.dsb.stts.asgn.vo.InstlVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("instlDao")
public class InstlDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 자원풀 구축 현황 조회
	 * @param searchVo
	 * @return
	 */
	public List<InstlVo> selectInstlList(InstlSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.asgn.instl.selectInstlList", searchVo);
	}

	/**
	 * 자원풀 구축 현황 상세보기
	 * @param searchVo
	 * @return
	 */
	public List<InstlVo> selectInstlView(InstlSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.asgn.instl.selectInstlView", searchVo);
	}

	/**
	 * 자원 회수 현황 입력 또는 수정
	 * @return
	 */
	public void insertInstl(InstlVo insertVo){
		sqlSession.selectList("ncis.sql.dsb.stts.asgn.instl.insertInstl", insertVo);
	}

	/**
	 * 자원풀 구축 현황 삭제
	 */
	public void deleteInstl(InstlVo vo) throws Exception{
		sqlSession.insert("ncis.sql.dsb.stts.asgn.instl.deleteInstl",vo);
	}

}
