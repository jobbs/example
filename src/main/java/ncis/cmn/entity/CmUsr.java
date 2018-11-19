/**
 *
 */
package ncis.cmn.entity;

import java.util.Date;

import javax.validation.constraints.Size;

import ncis.cmn.validation.groups.InsertProc;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author kamsi76
 *
 */
public class CmUsr {


    @NotEmpty(message="사용자ID을 입력하세요.")
    @Size(max=30,message="사용자ID은 최대 30자까지 허용합니다.")
    private String userId;  /* 사용자ID */

    @NotEmpty(message="비밀번호를 입력하세요.", groups={ InsertProc.class })
    @Size(max=200,message="비밀번호는 최대 200자까지 허용합니다.")
    private String passwd;  /* 비밀번호 */

    @NotEmpty(message="이름을 입력하세요.")
    @Size(max=30,message="이름은 최대 30자까지 허용합니다.")
    private String userNm;  /* 이름 */

    private String userClCd;  /* 사용자구분코드 */

    private String userClNm;  /* 사용자구분명 */

    private String institutionId;  /* 기관ID */

    private String institutionNm;  /* 기관명 */

    private String orgnztId;  /* 조직ID */

    private String orgnztNm;  /* 조직명 */

    private String mngRegionId;  /* 관리리전ID */

    private String ofcpsId;  /* 직위ID */

    private String ofcpsNm;  /* 직위명 */

    private String sysAuthrTyId;  /* 시스템권한유형ID */

    private String telno;  /* 전화 */

    private String lxtnNo;  /* 내선번호 */

    private String faxNo;  /* 팩스번호 */

    private String ownhomTelNo;  /* 자택전화번호 */

    private String mobile;  /* 핸드폰 */

    @NotEmpty(message="이메일을 입력하세요.")
    @Size(max=30,message="이메일은 최대 200자까지 허용합니다.")
    private String email;  /* 이메일 */

    private String userStat;  /* 회원상태 */

    private String absnceYn;  /* 부재여부 */

    private String absnceId;  /* 부재사용자ID */

    private String absnceBeginDt;  /* 부재시작일자 */

    private String absnceEndDt;  /* 부재종료일자 */

    private Date rcntLoginDttm;  /* 최근로그인일시 */

    private String crtfctKey;  /* 인증서키값 */

    private String unityConnectTyCd;  /* 통합접속구분코드 */

    private Date regDttm;  /* 가입일자 */

    private Date updtDttm;  /* 수정일자 */

    private String updtUserId;  /* 수정자 */

    private String sysInptYn;  /* 시스템 입력여부 */

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
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
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
     * @return the userClCd
     */
    public String getUserClCd() {
        return userClCd;
    }

    /**
     * @param userClCd the userClCd to set
     */
    public void setUserClCd(String userClCd) {
        this.userClCd = userClCd;
    }

    /**
     * @return the userClNm
     */
    public String getUserClNm() {
        return userClNm;
    }

    /**
     * @param userClNm the userClNm to set
     */
    public void setUserClNm(String userClNm) {
        this.userClNm = userClNm;
    }

    /**
     * @return the institutionId
     */
    public String getInstitutionId() {
        return institutionId;
    }

    /**
     * @param institutionId the institutionId to set
     */
    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    /**
     * @return the institutionNm
     */
    public String getInstitutionNm() {
        return institutionNm;
    }

    /**
     * @param institutionNm the institutionNm to set
     */
    public void setInstitutionNm(String institutionNm) {
        this.institutionNm = institutionNm;
    }

    /**
     * @return the orgnztId
     */
    public String getOrgnztId() {
        return orgnztId;
    }

    /**
     * @param orgnztId the orgnztId to set
     */
    public void setOrgnztId(String orgnztId) {
        this.orgnztId = orgnztId;
    }

    /**
     * @return the orgnztNm
     */
    public String getOrgnztNm() {
        return orgnztNm;
    }

    /**
     * @param orgnztNm the orgnztNm to set
     */
    public void setOrgnztNm(String orgnztNm) {
        this.orgnztNm = orgnztNm;
    }

    /**
     * @return the mngRegionId
     */
    public String getMngRegionId() {
        return mngRegionId;
    }

    /**
     * @param mngRegionId the mngRegionId to set
     */
    public void setMngRegionId(String mngRegionId) {
        this.mngRegionId = mngRegionId;
    }

    /**
     * @return the ofcpsId
     */
    public String getOfcpsId() {
        return ofcpsId;
    }

    /**
     * @param ofcpsId the ofcpsId to set
     */
    public void setOfcpsId(String ofcpsId) {
        this.ofcpsId = ofcpsId;
    }

    /**
     * @return the ofcpsName
     */
    public String getOfcpsNm() {
        return ofcpsNm;
    }

