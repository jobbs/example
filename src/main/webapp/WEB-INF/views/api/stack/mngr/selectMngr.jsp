<!--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 정승용
 * @lastmodifier 정승용
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * 		Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.      정승용         	v1.0                   최초생성
 *
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<script type="text/javascript" src="<c:url value="/resources/js/common/FileUtils.js" />" charset="UTF-8"></script>

<form:form commandName="mngrVo" enctype="multipart/form-data">
<!-- 매니저 위치 -->
<div class="col-box-100 detail-col">
	<form:hidden path="stackMngrId" value="${mngrVo._id}" />
	<form:hidden path="rev" value="${mngrVo._rev}" />
	<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
	<!-- box(목록조회 테이블) -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">위치</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>위치</caption>
				<colgroup>
					<col class="col20">
					<col class="col30">
					<col class="col20">
					<col class="col30">
				</colgroup>
				<tbody>
					<tr>
						<th><label for="regionId"><span class="text-red">*</span>센터</label></th>
						<td>
							<form:hidden path="regionId" />
							<c:out value="${mngrVo.regionNm}" />
						</td>
						<th><label for="zoneId"><span class="text-red">*</span>존</label></th>
						<td>
							<form:hidden path="zoneId" />
							<c:out value="${mngrVo.zoneNm}" />
						</td>
					</tr>
					<tr>
						<th><label for="netId"><span class="text-red">*</span>망</label></th>
						<td>
							<form:hidden path="netId" />
							<c:out value="${mngrVo.netNm}" />
						</td>
						<th></th>
						<td></td>
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
</div>
<!-- 매니저 종류 -->
<div class="col-box-100 detail-col">
	<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
	<!-- box(목록조회 테이블) -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">종류</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>종류</caption>
				<colgroup>
					<col class="col20">
					<col class="col30">
					<col class="col20">
					<col class="col30">
				</colgroup>
				<tbody>
					<tr>
						<th><label for="stackClCd"><span class="text-red">*</span>스택 분류</label></th>
						<td>
							<form:hidden path="stackClCd" />
							<c:out value="${mngrVo.stackClNm}" />
						</td>
						<th><label for="mngrClCd"><span class="text-red">*</span>매니저 분류</label></th>
						<td>
							<form:hidden path="mngrClCd" />
							<c:out value="${mngrVo.mngrClNm}" />
						</td>
					</tr>
					<tr>
						<th><label for="mngrNm"><span class="text-red">*</span>매니저 명</label></th>
						<td>
							<form:input path="mngrNm" title="매니저명" type="text" class="form-control essential" maxlength="60" />
						</td>
						<th><label for="mngrVerCd"><span class="text-red">*</span>매니저 버전</label></th>
						<td>
							<form:hidden path="mngrVerCd" />
							<c:out value="${mngrVo.mngrVerNm}" />
						</td>
					</tr>
					<tr>
						<th><label for="nowVerCd"><span class="text-red">*</span>현재 버전</label></th>
						<td>
							<nform:selectCode parentCd="${mngrVo.mngrClCd}" parentGrpCd="039"
								name="nowVerCd" id="nowVerCd" title="현재 버전"
								whole="true" value="${mngrVo.nowVerCd}"
								cssClass="form-control essential"
								wholeText="선택"
								onchange="" />
						</td>
						<th><label for="apiVerCd"><span class="text-red">*</span>API 버전</label></th>
						<td>
							<nform:selectCode parentCd="${mngrVo.mngrClCd}" parentGrpCd="039"
								name="apiVerCd" id="apiVerCd" title="API 버전"
								whole="true" value="${mngrVo.apiVerCd}"
								cssClass="form-control essential"
								wholeText="선택"
								onchange="" />
						</td>
					</tr>
					<tr>
						<th><label for="hostAddr"><span class="text-red">*</span>Host</label></th>
						<td colspan="3"><form:input path="hostAddr" type="text" class="form-control" maxlength="60" /></td>
					</tr>
					<tr>
						<th><label for="hostAddr2">Host2</label></th>
						<td colspan="3"><form:input path="hostAddr2" type="text" class="form-control" maxlength="60" /></td>
					</tr>
					<tr>
						<th><label for="authenticate">Authenticate</label></th>
						<td colspan="3"><form:input path="authenticate" type="text" class="form-control" maxlength="60" /></td>
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
</div>
<!-- 매니저 인정정보 -->
<div class="col-box-100 detail-col">
	<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
	<!-- box(목록조회 테이블) -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">인증정보</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>인증정보</caption>
				<colgroup>
					<col class="col20">
					<col class="col30">
					<col class="col20">
					<col class="col30">
				</colgroup>
				<tbody>
					<tr>
						<th><label for="mngrId"><span class="text-red">*</span>매니저ID</label></th>
						<td>
							<form:input path="mngrId"
								title="매니저ID" type="text"
								class="form-control essential"
								maxlength="60" autocomplete="off" />
						</td>
						<th><label for="mngrPw"><span class="text-red">*</span>비밀번호</label></th>
						<td>
							<form:input path="mngrPw"
								title="비밀번호" type="password"
								class="form-control essential"
								maxlength="60" autocomplete="off" />
						</td>
					</tr>
					<tr>
						<th><label for="file-1">인증서</label></th>
						<td>
							<div class="file-form">
								<div class="file-form-field input-group">
									<input disabled="disabled" class="form-control file-name"
										type="text" title="파일선택" placeholder="파일선택" value="${mngrVo.atchFileName}">
									<p class="input-group-btn">
										<label class="file-label btn" for="file-1">찾아보기</label>
									</p>
									<input name="uploadFile" class="form-control file-hidden" id="file-1" type="file">
									<script>
										$(function() {
											var fileTarget = $("#file-1");

											fileTarget.change(function() {
												if (window.FileReader) {
													var fileName = $(this)[0].files[0].name;
												} else {
													var fileName = $(this).val().split("/").pop().split("\\").pop();
												}
												fileTarget.siblings(".file-name").val(fileName);
											});
										});
									</script>
								</div>
							</div>
						</td>
						<th><label for="passwdChk"><span class="text-red">*</span>비밀번호확인</label></th>
						<td><form:input path="passwdChk" title="비밀번호확인" type="password" class="form-control essential" maxlength="60" />
						</td>
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
</div>
<!-- 매니저 기타 -->
<div class="col-box-100 detail-col">
	<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
	<!-- box(목록조회 테이블) -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">기타</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>기타</caption>
				<colgroup>
					<col class="col20">
					<col class="col30">
					<col class="col20">
					<col class="col30">
				</colgroup>
				<tbody>
					<tr>
						<th>등록자</th>
						<td><c:out value="${mngrVo.regUserNm }" /></td>
						<th>등록일</th>
						<td><c:out value="${mngrVo.regDt }" /></td>
					</tr>
					<tr id="virtlCnsle">
					</tr>
					<tr>
						<th><label for="monitoringYN"><span class="text-red">*</span>수집여부</label></th>
						<td colspan="3">
							<form:radiobutton path="monitoringYN" value="Y" label="모니터링 동작" /> &nbsp; &nbsp; &nbsp;
							<form:radiobutton path="monitoringYN" value="N" label="모니터링 중지" />
						</td>
					</tr>
					<tr>
						<th><label for="dc">설명</label></th>
						<td colspan="3"><form:textarea path="dc" title="설명" class="form-control" rows="3" maxlength="4000" /></td>
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
</div>
</form:form>
<div class="col-box-100 detail-col">
	<!-- page-btn-group -->
	<div class="edit-btn-group">
		<c:url var="listUrl" value="selectMngrList.do">
			<c:forEach var="curParam" items="${param}">
				<c:if test="${curParam.key ne 'stackMngrId'}">
					<c:param name="${curParam.key}" value="${curParam.value}"></c:param>
				</c:if>
			</c:forEach>
		</c:url>

		<div class="pull-left btns">
			<button type="button" class="btn btn-hover-gray" data-toggle="tooltip" data-original-title="뒤로"
				onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i>
			</button>
		</div>
		<div class="pull-right btns">
			<menu:authorize>
			<button type="button" class="btn btn-hover-green" data-toggle="tooltip" data-original-title="저장"
				onclick="fn_updateMngr();"><i class="fa fa-check"></i>
			</button>
			<button type="button" class="btn btn-hover-red" data-toggle="tooltip" data-original-title="삭제"
				onclick="jConfirm('매니저정보를 삭제하시겠습니까?', fn_deleteMngr)"><i class="fa fa-times"></i>
			</button>
			</menu:authorize>
		</div>
	</div>
	<!-- /page-btn-group -->
