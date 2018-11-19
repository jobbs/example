<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>서비스영역 생성 화면</pre>
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
 * 2016. 10. 13.     x         v1.0             최초생성
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

<form:form commandName="servcAreaVo">
<form:hidden path="quotaEditYn" title="쿼터변경여부"  />
<form:hidden path="limitEditYn" title="제한변경여부"  />

<!-- 등록/상세 영역 -->
<div class="col-box-100 detail-col">
	<c:set var="servcAreaVoClass" value="ncis.cpt.rsrc.atmscl.vo.ServcAreaVo"/>

    <!--  기본정보 시작  -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">기본정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>

		<div class="box-body no-padding">
	        <table class="table table-hover table-horizon">
				<caption>서비스영역 기본정보</caption>
				<colgroup>
					<col class="col10">
					<col class="col23">
					<col class="col10">
					<col class="col23">
					<col class="col10">
					<col class="col24">
				</colgroup>
				<tbody>
					<tr>
					    <th><label for="servcAreaNm"><span class="text-red">*</span>서비스영역명</label></th>
					    <td colspan="5">
					        <form:input path="servcAreaNm" title="서비스영역명" cssClass="form-control essential" value="" maxlength="50"/>
					    </td>
					</tr>
					<tr>
						<th><span class="text-red">*</span>센터</th>
						<td>
						    <nform:selectRegion name="regionId" id="regionId" title="센터" wholeText="센터을 선택하세요" cssClass="form-control essential"  whole="true" value="${servcAreaVo.regionId}"  onchange="selectZoneByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'byRole' : false, 'searchSwTypeCd' : 'ATMSCL','searchPoolTypeCd':'05'})" />
						</td>
						<th><span class="text-red">*</span>존</th>
						<td>
						    <nform:selectZone name="zoneId" id="zoneId" title="존" wholeText="존을 선택하세요" cssClass="form-control input-sm essential" whole="true"  regionId="${servcAreaVo.regionId}" value="${servcAreaVo.zoneId}" onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'searchCtlTrgtYn' : 'Y','byRole' : false, 'searchSwTypeCd' : 'ATMSCL','searchPoolTypeCd':'05'})" />
						</td>
						<th><span class="text-red">*</span>망구분(망)</th>
				        <td>
				            <nform:selectCode parentCd="NETCD" parentGrpCd="067" name="netClCd" id="netClCd" title="망구분" wholeText="망구분을 선택하세요" cssClass="form-control input-sm essential" whole="true" zoneId="${servcAreaVo.zoneId}" value="${servcAreaVo.netClCd}"  onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'searchCtlTrgtYn' : 'Y','byRole' : false, 'searchSwTypeCd' : 'ATMSCL','searchPoolTypeCd':'05'})"  />
				        </td>
					</tr>
					<tr>
					    <th><span class="text-red">*</span>자원풀</th>
			            <td>
			                <nform:selectPool name="rsrcPoolId" id="rsrcPoolId" title="자원풀" wholeText="자원풀을 선택하세요" cssClass="form-control input-sm essential" whole="true" poolTypeCd="01" ctlTrgtYn="Y" regionId="${servcAreaVo.regionId }" zoneId="${servcAreaVo.zoneId}" netClCd="${servcAreaVo.netClCd }" value="${servcAreaVo.rsrcPoolId}"/>
			            </td>
					    <th><span class="text-red">*</span>업무</th>
	                    <td>
	                        <div class="input-group">
	                            <input type="hidden" title="부처" name="institutionId" />
	                            <input type="hidden" title="업무" name="jobId" />
	                            <input type="text" name="institutionNm" class="form-control essential" placeholder="업무를 선택해주세요" disabled="disabled" title="업무" />
	                            <div class="input-group-btn">
	                                <button type="button" class="btn" data-toggle="tooltip" title="검색" data-original-title="검색" onclick="openJobeSearch();">
	                                    <i class="fa fa-search"></i>
	                                </button>
	                            </div>
	                        </div>
	                    </td>
	                    <th><label for="servcAreaCompId">서비스영역구성ID</label></th>
					    <td>
					        <form:input path="servcAreaCompId" title="서비스영역구성ID" cssClass="form-control" value="" maxlength="10"/>
					    </td>
					</tr>
					<tr>
					    <th>비고</th>
					    <td colspan="5">
					        <form:textarea path="rmk" cssClass="form-control" title="비고" rows="3" maxlength="1000" />
					    </td>
					</tr>
	            </tbody>
		    </table>
	    </div>
    </div>
	<!--  기본정보 끝  -->

	<!--  쿼터정보 시작  -->
	<div class="box">
        <div class="box-header">
            <h3 class="box-title">쿼터 정보(Quota)</h3>
        </div>

		<div class="box-body no-padding">
		    <table class="table table-horizon">
				<caption>서비스영역 쿼터 정보</caption>
				<colgroup>
					<col class="col10">
					<col class="col23">
					<col class="col10">
					<col class="col23">
					<col class="col10">
                    <col class="col24">
				</colgroup>
				<tbody>
				    <tr>
					    <th><label for="specClCd"><span class="text-red">*</span>스펙선택</label></th>
						<td colspan="5">
						    <div class="input-group">
							    <input type="hidden" title="부처" name="useGvDprtId">
							    <input type="text" name="specNm" id="specNm" class="form-control" placeholder="스펙을 선택해주세요" disabled="disabled" title="업무" >
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
					    <th><label for="reqCpuCorQty"><span class="text-red">*</span>요청 CPU(Core)</label></th>
					    <td>
					        <form:input path="reqCpuCorQty" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256" title="요청 CPU"  maxlength="3" disabled="true" />
					    </td>
					    <th><label for="lmttCpuCorQty"><span class="text-red">*</span>제한 CPU(Core)</label></th>
					    <td>
					        <form:input path="lmttCpuCorQty" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256" title="제한 CPU"  maxlength="3" disabled="true"  />
					    </td>
					    <th><label for="maxPodQty"><span class="text-red">*</span>최대 Pod 수</label></th>
                        <td>
                            <form:input path="maxPodQty" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256" title="최대 Pod 수"  maxlength="3" disabled="true"  />
                        </td>
					</tr>
					<tr>
					    <th><label for="reqMemCapa"><span class="text-red">*</span>요청 메모리(GB)</label></th>
					    <td>
					        <form:input path="reqMemCapa" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256" title="요청 메모리"  maxlength="3" disabled="true"  />
					    </td>
					    <th><label for="lmttMemCapa"><span class="text-red">*</span>제한 메모리(GB)</label></th>
					    <td>
					        <form:input path="lmttMemCapa" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256" title="제한 메모리"  maxlength="3" disabled="true" />
					    </td>
					    <td colspan="2"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!--  쿼터정보 끝  -->


	<!--  제한정보 시작  -->
	<div class="box">
        <div class="box-header">
            <h3 class="box-title">Pod 제한 정보(LimitRange)</h3>
        </div>

		<div class="box-body no-padding">
		    <table class="table table-horizon">
				<caption>Pod 자원제한 정보</caption>
				<colgroup>
					<col class="col10">
					<col class="col40">
					<col class="col10">
					<col class="col40">
				</colgroup>
				<tbody>
					<tr>
					    <th><label for="minCpuCorQty"><span class="text-red">*</span>최소 CPU(Core)</label></th>
					    <td>
					        <form:input path="minCpuCorQty" type="number" class="form-control essential onlyFloat" step="1" min="1" max="256" title="최소 CPU"  maxlength="4" />
						</td>
						<th><label for="intMaxCpuCorQty"><span class="text-red">*</span>최대 CPU(Core)</label></th>
						<td>
						    <form:input path="intMaxCpuCorQty" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256" title="최대 CPU"  maxlength="3" />
							<form:hidden path="maxCpuCorQty" title="최대 CPU(Core)"  />
						</td>
					</tr>
					<tr>
						<th><label for="minMemCapa"><span class="text-red">*</span>최소 메모리(GB)</label></th>
						<td>
							<form:input path="minMemCapa" type="number" class="form-control essential onlyFloat" step="1" min="1" max="256"  title="최소 메모리"  maxlength="5" />
						</td>
						<th><label for="intMaxMemCapa"><span class="text-red">*</span>최대 메모리(GB)</label></th>
						<td>
						    <form:input path="intMaxMemCapa" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256" title="최대 메모리"  maxlength="3" />
							<form:hidden path="maxMemCapa" title="최대 메모리(GB)"  />
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!--  제한정보 끝  -->


