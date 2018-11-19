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
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:url var="updateUrl" value="updateMenu.do"></c:url>

<c:url var="insertMenuRoleUrl" value="insertMenuRole.do">
 	<c:param name="menuSeq" value="${vo.menuSeq }"></c:param>
</c:url>

<c:url var="copyMenuRoleUrl" value="updateCopyMenuRole.do">
 	<c:param name="menuSeq" value="${vo.menuSeq }"></c:param>
</c:url>
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
		<div class="box-header">
			<h3 class="box-title">메뉴정보</h3>
		</div><!-- /box-header -->

		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>메뉴 정보 테이블</caption>
				<colgroup>
					<col class="col20">
					<col class="colAuto">
				</colgroup>
				<tbody>
				<tr>
					<th>메뉴명</th>
					<td><c:out value="${vo.menuNm }" /></td>
				</tr>
				<tr>
					<th>메뉴패턴</th>
					<td><c:out value="${vo.menuPattern }" /></td>
				</tr>
				<tr>
					<th>실행파일</th>
					<td><c:out value="${vo.menuFile }" /></td>
				</tr>
				<tr>
					<th>메뉴설명</th>
					<td><c:out value="${vo.menuDesc }" /></td>
				</tr>
				<tr>
					<th>사용여부</th>
					<td><spring:message code="message.common.label.use.${vo.useYn }" /></td>
				</tr>
				<tr>
					<th>팝업여부</th>
					<td><spring:message code="message.common.label.use.${vo.popupYn }" /></td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="search-col">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">권한목록</h3>
			</div><!-- /box-header -->

			<div class="box-body no-padding">
				<table class="table table-vertical">
					<caption>권한 목록 테이블</caption>
					<colgroup>
						<col class="col25">
						<col class="col25">
						<col class="col25">
						<col class="col25">
					</colgroup>
					<thead>
					<tr>
						<th>권한명</th>
						<th>읽기권한</th>
						<th>쓰기권한</th>
						<th>실행권한</th>
					</tr>
					</thead>
					<tbody>
					<c:choose>
						<c:when test="${ vo.menuRoleList eq null or empty vo.menuRoleList }">
							<tr><td colspan="4">검색된 데이터가 없습니다.</td></tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="role" items="${vo.menuRoleList }" varStatus="ri">
							<tr>
								<td><c:out value="${role.roleNm }" /></td>
								<td><c:if test="${role.readYn eq 'Y' }">■</c:if></td>
								<td><c:if test="${role.writeYn eq 'Y' }">■</c:if></td>
								<td><c:if test="${role.actYn eq 'Y' }">■</c:if></td>
							</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<menu:authorize>
	<div class="btns">
		<div class="btn-group pull-right">
			<button type="button" class="btn" onclick='doUpdateForm(<c:out value="${vo.menuSeq}" />)'>메뉴수정</button>
			<button type="button" class="btn btn-red" onclick='doDelete(<c:out value="${vo.menuSeq}" />)'>메뉴삭제</button>
			<button type="button" class="btn" onclick="popup('${insertMenuRoleUrl}','insertMenuRole',800)">권한수정</button>
			<button type="button" class="btn" onclick="popup('${copyMenuRoleUrl}','copyMenuRole',800)">권한복제</button>
		</div>
	</div>
	</menu:authorize>
</div>

<menu:authorize>
<script type="text/javascript">

function doUpdateForm(menuSeq) {
	var url = '${updateUrl}';

	$.ncmsLoding.start($('.tree_content_area'));
	$.get(url,{'menuSeq':menuSeq}, loadSuccessHandler,'html');
}

function doDelete(menuSeq){

	if( $("#tree").dynatree("getActiveNode").data.children != null &&
			$("#tree").dynatree("getActiveNode").data.children.length > 0 ) {

		jAlert("하위메뉴가 존재합니다. \n\n하위메뉴를 먼저 삭제하여 주시기 바랍니다.");
		return;
	}

	jConfirm("메뉴를 삭제하시겠습니까?", function() {
		var url = "<c:url value="deleteMenu.do" />";

		$.ncmsLoding.startFullScreen();
		$.post(url, {"menuSeq": menuSeq}, submitSuccessHandler, "json").always(function() {
			$.ncmsLoding.remove();
		});
	});
}
</script>
</menu:authorize>