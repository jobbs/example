/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TmplatDao.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 5.
 * @lastmodified 2016. 10. 5.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 5.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.dao;

import java.util.List;

import ncis.cpt.opr.catalg.vo.TmplatSvo;
import ncis.cpt.opr.catalg.vo.TmplatSwVo;
import ncis.cpt.opr.catalg.vo.TmplatVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 송승규
 *
 */
@Repository("tmplatDao")
public class TmplatDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * 템플릿 조회건수
	 * @param svo
	 * @return
	 */
	public int selectTmplatTotCnt(TmplatSvo svo){

		return sqlSession.selectOne("ncis.sql.cpt.tmplat.selectTmplatTotCnt",svo);
	}

	/**
	 * 템플릿 목록조회
	 * @param svo
	 * @return
	 */
	public List<TmplatVo> selectTmplatList(TmplatSvo svo){

		return sqlSession.selectList("ncis.sql.cpt.tmplat.selectTmplatList", svo);
	}

	/**
	 * 템플릿 상세조회
	 * @param tmplatSeq
	 * @return
	 */
	public TmplatVo selectTmplatDetail(Integer tmplatSeq){

		return sqlSession.selectOne("ncis.sql.cpt.tmplat.selectTmplatDetail",tmplatSeq);
	}

	/**
	 * 소프트웨어 조회건수
	 * @param svo
	 * @return
	 */
	public int selectSwTotCnt(TmplatSvo svo){

		return sqlSession.selectOne("ncis.sql.cpt.tmplat.selectSwTotCnt", svo);
	}

	/**
	 * 소프트웨어 목록조회
	 * @param svo
	 * @return
	 */
	public List<TmplatSwVo> selectSwList(TmplatSvo svo){

		return sqlSession.selectList("ncis.sql.cpt.tmplat.selectSwList", svo);
	}

	/**
	 * 자원요청 vm 생성 팝업 - 템플릿 조회
	 * @param svo
	 * @return
	 */
	public List<TmplatVo> selectRrVmTmplatList(TmplatSvo svo){
		return sqlSession.selectList("ncis.sql.cpt.tmplat.selectRrVmTmplatList", svo);
	}
}
