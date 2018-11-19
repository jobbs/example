<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     박봉춘         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo')}"></c:set>

<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get">
		<form:hidden path="paginationInfo.recordCountPerPage"
			id="recordCountPerPage" />
			<div class="box box-search">

				<div class="box-header">
					<h3 class="box-title">검색조건</h3>
					<div class="box-tools pull-right">
						<!-- 접기 버튼 -->
						<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
							<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
						</button>
					</div>
				</div>
				<!-- /box-header -->


				<div class="box-body collapse in search-collapse">
					<div class="form-group">
						<div class="form-cell form-cell-50 col-lay-25">
							<div class="cell-title">
								<label for="searchName">명칭</label>
							</div>
							<div class="cell-body">
								<form:input path="searchName" cssClass="form-control input-sm pull-right" title="명칭" />
							</div>
						</div>
						<div class="form-cell form-cell-50 col-lay-25">
							<div class="cell-title">
								<label for="searchHOST">HOST</label>
							</div>
							<div class="cell-body">
								<form:input path="searchHOST" cssClass="form-control input-sm pull-right" title="HOST" />
							</div>
						</div>

						<div class="form-cell form-cell-50 col-lay-25">
							<div class="cell-title">
								<label for="searchregionId">센터구분</label>
							</div>
							<div class="cell-body">
								<nform:selectRegion
									name="searchregionId"
									value="${searchVo.searchregionId }"
									cssClass="form-control input-sm pull-right"
									title="센터구분"/>
							</div>
						</div>
					</div>
				</div>
				<!-- /box-body -->


				<div class="box-footer collapse in search-collapse">
					<div class="pull-left">
						<button type="button" class="btn" onclick="formReset('searchVo')">초기화</button>
					</div>
					<div class="pull-right">
						<button type="button" class="btn btn-red" onclick="doSearch()">조회</button>
					</div>
				</div>
				<!-- /box-footer -->
			</div>
			<!-- /box(검색조건) -->
	</form:form>
</div>


<!-- 세로형 테이블 -->
<div class="col-box-100 search-col">
	<div class="box list-box">
		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">
				검색결과<small> ${searchVo.paginationInfo.currentPageNo }
					/ ${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo}" />
				</div>
			</div>
		</div>
		<!-- /box-header -->

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical table-layout-fixed" id="GatewayTable">
				<caption>API Gateway 목록 테이블</caption>
				<thead>
					<tr>
						<th>No.</th>
						<th>명칭</th>
						<th>HOST</th>
						<th>센터구분</th>
						<th>접속상태</th>
						<th>등록자</th>
						<th>등록일자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list}" varStatus="i">
						<c:url var="detailUrl" value="selectGateway.do">
							<c:forEach var="curParam" items="${param}">
								<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
							</c:forEach>
							<c:param name="gatewaySeq" value="${vo.gatewaySeq}" />
						</c:url>

						<tr>
							<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
							<td class="alignL"><a href="${detailUrl }"><c:out value="${vo.gatewayNm }" /></a></td>
							<td class="alignL"><c:out value="${vo.gatewayHost }" /></td>
							<td><c:out value="${vo.regionNm }" /></td>
							<td>
								<input type="hidden" name="regionId" value="${vo.regionId }" />
								<span class="status status-gray"  id="span_${vo.regionId }">접속상태확인중</span>
							</td>
							<td><c:out value="${vo.regUserNm }" /></td>
							<td><fmt:formatDate value="${vo.regDttm}" pattern="yyyy-MM-dd" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
			<div class="pull-left btns">

			</div>
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertGateway.do">
						<c:forEach var="curParam" items="${param }">
							<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
						</c:forEach>
					</c:url>
					<button class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가" onclick="goToUrl('${insertUrl}')">
						<i class="fa fa-plus"></i>
					</button>
				</menu:authorize>
			</div>
			<!-- /box-footer -->
		</div>
	</div>
</div>

<script type="text/javascript">

function checkHealth() {

	$("input:hidden[name='regionId']").each(function() {
		var value = $(this).val();

		$.get("selectGatewayHealthCheck.do", {"regionId" : value}, function(result) {
			var data = result.data[0];
			var $spanObj = $("#span_" + data.regionId);

			$spanObj.removeClass("status-gray status-green status-red");
			if( null == data.health ) {
				$spanObj.addClass("status-red");
				$spanObj.html("접속오류");
			} else {
				if( "ok" == data.health.condition ) {
					$spanObj.addClass("status-green");
					$spanObj.html("접속");
				} else {
					$spanObj.addClass("status-red");
					$spanObj.html("접속오류");
				}
			}
		});
	});

}
checkHealth();

function goToUrl(url) {
	location.href = url;
}

function doSearch() {
	$("#searchVo").attr("method", "selectGatewayList.do");
	$("#searchVo").submit();
}

function goPage(page) {
	location.href = "selectGatewayList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

$("#GatewayTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	               {sWidth : "40px" },
	               {sWidth : "150px" },
	               {sWidth : "200px" },
	               {sWidth : "70px" },
	               {sWidth : "100px" },
	               {sWidth : "90px" },
	               {sWidth : "90px" }
	],
	order : [ [ 0, "desc" ] ]
});
</script>
