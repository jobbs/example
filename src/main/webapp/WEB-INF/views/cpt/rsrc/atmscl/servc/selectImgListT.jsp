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
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<div class="box">
	<div class="box-body no-padding">
		<table class="table table-vertical">
			<caption>라우트 목록 테이블</caption>
			<colgroup>
				<col class="col30">
				<col class="col45">
				<col class="col10">
				<col class="col15">
			</colgroup>
			<thead>
			<tr>
				<th>이미지명</th>
				<th>이미지저장소주소</th>
				<th>버전</th>
				<th>생성일시</th>
			</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${list eq null or empty list }">
						<tr>
							<td colspan="4">이미지 정보가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="img" items="${list }" varStatus="i">
				          <tr>
				          	<td class="alignL"><c:out value="${img.imgNm }" /></td>
				          	<td class="alignL"><c:out value="${img.imgRepoAddr }" /></td>
				          	<td class="alignC"><c:out value="${img.imgVer }" /></td>
				          	<td class="alignC"><c:out value="${img.creDttm }" /></td>
				          </tr>
				        </c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>