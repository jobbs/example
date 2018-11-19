/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ClstrSearchVo.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.vo;

import java.util.Arrays;
import javax.validation.constraints.Max;
import ncis.cmn.vo.CommonSearchVo;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.com.validation.SearchValidation;

/**
 * @author 심원보
 *
 */
public class ClstrSearchVo extends CommonSearchVo {

    /**
     * -------------------------------
     * PREFIX 내용
     * -------------------------------
     * equals 일치
     * contains 부분일치
     * exists 존재
     * -------------------------------
     */

    private String equalsRegionId;

    private String equalsZoneId;

    private String equalsNetId;

    private String equalsNetClCd;

    private String equalsRsrcPoolId;

    private String equalsUseYn;

    private String equalsDelYn;

    @Max(value = ComConstant.CLSTR_ID_MAX_LENGTH, groups = { SearchValidation.class })
    private String containsClstrId;

    @Max(value = ComConstant.CLSTR_NM_MAX_LENGTH, groups = { SearchValidation.class })
    private String containsClstrNm;

    private String[] existsVrlzSwTyCdList;

    private String equalsRsrcPoolClCd;

    private boolean all = false;

    public String getEqualsRegionId() {
        return equalsRegionId;
    }

    public void setEqualsRegionId(String equalsRegionId) {
        this.equalsRegionId = equalsRegionId;
    }

    public String getEqualsZoneId() {
        return equalsZoneId;
    }

    public void setEqualsZoneId(String equalsZoneId) {
        this.equalsZoneId = equalsZoneId;
    }

    public String getEqualsNetId() {
        return equalsNetId;
    }

    public void setEqualsNetId(String equalsNetId) {
        this.equalsNetId = equalsNetId;
    }

    /**
	 * @return the equalsNetClCd
	 */
	public String getEqualsNetClCd() {
		return equalsNetClCd;
	}

	/**
	 * @param equalsNetClCd the equalsNetClCd to set
	 */
	public void setEqualsNetClCd(String equalsNetClCd) {
		this.equalsNetClCd = equalsNetClCd;
	}


    public String getEqualsRsrcPoolId() {
        return equalsRsrcPoolId;
    }

    public void setEqualsRsrcPoolId(String equalsRsrcPoolId) {
        this.equalsRsrcPoolId = equalsRsrcPoolId;
    }

    public String getEqualsUseYn() {
        return equalsUseYn;
    }

    public void setEqualsUseYn(String equalsUseYn) {
        this.equalsUseYn = equalsUseYn;
    }

    public String getEqualsDelYn() {
        return equalsDelYn;
    }

    public void setEqualsDelYn(String equalsDelYn) {
        this.equalsDelYn = equalsDelYn;
    }

    public String getContainsClstrId() {
        return containsClstrId;
    }

    public void setContainsClstrId(String containsClstrId) {
        this.containsClstrId = containsClstrId;
    }

    public String getContainsClstrNm() {
        return containsClstrNm;
    }

    public void setContainsClstrNm(String containsClstrNm) {
        this.containsClstrNm = containsClstrNm;
    }

    public String[] getExistsVrlzSwTyCdList() {
        if (null != this.existsVrlzSwTyCdList) {
            this.existsVrlzSwTyCdList = (existsVrlzSwTyCdList == null ? null : Arrays.copyOf(existsVrlzSwTyCdList, existsVrlzSwTyCdList.length));
            return this.existsVrlzSwTyCdList;
        }
        return null;
    }

    public void setExistsVrlzSwTyCdList(String[] existsVrlzSwTyCdList) {
        this.existsVrlzSwTyCdList = (existsVrlzSwTyCdList == null ? null : Arrays.copyOf(existsVrlzSwTyCdList, existsVrlzSwTyCdList.length));
    }

    public boolean isAll() {
        return all;
    }

    public void setAll(boolean all) {
        this.all = all;
    }

    public String getEqualsRsrcPoolClCd() {
        return equalsRsrcPoolClCd;
    }

    public void setEqualsRsrcPoolClCd(String equalsRsrcPoolClCd) {
        this.equalsRsrcPoolClCd = equalsRsrcPoolClCd;
    }

}
