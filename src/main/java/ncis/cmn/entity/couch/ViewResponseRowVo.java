/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ViewResponseRowVo.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 14.
 * @lastmodified 2016. 10. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 14.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cmn.entity.couch;


public class ViewResponseRowVo<T> {

	private String id; // document _id
	private Object key; // view key
	private T value; // view value
	private T doc; // document


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the key
	 */
	public Object getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(Object key) {
		this.key = key;
	}
	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}
	/**
	 * @return the doc
	 */
	public T getDoc() {
		return doc;
	}
	/**
	 * @param doc the doc to set
	 */
	public void setDoc(T doc) {
		this.doc = doc;
	}


}