</div>

<script type="text/javascript">
$(document).ready(function() {
	if("${mngrVo.stackClCd eq 'COM'}" == "true"){
		var html = ''
			+ '	<th><label for="virtlCnsleAccesIp">가상콘솔접근IP</label></th>'
			+ '	<td>'
			+ '		<input type="text" name="virtlCnsleAccesIp" title="가상콘솔접근IP" class="form-control" maxlength="60" value="${mngrVo.virtlCnsleAccesIp}"/>'
			+ '	</td>'
			+ '	<th><label for="virtlCnsleAccesPort">가상콘솔접근PORT</label></th>'
			+ '	<td>'
			+ '		<input type="text" id="virtlCnsleAccesPort" name="virtlCnsleAccesPort" title="가상콘솔접근PORT" class="form-control" onblur="fn_onlyNumber(this)" maxlength="60" value="${mngrVo.virtlCnsleAccesPort}"/>'
			+ '	</td>' + '';

		$('#virtlCnsle').append(html);
	}
});

// 매니저관리 수정 처리
function fn_updateMngr() {
	if (!fn_form_validation("mngrVo")) {
		return;
	}

	if ($("#mngrPw").val() != $("#passwdChk").val()) {
		parent.jAlert("비밀번호와 비밀번호확인이 일치하지 않습니다.");
		return;
	}

	jConfirm('매니저정보를 수정하시겠습니까?', function(){
		var options = {
			type : 'post',
			dataType : 'json',
			url : '<c:url value="/api/stack/mngr/updateMngr.do" />',
			success : fn_pageMove,
			beforeSend : function() {
			    $.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error : function(xhr, textStatus, errorThrown) {
				alert('오류 발생');
			}
		};

		$('#mngrVo').ajaxSubmit(options);
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

// 매니저관리 삭제 처리
function fn_deleteMngr() {
	$.ncmsLoding.startFullScreen();
	$.post('deleteMngr.do', $('#mngrVo').serialize(), fn_pageMove2, 'json')
			.always(function() {
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

//숫자만 입력가능
function fn_onlyNumber(obj) {
	val = obj.value;
	regOnlyNumber = /[^\d]/gi;
	if (regOnlyNumber.test(val))
		jAlert($('#virtlCnsleAccesPort').attr('title') + " : 숫자만 입력가능합니다.");
	obj.value = val.replace(regOnlyNumber, "");
}
</script>