/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TestService.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     박봉춘         v1.0             최초생성
 *
 */
package ncis.test.service;

import ncis.cmn.vo.ProcResultVo;

public interface TestService {

	ProcResultVo selectRest();

	ProcResultVo insertRest();

	ProcResultVo updateRest();

	ProcResultVo deleteRest();

	ProcResultVo selectMachineList();

	ProcResultVo selectMachine();

	ProcResultVo selectNtops();

    String selectSeqNum(String classfy, String format);

	/**
	 *
	 */
	void insertSequenceTest();

}