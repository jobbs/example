package ncis.cmn.entity;

import java.util.Date;

public class UserConnRec {

    /**
     * 좁속이력 시퀀스
     */
    private Long connectSeq;

    /**
     * 접근자아이디
     */
    private String userId;

    /**
     * 접근자명
     */
    private String userName;

    /**
     * 접근일자
     */
    private Date connectDate;

    /**
     * 접근 아이피
     */
    private String connectIp;

    /**
     * @return the connectSeq
     */
    public Long getConnectSeq() {
        return connectSeq;
    }

    /**
     * @param connectSeq the connectSeq to set
     */
    public void setConnectSeq(Long connectSeq) {
        this.connectSeq = connectSeq;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the connectDate
     */
    public Date getConnectDate() {
        return connectDate;
    }

    /**
     * @param connectDate the connectDate to set
     */
    public void setConnectDate(Date connectDate) {
        this.connectDate = connectDate;
    }

    /**
     * @return the connectIp
     */
    public String getConnectIp() {
        return connectIp;
    }

    /**
     * @param connectIp the connectIp to set
     */
    public void setConnectIp(String connectIp) {
        this.connectIp = connectIp;
    }

}
