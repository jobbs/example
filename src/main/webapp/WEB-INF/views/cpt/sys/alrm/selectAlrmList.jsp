<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>알림 목록</pre>
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 25.
 * @lastmodified 2016. 10. 25.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 25.     박봉춘         v1.0             최초생성
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
	<form:hidden path="firstSearch" />
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

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchAlrmSbjct">제목</label>
						</div>
						<div class="cell-body">
							<form:input path="searchAlrmSbjct" cssClass="form-control input-sm" title="제목"/>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchStatCd">상태</label>
						</div>
						<div class="cell-body">
							<form:select path="searchStatCd" cssClass="form-control input-sm" title="상태">
								<form:option value="">전체</form:option>
								<form:option value="I">정보</form:option>
								<form:option value="E">오류(장애)</form:option>
							</form:select>
						</div>
					</div>
					<div class="form-cell form-cell-75 col-lay-50">
						<div class="cell-title"><label for="searchStartDate">등록일자</label></div>
						<div class="cell-body">
							<div class="input-group period period-start">
								<form:input path="searchStartDate" cssClass="form-control input-sm datepicker" onchange="initDate(this, 'searchEndDate', 'S')" title="등록시작일자"/>
							</div>
							<div class="input-group period period-end">
								<form:input path="searchEndDate" cssClass="form-control input-sm datepicker" onchange="initDate(this, 'searchStartDate', 'E')" title="등록종료일자"/>
							</div>
						</div>
					</div>
				</div>

			</div>

			<!-- box-footer -->
			<div class="box-footer collapse in search-collapse">
				<div class="pull-left">
		   			<button type="button" class="btn" onclick="initializeForm()">초기화</button>
		 		</div>
				<div class="pull-right">
					<button type="button" class="btn btn-red pull-right" onclick="fn_selectAlrmList()">조회</button>
				</div>
			</div>

		</div>
	</form:form>
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
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_selectAlrmListXlsDwnl()"><i class="fa fa-download"></i></button>
					</div>
    			</div>
   			</div>
		</div>

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table id="alrmTable" class="table table-hover table-vertical table-layout-fixed">
				<caption>알림 목록 테이블</caption>
				<thead>
					<tr>
						<th>No.</th>
						<th>제목</th>
						<th>상태</th>
						<th>담당자</th>
						<th>등록일시</th>
						<th>확인일시</th>
						<th>이동</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="alrmVo" items="${list }" varStatus="i">
						<tr>
							<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
							<td class="alignL"><c:out value="${alrmVo.alrmSbjct}" /></td>
							<td>
								<c:choose>
									<c:when test="${alrmVo.statCd eq 'I' }" >
										<span class="status status-green">정보</span>
									</c:when>
									<c:when test="${alrmVo.statCd eq 'E' }" >
										<span class="status status-red">오류(장애)</span>
									</c:when>
									<c:otherwise>
										<span class="status status-gray">상태미설정</span>

									</c:otherwise>
								</c:choose>
							</td>
							<td><c:out value="${alrmVo.chargerNm}"/></td>
							<td><fmt:formatDate value="${alrmVo.regDttm }" pattern="YYYY-MM-dd"/></td>
							<td><fmt:formatDate value="${alrmVo.confrmDttm }" pattern="YYYY-MM-dd" /></td>
							<td >
								<button class="btn btn-sm btn-blue" onclick="goToUrl('<c:out value="${alrmVo.trgtUrl }" />')">이동</button>
							</td>
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
					<c:if test="${curParam.key ne 'alrmVo.alrmSeq'}">
						<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
					</c:if>
				</c:forEach>
			</c:url>

		</div>

	</div>

</div>

<script type="text/javascript">

	function fn_selectAlrmList() {
		$("#searchVo").attr("action", "selectAlrmList.do");
		$("#searchVo").submit();
	}

	function goPage(page) {
		location.href = "selectAlrmList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
	}

	// 목록의 정보를 Excel로 다운로드 한다.
	function fn_selectAlrmListXlsDwnl() {
		if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("다운로드 할 데이터가 없습니다.");
			return;
		}
		$('#searchVo').attr('target', '_self');
		$('#searchVo').attr('action', '<c:url value="selectAlrmListXlsDwnl.do"/>');
		$('#searchVo').submit();
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
		startDate.setDate(startDate.getDate() - 1);
		$('#searchVo input[type="text"][name="searchStartDate"]').val(startDate.toISOString().substr(0,10).replace('T', ' '));
		$('#searchVo input[type="text"][name="searchEndDate"]').val(endDate.toISOString().substr(0,10).replace('T', ' '));
	}

	$("#alrmTable").DataTable({
		dom : 'Zlfrtip',
		paging : false,
		searching : false,
		info : false,
		aoColumns : [
		               {sWidth : "50px" },
		               {sWidth : "190px" },
		               {sWidth : "100px" },
		               {sWidth : "100px" },
		               {sWidth : "120px" },
		               {sWidth : "120px" },
		               {sWidth : "60px" }
		],
		order : [ [ 0, "desc" ] ]
	});
</script>

