<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>
 	부처관리 상세 조회
 </pre>
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 6.
 * @lastmodified 2016. 10. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 6.     최경철         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:url var="listUrl" value="selectInsttList.do">
	<c:forEach var="curParam" items="${param }">
 		<c:if test="${curParam.key ne 'institutionId'}">
			<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
 		</c:if>
	</c:forEach>
</c:url>

<!-- 등록/상세 영역 -->
<div class="col-box-100 detail-col">

	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">부처관리</h3>
		</div>
		<!-- /box-header -->
		<form id="insttFrm" name="insttFrm" method="post">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>부처 상세 정보 테이블</caption>
				<colgroup>
					<col class="col20">
					<col class="colAuto">
				</colgroup>
				<tbody>
					<tr>
						<th>부처ID</th>
						<td>
							<c:out value="${insttVo.institutionId}" />
							<input type="hidden" name="institutionId" value="${insttVo.institutionId}" />
						</td>
					</tr>
					<tr>
						<th>부처</th>
						<td>
							<c:out value="${insttVo.institutionNm }" />
							<input type="hidden" name="institutionNm" value="${insttVo.institutionNm}" />
						</td>
					</tr>
					<tr>
						<th>사용여부</th>
						<td>
							<div class="input-group input-group-radio">
							<c:choose>
								<c:when test="${insttVo.useYn ne null && insttVo.useYn eq 'Y'}">
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
				<button class="btn btn-hover-yellow" data-toggle="tooltip" data-original-title="수정" onclick="fn_updateInstt()">
					<i class="fa fa-eraser"></i>
				</button>
			</div>
		</menu:authorize>
	</div>
</div>

<script type="text/javascript">

function fn_updateInstt(){

	jConfirm('부처 사용여부를 변경 하시겠습니까? 부처 사용여부를 미사용으로 할 시 하위 업무들도 미사용으로 수정됩니다.', function(){

		if(!fn_form_validation("insttFrm")){
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

		$('#insttFrm').attr("action", "updateInstt.do");
		$('#insttFrm').ajaxSubmit(options);

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