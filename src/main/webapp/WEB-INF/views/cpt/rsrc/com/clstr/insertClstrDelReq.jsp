<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>클러스터 삭제 요청 화면</pre>
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     심원보         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<form:form commandName="rsrcReqVo">
<!-- 등록/상세 영역 -->
<div class="col-box-100 detail-col">
	<c:set var="rsrcReqVoClass" value="ncis.cpt.rsrc.com.vo.RsrcReqVo"/>
	<c:set var="rsrcReqPhyRsrcVoClass" value="ncis.cpt.rsrc.com.vo.RsrcReqPhyRsrcVo"/>
	<c:set var="groupClass" value="ncis.cpt.rsrc.com.validation.InsertClstrDelReqValidation"/>
	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">요청정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
	  		<table class="table table-horizon">
	  			<caption>요청정보</caption>
	    		<colgroup>
					<col class="col20">
					<col class="col30">
					<col class="col20">
					<col class="col30">
      			</colgroup>
				<tbody>
					<tr>
						<th><span class="text-red">*</span>제목</th>
						<td>
							<form:input path="sbjct" name="sbjct" title="제목" cssClass="form-control essential" value="" maxlength="${ivu.getMaxlength(rsrcReqVoClass, 'sbjct', groupClass)}"/>
						</td>
						<th><span class="text-red">*</span>테스트여부</th>
						<td class="alignL">
							<div class="input-group input-group-radio">
								<form:radiobutton path="testYn" name="testYn" title="테스트여부" cssClass="essential" label="예" value="Y"/>
								<form:radiobutton path="testYn" name="testYn" title="테스트여부" cssClass="essential" label="아니오" value="N"/>
							</div>
						</td>
		            </tr>
		            <tr>
						<th><span class="text-red">*</span>티켓번호</th>
						<td>
							<form:input path="ticktNo" name="ticktNo" title="티켓번호" cssClass="form-control essential" value="" maxlength="${ivu.getMaxlength(rsrcReqVoClass, 'ticktNo', groupClass)}"/>
						</td><td></td><td></td>
		            </tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">삭제할 클러스터 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
	  		<table class="table table-horizon">
	  			<caption>삭제할 클러스터 정보</caption>
	    		<colgroup>
					<col class="col20">
					<col class="col30">
					<col class="col20">
					<col class="col30">
				</colgroup>
				<tbody>
					<tr>
						<th>클러스터명</th>
						<td>
							<form:hidden path="regionId" name="regionId" title="센터" value="${clstrVo.regionId }"/>
							<form:hidden path="rsrcReqPhyRsrcVoList[0].clstrSeq" name="rsrcReqPhyRsrcVoList[0].clstrSeq" title="클러스터" value="${clstrVo.clstrSeq }"/>
							<form:hidden path="rsrcReqPhyRsrcVoList[0].clstrCompId" name="rsrcReqPhyRsrcVoList[0].clstrCompId" title="클러스터구성ID" value="${clstrVo.clstrCompId }"/>
							<c:out value="${clstrVo.clstrNm }"/>
						</td>
						<th>클러스터ID</th>
						<td>
							<c:out value="${clstrVo.clstrId }"/>
						</td>
					</tr>
                </tbody>
			</table>
		</div>
	</div>
</div>
</form:form>

<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectClstrList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize onlyOprAdm="true">
				<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="요청" data-original-title="요청" onclick="fn_insertClstrDelReq();"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>

<script type="text/javascript">
//뒤로
function fn_selectClstrList(){
	location.href = '<c:url value="selectClstrList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'clstrSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

function fn_insertClstrDelReq(){

	if(!fn_form_validation("rsrcReqVo")){
		return;
	}

	jConfirm('클러스터를 삭제 요청하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: insertClstrDelReqResultHandler,
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

		$('#rsrcReqVo').attr('action', '<c:url value="insertClstrDelReq.do"/>');
		$('#rsrcReqVo').ajaxSubmit(options);

	});
}

function insertClstrDelReqResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo(result.messageList, function(){
			fn_selectClstrList();
		});
	}
	else{
		alert_message(result.messageList);
	}

}
</script>
