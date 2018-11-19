/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WthdrwStPerInstService.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 10
 * @lastmodified2016. 12. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 10   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.rsrcoptz.service;

import java.util.List;

import ncis.dsb.stts.rsrcoptz.vo.WthdrwStPerInstSearchVo;
import ncis.dsb.stts.rsrcoptz.vo.WthdrwStPerInstVo;

public interface WthdrwStPerInstService {

	public List<WthdrwStPerInstVo> selectWthdrwStPerInstList(WthdrwStPerInstSearchVo searchVo) throws Exception;

	public List<WthdrwStPerInstVo> selectWthdrwStPerInstView(WthdrwStPerInstSearchVo searchVo) throws Exception;

	public void insertWthdrwStPerInst(List<WthdrwStPerInstVo> list) throws Exception;

	public void deleteWthdrwStPerInst(WthdrwStPerInstVo vo) throws Exception;

}
