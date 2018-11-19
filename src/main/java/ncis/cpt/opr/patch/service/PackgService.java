/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PackgService.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.service;

import java.util.List;

import ncis.cmn.entity.OaPackgReposit;
import ncis.cpt.opr.patch.vo.PackgInfoVo;
import ncis.cpt.opr.patch.vo.PackgSearchVo;
import ncis.cpt.opr.patch.vo.PackgVo;

/**
 * @author 이화영
 *
 */
public interface PackgService {

	/**
	 * 검색 조건에 해당하는 패키지 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	List<PackgVo> selectPackgList(PackgSearchVo searchVo);

	/**
	 * 패키지 Excel 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<PackgVo> selectPackgExcelList(PackgSearchVo searchVo);

	/**
     * 리전 리스트 조회
     * @return

	List<RcRegion> selectRegionList();*/

	/**
	 * 망 리스트 조회
     * @param regionId
     * @return

    List<RcNet> selectPackgNetListByRegion(String regionId);*/

    /**
	 * 레파지토리 리스트 조회
     * @param regionId
     * @return
     */
    List<OaPackgReposit> selectPackgRepositListByNet(PackgSearchVo searchVo);

    /**
     * 패키지 상세 조회
     * @param packgVo
     * @return
     */
    PackgInfoVo selectPackg(PackgVo packgVo);

    /**
     * 패키지 상세 조회(패치대상 가상서버 목록)
     * @param searchVo
     * @return
     */
    List<PackgVo> selectPatchTrgtList(PackgSearchVo searchVo);

    /**
     * 패키지 이전 버전 조회 화면 호출
     * @param searchVo
     * @return
     */
    List<PackgVo> selectPackgVerList(PackgSearchVo searchVo);

    /**
	 * 알림등록
	 * @param packgVo
	 * @return
     * @throws Exception
	 */
	public void insertPatchAlrm(PackgVo packgVo) throws Exception;


}
