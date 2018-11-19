/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetwkIntfcServiceImpl.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.cpt.rsrc.com.dao.NetwkIntfcDao;
import ncis.cpt.rsrc.com.service.NetwkIntfcService;
import ncis.cpt.rsrc.com.vo.NetwkIntfcVo;
import org.springframework.stereotype.Service;

/**
 * @author 신재훈, 심원보
 *
 */
@Service("netwkIntfcService")
public class NetwkIntfcServiceImpl implements NetwkIntfcService {

    @Resource(name = "netwkIntfcDao")
    private NetwkIntfcDao netwkIntfcDao;

    /**
     * VM에 할당된 네트워크 인터페이스 조회
     */
    @Override
    public List<NetwkIntfcVo> selectNetwkIntfcList(NetwkIntfcVo vo) {
        return netwkIntfcDao.selectNetwkIntfcList(vo);
    }
}
