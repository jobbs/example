/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TreeNode.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.vo;

import java.util.ArrayList;
import java.util.List;


import org.springframework.util.CollectionUtils;

public class TreeNode<K,T> {

	private K key;
	private K parentKey;
	private String title;
	private String gubun;
	private T data;
	private List<TreeNode<K,T>> children;
	private String isFolder;
	private String isLazy;
	private String activate;
	private String jobId;

	public TreeNode(){
	}

	public TreeNode(K key, String title, T data){
		this.key = key;
		this.title = title;
		this.data = data;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public K getParentKey() {
		return parentKey;
	}

	public void setParentKey(K parentKey) {
		this.parentKey = parentKey;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public String getGubun() {
		return gubun;
	}

	public String getTitle() {
		//if("VM".equals(getGubun())) title="<span class=\"dynatree-virtualserver\"></span>"+title;
		//else if("WX".equals(getGubun())) title="<span class=\"dynatree-podlist\"></span>"+title;
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<TreeNode<K,T>> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode<K,T>> children) {
		this.children = children;
		if(!CollectionUtils.isEmpty(children)){
			this.isFolder = "true";
		}
	}

	public String getIsFolder() {
		return isFolder;
	}

	public void setIsFolder(String isFolder) {
		this.isFolder = isFolder;
	}

	public void addChild(TreeNode<K,T> child){
		if(this.children == null){
			children = new ArrayList<TreeNode<K,T>>();
			isFolder = "true";
		}
		children.add(child);
	}

	public String getIsLazy() {
		return isLazy;
	}

	public void setIsLazy(String isLazy) {
		this.isLazy = isLazy;
	}

	public String getActivate() {
		return activate;
	}

	public void setActivate(String activate) {
		this.activate = activate;
	}


}
