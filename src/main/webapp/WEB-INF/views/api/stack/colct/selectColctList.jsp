<!--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최장성
 * @lastmodifier 최장성
 * @created 2016. 11. 11.
 * @lastmodified 2016. 11. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 11.     최장성         v1.0             기능개발
 *
-->
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
	<form:form commandName="searchVo" method="GET" onsubmit="return fn_selectMngr();">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse"><i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기"></i>
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
							<label for="searchRegionId">센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion name="searchRegionId" id="searchRegionId"
								title="지역" cssClass="form-control input-sm"
								value="${searchVo.searchRegionId}" whole="true"
								onchange="selectZoneDy(this, 'searchZoneId' )" byRole="false"/>
						</div>
					</div>

					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchZoneId">존</label>
						</div>
						<div class="cell-body">
							<nform:selectZone name="searchZoneId" id="searchZoneId"
								title="Zone" cssClass="form-control input-sm" whole="true"
								regionId="${searchVo.searchRegionId}"
								value="${searchVo.searchZoneId}"
								onchange="selectNetDy(this, 'searchNetId')" />
						</div>
					</div>

					<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchNetId">망</label>
						</div>
						<div class="cell-body">
							<nform:selectNet name="searchNetId" id="searchNetId" title="망"
								cssClass="form-control input-sm" whole="true"
								zoneId="${searchVo.searchZoneId}"
								value="${searchVo.searchNetId}"
								onchange="selectPoolDy(this, 'searchRegionId', 'searchZoneId')" />
						</div>
					</div>

					<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchStackClCd">스택 분류</label>
						</div>
						<div class="cell-body">
							<nform:selectCode parentCd="201" parentGrpCd="039"
								name="searchStackClCd" id="searchStackClCd" whole="true"
								value="${searchVo.searchStackClCd}"
								cssClass="form-control input-sm"
								onchange="selectboxDy('039', this,'searchMngrClCd',true)" />
						</div>
					</div>

					<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchMngrClCd">매니저 분류</label>
						</div>
						<div class="cell-body">
							<nform:selectCode parentCd="${searchVo.searchStackClCd}"
								parentGrpCd="039" name="searchMngrClCd" id="searchMngrClCd"
								whole="true" title="매니저 분류" value="${searchVo.searchMngrClCd}"
								cssClass="form-control input-sm"
								onchange="selectboxDy('039', this,'searchNowVerCd',true)" />
						</div>
					</div>

					<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchNowVerCd">매니저 버전</label>
						</div>
						<div class="cell-body">
							<nform:selectCode parentCd="${searchVo.searchMngrClCd}"
								parentGrpCd="039" name="searchNowVerCd" id="searchNowVerCd"
								whole="true" title="매니저 버전" value="${searchVo.searchNowVerCd}"
								cssClass="form-control input-sm" />
						</div>
					</div>

					<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchMngrNm">매니저 명</label>
						</div>
						<div class="cell-body">
							<form:input path="searchMngrNm" type="text" class="form-control input-sm" placeholder="검색어 입력"/>
						</div>
					</div>
				</div>
			</div>

			<div class="box-footer collapse in search-collapse">
				<div class="pull-left">
					<button type="button" class="btn" onclick="fn_reset();">초기화</button>
				</div>
				<div class="pull-right">
					<button class="btn btn-red pull-right" >조회</button>
				</div>
			</div><!-- /box-footer -->
		</div><!-- /box(검색조건) -->
	</form:form>
