/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * RsrcAsgnStteTrmDao.java
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
 *
 */
package ncis.dsb.stts.asgn.dao;

import java.util.List;

import ncis.dsb.stts.asgn.vo.RsrcAsgnStteTrmSearchVo;
import ncis.dsb.stts.asgn.vo.RsrcAsgnStteTrmVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("rsrcAsgnStteTrmDao")
public class RsrcAsgnStteTrmDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 자원 보유 및 할당 현황-기간별 조회
	 * */
	public List<RsrcAsgnStteTrmVo> selectRsrcAsgnStteTrmList(RsrcAsgnStteTrmSearchVo searchVo){

		return sqlSession.selectList("ncis.sql.dsb.stts.rsrcAsgnStteTrm.selectRsrcAsgnStteTrmList",searchVo);
	}


}
