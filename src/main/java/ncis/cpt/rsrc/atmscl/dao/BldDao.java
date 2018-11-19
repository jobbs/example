package ncis.cpt.rsrc.atmscl.dao;



import java.util.List;

import ncis.cpt.rsrc.atmscl.vo.BldSearchVo;
import ncis.cpt.rsrc.atmscl.vo.BldVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("bldDao")
public class BldDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색조건에 해당하는 전체 빌드 목록 수 조회
	 * @param bldSearchVo
	 * @return
	 */
	public int selectBldTotCnt(BldSearchVo bldSearchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.bldService.selectBldTotCnt",bldSearchVo);
	}

	/**
	 * 검색조건에 해당하는 빌드 목록 조회
	 * @param bldSearchVo
	 * @return
	 */
	public List<BldVo> selectBldList(BldSearchVo bldSearchVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.bldService.selectBldList",bldSearchVo);
	}

	/**
	 * 빌드 상세 조회
	 * @param bldVo
	 * @return
	 */
	public List<BldVo> selectDetailBld(BldVo bldVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.bldService.selectDetailBld",bldVo);
	}

	/**
	 * 보안키 ID 조회
	 * @param servcAreaSeq
	 * @return
	 */
	public List<BldVo> selectScrtky(Integer servcAreaSeq) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.bldService.selectScrtky",servcAreaSeq);
	}


}
