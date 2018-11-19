package ncis.cpt.rsrc.atmscl.dao;



import java.util.List;

import ncis.cpt.rsrc.atmscl.vo.AtmsclDistrbSearchVo;
import ncis.cpt.rsrc.atmscl.vo.AtmsclDistrbVo;
import ncis.cpt.rsrc.atmscl.vo.DistrbEnvConfVo;
import ncis.cpt.rsrc.atmscl.vo.PvcVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("atmsclDistrbDao")
public class AtmsclDistrbDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색조건에 해당하는 전체 배포 목록 수 조회
	 * @param atmsclDistrbSearchVo
	 * @return
	 */
	public int selectAtmsclDistrbTotCnt(AtmsclDistrbSearchVo atmsclDistrbSearchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.atmsclDistrbService.selectAtmsclDistrbTotCnt",atmsclDistrbSearchVo);
	}

	/**
	 * 검색조건에 해당하는 배포 목록 조회
	 * @param atmsclDistrbSearchVo
	 * @return
	 */
	public List<AtmsclDistrbVo> selectAtmsclDistrbList(AtmsclDistrbSearchVo atmsclDistrbSearchVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.atmsclDistrbService.selectAtmsclDistrbList",atmsclDistrbSearchVo);
	}

	/**
	 * @param atmsclDistrbVo
	 * @return
	 */
	public List<AtmsclDistrbVo> selectDetailAtmsclDistrb(AtmsclDistrbVo atmsclDistrbVo) {

		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.atmsclDistrbService.selectDetailAtmsclDistrb",atmsclDistrbVo);
	}

	/**
	 * @param atmsclDistrbVo
	 * @return
	 */
	public List<AtmsclDistrbVo> selectDistrbPodInfo(AtmsclDistrbVo atmsclDistrbVo) {

		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.atmsclDistrbService.selectDistrbPodInfo",atmsclDistrbVo);
	}

	/**
	 * @param atmsclDistrbVo
	 * @return
	 */
	public List<AtmsclDistrbVo> selectRsrvSclInfo(AtmsclDistrbVo atmsclDistrbVo) {

		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.atmsclDistrbService.selectRsrvSclInfo",atmsclDistrbVo);
	}

	/**
	 * @param atmsclDistrbVo
	 */
	public List<AtmsclDistrbVo> selectAtmsclStrgP(AtmsclDistrbSearchVo atmsclDistrbSearchVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.atmsclDistrbService.selectAtmsclStrgP",atmsclDistrbSearchVo);
	}

	/**
	 * @param atmsclDistrbVo
	 * @return
	 */
	public Integer selectAutoSclingCheck(AtmsclDistrbVo atmsclDistrbVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.atmsclDistrbService.selectAutoSclingCheck",atmsclDistrbVo);
	}

	/**
	 * @param atmsclDistrbVo
	 */
	public List<DistrbEnvConfVo> selectDistrbEnvConfInfo(AtmsclDistrbVo atmsclDistrbVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.atmsclDistrbService.selectDistrbEnvConfInfo",atmsclDistrbVo);
	}

	/**
	 * @param atmsclDistrbVo
	 */
	public List<DistrbEnvConfVo> selectDistrbEnvConfExcept(AtmsclDistrbVo atmsclDistrbVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.atmsclDistrbService.selectDistrbEnvConfExcept",atmsclDistrbVo);
	}

	/**스케일 배포 목록 총건수 팝업
	 * @param atmsclDistrbSearchVo
	 * @return
	 */
	public int selectAtmsclDistrbTotCntP(AtmsclDistrbSearchVo atmsclDistrbSearchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.atmsclDistrbService.selectAtmsclDistrbTotCntP",atmsclDistrbSearchVo);
	}

	/**스케일 배포 목록 조회 팝업
	 * @param atmsclDistrbSearchVo
	 * @return
	 */
	public List<AtmsclDistrbVo> selectAtmsclDistrbListP(AtmsclDistrbSearchVo atmsclDistrbSearchVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.atmsclDistrbService.selectAtmsclDistrbListP",atmsclDistrbSearchVo);
	}

	/**
	 * @param atmsclDistrbVo
	 * @return
	 */
	public List<PvcVo> selectDistrbPvc(AtmsclDistrbVo atmsclDistrbVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.atmsclDistrbService.selectDistrbPvc",atmsclDistrbVo);
	}

	/**
	 * @param atmsclDistrbVo
	 * @return
	 */
	public AtmsclDistrbVo selectPodQuata(AtmsclDistrbVo atmsclDistrbVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.atmsclDistrbService.selectPodQuata",atmsclDistrbVo);
	}

	/**
	 * @param atmsclDistrbVo
	 * @return
	 */
	public int selectDitrbStatCnt(AtmsclDistrbVo atmsclDistrbVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.atmsclDistrbService.selectDitrbStatCnt",atmsclDistrbVo);
	}


}
