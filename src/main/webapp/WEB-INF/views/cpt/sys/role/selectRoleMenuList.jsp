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
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<c:set var="hasAuthWrite" value="${menu:hasAuthWrite(requestScope['javax.servlet.forward.request_uri'],pageContext.request.contextPath) }" />

<div class="box-header">
  <h3 class="box-title">[<c:out value="${role.roleNm }"/>] 메뉴 권한</h3>
</div>
<form name="roleMenuFrm" id="roleMenuFrm" action="updateRoleMenu.do">
<input type="hidden" name="roleCd" value="${role.roleCd }" />
<div class="box-body no-padding">
	<table class="table table-hover table-vertical">
		<caption>롤에 속한 메뉴 권한 등록 테이블</caption>
		<colgroup>
			<col class="colAuto">
			<col class="col15">
			<col class="col15">
			<col class="col15">
		</colgroup>
		<thead>
		<tr>
			<th>메뉴</th>
			<th>읽기 <menu:authorize><input type="checkbox" id="chkReadAll" title="읽기 전체 선택" onclick="doCheckAll(this, 'readYn')" /></menu:authorize></th>
			<th>쓰기 <menu:authorize><input type="checkbox" id="chkWriteAll" title="쓰기 전체 선택" onclick="doCheckAll(this, 'writeYn')" /></menu:authorize></th>
			<th>실행 <menu:authorize><input type="checkbox" id="chkActAll" title="실행 전체 선택" onclick="doCheckAll(this, 'actYn')" /></menu:authorize></th>
		</tr>
		</thead>
	</table>
	<div style="overflow: auto; max-height: 600px">
	<table class="table table-hover table-vertical">
		<colgroup>
			<col class="colAuto">
			<col class="col15">
			<col class="col15">
			<col class="col15">
		</colgroup>
		<tbody>
		<c:forEach items="${menus }" var="menu">
			<tr>
				<td class="alignL">
					<c:out value="${menu.menuNm }" />
					<input type="hidden" name="menuRoles[].menuSeq" value="${menu.menuSeq }" />
				</td>
				<td><input type="checkbox" name="menuRoles[].readYn" value="Y" class="readYn" title="${menu.menuNm } 읽기" data="${menu.menuSeq }" role="${menu.parent.menuSeq }" <c:if test="${menu.menuRole.readYn eq 'Y' }">checked="checked"</c:if> /></td>
				<td><input type="checkbox" name="menuRoles[].writeYn" value="Y" class="writeYn" title="${menu.menuNm } 쓰기" data="${menu.menuSeq }" role="${menu.parent.menuSeq }" <c:if test="${menu.menuRole.writeYn eq 'Y' }">checked="checked"</c:if>/></td>
				<td><input type="checkbox" name="menuRoles[].actYn" value="Y" class="actYn" title="${menu.menuNm } 실행" data="${menu.menuSeq }" role="${menu.parent.menuSeq }" <c:if test="${menu.menuRole.actYn eq 'Y' }">checked="checked"</c:if>/></td>
			</tr>
			<c:forEach items="${menu.subMenuList }" var="secMenu">
				<tr>
					<td class="alignL" style="padding-left: 30px">
						<c:out value="${secMenu.menuNm }" />
						<input type="hidden" name="menuRoles[].menuSeq" value="${secMenu.menuSeq }" />
					</td>
					<td><input type="checkbox" name="menuRoles[].readYn" value="Y" class="readYn" title="${secMenu.menuNm } 읽기" data="${secMenu.menuSeq }" role="${secMenu.parent.menuSeq }" <c:if test="${secMenu.menuRole.readYn eq 'Y' }">checked="checked"</c:if> /></td>
					<td><input type="checkbox" name="menuRoles[].writeYn" value="Y" class="writeYn" title="${secMenu.menuNm } 쓰기" data="${secMenu.menuSeq }" role="${secMenu.parent.menuSeq }" <c:if test="${secMenu.menuRole.writeYn eq 'Y' }">checked="checked"</c:if>/></td>
					<td><input type="checkbox" name="menuRoles[].actYn" value="Y" class="actYn" title="${secMenu.menuNm } 실행" data="${secMenu.menuSeq }" role="${secMenu.parent.menuSeq }" <c:if test="${secMenu.menuRole.actYn eq 'Y' }">checked="checked"</c:if>/></td>
				</tr>
				<c:forEach items="${secMenu.subMenuList }" var="thirdMenu">
					<tr>
						<td class="alignL" style="padding-left: 60px">
							<c:out value="${thirdMenu.menuNm }" />
							<input type="hidden" name="menuRoles[].menuSeq" value="${thirdMenu.menuSeq }" />
						</td>
						<td><input type="checkbox" name="menuRoles[].readYn" value="Y" class="readYn" title="${thirdMenu.menuNm } 읽기" data="${thirdMenu.menuSeq }" role="${thirdMenu.parent.menuSeq }" <c:if test="${thirdMenu.menuRole.readYn eq 'Y' }">checked="checked"</c:if> /></td>
						<td><input type="checkbox" name="menuRoles[].writeYn" value="Y" class="writeYn" title="${thirdMenu.menuNm } 쓰기" data="${thirdMenu.menuSeq }" role="${thirdMenu.parent.menuSeq }" <c:if test="${thirdMenu.menuRole.writeYn eq 'Y' }">checked="checked"</c:if>/></td>
						<td><input type="checkbox" name="menuRoles[].actYn" value="Y" class="actYn" title="${thirdMenu.menuNm } 실행" data="${thirdMenu.menuSeq }" role="${thirdMenu.parent.menuSeq }" <c:if test="${thirdMenu.menuRole.actYn eq 'Y' }">checked="checked"</c:if>/></td>
					</tr>
					<c:forEach items="${thirdMenu.subMenuList }" var="fourMenu">
						<tr>
							<td class="alignL" style="padding-left: 90px">
								<c:out value="${fourMenu.menuNm }" />
								<input type="hidden" name="menuRoles[].menuSeq" value="${fourMenu.menuSeq }" />
							</td>
							<td><input type="checkbox" name="menuRoles[].readYn" value="Y" class="readYn" title="${fourMenu.menuNm } 읽기" data="${fourMenu.menuSeq }" role="${fourMenu.parent.menuSeq }" <c:if test="${fourMenu.menuRole.readYn eq 'Y' }">checked="checked"</c:if> /></td>
							<td><input type="checkbox" name="menuRoles[].writeYn" value="Y" class="writeYn" title="${fourMenu.menuNm } 쓰기" data="${fourMenu.menuSeq }" role="${fourMenu.parent.menuSeq }" <c:if test="${fourMenu.menuRole.writeYn eq 'Y' }">checked="checked"</c:if>/></td>
							<td><input type="checkbox" name="menuRoles[].actYn" value="Y" class="actYn" title="${fourMenu.menuNm } 실행" data="${fourMenu.menuSeq }" role="${fourMenu.parent.menuSeq }" <c:if test="${fourMenu.menuRole.actYn eq 'Y' }">checked="checked"</c:if>/></td>
						</tr>
					</c:forEach>
				</c:forEach>
			</c:forEach>
		</c:forEach>
		</tbody>
	</table>
	</div>
