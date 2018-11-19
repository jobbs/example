/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ZoneServiceImpl.java
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

import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import ncis.cmn.dao.CRcZoneDao;
import ncis.cpt.rsrc.zone.dao.ZoneDao;
import ncis.cpt.rsrc.zone.service.ZoneService;
import ncis.cpt.rsrc.zone.vo.ZoneSearchVo;
import ncis.cpt.rsrc.zone.vo.ZoneVo;

/**
 * @author 심원보
 *
 */
@Service("zoneService")
public class ZoneServiceImpl implements ZoneService {

    @Resource(name = "cRcZoneDao")
    private CRcZoneDao cRcZoneDao;

    @Resource(name = "zoneDao")
    private ZoneDao zoneDao;

    @Override
    public List<ZoneVo> selectZoneAllList() {
        return zoneDao.selectZoneAllList();
    }

    @Override
    public ZoneVo selectZone(BigDecimal zoneSeq) {
        return zoneDao.selectZone(zoneSeq);
    }

    @Override
    public List<ZoneVo> selectZoneListByRegion(ZoneSearchVo zoneSearchVo) {
        return zoneDao.selectZoneListByRegion(zoneSearchVo);
    }

}
