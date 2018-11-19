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
	<input type="hidden" title="서비스영역SEQ" name="servcAreaSeq" id="servcAreaSeq" value="${servcAreaSeq }" />
	<input type="hidden" title="서비스영역ID" name="servcAreaId" id="servcAreaId" value="${servcAreaId }" />
	<input type="hidden" title="서비스SEQ" name="servcSeq" id="servcSeq" value="${servcSeq }" />
	<input type="hidden" title="배포설정Id" name="distrbConfId" id="distrbConfId" value="${distrbConfId }" />
	<input type="hidden" title="센터Id" name="regionId" id="regionId" value="${regionId }" />
	<input type="hidden" title="존Id" name="zoneId" id="zoneId" value="${zoneId }" />
	<input type="hidden" title="망구분코드" name="netClCd" id="netClCd" value="${netClCd }" />
	<input type="hidden" title="자원풀ID" name="rsrcPoolId" id="rsrcPoolId" value="${rsrcPoolId }" />
	<input type="hidden" title="할당스토리지용량" name="strgAsgnCapa" id="strgAsgnCapa" value="" />
	<input type="hidden" title="요청스토리지용량" name="reqStrgCapa" id="reqStrgCapa" value="" />
	<input type="hidden" title="접근구분코드" name="accssModeClCd" id="accssModeClCd" value="" />
	<input type="hidden" title="pv명" name="pvNm" id="pvNm" />
	<input type="hidden" title="pvID" name="pvId" id="pvId" />
<div class="box">
		<div class="box-body no-padding">

				<table class="table table-hover table-vertical" id="atmsclDistrbStrgTable">
					<caption>스토리지 선택 테이블</caption>

				<colgroup>
					<col class="col10">
					<col class="col20">
					<col class="col10">
					<col class="col20">
	      		</colgroup>

					<tbody>
						<tr>
							<th><label for="strgPvNm"><span class="text-red">*</span>스토리지 선택</label></th>
							<td colspan="3">
								<select id="strgPvNm" title="스토리지 선택" name="strgPvNm" class="form-control input-sm essential" onchange="changePvInfo(this);">
									<option value="">스토리지를 선택해주세요.</option>
									<c:forEach var="vo" items="${selectAtmsclStrg}" >
											<option value="${vo.strgAsgnCapa}-${vo.accssModeClCd}-${vo.pvId}">${vo.pvNm }</option>
									</c:forEach>
								</select>
							</td>
			            </tr>
			            <tr>
							<th><label for="mountPath"><span class="text-red">*</span>마운트 경로</label></th>
							<td>
								<input type="text" name="mountPath" id="mountPath" class="form-control essential"  placeholder="example: /data" title="마운트 경로" />
							</td>
							<th><label for="volumeNm"><span class="text-red">*</span>볼륨명</label></th>
							<td>
								<input type="text" name="volumeNm" id="volumeNm" class="form-control essential"  title="볼륨명" />
							</td>
			            </tr>
					</tbody>
				</table>
		</div>

</div>

	</form:form>
</div>
<div class="col-box-100">
	<div class="button">
		<menu:authorize>
			<button type="button" class="btn btn-dark" onclick="strgAdd();">할당</button>
		</menu:authorize>
		<button type="button" class="btn close-window">닫기</button>
	</div>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {


	});
	function changePvInfo(){
		var index = $("#strgPvNm option").index($("#strgPvNm option:selected"));
		var strgAsgnAndAccss = $("#strgPvNm option:selected").val();
		var data = strgAsgnAndAccss.split('-');
		var pvNm = $("#strgPvNm option:selected").text();
		$("#reqStrgCapa").val(data[0]);
		$("#accssModeClCd").val(data[1]);
		$("#pvId").val(data[2]);
		$("#pvNm").val(pvNm);


	}


    function strgAdd(){

    	if(!fn_form_validation("atmsclDistrbVo")){
    		return;
    	}


		var regId = /^[a-zA-Z0-9]+$/;
		var regId2 = /^\/[\/\-\_a-zA-Z0-9]+$/;

    	var pvSelectedCheck = $("#strgPvNm option:selected").val();
    	var mountPathCheck = $("#mountPath").val();
    	var volumNmCheck = $("#volumeNm").val();
    	if( pvSelectedCheck == "" || pvSelectedCheck == "undefined") {
    		jAlert("스토리지를 선택하여 주시기 바랍니다.");
    		return;
    	}

    	if (mountPathCheck == "" || mountPathCheck == "undefined") {
    		jAlert("마운트 경로를 입력해 주시기 바랍니다.", function() {$("#mountPath").focus(); } );
    		return;
    	}else if("/" != mountPathCheck[0] ){
    		jAlert("마운트 경로를 확인해 주시기 바랍니다.", function() {$("#mountPath").focus(); } );
    		return;
    	}else if(!regId2.test(mountPathCheck) ){
    		jAlert("마운트 경로는 영문/숫자(-,_)만 가능합니다.", function() {$("#mountPath").focus(); } );
    		return;
    	}
    	volumeNm
		if (volumNmCheck == "" || volumNmCheck == "undefined") {
			jAlert("볼륨명을 입력해 주시기 바랍니다.", function() { $("#volumeNm").focus(); });
    		return;
    	}else if(!regId.test(volumNmCheck)){
			jAlert("볼륨명은 영문과 숫자만 입력해 주시기 바랍니다.", function() { $("#volumeNm").focus(); });
    		return;
		}

	   jConfirm('스토리지 할당 하시겠습니까?', function(){
			var options = {
				type: 'post',
				dataType: 'json',
				success: insertStrgResultHandler,
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

			$('#atmsclDistrbVo').attr('action', '<c:url value="insertPvcStrgAdd.do"/>');
			$('#atmsclDistrbVo').ajaxSubmit(options);
		});
    }
  //생성 결과 콜백
    function insertStrgResultHandler(result){

    	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

    	if(result.success){
    		jInfo(result.messageList, function(){
    			window.close();
   		       window.opener.parent.location.reload();
    		});
    	}
    	else{
    		alert_message(result.messageList)
    	}
    }

</script>