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
<title>전자서명/검증 : 인증서 정보 추출</title>
<meta http-equiv="Content-type"	content="text/html;charset=euc-kr" />
<link href="css/default.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="header">
	<div id="header_inner">
		<h1>인증서 정보	추출</h1>
		<div id="desc">TrustPKI	테스트 페이지</div>
	</div>
</div>
<div id="main">
<div id="rcol">
<div id="rcontent">
	<h2>전자서명 데이터	내 인증서 정보 추출</h2>
	<div class="box">
		<div class="box_inner">함수명 :	<font color="green">CQJGetCertInfoFromSignedData()</font><br><br>
			설명 : 인자로 주어진, Base64 형태로	인코딩 된 전자서명문으로부터 인증서의 정보를 획득합니다.
		</div>
	</div>
	<h3>참고</h3>
	<ul>
		<li>추가 테스트를 진행하려면, <span>[이전]</span> 버튼을 클릭합니다.</li>
	<li>처음 페이지로 돌아가려면, <span>[처음]</span> 버튼을 클릭합니다.</li>
	</ul>
	<h3>결과</h3>
	<form>
		<div align="center">
		<table id="input_space"	cellspacing="0"	cellpadding="2"	width="100%" align="center">
		<tr>

			<tr>
			<td	class="input_field"	width="30%">클라이언트 서명	메시지</td>
			<td	class="input_data"><textarea name="OrgData"	cols="60" rows="8" readonly	><%=strSignedData%></textarea></td>
			</tr>
			<tr>
			<td	class="input_field1" width="30%">인증서 base64</td>
			<td	class="input_data"><textarea name="OrgData"	cols="60" rows="8" readonly	><%=strCert%></textarea></td>
			</tr>
			<tr>
			<td	class="input_field" width="30%">검증된	메시지</td>
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
			<INPUT type="button" value="이전" onclick="javascript:history.back()">
			<INPUT type="button" value="처음" onclick="location.href='./TrustPKI_Demo.html'">
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

