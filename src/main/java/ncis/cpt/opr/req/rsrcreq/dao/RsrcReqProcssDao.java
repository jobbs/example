/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자원요청 -프로세스 DAO</pre>
 *
 * @filename RsrcReqProcssDao.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.dao;

import java.util.List;

import ncis.cpt.opr.catalg.vo.UnitJobRelateVo;
import ncis.cpt.opr.catalg.vo.UnitJobSearchVo;
import ncis.cpt.opr.catalg.vo.UnitJobVo;
import ncis.cpt.opr.req.rsrcreq.vo.ProcssInstSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.ProcssInstVo;
import ncis.cpt.opr.req.rsrcreq.vo.UnitJobProcssSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.UnitJobProcssVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 김봉민
 */
@Repository("rsrcReqProcssDao")
public class RsrcReqProcssDao {


	@Autowired SqlSessionTemplate sqlSession;


	/**
	 * 프로세스 인스턴스 조회
	 * @param searchVo
	 * @return
	 */
	public ProcssInstVo selectProcssInst(ProcssInstSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.procssjoblist.selectProcssInst",searchVo);
	}

	/**
	 * 단위 업무 적합성 검사
	 * @param searchVo
	 * @return
	 */
	public UnitJobProcssVo selectUnitJobValidate(UnitJobProcssSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.procssjoblist.selectUnitJobValidate",searchVo);
	}

	/**
	 * 단위 업무 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<UnitJobVo> selectUnitJobList(UnitJobSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.procssjoblist.selectUnitJobList",searchVo);
	}

	/**
	 * 단위 프로세스 정보 조회
	 * @param searchVo
	 * @return
	 */
	public UnitJobProcssVo selectUnitProcssJobInfo(UnitJobProcssSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.procssjoblist.selectUnitProcssJobInfo",searchVo);
	}

	/**
	 * 단위 프로세스 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<UnitJobProcssVo> selectUnitProcssJobInfoList(UnitJobProcssSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.procssjoblist.selectUnitProcssJobInfo",searchVo);
	}

	/**
	 * 다음 순서의 단위 업무 관계  조회
	 * @param searchVo
	 * @return
	 */
	public List<UnitJobRelateVo> selectNextUnitJobRelateList(UnitJobSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.procssjoblist.selectNextUnitJobRelateList",searchVo);
	}



}
