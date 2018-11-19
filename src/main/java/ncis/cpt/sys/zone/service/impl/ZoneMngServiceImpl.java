/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ZoneMngServiceImpl.java
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
package ncis.cpt.sys.zone.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.cmn.dao.CRcNetDao;
import ncis.cmn.dao.CRcRegionDao;
import ncis.cmn.dao.CRcRsrcPoolDao;
import ncis.cmn.dao.CRcZoneDao;
import ncis.cmn.dao.CRcZoneNetMatrixDao;
import ncis.cmn.vo.Tree;
import ncis.cmn.vo.TreeNode;
import ncis.cpt.sys.zone.dao.ZoneMngDao;
import ncis.cpt.sys.zone.service.ZoneMngService;
import ncis.cpt.sys.zone.vo.NetVo;
import ncis.cpt.sys.zone.vo.RegionVo;
import ncis.cpt.sys.zone.vo.RsrcPoolVo;
import ncis.cpt.sys.zone.vo.ZoneNetVo;
import ncis.cpt.sys.zone.vo.ZoneVo;
import org.springframework.stereotype.Service;

/**
 * @author 최진호
 *
 */
@Service("zoneMngService")
public class ZoneMngServiceImpl implements ZoneMngService {

    @Resource(name="zoneMngDao")
    private ZoneMngDao zoneMngDao;

    @Resource(name="cRcRegionDao")
    private CRcRegionDao cRcRegionDao;

    @Resource(name="cRcZoneDao")
    private CRcZoneDao cRcZoneDao;

    @Resource(name="cRcZoneNetMatrixDao")
    private CRcZoneNetMatrixDao cRcZoneNetMatrixDao;

    @Resource(name="cRcNetDao")
    private CRcNetDao cRcNetDao;

    @Resource(name="cRcRsrcPoolDao")
    private CRcRsrcPoolDao cRcRsrcPoolDao;

    @Override
    public Tree<String, ZoneVo> selectZoneAndPoolListTree() {
        Tree<String,ZoneVo> tree = new Tree<String, ZoneVo>(new TreeNode<String,ZoneVo>(null,"root",null), false);
        tree.addChild(new TreeNode<String, ZoneVo>("000", "ZONE목록", null));
        tree.addChild(new TreeNode<String, ZoneVo>("9999", "미할당목록", null));
        tree.addChilds(zoneMngDao.selectZoneAndPoolListTree());

        return tree;
    }

    @Override
    public Tree<String, ZoneVo> selectZoneListTree() {
        Tree<String,ZoneVo> tree = new Tree<String, ZoneVo>(new TreeNode<String,ZoneVo>(null,"root",null), false);
        tree.addChilds(zoneMngDao.selectZoneListTree());
        return tree;
    }

    @Override
    public RegionVo selectRegion(String regionId) {
        return zoneMngDao.selectRegion(regionId);
    }

    @Override
    public void insertRegion(RegionVo region) {
        cRcRegionDao.insertRcRegion(region);
    }

    @Override
    public void updateRegion(RegionVo region) {
        cRcRegionDao.updateRcRegion(region);
    }

    @Override
    public boolean selectExistZoneByRegion(String regionId) {
        return zoneMngDao.selectExistZoneByRegion(regionId) > 0 ? true:false;
    }

    @Override
    public void deleteRegion(String regionId) {
        cRcRegionDao.deleteRcRegion(regionId);
    }

    @Override
    public ZoneVo selectZone(String zoneId) {
        return zoneMngDao.selectZone(zoneId);
    }

    @Override
    public void insertZone(ZoneVo zone) {
        cRcZoneDao.insertRcZone(zone);
    }

    @Override
    public void updateZone(ZoneVo zone) {
        cRcZoneDao.updateRcZone(zone);
    }

    @Override
    public boolean selectExistNetByZone(String zoneId) {
        return zoneMngDao.selectExistNetByZone(zoneId) > 0 ? true:false;
    }

    @Override
    public List<NetVo> selectNetListByPool(String zoneId, String netClCd) {
        return zoneMngDao.selectNetListByPool(zoneId, netClCd);
    }

    @Override
    public void deleteZone(String zoneId) {
        cRcZoneDao.deleteRcZone(zoneId);
    }


    @Override
    public NetVo selectNet(String netId) {
        return zoneMngDao.selectNet(netId);
    }

    @Override
    public void insertNet(NetVo net) {

        //망정보 등록
        cRcNetDao.insertRcNet(net);

        //매트릭스 등록
        ZoneNetVo zoneNet = net.getZoneNet();
        cRcZoneNetMatrixDao.insertRcZoneNetMatrix(zoneNet);
    }

    @Override
    public void updateNet(NetVo net) {
        cRcNetDao.updateRcNet(net);
    }

    @Override
    public boolean selectExistPoolByNet(String netId) {
        return zoneMngDao.selectExistPoolByNet(netId) > 0 ? true:false;
    }

    @Override
    public void deleteNet(String netId) {

        //매트릭스 삭제
        cRcZoneNetMatrixDao.deleteRcZoneNetMatrix(netId);

        //망삭제
        cRcNetDao.deleteRcNet(netId);
    }


    @Override
    public RsrcPoolVo selectPool(String rsrcPoolId) {
        return zoneMngDao.selectPool(rsrcPoolId);
    }

    @Override
    public void updateMoveRsrcPool(String netId, String poolId) {
        cRcRsrcPoolDao.updateMoveRsrcPool(netId, poolId);
    }

	@Override
	public void updatePool(RsrcPoolVo poolVo) {
		cRcRsrcPoolDao.updatePool(poolVo);
	}

}
