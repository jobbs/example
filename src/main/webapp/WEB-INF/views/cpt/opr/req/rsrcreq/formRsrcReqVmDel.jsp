<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자원요청상세-가상서버 삭제</pre>
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     김봉민         v1.0             최초생성
 * 2016. 11. 04.     김봉민         v1.01            오타수정
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>

<!--  가상서버 상태 표시  -->
<c:if test="${vmVo ne null }">
	<div class="col-box-100">
		<div class="col-info server <c:choose><c:when test='${"02" eq vmVo.statGrpCd}'><c:out value="server-up"/></c:when>
										      <c:when test='${"01" eq vmVo.statGrpCd}'><c:out value="server-down"/></c:when>
										      <c:when test='${"04" eq vmVo.statGrpCd}'><c:out value="server-exception"/></c:when>
										      <c:otherwise><c:out value="server-inprogress"/></c:otherwise> </c:choose>">
			<div class="col-info-body alignL">
				<div class="col-info-box alignL">
					<span class="label"></span>
					<h4 class="stat"><c:out value="${vmVo.statGrpCdNm}"/><c:if test='${"03" eq vmVo.statGrpCd}'><c:out value="(${vmVo.statCdNm})"/></c:if></h4>
					<menu:authorize authType="act">
						<c:choose>
							<c:when test='${vmVo.delYn eq "N"}'>
								<button type="button" class="btn btn-sm btn-refresh vm-sync" onclick="fn_executeVmStatSync();" disabled="disabled">새로고침</button>
							</c:when>
							<c:otherwise>
								<span class='status  status-red'>삭제됨</span>
							</c:otherwise>
						</c:choose>
					</menu:authorize>
				</div>
				<div class="col-info-box alignR">
					<c:if test='${vmVo.delYn eq "N"}'>
						<div class="col-info-btn">
							<menu:authorize authType="act">
									<button type="button" class="btn vm-shutdown" title="중지" onclick="fn_executeVmShutdown();"
											<c:choose><c:when test='${"03" eq rrDtlVo.rsrcReqPrcssStatCd }'><c:out value="disabled"/></c:when>
													  <c:otherwise><c:if test='${"02" ne vmVo.statGrpCd}'><c:out value="disabled"/></c:if> </c:otherwise></c:choose>
									><i class="fa fa-ban"></i><span>중지</span>
										</button>
									<button type="button" class="btn vm-stop" title="강제종료" onclick="fn_executeVmStop();"
											<c:choose><c:when test='${"03" eq rrDtlVo.rsrcReqPrcssStatCd }'><c:out value="disabled"/></c:when>
													  <c:otherwise><c:if test='${"02" ne vmVo.statGrpCd}'><c:out value="disabled"/></c:if> </c:otherwise></c:choose>
										><i class="fa fa-power-off"></i><span>강제종료</span>
									</button>
							</menu:authorize>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div><!--  /가상서버 상태 표시  -->
</c:if>

