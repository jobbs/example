/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename AuthrService.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.     박희택         v1.0             최초생성
 *
 */
package ncis.api.opapi.authr.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import ncis.api.opapi.authr.vo.AuthrSearchVo;
import ncis.api.opapi.authr.vo.AuthrVo;

/**
 * @author 박희택
 *
 */
public interface AuthrService {

	/**
	 * OpenApi 권한목록조회
	 * @param svo
	 * @return AuthrVo
	 */
	List<AuthrVo> selectAuthrList(AuthrSearchVo svo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException;

	/**
	 * OpenApi 권한등록
	 * @param AuthrVo Authr 내용
	 */
	void insertAuthr(AuthrVo authrVo) throws Exception;

	/**
	 * OpenApi 권한상세조회
	 * @param AuthrVo Authr 내용
	 */
	AuthrVo selectAuthr(String authrId) throws Exception;

	/**
	 * OpenApi 권한수정
	 * @param AuthrVo Authr 내용
	 */
	void updateAuthr(AuthrVo authrVo) throws Exception;

	/**
	 * OpenApi 권한삭제
	 * @param AuthrVo Authr 내용
	 */
	void deleteAuthr(AuthrVo authrVo) throws Exception;



}
