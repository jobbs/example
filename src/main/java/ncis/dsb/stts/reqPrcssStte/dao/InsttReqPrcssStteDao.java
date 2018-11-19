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

package ncis.dsb.stts.reqPrcssStte.dao;

import java.util.List;

import ncis.dsb.stts.reqPrcssStte.vo.InsttReqPrcssStteSearchVo;
import ncis.dsb.stts.reqPrcssStte.vo.ReqPrcssStteVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("insttReqPrcssStteDao")
public class InsttReqPrcssStteDao {

	@Autowired SqlSessionTemplate sqlSession;
	/**
	 * 클라우드 요청 처리현황 목록 조회
	 */
	public List<ReqPrcssStteVo> selectInsttReqPrcssStteList(InsttReqPrcssStteSearchVo searchVo) throws Exception{

		return sqlSession.selectList("ncis.sql.dsb.stts.reqPrcssStte.selectInsttReqPrcssStteList",searchVo);
	}

}
