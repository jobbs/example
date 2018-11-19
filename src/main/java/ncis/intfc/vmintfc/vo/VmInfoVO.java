/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmInfoVO.java
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
package ncis.intfc.vmintfc.vo;

import java.util.List;

/**
 * @author ShinKeeBong
 *
 */
public class VmInfoVO {

	private List<DisplayVO> display;  //DISPLAY

	public List<DisplayVO> getDisplay() {
		return display;
	}

	public void setDisplay(List<DisplayVO> display) {
		this.display = display;
	}


}
