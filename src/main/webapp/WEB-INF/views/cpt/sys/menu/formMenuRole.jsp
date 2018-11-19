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


<div class="col-box-100">
	<div class="info">
		<h2>알려드립니다.</h2>
		<p>- 하단 정보를 확인해 주세요.</p>
		<p>- 확인하신 정보가 맞으시면 선택을 눌러주세요.</p>
	</div>
</div>

<form:form commandName="vo">
<form:hidden path="menuSeq" />
<div class="col-box-100">
	<div class="box">
		<div class="box-body no-padding">

			<table class="table table-vertical table-hover">
				<caption>메뉴 롤 정보 등록 테이블</caption>
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
						<tr><td colspan="3">등록된 권한 데이터가 없습니다.</td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="role" items="${vo.menuRoleList }" varStatus="ri">
						<tr>
							<td>
								<form:hidden path="menuRoleList[${ri.index }].roleCd"/>
								<c:out value="${role.roleNm }" />
							</td>
							<td><form:checkbox path="menuRoleList[${ri.index }].readYn" value="Y" title="${role.roleNm } 읽기권한"/></td>
							<td><form:checkbox path="menuRoleList[${ri.index }].writeYn" value="Y" title="${role.roleNm } 쓰기권한"/></td>
							<td><form:checkbox path="menuRoleList[${ri.index }].actYn" value="Y" title="${role.roleNm } 실행권한" /></td>
						</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
		</div>
		<div class="box-footer clearfix">
			<div class="pull-right">
				<button type="button" class="btn btn-sm btn-function" onclick="jConfirm('해당 메뉴에 권한을 부여 하시겠습니까?', doSubmit)">저장</button>
			</div>
		</div><!-- /box-footer -->

	</div>
</div>
</form:form>

<script type="text/javascript">
function doSubmit(){
	$.ncmsLoding.startFullScreen();
	$.post('insertMenuRole.do', $('#vo').serialize(), handler_openerreloadclose, 'json').always(function() {
		$.ncmsLoding.remove();
	});
}
</script>