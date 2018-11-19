/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * EvntStteSearchVo.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 17
 * @lastmodified2016. 10. 17
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 17   김동훈         v1.0             최초생성
 *
 */
package ncis.dsb.stts.res.dao;

import java.util.List;
import java.util.Map;

import ncis.dsb.stts.res.vo.PmResSearchVo;
import ncis.dsb.stts.res.vo.PmResStteVo;
import ncis.dsb.stts.res.vo.PmTimeResUseRtVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("pmResStteDao")
public class PmResStteDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 물리서버 자원현황 조회
	 * */
	public List<PmResStteVo> selectPmResStteList(PmResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.rsrcAsgnStte.selectPmResStteList", searchVo);
	}
	/**
	 * 시간대별 CPU사용율 조회
	 * */
	public List<PmTimeResUseRtVo> selectPmTimeResUseRtCpu(PmResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.rsrcAsgnStte.selectPmTimeResUseRtCpu", searchVo);
	}
	/**
	 * 시간대별 CPU사용율 조회
	 * */
	public List<Map<String,String>> selectPmTimeResUseRtPivot(PmResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.rsrcAsgnStte.selectPmTimeResUseRtPivot", searchVo);
	}
	/**
	 * 시간대별 CPU사용율 조회
	 * */
	public List<Map<String,String>> selectClstrTimeResUseRtPivot(PmResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.rsrcAsgnStte.selectClstrTimeResUseRtPivot", searchVo);
	}
	/**
	 * 시간대별 MEM사용율 조회
	 * */
	public List<PmTimeResUseRtVo> selectPmTimeResUseRtMem(PmResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.rsrcAsgnStte.selectPmTimeResUseRtMem", searchVo);
	}
	/**
	 * 시간대별 SAN사용율 조회
	 * */
	public List<PmTimeResUseRtVo> selectPmTimeResUseRtSan(PmResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.rsrcAsgnStte.selectPmTimeResUseRtSan", searchVo);
	}

	public List<Map<String,String>> selectPmResStteVmList(PmResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.rsrcAsgnStte.selectPmResStteVmList", searchVo);
	}

	public List<Map<String,String>> selectClstrResStteVmList(PmResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.rsrcAsgnStte.selectClstrResStteVmList", searchVo);
	}
}
