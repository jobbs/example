/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ComServiceImpl.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 10. 27.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 27.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import ncis.cmn.util.RequestUtils;
import ncis.cpt.rsrc.atmscl.dao.ServcAreaDao;
import ncis.cpt.rsrc.atmscl.vo.ServcAreaSearchVo;
import ncis.cpt.rsrc.com.dao.PmDao;
import ncis.cpt.rsrc.com.dao.VmDao;
import ncis.cpt.rsrc.com.service.ComService;
import ncis.cpt.rsrc.com.vo.PmSearchVo;
import ncis.cpt.rsrc.com.vo.VmSearchVo;

import org.springframework.stereotype.Service;

/**
 * @author 심원보
 *
 */
@Service("comService")
public class ComServiceImpl implements ComService {

    @Resource(name = "pmDao")
    private PmDao pmDao;

    @Resource(name = "vmDao")
    private VmDao vmDao;

    @Resource(name = "servcAreaDao")
    private ServcAreaDao servcAreaDao;

    /**
     * 사용자별 컴퓨팅 자원통계
     *
     * @return
     */
    @Override
    public Map<String, Object> selectComSttsByUser() {

        Map<String, Object> resultMap = new HashMap<String, Object>();

        if ("SYSADM".equals(RequestUtils.getUser().getSuperposedUserRole()) || "OPRADM".equals(RequestUtils.getUser().getSuperposedUserRole())) {
            resultMap.put("pm", pmDao.selectPmSttsByUser(new PmSearchVo()));
        }
        resultMap.put("vm", vmDao.selectVmSttsByUser(new VmSearchVo()));
        resultMap.put("job", vmDao.selectVmJobSttsByUser(new VmSearchVo()));
        resultMap.put("atmscl", servcAreaDao.selectAtmsclSttsByUser(new ServcAreaSearchVo()));

        return resultMap;
    }

}
