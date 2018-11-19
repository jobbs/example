<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 07.
 * @lastmodified 2016. 10. 07.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 07.     박봉춘         v1.0             최초생성
 *
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get">
		<form:hidden path="paginationInfo.recordCountPerPage"
			id="recordCountPerPage" />
		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<!-- 접기 버튼 -->
					<button type="button" class="btn btn-sm" data-toggle="collapse"	data-target=".search-collapse">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
					</button>
				</div>
			</div>

			<div class="box-body collapse in search-collapse">
				<div class="form-group">

					<div class="form-cell form-cell-50 col-lay-50">
						<div class="cell-title">
							<label for="searchSbjct">제목</label>
						</div>
						<div class="cell-body">
							<form:input path="searchSbjct" cssClass="form-control input-sm pull-right" title="제목"/>
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-50">
						<div class="cell-title">
							<label for="searchContent">내용</label>
						</div>
						<div class="cell-body">
							<form:input path="searchContent" cssClass="form-control input-sm pull-right" title="내용" />
						</div>
					</div>
				</div>
			</div>
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
	</form:form>
</div>

<div class="col-box-100 search-col">
	<div class="box list-box">

		<div class="box-header">
			<h3 class="box-title">
				검색결과<small> ${searchVo.paginationInfo.currentPageNo } / ${searchVo.paginationInfo.totalPageCount }, 총 ${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo"	value="${searchVo }" />
				</div>
			</div>
		</div>
		<!-- /box-header -->

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical table-layout-fixed" id="qnaTable">
				<caption>Q&amp;A목록 테이블</caption>
				<thead>
					<tr>
						<th>No.</th>
						<th>제목</th>
						<th>답변여부</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>조회수</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="vo" items="${list }" varStatus="i">
						<c:url var="detailUrl" value="selectBoard.do">
							<c:forEach var="curParam" items="${param }">
								<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
							</c:forEach>
							<c:param name="boardSeq" value="${vo.boardSeq }" />
						</c:url>

						<tr>
							<td><c:out
									value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
							<td class="alignL ellipsis"><a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.sbjct}"/>"><c:out value="${vo.sbjct }" /></a></td>

							<c:choose>
								<c:when test="${vo.answerCnt > 0 }">
									<td><span class="status status-green">답변 완료</span></td>
								</c:when>
								<c:otherwise>
									<td><span class="status status-red">답변 없음</span></td>
								</c:otherwise>
							</c:choose>

							<td><c:out value="${vo.regNm }" /></td>
							<td><fmt:formatDate value="${vo.regDt }" pattern="yyyy-MM-dd" /></td>
							<td class="alignR"><fmt:formatNumber value="${vo.hitCnt }" pattern="#,###" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertBoard.do">
						<c:forEach var="curParam" items="${param }">
							<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
						</c:forEach>
					</c:url>
					<button class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가" onclick="goToUrl('${insertUrl}')">
						<i class="fa fa-plus"></i>
					</button>
				</menu:authorize>
			</div>
		</div>
		<!-- /box-footer -->
	</div>
</div>

<script type="text/javascript">
	function goPage(page) {
		location.href = "selectBoardList.do?paginationInfo.currentPageNo="
				+ page + "&${listParam}";
	}

	function goToUrl(url) {
		location.href = url;
	}

	function doSearch() {
		$("#searchVo").attr("method", "selectBoardList.do");
		$("#searchVo").submit();
	}

	$("#qnaTable").DataTable({
		dom : 'Zlfrtip',
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [
		               {sWidth : "60px" },
		               {sWidth : "300px" },
		               {sWidth : "80px" },
		               {sWidth : "80px" },
		               {sWidth : "100px" },
		               {sWidth : "60px" }
		],
		order : [ [ 0, "desc" ] ]
	});
</script>