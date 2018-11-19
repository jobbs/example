/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename IpStteService.java
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
package ncis.cpt.opr.ip.service;

import java.util.List;
import ncis.cpt.opr.ip.vo.IpSearchVo;
import ncis.cpt.opr.ip.vo.IpVo;

/**
 * @author 신재훈
 *
 */
public interface IpService {
    /**
     * IP현황 목록조회
     *
     * @param searchVo
     * @return
     */
    List<IpVo> selectIpStteList(IpSearchVo searchVo);

    /**
     * IP현황 엑셀다운로드
     *
     * @param searchVo
     * @return
     */
    List<IpVo> selectIpStteListXlsDwnl(IpSearchVo searchVo);
}
