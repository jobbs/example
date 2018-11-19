<%--
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre>보안키생성 화면</pre>
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
 * 2017. 05. 13.     x         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div class="col-box-100">
	<div class="info">
		<h2>보안키 ID 입력시 유의사항</h2>
		<p>- 영문 소문자, 숫자, 대쉬(-) 만 입력 가능합니다. (한글 불가)</p>
		<p>- 대쉬(-)는 시작 또는 마지막에 사용할 수 없습니다.</p>
	</div>
</div>


<div class="col-box-100">
	<form:form id="scrtkyVo" commandName="scrtkyVo">
		<form:hidden path="servcAreaSeq" title="서비스영역SEQ"  />
		<form:hidden path="servcAreaId" title="서비스영역ID"  />
		<form:hidden path="regionId" title="센터"  />
		<form:hidden path="zoneId" title="존"  />
		<form:hidden path="netClCd" title="망"  />
		<form:hidden path="rsrcPoolId" title="자원풀"  />

		<div class="box">
			<div class="box-body no-padding" style="">
				<table class="table table-horizon">
                        <caption>보안키 정보</caption>
                        <colgroup>
                            <col class="col20">
							<col class="col30">
							<col class="col20">
							<col class="col30">
                        </colgroup>
                        <tbody>
                        <tr>
                        	<th><label for="scrtkyId"><span class="text-red">*</span>보안키 ID</label></th>
						    <td colspan="3">
							    <form:input path="scrtkyId" title="보안키ID" cssClass="form-control essential" value="" maxlength="50" />
							</td>
						</tr>
						<tr>
							<th><label for="id"><span class="text-red">*</span>사용자ID</label></th>
						    <td>
						    	<form:input path="id" title="사용자ID" cssClass="form-control essential" value="" maxlength="50"/>
							</td>
							<th><label for="passwd"><span class="text-red">*</span>사용자 Password</label></th>
						    <td>
						    	<form:input path="passwd"  type="password" title="사용자 Password" cssClass="form-control essential" value="" maxlength="50"/>
							</td>
						</tr>
                    </tbody>
                </table>
			</div>
		<!-- /box-body -->
		</div>
	</form:form>
</div>
<!-- popup 버튼 -->
<div class="col-box-100">
  <div class="button">
  	<button type="button" class="btn btn-dark" onclick="fn_insertScrty()">생성</button>
  	<button type="button" class="btn close-window" >닫기</button>
   </div>
</div>
<!-- /popup 버튼 -->


<script type="text/javascript">

//정규식체크
function fn_checkStr(checkstr) {
	var reg = /^[a-z0-9]([-a-z0-9]*[a-z0-9])?$/
	return reg.test(checkstr);
}

//생성 버튼 클릭 시
function fn_insertScrty(){

	if(!fn_form_validation("scrtkyVo")){
		return;
	}

	if(!fn_checkStr($('#scrtkyId').val())) {
		jAlert('보안키 ID를 다시 입력해 주세요. \n(보안키 ID 입력시 유의사항을 확인 후 입력해 주세요.)');
		return;
	}

	jConfirm('보안키를 생성 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: insertScrtyResultHandler,
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

		$('#scrtkyVo').attr('action', '<c:url value="insertScrtky.do"/>');
		$('#scrtkyVo').ajaxSubmit(options);

	});
}

//생성 결과 콜백
function insertScrtyResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo(result.messageList, function(){
			opener.fn_setScrtky($("#servcAreaSeq").val());
			self.close();
		});
	}
	else{
		alert_message(result.messageList)
	}
}


</script>