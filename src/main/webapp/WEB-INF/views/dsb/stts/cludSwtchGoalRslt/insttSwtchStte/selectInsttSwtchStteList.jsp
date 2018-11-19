<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.     김동훈         v1.0             최초생성
 *
 --%>
 <%@page	import=" java.util.*"  %>
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/chart/chart.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>

<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
	<form:hidden path="paginationInfo.currentPageNo" id="currentPageNo"/>
</form:form>
<div class="col-box-100 search-col">
		<div class="box list-box">
          <div class="box-header">
			<h3 class="box-title">기관별 전환 현황
				<small>${searchVo.paginationInfo.currentPageNo } /
						${searchVo.paginationInfo.totalPageCount },
						총 ${searchVo.paginationInfo.totalRecordCount }건
				</small></h3>
				<div class="box-tools">
                <div class="input-group-box">
				     <nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/>
				     <div class="input-group-cell pad-right">
				     	<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_excelDown()"><i class="fa fa-download"></i></button>
				     </div>
				    </div>

              </div>
		</div>
          <div class="box-body no-padding list-body">
              <table class="table table-hover table-vertical table-bordered table-layout-fixed" id="tableInsttSwtchStte">
              <caption>기관별 전환 현황</caption>

                <thead>
                	<tr>
                		<th>No.</th>
                		<th>기관명</th>
                		<th>전환 업무수</th>
                		<th>주요 전환 사례</th>
                	</tr>
                </thead>
                <tbody>
	                <c:if test="${list eq null or empty list}">
	                	<tr ><td colspan="4">검색된 데이터가 없습니다.</td></tr>
	                </c:if>
	                <c:forEach var="vo" items="${list }" varStatus="i">
	                	<tr>
		                	<td class="ellipsis" ><c:out value="${vo.rnk}" /></td>
		                	<td class="ellipsis alignL" ><c:out value="${vo.institutionNm}"/></td>
		                	<td class="ellipsis alignR" ><fmt:formatNumber value="${vo.swtchJobQty}" pattern="#,###"/></td>
		                	<td class="ellipsis alignL" ><c:out value="${vo.primeSwtchExam }"/></td>
	                	</tr>
	                </c:forEach>
              </tbody>
            </table>
          </div><!-- /box-body -->
		<div class="box-footer edit-btn-group">
			<div class="pull-left btns">
			</div>
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertInsttSwtchStteView.do">
					</c:url>
					<button class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가" onclick="fn_goToUrl('${insertUrl}')"><i class="fa fa-plus"></i></button>
				</menu:authorize>
			</div>

		</div>

	</div><!-- /box(목록조회 테이블) -->

</div><!-- /col -->
<form id="excelForm" name="excelForm" action='<c:url value="selectInsttSwtchStteXlsDown.do"/>'>
</form>
<script>
$(document).ready(function() {
var autoColumns=[
					{sWidth:"50px"},
					{sWidth:"300px"},
					{sWidth:"100px"},
					{sWidth:"*"}
              ];
<c:if test="${not empty list}">
$("#tableInsttSwtchStte").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns:autoColumns
	,order : [[0,"desc"]]
} );
</c:if>

});
function fn_excelDown(){
	excelForm.submit();
}
function fn_goToUrl(url){
	location.href=url;
}
function goPage(page){
	$('#currentPageNo').val(page);
	searchVo.action='<c:url value="selectInsttSwtchStteList.do" />';
	searchVo.submit();
}
</script>