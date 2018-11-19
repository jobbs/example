/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmPatchService.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.service;

import java.util.List;

import ncis.cpt.opr.patch.vo.VmPatchPackgVo;
import ncis.cpt.opr.patch.vo.VmPatchSearchVo;
import ncis.cpt.opr.patch.vo.VmPatchVo;

/**
 * @author 이화영
 *
 */
public interface VmPatchService {

	/**
	 * 검색 조건에 해당하는 가상서버 패키지 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	List<VmPatchVo> selectVmPatchList(VmPatchSearchVo searchVo);

	/**
     * 가상서버 패키지 상세 조회
     *
     * @param vmSeq
     * @return
     */
	VmPatchVo selectVmPatch(VmPatchVo vmPatchVo);

	/**
     * 가상서버 패키지 상세 조회(설치 패키지)
     *
     * @param vmSeq
     * @return
     */

	List<VmPatchPackgVo> selectVmPatchPackgList(VmPatchVo vmPatchVo);

	/**
	 * 가상서버 Excel 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<VmPatchVo> selectVmPatchExcelList(VmPatchSearchVo searchVo);
}
