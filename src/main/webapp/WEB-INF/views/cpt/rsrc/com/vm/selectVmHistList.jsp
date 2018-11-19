<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     최경철         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>


<!-- 그리드 영역 -->
<form id="vmHistFrm">
<input type="hidden" name="searchVmSeq" value="${vmVo.vmSeq}" />

	<div class="col-box-100 detail-col">

		<div class="box detail-list-box">

			<!-- box-header -->
			<div class="box-header">
				<h3 class="box-title">자원변경 이력(${vmResHistSearchVo.paginationInfo.totalRecordCount })</h3>
				<div class="box-tools">
					<div class="input-group-box">
						<%-- <nform:selectRecodeCntPerPage formId="vmResHistSearchVo" value="${vmResHistSearchVo }"/> --%>
						<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="엑셀다운로드" data-original-title="엑셀다운로드" onclick="fn_selectVmResHistListXlsDwnl();"><i class="fa fa-download"></i></button>
						</div>
					</div>
				</div>
			</div>

			<!-- box-body -->
			<div class="box-body no-padding detail-list-body">
				<table id="vmResHistTable" class="table table-vertical table-layout-fixed">
				<caption>자원변경 이력 테이블</caption>
					<thead>
						<tr>
							<th><nobr>이력구분</nobr></th>
							<th><nobr>이력일시</nobr></th>
							<th><nobr>담당자</nobr></th>
							<th><nobr>변경전 상세내용</nobr></th>
							<th><nobr>변경후 상세내용</nobr></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vmResHistVo" items="${vmResHistVoList }" varStatus="i">
							<tr>
								<td class="alignL"><nobr><c:out value="${vmResHistVo.cdNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmResHistVo.wrkDt }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmResHistVo.wrkNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmResHistVo.beforeInfo }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmResHistVo.afterInfo }" /></nobr></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="box-footer">
	<!-- 			<ul class="pagination"> -->
	<%-- 				<ui:pagination paginationInfo="${vmResHistSearchVo.paginationInfo }" type="common" jsFunction="fn_goPage" /> --%>
	<!-- 			</ul> -->
			</div>
		</div>

		<div class="box detail-list-box">
			<!-- box-header -->
			<div class="box-header">
				<h3 class="box-title">마이그레이션 이력(${vmMigrHistSearchVo.paginationInfo.totalRecordCount })</h3>
				<div class="box-tools">
					<div class="input-group-box">
						<%-- <nform:selectRecodeCntPerPage formId="vmMigrHistSearchVo" value="${vmMigrHistSearchVo }"/> --%>
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="엑셀다운로드" data-original-title="엑셀다운로드" onclick="fn_selectVmMigrHistListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>

			<!-- box-body -->
			<div class="box-body no-padding detail-list-body">
				<table id="vmMigrHistTable" class="table table-vertical table-layout-fixed">
				<caption>마이그레이션 이력 테이블</caption>
					<thead>
						<tr>
							<th><nobr>이력구분</nobr></th>
							<th><nobr>이력일시</nobr></th>
							<th><nobr>담당자</nobr></th>
							<th><nobr>변경전 상세내용</nobr></th>
							<th><nobr>변경후 상세내용</nobr></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vmMigrHistVo" items="${vmMigrHistVoList }" varStatus="i">
							<tr>
								<td class="alignL"><nobr><c:out value="${vmMigrHistVo.cdNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmMigrHistVo.wrkDt }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmMigrHistVo.wrkNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmMigrHistVo.beforeInfo }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmMigrHistVo.afterInfo }" /></nobr></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="box-footer">
	<!-- 			<ul class="pagination"> -->
	<%-- 				<ui:pagination paginationInfo="${vmMigrHistSearchVo.paginationInfo }" type="common" jsFunction="fn_goPage" /> --%>
	<!-- 			</ul> -->
			</div>
		</div>

		<div class="box detail-list-box">

			<!-- box-header -->
			<div class="box-header">
				<h3 class="box-title">스냅샷 이력(${vmSnapHistSearchVo.paginationInfo.totalRecordCount })</h3>
				<div class="box-tools">
					<div class="input-group-box">
						<%-- <nform:selectRecodeCntPerPage formId="vmSnapHistSearchVo" value="${vmSnapHistSearchVo }"/> --%>
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="엑셀다운로드" data-original-title="엑셀다운로드" onclick="fn_selectVmSnapHistListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>

			<!-- box-body -->
			<div class="box-body no-padding detail-list-body">
				<table id="vmSnapHistTable" class="table table-vertical table-layout-fixed">
				<caption>스냅샷 이력 테이블</caption>
					<thead>
						<tr>
							<th><nobr>이력구분</nobr></th>
							<th><nobr>이력일시</nobr></th>
							<th><nobr>담당자</nobr></th>
							<th><nobr>상세내용</nobr></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vmSnapHistVo" items="${vmSnapHistVoList }" varStatus="i">
							<tr>
								<td class="alignL"><nobr><c:out value="${vmSnapHistVo.cdNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmSnapHistVo.wrkDt }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmSnapHistVo.wrkNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmSnapHistVo.detailInfo }" /></nobr></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="box-footer">
	<!-- 			<ul class="pagination"> -->
	<%-- 				<ui:pagination paginationInfo="${vmSnapHistSearchVo.paginationInfo }" type="common" jsFunction="fn_goPage" /> --%>
	<!-- 			</ul> -->
			</div>
		</div>

		<div class="box detail-list-box">

			<!-- box-header -->
			<div class="box-header">
				<h3 class="box-title">구성변경 이력(${vmCompHistSearchVo.paginationInfo.totalRecordCount })</h3>
				<div class="box-tools">
					<div class="input-group-box">
						<%-- <nform:selectRecodeCntPerPage formId="vmCompHistSearchVo" value="${vmCompHistSearchVo }"/> --%>
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="엑셀다운로드" data-original-title="엑셀다운로드" onclick="fn_selectVmCompHistListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>

			<!-- box-body -->
			<div class="box-body no-padding detail-list-body">
				<table id="vmCompHistTable" class="table table-vertical table-layout-fixed">
				<caption>구성변경 이력 테이블</caption>
					<thead>
						<tr>
							<th><nobr>이력구분</nobr></th>
							<th><nobr>이력일시</nobr></th>
							<th><nobr>담당자</nobr></th>
							<th><nobr>변경전 상세내용</nobr></th>
							<th><nobr>변경후 상세내용</nobr></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vmCompHistVo" items="${vmCompHistVoList }" varStatus="i">
							<tr>
								<td class="alignL"><nobr><c:out value="${vmCompHistVo.cdNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmCompHistVo.wrkDt }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmCompHistVo.wrkNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmCompHistVo.beforeInfo }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmCompHistVo.afterInfo }" /></nobr></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="box-footer">
	<!-- 			<ul class="pagination"> -->
	<%-- 				<ui:pagination paginationInfo="${vmCompHistSearchVo.paginationInfo }" type="common" jsFunction="fn_goPage" /> --%>
	<!-- 			</ul> -->
			</div>
		</div>

		<!-- 페이지 버튼 영역 -->
		<div class="col-box-100 no-padding-left no-padding-right">
			<div class="edit-btn-group">
				<div class="pull-left btns">
					<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectVmList();"><i class="fa fa-arrow-left"></i></button>
				</div>
			</div>
		</div>

	</div>
