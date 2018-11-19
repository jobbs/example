/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BtchService.java
 *
 * @author 정승용
 * @lastmodifier 정승용
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     정승용         v1.0             최초생성
 *
 */
package ncis.api.stack.btch.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import ncis.api.stack.btch.vo.BtchVo;

/**
 * @author 정승용
 *
 */
public interface BtchService {

	/**
	 * 배치관리 조회
	 * @param BtchVo 배치관리 내용
	 */
	List<BtchVo> selectBtch() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException;

	/**
	 * 배치정보 삭제주기 조회
	 * @param BtchVo 배치정보 삭제주기 내용
	 */
	List<BtchVo> selectBtchInfoDel() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException;

	/**
	 * 배치관리 수정
	 * @param @param BtchVo 배치관리 내용
	 */
	void updateBtch(BtchVo btchVo) throws Exception;

	/**
	 * 배치정보 삭제주기 수정
	 * @param @param BtchVo 배치정보 삭제주기 내용
	 */
	void updateBtchInfoDel(BtchVo btchVo) throws Exception;
}
