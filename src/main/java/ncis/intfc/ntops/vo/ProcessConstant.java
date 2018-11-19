/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ProcessConstant.java
 *
 * @author hsLee
 * @lastmodifier hsLee
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     hsLee         v1.0             최초생성
 *
 */
package ncis.intfc.ntops.vo;


public class ProcessConstant {
	public ProcessConstant(){}


	private static final String NTOPS_REGION_ID = "DJ";

	public static String getNtopsRegionId() {
		return NTOPS_REGION_ID;
	}

	public static String getNtopsCreResultUpdtUrl()
	{
		return CRE_RESULT_UPDATE_URL;
	}

	public static String getNtopsModResultUpdtUrl()
	{
		return MODANDDEL_RESULT_UPDATE_URL;
	}

	/* NTOPS 생성 요청 결과 업데이트 URL */
	private static final String CRE_RESULT_UPDATE_URL = "/ntop/svm/insd/ClodCreRsltUpdSvc";
	private static final String MODANDDEL_RESULT_UPDATE_URL = "/ntop/svm/insd/ClodSpecChgRsltUpdSvc";

	//프로세스변수정보
	private static final String PROCESS_VAL_NM_JOB_ID = "jobId";        //JOB ID(프로세스 변수명)
	private static final String PROCESS_VAL_NM_VOLUME_ID = "volumeId";  //볼륨ID(프로세스 변수명)
	private static final String PROCESS_VAL_NM_HA_VOLUME_ID = "haVolumeId";  //HA볼륨ID(프로세스 변수명)
	private static final String PROCESS_VAL_NM_HEARTBEAT_VOLUME_ID = "heartbeatVolumeId";  //HEARTBEAT볼륨ID(프로세스 변수명)
	private static final String PROCESS_VAL_NM_HA_STRG_CREATE_FLAG = "haStrgCreateFlag";  //HA볼륨생성여부(프로세스 변수명)
	private static final String PROCESS_VAL_NM_HEARTBEAT_STRG_CREATE_FLAG = "heartbeatCreateFlag";  //HEARTBEAT볼륨생성여부(프로세스 변수명)
	private static final String PROCESS_VAL_NM_REQ_RTN_ID = "reqRtnId"; //요청응답ID(프로세스 변수명)
	private static final String PROCESS_VAL_NM_VOLUME_CREATE_FLAG = "volumeCreateFlag";  //볼륨생성여부(프로세스 변수명)

	private static final String BATCH_REG_USER_ID = "BATCH_ADMIN_PROCESS"; //등록자ID

	//알림정보
	private static final String ALRM_SBJCT_VM_CREATE = "가상서버가 정상적으로 생성되었습니다.";
	private static final String ALRM_SBJCT_VM_CREATE_TARGET_URL = "/cpt/opr/req/rsrcreq/selectRsrcReqVmCre.do?schRsrcReqNo=";
	private static final String ALRM_SBJCT_VM_DELETE = "가상서버가 정상적으로 삭제되었습니다.";
	private static final String ALRM_SBJCT_VM_DELETE_TARGET_URL = "/cpt/opr/req/rsrcreq/formRsrcReqVmDel.do?schRsrcReqNo=";
	private static final String ALRM_SBJCT_VM_SPEC_CHANGE = "가상서버 스펙이 정상적으로 변경되었습니다.";
	private static final String ALRM_SBJCT_VM_SPEC_CHANGE_TARGET_URL = "/cpt/opr/req/rsrcreq/formRsrcReqVmSpecChng.do?schRsrcReqNo=";
	private static final String ALRM_SBJCT_VM_STRG_ADD = "가상서버 스토리지가 정상적으로 추가되었습니다.";
	private static final String ALRM_SBJCT_VM_STRG_ADD_TARGET_URL = "/cpt/opr/req/rsrcreq/formRsrcReqVmSpecChng.do?schRsrcReqNo=";

	//프로세스정보
	private static final int VM_START_PROCESS_ID = 20160001; //VM생성 프로세스 아이디
	private static final int VM_SPECCHNG_PROCESS_ID = 20160002; //VM스펙변경 프로세스 아이디
	private static final int VM_STRGADD_PROCESS_ID = 20160003; //VM 스토리지추가 프로세스 아이디
	private static final int PM_ADD_PROCESS_ID = 20160004; //물리서버추가 프로세스 아이디
	private static final int PM_DEL_PROCESS_ID = 20160005; //물리서버삭제 프로세스 아이디
	private static final int CL_ADD_PROCESS_ID = 20160006; //클러스터추가 프로세스 아이디
	private static final int CL_DEL_PROCESS_ID = 20160007; //클러스터삭제 프로세스 아이디
	private static final int VM_DELETE_PROCESS_ID = 20160008; //가상서버삭제 프로세스 아이디

	//API Gateway 상태정보
	private static final String API_JOB_STAT_COMPLETE = "complete";  //API Gateway의 작업상태 - 완료
	private static final String API_JOB_STAT_PROGRESS = "in_progress"; //API Gateway의 작업상태 - 진행중
	private static final String API_JOB_STAT_FAILED = "failed";  //API Gateway의 작업상태 - 실패
	private static final String API_JOB_STAT_PENDING = "pending";  //API Gateway의 작업상태 - 팬딩

