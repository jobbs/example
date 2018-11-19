<%@page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>전자서명/검증</title>
<meta http-equiv="Content-type" content="text/html;charset=euc-kr" />
<meta http-equiv='X-UA-Compatible' content='IE=EDGE'/>
<link href="css/default.css" rel="stylesheet" type="text/css" media="screen" />

<!-- RedBC TrustPKI Client Toolkit 공용 스크립트 -->
<script src="SettingForClient/NX_TPKIENT.js"></script>
<script src="SettingForClient/NX_TPKIENT_CALLBACK.js"></script>
<script language='javascript' src='SettingForClient/sockManager.js'></script>
<SCRIPT language="javascript">
// 클라이언트 ActiveX 및 Plug-in 설치 및 버전 체크, WebSocket 생성 후 연결.
// Parameter 는 InstallPage의 사용 여부를 나타냄.
// ture 설정시 사용 하는 InstallPage를 NX_TPKIENT.js CheckClient 함수를 수정해야 함.
CheckClient(false);

// 업데이트매니저를 통한 버전관리 및 설치 사용 여부에 따른 체크
if(SET_UPDATEMANAGER == "ON")
{
	StartAgent();
}
else if(SET_UPDATEMANAGER == "OFF")
{
	SetUpdateManager();
}

// WebSocket OnMessage 이벤트 발생시 호출 되는 함수 정의.
function OnMessage(funcName, returnValue, errNum, errMsg)
{
	console.log("funcName : " + funcName + ", " + "returnValue : " + returnValue);
	if(funcName == "System")
	{
		alert("TrustWeb 모듈에서 오류가 발생하였습니다.\n오류정보 : [0x" + lpad(errNum.toString(16).toUpperCase(), 8, "0") + "] - " + errMsg);
	}
	else if(funcName == "StartAgent")
	{
		// 초기화 함수, WebSocket이 지원되는 브라우저는 첫번째 실행 해야 하는 함수인 CQWIGetEnvironment 함수가 호출.
		// 그 이후의 작업은 OnMessage 함수를 정의하여 사용.
		Init();
	}
	else if(funcName == "CQWIInit")
	{
		if(returnValue == 0)
		{
			if(SET_MPSTORECONF == "ON")
			{
//				console.log("SetProperty");
//				WaitForSocketConnection(CALLBACK_SetParam, "MPStoreConf", POPUP_INSTALL_URL + "&" + POPUP_WINDOW_SIZE + "&" + UBIKEY_VERSION + "&" + SERVICE_INFO + "&" + SECURE_CODE);
				SetMobileCertService();
			}
		}
		else
		{
			//Error Msg 출력
			alert("TrustWeb 모듈에서 오류가 발생하였습니다.\n오류정보 : [0x" + lpad(errNum.toString(16).toUpperCase(), 8, "0") + "] - " + errMsg);
		}
	}
	else if(funcName == "CQWISignData")
	{
		var theForm = document.forms[0];

		if(returnValue == "")
		{
			//Error Msg 출력
			alert("TrustWeb 모듈에서 오류가 발생하였습니다.\n오류정보 : [0x" + lpad(errNum.toString(16).toUpperCase(), 8, "0") + "] - " + errMsg);
		}
		else
		{
			//전자서명 데이터 다음 페이지로 이동
			theForm.SignedMsg.value = returnValue;
			theForm.submit();
		}
	}
	else if(funcName == "SetParam")
	{
		if(returnValue != 0)
		{
			alert("TrustWeb 모듈에서 오류가 발생하였습니다.\n오류정보 : [0x" + lpad(errNum.toString(16).toUpperCase(), 8, "0") + "] - " + errMsg);
		}
	}
	else if(funcName == "SetUpdateManager")
	{
		if(returnValue == "none")
		{
			alert("TrustWeb 모듈에서 오류가 발생하였습니다.\n오류정보 : [0x" + lpad(errNum.toString(16).toUpperCase(), 8, "0") + "] - " + errMsg);
		}
		else
		{
			alert("Version : " + returnValue);
			StartAgent();
		}
	}
}

