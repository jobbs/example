/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ResultVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.cmm.service.vo;

import java.util.List;

/**
 * @author ShinKeeBong
 * @param <T>
 *
 */
@Deprecated /*ncis.rest.intfc.cmm.vo.ResultVO 와 중복되어 삭제대상임.*/
public class ResultVO<T> {

	private String resultCode;    /* 결과 코드   */
	private Integer resultCnt;    /* 결과 개수   */
	private String message;       /* 결과 메시지 */
	private List<T> data;         /* 결과 데이터 List */

	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public Integer getResultCnt() {
		return resultCnt;
	}
	public void setResultCnt(Integer resultCnt) {
		this.resultCnt = resultCnt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}


}