</div>
<menu:authorize>
<div class="box-footer clearfix">
	<div class="pull-right">
		<button type="button" class="btn btn-sm btn-function" onclick="jConfirm('해당 롤의 메뉴권한을 저장하시겠습니까?', doMenuSubmit);">저장</button>
	</div>
</div>
</menu:authorize>
</form>

<script type="text/javascript">
$(document).ready(function() {
	$(":input:checkbox").each(function() {
		$(this).on("change", doSelectChild);
	});

	<c:choose>
		<c:when test="${hasAuthWrite}">
			$(".readYn, .writeYn, .actYn").click(function(event) {
				event.stopPropagation();
			});

			$(".readYn, .writeYn, .actYn").parent().click(function(event){
				var $checkbox = $(this).children("input:checkbox");
				var checked = $checkbox.prop("checked");
				$checkbox.prop("checked", !checked);
			});
		</c:when>
		<c:otherwise>
			$(".readYn, .writeYn, .actYn").prop("disabled", true);
		</c:otherwise>
	</c:choose>




});

function doCheckAll(obj, clazz) {
	$("." + clazz).prop("checked", $(obj).prop("checked"));
}

function doSelectChild(e) {
	var parent = $(e.target).attr("data");
	var type = $(e.target).attr("class");
	var isChecked = $(e.target).prop("checked");

	$("input:checkbox[class='" + type + "'][role='" + parent + "']").each(function() {
		$(this).prop("checked", isChecked);
		$(this).trigger("change");
	});

}

function doMenuSubmit(result) {

	fn_form_rename("menuRoles","menuSeq,readYn,writeYn,actYn");

	var options = {
		type: 'post',
		dataType: 'json',
		success: successRoleMenuHandler,
		beforeSend : function() {
			$.ncmsLoding.startFullScreen();
		},
		complete : function() {
			$.ncmsLoding.remove();
		},
		error: function(xhr, textStatus, errorThrown){
			jAlert('오류 발생');
		}
	};

	$("#roleMenuFrm").ajaxSubmit(options);
}

function successRoleMenuHandler(result) {
	if( result.success) {
		jAlert("저장 완료 되었습니다.");
	}
}


</script>