/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BtchHistService.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 12. 9.
 * @lastmodified 2016. 12. 9.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 9.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.btch.service;

import java.util.List;

import ncis.cpt.sys.btch.vo.BtchHistSearchVo;
import ncis.cpt.sys.btch.vo.BtchHistVo;

/**
 * @author 박봉춘
 *
 */
public interface BtchHistService {

	/**
	 * 배치 수행이력 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<BtchHistVo> selectBtchHistList(BtchHistSearchVo searchVo);

	/**
	 * 배치 수행이력 엑셀 다운로드
	 * @param searchVo
	 * @return
	 */
	List<BtchHistVo> selectBtchHistListXlsDwnl(BtchHistSearchVo searchVo);

	/**
	 * 배치 수행이력 상세 조회
	 * @param jobExecutionId
	 * @return
	 */
	BtchHistVo selectBtchHist(int jobExecutionId);

	/**
	 * 배치 작업 이력 목록 조회
	 * @param jobExecutionId
	 * @return
	 */
	List<BtchHistVo> selectBtchJobHistList(int jobExecutionId);

	/**
	 * 배치 수행이력 상세 조회
	 * @param jobExecutionId
	 * @return
	 */
	BtchHistVo selectBtchHistById(String jobNm);

	/**
	 * @param stepExecutionId
	 * @return
	 */
	String selectExitMessage(long stepExecutionId);

}
