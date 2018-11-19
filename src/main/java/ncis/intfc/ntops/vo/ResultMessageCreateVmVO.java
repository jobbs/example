package ncis.intfc.ntops.vo;

/**
 * 가상서버 생성 요청 결과 업데이트 응답결과 메시지 VO
 *
 * @author 정해훈
 *
 */
public class ResultMessageCreateVmVO {
    private String code;        /* 응답코드 */
    private String message;     /* 응답메시지 */

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultMessageCreateVmVO [code=" + code + ", message=" + message + "]";
    }
}