</div>
</form:form>

<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectServcAreaList()"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize onlyOprAdm="true">
				<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="생성" data-original-title="생성"  onclick="fn_insertServcArea()"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>

<script type="text/javascript">

// 뒤로 버튼 클릭 시
function fn_selectServcAreaList(){
	location.href = '<c:url value="selectServcAreaList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'servcAreaSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

// 생성 버튼 클릭 시
function fn_insertServcArea(){

	if(!fn_form_validation("servcAreaVo")){
		return;
	}

	if(!fn_checkData(null)) {
		return;
	}

	jConfirm('서비스영역을 생성 하시겠습니까?', function(){

		$('#quotaEditYn').val('Y');
		$('#limitEditYn').val('Y');

		$('#maxCpuCorQty').val($('#intMaxCpuCorQty').val());
		$('#maxMemCapa').val($('#intMaxMemCapa').val());

		if($('#quotaCheck').prop("checked")==false){
	        $("#reqCpuCorQty").attr('disabled',false);
	        $("#lmttCpuCorQty").attr('disabled',false);
	        $("#reqMemCapa").attr('disabled',false);
	        $("#lmttMemCapa").attr('disabled',false);
	        $("#maxPodQty").attr('disabled',false);
		}

		var options = {
			type: 'post',
			dataType: 'json',
			success: insertServcAreaResultHandler,
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

		$('#servcAreaVo').attr('action', '<c:url value="insertServcArea.do"/>');
		$('#servcAreaVo').ajaxSubmit(options);

	});
}

// 생성 결과 콜백
function insertServcAreaResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo(result.messageList, function(){
			fn_selectServcAreaList();
		});
	}
	else{
		alert_message(result.messageList)
	}
}


