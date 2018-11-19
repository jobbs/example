/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PStrgService.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.service;

import java.util.List;

import ncis.cmn.util.excel.CustomSheet;
import ncis.cpt.rsrc.strg.vo.PhyStrgSearchVo;
import ncis.cpt.rsrc.strg.vo.PhyStrgVo;
import ncis.cpt.rsrc.strg.vo.VrStrgSearchVo;
import ncis.cpt.rsrc.strg.vo.VrStrgVo;

/**
 * 물리스토리지 관리 서비스
 * @author 김봉민
 *
 */
public interface PhyStrgService {

	/**
	 * 물리스토리 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<PhyStrgVo> selectPhyStrgList(PhyStrgSearchVo searchVo);

	/**
	 * 가상스토리지 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<VrStrgVo> selectVrStrgCapaList(VrStrgSearchVo searchVo);

	/**
	 * 물리스토리지 목록 엑셀 저장
	 * @param searchVo
	 * @return
	 */
	List<CustomSheet> makePhyStrgListExcelSheets(PhyStrgSearchVo searchVo);

	/**
	 * 가상스토리지 목록 엑셀 저장
	 * @param searchVo
	 * @return
	 */
	List<CustomSheet> makeVrStrgListInPhyStrgExcelSheets(VrStrgSearchVo searchVo);

	/**
	 * 물리스토리지  정보 수정
	 * @param vo
	 * @throws Exception
	 */
	void updatePhyStrgCommInfo(PhyStrgVo vo);
}
