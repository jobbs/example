/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * UsefulService.java
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


package ncis.dsb.stts.asgnUseful.service;

import java.util.List;

import ncis.dsb.stts.asgnUseful.vo.UsefulSearchVo;
import ncis.dsb.stts.asgnUseful.vo.UsefulVo;

public interface UsefulService {

	public List<UsefulVo> selectUsefulList(UsefulSearchVo searchVo) throws Exception;

	public List<UsefulVo> selectUsefulView(UsefulSearchVo searchVo) throws Exception;

	public List<UsefulVo> selectUsefulAdd(UsefulSearchVo searchVo) throws Exception;


	public void insertUseful(List<UsefulVo> list) throws Exception;

	public void deleteUseful(List<UsefulVo> list) throws Exception;


}
