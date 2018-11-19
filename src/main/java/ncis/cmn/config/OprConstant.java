/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename OpConstant.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cmn.config;


public class OprConstant {
	public OprConstant(){}

	public static final String RSRC_EXEC_SUCC_MSG = "성공적으로 실행요청 되었습니다.";
	public static final String RSRC_MANUAL_EXEC_SUCC_MSG = "성공적으로 처리완료되었습니다.";
	public static final String RSRC_SAVE_SUCC_MSG = "성공적으로 설정정보가 저장되었습니다.";
	public static final String RSRC_SAVE_CANCEL_SUCC_MSG = "성공적으로 설정정보가 취소되었습니다.";
	public static final String RSRC_EXEC_FAIL_MSG = "실행중 오류가 발생했습니다.";
	public static final String RSRC_EXEC_PM_NULL_MSG = "자동할당 대상 물리서버가 없습니다.";
	public static final String RSRC_EXEC_VM_NULL_MSG = "자동할당 대상 가상서버가 없습니다.";

	public static final String RX_CRE_SUCC_MSG = "성공적으로 생성 되었습니다.";
	public static final String RX_DEL_SUCC_MSG = "성공적으로 삭제 되었습니다.";
	public static final String RX_CRE_FAIL_MSG = "생성중 오류가 발생했습니다.";
	public static final String RX_DEL_FAIL_MSG = "삭제중 오류가 발생했습니다.";
	public static final String RX_ADD_SUCC_MSG = "성공적으로 추가 되었습니다.";
	public static final String RX_EXEC_SUCC_MSG = "성공적으로 실행 되었습니다.";
	public static final String RX_SAVE_SUCC_MSG = "성공적으로 저장 되었습니다.";
	public static final String RX_SAVE_FAIL_MSG = "저장중 오류가 발생했습니다.";


	public static final String RX_REQ_SUCC_MSG = "성공적으로 요청 되었습니다.";
	public static final String RX_REQ_FAIL_MSG = "요청중 오류가 발생했습니다.";
	public static final String RX_REQ_FILE_DEFAULT_PATH = "rsrcReqMng";


	public static final String RSRC_EXEC_NEED_SET_L3L4_INSTITUTIN_MSG = "L3/L4의 부처 설정이 필요합니다.";
	public static final String RSRC_EXEC_SID_NULL_MSG = "SID가 부정확합니다.확인하여 주세요.";

	public static final String RSRC_PROC_TYPE_UPDATA = "update";
	public static final String RSRC_EXCEPTION_PAGE = "viewRsrcReqError"; //에러발생시 이동 페이지(공통 정의되면 페이지명 수정되어야함)

	public static final int VM_START_PROCESS_ID = 20160001; //VM생성 프로세스 아이디
	public static final int VM_SPECCHNG_PROCESS_ID = 20160002; //VM스펙변경 프로세스 아이디
	public static final int VM_STRGADD_PROCESS_ID = 20160003; //VM 스토리지추가 프로세스 아이디
	public static final int PM_ADD_PROCESS_ID = 20160004; //물리서버추가 프로세스 아이디
	public static final int PM_DEL_PROCESS_ID = 20160005; //물리서버삭제 프로세스 아이디
	public static final int CL_ADD_PROCESS_ID = 20160006; //클러스터추가 프로세스 아이디
	public static final int CL_DEL_PROCESS_ID = 20160007; //클러스터삭제 프로세스 아이디
	public static final int VM_DEL_PROCESS_ID = 20160008; //VM삭제 프로세스 아이디
	public static final int VM_MIGR_PROCESS_ID = 20160009; //네트워크인터페이스 생성
	public static final int VM_REQ_COM_PROCESS_ID = 20160010; //요청처리 공통 프로세스

	public static final String PROCESS_STAT_CD_01 = "01"; //프로세스진행상태 (진행)
	public static final String PROCESS_STAT_CD_03 = "03"; //프로세스진행상태 (대기)
	public static final String RSRC_STAT_CD_01 = "01"; //자원요청진행상태코드(진행)
	public static final String RSRC_STAT_CD_02 = "02"; //자원요청진행상태 (처리중)
	public static final String RSRC_EXE_STAT_CD_02 = "02"; //실행상태코드 (설정완료)
	public static final String IP_STAT_CD_01= "01"; //IP상태 (할당)
	public static final String IP_STAT_CD_02= "02"; //IP상태 (미할당)

	public static final String RSRC_REQ_PRCSS_STAT_REQ="01";  //자원요청 처리 상태 (요청);
	public static final String RSRC_REQ_PRCSS_STAT_PRCSS ="02";  //자원요청 처리 상태 (처리중);
	public static final String RSRC_REQ_PRCSS_STAT_CMPLT="03";  //자원요청 처리 상태 (완료);
	public static final String RSRC_REQ_PRCSS_STAT_RJCT ="04";  //자원요청 처리 상태 (반려);
	public static final String RSRC_REQ_PRCSS_STAT_ERROR="05";  //자원요청 처리 상태 (오류);
	public static final String RSRC_REQ_PRCSS_STAT_REQ_DEL="06";  //자원요청 처리 상태 (요청삭제);
	public static final String RSRC_REQ_PRCSS_STAT_MANUAL_CMPLT="07";  //자원요청 처리 상태 (수동완료);

