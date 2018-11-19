package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 자원요청클러스터용도 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrClstrPrposReqList {

	/**
	* 자원요청번호
	*/
	@NotEmpty(message="자원요청번호는(은) 필수입력 항목입니다.")
    private String rsrcReqNo;

	/**
	* 자원요청일련번호
	*/
	@NotEmpty(message="자원요청일련번호는(은) 필수입력 항목입니다.")
    private BigDecimal rsrcReqSeq;

	/**
	* 용도구분코드
	*/
	@NotEmpty(message="용도구분코드는(은) 필수입력 항목입니다.")
    private String prposClCd;



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

	public String getPrposClCd()
	{
	    return prposClCd;
	}

	public void setPrposClCd(String prposClCd)
	{
	    this.prposClCd = prposClCd;
	}



}


