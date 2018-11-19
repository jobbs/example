package ncis.cmn.dao;

import ncis.cmn.entity.StDspthGrd;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfDspthVo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfSearchVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 통보등급 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cStDspthGrdDao")
public class CStDspthGrdDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 통보등급 등록
	 * @param stDspthGrd
	 */
	public void insertStDspthGrd(StDspthGrd stDspthGrd) {
		sqlSession.insert("ncis.sql.cmn.stDspthGrd.insertStDspthGrd", stDspthGrd);
	}
	/**
	 * 물리서버 통보등급 등록
	 * @param stDspthGrd
	 */
	public int insertStDspthGrdPm(PmThrdConfDspthVo vo) {
		return sqlSession.insert("ncis.sql.cmn.stDspthGrd.insertStDspthGrdPm", vo);
	}
	/**
	 * 가상서버 통보등급 등록
	 * @param stDspthGrd
	 */
	public int insertStDspthGrdVm(PmThrdConfDspthVo vo) {
		return sqlSession.insert("ncis.sql.cmn.stDspthGrd.insertStDspthGrdVm", vo);
	}

	/**
	 * 자동확장 통보등급 등록
	 * @param stDspthGrd
	 */
	public int insertStDspthGrdAx(PmThrdConfDspthVo vo) {
		return sqlSession.insert("ncis.sql.cmn.stDspthGrd.insertStDspthGrdAx", vo);
	}
	/**
	 * 통보등급 수정
	 * @param stDspthGrd
	 */
	public void updateStDspthGrd(StDspthGrd stDspthGrd) {
		sqlSession.update("ncis.sql.cmn.stDspthGrd.updateStDspthGrd", stDspthGrd);
	}

	/**
	 * 통보등급 삭제
	 * @param stDspthGrd
	 */
	public void deleteStDspthGrd(StDspthGrd stDspthGrd) {
		sqlSession.update("ncis.sql.cmn.stDspthGrd.deleteStDspthGrd", stDspthGrd);
	}
	/**
	 * 물리서버 통보등급 삭제
	 * @param stDspthGrd
	 */
	public int deleteStDspthGrdPm(PmThrdConfSearchVo pmThrdConfSearchVo) {
		return sqlSession.update("ncis.sql.cmn.stDspthGrd.deleteStDspthGrdPm", pmThrdConfSearchVo);
	}
	/**
	 * 물리서버 통보등급 삭제
	 * @param stDspthGrd
	 */
	public int deleteStDspthGrdVm(PmThrdConfSearchVo pmThrdConfSearchVo) {
		return sqlSession.update("ncis.sql.cmn.stDspthGrd.deleteStDspthGrdVm", pmThrdConfSearchVo);
	}

	/**
	 * 자동확장 통보등급 삭제
	 * @param stDspthGrd
	 */
	public int deleteStDspthGrdAx(PmThrdConfSearchVo pmThrdConfSearchVo) {
		return sqlSession.update("ncis.sql.cmn.stDspthGrd.deleteStDspthGrdAx", pmThrdConfSearchVo);
	}
}
