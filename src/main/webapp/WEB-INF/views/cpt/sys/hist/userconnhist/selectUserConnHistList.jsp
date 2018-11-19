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

<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
	<form:hidden path="firstSearch" />
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
					<div class="cell-title"><label for="searchUserId">아이디</label></div>
					<div class="cell-body">
						<form:input path="searchUserId" cssClass="form-control input-sm" title="아이디"/>
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title"><label for="searchUserNm">이름</label></div>
					<div class="cell-body">
						<form:input path="searchUserNm" cssClass="form-control input-sm" title="이름"/>
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title"><label for="searchConnIp">접속IP</label></div>
					<div class="cell-body">
						<form:input path="searchConnIp" cssClass="form-control input-sm" title="접속IP" />
					</div>
				</div>
				<div class="form-cell form-cell-100 col-lay-100">
					<div class="cell-title"><label for="searchStartDate">접속일자</label></div>
					<div class="cell-body">
						<div class="input-group period period-start">
							<form:input path="searchStartDate" cssClass="form-control input-sm datepicker" onchange="initDate(this, 'searchEndDate', 'S')" title="접속시작일자"/>
						</div>
						<div class="input-group period period-end">
							<form:input path="searchEndDate" cssClass="form-control input-sm datepicker" onchange="initDate(this, 'searchStartDate', 'E')" title="접속종료일자"/>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="box-footer collapse in search-collapse">
			<div class="pull-left">
				<button type="button" class="btn" onclick="initializeForm()">초기화</button>
			</div>
			<div class="pull-right">
				<button type="button" class="btn btn-red" onclick="doSearch()">조회</button>
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
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="doDownloadExcel()"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical table-layout-fixed" id="userConnTable">
				<caption>사용자 접속 이력 목록 테이블</caption>
				<thead>
				<tr>
					<th>No.</th>
					<th>아이디</th>
					<th>이름</th>
					<th>접속IP</th>
					<th>접속일시</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="vo" items="${list }" varStatus="i">
					<tr>
						<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
						<td><c:out value="${vo.userId }" /></td>
						<td><c:out value="${vo.userNm }" /></td>
						<td><c:out value="${vo.connIp }" /></td>
						<td><c:out value="${vo.connDt }" /></td>
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
		</div>
		<!-- /box-footer -->
	</div>
</div>

<script type="text/javascript">
function goPage(page){
	location.href = "selectUserConnHistList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

function doSearch() {
	$("#searchVo").attr("action", "selectUserConnHistList.do");
	$("#searchVo").submit();
}

function doDownloadExcel() {

	if("${searchVo.paginationInfo.totalRecordCount}" == '0'){
		alert("다운로드 할 데이터가 없습니다.");
		return;
	}

	$("#searchVo").attr("action", "selectDownloadUserConnHist.do");
	$("#searchVo").submit();
}

function initializeForm(){
	$('#searchVo input[type="text"]').val('');
	$("#searchVo select").val('').attr('selected', 'selected');
	initializeDate();
}

//검색 일자 초기화
function initializeDate(){
	var startDate = new Date();
	var endDate = new Date();
	startDate.setDate(startDate.getDate() - 7);
	$('#searchVo input[type="text"][name="searchStartDate"]').val(startDate.toISOString().substr(0,10).replace('T', ' '));
	$('#searchVo input[type="text"][name="searchEndDate"]').val(endDate.toISOString().substr(0,10).replace('T', ' '));
}

$("#userConnTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	               {sWidth : "80px" },
	               {sWidth : "200px" },
	               {sWidth : "150px" },
	               {sWidth : "140px" },
	               {sWidth : "150px" }
	],
	order : [[0, "desc"]]
} );
</script>