<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>
 	물리서버 삭제 요청
 </pre>
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 14.
 * @lastmodified 2016. 10. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 14.     최경철         v1.0             최초생성
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
	<c:set var="rsrcReqPmVoClass" value="ncis.cpt.rsrc.com.vo.RsrcReqPmVo"/>
	<c:set var="groupClass" value="ncis.cpt.rsrc.com.validation.InsertPmDelReqValidation"/>
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
	  		<caption>물리서버 삭제 요청 정보 테이블</caption>
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
							<form:input path="sbjct" name="sbjct" title="제목" cssClass="form-control input-sm essential" value="" maxlength="${ivu.getMaxlength(rsrcReqVoClass, 'sbjct', groupClass)}"/>
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
							<form:input path="ticktNo" name="ticktNo" title="티켓번호" cssClass="form-control input-sm essential" value="" maxlength="${ivu.getMaxlength(rsrcReqVoClass, 'ticktNo', groupClass)}"/>
						</td>
						<td colspan="2"></td>
		            </tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">삭제할 물리서버 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
	  		<table class="table table-horizon">
	  		<caption>삭제할 물리서버 정보 테이블</caption>
	    		<colgroup>
						<col class="col20">
						<col class="col30">
						<col class="col20">
						<col class="col30">
          </colgroup>
          <tbody>
					<tr>
						<th>물리서버명</th>
						<td>
							<form:hidden path="regionId" name="regionId" title="센터" value="${pmVo.regionId }"/>
							<form:hidden path="rsrcReqPmVoList[0].pmCompId" name="rsrcReqPmVoList[0].pmCompId" title="물리서버구성ID" value="${pmVo.pmCompId }"/>
							<form:hidden path="rsrcReqPmVoList[0].pmNm" name="rsrcReqPmVoList[0].pmNm" title="물리서버명" value="${pmVo.pmNm }"/>
							<form:hidden path="rsrcReqPmVoList[0].pmId" name="rsrcReqPmVoList[0].pmId" title="물리서버ID" value="${pmVo.pmId }"/>
							<form:hidden path="rsrcReqPmVoList[0].pmSeq" name="rsrcReqPmVoList[0].pmSeq" title="물리서버SEQ" value="${pmVo.pmSeq }"/>
							<c:out value="${pmVo.pmNm }"/>
						</td>
						<th>물리서버ID</th>
						<td>
							<c:out value="${pmVo.pmId }"/>
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
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectPmList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize onlyOprAdm="true">
				<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="요청" data-original-title="요청" onclick="fn_insertPmDelReq();"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>

<script type="text/javascript">

//뒤로
function fn_selectPmList(){
	location.href = '<c:url value="selectPmList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'pmSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

function fn_insertPmDelReq(){

	if(!fn_form_validation("rsrcReqVo")){
		return;
	}
	jConfirm('물리서버를 삭제 요청하시겠습니까?', function(){


		var options = {
			type: 'post',
			dataType: 'json',
			success: insertPmDelReqResultHandler,
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

		$('#rsrcReqVo').attr('action', 'insertPmDelReq.do');
		$('#rsrcReqVo').ajaxSubmit(options);

	});
}

function insertPmDelReqResultHandler(result){

	if(result.success){
		jInfo(result.messageList, function(){
			location.href = '<c:url value="selectPmList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'pmSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
		});
	}
	else{
		jAlert(result.messageList);
	}

}
</script>