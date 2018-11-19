<%--
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 08. 22.
 * @lastmodified 2017. 08. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 08. 22.     양정순         v1.0             최초생성
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

	searchVo.action='<c:url value="selectAxServcLogList.do" />';
	searchVo.submit();
}

</script>

<div class="col-box-100">
	<form:form commandName="searchVo"  method="get" >
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
		<form:hidden path="jobId" />
		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right"></div>
			</div>

			<div class="box-body collapse in search-collapse">
				<div class="form-group">

					<div class="form-cell form-cell-30 col-lay-30">
						<div class="cell-title">
							<label>업무</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:input type="text" path="jobNm" cssClass="form-control input-sm essential" title="업무" readonly="true" />
								<div class="input-group-btn">
									<button class="btn btn-sm" onclick="openJobeSearch(); return false;">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</div>
					</div>

					<div class="form-cell form-cell-30 col-lay-30">
						<div class="cell-title">
							<label>서비스영역 구성 ID</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:input path="servcAreaCompId" type="text" class="form-control input-sm" title="서비스영역 구성 ID" />
							</div>
						</div>
					</div>

					<div class="form-cell form-cell-40 col-lay-40">
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
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_excelDown();">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>

		</div>
		<!-- /box-header -->
		<div class="box-body no-padding list-body">
			<table class="table table-vertical table-hover table-layout-fixed" id="vmLogTable">
				<caption>자동확장로그 조회</caption>

				<thead>
					<tr>
						<th>No.</th>
						<th>부처명</th>
						<th>업무명</th>
						<th>로그수집 시간</th>
						<th>서비스영역 구성ID</th>
						<th>서비스영역명</th>
						<th>로그 메시지</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="vo" items="${list}" varStatus="ri">
						<tr>
							<td class="alignC"><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-ri.count)+1}" /></td>
							<td class="alignL"><c:out value="${vo.institutionNm }" /></td>
							<td class="alignL"><c:out value="${vo.jobNm }" /></td>
							<td class="alignC"><c:out value="${vo.logColctDttm }" /></td>
							<td class="alignL"><c:out value="${vo.servcAreaCompId }" /></td>
							<td class="alignL"><c:out value="${vo.servcAreaNm }" /></td>
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
    function fn_excelDown(){
    	if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
    		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
    		return;
    	}
    	searchVo.action='<c:url value="selectAxServcLogXlsDown.do" />';
    	searchVo.submit();

    }

	function goPage(page) {
		location.href = '<c:url value="selectAxServcLogList.do"/>?paginationInfo.currentPageNo=' + page + '&${listParam}';
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
	   		{sWidth : "40px" }, //No
	   		{sWidth : "50px" }, //업무명
	   		{sWidth : "60px" }, //로그수집시간
	   		{sWidth : "60px" }, //서비스영역 구성
	   		{sWidth : "50px" }, //서비스 영역명
	   		{sWidth : "140px" }, //로그메시지

	   	],
		order : [],
	});

	//$("#vmLogTable").DataTable( {
	//	"language":{"emptyTable":"dd"}
	//});
</script>

