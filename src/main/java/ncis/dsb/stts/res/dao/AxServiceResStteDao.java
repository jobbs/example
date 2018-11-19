/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxNodeResStteDao.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 05. 17
 * @lastmodified2017. 05. 17
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 05. 17   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.res.dao;

import java.util.List;
import java.util.Map;

import ncis.dsb.stts.res.vo.AxServiceResSearchVo;
import ncis.dsb.stts.res.vo.AxServiceResStteVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("axServiceResStteDao")
public class AxServiceResStteDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 업무 자원현황 조회
	 * */
	public List<AxServiceResStteVo> selectAxServiceResStteList(AxServiceResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.AxServiceResStte.selectAxServiceResStteList", searchVo);
	}

	/**
	 * 사용율 조회
	 * */

	public List<Map<String,String>> selectAxServiceTimeResUseRtPivot(AxServiceResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.AxServiceResStte.selectAxServiceTimeResUseRtPivot", searchVo);
	}
	/**
	 * POD List
	 * */

	public List<Map<String,String>> selectAxServiceResSttePodList(AxServiceResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.AxServiceResStte.selectAxServiceResSttePodList", searchVo);
	}


}
