///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	TrustPKI Enterprise Client Toolkit 공통 스크립트 v1.1
//
//	Version	|	Date			|	Comment
//	v1.0		|	2015.06.11	|	* 최초 작성.
//  v1.1		|	2015.11.25	|	* Non-ActiveX 전용으로 수정, WSS 기본접속으로 수정, 브라우저별로 URL 적용되도록 수정
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	TrustPKI Enterprise Client Toolkit 설정을 위한 환경 변수
//
// 1. 초기화를 위한 환경 변수
// CQWEB_SERVICE_NAME = 서비스명
// CQWEBID_SERVICE_NAME = 서비스명
// TPKIENT_SERVICE_URL = 서비스 호스트 URL(하위에 "/CQWeb" 이라는 디렉터리가 존재해야 함.)
//
// 2. Non-ActiveX TrustPKI Enterprise Client 버전
// TPKIENT_NX_VERSION = 버전
//
// 3. TrustPKI Enterprise Client 관리자 설치
// var CQWEB_EXE = 파일경로(EXE)
// var CQWEB_INSTALL_PAGE = 설치페이지 URL
//
// 4. 휴대폰 인증서 설정 (Ubikey)
// var SET_MPSTORECONF = 적용: "ON" / 미적용: "OFF"
// - 적용 시 아래 설정 필요
// - Ubikey 휴대폰 인증서 서비스 용 데이터 설정
// 	** download.html 내의 설정이 동일한 지 확인(ubikeyVersion, ubikeyObj)
// var POPUP_INSTALL_URL = 팝업 설치 페이지 경로
// var POPUP_WINDOW_SIZE = 팝업 설치 페이지 사이즈
// var UBIKEY_VERSION = Ubikey 버전
// var SERVICE_INFO = 서비스 정보
// var SECURE_CODE = 보안코드
//
// 5. 다이얼로그 "취소" 버튼 클릭 시 에러 메시지 출력 여부 설정
// var SET_CANCELERROR = 적용: "ON" / 미적용: "OFF"
//
// 6. 다이얼로그 휴대폰 인증서 서비스 사용 여부 설정
// var SET_MPSTORECONF = 적용: "ON" / 미적용: "OFF"
//
// 7. 업데이트 관리자 사용 여부 설정
// var SET_UPDATEMANAGER = 적용: "ON" / 미적용: "OFF"
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//var console = window.console || { log: function() {} };

var SERVICE_NAME = "NCMS";
var ID_SERVICE_NAME = "NCMSID";
var HOST = location.host;
var SERVICE_URL = "http://{HOST}/resources/NX_TPKIENT".replace(/{HOST}/, HOST);

var TPKIENT_CONNECT_URL = "";
var TPKIENT_NX_VERSION = "1.0.8.1";

//
var TPKIENT_EXE = "http://{HOST}/resources/NX_TPKIENT/CQWeb/nxtpkient_v1081.exe".replace(/{HOST}/, HOST);
//var TPKIENT_EXE = "http://localhost:8080/resources/NX_TPKIENT/CQWeb/nxtpkient.exe";
//var TPKIENT_INSTALL_PAGE = "http://10.64.3.249:80/NX_TPKIENT/Install/InstallProc.html";
//var TPKIENT_INSTALL_PAGE = "http://10.64.3.249:80/NX_TPKIENT/Install/InstallNX.html";
var TPKIENT_INSTALL_PAGE = "http://{HOST}/resources/NX_TPKIENT/Install/InstallNX.html".replace(/{HOST}/, HOST);

var POPUP_INSTALL_URL = "http://{HOST}/resources/NX_TPKIENT/Infovine/download.html".replace(/{HOST}/, HOST);  //경로
var POPUP_WINDOW_SIZE = "Width=450|Height=400";
var UBIKEY_VERSION = "1,4,0,5";  //버전
var SERVICE_INFO = "EKCC|";
var SECURE_CODE = "BCQRE|KINGS_INFOVINE|";
var SET_CANCELERROR = "OFF";
var SET_MPSTORECONF = "ON";

// 통합설치 프로그램 사용시 UpdateManager에서 버전관리 하지 않도록 설정
var SET_UPDATEMANAGER = "ON";
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

var USER_OS = null;
var USER_BROWSER = null;

