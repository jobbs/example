/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WasVstrQtyVo.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   이권기         v1.0             최초생성
 *
 */
package ncis.dsb.stts.etc.vo;

import java.util.ArrayList;
import java.util.List;

import ncis.cmn.vo.CommonSearchVo;



public class OprStatSearchVo extends CommonSearchVo {

	private String searchType;

	private String searchRegionId;

	private String searchZoneId;

	private String searchNetId;

	private String searchNetClCd;

    private String searchPoolNm;

    private String searchPoolTypeCd;

    private String searchSwTypeCd;

    private String searchCtlTrgtYn;

    private boolean netVmSltAt;

    private String poolListStr;

	private List<String> poolList;

	//검색기준
	//검색기간
	private String searchTrmCd;
	//검색시작일자
	private String strtDt;
	//검색종료일자
	private String endDt;
	private String year;
	//분기코드
	private String quarterCd;
	//반기코드
	private String halfCd;
	private String searchMmCd;
	private String searchQqCd;
	private String searchHhCd;
	private String date;
	private String search;
	/**
	 * @return the poolList
	 */
	public List<String> getPoolList()
	{
		return poolList;
	}
	/**
	 * @param poolList the poolList to set
	 */
	public void setPoolList(List<String> poolList)
	{
		this.poolList = poolList;
	}
	/**
	 * @return the searchTrmCd
	 */
	public String getSearchTrmCd()
	{
		return searchTrmCd;
	}
	/**
	 * @param searchTrmCd the searchTrmCd to set
	 */
	public void setSearchTrmCd(String searchTrmCd)
	{
		this.searchTrmCd = searchTrmCd;
	}
	/**
	 * @return the strtDt
	 */
	public String getStrtDt()
	{
		return strtDt;
	}
	/**
	 * @param strtDt the strtDt to set
	 */
	public void setStrtDt(String strtDt)
	{
		this.strtDt = strtDt;
	}
	/**
	 * @return the endDt
	 */
	public String getEndDt()
	{
		return endDt;
	}
	/**
	 * @param endDt the endDt to set
	 */
	public void setEndDt(String endDt)
	{
		this.endDt = endDt;
	}
	/**
	 * @return the year
	 */
	public String getYear()
	{
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year)
	{
		this.year = year;
	}
	/**
	 * @return the quarterCd
	 */
	public String getQuarterCd()
	{
		return quarterCd;
	}
	/**
	 * @param quarterCd the quarterCd to set
	 */
	public void setQuarterCd(String quarterCd)
	{
		this.quarterCd = quarterCd;
	}
	/**
	 * @return the halfCd
	 */
	public String getHalfCd()
	{
		return halfCd;
	}
	/**
	 * @param halfCd the halfCd to set
	 */
	public void setHalfCd(String halfCd)
	{
		this.halfCd = halfCd;
	}
	/**
	 * @return the searchMmCd
	 */
	public String getSearchMmCd()
	{
		return searchMmCd;
	}
	/**
	 * @param searchMmCd the searchMmCd to set
	 */
	public void setSearchMmCd(String searchMmCd)
	{
		this.searchMmCd = searchMmCd;
	}
	/**
	 * @return the searchQqCd
	 */
	public String getSearchQqCd()
	{
		return searchQqCd;
	}
	/**
	 * @param searchQqCd the searchQqCd to set
	 */
	public void setSearchQqCd(String searchQqCd)
	{
		this.searchQqCd = searchQqCd;
	}
	/**
	 * @return the searchHhCd
	 */
	public String getSearchHhCd()
	{
		return searchHhCd;
	}
	/**
	 * @param searchHhCd the searchHhCd to set
	 */
	public void setSearchHhCd(String searchHhCd)
	{
		this.searchHhCd = searchHhCd;
	}
	/**
	 * @return the date
	 */
	public String getDate()
	{
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date)
	{
		this.date = date;
	}
	/**
	 * @return the search
	 */
	public String getSearch()
	{
		return search;
	}
	/**
	 * @param search the search to set
	 */
	public void setSearch(String search)
	{
		this.search = search;
	}
	/**
	 * @return the searchType
	 */
	public String getSearchType()
	{
		return searchType;
	}
	/**
	 * @param searchType the searchType to set
	 */
	public void setSearchType(String searchType)
	{
		this.searchType = searchType;
	}
	/**
	 * @return the searchRegionId
	 */
	public String getSearchRegionId()
	{
		return searchRegionId;
	}
	/**
	 * @param searchRegionId the searchRegionId to set
	 */
	public void setSearchRegionId(String searchRegionId)
	{
		this.searchRegionId = searchRegionId;
	}
	/**
	 * @return the searchZoneId
	 */
	public String getSearchZoneId()
	{
		return searchZoneId;
	}
	/**
	 * @param searchZoneId the searchZoneId to set
	 */
	public void setSearchZoneId(String searchZoneId)
	{
		this.searchZoneId = searchZoneId;
	}
	/**
	 * @return the searchNetId
	 */
	public String getSearchNetClCd()
	{
		return searchNetClCd;
	}
	/**
	 * @param searchNetId the searchNetId to set
	 */
	public void setSearchNetClCd(String searchNetClCd)
	{
		this.searchNetClCd = searchNetClCd;
	}
	/**
	 * @return the searchNetId
	 */
	public String getSearchNetId()
	{
		return searchNetId;
	}
	/**
	 * @param searchNetId the searchNetId to set
	 */
	public void setSearchNetId(String searchNetId)
	{
		this.searchNetId = searchNetId;
	}
	/**
	 * @return the searchPoolNm
	 */
	public String getSearchPoolNm()
	{
		return searchPoolNm;
	}
	/**
	 * @param searchPoolNm the searchPoolNm to set
	 */
	public void setSearchPoolNm(String searchPoolNm)
	{
		this.searchPoolNm = searchPoolNm;
	}
	/**
	 * @return the searchSwTypeCd
	 */
	public String getSearchSwTypeCd()
	{
		return searchSwTypeCd;
	}
	/**
	 * @param searchSwTypeCd the searchSwTypeCd to set
	 */
	public void setSearchSwTypeCd(String searchSwTypeCd)
	{
		this.searchSwTypeCd = searchSwTypeCd;
	}
	/**
	 * @return the searchPoolTypeCd
	 */
	public String getSearchPoolTypeCd()
	{
		return searchPoolTypeCd;
	}
	/**
	 * @param searchPoolTypeCd the searchPoolTypeCd to set
	 */
	public void setSearchPoolTypeCd(String searchPoolTypeCd)
	{
		this.searchPoolTypeCd = searchPoolTypeCd;
	}
	/**
	 * @return the searchCtlTrgtYn
	 */
	public String getSearchCtlTrgtYn()
	{
		return searchCtlTrgtYn;
	}
	/**
	 * @param searchCtlTrgtYn the searchCtlTrgtYn to set
	 */
	public void setSearchCtlTrgtYn(String searchCtlTrgtYn)
	{
		this.searchCtlTrgtYn = searchCtlTrgtYn;
	}
	/**
	 * @return the poolListStr
	 */
	public String getPoolListStr()
	{
		return poolListStr;
	}
	/**
	 * @param poolListStr the poolListStr to set
	 */
	public void setPoolListStr(String poolListStr)
	{
		this.poolListStr = poolListStr;

		if( this.poolList == null && poolListStr != null && poolListStr.length() > 0)
		{
			this.poolList = new ArrayList<String>();
			String[] tmp = poolListStr.split(",");
			if(tmp.length > 0 )
			{
				for(int i = 0 ; i < tmp.length ; i++ )
					this.poolList.add(tmp[i]);
			}
			else
				this.poolList.add(poolListStr);
		}
	}
	/**
	 * @return the netVmSltAt
	 */
	public boolean isNetVmSltAt()
	{
		return netVmSltAt;
	}
	/**
	 * @param netVmSltAt the netVmSltAt to set
	 */
	public void setNetVmSltAt(boolean netVmSltAt)
	{
		this.netVmSltAt = netVmSltAt;
	}


}
