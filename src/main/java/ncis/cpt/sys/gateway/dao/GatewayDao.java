/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename GatewayDao.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 9. 23.
 * @lastmodified 2016. 9. 23.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 23.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.gateway.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ncis.cpt.sys.gateway.vo.GatewaySearchVo;
import ncis.cpt.sys.gateway.vo.GatewayVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 박봉춘
 *
 */
@Repository("GatewayDao")
public class GatewayDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색조건에 해당하는 전체 접속정보 수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectGatewayTotCnt(GatewaySearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.gateway.selectGatewayTotCnt", searchVo);
	}

	/**
	 * 검색조건에 해당하는 접속정보 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<GatewayVo> selectGatewayList(GatewaySearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.gateway.selectGatewayList", searchVo);
	}

	/**
	 * 해당 접속정보의 정보 조회
	 * @param gatewaySeq
	 * @return
	 */
	public GatewayVo selectGateway(Long gatewaySeq) {
		return sqlSession.selectOne("ncis.sql.cpt.gateway.selectGateway", gatewaySeq);
	}

	/**
	 * 해당 region_id가 포함 되어 있는 수 조회
	 * @param vo
	 * @return
	 */
	public int selectRegionCnt(String regionId, Long gatewaySeq){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("regionId", regionId);
		param.put("gatewaySeq", gatewaySeq);

		return sqlSession.selectOne("ncis.sql.cpt.gateway.selectRegionCnt", param);
	}
}
