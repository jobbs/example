/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * RsrcAsgnStteTrmService.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.asgn.service;

import java.util.List;

import ncis.dsb.stts.asgn.vo.RsrcAsgnStteTrmSearchVo;
import ncis.dsb.stts.asgn.vo.RsrcAsgnStteTrmVo;


public interface RsrcAsgnStteTrmService {

	public List<RsrcAsgnStteTrmVo> selectRsrcAsgnStteTrmList(RsrcAsgnStteTrmSearchVo searchVo)throws Exception;



}
