/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * InsttRsrcUseStteDao.java
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

package ncis.dsb.stts.rsrcuse.dao;

import java.util.List;

import ncis.dsb.stts.rsrcuse.vo.InsttRsrcRxAsgnVo;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcRxMaxVo;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcUseStteSearchVo;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcUseStteAsgnVo;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcUseStteMaxVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("insttRsrcUseStteDao")
public class InsttRsrcUseStteDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 논리자원 할당량 목록 조회
	 * */
	public List<InsttRsrcUseStteAsgnVo> selecInsttRsrcUseStteAsgnList(InsttRsrcUseStteSearchVo searchVo){

		return sqlSession.selectList("ncis.sql.dsb.stts.insttRsrcUseStte.selecInsttRsrcUseStteAsgnList",searchVo);
	}

	/**
	 * 가상서버 최빈시 자원 사용률 목록 조회
	 * */
	public List<InsttRsrcUseStteMaxVo> selecInsttRsrcUseStteMaxList(InsttRsrcUseStteSearchVo searchVo){

		return sqlSession.selectList("ncis.sql.dsb.stts.insttRsrcUseStte.selecInsttRsrcUseStteMaxList",searchVo);
	}

	/**
	 * 자동확장 할당량 목록
	 * */
	public List<InsttRsrcRxAsgnVo> selectRxAsgnList(InsttRsrcUseStteSearchVo searchVo) {

		return sqlSession.selectList("ncis.sql.dsb.stts.insttRsrcUseStte.selectRxAsgnList",searchVo);
	}

	/**
	 * 자동확장 최빈시 자원 사용률 목록
	 * */
	public List<InsttRsrcRxMaxVo> selectRxMaxList(InsttRsrcUseStteSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.dsb.stts.insttRsrcUseStte.selectRxMaxList",searchVo);
	}




}
