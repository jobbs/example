/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserConnRecService.java
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
import ncis.cmn.entity.CmUsrConnHist;
import ncis.cpt.sys.hist.vo.UserConnHistSearchVo;
import ncis.cpt.sys.hist.vo.UserConnHistVo;

public interface UserConnHistService {

	/**
	 * 접속이력 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<UserConnHistVo> selectUserConnHistList(UserConnHistSearchVo searchVo);

	/**
	 * 접속로그 상세조회
	 * @param operateLogSeq
	 * @return
	 */
	UserConnHistVo selectUserConnHist(Long connectSeq);

	/**
	 * 접속이력 저장
	 * @param cmUsrConnHist 접속이력 정보
	 */
	void insertUSerConnHist(CmUsrConnHist cmUsrConnHist);

	/**
	 * 접속이력 엑셀 다운로드
	 * @param searchVo
	 * @return
	 */
	List<UserConnHistVo> selectDownloadUserConnHist(UserConnHistSearchVo searchVo);
}
