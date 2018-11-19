/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmPatchDao.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.dao;

import java.util.List;

import ncis.cpt.opr.patch.vo.VmPatchPackgVo;
import ncis.cpt.opr.patch.vo.VmPatchSearchVo;
import ncis.cpt.opr.patch.vo.VmPatchVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 이화영
 *
 */
@Repository("vmPatchDao")
public class VmPatchDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색 조건에 해당하는 가상서버 패키지 목록 카운트
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	public int selectVmPatchListTotCnt(VmPatchSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.patch.selectVmPatchListTotCnt", searchVo);
	}

	/**
	 * 검색 조건에 해당하는 가상서버 패키지 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	public List<VmPatchVo> selectVmPatchList(VmPatchSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.patch.selectVmPatchList", searchVo);
	}

	/**
     * 가상서버 패키지 상세 정보 조회
     *
     * @param vmSeq
     * @return
     */
    public VmPatchVo selectVmPatch(VmPatchVo vmPatchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.opr.patch.selectVmPatch", vmPatchVo);
    }

    /**
     * 가상서버 패키지 상세 정보 조회(설치 패키지 목록 카운트)
     *
     * @param vmSeq
     * @return
     */
    public int selectVmPatchPackgListTotCnt(VmPatchVo vmPatchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.opr.patch.selectVmPatchPackgListTotCnt", vmPatchVo);
    }

    /**
     * 가상서버 패키지 상세 정보 조회(설치 패키지 목록 카운트)
     *
     * @param vmSeq
     * @return
     */
    public List<VmPatchPackgVo> selectVmPatchPackgList(VmPatchVo vmPatchVo) {
        return sqlSession.selectList("ncis.sql.cpt.opr.patch.selectVmPatchPackgList", vmPatchVo);
    }

    /**
	 *가상서버 Excel 목록 조회
	 */
	public List<VmPatchVo> selectVmPatchExcelList(VmPatchSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.patch.selectVmPatchExcelList", searchVo);
	}


}
