/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetDao.java
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
package ncis.cpt.rsrc.zone.dao;

import java.util.List;

import ncis.cpt.rsrc.zone.vo.NetSearchVo;
import ncis.cpt.rsrc.zone.vo.NetVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 심원보
 *
 */
@Repository("netDao")
public class NetDao {

    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * 망 목록 조회
     * @return
     */
    public List<NetVo> selectNetAllList() {
        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.net.selectNetAllList");
    }

    /**
     * 망 상세 정보 조회
     *
     * @param netSeq
     * @return
     */
    public NetVo selectNet(String netId) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.net.selectNet", netId);

    }

    public List<NetVo> selectNetListByZone(NetSearchVo netSearchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.net.selectNetListByZone", netSearchVo);
    }
}
