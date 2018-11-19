<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>사전배포 상세 화면</pre>
 *
 * @author x
 * @lastmodifier x
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     x         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>


<div class="col-box-100">
	<div class="col-info server <c:choose>
									<c:when test='${"01" eq preDistrbVo.distrbStatCd}'><c:out value="server-inprogress"/></c:when>
									<c:when test='${"02" eq preDistrbVo.distrbStatCd}'><c:out value="server-up"/></c:when>
									<c:when test='${"03" eq preDistrbVo.distrbStatCd}'><c:out value="server-exception"/></c:when>
									<c:when test='${"04" eq preDistrbVo.distrbStatCd}'><c:out value="server-maintain"/></c:when>
									<c:otherwise></c:otherwise></c:choose>">
		<div class="col-info-body alignL">
			<div class="col-info-box alignL">
				<span class="label"></span>
				<h4 class="stat"><c:out value="${preDistrbVo.distrbStatNm}"/></h4>
				<c:if test='${"01" eq preDistrbVo.distrbStatCd}'>
					<span class="alignR" id="maxLimit"></span>
				</c:if>
			</div>
		</div>
	</div>
</div>

<div class="col-box-100 detail-col">
	<form:form commandName="preDistrbVo">
	<form:hidden path="servcAreaId" title="서비스영역ID" />
	<form:hidden path="servcAreaSeq" title="서비스영역Seq"/>
	<form:hidden path="demonSetId" title="데몬SetID"/>
	<form:hidden path="regionId" title="센터ID"/>
	<form:hidden path="zoneId" title="존ID"/>
	<form:hidden path="netClCd" title="망구분코드"/>
	<form:hidden path="rsrcPoolId" title="자원풀ID"/>
	<form:hidden path="preDistrbReqSeq" title="사전배포요청SEQ"/>
	<form:hidden path="imgRepoDtlAddr" title="이미지 상세주소"/>
	<form:hidden path="distrbStatCd" title="사전배포코드"/>

	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">사전배포 상세 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
	  		<table class="table table-horizon">
	  		<caption>사전 배포 상세정보 테이블</caption>
				<colgroup>
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
				</colgroup>
				<tbody>
					<tr>
						<th>센터</th>
						<td><c:out value="${preDistrbVo.regionNm }" /></td>
						<th>존</th>
						<td><c:out value="${preDistrbVo.zoneNm }" /></td>
						<th>망구분</th>
						<td><c:out value="${preDistrbVo.netNm }" /></td>

					</tr>
					<tr>
						<th>자원풀</th>
						<td><c:out value="${preDistrbVo.rsrcPoolNm }" /></td>
						<th>서비스영역명</th>
						<td><c:out value="${preDistrbVo.servcAreaNm }" /></td>
						<th>서비스명</th>
						<td><c:out value="${preDistrbVo.servcNm }" /></td>

					</tr>
					<tr>
						<th>이미지명</th>
						<td><c:out value="${preDistrbVo.imgNm}" /></td>
						<th>이미지 버전</th>
						<td><c:out value="${preDistrbVo.imgVer }" /></td>
						<th>배포자</th>
						<td><c:out value="${preDistrbVo.distrbReqUserNm }" /></td>
					</tr>
					<tr>
						<th>배포요청일시</th>
						<td><c:out value="${preDistrbVo.distrbReqDttm }" /></td>
						<th>배포완료일시</th>
						<td colspan="2"><c:out value="${preDistrbVo.distrbComptDttm }" /></td>
					</tr>
					<tr>
						<th>이미지 경로</th>
						<td colspan="5"><c:out value="${preDistrbVo.imgRepoDtlAddr }" /></td>
					</tr>
					<tr>
			            <th>비고</th>
			            <td colspan="5">
			            	<form:hidden path="rmk" name="rmk" title="비고" value="${preDistrbVo.rmk }"/>
			             	<textarea id="textareaRmk" title="비고" Class="form-control" rows="3" maxlength="1000" placeholder="내용을 입력해 주세요."><c:out value="${preDistrbVo.rmk }"/></textarea>
			            </td>
		         	</tr>
				</tbody>
			</table>
		</div>
	</div>
	</form:form>
</div>

