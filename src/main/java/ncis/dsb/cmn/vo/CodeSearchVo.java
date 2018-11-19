/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CodeSearchVo.java
 *
 * @author 이권기
 * @lastmodifier 이권기
 * @created 2016. 9. 30.
 * @lastmodified 2016. 9. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 30.     이권기         v1.0             최초생성
 *
 */
package ncis.dsb.cmn.vo;

/**
 * @author 이권기
 *
 */
public class CodeSearchVo {
	private String userId;
	private String codeGubun;
	private boolean allYN = false;


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public CodeSearchVo(String codeGubun){
		setCodeGubun(codeGubun);
	}

	public CodeSearchVo(String codeGubun, boolean allYN){
		setCodeGubun(codeGubun);
		setAllYN(allYN);
	}

	public String getCodeGubun() {
		return codeGubun;
	}

	public void setCodeGubun(String codeGubun) {
		this.codeGubun = codeGubun;
	}

	public boolean isAllYN() {
		return allYN;
	}

	public void setAllYN(boolean allYN) {
		this.allYN = allYN;
	}
}


