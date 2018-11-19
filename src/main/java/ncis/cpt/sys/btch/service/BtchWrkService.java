/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BtchWrkService.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.btch.service;

import java.util.List;

import ncis.cpt.sys.btch.vo.BtchWrkSearchVo;
import ncis.cpt.sys.btch.vo.BtchWrkVo;

/**
 * @author 박봉춘
 *
 */
public interface BtchWrkService {

	/**
	 * 검색 조건에 해당하는 배치 관리 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<BtchWrkVo> selectBtchWrkList(BtchWrkSearchVo searchVo);

	/**
	 * Sequence에 해당하는 배치관리 정보 조회(배치 상세조회)
	 * @param btchWrkSeq
	 * @return
	 */
	BtchWrkVo selectBtchWrk(Long btchWrkSeq);

	/**
	 * 배치관리 등록
	 * @param btchWrkVo
	 */
	void insertBtchWrk(BtchWrkVo btchWrkVo);

	/**
	 * 배치관리 수정
	 * @param btchWrkVo
	 */
	void updateBtchWrk(BtchWrkVo btchWrkVo);


	/**
	 * 배치관리 삭제
	 * @param btchWrkSeq
	 */
	void deleteBtchWrk(Long btchWrkSeq);

	/**
	 * 배치관리 목록 엑셀 다운로드
	 * @param searchVo
	 * @return
	 */
	List<BtchWrkVo> selectBtchWrkListXlsDwnl(BtchWrkSearchVo searchVo);

	/**
	 * 배치 ID 중복 수 체크
	 * @param btchwrkSeq
	 * @param btchwrkId
	 * @return
	 */
	int selectBtchWrkIdCnt(Long btchWrkSeq, String btchWrkId);
}
