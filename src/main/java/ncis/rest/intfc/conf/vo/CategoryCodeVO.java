/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CategoryCodeVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 9. 21.
 * @lastmodified 2016. 9. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 21.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.conf.vo;


/**
 * @author ShinKeeBong
 *
 */
//@JsonInclude(Include.NON_NULL)
public class CategoryCodeVO {

	private String parentGrpCd;	/* 부모그룹코드 */
	private String parentCd;	/* 부모코드 	*/
	private String grpCd;		/* 그룹코드 	*/
	private String cd	;		/* 코드 		*/
	private String cdNm	;		/* 코드명 		*/
	private String cdDesc	;	/* 설명 		*/


	/**
	 * @return the parentGrpCd
	 */
	public String getParentGrpCd() {
		return parentGrpCd;
	}
	/**
	 * @param parentGrpCd the parentGrpCd to set
	 */
	public void setParentGrpCd(String parentGrpCd) {
		this.parentGrpCd = parentGrpCd;
	}
	/**
	 * @return the parentCd
	 */
	public String getParentCd() {
		return parentCd;
	}
	/**
	 * @param parentCd the parentCd to set
	 */
	public void setParentCd(String parentCd) {
		this.parentCd = parentCd;
	}
	/**
	 * @return the cdNm
	 */
	public String getCdNm() {
		return cdNm;
	}
	/**
	 * @param cdNm the cdNm to set
	 */
	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}
	/**
	 * @return the cd
	 */
	public String getCd() {
		return cd;
	}
	/**
	 * @param cd the cd to set
	 */
	public void setCd(String cd) {
		this.cd = cd;
	}
	/**
	 * @return the grpCd
	 */
	public String getGrpCd() {
		return grpCd;
	}
	/**
	 * @param grpCd the grpCd to set
	 */
	public void setGrpCd(String grpCd) {
		this.grpCd = grpCd;
	}
	/**
	 * @return the cdDesc
	 */
	public String getCdDesc() {
		return cdDesc;
	}
	/**
	 * @param cdDesc the cdDesc to set
	 */
	public void setCdDesc(String cdDesc) {
		this.cdDesc = cdDesc;
	}



}
