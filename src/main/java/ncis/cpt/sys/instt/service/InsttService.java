/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DepartService.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.sys.instt.service;

import java.util.List;

import ncis.cpt.sys.instt.vo.InsttSearchVo;
import ncis.cpt.sys.instt.vo.InsttVo;

/**
 * @author 최경철
 *
 */
public interface InsttService {

	/**
	 * 부처 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<InsttVo> selectInsttList(InsttSearchVo searchVo);

	/**
	 * 부처 상세 조회
	 * @param institutionId
	 * @return
	 */
	InsttVo selectInstt(String institutionId);

	/**
	 * 부처 정보 수정
	 * @param insttVo
	 */
	void updateInstt(InsttVo insttVo);

	/**
	 * @param insttVo
	 */
	void updateJob(InsttVo insttVo);

        /**
         * 부처목록 조회(Excel 다운로드)
         * @param searchVo
         * @return
         */
        List<InsttVo> selectInsttListXlsDwnl(InsttSearchVo searchVo);

	/**
	 * 부처 ID 조회
	 * @param institutionNm
	 * @return
	 */
	String selectInsttId(String institutionNm);
	
	/**
	 * 부처 목록 조회 (By 온나라)
	 * @param searchVo
	 * @return
	 */
	List<InsttVo> selectInsttListByOnnara(InsttSearchVo searchVo);
}
