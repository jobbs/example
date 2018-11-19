<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 4.
 * @lastmodified 2016. 12. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 4.     양정순         v1.0             최초생성
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
<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>
<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>


<div class="col-box-100 search-col">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">자원 회수 상세 현황</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_excelDown()">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical" id="withDrawTable">
				<caption>자원 회수 상세 현황</caption>
				<colgroup>
					<col class="colAuto">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">

				</colgroup>
				<thead>
					<tr>
						<th rowspan="2">번호</th>
						<th rowspan="2">자원풀코드</th>
						<th colspan="4">반납요구량</th>
						<th colspan="4">반납량</th>
						<th colspan="4">반납률(%)</th>
					</tr>
					<tr>
						<th>가상서버</th>
						<th>vCore</th>
						<th>MEM</th>
						<th>SAN</th>
						<th>가상서버</th>
						<th>vCore</th>
						<th>MEM</th>
						<th>SAN</th>
						<th>가상서버</th>
						<th>vCore</th>
						<th>MEM</th>
						<th>SAN</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${list eq null or empty list }">
							<tr>
								<td colspan="15">검색된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${list }" varStatus="ri">
								<tr>
									<td class="alignC"><c:out value="${vo.rn }" /></td>
									<td class="alignL"><a href="" onclick="fn_gotoUpdate('<c:out value="${vo.rsrcPoolId }" />');return false;"><c:out value="${vo.rsrcPoolNm }" /></a></td>
									<td class="alignR"><fmt:formatNumber value="${vo.returnReqQtyVm }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.returnReqQtyVcore }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.returnReqQtyMem }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.returnReqQtySan }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.returnQtyVm }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.returnQtyVcore }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.returnQtyMem }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.returnQtySan }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.returnRtVm }" pattern="#,###.##" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.returnRtVcore }" pattern="#,###.##" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.returnRtMem }" pattern="#,###.##" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.returnRtSan }" pattern="#,###.##" /></td>

								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->
	</div>
	<!-- /box(목록조회 테이블) -->
</div>
<!-- /col -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="f_goToListPage()">
				<i class="fa fa-arrow-left"></i>
			</button>
		</div>
		<div class="pull-right btns"></div>
	</div>
</div>
<form:form commandName="searchVo" method="get">
	<c:forEach var="region" items="${searchVo.region }">
		<input type="hidden" name="region" value="${region }" />
	</c:forEach>
	<form:hidden path="quarter" />
	<form:hidden path="year" />
	<input type="hidden" name="rsrcPoolId" id="rsrcPoolId" value="" />
	<input type="hidden" name="cmd" id="cmd">

</form:form>

<script type="text/javascript">

function fn_gotoUpdate(rsrcPoolId){
	$('#rsrcPoolId').val(rsrcPoolId);
	$('#cmd').val('U');

	searchVo.action='<c:url value="insertWthdrwStView.do" />';
	searchVo.submit();
}




function fn_excelDown(){
	if(${list eq null or empty list}) {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}

	searchVo.action='<c:url value="selectWthdrwRsrcXlsDown.do" />';
	searchVo.submit();

}

function goToUrl(url) {
	location.href = url;
}

//목록조회 페이지로 이동
function f_goToListPage(){
	location.href = "selectWthdrwStList.do";
}

</script>

