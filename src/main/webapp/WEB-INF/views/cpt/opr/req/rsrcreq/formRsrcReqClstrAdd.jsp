<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자원요청상세-클러스터 추가 </pre>
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 6.
 * @lastmodified 2016. 10. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 6.     김봉민         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<!-- 페이지 컨텐츠 -->
<div class="col-box-100 detail-col">
	<form:form commandName="rrprVo" name="frm" id="frm" method="post">
		<form:hidden path="rsrcReqNo" />
		<form:hidden path="rsrcReqSeq" />
		<form:hidden path="rsrcReqTyCd"/>
		<form:hidden path="pmId" />
		<form:hidden path="zoneId"  />
    	<form:hidden path="netClCd"  />
    	<form:hidden path="rsrcPoolId"  />
		<form:hidden path="rsrcReqPrcssStatCd"/>
		<form:hidden path="schRsrcReqNo" value="${rrprVo.rsrcReqNo}" />
		<!-- 자원요청 기본정보  -->
		<%@ include file="selectRsrcReqInfo.jsp" %>

		<div class="box detail-list-box">
			<div class="box-header"><h3 class="box-title">클러스터 추가  정보</h3></div>
			<div class="box-body no-padding">
				<table class="table table-horizon">
				<caption>클러스터 생성 설정</caption>
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
					<tr><th>센터</th><td ><c:out value="${rrVo.regionNm}" /></td>
						<th>존</th><td ><c:out value="${rrprVo.zoneNm}" /></td>
						<th>망</th><td ><c:out value="${rrprVo.netNm}" /></td>
						<th>자원풀</th><td ><c:out value="${rrprVo.rsrcPoolNm}" /></td></tr>
					<tr><th>클러스터구성ID</th><td><c:out value="${rrprVo.clstrCompId}" /></td>
						<th>클러스터명</th><td ><c:out value="${rrprVo.clstrNm}" /></td>
						<th>클러스터용도</th><td colspan="7" ><c:out value='${rrprVo.rsrcReqClstrPropsReqListNmTxt}' /></td>

          <tr>
						<th><span class="text-red">*</span>데이터센터</th>
							<td colspan="3">
							<c:if test="${rrVo.rsrcReqPrcssStatCd eq '01'}">
	          			<form:select path="dataCntrSeq" cssClass="form-control essential input-sm" title="데이터센터 선택">
		              	<c:forEach var="dataCntr" items="${rrDataCntrListVo}" varStatus="dataCntrListVoVar">
		              		<form:option value="${dataCntr.dataCntrSeq}">${dataCntr.dataCntrNm}</form:option>
		              	</c:forEach>
									</form:select>
							</c:if>
              <c:if test="${rrVo.rsrcReqPrcssStatCd ne '01'}">
              	<c:out value="${rrprVo.dataCntrNm}" />
              </c:if>
          		</td>
						<th><span class="text-red">*</span>클러스터ID</th>
							<c:choose>
								<c:when test="${rrVo.rsrcReqPrcssStatCd eq '01'}">
									<td colspan="3"><c:choose>
											<c:when
												test="${rrprVo.clstrId ne null }">
												<input type="text" id="clstrId" name="clstrId" title="클러스터ID"
													class="form-control essential" maxlength="100"
													value="<c:out value='${rrprVo.clstrId}'/>">
											</c:when>
											<c:otherwise>
												<c:set var="rsrcReqNo" value="${rrprVo.rsrcReqNo}" />
												<c:set var="rsrcReqNoLen" value="${fn:length(rsrcReqNo)}" />
												<c:set var="rsrcReqNoLast4" value="${fn:substring(rsrcReqNo,  rsrcReqNoLen-4 , rsrcReqNoLen )}" />
												<input type="text" id="clstrId" name="clstrId" title="클러스터ID"
													class="form-control essential" maxlength="100"
													value="<c:out value='${rrVo.regionId}_${rrprVo.netClCd}_${rrprVo.vrlzSwTyVl2}_CL_${rrprVo.rsrcReqClstrPropsReqListNm}_${rsrcReqNoLast4}'/>">
											</c:otherwise>
										</c:choose></td>
								</c:when>
								<c:otherwise>
									<td colspan="3" ><c:out value='${rrprVo.clstrId}' /></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="box-footer">
				<div class="pull-right"><button  id="btnProcssStat" class="btn btn-sm btn-hover-gray"  data-toggle="tooltip" title="" data-original-title="진행상태조회" onclick="fn_showProcssClstrAdd(); return false;"><i class="fa fa-file-o"></i>진행상태조회</button></div>
			</div><!-- /box-footer -->
		</div>
	</form:form>
