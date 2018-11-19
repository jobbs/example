/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxServcUsefulRngDao.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 08. 10
 * @lastmodified2017. 08. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 10. 10   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.axusert.dao;

import java.util.List;

import ncis.dsb.stts.axusert.vo.AxServcUsefulRngSearchVo;
import ncis.dsb.stts.axusert.vo.AxServcUsefulMemVo;
import ncis.dsb.stts.axusert.vo.AxServcUsefulSanVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("axServcUsefulRngDao")
public class AxServcUsefulRngDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 자동확장 MEM 용량별 건수조회
	 * @param searchVo
	 * @return
	 */
	public List<AxServcUsefulMemVo> selectMemCntList(AxServcUsefulRngSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.axusert.axServcUsefulRng.selectMemCntList", searchVo);
	}

	/**
	 * 자동확장 SAN 용량별 건수조회
	 * @param searchVo
	 * @return
	 */
	public List<AxServcUsefulSanVo> selectSanCntList(AxServcUsefulRngSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.axusert.axServcUsefulRng.selectSanCntList", searchVo);
	}

	/**
	 * 자동확장 MEM 비율별 건수조회
	 * @param searchVo
	 * @return
	 */
	public List<AxServcUsefulMemVo> selectMemCntRtList(AxServcUsefulRngSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.axusert.axServcUsefulRng.selectMemCntRtList", searchVo);
	}

	/**
	 * 자동확장 SAN 비율별 건수조회
	 * @param searchVo
	 * @return
	 */
	public List<AxServcUsefulSanVo> selectSanCntRtList(AxServcUsefulRngSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.axusert.axServcUsefulRng.selectSanCntRtList", searchVo);
	}
}

