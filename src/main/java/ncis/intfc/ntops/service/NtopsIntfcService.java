/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ReqVmConsoleTokenService.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 20.
 * @lastmodified 2016. 10. 20.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 20.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.ntops.service;




/**
 * @author ihjang
 *
 */
public interface NtopsIntfcService {


	public boolean sendVmCreateNTopsResult(String string) throws Exception;

	public boolean sendVmDeleteNTopsResult(String rsrcReqNo) throws Exception;

	public boolean sendVmSpecChangeNTopsResult(String rsrcReqNo) throws Exception;

	public boolean sendVmStorageAddNTopsResult(String rsrcReqNo) throws Exception;


}
