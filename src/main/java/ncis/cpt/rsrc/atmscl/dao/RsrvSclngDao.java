package ncis.cpt.rsrc.atmscl.dao;



import java.util.List;

import ncis.cpt.rsrc.atmscl.vo.RsrvSclngSearchVo;
import ncis.cpt.rsrc.atmscl.vo.RsrvSclngVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("rsrvSclngDao")
public class RsrvSclngDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색조건에 해당하는 전체 스케일 예약설정 목록 수 조회
	 * @param rsrvSclngSearchVo
	 * @return
	 */
	public int selectRsrvSclngTotCnt(RsrvSclngSearchVo rsrvSclngSearchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.rsrvSclngService.selectRsrvSclngTotCnt",rsrvSclngSearchVo);
	}

	/**
	 * 검색조건에 해당하는 스케일 예약설정  목록 조회
	 * @param rsrvSclngSearchVo
	 * @return
	 */
	public List<RsrvSclngVo> selectRsrvSclngList(RsrvSclngSearchVo rsrvSclngSearchVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.rsrvSclngService.selectRsrvSclngList",rsrvSclngSearchVo);
	}

	/**
	 * 스케일예약설정 상세조회
	 * @param rsrvSclngVo
	 * @return
	 */
	public RsrvSclngVo selectAtmSclRsrvSclng(RsrvSclngVo rsrvSclngVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.rsrvSclngService.selectAtmSclRsrvSclng", rsrvSclngVo);
	}

	/**
	 * @param rsrvSclngVo
	 * @return
	 */
	public RsrvSclngVo selectRsrvSclngCheck(RsrvSclngVo rsrvSclngVo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.rsrvSclngService.selectRsrvSclngCheck",rsrvSclngVo);
	}



}
