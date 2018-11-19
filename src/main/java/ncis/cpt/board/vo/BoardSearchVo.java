/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BoardSearchVo.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 9. 30.
 * @lastmodified 2016. 9. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 30.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.board.vo;

import ncis.cmn.vo.CommonSearchVo;

public class BoardSearchVo extends CommonSearchVo {

	/**
	 * 메인화면 공지를 위한 게시판 코드 저장
	 */
	private String boardCd;

	/**
	 * 제목검색
	 */
	private String searchSbjct;

	/**
	 * 내용검색
	 */
	private String searchContent;

		public String getBoardCd() {
		return boardCd;
	}

	public void setBoardCd(String boarIId) {
		this.boardCd = boarIId;
	}

	/**
	 * @return the searchSbjct
	 */
	public String getSearchSbjct() {
		return searchSbjct;
	}

	/**
	 * @param searchSbjct the searchSbjct to set
	 */
	public void setSearchSbjct(String searchSbjct) {
		this.searchSbjct = searchSbjct;
	}

	/**
	 * @return the searchContent
	 */
	public String getSearchContent() {
		return searchContent;
	}

	/**
	 * @param searchContent the searchContent to set
	 */
	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
}