</form>



<script type="text/javascript">

//뒤로
function fn_selectVmList(){
	location.href = '<c:url value="selectVmList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'vmSeq' and pageParam.key ne 'searchType'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

function fn_selectVmResHistListXlsDwnl() {
	if("${vmResHistSearchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("다운로드 할 데이터가 없습니다.");
		return;
	}
	$('#vmHistFrm').attr('target', '_self');
	$('#vmHistFrm').attr('action', '<c:url value="selectVmResHistListXlsDwnl.do"/>');
	$('#vmHistFrm').submit();
}

function fn_selectVmMigrHistListXlsDwnl() {
	if("${vmMigrHistSearchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("다운로드 할 데이터가 없습니다.");
		return;
	}
	$('#vmHistFrm').attr('target', '_self');
	$('#vmHistFrm').attr('action', '<c:url value="selectVmMigrHistListXlsDwnl.do"/>');
	$('#vmHistFrm').submit();
}

function fn_selectVmSnapHistListXlsDwnl() {
	if("${vmSnapHistSearchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("다운로드 할 데이터가 없습니다.");
		return;
	}
	$('#vmHistFrm').attr('target', '_self');
	$('#vmHistFrm').attr('action', '<c:url value="selectVmSnapHistListXlsDwnl.do"/>');
	$('#vmHistFrm').submit();
}

function fn_selectVmCompHistListXlsDwnl() {
	if("${vmCompHistSearchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("다운로드 할 데이터가 없습니다.");
		return;
	}
	$('#vmHistFrm').attr('target', '_self');
	$('#vmHistFrm').attr('action', '<c:url value="selectVmCompHistListXlsDwnl.do"/>');
	$('#vmHistFrm').submit();
}

$("#vmResHistTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	                {sWidth : "86px" },
	                {sWidth : "131px" },
	                {sWidth : "58px" },
	                {sWidth : "223px" },
	                {sWidth : "223px" }
	 ],

	 order : [[1, "desc"]]
});

$("#vmMigrHistTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	                {sWidth : "86px" },
	                {sWidth : "131px" },
	                {sWidth : "58px" },
	                {sWidth : "223px" },
	                {sWidth : "223px" }
	 ],

	 order : [[1, "desc"]]
});

$("#vmSnapHistTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	                {sWidth : "86px" },
	                {sWidth : "131px" },
	                {sWidth : "58px" },
	                {sWidth : "446px" }
	 ],

	 order : [[1, "desc"]]
});

$("#vmCompHistTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	                {sWidth : "86px" },
	                {sWidth : "131px" },
	                {sWidth : "58px" },
	                {sWidth : "223px" },
	                {sWidth : "223px" }
	 ],

	 order : [[1, "desc"]]
});

</script>