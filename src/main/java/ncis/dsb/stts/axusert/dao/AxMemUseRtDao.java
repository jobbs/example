/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxMemUseRtDao.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 10. 10
 * @lastmodified2017. 10. 10
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

import ncis.dsb.stts.axusert.vo.AxUseRtSearchVo;
import ncis.dsb.stts.axusert.vo.AxUseRtVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("axMemUseRtDao")
public class AxMemUseRtDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 서비스 MEM 사용률 분포 조회
	 * @param searchVo
	 * @return
	 */
	public List<AxUseRtVo> selectAxMemUseRtList(AxUseRtSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.axusert.axMemUseRt.selectAxMemUseRtList", searchVo);
	}

	/**
	 * 서비스 MEM 최빈시 사용률 분포 조회
	 * @param searchVo
	 * @return
	 */
	public List<AxUseRtVo> selectAxTopMemUseRtList(AxUseRtSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.axusert.axMemUseRt.selectAxTopMemUseRtList", searchVo);
	}
}
