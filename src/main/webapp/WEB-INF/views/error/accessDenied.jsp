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

<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-1.12.4.js" />"></script>
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
</head>
<body class="skin-potal potal-login">

<div class="wrapper">

		<!-- Main Area -->
		<aside class="wide-side">

			<section class="error">

				<div class="error-box">
					<div class="box">
						<div class="box-header">
							<i class="fa fa-question-circle"></i>
							<h1>요청하신 페이지에 권한이 없거나 페이지를 찾을 수 없습니다.</h1>
						</div>
						<div class="box-body">
							<p>입력하신 주소가 정확한지 다시 확인 부탁드립니다.</p>
							<p>서비스 이용에 불편을 드려서 대단히 죄송합니다.</p>
						</div>
						<div class="box-footer">
							<button class="btn" type="button" onclick="history.back()">
								<i class="fa fa-angle-left"></i>이전페이지
							</button>
							<button class="btn" onclick="goHome()">
								홈으로<i class="fa fa-angle-right"></i>
							</button>
						</div>
					</div>

				</div>
			</section>
			<!-- /컨텐츠 -->


			<!-- copyright -->
			<div class="copyright">
				<p>
					Copyright ⓒ 2016. All rights reserved by <span class="text-black">Selim</span>
				</p>
			</div>
			<!-- /copyright -->

		</aside>
		<!-- /Contents Area -->
	</div>
	<script type="text/javascript">
	function goHome() {
		location.href = "<c:url value="/" />";
	}
	</script>
</body>
</html>