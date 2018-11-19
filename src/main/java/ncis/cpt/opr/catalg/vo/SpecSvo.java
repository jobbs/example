/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SpecSvo.java
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

import java.util.ArrayList;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 송승규
 *
 */
public class SpecSvo extends CommonSearchVo {

	/**
	 * CRUD 성공 여부
	 */
	private boolean successYn;

	/**
	 * R 스펙분류코드
	 */
	private String specClCd;

	/**
	 * R 스펙명
	 */
	private String specNm;
	
	/**
	 * R 구분코드
	 */
	private String clCd;
	

	/**
	 * D 스펙ID List
	 */
	private ArrayList<Integer> delCheck;

	/**
	 * @return the successYn
	 */
	public boolean isSuccessYn() {
		return successYn;
	}

	/**
	 * @param successYn the successYn to set
	 */
	public void setSuccessYn(boolean successYn) {
		this.successYn = successYn;
	}

	/**
	 * @return the specClCd
	 */
	public String getSpecClCd() {
		return specClCd;
	}

	/**
	 * @param specClCd the specClCd to set
	 */
	public void setSpecClCd(String specClCd) {
		this.specClCd = specClCd;
	}

	/**
	 * @return the specNm
	 */
	public String getSpecNm() {
		return specNm;
	}

	/**
	 * @param specNm the specNm to set
	 */
	public void setSpecNm(String specNm) {
		this.specNm = specNm;
	}

	/**
	 * @return the delCheck
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Integer> getDelCheck() {
		if(delCheck.isEmpty()){
			delCheck = new ArrayList<Integer>();
		}
		return (ArrayList<Integer>) delCheck.clone();
	}

	/**
	 * @param delCheck the delCheck to set
	 */
	@SuppressWarnings("unchecked")
	public void setDelCheck(ArrayList<Integer> delCheck) {
		this.delCheck = (ArrayList<Integer>) delCheck.clone();
	}

	/**
	 * @return the clCd
	 */
	public String getClCd() {
		return clCd;
	}

	/**
	 * @param clCd the clCd to set
	 */
	public void setClCd(String clCd) {
		this.clCd = clCd;
	}
	
}
