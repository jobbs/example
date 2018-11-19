<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이제율
 * @lastmodifier 이제율
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     이제율         v1.0             최초생성
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

<div class="col-box-40 detail-col no-padding-right">
	<form:form commandName="userMngVo">
	<form:hidden path="rev" value="${userMngVo._rev }"/>
	<form:hidden path="statCd" value="${userMngVo.statCd }"/>
          <!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
          <!-- box(목록조회 테이블) -->
          <div class="box">

            <div class="box-body no-padding">
              <table class="table table-horizon">
              <caption>사용관리(로그인)</caption>
                <colgroup>
                  	<col class="col20">
					<col class="col20">
                </colgroup>
                <tbody>
                	<tr>
                    	<th><label for="regionId">API-Gateway</label></th>
	                    <td>
	                    	<nform:selectRegion
		                    	path="regionId"
		                    	name="regionId"
								id="regionId"
								title="API-Gateway"
								cssClass="form-control essential"
								wholeText="전체"
								byRole="false" />
	                    </td>
                  	</tr>
         			<tr>
           				<th><label for="sysCd">신청시스템</label></th>
           				<td>
           					<nform:selectCode parentCd="208"
								parentGrpCd="046"
								name="sysCd"
								id="sysCd"
								whole="true"
								title="신청시스템"
								cssClass="form-control essential"/>
           				</td>
         			</tr>
         			<tr>
           				<th><label for="passwd">비밀번호</label></th>
           				<td>
           					<form:input title="비밀번호" path="passwd" type="password" class="form-control essential" maxlength="60"/>
           				</td>
         			</tr>
                </tbody>
              </table>
            </div><!-- /box-body -->
            <div class="box-footer clearfix">
              <div class="pull-right">
              </div>
            </div><!-- /box-footer -->
          </div><!-- /box -->
	</form:form>
</div>
<div class="col-box-60 detail-col no-padding-left">
	<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
	<!-- box(목록조회 테이블) -->
	<div class="box">
 		<div class="box-body no-padding">
 			<table class="table table-horizon">
				<colgroup>
					<col class="col100">
				</colgroup>
        		<tbody>
        			<tr>
						<td style="border-left: 1px solid #ddd;">
 							<button type="button" class="btn btn-blue btn-3vh" style="width:100px;" onclick="fn_doLogin();">로그인</button>
       					</td>
					</tr>
  				</tbody>
			</table>
		</div><!-- /box-body -->
		<div class="box-footer clearfix">
			<div class="pull-right">
			</div>
		</div><!-- /box-footer -->
	</div><!-- /box -->
</div>
<script type="text/javascript">
$(document).ready(function() {
	console.log($("#passwd").attr("tabindex"));
});

//로그인 체크
function fn_doLogin() {
	if (!fn_form_validation("userMngVo")) {
		return;
	}

	$.ncmsLoding.startFullScreen();
	$.post(	'selectLoginChk.do',
		$('#userMngVo').serialize(), function(result) {
			alert_message(result.messageList, function() {
				if (result.success) {
					location.href = "selectUseMngLogin.do?useReqId="
							+ $('select[name=regionId]').val() + "_"
							+ $('select[name=sysCd]').val();
				}
			}, (result.success ? "INFO" : ""));
		}, 'json').always(function() {
		$.ncmsLoding.remove();
	});
}

//비밀번호 초기화
function fn_passwdInit() {
	if ($("#sysCd").val() == "") {
		parent.jAlert("비밀번호 초기화 요청 시 신청시스템을 선택해야 합니다.");
		return;
	}

	$.ncmsLoding.startFullScreen();
	$.post('updateReqUserPasswd.do', $('#userMngVo').serialize(),
		function(result) {
			alert_message(result.messageList, function() {
				if (result.success) {
					if (result.procType == "update") {
						location.href = "selectUseLogin.do";
					}
				}
			}, (result.success ? "INFO" : ""));
		}, 'json').always(function() {
		$.ncmsLoding.remove();
	});
}

$("#passwd").keydown(function(e) { if (e.keyCode == '13') fn_doLogin(); });
</script>