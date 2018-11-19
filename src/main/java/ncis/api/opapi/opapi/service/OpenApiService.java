/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename OpenApiService.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     박희택         v1.0             최초생성
 *
 */
package ncis.api.opapi.opapi.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import ncis.api.opapi.opapi.vo.OpenApiSearchVo;
import ncis.api.opapi.opapi.vo.OpenApiVo;

/**
 * @author 박희택
 *
 */
public interface OpenApiService {

	/**
	 * OpenApi 목록조회
	 * @param svo
	 * @return SpecSvo
	 */
	List<OpenApiVo> selectOpenApiList(OpenApiSearchVo svo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException;

	/**
	 * OpenApi 조회
	 * @param openApiVo OpenApi 내용
	 */
	OpenApiVo selectOpenApi(String opApiId) throws Exception;

	/**
	 * OpenApi등록
	 * @param openApiVo OpenApi 내용
	 */
	void insertOpenApi(OpenApiVo openApiVo) throws Exception;

	/**
	 * OpenApi수정
	 * @param openApiVo OpenApi 내용
	 */
	void updateOpenApi(OpenApiVo openApiVo) throws Exception;

	/**
	 * OpenApi삭제
	 * @param openApiVo OpenApi 내용
	 */
	void deleteOpenApi(OpenApiVo openApiVo) throws Exception;
}
