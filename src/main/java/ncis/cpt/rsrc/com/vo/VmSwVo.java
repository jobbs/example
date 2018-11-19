/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmSwVo.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 11. 28.
 * @lastmodified 2016. 11. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 28.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.vo;

import java.util.Date;

/**
 * @author 심원보
 *
 */
public class VmSwVo {

    private String vmCompId;
    private String swCompId;
    private String swNm;
    private String instlVer;
    private String patchVer;
    private Date instlDt;

    public String getVmCompId() {
        return vmCompId;
    }

    public void setVmCompId(String vmCompId) {
        this.vmCompId = vmCompId;
    }

    public String getSwCompId() {
        return swCompId;
    }

    public void setSwCompId(String swCompId) {
        this.swCompId = swCompId;
    }

    public String getSwNm() {
        return swNm;
    }

    public void setSwNm(String swNm) {
        this.swNm = swNm;
    }

    public String getInstlVer() {
        return instlVer;
    }

    public void setInstlVer(String instlVer) {
        this.instlVer = instlVer;
    }

    public String getPatchVer() {
        return patchVer;
    }

    public void setPatchVer(String patchVer) {
        this.patchVer = patchVer;
    }

    public Date getInstlDt() {
        return instlDt;
    }

    public void setInstlDt(Date instlDt) {
        this.instlDt = instlDt;
    }

}
