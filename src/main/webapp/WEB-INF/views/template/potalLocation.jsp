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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<c:set var="currentMenu" value="${menu:getCurrentMenu(requestScope['javax.servlet.forward.request_uri'],pageContext.request.contextPath) }"/>
<c:set var="menuLocation" value="${currentMenu.location }"></c:set>

<!-- 컨텐츠 타이틀 -->
<section class="content-header">
	<div class="pull-left">
		<button class="btn btn-side-menu" onclick="toggleSideMenu()"><i class="fa fa-bars"></i></button>
		<h1>
			<c:choose>
				<c:when test="${title ne null and title ne '' }">
					<c:out value="${title }" />
				</c:when>
				<c:otherwise>
					<c:out value="${currentMenu.menuNm }" />
				</c:otherwise>
			</c:choose>
		</h1>
	</div>
	<div class="pull-right">
		<ol class="breadcrumb">
			<c:forEach var="menu" items="${menuLocation }" varStatus="i">
				<c:if test="${i.count ne 2}">
				<c:choose>
					<c:when test="${i.first }">
						<li><a href="<c:url value="/" />"><i class="fa fa-home"></i>홈</a></li>
					</c:when>
					<c:when test="${i.last }">
						<li class="active"><c:out value="${menu.menuNm }" /></li>
					</c:when>
					<c:otherwise>
						<li><a href="<c:url value="${menu.realUrl }" />"><c:out value="${menu.menuNm }" /></a></li>
					</c:otherwise>
				</c:choose>
				</c:if>
			</c:forEach>
		</ol>
		<button class="btn btn-side-info" onclick="toggleExtraSide()"><i class="fa fa-caret-right"></i></button>
	</div>
</section><!-- /컨텐츠 타이틀 -->
<script type="text/javascript">
function toggleSideMenu() {
	$.ncmsLayout.update("200");
}

function toggleExtraSide() {
	$.ncmsLayout.update("201");
}
</script>