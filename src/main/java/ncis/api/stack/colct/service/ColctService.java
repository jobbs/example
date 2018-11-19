/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ColctService.java
 *
 * @author 최장성
 * @lastmodifier 최장성
 * @created 2016. 11. 11.
 * @lastmodified 2016. 11. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 11.     최장성         v1.0             최초생성
 *
 */
package ncis.api.stack.colct.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import ncis.api.stack.colct.vo.ColctSearchVo;
import ncis.api.stack.colct.vo.ColctVo;

/**
 * @author 최장성
 *
 */
public interface ColctService {

	/**
	 * 매니저 관리 목록조회
	 * @param searchVo
	 * @return MngrVo
	 */
	List<ColctVo> selectColctList(ColctSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException;

    /**
     * @param mngrId
     * @return
     */
	ColctVo selectColctHealthCheck(String colctId, String mngrId, String stackClCd, String btchColctCd) throws Exception;


}
