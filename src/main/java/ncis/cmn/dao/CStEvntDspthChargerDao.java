package ncis.cmn.dao;

import ncis.cmn.entity.StEvntDspthCharger;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfDspthVo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfSearchVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 이벤트통보대상자 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cStEvntDspthChargerDao")
public class CStEvntDspthChargerDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 이벤트통보대상자 등록
	 * @param stEvntDspthCharger
	 */
	public void insertStEvntDspthCharger(StEvntDspthCharger stEvntDspthCharger) {
		sqlSession.insert("ncis.sql.cmn.stEvntDspthCharger.insertStEvntDspthCharger", stEvntDspthCharger);
	}
	/**
	 * 물리서버 이벤트통보대상자 등록
	 * @param stEvntDspthCharger
	 */
	public int insertStEvntDspthChargerPm(PmThrdConfDspthVo vo) {
		return sqlSession.insert("ncis.sql.cmn.stEvntDspthCharger.insertStEvntDspthChargerPm", vo);
	}
	/**
	 * 가상서버 이벤트통보대상자 등록
	 * @param stEvntDspthCharger
	 */
	public int insertStEvntDspthChargerVm(PmThrdConfDspthVo vo) {
		return sqlSession.insert("ncis.sql.cmn.stEvntDspthCharger.insertStEvntDspthChargerVm", vo);
	}

	/**
	 * 자동확장 이벤트통보대상자 등록
	 * @param stEvntDspthCharger
	 */
	public int insertStEvntDspthChargerAx(PmThrdConfDspthVo vo) {
		return sqlSession.insert("ncis.sql.cmn.stEvntDspthCharger.insertStEvntDspthChargerAx", vo);
	}
	/**
	 * 이벤트통보대상자 수정
	 * @param stEvntDspthCharger
	 */
	public void updateStEvntDspthCharger(StEvntDspthCharger stEvntDspthCharger) {
		sqlSession.update("ncis.sql.cmn.stEvntDspthCharger.updateStEvntDspthCharger", stEvntDspthCharger);
	}

	/**
	 * 이벤트통보대상자 삭제
	 * @param stEvntDspthCharger
	 */
	public void deleteStEvntDspthCharger(StEvntDspthCharger stEvntDspthCharger) {
		sqlSession.update("ncis.sql.cmn.stEvntDspthCharger.deleteStEvntDspthCharger", stEvntDspthCharger);
	}
	/**
	 * 물리서버 이벤트통보대상자 삭제
	 * @param stEvntDspthCharger
	 */
	public int deleteStEvntDspthChargerPm(PmThrdConfSearchVo pmThrdConfSearchVo) {
		return sqlSession.update("ncis.sql.cmn.stEvntDspthCharger.deleteStEvntDspthChargerPm", pmThrdConfSearchVo);
	}
	/**
	 * 가상서버 이벤트통보대상자 삭제
	 * @param stEvntDspthCharger
	 */
	public int deleteStEvntDspthChargerVm(PmThrdConfSearchVo pmThrdConfSearchVo) {
		return sqlSession.update("ncis.sql.cmn.stEvntDspthCharger.deleteStEvntDspthChargerVm", pmThrdConfSearchVo);
	}

	/**
	 * 자동확장 이벤트통보대상자 삭제
	 * @param stEvntDspthCharger
	 */
	public int deleteStEvntDspthChargerAx(PmThrdConfSearchVo pmThrdConfSearchVo) {
		return sqlSession.update("ncis.sql.cmn.stEvntDspthCharger.deleteStEvntDspthChargerAx", pmThrdConfSearchVo);
	}

}
