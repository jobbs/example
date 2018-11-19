<%--
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 9. 22.
 * @lastmodified 2017. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 9. 22.     양정순         v1.0             최초생성
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

<form:form commandName="searchVo" name="frm" id="frm" method="post" action="">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
	<div class="col-box-100 search-col">
		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기"></i>
					</button>
				</div>
			</div>

			<div class="box-body collapse in search-collapse">
				<div class="form-group">
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion name="regionId" id="regionId" title="센터" cssClass="form-control input-sm" byRole="false" value="${searchVo.regionId}" whole="true" />
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>년도</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:select path="year" cssClass="form-control input-sm" title="년도">
									<c:forEach var="yearVo" items="${yearCdList }">
										<form:option value="${yearVo.cd}">
											<c:out value="${yearVo.cdNm }" />
										</form:option>
									</c:forEach>
								</form:select>
							</div>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>월</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:select path="month" cssClass="form-control input-sm" title="월">
									<form:option value="">전체</form:option>
									<form:option value="01">1월</form:option>
									<form:option value="02">2월</form:option>
									<form:option value="03">3월</form:option>
									<form:option value="04">4월</form:option>
									<form:option value="05">5월</form:option>
									<form:option value="06">6월</form:option>
									<form:option value="07">7월</form:option>
									<form:option value="08">8월</form:option>
									<form:option value="09">9월</form:option>
									<form:option value="10">10월</form:option>
									<form:option value="11">11월</form:option>
									<form:option value="12">12월</form:option>
								</form:select>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="box-footer collapse in search-collapse">
				<div class="table-btn pull-left">
					<button type="button" class="btn btn-default" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
				</div>
				<div class="pull-right">
					<button onclick="javascript:fn_search();return false;" class="btn btn-red pull-right">조회</button>
				</div>
			</div>
			<!-- /box-footer -->
		</div>
	</div>
</form:form>
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
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }" />
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
			<table class="table table-hover table-vertical">
				<caption>자원풀별 자동확장 사양 목록</caption>
				<colgroup>
					<col class="col5">
					<col class="colAuto">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
				</colgroup>
				<thead>
					<tr>
						<th rowspan="2">No.</th>
						<th rowspan="2">자원풀</th>
						<th colspan="3">Core</th>
						<th colspan="3">MEM(GB)</th>
						<th colspan="3">스토리지(GB)</th>
					</tr>
					<tr>
						<th>최저</th>
						<th>평균</th>
						<th>최고</th>
						<th>최저</th>
						<th>평균</th>
						<th>최고</th>
						<th>최저</th>
						<th>평균</th>
						<th>최고</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${list eq null or empty list }">
							<c:if test='${searchVo.regionId eq null }'>
								<tr>
									<td colspan="11">조회 버튼을 클릭하시기 바랍니다.</td>
								</tr>
							</c:if>
							<c:if test='${searchVo.regionId ne null }'>
								<tr>
									<td colspan="11">검색된 데이터가 없습니다.</td>
								</tr>
							</c:if>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${list }" varStatus="i">
								<tr>
									<td><c:out value="${vo.no }" /></td>
									<td class="alignL"><c:out value="${vo.rsrcPoolNm }" /></td>
									<td class="alignR"><c:out value="${vo.minCpuCorQty }" /></td>
									<td class="alignR"><c:out value="${vo.avgCpuCorQty }" /></td>
									<td class="alignR"><c:out value="${vo.maxCpuCorQty }" /></td>
									<td class="alignR"><c:out value="${vo.minMemTotCapa }" /></td>
									<td class="alignR"><c:out value="${vo.avgMemTotCapa }" /></td>
									<td class="alignR"><c:out value="${vo.maxMemTotCapa }" /></td>
									<td class="alignR"><c:out value="${vo.minStrgTotCapa }" /></td>
									<td class="alignR"><c:out value="${vo.avgStrgTotCapa }" /></td>
									<td class="alignR"><c:out value="${vo.maxStrgTotCapa }" /></td>
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
		</div>
		<!-- /box-footer -->
	</div>
	<!-- /box -->
</div>
<!-- /col -->

<script type="text/javascript">
	function goPage(page) {
		location.href = "selectAxSpecPerPoolList.do?paginationInfo.currentPageNo="
				+ page + "&${listParam}";
	}

	// 검색조건 초기화
	function fn_reset() {
		//$("#searchVo input[type='text']").val("");
		$("#regionId").val("").attr("selected", "selected");
		$('#year option:eq(0)').attr("selected","selected");
		$("#month").val("").attr("selected", "selected");
	}

	//조회버튼 클릭시.
	function fn_search() {
		$("#frm").attr("target", "_self");
		$("#frm").attr("action", "<c:url value='selectAxSpecPerPoolList.do'/>");
		$("#frm").submit();
		return false;
	}

	function excelDown() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}

		$("#frm").attr("target", "_self");
		$("#frm").attr("action",
				"<c:url value='selectAxSpecPerPoolXlsDown.do'/>");
		$("#frm").submit();
		return false;
	}

	function goToUrl(url) {
		location.href = url;
	}
</script>

