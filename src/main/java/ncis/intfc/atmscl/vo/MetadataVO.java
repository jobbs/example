/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename LbBodyVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 11. 11.
 * @lastmodified 2016. 11. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 11.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.vo;

import java.util.Map;

/**
 * @author x
 *
 */
public class MetadataVO {

	private String name;
	//private LabelsVO labels;
	
	private Map<String, String> annotations;
	private Map<String, String> labels;
	
	
	//private AnnotationsVO annotations;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*
	public LabelsVO getLabels() {
		return labels;
	}
	public void setLabels(LabelsVO labels) {
		this.labels = labels;
	}
	*/
	public Map<String, String> getAnnotations() {
		return annotations;
	}
	public void setAnnotations(Map<String, String> annotations) {
		this.annotations = annotations;
	}
	public Map<String, String> getLabels() {
		return labels;
	}
	public void setLabels(Map<String, String> labels) {
		this.labels = labels;
	}

}