<div class="col-box-100 detail-col">
	<div class="box detail-list-box">
		<div class="box-header"><h3 class="box-title">기본 정보</h3></div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>가상서버의 기본정보</caption>
				<colgroup>
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
				</colgroup>
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3"><c:out value="${rrDtlVo.sbjct }" /></td>
						<th>실행자</th>
						<td><c:out value="${rrDtlVo.exeUserNm }" /></td>
						<th>실행일시</th>
						<td><c:out value="${rrDtlVo.exeDttm }" /></td>
					</tr>
					<tr>
						<th>상태</th>
						<td>
							<span class="status
								<c:choose>
									<c:when test="${'01' eq rrDtlVo.rsrcReqPrcssStatCd}"><c:out value="status-blue"/></c:when>
									<c:when test="${'02' eq rrDtlVo.rsrcReqPrcssStatCd}"><c:out value="status-yellow"/></c:when>
									<c:when test="${'03' eq rrDtlVo.rsrcReqPrcssStatCd}"><c:out value="status-green"/></c:when>
									<c:when test="${'04' eq rrDtlVo.rsrcReqPrcssStatCd}"><c:out value="status-aqua"/></c:when>
									<c:when test="${'05' eq rrDtlVo.rsrcReqPrcssStatCd}"><c:out value="status-red"/></c:when>
									<c:when test="${'06' eq rrDtlVo.rsrcReqPrcssStatCd}"><c:out value="status-gray"/></c:when>
									<c:when test="${'07' eq rrDtlVo.rsrcReqPrcssStatCd}"><c:out value="status-green"/></c:when>
									<c:otherwise><c:out value="status-gray"/></c:otherwise>
								</c:choose>
	                			status-red "><c:out value="${rrDtlVo.rsrcReqPrcssStatNm}"/>
	                		</span>
						</td>
						<th>티켓번호</th>
						<td><c:out value="${rrDtlVo.ticktNo }" /></td>
						<th>요청번호</th>
						<td><c:out value="${rrDtlVo.rsrcReqNo }" /></td>
						<th>요청일시</th>
						<td><c:out value="${rrDtlVo.rsrcReqDttm }" /></td>
					</tr>
					<tr>
						<th>요청유형</th>
						<td><c:out value="${rrDtlVo.rsrcReqTyNm }" /></td>
						<th>요청자</th>
						<td><c:out value="${rrDtlVo.rsrcReqUsrNm }" /></td>
						<th>부처</th>
						<td><c:out value="${rrDtlVo.reqInstitutionNm }" /></td>
						<th>핸드폰</th>
						<td><c:out value="${rrDtlVo.mobile }" /></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><c:out value="${rrDtlVo.email }" /></td>
						<th>완료일시</th>
						<td><c:out value="${rrDtlVo.comptDttm }" /></td>
						<th>테스트여부</th>
						<td colspan="3" >
							<c:choose>
								<c:when test="${rrDtlVo.testYn eq 'Y'}">예</c:when>
								<c:when test="${rrDtlVo.testYn eq 'N'}">아니오</c:when>
								<c:otherwise><c:out value="${rrDtlVo.testYn}"/></c:otherwise>
							</c:choose>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div><!-- /box -->

	<!-- box  -->
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">가상서버 정보  <small class="text-red"><c:if test="${vmVo.delYn eq 'Y' }"><c:out value="[삭제됨]" /></c:if></small></h3>
		</div>
		<!-- box-body -->
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>가상서버 상세 정보 </caption>
				<colgroup>
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
				</colgroup>
				<tbody>
					<c:choose>
						<c:when test="${vmVo eq null}">
							<tr><td colspan="8" class="btn btn-red btn-lg"><c:out  value="가상서버정보 조회 권한이 없습니다."/></td></tr>
						</c:when>
						<c:otherwise>
							<tr><th>센터</th><td><c:out value="${vmVo.regionNm }" /></td>
								<th>존</th><td><c:out value="${vmVo.zoneNm }" /></td>
								<th>망</th><td><c:out value="${vmVo.netNm }" /></td>
								<th>자원풀</th><td><c:out value="${vmVo.rsrcPoolNm }" /></td></tr>
							<tr><th>클러스터명</th><td><c:out value="${vmVo.clstrNm }" /></td>
								<th>물리서버명</th><td><c:out value="${vmVo.pmNm }" /></td>
								<th>요청부처</th><td><c:out value="${vmVo.institutionNm }" /></td>
								<th>업무</th>
									<td><nobr>
										<c:forEach var="vmJobVo" items="${vmVo.vmJobVoList }"
											varStatus="i">
											<c:out value="${vmJobVo.jobNm }" />
											<c:if test="${fn:length(vmVo.vmJobVoList) > (i.index + 1) }">
												<c:out value="," />
											</c:if>
										</c:forEach>
									</nobr></td></tr>
							<tr><th>가상화SW</th><td><c:out value="${vmVo.vrlzSwTyCdNm }" /></td>
								<th>가상서버명</th><td><c:out value="${vmVo.vmNm }" /></td>
								<th>가상서버ID</th><td><c:out value="${vmVo.vmId }" /></td>
								<th>호스트명</th><td><c:out value="${vmVo.hstNm }" /></td></tr>
							<tr><th>IP주소</th><td><c:out value="${vmVo.rprsntIpAddr }" /></td>
								<th>OS유형</th><td><c:out value="${vmVo.osTyCdNm }" /></td>
								<th>운영체제</th><td><c:out value="${vmVo.osNm }" /></td>
								<th>S/W</th><td><c:out value="${vmVo.pltfrm }" /></td></tr>
							<tr><th>CPU vCore</th><td><c:out value="${vmVo.cpuVcoreQty }" /></td>
								<th>CPU Ent</th><td><c:out value="${vmVo.cpuEnt }" /></td>
								<th>메모리 (GB)</th><td><c:out value="${vmVo.memAsgnCapa }" /></td>
								<th>스토리지 (GB)</th><td><c:out value="${vmVo.strgAsgnCapa}" /></td></tr>
							<tr><th>서비스기간</th>
									<td colspan="7">
										<c:choose>
											<c:when test="${vmVo.servcStrtDt ne null }">
												<fmt:formatDate pattern="yyyy-MM-dd" value="${vmVo.servcStrtDt}"/>
												 ~ <fmt:formatDate pattern="yyyy-MM-dd" value="${vmVo.servcEndDt}"/>
											</c:when>
											<c:otherwise>영구</c:otherwise>
									</c:choose></td></tr>
							<tr><th>가상서버구성ID</th><td colspan="7"><c:out value="${vmVo.vmCompId }" /></td></tr>
							<tr><th>비고</th><td colspan="7"><c:out value="${vmVo.rmk }" /></td></tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<div class="box-footer">
			<div class="pull-right"><button  id="btnProcssStat" class="btn btn-sm btn-hover-gray"  data-toggle="tooltip" title="" data-original-title="진행상태조회" onclick="fn_showProcssVmDel(); return false;"><i class="fa fa-file-o"></i>진행상태조회</button>
      		  <button id="nTopsReSendBtn" class="btn btn-sm" onclick="javascript:fn_resendNtops(); return false;"><i class="fa fa-file-o"></i>nTOPS 결과 재전송</button>
      		  </div>
		</div><!-- /box-footer -->
	</div><!-- /box -->

