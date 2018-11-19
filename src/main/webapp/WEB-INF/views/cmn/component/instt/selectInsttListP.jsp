<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 8.
 * @lastmodified 2016. 10. 8.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 8.     신재훈         v1.0             최초생성
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

<script type="text/javascript"	src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript"	src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript"	src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100">
	<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
	<form:hidden path="searchType"/>
	<form:hidden path="type" value="${searchVo.searchType }" />
	<!-- 검색조건 영역 -->
	<div class="box-search">
		<div class="box-body">
			<div class="form-group">
				<div class="form-cell form-cell-50">
					<div class="cell-title">
						<label for="searchInttNm">부처명</label>
					</div>
					<div class="cell-body">
						<div class="input-group">
							<form:input path="searchInttNm" class="form-control input-sm" title="부처명"/>
						</div>
					</div>
				</div>

				<div class="form-cell form-cell-100 alignR pad-top-5">
					<button class="btn btn-red btn-sm" type="button" onclick="fn_selectInsttList()">조회</button>
				</div>
			</div>
		</div>
	</div>
	</form:form>
	<!-- /검색조건 영역 -->
	<!-- 테이블 영역 -->
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
			<form id="insttFrm" name="insttFrm">
			<table class="table table-hover table-vertical table-layout-fixed" id="insttListPTable">
				<caption>부처팝업목록(센터구분, 부처)</caption>
				<thead>
					<tr>
						<th>
							<c:if test="${searchVo.searchType eq 'M' }">
								<input type="checkbox" id="chkInstitutionIdAll" title="부처 전체 선택" onclick="doCheckAll(this, 'institutionId')" />
							</c:if>
						</th>
						<th>부처ID</th>
						<th>부처</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="insttVo" items="${list }" varStatus="i">
				<tr>
					<td>
						<c:choose>
						<c:when test="${searchVo.searchType eq 'M' }">
								<input type="checkbox" name="institutionId" class="institutionId" value="${insttVo.institutionId }" title="항목선택"/>
							</c:when>
							<c:otherwise>
								<input type="radio" name="institutionId" value="${insttVo.institutionId }" title="항목선택"/>
							</c:otherwise>
						</c:choose>
						<input type="hidden" name="institutionNm" value="${insttVo.institutionNm }">
					</td>
					<td><c:out value="${insttVo.institutionId}" /></td>
					<td class="alignL"><c:out value="${insttVo.institutionNm }" /></td>
				</tr>
				</c:forEach>
				</tbody>
			</table>
			</form>
		</div>

		<div class="box-footer">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }"	type="common" jsFunction="goPage" />
			</ul>
			<!-- /box-body -->
		</div>
		<!-- /테이블 영역 -->
	</div>
</div>
<div class="col-box-100">
	<div class="button">
		<c:choose>
			<c:when test="${searchVo.searchType eq 'M' }">
				<button type="button" class="btn btn-dark" onclick="selectInsttM()">선택</button>
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-dark" onclick="selectInsttS()">선택</button>
			</c:otherwise>
		</c:choose>
		<button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
	</div>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>
<script type="text/javascript">
// 페이지 이동
function goPage(page) {
// 	location.href = "selectInsttListP.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
	var type = $("input:hidden[name='type']").val();
	location.href = "selectInsttListP.do?paginationInfo.currentPageNo=" + page + "&&searchType=" + type;
}

function fn_selectInsttList(){
	$("#searchVo").attr("action", "selectInsttListP.do");
	$("#searchVo").submit();
}

function doCheckAll(obj, clazz) {
	$("." + clazz).prop("checked", $(obj).prop("checked"));
}

function selectInsttM(){
	if( $("input:checkbox[name='institutionId']:checked").size() == 0 ) {
		jAlert("부처를 한항목 이상 선택하여 주시기 바랍니다.");
		return;
	}

	var datas = new Array();
	var data = null;
	$("input:checkbox[name='institutionId']").each(function(index) {
		if( $(this).prop("checked") ) {
			data = new EntityInstitution();
			data.institutionId = $(this).val();
			data.institutionNm = $("input:hidden[name='institutionNm']:eq(" + index + ")").val();
			datas.push(data);
		}
	});

	var evt = jQuery.Event('selectInstitutionMulti', {
		"procType" : "<c:out value="${searchVo.searchType}" />",
		"datas" : datas
    });

    var _parent = window.opener;
    _parent.jQuery(_parent.document).trigger(evt);
	window.close();
}

function selectInsttS(){

	if( $("input:radio[name='institutionId']:checked").size() == 0 ) {
		jAlert("부처를 선택하여 주시기 바랍니다.");
		return;
	}

	var data = null;
	$("input:radio[name='institutionId']").each(function(index) {
		if( $(this).prop("checked") ) {
			data = new EntityInstitution();
			data.institutionId = $(this).val();
			data.institutionNm = $("input:hidden[name='institutionNm']:eq(" + index + ")").val();
		}
	});

	var evt = jQuery.Event('selectInstitution', {
		"procType" : "<c:out value="${searchVo.searchType}" />",
		"datas" : data
    });

    var _parent = window.opener;
    _parent.jQuery(_parent.document).trigger(evt);
    window.close();
}

$("#insttFrm input[name='institutionId']").click(function(event) {
	event.stopPropagation();
});


$("#insttFrm input[name='institutionId']").parent().parent().click(function() {
	var $target = $(this).find("input[name='institutionId']");
	if( $target.attr("type") == "radio" ) {
		$target.prop("checked", true);
	} else {
		var checked = $target.prop("checked");
		$target.prop("checked", !checked);
	}
});

$("#insttListPTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	               {sWidth : "80px" },
	               {sWidth : "300px" },
	               {sWidth : "300px" }
	],
	order : [ [ 0, "desc" ] ]
});
</script>