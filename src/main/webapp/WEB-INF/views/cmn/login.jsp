                 <%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 14.
 * @lastmodified 2016. 10. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 14.     최진호         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<title><spring:message code="message.site.title"/></title>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui-1.12.0/jquery-ui.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/reset.css" />"><!-- css초기화 -->
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/font-awesome.min.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/ionicons.min.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">

<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-2.1.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-ui.js" />"></script>

<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.alerts.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js" />"></script>

<script type="text/javascript" src="<c:url value="/resources/js/common/respond.src.js" />"></script><!-- 미디어 쿼리 인식 -->
<script type="text/javascript" src="<c:url value="/resources/js/common/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.sparkline.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/custom.js" />"></script>

<script type="text/javascript" src="<c:url value="/resources/NX_TPKIENT/SettingForClient/NX_TPKIENT.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/NX_TPKIENT/SettingForClient/NX_TPKIENT_CALLBACK.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/NX_TPKIENT/SettingForClient/sockManager.js" />"></script>

<script type="text/javascript">
<c:if test="${error ne null }">
alert( "${error}" );
history.back();
</c:if>

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

 			var loadingbar = document.getElementById('loadingbar');
			loadingbar.style.display = "none";
			spinner.stop(target);

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
</script>

</head>
<body class="skin-potal potal-login"  onload="loader()">
<div class="wrapper">

  <!-- Main Area -->
  <aside class="wide-side">

	<section class="login">

        <h1>Cloud 통합관리시스템 로그인</h1>
        <div class="login-box">
          <div class="box">
              <div class="box-header">
                <h2 class="box-title">공인인증서 로그인</h2>
                <div class="box-title-comment">
                  <p>모든 서비스를 이용하기 위해서는 공인인증서 로그인을 필요로 합니다.</p>
                  <p>기존에 등록하지 않은 공인인증서는 등록 후 사용하실 수 있습니다.</p>
                </div>
              </div>
              <div class="box-body alignC">
                <button type="button" onclick="CQWebSignData()" class="btn btn-blue btn-lg btn-login"><i class="fa fa-unlock-alt"></i><p>공인인증서 로그인</p></button>
              </div><!-- /box-body -->
              <div class="box-footer">
                <button type="button" class="btn" title="인증서등록" onclick="window.open('<c:url value="/insertPKI.do"/>', '_blank', 'width=500, height=400' );"><i class="fa fa-edit"></i>인증서 등록</button>
               	<button type="button" class="btn" title="필수 프로그램 다운로드" onclick="doPKIDownload()"><i class="fa fa-download"></i>필수 프로그램 다운로드</button>
              </div>
            </div><!-- /box -->

        </div>
	</section><!-- /컨텐츠 -->
	<form name="send_form" method="post" action="<c:url value="/login/process" />">
		<input type="hidden" name="SignedMsg" />
		<input type="hidden" name="OrgMsg" value="nCMSLogin" />
	</form>
	<div id="loadingbar" class="disabledisplay"></div>
	<div id="loader"></div>
	<script type="text/javascript">
	function doPKIDownload() {
		location.href = "./resources/NX_TPKIENT/CQWeb/nxtpkient_v1081.exe";
	}
	</script>
    <!-- copyright -->
    <div class="copyright">
      <p>Copyright ⓒ 2016. All rights reserved by <span class="text-black">Selim</span></p>
    </div>
    <!-- /copyright -->

  </aside><!-- /Contents Area -->


</div>
</body>
</html>