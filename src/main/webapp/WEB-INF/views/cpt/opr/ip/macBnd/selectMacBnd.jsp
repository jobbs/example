<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     송승규         v1.0             최초생성
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

<c:set var="listParam" value="${cf:queryStringMulti(param, 'paginationInfo.currentPageNo,asgnYn,vmCompId', ',') }"></c:set>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">기본정보</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon" id="tmplatData">
				<caption>템플릿 기본정보</caption>
				<colgroup>
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
				</colgroup>
				<tbody>
					<tr>
						<th>센터</th>
						<td><c:out value="${macBnd.regionNm }"/></td>
						<th>존</th>
						<td><c:out value="${macBnd.zoneNm }"/></td>
						<th>망구분(망)</th>
						<td><c:out value="${macBnd.netClCdNm }"/>(<c:out value="${macBnd.netNm }"/>)</td>
						<th>자원풀</th>
						<td><c:out value="${macBnd.rsrcPoolNm }"/></td>
					</tr>
					<tr>
						<th>MAC대역명</th>
						<td><c:out value="${macBnd.macBndNm }"/></td>
						<th>MAC시작주소</th>
						<td><c:out value="${macBnd.macStrtAddr }"/></td>
						<th>MAC종료주소</th>
						<td><c:out value="${macBnd.macEndAddr }"/></td>
						<th>할당</th>
						<td><c:out value="${macBnd.asgnCnt }"/></td>
					</tr>
					<tr>
						<th>설명</th>
						<td colspan="7"><c:out value="${macBnd.dc }"/></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<div class="col-box-100 search-col">
	<form:form id="searchVo" commandName="searchVo" method="GET">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
	<form:hidden path="macBndSeq" value="${param.macBndSeq }" />
	<form:hidden path="regionId" value="${param.regionId }" />
	<form:hidden path="zoneId" value="${param.zoneId }" />
	<form:hidden path="netId" value="${param.netId }" />
	<form:hidden path="poolId" value="${param.poolId }" />
	<form:hidden path="macBndNm" value="${param.macBndNm }" />
	<form:hidden path="macAddr" value="${param.macAddr }" />
		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
			</div>
			<div class="box-body">
				<div class="form-group">
					<div class="form-cell form-cell-50 col-lay-33">
						<div class="cell-title">
							<label for="asgnYn">할당여부</label>
						</div>
						<div class="cell-body">
							<form:select path="asgnYn" cssClass="form-control input-sm" title="할당여부">
								<form:option value="">전체</form:option>
				              	<form:option value="Y">할당</form:option>
				              	<form:option value="N">미할당</form:option>
							</form:select>
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-33">
						<div class="cell-title">
							<label for="vmCompId">가상서버명</label>
						</div>
						<div class="cell-body">
							<form:input type="text" path="vmNm" class="form-control input-sm pull-right" title="가상서버명"/>
						</div>
					</div>
				</div>
			</div>
			<div class="box-footer">
				<div class="pull-left">
					<button type="button" class="btn" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
				</div>
				<div class="pull-right">
					<button type="button" class="btn btn-red" onclick="fn_selectMacBndDetail();" title="조회">조회</button>
				</div>
			</div>
		</div>
	</form:form>
