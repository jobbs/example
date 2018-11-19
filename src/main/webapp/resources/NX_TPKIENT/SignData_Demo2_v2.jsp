<%@page	language="java"	contentType="text/html;	charset=euc-kr"	pageEncoding="euc-kr"%>
<%@page	import="javax.servlet.http.HttpSession,	com.bcqre.lib.CQJava, java.util.StringTokenizer,  java.io.*, java.util.*"  %>
<%@include file="SettingForServer/cqjavaenv.jsp"%>

<%
	String strOrgData =	request.getParameter("OrgMsg");
	String strSignedData = request.getParameter("SignedMsg");

//	String strSignedData = new String (request.getParameter("SignedMsg").getBytes("8859_1"), "EUC-KR");

	String strVerifiedData = "";
	String strCert = "";
//	String strVersion =	"";
//	String strSerial = "";
//	String strSignAlgID	= "";
//	String strIssuer = "";
	String strSubject =	"";
//	String strSubPublicKeyAlgID	= "";
//	String strFromDate = "";
//	String strToDate = "";
//	String strSignature	= "";
	String strSubAlt = "";
//	String strKeyUsage = "";
//	String strExtKeyUsage =	"";
//	String strPolicy = "";
//	String strPolicyMapping	= "";
//	String strBasicConst = "";
//	String strPolicyConst =	"";
//	String strDistPoint	= "";
//	String strAuthKeyID	= "";
//	String strSubKeyID = "";
//	String strPublicKey	= "";

	int	IsError	= -1;
	int	nByte =	0;

	if(strOrgData == null || strOrgData	== "")
	{
		out.println("ERROR:	Request	data is	empty.");
		return;
	}
	if(strSignedData ==	null ||	strSignedData == "")
	{
		out.println("ERROR:	Request	data is	empty.");
		return;
	}

	IsError	= CQJava.CQJInit(gServerServiceIni);

	if(IsError != 0)
	{
		out.println("Error Num [" +	CQJava.CQJGetErrorNum()	+ "] : " + CQJava.CQJGetErrorMsg());
		return;
	}

	strVerifiedData	= CQJava.CQJVerifyData(gServerServiceIni, 1, strSignedData,	strOrgData);

		if(strVerifiedData.equals(""))
	{
		out.println("Error Num [" +	CQJava.CQJGetErrorNum()	+ "] : " + CQJava.CQJGetErrorMsg());
		return;
	}
	else
	{
		nByte =	strVerifiedData.trim().length();
	}

	strCert	= CQJava.CQJGetCertificateFromSignedData(strSignedData);
//	strVersion = CQJava.CQJGetCertInfoFromSignedData(strSignedData,	"CERT_VERSION");
//	strSerial	= CQJava.CQJGetCertInfoFromSignedData(strSignedData, "CERT_SERIAL");
//	strSignAlgID = CQJava.CQJGetCertInfoFromSignedData(strSignedData,	"CERT_SIGNATURE_ALGID");
//	strIssuer	= CQJava.CQJGetCertInfoFromSignedData(strSignedData, "CERT_ISSUER");
	strSubject = CQJava.CQJGetCertInfoFromSignedData(strSignedData, "CERT_SUBJECT");
//	strSubPublicKeyAlgID = CQJava.CQJGetCertInfoFromSignedData(strSignedData,	"CERT_SUBJECT_PUBLIC_KEY_ALGID");
//	strFromDate =	CQJava.CQJGetCertInfoFromSignedData(strSignedData, "CERT_FROM");
//	strToDate	= CQJava.CQJGetCertInfoFromSignedData(strSignedData, "CERT_TO");
//	strSignature = CQJava.CQJGetCertInfoFromSignedData(strSignedData,	"CERT_SIGNATURE");
	strSubAlt	= CQJava.CQJGetCertInfoFromSignedData(strSignedData, "CERT_SUBJECT_ALT_NAME");
