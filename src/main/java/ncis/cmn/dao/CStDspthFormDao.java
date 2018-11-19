package ncis.cmn.dao;

import ncis.cmn.entity.StDspthForm;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfDspthVo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfSearchVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 통보형식 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cStDspthFormDao")
public class CStDspthFormDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 통보형식 등록
	 * @param stDspthForm
	 */
	public void insertStDspthForm(StDspthForm stDspthForm) {
		sqlSession.insert("ncis.sql.cmn.stDspthForm.insertStDspthForm", stDspthForm);
	}
	/**
	 * 물리서버 통보형식 등록
	 * @param stDspthForm
	 */
	public int insertStDspthFormPm(PmThrdConfDspthVo vo) {
		return sqlSession.insert("ncis.sql.cmn.stDspthForm.insertStDspthFormPm", vo);
	}
	/**
	 * 물리서버 통보형식 등록
	 * @param stDspthForm
	 */
	public int insertStDspthFormVm(PmThrdConfDspthVo vo) {
		return sqlSession.insert("ncis.sql.cmn.stDspthForm.insertStDspthFormVm", vo);
	}

	/**
	 * 자동확장 통보형식 등록
	 * @param stDspthForm
	 */
	public int insertStDspthFormAx(PmThrdConfDspthVo vo) {
		return sqlSession.insert("ncis.sql.cmn.stDspthForm.insertStDspthFormAx", vo);
	}

	/**
	 * 통보형식 수정
	 * @param stDspthForm
	 */
	public void updateStDspthForm(StDspthForm stDspthForm) {
		sqlSession.update("ncis.sql.cmn.stDspthForm.updateStDspthForm", stDspthForm);
	}

	/**
	 * 통보형식 삭제
	 * @param stDspthForm
	 */
	public void deleteStDspthForm(StDspthForm stDspthForm) {
		sqlSession.update("ncis.sql.cmn.stDspthForm.deleteStDspthForm", stDspthForm);
	}
	/**
	 * 물리서버 통보형식 삭제
	 * @param stDspthForm
	 */
	public int deleteStDspthFormPm(PmThrdConfSearchVo pmThrdConfSearchVo) {
		return sqlSession.update("ncis.sql.cmn.stDspthForm.deleteStDspthFormPm", pmThrdConfSearchVo);
	}
	/**
	 * 가상서버 통보형식 삭제
	 * @param stDspthForm
	 */
	public int deleteStDspthFormVm(PmThrdConfSearchVo pmThrdConfSearchVo) {
		return sqlSession.update("ncis.sql.cmn.stDspthForm.deleteStDspthFormVm", pmThrdConfSearchVo);
	}
	/**
	 * 자동확장 통보형식 삭제
	 * @param stDspthForm
	 */
	public int deleteStDspthFormAx(PmThrdConfSearchVo pmThrdConfSearchVo) {
		return sqlSession.update("ncis.sql.cmn.stDspthForm.deleteStDspthFormAx", pmThrdConfSearchVo);
	}

}
