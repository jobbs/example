/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserVo.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.user.vo;

import java.util.Date;
import java.util.List;
import ncis.cmn.entity.CmUsr;
import ncis.cmn.util.DateUtil;
import ncis.cpt.rsrc.pool.vo.RsrcPoolVo;

public class UserVo extends CmUsr {

	/**
	 * ncms최근 접속일시 및 패턴 변경 변수
	 */
    private Date ncmsRcntLoginDttm;

    /**
     * 관리센터명
     */
    private String mngRegionNm;

    /**
     * 목록에서 사용할 롤 명
     */
    private String roleNm;

    private String signedMsg;

    private String orgMsg;

	/**
	 * 사용자 권한 목록
	 */
	private List<UserRoleVo> userRoles;

	private List<UserJobVo> userJobs;

	private List<RsrcPoolVo> userPools;

	private List<UserInsttVo> userInstts;

	/**
	 * @return the userRoles
	 */
	public List<UserRoleVo> getUserRoles() {
		return userRoles;
	}

	/**
	 * @param userRoles the userRoles to set
	 */
	public void setUserRoles(List<UserRoleVo> userRoles) {
		this.userRoles = userRoles;
	}

    /**
     * @return the ncmsRcntLoginDttm
     */
    public Date getNcmsRcntLoginDttm() {
        return ncmsRcntLoginDttm;
    }

    /**
     * @param ncmsRcntLoginDttm the ncmsRcntLoginDttm to set
     */
    public void setNcmsRcntLoginDttm(Date ncmsRcntLoginDttm) {
        this.ncmsRcntLoginDttm = ncmsRcntLoginDttm;
    }

    /**
     * @return the userJobs
     */
    public List<UserJobVo> getUserJobs() {
        return userJobs;
    }

    /**
     * @param userJobs the userJobs to set
     */
    public void setUserJobs(List<UserJobVo> userJobs) {
        this.userJobs = userJobs;
    }

    /**
     * @return the userPool
     */
    public List<RsrcPoolVo> getUserPools() {
        return userPools;
    }

    /**
     * @param userPool the userPool to set
     */
    public void setUserPools(List<RsrcPoolVo> userPools) {
        this.userPools = userPools;
    }

    /**
     * @return the roleNm
     */
    public String getRoleNm() {
        return roleNm;
    }

    /**
     * @param roleNm the roleNm to set
     */
    public void setRoleNm(String roleNm) {
        this.roleNm = roleNm;
    }

    /**
     * @return the signedMsg
     */
    public String getSignedMsg() {
        return signedMsg;
    }

    /**
     * @param signedMsg the signedMsg to set
     */
    public void setSignedMsg(String signedMsg) {
        this.signedMsg = signedMsg;
    }

    /**
     * @return the orgMsg
     */
    public String getOrgMsg() {
        return orgMsg;
    }

    /**
     * @param orgMsg the orgMsg to set
     */
    public void setOrgMsg(String orgMsg) {
        this.orgMsg = orgMsg;
    }

	/**
	 * @return the rcntLoginDttmPattern
	 */
	public String getRcntLoginDttmPattern() {
		return DateUtil.dateToString( getRcntLoginDttm(), "yyyy-MM-dd HH:mm");
	}

	/**
	 * @return the ncmsRcntLoginDttmPattern
	 */
	public String getNcmsRcntLoginDttmPattern() {
		return DateUtil.dateToString( getNcmsRcntLoginDttm(), "yyyy-MM-dd HH:mm");
	}

	/**
	 * @return the userInstts
	 */
	public List<UserInsttVo> getUserInstts() {
		return userInstts;
	}

	/**
	 * @param userInstts the userInstts to set
	 */
	public void setUserInstts(List<UserInsttVo> userInstts) {
		this.userInstts = userInstts;
	}

	/**
	 * @return the mngRegionNm
	 */
	public String getMngRegionNm() {
		return mngRegionNm;
	}

	/**
	 * @param mngRegionNm the mngRegionNm to set
	 */
	public void setMngRegionNm(String mngRegionNm) {
		this.mngRegionNm = mngRegionNm;
	}
}
