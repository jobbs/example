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
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
	<form:hidden path="searchType"/>
	<div class="box-search">
		<div class="box-body">
			<div class="form-group">
				<div class="form-cell form-cell-50">
					<div class="cell-title">
						<label>센터</label>
					</div>
					<div class="cell-body">
						<nform:selectRegion
								name="searchRegionId"
								id="searchRegionId"
								value="${searchVo.searchRegionId }"
								cssClass="form-control input-sm" />
					</div>
				</div>
				<div class="form-cell form-cell-50">
					<div class="cell-title">
						<label>부처</label>
					</div>
					<div class="cell-body">
						<div class="input-group">
							<form:input path="searchInttNm" class="form-control input-sm" />
						</div>
					</div>
				</div>
				<div class="form-cell form-cell-50">
					<div class="cell-title">
						<label>업무</label>
					</div>
					<div class="cell-body">
						<form:input path="searchJobNm" class="form-control input-sm" />
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
			<form action="jobFrm" id="jobFrm">
			<table class="table table-hover table-vertical">
				<caption>업무 목록 테이블</caption>
				<colgroup>
					<col class="col10">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
				</colgroup>
				<thead>
				<tr>
					<th></th>
					<th>센터</th>
					<th>부처</th>
					<th>업무</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="vo" items="${list }" varStatus="i">
					<tr>
						<td>
							<c:choose>
								<c:when test="${searchVo.searchType eq 'M' }">
									<input type="checkbox" name="jobId" value="${vo.jobId }" />
								</c:when>
								<c:otherwise>
									<input type="radio" name="jobId" value="${vo.jobId }"/>
								</c:otherwise>
							</c:choose>
							<input type="hidden" name="jobNm" value="${vo.jobNm }" />
							<input type="hidden" name="cludJob" value="${vo.cludJob }" />
							<input type="hidden" name="jobGrd" value="${vo.jobGrd }" />
							<input type="hidden" name="institutionId" value="${vo.institutionId }" />
							<input type="hidden" name="institutionNm" value="${vo.institution.institutionNm }" />
							<input type="hidden" name="regionId" value="${vo.institution.regionId }" />
							<input type="hidden" name="regionNm" value="${vo.institution.regionNm }" />
						</td>
						<td><c:out value="${vo.institution.regionNm }" /></td>
						<td class="alignL"><c:out value="${vo.institution.institutionNm }" /></td>
						<td class="alignL"><c:out value="${vo.jobNm }" /></td>
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
			<div class="btn-group pull-right">
			<c:choose>
				<c:when test="${searchVo.searchType eq 'M' }">
					<button type="button" class="btn btn-function" onclick="selectJobM()">선택</button>
				</c:when>
				<c:otherwise>
					<button type="button" class="btn btn-function" onclick="selectJobS()">선택</button>
				</c:otherwise>
			</c:choose>
			</div>
		</div>
		<!-- /box-footer -->
	</div>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>
<script type="text/javascript">
function goPage(page){
	location.href = "selectJobListP.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

function selectJobM(){

	var datas = new Array();
	var data = null;
	$("input:checkbox[name='jobId']").each(function(index) {
		if( $(this).prop("checked") ) {
			data = new EntityJob();
			data.jobId = $(this).val();
			data.jobNm = $("input:hidden[name='jobNm']:eq(" + index + ")").val();
			data.cludJob = $("input:hidden[name='cludJob']:eq(" + index + ")").val();
			data.jobGrd = $("input:hidden[name='jobGrd']:eq(" + index + ")").val();
			data.institutionId = $("input:hidden[name='institutionId']:eq(" + index + ")").val();
			data.institutionNm = $("input:hidden[name='institutionNm']:eq(" + index + ")").val();
			data.regionId = $("input:hidden[name='regionId']:eq(" + index + ")").val();
			data.regionNm = $("input:hidden[name='regionNm']:eq(" + index + ")").val();
			datas.push(data);
		}
	});

	var evt = jQuery.Event('selectJobMulti', {
		"procType" : "<c:out value="${searchVo.searchType}" />",
		"datas" : datas
    });

    var _parent = window.opener;
    _parent.jQuery(_parent.document).trigger(evt).unbind("selectJobMulti");
	window.close();
}

function selectJobS(){

	var data = null;
	$("input:radio[name='jobId']").each(function(index) {
		if( $(this).prop("checked") ) {
			data = new EntityJob();
			data.jobId = $(this).val();
			data.jobNm = $("input:hidden[name='jobNm']:eq(" + index + ")").val();
			data.cludJob = $("input:hidden[name='cludJob']:eq(" + index + ")").val();
			data.jobGrd = $("input:hidden[name='jobGrd']:eq(" + index + ")").val();
			data.institutionId = $("input:hidden[name='institutionId']:eq(" + index + ")").val();
			data.institutionNm = $("input:hidden[name='institutionNm']:eq(" + index + ")").val();
			data.regionId = $("input:hidden[name='regionId']:eq(" + index + ")").val();
			data.regionNm = $("input:hidden[name='regionNm']:eq(" + index + ")").val();
		}
	});

	var evt = jQuery.Event('selectJob', {
		"procType" : "<c:out value="${searchVo.searchType}" />",
		"datas" : data
    });

    var _parent = window.opener;
    _parent.jQuery(_parent.document).trigger(evt);
    window.close();
}

$("#jobFrm input[name='jobId']").click(function(event) {
	event.stopPropagation();
});

$("#jobFrm input[name='jobId']").parent().parent().click(function() {
	var $target = $(this).find("input[name='jobId']");
	if( $target.attr("type") == "radio" ) {
		$target.prop("checked", true);
	} else {
		var checked = $target.prop("checked");
		$target.prop("checked", !checked);
	}
});
</script>