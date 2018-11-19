<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>
 	부처업무관리 목록 조회
 </pre>
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 6.
 * @lastmodified 2016. 10. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 6.     최경철         v1.0             최초생성
 *
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>


<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<!-- 검색조건 영역 -->
<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
		<div class="box box-search">

			<!-- box-header -->
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<!-- 접기 버튼 -->
					<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
					</button>
				</div>
			</div>

			<!-- box-body -->
			<div class="box-body collapse in search-collapse">

				<div class="form-group">

					<div class="form-cell form-cell-25 col-lay-25">
						<div class="cell-title">
							<label for="searchRegionId">센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion
									name="searchRegionId"
									value="${searchVo.searchRegionId }"
									cssClass="form-control input-sm"
									title="센터"/>
						</div>
					</div>

					<div class="form-cell form-cell-25 col-lay-25">
						<div class="cell-title">
							<label for="searchInttNm">부처</label>
						</div>
						<div class="cell-body">
							<form:input path="searchInttNm" cssClass="form-control input-sm" title="부처"/>
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchInttId">부처 ID</label>
						</div>
						<div class="cell-body">
							<form:input path="searchInttId" cssClass="form-control input-sm" title="부처ID"/>
						</div>
					</div>

					<div class="form-cell form-cell-25 col-lay-25">
						<div class="cell-title">
							<label for="searchJobNm">업무</label>
						</div>
						<div class="cell-body">
							<form:input path="searchJobNm" cssClass="form-control input-sm" title="업무"/>
						</div>
					</div>
					<div class="form-cell form-cell-25 col-lay-25">
						<div class="cell-title">
							<label for="searchJobId">업무 ID</label>
						</div>
						<div class="cell-body">
							<form:input path="searchJobId" cssClass="form-control input-sm" title="업무ID"/>
						</div>
					</div>

					<div class="input-group input-group-check">
						<form:checkbox path="searchVmAsgnYn" id="searchVmAsgnYn" value="Y" />
						<label for="searchVmAsgnYn"><c:out value="가상서버할당여부"/></label>
					</div>

					<div class="input-group input-group-check">
						<form:checkbox path="searchAtmsclAsgnYn" id="searchAtmsclAsgnYn" value="Y" />
						<label for="searchAtmsclAsgnYn"><c:out value="자동확장할당여부"/></label>
					</div>


				</div>

			</div>

			<!-- box-footer -->
			<div class="box-footer collapse in search-collapse">
				<div class="pull-left">
		   			<button type="button" class="btn" onclick="formReset('searchVo')">초기화</button>
		 		</div>
				<div class="pull-right">
					<button type="button" class="btn btn-red pull-right" onclick="fn_selectJobList()">조회</button>
				</div>
			</div>

		</div>
	</form:form>
</div>
<div class="col-box-100">
	<div class="info">
		<h2>알려드립니다.</h2>
		<p>- 해당정보는 nTOPS와 연계된 정보입니다.</p>
	</div>
</div>
<!-- 그리드 영역 -->
<div class="col-box-100 search-col">

	<div class="box list-box">

		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">검색결과<small> ${searchVo.paginationInfo.currentPageNo } / ${searchVo.paginationInfo.totalPageCount }, 총 ${searchVo.paginationInfo.totalRecordCount }건	 </small></h3>

  			<div class="box-tools">
  				<div class="input-group-box">
    				<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/>
    				<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_selectJobListXlsDwnl()"><i class="fa fa-download"></i></button>
					</div>
    			</div>
   			</div>

		</div>

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table id="jobTable" class="table table-hover table-vertical table-layout-fixed">
				<caption>부처업무 목록 테이블</caption>
				<thead>
					<tr>
						<th>No.</th>
						<th>센터</th>
						<th>부처</th>
						<th>부처ID</th>
						<th>업무</th>
						<th>업무ID</th>
						<th>VM수</th>
						<th>클라우드업무여부</th>
						<th>가상서버할당여부</th>
						<th>자동확장할당여부</th>
						<th>사용여부</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="jobVo" items="${list }" varStatus="i">
						<c:url var="detailUrl" value="selectJob.do">
							<c:forEach var="curParam" items="${param }">
								<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
							</c:forEach>
							<c:param name="jobId" value="${jobVo.jobId }" />
						</c:url>
						<tr>
							<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
							<td><c:out value="${jobVo.regionNm }" /></td>
							<td class="alignL"><c:out value="${jobVo.institution.institutionNm }" /></td>
							<td class="alignL"><c:out value="${jobVo.institution.institutionId }" /></td>
							<td class="alignL"><c:out value="${jobVo.jobNm }" /></td>
							<td class="alignL"><c:out value="${jobVo.jobId }" /></td><%--<a href="<c:url value="${detailUrl }" />" title ="<c:out value="${jobVo.jobNm }" />"> --%>
							<td class="alignR"><c:out value="${jobVo.vmCnt }" /></td>
							<td>
								<c:choose>
									<c:when	test="${jobVo.cludJob ne null && jobVo.cludJob eq 'Y'}">
										<c:out value="클라우드업무" />
									</c:when>
									<c:otherwise>
										<c:out value="클라우드비업무" />
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<c:choose>
									<c:when	test="${jobVo.vmAsgnYn ne null && jobVo.vmAsgnYn eq 'Y'}">
										<c:out value="할당" />
									</c:when>
									<c:otherwise>
										<c:out value="미할당" />
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<c:choose>
									<c:when	test="${jobVo.atmsclAsgnYn ne null && jobVo.atmsclAsgnYn eq 'Y'}">
										<c:out value="할당" />
									</c:when>
									<c:otherwise>
										<c:out value="미할당" />
									</c:otherwise>
								</c:choose>
							</td>
							<td><c:choose>
									<c:when	test="${jobVo.useYn ne null && jobVo.useYn eq 'Y'}">
										<span class="status status-green">사용</span>
									</c:when>
									<c:otherwise>
										<span class="status status-red">미사용</span>
									</c:otherwise>
								</c:choose></td>
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
			<c:url var="listUrl" value="selectJobList.do">
				<c:forEach var="curParam" items="${param }">
					<c:if test="${curParam.key ne 'jobId'}">
						<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
					</c:if>
				</c:forEach>
			</c:url>

		</div>

	</div>

</div>

<script type="text/javascript">

	function fn_selectJobList() {
		$("#searchVo").attr("action", "selectJobList.do");
		$("#searchVo").submit();
	}

	function goPage(page) {
		location.href = "selectJobList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
	}

	// 목록의 정보를 Excel로 다운로드 한다.
	function fn_selectJobListXlsDwnl() {
		if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("다운로드 할 데이터가 없습니다.");
			return;
		}
		$('#searchVo').attr('target', '_self');
		$('#searchVo').attr('action', '<c:url value="selectJobListXlsDwnl.do"/>');
		$('#searchVo').submit();
	}

	$("#jobTable").DataTable({
		dom : 'Zlfrtip',
		paging : false,
		searching : false,
		info : false,
		aoColumns : [
	      {sWidth : "60px" },
              {sWidth : "70px" },
              {sWidth : "130px" },
              {sWidth : "80px" },
              {sWidth : "180px" },
             
              {sWidth : "80px" },
              {sWidth : "100px" },
              {sWidth : "90px" },
              {sWidth : "90px" },
	      {sWidth : "90px" },
	     
	      {sWidth : "80px" }
		],
		order : [ [ 0, "desc" ] ]
	});
</script>