function CQWebSignData()
{
	var strDNFilter = ""; //모든 인증서
//	var strDNFilter = "o=Government of Korea"; //EPKI, GPKI 인증서 옵션
	var strCAFilter = "";
	var strResult = "";
	var theForm = document.forms[0];

	if(theForm.OrgMsg.value == "")
	{
		alert("전자서명 할 메시지가 입력되지 않았습니다.\n\n전자서명 할 메시지를 입력한 후, [다음] 버튼을 클릭하십시오.");
		return;
	}

	strResult = SignData(1, strDNFilter, strCAFilter, theForm.OrgMsg.value, 2);
	if(WEBSOCKET == null)
	{
		if(strResult == "")
		{
			TCTErrorInfo();
		}
		else
		{
			theForm.SignedMsg.value = strResult;
			theForm.submit();
		}
	}

}
</SCRIPT>
</head>
<body onload="loader()">
<div id="header">
	<div id="header_inner">
		<h1>전자서명/검증</h1>
		<div id="desc">TrustPKI 테스트 페이지</div>
	</div>
</div>
<div id="main">
<div id="rcol">
<div id="rcontent">
	<h2>클라이언트 데이터 전자서명</h2>
	<div class="box">
		<div class="box_inner">함수명 : <font color="green">CQWISignData()</font><br>
			<br>설명 : 로컬에 저장된 인증서 리스트를 매개변수로 입력 받은 DN 필터링과 CA 필터링을 하여 해당하는 인증서만 로딩하여 보여주고 사용자가 선택한 인증서 정보, 원문 포함 여부 Flag, 개인키 패스워드, 원문 정보를 이용하여 전자서명을 수행합니다.
			<br>성공 시 서명 된 데이터를 리턴하며, 실패 시 에러코드를 리턴합니다.
		</div>
	</div>
	<h3>절차</h3>
	<ol>
		<li><span>"전자서명 할 메시지"</span> 입력란에 전자서명 할 임의의 문자열을 입력한 후, <span>[다음]</span> 버튼을 클릭합니다.</li>
		<li>인증서 선택 대화상자가 화면에 표시되면 전자서명에 사용할 인증서를 선택한 다음 비밀번호 입력한 후, <span>[확인]</span> 버튼을 클릭합니다.</li>
		<li>다음 페이지에서 <span>"전자서명 할 메시지"</span> 와 <span>"서버 검증 메시지"</span> 의 내용이 동일한 지 확인합니다.</li>
	</ol>
	<h3>참고</h3>
	<ul>
		<li>문자열을 다시 입력 하려면, <span>[초기화]</span> 버튼을 클릭합니다.</li>
		<li>처음 페이지로 돌아가려면, <span>[이전]</span> 버튼을 클릭합니다.</li>
	</ul>
	<h3>실행</h3>
	<form name="send_form" action="SignData_Demo2_v2.jsp" method="post">
		<input type="hidden" name="SignedMsg"/>
		<div align="center">
		<table id="input_space" cellspacing="0" cellpadding="2" width="100%" align="center">
		<tr>
		<td class="input_field" width="30%">전자서명 할 메시지</td>
		<td class="input_data"><textarea name="OrgMsg" cols="60" rows="2" ></textarea></td>
		</tr>
		</table>
		</div>
		<div id="button_space" align="center">
			<input type="button" value="다음" onclick="CQWebSignData()"/>
		    <input type="reset" value="초기화"/>
		    <input type="button" value="이전" onclick="javascript:history.back()"/>
		</div>
	</form>
<!--	<div id="loadingbar" class="disabledisplay"></div>
	<div id="loader"></div> -->
</div>
</div>
</div>
<div id="footer">
	Copyright &copy; 2000-2015 SGA Solutions.
</div>
</body>
</html>
