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
	<div class="box-header">
				<h3 class="box-title">쿼터 정보</h3>
				<div class="box-tools">
					<div class="pull-right">
					</div>
				</div>
			</div>
		<div class="box-body no-padding">

				<table class="table table-vertical">
					<caption>쿼터 테이블</caption>

				<colgroup>
					<col class="col10">
					<col class="col20">
					<col class="col10">
					<col class="col10">
					<col class="col20">
					<col class="col10">
	      		</colgroup>

					<tbody>

						<tr>
							<th>최소CPU</th>
							<td class="alignL">
								<c:out value="${selectPodQuata.minCpuCorQty}"/>
							</td>
							<td class="alignC">Core</td>
							<th>최대CPU</th>
							<td class="alignL">
								<fmt:parseNumber var="maxCpuCorQty" integerOnly="true" type="number" value="${selectPodQuata.maxCpuCorQty}"/>
								<c:out value="${maxCpuCorQty}"/>
							</td>
							<td class="alignC">Core</td>
			            </tr>
						<tr>
							<th>최소메모리</th>
							<td class="alignL">
								<c:out value="${selectPodQuata.minMemCapa}"/>
							</td>

							<td class="alignC">GB</td>
							<th>최대메모리</th>
							<td class="alignL">
								<fmt:parseNumber var="maxMemCapa" integerOnly="true" type="number" value="${selectPodQuata.maxMemCapa}"/>
								<c:out value="${maxMemCapa}"/>
							</td>
							<td class="alignC">GB</td>
			            </tr>
					</tbody>
				</table>
		</div>

</div>

