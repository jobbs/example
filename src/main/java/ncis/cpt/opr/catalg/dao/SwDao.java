/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SwDao.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2017. 1. 11.
 * @lastmodified 2017. 1. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 1. 11.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ncis.cpt.opr.catalg.vo.SwSearchVo;
import ncis.cpt.opr.catalg.vo.SwVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 이화영
 *
 */
@Repository("swDao")
public class SwDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * 소프트웨어 조회건수
	 * @param svo
	 * @return
	 */
	public int selectSwMngListTotCnt(SwSearchVo svo){

		return sqlSession.selectOne("ncis.sql.cpt.opr.sw.selectSwMngListTotCnt",svo);
	}

	/**
	 * 소프트웨어 목록조회
	 * @param svo
	 * @return
	 */
	public List<SwVo> selectSwMngList(SwSearchVo svo){

		return sqlSession.selectList("ncis.sql.cpt.opr.sw.selectSwMngList", svo);
	}


	/**
	 * 소프트웨어 Excel 목록 조회
	 * @param svo
	 * @return
	 */
	public List<SwVo> selectSwExcelList(SwSearchVo svo){
		return sqlSession.selectList("ncis.sql.cpt.opr.sw.selectSwExcelList",svo);
	}

	/**
	 * 소프트웨어 상세조회
	 * @param specSeq
	 * @return
	 */
	public SwVo selectSw(BigDecimal swSeq){
		return sqlSession.selectOne("ncis.sql.cpt.opr.sw.selectSw",swSeq);
	}

	/**
	 *sw정보 중복 체크
	 * @param swVo
	 * @return
	 */
	public int selectSwInfoCheck(String swNm, String swVer, BigDecimal swSeq) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("swNm", swNm);
		params.put("swVer", swVer);
		params.put("swSeq", swSeq);

		return sqlSession.selectOne("ncis.sql.cpt.opr.sw.selectSwInfoCheck",params);
	}

	/**
	  *sw사용여부 체크
	 * @param swSeq
	 * @return
	 */
	public int selectSwUseYn(BigDecimal swSeq) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.sw.selectSwUseYn",swSeq);
	}



}