//	strKeyUsage =	CQJava.CQJGetCertInfoFromSignedData(strSignedData, "CERT_KEY_USAGE");
//	strExtKeyUsage = CQJava.CQJGetCertInfoFromSignedData(strSignedData, "CERT_EXT_KEY_USAGE");
//	strPolicy	= CQJava.CQJGetCertInfoFromSignedData(strSignedData, "CERT_POLICY");
//	strPolicyMapping = CQJava.CQJGetCertInfoFromSignedData(strSignedData,	"CERT_POLICY_MAPPING");
//	strBasicConst	= CQJava.CQJGetCertInfoFromSignedData(strSignedData, "CERT_BASIC_CONSTRAINT");
//	strPolicyConst = CQJava.CQJGetCertInfoFromSignedData(strSignedData, "CERT_POLICY_CONSTRAINT");
//	strDistPoint = CQJava.CQJGetCertInfoFromSignedData(strSignedData,	"CERT_DISTRIBUTION_POINT");
//	strAuthKeyID = CQJava.CQJGetCertInfoFromSignedData(strSignedData,	"CERT_AUTHORITY_KEY_ID");
//	strSubKeyID =	CQJava.CQJGetCertInfoFromSignedData(strSignedData, "CERT_SUBJECT_KEY_ID");
//	strPublicKey = CQJava.CQJGetCertInfoFromSignedData(strSignedData,	"CERT_PUBLIC_KEY");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>���ڼ���/���� : ������ ���� ����</title>
<meta http-equiv="Content-type"	content="text/html;charset=euc-kr" />
<link href="css/default.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="header">
	<div id="header_inner">
		<h1>������ ����	����</h1>
		<div id="desc">TrustPKI	�׽�Ʈ ������</div>
	</div>
</div>
<div id="main">
<div id="rcol">
<div id="rcontent">
	<h2>���ڼ��� ������	�� ������ ���� ����</h2>
	<div class="box">
		<div class="box_inner">�Լ��� :	<font color="green">CQJGetCertInfoFromSignedData()</font><br><br>
			���� : ���ڷ� �־���, Base64 ���·�	���ڵ� �� ���ڼ������κ��� �������� ������ ȹ���մϴ�.
		</div>
	</div>
	<h3>����</h3>
	<ul>
		<li>�߰� �׽�Ʈ�� �����Ϸ���, <span>[����]</span> ��ư�� Ŭ���մϴ�.</li>
	<li>ó�� �������� ���ư�����, <span>[ó��]</span> ��ư�� Ŭ���մϴ�.</li>
	</ul>
	<h3>���</h3>
	<form>
		<div align="center">
		<table id="input_space"	cellspacing="0"	cellpadding="2"	width="100%" align="center">
		<tr>

			<tr>
			<td	class="input_field"	width="30%">Ŭ���̾�Ʈ ����	�޽���</td>
			<td	class="input_data"><textarea name="OrgData"	cols="60" rows="8" readonly	><%=strSignedData%></textarea></td>
			</tr>
			<tr>
			<td	class="input_field1" width="30%">������ base64</td>
			<td	class="input_data"><textarea name="OrgData"	cols="60" rows="8" readonly	><%=strCert%></textarea></td>
			</tr>
			<tr>
			<td	class="input_field" width="30%">������	�޽���</td>
			<td	class="input_data"><textarea name="OrgData"	cols="60" rows="1" readonly	><%=strVerifiedData%></textarea></td>
			</tr>
			<tr>
			<td	class="input_field1" width="30%">Subject Name</td>
			<td	class="input_data"><textarea cols="60" rows="1"	readonly ><%=strSubject%></textarea></td>
			</tr>
			<tr>
			<td	class="input_field"	width="30%">SubjectAltName</td>
			<td	class="input_data"><textarea cols="60" rows="3"	readonly ><%=strSubAlt%></textarea></td>
			</tr>
		</table>
		</div>
		<div id="button_space" align="center">
			<INPUT type="button" value="����" onclick="javascript:history.back()">
			<INPUT type="button" value="ó��" onclick="location.href='./TrustPKI_Demo.html'">
		</div>
	</form>
</div>
</div>
</div>
<div id="footer">
	Copyright &copy; 2000-2015 SGA Solutions.
</div>
</body>
</html>

