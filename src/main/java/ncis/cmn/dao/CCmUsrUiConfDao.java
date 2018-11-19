/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmUsrUiConfDao.java
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

import ncis.cmn.entity.CmUsrUiConf;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 사용자롤정보 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cCmUsrUiConfDao")
public class CCmUsrUiConfDao {

	@Autowired
	SqlSessionTemplate sqlSession;

    /**
     * @param confVo
     */
    public void updateCmUsrUiConf(CmUsrUiConf confVo) {
        sqlSession.update("ncis.sql.cmn.cmUsrUiConf.updateCmUsrUiConf", confVo);
    }

}
