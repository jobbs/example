/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MngrService.java
 *
 * @author 정승용
 * @lastmodifier 정승용
 * @created 2016. 10. 20.
 * @lastmodified 2016. 10. 20.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 20.     정승용         v1.0             최초생성
 *
 */
package ncis.api.stack.mngr.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import ncis.api.stack.mngr.vo.MngrSearchVo;
import ncis.api.stack.mngr.vo.MngrVo;

/**
 * @author 정승용
 *
 */
public interface MngrService {

	/**
	 * 매니저 관리 목록조회
	 * @param searchVo
	 * @return MngrVo
	 */
	List<MngrVo> selectMngrList(MngrSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException;

	/**
	 * 매니저 상태 호출(목록 조회)
     * @param regionId
     * @param zoneId
     * @param networkId
     * @param managerId
     * @return
     */
	MngrVo selectMngrHealthCheck(String rowId, String regionId, String zoneId, String netId, String mngrId) throws Exception;

	/**
	 * 매니저 관리 상세조회
	 * @param MngrVo Mngr 내용
	 */
	MngrVo selectMngr(String stackMngrId) throws Exception;

	/**
	 * 매니저 관리 등록
	 * @param @param MngrVo Mngr 내용
	 */
	void insertMngr(MngrVo mngrVo) throws Exception;

	/**
	 * 매니저 관리 수정
	 * @param @param MngrVo Mngr 내용
	 */
	void updateMngr(MngrVo mngrVo) throws Exception;

	/**
	 * 매니저 관리 삭제
	 * @param @param MngrVo Mngr 내용
	 */
	void deleteMngr(MngrVo mngrVo) throws Exception;

}