    /**
     * @param ofcpsName the ofcpsName to set
     */
    public void setOfcpsNm(String ofcpsNm) {
        this.ofcpsNm = ofcpsNm;
    }

    /**
     * @return the sysAuthrTyId
     */
    public String getSysAuthrTyId() {
        return sysAuthrTyId;
    }

    /**
     * @param sysAuthrTyId the sysAuthrTyId to set
     */
    public void setSysAuthrTyId(String sysAuthrTyId) {
        this.sysAuthrTyId = sysAuthrTyId;
    }

    /**
     * @return the telno
     */
    public String getTelno() {
        return telno;
    }

    /**
     * @param telno the telno to set
     */
    public void setTelno(String telno) {
        this.telno = telno;
    }

    /**
     * @return the lxtnNo
     */
    public String getLxtnNo() {
        return lxtnNo;
    }

    /**
     * @param lxtnNo the lxtnNo to set
     */
    public void setLxtnNo(String lxtnNo) {
        this.lxtnNo = lxtnNo;
    }

    /**
     * @return the faxNo
     */
    public String getFaxNo() {
        return faxNo;
    }

    /**
     * @param faxNo the faxNo to set
     */
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    /**
     * @return the ownhomTelNo
     */
    public String getOwnhomTelNo() {
        return ownhomTelNo;
    }

    /**
     * @param ownhomTelNo the ownhomTelNo to set
     */
    public void setOwnhomTelNo(String ownhomTelNo) {
        this.ownhomTelNo = ownhomTelNo;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the userStat
     */
    public String getUserStat() {
        return userStat;
    }

    /**
     * @param userStat the userStat to set
     */
    public void setUserStat(String userStat) {
        this.userStat = userStat;
    }

    /**
     * @return the absnceYn
     */
    public String getAbsnceYn() {
        return absnceYn;
    }

    /**
     * @param absnceYn the absnceYn to set
     */
    public void setAbsnceYn(String absnceYn) {
        this.absnceYn = absnceYn;
    }

    /**
     * @return the absnceId
     */
    public String getAbsnceId() {
        return absnceId;
    }

    /**
     * @param absnceId the absnceId to set
     */
    public void setAbsnceId(String absnceId) {
        this.absnceId = absnceId;
    }

    /**
     * @return the absnceBeginDt
     */
    public String getAbsnceBeginDt() {
        return absnceBeginDt;
    }

    /**
     * @param absnceBeginDt the absnceBeginDt to set
     */
    public void setAbsnceBeginDt(String absnceBeginDt) {
        this.absnceBeginDt = absnceBeginDt;
    }

    /**
     * @return the absnceEndDt
     */
    public String getAbsnceEndDt() {
        return absnceEndDt;
    }

    /**
     * @param absnceEndDt the absnceEndDt to set
     */
    public void setAbsnceEndDt(String absnceEndDt) {
        this.absnceEndDt = absnceEndDt;
    }

    /**
     * @return the rcntLoginDt
     */
    public Date getRcntLoginDttm() {
        return rcntLoginDttm;
    }

    /**
     * @param rcntLoginDt the rcntLoginDt to set
     */
    public void setRcntLoginDttm(Date rcntLoginDttm) {
        this.rcntLoginDttm = rcntLoginDttm;
    }

    /**
     * @return the crtfctKey
     */
    public String getCrtfctKey() {
        return crtfctKey;
    }

    /**
     * @param crtfctKey the crtfctKey to set
     */
    public void setCrtfctKey(String crtfctKey) {
        this.crtfctKey = crtfctKey;
    }

    /**
     * @return the unityConnectTyCd
     */
    public String getUnityConnectTyCd() {
        return unityConnectTyCd;
    }

    /**
     * @param unityConnectTyCd the unityConnectTyCd to set
     */
    public void setUnityConnectTyCd(String unityConnectTyCd) {
        this.unityConnectTyCd = unityConnectTyCd;
    }

    /**
     * @return the regDt
     */
    public Date getRegDttm() {
        return regDttm;
    }

    /**
     * @param regDt the regDt to set
     */
    public void setRegDt(Date regDttm) {
        this.regDttm = regDttm;
    }

    /**
     * @return the updtDt
     */
    public Date getUpdtDttm() {
        return updtDttm;
    }

    /**
     * @param updtDt the updtDt to set
     */
    public void setUpdtDt(Date updtDttm) {
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

	/**
	 * @return the sysInptYn
	 */
	public String getSysInptYn() {
		return sysInptYn;
	}

	/**
	 * @param sysInptYn the sysInptYn to set
	 */
	public void setSysInptYn(String sysInptYn) {
		this.sysInptYn = sysInptYn;
	}


}