// WebSocket
var WEBSOCKET = null;
var WEBSOCKET_RECVDATA = null;
var WEBSOCKET_CONNECT = false;
var WEBSOCKET_SETUP = false;

var UNSUPPORTED = 0;

// OS
var MICROSOFT_WINDOWS = 1;
var MICROSOFT_WINDOWS_64 = 2;

// BROWSER
var MOZILLA_FF = 10;
var APPLE_SAFARI = 11;
var GOOGLE_CHROME = 12;
var OPERASOFTWARE_OPERA = 13;
var MICOROSOFT_IE7 = 14
var MICOROSOFT_IE8 = 15;
var MICOROSOFT_IE9 = 16;
var MICOROSOFT_IE9_X64 = 17;
var MICOROSOFT_IE10 = 18;
var MICOROSOFT_IE11 = 19;
var MICOROSOFT_EDGE = 20;

// AlgID
var CQWEBALG_SEED = 10;
var CQWEBALG_AES128 = 16;
var CQWEBALG_AES256 = 17;
var CQWEBALG_ARIA128 = 18;
var CQWEBALG_ARIA256 = 19;

// HashAlgID
var CQWEBHASHALG_MD2 = 0;
var CQWEBHASHALG_MD4 = 1;
var CQWEBHASHALG_MD5 = 2;
var CQWEBHASHALG_RIPEMD160 = 3;
var CQWEBHASHALG_SHA1 = 4;
var CQWEBHASHALG_HAS160 = 5;
var CQWEBHASHALG_SHA256 = 6;
var CQWEBHASHALG_SHA384 = 7;
var CQWEBHASHALG_SHA512 = 8;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Client Toolkit Install & Check Function
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//플래시 소켓 접속을 위한 스크립트 Include
document.writeln("<script language='javascript' src='/resources/NX_TPKIENT/SettingForClient/json2.js'></script>");
document.writeln("<script language='javascript' src='/resources/NX_TPKIENT/SettingForClient/sockManager.js'></script>");
document.writeln("<link rel='stylesheet' type='text/css' href='/resources/NX_TPKIENT/SettingForClient/loader.css'>");
document.writeln("<script language='javascript' src='/resources/NX_TPKIENT/SettingForClient/spin.js'></script>");
document.writeln("<script language='javascript' src='/resources/NX_TPKIENT/SettingForClient/spin.min.js'></script>");

var spinner;
var target;

function loader()
{
	var loadingbar = document.getElementById('loadingbar');
	loadingbar.style.display = "block";

	var opts = {
	  lines: 13 // The number of lines to draw
	, length: 1 // The length of each line
	, width: 10 // The line thickness
	, radius: 20 // The radius of the inner circle
	, scale: 1 // Scales overall size of the spinner
	, corners: 1 // Corner roundness (0..1)
	, color: '#045FB4' // #rgb or #rrggbb or array of colors
	, opacity: 0.15 // Opacity of the lines
	, rotate: 0 // The rotation offset
	, direction: 1 // 1: clockwise, -1: counterclockwise
	, speed: 1 // Rounds per second
	, trail: 60 // Afterglow percentage
	, fps: 20 // Frames per second when using setTimeout() as a fallback for CSS
	, zIndex: 2e9 // The z-index (defaults to 2000000000)
	, className: 'spinner' // The CSS class to assign to the spinner
	, top: '50%' // Top position relative to parent
	, left: '50%' // Left position relative to parent
	, shadow: false // Whether to render a shadow
	, hwaccel: false // Whether to use hardware acceleration
	, position: 'absolute' // Element positioning
	}
	target = document.getElementById('loader')
	spinner = new Spinner(opts).spin(target);
}


// 사용자의 운영체제를 확인합니다.
function DetectedOS()
{
	var strPlatform = navigator.platform.toLowerCase();
	 // alert(strPlatform);//debug

	if(strPlatform.match("win32") != null)
	{
		return MICROSOFT_WINDOWS;
	}
	else if(strPlatform.match("win64") != null)
	{
		return MICROSOFT_WINDOWS_64;
	}

	return UNSUPPORTED;
}

