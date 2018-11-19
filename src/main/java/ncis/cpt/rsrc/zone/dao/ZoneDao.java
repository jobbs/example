/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ZoneDao.java
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

import java.math.BigDecimal;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ncis.cpt.rsrc.zone.vo.ZoneSearchVo;
import ncis.cpt.rsrc.zone.vo.ZoneVo;

/**
 * @author 심원보
 *
 */
@Repository("zoneDao")
public class ZoneDao {

    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * 존 목록 조회(사용자)
     *
     * @param zoneSearchVo
     * @return
     */
    public List<ZoneVo> selectZoneList(ZoneSearchVo zoneSearchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.zone.selectZoneList", zoneSearchVo);
    }

	/**
	 * 존 목록 조회(전체)
	 * @return
	 */
	public List<ZoneVo> selectZoneAllList() {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.com.zone.selectZoneAllList");
	}

    /**
     * 존 상세 정보 조회
     *
     * @param zoneSeq
     * @return
     */
    public ZoneVo selectZone(BigDecimal zoneSeq) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.zone.selectZone", zoneSeq);

    }

    /**
     * @param regionId
     * @return
     */
    public List<ZoneVo> selectZoneListByRegion(ZoneSearchVo zoneSearchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.zone.selectZoneListByRegion", zoneSearchVo);
    }
}
