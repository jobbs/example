package ncis.cmn.dao;

import ncis.cmn.entity.StEvnt;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 이벤트 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cStEvntDao")
public class CStEvntDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 이벤트 등록
	 * @param stEvnt
	 */
	public void insertStEvnt(StEvnt stEvnt) {
		sqlSession.insert("ncis.sql.cmn.stEvnt.insertStEvnt", stEvnt);
	}

	/**
	 * 이벤트 수정
	 * @param stEvnt
	 */
	public void updateStEvnt(StEvnt stEvnt) {
		sqlSession.update("ncis.sql.cmn.stEvnt.updateStEvnt", stEvnt);
	}

	/**
	 * 이벤트 삭제
	 * @param stEvnt
	 */
	public void deleteStEvnt(StEvnt stEvnt) {
		sqlSession.update("ncis.sql.cmn.stEvnt.deleteStEvnt", stEvnt);
	}
	//이벤트 확인
	public int updateEvntConfrm(StEvnt stEvnt){
		return sqlSession.update("ncis.sql.cmn.stEvnt.updateEvntConfrm",stEvnt);
	}
	//이벤트 확인 취소
	public int updateEvntConfrmCncl(StEvnt stEvnt){
		return sqlSession.update("ncis.sql.cmn.stEvnt.updateEvntConfrmCncl",stEvnt);
	}

	//자동확장 이벤트 확인
	public int updateAxEvntConfrm(StEvnt stEvnt){
		return sqlSession.update("ncis.sql.cmn.stEvnt.updateEvntConfrm",stEvnt);
	}
	//자동확장 이벤트 확인 취소
	public int updateAxEvntConfrmCncl(StEvnt stEvnt){
		return sqlSession.update("ncis.sql.cmn.stEvnt.updateEvntConfrmCncl",stEvnt);
	}

}
