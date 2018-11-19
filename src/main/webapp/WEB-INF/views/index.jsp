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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<c:set var="menu" value="${menu:getCurrentMenuByCd(0) }" />
<c:set var="subMenuList" value="${menu.subMenuList }"></c:set>

<c:set var="currentMenu" value="${menu:getCurrentMenu(requestScope['javax.servlet.forward.request_uri'],pageContext.request.contextPath) }"/>
<c:set var="menuLocation" value="${currentMenu.location }"></c:set>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title><spring:message code="message.site.title"/><c:if test="${currentMenu.menuName != null }"> - <c:out value="${currentMenu.menuName }" /></c:if></title>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui-1.12.0/jquery-ui.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/reset.css" />"><!-- css초기화 -->
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/font-awesome.min.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/ionicons.min.css" />">

<!--[if lt IE 9]><script type="text/javascript" src="<c:url value="/resources/js/jquery/excanvas.js" />"></script><![endif]-->
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-1.12.4.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-ui.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.ui.datepicker-ko.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.form.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.alerts.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/validation.js" />"></script>

<script type="text/javascript" src="<c:url value="/resources/js/common/respond.src.js" />"></script><!-- 미디어 쿼리 인식 -->
<script type="text/javascript" src="<c:url value="/resources/js/common/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/custom.js" />"></script>

<script type="text/javascript">
contextPath = '${pageContext.request.contextPath}';
dateFormat = 'yy-mm-dd';

$(document).ready(function(){
	$.ajaxSetup({
		cache : false,
		error: function(x,e){
			jAlert('서버요청시 오류가 발생하였습니다.');
		}
	});
});
</script>
</head>
<body>
<div id="header_area">
	<h1>
		<a href="<c:url value="/" />" class="h_logo">Company</a>
	</h1>
	<ul id="userInfo">
		<li>

		</li>
	</ul>
	<ul id="topmenu">
		<li>
			<sec:authorize access="isAuthenticated()">
				<span class="btn_pack type06">
			        <a href="<c:url value='/logout.do' />">로그아웃</a>
				</span>
			</sec:authorize>
		</li>
	</ul>
	<ul id="gnb_area">
	<c:forEach var="topMenu" items="${subMenuList }" >
		<li><a href="<c:url value="${topMenu.realUrl }" />"  class="gnb0${topMenu.menuOrder }<c:if test="${menuLocation[1].menuId eq topMenu.menuId }">_sel</c:if>"><span><c:out value="${topMenu.menuName }" /></span></a></li>
	</c:forEach>
	</ul>

	<form>
		<div class="input-group">
		<input type="text" class="form-control datepicker" />
		</div>
	</form>
</div>
</body>
</html>