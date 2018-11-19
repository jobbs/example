package ncis.cmn.dao;

import ncis.cmn.entity.StDspthConf;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfDspthVo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfSearchVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 통보설정 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cStDspthConfDao")
public class CStDspthConfDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 통보설정 등록
	 * @param stDspthConf
	 */
	public void insertStDspthConf(StDspthConf stDspthConf) {
		sqlSession.insert("ncis.sql.cmn.stDspthConf.insertStDspthConf", stDspthConf);
	}

	/**
	 * 통보설정 등록
	 * @param stDspthConf
	 */
	public int insertStDspthConfPm(PmThrdConfDspthVo vo) {
		return sqlSession.insert("ncis.sql.cmn.stDspthConf.insertStDspthConfPm", vo);
	}
	/**
	 * 통보설정 등록
	 * @param stDspthConf
	 */
	public int insertStDspthConfVm(PmThrdConfDspthVo vo) {
		return sqlSession.insert("ncis.sql.cmn.stDspthConf.insertStDspthConfVm", vo);
	}

	/**
	 * 자동확장 통보설정 등록
	 * @param stDspthConf
	 */
	public int insertStDspthConfAx(PmThrdConfDspthVo vo) {
		return sqlSession.insert("ncis.sql.cmn.stDspthConf.insertStDspthConfAx", vo);
	}

	/**
	 * 통보설정 수정
	 * @param stDspthConf
	 */
	public void updateStDspthConf(StDspthConf stDspthConf) {
		sqlSession.update("ncis.sql.cmn.stDspthConf.updateStDspthConf", stDspthConf);
	}

	/**
	 * 통보설정 삭제
	 * @param stDspthConf
	 */
	public void deleteStDspthConf(StDspthConf stDspthConf) {
		sqlSession.update("ncis.sql.cmn.stDspthConf.deleteStDspthConf", stDspthConf);
	}

	/**
	 * 물리서버 통보설정 삭제
	 * @param stDspthConf
	 */
	public int deleteStDspthConfPm(PmThrdConfSearchVo pmThrdConfSearchVo) {
		return sqlSession.update("ncis.sql.cmn.stDspthConf.deleteStDspthConfPm", pmThrdConfSearchVo);
	}
	/**
	 * 물리서버 통보설정 삭제
	 * @param stDspthConf
	 */
	public int deleteStDspthConfVm(PmThrdConfSearchVo pmThrdConfSearchVo) {
		return sqlSession.update("ncis.sql.cmn.stDspthConf.deleteStDspthConfVm", pmThrdConfSearchVo);
	}

	/**
	 * 자동확장 통보설정 삭제
	 * @param stDspthConf
	 */
	public int deleteStDspthConfAx(PmThrdConfSearchVo pmThrdConfSearchVo) {
		return sqlSession.update("ncis.sql.cmn.stDspthConf.deleteStDspthConfAx", pmThrdConfSearchVo);
	}
}
