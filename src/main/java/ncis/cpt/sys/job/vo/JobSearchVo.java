/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename JobSearchVo.java
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

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 최진호
 *
 */
public class JobSearchVo extends CommonSearchVo {

    private String searchJobNm;

    private String searchJobId;

    private String searchInttNm;

    private String searchInttId;

    private String searchRegionId;

    private String searchVmAsgnYn;

    private String searchAtmsclAsgnYn;

    private String searchCludJob;


	/**
	 * @return the searchVmAsgnYn
	 */
	public String getSearchVmAsgnYn() {
		return searchVmAsgnYn;
	}

	/**
	 * @param searchVmAsgnYn the searchVmAsgnYn to set
	 */
	public void setSearchVmAsgnYn(String searchVmAsgnYn) {
		this.searchVmAsgnYn = searchVmAsgnYn;
	}

	/**
     * 검색 타입
     * SINGLE, MULTI
     */
    public String type;

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the searchJobNm
     */
    public String getSearchJobNm() {
        return searchJobNm;
    }

    /**
     * @param searchJobNm the searchJobNm to set
     */
    public void setSearchJobNm(String searchJobNm) {
        this.searchJobNm = searchJobNm;
    }

    /**
	 * @return the searchJobId
	 */
	public String getSearchJobId()
	{
		return searchJobId;
	}

	/**
	 * @param searchJobId the searchJobId to set
	 */
	public void setSearchJobId(String searchJobId)
	{
		this.searchJobId = searchJobId;
	}

	/**
	 * @return the searchInttId
	 */
	public String getSearchInttId()
	{
		return searchInttId;
	}

	/**
	 * @param searchInttId the searchInttId to set
	 */
	public void setSearchInttId(String searchInttId)
	{
		this.searchInttId = searchInttId;
	}

	/**
     * @return the searchInttNm
     */
    public String getSearchInttNm() {
        return searchInttNm;
    }

    /**
     * @param searchInttNm the searchInttNm to set
     */
    public void setSearchInttNm(String searchInttNm) {
        this.searchInttNm = searchInttNm;
    }

    /**
     * @return the searchRegionId
     */
    public String getSearchRegionId() {
        return searchRegionId;
    }

    /**
     * @param searchRegionId the searchRegionId to set
     */
    public void setSearchRegionId(String searchRegionId) {
        this.searchRegionId = searchRegionId;
    }

    /**
     * @return the searchCludJob
     */
    public String getSearchCludJob() {
        return searchCludJob;
    }

    /**
     * @param searchCludJob the searchCludJob to set
     */
    public void setSearchCludJob(String searchCludJob) {
        this.searchCludJob = searchCludJob;
    }

	/**
	 * @return the searchAtmsclAsgnYn
	 */
	public String getSearchAtmsclAsgnYn() {
		return searchAtmsclAsgnYn;
	}

	/**
	 * @param searchAtmsclAsgnYn the searchAtmsclAsgnYn to set
	 */
	public void setSearchAtmsclAsgnYn(String searchAtmsclAsgnYn) {
		this.searchAtmsclAsgnYn = searchAtmsclAsgnYn;
	}

}
