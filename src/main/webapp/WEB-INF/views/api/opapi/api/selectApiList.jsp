<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이제율
 * @lastmodifier 이제율
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * --------------------------------------------------------------------
 * 		Date         author         ver            	 Description
 * --------------------------------------------------------------------
 * 2016. 10. 12.     이제율         		v1.0             	최초생성
 * 2016. 11. 16.     정승용         		v1.1           스크립트 추가 및 웹표준/접근성 수정
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

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo')}"></c:set>

<div class="col-box-100 search-col">
<form:form commandName="searchVo" method="GET" onsubmit="return fn_selectApi();">
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
				<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchStackClCd">스택분류</label>
					</div>
					<div class="cell-body">
						<div class="input-group">
							<nform:selectCode parentCd="201" parentGrpCd="039"
								name="searchStackClCd" id="searchStackClCd" title="스택분류" whole="true"
								value="${searchVo.searchStackClCd}"	cssClass="form-control input-sm" />
						</div>
					</div>
				</div>

				<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
				<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchApiId">API ID</label>
					</div>
					<div class="cell-body">
						<form:input path="searchApiId" title="API ID" type="text" class="form-control input-sm" />
					</div>
				</div>

				<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
				<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchApiNm">API 명</label>
					</div>
					<div class="cell-body">
						<form:input path="searchApiNm" title="API 명" type="text" class="form-control input-sm" />
					</div>
				</div>

				<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchApiVerCd">API 버전</label>
					</div>
					<div class="cell-body">
						<div class="input-group">
							<nform:selectCode parentCd="203" parentGrpCd="041"
								name="searchApiVerCd" id="searchApiVerCd" title="API 버전" whole="true"
								value="${searchVo.searchApiVerCd}" cssClass="form-control input-sm" />
						</div>
					</div>
				</div>

				<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchMethodCd">Method</label>
					</div>
					<div class="cell-body">
						<div class="input-group">
							<nform:selectCode parentCd="202" parentGrpCd="040"
								name="searchMethodCd" id="searchMethodCd" title="Method" whole="true"
								value="${searchVo.searchMethodCd}" cssClass="form-control input-sm" />
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
						<form:input path="searchUri" title="URI" type="text" class="form-control input-sm" />
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
			<h3 class="box-title">검색결과<small>
				${searchVo.paginationInfo.currentPageNo} /
				${searchVo.paginationInfo.totalPageCount}, 총
				${searchVo.paginationInfo.totalRecordCount}건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo}" />
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-hover-green" data-toggle="tooltip"
							title="" data-original-title="엑셀다운로드" onclick="fn_downloadExcel();"><i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /box-header -->

		<!-- box-body -->
		<div class="box-body no-padding list-body">
		<form:form commandName="apiVo" method="get">
			<table class="table table-hover table-vertical table-layout-fixed" id="apiTable">
				<caption>API관리</caption>
				<thead>
					<tr>
						<th><input type="checkbox" id="selectAll" title="전체선택"></th>
						<th>No.</th>
						<th>스택분류</th>
						<th>API ID</th>
						<th>API 명</th>
						<th>API 버전</th>
						<th>Method</th>
						<th>URI</th>
						<th>등록자</th>
						<th>등록일자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="apiVo" items="${list }" varStatus="i">
						<c:url var="detailUrl" value="selectApi.do">
							<c:forEach var="curParam" items="${param}">
								<c:param name="${curParam.key }" value="${curParam.value}"></c:param>
							</c:forEach>
							<c:param name="keyId" value="${apiVo._id}" />
						</c:url>
						<tr>
							<td>
								<input type="checkbox" name="delKey" class="delKey"	value="${apiVo._id}" onclick="fn_deleteCheck(this)" title="항목선택" />
								<input type="checkbox" name="delRev" class="delRev" value="${apiVo._rev}" style="display: none" title="항목선택" /></td>
							<td>
								<c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" />
							</td>
							<td><c:out value="${apiVo.stackClNm}" /></td>
							<td class="alignL">
								<a href="<c:url value="${detailUrl}" />" title="<c:out value="${apiVo.dc}"/>"><c:out value="${apiVo.apiId}" /></a>
							</td>
							<td class="alignL"><c:out value="${apiVo.apiNm}" /></td>
							<td class="alignC"><c:out value="${apiVo.apiVerNm}" /></td>
							<td class="alignC"><c:out value="${apiVo.methodNm}" /></td>
							<td class="alignL"><c:out value="${apiVo.uri}" /></td>
							<td><c:out value="${apiVo.regUserNm}" /></td>
							<td><c:out value="${apiVo.regDt}" /></td>
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
				<ui:pagination paginationInfo="${searchVo.paginationInfo}" type="common" jsFunction="fn_goPage" />
			</ul>
			<div class="pull-right btns">

					<c:url var="insertUrl" value="insertApi.do">
						<c:forEach var="curParam" items="${param}">
							<c:param name="${curParam.key}" value="${curParam.value}"></c:param>
						</c:forEach>
					</c:url>
					<menu:authorize>
					<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가"
						onclick="goToUrl('${insertUrl}')"><i class="fa fa-plus"></i>
					</button>
					<button type="button" class="btn btn-hover-red" data-toggle="tooltip" data-original-title="삭제"
						onclick="jConfirm('Api를 삭제하시겠습니까?', fn_deleteApi)"><i class="fa fa-minus"></i>
					</button>
					</menu:authorize>
			</div>
		</div>
		<!-- /box-footer -->
	</div>
</div>

<script type="text/javascript">
//체크박스 설정
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
function fn_selectApi() {
	$.ncmsLoding.startFullScreen();
}

// 페이징 이동
function fn_goPage(page) {
	location.href = "selectApiList.do?paginationInfo.currentPageNo=" + page	+ "&${listParam}";
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

// 선택Api 삭제
function fn_deleteApi() {
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
	$.post('deleteChkApi.do', $('#apiVo').serialize(), fn_deleteApiCallBakc, 'json').always(function() {
		$.ncmsLoding.remove();
	 });
}

// API삭제 콜백
function fn_deleteApiCallBakc(result) {
	alert_message(result.messageList, function() {
		if (result.success) {
			if (result.procType == "delete") {
				location.href = "selectApiList.do";
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

	$("#searchVo").attr("action", "selectApiListXlsDwnl.do");
	$("#searchVo").submit();
	$.ncmsLoding.remove();
}

//테이블 정렬
$("#apiTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,

	//colgroup 대신 여기에 입력
	aoColumns : [
	   { sWidth : "30px" },
	   { sWidth : "40px" },
	   { sWidth : "100px"},
	   { sWidth : "150px"},
	   { sWidth : "150px"},
	   { sWidth : "60px" },
	   { sWidth : "70px" },
	   { sWidth : "250px" },
	   { sWidth : "80px"},
	   { sWidth : "80px"}
	],
	order : [ [ 0, "desc" ] ]
});
</script>