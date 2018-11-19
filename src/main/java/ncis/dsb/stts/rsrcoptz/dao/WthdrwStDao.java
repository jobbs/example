/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WthdrwStDao.java
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

import ncis.dsb.stts.rsrcoptz.vo.WthdrwStSearchVo;
import ncis.dsb.stts.rsrcoptz.vo.WthdrwStVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("wthdrwStDao")
public class WthdrwStDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 자원 회수 현황 조회
	 * @param searchVo
	 * @return
	 */
	public List<WthdrwStVo> selectWthdrwStList(WthdrwStSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.rsrcoptz.wthdrwSt.selectWthdrwStList", searchVo);
	}

	/**
	 * 자원 회수 현황 상세 조회
	 * @param searchVo
	 * @return
	 */
	public List<WthdrwStVo> selectWthdrwRsrcList(WthdrwStSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.rsrcoptz.wthdrwSt.selectWthdrwRsrcList", searchVo);
	}


	/**
	 *  자원 회수 현황 상세보기
	 * @param searchVo
	 * @return
	 */
	public List<WthdrwStVo> selectWthdrwStView(WthdrwStSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.rsrcoptz.wthdrwSt.selectWthdrwStView", searchVo);
	}
	/**
	 * 자원 회수 현황 입력 또는 수정
	 * @return
	 */
	public void insertWthdrwSt(WthdrwStVo insertVo){
		sqlSession.selectList("ncis.sql.dsb.stts.rsrcoptz.wthdrwSt.insertWthdrwSt", insertVo);
	}

	/**
	 * 자원 회수 현황 등록 삭제
	 */
	public void deleteWthdrwSt(WthdrwStVo vo) throws Exception{
		sqlSession.insert("ncis.sql.dsb.stts.rsrcoptz.wthdrwSt.deleteWthdrwSt",vo);
	}

}
