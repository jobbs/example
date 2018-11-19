/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UnitJobRelateVo.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.vo;

import java.util.Date;
import java.util.List;

import ncis.cmn.entity.RrUnitJobRelate;

/**
 * @author 이화영
 *
 */
public class UnitJobRelateVo extends RrUnitJobRelate{

	private List<UnitJobRelateVo> unitJobRelateVoList;
	private Date regDt;/*등록일자*/

	private String uJobRelateTyNm;  /* 단위업무관계유형코드명*/

	public List<UnitJobRelateVo> getUnitJobRelateVoList() {
		return unitJobRelateVoList;
	}
	public void setUnitJobRelateVoList(List<UnitJobRelateVo> unitJobRelateVoList) {
		this.unitJobRelateVoList = unitJobRelateVoList;
	}
	public Date getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}
	public String getuJobRelateTyNm() {
		return uJobRelateTyNm;
	}
	public void setuJobRelateTyNm(String uJobRelateTyNm) {
		this.uJobRelateTyNm = uJobRelateTyNm;
	}

}
