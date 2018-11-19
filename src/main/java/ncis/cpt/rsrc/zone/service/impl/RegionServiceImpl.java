/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RegionServiceImpl.java
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
package ncis.cpt.rsrc.zone.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.CRcRegionDao;
import ncis.cpt.rsrc.zone.dao.RegionDao;
import ncis.cpt.rsrc.zone.service.RegionService;
import ncis.cpt.rsrc.zone.vo.RegionSearchVo;
import ncis.cpt.rsrc.zone.vo.RegionVo;

import org.springframework.stereotype.Service;

/**
 * @author 심원보
 *
 */
@Service("regionService")
public class RegionServiceImpl implements RegionService {

    @Resource(name = "cRcRegionDao")
    private CRcRegionDao cRcRegionDao;

    @Resource(name = "regionDao")
    private RegionDao regionDao;

    @Override
    public List<RegionVo> selectRegionList(RegionSearchVo regionSearchVo) {
        return regionDao.selectRegionList(regionSearchVo);
    }

    @Override
    public List<RegionVo> selectRegionAllList() {
        return regionDao.selectRegionAllList();
    }

    @Override
    public RegionVo selectRegion(String regionId) {

        return regionDao.selectRegion(regionId);

    }

}
