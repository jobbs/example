/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PackgDao.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.dao;

import java.math.BigDecimal;
import java.util.List;

import ncis.cmn.entity.OaPackgReposit;
import ncis.cpt.opr.patch.vo.PackgInfoVo;
import ncis.cpt.opr.patch.vo.PackgSearchVo;
import ncis.cpt.opr.patch.vo.PackgVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 이화영
 *
 */
@Repository("packgDao")
public class PackgDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색 조건에 해당하는 패키지 목록 카운트
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	public int selectPackgListTotCnt(PackgSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.patch.packg.selectPackgListTotCnt", searchVo);
	}

	/**
	 * 검색 조건에 해당하는 가상서버 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	public List<PackgVo> selectPackgList(PackgSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.patch.packg.selectPackgList", searchVo);
	}

	/**
	 *패키지 Excel 목록 조회
	 */
	public List<PackgVo> selectPackgExcelList(PackgSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.patch.packg.selectPackgExcelList", searchVo);
	}

	/*public List<RcRegion> selectRegionList() {
		return sqlSession.selectList("ncis.sql.cpt.opr.patch.packg.selectRegionList");
	}

	public List<RcNet> selectPackgNetListByRegion(String regionId) {
        return sqlSession.selectList("ncis.sql.cpt.opr.patch.packg.selectPackgNetListByRegion", regionId);
    }*/

	public List<OaPackgReposit> selectPackgRepositListByNet(PackgSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.opr.patch.packg.selectPackgRepositListByNet", searchVo);
    }


	/**
     * 패키지 상세 정보 조회
     * @param vmSeq
     * @return
     */
    public PackgInfoVo selectPackg(PackgVo packgVo) {
        return sqlSession.selectOne("ncis.sql.cpt.opr.patch.packg.selectPackg", packgVo);
    }

    /**
	 * 패키지 상세 조회(패치대상 가상서버 목록) 카운트
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	public int selectPatchTrgtListTotCnt(PackgSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.patch.packg.selectPatchTrgtListTotCnt", searchVo);
	}

	/**
	 * 패키지 상세 조회(패치대상 가상서버 목록)
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	public List<PackgVo> selectPatchTrgtList(PackgSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.patch.packg.selectPatchTrgtList", searchVo);
	}

	/**
	 * 패키지 이전 버전 조회 화면 호출 카운트
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	public int selectPackgVerListTotCnt(PackgSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.patch.packg.selectPackgVerListTotCnt", searchVo);
	}

	/**
	 * 패키지 이전 버전 조회 화면 호출
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	public List<PackgVo> selectPackgVerList(PackgSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.patch.packg.selectPackgVerList", searchVo);
	}

	public List<PackgVo> selectVmInfoList(PackgVo packgVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.patch.packg.selectVmInfoList", packgVo);
	}

	public List<PackgVo> selectVmChargerList(String vmCompId) {
		return sqlSession.selectList("ncis.sql.cpt.opr.patch.packg.selectVmChargerList", vmCompId);
	}

	public List<PackgVo> selectJobChargerList(BigDecimal vmSeq) {
		return sqlSession.selectList("ncis.sql.cpt.opr.patch.packg.selectJobChargerList", vmSeq);
	}



}
