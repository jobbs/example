package ncis.cmn.dao;

import ncis.cmn.entity.WordDicary;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cWordDicaryDao")
public class CWordDicaryDao {

	@Autowired SqlSessionTemplate sqlSession;


	/**
	 * 용어사전 등록
	 * @param roleUserVo
	 */
	public void insertWordDicary(WordDicary dicary) {
		sqlSession.insert("ncis.sql.cmn.worddicary.insertWordDicary",dicary);
	}

	/**
	 * 영어사전 수정
	 * @param dicary
	 */
	public void updateWordDicary(WordDicary dicary) {
		sqlSession.update("ncis.sql.cmn.worddicary.updateWordDicary",dicary);
	}

	/**
	 * 용어사전삭제
	 * @param roleUser
	 */
	public void deleteWordDicary(Long wordSeq) {
		sqlSession.delete("ncis.sql.cmn.worddicary.deleteWordDicary", wordSeq);
	}

}
