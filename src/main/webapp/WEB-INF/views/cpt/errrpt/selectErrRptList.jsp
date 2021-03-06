<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 07.
 * @lastmodified 2016. 10. 07.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 07.     박봉춘         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
	<div class="box box-search">
		<div class="box-header">
			<h3 class="box-title">검색조건</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
				</button>
			</div>
		</div>

		<div class="box-body collapse in search-collapse">
			<div class="form-group">
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label>카테고리</label>
					</div>
					<div class="cell-body">
						<nform:selectCode parentCd="ERRCATE" parentGrpCd="070" name="searchErrCateCd"
							cssClass="form-control input-sm" value="${searchVo.searchErrCateCd }" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label>제목</label>
					</div>
					<div class="cell-body">
						<form:input path="searchSbjct"
							cssClass="form-control input-sm pull-right" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label>내용</label>
					</div>
					<div class="cell-body">
						<form:input path="searchContent"
							cssClass="form-control input-sm pull-right" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label>담당자</label>
					</div>
					<div class="cell-body">
						<form:input path="searchChargeNm"
							cssClass="form-control input-sm pull-right" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label>결함구분</label>
					</div>
					<div class="cell-body">
						<nform:selectCode parentCd="ERRTY" parentGrpCd="070" name="searchErrTyCd"
							cssClass="form-control input-sm" value="${searchVo.searchErrTyCd }" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label>처리상태</label>
					</div>
					<div class="cell-body">
						<nform:selectCode parentCd="ERRSTT" parentGrpCd="070" name="searchProcssStatCd"
							cssClass="form-control input-sm" value="${searchVo.searchProcssStatCd }" />
					</div>
				</div>
			</div>
		</div>
		<div class="box-footer collapse in search-collapse">
			<div class="pull-right">
				<button type="submit" class="btn btn-red">조회</button>
			</div>
		</div><!-- /box-footer -->
	</div>
	</form:form>
</div>

<div class="col-box-100 search-col">
	<div class="box list-box">

		<div class="box-header">
			<h3 class="box-title">검색결과<small>
				${searchVo.paginationInfo.currentPageNo } /
				${searchVo.paginationInfo.totalPageCount },
				총 ${searchVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/>
				</div>
			</div>
		</div><!-- /box-header -->

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical table-layout-fixed" id="noticeTable">
				<colgroup>
					<col class="col10">
					<col class="col10">
					<col class="colAuto">
					<col class="col12">
					<col class="col12">
					<col class="col12">
					<col class="col12">
				</colgroup>
				<thead>
				<tr>
					<th>No.</th>
					<th>카테고리</th>
					<th>제목</th>
					<th>결함구분</th>
					<th>처리상태</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
				</thead>

				<tbody>
				<c:forEach var="vo" items="${list }" varStatus="i">
					<c:url var="detailUrl" value="selectErrRpt.do">
						<c:forEach var="curParam" items="${param }">
							<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
						</c:forEach>
						<c:param name="errRptSeq" value="${vo.errRptSeq }" />
					</c:url>
					<tr>
						<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>

						<td><c:out value="${vo.errCateNm }" /></td>
						<td class="alignL ellipsis">
							<a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.errTitle}"/>"><c:out value="${vo.errTitle}"/></a>
						</td>
						<td><c:out value="${vo.errTyNm }" /></td>
						<td>
							<c:choose>
								<c:when test="${vo.procssStatCd eq 'REG' }">
								<span class="status status-gray"><c:out value="${vo.procssStatNm }" /></span>
								</c:when>
								<c:when test="${vo.procssStatCd eq 'CNFRM' }">
								<span class="status status-aqua"><c:out value="${vo.procssStatNm }" /></span>
								</c:when>
								<c:when test="${vo.procssStatCd eq 'ACTING' }">
								<span class="status status-yellow"><c:out value="${vo.procssStatNm }" /></span>
								</c:when>
								<c:when test="${vo.procssStatCd eq 'ACTCMP' }">
								<span class="status status-green"><c:out value="${vo.procssStatNm }" /></span>
								</c:when>
							</c:choose>

						</td>
						<td><c:out value="${vo.regUsrNm }" /></td>
						<td><fmt:formatDate value="${vo.regDttm }" pattern="yyyy-MM-dd" /></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertErrRpt.do">
						<c:forEach var="curParam" items="${param }">
							<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
						</c:forEach>
					</c:url>
					<button class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가" onclick="goToUrl('${insertUrl}')"><i class="fa fa-plus"></i></button>
				</menu:authorize>
			</div>
		</div>
		<!-- /box-footer -->
	</div>
</div>

<script type="text/javascript">
function goPage(page){
	location.href = "selectErrRptList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

function goToUrl(url) {
	location.href = url;
}

$("#noticeTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	order : [[0, "desc"]]
} );
</script>