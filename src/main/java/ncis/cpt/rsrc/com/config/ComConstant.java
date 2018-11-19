/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ComConstant.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 10. 14.
 * @lastmodified 2016. 10. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 14.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.config;

/**
 * @author 심원보
 *
 */
public class ComConstant {

    public static final String COM_STACK = "COM";

    public static final String INSERT = "insert";
    public static final String UPDATE = "update";
    public static final String DELETE = "delete";
    public static final String EXECUTE = "execute";

    public static final String NET_CL_GRP_CD = "067"; // 망구분 그룹 코드
    public static final String NET_CL_PARENT_CD = "NETCD"; // 망구분 그룹 코드
    public static final String VRLZ_SW_TY_GRP_CD = "001"; // 가상화SW유형 그룹코드
    public static final String VRLZ_SW_TY_PARENT_CD = "100"; // 가상화SW유형 상위코드
    public static final String CLSTR_PRPOS_GRP_CD = "002"; // 클러스터 용도 그룹코드
    public static final String CLSTR_PRPOS_PARENT_CD = "101"; // 클러스터 용도 상위코드
    public static final String OS_TY_GRP_CD = "003"; // 운영체제유형 그룹코드
    public static final String OS_TY_PARENT_CD = "102"; // 운영체제유형 상위코드
    public static final String VM_STAT_GRP_CD = "010"; // 가상서버상태 그룹코드
    public static final String VM_STAT_PARENT_CD = "109"; // 가상서버상태 상위코드
    public static final String VM_STAT_GRP_GRP_CD = "074"; // 가상서버상태그룹 그룹코드
    public static final String VM_STAT_GRP_PARENT_CD = "109"; // 가상서버상태그룹 상위코드
    public static final String PM_STAT_GRP_CD = "073"; // 물리서버상태 그룹코드
    public static final String PM_STAT_PARENT_CD = "109"; // 물리서버상태 상위코드
    public static final String PM_GRP_STAT_GRP_CD = "075"; // 물리서버상태그룹코드 그룹코드
    public static final String PM_GRP_STAT_PARENT_CD = "109"; // 물리서버상태그룹코드 상위코드
    public static final String VM_REQ_GRP_CD = "064"; // 가상서버요청유형 그룹코드
    public static final String VM_REQ_PARENT_CD = "141"; // 가상서버요청유형 상위코드

    public static final String VM_REQ_RES_CD = "01"; // 가상서버요청유형 자원 그룹코드
    public static final String VM_REQ_MIGR_CD = "02"; // 가상서버요청유형 마이그레이션 그룹코드
    public static final String VM_REQ_SNAP_CD = "03"; // 가상서버요청유형 스냅샷 그룹코드
    public static final String VM_REQ_COMP_CD = "04"; // 가상서버요청유형 구성변경 그룹코드

    public static final String VM_CHNG_CL_CD_VM_SPEC_MOD = "01"; // 가상서버변경구분코드 - 가상서버 스펙 변경
    public static final String VM_CHNG_CL_CD_VM_STRG_ADD = "02"; // 가상서버변경구분코드 - 가상서버 스토리지 추가

    public static final String VM_STAT_CD_DOWN = "01"; // 가상서버상태코드 - down
    public static final String VM_STAT_CD_UP = "02"; // 가상서버상태코드 - up

    public static final String VRLZ_SW_TY_CD_EV = "01"; // 가상화SW유형코드 - RHEV

