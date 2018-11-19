/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmSpecPerPoolDao.java
 *
 * @author 이권기
 * @lastmodifier 이권기
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   이권기         v1.0             최초생성
 *
 */
package ncis.dsb.stts.specusert.dao;

import java.util.List;

import ncis.dsb.stts.specusert.vo.VmSpecPerPoolSearchVo;
import ncis.dsb.stts.specusert.vo.VmSpecPerPoolVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("vmSpecPerPoolDao")
public class VmSpecPerPoolDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색 조건에 해당하는자원풀별 가상서버 사양 수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectVmSpecPerPoolTotCnt(VmSpecPerPoolSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.dsb.stts.specusert.vmSpecPerPool.selectVmSpecPerPoolTotCnt", searchVo);
	}

	/**
	 * 자원풀별 가상서버 사양 조회
	 * @param searchVo
	 * @return
	 */
	public List<VmSpecPerPoolVo> selectVmSpecPerPoolList(VmSpecPerPoolSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.specusert.vmSpecPerPool.selectVmSpecPerPoolList", searchVo);
	}

}
