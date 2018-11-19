package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 사용자접속이력 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class CmUsrConnHist {

    /**
     * 접속이력SEQ
     */
    @NotEmpty(message = "접속이력SEQ는(은) 필수입력 항목입니다.")
    private Long connHistSeq;

    /**
     * 사용자ID
     */
    @NotEmpty(message = "사용자ID는(은) 필수입력 항목입니다.")
    private String userId;

    /**
     * 회원명
     */
    private String userNm;

    /**
     * 접속일시
     */
    private String connDt;

    /**
     * 접속IP
     */
    private String connIp;

    public Long getConnHistSeq() {
        return connHistSeq;
    }

    public void setConnHistSeq(Long connHistSeq) {
        this.connHistSeq = connHistSeq;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public String getConnDt() {
        return connDt;
    }

    public void setConnDt(String connDt) {
        this.connDt = connDt;
    }

    public String getConnIp() {
        return connIp;
    }

    public void setConnIp(String connIp) {
        this.connIp = connIp;
    }

}
