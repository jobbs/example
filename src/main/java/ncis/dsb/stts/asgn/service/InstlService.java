/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * InstlService.java
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

import ncis.dsb.stts.asgn.vo.InstlSearchVo;
import ncis.dsb.stts.asgn.vo.InstlVo;

public interface InstlService {

	public List<InstlVo> selectInstlList(InstlSearchVo searchVo) throws Exception;

	public List<InstlVo> selectInstlView(InstlSearchVo searchVo) throws Exception;

	public void insertInstl(List<InstlVo> list) throws Exception;

	public void deleteInstl(InstlVo vo) throws Exception;

}
