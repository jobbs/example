package ncis.cpt.rsrc.atmscl.dao;



import java.util.List;

import ncis.cpt.rsrc.atmscl.vo.PreDistrbSearchVo;
import ncis.cpt.rsrc.atmscl.vo.PreDistrbVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("preDistrbDao")
public class PreDistrbDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색조건에 해당하는 전체 사전배포 목록 수 조회
	 * @param preDistrbSearchVo
	 * @return
	 */
	public int selectPreDistrbTotCnt(PreDistrbSearchVo preDistrbSearchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.preDistrbService.selectPreDistrbTotCnt",preDistrbSearchVo);
	}

	/**
	 * 검색조건에 해당하는 사전배포 목록 조회
	 * @param preDistrbSearchVo
	 * @return
	 */
	public List<PreDistrbVo> selectPreDistrbList(PreDistrbSearchVo preDistrbSearchVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.preDistrbService.selectPreDistrbList",preDistrbSearchVo);
	}

	/**
	 * 이미지 목록 수 조회
	 * @param preDistrbSearchVo
	 * @return
	 */
	public int selectPreDistrbTotCntP(PreDistrbSearchVo preDistrbSearchVo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.preDistrbService.selectPreDistrbTotCntP",preDistrbSearchVo);
	}

	/**
	 * @param preDistrbSearchVo
	 * @return
	 */
	public List<PreDistrbVo> selectPreDistrbListP(PreDistrbSearchVo preDistrbSearchVo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.preDistrbService.selectPreDistrbListP",preDistrbSearchVo);
	}
	/**
	 * 사전배포 상세조회
	 * @param preDistrbVo
	 * @return PreDistrbVo
	 */
	public PreDistrbVo updatePreDistrb(PreDistrbVo preDistrbVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.preDistrbService.updatePreDistrb",preDistrbVo);
	}

}
