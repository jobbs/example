/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ClstrPrposDao.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.dao;

import java.util.List;
import ncis.cpt.rsrc.com.vo.ClstrPrposSearchVo;
import ncis.cpt.rsrc.com.vo.ClstrPrposVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 심원보
 *
 */
@Repository("clstrPrposDao")
public class ClstrPrposDao {

    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * 클러스터용도 목록 조회
     *
     * @param clstrPrposSearchVo
     * @return
     */
    public List<ClstrPrposVo> selectClstrPrposList(ClstrPrposSearchVo clstrPrposSearchVo) {

        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.clstrPrpos.selectClstrPrposList", clstrPrposSearchVo);

    }

}
