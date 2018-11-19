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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<div class="box">
	<div class="box-body no-padding">
		<table class="table table-vertical">
			<caption>사용자 권한 목록 테이블</caption>
			<colgroup>
				<col class="col30">
				<col class="colAuto">
				<menu:authorize>
				<col class="col10">
				</menu:authorize>
			</colgroup>
			<thead>
			<tr>
				<th>권한코드</th>
				<th>권한명</th>
				<menu:authorize>
				<th></th>
				</menu:authorize>
			</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${list eq null or empty list }">
						<tr>
							<td colspan="3">설정된 권한이 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="role" items="${list }" varStatus="i">
				          <tr>
				          	<td class="alignL"><c:out value="${role.roleCd }" /></td>
				          	<td class="alignL"><c:out value="${role.roleNm }" /></td>
				          	<menu:authorize>
				          	<td><button class="btn btn-default btn-sm" onclick="doDeleteRole('<c:out value="${role.roleCd }" />','<c:out value="${role.roleTyCd }" />')">삭제</button></td>
				          	</menu:authorize>
				          </tr>
				        </c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	<menu:authorize>
	<div class="box-footer clearfix">
		<div class="pull-right">
			<button class="btn btn-sm btn-function" onclick="openRoleMultiSearch()">권한등록</button>
		</div>
	</div>

	<script type="text/javascript">
	function doDeleteRole(roleCd, roleTyCd) {

		var confirmText = "";
		if( roleTyCd == "OPRADM") {
			confirmText = "해당 사용자의 권한을 삭제 하실 경우 운영자이기 때문에 자원풀의 권한도 자동 삭제 됩니다.<br /><br />해당 사용자의 권한을 삭제하시겠습니까?";
		} else if( roleTyCd == "OPRCHR") {
			confirmText = "해당 사용자의 권한을 삭제 하실 경우 담당자이기 때문에 업무에 대한 권한도 자동 삭제 됩니다.<br /><br />해당 사용자의 권한을 삭제하시겠습니까?";
		} else {
			confirmText = "해당 사용자의 권한을 삭제하시겠습니까?";
		}

		jConfirm(confirmText, function(result) {

			//로딩바 시작
			$.ncmsLoding.startFullScreen();
			$.post("<c:url value="deleteUserRole.do" />",
					{"roleCd" : roleCd, "roleTyCd" : roleTyCd, "userId" : "<c:out value="${userId }" />" },
					function(result) {
						alert_message(result.messageList, function() {
							if( result.success ) {
								getRole();
								if( roleTyCd == "OPRADM" ) {
									getPool();
								} else if( roleTyCd == "OPRCHR") {
									getJob();
									getInstt();
								}
							}
						});

					},
					"json"
				).always(function() {
					//로딩바 종료
					$.ncmsLoding.remove();
				});

		});
	}
	</script>
	</menu:authorize>
</div>