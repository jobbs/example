<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<div class="box">
	<div class="box-body no-padding">
		<table class="table table-hover table-vertical table-layout-fixed" id="bldTable">
			<caption>빌드 목록 테이블</caption>
			<colgroup>
				<col class="col5">
				<col class="col5">
				<col class="col20">
				<col class="col20">
				<col class="col30">
				<col class="col20">
			</colgroup>
			<thead>
			<tr>
				<th>버전</th>
				<th>상태</th>
				<th>빌드명</th>
				<th>Git브랜치명</th>
				<th>소스저장소URL</th>
				<th>생성일시</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="bld" items="${list }" varStatus="i">
		          <tr>
		          	<td class="alignC"><c:out value="${bld.bldVer }" /></td>
		          	<td class="alignC">
		          		<!-- 진행중 01: 완료:02, 실패 03: 취소: 04 , New:05, Pending:06 ,오류:07, 기타:08 -->
                		<span class="status <c:choose>
                								<c:when test="${'01' eq bld.bldStatCd}"><c:out value="status-blue"/></c:when>
                								<c:when test="${'02' eq bld.bldStatCd}"><c:out value="status-green"/></c:when>
                								<c:when test="${'03' eq bld.bldStatCd}"><c:out value="status-aqua"/></c:when>
                								<c:when test="${'07' eq bld.bldStatCd}"><c:out value="status-red"/></c:when>
												<c:otherwise><c:out value="status-gray"/></c:otherwise>
                							</c:choose>
                			status-red "><c:out value="${bld.bldStatNm}"/>
                		</span>
		          	</td>
		          	<td class="alignL"><c:out value="${bld.bldHstryId }" /></td>
		          	<td class="alignL"><c:out value="${bld.gitBrnchNm }" /></td>
		          	<td class="alignL"><c:out value="${bld.repoAddr }" /></td>
		          	<td class="alignC"><c:out value="${bld.creDttm }" /></td>
		          </tr>
		        </c:forEach>
			</tbody>
		</table>
	</div>
</div>

<script type="text/javascript">

$(document).ready(function() {

	$("#bldTable").DataTable({
	    dom : 'Zlfrtip',
	    paging : false,
	    searching : false,
	    info : false,
	    bAutoWidth : false,
		scrollY: "138px",
		scrollCollapse: true,
	    aoColumns : [
	          {sWidth : "100px" },
	          {sWidth : "80px" },
	          {sWidth : "300px" },
	          {sWidth : "200px" },
	          {sWidth : "400px" },
	          {sWidth : "100px" }
	    ],

	    order : [ [ 0, "desc" ] ]
	});
});

$(window).bind("resize", fn_tableSetSize);

function fn_tableSetSize() {
	$("#bldTable").DataTable().columns.adjust();
}

</script>