// 사용자의 브라우저를 확인합니다.
// 사용자의 브라우저를 확인합니다.
function DetectedBrowser()
{
	var strUserAgent;
	var strPatternIE = /trident/i;
	var strPatternEdge = /edge/i;
	var strPatternFireFox = /firefox/i;
	var strPatternChrome = /chrome/i;
	var strPatternOPera = /opr/i;
	var strPatternSafari = /Version/i;

	strUserAgent = navigator.userAgent.toLowerCase();
  //alert(strUserAgent);//debug

        if(strPatternFireFox.test(strUserAgent) == true)
	{
		return MOZILLA_FF;
	}
	else if(strPatternChrome.test(strUserAgent) == true)
	{
		if(strPatternOPera.test(strUserAgent) == true)
		{
			return OPERASOFTWARE_OPERA;
		}
		else if(strPatternEdge.test(strUserAgent) == true)
		{
			return MICOROSOFT_EDGE;
		}
		else if(strPatternSafari.test(strUserAgent) == true)
		{
			return APPLE_SAFARI;
		}
		else
		{
			return GOOGLE_CHROME;
		}
	}
	else if(	strUserAgent.match("msie 7.0") != null)
	{
		return MICOROSOFT_IE7;
	}
	else if(strPatternIE.test(strUserAgent) == true)
	{
		if(strUserAgent.match("trident/4.0") != null)
		{
			return MICOROSOFT_IE8;
		}
		else if(strUserAgent.match("trident/5.0") != null)
		{
			if(strUserAgent.match("win64; x64") != null)
			{
				return MICOROSOFT_IE9_X64;
			}
			else
			{
				return MICOROSOFT_IE9;
			}
		}
		else if(strUserAgent.match("trident/6.0") != null)
		{
			return MICOROSOFT_IE10;
		}
		else if(strUserAgent.match("trident/7.0") != null)
		{
			return MICOROSOFT_IE11;
		}
	}

	return UNSUPPORTED;
}

// 클라이언트 메소드 호출 실패 시 오류를 출력합니다.
function SetupError()
{
	alert("TrustPKI가 지원하지 않는 운영체제 혹은 브라우저를 사용 중이시거나, Object 선언이 올바르지 않습니다.\n\n관리자에게 문의하여 주시기 바랍니다.");
	return;
}

