/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * SanAsgnYmService.java
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

import ncis.dsb.stts.asgn.vo.SanAsgnYmSearchVo;
import ncis.dsb.stts.asgn.vo.SanAsgnYmVo;


public interface SanAsgnYmService {

	public List<SanAsgnYmVo> selectSanAsgnYmList(SanAsgnYmSearchVo searchVo) throws Exception;

	public List<SanAsgnYmVo> selectSanAsgnRsrcList(SanAsgnYmSearchVo searchVo) throws Exception;

	public List<SanAsgnYmVo> selectSanAsgnView(SanAsgnYmSearchVo searchVo) throws Exception;

	public void deleteSanAsgn(List<SanAsgnYmVo> list) throws Exception;

	public void insertSanAsgn(List<SanAsgnYmVo> list) throws Exception;

}
