/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WthdrwStPerInstDao.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 10
 * @lastmodified2016. 12. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 10   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.rsrcoptz.dao;

import java.util.List;

import ncis.dsb.stts.rsrcoptz.vo.WthdrwStPerInstSearchVo;
import ncis.dsb.stts.rsrcoptz.vo.WthdrwStPerInstVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("wthdrwStPerInstDao")
public class WthdrwStPerInstDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 *  기관별 자원 회수 현황 건수
	 * @param searchVo
	 * @return
	 */
	public int selectWthdrwStPerInstTotCnt(WthdrwStPerInstSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.dsb.stts.rsrcoptz.wthdrwStPerInst.selectWthdrwStPerInstTotCnt", searchVo);
	}

	/**
	 * 기관별 자원 회수 현황 조회
	 * @param searchVo
	 * @return
	 */
	public List<WthdrwStPerInstVo> selectWthdrwStPerInstList(WthdrwStPerInstSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.rsrcoptz.wthdrwStPerInst.selectWthdrwStPerInstList", searchVo);
	}

	/**
	 * 기관별 자원 회수 현황 상세보기
	 * @param searchVo
	 * @return
	 */
	public List<WthdrwStPerInstVo> selectWthdrwStPerInstView(WthdrwStPerInstSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.rsrcoptz.wthdrwStPerInst.selectWthdrwStPerInstView", searchVo);
	}
	/**
	 * 기관별 자원 회수 현황 등록 수정
	 */
	public void insertWthdrwStPerInst(WthdrwStPerInstVo vo) throws Exception{
		sqlSession.selectList("ncis.sql.dsb.stts.rsrcoptz.wthdrwStPerInst.insertWthdrwStPerInst",vo);
	}

	/**
	 * 기관별 자원 회수 현황 등록 삭제
	 */
	public void deleteWthdrwStPerInst(WthdrwStPerInstVo vo) throws Exception{
		sqlSession.insert("ncis.sql.dsb.stts.rsrcoptz.wthdrwStPerInst.deleteWthdrwStPerInst",vo);
	}


}
