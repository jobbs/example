/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmSnapHistVo.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 27.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 27.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.vo;

import ncis.cmn.entity.RrVmWrkHist;

/**
 * @author 최경철
 *
 */
public class VmSnapHistVo extends RrVmWrkHist {

    // 작업자명
    private String wrkNm;
    // 작업자 이메일
    private String wrkEmail;
    // 작업자 전화번호
    private String wrkPhone;
    // 이력구분명
    private String cdNm;
    // 상세정보
    private String detailInfo;

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    public String getCdNm() {
        return cdNm;
    }

    public void setCdNm(String cdNm) {
        this.cdNm = cdNm;
    }

    public String getWrkNm() {
        return wrkNm;
    }

    public void setWrkNm(String wrkNm) {
        this.wrkNm = wrkNm;
    }

    public String getWrkEmail() {
        return wrkEmail;
    }

    public void setWrkEmail(String wrkEmail) {
        this.wrkEmail = wrkEmail;
    }

    public String getWrkPhone() {
        return wrkPhone;
    }

    public void setWrkPhone(String wrkPhone) {
        this.wrkPhone = wrkPhone;
    }
}
