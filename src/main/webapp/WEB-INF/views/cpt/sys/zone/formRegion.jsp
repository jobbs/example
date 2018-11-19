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

	<form:form commandName="region" method="post" onsubmit="doRegionSubmit(); return false;">
	<div class="box-header">
		<h3 class="box-title">센터 정보</h3>
	</div><!-- /box-header -->

	<div class="box-body no-padding">
		<table class="table table-horizon">
			<caption>센타 등록 테이블</caption>
			<colgroup>
				<col class="col20">
				<col class="colAuto">
			</colgroup>
			<tbody>
			<tr>
				<th><span class="text-red">*</span> 센터ID</th>
				<td>
					<c:choose>
						<c:when test="${region.regionId ne null }">
							<c:out value="${region.regionId }" />
							<form:hidden path="regionId" />
						</c:when>
						<c:otherwise>
							<form:input path="regionId" cssClass="form-control essential" title="센터ID" maxlength="10" style="ime-mode:inactive" />
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th><span class="text-red">*</span> 센터명</th>
				<td><form:input path="regionNm" cssClass="form-control essential" title="센터명" maxlength="30" style="ime-mode:active" /></td>
			</tr>
			<tr>
				<th>센터위치명</th>
				<td><form:input path="regionLocaNm" cssClass="form-control" title="센터위치명" maxlength="100" /></td>
			</tr>
			</tbody>
		</table>
	</div>
	</form:form>
</div>
<menu:authorize>
<div class="edit-btn-group">
		<div class="btns pull-right">
		<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="" data-original-title="저장" onclick="doRegionSubmit()"><i class="fa fa-check"></i></button>
    </div>
</div>
<script type="text/javascript">

function doRegionSubmit(){

	if(!fn_form_validation("region"))
		return;

	<c:choose>
		<c:when test="${region.regionId ne null }">
		var url = "<c:url value="updateRegion.do" />";
		</c:when>
		<c:otherwise>
		var url = "<c:url value="insertRegion.do" />";
		</c:otherwise>
	</c:choose>
	jConfirm('센터정보를 저장하시겠습니까?', function() {

		//로딩바 시작
		$.ncmsLoding.startFullScreen();

		$.post(url,$('#region').serialize(), function (result) {
			alert_message(result.messageList, function() {
				if (result.success) {
					if( result.procType == "regionUpdate" ) {
						//이름변경
						$("#tree").dynatree("getActiveNode").setTitle($("#regionNm").val());
					} else {

						//자식 추가
						$("#tree").dynatree("getActiveNode").addChild({
							"title" : $("#regionNm").val(),
							"key" : $("#regionId").val()
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