	//API URL정보
	private static final String VM_DETAIL_INFO_API_URL = "/machines/{id}";
	private static final String REQ_API_URL_VM_MIG= "/machines/{id}"; /* 가상서버 마이그래에션 API호출 URL */
	private static final String REQ_API_URL_VM_SNAP_CRE = "/machines/{id}/snapshots"; /* 스냅샷생성 API호출 URL */
	private static final String REQ_API_URL_VM_SNAP_RESTOR = "/machines/{id}/snapshots/{id2}"; /* 스냅샷복원 API호출 URL */
	private static final String REQ_API_URL_VM_SNAP_DEL = "/machines/{id}/snapshots/{id2}"; /* 스냅샷 삭제 API호출 URL */
	private static final String REQ_API_URL_VM_SNAP_DEL_SEARCH = "/machines/{id}/snapshots/{id2}"; /* 스냅샷 상세 API호출 URL */

	private static final Integer VM_DETAIL_INFO_API_TMP_SEQ = 100; //가상서버 상세조회시 임시 SEQ

	//API URL 키 구분값
	private static final String URL_KEY_STR_ID = "{id}";
	private static final String URL_KEY_STR_ID1 = "{id1}";
	private static final String URL_KEY_STR_ID2 = "{id2}";

	//API 호출시  Action 값
	private static final String ACTION_MOVE = "move";
	private static final String ACTION_START = "start";

	private static final String NTOPS_STAT_CD_IFM0000 = "IFM0000"; //nTops 결과전송 후 성공메시지
	private static final String NTOPS_STAT_CD_IFM0004 = "IFM0004"; //nTops 결과전송 후 수정 성공메시지

	private static final String REQ_API_URL_VAL_NM = "apiUrl"; /* API호출 URL 정보 셋팅을 위한 프로세스 변수명 */
	private static final String REQ_JSON_DATA_NM = "jsonData"; /* API호출 JSON형태의 데이터 정보 셋팅을 위한 프로세스 변수명 */

	private static final String ITFFC_JOB_ID_PRE_STR = "PUJ"; //API Gateway 작업상태 조회를 위한 키값의 앞 구분 값
	private static final String VMWARE_RTN_STR_AFTER = "after"; //VMWare인 경우 비동기 처리를 위한 약속된 변수값

	//자원요청상태코드
	private static final String RSRC_REQ_STAT_CD_03 = "03";  //완료
	private static final String RSRC_REQ_STAT_CD_05 = "05";  //오류

	//가상서버구분코드
	private static final String VM_CL_CD_01 = "01";  //컴퓨팅

	//가상서버 상태코드
	private static final String VM_STAT_CD_02 = "02";  //가동중

	//알림 상태코드
	private static final String ALRM_STAT_CD_01 = "01";  //알림

	//스냅샷 상태구분코드
	private static final String SNAPSHT_STAT_CD_01 = "01";  //생성
	private static final String SNAPSHT_STAT_CD_02 = "02";  //복원
	private static final String SNAPSHT_STAT_CD_03 = "03";  //삭제

	//프로세스,단위업무 상태코드
	private static final String STAT_CD_01 = "01"; //진행
	private static final String STAT_CD_02 = "02"; //완료
	private static final String STAT_CD_03 = "03"; //대기
	private static final String STAT_CD_04 = "04"; //오류

	//단위업무 유형
	private static final String JOB_TY_CD_01 = "01"; //인터페이스 단위업무
	private static final String JOB_TY_CD_02 = "02"; //일반 단위업무
	private static final String JOB_TY_CD_03 = "03"; //서브프로세스 단위업무

	// 가상서버 생성 프로세스의 단위업무 기능유형코드
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_01 = "01"; //가상서버 생성요청
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_02 = "02"; //가상서버 생성확인
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_03 = "03"; //스토리지 볼륨 이동
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_04 = "04"; //스토리지 볼륨 이동확인
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_05 = "05"; //네트워크 인터페이스 추가
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_06 = "06"; //네트워크 인터페이스 추가확인
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_07 = "07"; //가상서버 시작
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_08 = "08"; //가상서버 시작확인
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_09 = "09"; //nTOPS 가상서버 생성 결과정보 전송
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_10 = "10"; //HA가상볼륨생성요청
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_11 = "11"; //HA가상볼륨생성대기
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_12 = "12"; //HA가상볼륨적용요청
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_13 = "13"; //HA가상볼륨적용대기
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_14 = "14"; //Heartbeat가상볼륨생성요청
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_15 = "15"; //Heartbeat가상볼륨생성대기
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_16 = "16"; //Heartbeat가상볼륨적용요청
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_17 = "17"; //Heartbeat가상볼륨적용대기
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_100 = "100"; //네트워크인터페이스 생성

