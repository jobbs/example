/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * RsrcUseStteDao.java
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

import ncis.dsb.stts.rsrcuse.vo.RsrcUseStteSearchVo;
import ncis.dsb.stts.rsrcuse.vo.RsrcUseStteVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("rsrcUseStteDao")
public class RsrcUseStteDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 자원 사용 현황-기간별 조회
	 * */
	public List<RsrcUseStteVo> selecRsrcUseStteList(RsrcUseStteSearchVo searchVo){

		return sqlSession.selectList("ncis.sql.dsb.stts.rsrcUseStte.selectRsrcUseStteList",searchVo);
	}





}
