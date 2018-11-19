/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ServStteDao.java
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
package ncis.dsb.stts.servstte.dao;

import java.util.List;

import ncis.dsb.stts.servstte.vo.CntServStteVo;
import ncis.dsb.stts.servstte.vo.PmStteVo;
import ncis.dsb.stts.servstte.vo.ServStteSearchVo;
import ncis.dsb.stts.servstte.vo.VmStteVo;
import ncis.dsb.stts.servstte.vo.VrlzStteVo;
import ncis.dsb.stts.servstte.vo.CloudJobVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("servStteDao")
public class ServStteDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 센터별 서비스 현황
	 * */
	public List<CntServStteVo> selectCntServStteList(ServStteSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.servstte.selectCntServStteList",searchVo);
	}
	/**
	 * 물리서버 현황
	 * */

	public List<PmStteVo> selectPmStteList(ServStteSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.servstte.selectPmStteList",searchVo);
	}
	/**
	 * 가상서버 현황
	 * */

	public List<VmStteVo> selectVmStteList(ServStteSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.servstte.selectVmStteList",searchVo);
	}

	/**
	 * 가상화 현황
	 * */

	public List<VrlzStteVo> selectVrlzStteList(ServStteSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.servstte.selectVrlzStteList",searchVo);
	}

	/**
	 * 쿨라우드 업무 진행 현황
	 * */

	public List<CloudJobVo> selectCloudJobList(ServStteSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.servstte.selectCloudJobList",searchVo);
	}



}
