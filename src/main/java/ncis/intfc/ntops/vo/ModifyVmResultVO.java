package ncis.intfc.ntops.vo;

/**
 * 가상서버 변경 요청 결과 업데이트 VO
 *
 * @author 정해훈
 *
 */
public class ModifyVmResultVO {
    private String reqId;               /* 요청ID */
    private String vmId;                /* 가상서버구성ID */
    private String reqType;             /* 요청타입 : 'VM_ADD_STORAGE', 'VM_SPEC', 'VM_DEL' */
    private String modDate;             /* 처리일자 */
    private String modResult;           /* 처리결과 : 'S'=성공 , 'F'=실패*/
    private String errorMsg;            /* 에러 메시지 */
    private int totalStorageSize;       /* 총 스토리지 용량 */

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
    public String getReqType() {
        return reqType;
    }
    public void setReqType(String reqType) {
        this.reqType = reqType;
    }
    public String getModDate() {
        return modDate;
    }
    public void setModDate(String modDate) {
        this.modDate = modDate;
    }
    public String getModResult() {
        return modResult;
    }
    public void setModResult(String modResult) {
        this.modResult = modResult;
    }
    public String getErrorMsg() {
        return errorMsg;
    }
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    public int getTotalStorageSize() {
        return totalStorageSize;
    }
    public void setTotalStorageSize(int totalStorageSize) {
        this.totalStorageSize = totalStorageSize;
    }

    @Override
    public String toString() {
        return "ModifyVmResultVO [reqId=" + reqId + ", vmId=" + vmId + ", reqType=" + reqType + ", modDate=" + modDate + ", modResult=" + modResult + ", errorMsg=" + errorMsg + ", totalStorageSize=" + totalStorageSize + "]";
    }

}
