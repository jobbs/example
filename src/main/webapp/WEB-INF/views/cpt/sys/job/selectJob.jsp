<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>부처업무관리 상세조회</pre>
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 25.
 * @lastmodified 2016. 10. 25.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 25.     박봉춘         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>


<script type="text/javascript"
	src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>

<c:url var="listUrl" value="selectJobList.do">
	<c:forEach var="curParam" items="${param }">
 		<c:if test="${curParam.key ne 'jobId'}">
			<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
 		</c:if>
	</c:forEach>
</c:url>

<!-- 등록/상세 영역 -->
<div class="col-box-100 detail-col">

	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">부처업무관리</h3>
		</div>
		<!-- /box-header -->
		<form id="jobFrm" name="jobFrm" method="post">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>부처업무 상세 테이블</caption>
				<colgroup>
					<col class="col20">
					<col class="colAuto">
				</colgroup>
				<tbody>
					<tr>
						<th>센터</th>
						<td>
							<c:out value="${jobVo.regionNm}" />
							<input type="hidden" name="regionId" value="${jobVo.regionId}" />
						</td>
					</tr>
					<tr>
						<th>부처업무ID</th>
						<td>
							<c:out value="${jobVo.jobId}" />
							<input type="hidden" name="jobId" value="${jobVo.jobId}" />
						</td>
					</tr>
					<tr>
						<th>부처업무</th>
						<td>
							<c:out value="${jobVo.jobNm }" />
							<input type="hidden" name="jobNm" value="${jobVo.jobNm}" />
						</td>
					</tr>
					<tr>
						<th>사용여부</th>
						<td>
							<div class="input-group input-group-radio">
								<c:choose>
									<c:when test="${jobVo.useYn ne null && jobVo.useYn eq 'Y'}">
										<input type="radio" id="use1" name="useYn" value="Y" checked="checked" /><label for="use1">사용</label>
										<input type="radio" id="use2" name="useYn" value="N" /><label for="use2">미사용</label>
									</c:when>
									<c:otherwise>
										<input type="radio" id="use1" name="useYn" value="Y" /><label for="use1">사용</label>
										<input type="radio" id="use2" name="useYn" value="N" checked="checked" /><label for="use2">미사용</label>
									</c:otherwise>
							</c:choose>
							</div>

						</td>
					</tr>

				</tbody>
			</table>
		</div>
		</form>

	</div>

</div>

<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')">
				<i class="fa fa-arrow-left"></i>
			</button>
		</div>
		<menu:authorize>
			<div class="pull-right btns">
				<button class="btn btn-hover-yellow" data-toggle="tooltip" data-original-title="수정" onclick="fn_updateJob()">
					<i class="fa fa-eraser"></i>
				</button>
			</div>
		</menu:authorize>
	</div>
</div>

<script type="text/javascript">

function fn_updateJob(){

	jConfirm('부처 업무 정보를 변경 하시겠습니까?', function(){

		if(!fn_form_validation("jobFrm")){
			return;
		}

		var options = {
			type: 'post',
			dataType: 'json',
			success: fn_successHandler,
			beforeSend : function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				jAlert('정보저장 중 오류 발생');
			}
		};

		$('#jobFrm').attr("action", "updateJob.do");
		$('#jobFrm').ajaxSubmit(options);

	});
}

function fn_successHandler(result) {
	if( result.success) {
		goToUrl('${listUrl}');
	}
	else{
		jAlert(result.messageList);
	}

}
</script>