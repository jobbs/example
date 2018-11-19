/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * RsrcAsgnStteClstrDao.java
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

package ncis.dsb.stts.asgn.dao;

import java.util.List;

import ncis.dsb.stts.asgn.vo.RsrcAsgnStteClstrSearchVo;
import ncis.dsb.stts.asgn.vo.RsrcAsgnStteClstrVo;
import ncis.dsb.stts.asgn.vo.RsrcAsgnStteClstrAxVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("rsrcAsgnStteClstrDao")
public class RsrcAsgnStteClstrDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 자원 보유 및 할당 현황-클러스터별 조회
	 * */
	public List<RsrcAsgnStteClstrVo> selectRsrcAsgnStteClstrList(RsrcAsgnStteClstrSearchVo searchVo){

		return sqlSession.selectList("ncis.sql.dsb.stts.rsrcAsgnStteClstr.selectRsrcAsgnStteClstrList",searchVo);
	}

	/**
	 * 자동확장 자원 보유 및 할당 현황-클러스터별 조회
	 * */
	public List<RsrcAsgnStteClstrAxVo> selectRsrcAsgnStteClstrAxList(RsrcAsgnStteClstrSearchVo searchVo){

		return sqlSession.selectList("ncis.sql.dsb.stts.rsrcAsgnStteClstr.selectRsrcAsgnStteClstrAxList",searchVo);
	}


}
