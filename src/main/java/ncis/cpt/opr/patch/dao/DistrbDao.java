/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DistrbDao.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 21.
 * @lastmodified 2016. 10. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 21.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.dao;

import java.util.List;

import ncis.cpt.opr.patch.vo.DistrbSearchVo;
import ncis.cpt.opr.patch.vo.DistrbVo;
import ncis.cpt.opr.patch.vo.VmPatchVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 이화영
 *
 */
@Repository("distrbDao")
public class DistrbDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 배포 목록 조회 카운트
	 * @return
	 */
	public int selectDistrbListTotCnt(DistrbSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.patch.distrb.selectDistrbListTotCnt", searchVo);
	}

	/**
	 * 배포 목록 조회
	 * @return
	 */
	public List<DistrbVo> selectDistrbList(DistrbSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.patch.distrb.selectDistrbList", searchVo);
	}

	/**
	 * 배포 목록 엑셀다운로드
	 * @return
	 */
	public List<DistrbVo> selectDistrbExcelList(DistrbSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.patch.distrb.selectDistrbExcelList", searchVo);
	}

	/**
	 * 배포 목록 조회 카운트
	 * @return
	 */
	public String selectRsrcPoolId(VmPatchVo vmPatchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.patch.distrb.selectRsrcPoolId", vmPatchVo);
	}



}