// 오류코드의 자릿수를 맞춥니다.
function lpad(src, len, padStr)
{
	var retStr = "";
	var padCnt = Number(len) - String(src).length;
	for(var i=0;i<padCnt;i++) retStr += String(padStr);
	return retStr+src;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// 클라이언트 체크 및 설정
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function CheckClient_login(usedInstallPage)
{
	USER_OS = DetectedOS();
	USER_BROWSER = DetectedBrowser();

	if(USER_OS == UNSUPPORTED || USER_BROWSER == UNSUPPORTED)
	{
		alert("TrustPKI가 지원하지 않는\n운영체제 및 브라우저를 사용 중 입니다.\n\n[Supported OS]\nWindowsXP(32bit, 64bit) 이상  지원합니다.\n\n[Supported Browser]\nMicrosoft Internet Explorer(7.0 이상, 32bit, 64bit)\nSafari(5.0 이상)\nMozilla Firefox , Google Chrome, Opera\n최신버전을 지원합니다.");
		return -1;
	}
	else
	{
		if((USER_BROWSER >= MICOROSOFT_IE7) && (USER_BROWSER <= MICOROSOFT_EDGE))
		{
			TPKIENT_CONNECT_URL = "wss://127.0.0.1:52075"; //"wss://127.0.0.1:52073"; 52075
		}
		else
		{
			TPKIENT_CONNECT_URL = "wss://localhost:52075"; //"ws://localhost:51629";  51631
		}

		if(WEBSOCKET == null)
		{
			WEBSOCKET = new WebSocket(TPKIENT_CONNECT_URL);

			// WebSocket Event 설정
			WEBSOCKET.onopen = function(evt)
			{
				console.log("클라이언트가 연결 되었습니다.");

				if(SET_UPDATEMANAGER == "ON")
				{
//					StartAgent();
				}
				else if(SET_UPDATEMANAGER == "OFF")
				{
//					var params = new Object();
//					params.funcname = "SetUpdateManager";
//					params.productcode = "PKI_ENT";
//					WEBSOCKET.send(JSON.stringify(params));
//					alert(WEBSOCKET.send(JSON.stringify(params)));
				}
//				var params = new Object();
//				params.funcname = "StartAgent";
//				params.productcode = "PKI_ENT";
//				params.agentversion = TPKIENT_NX_VERSION;
//				params.setupurl = TPKIENT_EXE;
//				WEBSOCKET.send(JSON.stringify(params));

//				console.log("MSG SIZE = " + JSON.stringify(params).length);
//				if (CURRENT_VERSION != TPKIENT_NX_VERSION)
//				{
//					location.href = TPKIENT_INSTALL_PAGE_LOGIN
//				}
				WEBSOCKET_SETUP = true;
			};
			WEBSOCKET.onclose = function(evt)
			{
				if(WEBSOCKET_SETUP == false)
				{
					if(usedInstallPage == true)
					{
						// WebSocket 서비스가 동작하지 않는 경우 설치 페이지로 이동 합니다.
							location.href = TPKIENT_INSTALL_PAGE_LOGIN
					}
					else
					{
						// 설치페이지 미사용시 해당 페이지에서 파일을 바로 다운로드 합니다.
						location.href = TPKIENT_EXE;
					}
				}
			};
			WEBSOCKET.onmessage = function(evt)
			{
				var object = JSON.parse(evt.data);
				var funcName = object.funcname;
				var returnValue = object.result;
				var errNum = object.errnum;
				var errMsg = object.errmsg;

				OnMessage(funcName, returnValue, errNum, errMsg);
			};
		}
	}

	return 0;
}

function CheckClient(usedInstallPage)
{

	console.log( "CheckClient------------------------------------");
	USER_OS = DetectedOS();
	USER_BROWSER = DetectedBrowser();

	if(USER_OS == UNSUPPORTED || USER_BROWSER == UNSUPPORTED)
	{
		alert("TrustPKI가 지원하지 않는\n운영체제 및 브라우저를 사용 중 입니다.\n\n[Supported OS]\nWindowsXP(32bit, 64bit) 이상  지원합니다.\n\n[Supported Browser]\nMicrosoft Internet Explorer(7.0 이상, 32bit, 64bit)\nSafari(5.0 이상)\nMozilla Firefox , Google Chrome, Opera\n최신버전을 지원합니다.");
		return -1;
	}
	else
	{
		if((USER_BROWSER >= MICOROSOFT_IE7) && (USER_BROWSER <= MICOROSOFT_EDGE))
		{
			TPKIENT_CONNECT_URL = "wss://127.0.0.1:52075"; //"wss://127.0.0.1:52073";
		}
		else
		{
			TPKIENT_CONNECT_URL = "wss://localhost:52075"; //"ws://localhost:51629";
		}

		if(WEBSOCKET == null)
		{
			WEBSOCKET = new WebSocket(TPKIENT_CONNECT_URL);

			// WebSocket Event 설정
			WEBSOCKET.onopen = function(evt)
			{
				console.log("클라이언트가 연결 되었습니다.");

				if(SET_UPDATEMANAGER == "ON")
				{
//					StartAgent();
				}
				else if(SET_UPDATEMANAGER == "OFF")
				{
//					var params = new Object();
//					params.funcname = "SetUpdateManager";
//					params.productcode = "PKI_ENT";
//					WEBSOCKET.send(JSON.stringify(params));
//					alert(WEBSOCKET.send(JSON.stringify(params)));
				}
//				var params = new Object();
//				params.funcname = "StartAgent";
//				params.productcode = "PKI_ENT";
//				params.agentversion = TPKIENT_NX_VERSION;
//				params.setupurl = TPKIENT_EXE;
//				WEBSOCKET.send(JSON.stringify(params));

//				console.log("MSG SIZE = " + JSON.stringify(params).length);
//				if (CURRENT_VERSION != TPKIENT_NX_VERSION)
//				{
//					location.href = TPKIENT_INSTALL_PAGE_LOGIN
//				}
				WEBSOCKET_SETUP = true;
			};
			WEBSOCKET.onclose = function(evt)
			{
				if(WEBSOCKET_SETUP == false)
				{
					if(usedInstallPage == true)
					{
						// WebSocket 서비스가 동작하지 않는 경우 설치 페이지로 이동 합니다.
							location.href = TPKIENT_INSTALL_PAGE_LOGIN
					}
					else
					{
						// 설치페이지 미사용시 해당 페이지에서 파일을 바로 다운로드 합니다.
						location.href = TPKIENT_EXE;
					}
				}
			};
			WEBSOCKET.onmessage = function(evt)
			{
				var object = JSON.parse(evt.data);
				var funcName = object.funcname;
				var returnValue = object.result;
				var errNum = object.errnum;
				var errMsg = object.errmsg;

				OnMessage(funcName, returnValue, errNum, errMsg);
			};
		}
	}

	return 0;
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// 클라이언트에서 제공하는 API
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 클라이언트의 에이전트를 시작합니다.
function StartAgent()
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_StartAgent);
	}
}

