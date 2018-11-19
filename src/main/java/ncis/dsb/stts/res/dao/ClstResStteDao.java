/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ClstResStteDao.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 17
 * @lastmodified2016. 10. 17
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 17   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.res.dao;

import java.util.List;

import ncis.dsb.stts.res.vo.AxCntVo;
import ncis.dsb.stts.res.vo.ClstResInfoVo;
import ncis.dsb.stts.res.vo.ClstResStteSearchVo;
import ncis.dsb.stts.res.vo.HiperVisorCntVo;
import ncis.dsb.stts.res.vo.PmCntVo;
import ncis.dsb.stts.res.vo.PmResInfoVo;
import ncis.dsb.stts.res.vo.ResAsgnCntVo;
import ncis.dsb.stts.res.vo.VirtRtVo;
import ncis.dsb.stts.res.vo.VmCntVo;
import ncis.dsb.stts.res.vo.VmInfoVo;
import ncis.dsb.stts.res.vo.VmResInfoVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("clstResStteDao")
public class ClstResStteDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 자원풀 수량 조회
	 * @param searchVo
	 * @return
	 */
	public int selectClCnt(ClstResStteSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.stts.res.clstResStte.selectClCnt", SearchVo);


	}
	/**
	 * 물리서버 수량 조회
	 * @param searchVo
	 * @return
	 */
	public PmCntVo selectPmCnt(ClstResStteSearchVo SearchVo){

		return sqlSession.selectOne("ncis.sql.dsb.stts.res.clstResStte.selectPmCnt",SearchVo);
	}

	/**
	 * 물리서버 자원 조회
	 * @param searchVo
	 * @return
	 */
	public PmResInfoVo selectPmResInfo(ClstResStteSearchVo SearchVo){

		return sqlSession.selectOne("ncis.sql.dsb.stts.res.clstResStte.selectPmResInfo",SearchVo);
	}

	/**
	 * 하이퍼바이저 수량 조회
	 * @param searchVo
	 * @return
	 */
	public HiperVisorCntVo selectHiperVisorCnt(ClstResStteSearchVo SearchVo){

		return sqlSession.selectOne("ncis.sql.dsb.stts.res.clstResStte.selectHiperVisorCnt",SearchVo);
	}

	/**
	 * 가상서버 수량 조회
	 * @param searchVo
	 * @return
	 */
	public VmCntVo selectVmCnt(ClstResStteSearchVo SearchVo){

		return sqlSession.selectOne("ncis.sql.dsb.stts.res.clstResStte.selectVmCnt",SearchVo);
	}
	
	/**
	 * 가상서버 수량 조회
	 * @param searchVo
	 * @return
	 */
	public VmResInfoVo selectVmResInfo(ClstResStteSearchVo SearchVo){

		return sqlSession.selectOne("ncis.sql.dsb.stts.res.clstResStte.selectVmResInfo",SearchVo);
	}

	/**
	 * 자원할당 수량 조회
	 * @param searchVo
	 * @return
	 */
	public ResAsgnCntVo selectResAsgn(ClstResStteSearchVo SearchVo){

		return sqlSession.selectOne("ncis.sql.dsb.stts.res.clstResStte.selectResAsgn",SearchVo);
	}

	/**
	 * 가상화율 조회
	 * @param searchVo
	 * @return
	 */
	public VirtRtVo selectVirtRt(ClstResStteSearchVo SearchVo){

		return sqlSession.selectOne("ncis.sql.dsb.stts.res.clstResStte.selectVirtRt",SearchVo);
	}

	/**
	 * 자동확장 갯수 조회
	 * @param searchVo
	 * @return
	 */
	public AxCntVo selectAxCnt(ClstResStteSearchVo SearchVo){

		return sqlSession.selectOne("ncis.sql.dsb.stts.res.clstResStte.selectAxCnt",SearchVo);
	}

	/**
	 * 자원풀 자원현황 조회
	 * @param searchVo
	 * @return
	 */
	public List<VmInfoVo> selectVmList(ClstResStteSearchVo SearchVo){

		return sqlSession.selectList("ncis.sql.dsb.stts.res.clstResStte.selectVmList",SearchVo);
	}
	
	/**
	 * 자원풀 자원현황 조회
	 * @param searchVo
	 * @return
	 */
	public List<ClstResInfoVo> selectClstResList(ClstResStteSearchVo SearchVo){

		return sqlSession.selectList("ncis.sql.dsb.stts.res.clstResStte.selectClstResList",SearchVo);
	}

}
