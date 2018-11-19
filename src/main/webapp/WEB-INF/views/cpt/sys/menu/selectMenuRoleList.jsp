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
<div class="box">
	<div class="box-header">
    <h3 class="box-title">권한목록</h3>
  </div>
	<div class="box-body no-padding">
		<table class="table table-vertical">
			<caption>권한 목록 테이블</caption>
			<colgroup>
				<col class="col25">
				<col class="col25">
				<col class="col25">
				<col class="col25">
			</colgroup>
			<thead>
			<tr>
				<th>권한명</th>
				<th>읽기권한</th>
				<th>쓰기권한</th>
				<th>실행권한</th>
			</tr>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${ menuRoleList eq null or empty menuRoleList }">
					<tr><td colspan="4">검색된 권한 정보가 없습니다.</td></tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="role" items="${menuRoleList }" varStatus="ri">
					<tr>
						<td><c:out value="${role.roleNm }" /></td>
						<td><c:if test="${role.readYn eq 'Y' }">■</c:if></td>
						<td><c:if test="${role.writeYn eq 'Y' }">■</c:if></td>
						<td><c:if test="${role.actYn eq 'Y' }">■</c:if></td>
					</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			</tbody>
		</table>
	</div>

	<div class="box-footer">
		<div class="btn-group pull-right btns">
	    	<button type="button" class="btn btn-function" onclick='doCopyRole()'>권한복제</button>
	    </div>
	</div>
</div>