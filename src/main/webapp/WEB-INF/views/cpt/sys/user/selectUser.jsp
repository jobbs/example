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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>사용자 상세 정보 테이블</caption>
				<colgroup>
					<col class="col20">
					<col class="col30">
					<col class="col20">
					<col class="col30">
				</colgroup>
				<tbody>
				<tr>
					<th>사용자ID</th>
					<td><c:out value="${user.userId }" /></td>
					<th>사용자명</th>
					<td><c:out value="${user.userNm }" /></td>
				</tr>
				<tr>
					<th>부처</th>
					<td><c:out value="${user.institutionNm }" /></td>
					<th>조직</th>
					<td><c:out value="${user.orgnztNm }" /></td>
				</tr>
				<tr>
					<th>직위</th>
					<td><c:out value="${user.ofcpsNm }" /></td>
					<th>시스템권한유형</th>
					<td><c:out value="${user.sysAuthrTyId }" /></td>
				</tr>
				<tr>
					<th>전화번호(내선)</th>
					<td><c:choose>
							<c:when test="${user.telno eq null or user.telno eq '' }">&nbsp;</c:when>
							<c:otherwise><c:out value="${user.telno }" />(<c:out value="${user.lxtnNo }" />)</c:otherwise>
						</c:choose></td>
					<th>핸드폰</th>
					<td><c:out value="${user.mobile }" /></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td colspan="3"><c:out value="${user.email }" /></td>
					<%-- <th>상태</th>
					<td><c:out value="${user.userStat }" /></td> --%>
				</tr>
				<tr>
					<th>관리센터</th>
					<td><c:out value="${user.mngRegionNm }" /></td>
					<th>사용자구분</th>
					<td><c:out value="${user.userClNm }" /></td>
				</tr>
				<tr>
					<th>권한</th>
					<td colspan="3"><c:out value="${user.roleNm }" /></td>
				</tr>
				<tr>
					<th>nTOPS 최근접속일시</th>
					<td><fmt:formatDate value="${user.rcntLoginDttm }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<th>nCMS 최근접속일시</th>
					<td><fmt:formatDate value="${user.ncmsRcntLoginDttm }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="col-box-100 search-col">
	<div class="nav-tabs-custom">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#tapRole" data-toggle="tab">사용자롤</a></li>
			<li><a href="#tapInstt" data-toggle="tab">부처권한</a></li>
			<li><a href="#tapWork" data-toggle="tab">업무권한</a></li>
			<li><a href="#tapManager" data-toggle="tab">자원풀권한</a></li>
		</ul><!-- /nav-tabs -->
		<div class="tab-content">
			<div class="tab-pane active" id="tapRole">롤 목록 DIV</div>
			<div class="tab-pane" id="tapInstt">부처목록 DIV</div>
			<div class="tab-pane" id="tapWork">업무목록 DIV</div>
			<div class="tab-pane" id="tapManager">매니저 목록 DIV</div>
		</div>
	</div>
</div>


<!-- 페이지 버튼 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<c:url var="updateUrl" value="updateUser.do">
			<c:forEach var="curParam" items="${param }">
				<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
			</c:forEach>
		</c:url>
		<c:url var="listUrl" value="selectUserList.do">
			<c:forEach var="curParam" items="${param }">
				<c:if test="${curParam.key ne 'userId'}">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:if>
			</c:forEach>
		</c:url>

		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
		</div>

		<menu:authorize>
			<div class="pull-right">
				<c:if test="${ user.sysInptYn eq 'Y'}">
					<button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="수정" onclick="goToUrl('${updateUrl}')"><i class="fa fa-eraser"></i></button>
					<button class="btn btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="doDelete()"><i class="fa fa-times"></i></button>
				</c:if>
			</div>
		</menu:authorize>
	</div>
</div>
<!-- /페이지 버튼 -->

<script type="text/javascript">

function doDelete(){
	jConfirm("사용자 정보를 삭제하시겠습니까?", function() {
		$.post("deleteUser.do", {"userId": "${user.userId}" }, function(result) {
			alert_message(result.messageList, function() {
				if( result.success) {
					goToUrl('${listUrl}');
				}
			});

		}, "json");
	});
}

