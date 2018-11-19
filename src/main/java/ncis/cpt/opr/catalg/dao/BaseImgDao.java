package ncis.cpt.opr.catalg.dao;

import java.util.List;

import ncis.cpt.opr.catalg.vo.BaseImgSearchVo;
import ncis.cpt.opr.catalg.vo.BaseImgVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("baseImgDao")
public class BaseImgDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색조건에 해당하는 전체 베이스이미지 수 조회
	 * @param   searchVo
	 * @return
	 */
	public int selectBaseImgTotCnt(BaseImgSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.catalg.baseimg.selectBaseImgTotCnt",searchVo);
	}

	/**
	 * 검색조건에 해당하는 베이스이미지 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<BaseImgVo> selectBaseImgList(BaseImgSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.catalg.baseimg.selectBaseImgList",searchVo);
	}

	/**
	 * 베이스이미지 상세
	 * @param resReqId
	 * @return
	 */
	public BaseImgVo selectBaseImg(BaseImgVo baseImgVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.catalg.baseimg.selectBaseImg",baseImgVo);
	}

	/**
	 * 베이스이미지 상세
	 * @param baseImgVo
	 * @return
	 */
	public List<BaseImgVo> selectBaseImgPortList(BaseImgVo baseImgVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.catalg.baseimg.selectBaseImgPortList",baseImgVo);
	}

}
