<!--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 정승용
 * @lastmodifier 정승용
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         	author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     정승용         	  v1.0             	최초생성
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
							<nform:selectRegion path="regionId"
								name="regionId"	id="regionId" title="센터"
								cssClass="form-control essential"
								onchange="selectZoneDy(this, 'zoneId', {'byRole' : false})"
								wholeText="선택"
								byRole="false" />
						</td>
						<th><label for="zoneId"><span class="text-red">*</span>존</label></th>
						<td>
							<nform:selectZone path="zoneId"
								name="zoneId" id="zoneId" title="존"
								cssClass="form-control essential"
								regionId="${searchVo.searchRegionCd}"
								byRole="false"
								wholeText="선택"
								onchange="selectNetDy(this, 'netId', {'byRole' : false})" />
						</td>
					</tr>
					<tr>
						<th><label for="netId"><span class="text-red">*</span>망</label></th>
						<td>
							<nform:selectNet path="netId"
								name="netId" id="netId" title="망"
								cssClass="form-control essential"
								zoneId="${searchVo.searchZoneCd}"
								wholeText="선택"
								byRole="false" />
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
						<th><label for="stackClCd"><span class="text-red">*</span>스택분류</label></th>
						<td>
							<nform:selectCode parentCd="201" parentGrpCd="039"
								name="stackClCd" id="stackClCd" title="스택분류"
								whole="true" value="${searchVo.searchStackClCd}"
								cssClass="form-control essential"
								wholeText="선택"
								onchange="selectboxDy('039', this,'mngrClCd',false)" />
						</td>
						<th><label for="mngrClCd"><span class="text-red">*</span>매니저분류</label></th>
						<td>
							<form:select path="mngrClCd"
								title="매니저분류" class="form-control essential"
								onchange="selectboxThreeDy('039', this,'mngrVerCd','apiVerCd','nowVerCd',false)">
								<form:option value="">선택</form:option>
							</form:select>
						</td>
					</tr>
					<tr>
						<th><label for="mngrNm"><span class="text-red">*</span>매니저명</label></th>
						<td>
							<form:input path="mngrNm" title="매니저명" type="text"
								class="form-control essential" maxlength="60" />
						</td>
						<th><label for="mngrVerCd"><span class="text-red">*</span>매니저버전</label></th>
						<td>
							<form:select path="mngrVerCd"
								title="매니저버전" class="form-control essential">
								<form:option value="">선택</form:option>
							</form:select>
						</td>
					</tr>
					<tr>
						<th><label for="nowVerCd"><span class="text-red">*</span>현재버전</label></th>
						<td>
							<form:select path="nowVerCd"
								title="현재버전" class="form-control essential">
								<form:option value="">선택</form:option>
							</form:select>
						</td>
						<th><label for="apiVerCd"><span class="text-red">*</span>API버전</label></th>
						<td>
							<form:select path="apiVerCd"
								title="API버전" class="form-control essential">
								<form:option value="">선택</form:option>
							</form:select>
						</td>
					</tr>
					<tr>
						<th><label for="hostAddr"><span class="text-red">*</span>Host</label></th>
						<td colspan="3"><form:input path="hostAddr" title="Host" id="hostAddr"
								type="text" class="form-control essential" maxlength="60" /></td>
					</tr>
					<tr>
						<th><label for="hostAddr2">Host2</label></th>
						<td colspan="3"><form:input path="hostAddr2" title="Host2" id="hostAddr2"
								type="text" class="form-control" maxlength="60" /></td>
					</tr>
					<tr>
						<th><label for="authenticate">Authenticate</label></th>
						<td colspan="3"><form:input path="authenticate" title="Authenticate" id="authenticate"
								type="text" class="form-control" maxlength="60" /></td>
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
<!-- 매니저 인증정보 -->
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
						<th><label for="atchFile">인증서</label></th>
						<td>
							<div class="file-form" id="fileSigleDiv"></div>
							<script type="text/javascript">
								$("#fileSigleDiv").createSelectboxFile({multiType : 'single'});
							</script>
						</td>
						<th><label for="passwdChk"><span class="text-red">*</span>비밀번호확인</label></th>
						<td>
							<form:input path="passwdChk" title="비밀번호확인" type="password" class="form-control essential" maxlength="60" />
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
						<td colspan="3">
							<form:textarea id="dc" path="dc" class="form-control" rows="3" maxlength="4000" />
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
</form:form>
<div class="col-box-100 detail-col">
	<!-- page-btn-group -->
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button type="button" class="btn btn-hover-gray" data-toggle="tooltip"
				data-original-title="뒤로" onclick="goToUrl('selectMngrList.do')"><i class="fa fa-arrow-left"></i>
			</button>
		</div>
		<div class="pull-right btns">
			<button type="button" class="btn btn-hover-green" data-toggle="tooltip"
				data-original-title="저장" onclick="doSubmit();"><i class="fa fa-check"></i>
			</button>
		</div>
	</div>
	<!-- /page-btn-group -->
</div>

<script type="text/javascript">
$(document).ready(function() {
	var html = ''
		+ '	<th><label for="virtlCnsleAccesIp">가상콘솔접근IP</label></th>'
		+ '	<td>'
		+ '		<input type="text" name="virtlCnsleAccesIp" title="가상콘솔접근IP" class="form-control" maxlength="60"/>'
		+ '	</td>'
		+ '	<th><label for="virtlCnsleAccesPort">가상콘솔접근PORT</label></th>'
		+ '	<td>'
		+ '		<input type="text" id="virtlCnsleAccesPort" name="virtlCnsleAccesPort" title="가상콘솔접근PORT" class="form-control" onblur="fn_onlyNumber(this)" maxlength="60"/>'
		+ '	</td>' + '';

	$("#stackClCd").change(function(){
		if ($("#stackClCd option:selected").val() == "COM"){
			$('#virtlCnsle').append(html);
		} else {
			$("#virtlCnsle").children().remove();
		}
	});
});

//저장
function doSubmit(result) {
	if (!fn_form_validation("mngrVo")) {
		return;
	}

	if ($("#mngrPw").val() != $("#passwdChk").val()) {
		parent.jAlert("비밀번호와 비밀번호확인이 일치하지 않습니다.");
		return;
	}

	jConfirm('매니저정보를 저장하시겠습니까?', function(){
		var options = {
			type : 'post',
			dataType : 'json',
			url : '<c:url value="/api/stack/mngr/insertMngr.do" />',
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
			if (result.procType == "insert") {
				location.href = "<c:url value='selectMngrList.do'/>";
			}
		}
	}, (result.success ? "INFO" : ""));
}

// 숫자만 입력가능
function fn_onlyNumber(obj) {
	val = obj.value;
	regOnlyNumber = /[^\d]/gi;
	if (regOnlyNumber.test(val))
		jAlert($('#virtlCnsleAccesPort').attr('title') + " : 숫자만 입력가능합니다.");
	obj.value = val.replace(regOnlyNumber, "");
}
</script>