// 클라이언트의 버전관리 사용 여부를 설정합니다.
// 성공 : 문자열로 된 클라이언트 버전 반환
// 실패 : "none" 문자열 반환
function SetUpdateManager()
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_SetUpdateManager);
	}
}

// 보안토큰의 사용 여부를 설정합니다.
function SetUseSecureToken(strValue)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_SetParam, "UseSecureToken", strValue);
	}
}

// 인증서 비밀번호의 입력횟수를 제한 합니다.
function SetPasswordInputLimit(strValue)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_SetParam, "PasswordInputCount", strValue);
	}
}

// 모바일 인증서 서비스를 사용하도록 설정합니다.
function SetMobileCertService()
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_SetParam, "MPStoreConf", POPUP_INSTALL_URL + "&" + POPUP_WINDOW_SIZE + "&" + UBIKEY_VERSION + "&" + SERVICE_INFO + "&" + SECURE_CODE);
	}
}

// Client Toolkit 초기화 합니다.
// 성공: 0
// 실패: -1
function Init()
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWIInit, SERVICE_NAME, SERVICE_URL);
	}
}

// 보안 채널이 형성된 후에 디폴트 spf(서명 옵션)를 참조하여 데이터 서명을 수행합니다.
// 이 메소드는 기존 버전과의 호환성을 위해서만 존재합니다. (KITA 납품 툴킷에 적용되는 메소드)
// 성공: Base64형태로 인코딩된 서명된 문자열
// 실패: ""(빈 문자열)
function SignData(inDataFlag, strDN, strCAType, strData, storageType)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWISignData, inDataFlag, strDN, strCAType, strData, storageType);
	}
}

// 전자서명문에 대한 검증을 수행하고, 서명 원문을 반환합니다.
// 성공: 전자서명 검증이 된 서명 원문
// 실패: ""(빈 문자열)
function VerifyData(strSpfName, inDataFlag, strSignedData, strOriginalData)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWIVerifyData, strSpfName, inDataFlag, strSignedData, strOriginalData);
	}
}

// 인자로 주어진 Base 64형태로 인코딩 된 인증서의 정보를 얻습니다.
// 성공: 선택한 인증서 필드에 해당하는 문자열
// 실패: ""(빈 문자열)
function GetCertInfoFromSignedData(strSignedData, strFieldName)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWIGetCertInfoFromSignedData, strSignedData);
	}
}

// 인증서 기반 사용자 인증 및 클라리언트와 서버 간 보안 채널 요청 데이터를 생성합니다.
// 성공: 보안채널 요청 데이터
// 실패: ""(빈 문자열)
function SessionRequestWithSignature(strSpfName, inDataFlag, strDN, strCAType, strSessionID, algID, storageType)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWISessionRequestWithSignature, strSpfName, inDataFlag, strDN, strCAType, strSessionID, algID, storageType);
	}
}

// 보안 채널 종료 시 호출하며, 세션과 관련된 정보를 삭제합니다.
// 성공: 0
// 실패: -1
function SessionDestroy(strSessionID)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_SessionDestroy, strSessionID);
	}
}

// 보안 채널이 형성된 후에 공유된 키를 사용하여 대칭키 암호화를 수행합니다.
// 성공: Base64형태로 인코딩된 암호 문자열
// 실패: ""(빈 문자열)
function SessionEncrypt(strSessionID, strData)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWISessionEncrypt, strSessionID, strData);
	}
}

