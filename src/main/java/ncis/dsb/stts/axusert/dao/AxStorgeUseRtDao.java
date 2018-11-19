/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxStorgeUseRtDao.java
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
 * 2017. 08. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.axusert.dao;

import java.util.List;
import ncis.dsb.stts.axusert.vo.AxUseRtSearchVo;
import ncis.dsb.stts.axusert.vo.AxUseRtVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("axStorgeUseRtDao")
public class AxStorgeUseRtDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 자동확장 스토리지 사용률 분포 조회
	 * @param searchVo
	 * @return
	 */
	public List<AxUseRtVo> selectSanUseRtList(AxUseRtSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.axusert.axStorgeUseRt.selectAxStorgeUseRtList", searchVo);
	}

	/**
	 * 자동확장 스토리지 최빈시 사용률 분포 조회
	 * @param searchVo
	 * @return
	 */
	public List<AxUseRtVo> selectTopSanUseRtList(AxUseRtSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.axusert.axStorgeUseRt.selectAxTopStorgeUseRtList", searchVo);
	}
}