	public static final String RSRC_REQ_TY_CD_VM_CRE = "01";	/* 가상서버생성 */
	public static final String RSRC_REQ_TY_CD_VM_DEL = "02";	/* 가상서버삭제 */
	public static final String RSRC_REQ_TY_CD_VM_SPEC_CHNG = "03";	/* 가상서버 스펙변경 */
	public static final String RSRC_REQ_TY_CD_SLB_CRE = "04";	/* SLB설정 */
	public static final String RSRC_REQ_TY_CD_PM_ADD = "05";	/* 물리서버추가 */
	public static final String RSRC_REQ_TY_CD_PM_DEL = "06";	/* 물리서버삭제 */
	public static final String RSRC_REQ_TY_CD_CLSTR_ADD = "07";	/* 클러스터추가 */
	public static final String RSRC_REQ_TY_CD_CLSTR_DEL = "08";	/* 클러스터삭제 */
	public static final String RSRC_REQ_TY_CD_VM_STRG_ADD = "09";	/* 가상서버스토리지추가 */
	public static final String RSRC_REQ_TY_CD_VM_STRG_DEL = "10";	/* 가상서버스토리지삭제 */

	public static final String PROCESS_REF_JOB_KEY_VM_MIG = "MIG";	/* 프로세스인스턴서의 참조업무키 */
	public static final String PROCESS_REF_JOB_KEY_VM_SNAP_CRE = "SNAP_CRE";	/* 프로세스인스턴서의 참조업무키 */
	public static final String PROCESS_REF_JOB_KEY_VM_SNAP_RESTOR = "SNAP_RESTOR";	/* 프로세스인스턴서의 참조업무키 */
	public static final String PROCESS_REF_JOB_KEY_VM_SNAP_DEL = "SNAP_DEL";	/* 프로세스인스턴서의 참조업무키 */

	public static final String RSRC_REQ_STRG_MOVE_VAL_NM = "strgMoveFlag"; /* 스토리지도메인 이동 여부를 판단하는 프로세스 변수명 */
	public static final String RSRC_REQ_HA_VAL_NM = "haFlag"; /* 가상서버생성시 HA 여부를 판단하는 프로세스 변수명 */
	public static final String REQ_JSON_DATA_NM = "jsonData"; /* API호출 JSON형태의 데이터 정보 셋팅을 위한 프로세스 변수명 */
	public static final String REQ_VM_SEQ_NM = "vmSeq"; /* 가상서버SEQ저장을위한 프로세스 변수명 */
	public static final String REQ_REQ_KEY_NM = "reqKey"; /* 프로세스를 호출한 업무Key저장을 위한 프로세스 변수명 */
	public static final String REQ_REQ_TITLE_NM = "title"; /* 프로세스를 호출한 업무 제목 저장을 위한 프로세스 변수명 */
	public static final String REQ_REQ_USERID_NM = "userId"; /* 프로세스를 호출한 사용자 저장을 위한 프로세스 변수명 */
	public static final String RSRC_REQ_VM_STOP_VAL_NM = "vmStopFlag"; /* 가상서버중지여부 */
	public static final String RSRC_REQ_VOLUME_CREATE_VAL_NM = "volumeCreateFlag"; /* 볼륨생셩여부 */

	public static final String DISTRB_FILE_DEFAUlT_PATH = "/tmp/ncis";	/*배포 첨부파일 default 경로*/

	public static final String USE_YN_Y = "Y";	/* 시용여부 Y */
	public static final String USE_YN_N = "N";	/* 시용여부 N */

	public static final String SEQ_CRE_CLASSFY = "GW_IF_JOB";
	public static final String SEQ_CRE_PREFIX = "GWJob";

	public static final String SUCCESS_MSG = "정상 처리되었습니다.";
    public static final String ERROR_MSG = "오류가 발생하였습니다.";

    public static final String ERROR_MSG_PM_IS_NULL = "물리서버가 존재하지 않습니다.";
    public static final String ERROR_MSG_PM_INVALID_STATUS = "물리서버 상태가 적합하지 않습니다.";
    public static final String ERROR_MSG_PM_HAVING_VM = "물리서버 하위에 가상서버가 있습니다.";
    public static final String ERROR_MSG_PM_NOT_EQUALS_REQ_PM = "요청한 물리서버와 일치하지 않습니다.";

    /// 물리서버 상태
    public static final String PM_STAT_CD_OFF = "01"; //물리서버상태-다운(OFF)
    public static final String PM_STAT_CD_UP = "02"; //물리서버상태-업(UP)
    public static final String PM_STAT_CD_MAINTAIN = "03"; //물리서버상태-유지보수
    public static final String PM_STAT_CD_PROCSS = "04"; //물리서버상태-처리중
    public static final String PM_STAT_CD_EXCEPTION = "05"; //물리서버상태-예외

    public static final String VM_ROOT_ID = "root"; // 가상서버 Root Id

    //사전배포 default namespace 설정 변수
    public static final String DEMONSET_OPENSHIFT= "openshift";

}
