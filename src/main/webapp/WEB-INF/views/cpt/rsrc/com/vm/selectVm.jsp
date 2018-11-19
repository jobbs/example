<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>가상서버 상세 화면</pre>
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     심원보         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-box-100 detail-col">
	<!-- Tab 영역 -->
	<div class="nav-tabs-custom">
		<!-- 메뉴 영역 -->
		<ul class="nav nav-tabs">
			<li class="<c:if test="${vmSearchVo.searchType eq 'info' }">active</c:if>"><a href="#tab-info" onclick="fn_changTab('info')" data-toggle="tab">기본정보</a></li>
			<li class="<c:if test="${vmSearchVo.searchType eq 'snap' }">active</c:if>"><a href="#tab-snapsht" onclick="fn_changTab('snap')" data-toggle="tab">스냅샷</a></li>
			<li class="<c:if test="${vmSearchVo.searchType eq 'hist' }">active</c:if>"><a href="#tab-hist" onclick="fn_changTab('hist')" data-toggle="tab">이력정보</a></li>
		</ul>

		<!-- 컨텐츠 영역 -->
		<div class="tab-content row">
			<div class="tab-pane active" id="tab-contents">
				<!-- 기본정보 -->
				<c:if test="${vmSearchVo.searchType eq 'info' }"><jsp:include page="selectVmInfo.jsp" flush="false" /></c:if>
				<!-- 스냅샷 -->
				<c:if test="${vmSearchVo.searchType eq 'snap' }"><jsp:include page="selectVmSnapList.jsp" flush="false" /></c:if>
				<!-- 이력정보 -->
				<c:if test="${vmSearchVo.searchType eq 'hist' }"><jsp:include page="selectVmHistList.jsp" flush="false" /></c:if>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

function fn_changTab(type) {
	location.href="<c:url value="selectVm.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'searchType'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>&searchType=" + type;
}

</script>