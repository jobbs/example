<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     최경철         v1.0             최초생성
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

<!-- <section class="popup-content"> -->
<!-- 	<div class="row"> -->

		<div class="col-box-100">
			<div class="col-info server <c:choose><c:when test='${"02" eq vmVo.statGrpCd}'><c:out value="server-up"/></c:when><c:when test='${"01" eq vmVo.statGrpCd}'><c:out value="server-down"/></c:when><c:otherwise><c:out value="server-maintain"/></c:otherwise></c:choose>">
				<div class="col-info-body alignL">
					<div class="col-info-box alignL">
						<span class="label"></span>
						<h4 class="stat"><c:out value="${vmVo.statGrpCdNm}"/></h4>
						<menu:authorize>
							<button type="button" class="btn btn-sm btn-refresh" title="새로고침" onclick="fn_executeVmSync();">새로고침</button>
						</menu:authorize>
					</div>
					<div class="col-info-box alignR">
						<div class="col-info-btn">
							<menu:authorize>
								<button type="button" class="btn" title="중지" onclick="fn_executeVmShutdown();"><i class="fa fa-ban"></i><span>중지</span></button>
							</menu:authorize>
						</div>
					</div>
				</div>
			</div>
		</div>

		<form:form id="vmSnapVo" commandName="vmSnapVo">
		<c:set var="vmSnapVoClass" value="ncis.cpt.rsrc.com.vo.VmSnapVo"/>
		<c:set var="groupClass" value="ncis.cmn.validation.groups.UpdateProc"/>
			<div class="col-box-100">
				<!-- 수평형 테이블 -->
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">스냅샷정보</h3>
						<div class="box-tools">
							<div class="pull-right">
							</div>
						</div>
					</div>
					<div class="box-body no-padding">
						<form:hidden path="vmSeq" value="${vmVo.vmSeq}"/>
				  		<table class="table table-horizon">
				  		<caption>스냅샷 정보 테이블</caption>
							<colgroup>
								<col class="col20">
								<col class="colAuto">
							</colgroup>
							<tbody>
								<tr>
									<th><span class="text-red">*</span>스냅샷명</th>
									<td>
										<form:input path="snapshtNm" name="snapshtNm" title="스냅샷명" cssClass="form-control input-sm essential" value="${vmSnapVo.snapshtNm }" maxlength="${ivu.getMaxlength(vmSnapVoClass, 'snapshtNm', groupClass)}"/>
									</td>
								</tr>
								<tr>
									<th>비고</th>
									<td>
										<form:textarea path="rmk" name="rmk" title="비고" class="form-control" rows="3" maxlength="${ivu.getMaxlength(vmVoSnapClass, 'rmk', groupClass)}" placeholder="내용을 입력해 주세요." value="${vmSnapVo.rmk }"/>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</form:form>

		<div class="col-box-100">
			<div class="button">
				<button type="button" class="btn btn-dark" title="생성" onclick="fn_insertVmSnapCre()">생성</button>
				<button type="button" class="btn close-window" title="닫기" onclick="fn_close()">닫기</button>
			</div>
		</div>

<!-- 	</div> -->
<!-- </section> -->


<script type="text/javascript">

//창 닫기
function fn_close(){
	window.close();
}

function fn_insertVmSnapCre() {

	if(!fn_form_validation("vmSnapVo")){
		return;
	}
	jConfirm('스냅샷을 생성 하시겠습니까?', function(){


		var options = {
			type: 'post',
			dataType: 'json',
			success: insertVmSnapCreResultHandler,
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

		$('#vmSnapVo').attr('action', 'insertVmSnap.do');
		$('#vmSnapVo').ajaxSubmit(options);

	});
}

function fn_executeVmSync(){
	//jConfirm('가상서버 상태정보를 동기화 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: executeVmStatSyncResultHandler, /*vmSnapResultHandler,*/
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

		$('#vmSnapVo').attr('action', '<c:url value="selectExecVmStatSync.do"/>');
		$('#vmSnapVo').ajaxSubmit(options);

	//});
}

function fn_executeVmShutdown(){
	jConfirm('가상서버를 중지 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: vmSnapResultHandler,
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

		$('#vmSnapVo').attr('action', '<c:url value="executeVmShutdown.do"/>');
		$('#vmSnapVo').ajaxSubmit(options);

	});
}

function executeVmStatSyncResultHandler(result){
	if(result.success){
		fn_selectVmStatSync();
	}
	else{
		jAlert(result.messageList);
	}
}

function fn_selectVmStatSync() {
	var options = {
		type: 'post',
		dataType: 'json',
		success: selectVmStatSyncResultHandler,
		beforeSend: function() {
		},
		complete : function() {
		},
		error: function(xhr, textStatus, errorThrown){
			if(xhr.status === 0 || xhr.readyState === 0){
				return;
			}
			jAlert('오류가 발생하였습니다.');
		}
	};

	$('#vmVo').attr('action', '<c:url value="selectVmStatSync.do"/>');
	var form = $('#vmVo').ajaxSubmit(options);
	xhr = form.data('jqxhr');
}

function selectVmStatSyncResultHandler(result) {
	if(result.success){

		console.log( result.data );

		if(result.data && result.data.statGrpCd){

			var statGrpCd = result.data.statGrpCd;
			var vrlzSwTyCd = result.data.vrlzSwTyCd;
			var $container = $('div.server');

			var hasProcss = (result.data.vmProcssMsgVoList && result.data.vmProcssMsgVoList.length > 0);
			$container.find('.col-info-box.alignL .label').remove();
			switch(statGrpCd){
			case '01' : // 다운(OFF)
				$container.removeClass('server-up').removeClass('server-inprogress').removeClass('server-exception').addClass('server-down');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			case '02' : // 업(ON)
				$container.removeClass('server-down').removeClass('server-inprogress').removeClass('server-exception').addClass('server-up');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			case '03' : // 처리중
				$container.removeClass('server-up').removeClass('server-down').removeClass('server-exception').addClass('server-inprogress');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			case '04' : // 예외
				$container.removeClass('server-up').removeClass('server-down').removeClass('server-inprogress').addClass('server-exception');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			default : // 그외
				break;
			}


			if(statGrpCd === "03"){//처리중일때만 진행상태를 보여줌
				$container.find('.stat').html(result.data.statGrpCdNm + "(" + result.data.statCdNm+ ")");
			}else{
				$container.find('.stat').html(result.data.statGrpCdNm);
			}
		}
	}
}
function vmSnapResultHandler(result){

	if(result.success){
		jInfo(result.messageList, function(){
			location.reload();
		});
	}
	else{
		jAlert(result.messageList);
	}
}

function insertVmSnapCreResultHandler(result){

	if(result.success){
		jInfo(result.messageList, function(){
			opener.parent.fn_insertVmSnap_reload();
			window.close();

		});
	}
	else{
		jAlert(result.messageList);
	}
}

</script>