<div class="box">
	<div class="box-header">
				<h3 class="box-title">제한 정보</h3>
				<div class="box-tools">
					<div class="pull-right">
					</div>
				</div>
			</div>
		<div class="box-body no-padding">

				<table class="table table-vertical" id="atmsclDistrbStrgTable">
					<caption>자원 제한 테이블</caption>

				<colgroup>
					<col class="col10">
					<col class="col20">
					<col class="col10">
					<col class="col10">
					<col class="col20">
					<col class="col10">
	      		</colgroup>

					<tbody>
			             <tr>
			            	<th><label for="specClCd"><span class="text-red">*</span>스펙선택</label></th>
				            <td colspan="5">
			            	   <div class="input-group">
									    <input type="hidden" title="부처" name="useGvDprtId">
									    <input type="text" id="specNm" name="specNm" class="form-control" placeholder="스펙을 선택해주세요" disabled="disabled" title="업무" >
									    <div class="input-group-btn">
									        <button type="button" class="btn" data-toggle="tooltip" title="" data-original-title="검색" onclick="fn_selectSpecListP();">
									            <i class="fa fa-search"></i>
									        </button>
							            </div>

										<div class="input-group-btn">
										    <input type="checkbox" id="quotaCheck" name="quotaCheck" onclick="fn_quotaToggle()" title="직접입력여부" /><label for="quotaCheck">직접입력</label>
										</div>
							    </div>
				            </td>
			            </tr>
						<tr>
							<th><span class="text-red">*</span>요청CPU</th>
							<td>
								<c:choose>
									<c:when test="${reqCpuCorQty eq 0}">
										<input type="number"  id="inReqCpuCorQty" class="form-control essential onlyFloat" oninput="maxLengthCheck(this);"  maxlength="4"  title="요청CPU(Core)" value="" min="0.0" disabled="disabled"/>
									</c:when>
									<c:otherwise>
										<input type="number"  id="inReqCpuCorQty" class="form-control essential onlyFloat" oninput="maxLengthCheck(this);"  maxlength="4"  title="요청CPU(Core)" value="${reqCpuCorQty}" min="0.0" disabled="disabled"/>
									</c:otherwise>
								</c:choose>
							</td>
							<td class="alignC">Core</td>
							<fmt:parseNumber var="lmttCpu" integerOnly="true" type="number" value="${lmttCpuCorQty }"/>
							<th><span class="text-red">*</span>제한CPU</th>
							<c:choose>
								<c:when test="${lmttCpu eq 0}">
									<td><input type="number" id="inLmttCpuCorQty" class="form-control essential onlyInteger"  oninput="maxLengthCheck(this);"   title="제한CPU(Core)"  value=""  maxlength="2" min="1" max="99" disabled="disabled"/></td>
								</c:when>
								<c:otherwise>
									<td><input type="number" id="inLmttCpuCorQty" class="form-control essential onlyInteger"  oninput="maxLengthCheck(this);"   title="제한CPU(Core)"  value="${lmttCpu}"  maxlength="2" min="1" max="99" disabled="disabled"/></td>
								</c:otherwise>
							</c:choose>
							<td class="alignC">Core</td>
			            </tr>
			            	<tr>
							<th><span class="text-red">*</span>요청메모리</th>
							<c:choose>
								<c:when test="${reqMemCapa eq 0}">
									<td><input type="number" id="inReqMemCapa" class="form-control essential onlyFloat"  oninput="maxLengthCheck(this);"   maxlength="5"  title="요청메모리(GB)" value=""  min="0.0" disabled="disabled"/></td>
								</c:when>
								<c:otherwise>
									<td><input type="number" id="inReqMemCapa" class="form-control essential onlyFloat"  oninput="maxLengthCheck(this);"   maxlength="5"  title="요청메모리(GB)" value="${reqMemCapa}"  min="0.0" disabled="disabled"/></td>
								</c:otherwise>
							</c:choose>
							<td class="alignC">GB</td>
							<fmt:parseNumber var="lmttMem" integerOnly="true" type="number" value="${lmttMemCapa }"/>
							<th><span class="text-red">*</span>제한메모리</th>
							<c:choose>
								<c:when test="${lmttMem eq 0}">
									<td><input type="number" id="inLmttMemCapa" class="form-control essential onlyInteger"  oninput="maxLengthCheck(this);"  title="제한메모리(GB)" value="" maxlength="2" min="1" max="99" disabled="disabled"/></td>
								</c:when>
								<c:otherwise>
									<td><input type="number" id="inLmttMemCapa" class="form-control essential onlyInteger"  oninput="maxLengthCheck(this);"  title="제한메모리(GB)" value="${lmttMem}" maxlength="2"  min="1" max="99" disabled="disabled"/></td>
								</c:otherwise>
							</c:choose>
							<td class="alignC">GB</td>
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
		<c:choose>
			<c:when test="${empty selectPodQuata.minCpuCorQty or empty selectPodQuata.maxCpuCorQty or empty selectPodQuata.minMemCapa or empty selectPodQuata.maxMemCapa}">
				<button type="button" class="btn btn-dark" onclick="fn_alert(1);">설정</button>
				<button type="button" class="btn btn-dark" onclick="fn_alert(2);">초기화</button>
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-dark" onclick="rsrcLtAdd();">설정</button>
				<button type="button" class="btn btn-dark" onclick="fn_init();">초기화</button>
			</c:otherwise>
		</c:choose>
		</menu:authorize>
		<button type="button" class="btn close-window">닫기</button>
	</div>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {
	var reqCpu = '${reqCpuCorQty}';

	});

    function rsrcLtAdd(){

    	if(!fn_form_validation("atmsclDistrbVo")){
    		return;
    	}
    	var minCpu = parseFloat('${selectPodQuata.minCpuCorQty}');
    	var maxCpu = parseFloat('${selectPodQuata.maxCpuCorQty}');
    	var minMem = parseFloat('${selectPodQuata.minMemCapa}');
    	var maxMem = parseFloat('${selectPodQuata.maxMemCapa}');

    	var inReqCpu =  parseFloat($("#inReqCpuCorQty").val());
    	var inLmttCpu = parseFloat($("#inLmttCpuCorQty").val());
    	var inReqMem =  parseFloat($("#inReqMemCapa").val());
    	var inLmttMem = parseFloat($("#inLmttMemCapa").val());

    	if(minCpu > inReqCpu ){
   		 	jAlert("요청CPU(Core)는 최소CPU(Core) 보다 작을 수 없습니다.", function() {$("#inReqCpuCorQty").focus(); } );
  		 	return;
    	}
    	if(inLmttCpu < inReqCpu ){
   		 	jAlert("요청CPU(Core)는 제한CPU(Core) 보다 클 수 없습니다.", function() {$("#inReqCpuCorQty").focus(); } );
  		 	return;
    	}

    	if(minMem > inReqMem ){
   		 	jAlert("요청메모리(GB)는 최소메모리(GB) 보다 작을 수 없습니다.", function() {$("#inReqMemCapa").focus(); } );
  		 	return;
    	}
    	if(inLmttMem < inReqMem ){
   		 	jAlert("요청메모리(GB)는 제한메모리(GB) 보다 클 수 없습니다.", function() {$("#inReqMemCapa").focus(); } );
  		 	return;
    	}

    	if(maxCpu < inLmttCpu ){
   		 	jAlert("제한CPU(Core)는 최대CPU(Core) 보다 클 수 없습니다.", function() {$("#inLmttCpuCorQty").focus(); } );
  		 	return;
    	}
    	if(maxMem < inLmttMem ){
   		 	jAlert("제한메모리(GB)는 최대메모리(GB) 보다 클 수 없습니다.", function() {$("#inLmttMemCapa").focus(); } );
  		 	return;
    	}
    	if(inReqCpu > inLmttCpu ){
   		 	jAlert("제한CPU(Core)는 요청CPU(Core) 보다 작을 수 없습니다.", function() {$("#inLmttCpuCorQty").focus(); } );
  		 	return;
    	}
    	if(inReqMem > inLmttMem ){
   		 	jAlert("제한메모리(GB)는 요청메모리(GB) 보다 작을 수 없습니다.", function() {$("#inLmttMemCapa").focus(); } );
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

			$('#atmsclDistrbVo').attr('action', '<c:url value="updateRsrcLt.do"/>');
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
    function fn_init(){
    	jConfirm('자원제한 설정을 초기화 하시겠습니까?', function(){
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

			$('#atmsclDistrbVo').attr('action', '<c:url value="updateInitRsrcLt.do"/>');
			$('#atmsclDistrbVo').ajaxSubmit(options);

		});
    }
    function fn_alert(ch){
    	if(ch == 1){
	    	jAlert("최소 (CPU,메모리)와 최대 (CPU,메모리)값이 있어야 설정 가능합니다." );
	    	return;
    	}else{
    		jAlert("최소 (CPU,메모리)와 최대 (CPU,메모리)값이 있어야 초기화 가능합니다." );
	    	return;
    	}
    }
  //스 펙 선택 팝업
    function fn_selectSpecListP(){

    	var url = contextPath+'/cpt/rsrc/atmscl/servcarea/selectAtmSclSpecListPView.do?specClCd=07';
    	var width = 1000;
    	var height = 620;
    	var posY  = (screen.width - width) / 2;
    	var posX =  (screen.height - height) / 2;
    	var args = {width:width , height:height, posX : posX , posY : posY};
    	windowOpen(url, '', args);
    }
 // 스펙 선택 콜백
    function fn_selectedSpec(spec){
    	$('#specNm').val(spec.specNm);
    	$('#inReqCpuCorQty').val(spec.vcoreMinVl);
    	$('#inLmttCpuCorQty').val(spec.vcoreMaxVl);
    	$('#inReqMemCapa').val(spec.memMinVl);
    	$('#inLmttMemCapa').val(spec.memMaxVl);
    }
  //직접입력 선택 시
  function fn_quotaToggle(){
    if($('#quotaCheck').prop("checked")==true){
        $("#inReqCpuCorQty").val('${reqCpuCorQty}');
        $("#inReqCpuCorQty").attr('disabled',false);
        $("#inLmttCpuCorQty").val('${lmttCpu}');
        $("#inLmttCpuCorQty").attr('disabled',false);
        $("#inReqMemCapa").val('${reqMemCapa}');
        $("#inReqMemCapa").attr('disabled',false);
        $("#inLmttMemCapa").val('${lmttMem}');
        $("#inLmttMemCapa").attr('disabled',false);

    }else{
        $("#inReqCpuCorQty").val("");
        $("#inReqCpuCorQty").val('${reqCpuCorQty}');
        $("#inReqCpuCorQty").attr('disabled',true);
        $("#inLmttCpuCorQty").val("");
		$("#inLmttCpuCorQty").val('${lmttCpu}');
		$("#inLmttCpuCorQty").attr('disabled',true);
        $("#inReqMemCapa").val("");
        $("#inReqMemCapa").val('${reqMemCapa}');
        $("#inReqMemCapa").attr('disabled',true);
        $("#inLmttMemCapa").val("");
        $("#inLmttMemCapa").val('${lmttMem}');
        $("#inLmttMemCapa").attr('disabled',true);
    }
}



</script>