<%@page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>���ڼ���/����</title>
<meta http-equiv="Content-type" content="text/html;charset=euc-kr" />
<meta http-equiv='X-UA-Compatible' content='IE=EDGE'/>
<link href="css/default.css" rel="stylesheet" type="text/css" media="screen" />

<!-- RedBC TrustPKI Client Toolkit ���� ��ũ��Ʈ -->
<script src="SettingForClient/NX_TPKIENT.js"></script>
<script src="SettingForClient/NX_TPKIENT_CALLBACK.js"></script>
<script language='javascript' src='SettingForClient/sockManager.js'></script>
<SCRIPT language="javascript">
// Ŭ���̾�Ʈ ActiveX �� Plug-in ��ġ �� ���� üũ, WebSocket ���� �� ����.
// Parameter �� InstallPage�� ��� ���θ� ��Ÿ��.
// ture ������ ��� �ϴ� InstallPage�� NX_TPKIENT.js CheckClient �Լ��� �����ؾ� ��.
CheckClient(false);

// ������Ʈ�Ŵ����� ���� �������� �� ��ġ ��� ���ο� ���� üũ
if(SET_UPDATEMANAGER == "ON")
{
	StartAgent();
}
else if(SET_UPDATEMANAGER == "OFF")
{
	SetUpdateManager();
}

// WebSocket OnMessage �̺�Ʈ �߻��� ȣ�� �Ǵ� �Լ� ����.
function OnMessage(funcName, returnValue, errNum, errMsg)
{
	console.log("funcName : " + funcName + ", " + "returnValue : " + returnValue);
	if(funcName == "System")
	{
		alert("TrustWeb ��⿡�� ������ �߻��Ͽ����ϴ�.\n�������� : [0x" + lpad(errNum.toString(16).toUpperCase(), 8, "0") + "] - " + errMsg);
	}
	else if(funcName == "StartAgent")
	{
		// �ʱ�ȭ �Լ�, WebSocket�� �����Ǵ� �������� ù��° ���� �ؾ� �ϴ� �Լ��� CQWIGetEnvironment �Լ��� ȣ��.
		// �� ������ �۾��� OnMessage �Լ��� �����Ͽ� ���.
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
			//Error Msg ���
			alert("TrustWeb ��⿡�� ������ �߻��Ͽ����ϴ�.\n�������� : [0x" + lpad(errNum.toString(16).toUpperCase(), 8, "0") + "] - " + errMsg);
		}
	}
	else if(funcName == "CQWISignData")
	{
		var theForm = document.forms[0];

		if(returnValue == "")
		{
			//Error Msg ���
			alert("TrustWeb ��⿡�� ������ �߻��Ͽ����ϴ�.\n�������� : [0x" + lpad(errNum.toString(16).toUpperCase(), 8, "0") + "] - " + errMsg);
		}
		else
		{
			//���ڼ��� ������ ���� �������� �̵�
			theForm.SignedMsg.value = returnValue;
			theForm.submit();
		}
	}
	else if(funcName == "SetParam")
	{
		if(returnValue != 0)
		{
			alert("TrustWeb ��⿡�� ������ �߻��Ͽ����ϴ�.\n�������� : [0x" + lpad(errNum.toString(16).toUpperCase(), 8, "0") + "] - " + errMsg);
		}
	}
	else if(funcName == "SetUpdateManager")
	{
		if(returnValue == "none")
		{
			alert("TrustWeb ��⿡�� ������ �߻��Ͽ����ϴ�.\n�������� : [0x" + lpad(errNum.toString(16).toUpperCase(), 8, "0") + "] - " + errMsg);
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
	var strDNFilter = ""; //��� ������
//	var strDNFilter = "o=Government of Korea"; //EPKI, GPKI ������ �ɼ�
	var strCAFilter = "";
	var strResult = "";
	var theForm = document.forms[0];

	if(theForm.OrgMsg.value == "")
	{
		alert("���ڼ��� �� �޽����� �Էµ��� �ʾҽ��ϴ�.\n\n���ڼ��� �� �޽����� �Է��� ��, [����] ��ư�� Ŭ���Ͻʽÿ�.");
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
		<h1>���ڼ���/����</h1>
		<div id="desc">TrustPKI �׽�Ʈ ������</div>
	</div>
</div>
<div id="main">
<div id="rcol">
<div id="rcontent">
	<h2>Ŭ���̾�Ʈ ������ ���ڼ���</h2>
	<div class="box">
		<div class="box_inner">�Լ��� : <font color="green">CQWISignData()</font><br>
			<br>���� : ���ÿ� ����� ������ ����Ʈ�� �Ű������� �Է� ���� DN ���͸��� CA ���͸��� �Ͽ� �ش��ϴ� �������� �ε��Ͽ� �����ְ� ����ڰ� ������ ������ ����, ���� ���� ���� Flag, ����Ű �н�����, ���� ������ �̿��Ͽ� ���ڼ����� �����մϴ�.
			<br>���� �� ���� �� �����͸� �����ϸ�, ���� �� �����ڵ带 �����մϴ�.
		</div>
	</div>
	<h3>����</h3>
	<ol>
		<li><span>"���ڼ��� �� �޽���"</span> �Է¶��� ���ڼ��� �� ������ ���ڿ��� �Է��� ��, <span>[����]</span> ��ư�� Ŭ���մϴ�.</li>
		<li>������ ���� ��ȭ���ڰ� ȭ�鿡 ǥ�õǸ� ���ڼ��� ����� �������� ������ ���� ��й�ȣ �Է��� ��, <span>[Ȯ��]</span> ��ư�� Ŭ���մϴ�.</li>
		<li>���� ���������� <span>"���ڼ��� �� �޽���"</span> �� <span>"���� ���� �޽���"</span> �� ������ ������ �� Ȯ���մϴ�.</li>
	</ol>
	<h3>����</h3>
	<ul>
		<li>���ڿ��� �ٽ� �Է� �Ϸ���, <span>[�ʱ�ȭ]</span> ��ư�� Ŭ���մϴ�.</li>
		<li>ó�� �������� ���ư�����, <span>[����]</span> ��ư�� Ŭ���մϴ�.</li>
	</ul>
	<h3>����</h3>
	<form name="send_form" action="SignData_Demo2_v2.jsp" method="post">
		<input type="hidden" name="SignedMsg"/>
		<div align="center">
		<table id="input_space" cellspacing="0" cellpadding="2" width="100%" align="center">
		<tr>
		<td class="input_field" width="30%">���ڼ��� �� �޽���</td>
		<td class="input_data"><textarea name="OrgMsg" cols="60" rows="2" ></textarea></td>
		</tr>
		</table>
		</div>
		<div id="button_space" align="center">
			<input type="button" value="����" onclick="CQWebSignData()"/>
		    <input type="reset" value="�ʱ�ȭ"/>
		    <input type="button" value="����" onclick="javascript:history.back()"/>
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