<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" data-original-title="뒤로" onclick="fn_selectPreDistrbList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<c:if test="${'Y' eq preDistrbVo.ctlTrgtYn }">
				<menu:authorize>
						<button class="btn btn-sm btn-hover-green" data-toggle="tooltip"  data-original-title="재배포"  onclick="fn_reInsertPreDistrb();"><i class="fa fa-play-circle"></i></button>
				</menu:authorize>
			</c:if>
		</div>
	</div>
</div>

<script type="text/javascript">

	var tat = "";
$(function() {
	var stat = $("#distrbStatCd").val();
	if(stat == '01') {
 		setInterval(function(){ fn_selectPreDistrbStat(); }, 30*1000);
 		tat = setInterval(function(){ fn_timeLt(); }, 1000);
 	}
});

function fn_selectPreDistrbStat(){

	var options = {
			type: 'get',
			dataType: 'json',
			success: selectPreDistrbStatResultHandler,
			beforeSend: function() {
				/* $.ncmsLoding.startFullScreen(); */
			},
			complete : function() {
				/* $.ncmsLoding.remove(); */
			},
			error: function(xhr, textStatus, errorThrown){
				jAlert('오류가 발생하였습니다.');
			}
		};
 	$('#preDistrbVo').attr('action', '<c:url value="selectPreDistrbStat.do"/>');
	$('#preDistrbVo').ajaxSubmit(options);
}
function selectPreDistrbStatResultHandler(result){
	if(result.success){
		if(result.procType == "update") {
			if(result.data && result.data.distrbStatCd){

				var distrbStatCd = result.data.distrbStatCd;
				var $container = $('div.server');

/* 				$container.find('.col-info-box.alignL .label').remove(); */
				switch(distrbStatCd){
				case '01' : // 진행중(INPROGRESS)
					/* $container.removeClass('server-exception').removeClass('server-up').addClass('server-inprogress');
					$container.find('.stat').before('<span class="label"></span>'); */
					break;
				case '02' : // 완료(UP)
					location.reload();
					fn_deletePreDistrb();
					break;
				case '03' : // 오류(EXCEPTION)
					 location.reload();
					/* $container.removeClass('server-up').removeClass('server-inprogress').addClass('server-exception');
					$container.find('.stat').before('<span class="label"></span>');
					$container.find('.stat').html( result.data.distrbStatNm); */
					break;
				default : // 그외
					break;
				}
			}
		}
	}
	else{
		jAlert(result.messageList);
	}
}
//뒤로
function fn_selectPreDistrbList(){
	location.href = '<c:url value="selectPreDistrbList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'preDistrbReqSeq' && pageParam.key ne 'servcAreaSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}
//재배포 버튼 클릭 시
function fn_reInsertPreDistrb(){

	if(!fn_form_validation("preDistrbVo")){
		return;
	}
	$('#rmk').val($('#textareaRmk').val());

	jConfirm('재배포 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: reInsertPreDistrbResultHandler,
			beforeSend: function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				jAlert('오류가 발생하였습니다.');
			}
		};

		$('#preDistrbVo').attr('action', '<c:url value="reInsertPreDistrb.do"/>');
		$('#preDistrbVo').ajaxSubmit(options);

	});
}

//저장 결과 콜백
function reInsertPreDistrbResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		if(result.procType == "update") {
			location.reload();
		}
	}
	else{
		alert_message(result.messageList)
	}
}


//완료시
function fn_deletePreDistrb(){

	if(!fn_form_validation("preDistrbVo")){
		return;
	}
	$('#rmk').val($('#textareaRmk').val());


		var options = {
			type: 'post',
			dataType: 'json',
			success: deletePreDistrbResultHandler,
			beforeSend: function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				jAlert('오류가 발생하였습니다.');
			}
		};

		$('#preDistrbVo').attr('action', '<c:url value="deletePreDistrb.do"/>');
		$('#preDistrbVo').ajaxSubmit(options);

}
//저장 결과 콜백
function deletePreDistrbResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		if(result.procType == "delete") {
			location.reload();
		}
	}
	else{
		alert_message(result.messageList)
	}
}