</div><!-- /col-box-100 -->

<form:form commandName="rrDtlVo" name="rrDtlFrm" id="rrDtlFrm" method="post" action="">
	<form:hidden path="regionId" value= "${vmVo.regionId }" />  <!-- 센터ID -->
    <form:hidden path="zoneId" value= "${vmVo.zoneId }"   />   <!-- 존ID -->
    <form:hidden path="netId" value= "${vmVo.netId }"  />  <!-- 망ID -->
    <form:hidden path="netClCd" value= "${vmVo.netClCd }"  />  <!-- 망구분코드 -->
    <form:hidden path="rsrcPoolId"  value= "${vmVo.rsrcPoolId }" />  <!-- 매니저ID -->
    <form:hidden path="uuid"  value= "${vmVo.uuid }" />  <!-- 가상서버UUID -->
	<form:hidden path="rsrcReqNo" /><!-- 자원요청번호 -->
	<form:hidden path="rsrcReqSeq" /><!-- 자원요청일련번호 -->
	<form:hidden path="rsrcReqDtlPrcssStatCd" /><!-- 자원요청상세진행상태코드 -->
	<form:hidden path="schRsrcReqNo" value="${rrDtlVo.rsrcReqNo}" /><!-- 조회 자원요청번호  -->
	<form:hidden path="ticktNo" value="${rrDtlVo.ticktNo }" /> <!--요청 티켓번호 -->
	<form:hidden path="procssInstSeq" /><!-- 프로세스인스턴스ID -->
	<form:hidden path="rsrcReqTyCd"/>
	<form:hidden path="vmChngClCd"/>
	<form:hidden path="vmSeq"/>
	<form:hidden path="exeType" />  <!-- 실행타입-->
</form:form>

<c:if test="${vmVo ne null}">
	<form:form commandName="vmVo" name="vmFrm"	id="vmFrm" method="post" action="">
		<form:hidden path="vmSeq"/>
		<form:hidden path="statGrpCd"/>
		<form:hidden path="statGrpCdNm"/>
	</form:form>
</c:if>

<!-- page-btn-group -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<c:url var="updateUrl" value="updateRsrcReq.do">
			<c:forEach var="curParam" items="${param }">
				<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
			</c:forEach>
		</c:url>
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
		<div class="pull-right btns">
			<menu:authorize authType="act" onlyOprAdm="true">
				<button id = "manualRsrcReqBtn" class="btn btn-sm btn-hover-green" onclick="javascript:fn_execRsrcReq('M')"  data-toggle="tooltip" title="" data-original-title="수동완료"><i class="fa fa-arrow-circle-o-right"></i></button>
				<button id="execRsrcReqBtn" class="btn btn-sm btn-hover-green" onclick="javascript:fn_execRsrcReq()" data-toggle="tooltip" title="" data-original-title="실행"><i class="fa fa-play-circle"></i></button>
				<button id="rjctRsrcReqBtn" class="btn btn-sm btn-hover-red" onclick="javascript:fn_rjctRsrcReq()" data-toggle="tooltip" title="" data-original-title="반려"><i class="fa fa-times"></i></button>
			</menu:authorize>

			<menu:modAuthorize regId="${rrDtlVo.regUserId }">
				<button id ="deleteRsrcReqBtn" class="btn btn-sm btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="javascript:fn_deleteRsrcReq()"><i class="fa fa-minus"></i></button>
			</menu:modAuthorize>
		</div>
	</div>
