package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 사용자정보변경이력 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class SiUserChngHist {

    /**
     * 변경일시
     */
    @NotEmpty(message = "변경일시는(은) 필수입력 항목입니다.")
    private String chngDttm;

    /**
     * 사용자ID
     */
    @NotEmpty(message = "사용자ID는(은) 필수입력 항목입니다.")
    private String userId;

    /**
     * 사용자명
     */
    private String userNm;

    /**
     * 사용자구분코드(1)
     */
    private String userClCd;

    /**
     * 사용자구분명
     */
    private String userClNm;

    /**
     * 기관ID
     */
    private String institutionId;

    /**
     * 기관명
     */
    private String institutionNm;

    /**
     * 조직ID
     */
    private String orgnztId;

    /**
     * 조직명
     */
    private String orgnztNm;

    /**
     * 관리리전구분코드
     */
    private String mngRegionClCd;

    /**
     * 직위명
     */
    private String ofcpsName;

    /**
     * 시스템권한유형ID
     */
    private String sysAuthrTyId;

    /**
     * 비밀번호
     */
    private String passwd;

    /**
     * 전화번호
     */
    private String telno;

    /**
     * 내선번호
     */
    private String lxtnNo;

    /**
     * 팩스번호
     */
    private String faxNo;

    /**
     * 자택전화번호
     */
    private String ownhomTelNo;

    /**
     * 휴대폰번호
     */
    private String mobile;

    /**
     * 이메일주소
     */
    private String email;

    /**
     * 부재여부
     */
    private String absnceYn;

    /**
     * 부재사용자ID
     */
    private String absnceId;

    /**
     * 부재시작일자
     */
    private String absnceBeginDt;

    /**
     * 부재종료일자
     */
    private String absnceEndDt;

    /**
     * 최근로그인일시
     */
    private String rcntLoginDt;

    /**
     * 인증서키값
     */
    private String crtfctKey;

    /**
     * 통합접속구분코드
     */
    private String unityConnectTyCd;

    /**
     * 등록일자
     */
    private String regDt;

    /**
     * 직위ID
     */
    private String ofcpsId;

    public String getChngDttm() {
        return chngDttm;
    }

    public void setChngDttm(String chngDttm) {
        this.chngDttm = chngDttm;
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

    public String getUserClCd() {
        return userClCd;
    }

    public void setUserClCd(String userClCd) {
        this.userClCd = userClCd;
    }

    public String getUserClNm() {
        return userClNm;
    }

    public void setUserClNm(String userClNm) {
        this.userClNm = userClNm;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionNm() {
        return institutionNm;
    }

    public void setInstitutionNm(String institutionNm) {
        this.institutionNm = institutionNm;
    }

    public String getOrgnztId() {
        return orgnztId;
    }

    public void setOrgnztId(String orgnztId) {
        this.orgnztId = orgnztId;
    }

    public String getOrgnztNm() {
        return orgnztNm;
    }

    public void setOrgnztNm(String orgnztNm) {
        this.orgnztNm = orgnztNm;
    }

    public String getMngRegionClCd() {
        return mngRegionClCd;
    }

    public void setMngRegionClCd(String mngRegionClCd) {
        this.mngRegionClCd = mngRegionClCd;
    }

    public String getOfcpsName() {
        return ofcpsName;
    }

    public void setOfcpsName(String ofcpsName) {
        this.ofcpsName = ofcpsName;
    }

    public String getSysAuthrTyId() {
        return sysAuthrTyId;
    }

    public void setSysAuthrTyId(String sysAuthrTyId) {
        this.sysAuthrTyId = sysAuthrTyId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getLxtnNo() {
        return lxtnNo;
    }

    public void setLxtnNo(String lxtnNo) {
        this.lxtnNo = lxtnNo;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getOwnhomTelNo() {
        return ownhomTelNo;
    }

    public void setOwnhomTelNo(String ownhomTelNo) {
        this.ownhomTelNo = ownhomTelNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbsnceYn() {
        return absnceYn;
    }

    public void setAbsnceYn(String absnceYn) {
        this.absnceYn = absnceYn;
    }

    public String getAbsnceId() {
        return absnceId;
    }

    public void setAbsnceId(String absnceId) {
        this.absnceId = absnceId;
    }

    public String getAbsnceBeginDt() {
        return absnceBeginDt;
    }

    public void setAbsnceBeginDt(String absnceBeginDt) {
        this.absnceBeginDt = absnceBeginDt;
    }

    public String getAbsnceEndDt() {
        return absnceEndDt;
    }

    public void setAbsnceEndDt(String absnceEndDt) {
        this.absnceEndDt = absnceEndDt;
    }

    public String getRcntLoginDt() {
        return rcntLoginDt;
    }

    public void setRcntLoginDt(String rcntLoginDt) {
        this.rcntLoginDt = rcntLoginDt;
    }

    public String getCrtfctKey() {
        return crtfctKey;
    }

    public void setCrtfctKey(String crtfctKey) {
        this.crtfctKey = crtfctKey;
    }

    public String getUnityConnectTyCd() {
        return unityConnectTyCd;
    }

    public void setUnityConnectTyCd(String unityConnectTyCd) {
        this.unityConnectTyCd = unityConnectTyCd;
    }

    public String getRegDt() {
        return regDt;
    }

    public void setRegDt(String regDt) {
        this.regDt = regDt;
    }

    public String getOfcpsId() {
        return ofcpsId;
    }

    public void setOfcpsId(String ofcpsId) {
        this.ofcpsId = ofcpsId;
    }

}
