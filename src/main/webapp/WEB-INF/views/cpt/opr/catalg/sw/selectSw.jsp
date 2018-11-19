<!--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2017. 1. 11.
 * @lastmodified 2017. 1. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 1. 11.     이화영         v1.0             최초생성
 *
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-box-100 detail-col">
	<div class="box detail-list-box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>기본정보</caption>
	    		<colgroup>
					<col class="col30">
					<col class="col70">
				</colgroup>
				<tbody>
	  			<tr>
	    			<th>소프트웨어 명</th>
	    			<td><c:out value="${swVo.swNm}"/></td>
	    		</tr>
	    		<tr>
					<th>소프트웨어 버전</th>
					<td><c:out value="${swVo.swVer}"/></td>
				</tr>
				<tr>
					<th>소프트웨어 제조사</th>
					<td><c:out value="${swVo.swMnfctCo}"/></td>
				</tr>
				<tr>
					<th>비고</th>
					<td>${cf:nl2br(swVo.rmk ) }</td>
				</tr>
				<tr>
					<th>등록자</th>
					<td><c:out value="${swVo.creUserNm}"/></td>
				</tr>
				<tr>
					<th>등록일시</th>
					<td><fmt:formatDate value="${swVo.creDttm }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				<c:if test="${null ne swVo.updtUserId}">
					<tr>
						<th>수정자</th>
						<td><c:out value="${swVo.updtUserNm}"/></td>
					</tr>
					<tr>
						<th>수정일시</th>
						<td><fmt:formatDate value="${swVo.updtDttm }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</c:if>
	    		</tbody>
	  		</table>
		</div><!-- /box-body -->
    </div>

</div><!-- /col -->

<div class="col-box-100">
	<div class="edit-btn-group">

		<c:url var="updateUrl" value="updateSw.do">
			<c:forEach var="curParam" items="${param }">
				<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
			</c:forEach>
		</c:url>
		<c:url var="listUrl" value="selectSwList.do">
			<c:forEach var="curParam" items="${param }">
				<c:if test="${curParam.key ne 'swSeq'}">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:if>
			</c:forEach>
		</c:url>
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
		</div>

		<menu:authorize>
			<div class="pull-right">
				<button class="btn btn-hover-yellow" data-toggle="tooltip" data-original-title="수정" onclick="goToUrl('${updateUrl}')"><i class="fa fa-eraser"></i></button>
				<button class="btn btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="doDelete()"><i class="fa fa-times"></i></button>
			</div>
		</menu:authorize>
	</div>
</div>


<script type="text/javascript">

function doDelete(){

	jConfirm("소프트웨어를 삭제하시겠습니까?", function() {

		//로딩바 시작
		$.ncmsLoding.startFullScreen();
		$.post("deleteSw.do", {"swSeq": ${swVo.swSeq}}, function(result) {

			alert_message(result.messageList, function() {
				if( result.success) {
					goToUrl('${listUrl}');
				}
			});

		}, "json").always(function() {
			//로딩바 종료
			$.ncmsLoding.remove();
		});
	});

}
</script>