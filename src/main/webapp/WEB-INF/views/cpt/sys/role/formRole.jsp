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

<script type="text/javascript" src="<c:url value="/resources/js/common/validation.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/FileUtils.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/sedit2/js/HuskyEZCreator.js" />" charset="UTF-8"></script>

<div class="col-box-100">
	<div class="box">
		<div class="box-body">
			<form:form commandName="role">
			<table class="table table-bordered">
				<caption>롤 등록 테이블</caption>
				<colgroup>
					<col class="col15">
					<col class="colAuto">
				</colgroup>
				<tbody>
				<tr>
					<th>코드</th>
					<td>
						<c:choose>
							<c:when test="${role.roleCode ne null and !empty role.roleCode }">
							<c:out value="${role.roleCode}" />
							</c:when>
							<c:otherwise>
							<form:input path="roleCode" cssClass="form-control essential" title="코드"/>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<th>명칭</th>
					<td>
						<form:input path="roleName" cssClass="form-control essential" title="명칭"/>
						<form:hidden path="useYn" value="Y"/>
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
	<div class="page-btn">
		<c:url var="detailUrl" value="detail.do">
			<c:forEach var="curParam" items="${param }">
				<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
			</c:forEach>
		</c:url>
		<c:url var="listUrl" value="list.do">
			<c:forEach var="curParam" items="${param }">
				<c:if test="${curParam.key ne 'boardSeq'}">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:if>
			</c:forEach>
		</c:url>
		<c:choose>
			<c:when test="${vo.boardSeq > 0 }">
				<button type="button" class="btn btn-lg" onclick="goToUrl('${detailUrl}')">취소</button>
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-lg" onclick="goToUrl('${listUrl}')">취소</button>
			</c:otherwise>
		</c:choose>

		<div class="pull-right">
			<button type="button" class="btn btn-blue btn-lg" onclick="doSubmit();">저장</button>
		</div>
	</div>
</div>
<!-- /페이지 버튼 -->


<script type="text/javascript">
function doSubmit(){

	if(!fn_form_validation("role")){
		return;
	}

	jConfirm("롤을 저장 하시겠습니까?", function(){
		var url = $("#role").attr("action");

		$.ncmsLoding.startFullScreen();
		$.post(
				url,$('#role').serialize(),
				successHandler,
				'json'
			).always(function() {
				$.ncmsLoding.remove();
			});
	});
}

function successHandler(result){

	alert_message(result.messageList, function() {
		if(result.success){
			if(result.procType == "insert")
				location.href = "list.do";
			else
				location.href = "${detailUrl}";
		}
	});
}

function deleteFile(obj){
	var con = confirm("파일을 삭제 하시겠습니까?");
	if( !con ) return false;
	$(obj).parent().parent().remove();
}
</script>