/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename IpBndConstants.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 22.
 * @lastmodified 2016. 10. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 22.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.config;

/**
 * @author 신재훈
 *
 */
public class IpBndConstants {
    public static final String INSERT = "insert";
    public static final String UPDATE = "update";
    public static final String DELETE = "delete";
    public static final String EXECUTE = "execute";

    public static final String IP_BND_STAT_CD_ASGN = "01";
    public static final String IP_BND_STAT_CD_UNASGN = "02";
    public static final String IP_BND_STAT_CD_BLK = "03";

    public static final String IP_BND_STAT_CD_NM_ASGN = "할당";
    public static final String IP_BND_STAT_CD_NM_UNASGN = "미할당";
    public static final String IP_BND_STAT_CD_NM_BLK = "Block";

    public static final String IP_BND_TAB_TYPE_ASGN = "asgn";
    public static final String IP_BND_TAB_TYPE_UNASGN = "unasgn";
    public static final String IP_BND_TAB_TYPE_BLOCK = "block";
    public static final String IP_BND_TAB_TYPE_INFO = "info";
    public static final String IP_BND_TAB_TYPE_STATIC = "static";

    public static final String IP_STAT_GRP_CD = "022"; // IP상태 그룹코드
    public static final String IP_STAT_PARENT_CD = "121"; // IP상태 상위코드

    public static final String IP_BND_NET_GRP_CD = "067"; // 망 그룹코드
    public static final String IP_BND_NET_PARENT_CD = "NETCD"; // 망 상위코드

    public static final String IP_BND_PRPOS_GRP_CD = "005"; // IP대역 용도 그룹코드
    public static final String IP_BND_PRPOS_PARENT_CD = "104"; // IP대역 용도 상위코드

    public static final String SUCCESS_MSG = "정상 처리되었습니다.";
    public static final String ERROR_MSG = "오류가 발생하였습니다.";
    public static final String NOTING_MSG = "아무 행동을 하지 않습니다";

    public static final String ERROR_MSG_IPBND_USE = "사용중인 IP대역은 삭제할 수 없습니다.";
    public static final String ERROR_MSG_IPBND_EMPTY_PRPOS = "용도를 선택해주세요.";
    public static final String ERROR_MSG_IPBND_USED_IP = "입력한 IP범위에 다른 IP대역에서 사용중인 IP가 존재합니다.";

    public static final String IP_BND_USE_YN = "Y";

    // IP대역 용도
    public static final String[] IP_BND_PRPOS_CD_SERVICE = { "01", "02", "03" };

}
