<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 12. 09.
 * @lastmodified 2016. 12. 09.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 09.     박봉춘         v1.0             최초생성
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

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo')}"></c:set>

<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
	<form:hidden path="startTimefirstSearch" />
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
						<label for="searchBtchWrkNm">배치 작업 명</label>
					</div>
					<div class="cell-body">
						<form:input path="searchBtchWrkNm" cssClass="form-control input-sm pull-right" title="배치작업명" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchBtchWrkId">배치 작업 ID</label>
					</div>
					<div class="cell-body">
						<form:input path="searchBtchWrkId" cssClass="form-control input-sm pull-right" title="배치작업명" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchBtchStatus">배치 상태</label>
					</div>
					<div class="cell-body">
						<form:select path="searchBtchStatus" cssClass="form-control input-sm" title="최종작업상태">
							<form:option value="">전체</form:option>
							<form:option value="ABANDONED">ABANDONED</form:option>
							<form:option value="COMPLETED">COMPLETED</form:option>
							<form:option value="FAILED">FAILED</form:option>
							<form:option value="STARTED">STARTED</form:option>
							<form:option value="STARTING">STARTING</form:option>
							<form:option value="STOPPING">STOPPING</form:option>
							<form:option value="UNKNOWN">UNKNOWN</form:option>
						</form:select>
					</div>
				</div>
				<div class="form-cell form-cell-100 col-lay-100">
					<div class="cell-title"><label for="searchBtchStartTimeStart">배치 시작시간</label></div>
					<div class="cell-body">
						<div class="input-group period period-start">
							<form:input path="searchBtchStartTimeStart" cssClass="form-control input-sm datepicker" onchange="initDate(this, 'searchBtchStartTimeEnd', 'S')" title="배치시작일시"/>
						</div>
						<div class="input-group period period-end">
							<form:input path="searchBtchStartTimeEnd" cssClass="form-control input-sm datepicker" onchange="initDate(this, 'searchBtchStartTimeStart', 'E')" title="배치시작일시"/>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /box-body -->
		<div class="box-footer collapse in search-collapse">
			<div class="pull-left">
				<button type="button" class="btn" onclick="initializeForm()">초기화</button>
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
    				<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/>
    				<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_selectBtchHistListXlsDwnl()"><i class="fa fa-download"></i></button>
					</div>
    			</div>
   			</div>
		</div>
		<!-- /box-header -->

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical table-layout-fixed" id="BtchHistTable">
				<caption>배치 이력 목록 조회 테이블</caption>
				<thead>
					<tr>
						<th>No.</th>
						<th>배치 작업 명</th>
						<th>배치 작업 ID</th>
						<th>배치 시작시간</th>
						<th>배치 종료시간</th>
						<th>배치 상태</th>
						<th>배치 종료 메세지</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list}" varStatus="i">
						<c:url var="detailUrl" value="selectBtchHist.do">
							<c:forEach var="curParam" items="${param}">
								<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
							</c:forEach>
							<c:param name="jobExecutionId" value="${vo.jobExecutionId}" />
						</c:url>
						<tr>
							<td>
								<c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" />
							</td>
							<td class="alignL"><a href="${detailUrl }"><c:out value="${vo.btchWrkNm }" /></a></td>
							<td class="alignL"><c:out value="${vo.jobName }" /></td>
							<td><fmt:formatDate value="${vo.startTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td><fmt:formatDate value="${vo.endTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>
								<c:choose>
									<c:when test="${ vo.status eq null }">
									-
									</c:when>
									<c:when test = "${ vo.status eq 'ABANDONED' or vo.status eq 'FAILED' or vo.status eq 'UNKNOWN' }">
										<span class="status status-red"><c:out value="${vo.status }"/></span>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${vo.exitMessage eq '' or vo.exitMessage eq null}">
												<span class="status status-green"><c:out value="${vo.status }"/></span>
											</c:when>
											<c:otherwise>
												<span class="status status-red">비정상종료배치</span>
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
							</td>
							<c:choose>
								<c:when test="${vo.exitMessage eq '' or vo.exitMessage eq null }">
									<td>-</td>
								</c:when>
								<c:otherwise>
									<td class="alignL"><c:out value="${vo.exitMessage }" /></td>
								</c:otherwise>
							</c:choose>
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
				<ui:pagination paginationInfo="${searchVo.paginationInfo }"
					type="common" jsFunction="goPage" />
			</ul>
			<!-- /box-footer -->
		</div>
	</div>
</div>

<script type="text/javascript">

	function goToUrl(url) {
		location.href = url;
	}

	function doSearch() {
		//시작시간 비교 및 처리
		var startDate = new Date($('#searchBtchStartTimeStart').val());
		var endDate = new Date($('#searchBtchStartTimeEnd').val());
		var dateCompareMs = endDate.getTime() - startDate.getTime();
		var dateCompareDay = dateCompareMs / (1000*60*60*24);
		//시작시간 차이가 3 이하일때
		if(dateCompareDay < 4){
			$("#searchVo").attr("action", "selectBtchHistList.do");
			$("#searchVo").submit();
		}else{
			jAlert("배치 시작일자 검색은 최대 3일까지 가능합니다.");
			return;
		}
	}

	// 목록의 정보를 Excel로 다운로드 한다.
	function fn_selectBtchHistListXlsDwnl() {
		if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("다운로드 할 데이터가 없습니다.");
			return;
		}else if("${searchVo.paginationInfo.totalRecordCount}" == '65000') {
			jAlert("엑셀 다운로드 항목 수는 최대 65000건까지 가능합니다.");
			return;
		}
		$('#searchVo').attr('target', '_self');
		$('#searchVo').attr('action', '<c:url value="selectBtchHistListXlsDwnl.do"/>');
		$('#searchVo').submit();
	}

	function goPage(page) {
		location.href = "selectBtchHistList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
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
		startDate.setDate(startDate.getDate() - 3);
		$('#searchVo input[type="text"][name="searchBtchStartTimeStart"]').val(startDate.toISOString().substr(0,10).replace('T', ' '));
		$('#searchVo input[type="text"][name="searchBtchStartTimeEnd"]').val(endDate.toISOString().substr(0,10).replace('T', ' '));
	}

	$("#BtchHistTable").DataTable({
		dom : 'Zlfrtip',
		aoColumns : [
		               {sWidth : "30px" },
		               {sWidth : "170px" },
		               {sWidth : "130px" },
		               {sWidth : "100px" },
		               {sWidth : "100px" },
		               {sWidth : "80px" },
		               {sWidth : "70px" }
		],
		order : [ [ 0, "desc" ] ]
	});
</script>
