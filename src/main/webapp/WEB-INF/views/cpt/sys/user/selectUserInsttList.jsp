<!--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 11. 30.
 * @lastmodified 2016. 11. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 30.     박봉춘         v1.0             최초생성
 *
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<div class="box">
<c:choose>	<c:when test="${list eq null or empty list }"></c:when>
			<c:otherwise>총 ${list.size() } 건</c:otherwise></c:choose>
	<div class="box-body no-padding">
		<table class="table table-vertical" id="userInsTable">
			<caption>사용자 부처 목록 테이블</caption>
			<colgroup>
				<col class="col10">
				<col class="col20">
				<col class="colAuto">
				<menu:authorize>
				<col class="col10">
				</menu:authorize>
			</colgroup>
			<thead>
			<tr>
				<th>No</th>
				<th>부처ID</th>
				<th>부처</th>
				<menu:authorize>
				<th></th>
				</menu:authorize>
			</tr>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${list eq null or empty list }">
					<tr>
						<td colspan="4">권한을 가진 부처가 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="instt" items="${list }" varStatus="i">
			          <tr>
			          	<td><c:out value="${i.index +1 }" /></td>
			          	<td><c:out value="${instt.institutionId }" /></td>
			          	<td class="alignL"><c:out value="${instt.institutionNm }" /></td>
			          	<menu:authorize>
			          	<td><button class="btn btn-default btn-sm" onclick="doDeleteInstt('<c:out value="${instt.institutionId }" />')">삭제</button></td>
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
		<c:if test="${isUserRole ne false }">
			<div class="pull-right">
				<button class="btn btn-sm btn-function" onclick="openInsttMultiSearch()">부처등록</button>
			</div>
		</c:if>
	</div>

	<script type="text/javascript" src="<c:url value="/resources/js/common/component/popup.js" />"></script>
	<script type="text/javascript">
	function doDeleteInstt(institutionId) {
		var confirmText = "해당 사용자의 부처를 삭제 하실 경우 업무에 대한 권한도 자동 삭제 됩니다.<br /><br />해당 사용자의 부처를 삭제하시겠습니까?";

		jConfirm(confirmText, function(result) {

			//로딩바 시작
			$.ncmsLoding.startFullScreen();

			$.post("<c:url value="deleteUserInstt.do" />",
					{"institutionId" : institutionId, "userId" : "<c:out value="${userId }" />" },
					function(result) {
						alert_message(result.messageList, function() {
							if( result.success ) {
								getInstt();
								getJob();
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

	$("#userInsTable").DataTable( {
		dom: 'Zlfrtip',
		aoColumns : [
		               {sWidth : "80px" }, //NO
		               {sWidth : "100px" }, //기관명
		               {sWidth : "100px" }, //기관 ID
		               {sWidth : "80px" },  //버튼
		],
		order : []
	} );
	</script>
	</menu:authorize>
</div>