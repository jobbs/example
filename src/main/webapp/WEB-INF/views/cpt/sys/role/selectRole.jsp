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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-box-100">
	<div class="box">
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical table-layout-fixed">
				<caption>롤 상세 정보 테이블</caption>
				<colgroup>
					<col class="col15">
					<col class="colAuto">
				</colgroup>
				<tbody>
				<tr>
					<th>코드</th>
					<td><c:out value="${role.roleCode }" /></td>
				</tr>
				<tr>
					<th>명칭</th>
					<td><c:out value="${role.roleName }" /></td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<!-- 페이지 버튼 -->
<div class="col-box-100">
	<div class="page-btn">

		<c:url var="listUrl" value="selectRoleList.do">
			<c:forEach var="curParam" items="${param }">
				<c:if test="${curParam.key ne 'roleCode'}">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:if>
			</c:forEach>
		</c:url>

		<c:url var="updateUrl" value="updateRoleView.do">
			<c:forEach var="curParam" items="${param }">
				<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
			</c:forEach>
		</c:url>

		<button type="button" class="btn btn-lg" onclick="goToUrl('${listUrl}')">목록</button>

		<menu:modAuthorize regId="${role.regId }">
			<div class="pull-right">
				<button type="button" class="btn btn-blue btn-lg" onclick="goToUrl('${updateUrl}')">수정</button>
			</div>
		</menu:modAuthorize>
	</div>
</div>
<!-- /페이지 버튼 -->