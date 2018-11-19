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
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>
<c:url var="selectListUrl" value="selectCodeSearchList.do"></c:url>

<div class="box list-box" style="margin-top:0;">
	<div class="box-header">
		<h3 class="box-title">검색결과<small>
			${searchVo.paginationInfo.currentPageNo } /
			${searchVo.paginationInfo.totalPageCount },
			총 ${searchVo.paginationInfo.totalRecordCount }건
		</small></h3>
		<div class="box-tools">
			<div class="input-group-box">
 				<nform:selectRecodeCntPerPage formId="searchFrm" value="${searchVo }" />
 				<div class="input-group-cell pad-right">
					<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_selectCodeListXlsDwnl()"><i class="fa fa-download"></i></button>
				</div>
 			</div>
		</div>
	</div><!-- /box-header -->

	<!-- box-body -->
	<div class="box-body no-padding list-body">
		<table class="table table-hover table-vertical table-layout-fixed" id="codeListTable">
			<caption>코드 검색 목록 테이블</caption><%--
			<colgroup>
				<col class="col15">
				<col class="col15">
				<col class="col15">
				<col class="col15">
				<col class="colAuto">
				<col class="col10">
			</colgroup> --%>
			<thead>
			<tr>
				<th>코드</th>
				<th>그룹코드</th>
				<th>부모코드</th>
				<th>부모그룹코드</th>
				<th>코드명</th>
				<th>사용여부</th>
			</tr>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${list eq null or empty list }">
					<tr>
						<td colspan="6">검색된 데이터가 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="vo" items="${list }" varStatus="i">
					<tr>
						<td><a href="javascript:void()" onclick="loadSelectSearchDetail('<c:out value="${vo.cd}"/>','<c:out value="${vo.grpCd}"/>')"><c:out value="${vo.cd}"/></a></td>
						<td><a href="javascript:void()" onclick="loadSelectSearchDetail('<c:out value="${vo.cd}"/>','<c:out value="${vo.grpCd}"/>')"><c:out value="${vo.grpCd}"/></a></td>
						<td><c:out value="${vo.parentCd}"/></td>
						<td><c:out value="${vo.parentGrpCd}"/></td>
						<td class="alignL"><a href="javascript:void()" onclick="loadSelectSearchDetail('<c:out value="${vo.cd}"/>','<c:out value="${vo.grpCd}"/>')"><c:out value="${vo.cdNm}"/></a></td>
						<td><c:out value="${vo.useYn}"/></td>
					</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			</tbody>
		</table>
	</div>
	<div class="box-footer edit-btn-group">
		<ul class="pagination">
			<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
		</ul>
	</div>
</div>
<script type="text/javascript">

function loadSelectSearchDetail(cd, grpCd) {
	var selectNode = $("#tree").dynatree("getTree").selectKey(cd + "^|^" + grpCd);
	selectNode.getParent().expand(true);
	selectNode.activateSilently();
	selectNode.focus();

	$.get('selectCode.do', "cd=" + cd + "&grpCd=" + grpCd + "${listParam}", loadSuccessHandler, 'html');
}

function goPage(page){
	$.get('selectCodeSearchList.do', "paginationInfo.currentPageNo=" + page + "&${listParam}", loadSuccessHandler, 'html');
}

//목록의 정보를 Excel로 다운로드 한다.
function fn_selectCodeListXlsDwnl() {
	if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("다운로드 할 데이터가 없습니다.");
		return;
	}

	location.href = "selectCodeListXlsDwnl.do?" + $('#searchFrm').serialize();
}

$("#codeListTable").DataTable({
    dom : 'Zlfrtip',
    paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
    aoColumns : [
          {sWidth : "100px" },	// 코드
          {sWidth : "100px" },	// 그룹코드
          {sWidth : "100px" }, 	// 부모코드
          {sWidth : "100px" }, 	// 부모그룹코드
          {sWidth : "200px" }, 	// 코드명
          {sWidth : "66px" }	// 사용여부
    ],
    order : [ [ 0, "desc" ] ]
});
$("#codeListTable").css("width", "100%");
//$("#codeListTable").DataTable().columns.adjust().draw();


$('[data-toggle="tooltip"]').tooltip();
</script>