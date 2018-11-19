package ncis.cmn.dao;

import ncis.cmn.entity.StProf;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cStProfDao")
public class CStProfDao {

	@Autowired SqlSessionTemplate sqlSession;


	/**
	 * 프로파일 등록
	 * @param roleUserVo
	 */
	public void insertStProf(StProf vo) {
		sqlSession.insert("ncis.sql.cmn.StProf.insertStProf",vo);
	}
	public long selectStProfSeq(){
		return sqlSession.selectOne("ncis.sql.cmn.StProf.selectStProfSeq");
	}
	/**
	 * 프로파일 수정
	 * @param dicary
	 */
	public int updateStProf(StProf vo) {
		return  sqlSession.update("ncis.sql.cmn.StProf.updateStProf",vo);
	}

	/**
	 * 프로파일 삭제
	 * @param roleUser
	 */
	public int deleteStProf(Long key) {
		return sqlSession.delete("ncis.sql.cmn.StProf.deleteStProf", key);
	}

}
