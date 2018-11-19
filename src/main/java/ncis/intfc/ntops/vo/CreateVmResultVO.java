package ncis.intfc.ntops.vo;

/**
 * 가상서버 생성 요청 결과 업데이트 VO
 *
 * @author 정해훈
 *
 */
public class CreateVmResultVO {
    private String reqId;           /* 요청ID */
    private String vmId;            /* 가상서버구성ID */
    private String createDate;      /* 생성일자 */
    private String createResult;    /* 처리결과 */
    private String errorMsg;        /* 에러메시지 */

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getVmId() {
        return vmId;
    }

    public void setVmId(String vmId) {
        this.vmId = vmId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateResult() {
        return createResult;
    }

    public void setCreateResult(String createResult) {
        this.createResult = createResult;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "CreateVmResultVO [reqId=" + reqId + ", vmId=" + vmId + ", createDate=" + createDate + ", createResult=" + createResult + ", errorMsg=" + errorMsg + "]";
    }

}
