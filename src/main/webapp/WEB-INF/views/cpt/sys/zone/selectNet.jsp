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
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<div class="box">

	<div class="box-header">
		<h3 class="box-title">존 정보</h3>
	</div><!-- /box-header -->

	<div class="box-body no-padding">
		<table class="table table-horizon">
			<caption>존 정보 테이블</caption>
			<colgroup>
				<col class="col20">
				<col class="col30">
				<col class="col20">
				<col class="col30">
			</colgroup>
			<tbody>
			<tr>
				<th>센터ID</th>
				<td><c:out value="${net.zoneNet.zone.region.regionId }" /></td>
				<th>센터명</th>
				<td><c:out value="${net.zoneNet.zone.region.regionNm }" /></td>
			</tr>
			<tr>
				<th>존ID</th>
				<td><c:out value="${net.zoneNet.zone.zoneId }" /></td>
				<th>존명</th>
				<td><c:out value="${net.zoneNet.zone.zoneNm }" /></td>
			</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="box">
	<div class="box-header">
		<h3 class="box-title">망정보</h3>
	</div><!-- /box-header -->

	<div class="box-body no-padding">
		<table class="table table-horizon">
			<caption>망정보 테이블</caption>
			<colgroup>
				<col class="col20">
				<col class="colAuto">
			</colgroup>
			<tbody>
			<tr>
				<th>망ID</th>
				<td><c:out value="${net.netId }" /></td>
			</tr>
			<tr>
				<th>망명</th>
				<td><c:out value="${net.netNm }" /></td>
			</tr>
			<tr>
				<th>망구분</th>
				<td><c:out value="${net.netClNm }" /></td>
			</tr>
			</tbody>
		</table>
	</div>
</div>

<menu:authorize>
<div class="edit-btn-group">
	<div class="pull-right btns">
		<button class="btn btn-sm btn-hover-yellow" data-toggle="tooltip" data-original-title="망수정" onclick="doUpdateNetForm('<c:out value="${net.netId}" />')"><i class="fa fa-eraser"></i></button>
		<c:if test="${net.netId ne null }">
			<button type="button" class="btn btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="jConfirm('망정보를 삭제하시겠습니까?', doNetDelete)"><i class="fa fa-times"></i></button>
		</c:if>
	</div>
</div>

<script type="text/javascript">
function doUpdateNetForm(netId) {
	$.get("updateNet.do",{'netId' : netId}, loadSuccessHandler,'html');
}


function doNetDelete() {

	var node = $("#tree").dynatree("getActiveNode");
	if( node.countChildren() > 0 ) {
		jAlert("망에 속한 자원풀이 존재합니다. 삭제할 수 없습니다.");
		return;
	}

	//로딩바 시작
	$.ncmsLoding.startFullScreen();

	$.post("deleteNet.do", {"netId" : "<c:out value="${net.netId }" />" }, function (result) {
		alert_message(result.messageList, function() {
			if (result.success) {
				var parentKey = $("#tree").dynatree("getActiveNode").getParent().data.key;
				$("#tree").dynatree("getActiveNode").remove();
				$("#tree").dynatree("getTree").activateKey(parentKey);

				if( $("#tree").dynatree("getActiveNode").countChildren() == 0 ) {
					$("#tree").dynatree("getActiveNode").data.isFolder = false;
					$("#tree").dynatree("getActiveNode").render();
				}

			}
		});
	},'json').always(function() {
		//로딩바 종료
		$.ncmsLoding.remove();
	});
}
$('[data-toggle="tooltip"]').tooltip();
</script>
</menu:authorize>