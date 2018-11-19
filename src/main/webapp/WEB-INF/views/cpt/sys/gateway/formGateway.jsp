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
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<c:url var="detailUrl" value="selectGateway.do">
	<c:forEach var="curParam" items="${param }">
		<c:param name="${curParam.key }" value="${curParam.value }">
		</c:param>
	</c:forEach>
</c:url>

<c:url var="listUrl" value="selectGatewayList.do">
	<c:forEach var="curParam" items="${param }">
		<c:if test="${curParam.key ne 'gatewaySeq'}">
			<c:param name="${curParam.key }" value="${curParam.value}"></c:param>
		</c:if>
	</c:forEach>
</c:url>


<script type="text/javascript" src="<c:url value="/resources/js/common/validation.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/FileUtils.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/sedit2/js/HuskyEZCreator.js" />" charset="UTF-8"></script>


<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<form:form commandName="vo">
				<table class="table table-horizon">
					<caption>API Gateway 등록 테이블</caption>
					<colgroup>
						<col class="col20">
						<col class="colAuto">
					</colgroup>
					<tbody>
						<tr>
							<th><span class="text-red">*</span><label for="gatewayNm">명칭</label> </th>
							<td><form:input path="gatewayNm" cssClass="form-control essential" title="명칭" maxlength="100"/></td>
						</tr>
						<tr>
							<th><span class="text-red">*</span> <label for="gatewayHost">HOST</label></th>
							<td><form:input path="gatewayHost" cssClass="form-control essential" title="HOST" maxlength="100"/></td>
						</tr>
						<tr>
							<th><span class="text-red">*</span> <label for="gatewayToken">TOKEN</label></th>
							<td><form:input path="gatewayToken" cssClass="form-control essential" title="TOKEN" maxlength="100" /></td>
						</tr>
						<tr>
							<th><span class="text-red">*</span> <label for="regionId">센터구분</label></th>
							<td>
								<nform:selectRegion
									name="regionId"
									value="${vo.regionId }"
									byRole="false"
									wholeText="선택"
									cssClass="form-control input-sm pull-right essential"
									title="센터구분"/>
							</td>
						</tr>
					</tbody>
				</table>
			</form:form>
		</div>
	</div>
</div>

<!-- 페이지 버튼 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<c:choose>
				<c:when test="${vo.gatewaySeq > 0}">
					<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip"
						title="" data-original-title="뒤로"
						onclick="goToUrl('${detailUrl}')">
						<i class="fa fa-arrow-left"></i>
					</button>
				</c:when>
				<c:otherwise>
					<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip"
						title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')">
						<i class="fa fa-arrow-left"></i>
					</button>
				</c:otherwise>
			</c:choose>
		</div>

		<div class="pull-right btns">
			<button class="btn btn-sm btn-hover-green" data-toggle="tooltip"
				title="" data-original-title="저장"
				onclick="doSubmit()">
				<i class="fa fa-check"></i>
			</button>
		</div>
	</div>
</div>

<script type="text/javascript">

	function doSubmit(result) {
		if (!fn_form_validation("vo")) {
			return;
		}

		jConfirm('API-Gateway 접속정보를 저장하시겠습니까?', function() {
			var options = {
					type : 'post',
					dataType : 'json',
					success : function(result) {

						alert_message(result.messageList, function() {
							if (result.success) {
								if (result.procType == "insert") {
									location.href = "selectGatewayList.do";
								} else {
									location.href = "${detailUrl}";
								}
							}
						},(result.success?"INFO":""));
					},
					beforeSend : function() {
						$.ncmsLoding.startFullScreen();
					},
					complete : function() {
						$.ncmsLoding.remove();
					},
					error : function(xhr, textStatus, errorThrown) {
						jAlert('오류 발생');
					}
			};

			$('#vo').ajaxSubmit(options);
		});

	}
</script>