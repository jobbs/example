/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CustomMiddlewareVo.java
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
 * 2016. 10. 31.     이제율         v1.0             최초생성
 *
 */
package ncis.api.cmn.tyk.vo;

import java.util.List;

/**
 * @author 이제율
 *
 */
public class CustomMiddlewareVo {
	private List<MiddlePreVo> pre;
	private List<MiddlePostVo> post;
	private List<MiddleResponseVo> response;
	/**
	 * @return the pre
	 */
	public List<MiddlePreVo> getPre() {
		return pre;
	}
	/**
	 * @param pre the pre to set
	 */
	public void setPre(List<MiddlePreVo> pre) {
		this.pre = pre;
	}
	/**
	 * @return the post
	 */
	public List<MiddlePostVo> getPost() {
		return post;
	}
	/**
	 * @param post the post to set
	 */
	public void setPost(List<MiddlePostVo> post) {
		this.post = post;
	}
	/**
	 * @return the response
	 */
	public List<MiddleResponseVo> getResponse() {
		return response;
	}
	/**
	 * @param response the response to set
	 */
	public void setResponse(List<MiddleResponseVo> response) {
		this.response = response;
	}
}