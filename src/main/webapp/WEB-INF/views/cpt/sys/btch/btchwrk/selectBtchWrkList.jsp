<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     박봉춘         v1.0             최초생성
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

<c:set var="listParam"
	value="${cf:queryString(param, 'paginationInfo.currentPageNo')}"></c:set>

<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
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
						<label for="searchBtchWrkNm">배치작업명</label>
					</div>
					<div class="cell-body">
						<form:input path="searchBtchWrkNm" cssClass="form-control input-sm pull-right" title="배치작업명" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchBtchWrkId">배치JOBID</label>
					</div>
					<div class="cell-body">
						<form:input path="searchBtchWrkId" cssClass="form-control input-sm pull-right" title="배치JOBID" />
					</div>
				</div>

				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchJobStatus">상태</label>
					</div>
					<div class="cell-body">
						<form:select path="searchJobStatus" cssClass="form-control input-sm" title="상태">
							<form:option value="">전체</form:option>
							<form:option value="S">작업중</form:option>
							<form:option value="E">대기상태</form:option>
						</form:select>
					</div>
				</div>

				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchJobStatusLast">최종작업상태</label>
					</div>
					<div class="cell-body">
						<form:select path="searchJobStatusLast" cssClass="form-control input-sm" title="최종작업상태">
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

				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchStat">사용여부</label>
					</div>
					<div class="cell-body">
						<form:select path="searchStat" cssClass="form-control input-sm" title="사용여부" >
							<form:option value="">전체</form:option>
							<form:option value="Y">사용</form:option>
							<form:option value="N">미사용</form:option>
						</form:select>
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchCycle">주기</label>
						</div>
						<div class="cell-body">
							<nform:selectCode
						       parentCd="btchcycle"
						       parentGrpCd="060"
						       name="searchCycle"
						       id="searchCycle"
						       whole="true"
						       value="${searchVo.searchCycle}"
						       cssClass="form-control input-sm"
						       title="주기"/>
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
    				<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/>
    				<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_selectBtchWrkListXlsDwnl()"><i class="fa fa-download"></i></button>
					</div>
    			</div>
   			</div>
		</div>
		<!-- /box-header -->

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical table-layout-fixed" id="BtchWrkTable">
				<caption>배치 목록 조회 테이블</caption>
				<thead>
					<tr>
						<th>No.</th>
						<th>배치작업명</th>
						<th>배치JOBID</th>
						<th>주기/시점</th>
						<th>상태</th>
						<th>최종작업일시</th>
						<th>최종작업상태</th>
						<th>사용여부</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list}" varStatus="i">
						<c:url var="detailUrl" value="selectBtchWrk.do">
							<c:forEach var="curParam" items="${param}">
								<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
							</c:forEach>
							<c:param name="btchWrkSeq" value="${vo.btchWrkSeq}" />
						</c:url>

						<tr>
							<td>
								<c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" />
							</td>
							<td class="alignL"><a href="${detailUrl }"><c:out value="${vo.btchWrkNm }" /></a></td>
							<td class="alignL"><a href="${detailUrl }"><c:out value="${vo.btchWrkId }" /></a></td>
							<td class="alignL">
								<c:choose>
								<c:when test="${vo.timeType eq 'C' and vo.cycle eq 'write'}">
									(주기) <c:out value="${vo.cycleDirectWrite}" />
								</c:when>
								<c:when test="${vo.timeType eq 'C' and vo.cycle ne 'write' and vo.cycle ne null}">
									(주기) <c:out value="${vo.cycleNm}" />
								</c:when>
								<c:when test="${vo.timeType eq 'E'}">
									(시점)
									<c:if test="${vo.exeTimeMonth ne ''}">
										<fmt:formatNumber value="${vo.exeTimeMonth}" pattern="00"/>월
									</c:if>
									<c:if test="${vo.exeTimeDay ne '' }">
										<fmt:formatNumber value="${vo.exeTimeDay}" pattern="00"/>일
									</c:if>
									<c:if test="${vo.exeTimeHour ne ''}">
										<fmt:formatNumber value="${vo.exeTimeHour}" pattern="00"/>시
									</c:if>
									<fmt:formatNumber value="${vo.exeTimeMinute}" pattern="00"/>분
								</c:when>
								<c:otherwise>
									(주기) 주기 미설정
								</c:otherwise>
							</c:choose>
							</td>
							<td>
								<c:choose>
									<c:when test = "${ vo.lastStat eq 'STARTING' or vo.lastStat eq 'STARTED' }">
										<span class="status status-red">작업중</span>
									</c:when>
									<c:otherwise>
										<span class="status status-green">대기상태</span>
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<c:choose>
									<c:when test="${ vo.strtDttm eq null }">
									-
									</c:when>
									<c:otherwise>
										<fmt:formatDate value="${vo.strtDttm }" pattern="yyyy-MM-dd HH:mm:ss"/>
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<c:choose>
									<c:when test="${ vo.lastStat eq null }">
									-
									</c:when>
									<c:when test = "${ vo.lastStat eq 'ABANDONED' or vo.lastStat eq 'FAILED' or vo.lastStat eq 'UNKNOWN' }">
										<span class="status status-red"><c:out value="${vo.lastStat }"/></span>
									</c:when>
									<c:otherwise>
										<span class="status status-green"><c:out value="${vo.lastStat }"/></span>
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<c:choose>
									<c:when test = "${vo.stat eq 'Y' }">
										<span class="status status-green">사용</span>
									</c:when>
									<c:otherwise>
										<span class="status status-gray">미사용</span>
									</c:otherwise>
								</c:choose>
							</td>
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
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertBtchWrk.do">
						<c:forEach var="curParam" items="${param }">
							<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
						</c:forEach>
					</c:url>
					<button class="btn btn-hover-blue" data-toggle="tooltip"
						data-original-title="추가" onclick="goToUrl('${insertUrl}')">
						<i class="fa fa-plus"></i>
					</button>
				</menu:authorize>
			</div>
			<!-- /box-footer -->
		</div>
	</div>
</div>

<script type="text/javascript">
	function goToUrl(url) {
		location.href = url;
	}

	function doSearch() {
		$("#searchVo").attr("action", "selectBtchWrkList.do");
		$("#searchVo").submit();
	}

	// 목록의 정보를 Excel로 다운로드 한다.
	function fn_selectBtchWrkListXlsDwnl() {
		if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("다운로드 할 데이터가 없습니다.");
			return;
		}
		$('#searchVo').attr('target', '_self');
		$('#searchVo').attr('action', '<c:url value="selectBtchWrkListXlsDwnl.do"/>');
		$('#searchVo').submit();
	}

	function goPage(page) {
		location.href = "selectBtchWrkList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
	}

	$("#BtchWrkTable").DataTable({
		dom : 'Zlfrtip',
		aoColumns : [
		               {sWidth : "50px" },
		               {sWidth : "200px" },
		               {sWidth : "200px" },
		               {sWidth : "120px" },
		               {sWidth : "67px" },
		               {sWidth : "130px" },
		               {sWidth : "92px" },
		               {sWidth : "50px" }
		],
		order : [ [ 0, "desc" ] ]
	});
</script>
