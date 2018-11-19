/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PathsVo.java
 *
 * @author 이제율
 * @lastmodifier 이제율
 * @created 2016. 10. 31.
 * @lastmodified 2016. 10. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 31.     이제율        	 v1.0    	         최초생성
 *
 */
package ncis.api.cmn.tyk.vo;

import java.util.List;

/**
 * @author 이제율
 *
 */
public class PathsVo {
	private List<String> ignored;
    private List<String> white_list;
    private List<String> black_list;
	/**
	 * @return the ignored
	 */
	public List<String> getIgnored() {
		return ignored;
	}
	/**
	 * @param ignored the ignored to set
	 */
	public void setIgnored(List<String> ignored) {
		this.ignored = ignored;
	}
	/**
	 * @return the white_list
	 */
	public List<String> getWhite_list() {
		return white_list;
	}
	/**
	 * @param white_list the white_list to set
	 */
	public void setWhite_list(List<String> white_list) {
		this.white_list = white_list;
	}
	/**
	 * @return the black_list
	 */
	public List<String> getBlack_list() {
		return black_list;
	}
	/**
	 * @param black_list the black_list to set
	 */
	public void setBlack_list(List<String> black_list) {
		this.black_list = black_list;
	}
}
