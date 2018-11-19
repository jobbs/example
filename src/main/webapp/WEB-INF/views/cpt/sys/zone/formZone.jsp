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

<div class="box">

	<div class="box-header">
		<h3 class="box-title">센터 정보</h3>
	</div><!-- /box-header -->

	<div class="box-body no-padding">
		<table class="table table-horizon">
			<caption>존 등록 - 센터 정보 테이블</caption>
			<colgroup>
				<col class="col20">
				<col class="colAuto">
			</colgroup>
			<tbody>
			<tr>
				<th>센터ID</th>
				<td><c:out value="${zone.region.regionId }" /></td>
			</tr>
			<tr>
				<th>센터명</th>
				<td><c:out value="${zone.region.regionNm }" /></td>
			</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="box">

	<form:form commandName="zone" method="post" onsubmit="doZoneSubmit(); return false;">
	<form:hidden path="regionId"/>
	<div class="box-header">
		<h3 class="box-title">존 정보</h3>
	</div><!-- /box-header -->

	<div class="box-body no-padding">
		<table class="table table-horizon">
			<caption>존 등록 테이블</caption>
			<colgroup>
				<col class="col20">
				<col class="colAuto">
			</colgroup>
			<tbody>
			<tr>
				<th><span class="text-red">*</span> 존ID</th>
				<td>
					<c:choose>
						<c:when test="${zone.zoneId ne null }">
							<c:out value="${zone.zoneId }" />
							<form:hidden path="zoneId" />
						</c:when>
						<c:otherwise>
							<form:input path="zoneId" cssClass="form-control essential" title="존ID" maxlength="10" style="ime-mode:inactive" />
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th><span class="text-red">*</span> 존명</th>
				<td><form:input path="zoneNm" cssClass="form-control essential" title="존명" maxlength="30" style="ime-mode:active" /></td>
			</tr>
			</tbody>
		</table>
	</div>
	</form:form>
</div>
<menu:authorize>
<div class="edit-btn-group">
		<div class="btns pull-right">
		<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="" data-original-title="저장" onclick="doZoneSubmit()"><i class="fa fa-check"></i></button>
    </div>
</div>
<script type="text/javascript">

function doZoneSubmit(){

	if(!fn_form_validation("zone"))
		return;

	<c:choose>
		<c:when test="${zone.zoneId ne null }">
		var url = "<c:url value="updateZone.do" />";
		</c:when>
		<c:otherwise>
		var url = "<c:url value="insertZone.do" />";
		</c:otherwise>
	</c:choose>

	jConfirm('존정보를 저장하시겠습니까?', function() {

		//로딩바 시작
		$.ncmsLoding.startFullScreen();

		$.post(url,$('#zone').serialize(), function (result) {
			alert_message(result.messageList, function() {
				if (result.success) {
					if( result.procType == "zoneUpdate" ) {
						//이름변경
						$("#tree").dynatree("getActiveNode").setTitle($("#zoneNm").val());
					} else {

						//자식 추가
						var node = result.data;
						$("#tree").dynatree("getActiveNode").addChild({
							"title" : node.zoneNm,
							"key" : node.region.regionId + "," +  node.zoneId
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