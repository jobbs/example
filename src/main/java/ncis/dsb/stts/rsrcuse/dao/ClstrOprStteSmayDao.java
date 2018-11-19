/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ClstrOprStteSmayDao.java
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

import ncis.dsb.stts.rsrcuse.vo.ClstrOprStteSmaySearchVo;
import ncis.dsb.stts.rsrcuse.vo.ClstrOprStteSmayVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("clstrOprStteSmayDao")
public class ClstrOprStteSmayDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 자원풀 운영 현황 개요
	 * */
	public List<ClstrOprStteSmayVo> selecClstrOprStteSmayList(ClstrOprStteSmaySearchVo searchVo){

		return sqlSession.selectList("ncis.sql.dsb.stts.clstrOprStteSmay.selecClstrOprStteSmayList",searchVo);
	}

	/**
	 * @param searchVo
	 * @return
	 */
	public List<ClstrOprStteSmayVo> selectClstrOprStteSmayRsAutoList(ClstrOprStteSmaySearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.dsb.stts.clstrOprStteSmay.selectClstrOprStteSmayRsAutoList",searchVo);
	}





}
