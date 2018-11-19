/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ViewResponseVo.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 14.
 * @lastmodified 2016. 10. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 14.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cmn.entity.couch;

import java.util.List;

public class ViewResponseVo<T> {

	private long total_rows;
	private long offset;
	private List<ViewResponseRowVo<T>> rows; // 데이터 목록
	/**
	 * @return the total_rows
	 */
	public long getTotal_rows() {
		return total_rows;
	}
	/**
	 * @param total_rows the total_rows to set
	 */
	public void setTotal_rows(long total_rows) {
		this.total_rows = total_rows;
	}
	/**
	 * @return the offset
	 */
	public long getOffset() {
		return offset;
	}
	/**
	 * @param offset the offset to set
	 */
	public void setOffset(long offset) {
		this.offset = offset;
	}
	/**
	 * @return the rows
	 */
	public List<ViewResponseRowVo<T>> getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(List<ViewResponseRowVo<T>> rows) {
		this.rows = rows;
	}

}
