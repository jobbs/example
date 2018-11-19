/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmInstitutionDao.java
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

import ncis.cmn.entity.CmInstitution;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 기관 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cCmInstitutionDao")
public class CCmInstitutionDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 기관 등록
	 * @param cmInstitution
	 */
	public void insertCmInstitution(CmInstitution cmInstitution) {
		sqlSession.insert("ncis.sql.cmn.cmInstitution.insertCmInstitution", cmInstitution);
	}

	/**
	 * 기관 수정
	 * @param cmInstitution
	 */
	public void updateCmInstitution(CmInstitution cmInstitution) {
		sqlSession.update("ncis.sql.cmn.cmInstitution.updateCmInstitution", cmInstitution);
	}

	/**
	 * 기관 삭제
	 * @param cmInstitution
	 */
	public void deleteCmInstitution(CmInstitution cmInstitution) {
		sqlSession.update("ncis.sql.cmn.cmInstitution.deleteCmInstitution", cmInstitution);
	}

	/**
	 * 기관 사용여부 수정
	 * @param cmInstitution
	 */
	public void updateCmInstitutionUseYn(CmInstitution cmInstitution) {
		sqlSession.update("ncis.sql.cmn.cmInstitution.updateCmInstitutionUseYn", cmInstitution);
	}

	/**
	 * @param insttVo
	 */
	public void updateSubJob(CmInstitution cmInstitution) {
		sqlSession.update("ncis.sql.cmn.cmInstitution.updateSubJob", cmInstitution);

	}

}