</div><!-- /col -->

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">검색결과
				<small>
					${searchVo.paginationInfo.currentPageNo } /
					${searchVo.paginationInfo.totalPageCount },
					총 ${searchVo.paginationInfo.totalRecordCount }건
				</small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
     				<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/>
     				<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-hover-green"
							data-toggle="tooltip" title="" data-original-title="엑셀다운로드"
							onclick="fn_downloadExcel();"><i class="fa fa-download"></i>
						</button>
					</div>
				</div>
  			</div><!-- /box-header -->
  		</div>
		<div class="box-body no-padding list-body">
			<form:form commandName="colctVo" method="get">
			<table class="table table-hover table-vertical table-layout-fixed" id="colctListTable">
				<caption>배치수집현황목록</caption>
				<thead>
					<tr>
						<th>No.</th>
						<th>센터</th>
						<th>존</th>
						<th>망</th>
						<th>스택 분류</th>
						<th>매니저 분류</th>
						<th>현재 버전</th>
						<th>매니저 명</th>
						<th>수집구분</th>
						<th>상태</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="colctVo" items="${list}" varStatus="i">
						<tr>
							<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
							<td><c:out value="${colctVo.regionNm}" /></td>
							<td><c:out value="${colctVo.zoneNm}" /></td>
							<td><c:out value="${colctVo.netNm}" /></td>
							<td><c:out value="${colctVo.stackClNm}" /></td>
							<td><c:out value="${colctVo.mngrClNm}" /></td>
							<td><c:out value="${colctVo.nowVerNm}" /></td>
							<td class="alignL"><c:out value="${colctVo.mngrNm}" /></td>
							<td><c:out value="${colctVo.btchColctNm}" /></td>
							<td>
								<input type="hidden" name="colctId" value="${i.count}" />
								<input type="hidden" name="mngrId_${i.count}" value="${colctVo._id}" />
								<input type="hidden" name="stackClCd_${i.count}" value="${colctVo.stackClCd}" />
								<input type="hidden" name="btchColctCd_${i.count}" value="${colctVo.btchColctCd}" />
								<input type="hidden" name="monitoringYN_${i.count}" value="${colctVo.monitoringYN}" />
								<span class="status status-gray" id="span_${i.count}">확인중</span>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</form:form>
		</div>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
            <ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo}" type="common" jsFunction="fn_goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertMngr.do">
						<c:forEach var="curParam" items="${param}">
							<c:param name="${curParam.key}" value="${curParam.value}"></c:param>
						</c:forEach>
					</c:url>
				</menu:authorize>
			</div>
		</div>
		<!-- /box-footer -->
	</div>
</div>

<script type="text/javascript">

function checkHealth() {
	$("input:hidden[name='colctId']").each(function() {
		var value = $(this).val();
		var mngrId = $("input:hidden[name='mngrId_"+value+"']").val();
		var stackClCd = $("input:hidden[name='stackClCd_"+value+"']").val();
		var btchColctCd = $("input:hidden[name='btchColctCd_"+value+"']").val();
		var monitoringYN = $("input:hidden[name='monitoringYN_"+value+"']").val();

		if(monitoringYN == "N") {
			var $spanObj = $("#span_" + value);
			$spanObj.removeClass("status-gray status-green status-red");
			$spanObj.addClass("status-gray");
			$spanObj.html("중지");
		} else {
	 		$.get("selectColctHealthCheck.do", {"colctId" : value, "mngrId" : mngrId, "stackClCd" : stackClCd, "btchColctCd" : btchColctCd}, function(result) {
				var data = result.data;
				var $spanObj = $("#span_" + data._id);
				$spanObj.removeClass("status-gray status-green status-red");
				if( true == data.btchSttus ) {
					$spanObj.addClass("status-blue");
					$spanObj.html("정상");
				} else {
					$spanObj.addClass("status-red");
					$spanObj.html("지연");
				}
			});
		}
	});

}
checkHealth();

//조회버튼 클릭시.
function fn_selectMngr() {
	$.ncmsLoding.startFullScreen();
}

//페이징 이동
function fn_goPage(page){
	location.href = "selectColctList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

//초기화 버튼 클릭 시
function fn_reset() {
	$("#searchVo input[type='text']").val("");
	$("#searchVo select").val("").attr("selected","selected");
}

//엑셀 다운로드
function fn_downloadExcel() {
	if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("다운로드할 데이터가 없습니다");
		return;
	}

	$("#searchVo").attr("action", "selectColctListXlsDwnl.do");
	$("#searchVo").submit();
	$.ncmsLoding.remove();
}

//테이블 정렬
$("#colctListTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,

	//colgroup 대신 여기에 입력
	aoColumns : [
	   { sWidth : "40px" },
	   { sWidth : "40px" },
	   { sWidth : "40px" },
	   { sWidth : "60px"},
	   { sWidth : "90px"},
	   { sWidth : "90px"},
	   { sWidth : "50px" },
	   { sWidth : "155px" },
	   { sWidth : "100px"},
	   { sWidth : "50px "}
	],
	order : [ [ 0, "desc" ] ]
});
</script>