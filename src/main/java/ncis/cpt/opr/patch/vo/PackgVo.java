/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PackgVo.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.vo;

import java.sql.Timestamp;
import java.util.List;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 이화영
 *
 */
public class PackgVo extends VmPatchVo {

    private String packgSeq;
    private String repositNm;
    private String packgNm;
    private String packgCn;
    private String ver;
    private String release;
    private Timestamp regDttm;
    private String patchAlrmTyCd;
    private String trgPackgSeq;
    private String trgRelease;
    private String trgPackgNm;
    private String trgPackgVer;
    private String applcPackgSeq;
    private String applcRelease;
    private String applcPackgNm;
    private String applcPackgVer;
    private String patchAlrmCn;
    private List<PackgVo> vmInfoList;
    private List<PackgVo> vmChargerList;
    private List<PackgVo> jobChargerList;
    private String userId;
    private String relaterClCd;
    private String userClCd;

    @NotEmpty(message = "알림명을 입력하세요.")
    @Size(min = 1, max = 60)
    private String patchAlrmNm;

    public String getPackgSeq() {
        return packgSeq;
    }

    public void setPackgSeq(String packgSeq) {
        this.packgSeq = packgSeq;
    }

    public String getRepositNm() {
        return repositNm;
    }

    public void setRepositNm(String repositNm) {
        this.repositNm = repositNm;
    }

    public String getPackgNm() {
        return packgNm;
    }

    public void setPackgNm(String packgNm) {
        this.packgNm = packgNm;
    }

    public String getPackgCn() {
        return packgCn;
    }

    public void setPackgCn(String packgCn) {
        this.packgCn = packgCn;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public Timestamp getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(Timestamp regDttm) {
        this.regDttm = regDttm;
    }

    public String getPatchAlrmTyCd() {
        return patchAlrmTyCd;
    }

    public void setPatchAlrmTyCd(String patchAlrmTyCd) {
        this.patchAlrmTyCd = patchAlrmTyCd;
    }

    public String getTrgPackgNm() {
        return trgPackgNm;
    }

    public void setTrgPackgNm(String trgPackgNm) {
        this.trgPackgNm = trgPackgNm;
    }

    public String getTrgPackgVer() {
        return trgPackgVer;
    }

    public void setTrgPackgVer(String trgPackgVer) {
        this.trgPackgVer = trgPackgVer;
    }

    public String getApplcPackgSeq() {
        return applcPackgSeq;
    }

    public void setApplcPackgSeq(String applcPackgSeq) {
        this.applcPackgSeq = applcPackgSeq;
    }

    public String getApplcPackgNm() {
        return applcPackgNm;
    }

    public void setApplcPackgNm(String applcPackgNm) {
        this.applcPackgNm = applcPackgNm;
    }

    public String getApplcPackgVer() {
        return applcPackgVer;
    }

    public void setApplcPackgVer(String applcPackgVer) {
        this.applcPackgVer = applcPackgVer;
    }

    public String getPatchAlrmCn() {
        return patchAlrmCn;
    }

    public void setPatchAlrmCn(String patchAlrmCn) {
        this.patchAlrmCn = patchAlrmCn;
    }

    public String getPatchAlrmNm() {
        return patchAlrmNm;
    }

    public void setPatchAlrmNm(String patchAlrmNm) {
        this.patchAlrmNm = patchAlrmNm;
    }

    public String getTrgPackgSeq() {
        return trgPackgSeq;
    }

    public void setTrgPackgSeq(String trgPackgSeq) {
        this.trgPackgSeq = trgPackgSeq;
    }

    public String getTrgRelease() {
        return trgRelease;
    }

    public void setTrgRelease(String trgRelease) {
        this.trgRelease = trgRelease;
    }

    public String getApplcRelease() {
        return applcRelease;
    }

    public void setApplcRelease(String applcRelease) {
        this.applcRelease = applcRelease;
    }

    public List<PackgVo> getVmInfoList() {
        return vmInfoList;
    }

    public void setVmInfoList(List<PackgVo> vmInfoList) {
        this.vmInfoList = vmInfoList;
    }

    public List<PackgVo> getVmChargerList() {
        return vmChargerList;
    }

    public void setVmChargerList(List<PackgVo> vmChargerList) {
        this.vmChargerList = vmChargerList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRelaterClCd() {
        return relaterClCd;
    }

    public void setRelaterClCd(String relaterClCd) {
        this.relaterClCd = relaterClCd;
    }

	public List<PackgVo> getJobChargerList() {
		return jobChargerList;
	}

	public void setJobChargerList(List<PackgVo> jobChargerList) {
		this.jobChargerList = jobChargerList;
	}

	public String getUserClCd() {
		return userClCd;
	}

	public void setUserClCd(String userClCd) {
		this.userClCd = userClCd;
	}


}
