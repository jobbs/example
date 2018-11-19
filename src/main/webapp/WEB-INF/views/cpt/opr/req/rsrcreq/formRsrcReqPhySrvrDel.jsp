<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *	자원요청 상세-물리서버 삭제
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 5.
 * @lastmodified 2016. 10. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 5.     김봉민         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<!--  물리서버 상태 표시  -->
<c:if test="${pmVo ne null }">
	<div class="col-box-100">
		<div class="col-info server <c:choose><c:when test='${"01" eq pmVo.statCd}'><c:out value="server-down"/></c:when>
											  <c:when test='${"02" eq pmVo.statCd}'><c:out value="server-up"/></c:when>
										      <c:when test='${"03" eq pmVo.statCd}'><c:out value="server-maintain"/></c:when>
										      <c:when test='${"05" eq pmVo.statCd}'><c:out value="server-exception"/></c:when>
										      <c:otherwise><c:out value="server-inprogress"/></c:otherwise> </c:choose>">
			<div class="col-info-body alignL">
				<div class="col-info-box alignL">
					<span class="label"></span>
					<h4 class="stat"><c:out value="${pmVo.statCdNm}"/></h4>
					<menu:authorize authType="act">
						<c:choose>
							<c:when test='${pmVo.delYn eq "N"}'>
								<button type="button" class="btn btn-sm btn-refresh vm-sync" title="새로고침" onclick="fn_execPM('S');" disabled="disabled">새로고침</button>
							</c:when>
							<c:otherwise>
								<span class='status  status-red'>삭제됨</span>
							</c:otherwise>
						</c:choose>
					</menu:authorize>
				</div>
				<div class="col-info-box alignR">
					<c:if test='${pmVo.delYn eq "N"}'>
						<div class="col-info-btn">
							<menu:authorize authType="act">
								<button type="button" class="btn vm-start" title="시작" onclick="fn_execPM('A');"
									<c:choose><c:when test='${"03" eq rrprVo.rsrcReqPrcssStatCd }'><c:out value="disabled"/></c:when>
									  		  <c:otherwise><c:if test='${"01" ne pmVo.statCd}'><c:out value="disabled"/></c:if></c:otherwise></c:choose>
									><i class="fa fa-play-circle"></i><span>시작</span></button>

								<button type="button" class="btn vm-shutdown" title="중지" onclick="fn_execPM('D');"
									<c:choose><c:when test='${"03" eq rrprVo.rsrcReqPrcssStatCd }'><c:out value="disabled"/></c:when>
							  		  		   <c:otherwise><c:if test='${"02" ne pmVo.statCd}'><c:out value="disabled"/></c:if></c:otherwise></c:choose>
									><i class="fa fa-ban" ></i><span>중지</span></button>
							</menu:authorize>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div><!--  /물리서버 상태 표시  -->
</c:if>

<form:form commandName="pmVo" id="pmFrm">
	<form:hidden path="pmSeq"/>
	<form:hidden path="statCd"/>
	<form:hidden path="statCdNm"/>
</form:form>

<!-- 페이지 컨텐츠 -->
<div class="col-box-100 detail-col">
	<%@ include file="selectRsrcReqInfo.jsp" %>
	<!-- /box -->

	<div class="box detail-list-box">
		<!--  box-header -->
		<div class="box-header">
			<h3 class="box-title">물리서버 삭제 정보</h3>
		</div>
			<!-- /box-header -->
		<div class="box-body no-padding">
			<c:if test="${rrprVo ne null}">
			<form:form commandName="rrprVo" name="frm" id="frm" method="post" action="">
				<form:hidden path="rsrcReqNo" />
				<form:hidden path="rsrcReqSeq" />
				<form:hidden path="rsrcReqTyCd" />
				<form:hidden path="rsrcReqPrcssStatCd" />
				<form:hidden path="zoneId" />
				<form:hidden path="netClCd" />
				<form:hidden path="rsrcPoolId" />
				<form:hidden path="schRsrcReqNo" value="${rrprVo.rsrcReqNo}" />
					<table class="table table-horizon">
					<caption>물리서버 삭제 상세설정</caption>
					<colgroup>
						<col class="col10">
						<col class="col10">
						<col class="col10">
						<col class="col10">
						<col class="col10">
						<col class="col10">
						<col class="colAuto">
					</colgroup>
					<thead>
						<tr><th colspan="2">연계 클러스터 정보</th>
							<th colspan="4">삭제 물리서버 정보</th></tr>
						<tr><th>클러스터명</th>
							<th>클러스터구성ID</th>
							<th>물리서버명</th>
							<th>물리서버구성ID</th>
							<th>물리서버IP</th>
							<th><span class="text-red">*</span>물리서버ID</th></tr>
					</thead>
					<tbody>
						<tr><td><c:out value="${rrprVo.clstrNm}" /></td>
							<td><c:out value="${rrprVo.clstrCompId}" /></td>
							<td><c:out value="${rrprVo.pmNm}" /></td>
							<td><c:out value="${rrprVo.pmCompId}" /></td>
							<td><c:out value="${rrprVo.ipAddr}" /></td>
							<c:choose>
								<c:when test="${rrVo.rsrcReqPrcssStatCd eq '01' }">
									<c:choose>
										<c:when test="${rrprVo.pmId != null || rrprVo.pmId ne null }">
											<td><input type="text" id="pmId" name="pmId" class="form-control essential" value="<c:out value='${rrprVo.pmId}'/>" title="물리서버 ID" maxlength="100" disabled="disabled" /></td>
										</c:when>
										<c:otherwise>
											<td><input type="text" id="pmId" name="pmId" class="form-control essential" title="물리서버 ID" maxlength="100" disabled="disabled" /></td>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<td><c:out value='${rrprVo.pmId}' /></td>
								</c:otherwise>
							</c:choose></tr>
					</tbody>
				</table>
			</form:form>
			</c:if>
		</div>

		<!-- box-body -->
		<div class="box-footer">
			<div class="pull-right">
				<button id="btnProcssStat" class="btn btn-sm btn-hover-gray"
				data-toggle="tooltip" title="" data-original-title="진행상태조회"
					onclick="fn_showProcssPmDel(); return false;">
					<i class="fa fa-file-o"></i>진행상태조회
				</button>
			</div>
		</div><!-- /box-footer -->
	</div><!-- /box -->
