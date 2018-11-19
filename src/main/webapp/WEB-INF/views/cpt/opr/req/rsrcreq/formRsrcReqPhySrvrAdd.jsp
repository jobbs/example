<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자원요청 상세-물리서버 추가</pre>
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 5.
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

<!-- 페이지 컨텐츠 -->
<div class="col-box-100 detail-col">
	<!-- 자원요청 기본 정보  -->
	<%@ include file="selectRsrcReqInfo.jsp" %>

	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">물리서버 추가 정보</h3>
		</div>

		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>물리서버 추가 상세 설정 정보</caption>
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
					<tr>
						<th colspan="2">연계 클러스터 정보</th>
						<th colspan="4">신규 물리서버 정보</th>
					</tr>
					<tr>
						<th>클러스터명</th>
						<th>클러스터구성ID</th>
						<th>물리서버명</th>
						<th>물리서버구성ID</th>
						<th>물리서버IP</th>
						<th><span class="text-red">*</span>물리서버ID</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td><c:out value="${rrprVo.clstrNm}" /></td>
						<td><c:out value="${rrprVo.clstrCompId}" /></td>
						<td><c:out value="${rrprVo.pmNm}" /></td>
						<td><c:out value="${rrprVo.pmCompId}" /></td>
						<td><c:out value="${rrprVo.ipAddr}" /></td>
						<c:choose>
							<c:when test="${rrVo.rsrcReqPrcssStatCd eq '01' }">
								<c:choose>
									<c:when
										test="${rrprVo.pmId != null || rrprVo.pmId ne null }">
										<td><input type="text" id="inputPmId" name="inputPmId" class="form-control essential" value="<c:out value='${rrprVo.pmId}'/>"
											title="물리서버 ID" maxlength="100" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="text" id="inputPmId" name="inputPmId" class="form-control essential" title="물리서버 ID" maxlength="100" /></td>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<td><c:out value='${rrprVo.pmId}' /></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</tbody>
			</table>
		</div><!-- /물리서버 추가 설정 -->

		<div class="box-footer">
			<div class="pull-right">
				<button id="btnProcssStat" class="btn btn-sm btn-hover-gray"
					data-toggle="tooltip" title="" data-original-title="진행상태조회"
					onclick="fn_showProcssPmAdd(); return false;">
					<i class="fa fa-file-o"></i>진행상태조회
				</button>
			</div>
		</div><!-- /box-footer -->
	</div><!-- /물리서버 상세 -->
</div>

<form:form commandName="rrprVo" name="frm"	id="frm" method="post" action="">
		<form:hidden path="rsrcReqNo" />
		<form:hidden path="rsrcReqSeq" />
		<form:hidden path="rsrcReqTyCd" />
		<form:hidden path="rsrcReqPrcssStatCd" />
		<form:hidden path="schRsrcReqNo" value="${rrprVo.rsrcReqNo}" />
		<form:hidden path="pmId" />
		<form:hidden path="netClCd" />
</form:form>

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

		<c:if test="${rrVo.rsrcReqPrcssStatCd eq '01'}">
			<div class="pull-right btns">
				<menu:authorize authType="act" onlyOprAdm="true">
					<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="" data-original-title="실행" onclick="javascript:fn_updateRsrcReqPhySrvrAddExe();">
						<i class="fa fa-play-circle"></i>
					</button>
					<button class="btn btn-sm btn-hover-red" data-toggle="tooltip" title="" data-original-title="반려" onclick="javascript:fn_updateRsrcReqPhySrvrAddRjct();">
						<i class="fa fa-times"></i>
					</button>
				</menu:authorize>

				<menu:modAuthorize regId="${rrVo.regUserId }">
					<button id = "deleteRsrcReqBtn" class="btn btn-sm btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="javascript:fn_deleteRsrcReq()"><i class="fa fa-minus"></i></button>
				</menu:modAuthorize>
			</div>
		</c:if>
	</div>
</div>
<!-- /페이지 버튼 영역 -->

<script type="text/javascript">
/**
 * 초기 구동
 */
$(function() {
	fn_initUI();
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
 *  물리서버 추가 실행 결과
 */
function fn_callbackRsrcReqPhySrvrAdd(result){
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
	//$("#frm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/formRsrcReqPhySrvAdd.do'/>");
	//$("#frm").submit();
}

/**
 * 실행
 */
function fn_updateRsrcReqPhySrvrAddExe(){

	if($('#inputPmId').val()==''){
		jAlert("물리서버 ID는 반드시 입력하셔야 합니다.", function(){
			$('#inputPmId').focus();
		});
		return;
	}

	$('#pmId').val($('#inputPmId').val());

	if(!fn_form_validation("frm")){
		jAlert("물리서버 ID는 반드시 입력하셔야 합니다.", function(){
			$('#inputPmId').focus();
		});
		return;
	}


	jConfirm("실행하시겠습니까", function(result){
		$.ncmsLoding.startFullScreen();
		$.post("<c:url value='updateRsrcReqPhyRsrcExe.do'/>", $('#frm').serialize(), fn_callbackRsrcReqPhySrvrAdd, 'json').always(function(){$.ncmsLoding.remove();});
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
function fn_updateRsrcReqPhySrvrAddRjct(){
	var url = 'selectRsrcReqRjctP.do';
	var rsrcReqNo = $('#frm #rsrcReqNo').val();
	var rsrcReqSeq = $('#frm #rsrcReqSeq').val();
	var rsrcReqTyCd = $('#frm #rsrcReqTyCd').val();

	var params = {rsrcReqNo : rsrcReqNo, rsrcReqSeq : rsrcReqSeq, rsrcReqTyCd: rsrcReqTyCd };

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
function fn_showProcssPmAdd(){
	var params = { rsrcReqNo : $('#rsrcReqNo').val() , rsrcReqSeq : $('#rsrcReqSeq').val()};
	var args = {key:"selectRsrcReqExeListP", width: 1100 , height: 710 };
	windowOpen('selectRsrcReqExeListP.do', params, args);
	return false;
}
</script>