</div><!-- /box-body -->


<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<c:url var="listUrl" value="selectRsrcReqList.do">
			<c:forEach var="curParam" items="${param }">
				<c:if test="${curParam.key ne 'boardSeq'}"><c:param name="${curParam.key }" value="${curParam.value }"></c:param></c:if>
			</c:forEach>
		</c:url>

	    <div class="pull-left btns">
   			<button  class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
		</div>

		<c:choose>
			<c:when test="${rrVo.rsrcReqPrcssStatCd eq '01'  }">
				<div class="pull-right btns">
					<menu:authorize authType="act" onlyOprAdm="true">
						<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="" data-original-title="실행" onclick="javascript:fn_updateRsrcReqPhyClstrAddExe();"><i class="fa fa-play-circle"></i></button>
						<button class="btn btn-sm btn-hover-red" data-toggle="tooltip" title="" data-original-title="반려" onclick="javascript:fn_updateRsrcReqClstrAddRjct();"><i class="fa fa-times"></i></button>
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
 * 실행 결과
 */
function fn_callbackRsrcReqClstrAdd(result){
	if(result.success){
		jInfo(result.messageList, function() {
			fn_reloadPage();
		});
	}else{
		jAlert(result.messageList);
	}
}

/**
 *  화면 재 호출
 */
function fn_reloadPage(){
	location.reload();
	//$("#frm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/formRsrcReqClstAdd.do'/>");
	//$("#frm").submit();
}

/**
 * 실행
 */
function fn_updateRsrcReqPhyClstrAddExe(){

	if(!fn_form_validation("frm")){
		jAlert("클러스터  ID는 반드시 입력하셔야 합니다.", function(){
			$('#clstrId').focus();
		});
		return;
	}
	if($('#clstrId').val()==''){
		jAlert("클러스터  ID는 반드시 입력하셔야 합니다.", function(){
			$('#clstrId').focus();
		});
		return;
	}

	jConfirm("실행하시겠습니까", function(result){
		$.ncmsLoding.startFullScreen();
		$.post('updateRsrcReqPhyRsrcExe.do', $('#frm').serialize(), fn_callbackRsrcReqClstrAdd, 'json').always(function(){$.ncmsLoding.remove();});
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
function fn_updateRsrcReqClstrAddRjct(){
	var url = 'selectRsrcReqRjctP.do';
	var rsrcReqNo = $('#frm #rsrcReqNo').val();
	var rsrcReqSeq = $('#frm #rsrcReqSeq').val();
	var rsrcReqTyCd = $('#frm #rsrcReqTyCd').val();
	var params = { rsrcReqNo : rsrcReqNo , rsrcReqSeq : rsrcReqSeq, rsrcReqTyCd: rsrcReqTyCd };

	var width = 740;
	var height = 290;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {key:"RsrcReqRjct", width:width , height:height, posX : posX , posY : posY};

	windowOpen(url, params, args);
}

/**
 *  진행상태 팝업
 */
function fn_showProcssClstrAdd(){
	var params = { rsrcReqNo : $('#rsrcReqNo').val() , rsrcReqSeq : $('#rsrcReqSeq').val()};
	var args = {key:"selectRsrcReqExeListP", width: 1100 , height: 710 };
	windowOpen('selectRsrcReqExeListP.do', params, args);
	return false;
}

</script>