package ncis.cmn.dao;

import ncis.cmn.entity.StSrvrEvntOccr;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 서버별이벤트발생 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cStSrvrEvntOccrDao")
public class CStSrvrEvntOccrDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 서버별이벤트발생 등록
	 * @param stSrvrEvntOccr
	 */
	public void insertStSrvrEvntOccr(StSrvrEvntOccr stSrvrEvntOccr) {
		sqlSession.insert("ncis.sql.cmn.stSrvrEvntOccr.insertStSrvrEvntOccr", stSrvrEvntOccr);
	}

	/**
	 * 서버별이벤트발생 수정
	 * @param stSrvrEvntOccr
	 */
	public void updateStSrvrEvntOccr(StSrvrEvntOccr stSrvrEvntOccr) {
		sqlSession.update("ncis.sql.cmn.stSrvrEvntOccr.updateStSrvrEvntOccr", stSrvrEvntOccr);
	}

	/**
	 * 서버별이벤트발생 삭제
	 * @param stSrvrEvntOccr
	 */
	public void deleteStSrvrEvntOccr(StSrvrEvntOccr stSrvrEvntOccr) {
		sqlSession.update("ncis.sql.cmn.stSrvrEvntOccr.deleteStSrvrEvntOccr", stSrvrEvntOccr);
	}

}
