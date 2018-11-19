﻿<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>가상서버 삭제 요청 화면</pre>
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

<!-- 등록/상세 영역 -->
<div class="col-box-100 detail-col">
	<form:form commandName="rsrcReqVo">
	<c:set var="rsrcReqVoClass" value="ncis.cpt.rsrc.com.vo.RsrcReqVo"/>
	<c:set var="rsrcReqVmVoClass" value="ncis.cpt.rsrc.com.vo.RsrcReqVmVo"/>
	<c:set var="groupClass" value="ncis.cpt.rsrc.com.validation.InsertVmDelReqValidation"/>
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
						<td>
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
			<h3 class="box-title">삭제할 가상서버 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
	 		<table class="table table-horizon">
	 			<caption>삭제할 가상서버 정보</caption>
		   		<colgroup>
	     			<col class="col20">
	     			<col class="col30">
	     			<col class="col20">
	     			<col class="col30">
				</colgroup>
				<tbody>
					<tr>
						<th>가상서버명</th>
						<td>
							<form:hidden path="regionId" name="regionId" title="센터" value="${vmVo.regionId }"/>
							<form:hidden path="rsrcReqVmVoList[0].vmSeq" name="rsrcReqVmVoList[0].vmSeq" title="가상서버" value="${vmVo.vmSeq }"/>
							<form:hidden path="rsrcReqVmVoList[0].vmCompId" name="rsrcReqVmVoList[0].vmCompId" title="가상서버구성ID" value="${vmVo.vmCompId }"/>
							<c:out value="${vmVo.vmNm }"/>
						</td>
						<th>가상서버ID</th>
						<td>
							<c:out value="${vmVo.vmId }"/>
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
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectVmList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize onlyOprAdm="true">
				<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="요청" data-original-title="요청" onclick="fn_insertVmDelReq();"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>

<script type="text/javascript">

//뒤로
function fn_selectVmList(){
	location.href = '<c:url value="selectVmList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'vmSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

function fn_insertVmDelReq(){

	if(!fn_form_validation("rsrcReqVo")){
		return;
	}

	jConfirm('가상서버를 삭제 요청하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: insertVmDelReqResultHandler,
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

		$('#rsrcReqVo').attr('action', '<c:url value="insertVmDelReq.do"/>');
		$('#rsrcReqVo').ajaxSubmit(options);

	});
}

function insertVmDelReqResultHandler(result){

	if(result.success){
		jInfo(result.messageList, function(){
			fn_selectVmList();
		});
	}
	else{
		jAlert(result.messageList);
	}

}
</script>