// 보안 채널이 형성된 후에 공유된 키를 사용하여 대칭키 복호화를 수행합니다.
// 성공: 복호화된 문자열
// 실패: ""(빈 문자열)
function SessionDecrypt(strSessionID, strEncryptedData)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWISessionDecrypt, strSessionID, strEncryptedData);
	}
}

// 대칭키 암/복호화에 사용할 임의의 대칭 키를 생성합니다.
// 성공: Base64형태로 인코딩 된 대칭키
// 실패: ""(빈 문자열)
function GenSymKey(algID)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWIGenSymKey, algID);
	}
}

// 입력한 키로 평문을 대칭키 암호화 합니다.
// 성공: Base64형태로 인코딩된 암호 문자열
// 실패: ""(빈 문자열)
function EncryptData(algID, symKey, strData)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWIEncryptData, algID, symKey, strData);
	}
}

// 입력한 키로 암호문을 대칭키 복호화 합니다.
// 성공: 복호화된 평문 문자열
// 실패: ""(빈 문자열)
function DecryptData(algID, symKey, strData)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWIDecryptData, algID, symKey, strData);
	}
}

// 평문을 Envelop형태로 암호화 한다.
// 성공: Base 64형태로 인코딩 된 암호 문자열
// 실패: ""(빈 문자열)
function EnvelopData(strEpfName, strData)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWIEnvelopData, strEpfName, strData);
	}
}

// Envelop형태로 암호화된 데이터를 Develop하여 평문을 반환합니다.
// 성공: 복호화 한 평문 문자열
// 실패: ""(빈 문자열)
function DevelopData(strEpfName, strEnvelopedData)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWIDevelopData, strEpfName, strEnvelopedData);
	}
}

// 신원확인 정보를 이용한 인증서 기반의 사용자 인증을 수행합니다.
// 성공: 신원확인 용 인증서 로그인 요청 데이터
// 실패: ""(빈 문자열)
function RequestCheckUserID(strDnFilter, strCAType, strUserID)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWIRequestCheckUserID, strDnFilter, strCAType, strUserID);
	}
}

// 입력 된 데이터에 대한 해시를 수행합니다.
// 성공: 해시데이터
// 실패: ""(빈 문자열)
function Hash(nAlgID, nEncodeFlag, strData)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWIHash, nAlgID, nEncodeFlag, strData);
	}
}

// 인자로 주어진 스트링을 Base64인코딩합니다.
// 성공: Base64형태로 인코딩 된 스트링
// 실패: ""(빈 문자열)
function Base64Encode(strString)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWIBase64Encode, strString);
	}
}

// 인자로 주어진 스트링을 Base64인코딩합니다.
// 성공: Base64형태로 디코딩 된 스트링
// 실패: ""(빈 문자열)
function Base64Decode(strEncoded)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWIBase64Decode, strEncoded);
	}
}

// 원문파일에 대해 전자서명을 수행합니다.
// 성공: 0
// 실패: -1
function SignFile(inDataFlag, strDN, strCAType, strTextFile, strSignedFile, storageType, createdirFlag)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWISignFile, inDataFlag, strDN, strCAType, strTextFile, strSignedFile, storageType, createdirFlag);
	}
}

// RequestCheckUserID, RequestCheckUserIDWithFlag, SessionRequestWithSignature 함수 사용시 선택 한 인증서 DN을 반환합니다.
// 성공: DN 값
// 실패: ""(빈 문자열)
function GetSelectedCertDN()
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWIGetSelectedCertDN);
	}
}

// 신원확인 정보를 이용한 인증서 기반의 사용자 인증을 수행합니다.
// 성공: 신원확인 용 인증서 로그인 요청 데이터
// 실패: ""(빈 문자열)
// Flag : 0 - 정보저장 안함 1 - 정보 저장
function RequestCheckUserIDWithFlag(strDnFilter, strCAType, strUserID, nFlag)
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWIRequestCheckUserIDWithFlag, strDnFilter, strCAType, strUserID, nFlag);
	}
}


// 저장된 사용자의 신원확인 정보를 삭제합니다.
// 성공: 0
function DeleteUserInfo()
{
	if(WEBSOCKET != null)
	{
		WaitForSocketConnection(CALLBACK_CQWIDeleteUserInfo);
	}
}