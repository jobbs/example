/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DistrbService.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 21.
 * @lastmodified 2016. 10. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 21.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.service;

import java.util.List;

import ncis.cpt.opr.patch.vo.DistrbSearchVo;
import ncis.cpt.opr.patch.vo.DistrbVo;

/**
 * @author 이화영
 *
 */
public interface DistrbService {

	/**
	 * 배포 목록 조회
	 * @return
	 */
	List<DistrbVo> selectDistrbList(DistrbSearchVo searchVo);

	/**
	 * 배포 목록 엑셀다운로드
	 * @return
	 */
	List<DistrbVo> selectDistrbExcelList(DistrbSearchVo searchVo);

	/**
	 * 배포 정보 등록
	 * @param distrbVo 배포 정보 내용
	 */
	void insertDisrb(DistrbVo distrbVo);
}
