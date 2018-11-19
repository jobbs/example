/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MemberBodyVo.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 11. 11.
 * @lastmodified 2016. 11. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 11.     김봉민         v1.0             최초생성
 *
 */
package ncis.intfc.netwkstack.vo;

import java.util.List;

/**
 * @author 김봉민
 *
 */
public class MemberBodyVo {
	private List<MemberVO> member;

	public List<MemberVO> getMember() {
		return member;
	}

	public void setMember(List<MemberVO> member) {
		this.member = member;
	}


}
