/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RegionDao.java
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

import ncis.cpt.rsrc.zone.vo.RegionSearchVo;
import ncis.cpt.rsrc.zone.vo.RegionVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 심원보
 *
 */
@Repository("regionDao")
public class RegionDao {

    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * 리전 목록 조회(사용자)
     *
     * @param regionSearchVo
     * @return
     */
    public List<RegionVo> selectRegionList(RegionSearchVo regionSearchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.region.selectRegionList", regionSearchVo);
    }


	/**
	 * 리전 목록 조회(전체)
	 * @return
	 */
	public List<RegionVo> selectRegionAllList() {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.com.region.selectRegionAllList");
	}

    /**
     * 리전 상세 정보 조회
     *
     * @param regionId
     * @return
     */
    public RegionVo selectRegion(String regionId) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.region.selectRegion", regionId);

    }


}
