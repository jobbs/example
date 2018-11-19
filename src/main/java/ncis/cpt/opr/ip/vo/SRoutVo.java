/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SRoutVo.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 9. 27.
 * @lastmodified 2016. 9. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 27.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.vo;

import java.math.BigDecimal;
import java.util.List;
import ncis.cmn.entity.RnSRout;

/**
 * @author 신재훈
 *
 */
public class SRoutVo extends RnSRout {
    private BigDecimal ipBndSeq;
    private List<SRoutVo> sRoutList;

    public List<SRoutVo> getsRoutList() {
        return sRoutList;
    }

    public void setsRoutList(List<SRoutVo> sRoutList) {
        this.sRoutList = sRoutList;
    }

    @Override
    public String toString() {
        return "SRoutVo [ipBndSeq=" + ipBndSeq + ", sRoutList=" + sRoutList + ", getsRoutSeq()=" + getsRoutSeq() + ", getIpBndAddr()=" + getIpBndAddr() + ", getSubnetMask()=" + getSubnetMask() + ", getGtwyNm()=" + getGtwyNm() + ", getBndSeq()=" + getBndSeq() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    public BigDecimal getIpBndSeq() {
        return ipBndSeq;
    }

    public void setIpBndSeq(BigDecimal ipBndSeq) {
        this.ipBndSeq = ipBndSeq;
    }

}
