<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     양정순         v1.0             최초생성
 *
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>


<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<script>
$(document).bind('selectJob',setJob);
function setJob(evt) {

	var job = evt.datas;
	$('#jobId').val(job.jobId);
	$('#jobNm').val(job.jobNm);
}


function fn_search(){
	if(!fn_form_validation("searchVo")){
		return;
	}

	searchVo.action='<c:url value="selectVmLogList.do" />';
	searchVo.submit();
}

</script>

<div class="col-box-100">
	<form:form commandName="searchVo" method="get" onsubmit="fn_search(); return false;">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
		<form:hidden path="jobId" />
		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right"></div>
			</div>

			<div class="box-body collapse in search-collapse">
				<div class="form-group">

					<div class="form-cell form-cell-25 col-lay-25">
						<div class="cell-title">
							<label>부처명/업무</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:input type="text" path="jobNm" cssClass="form-control input-sm essential" title="부처명/업무" readonly="true" />
								<div class="input-group-btn">
									<button class="btn btn-sm" onclick="openJobeSearch(); return false;">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</div>
					</div>

					<div class="form-cell form-cell-25 col-lay-25">
						<div class="cell-title">
							<label>가상서버 구성 ID</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:input path="compId" type="text" class="form-control input-sm" title="가상서버 구성 ID" />
							</div>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-50">
						<div class="cell-title">
							<label>로그수집 시간</label>
						</div>
						<div class="cell-body">
							<div class="input-group-box">
								<div class="input-group-cell" id="divDate">
									<div class="input-group period period-start">
										<form:input path="strtDt" cssClass="form-control input-sm datepicker onlyDate essential" maxlength="" title="시작일자" onchange="initDate(this, 'endDt', 'S')" />
									</div>
									<div class="input-group period period-end">
										<form:input path="endDt" cssClass="form-control input-sm datepicker onlyDate essential" title="종료일자" onchange="initDate(this, 'strtDt', 'E')" />
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="box-footer collapse in search-collapse">
				<div class="table-btn pull-left">
					<button type="reset" class="btn">초기화</button>
				</div>
				<div class="pull-right">
					<button type="submit" class="btn btn-red" onclick="fn_search(); return false;">조회</button>
				</div>
			</div>
			<!-- /box-footer -->
		</div>
	</form:form>
</div>
<!-- /col -->

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">
				검색결과<small> ${searchVo.paginationInfo.currentPageNo } /
					${searchVo.paginationInfo.totalPageCount }, 총 :
					${searchVo.paginationInfo.totalRecordCount } 건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }" />
					<div class="input-group-cell pad-right"></div>
				</div>
			</div>

		</div>
		<!-- /box-header -->
		<div class="box-body no-padding list-body">
			<table class="table table-vertical table-hover table-layout-fixed" id="vmLogTable">
				<caption>가상서버로그 조회</caption>

				<thead>
					<tr>
						<th>No.</th>
						<th>업무명</th>
						<th>로그 수집시간</th>
						<th>가상서버 구성ID</th>
						<th>가상서버명</th>
						<th>호스트명</th>
						<th>가상서버 IP</th>
						<th>로그 메시지</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="vo" items="${list}" varStatus="ri">
						<tr>
							<td class="alignC"><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-ri.count)+1}" /></td>
							<td class="alignC"><c:out value="${vo.jobNm }" /></td>
							<td class="alignC"><c:out value="${vo.eqpLogColctDttm }" /></td>
							<td class="alignL"><c:out value="${vo.vmCompId }" /></td>
							<td class="alignL"><c:out value="${vo.vmNm }" /></td>
							<td class="alignL"><c:out value="${vo.hstNm }" /></td>
							<td class="alignC"><c:out value="${vo.eqpIpAddr }" /></td>
							<td class="alignL"><c:out value="${vo.logMsg }" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
		</div>
		<!-- /box-footer -->


	</div>
	<!-- /box(목록조회 테이블) -->
</div>
<!-- /col -->

<script type="text/javascript">

    /*$(document).ready( function() {
	       $('#vmLogTable').dataTable( {
	         olanguage: {
	           sEmptyTable: "No data available in table"
	         }
	       } );
	     } );
    */
	function goPage(page) {
		location.href = '<c:url value="selectVmLogList.do"/>?paginationInfo.currentPageNo=' + page + '&${listParam}';
	}

	$("#vmLogTable").DataTable( {
		dom: 'Zlfrtip',
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		<c:choose>
          <c:when test="${ list eq null or empty list }">
            <c:choose>
			  <c:when test="${searchVo.jobId eq null or empty searchVo.jobId }">
		         oLanguage:{sEmptyTable:"조회 버튼을 클릭해 주시기 바랍니다."},
		       </c:when>
			   <c:otherwise>
			     oLanguage:{sEmptyTable:"검색된 데이터가 없습니다."},
			   </c:otherwise>
			</c:choose>
		</c:when>
  	 </c:choose>
	    //"language":{"emptyTable":"dd"}
		aoColumns : [
	   		{sWidth : "18px" }, //No
	   		{sWidth : "50px" }, //업무명
	   		{sWidth : "40px" }, //로그수집시간
	   		{sWidth : "40px" }, //가상서버 구성ID
	   		{sWidth : "40px" }, //가상서버명
	   		{sWidth : "25px" }, //호스트명
	   		{sWidth : "50px" }, //가상서버IP
	   		{sWidth : "140px" }, //로그메시지

	   	],
		order : [],
	});

	//$("#vmLogTable").DataTable( {
	//	"language":{"emptyTable":"dd"}
	//});
</script>