//스 펙 선택 팝업
function fn_selectSpecListP(){

	var url = 'selectAtmSclSpecListPView.do?specClCd=06';
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
	$('#reqCpuCorQty').val(spec.vcoreMinVl);
	$('#lmttCpuCorQty').val(spec.vcoreMaxVl);
	$('#reqMemCapa').val(spec.memMinVl);
	$('#lmttMemCapa').val(spec.memMaxVl);
	$('#maxPodQty').val(spec.maxPodQty);
	$('#quotaCheck').prop("checked",false);
}


//쿼터설정 직접입력 선택 시
function fn_quotaToggle(){
    if($('#quotaCheck').prop("checked")==true){
        $("#reqCpuCorQty").val("");
        $("#reqCpuCorQty").attr('disabled',false);
        $("#lmttCpuCorQty").val("");
        $("#lmttCpuCorQty").attr('disabled',false);
        $("#reqMemCapa").val("");
        $("#reqMemCapa").attr('disabled',false);
        $("#lmttMemCapa").val("");
        $("#lmttMemCapa").attr('disabled',false);
        $("#maxPodQty").val("");
        $("#maxPodQty").attr('disabled',false);
        $("#specNm").val("");
    }else{
        $("#reqCpuCorQty").val("");
        $('#reqCpuCorQty').val('${servcAreaVo.reqCpuCorQty}');
        $("#reqCpuCorQty").attr('disabled',true);
        $("#lmttCpuCorQty").val("");
        $('#lmttCpuCorQty').val('${servcAreaVo.lmttCpuCorQty}');
        $("#lmttCpuCorQty").attr('disabled',true);
        $("#reqMemCapa").val("");
        $('#reqMemCapa').val('${servcAreaVo.reqMemCapa}');
        $("#reqMemCapa").attr('disabled',true);
        $("#lmttMemCapa").val("");
        $('#lmttMemCapa').val('${servcAreaVo.lmttMemCapa}');
        $("#lmttMemCapa").attr('disabled',true);
        $("#maxPodQty").val("");
        $('#maxPodQty').val('${servcAreaVo.maxPodQty}');
        $("#maxPodQty").attr('disabled',true);
        $("#specNm").val("");
    }
}


//업무에 대한 단일 선택
$(document).bind('selectJob',setJob);
//업무에 대한 단일 선택 이벤터 함수
function setJob(evt) {
	var job = evt.datas;

	$('#servcAreaVo input[name="institutionNm"]').val(job.jobNm);
    $('#servcAreaVo input:hidden[name="institutionId"]').val(job.institutionId);
    $('#servcAreaVo input:hidden[name="jobId"]').val(job.jobId);
}


//소숫점 체크
function fn_checkFloat(dataVal, checkLen) {

	var rtnFlag = true;
	var msg = "";

	if(dataVal.indexOf('.')!=-1) {
		var checkLength = dataVal.substring(dataVal.indexOf('.')+1);

		if(checkLength.length>checkLen) {
			rtnFlag =  false;
		}
	}

	return rtnFlag;
}