	//가상서버 스펙변경 프로세스의 단위업무 기능유형코드
	private static final String VM_SPEC_INTFC_FNCT_TY_CD_10 = "10"; //가상서버 스펙변경요청
	private static final String VM_SPEC_INTFC_FNCT_TY_CD_11 = "11"; //가상서버 스펙변경요청대기
	private static final String VM_SPEC_INTFC_FNCT_TY_CD_12 = "12"; //가상서버 스펙변경 가상서버 시작 요청
	private static final String VM_SPEC_INTFC_FNCT_TY_CD_13 = "13"; //가상서버 스펙변경 가상서버 시작확인
	private static final String VM_SPEC_INTFC_FNCT_TY_CD_14 = "14"; //nTOPS 가상서버 스펙변경 결과정보 전송

	//스토리지추가 프로세스의 단위업무 기능유형코드
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_20 = "20"; //가상볼륨 생성 요청
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_21 = "21"; //가상볼륨 생성확인
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_22 = "22"; //가상볼륨 적용 요청
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_23 = "23"; //가상볼륨 적용 대기
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_24 = "24"; //가상서버 시작요청
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_25 = "25"; //가상서버 시작 대기
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_26 = "26"; //nTOPS 스토리지추가 결과정보 전송

	//물리자원 프로세스의 단위업무 기능유형코드
	private static final String P_RSRC_INTFC_FNCT_TY_CD_30 = "30"; //물리서버추가 요청
	private static final String P_RSRC_INTFC_FNCT_TY_CD_31 = "31"; //물리서버추가 확인
	private static final String P_RSRC_INTFC_FNCT_TY_CD_40 = "40"; //물리서버삭제 요청
	private static final String P_RSRC_INTFC_FNCT_TY_CD_41 = "41"; //물리서버삭제 확인
	private static final String P_RSRC_INTFC_FNCT_TY_CD_50 = "50"; //클러스터추가 요청
	private static final String P_RSRC_INTFC_FNCT_TY_CD_51 = "51"; //클러스터추가 확인
	private static final String P_RSRC_INTFC_FNCT_TY_CD_60 = "60"; //클러스터삭제 요청
	private static final String P_RSRC_INTFC_FNCT_TY_CD_61 = "61"; //클러스터삭제 확인

	//가상서버 삭제 프로세스의 단위업무 기능유형코드
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_70 = "70"; //가상서버 삭제요청
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_71 = "71"; //가상서버 삭제확인
	private static final String VM_CREATE_INTFC_FNCT_TY_CD_72 = "72"; ///nTOPS 가상서버 삭제 결과정보 전송

	//공통요청 프로세스의 단위업무 기능유형코드
	private static final String COM_REQ_INTFC_FNCT_TY_CD_80 = "80"; //공통요청
	private static final String COM_REQ_INTFC_FNCT_TY_CD_81 = "81"; //공통요청 확인

	//API호출 결과 메시지
	private static final String API_SUCC_MSG = "성공";
	private static final String API_FAIL_MSG = "실패";
	private static final String API_PROGRESS_MSG = "진행";
	private static final String API_TIME_FORCE_SUCC_MSG = "강제성공(시간초과)";
	private static final String API_CONFLICT_FORCE_SUCC_MSG = "강제성공(충돌)";

	//오류메시지 구분 (오류발생시 메시지 타이틀)
	private static final String ERR_CATCH_MSG_01 = "[API처리오류] ";  //API수행시 에러가 발생했을경우
	private static final String ERR_CATCH_MSG_02 = "[API호출시간초과오류] "; //API호출시 시간초과로 응답을 받지 못해 에러가 발생했을경우
	private static final String ERR_CATCH_MSG_03 = "[업무처리오류] "; // API 수행은 정상처리 되었으나 후속으로 비지니스로직처리 시 에러가 발생했을경우
	private static final String ERR_CATCH_MSG_04 = "[API응답정보오류] API호출 후 응답정보(UUID)를 받지 못했습니다. "; // API 수행후 에러는 없으나 약속된 응답정보를 받지 못했을경우
	private static final String ERR_CATCH_MSG_05 = "[API처리충돌오류] 이미 해당 API가 처리되었습니다. "; // API 수행후 에러는 없으나 약속된 응답정보를 받지 못했을경우
	private static final String ERR_CATCH_MSG_06 = "[API잘못된인터페이스변수명오류] "; // API호출후 응답변수명이 일치하지 않을경우
	private static final String ERR_CATCH_MSG_07 = "[nTOPS처리오류] ";  //nTOPS결과전송 에러가 발생했을경우

	//오류코드
	private static final String BTCH_ERR_CD_01 = "01"; //API수행시 에러가 발생했을경우
	private static final String BTCH_ERR_CD_02 = "02"; ///API호출시 시간초과로 응답을 받지 못해 에러가 발생했을경우
	private static final String BTCH_ERR_CD_03 = "03"; //API 수행은 정상처리 되었으나 후속으로 비지니스로직처리 시 에러가 발생했을경우
	private static final String BTCH_ERR_CD_04 = "04"; //API 수행후 에러는 없으나 약속된 응답정보를 받지 못했을경우
	private static final String BTCH_ERR_CD_05 = "05"; //API가 이미 호출되어 중복 에러가 발생했을경우 (API 시간초과 오류로 인해 재 처리 시 이미 매니저에서 수행이 되었을경우)

