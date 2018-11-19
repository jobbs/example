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

<c:url var="detailUrl" value="selectTermDicary.do">
	<c:forEach var="curParam" items="${param }">
		<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
	</c:forEach>
</c:url>
<c:url var="listUrl" value="selectTermDicaryList.do">
	<c:forEach var="curParam" items="${param }">
		<c:if test="${curParam.key ne 'wordSeq'}">
			<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
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
				<colgroup>
					<col class="col20">
					<col class="colAuto">
				</colgroup>
				<tbody>
				<tr>
					<th>표준용어</th>
					<td><form:input path="wordKr" cssClass="form-control essential" title="한글명"/></td>
				</tr>
				<tr>
					<th>표준영문명</th>
					<td>
						<form:input path="wordEn" cssClass="form-control essential" title="영문명"/>
					</td>
				</tr>
				<tr>
					<th>도메인</th>
					<td>
						<form:input path="wordAbrv" cssClass="form-control essential" title="영문약어"/>
					</td>
				</tr>
				<tr>
					<th>설명</th>
					<td>
						<form:input path="wordDc" cssClass="form-control" title="설명"/>
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
       <button class="btn btn-hover-gray" data-toggle="tooltip" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
     </div>
		<div class="pull-right btns">
       <button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="저장" onclick="jConfirm('용어사전을 저장하시겠습니까?', doSubmit);"><i class="fa fa-check"></i></button>
     </div>
	</div>
</div>

<script type="text/javascript">

function doSubmit(result){

	if(!fn_form_validation("vo")){
		return;
	}

	var options = {
		type: 'post',
		dataType: 'json',
		success: successHandler,
		beforeSend : function() {
			$.ncmsLoding.startFullScreen();
		},
		complete : function() {
			$.ncmsLoding.remove();
		},
		error: function(xhr, textStatus, errorThrown){
			alert('오류 발생');
		}
	};
	$('#vo').ajaxSubmit(options);
}

function successHandler(result){

	alert_message(result.messageList, function() {
		if(result.success){
			location.href = "${listUrl}";
		}
	});
}

function deleteFile(obj){
	var con = confirm("파일을 삭제 하시겠습니까?");
	if( !con ) return false;
	$(obj).parent().parent().remove();
}
</script>