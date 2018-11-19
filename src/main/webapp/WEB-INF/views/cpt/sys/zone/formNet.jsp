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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<div class="box">

	<div class="box-header">
		<h3 class="box-title">센터 정보</h3>
	</div><!-- /box-header -->

	<div class="box-body no-padding">
		<table class="table table-horizon">
			<caption>망 등록 테이블</caption>
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

	<form:form commandName="net" method="post" onsubmit="doZoneNetSubmit(); return false;">
	<form:hidden path="netId"/>
	<form:hidden path="zoneNet.zoneId"/>
	<div class="box-header">
		<h3 class="box-title">망 정보</h3>
	</div><!-- /box-header -->

	<div class="box-body no-padding">
		<table class="table table-horizon">
			<colgroup>
				<col class="col20">
				<col class="colAuto">
			</colgroup>
			<tbody>
			<tr>
				<th><span class="text-red">*</span> 망명</th>
				<td><form:input path="netNm" cssClass="form-control essential" title="망명" maxlength="30" style="ime-mode:active" /></td>
			</tr>
			<tr>
				<th><span class="text-red">*</span> 망구분코드</th>
				<td>
					<nform:selectCode
							parentCd="NETCD"
							parentGrpCd="067"
							whole="false"
							name="netClCd"
							value="${net.netClCd }"
							cssClass="form-control essential" />
				</td>
			</tr>
			</tbody>
		</table>
	</div>
	</form:form>
</div>
<menu:authorize>
<div class="edit-btn-group">
	<div class="pull-right btns">
		<button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="저장" onclick="doZoneNetSubmit()"><i class="fa fa-check"></i></button>
	</div>
</div>
<script type="text/javascript">



function doZoneNetSubmit(){

	if(!fn_form_validation("net"))
		return;

	<c:choose>
		<c:when test="${net.netId ne null }">
		var url = "<c:url value="updateNet.do" />";
		</c:when>
		<c:otherwise>
		var url = "<c:url value="insertNet.do" />";
		</c:otherwise>
	</c:choose>

	jConfirm('망정보를 저장하시겠습니까?', function() {

		//로딩바 시작
		$.ncmsLoding.startFullScreen();

		$.post(url,$('#net').serialize(), function (result) {
			alert_message(result.messageList, function() {
				if (result.success) {
					if( result.procType == "netupdate" ) {
						//이름변경
						$("#tree").dynatree("getActiveNode").setTitle($("#netNm").val());
					} else {
						//자식 추가
						var node = result.data;
						$("#tree").dynatree("getActiveNode").addChild({
							"title" : node.netNm,
							"key" : node.zoneNet.zone.region.regionId + "," +  node.zoneNet.zoneId + "," + node.netId
	 					});

						$("#tree").dynatree("getActiveNode").sortChildren(function(a, b) {
							a = a.data.title.toLowerCase();
						    b = b.data.title.toLowerCase();
						    return a > b ? 1 : a < b ? -1 : 0;
						}, false);

						$("#tree").dynatree("getActiveNode").expand(true);

						if( $("#tree").dynatree("getActiveNode").data.isFolder == null || !$("#tree").dynatree("getActiveNode").data.isFolder) {
							$("#tree").dynatree("getActiveNode").data.isFolder = true;
							$("#tree").dynatree("getActiveNode").render();
						}

					}

					loadSelectDetail( $("#tree").dynatree("getActiveNode").data.key );
				}
			});
		},'json').always(function() {
			//로딩바 종료
			$.ncmsLoding.remove();
		});
	});

}
$('[data-toggle="tooltip"]').tooltip();
</script>
</menu:authorize>