//데이터 체크
function fn_checkData(obj){


	var rtfFlag = true;
	var alertMsg = "";

	if(parseInt($('#reqCpuCorQty').val()) > 128 || parseInt($('#reqCpuCorQty').val()) <= 0 ||
	   parseInt($('#lmttCpuCorQty').val()) > 128 || parseInt($('#lmttCpuCorQty').val()) <= 0 ||
	   parseInt($('#intMaxCpuCorQty').val()) > 128 || parseInt($('#intMaxCpuCorQty').val()) <= 0 ) {

		alertMsg = "CPU 값은 1 ~ 128 사이의 값으로 설정해주세요.";
		rtfFlag = false;
	}

	if(rtfFlag && (parseInt($('#reqMemCapa').val()) > 256 || parseInt($('#reqMemCapa').val()) <= 0 ||
	   parseInt($('#lmttMemCapa').val()) > 256 || parseInt($('#lmttMemCapa').val()) <= 0 ||
	   parseInt($('#intMaxMemCapa').val()) > 256 || parseInt($('#intMaxMemCapa').val()) <= 0 )) {
		alertMsg = "메모리값은 1 ~ 256 사이의 값으로 설정해주세요.";
		rtfFlag = false;
	}


	if(rtfFlag && (parseFloat($('#minCpuCorQty').val()) > 128 || parseFloat($('#minCpuCorQty').val()) < 0.01)) {
		alertMsg = "제한 정보의 최소 CPU 값은 0.01 ~ 128 사이의 값으로 설정해주세요.";
		obj = $('#minCpuCorQty');
		rtfFlag = false;
	}

	if(rtfFlag && (parseFloat($('#minMemCapa').val()) > 256 || parseFloat($('#minMemCapa').val()) < 0.001)) {
		alertMsg = "제한 정보의 최소 메모리 값은 0.001 ~ 256 사이의 값으로 설정해주세요.";
		obj = $('#minMemCapa');
		rtfFlag = false;
	}


	if(rtfFlag && (parseFloat($('#minMemCapa').val()) < 1 && (parseFloat($('#minMemCapa').val())*1024)%1 !=0)) {
		alertMsg = "제한 정보의 최소 메모리 값을  다시 입력해 주세요. \n 예시1)512MB를 입력하고 싶을경우  = 0.5 \n 예시2)256MB를 입력하고 싶을경우 = 0.25";
		obj = $('#minMemCapa');
		rtfFlag = false;
	}


	if(rtfFlag && (!fn_checkFloat($('#minMemCapa').val(), 3))) {
		rtfFlag = false;
		alertMsg = "최소 메모리는 소숫점 3자리까지만 허용합니다.";
		obj = $('#minMemCapa');

	}

	if(rtfFlag && (!fn_checkFloat($('#minCpuCorQty').val(), 2))) {
		rtfFlag = false;
		alertMsg = "최소 CPU는  소숫점 2자리까지만 허용합니다.";
		obj = $('#minCpuCorQty');
	}


	if(rtfFlag && (parseInt($('#lmttCpuCorQty').val()) < parseInt($('#reqCpuCorQty').val()))){
		obj = $('#reqCpuCorQty');
		alertMsg = "요청 CPU 값은 제한 CPU 값 보다 클 수 없습니다.";
		rtfFlag = false;
	}


	if(rtfFlag && (parseFloat($('#intMaxCpuCorQty').val()) < parseFloat($('#minCpuCorQty').val()))){
		obj = $('#minCpuCorQty');
		alertMsg = "최소 CPU 값은 최대 CPU 값 보다 클 수 없습니다.";
		rtfFlag = false;
	}


	if(rtfFlag && (parseInt($('#lmttMemCapa').val()) < parseInt($('#reqMemCapa').val()))){
		obj = $('#reqMemCapa');
		alertMsg = "요청 메모리 값은 제한 메모리 값 보다 클 수 없습니다.";
		rtfFlag = false;
	}

	if(rtfFlag && (parseFloat($('#intMaxMemCapa').val()) < parseFloat($('#minMemCapa').val()))){
		alertMsg = "최소 메모리 값은 최대 메모리 값 보다 클 수 없습니다.";
		obj = $('#minMemCapa');
		rtfFlag = false;
	}

	if(rtfFlag && (parseFloat($('#lmttMemCapa').val()) < parseFloat($('#minMemCapa').val()))){
		alertMsg = "최소 메모리 값은 제한 메모리 값 보다 클 수 없습니다.";
		obj = $('#minMemCapa');
		rtfFlag = false;

	}

	if(rtfFlag && (parseInt($('#lmttMemCapa').val()) < parseInt($('#intMaxMemCapa').val()))){
		alertMsg = "최대 메모리 값은 제한 메모리 값 보다 클 수 없습니다.";
		obj = $('#intMaxMemCapa');
		rtfFlag = false;
	}

	if(rtfFlag && (parseInt($('#lmttCpuCorQty').val()) < parseInt($('#intMaxCpuCorQty').val()))){
		alertMsg = "최대 CPU 값은 제한 CPU 값 보다 클 수 없습니다.";
		obj = $('#intMaxCpuCorQty');
		rtfFlag = false;
	}

	if(rtfFlag && (parseInt($('#lmttCpuCorQty').val()) < parseInt($('#minCpuCorQty').val()))){
		alertMsg = "최소 CPU 값은 제한 CPU 값 보다 클 수 없습니다.";
		obj = $('#minCpuCorQty');
		rtfFlag = false;
	}

	if(!rtfFlag) {
		jAlert(alertMsg, function(){
			if(obj != null) {
				obj.focus();
			}
		});
	}

	return rtfFlag;
}



</script>
