/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SpecVo.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.vo;

import ncis.cmn.entity.RrSpec;


/**
 * @author 송승규
 *
 */
public class SpecVo extends RrSpec {

	/**
	 * 스펙분류코드명
	 */
	private String specClCdNm;

	/**
	 * 생성자명
	 */
	private String creUserNm;

	/**
	 * 수정자명
	 */
	private String updtUserNm;

	/**
	 * 생성일자(for excel)
	 */
	private String creDate;

	/**
	 * 수정일자(for excel)
	 */
	private String updtDate;
	
	/**
	 * 구분명
	 */
	private String clCdNm;
	
	

	/**
	 * @return the specClCdNm
	 */
	public String getSpecClCdNm() {
		return specClCdNm;
	}

	/**
	 * @param specClCdNm the specClCdNm to set
	 */
	public void setSpecClCdNm(String specClCdNm) {
		this.specClCdNm = specClCdNm;
	}

	/**
	 * @return the creUserNm
	 */
	public String getCreUserNm() {
		return creUserNm;
	}

	/**
	 * @param creUserNm the creUserNm to set
	 */
	public void setCreUserNm(String creUserNm) {
		this.creUserNm = creUserNm;
	}

	/**
	 * @return the updtUserNm
	 */
	public String getUpdtUserNm() {
		return updtUserNm;
	}

	/**
	 * @param updtUserNm the updtUserNm to set
	 */
	public void setUpdtUserNm(String updtUserNm) {
		this.updtUserNm = updtUserNm;
	}

	/**
	 * @return the creDate
	 */
	public String getCreDate() {
		return creDate;
	}

	/**
	 * @param creDate the creDate to set
	 */
	public void setCreDate(String creDate) {
		this.creDate = creDate;
	}

	/**
	 * @return the updtDate
	 */
	public String getUpdtDate() {
		return updtDate;
	}

	/**
	 * @param updtDate the updtDate to set
	 */
	public void setUpdtDate(String updtDate) {
		this.updtDate = updtDate;
	}

	/**
	 * @return the clCdNm
	 */
	public String getClCdNm() {
		return clCdNm;
	}

	/**
	 * @param clCdNm the clCdNm to set
	 */
	public void setClCdNm(String clCdNm) {
		this.clCdNm = clCdNm;
	}

	
}