    public static final String RSRC_REQ_TY_CD_PM_CRE_CD = "05"; // 자원요청유형코드 - 물리서버 삭제
    public static final String RSRC_REQ_TY_CD_PM_DEL_CD = "06"; // 자원요청유형코드 - 물리서버 삭제
    public static final String RSRC_REQ_TY_CD_VM_CRE_CD = "01"; // 자원요청유형코드 - 가상서버 생성
    public static final String RSRC_REQ_TY_CD_VM_DEL_CD = "02"; // 자원요청유형코드 - 가상서버 삭제
    public static final String RSRC_REQ_TY_CD_VM_SPEC_MOD_CD = "03"; // 자원요청유형코드 - 가상서버 스펙변경
    public static final String RSRC_REQ_TY_CD_VM_STRG_ADD_CD = "09"; // 자원요청유형코드 - 가상서버 스토리지 추가
    public static final String RSRC_REQ_TY_CD_VM_STRG_DEL_CD = "10"; // 자원요청유형코드 - 가상서버 스토리지 삭제
    public static final String RSRC_REQ_TY_CD_CLSTR_CRE_CD = "07"; // 자원요청유형코드 - 클러스터 생성
    public static final String RSRC_REQ_TY_CD_CLSTR_DEL_CD = "08"; // 자원요청유형코드 - 클러스터 삭제
    public static final String RSRC_REQ_PRCSS_STAT_CD_REQ_CD = "01"; // 자원요청처리상태코드 - 요청

    public static final String VM_REQ_TY_CD_CHG_COMP_ID = "09"; // 가상서버요청유형코드 - 구성ID 변경

    public static final String VM_RC_CMD_CD_CONNECT_CD = "01"; // 가상서버원격콘솔명령 - 접속
    public static final String VM_RC_CMD_CD_DISCONNECT_CD = "02"; // 가상서버원격콘솔명령 - 접속종료

    public static final String RSRC_REQ_NO_DEFAULT_VALUE = "R999912319999"; // 자원요청번호 기본값

    public static final String RSRC_REQ_EXE_STAT_CD_01 = "01"; // 자원요청실행상태코드 - 미설정

    public static final String SUCCESS_MSG = "정상 처리되었습니다.";
    public static final String ERROR_MSG = "오류가 발생하였습니다.";
    public static final String CANNOT_CHANGE_AVAILABLITY_CLSTR_HAS_PM_OR_VM_MSG = "해당 클러스터에 물리서버 또는 하위 가상서버가 존재하여, 사용여부를 변경할 수 없습니다.";
    public static final String UNABLE_TO_DELETE_CLSTR_HAS_PM_OR_VM_MSG = "해당 클러스터에 물리서버 또는 하위 가상서버가 존재하여, 삭제할 수 없습니다.";
    public static final String PM_HAS_VM_MSG = "해당 물리서버에 하위 가상서버가 존재합니다.";
    public static final String FAILED_SNAP_OVER_VR_STRG_CAPA_MSG = "가상스토리지 용량이 부족합니다.";
    public static final String FAILED_SNAP_OVER_COUNT_MSG = "스냅샷 최대갯수를 초과하였습니다.";
    public static final String FAILED_SNAP_PROCESS_INFO_MSG = "처리중인 스냅샷 정보가 존재하므로 처리할 수 없습니다.";
    public static final String FAILED_VM_NOT_PROCESS_INFO_MSG = "처리할 수 없는 가상서버 정보입니다.";
    public static final String FAILED_VM_STAT_ON_PROCESS_MSG = "가상서버가 업(ON) 상태일 때 처리 가능합니다.";
    public static final String FAILED_VM_STAT_OFF_PROCESS_MSG = "가상서버가 다운(OFF) 상태일 때 처리 가능합니다.";
    public static final String INVALID_ESSENTIAL_DATA_MSG = "필수항목이 미입력되었습니다.";
    public static final String FAILED_TO_LOAD_REQUEST_USER_MSG = "요청자 정보를 불러올 수 없습니다.";
    public static final String NOT_EXIST_TARGET_CLUSTER_MSG = "대상 클러스터가 없습니다.";
    public static final String FAILED_TO_LOAD_SPEC_INFO_MSG = "선택한 스펙 정보를 불러올 수 없습니다.";
    public static final String NOT_CONTROL_TARGET_RSRC_POOL = "제어할 수 있는 자원풀이 아닙니다.";
    public static final String NOT_EXIST_TARGET_CLSTR_MSG = "대상 클러스터가 없습니다.";
    public static final String NOT_EXIST_TARGET_VM_MSG = "대상 가상서버가 없습니다.";
    public static final String NOT_EXIST_TARGET_PM_MSG = "대상 물리서버가 없습니다.";
    public static final String NOT_EXIST_PM_BY_IP_ADDR_MSG = "IP주소에 해당하는 물리서버 정보가 없습니다.";
    public static final String NOT_EXIST_CONNECTABLE_VM_GRAPHIC_CONSOLE_MSG = "접속가능한 가상서버 그래픽콘솔정보가 없습니다.";
    public static final String VM_COMP_ID_ALREADY_EXISTS_MSG = "사용중인 가상서버 구성ID입니다.";
    public static final String PM_COMP_ID_ALREADY_EXISTS_MSG = "사용중인 물리서버 구성ID입니다.";
    public static final String CLSTR_COMP_ID_ALREADY_EXISTS_MSG = "사용중인 클러스터 구성ID입니다.";
    public static final String VM_STATUS_NOT_SYNCHRONIZED_MSG = "가상서버 상태가 동기화되지 않았습니다.";
    public static final String FAILED_TO_GET_VM_STATUS_MSG = "가상서버 상태정보를 확인할 수 없습니다.";
    public static final String FAILED_TO_GET_VM_GRAPHIC_CONSOLE_MSG = "가상서버 그래픽콘솔정보를 확인할 수 없습니다.";
    public static final String NOT_SUPPORT_VM_GRAPHIC_CONSOLE = "가상서버 그래픽콘솔을 지원하지 않습니다.";
    public static final String NOT_EXIST_TARGET_HOST_CONNECTION_INFO = "연결할 호스트 정보가 없습니다.";

