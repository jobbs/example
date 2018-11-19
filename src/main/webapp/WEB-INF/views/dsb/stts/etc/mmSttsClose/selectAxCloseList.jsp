<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자동확장 마감 화면</pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 10. 13.
 * @lastmodified 2017. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 10. 13.     양정순         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">
				검색결과<small> ${searchVo.paginationInfo.currentPageNo } /
					${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage
						formId="searchVo"
						value="${searchVo }" />
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="excelDown();">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /box-header -->

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical" id="noticeTable">
				<caption>POD 마감 조회</caption>
				<colgroup>
					<col class="colAuto">
					<col class="col8">
					<col class="col7">
					<col class="col9">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
				</colgroup>
				<thead>
					<tr>
						<th>일자</th>
						<th>센터</th>
						<th>존</th>
						<th>망구분</th>
						<th>자원풀</th>
						<th>서비스명</th>
						<th>PODID</th>
						<th>cpu사용율(%)</th>
						<th>코어 개수</th>
						<th>스토리지 총용량(Gbyte)</th>
						<th>메모리 총용량(Gbyte)</th>
				</thead>

				<tbody>
					<c:choose>
						<c:when test="${list eq null or empty list }">
							<tr>
								<td colspan="11">검색된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${list }" varStatus="i">
								<tr>
									<td class="alignC"><c:out value="${vo.colctDt }" /></td>
									<td class="alignC"><c:out value="${vo.regionNm }" /></td>
									<td class="alignC"><c:out value="${vo.zoneNm }" /></td>
									<td class="alignC"><c:out value="${vo.netNm }" /></td>
									<td class="alignC"><c:out value="${vo.rsrcPoolNm }" /></td>
									<td class="alignC"><c:out value="${vo.servcNm }" /></td>
									<td class="alignL"><c:out value="${vo.podId }" /></td>
									<td class="alignR"><c:out value="${vo.avgCpuUseRt }" /></td>
									<td class="alignR"><c:out value="${vo.cpuCorQty }" /></td>
									<td class="alignR"><c:out value="${vo.strgTotCapa }" /></td>
									<td class="alignR"><c:out value="${vo.memTotCapa }" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
			<div class="pull-left btns">
				<c:url var="preUrl" value="selectMmSttsCloseList.do">
					<c:forEach var="curParam" items="${param }">
						<c:if test="${curParam.key ne 'pmId' and curParam.key ne 'paginationInfo.currentPageNo' and curParam.key ne 'pmSeq'}">
							<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
						</c:if>
					</c:forEach>
					<c:param name="paginationInfo.currentPageNo" value="${searchVo.prvPageNo }" />
				</c:url>
				<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${preUrl}')">
					<i class="fa fa-arrow-left"></i>
				</button>
			</div>
		</div>
		<!-- /box-footer -->
	</div>
</div>

<script type="text/javascript">
	function excelDown() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}

		<c:url var="excelDownUrl" value="selectAxCloseXlsDown.do">
		<c:forEach var="curParam" items="${param }">
			<c:if test="${curParam.key ne 'prvPageNo'}">
			<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
			</c:if>
		</c:forEach>
		</c:url>

		location.href = '<c:url value="${excelDownUrl }" />';
	}

	function goPage(page) {
		location.href = "selectAxCloseList.do?paginationInfo.currentPageNo="
				+ page + "&${listParam}";
	}

	function goToUrl(url) {
		location.href = url;
	}

	function changeRecordCntPerPage(formId) {
		console.log($("#tmpCntPerPage").val());
		location.href = "selectAxCloseList.do?paginationInfo.recordCountPerPage="
				+ $("#tmpCntPerPage").val() + "&${listParam}";
	}
	/*
	 $("#noticeTable").DataTable( {
	 dom: 'Zlfrtip',
	 paging : false,
	 searching : false,
	 info : false,
	 order : [[0, "desc"]]
	 } );*/
</script>