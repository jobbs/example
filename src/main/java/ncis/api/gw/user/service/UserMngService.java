/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserMngService.java
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
package ncis.api.gw.user.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import ncis.api.gw.user.vo.UserMngSearchVo;
import ncis.api.gw.user.vo.UserMngVo;

/**
 * @author 박희택
 *
 */
public interface UserMngService {

	/**
	 * 사용자관리 목록조회
	 * @param svo
	 * @return UserMngVo
	 */
	List<UserMngVo> selectUserMngList(UserMngSearchVo svo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException;

	/**
	 * 사용자관리 조회
	 * @param UserMngVo UserMng 내용
	 */
	UserMngVo selectUserMng(String useReqId) throws Exception;

	/**
	 * 사용자관리 수정
	 * @param UserMngVo UserMng 내용
	 */
	void updateUserMng(UserMngVo userMngVo) throws Exception;

	/**
	 * 사용자관리 삭제
	 * @param openApiVo OpenApi 내용
	 */
	void deleteUserMng(UserMngVo userMngVo) throws Exception;

	/**
	 * 키재발급
	 * @param openApiVo OpenApi 내용
	 */
	void reIssuedUserMng(UserMngVo userMngVo) throws Exception;


}

