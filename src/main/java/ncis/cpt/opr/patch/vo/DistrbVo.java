/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DistrbVo.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 21.
 * @lastmodified 2016. 10. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 21.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.vo;

import java.util.List;

import ncis.cmn.entity.OaDistrb;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 이화영
 *
 */
public class DistrbVo extends OaDistrb {

	private String distrbReasnNm;
	private String vmCompId;
	private String distrbExeUserNm;
	private String atchFileSeq;
	private MultipartFile uploadFile;
	private List<VmPatchVo> distrVmList;
	private DistrbFileVo distrbFile;



	public String getDistrbReasnNm() {
		return distrbReasnNm;
	}
	public void setDistrbReasnNm(String distrbReasnNm) {
		this.distrbReasnNm = distrbReasnNm;
	}
	public String getVmCompId() {
		return vmCompId;
	}
	public void setVmCompId(String vmCompId) {
		this.vmCompId = vmCompId;
	}
	public String getDistrbExeUserNm() {
		return distrbExeUserNm;
	}
	public void setDistrbExeUserNm(String distrbExeUserNm) {
		this.distrbExeUserNm = distrbExeUserNm;
	}
	public String getAtchFileSeq() {
		return atchFileSeq;
	}
	public void setAtchFileSeq(String atchFileSeq) {
		this.atchFileSeq = atchFileSeq;
	}
	public List<VmPatchVo> getDistrVmList() {
		return distrVmList;
	}
	public void setDistrVmList(List<VmPatchVo> distrVmList) {
		this.distrVmList = distrVmList;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public DistrbFileVo getDistrbFile() {
		return distrbFile;
	}
	public void setDistrbFile(DistrbFileVo distrbFile) {
		this.distrbFile = distrbFile;
	}



}
