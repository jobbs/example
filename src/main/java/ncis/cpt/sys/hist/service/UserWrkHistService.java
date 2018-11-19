/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserWrkHistService.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.hist.service;

import java.util.List;

import ncis.cpt.sys.hist.vo.UserWrkHistSearchVo;
import ncis.cpt.sys.hist.vo.UserWrkHistVo;

public interface UserWrkHistService {

	/**
	 * 작업이력 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<UserWrkHistVo> selectUserWrkHistList(UserWrkHistSearchVo searchVo);

	/**
	 * 작업로그 상세조회
	 * @param operateLogSeq
	 * @return
	 */
	UserWrkHistVo selectUserWrkHist(Long wrkHistSeq);

	/**
	 * 작업이력 저장
	 * @param log 작업이력 정보
	 */
	void insertUserWrkHist(UserWrkHistVo wrkHist);

	/**
	 * @param searchVo
	 * @return
	 */
	List<UserWrkHistVo> selectDownloadUserWrkHist(UserWrkHistSearchVo searchVo);
}
