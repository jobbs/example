<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     박희택         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<div class="col-box-100 detail-col">
	<form:form commandName="openApiVo">
		<form:hidden path="opApiId" value="${openApiVo._id}" />
		<form:hidden path="rev" value="${openApiVo._rev}" />
		<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
		<!-- box(목록조회 테이블) -->
		<div class="box">

			<div class="box-body no-padding">
				<table class="table table-horizon">
					<caption>OpenAPI관리</caption>
					<colgroup>
						<col class="col20">
						<col class="col30">
						<col class="col20">
						<col class="col30">
					</colgroup>
					<tbody>
						<tr>
							<th>작성자</th>
							<td><c:out value="${openApiVo.regUserNm }" /></td>
							<th><label for="regionId"><span class="text-red">*</span>센터</label></th>
							<td>
								<nform:selectRegion path="regionId"
									name="regionId"
									id="regionId"
									title="센터"
									wholeText="선택"
									value="${openApiVo.regionId}"
									cssClass="form-control essential"
									byRole="false" />
							</td>
						</tr>
						<tr>
							<th><label for="opApiNm"><span class="text-red">*</span>OpenAPI명</label></th>
							<td>
								<form:input path="opApiNm" title="OpenAPI명" type="text" class="form-control essential" maxlength="60" />
							</td>
							<th><span class="text-red">*</span>상태</th>
							<td>
								<div class="input-group input-group-radio">
									<form:radiobutton path="statCd" name="statCd" cssClass="essential" title="상태" label="활성" value="Y" />
									<form:radiobutton path="statCd" name="statCd" cssClass="essential" title="상태" label="비활성" value="N" />
								</div>
							</td>
						</tr>
						<tr>
							<th><label for="uri"><span class="text-red">*</span>URI</label></th>
							<td>
								<form:input path="uri" type="text" title="URI" class="form-control essential" maxlength="60" onblur="fn_onlyAlpha(this)"/>
							</td>
							<th><span class="text-red">*</span>서비스Discovery사용여부</th>
							<td>
								<div class="input-group input-group-radio">
									<form:radiobutton path="svcDscvryYn" name="svcDscvryYn" cssClass="essential" title="서비스Discovery사용여부" label="사용" value="Y" />
									<form:radiobutton path="svcDscvryYn" name="svcDscvryYn" cssClass="essential" title="서비스Discovery사용여부" label="미사용" value="N" />
								</div>
							</td>
						</tr>
						<tr>
							<th><label for="targetHstAddr"><span class="text-red">*</span>Target</label></th>
							<td colspan="3">
								<form:input path="targetHstAddr" title="Target" type="text" class="form-control essential" maxlength="60" />
							</td>
						</tr>
						<tr>
							<th><label for="dc">설명</label></th>
							<td colspan="3"><form:textarea path="dc" title="설명" class="form-control" rows="3" maxlength="4000"/></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- /box-body -->
			<div class="box-footer clearfix">
				<div class="pull-right"></div>
			</div>
			<!-- /box-footer -->
		</div>
		<!-- /box -->
	</form:form>
</div>
<div class="col-box-100 detail-col">
	<!-- page-btn-group -->
	<div class="edit-btn-group">
		<c:url var="listUrl" value="selectOpenApiList.do">
			<c:forEach var="curParam" items="${param}">
				<c:if test="${curParam.key ne 'opApiId'}">
					<c:param name="${curParam.key}" value="${curParam.value}"></c:param>
				</c:if>
			</c:forEach>
		</c:url>

		<div class="pull-left btns">
			<button class="btn btn-hover-gray" data-toggle="tooltip" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
		<menu:authorize>
			<button type="button" class="btn btn-hover-green" data-toggle="tooltip" data-original-title="저장" onclick="fn_updateOpenApi();"><i class="fa fa-check"></i></button>
			<button type="button" class="btn btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="jConfirm('OpenApi를 삭제하시겠습니까?', fn_deleteOpenApi)"><i class="fa fa-times"></i></button>
		</menu:authorize>
		</div>
	</div>
	<!-- /page-btn-group -->
</div>

<script type="text/javascript">
// OpenApi수정 처리
function fn_updateOpenApi() {
	if (!fn_form_validation("openApiVo")) {
		return;
	}

	jConfirm('OpenApi를 수정하시겠습니까?', function(){
		$.ncmsLoding.startFullScreen();
		$.post('updateOpenApi.do', $('#openApiVo').serialize(), fn_pageMove, 'json').always(function() {
			$.ncmsLoding.remove();
		});
	});
}

// 콜백 / 화면이동
function fn_pageMove(result) {
	alert_message(result.messageList, function() {
		if (result.success) {
			if (result.procType == "update") {
				goToUrl('${listUrl}');
			}
		}
	}, (result.success ? "INFO" : ""));
}

// OpenApi삭제 처리
function fn_deleteOpenApi() {
	$.ncmsLoding.startFullScreen();
	$.post('deleteOpenApi.do', $('#openApiVo').serialize(), fn_pageMove2, 'json').always(function() {
		$.ncmsLoding.remove();
	});
}

// 콜백 / 화면이동
function fn_pageMove2(result) {
	alert_message(result.messageList, function() {
		if (result.success) {
			if (result.procType == "delete") {
				goToUrl('${listUrl}');
			}
		}
	}, (result.success ? "INFO" : ""));
}

//영문, 숫자, '/', '_' 입력
function fn_onlyAlpha(obj) {
	val = obj.value;
	regOnlyAlpha = /[^a-zA-Z0-9\/\_]/gi;	//check=/[ㄱ-ㅎ|ㅏ-ㅣ|가-힝]/; 한글만 체크할 때(특수문자도 필요하면 이걸로 체크)
	if (regOnlyAlpha.test(val))
		jAlert($('#uri').attr('title') + " : 영문, 숫자, '/', '_'만 입력가능합니다.");
	obj.value = val.replace(regOnlyAlpha, "");
}
</script>