</div>
<!-- /page-btn-group -->

<script type="text/javascript">

$(function() {
	fn_formInit("${rrDtlVo.rsrcReqPrcssStatCd}");
	setInterval(function(){ fn_selectVmStatSync(); }, 60 * 1000);
});



//폼 셋팅
function fn_formInit(statCd) {

	var testYn = "${rrDtlVo.testYn }"; //테스트여부
	if(testYn != 'Y') {
		$("#deleteRsrcReqBtn").hide();  //삭제버튼을 감춘다.
	}

	$("#execRsrcReqBtn").hide();
	$("#rjctRsrcReqBtn").hide();
	$("#btnProcssStat").show();

	$("#nTopsReSendBtn").hide(); //nTOPS 재전송  버튼을 숨긴다.


	if(statCd == '01') {
		$("#manualRsrcReqBtn").show(); //수동실행버튼을 활성화한다.
		$("#execRsrcReqBtn").show();
		$("#rjctRsrcReqBtn").show();
		$("#btnProcssStat").hide();
	}

	if( statCd == '04' || statCd == '07'){
		$("#manualRsrcReqBtn").hide(); //수동실행버튼을 숨긴다.
		$("#btnProcssStat").hide();
	}

	if(statCd == '03' ||  statCd == '07' ){  // 수동완료상태인 경우
		$("#nTopsReSendBtn").show(); //nTOPS 재전송  버튼을 활성화한다.
	}
}

function checkValidateVm(){
	var statGrpCd = $('#vmFrm #statGrpCd').val();  // "${vmVo.statGrpCd}";	//01:다운, 02: 업, 03:진행중, 04:예외

	if(statGrpCd =='01' || statGrpCd==''){
		//다운 또는 없을 경우만 처리
		return true;
	}
	return false;
}

//실행 버튼 클릭 시
function fn_execRsrcReq(btnFlag) {

	var delyn = "${vmVo.delYn}";

	if(!checkValidateVm() && delyn != 'Y' ){
		jAlert("가상서버가 상태 ["+ ( $('#vmFrm #statGrpCdNm').val() ) +"].\n가상서버 [다운(OFF)] 상태만 실행 가능합니다.");
		return;
	}

	var msg = '삭제 시 데이터를 복구하실 수 없습니다 .\n - 가상서버삭제 요청을 실행하시겠습니까?';
	if(delyn == 'Y'){
		msg = '삭제된 가상서버입니다.\n - 가상서버삭제 요청을 실행하시겠습니까';
	}

	// 수동 실행 버튼 클릭시
	if(btnFlag == 'M') {
		$('#exeType').val(btnFlag);
	}

	jConfirm(msg, function(){
		$.ncmsLoding.startFullScreen();
		$.post('updateRsrcReqVmExe.do', $('#rrDtlFrm').serialize(), fn_callbackRsrcReqVmDelExe, 'json').always(function(){$.ncmsLoding.remove();});
	});
}

//삭제 버튼 클릭 시
function fn_deleteRsrcReq() {
	jConfirm('삭제 하시겠습니까?', function(){
		$.ncmsLoding.startFullScreen();
		$.post('updateRsrcReqDeleteYn.do', $('#rrDtlFrm').serialize(), function(result) {

			jInfo(result.messageList, function() {
				if( result.success) {
					goToUrl('${listUrl}');
				}
			});

		}, 'json').always(function(){$.ncmsLoding.remove();});
	});
}

//실행 후
function fn_callbackRsrcReqVmDelExe(result){
	if(result.success){
		jInfo(result.messageList, function() {
			fn_reloadPage();
		});
	}else{
		jAlert(result.messageList);
	}
}

function fn_reloadPage(){
	location.reload();
	//$("#rrDtlFrm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/formRsrcReqVmDel.do'/>");
	//$("#rrDtlFrm").submit();
}


