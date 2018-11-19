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
<%
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Expires","0");
response.setDateHeader("Expires",-1);
%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<c:set var="currentMenu" value="${menu:getCurrentMenu(requestScope['javax.servlet.forward.request_uri'],pageContext.request.contextPath) }"/>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title><spring:message code="message.site.title"/><c:if test="${currentMenu.menuNm != null }"> - <c:out value="${currentMenu.menuNm }" /></c:if></title>
</head>
<body class="skin-potal potal-main">

	<div class="skip-nav">
		<a href="#navbar">메인메뉴 바로가기</a>
		<a href="#content">본문 바로가기</a>
	</div>

	<header class="header">
		<t:insertAttribute name="navbarInfo"></t:insertAttribute>
		<t:insertAttribute name="header"></t:insertAttribute>
	</header>

	<!-- right-side -->
	<div class="wrapper">

		<aside class="wide-side" id="content">
			<t:insertAttribute name="contents"></t:insertAttribute>
			<t:insertAttribute name="footer"></t:insertAttribute>
		</aside>
	</div>
</body>
</html>