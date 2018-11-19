/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ApiService.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     박희택         v1.0             최초생성
 *
 */
package ncis.api.opapi.api.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import ncis.api.opapi.api.vo.ApiSearchVo;
import ncis.api.opapi.api.vo.ApiVo;

/**
 * @author 박희택
 *
 */
public interface ApiService {

	/**
	 * Api 목록조회
	 * @param svo
	 * @return ApiSearchVo
	 */
	List<ApiVo> selectApiList(ApiSearchVo svo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException;

	/**
	 * Api 조회
	 * @param ApiVo Api 내용
	 */
	ApiVo selectApi(String keyId) throws Exception;

	/**
	 * Api등록
	 * @param ApiVo Api 내용
	 */
	void insertApi(ApiVo apiVo) throws Exception;

	/**
	 * Api삭제
	 * @param ApiVo Api 내용
	 */
	void deleteApi(ApiVo apiVo) throws Exception;

	/**
	 * Api수정
	 * @param ApiVo Api 내용
	 */
	void updateApi(ApiVo apiVo) throws Exception;
}
