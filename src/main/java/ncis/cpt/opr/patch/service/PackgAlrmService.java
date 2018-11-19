/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PackgAlrmService.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.service;

import java.util.List;

import ncis.cpt.opr.patch.vo.PackgAlrmInfoVo;
import ncis.cpt.opr.patch.vo.PackgAlrmSearchVo;
import ncis.cpt.opr.patch.vo.PackgAlrmVo;

/**
 * @author 이화영
 *
 */
public interface PackgAlrmService {

	/**
	 * 검색 조건에 해당하는 패치알림 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	List<PackgAlrmVo> selectPackgAlrmList(PackgAlrmSearchVo searchVo);

	/**
	 * 패치알림  Excel 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	List<PackgAlrmVo> selectPackgAlrmExcelList(PackgAlrmSearchVo searchVo);

	/**
     * 패치알림 상세 조회
     * @param packgAlrmVo
     * @return
     */
	PackgAlrmInfoVo selectPackgAlrm(PackgAlrmVo packgAlrmVo);

	/**
     * 패치알림확인
     * @param searchVo
     * @return
     */
	public void updatePackgAlrm(PackgAlrmSearchVo packgAlrmSearchVo);

}
