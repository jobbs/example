<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자원요청상세 -반려 (팝업)</pre>
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 7.
 * @lastmodified 2016. 10. 7.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 7.     김봉민         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>


<div class="col-box-100">
	<div class="box">
		<form:form commandName="rsrcReqVo" name="frm" id="frm" method="post" action="">
			<form:hidden path="rsrcReqNo" value="${rsrcReqVo.rsrcReqNo}"/>
			<form:hidden path="rsrcReqSeq" value="${rsrcReqVo.rsrcReqSeq}"/>
			<form:hidden path="rsrcReqTyCd" value="${rsrcReqVo.rsrcReqTyCd}"/>

			<div class="box-header"><h3 class="box-title">반려정보</h3></div>
			<div class="box-body no-padding">
				<table class="table table-horizon">
					<caption>반려 실행 정보 </caption>
				 	<colgroup>
						<col class="col20">
						<col class="col30">
						<col class="col20">
						<col class="col30">
					</colgroup>
					<tbody>
				    	<tr><th class="alignC"><label>반려유형</label></th><td colspan="3">
				        		<div class="cell-body">
				            		<form:select path="rjctTyCd" cssClass="form-control input-sm" title="반려유형">
										<c:forEach var="cd" items="${codeList}" varStatus="i">
											<form:option value="${cd.cd}">${cd.cdNm}</form:option>
										</c:forEach>
									</form:select>
								</div></td></tr>
						<tr><th class="alignC"><label>반려사유</label></th><td colspan="3"><form:textarea path="rjctReasn" class="form-control" rows="3" placeholder="내용을 입력해 주세요." title="반려시유" maxlength="1000" /></td></tr>
					</tbody>
				</table><!-- /box-body(반려정보) -->
			</div>
		</form:form>
	</div>
</div>

<!-- footer  -->
<div class="col-box-100">
	<div class="button">
		<menu:authorize authType="act">
			<button class="btn btn-dark" data-toggle="tooltip"  data-original-title="반려" onclick="javascript:fn_rsrcReqRjctExe(); return false;">반려</button>
		</menu:authorize>
		<button class="btn close-window" data-toggle="tooltip" data-original-title="닫기" onclick="self.close()">닫기 </button>
	</div>
</div><!-- /footer  -->


<script type="text/javascript">
function fn_callbackRsrcReqRjct(result){
	jInfo(result.messageList, function() {
		if(result.success){
			self.close();
			window.opener.fn_reloadPage();
		}
	});
}

/**
 * 반려실행
 */
function fn_rsrcReqRjctExe(){
	jConfirm("반려하시겠습니까?", function(){
		var ty = $('#frm #rsrcReqTyCd').val();
		if(ty == '04'){
			$.post( contextPath+ '/cpt/opr/req/rsrcreq/updateRsrcReqNetwkRjct.do', $('#frm').serialize() ,fn_callbackRsrcReqRjct, 'json');
		}else if(ty =='05' || ty=='06' || ty == '07' || ty=='08'){
			$.post( contextPath+ '/cpt/opr/req/rsrcreq/updateRsrcReqPhyRsrcRjct.do', $('#frm').serialize() ,fn_callbackRsrcReqRjct, 'json');
		}else if(ty=='01'  || ty=='02' || ty=='03' || ty=='09'  || ty=='10'){
			$.post( contextPath+ '/cpt/opr/req/rsrcreq/updateRsrcReqVmRjct.do', $('#frm').serialize() ,fn_callbackRsrcReqRjct, 'json');
		}else{
			jAlert('자원요청유형코드가 잘못 되었습니다. [Code:'+ ty+"]");
		}
	}, "반려확인");
}
</script>
