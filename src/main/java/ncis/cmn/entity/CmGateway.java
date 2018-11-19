package ncis.cmn.entity;

import java.util.Date;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * API게이트웨이정보 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class CmGateway {

    /**
     * 게이트웨이SEQ
     */
    private Long gatewaySeq;

    /**
     * 게이트웨이명
     */
    @NotEmpty(message="게이트웨이명을 입력하세요.")
    @Size(max=100,message="게이트웨이명은 최대 100자까지 허용합니다.")
    private String gatewayNm;

    /**
     * 호스트
     */
    @NotEmpty(message="게이트웨이 호스트 정보를 입력하세요.")
    @Size(max=100,message="게이트웨이명은 최대 100자까지 허용합니다.")
    private String gatewayHost;

    /**
     * 토큰(인증)
     */
    @NotEmpty(message="게이트웨이 토큰 정보를 입력하세요.")
    @Size(max=100,message="게이트웨이명은 최대 100자까지 허용합니다.")
    private String gatewayToken;

    /**
     * 등록자ID
     */
    private String regUserId;

    /**
     * 등록일시
     */
    private Date regDttm;

    /**
     * 수정자ID
     */
    private String updtUserId;

    /**
     * 수정일시
     */
    private Date updtDttm;

    /**
     * 리전ID
     */
    @NotEmpty(message="게이트웨이 센터 정보를 입력하세요.")
    private String regionId;

    public Long getGatewaySeq() {
        return gatewaySeq;
    }

    public void setGatewaySeq(Long gatewaySeq) {
        this.gatewaySeq = gatewaySeq;
    }

    public String getGatewayNm() {
        return gatewayNm;
    }

    public void setGatewayNm(String gatewayNm) {
        this.gatewayNm = gatewayNm;
    }

    public String getGatewayHost() {
        return gatewayHost;
    }

    public void setGatewayHost(String gatewayHost) {
        this.gatewayHost = gatewayHost;
    }

    public String getGatewayToken() {
        return gatewayToken;
    }

    public void setGatewayToken(String gatewayToken) {
        this.gatewayToken = gatewayToken;
    }

    public String getRegUserId() {
        return regUserId;
    }

    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    public Date getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(Date regDttm) {
        this.regDttm = regDttm;
    }

    public String getUpdtUserId() {
        return updtUserId;
    }

    public void setUpdtUserId(String updtUserId) {
        this.updtUserId = updtUserId;
    }

    public Date getUpdtDttm() {
        return updtDttm;
    }

    public void setUpdtDttm(Date updtDttm) {
        this.updtDttm = updtDttm;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }
}
