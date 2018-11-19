/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmCodeDao.java
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

import java.util.HashMap;
import java.util.Map;
import ncis.cmn.entity.CmCode;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 공통코드 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cCmCodeDao")
public class CCmCodeDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 공통코드 등록
	 * @param cmCode
	 */
	public void insertCmCode(CmCode cmCode) {
		sqlSession.insert("ncis.sql.cmn.cmcode.insertCmCode", cmCode);
	}

	/**
	 * 공통코드 수정
	 * @param cmCode
	 */
	public void updateCmCode(CmCode cmCode) {
		sqlSession.update("ncis.sql.cmn.cmcode.updateCmCode", cmCode);
	}

	/**
	 * 공통코드 삭제
	 * @param cmCode
	 */
	public void deleteCmCode(CmCode cmCode) {
		sqlSession.update("ncis.sql.cmn.cmcode.deleteCmCode", cmCode);
	}

    /**
     * @param cd
     * @param grpCd
     */
    public void updateCodeDownOrderByUp(String cd, String grpCd) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("cd", cd);
        param.put("grpCd", grpCd);
        sqlSession.update("ncis.sql.cmn.cmcode.updateCodeDownOrderByUp", param);
    }

    /**
     * @param cd
     * @param grpCd
     */
    public void updateCodeUpOrder(String cd, String grpCd) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("cd", cd);
        param.put("grpCd", grpCd);
        sqlSession.update("ncis.sql.cmn.cmcode.updateCodeUpOrder", param);
    }

    /**
     * @param cd
     * @param grpCd
     */
    public void updateCodeUpOrderByDown(String cd, String grpCd) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("cd", cd);
        param.put("grpCd", grpCd);
        sqlSession.update("ncis.sql.cmn.cmcode.updateCodeUpOrderByDown", param);
    }

    /**
     * @param cd
     * @param grpCd
     */
    public void updateCodeDownOrder(String cd, String grpCd) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("cd", cd);
        param.put("grpCd", grpCd);
        sqlSession.update("ncis.sql.cmn.cmcode.updateCodeDownOrder", param);
    }

}
