/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename GraphicConsoleResultBodyVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 11. 2.
 * @lastmodified 2016. 11. 2.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 2.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.vmintfc.vo;

import java.util.List;

/**
 * @author ShinKeeBong
 *
 */
public class GraphicConsoleResultBodyVO {

	private List<GraphicConsoleVO> graphics_consoles;  //그래픽콘솔목록 정보

	public List<GraphicConsoleVO> getGraphics_consoles() {
		return graphics_consoles;
	}

	public void setGraphics_consoles(List<GraphicConsoleVO> graphics_consoles) {
		this.graphics_consoles = graphics_consoles;
	}





}
