package ncis.cmn.entity;


public class CmUserWrkHist {

    /**
     * 작업이력 순번
     */
    private Long wrkHistSeq;
    /**
     * 메뉴아이디
     */
    private Long menuSeq;
    /**
     * 메뉴명
     */
    private String menuNm;
    /**
     * 작업 행위명
     */
    private String wrkInfo;
    /**
     * 작업행위 설명
     */
    private String wrkDc;
    /**
     * 적용된 파라메타 정보
     */
    private String wrkParam;
    /**
     * 작업타입
     */
    private String wrkTy;
    /**
     * 작업자 아이디
     */
    private String userId;
    /**
     * 작업자 명
     */
    private String userNm;
    /**
     * 접속아이피
     */
    private String wrkIP;
    /**
     * 작업일자
     */
    private String wrkDttm;

    /**
     * @return the wrkHistSeq
     */
    public Long getWrkHistSeq() {
        return wrkHistSeq;
    }
    /**
     * @param wrkHistSeq the wrkHistSeq to set
     */
    public void setWrkHistSeq(Long wrkHistSeq) {
        this.wrkHistSeq = wrkHistSeq;
    }
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
     * @return the menuNm
     */
    public String getMenuNm() {
        return menuNm;
    }
    /**
     * @param menuNm the menuNm to set
     */
    public void setMenuNm(String menuNm) {
        this.menuNm = menuNm;
    }
    /**
     * @return the wrkInfo
     */
    public String getWrkInfo() {
        return wrkInfo;
    }
    /**
     * @param wrkInfo the wrkInfo to set
     */
    public void setWrkInfo(String wrkInfo) {
        this.wrkInfo = wrkInfo;
    }
    /**
     * @return the wrkDesc
     */
    public String getWrkDc() {
        return wrkDc;
    }
    /**
     * @param wrkDesc the wrkDesc to set
     */
    public void setWrkDc(String wrkDc) {
        this.wrkDc = wrkDc;
    }
    /**
     * @return the wrkParam
     */
    public String getWrkParam() {
        return wrkParam;
    }
    /**
     * @param wrkParam the wrkParam to set
     */
    public void setWrkParam(String wrkParam) {
        this.wrkParam = wrkParam;
    }
    /**
     * @return the wrkTy
     */
    public String getWrkTy() {
        return wrkTy;
    }
    /**
     * @param wrkTy the wrkTy to set
     */
    public void setWrkTy(String wrkTy) {
        this.wrkTy = wrkTy;
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
     * @return the userNm
     */
    public String getUserNm() {
        return userNm;
    }
    /**
     * @param userNm the userNm to set
     */
    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }
    /**
     * @return the wrkIP
     */
    public String getWrkIP() {
        return wrkIP;
    }
    /**
     * @param wrkIP the wrkIP to set
     */
    public void setWrkIP(String wrkIP) {
        this.wrkIP = wrkIP;
    }
    /**
     * @return the wrkDttm
     */
    public String getWrkDttm() {
        return wrkDttm;
    }
    /**
     * @param wrkDttm the wrkDttm to set
     */
    public void setWrkDttm(String wrkDttm) {
        this.wrkDttm = wrkDttm;
    }



}
