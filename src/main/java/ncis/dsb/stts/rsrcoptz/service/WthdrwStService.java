/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WthdrwStService.java
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

import ncis.dsb.stts.rsrcoptz.vo.WthdrwStSearchVo;
import ncis.dsb.stts.rsrcoptz.vo.WthdrwStVo;

public interface WthdrwStService {

	public List<WthdrwStVo> selectWthdrwStList(WthdrwStSearchVo searchVo) throws Exception;

	public List<WthdrwStVo> selectWthdrwRsrcList(WthdrwStSearchVo searchVo) throws Exception;

	public List<WthdrwStVo> selectWthdrwStView(WthdrwStSearchVo searchVo) throws Exception;

	public void deleteWthdrwSt(WthdrwStVo vo) throws Exception;

	public void insertWthdrwSt(List<WthdrwStVo> insert) throws Exception;

}
