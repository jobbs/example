/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TargetVmInsertDataVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 21.
 * @lastmodified 2016. 10. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 21.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.seoa.vo;

import java.util.List;

/**
 * @author ShinKeeBong
 *
 */
public class TargetVmInsertDataVO {

	private List<TargetVmVO> insertData;   //InsertData 배열 객체


	public List<TargetVmVO> getInsertData() {
		return insertData;
	}

	public void setInsertData(List<TargetVmVO> insertData) {
		this.insertData = insertData;
	}

}