</div>
<div class="col-box-100 search-col">
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">검색결과<small>
				${searchVo.paginationInfo.currentPageNo } /
				${searchVo.paginationInfo.totalPageCount },
				총 ${searchVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<%-- <nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/> --%>
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_downloadExcel();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding detail-list-body">
			<table class="table table-hover table-vertical table-layout-fixed" id="macAsgnYnTable">
				<caption>MAC주소 할당/미할당 목록 테이블</caption>
				<thead>
					<tr>
						<th>할당여부</th>
						<th>MAC 주소</th>
						<th>부처명</th>
						<th>업무명</th>
						<th>자원풀명</th>
						<th>가상서버명</th>
						<th>가상서버구성ID</th>
						<th>인터페이스명</th>
						<th>할당일자</th>
					</tr>
				</thead>
				<tbody>
				<c:choose>
					<c:when test="${list eq null or empty list }">
					</c:when>
					<c:otherwise>
						<c:forEach var="macBndIntfcAsgnVo" items="${list }">
							<tr>
								<td>
								<c:choose>
									<c:when test="${macBndIntfcAsgnVo.asgnYn eq 'Y'}">
										<span class="status status-green">할당</span>
									</c:when>
									<c:when test="${macBndIntfcAsgnVo.asgnYn eq 'N'}">
										<span class="status status-gray">미할당</span>
									</c:when>
								</c:choose>
								</td>
								<td><c:out value="${macBndIntfcAsgnVo.macAddr }"/></td>
								<td class="alignL"><c:out value="${macBndIntfcAsgnVo.institutionNm }"/></td>
								<td class="alignL"><c:out value="${macBndIntfcAsgnVo.vmJob }"/></td>
								<td class="alignL"><c:out value="${macBndIntfcAsgnVo.rsrcPoolNm }"/></td>
								<td class="alignL"><c:out value="${macBndIntfcAsgnVo.vmNm }"/></td>
								<td class="alignL"><c:out value="${macBndIntfcAsgnVo.vmCompId }"/></td>
								<td class="alignL"><c:out value="${macBndIntfcAsgnVo.netwkIntfcNm }"/></td>
								<td><fmt:formatDate value="${macBndIntfcAsgnVo.asgnDt }" pattern="yyyy-MM-dd" /></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
		</div>
		<div class="box-footer edit-btn-group ">
			<div class="pull-left btns">
				<button class="btn btn-hover-gray" data-toggle="tooltip" data-original-title="뒤로" onclick="fn_selectMacBndList();"><i class="fa fa-arrow-left"></i></button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		fnLayoutConf200();
	});

	function fn_reset(){

		$("#searchVo input[type='text']").val("");
		$("#searchVo select").val("").attr("selected", "selected");
	}

	function fn_selectMacBndList(){

		location.href = '<c:url value="selectMacBndList.do"><c:forEach var="curParam" items="${param}"><c:if test="${curParam.key ne 'macBndSeq' and curParam.key ne 'asgnYn' and curParam.key ne 'vmCompId'}"><c:param name="${curParam.key}" value="${curParam.value}" /></c:if></c:forEach></c:url>';
	}

	// 페이징 이동
	function fn_goPage(page){
		location.href = "<c:url value='selectMacBnd.do?paginationInfo.currentPageNo=" + page + "&${listParam}'/>";
	}


	// 엑셀다운로드
	function fn_downloadExcel() {

		var cnt = 0;

		$.each($('#macAsgnYnTable > tbody > tr'), function(){
			cnt++;
		});

		if(cnt == 0) {
			jAlert("다운로드할 데이터가 없습니다");
			return;
		}

		$("#searchVo").attr("action", "selectMacBndDetailXlsDwnl.do");
		$("#searchVo").submit();
	}

	// 조회
	function fn_selectMacBndDetail(){

		$("#searchVo").attr("action", "selectMacBnd.do");
		$("#searchVo").submit();
	}

	$("#macAsgnYnTable").DataTable( {
		dom: 'Zlfrtip' ,
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		scrollY: "300px",
		scrollCollapse: true,
		scrollX: true,
		aoColumns : [
					{sWidth : "50px" },
					{sWidth : "110px" },
					{sWidth : "80px" },
					{sWidth : "80px" },
					{sWidth : "81px" },
					{sWidth : "80px" },
					{sWidth : "85px" },
					{sWidth : "75px" },
					{sWidth : "80px" }
					],
		order : [[1, "asc"]]
	} );

	/* -----------------------------------------------
	/* 창 사이즈 및 좌측메뉴, 우측 컨텐츠의 보이기 여부에
	/* 따른 DataTable 사이즈 변경 처리
	----------------------------------------------- */
	$(window).bind("resize", fnLayoutConf200);

	function fnLayoutConf200() {
		$("#macAsgnYnTable").css("width", "100%");
		$("#macAsgnYnTable").DataTable().columns.adjust().draw();
	}

	function fnLayoutConf201() {
		fnLayoutConf200();
	}

</script>