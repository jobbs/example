<!--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2017. 1. 11.
 * @lastmodified 2017. 1. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 1. 11.     이화영         v1.0             최초생성
 *
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:url var="detailUrl" value="selectSw.do">
	<c:forEach var="curParam" items="${param }">
		<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
	</c:forEach>
</c:url>
<c:url var="listUrl" value="selectSwList.do">
	<c:forEach var="curParam" items="${param }">
		<c:if test="${curParam.key ne 'swSeq'}">
			<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
		</c:if>
	</c:forEach>
</c:url>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">기본 정보</h3>
		</div>
		<div class="box-body no-padding">
			<form:form commandName="swVo">
			<table class="table table-horizon">
				<caption>소프트웨어 저장 테이블</caption>
				<colgroup>
					<col class="col30">
					<col class="col70">
				</colgroup>
				<tbody>
				<tr>
					<th><span class="text-red">*</span>소프트웨어 명</th>
	    			<td><form:input path="swNm" cssClass="form-control essential" title="소프트웨어명" maxlength="60" /></td>
	    		</tr>
	    		<tr>
					<th><span class="text-red">*</span>소프트웨어 버전</th>
					<td><form:input path="swVer" cssClass="form-control essential" title="소프트웨어버전" maxlength="30" /></td>
				</tr>
				<tr>
					<th>소프트웨어 제조사</th>
					<td><form:input path="swMnfctCo" cssClass="form-control" title="소프트웨어제조사" maxlength="30" /></td>
				</tr>
				<tr>
					<th>비고</th>
					<td><form:textarea name="rmk" path="rmk" class="form-control" rows="3" title="비고" maxlength="1000"/></td>
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
				<c:when test="${swVo.swSeq > 0 }">
					<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${detailUrl}')"><i class="fa fa-arrow-left"></i></button>
				</c:when>
				<c:otherwise>
					<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
				</c:otherwise>
			</c:choose>
		</div>

		<div class="pull-right btns">
			<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="" data-original-title="저장" onclick="doSubmit();"><i class="fa fa-check"></i></button>
		</div>
	</div>
</div>

<script type="text/javascript">

function doSubmit(){

	if(!fn_form_validation("swVo")){
		return;
	}

	jConfirm('소프트웨어 정보를 저장하시겠습니까?', function() {
		var options = {
				type : 'post',
				dataType : 'json',
				success : function(result) {

					alert_message(result.messageList, function() {
						if (result.success) {
							if (result.procType == "insert") {
								location.href = "selectSwList.do";
							} else {
								location.href = "${detailUrl}";
							}
						}
					},(result.success?"INFO":""));
				},
				error : function(xhr, textStatus, errorThrown) {
					jAlert('오류 발생');
				}
		};

		$('#swVo').ajaxSubmit(options);
	});
}

</script>