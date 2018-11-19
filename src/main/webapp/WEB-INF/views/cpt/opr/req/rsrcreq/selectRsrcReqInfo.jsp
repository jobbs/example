<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 12. 12.
 * @lastmodified 2016. 12. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 12.     김봉민         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- 가본정보  -->
<div class="box detail-list-box">
	<div class="box-header">
		<h3 class="box-title">기본정보</h3>
	</div>
	<div class="box-body no-padding">
		<table class="table table-horizon">
			<caption>클러스터 추가 기본정보</caption>
			<colgroup>
				<col class="col10">
				<col class="col15">
				<col class="col10">
				<col class="col15">
				<col class="col10">
				<col class="col15">
				<col class="col10">
				<col class="col15">
			</colgroup>
			<tbody>
				<tr><th>제목</th><td colspan="3"><c:out value="${rrVo.sbjct}" /></td>
					<th>실행자</th><td><c:out value="${rrVo.exeUserNm}" /></td>
					<th>실행일시</th><td><c:out value="${rrprVo.exeDttm}" /></td></tr>
				<tr><th>상태</th><td><c:out value="${rrVo.rsrcReqPrcssStatNm}" /></td>
					<th>티켓번호</th><td><c:out value="${rrVo.ticktNo}" /></td>
					<th>요청번호</th><td><c:out value="${rrVo.rsrcReqNo}" /></td>
					<th>요청일시</th><td><c:out value="${rrVo.rsrcReqDttm}" /></td></tr>
				<tr><th>요청유형</th><td><c:out value="${rrVo.rsrcReqTyNm}" /></td>
					<th>요청자</th><td><c:out value="${rrVo.rsrcReqUserNm}" /></td>
					<th>요청부처</th><td><c:out value="${rrVo.reqInstitutionNm}" /></td>
					<th>핸드폰</th><td><c:out value="${rrVo.rsrcReqMobile}" /></td></tr>
				<tr><th>이메일</th><td><c:out value="${rrVo.rsrcReqEmail}" /></td>
					<th>완료일시</th><td><c:out value="${rrVo.comptDttm}" /></td>
					<th>테스트여부</th><td colspan="3">
									<c:choose>
										<c:when test="${rrVo.testYn eq 'Y'}">예</c:when>
										<c:when test="${rrVo.testYn eq 'N'}">아니오</c:when>
										<c:otherwise><c:out value="${rrVo.testYn}" /></c:otherwise>
									</c:choose></td></tr>
			</tbody>
		</table>
	</div>
</div>