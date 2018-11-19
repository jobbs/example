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
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100">
	<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
	<form:hidden path="searchType"/>
	<div class="box-search">
		<div class="box-body">
			<div class="form-group">
				<div class="form-cell form-cell-50">
					<div class="cell-title"><label>아이디</label></div>
					<div class="cell-body">
						<form:input path="searchUserId" cssClass="form-control input-sm pull-right" />
					</div>
				</div>
				<div class="form-cell form-cell-50">
					<div class="cell-title"><label>이름</label></div>
					<div class="cell-body">
						<form:input path="searchUserNm" cssClass="form-control input-sm pull-right" />
					</div>
				</div>
				<div class="form-cell form-cell-100 alignR pad-top-5">
					<button class="btn btn-red btn-sm" type="submit">조회</button>
				</div>
			</div>

		</div>
	</div>
	</form:form>

	<div class="box">
		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">
				검색결과<small> ${searchVo.paginationInfo.currentPageNo }
					/ ${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }" />
				</div>
			</div>
		</div>
		<!-- /box-header -->
		<!-- box-body -->
		<div class="box-body no-padding">
			<form action="userFrm" id="userFrm">
			<table class="table table-hover table-vertical">
				<caption>사용자 목록 테이블</caption>
				<colgroup>
					<col class="col10">
					<col class="col15">
					<col class="col15">
					<col class="colAuto">
					<col class="col20">
					<col class="col25">
				</colgroup>
				<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>부처</th>
					<th>직위</th>
					<th>전화번호</th>
					<th>이메일</th>
				</tr>
				</thead>

				<tbody>
				<c:forEach var="vo" items="${list }" varStatus="i">
					<tr>
						<td class="alignL"><c:out value="${vo.userId }" /></td>
						<td><c:out value="${vo.userNm }" /></td>
						<td class="alignL"><c:out value="${vo.institutionNm }" /></td>
						<td class="alignL"><c:out value="${vo.ofcpsNm }" /></td>
						<td><c:out value="${vo.telno }" /></td>
						<td class="alignL"><c:out value="${vo.email }" /></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</form>
		</div>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
		</div>
		<!-- /box-footer -->
	</div>
</div>
<script type="text/javascript">
function goPage(page){
	location.href = "selectUserViewListP.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}
</script>