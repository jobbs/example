/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SwVo.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2017. 1. 11.
 * @lastmodified 2017. 1. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 1. 11.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.vo;

import java.util.List;

import ncis.cmn.entity.RrSw;

/**
 * @author 이화영
 *
 */
public class SwVo extends RrSw {

	private String creUserNm; /* 등록자명 */
	private String updtUserNm; /* 수정자명 */
    private List<Integer> updtCheck;

	public String getCreUserNm() {
		return creUserNm;
	}
	public void setCreUserNm(String creUserNm) {
		this.creUserNm = creUserNm;
	}
	public String getUpdtUserNm() {
		return updtUserNm;
	}
	public void setUpdtUserNm(String updtUserNm) {
		this.updtUserNm = updtUserNm;
	}
	/**
	 * @return the updtCheck
	 */
	public List<Integer> getUpdtCheck() {
		return updtCheck;
	}
	/**
	 * @param updtCheck the updtCheck to set
	 */
	public void setUpdtCheck(List<Integer> updtCheck) {
		this.updtCheck = updtCheck;
	}
}
