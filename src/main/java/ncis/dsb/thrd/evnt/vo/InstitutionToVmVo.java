/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * InstitutionToVmVo.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   김동훈         v1.0             최초생성
 *
 */
package ncis.dsb.thrd.evnt.vo;


public class InstitutionToVmVo {
	private String key;
	private String title;
	private String path;
	private int depth;
	private String gubun;

	@SuppressWarnings("unused")
	private String isFolder;

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}


	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getTitle() {
		String ptitle="";
		if("VM".equals(getGubun())) ptitle="<span class=\"dynatree-virtualserver\"></span>"+title;
		else if("WX".equals(getGubun())) ptitle="<span class=\"dynatree-podlist\"></span>"+title;
		else ptitle=title;
		return ptitle;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsFolder() {
		return "VM".equals(getGubun()) || "WX".equals(getGubun())?"true":"false";
	}
	public void setIsFolder(String isFolder) {
		this.isFolder = isFolder;
	}

}