</div><!-- /페이지 컨텐츠 -->

<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<c:url var="listUrl" value="selectRsrcReqList.do">
			<c:forEach var="curParam" items="${param }">
				<c:if test="${curParam.key ne 'boardSeq'}">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:if>
			</c:forEach>
		</c:url>

		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip"
				title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')">
				<i class="fa fa-arrow-left"></i>
			</button>
		</div>
		<c:choose>
			<c:when test="${rrVo.rsrcReqPrcssStatCd eq '01'}">
				<div class="pull-right btns">
					<menu:authorize authType="act" onlyOprAdm="true">
						<button class="btn btn-sm btn-hover-green" data-toggle="tooltip"
							title="" data-original-title="실행"
							onclick="fn_updateRsrcReqPhySrvrDelExe(); return false;">
							<i class="fa fa-play-circle"></i>
						</button>
						<button class="btn btn-sm btn-hover-red" data-toggle="tooltip"
							title="" data-original-title="반려"
							onclick="fn_updateRsrcReqPhySrvrDelRjct(); return false;">
							<i class="fa fa-times"></i>
						</button>
					</menu:authorize>

					<menu:modAuthorize regId="${rrVo.regUserId }">
						<button id = "deleteRsrcReqBtn" class="btn btn-sm btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="javascript:fn_deleteRsrcReq()"><i class="fa fa-minus"></i></button>
					</menu:modAuthorize>
				</div>
			</c:when>
		</c:choose>
	</div>
</div>
<!-- /페이지 버튼 영역 -->


<script type="text/javascript">


/**
 * 초기 구동
 */
$(function() {
	fn_initUI();
	setInterval(function(){ fn_selectSyncPmsStatus(); }, 60 * 1000);
});

/**
 * 화면 초기화
 */
function fn_initUI(){
	var procssStat = $("#rsrcReqPrcssStatCd").val();
	var testYn = "${rrVo.testYn }"; //테스트여부

	$('#btnProcssStat').show();
	if(procssStat =='01' || procssStat =='04'){
		$('#btnProcssStat').hide();
	}

	if(testYn != 'Y') {
		$("#deleteRsrcReqBtn").hide();  //삭제버튼을 감춘다.
	}
}

/**
 * 실행/반려 callback
 */
function fn_callbackRsrcReqPhySrvrDel(result){
	if(result.success){
		jInfo(result.messageList, function() {
			fn_reloadPage();
		});
	}else{
		jAlert(result.messageList);
	}
}

/**
 * 화면 재 호출
 */
function fn_reloadPage(){
	location.reload();
	//$("#frm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/formRsrcReqPhySrvDel.do'/>");
	//$("#frm").submit();
}

/**
 * 실행
 */
function fn_updateRsrcReqPhySrvrDelExe(){
	var statCd =  $('#pmFrm #statCd').val();

	if(statCd != '01'){
		jAlert("다운(OFF)일 경우에만 가능합니다. [상태:" +  $('#pmFrm #statCdNm').val()+"]");
		return;
	}

	jConfirm("실행하시겠습니까", function(result){
			$.ncmsLoding.startFullScreen();
			$.post('updateRsrcReqPhyRsrcExe.do', $('#frm').serialize(), fn_callbackRsrcReqPhySrvrDel, 'json').always(function(){$.ncmsLoding.remove();});
	});
}

