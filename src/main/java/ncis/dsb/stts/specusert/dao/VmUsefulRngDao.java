/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmUsefulRngDao.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.specusert.dao;

import java.util.List;

import ncis.dsb.stts.specusert.vo.VmUsefulMemVo;
import ncis.dsb.stts.specusert.vo.VmUsefulRngSearchVo;
import ncis.dsb.stts.specusert.vo.VmUsefulSanVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("vmUsefulRngDao")
public class VmUsefulRngDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 가상서버 MEM 용량별 건수조회
	 * @param searchVo
	 * @return
	 */
	public List<VmUsefulMemVo> selectMemCntList(VmUsefulRngSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.specusert.vmUsefulRng.selectMemCntList", searchVo);
	}

	/**
	 * 가상서버 SAN 용량별 건수조회
	 * @param searchVo
	 * @return
	 */
	public List<VmUsefulSanVo> selectSanCntList(VmUsefulRngSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.specusert.vmUsefulRng.selectSanCntList", searchVo);
	}

	/**
	 * 가상서버 MEM 비율별 건수조회
	 * @param searchVo
	 * @return
	 */
	public List<VmUsefulMemVo> selectMemCntRtList(VmUsefulRngSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.specusert.vmUsefulRng.selectMemCntRtList", searchVo);
	}

	/**
	 * 가상서버 SAN 비율별 건수조회
	 * @param searchVo
	 * @return
	 */
	public List<VmUsefulSanVo> selectSanCntRtList(VmUsefulRngSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.specusert.vmUsefulRng.selectSanCntRtList", searchVo);
	}
}

