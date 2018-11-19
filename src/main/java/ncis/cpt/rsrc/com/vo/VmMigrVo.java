/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmMigrVo.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 10. 21.
 * @lastmodified 2016. 10. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 21.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.vo;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 심원보
 *
 */

public class VmMigrVo {

    @NotEmpty(message = "대상 물리서버의 센터 정보가 없습니다.")
    private String regionId;

    @NotEmpty(message = "대상 물리서버의 존 정보가 없습니다.")
    private String zoneId;

    @NotEmpty(message = "대상 물리서버의 망 정보가 없습니다.")
    private String netClCd;

    @NotEmpty(message = "대상 물리서버의 자원풀 정보가 없습니다.")
    private String rsrcPoolId;

    @NotNull(message = "대상 물리서버를 선택해주세요.")
    private BigDecimal pmSeq;

    @NotEmpty(message = "대상 물리서버의 UUID 정보가 없습니다.")
    private String pmUuid;

    @NotEmpty(message = "가상서버의 UUID 정보가 없습니다.")
    private String vmUuid;

    @NotNull(message = "가상서버를 선택해주세요.")
    private BigDecimal vmSeq;

    private String userId;

    private String vmNm;



    /**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getNetClCd() {
        return netClCd;
    }

    public void setNetClCd(String netClCd) {
        this.netClCd = netClCd;
    }

    public String getRsrcPoolId() {
        return rsrcPoolId;
    }

    public void setRsrcPoolId(String rsrcPoolId) {
        this.rsrcPoolId = rsrcPoolId;
    }

    public BigDecimal getPmSeq() {
        return pmSeq;
    }

    public void setPmSeq(BigDecimal pmSeq) {
        this.pmSeq = pmSeq;
    }

    public String getPmUuid() {
        return pmUuid;
    }

    public void setPmUuid(String pmUuid) {
        this.pmUuid = pmUuid;
    }

    public String getVmUuid() {
        return vmUuid;
    }

    public void setVmUuid(String vmUuid) {
        this.vmUuid = vmUuid;
    }

    public BigDecimal getVmSeq() {
        return vmSeq;
    }

    public void setVmSeq(BigDecimal vmSeq) {
        this.vmSeq = vmSeq;
    }

	public String getVmNm() {
		return vmNm;
	}

	public void setVmNm(String vmNm) {
		this.vmNm = vmNm;
	}

}