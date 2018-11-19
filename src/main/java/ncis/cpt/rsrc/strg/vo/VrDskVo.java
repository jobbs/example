/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VrDiskVo.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 27.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 27.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.vo;

import ncis.cmn.entity.RsVrDsk;

/**
 * @author 신재훈, 심원보
 *
 */
public class VrDskVo extends RsVrDsk {

    private String vmInstlLoca; // 할당된 VM명
    private String strgDmnNm; // 가상 스토리지도메인명
    private String strgDmnUuid; // 가상 스토리지도메인UUID
    private String prposNm; // 가상디스크 용도이름

    public String getVmInstlLoca() {
        return vmInstlLoca;
    }

    public void setVmInstlLoca(String vmInstlLoca) {
        this.vmInstlLoca = vmInstlLoca;
    }

    public String getStrgDmnNm() {
        return strgDmnNm;
    }

    public void setStrgDmnNm(String strgDmnNm) {
        this.strgDmnNm = strgDmnNm;
    }

    public String getPrposNm() {
        return prposNm;
    }

    public void setPrposNm(String prposNm) {
        this.prposNm = prposNm;
    }

	public String getStrgDmnUuid() {
		return strgDmnUuid;
	}

	public void setStrgDmnUuid(String strgDmnUuid) {
		this.strgDmnUuid = strgDmnUuid;
	}

}
