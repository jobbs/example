package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * HA구성 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrHaComp {

	/**
	* 자원요청번호
	*/
    private String rsrcReqNo;

	/**
	* 자원요청일련번호
	*/
    private BigDecimal rsrcReqSeq;

	/**
	* HA구성여부
	*/
    private String haCompYn;

	/**
	* HA상태코드
	*/
    private String haStatCd;

	/**
	* HA그룹코드
	*/
    @NotEmpty(message="HA 그룹코드은 필수입력 항목입니다.")
    private String haGrpCd;

	/**
	* HA그룹명
	*/
    @NotEmpty(message="HA 그룹명은 필수입력 항목입니다.")
    private String haGrpNm;

	/**
	* HA스토리지용량
	*/
    @NotEmpty(message="HA 스토리지용량은 필수입력 항목입니다.")
    private Integer haStrgCapa;

	/**
	* HA가성서버명
	*/
    @NotEmpty(message="HA 서비스명은 필수입력 항목입니다.")
    private String haVmNm;

	/**
	* HA호스트명
	*/
    private String haHstNm;


    /**
	* HA그룹ID
	*/
    private String haGrpId;


	public String getRsrcReqNo()
	{
	    return rsrcReqNo;
	}

	public void setRsrcReqNo(String rsrcReqNo)
	{
	    this.rsrcReqNo = rsrcReqNo;
	}

	public BigDecimal getRsrcReqSeq()
	{
	    return rsrcReqSeq;
	}

	public void setRsrcReqSeq(BigDecimal rsrcReqSeq)
	{
	    this.rsrcReqSeq = rsrcReqSeq;
	}

	public String getHaCompYn()
	{
	    return haCompYn;
	}

	public void setHaCompYn(String haCompYn)
	{
	    this.haCompYn = haCompYn;
	}

	public String getHaStatCd()
	{
	    return haStatCd;
	}

	public void setHaStatCd(String haStatCd)
	{
	    this.haStatCd = haStatCd;
	}

	public String getHaGrpCd()
	{
	    return haGrpCd;
	}

	public void setHaGrpCd(String haGrpCd)
	{
	    this.haGrpCd = haGrpCd;
	}

	public String getHaGrpNm()
	{
	    return haGrpNm;
	}

	public void setHaGrpNm(String haGrpNm)
	{
	    this.haGrpNm = haGrpNm;
	}

	public Integer getHaStrgCapa()
	{
	    return haStrgCapa;
	}

	public void setHaStrgCapa(Integer haStrgCapa)
	{
	    this.haStrgCapa = haStrgCapa;
	}

	public String getHaVmNm()
	{
	    return haVmNm;
	}

	public void setHaVmNm(String haVmNm)
	{
	    this.haVmNm = haVmNm;
	}

	public String getHaHstNm()
	{
	    return haHstNm;
	}

	public void setHaHstNm(String haHstNm)
	{
	    this.haHstNm = haHstNm;
	}

	public String getHaGrpId() {
		return haGrpId;
	}

	public void setHaGrpId(String haGrpId) {
		this.haGrpId = haGrpId;
	}

}


