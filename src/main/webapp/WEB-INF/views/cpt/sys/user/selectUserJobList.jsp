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
<c:choose>	<c:when test="${list eq null or empty list }"></c:when>
			<c:otherwise>총 ${list.size() } 건</c:otherwise></c:choose>
	<div class="box-body no-padding">
		<table class="table table-vertical" id="userJobTable">
			<caption>사용자 부처업무 목록 테이블</caption>
			<colgroup>
				<col class="col10">
				<col class="col20">
				<col class="col20">
				<col class="colAuto">
				<col class="col20">
				<menu:authorize>
				<col class="col10">
				</menu:authorize>
			</colgroup>
			<thead>
			<tr>
				<th>No</th>
				<th>기관명</th>
				<th>기관 ID</th>
				<th>업무명</th>
				<th>업무 ID</th>
				<menu:authorize>
				<th></th>
				</menu:authorize>
			</tr>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${list eq null or empty list }">
					<tr>
						<td colspan="5">권한을 가진 업무가 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="job" items="${list }" varStatus="i">
			          <tr>
			          	<td><c:out value="${i.index +1 }" /></td>
			          	<td class="alignL"><c:out value="${job.institutionNm }" /></td>
			          	<td class="alignL"><c:out value="${job.institutionId }" /></td>
			          	<td class="alignL"><c:out value="${job.jobNm }" /></td>
			          	<td class="alignL"><c:out value="${job.jobId }" /></td>
			          	<menu:authorize>
			          	<td><button class="btn btn-default btn-sm" onclick="doDeleteJob('<c:out value="${job.jobId }" />')">삭제</button></td>
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
				<button class="btn btn-sm btn-function" onclick="openJobMultiSearch()">업무등록</button>
			</div>
		</c:if>
	</div>

	<script type="text/javascript" src="<c:url value="/resources/js/common/component/popup.js" />"></script>
	<script type="text/javascript">
	function doDeleteJob(jobId) {
		jConfirm("사용자의 업무권한을 삭제하시겠습니까?", function(result) {

			//로딩바 시작
			$.ncmsLoding.startFullScreen();

			$.post("<c:url value="deleteUserJob.do" />",
					{"jobId" : jobId, "userId" : "<c:out value="${userId }" />" },
					function(result) {
						alert_message(result.messageList, function() {
							if( result.success ) {
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

	$("#userJobTable").DataTable( {
		dom: 'Zlfrtip',
		aoColumns : [
		               {sWidth : "80px" }, //NO
		               {sWidth : "100px" }, //기관명
		               {sWidth : "100px" }, //기관 ID
		               {sWidth : "200px" }, //업무명
		               {sWidth : "100px" }, //업무 ID
		               {sWidth : "80px" },  //버튼

		],
		order : []
	} );

	</script>
	</menu:authorize>
</div>