function fn_timeLt(){
	var data = '${preDistrbVo.distrbReqDttm }';
	var d = data.replace(" ","T");
	d = d+"+09:00";
	data = d;
	var nwDate = new Date();
	var stDate = new Date(data);
	var lastDay = (new Date(nwDate.getFullYear(),nwDate.getMonth(),0)).getDate();

	var interval = nwDate.getTime() - stDate.getTime();
	var sec = Math.floor(interval / 1000);
	var day = Math.floor(sec/3600/24);
	if(sec < 60 && sec > 0){
		if(sec < 10){
			$("#maxLimit").text("경과 시간 : 00분 0"+sec+"초");
		}else{
			$("#maxLimit").text("경과 시간 : 00분 "+sec+"초");
		}
	}else if(sec < 3600){

		var secMin = Math.floor(sec%3600/60);
		if(secMin < 3){
			sec = "경과 시간 : 0"+Math.floor(sec%3600/60)+"분 "+sec%60+"초";
		}else{

			sec = "경과 시간 : 03분 00초";
			clearInterval(tat);
			fn_timeStat();
		// 	var options = {
		//			type: 'post',
		//			dataType: 'json',
		//			success: delPreDistrbStatResultHandler,
		//			beforeSend: function() {
						/* $.ncmsLoding.startFullScreen(); */
		//			},
		//			complete : function() {
		//				/* $.ncmsLoding.remove(); */
		//			},
		//			error: function(xhr, textStatus, errorThrown){
		//				jAlert('오류가 발생하였습니다.');
		//			}
		//		};
		// 	$('#preDistrbVo').attr('action', '<c:url value="deletePreDistrb.do"/>');
		//	$('#preDistrbVo').ajaxSubmit(options);
//			sec = "경과 시간 : "+Math.floor(sec%3600/60)+"분"+sec%60+"초";
		}
		$("#maxLimit").text(sec);
	}
	/* else{
		sec = "경과 시간 : 03분 00초 초과";
		$("#maxLimit").text(sec);
	} */
}
//저장 결과 콜백
function delPreDistrbStatResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		if(result.procType == "delete") {
			var options = {
					type: 'post',
					dataType: 'json',
					success: deletePreDistrbResultHandler,
					beforeSend: function() {
						/* $.ncmsLoding.startFullScreen(); */
					},
					complete : function() {
						/* $.ncmsLoding.remove(); */
					},
					error: function(xhr, textStatus, errorThrown){
						jAlert('오류가 발생하였습니다.');
					}
				};
		 	$('#preDistrbVo').attr('action', '<c:url value="updateLmtPreDistrb.do"/>');
			$('#preDistrbVo').ajaxSubmit(options);
		}
	}
	else{
		alert_message(result.messageList)
	}
}
function fn_timeStat(){

	var options = {
			type: 'get',
			dataType: 'json',
			success: selectTimeStatResultHandler,
			beforeSend: function() {
				/* $.ncmsLoding.startFullScreen(); */
			},
			complete : function() {
				/* $.ncmsLoding.remove(); */
			},
			error: function(xhr, textStatus, errorThrown){
				jAlert('오류가 발생하였습니다.');
			}
		};
 	$('#preDistrbVo').attr('action', '<c:url value="selectPreDistrbStat.do"/>');
	$('#preDistrbVo').ajaxSubmit(options);
}

function selectTimeStatResultHandler(result){
	if(result.success){
		if(result.procType == "update") {
			if(result.data && result.data.distrbStatCd){

				var distrbStatCd = result.data.distrbStatCd;

				if('02' == distrbStatCd){
					location.reload();
				}else{
					var options = {
							type: 'post',
							dataType: 'json',
							success: delPreDistrbStatResultHandler,
							beforeSend: function() {
								/* $.ncmsLoding.startFullScreen(); */
							},
							complete : function() {
								/* $.ncmsLoding.remove(); */
							},
							error: function(xhr, textStatus, errorThrown){
								jAlert('오류가 발생하였습니다.');
							}
						};
				 	$('#preDistrbVo').attr('action', '<c:url value="deletePreDistrb.do"/>');
					$('#preDistrbVo').ajaxSubmit(options);
				}
			}
		}
	}
	else{
		jAlert(result.messageList);
	}
}
</script>
