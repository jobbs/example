package ncis.cmn.dao;

import ncis.cmn.entity.StThresDfltConf;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cStThresDfltConfDao")
public class CStThresDfltConfDao {

	@Autowired SqlSessionTemplate sqlSession;


	/**
	 * 기본 임계치 설정 등록
	 */
	public void insertStThresDfltConf(StThresDfltConf vo) {
		sqlSession.insert("ncis.sql.cmn.stThresDfltConf.insertStThresDfltConf",vo);
	}

	/**
	 * 기본 임계치 설정 수정
	 */
	public int updateStThresDfltConf(StThresDfltConf vo) {
		return sqlSession.update("ncis.sql.cmn.stThresDfltConf.updateStThresDfltConf",vo);
	}

	/**
	 * 기본 임계치 설정 삭제
	 */
	public int  deleteStThresDfltConf(Long key) {
		return sqlSession.delete("ncis.sql.cmn.stThresDfltConf.deleteStThresDfltConf", key);
	}

}
