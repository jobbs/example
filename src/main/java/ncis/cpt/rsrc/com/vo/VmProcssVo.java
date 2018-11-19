/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmProcssVo.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 11. 17.
 * @lastmodified 2016. 11. 17.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 17.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.vo;

/**
 * @author 최경철
 *
 */
public class VmProcssVo {

    /**
     * 프로세스인스턴스SEQ
     */
    private int procssInstSeq;

    /**
     * 프로세스SEQ
     */
    private int procssSeq;

    /**
     * 변수값
     */
    private String varVl;

    private String[] refJobIdList;

    /**
     * @return the refJobIdList
     */
    public String[] getRefJobIdList() {
        return refJobIdList;
    }

    /**
     * @param refJobIdList the refJobIdList to set
     */
    public void setRefJobIdList(String[] refJobIdList) {
        this.refJobIdList = refJobIdList;
    }

    /**
     * @return the procssInstSeq
     */
    public int getProcssInstSeq() {
        return procssInstSeq;
    }

    /**
     * @param procssInstSeq the procssInstSeq to set
     */
    public void setProcssInstSeq(int procssInstSeq) {
        this.procssInstSeq = procssInstSeq;
    }

    /**
     * @return the procssSeq
     */
    public int getProcssSeq() {
        return procssSeq;
    }

    /**
     * @param procssSeq the procssSeq to set
     */
    public void setProcssSeq(int procssSeq) {
        this.procssSeq = procssSeq;
    }

    /**
     * @return the varVl
     */
    public String getVarVl() {
        return varVl;
    }

    /**
     * @param varVl the varVl to set
     */
    public void setVarVl(String varVl) {
        this.varVl = varVl;
    }

}
