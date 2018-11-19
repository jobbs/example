package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 네트워크인터페이스요청목록 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrNetwkIntfcReqList {

    /**
     * 자원요청번호
     */
    @NotEmpty(message = "자원요청번호는(은) 필수입력 항목입니다.")
    private String rsrcReqNo;

    /**
     * 자원요청일련번호
     */
    @NotEmpty(message = "자원요청일련번호는(은) 필수입력 항목입니다.")
    private BigDecimal rsrcReqSeq;

    /**
     * 네트워크인터페이스SEQ
     */
    private String netwkIntfcSeq;

    /**
     * 네트워크인터페이스ID
     */
    private String netwkIntfcId;

    /**
     * IP 대역 SEQ
     */
    private Integer ipBndSeq;

    /**
     * IP주소
     */
    private String ipAddr;

    /**
     * NIC용도코드
     */
    private String nicPrposCd;

    /**
     * IP자동할당여부
     */
    private String ipAutoAsgnYn;

    /**
     * 네트워크 인터페이스명
     */
    private String netwkIntfcNm;

    /**
     * NAT IP 주소여부
     */
    private String natYn;


    public String getRsrcReqNo() {
        return rsrcReqNo;
    }

    public void setRsrcReqNo(String rsrcReqNo) {
        this.rsrcReqNo = rsrcReqNo;
    }

    public BigDecimal getRsrcReqSeq() {
		return rsrcReqSeq;
	}

	public void setRsrcReqSeq(BigDecimal rsrcReqSeq) {
		this.rsrcReqSeq = rsrcReqSeq;
	}

	/**
	 * @return the ipBndSeq
	 */
	public Integer getIpBndSeq()
	{
		return ipBndSeq;
	}

	/**
	 * @param ipBndSeq the ipBndSeq to set
	 */
	public void setIpBndSeq(Integer ipBndSeq)
	{
		this.ipBndSeq = ipBndSeq;
	}

	public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getNicPrposCd() {
        return nicPrposCd;
    }

    public void setNicPrposCd(String nicPrposCd) {
        this.nicPrposCd = nicPrposCd;
    }

    public String getIpAutoAsgnYn() {
        return ipAutoAsgnYn;
    }

    public void setIpAutoAsgnYn(String ipAutoAsgnYn) {
        this.ipAutoAsgnYn = ipAutoAsgnYn;
    }

    public String getNetwkIntfcSeq() {
        return netwkIntfcSeq;
    }

    public void setNetwkIntfcSeq(String netwkIntfcSeq) {
        this.netwkIntfcSeq = netwkIntfcSeq;
    }

	public String getNetwkIntfcId() {
		return netwkIntfcId;
	}

	public void setNetwkIntfcId(String netwkIntfcId) {
		this.netwkIntfcId = netwkIntfcId;
	}

	public String getNetwkIntfcNm() {
		return netwkIntfcNm;
	}

	public void setNetwkIntfcNm(String netwkIntfcNm) {
		this.netwkIntfcNm = netwkIntfcNm;
	}

	public String getNatYn() {
		return natYn;
	}

	public void setNatYn(String natYn) {
		this.natYn = natYn;
	}



}
