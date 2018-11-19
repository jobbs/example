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
<div class="col-box-100 detail-col">
	<div class="box">

		<div class="box-header">
			<h3 class="box-title">상위 메뉴정보</h3>
		</div><!-- /box-header -->

		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>상위메뉴 정보 테이블</caption>
				<colgroup>
					<col class="col20">
					<col class="colAuto">
				</colgroup>
				<tbody>
				<tr>
					<th>상위메뉴명</th>
					<td><c:out value="${vo.parent.menuNm }" /></td>
				</tr>
				<tr>
					<th>메뉴패턴</th>
					<td><c:out value="${vo.parent.menuPattern }" /></td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="box">

		<form:form commandName="vo">
		<form:hidden path="parentSeq" />
		<form:hidden path="menuSeq" />
		<form:hidden path="parent.menuPattern" id="parentPattern" />

		<div class="box-header">
			<h3 class="box-title">메뉴정보</h3>
		</div><!-- /box-header -->

		<div class="box-body no-padding">
			<table class="table table-horizon">
				<colgroup>
					<col class="col20">
					<col class="colAuto">
				</colgroup>
				<tbody>
				<tr>
					<th><span class="text-red">*</span> 메뉴명</th>
					<td><form:input path="menuNm" cssClass="form-control essential" title="메뉴명" maxlength="100"/></td>
				</tr>
				<tr>
					<th><span class="text-red">*</span> 메뉴패턴</th>
					<td>
						<form:input path="menuPattern" cssClass="form-control essential" title="메뉴패턴" placeholder="리소스는 반드시 '/'로 시작을 하여 '/'로 끝나도록 하여 주시기 바랍니다." maxlength="200"/>
					</td>
				</tr>
				<tr>
					<th>실행파일(.do)</th>
					<td><form:input path="menuFile" cssClass="form-control" placeholder="패턴 이후 URL만 입력을 하여 주시며 반드시 확장자는 .do로 하여 주시기 바랍니다." maxlength="200" title="실행파일명"/></td>
				</tr>
				<tr>
					<th>메뉴설명</th>
					<td><form:input path="menuDesc" cssClass="form-control" maxlength="200" title="메뉴설명"/></td>
				</tr>
				<tr>
					<th>사용여부</th>
					<td>
						<div class="input-group input-group-radio">
							<form:radiobutton path="useYn" label="사용" value="Y"/>
							<form:radiobutton path="useYn" label="미사용" value="N"/>
						</div>
					</td>
				</tr>
				<tr>
					<th>팝업여부</th>
					<td>
						<div class="input-group input-group-radio">
							<form:radiobutton path="popupYn" label="사용" value="Y"/>
							<form:radiobutton path="popupYn" label="미사용" value="N"/>
						</div>
					</td>
				</tr>
			</table>
		</div>
		</form:form>
	</div>
	<div class="btns">
		<div class="btn-group pull-right">
			<button type="button" class="btn btn-default" onclick="loadSelectDetail()">취소</button>
			<button type="button" class="btn btn-default" onclick="jConfirm('메뉴를 저장하시겠습니까?', doSubmit)">저장</button>
	    </div>
	</div>
</div>

<script type="text/javascript">

function doSubmit(){

	if(!fn_form_validation("vo"))
		return;

	//상위 메뉴와 패턴이 동일한지 여부 판단
	/* var parentPattern = $("#parentPattern").val();
	var menuPattern = $("#menuPattern").val();

	if( menuPattern.indexOf(parentPattern) != 0 ) {
		jAlert("메뉴 패턴은 상위 메뉴 패턴을 포함하여야 합니다.", function() {
			$("#menuPattern").focus();
		});

		return;
	} */

	<c:choose>
		<c:when test="${vo.menuSeq ne null }">
		var url = "<c:url value="updateMenu.do" />";
		</c:when>
		<c:otherwise>
		var url = "<c:url value="insertMenu.do" />";
		</c:otherwise>
	</c:choose>

	$.ncmsLoding.startFullScreen();
	$.post(url,$('#vo').serialize(), submitSuccessHandler,'json').always(function() {
				$.ncmsLoding.remove();
			});
}

</script>