/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmGatewayDao.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cmn.dao;

import ncis.cmn.entity.CmGateway;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * API게이트웨이정보 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cCmGatewayDao")
public class CCmGatewayDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * API게이트웨이정보 등록
	 * @param cmGateway
	 */
	public void insertCmGateway(CmGateway cmGateway) {
		sqlSession.insert("ncis.sql.cmn.cmGateway.insertCmGateway", cmGateway);
	}

	/**
	 * API게이트웨이정보 수정
	 * @param cmGateway
	 */
	public void updateCmGateway(CmGateway cmGateway) {
		sqlSession.update("ncis.sql.cmn.cmGateway.updateCmGateway", cmGateway);
	}

	/**
	 * API게이트웨이정보 삭제
	 * @param cmGateway
	 */
	public void deleteCmGateway(Long gatewaySeq) {
		sqlSession.update("ncis.sql.cmn.cmGateway.deleteCmGateway", gatewaySeq);
	}

	/**
	 * 게이트웨이 정보 조회
	 * @param regionId
	 * @return
	 */
	public CmGateway selectCmGatewayByRegion(String regionId)
	{
		return sqlSession.selectOne("ncis.sql.cmn.cmGateway.selectCmGatewayByRegion", regionId);
	}
}
