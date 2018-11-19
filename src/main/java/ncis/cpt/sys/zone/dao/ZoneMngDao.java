/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ZoneMngDao.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.zone.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ncis.cmn.vo.TreeNode;
import ncis.cpt.sys.zone.vo.NetVo;
import ncis.cpt.sys.zone.vo.RegionVo;
import ncis.cpt.sys.zone.vo.RsrcPoolVo;
import ncis.cpt.sys.zone.vo.ZoneNetVo;
import ncis.cpt.sys.zone.vo.ZoneVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 최진호
 *
 */
@Repository("zoneMngDao")
public class ZoneMngDao {

    @Autowired SqlSession sqlSession;

    /**
     * @param parentId
     * @param reqType
     * @param state
     * @return
     */
    public List<TreeNode<String, ZoneVo>> selectZoneAndPoolListTree() {
        return sqlSession.selectList("ncis.sql.cpt.zone.selectZoneAndPoolListTree");
    }

    /**
     * @param parentId
     * @param reqType
     * @param state
     * @return
     */
    public List<TreeNode<String, ZoneVo>> selectZoneListTree() {
        return sqlSession.selectList("ncis.sql.cpt.zone.selectZoneListTree");
    }

    /**
     * @param regionId
     * @return
     */
    public RegionVo selectRegion(String regionId) {
        return sqlSession.selectOne("ncis.sql.cpt.zone.selectRegion",regionId);
    }

    /**
     * @param zoneId
     * @return
     */
    public ZoneVo selectZone(String zoneId) {
        return sqlSession.selectOne("ncis.sql.cpt.zone.selectZone",zoneId);
    }

    /**
     * @param zoneId
     * @return
     */
    public List<TreeNode<String, NetVo>> selectNetTree(String zoneId) {
        return sqlSession.selectList("ncis.sql.cpt.zone.selectNetTree",zoneId);
    }

    /**
     * @param zoneId
     * @param netId
     * @return
     */
    public NetVo selectNet(String netId) {
        return sqlSession.selectOne("ncis.sql.cpt.zone.selectNet",netId);
    }

    /**
     * @param rsrcPoolId
     * @return
     */
    public RsrcPoolVo selectPool(String rsrcPoolId) {
        return sqlSession.selectOne("ncis.sql.cpt.zone.selectPool",rsrcPoolId);
    }

    /**
     * @return
     */
    public List<NetVo> selectNetList() {
        return sqlSession.selectList("ncis.sql.cpt.zone.selectNetList");
    }

    /**
     * @param zoneNet
     * @return
     */
    public int selectExsitZoneNet(ZoneNetVo zoneNet) {
        return sqlSession.selectOne("ncis.sql.cpt.zone.selectExsitZoneNet",zoneNet);
    }

    /**
     * @param regionId
     * @return
     */
    public int selectExistZoneByRegion(String regionId) {
        return sqlSession.selectOne("ncis.sql.cpt.zone.selectExistZoneByRegion", regionId);
    }

    /**
     * @param zoneId
     * @return
     */
    public int selectExistNetByZone(String zoneId) {
        return sqlSession.selectOne("ncis.sql.cpt.zone.selectExistNetByZone", zoneId);
    }

    /**
     *
     * @param zoneId
     * @return
     */
    public List<NetVo> selectNetListByPool(String zoneId, String netClCd) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("zoneId", zoneId);
        params.put("netClCd", netClCd);

        return sqlSession.selectList("ncis.sql.cpt.zone.selectNetListByPool", params);
    }

    /**
     * @param zoneId
     * @param netId
     * @return
     */
    public int selectExistPoolByNet(String netId) {
        return sqlSession.selectOne("ncis.sql.cpt.zone.selectExistPoolByNet", netId);
    }

}
