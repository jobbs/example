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


<form:form id="servcRouteVo" commandName="servcRouteVo">
<form:hidden path="servcSeq" title="서비스SEQ"  />
<form:hidden path="servcAreaId" title="서비스영역ID"  />
<form:hidden path="routeId" title="라우트ID"  />
<form:hidden path="regionId" title="센터"  />
<form:hidden path="zoneId" title="존"  />
<form:hidden path="netClCd" title="망"  />
<form:hidden path="rsrcPoolId" title="자원풀ID"  />

<div class="box">
	<div class="box-body no-padding">
		<table class="table table-vertical">
			<caption>라우트 목록 테이블</caption>
			<colgroup>
				<col class="col40">
				<col class="col30">
				<col class="col20">
				<col class="col10">
			</colgroup>
			<thead>
			<tr>
				<th>라우트명</th>
				<th>호스트명</th>
				<th>대상포트</th>
				<th></th>
			</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${list eq null or empty list }">
						<tr>
							<td colspan="3">라우트 정보가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="route" items="${list }" varStatus="i">
				          <tr>
				          	<td class="alignL"><c:out value="${route.routeNm }" /></td>
				          	<td class="alignL"><c:out value="${route.hstNm }" /></td>
				          	<td class="alignL"><c:out value="${route.targtPort }" /></td>

				          	<menu:authorize authType="act">
				          	<td>
				          		<button class="btn btn-default btn-sm" onclick="fn_deleteRoute('<c:out value="${route.routeId }" />', '<c:out value="${route.hstNm }" />');return false;">삭제</button>
				          	</td>
				          	</menu:authorize>

				          </tr>
				        </c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>

</form:form>


<script type="text/javascript">
//라우트 삭제
function fn_deleteRoute(routeId, hstNm) {

	$('#routeId').val(routeId);

	jConfirm(hstNm+' 라우트를 삭제 하시겠습니까?', function(){
		$.ncmsLoding.startFullScreen();
		$.post('deleteServcRoute.do', $('#servcRouteVo').serialize(), function(result) {

			jInfo(result.messageList, function() {
				if( result.success) {
					location.reload();
				}
			});

		}, 'json').always(function(){$.ncmsLoding.remove();});
	});

}


</script>