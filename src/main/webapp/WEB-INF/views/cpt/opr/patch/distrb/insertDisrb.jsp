<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 21.
 * @lastmodified 2016. 10. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 21.     이화영         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<script type="text/javascript" src="<c:url value="/resources/js/common/validation.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/FileUtils.js" />" charset="UTF-8"></script>

<div class="col-box-100 detail-col">
	<form:form commandName="distrbVo" enctype="multipart/form-data">
		<div class="box detail-list-box">
			<div class="box-header">
				<h3 class="box-title">배포 기본정보</h3>
			</div>
			<!-- /box-header -->
			<div class="box-body no-padding">
				<table class="table table-horizon">
					<caption>배포 기본정보</caption>
					<colgroup>
						<col class="col25">
						<col class="col25">
						<col class="col25">
						<col class="col25">
					</colgroup>
					<tbody>
						<tr>
							<th><span class="text-red">*</span>티켓번호</th>
							<td><form:input path="ticketId" cssClass="form-control essential" value="" title="티켓번호" maxlength="20" /></td>
							<th>배포사유</th>
							<td>
								<form:select path="distrbReasnCd" title="배포사유" cssClass="form-control input-sm">
									<c:forEach var="distrbReasnCd" items="${patchAlrmTyCdList }">
										<form:option value="${distrbReasnCd.cd}"><c:out value="${distrbReasnCd.cdNm }" /></form:option>
									</c:forEach>
								</form:select>
							</td>
						</tr>
						<tr>
							<th><span class="text-red">*</span>배포경로</th>
							<td colspan="3">
								<div class="input-group-box full">
									<form:input path="distrbPath" cssClass="form-control" value="" title="배포경로" disabled="true" maxlength="1000" />
									<div class="input-group-cell pad-right-5 fix-cell">
										<div class="input-group input-group-check">
											<input type="checkbox" id="distrbPathCheck" name="distrbPathCheck" onclick="fn_distrbPath()" /><label for="distrbPathCheck">직접입력</label>
										</div>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<th><span class="text-red">*</span>배포내용</th>
							<td colspan="3">
								<form:textarea path="rmk" cssClass="form-control essential" title="배포내용" rows="5" maxlength="1000" />
							</td>
						</tr>
						<tr>
							<th><span class="text-red">*</span>파일첨부</th>
							<td colspan="3">
								<div class="file-form" id="fileSigleDiv"></div>
								<script type="text/javascript">
									$("#fileSigleDiv").createSelectboxFile({multiType : 'single' } );
								</script>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<!--box-body no-padding  -->
		</div>
		<!--box  -->

		<div class="box detail-list-box">
			<div class="box-header">
				<h3 class="box-title">대상 가상서버</h3>
				<div class="box-tools">
					<div class="input-group-box">
						<div class="input-group-cell pad-right">
							<button type="button" class="btn btn-sm btn-function" onclick="fn_selectDistrVmListP()">추가</button>
						</div>
					</div>
				</div>
				<!--box-tools  -->
				<div class="box-body no-padding">
					<input type="hidden" id="vmCnt" value="${distrbVo.distrVmList.size() }" />
					<table class="table table-vertical" id="distrVmList">
						<caption>대상 가상서버 목록</caption>
						<colgroup>
							<col class="colAuto">
							<col class="colAuto">
							<col class="colAuto">
							<col class="colAuto">
							<col class="colAuto">
							<col class="colAuto">
							<col class="colAuto">
							<col class="colAuto">
						</colgroup>
						<thead>
							<tr>
								<th>센터</th>
								<th>존</th>
								<th>망구분</th>
								<th>가상화SW</th>
								<th>가상서버구성ID</th>
								<th>가상서버명</th>
								<th>생성일자</th>
								<th><span class="text-red">*</span>비밀번호</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
				<!--box-body no-padding  -->
			</div>
			<!--box  -->
		</div>
	</form:form>
</div>

<div class="col-box-100">
	<div class="edit-btn-group">
		<c:url var="listUrl" value="selectDistrbList.do">
			<c:forEach var="curParam" items="${param }">
				<c:if test="${curParam.key ne 'distrbSeq'}">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:if>
			</c:forEach>
		</c:url>
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize>
				<button type="button" class="btn btn-hover-green" data-toggle="tooltip" title="" data-original-title="배포" onclick="fn_insertDisrb();"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>

</div><!-- col-box-100 detail-col -->

<script type="text/javascript">

//가상서버 조회 파업 호출
function fn_selectDistrVmListP(){
	var url = 'selectDistrVmListPView.do';

	var width = 1280;
	var height = 720;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {width:width , height:height, posX : posX , posY : posY};
	windowOpen(url, "", args);
}

