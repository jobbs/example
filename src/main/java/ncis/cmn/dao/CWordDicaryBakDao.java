package ncis.cmn.dao;

import ncis.cmn.entity.WordDicaryBak;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 용어사전 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cWordDicaryBakDao")
public class CWordDicaryBakDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 용어사전 등록
	 * @param wordDicaryBak
	 */
	public void insertWordDicaryBak(WordDicaryBak wordDicaryBak) {
		sqlSession.insert("ncis.sql.cmn.wordDicaryBak.insertWordDicaryBak", wordDicaryBak);
	}

	/**
	 * 용어사전 수정
	 * @param wordDicaryBak
	 */
	public void updateWordDicaryBak(WordDicaryBak wordDicaryBak) {
		sqlSession.update("ncis.sql.cmn.wordDicaryBak.updateWordDicaryBak", wordDicaryBak);
	}

	/**
	 * 용어사전 삭제
	 * @param wordDicaryBak
	 */
	public void deleteWordDicaryBak(WordDicaryBak wordDicaryBak) {
		sqlSession.update("ncis.sql.cmn.wordDicaryBak.deleteWordDicaryBak", wordDicaryBak);
	}

}
