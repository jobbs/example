<%--
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre>라우트생성 화면</pre>
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
	<form:form id="servcRouteVo" commandName="servcRouteVo">
		<form:hidden path="servcAreaId" title="서비스영역ID"  />
		<form:hidden path="servcSeq" title="서비스SEQ"  />
		<form:hidden path="servcId" title="서비스ID"  />
		<form:hidden path="regionId" title="센터"  />
		<form:hidden path="zoneId" title="존"  />
		<form:hidden path="netClCd" title="망"  />
		<form:hidden path="rsrcPoolId" title="자원풀"  />

		<div class="box">
			<div class="box-body no-padding" style="overflow-x:auto;">
				<table class="table table-horizon">
                        <caption>라우트 정보</caption>
                        <colgroup>
                            <col class="col20">
							<col class="col30">
							<col class="col20">
							<col class="col30">
                        </colgroup>
                        <tbody>
                        <tr>
                        	<th><label for="servcNm">대상 서비스</label></th>
						    <td colspan="3"><c:out value="${servcRouteVo.servcNm }" />
							</td>
						</tr>
						<tr>
							<th><label for="targtPort"><span class="text-red">*</span>대상 포트</label></th>
						    <td>
							    <form:select path="targtPort" title="포트 선택" cssClass="form-control">
							    	<c:forEach var="vo" items="${servcPortList }" varStatus="i">
							    		<form:option value="${vo.portNm}"><c:out value="${vo.portId }" /></form:option>
							    	</c:forEach>
		                  		</form:select>
							</td>
							<th><label for="hstNm"><span class="text-red">*</span>호스트명</label></th>
						    <td>
						    	<form:input path="hstNm" title="호스트명" cssClass="form-control essential" value="" maxlength="50"/>
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
  	<button type="button" class="btn btn-dark" onclick="fn_insertServcRoute()">생성</button>
  	<button type="button" class="btn close-window" >닫기</button>
   </div>
</div>
<!-- /popup 버튼 -->


<script type="text/javascript">

//생성 버튼 클릭 시
function fn_insertServcRoute(){

	if(!fn_form_validation("servcRouteVo")){
		return;
	}

	if(!fn_checkHstNmStr($('#hstNm').val())) {

		jAlert('호스트명을 다시 입력해 주세요. \n - 영문소문자, 숫자, "-", "." 으로 구성하여 입력해주세요. \n - 시작과 끝은 문자나 숫자로 입력해 주세요.', function() {
			$("#hstNm").focus();
		});

		return;
	}

	jConfirm('라우트를 생성 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: insertServcRouteResultHandler,
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

		$('#servcRouteVo').attr('action', '<c:url value="insertServcRoute.do"/>');
		$('#servcRouteVo').ajaxSubmit(options);

	});
}

//생성 결과 콜백
function insertServcRouteResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo(result.messageList, function(){
			opener.location.reload(true);
			self.close();
		});
	}
	else{
		alert_message(result.messageList)
	}
}

//호스트명 체크
function fn_checkHstNmStr(checkstr) {
	var reg = /^[a-z0-9]([-a-z0-9]*[a-z0-9])?(\.[a-z0-9]([-a-z0-9]*[a-z0-9])?)*$/
	return reg.test(checkstr);
}


</script>