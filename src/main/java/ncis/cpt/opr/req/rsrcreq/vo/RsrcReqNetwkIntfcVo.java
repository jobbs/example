package ncis.cpt.opr.req.rsrcreq.vo;

import java.math.BigDecimal;

public class RsrcReqNetwkIntfcVo {

    private String rsrcReqNo; /* 자원요청번호 */
    private BigDecimal rsrcReqSeq; /* 자원요청일련번호 */
    private String netwkIntfcId; /* 네트워크인터페이스ID */
    private String netwkIntfcNm; /* 네트워크인터페이스명 */
    private Integer ipBndSeq; /* IP 대역 SEQ*/
    private String ipAddr; /* IP주소 */
    private String ipAutoAsgnYn; /* IP자동할당여부 */
    private String nicPrposNm; /* NIC용도명 */
    private String nicPrposCd; /* NIC용도코드 */
    private String uuid; /* UUID */
    private String natYn; /* NAT 여부*/
    private String rsrcPoolId; /* 자원풀ID */

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

    public String getIpAutoAsgnYn() {
        return ipAutoAsgnYn;
    }

    public void setIpAutoAsgnYn(String ipAutoAsgnYn) {
        this.ipAutoAsgnYn = ipAutoAsgnYn;
    }

    public String getNicPrposNm() {
        return nicPrposNm;
    }

    public void setNicPrposNm(String nicPrposNm) {
        this.nicPrposNm = nicPrposNm;
    }

    public String getNicPrposCd() {
        return nicPrposCd;
    }

    public void setNicPrposCd(String nicPrposCd) {
        this.nicPrposCd = nicPrposCd;
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getNatYn() {
		return natYn;
	}

	public void setNatYn(String natYn) {
		this.natYn = natYn;
	}

	public String getRsrcPoolId() {
		return rsrcPoolId;
	}

	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}

}
