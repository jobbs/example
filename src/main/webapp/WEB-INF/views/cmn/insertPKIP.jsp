<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<script  type="text/javascript" src="<c:url value="/resources/NX_TPKIENT/SettingForClient/NX_TPKIENT.js" />"></script>
<script  type="text/javascript" src="<c:url value="/resources/NX_TPKIENT/SettingForClient/NX_TPKIENT_CALLBACK.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/NX_TPKIENT/SettingForClient/sockManager.js" />"></script>
<script type="text/javascript">
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
			theForm.crtfctKey.value = returnValue;


			var options = {
				type: 'post',
				dataType: 'json',
				success: function(result) {
					alert_message(result.messageList, function() {
						if(result.success){
							window.close();
						}
					}, (result.success?"INFO":""));
				},
				error: function(xhr, textStatus, errorThrown){
					jAlert('오류 발생');
				}
			};
			$('#pkiFrm').ajaxSubmit(options);
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

	if(theForm.orgMsg.value == "")
	{
		alert("전자서명 할 메시지가 입력되지 않았습니다.\n\n전자서명 할 메시지를 입력한 후, [다음] 버튼을 클릭하십시오.");
		return;
	}

	strResult = SignData(1, strDNFilter, strCAFilter, theForm.orgMsg.value, 2);
	if(WEBSOCKET == null)
	{
		if(strResult == "")
		{
			TCTErrorInfo();
		}
		else
		{
			theForm.crtfctKey.value = strResult;
			$.post("insertPKI.do", $("#pkiFrm").serialize(), function(result) {
				console.log( result );
			});
			//theForm.submit();
		}
	}

}
//경고창 작게 처리
$.alerts["dialogSize"] = "small";
</script>

	<div class="col-box-100">
		<div class="info">
			<h2>알려드립니다.</h2>
			<p>- nTOPS 시스템 사용자 아이디가 발급되어야 인증서 등록이 진행 가능합니다.</p>
			<p>- 변경 사유 : 인증서 갱신, 유효기간 만료 후 재발급 받는 경우 등</p>
			<p>- 인증서 등록 시 기존 등록된 인증서는 업데이트됩니다.</p>
		</div>
	</div>
	<div class="col-box-100">
		<div class="box">
			<div class="box-body no-padding">
				<form name="pkiFrm" id="pkiFrm" method="post" action="insertPKI.do">
				<table class="table table-horizon">
					<colgroup>
						<col class="col50">
						<col class="colAuto">
					</colgroup>
					<tbody>
						<tr>
							<th>아이디</th>
							<td>
								<input type="text" id="userId" name="userId" class="form-control" title="아이디"/>
								<input type="hidden" name="crtfctKey" title="DN"/>
								<input type="hidden" name="orgMsg" value="nCMSLogin" title="PKIMsg"/>
							</td>
						</tr>
						<!--
						<tr>
							<th>비밀번호</th>
							<td>
								<input type="password" id="passwd" name="passwd" class="form-control" title="비밀번호"/>
							</td>
						</tr>
						 -->
					</tbody>
				</table>
				</form>
			</div>
			<!-- /box-body -->
		</div>

	</div>

	<!-- popup 버튼 -->
	<div class="col-box-100">
		<div class="button">
			<button class="btn btn-dark" onclick="CQWebSignData()">등록하기</button>
			<button class="btn close-window">취소하기</button>
		</div>
	</div>
	<!-- /popup 버튼 -->
	<div id="loadingbar" class="disabledisplay"></div>
	<div id="loader"></div>
<script type="text/javascript">
$(document).ready(function() {
	 loader();
});
</script>