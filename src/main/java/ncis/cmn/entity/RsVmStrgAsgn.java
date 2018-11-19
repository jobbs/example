package ncis.cmn.entity;

import java.math.BigDecimal;

/**
 * 가상서버스토리지할당 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author 심원보
 */

public class RsVmStrgAsgn {

    /**
     * 가상서버SEQ
     */
    private BigDecimal vmSeq;

    /**
     * 가상디스크SEQ
     */
    private BigDecimal vrDskId;

    private String vrDskSeq;



    /**
	 * @return the vrDskSeq
	 */
	public String getVrDskSeq() {
		return vrDskSeq;
	}

	/**
	 * @param vrDskSeq the vrDskSeq to set
	 */
	public void setVrDskSeq(String vrDskSeq) {
		this.vrDskSeq = vrDskSeq;
	}

	public BigDecimal getVmSeq() {
        return vmSeq;
    }

    public void setVmSeq(BigDecimal vmSeq) {
        this.vmSeq = vmSeq;
    }

    public BigDecimal getVrDskId() {
        return vrDskId;
    }

    public void setVrDskId(BigDecimal vrDskId) {
        this.vrDskId = vrDskId;
    }

}
