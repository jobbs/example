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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Expires","0");
response.setDateHeader("Expires",-1);
%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title><c:out value="${title }" /></title>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui-1.12.0/jquery-ui.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/reset.css" />"><!-- css초기화 -->
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/font-awesome.min.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/ionicons.min.css" />">

<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-2.1.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-ui.js" />"></script>

<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.alphanumeric.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.money.plus.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.ui.datepicker-ko.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.form.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.alerts.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/validation.js" />"></script>

<script type="text/javascript" src="<c:url value="/resources/js/common/respond.src.js" />"></script><!-- 미디어 쿼리 인식 -->
<script type="text/javascript" src="<c:url value="/resources/js/common/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.sparkline.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/custom.js" />"></script>

<!-- Tooltip -->
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/tooltopster/tooltipster.css" />">
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.tooltipster.js" />"></script>

<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>

<!-- NCMS 에서 사용하는 공통 컴포넌트  -->
<script type="text/javascript" src="<c:url value="/resources/js/common/component/popup.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/selectbox.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/spin.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/loading.js" />"></script>

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

	$(".close-window").click(function() {
		window.open('about:blank', '_self').close();
	});
});
</script>
</head>
<body class="popup-window">

<!-- Popup box -->
<aside class="popup-box">
	<section class="popup-header">
		<div class="title pull-left">
			<h1><c:out value="${title }" /></h1>
		</div>
	<div class="tools pull-right">
		<button type="button" class="close close-window"><span aria-hidden="true">×</span><span class="sr-only">닫기</span></button>
	</div>
	</section><!-- /popup 타이틀 -->

	<!-- popup 컨텐츠 -->
	<section class="popup-content">
		<div class="row">
			<t:insertAttribute name="contents"></t:insertAttribute>
		</div>
	</section>
</aside>
</body>
</html>