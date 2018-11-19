package ncis.cmn.dao;

import ncis.cmn.entity.StEvntDspthHist;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 이벤트통보(이력) DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cStEvntDspthHistDao")
public class CStEvntDspthHistDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 이벤트통보(이력) 등록
	 * @param stEvntDspthHist
	 */
	public void insertStEvntDspthHist(StEvntDspthHist stEvntDspthHist) {
		sqlSession.insert("ncis.sql.cmn.stEvntDspthHist.insertStEvntDspthHist", stEvntDspthHist);
	}

	/**
	 * 이벤트통보(이력) 수정
	 * @param stEvntDspthHist
	 */
	public void updateStEvntDspthHist(StEvntDspthHist stEvntDspthHist) {
		sqlSession.update("ncis.sql.cmn.stEvntDspthHist.updateStEvntDspthHist", stEvntDspthHist);
	}

	/**
	 * 이벤트통보(이력) 삭제
	 * @param stEvntDspthHist
	 */
	public void deleteStEvntDspthHist(StEvntDspthHist stEvntDspthHist) {
		sqlSession.update("ncis.sql.cmn.stEvntDspthHist.deleteStEvntDspthHist", stEvntDspthHist);
	}

}
