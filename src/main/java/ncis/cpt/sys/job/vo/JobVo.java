/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename JobVo.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 6.
 * @lastmodified 2016. 10. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 6.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.job.vo;

import ncis.cmn.entity.CmJob;
import ncis.cpt.sys.instt.vo.InsttVo;

/**
 * @author 최진호
 *
 */
public class JobVo extends CmJob {

    private InsttVo institution;

    private String regionNm;

    private String vmAsgnYn;

    private String vmCnt;

    private String atmsclAsgnYn;

    public String getInstitutionNm() {
    	return institution.getInstitutionNm();
    }

    public void setRegionNm(String regionNm) {
        this.regionNm = regionNm;
    }

    public String getRegionNm() {
    	return regionNm;
    }

    /**
	 * @return the vmAsgnYn
	 */
	public String getVmAsgnYn() {
		return vmAsgnYn;
	}

	/**
	 * @param vmAsgnYn the vmAsgnYn to set
	 */
	public void setVmAsgnYn(String vmAsgnYn) {
		this.vmAsgnYn = vmAsgnYn;
	}

	/**
	 * @return the vmCnt
	 */
	public String getVmCnt() {
		return vmCnt;
	}

	/**
	 * @param vmCnt the vmCnt to set
	 */
	public void setVmCnt(String vmCnt) {
		this.vmCnt = vmCnt;
	}

	/**
     * @return the institution
     */
    public InsttVo getInstitution() {
        return institution;
    }

    /**
     * @param institution the institution to set
     */
    public void setInstitution(InsttVo institution) {
        this.institution = institution;
    }

	/**
	 * @return the atmsclAsgnYn
	 */
	public String getAtmsclAsgnYn() {
		return atmsclAsgnYn;
	}

	/**
	 * @param atmsclAsgnYn the atmsclAsgnYn to set
	 */
	public void setAtmsclAsgnYn(String atmsclAsgnYn) {
		this.atmsclAsgnYn = atmsclAsgnYn;
	}



}
