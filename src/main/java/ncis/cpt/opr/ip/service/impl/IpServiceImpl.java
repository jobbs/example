/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename IpServiceImpl.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.cpt.opr.ip.dao.RnIpDao;
import ncis.cpt.opr.ip.service.IpService;
import ncis.cpt.opr.ip.vo.IpSearchVo;
import ncis.cpt.opr.ip.vo.IpVo;
import org.springframework.stereotype.Service;

/**
 * @author 신재훈
 *
 */

@Service("ipService")
public class IpServiceImpl implements IpService {
    @Resource(name = "rnIpDao")
    private RnIpDao rnIpDao;

    /**
     * IP 현황 조회
     */
    @Override
    public List<IpVo> selectIpStteList(IpSearchVo searchVo) {
        List<IpVo> list = null;
        int totalCount = rnIpDao.selectIpListTotCnt(searchVo);
        if (totalCount > 0) {
            searchVo.getPaginationInfo().setTotalRecordCount(totalCount); // 페이지 처리위한 count
            list = rnIpDao.selectIpList(searchVo);
        }
        return list;

    }

    /**
     * IP 현황 엑셀다운로드
     */
    @Override
    public List<IpVo> selectIpStteListXlsDwnl(IpSearchVo searchVo) {
        searchVo.setPaginationInfo(null);
        return rnIpDao.selectIpList(searchVo);
    }
}
