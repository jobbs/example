/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ErrRptVo.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 31.
 * @lastmodified 2016. 10. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 31.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.errrpt.vo;

import java.util.List;
import ncis.cmn.entity.ZErrRpt;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 최진호
 *
 */
public class ErrRptVo extends ZErrRpt {

    private String errCateNm;

    private String errTyNm;

    private String chargeNm;

    private String procssStatNm;

    private String regUsrNm;

    private List<ErrRptProcssVo> errRptRpocsses;

    private MultipartFile[] uploadFile;

    private List<ErrRptFileVo> errRptFiles;

    private List<Long> deleteFile;

    /**
     * @return the errRptRpocsses
     */
    public List<ErrRptProcssVo> getErrRptRpocsses() {
        return errRptRpocsses;
    }

    /**
     * @param errRptRpocsses the errRptRpocsses to set
     */
    public void setErrRptRpocsses(List<ErrRptProcssVo> errRptRpocsses) {
        this.errRptRpocsses = errRptRpocsses;
    }

    /**
     * @return the uploadFile
     */
    public MultipartFile[] getUploadFile() {
        if( null != this.uploadFile ) {
            return this.uploadFile.clone();
        }
        return null;
    }

    /**
     * @param uploadFile the uploadFile to set
     */
    public void setUploadFile(MultipartFile[] uploadFile) {
        this.uploadFile = uploadFile.clone();
    }

    /**
     * @return the errRptFiles
     */
    public List<ErrRptFileVo> getErrRptFiles() {
        return errRptFiles;
    }

    /**
     * @param errRptFiles the errRptFiles to set
     */
    public void setErrRptFiles(List<ErrRptFileVo> errRptFiles) {
        this.errRptFiles = errRptFiles;
    }

    /**
     * @return the errCateNm
     */
    public String getErrCateNm() {
        return errCateNm;
    }

    /**
     * @param errCateNm the errCateNm to set
     */
    public void setErrCateNm(String errCateNm) {
        this.errCateNm = errCateNm;
    }

    /**
     * @return the errTyNm
     */
    public String getErrTyNm() {
        return errTyNm;
    }

    /**
     * @param errTyNm the errTyNm to set
     */
    public void setErrTyNm(String errTyNm) {
        this.errTyNm = errTyNm;
    }

    /**
     * @return the chargeNm
     */
    public String getChargeNm() {
        return chargeNm;
    }

    /**
     * @param chargeNm the chargeNm to set
     */
    public void setChargeNm(String chargeNm) {
        this.chargeNm = chargeNm;
    }

    /**
     * @return the procssStatNm
     */
    public String getProcssStatNm() {
        return procssStatNm;
    }

    /**
     * @param procssStatNm the procssStatNm to set
     */
    public void setProcssStatNm(String procssStatNm) {
        this.procssStatNm = procssStatNm;
    }

    /**
     * @return the regUsrNm
     */
    public String getRegUsrNm() {
        return regUsrNm;
    }

    /**
     * @param regUsrNm the regUsrNm to set
     */
    public void setRegUsrNm(String regUsrNm) {
        this.regUsrNm = regUsrNm;
    }

    /**
     * @return the deleteFile
     */
    public List<Long> getDeleteFile() {
        return deleteFile;
    }

    /**
     * @param deleteFile the deleteFile to set
     */
    public void setDeleteFile(List<Long> deleteFile) {
        this.deleteFile = deleteFile;
    }

}