    public static final String VM_GRAPHIC_PROTOCOL_SPICE = "spice";
    public static final String VM_GRAPHIC_PROTOCOL_VNC = "vnc";

    // 가상서버 상세조회 탭 메뉴
    public static final String VM_TAB_INFO = "info";
    public static final String VM_TAB_SNAP = "snap";
    public static final String VM_TAB_HIST = "hist";

    /* 최대길이 */
    // 클러스터
    public static final int CLSTR_ID_MAX_LENGTH = 100;
    public static final int CLSTR_NM_MAX_LENGTH = 100;
    public static final int CLSTR_COMP_ID_MAX_LENGTH = 10;
    public static final int CLSTR_RMK_MAX_LENGTH = 1000;
    // 물리서버
    public static final int PM_ID_MAX_LENGTH = 100;
    public static final int PM_NM_MAX_LENGTH = 100;
    public static final int PM_COMP_ID_MAX_LENGTH = 10;
    public static final int PM_RMK_MAX_LENGTH = 1000;
    // 가상서버
    public static final int VM_ID_MAX_LENGTH = 100;
    public static final int VM_NM_MAX_LENGTH = 100;
    public static final int VM_COMP_ID_MAX_LENGTH = 10;
    public static final int VM_RMK_MAX_LENGTH = 1000;
    // 공통
    public static final int SBJCT_MAX_LENGTH = 500;
    public static final int TICKT_NO_MAX_LENGTH = 20;
    public static final int IP_ADDR_MAX_LENGTH = 16;
    public static final int HST_NM_MAX_LENGTH = 100;
    // 부처
    public static final int INSTITUTION_NM_MAX_LENGTH = 30;
    // 업무
    public static final int JOB_NM_MAX_LENGTH = 100;

    /* 최대값 */
    public static final String CPU_VCORE_QTY_MAX_VALUE = "128";
    public static final String MEM_ASGN_CAPA_GB_MAX_VALUE = "256";
    public static final String STRG_ASGN_CAPA_GB_MAX_VALUE = "9999999";

}
