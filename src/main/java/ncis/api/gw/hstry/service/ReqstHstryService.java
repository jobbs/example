/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ReqstHstryService.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 27.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 27.     박희택         v1.0             최초생성
 *
 */
package ncis.api.gw.hstry.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import ncis.api.gw.use.vo.ReqstHstrySearchVo;
import ncis.api.gw.use.vo.ReqstHstryVo;
import ncis.api.gw.user.vo.UserMngVo;

/**
 * @author 박희택
 *
 */
public interface ReqstHstryService {

	/**
	 * 신청이력 등록
	 * @param UserMngVo vo
	 * @return void
	 */
	void insertReqstHstry(UserMngVo vo) throws Exception;

	/**
	 * 신청이력 목록조회
	 * @param svo
	 * @return ReqstHstrySearchVo
	 */
	List<ReqstHstryVo> selectReqstHistryList(ReqstHstrySearchVo svo)  throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException;

}
