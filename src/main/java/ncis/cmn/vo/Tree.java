/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename Tree.java
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

import java.util.List;

public class Tree<K,T> {
	private TreeNode<K,T> root;
	boolean isLazy;
	private K activateKey;

	public Tree() {
		isLazy = false;
	}

	public Tree(TreeNode<K,T> root){
		this.root = root;
		isLazy = false;
	}

	public Tree(TreeNode<K,T> root, boolean isLazy){
		this.root = root;
		this.isLazy = isLazy;
	}

	public TreeNode<K,T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<K,T> root) {
		this.root = root;
	}

	public void addChilds(List<TreeNode<K,T>> children){
		if(children == null){
			return;
		}

		for(TreeNode<K,T> node:children){
			TreeNode<K,T> parent = findParent(root,node);

			/*if(!node.getTitle().equals(tmpTitle)){
				tmpTitle = node.getTitle();
			}else{
				node.setTitle(node.getTitle()+"("+node.getJobId()+")");
			}
			*/
			if(parent != null){
				if(isLazy){
					node.setIsLazy("true");
				}
				parent.addChild(node);
			}
		}
	}

	public void addChild(TreeNode<K,T> node){
		TreeNode<K,T> parent = findParent(root,node);
		if(parent != null){
			if(isLazy){
				node.setIsLazy("true");
			}
			if(activateKey != null &&activateKey.equals(node.getKey())){
				node.setActivate("true");
			}
			parent.addChild(node);
		}
	}

	public TreeNode<K,T> findParent(TreeNode<K,T> node, TreeNode<K,T> child){
		TreeNode<K,T> result = null;
		if(compareKey(node.getKey(), child.getParentKey())){
			return node;
		}else if(node.getChildren() != null){
			for(TreeNode<K,T> childNode:node.getChildren()){
				result = findParent(childNode,child);
				if(result != null){
					return result;
				}
			}
		}
		return result;
	}

	private boolean compareKey(K obj1, K obj2){
		if(obj1 == null && obj2 == null){
			return true;
		}else if(obj1 == null || obj2 == null){
			return false;
		}
		return obj1.equals(obj2);
	}

	public K getActivateKey() {
		return activateKey;
	}

	public void setActivateKey(K activateKey) {
		this.activateKey = activateKey;
	}
}
