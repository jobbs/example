<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>
 	부처관리 목록 조회
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


<script type="text/javascript"
	src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>

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

					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchInttId">부처ID</label>
						</div>
						<div class="cell-body">
							<form:input path="searchInttId" cssClass="form-control input-sm" title="기관ID" />
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchInttNm">부처</label>
						</div>
						<div class="cell-body">
							<form:input path="searchInttNm" cssClass="form-control input-sm" title="부처" />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchUseYn">사용여부</label>
						</div>
						<div class="cell-body">
							<form:select path="searchUseYn" cssClass="form-control input-sm" title="사용여부">
								<form:option value="">전체</form:option>
								<form:option value="Y">사용</form:option>
								<form:option value="N">미사용</form:option>
							</form:select>
						</div>
					</div>

				</div>

			</div>

			<!-- box-footer -->
			<div class="box-footer collapse in search-collapse">
				<div class="pull-left">
		   			<button type="button" class="btn" onclick="formReset('searchVo')">초기화</button>
		 		</div>
				<div class="pull-right">
					<button type="button" class="btn btn-red pull-right" onclick="fn_selectInsttList()">조회</button>
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
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_selectInsttListXlsDwnl()"><i class="fa fa-download"></i></button>
					</div>
    			</div>
   			</div>
		</div>

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table id="insttTable" class="table table-hover table-vertical table-layout-fixed">
				<caption>부처 목록 테이블</caption>
				<thead>
					<tr>
						<th>No.</th>
						<th>부처ID</th>
						<th>부처</th>
						<th>사용여부</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="insttVo" items="${list }" varStatus="i">
						<c:url var="detailUrl" value="selectInstt.do">
							<c:forEach var="curParam" items="${param }">
								<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
							</c:forEach>
							<c:param name="institutionId" value="${insttVo.institutionId }" />
						</c:url>
						<tr>
							<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
							<td><c:out value="${insttVo.institutionId }" /></td>
							<td class="alignL"><c:out value="${cf:ellipsis(insttVo.institutionNm, 60) }" /></td><%--<a href="<c:url value="${detailUrl }" />" title="<c:out value="${insttVo.institutionNm}"/>"> --%>
							<td>
								<c:choose>
									<c:when test="${insttVo.useYn ne null && insttVo.useYn eq 'Y'}">
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
			<c:url var="listUrl" value="selectInsttList.do">
				<c:forEach var="curParam" items="${param }">
					<c:if test="${curParam.key ne 'institutionId'}">
						<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
					</c:if>
				</c:forEach>
			</c:url>
		</div>
	</div>
</div>

<script type="text/javascript">
	function fn_selectInsttList() {
		$("#searchVo").attr("action", "selectInsttList.do");
		$("#searchVo").submit();
	}

	function goPage(page) {
		location.href = "selectInsttList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
	}

	// 목록의 정보를 Excel로 다운로드 한다.
	function fn_selectInsttListXlsDwnl() {
		if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("다운로드 할 데이터가 없습니다.");
			return;
		}
		$('#searchVo').attr('target', '_self');
		$('#searchVo').attr('action', '<c:url value="selectInsttListXlsDwnl.do"/>');
		$('#searchVo').submit();
	}

	$("#insttTable").DataTable({
		dom : 'Zlfrtip',
		aoColumns : [
              {sWidth : "80px" },
              {sWidth : "130px" },
              {sWidth : "300px" },
              {sWidth : "100px" }
		],
		order : [ [ 0, "desc" ] ]
	});
</script>