//삭제 버튼 클릭 시
function fn_deleteRsrcReq() {
	jConfirm('삭제 하시겠습니까?', function(){
		$.ncmsLoding.startFullScreen();
		$.post('updateRsrcReqDeleteYn.do', $('#frm').serialize(), function(result) {

			jInfo(result.messageList, function() {
				if( result.success) {
					goToUrl('${listUrl}');
				}
			});

		}, 'json').always(function(){$.ncmsLoding.remove();});
	});
}

/**
 * 반려팝업 호출
 */
function fn_updateRsrcReqPhySrvrDelRjct(){

	var url = 'selectRsrcReqRjctP.do';
	var rsrcReqNo = $('#frm #rsrcReqNo').val();
	var rsrcReqSeq = $('#frm #rsrcReqSeq').val();
	var rsrcReqTyCd = $('#frm #rsrcReqTyCd').val();

	var params = {rsrcReqNo : rsrcReqNo , rsrcReqSeq : rsrcReqSeq, rsrcReqTyCd: rsrcReqTyCd };

	var width = 740;
	var height = 290;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {key:"RsrcReqRjct", width:width , height:height, posX : posX , posY : posY};

	windowOpen(url, params, args);
}

/**
 * 진행상태 팝업
 */
function fn_showProcssPmDel(){
	var params = { rsrcReqNo : $('#rsrcReqNo').val() , rsrcReqSeq : $('#rsrcReqSeq').val()};
	var args = {key:"selectRsrcReqExeListP", width: 1100 , height: 710 };
	windowOpen('selectRsrcReqExeListP.do', params, args);
	return false;
}

/**
 * 물리서버 동기화/시작/중지
 */
function fn_execPM(cmd){
	if(cmd=='S'){
		//물리서버 동기화(새로고침)
		fn_execPMImpl('updateSyncPmsStatus.do');
	}else if(cmd == 'A'){
		//물리서버 시작(UP)
		fn_execPMImpl('updatePmActive.do');
	}else if(cmd == 'D'){
		//물리서버 비활성(다운)
		fn_execPMImpl('updatePmDeactive.do');
	}
}
/**
 * 물리서버 실행 및 연동
 */
function fn_execPMImpl(url){
	var pmSeq = "${pmVo.pmSeq}";
	$.ajax({
		type : "POST"
		,url : url
		,data : "pmSeq="+pmSeq
		,beforeSend: function() {
			$.ncmsLoding.startFullScreen();
		}
		,complete : function() {
		  	$.ncmsLoding.remove();
		}
		,error: function(xhr, textStatus, errorThrown){
			$.ncmsLoding.remove();
			jAlert('오류가 발생하였습니다.');
		}
		,success :fn_cbPmResult,
	});
}

/**
 * 상태 동기화
 */
function fn_selectSyncPmsStatus(){
	var pmSeq = "${pmVo.pmSeq}";
	$.ajax({
		type: 'post'
		, url : "selectSyncPmsStatus.do"
		, data : "pmSeq="+pmSeq
		, success:  fn_cbPmStatusSyncResult
		, beforeSend: function() {
		}
		, complete : function() {
		}
		,error: function(xhr, textStatus, errorThrown){
			if(xhr.status === 0 || xhr.readyState === 0){
				console.log(xhr);
				return;
			}
			jAlert('오류가 발생하였습니다.');
		}
	});
}

/**
 * 새로고침/시작/중지
 */
function fn_cbPmResult(result){
	if(result.success){
		console.log(result.messageList);
		fn_selectSyncPmsStatus();
	}else{
		jAlert(result.messageList);
	}
}

/**
 * 상태 응답에 따른 출력
 */
function fn_cbPmStatusSyncResult(result){
	if(result.success){
		if(result.data && result.data.statCd){
			var statCd = result.data.statCd;
			var statCdNm = result.data.statCdNm;
			var $container = $('div.server');

			$container.find('.col-info-box.alignL .label').remove();
			$container.removeClass('server-down').removeClass('server-up').removeClass('server-inprogress').removeClass('server-exception').removeClass('server-maintain');

			switch(statCd){
			case '01' : // 다운(OFF)
				$container.addClass('server-down');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			case '02' : // 업(ON)
				$container.addClass('server-up');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			case '03' : // 유지보수
				$container.addClass('server-maintain');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			case '04' : // 처리중
				$container.addClass('server-inprogress');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			case '05' : // 예외
				$container.addClass('server-exception');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			default : // 그외
				break;
			}
			$container.find('.stat').html(statCdNm);
			$container.find('.vm-start').prop('disabled', ("01" != statCd));
			$container.find('.vm-shutdown').prop('disabled', ("02" != statCd));

			$('#pmFrm #statCd').val(statCd);
			$('#pmFrm #statCdNm').val(statCdNm);

			console.log('statCd= '+ statCd+", statCdNm="+statCdNm);

		}
	}
}

</script>