	//가상서버작업이력 요청유형코드
	private static final String WRK_HIST_VM_REQ_TY_CD_01 = "01"; //가상서버생성
	private static final String WRK_HIST_VM_REQ_TY_CD_02 = "02"; //가상서버스펙변경
	private static final String WRK_HIST_VM_REQ_TY_CD_03 = "03"; //가상서버삭제
	private static final String WRK_HIST_VM_REQ_TY_CD_04 = "04"; //가상서버스토리지추가
	private static final String WRK_HIST_VM_REQ_TY_CD_05 = "05"; //마이그래이션
	private static final String WRK_HIST_VM_REQ_TY_CD_06 = "06"; //스냅샷생성
	private static final String WRK_HIST_VM_REQ_TY_CD_07 = "07"; //삭제
	private static final String WRK_HIST_VM_REQ_TY_CD_08 = "08"; //복원

	//배치 JOB ID
	private static final String BTCH_WRK_ID_COM_REQ_PROCESS_JOB = "comReqProcessJob"; //공통프로세스 JOB ID
	private static final String BTCH_WRK_ID_P_RSRC_PROCESS_JOB = "pRsrcProcessJob"; //물리자원 JOB ID
	private static final String BTCH_WRK_ID_VM_DELETE_PROCESS_JOB = "vmDeleteProcessJob"; //가상서버삭제 JOB ID
	private static final String BTCH_WRK_ID_VM_STORAGE_ADD_PROCESS_JOB = "vmStorageAddprocessJob"; //가상서버 스토리지추가 JOB ID
	private static final String BTCH_WRK_ID_VM_SPEC_CHANGE_PROCESS_JOB = "vmSpecChangeProcessJob"; //가상서버 스펙변경 JOB ID
	private static final String BTCH_WRK_ID_VM_CREATE_PROCESS_JOB = "vmCreateProcessJob"; //가상서버생성 JOB ID

	private static final String BTCH_LOG_ID_COM_REQ_PROCESS_JOB = "ncis.bat.process.comreq"; //공통프로세스 로그 ID
	private static final String BTCH_LOG_ID_P_RSRC_PROCESS_JOB = "ncis.bat.process.prsrc"; //물리자원 로그 ID
	private static final String BTCH_LOG_ID_VM_DELETE_PROCESS_JOB = "ncis.bat.process.vmdelete"; //가상서버삭제 로그 ID
	private static final String BTCH_LOG_ID_VM_STORAGE_ADD_PROCESS_JOB = "ncis.bat.process.vmstrgadd"; //가상서버 스토리지추가 로그 ID
	private static final String BTCH_LOG_ID_VM_SPEC_CHANGE_PROCESS_JOB = "ncis.bat.process.vmspec"; //가상서버 스펙변경 로그 ID
	private static final String BTCH_LOG_ID_VM_CREATE_PROCESS_JOB = "ncis.bat.process.vmcreate"; //가상서버생성 로그 ID
	private static final String BTCH_LOG_ID_FAIL = "ncis.bat.process.fail"; //실패 로그 ID

	//가상서버 상태
	private static final String VM_STATE_LOCKED = "image_locked"; //가상서버 Lock상태

	//가상서버 볼륨 상태
	private static final String VM_VOLUME_STATE_OK = "ok"; //가상서버 볼륨 정상

	//가상화SW유형코드
	private static final String VR_CNVR_SW_TY_CD_01 = "01"; // RHEV
	private static final String VR_CNVR_SW_TY_CD_02 = "02"; // VMWare
	private static final String VR_CNVR_SW_TY_CD_03 = "03"; // HP Integrity VM
	private static final String VR_CNVR_SW_TY_CD_04 = "04"; // IBM Power VM

	//디스크구분코드
	private static final String DSK_CL_CD_02 = "02"; // 가상서버디스크


	//공통요청참조업무ID
	private static final String COM_REQ_JOB_ID_MIG = "MIG"; // MIG
	private static final String COM_REQ_JOB_ID_SNAP_CRE = "SNAP_CRE"; // SNAP_CRE
	private static final String COM_REQ_JOB_ID_SNAP_RESTOR = "SNAP_RESTOR"; // SNAP_RESTOR
	private static final String COM_REQ_JOB_ID_SNAP_DEL = "SNAP_DEL"; // SNAP_DEL

	//nTOPS연계변수값
	private static final String NTOPS_RESULT_S = "S"; // 성공
	private static final String NTOPS_REQ_TYPE_STORAGE = "VM_ADD_STORAGE"; // 스토리지추가 결과정보 전송
	private static final String NTOPS_REQ_TYPE_VM_SPEC = "VM_SPEC"; // 가상서버 스펙변경 결과정보 전송
	private static final String NTOPS_REQ_TYPE_VM_DEL = "VM_DEL"; // 가상서버삭제 결과정보 전송

	//OS유형코드
	private static final String OS_TY_CD_01 = "01"; // LINUX
	private static final String OS_TY_CD_02 = "02"; // HP-UX
	private static final String OS_TY_CD_03 = "03"; // AIX
	private static final String OS_TY_CD_04 = "04"; // WINDOWS
	private static final String OS_TY_CD_05 = "05"; // x86
	private static final String OS_TY_CD_09 = "09"; // Solaris

	//Log레벨
	private static final String LOG_LEVEL_DEBUG = "DEBUG";
	private static final String LOG_LEVEL_INFO = "INFO";
	private static final String LOG_LEVEL_ERROR = "ERROR";

