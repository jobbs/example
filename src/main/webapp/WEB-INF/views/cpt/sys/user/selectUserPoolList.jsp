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
<c:choose>	<c:when test="${list eq null or empty list }"></c:when>
			<c:otherwise>총 ${list.size() } 건</c:otherwise></c:choose>
	<div class="box-body no-padding">
		<table class="table table-vertical" id="userPoolTable">
			<caption>사용자 자원정보 테이블</caption>
			<thead>
			<tr>
				<th>No</th>
				<th>센터</th>
				<th>존</th>
				<th>망</th>
				<th>자원풀</th>
				<menu:authorize>
				<th></th>
				</menu:authorize>
			</tr>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${list eq null or empty list }">
					<tr>
						<td colspan="6">권한을 가진 자원풀이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="rsrcPool" items="${list }" varStatus="i">
			          <tr>
			          	<td><c:out value="${i.index +1 }" /></td>
			          	<td><c:out value="${rsrcPool.region.regionNm }" /></td>
			          	<td class="alignL"><c:out value="${rsrcPool.zone.zoneNm }" /></td>
			          	<td class="alignL"><c:out value="${rsrcPool.net.netNm }" /></td>
			          	<td class="alignL"><c:out value="${rsrcPool.rsrcPoolNm }" /></td>
			          	<menu:authorize>
			          	<td><button class="btn btn-default btn-sm" onclick="doDeletePool('<c:out value="${rsrcPool.rsrcPoolId }" />')">삭제</button></td>
			          	</menu:authorize>
			          </tr>
		          </c:forEach>
				</c:otherwise>
			</c:choose>
			</tbody>
		</table>
	</div>
	<menu:authorize>
	<div class="box-footer clearfix">
		<c:if test="${isUserRole ne false }">
			<div class="pull-right">
				<button class="btn btn-sm btn-function" onclick="openPoolMultiSearch()">자원풀등록</button>
			</div>
		</c:if>
	</div>

	<script type="text/javascript" src="<c:url value="/resources/js/common/component/popup.js" />"></script>
	<script type="text/javascript">
	function doDeletePool(rsrcPoolId) {
		jConfirm("사용자의 자원풀 권한을 삭제하시겠습니까?", function(result) {

			//로딩바 시작
			$.ncmsLoding.startFullScreen();
			$.post("<c:url value="deleteUserPool.do" />",
					{"rsrcPoolId" : rsrcPoolId, "userId" : "<c:out value="${userId }" />" },
					function(result) {
						alert_message(result.messageList, function() {
							if( result.success ) {
								getPool();
							}
						});
					},
					"json"
				).always(function() {
					//로딩바 종료
					$.ncmsLoding.remove();
				});

		});
	}

	$("#userPoolTable").DataTable( {
		dom: 'Zlfrtip',
		aoColumns : [
		               {sWidth : "80px" }, //NO
		               {sWidth : "100px" }, //센터
		               {sWidth : "100px" }, //존
		               {sWidth : "100px" }, //망
		               {sWidth : "100px" }, //자원풀
		               {sWidth : "80px" },  //
		],
		order : []
	} );
	</script>
	</menu:authorize>
</div>