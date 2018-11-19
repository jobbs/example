<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     박봉춘         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>API Gateway 정보 테이블</caption>
				<colgroup>
					<col class="col20">
					<col class="colAuto">
				</colgroup>
				<tbody>
					<tr>
						<th>명칭</th>
						<td><c:out value="${vo.gatewayNm }"/></td>
					</tr>
					<tr>
						<th>HOST</th>
						<td><c:out value="${vo.gatewayHost }"/></td>
					</tr>
					<tr>
						<th>센터구분</th>
						<td><c:out value="${vo.regionNm }"/></td>
					</tr>
					<tr>
						<th>TOKEN</th>
						<td><c:out value="${vo.gatewayToken }"/></td>
					</tr>
					<tr>
						<th>접속상태</th>
						<td id="healthTd"><span class="status status-gray">접속상태확인중</span></td>
					</tr>
					<tr>
						<th>등록자</th>
						<td><c:out value="${vo.regUserNm }"/></td>
					</tr>
					<tr>
						<th>등록일자</th>
						<td><fmt:formatDate value="${vo.regDttm }" pattern="yyyy-MM-dd"/></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<!--  페이지 버튼 -->
	<div class="col-box-100">
		<div class="edit-btn-group">

			<c:url var="updateUrl" value="updateGateway.do">
				<c:forEach var="curParam" items="${param}">
					<c:param name="${curParam.key}" value="${curParam.value}"></c:param>
				</c:forEach>
			</c:url>
			<c:url var="listUrl" value="selectGatewayList.do">
				<c:forEach var="curParam" items="${param }">
					<c:if test="${curParam.key ne 'gatewaySeq' }">
						<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
					</c:if>
				</c:forEach>
			</c:url>
			<div class="pull-left btns">
				<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
			</div>

			<menu:authorize>
				<div class="pull-right">
					<button class="btn btn-hover-yellow" data-toggle="tooltip" data-original-title="수정" onclick="goToUrl('${updateUrl}')"><i class="fa fa-eraser"></i></button>
					<button class="btn btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="doDelete()"><i class="fa fa-times"></i></button>
				</div>
			</menu:authorize>
		</div>
	</div>

<script type="text/javascript">
function doDelete(){

	jConfirm("API-Gateway 접속정보를 삭제하시겠습니까?", function() {
		var url = "<c:url value="deleteGateway.do" />";

		$.ncmsLoding.startFullScreen();
		$.post(url, {"gatewaySeq": ${vo.gatewaySeq} }, function(result) {
			alert_message(result.messageList, function() {
				if( result.success) {
					goToUrl('${listUrl}');
				}
			});

		}, "json")
		.always(function() {
			$.ncmsLoding.remove();
		});;
	});
}

function checkHealth() {
	$.get("selectGatewayHealthCheck.do", {"regionId" : "<c:out value="${vo.regionId }"/>"}, function(result) {
		var datas = result.data;
		var data = datas[0];

		if( null == data.health ) {
			$("#healthTd").html("<span class='status status-red'>접속오류</span>");
		} else {
			if( "ok" == data.health.condition ) {
				$("#healthTd").html("<span class='status status-green'>접속</span>");
			} else {
				$("#healthTd").html("<span class='status status-red'>접속오류</span>");
			}
		}
	});
}
checkHealth();

</script>