//반려버튼 클릭 시
function fn_rjctRsrcReq() {
	//alert("자원요청 가상서버 상태 만 반려 상태로 변경 - 비지니스 로직이 필요할 경우 추가 ");
	var params = { rsrcReqNo : $('#rsrcReqNo').val() , rsrcReqSeq : $('#rsrcReqSeq').val(), rsrcReqTyCd: $('#rsrcReqTyCd').val() };

	var width = 740;
	var height = 290;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {key:"RsrcReqRjct", width:width , height:height, posX : posX , posY : posY};

	windowOpen('selectRsrcReqRjctP.do', params, args);
}

/**
 * 진행상태 팝업
 */
function fn_showProcssVmDel(){
	var params = { rsrcReqNo : $('#rsrcReqNo').val() , rsrcReqSeq : $('#rsrcReqSeq').val()};
	var args = {key:"selectRsrcReqExeListP", width: 1100 , height: 710 };
	windowOpen('selectRsrcReqExeListP.do', params, args);
	return false;
}

/**
 * 가상서버 새로고침
 */
function fn_executeVmStatSync(){
	fn_executeVmImpl('<c:url value="/cpt/rsrc/com/vm/selectExecVmStatSync.do"/>');
}

/**
 * 가상서버 중지
 */
function fn_executeVmShutdown(){
	jConfirm('가상서버를 중지 하시겠습니까?', function(){
		fn_executeVmImpl('<c:url value="/cpt/rsrc/com/vm/executeVmShutdown.do"/>');
	});
}

/**
 * 가상서버 강제종료
 */
function fn_executeVmStop(){
	jConfirm('가상서버를 강제종료 하시겠습니까?', function(){
		fn_executeVmImpl('<c:url value="/cpt/rsrc/com/vm/executeVmStop.do"/>');
	});
}
/**
 * 가상서버 상태 변경 및 새로고침 요청
 */
function fn_executeVmImpl(url){
	var vmSeq = "${vmVo.vmSeq}";
	$.ajax({
		type : "POST"
		,url : url
		,data : "vmSeq="+vmSeq
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
		,success :callbackExecuteVmResultHandler,

	});
}

/**
 * callback sucess
 */
function callbackExecuteVmResultHandler(result){
	if(result.success){
		//성공시 메시지 표시 안함.
		//jInfo(result.messageList, function(){ location.reload(); });
		//location.reload();
		fn_selectVmStatSync();
	}
	else{
		jAlert(result.messageList, function(){
			location.reload();
		});
	}
}

/**
* nTOPS 결과 재전송
*/
function fn_resendNtops(){
	var rsrcReqNo = $('#rrDtlFrm #rsrcReqNo').val();
	var rsrcReqTyCd = $('#rrDtlFrm #rsrcReqTyCd').val();

	jConfirm("nTOPS 결과 재전송을  실행하시겠습니까", function(result){
		var data ={ rsrcReqNo : rsrcReqNo ,
				rsrcReqTyCd : rsrcReqTyCd
		};

		$.post("<c:url value='resendResultToNtops.do'/>", data, fn_callbackResendNtops, 'json').always(function(){$.ncmsLoding.remove();});
	});
}

//실행 후
function fn_callbackResendNtops(result){
	if(result.success){
		jInfo(result.messageList);
	}else{
		jAlert(result.messageList);
	}
}

/**
 *  주기적 동기화
 */
 var xhr = null;
 function fn_selectVmStatSync(){
	var vmSeq = "${vmVo.vmSeq}";

	if(vmSeq ==null || vmSeq == undefined || vmSeq ==''){
		console.log("vmSeq is not existed. No Reflash!");
		return;
	}


	$.ajax({
		type: 'post'
		, url : "/cpt/rsrc/com/vm/selectVmStatSync.do"
		, data : "vmSeq="+vmSeq
		, success: selectVmStatSyncResultHandler
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
 * 	동기화 결과 출력
 */
function selectVmStatSyncResultHandler(result){
	if(result.success){
		if(result.data && result.data.statGrpCd){

			var statGrpCd = result.data.statGrpCd;
			var $container = $('div.server');

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

			$container.find('.vm-shutdown').prop('disabled', ("02" != statGrpCd));
			$container.find('.vm-stop').prop('disabled', ("02" != statGrpCd));

			$('#vmFrm #statGrpCd').val(statGrpCd);
			$('#vmFrm #statGrpCdNm').val(result.data.statGrpCdNm);
		}
	}
	else{
		jAlert(result.messageList);
	}
}

</script>
