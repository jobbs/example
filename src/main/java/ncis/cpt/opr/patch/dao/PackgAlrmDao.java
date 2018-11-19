/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PackgAlrmDao.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.dao;

import java.util.List;

import ncis.cpt.opr.patch.vo.PackgAlrmInfoVo;
import ncis.cpt.opr.patch.vo.PackgAlrmSearchVo;
import ncis.cpt.opr.patch.vo.PackgAlrmVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 이화영
 *
 */
@Repository("packgAlrmDao")
public class PackgAlrmDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색 조건에 해당하는 패치알림 목록 카운트
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	public int selectPackgAlrmListTotCnt(PackgAlrmSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.patch.packgAlrm.selectPackgAlrmListTotCnt", searchVo);
	}

	/**
	 * 검색 조건에 해당하는 패치알림 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	public List<PackgAlrmVo> selectPackgAlrmList(PackgAlrmSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.patch.packgAlrm.selectPackgAlrmList", searchVo);
	}

	/**
	 * 패치알림  Excel 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	public List<PackgAlrmVo> selectPackgAlrmExcelList(PackgAlrmSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.patch.packgAlrm.selectPackgAlrmExcelList", searchVo);
	}

	/**
     * 패치알림 상세 정보 조회
     * @param vmSeq
     * @return
     */
    public PackgAlrmInfoVo selectPackgAlrm(PackgAlrmVo packgAlrmVo) {
        return sqlSession.selectOne("ncis.sql.cpt.opr.patch.packgAlrm.selectPackgAlrm", packgAlrmVo);
    }

}
