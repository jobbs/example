/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename WordDicaryDao.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.worddicary.dao;

import java.util.List;

import ncis.cpt.worddicary.vo.WordDicarySearchVo;
import ncis.cpt.worddicary.vo.WordDicaryVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("wordDicaryDao")
public class WordDicaryDao {

	@Autowired SqlSessionTemplate sqlSession;


	public int selectWordDicaryTotCnt(WordDicarySearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.worddicary.selectWordDicaryTotCnt", searchVo);
	}

	/**
	 * 용어사전 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<WordDicaryVo> selectWordDicaryList(WordDicarySearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.worddicary.selectWordDicaryList", searchVo);
	}

	/**
	 * 용어사전 상세조회
	 * @param wordSeq
	 * @return
	 */
	public WordDicaryVo selectWordDicary(Long wordSeq) {
		return sqlSession.selectOne("ncis.sql.cpt.worddicary.selectWordDicary", wordSeq);
	}

}
