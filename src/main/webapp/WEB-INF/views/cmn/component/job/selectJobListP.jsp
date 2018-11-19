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
						<label for="searchRegionId">센터</label>
					</div>
					<div class="cell-body">
						<nform:selectRegion
								name="searchRegionId"
								id="searchRegionId"
								byRole="false"
								value="${searchVo.searchRegionId }"
								cssClass="form-control input-sm"
								title="센터"/>
					</div>
				</div>
				<div class="form-cell form-cell-50">
					<div class="cell-title">
						<label for="searchInttNm">부처</label>
					</div>
					<div class="cell-body">
						<div class="input-group">
							<form:input path="searchInttNm" class="form-control input-sm" title="부처"/>
						</div>
					</div>
				</div>
				<div class="form-cell form-cell-50">
					<div class="cell-title">
						<label for="searchInttId">부처ID</label>
					</div>
					<div class="cell-body">
						<div class="input-group">
							<form:input path="searchInttId" class="form-control input-sm" title="부처ID"/>
						</div>
					</div>
				</div>
				<div class="form-cell form-cell-50">
					<div class="cell-title">
						<label for="searchJobNm">업무</label>
					</div>
					<div class="cell-body">
						<form:input path="searchJobNm" class="form-control input-sm" title="업무"/>
					</div>
				</div>
				<div class="form-cell form-cell-50">
					<div class="cell-title">
						<label for="searchJobId">업무ID</label>
					</div>
					<div class="cell-body">
						<form:input path="searchJobId" class="form-control input-sm" title="업무ID"/>
					</div>
				</div>
				<div class="form-cell form-cell-50">
					<div class="cell-title">
						<label for="searchCludJob1">클라우드업무</label>
					</div>
					<div class="cell-body input-group input-group-radio">
						<form:radiobutton path="searchCludJob" value="" label="전체"  title="클라우드업무-전체"/>
						<form:radiobutton path="searchCludJob" value="Y" label="Y" title="클라우드업무-Y"/>
						<form:radiobutton path="searchCludJob" value="N" label="N" title="클라우드업무-N"/>
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
				<caption>부처 업무 목록 테이블</caption>
				<colgroup>
					<col class="col5">
					<col class="col10">
					<col class="col35">
					<col class="col10">
					<col class="col35">
					<col class="col10">
					<col class="col15">
				</colgroup>
				<thead>
				<tr>
					<th>
						<c:if test="${searchVo.searchType eq 'M' }">
							<input type="checkbox" id="chkJobAll" title="부처 업무 전체 선택" onclick="doCheckAll(this, 'jobId')" />
						</c:if>
					</th>
					<th>센터</th>
					<th>부처</th>
					<th>부처ID</th>
					<th>업무</th>
					<th>업무ID</th>
					<th>클라우드업무</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="vo" items="${list }" varStatus="i">
					<tr>
						<td>
							<c:choose>
								<c:when test="${searchVo.searchType eq 'M' }">
									<input type="checkbox" name="jobId" class="jobId" value="${vo.jobId }" title="업무ID ${vo.jobId }" />
								</c:when>
								<c:otherwise>
									<input type="radio" name="jobId" value="${vo.jobId }" title="업무ID ${vo.jobId }" />
								</c:otherwise>
							</c:choose>
							<input type="hidden" name="jobNm" value="${vo.jobNm }" />
							<input type="hidden" name="cludJob" value="${vo.cludJob }" />
							<input type="hidden" name="jobGrd" value="${vo.jobGrd }" />
							<input type="hidden" name="institutionId" value="${vo.institutionId }" />
							<input type="hidden" name="institutionNm" value="${vo.institution.institutionNm }" />
							<input type="hidden" name="regionId" value="${vo.regionId }" />
							<input type="hidden" name="regionNm" value="${vo.regionNm }" />
						</td>
						<td><c:out value="${vo.regionNm }" /></td>
						<td class="alignL"><c:out value="${vo.institution.institutionNm }" /></td>
						<td class="alignL"><c:out value="${vo.institution.institutionId }" /></td>
						<td class="alignL"><c:out value="${vo.jobNm }" /></td>
						<td class="alignL"><c:out value="${vo.jobId }" /></td>
						<td><c:out value="${vo.cludJob }" /></td>
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
<div class="col-box-100">
	<div class="button">
		<c:choose>
			<c:when test="${searchVo.searchType eq 'M' }">
				<button type="button" class="btn btn-dark" onclick="selectJobM()">선택</button>
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-dark" onclick="selectJobS()">선택</button>
			</c:otherwise>
		</c:choose>
		<button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
	</div>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>
<script type="text/javascript">

function doCheckAll(obj, clazz) {
	$("." + clazz).prop("checked", $(obj).prop("checked"));
}

function goPage(page){
	location.href = "selectJobListP.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

function selectJobM(){

	if( $("input:checkbox[name='jobId']:checked").size() == 0 ) {
		jAlert("업무를 한항목 이상 선택하여 주시기 바랍니다.");
		return;
	}

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
    _parent.jQuery(_parent.document).trigger(evt);
	window.close();
}

function selectJobS(){

	if( $("input:radio[name='jobId']:checked").size() == 0 ) {
		jAlert("업무를 선택하여 주시기 바랍니다.");
		return;
	}

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