//Role 검색 선택시 처리할 이벤트 핸들러
$(document).bind('selectRoleMulti',setRoles);
function setRoles(evt) {
	var formData = [];
	var roles = evt.roles;

	$.each(roles, function(index) {
		formData.push({ name : "userRoles[" + index + "].roleCd", value : this.roleCd });
	});
	formData.push({ name : "userId", value : "<c:out value="${user.userId }" />" });

	//로딩바 시작
	$.ncmsLoding.startFullScreen();
 	$.post("<c:url value="insertUserRole.do" />",
				formData,
				function(result) {
					alert_message(result.message, function() {
						if( result.success ) {
							getRole();
							getInstt();
							getPool();
							getJob();
						}
					});

				},
				"json"
			).always(function() {
				//로딩바 종료
				$.ncmsLoding.remove();
			});
}

//Institution 검색 선택시 처리할 이벤트 핸들러
$(document).bind('selectInstitutionMulti',setInstts);
function setInstts(evt) {
	console.log("test");
	var formData = [];
	$.each(evt.datas, function(index) {
		formData.push({ name : "userInstts[" + index + "].institutionId", value : this.institutionId });
		formData.push({ name : "userInstts[" + index + "].userId", value : "<c:out value="${user.userId }" />" });
	});
	formData.push({ name : "userId", value : "<c:out value="${user.userId }" />" });

	//로딩바 시작
	$.ncmsLoding.startFullScreen();
 	$.post("<c:url value="insertUserInstt.do" />",
				formData,
				function(result) {
					alert_message(result.message, function() {
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
}

//Role 검색 선택시 처리할 이벤트 핸들러
$(document).bind('selectJobMulti',setJobs);
function setJobs(evt) {
	var formData = [];
	$.each(evt.datas, function(index) {
		formData.push({ name : "userJobs[" + index + "].jobId", value : this.jobId });
		formData.push({ name : "userJobs[" + index + "].userId", value : "<c:out value="${user.userId }" />" });
	});
	formData.push({ name : "userId", value : "<c:out value="${user.userId }" />" });

	//로딩바 시작
	$.ncmsLoding.startFullScreen();
	$.post("<c:url value="insertUserJob.do" />",
			formData,
			function(result) {
				alert_message(result.message, function() {
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
}

//Role 검색 선택시 처리할 이벤트 핸들러
$(document).bind('selectPoolMulti',setPools);

function setPools(evt) {

	var formData = [];

	$.each(evt.datas, function(index) {
		formData.push({ name : "userPools[" + index + "].rsrcPoolId", value : this.rsrcPoolId });
		formData.push({ name : "userPools[" + index + "].regionId", value : this.regionId });
		formData.push({ name : "userPools[" + index + "].userId", value : "<c:out value="${user.userId }" />" });
	});
	formData.push({ name : "userId", value : "<c:out value="${user.userId }" />" });

	//로딩바 시작
	$.ncmsLoding.startFullScreen();
	$.post("<c:url value="insertUserPool.do" />",
			formData,
			function(result) {
				alert_message(result.message, function() {
					if( result.success ) {
						getPool();
					}
				});
			},
			"json"
		).always(function() {
			//로딩바 종료
			$.ncmsLoding.remove();
		});
}

function getRole() {
	$("#tapRole").load("<c:url value="selectUserRoleList.do" />?userId=<c:out value="${user.userId }" />");
}

function getInstt() {
	$("#tapInstt").load("<c:url value="selectUserInsttList.do" />?userId=<c:out value="${user.userId }" />");
}

function getJob() {
	$("#tapWork").load("<c:url value="selectUserJobList.do" />?userId=<c:out value="${user.userId }" />");
}

function getPool() {
	$("#tapManager").load("<c:url value="selectUserPoolList.do" />?userId=<c:out value="${user.userId }" />");
}



//최초 상세 페이지 접근시 탭목록 초기화
getRole();
getInstt();
getJob();
getPool();
</script>