//가상서버 팝업창에서 전달받은 값 - 테이블 갱신
$(document).bind('distrVmList',setDistrVmList);
function setDistrVmList(datas) {
	// 삭제
	//$('#distrVmListTBody > tr').remove();

	// 추가
	$.each(datas, function() {

		var html = '<tr>'
		+ '	<td>'+ this.regionNm + '</td>'
		+ '	<td>'+ this.zoneNm + '</td>'
		+ '	<td>'+ this.netNm + '</td>'
		+ '	<td>'+ this.vrlzSwTyCdNm + '</td>'
		+ '	<td>'+ this.vmCompId + '</td>'
		+ '	<td class="alignL">'+ this.vmNm + '</td>'
		+ '	<td>'+ this.regDttm + '</td>'
		+ '	<td><input type="passWord" name="distrVmList[].passWd" class="essential form-control" title="비밀번호" value=""/></td>'
		+ ' <td>'
		+ '		<button type="button" class="btn btn-function" onclick="fn_deleteVm(this);"">삭제</button>'
		+ '		<input type="hidden" name="distrVmList[].vmSeq" class="distrVmListCss" value="' + this.vmSeq + '" />'
		+ '		<input type="hidden" name="distrVmList[].regionNm" value="' + this.regionNm + '" />'
		+ '		<input type="hidden" name="distrVmList[].regionId" value="' + this.regionId + '" />'
		+ '		<input type="hidden" name="distrVmList[].zoneNm" value="' + this.zoneNm + '" />'
		+ '		<input type="hidden" name="distrVmList[].zoneId" value="' + this.zoneId + '" />'
		+ '		<input type="hidden" name="distrVmList[].netNm" value="' + this.netNm + '" />'
		+ '		<input type="hidden" name="distrVmList[].netClCd" value="' + this.netClCd + '" />'
		+ '		<input type="hidden" name="distrVmList[].vrlzSwTyCdNm" value="' + this.vrlzSwTyCdNm + '" />'
		+ '		<input type="hidden" name="distrVmList[].vmCompId" value="' + this.vmCompId + '" />'
		+ '		<input type="hidden" name="distrVmList[].vmNm" value="' + this.vmNm + '" />'
		+ '		<input type="hidden" name="distrVmList[].regDttm" value="' + this.regDttm + '" />'
		+ '		<input type="hidden" name="distrVmList[].rsrcPoolId" value="' + this.rsrcPoolId + '" />'
		+ '		<input type="hidden" name="distrVmList[].rprsntIpAddr" value="' + this.rprsntIpAddr + '" />'
		+ '		<input type="hidden" name="distrVmList[].netId" value="' + this.netId + '" />'
		+ '		<input type="hidden" name="checkVmSeq" value="' + this.vmSeq + '" />'
		+ '</td>' + '</tr>';
		var bExists = false;
		var vmSeqC = this.vmSeq;

		$.each($('#distrVmList input:hidden[name="checkVmSeq"]'), function(index, item){
			if($(item).val() == vmSeqC){
				bExists = true;
				return false;
			}
		});

		if(!bExists){
			$("#distrVmList").append(html);
		}
		//vmCnt.value++;
	});

}

//선택된 가상서버 삭제
	function fn_deleteVm(obj){
		var rowCnt = obj.parentNode.parentNode.rowIndex;
		distrVmList.deleteRow(rowCnt);
		vmCnt.value--;
	}

//배포경로 input 제어
function fn_distrbPath(){
	if($('#distrbPathCheck').prop("checked")==true){
		$("#distrbPath").val("");
		$("#distrbPath").attr('disabled',false);
	}else{
		$("#distrbPath").val("");
		$('#distrbPath').val('${distrbVo.distrbPath}');
		$("#distrbPath").attr('disabled',true);
	}

}

function fn_insertDisrb(){
  	 if(!fn_form_validation("distrbVo")){
		return;
	}

 	if($('#distrbPathCheck').prop("checked")==true){
 		if($('#distrbPath').val()==''){
 			jAlert('배포경를 입력해주세요.');
 			return;
 		}
	}

	//if ( $("input:file").size() == 0 ) {
	if($('#atchFile').val()==''){
		jAlert("첨부파일을 등록해주세요.");
		return;
	}

	if ( $("input:hidden.distrVmListCss").size() == 0 ) {
		jAlert('대상 가상서버를 추가해주세요. ');
		return;
	}

	var vmAdd = [];
	var bool = true;
	$("input:hidden[name='checkVmSeq']").each(function() {
		vmAdd.push(this.value);
	});

	$.each(vmAdd, function(i){
		var str = this;
		$.each(vmAdd, function(j){
			if(str.toString() == this){
				if(i!=j){
					jAlert("중복된 가상서버가 있습니다.");
					vmAdd = [];
					bool = false;
					return false;
				}
			}
		});
	});


	if(bool){
	jConfirm('배포 정보를 배포 하시겠습니까?', function(){

			fn_form_rename("distrVmList", "passWd,vmSeq,regionNm,regionId,zoneNm,zoneId,netNm,netClCd,vrlzSwTyCdNm,vmCompId,vmNm,regDttm,rsrcPoolId,rprsntIpAddr,netId");

			var options = {
				type: 'post',
				dataType: 'json',
				success: insertDisrbResultHandler,
				beforeSend : function() {
					$.ncmsLoding.startFullScreen();
				},
				complete : function() {
					$.ncmsLoding.remove();
				},
				error: function(xhr, textStatus, errorThrown){
					jAlert('오류가 발생하였습니다.');
				}
			};

			$('#distrbVo').attr('action', 'insertDisrb.do');
			$('#distrbVo').ajaxSubmit(options);

		});
	}
}

function insertDisrbResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jAlert("배포정보가 배포되었습니다.", function(){
			location.href = "selectDistrbList.do";
		});
	}
	else{
		alert_message(result.messageList);
	}

}

</script>