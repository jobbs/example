<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     박희택         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="GET" onsubmit="return fn_selectOpenApi();">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<button type="button" class="btn btn-sm" data-toggle="collapse"	data-target=".search-collapse">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기"></i>
					</button>
				</div>
			</div>
			<!-- /box-header -->

			<!-- box-body -->
			<div class="box-body collapse in search-collapse">
				<div class="form-group">
					<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchOpenApiNm">OpenAPI명</label>
						</div>
						<div class="cell-body">
							<form:input path="searchOpenApiNm" type="text" class="form-control input-sm" title="OpenAPI명"/>
						</div>
					</div>

					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchStatCd">상태</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<nform:selectCode parentCd="200" parentGrpCd="038"
									name="searchStatCd" id="searchStatCd" whole="true"
									value="${searchVo.searchStatCd}"
									cssClass="form-control input-sm" title="상태"/>
							</div>
						</div>
					</div>

					<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchUri">URI</label>
						</div>
						<div class="cell-body">
							<form:input path="searchUri" type="text" class="form-control input-sm" title="URI명"/>
						</div>
					</div>

				</div>
			</div>

			<div class="box-footer collapse in search-collapse">
				<div class="pull-left">
					<button type="button" class="btn" onClick="fn_reset();">초기화</button>
				</div>
				<div class="pull-right">
					<button class="btn btn-red" data-original-title="조회" >조회</button>
				</div>
			</div>
			<!-- /box-footer -->
		</div>
		<!-- /box(검색조건) -->
	</form:form>
</div>
<!-- /col -->

<div class="col-box-100 search-col">
	<div class="box list-box">

		<div class="box-header">
			<h3 class="box-title">
				검색결과<small> ${searchVo.paginationInfo.currentPageNo } /
					${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo"
						value="${searchVo }" />
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-hover-green"
							data-toggle="tooltip" title="" data-original-title="엑셀다운로드"
							onclick="fn_downloadExcel();"><i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
			<!-- /box-header -->
		</div>
		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<form:form commandName="openApiVo" method="get">
				<table class="table table-hover table-vertical table-layout-fixed" id="openApiTable">
					<caption>OpenAPI관리</caption>
					<thead>
						<tr>
							<th><input type="checkbox" id="selectAll" title="전체선택"></th>
							<th>No.</th>
							<th>OpenAPI명</th>
							<th>URI</th>
							<th>상태</th>
							<th>작성자</th>
							<th>등록일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="openApiVo" items="${list }" varStatus="i">
							<c:url var="detailUrl" value="selectOpenApi.do">
								<c:forEach var="curParam" items="${param }">
									<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
								</c:forEach>
								<c:param name="opApiNm" value="${openApiVo.opApiNm }" />
								<c:param name="opApiId" value="${openApiVo._id }" />
							</c:url>
							<tr>
								<td>
									<input type="checkbox" name="delKey" class="delKey"	value="${openApiVo._id }" onclick="fn_deleteCheck(this)" title="항목선택"/>
									<input type="checkbox" name="delRev" class="delRev"	value="${openApiVo._rev }" style="display: none" title="항목선택"/>
								</td>
								<td>
									<c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" />
								</td>
								<td class="alignL">
									<a href="<c:url value="${detailUrl }" />" title="<c:out value="${openApiVo.dc}"/>"><c:out value="${openApiVo.opApiNm}" /></a>
								</td>
								<td class="alignL"><c:out value="${openApiVo.uri}" /></td>
								<c:choose>
									<c:when test="${openApiVo.statCd eq 'Y'}">
										<td>활성</td>
									</c:when>
									<c:otherwise>
										<td>비활성</td>
									</c:otherwise>
								</c:choose>
								<td><c:out value="${openApiVo.regUserNm }" /></td>
								<td><c:out value="${openApiVo.regDt }" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form:form>
		</div>
		<!-- /box-body   -->

		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }"
					type="common" jsFunction="fn_goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertOpenApi.do">
						<c:forEach var="curParam" items="${param }">
							<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
						</c:forEach>
					</c:url>
					<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가" onclick="goToUrl('${insertUrl}')"><i class="fa fa-plus"></i></button>
					<button type="button" class="btn btn-hover-red"	data-toggle="tooltip" data-original-title="삭제" onclick="jConfirm('OpenApi를 삭제하시겠습니까?', fn_deleteOpenApi)"><i class="fa fa-minus"></i></button>
				</menu:authorize>
			</div>
		</div>
		<!-- /box-footer -->
	</div>
</div>

<script type="text/javascript">
// 체크박스 설정
$(document).ready(function() {
	$('#selectAll').click(function() {
		$('.delKey').prop('checked', $(this).is(":checked"));
		fn_deleteCheck($('.delKey'));
	});

	$('.delKey').click(function() {
		if ($('.delKey:checked').length == $('.delKey').length) {
			$('#selectAll').prop('checked', true);
		} else {
			$('#selectAll').prop('checked', false);
		}
	});
});

// 조회
function fn_selectOpenApi() {
	$.ncmsLoding.startFullScreen();
}


// 페이징 이동
function fn_goPage(page) {
	location.href = "selectOpenApiList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

// key 체크박스가 클릭되면 rev 체크박스도 같이 선택되게 함
function fn_deleteCheck(obj) {
	$("input:checkbox[name='delKey']").each(
		function(idx) {
			if ($(this).prop("checked")) {
				$("input:checkbox[name='delRev']:eq(" + idx + ")").prop("checked", true);
			} else {
				$("input:checkbox[name='delRev']:eq(" + idx + ")").prop("checked", false);
			}
		});
}

// 검색조건 초기화
function fn_reset() {
	$("#searchVo input[type='text']").val("");
	$("#searchVo select").val("").attr("selected", "selected");
}

// 선택openApi 삭제
function fn_deleteOpenApi() {
	var checked = 0;
	$("input[name='delKey']").each(function() {
		if ($(this).prop("checked")) {
			checked++;
		}
	});

	if (checked == 0) {
		parent.jAlert("삭제대상을 선택하시기 바랍니다.");
		return;
	}

	$.ncmsLoding.startFullScreen();
	$.post('deleteChkOpenApi.do', $('#openApiVo').serialize(), fn_deleteOpenApiCallBakc, 'json').always(function() {
		$.ncmsLoding.remove();
	 });
}

// 스펙삭제 콜백
function fn_deleteOpenApiCallBakc(result) {
	alert_message(result.messageList, function() {
		if (result.success) {
			if (result.procType == "delete") {
				location.href = "selectOpenApiList.do";
			}
		}
	}, (result.success ? "INFO" : ""));
}

// 엑셀 다운로드
function fn_downloadExcel() {
	if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("다운로드할 데이터가 없습니다");
		return;
	}

	$("#searchVo").attr("action", "selectOpenApiListXlsDwnl.do");
	$("#searchVo").submit();
	$.ncmsLoding.remove();
}

//테이블 정렬
$("#openApiTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,

	//colgroup 대신 여기에 입력
	aoColumns : [
	   { sWidth : "30px" },
	   { sWidth : "40px" },
	   { sWidth : "200px" },
	   { sWidth : "220px" },
	   { sWidth : "50px"},
	   { sWidth : "80px"},
	   { sWidth : "80px"}
	],
	order : [ [ 0, "desc" ] ]
});
</script>