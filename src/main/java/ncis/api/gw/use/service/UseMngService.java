/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UseReqService.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     박희택         v1.0             최초생성
 *
 */
package ncis.api.gw.use.service;

import ncis.api.gw.user.vo.UserMngVo;

/**
 * @author 박희택
 *
 */
public interface UseMngService {

	/**
	 * 로그인 체크
	 * @param userMngVo ApiGwUser 내용
	 */
	UserMngVo apiLoginChk(UserMngVo userMngVo) throws Exception;

	/**
	 * 사용관리 조회
	 * @param UseMngVo UseMng 내용
	 */
	UserMngVo selectUseMng(String sysCd) throws Exception;

	/**
	 * 사용관리 수정
	 * @param UseMngVo UseMng 내용
	 */
	void updateUseMng(UserMngVo userMngVo) throws Exception;

	/**
	 * 비밀번호초기화 메일전송
	 * @param UseMngVo UseMng 내용
	 */
	void sendMail(UserMngVo userMngVo) throws Exception;

}
