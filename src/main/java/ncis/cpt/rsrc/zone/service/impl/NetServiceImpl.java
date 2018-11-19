/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetServiceImpl.java
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

import ncis.cmn.dao.CRcNetDao;
import ncis.cpt.rsrc.zone.dao.NetDao;
import ncis.cpt.rsrc.zone.service.NetService;
import ncis.cpt.rsrc.zone.vo.NetSearchVo;
import ncis.cpt.rsrc.zone.vo.NetVo;

import org.springframework.stereotype.Service;

/**
 * @author 심원보
 *
 */
@Service("netService")
public class NetServiceImpl implements NetService {

    @Resource(name = "cRcNetDao")
    private CRcNetDao cRcNetDao;

    @Resource(name = "netDao")
    private NetDao netDao;

    @Override
    public List<NetVo> selectNetAllList() {
    	return netDao.selectNetAllList();
    }

    @Override
    public NetVo selectNet(String netId) {
        return netDao.selectNet(netId);
    }

    @Override
    public List<NetVo> selectNetListByZone(NetSearchVo netSearchVo) {
        return netDao.selectNetListByZone(netSearchVo);
    }

}
