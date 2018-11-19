package ncis.cmn.entity;

import java.util.Date;

public class CmMenuRole {

    private Long menuSeq;

    private String roleCd;

    private String readYn;

    private String writeYn;

    private String actYn;

    private Date regDttm;

    private String regUserId;

    private Date updtDttm;

    private String updtUserId;

    /**
     * @return the menuSeq
     */
    public Long getMenuSeq() {
        return menuSeq;
    }

    /**
     * @param menuSeq the menuSeq to set
     */
    public void setMenuSeq(Long menuSeq) {
        this.menuSeq = menuSeq;
    }

    /**
     * @return the roleCd
     */
    public String getRoleCd() {
        return roleCd;
    }

    /**
     * @param roleCd the roleCd to set
     */
    public void setRoleCd(String roleCd) {
        this.roleCd = roleCd;
    }

    /**
     * @return the readYn
     */
    public String getReadYn() {
        return readYn;
    }

    /**
     * @param readYn the readYn to set
     */
    public void setReadYn(String readYn) {
        this.readYn = readYn;
    }

    /**
     * @return the writeYn
     */
    public String getWriteYn() {
        return writeYn;
    }

    /**
     * @param writeYn the writeYn to set
     */
    public void setWriteYn(String writeYn) {
        this.writeYn = writeYn;
    }

    /**
     * @return the actYn
     */
    public String getActYn() {
        return actYn;
    }

    /**
     * @param actYn the actYn to set
     */
    public void setActYn(String actYn) {
        this.actYn = actYn;
    }

    /**
     * @return the regDttm
     */
    public Date getRegDttm() {
        return regDttm;
    }

    /**
     * @param regDttm the regDttm to set
     */
    public void setRegDttm(Date regDttm) {
        this.regDttm = regDttm;
    }

    /**
     * @return the regUserId
     */
    public String getRegUserId() {
        return regUserId;
    }

    /**
     * @param regUserId the regUserId to set
     */
    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    /**
     * @return the updtDttm
     */
    public Date getUpdtDttm() {
        return updtDttm;
    }

    /**
     * @param updtDttm the updtDttm to set
     */
    public void setUpdtDttm(Date updtDttm) {
        this.updtDttm = updtDttm;
    }

    /**
     * @return the updtUserId
     */
    public String getUpdtUserId() {
        return updtUserId;
    }

    /**
     * @param updtUserId the updtUserId to set
     */
    public void setUpdtUserId(String updtUserId) {
        this.updtUserId = updtUserId;
    }



}
