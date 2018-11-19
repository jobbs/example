<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자동확장 요청 화면</pre>
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 04. 28.
 * @lastmodified 2017. 04. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 05. 12.     x         v1.0             최초생성
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

<script type="text/javascript" src="<c:url value="/resources/js/common/validation.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/FileUtils.js" />" charset="UTF-8"></script>

<form:form commandName="rsrcReqMngVo" name="rsrcReqFrm"	id="rsrcReqFrm" method="post" action="">
	<form:hidden path="rsrcReqClCd" title="자원요청구분코드"  />
	<form:hidden path="rsrcReqNo" title="자원요청번호"  />
	<form:hidden path="rsrcReqPrcssStatCd" title="자원요청진행상태코드"  />

<div class="col-box-100 detail-col">

    <!--  기본정보 시작  -->
    <div class="box detail-list-box">
		<div class="box-header">
		    <h3 class="box-title">기본 정보</h3>
		</div><!-- /box-header -->

		<div class="box-body no-padding">
		    <table class="table table-horizon">
		   		<caption>기본정보</caption>
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
						<th>제목</th><td colspan="3"><c:out value="${rsrcReqMngVo.sbjct }"/></td>
						<th>상태</th>
						<td>
							<span class="status <c:choose>
								<c:when test="${'01' eq rsrcReqMngVo.rsrcReqPrcssStatCd}"><c:out value="status-blue"/></c:when>
								<c:when test="${'02' eq rsrcReqMngVo.rsrcReqPrcssStatCd}"><c:out value="status-yellow"/></c:when>
								<c:when test="${'03' eq rsrcReqMngVo.rsrcReqPrcssStatCd}"><c:out value="status-green"/></c:when>
								<c:when test="${'04' eq rsrcReqMngVo.rsrcReqPrcssStatCd}"><c:out value="status-aqua"/></c:when>
								<c:when test="${'05' eq rsrcReqMngVo.rsrcReqPrcssStatCd}"><c:out value="status-red"/></c:when>
								<c:when test="${'06' eq rsrcReqMngVo.rsrcReqPrcssStatCd}"><c:out value="status-gray"/></c:when>
									<c:otherwise><c:out value="status-gray"/></c:otherwise>
								</c:choose>
							status-red "><c:out value="${rsrcReqMngVo.rsrcReqPrcssStatNm}"/></span>
						</td>
						<th>티켓번호</th><td><c:out value="${rsrcReqMngVo.ticktNo }"/></td>
					</tr>
				    <tr>
						<th>요청번호</th><td><c:out value="${rsrcReqMngVo.rsrcReqNo }"/></td>
						<th>요청일시</th><td><c:out value="${rsrcReqMngVo.rsrcReqDttm }"/></td>
						<th>요청유형</th><td><c:out value="${rsrcReqMngVo.rsrcReqTyNm }"/></td>
						<th>등록자</th><td><c:out value="${rsrcReqMngVo.regUserNm }"/></td>
					</tr>
					<tr>
						<th>요청자</th><td><c:out value="${rsrcReqMngVo.rsrcReqUsrNm }"/></td>
						<th>요청부처</th><td><c:out value="${rsrcReqMngVo.reqInstitutionNm }"/></td>
						<th>핸드폰</th><td><c:out value="${rsrcReqMngVo.rsrcReqMobile }"/></td>
						<th>이메일</th><td><c:out value="${rsrcReqMngVo.rsrcReqEmail }"/></td>
					</tr>
					<tr>
						<th>완료자</th><td><c:out value="${rsrcReqMngVo.exeUserNm }"/></td>
						<th>완료일시</th><td colspan="5"><c:out value="${rsrcReqMngVo.comptDttm }"/></td>
					</tr>
				</tbody>
		    </table>
		</div>
	</div>
	<!--  기본정보 끝  -->

	<!--  상세정보  시작  -->
	<div class="box">
        <div class="box-header">
            <h3 class="box-title">상세정보</h3>
        </div>

		<div class="box-body no-padding">
		    <table class="table table-horizon">
				<caption>자동확장요청 상세 정보</caption>
				<colgroup>
					<col class="col10">
					<col class="col90">
				</colgroup>
				<tbody>
					<tr>
						<th>센터</th>
						<td><c:out value="${rsrcReqMngVo.regionNm }"/></td>
					</tr>
					<tr>
					  <th>요청내용</th>
                      <td class="editor">
                      	<form:textarea path="reqCn" cssClass="form-control essential" title="요청내용" rows="5" maxlength="1000" readonly="true" />

                      </td>
					</tr>
					<tr>
                        <th>첨부파일</th>
                        <td>
							<c:url var="downUrl" value="rsrcReqDownfile.do">
								<c:param name="rsrcReqNo" value="${rsrcReqMngVo.rsrcReqNo }"/>
							</c:url>
							<a href="<c:out value="${downUrl }" />"><c:out value="${rsrcReqMngVo.oriAtchFileNm }"/></a>
						</td>
                    </tr>
				</tbody>
			</table>
		</div>
	</div>
	<!--  상세정보  끝  -->

</div>
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
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectRsrcReqMngList()"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize authType="act" onlyOprAdm="true">
	    		<button id = "saveRsrcReqBtn" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="완료" onclick="javascript:fn_cmpltRsrcReq()"><i class="fa fa-check"></i></button>
	    	</menu:authorize>

			<menu:modAuthorize regId="${rsrcReqMngVo.regUserId }">
	    		<button id = "deleteRsrcReqBtn" class="btn btn-sm btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="javascript:fn_deleteRsrcReq()"><i class="fa fa-minus"></i></button>
	    	</menu:modAuthorize>
		</div>
	</div>
</div>

<script type="text/javascript">

$(function() {
	fn_initUI();
});

//버튼 제어
function fn_initUI(){
	var procssStat = $("#rsrcReqPrcssStatCd").val();

	if(procssStat =='03'){
		$('#saveRsrcReqBtn').hide();
		//$('#deleteRsrcReqBtn').hide();
	}
}


// 뒤로 버튼 클릭 시
function fn_selectRsrcReqMngList(){
	location.href = '<c:url value="selectRsrcReqList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'servcAreaSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}


// 완료버튼 클릭 시
function fn_cmpltRsrcReq() {
	jConfirm("완료하시겠습니까?", function(){

		$('#rsrcReqPrcssStatCd').val("03"); //완료
		$.ncmsLoding.startFullScreen();
		$.post('updateRsrcReqExeInfo.do', $('#rsrcReqFrm').serialize(), fn_cmpltRsrcReqResultHandler, 'json').always(function(){$.ncmsLoding.remove();});
	});
}


//삭제 버튼 클릭 시
function fn_deleteRsrcReq() {
	jConfirm('삭제 하시겠습니까?', function(){
		$.ncmsLoding.startFullScreen();
		$.post('updateRsrcReqDeleteYn.do', $('#rsrcReqFrm').serialize(), function(result) {

			jInfo(result.messageList, function() {
				if( result.success) {
					goToUrl('${listUrl}');
				}
			});

		}, 'json').always(function(){$.ncmsLoding.remove();});
	});
}


// 완료 결과 콜백
function fn_cmpltRsrcReqResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo(result.messageList, function(){
			fn_selectRsrcReqMngList();
		});
	}
	else{
		alert_message(result.messageList)
	}
}

</script>
