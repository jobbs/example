<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
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
 * 2017. 04. 28.     x         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>




<div class="col-box-100">
<form:form commandName="atmsclDistrbVo">
<input type="hidden" title="서비스영역ID" name="servcAreaId" id="servcAreaId" value="${servcAreaId }" />
<input type="hidden" title="서비스SEQ" name="servcSeq" id="servcSeq" value="${servcSeq }" />
<input type="hidden" title="배포설정Id" name="distrbConfId" id="distrbConfId" value="${distrbConfId }" />
<input type="hidden" title="센터Id" name="regionId" id="regionId" value="${regionId }" />
<input type="hidden" title="존Id" name="zoneId" id="zoneId" value="${zoneId }" />
<input type="hidden" title="망구분코드" name="netClCd" id="netClCd" value="${netClCd }" />
<input type="hidden" title="자원풀ID" name="rsrcPoolId" id="rsrcPoolId" value="${rsrcPoolId }" />
<input type="hidden" title="등록자ID" name="regUserId" id="regUserId" value="${regUserId }" />

<input type="hidden" title="요청CPU(Core)" name="reqCpuCorQty" id="reqCpuCorQty"  />
<input type="hidden" title="제한CPU(Core)" name="lmttCpuCorQty" id="lmttCpuCorQty"  />
<input type="hidden" title="요청메모리(GB)" name="reqMemCapa" id="reqMemCapa"  />
<input type="hidden" title="제한메모리(GB)" name="lmttMemCapa" id="lmttMemCapa"  />
<input type="hidden" title="배포ID" name="distrbId" id="distrbId" value="${distrbId }" />

<div class="box">
		<div class="box-body no-padding">

				<table class="table table-hover table-vertical" id="atmsclDistrbStrgTable">
					<caption>자원 제한 테이블</caption>

				<colgroup>
					<col class="col10">
					<col class="col20">
					<col class="col10">
					<col class="col20">
	      		</colgroup>

					<tbody>
						<tr>
							<th><span class="text-red">*</span>요청CPU(Core)</th>
							<td>
								<input type="number" id="inReqCpuCorQty" class="form-control essential onlyFloat" step="0.01" min="0.01" maxlength="3"  max="256" title="요청CPU(Core)" value="${reqCpuCorQty}"/>
							</td>
							<th><span class="text-red">*</span>제한CPU(Core)</th>
							<td><input type="number" id="inLmttCpuCorQty" class="form-control essential onlyInteger" step="1" min="1" max="256" title="제한CPU(Core)"  value="${lmttCpuCorQty}"  maxlength="3"/></td>
			            </tr>
			            	<tr>
							<th><span class="text-red">*</span>요청메모리(GB)</th>
							<td><input type="number" id="inReqMemCapa" class="form-control essential"  step="0.01" min="0.01" maxlength="3" max="256"  title="요청메모리(GB)" value="${reqMemCapa}"/></td>
							<th><span class="text-red">*</span>제한메모리(GB)</th>
							<td><input type="number" id="inLmttMemCapa" class="form-control essential" title="제한메모리(GB)" step="1" min="1" max="256" maxlength="3"  value="${lmttMemCapa}"/></td>
			            </tr>
					</tbody>
				</table>
		</div>

</div>
</div>
</form:form>
<div class="col-box-100">
	<div class="button">
		<menu:authorize>
		<button type="button" class="btn btn-dark" onclick="rsrcLtAdd();">설정</button>
		</menu:authorize>
		<button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
	</div>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {


	});

    function rsrcLtAdd(){

    	if(!fn_form_validation("atmsclDistrbVo")){
    		return;
    	}


		jConfirm('자원제한 하시겠습니까?', function(){
			$("#reqCpuCorQty").val($("#inReqCpuCorQty").val());
			$("#lmttCpuCorQty").val($("#inLmttCpuCorQty").val());
			$("#reqMemCapa").val($("#inReqMemCapa").val());
			$("#lmttMemCapa").val($("#inLmttMemCapa").val());

			var options = {
				type: 'post',
				dataType: 'json',
				success: insertRsrcLtResultHandler,
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

			$('#atmsclDistrbVo').attr('action', contextPath+'/cpt/rsrc/atmscl/atmsclDistrb/updateRsrcLt.do');
			$('#atmsclDistrbVo').ajaxSubmit(options);

		});
    }
  //생성 결과 콜백
    function insertRsrcLtResultHandler(result){

    	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

    	if(result.success){
    		jInfo(result.messageList, function(){
    			window.opener.parent.location.reload();
    			window.close();

    		});
    	}
    	else{
    		alert_message(result.messageList)
    	}
    }
    function maxLengthCheck(data){
   		if(data.value.length > data.maxLength){
    		data.value = data.value.slice(0,data.maxLength)
    	}
    }
</script>