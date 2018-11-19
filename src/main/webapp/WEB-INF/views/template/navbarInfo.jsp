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
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

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
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.cookie.js" />"></script>
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
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.customSort.js" />"></script>

<!-- NCMS 에서 사용하는 공통 컴포넌트  -->
<script type="text/javascript">
contextPath = '${pageContext.request.contextPath}';
dateFormat = 'yy-mm-dd';
</script>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/popup.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/api/selectbox.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/selectbox.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/json2.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/layout.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/loading.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/alrm.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/cpt/extra.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/spin.js" />"></script>


<sec:authentication property="principal" var="user"/>

<script type="text/javascript">

//AJAX 시스템 오류를 찍고 싶지 않을 경우 해당 배열에 URL을 추가 해 주면 됩니다.
var blackList = [
	contextPath + "/cmn/component/alrm/selectTopAlrmList.do"
];

$(document).ready(function() {
	$.ajaxSetup({
		cache : false,
		error: function(x,e){
			if( blackList.indexOf(x.url) < 0 ) {
				jAlert('서버요청시 오류가 발생하였습니다.');
			}
		}
	});

	$.ncmsLayout.init('${user.uiConfJson }');
});

var superposedUserRole  = "${user.superposedUserRole }";
</script>


<div class="alerts top-right" id="alertsDiv"></div>

<nav class="navbar navbar-info">
	<ul class="nav navbar-tap">
		<li class="potal"><a href="<c:url value="/cpt/" />">포털</a></li>
		<li class="dashboard"><a href="<c:url value="/dsb/" />">대시보드</a></li>
		<li class="api"><a href="<c:url value="/api/" />">API Gateway</a></li>
	</ul>

	<ul class="nav navbar-nav">
		<li class="dropdown user user-menu">
			<button type="button" class="dropdown-toggle" data-toggle="dropdown">
				<span><b>${user.superposeRoleNm }</b> ${user.userNm } <i class="caret"></i></span>
			</button>
			<ul class="dropdown-menu">
				<li class="user-header">
					<h4> ${user.userNm }</h4> <b>${user.superposeRoleNm }</b>
					<p>
						<small>${user.institutionNm } · ${user.orgnztNm }</small>
					</p>
				</li>
				<li class="user-footer">
					<div class="pull-right">
						<a href="<c:url value='/logout.do' />" class="btn btn-default btn-flat">로그아웃</a>
					</div>
				</li>
			</ul>
		</li>

		<!-- 알림: style can be found in dropdown.less -->
		<li class="dropdown notifications-menu" id="notificaions-menu">
			<button type="button" class="dropdown-toggle" data-toggle="dropdown">
				<i class="fa fa-comments"></i>
				<b class="count alrm_count">0</b>
				<span class="label label-red alrm_label"></span>
			</button>
			<ul class="dropdown-menu">
				<li class="header alrm_header">0개의 알람이 있습니다.</li>
				<li class="scroll-body">
					<!-- inner menu: contains the actual data -->
					<ul class="menu alrm_dropdown">
					</ul>
				</li>
				<li class="footer"><a href="<c:url value="/cpt/sys/alrm/selectAlrmList.do"/>">모두 보기</a></li>
			</ul>
		</li>

		<!-- 바로가기 -->
		<li class="dropdown shortcut-menu" id="shortcut-menu">
			<button type="button" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-link"></i> 바로가기</button>
			<ul class="dropdown-menu">
				<li class="header">3개의 링크가 있습니다.</li>
				<li class="footer">
					<a href="http://ntops.go.kr" target="_blank" class="btn btn-default btn-flat"><i class="fa fa-link"></i> nTOPS</a>
					<a href="http://10.180.213.168/magicsso/connect.jsp?/returnUrl=/ssologin.do" target="_blank" class="btn btn-default btn-flat"><i class="fa fa-link"></i> G-CAMS</a>
					<a href="http://10.182.29.16:9090" target="_blank" class="btn btn-default btn-flat"><i class="fa fa-link"></i> nSIMS</a>
				</li>
			</ul>
		</li>
	</ul>
</nav>