	private static final String HEARTBEAT_STRG_CAPACITY= "1"; // HEARTBEAT 스토리지용량 (1G로 고정)

	//스토리지할당정책 코드
	private static final String STRG_ASGN_POLICY_CD_01 = "01";  //Thin Provision
	private static final String STRG_ASGN_POLICY_CD_02 = "02";  //Preallocated

	public static String getApiProgressMsg() {
		return API_PROGRESS_MSG;
	}
	public static String getWrkHistVmReqTyCd01() {
		return WRK_HIST_VM_REQ_TY_CD_01;
	}
	public static String getWrkHistVmReqTyCd02() {
		return WRK_HIST_VM_REQ_TY_CD_02;
	}
	public static String getWrkHistVmReqTyCd03() {
		return WRK_HIST_VM_REQ_TY_CD_03;
	}
	public static String getWrkHistVmReqTyCd04() {
		return WRK_HIST_VM_REQ_TY_CD_04;
	}
	public static String getVmCreateIntfcFnctTyCd20() {
		return VM_CREATE_INTFC_FNCT_TY_CD_20;
	}
	public static String getVmCreateIntfcFnctTyCd21() {
		return VM_CREATE_INTFC_FNCT_TY_CD_21;
	}
	public static String getVmCreateIntfcFnctTyCd22() {
		return VM_CREATE_INTFC_FNCT_TY_CD_22;
	}
	public static String getVmCreateIntfcFnctTyCd23() {
		return VM_CREATE_INTFC_FNCT_TY_CD_23;
	}
	public static String getVmCreateIntfcFnctTyCd24() {
		return VM_CREATE_INTFC_FNCT_TY_CD_24;
	}
	public static String getVmCreateIntfcFnctTyCd25() {
		return VM_CREATE_INTFC_FNCT_TY_CD_25;
	}
	public static String getVmCreateIntfcFnctTyCd26() {
		return VM_CREATE_INTFC_FNCT_TY_CD_26;
	}
	public static String getpRsrcIntfcFnctTyCd30() {
		return P_RSRC_INTFC_FNCT_TY_CD_30;
	}
	public static String getpRsrcIntfcFnctTyCd31() {
		return P_RSRC_INTFC_FNCT_TY_CD_31;
	}
	public static String getpRsrcIntfcFnctTyCd40() {
		return P_RSRC_INTFC_FNCT_TY_CD_40;
	}
	public static String getpRsrcIntfcFnctTyCd41() {
		return P_RSRC_INTFC_FNCT_TY_CD_41;
	}
	public static String getpRsrcIntfcFnctTyCd50() {
		return P_RSRC_INTFC_FNCT_TY_CD_50;
	}
	public static String getpRsrcIntfcFnctTyCd51() {
		return P_RSRC_INTFC_FNCT_TY_CD_51;
	}
	public static String getpRsrcIntfcFnctTyCd60() {
		return P_RSRC_INTFC_FNCT_TY_CD_60;
	}
	public static String getpRsrcIntfcFnctTyCd61() {
		return P_RSRC_INTFC_FNCT_TY_CD_61;
	}
	public static String getVmSpecIntfcFnctTyCd10() {
		return VM_SPEC_INTFC_FNCT_TY_CD_10;
	}
	public static String getVmSpecIntfcFnctTyCd11() {
		return VM_SPEC_INTFC_FNCT_TY_CD_11;
	}
	public static String getVmSpecIntfcFnctTyCd12() {
		return VM_SPEC_INTFC_FNCT_TY_CD_12;
	}
	public static String getVmSpecIntfcFnctTyCd13() {
		return VM_SPEC_INTFC_FNCT_TY_CD_13;
	}
	public static String getVmSpecIntfcFnctTyCd14() {
		return VM_SPEC_INTFC_FNCT_TY_CD_14;
	}
	public static String getVmCreateIntfcFnctTyCd70() {
		return VM_CREATE_INTFC_FNCT_TY_CD_70;
	}
	public static String getVmCreateIntfcFnctTyCd71() {
		return VM_CREATE_INTFC_FNCT_TY_CD_71;
	}
	public static String getVmCreateIntfcFnctTyCd72() {
		return VM_CREATE_INTFC_FNCT_TY_CD_72;
	}
	public static String getComReqIntfcFnctTyCd80() {
		return COM_REQ_INTFC_FNCT_TY_CD_80;
	}
	public static String getComReqIntfcFnctTyCd81() {
		return COM_REQ_INTFC_FNCT_TY_CD_81;
	}
	public static String getApiSuccMsg() {
		return API_SUCC_MSG;
	}
	public static String getApiFailMsg() {
		return API_FAIL_MSG;
	}
	public static String getVmCreateIntfcFnctTyCd100() {
		return VM_CREATE_INTFC_FNCT_TY_CD_100;
	}
	public static String getStatCd01() {
		return STAT_CD_01;
	}
	public static String getStatCd02() {
		return STAT_CD_02;
	}
	public static String getStatCd03() {
		return STAT_CD_03;
	}
	public static String getStatCd04() {
		return STAT_CD_04;
	}
	public static String getJobTyCd01() {
		return JOB_TY_CD_01;
	}
	public static String getJobTyCd02() {
		return JOB_TY_CD_02;
	}
	public static String getJobTyCd03() {
		return JOB_TY_CD_03;
	}
	public static String getVmCreateIntfcFnctTyCd01() {
		return VM_CREATE_INTFC_FNCT_TY_CD_01;
	}
	public static String getVmCreateIntfcFnctTyCd02() {
		return VM_CREATE_INTFC_FNCT_TY_CD_02;
	}
	public static String getVmCreateIntfcFnctTyCd03() {
		return VM_CREATE_INTFC_FNCT_TY_CD_03;
	}
	public static String getVmCreateIntfcFnctTyCd04() {
		return VM_CREATE_INTFC_FNCT_TY_CD_04;
	}
	public static String getVmCreateIntfcFnctTyCd05() {
		return VM_CREATE_INTFC_FNCT_TY_CD_05;
	}
	public static String getVmCreateIntfcFnctTyCd06() {
		return VM_CREATE_INTFC_FNCT_TY_CD_06;
	}
	public static String getVmCreateIntfcFnctTyCd07() {
		return VM_CREATE_INTFC_FNCT_TY_CD_07;
	}
	public static String getVmCreateIntfcFnctTyCd08() {
		return VM_CREATE_INTFC_FNCT_TY_CD_08;
	}
	public static String getVmCreateIntfcFnctTyCd09() {
		return VM_CREATE_INTFC_FNCT_TY_CD_09;
	}
	public static String getVmCreateIntfcFnctTyCd10() {
		return VM_CREATE_INTFC_FNCT_TY_CD_10;
	}
	public static String getVmCreateIntfcFnctTyCd11() {
		return VM_CREATE_INTFC_FNCT_TY_CD_11;
	}
	public static String getVmCreateIntfcFnctTyCd12() {
		return VM_CREATE_INTFC_FNCT_TY_CD_12;
	}
	public static String getVmCreateIntfcFnctTyCd13() {
		return VM_CREATE_INTFC_FNCT_TY_CD_13;
	}
	public static String getVmCreateIntfcFnctTyCd14() {
		return VM_CREATE_INTFC_FNCT_TY_CD_14;
	}
	public static String getVmCreateIntfcFnctTyCd15() {
		return VM_CREATE_INTFC_FNCT_TY_CD_15;
	}
	public static String getVmCreateIntfcFnctTyCd16() {
		return VM_CREATE_INTFC_FNCT_TY_CD_16;
	}
	public static String getVmCreateIntfcFnctTyCd17() {
		return VM_CREATE_INTFC_FNCT_TY_CD_17;
	}
	public static String getProcessValNmJobId() {
		return PROCESS_VAL_NM_JOB_ID;
	}
	public static String getProcessValNmVolumeId() {
		return PROCESS_VAL_NM_VOLUME_ID;
	}
	public static String getProcessValNmHaVolumeId() {
		return PROCESS_VAL_NM_HA_VOLUME_ID;
	}
	public static String getProcessValNmHeartbeatVolumeId() {
		return PROCESS_VAL_NM_HEARTBEAT_VOLUME_ID;
	}
	public static String getProcessValNmHaStrgCreateFlag() {
		return PROCESS_VAL_NM_HA_STRG_CREATE_FLAG;
	}
	public static String getProcessValNmHeartbeatStrgCreateFlag() {
		return PROCESS_VAL_NM_HEARTBEAT_STRG_CREATE_FLAG;
	}
	public static String getBatchRegUserId() {
		return BATCH_REG_USER_ID;
	}
	public static String getAlrmSbjctVmCreate() {
		return ALRM_SBJCT_VM_CREATE;
	}
	public static String getAlrmSbjctVmCreateTargetUrl() {
		return ALRM_SBJCT_VM_CREATE_TARGET_URL;
	}
	public static String getAlrmSbjctVmDelete() {
		return ALRM_SBJCT_VM_DELETE;
	}
	public static String getAlrmSbjctVmDeleteTargetUrl() {
		return ALRM_SBJCT_VM_DELETE_TARGET_URL;
	}
	public static String getAlrmSbjctVmSpecChange() {
		return ALRM_SBJCT_VM_SPEC_CHANGE;
	}
	public static String getAlrmSbjctVmSpecChangeTargetUrl() {
		return ALRM_SBJCT_VM_SPEC_CHANGE_TARGET_URL;
	}
	public static String getAlrmSbjctVmStrgAdd() {
		return ALRM_SBJCT_VM_STRG_ADD;
	}
	public static String getAlrmSbjctVmStrgAddTargetUrl() {
		return ALRM_SBJCT_VM_STRG_ADD_TARGET_URL;
	}
	public static int getVmStartProcessId() {
		return VM_START_PROCESS_ID;
	}
	public static int getVmSpecchngProcessId() {
		return VM_SPECCHNG_PROCESS_ID;
	}
	public static int getVmStrgaddProcessId() {
		return VM_STRGADD_PROCESS_ID;
	}
	public static int getPmAddProcessId() {
		return PM_ADD_PROCESS_ID;
	}
	public static int getPmDelProcessId() {
		return PM_DEL_PROCESS_ID;
	}
	public static int getClAddProcessId() {
		return CL_ADD_PROCESS_ID;
	}
	public static int getClDelProcessId() {
		return CL_DEL_PROCESS_ID;
	}
	public static int getVmDeleteProcessId() {
		return VM_DELETE_PROCESS_ID;
	}
	public static String getApiJobStatComplete() {
		return API_JOB_STAT_COMPLETE;
	}
	public static String getApiJobStatProgress() {
		return API_JOB_STAT_PROGRESS;
	}
	public static String getApiJobStatFailed() {
		return API_JOB_STAT_FAILED;
	}
	public static String getApiJobStatPending() {
		return API_JOB_STAT_PENDING;
	}
	public static String getVmDetailInfoApiUrl() {
		return VM_DETAIL_INFO_API_URL;
	}
	public static String getReqApiUrlVmMig() {
		return REQ_API_URL_VM_MIG;
	}
	public static String getReqApiUrlVmSnapCre() {
		return REQ_API_URL_VM_SNAP_CRE;
	}
	public static String getReqApiUrlVmSnapRestor() {
		return REQ_API_URL_VM_SNAP_RESTOR;
	}
	public static String getReqApiUrlVmSnapDel() {
		return REQ_API_URL_VM_SNAP_DEL;
	}
	public static String getUrlKeyStrId() {
		return URL_KEY_STR_ID;
	}
	public static String getUrlKeyStrId1() {
		return URL_KEY_STR_ID1;
	}
	public static String getUrlKeyStrId2() {
		return URL_KEY_STR_ID2;
	}
	public static String getActionMove() {
		return ACTION_MOVE;
	}
	public static String getActionStart() {
		return ACTION_START;
	}
	public static String getNtopsStatCdIfm0000() {
		return NTOPS_STAT_CD_IFM0000;
	}
	public static String getNtopsStatCdIfm0004() {
		return NTOPS_STAT_CD_IFM0004;
	}
	public static String getReqApiUrlValNm() {
		return REQ_API_URL_VAL_NM;
	}
	public static String getReqJsonDataNm() {
		return REQ_JSON_DATA_NM;
	}
	public static String getReqApiUrlVmSnapDelSearch() {
		return REQ_API_URL_VM_SNAP_DEL_SEARCH;
	}
	public static Integer getVmDetailInfoApiTmpSeq() {
		return VM_DETAIL_INFO_API_TMP_SEQ;
	}
	public static String getProcessValNmReqRtnId() {
		return PROCESS_VAL_NM_REQ_RTN_ID;
	}
	public static String getItffcJobIdPreStr() {
		return ITFFC_JOB_ID_PRE_STR;
	}
	public static String getVmwareRtnStrAfter() {
		return VMWARE_RTN_STR_AFTER;
	}
	public static String getVmClCd01() {
		return VM_CL_CD_01;
	}
	public static String getVmStatCd02() {
		return VM_STAT_CD_02;
	}
	public static String getRsrcReqStatCd03() {
		return RSRC_REQ_STAT_CD_03;
	}
	public static String getAlrmStatCd01() {
		return ALRM_STAT_CD_01;
	}
	public static String getWrkHistVmReqTyCd05() {
		return WRK_HIST_VM_REQ_TY_CD_05;
	}
	public static String getWrkHistVmReqTyCd06() {
		return WRK_HIST_VM_REQ_TY_CD_06;
	}
	public static String getWrkHistVmReqTyCd07() {
		return WRK_HIST_VM_REQ_TY_CD_07;
	}
	public static String getWrkHistVmReqTyCd08() {
		return WRK_HIST_VM_REQ_TY_CD_08;
	}
	public static String getErrCatchMsg01() {
		return ERR_CATCH_MSG_01;
	}
	public static String getErrCatchMsg02() {
		return ERR_CATCH_MSG_02;
	}
	public static String getSnapshtStatCd01() {
		return SNAPSHT_STAT_CD_01;
	}
	public static String getSnapshtStatCd02() {
		return SNAPSHT_STAT_CD_02;
	}
	public static String getSnapshtStatCd03() {
		return SNAPSHT_STAT_CD_03;
	}
	public static String getErrCatchMsg03() {
		return ERR_CATCH_MSG_03;
	}
	public static String getRsrcReqStatCd05() {
		return RSRC_REQ_STAT_CD_05;
	}
	public static String getBtchWrkIdComReqProcessJob() {
		return BTCH_WRK_ID_COM_REQ_PROCESS_JOB;
	}
	public static String getBtchWrkIdPRsrcProcessJob() {
		return BTCH_WRK_ID_P_RSRC_PROCESS_JOB;
	}
	public static String getBtchWrkIdVmDeleteProcessJob() {
		return BTCH_WRK_ID_VM_DELETE_PROCESS_JOB;
	}
	public static String getBtchWrkIdVmStorageAddProcessJob() {
		return BTCH_WRK_ID_VM_STORAGE_ADD_PROCESS_JOB;
	}
	public static String getBtchWrkIdVmSpecChangeProcessJob() {
		return BTCH_WRK_ID_VM_SPEC_CHANGE_PROCESS_JOB;
	}
	public static String getBtchWrkIdVmCreateProcessJob() {
		return BTCH_WRK_ID_VM_CREATE_PROCESS_JOB;
	}
	public static String getBtchLogIdComReqProcessJob() {
		return BTCH_LOG_ID_COM_REQ_PROCESS_JOB;
	}
	public static String getBtchLogIdPRsrcProcessJob() {
		return BTCH_LOG_ID_P_RSRC_PROCESS_JOB;
	}
	public static String getBtchLogIdVmDeleteProcessJob() {
		return BTCH_LOG_ID_VM_DELETE_PROCESS_JOB;
	}
	public static String getBtchLogIdVmStorageAddProcessJob() {
		return BTCH_LOG_ID_VM_STORAGE_ADD_PROCESS_JOB;
	}
	public static String getBtchLogIdVmSpecChangeProcessJob() {
		return BTCH_LOG_ID_VM_SPEC_CHANGE_PROCESS_JOB;
	}
	public static String getBtchLogIdVmCreateProcessJob() {
		return BTCH_LOG_ID_VM_CREATE_PROCESS_JOB;
	}
	public static String getErrCatchMsg04() {
		return ERR_CATCH_MSG_04;
	}
	public static String getBtchErrCd01() {
		return BTCH_ERR_CD_01;
	}
	public static String getBtchErrCd02() {
		return BTCH_ERR_CD_02;
	}
	public static String getBtchErrCd03() {
		return BTCH_ERR_CD_03;
	}
	public static String getBtchErrCd04() {
		return BTCH_ERR_CD_04;
	}
	public static String getBtchErrCd05() {
		return BTCH_ERR_CD_05;
	}
	public static String getErrCatchMsg05() {
		return ERR_CATCH_MSG_05;
	}
	public static String getBtchLogIdFail() {
		return BTCH_LOG_ID_FAIL;
	}
	public static String getVmStateLocked() {
		return VM_STATE_LOCKED;
	}
	public static String getVmVolumeStateOk() {
		return VM_VOLUME_STATE_OK;
	}
	public static String getVrCnvrSwTyCd01() {
		return VR_CNVR_SW_TY_CD_01;
	}
	public static String getVrCnvrSwTyCd02() {
		return VR_CNVR_SW_TY_CD_02;
	}
	public static String getVrCnvrSwTyCd03() {
		return VR_CNVR_SW_TY_CD_03;
	}
	public static String getVrCnvrSwTyCd04() {
		return VR_CNVR_SW_TY_CD_04;
	}
	public static String getApiTimeForceSuccMsg() {
		return API_TIME_FORCE_SUCC_MSG;
	}
	public static String getApiConflictForceSuccMsg() {
		return API_CONFLICT_FORCE_SUCC_MSG;
	}
	public static String getErrCatchMsg06() {
		return ERR_CATCH_MSG_06;
	}
	public static String getErrCatchMsg07() {
		return ERR_CATCH_MSG_07;
	}
	public static String getDskClCd02() {
		return DSK_CL_CD_02;
	}
	public static String getOsTyCd01() {
		return OS_TY_CD_01;
	}
	public static String getOsTyCd02() {
		return OS_TY_CD_02;
	}
	public static String getOsTyCd03() {
		return OS_TY_CD_03;
	}
	public static String getOsTyCd04() {
		return OS_TY_CD_04;
	}
	public static String getOsTyCd05() {
		return OS_TY_CD_05;
	}
	public static String getOsTyCd09() {
		return OS_TY_CD_09;
	}
	public static String getComReqJobIdMig() {
		return COM_REQ_JOB_ID_MIG;
	}
	public static String getComReqJobIdSnapCre() {
		return COM_REQ_JOB_ID_SNAP_CRE;
	}
	public static String getComReqJobIdSnapRestor() {
		return COM_REQ_JOB_ID_SNAP_RESTOR;
	}
	public static String getComReqJobIdSnapDel() {
		return COM_REQ_JOB_ID_SNAP_DEL;
	}
	public static String getNtopsResultS() {
		return NTOPS_RESULT_S;
	}
	public static String getNtopsReqTypeStorage() {
		return NTOPS_REQ_TYPE_STORAGE;
	}
	public static String getNtopsReqTypeVmSpec() {
		return NTOPS_REQ_TYPE_VM_SPEC;
	}
	public static String getNtopsReqTypeVmDel() {
		return NTOPS_REQ_TYPE_VM_DEL;
	}
	public static String getLogLevelDebug() {
		return LOG_LEVEL_DEBUG;
	}
	public static String getLogLevelInfo() {
		return LOG_LEVEL_INFO;
	}
	public static String getLogLevelError() {
		return LOG_LEVEL_ERROR;
	}
	public static String getHeartbeatStrgCapacity() {
		return HEARTBEAT_STRG_CAPACITY;
	}
	public static String getProcessValNmVolumeCreateFlag() {
		return PROCESS_VAL_NM_VOLUME_CREATE_FLAG;
	}
	public static String getStrgAsgnPolicyCd01() {
		return STRG_ASGN_POLICY_CD_01;
	}
	public static String getStrgAsgnPolicyCd02() {
		return STRG_ASGN_POLICY_CD_02;
	}
}
