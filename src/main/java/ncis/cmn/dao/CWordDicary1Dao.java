package ncis.cmn.dao;

import ncis.cmn.entity.WordDicary1;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 용어사전 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cWordDicary1Dao")
public class CWordDicary1Dao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 용어사전 등록
	 * @param wordDicary1
	 */
	public void insertWordDicary1(WordDicary1 wordDicary1) {
		sqlSession.insert("ncis.sql.cmn.wordDicary1.insertWordDicary1", wordDicary1);
	}

	/**
	 * 용어사전 수정
	 * @param wordDicary1
	 */
	public void updateWordDicary1(WordDicary1 wordDicary1) {
		sqlSession.update("ncis.sql.cmn.wordDicary1.updateWordDicary1", wordDicary1);
	}

	/**
	 * 용어사전 삭제
	 * @param wordDicary1
	 */
	public void deleteWordDicary1(WordDicary1 wordDicary1) {
		sqlSession.update("ncis.sql.cmn.wordDicary1.deleteWordDicary1", wordDicary1);
	}

}
