<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 29.
 * @lastmodified 2016. 10. 29.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 29.     신재훈         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<form:form id="insertIpBndFrm" commandName="ipBndVo">
	<input type="hidden" name="institutionId" />
	<div class="col-box-100 detail-col">
		<div class="box">
			<!-- box-header -->
			<div class="box-header">
				<h3 class="box-title">IP대역정보</h3>
			</div>
			<!-- 대역정보 시작 -->
			<div class="box-body no-padding">
				<table class="table table-horizon">
				<caption>IP대역정보(IP대역명, 센터, 사용여부, 망구분, 시작IP, 종료IP, 게이트웨이, VLAN, 사용부처, 용도)</caption>
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
							<th><span class="text-red">*</span>IP대역명</th>
							<td colspan="5"><form:input id="ipBndNm" path="ipBndNm" cssClass="form-control input-sm essential" title="IP대역명" value="" maxlength="50" /></td>
						</tr>
						<tr>
							<th><span class="text-red">*</span>센터</th>
							<td><nform:selectRegion name="regionId" id="regionId" whole="true" title="센터" wholeText="센터를 선택하세요" cssClass="form-control essential" /></td>
							<th>사용여부</th>
							<td>
								<div class="input-group input-group-radio">
									<form:radiobutton path="useYn" title="사용여부" cssClass="essential" label="사용" value="Y" checked="checked"/>
									<form:radiobutton path="useYn" title="사용여부" cssClass="essential" label="미사용" value="N" />
								</div>
							</td>
							<th><span class="text-red">*</span>망구분</th>
							<td>
								<nform:selectCode
									parentCd="NETCD"
									parentGrpCd="067"
									name="netClCd"
									id="netClCd"
									whole="true"
									wholeText="망을 선택하세요"
									extra1=""
									extra2=""
									extra3=""
									extra4=""
									extra5=""
									title="망구분"
									cssClass="form-control essential"  onchange="fn_checkPrpos()"/>
							</td>
						</tr>
						<tr>
							<th><span class="text-red">*</span>시작IP</th>
							<td><form:input path="bndStrtIp" cssClass="form-control onlyIp essential" maxlength="15" title="시작Ip" onblur="fn_getSubNetMaskAddress(this)" /></td>
							<th><span class="text-red">*</span>종료IP</th>
							<td><form:input path="bndEndIp" cssClass="form-control onlyIp essential" maxlength="15" title="종료IP"/></td>
							<th><span class="text-red">*</span>서브넷마스크</th>
							<td><form:input path="subnetMask" cssClass="form-control onlyIp essential" maxlength="15" title="서브넷마스크"/></td>
						</tr>
						<tr>
							<th>게이트웨이</th>
							<td><form:input path="gtwyIpAddr"  cssClass="form-control onlyIp" maxlength="15" title="게이트웨이" onchange="inputCheck()"/></td>
							<th><span class="text-red">*</span>VLAN</th>
							<td colspan="3"><form:input path="vlan" cssClass="form-control onlyNumber essential" maxlength="20" title="VLAN"/></td>
						</tr>
						<tr>
							<th><span class="text-red">*</span>사용부처</th>
							<td colspan="5">
								<div class="input-group">
									<table class="table table-hover table-vertical  table-layout-fixed" id="insttListTable" >
										<colgroup>
											<col class="col92">
											<col class="col4">
											<col class="col4">
										</colgroup>
										<tbody id="insttListTbody">
										</tbody>
									</table>
<%--
 									<menu:authorize>
 										<div class="input-group-btn" style="vertical-align: bottom">
 										<button type="button" class="btn btn" title="부처검색" onclick="fn_selectInsttList()" style="border-left-style: 1px solid black; border-left: 1px solid #ddd;"><i class="fa fa-search"></i></button>
 										</div>
 									</menu:authorize>
--%>
								</div>
							</td>
						</tr>
						<tr>
							<th><span class="text-red">*</span>용도</th>
							<td class="alignL" colspan="5">
							<div class="input-group input-group-check">
								<c:forEach var="prposClCd" items="${prposClCdList }">
									<form:checkbox path="prposClCdList" value="${prposClCd.cd}" id="${prposClCd.cd}" title="용도" onclick="fn_checkPrpos()"/>
									<label for="${prposClCd.cd}"><c:out value="${prposClCd.cdNm}" /></label>
								</c:forEach>
							</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="box-footer clearfix"></div>
			<!-- 대역정보 종료 -->
		</div>
	</div>

	<div class="col-box-100 detail-col">
		<!-- 전체 Static Router 시작 -->
		<div class="box detail-list-box">
			<div class="box-header">
				<h3 class="box-title">스태틱라우터 설정</h3>
				<div class="box-tools">
					<div class="pull-right">
						<menu:authorize>
						<button type="button" class="btn btn-sm btn-function" onclick="fn_insertSRout()" title="스태틱라우터 추가">추가</button>
						</menu:authorize>
					</div>
				</div>
			</div>
			<div class="box-body no-padding">
				<table class="table table-vertical" id="sRoutListTable">
				<caption>스태틱라우터설정(IP, 서브넷마스크, 게이트웨이)</caption>
					<colgroup>
						<col class="col30">
						<col class="col30">
						<col class="col30">
						<col class="col10">
					</colgroup>
					<thead>
						<tr>
							<th>IP</th>
							<th>서브넷마스크</th>
							<th>게이트웨이</th>
							<th></th>
						</tr>
					</thead>
					<tbody id="sRoutListTBody">
					</tbody>
				</table>
			</div>
			<!-- 전체 Static Router 종료 -->
		</div>
	</div>

	<div class="col-box-100 detail-col">
		<!-- 가상스위치 정보 시작 -->
		<div class="box detail-list-box">
			<div class="box-header">
				<h4 class="box-title">가상스위치 연결
				</h4>
				<div class="box-tools">
					<div class="input-group pull-right">
						<menu:authorize>
						<button type="button" class="btn btn-sm btn-function" onclick="fn_selecVrSwtchList()" title="가상스위치 추가" >추가</button>
						</menu:authorize>
					</div>
				</div>
			</div>
			<div class="box-body no-padding">
				<table class="table table-bordered" id="vrSwtchListTable">
				<caption>가상스위치설정(센터, 망구분, 가상화SW, 자원풀, 네트워크명)</caption>
					<colgroup>
						<col class="col8">
						<col class="col14">
						<col class="col20">
						<col class="col20">
						<col class="col30">
						<col class="col8">
					</colgroup>
					<thead>
						<tr>
							<th>센터</th>
							<th>망구분</th>
							<th>가상화SW</th>
							<th>자원풀</th>
							<th>네트워크명</th>
							<th></th>
						</tr>
					</thead>
					<tbody id="vrSwtchListTbody">
					</tbody>
				</table>
			</div>
		</div>
	</div>
</form:form>
<div class="col-box-100">
	<c:url var="listUrl" value="selectIpBndList.do">
		<c:forEach var="curParam" items="${param }">
			<c:if test="${curParam.key ne 'bndSeq'}">
				<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
			</c:if>
		</c:forEach>
	</c:url>
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip"	title="뒤로" data-original-title="뒤로" onclick="fn_goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i>
			</button>
		</div>
		<div class="pull-right">
		<menu:authorize>
			<button class="btn btn-hover-yellow" data-toggle="tooltip" data-original-title="정보저장" onclick="fn_insertIpBnd()" title="정보저장"><i class="fa fa-eraser"></i></button>
		</menu:authorize>
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).bind('selectInstitutionMulti', setInstitution);
$(document).ready(function(){
	// 가상스위치가 설정되었을 때, 망구분을 수정하게 되면 설정한 가상스위치 정보가 초기화 되는 기능
	$("#insertIpBndFrm select[name='netClCd']").focus(function(){
		$(this).data('lastValue', $(this).val());
	});
	$("#insertIpBndFrm select[name='netClCd']").change(function(e){
		var lastNetClCd = $(this).data('lastValue');
		var newNetClCd = $(this).val();
		var vrSwtchLength = $("input:hidden[name='checkVmSeq']").length;

		if(vrSwtchLength > 0){
			jConfirmForCancel("선택한 망구분을 변경하게되면 설정된 가상스위치 정보가 초기화 됩니다. 변경하시겠습니까?", function(result){
				if(result){
					$(this).data('lastValue', newNetClCd);
					$('#vrSwtchListTbody > tr').remove();
				}
				else{
					$(this).val(lastNetClCd);
					$("#insertIpBndFrm select[name='netClCd']").val(lastNetClCd).prop("selected", true);
				}
			});
		}
		else {
			// 마지막 선택값 저장
			$(this).data('lastValue', newNetClCd);
		}
	});

	//부처테이블 설정
	var index = insttListTable.rows.length;
	if(index == 0){
		var html = '<tr>' +
		'	<td class="alignL"></td>' +
		'	<td></td>' +
		'   <td>' + '<button type="button" class="btn btn-sm btn-function" name="btnInsertInstt" onclick="fn_selectInsttList()" title="부처추가">추가</button>' +
		'	</td>' +
		'</tr>';
		$('#insttListTbody').append(html);
	}
});

function fn_goToUrl(url) {
	location.href = url;
}

function fn_checkPrpos(){

	var netClCd = $("#insertIpBndFrm select[name='netClCd']").val();

	// 관리망의 경우 여려개 WEB/WAS/DB 어떤 용도를 선택해도 상관없도록 수정. 2018.05.21
	if(netClCd == 'M')
	{
		document.getElementById('01').disabled = false;
		document.getElementById('02').disabled = false;
		document.getElementById('03').disabled = false;
		document.getElementById('05').disabled = false;
		document.getElementById('06').disabled = false;
		document.getElementById('07').disabled = false;
		document.getElementById('09').disabled = false;
		document.getElementById('10').disabled = false;
		document.getElementById('11').disabled = false;

		return;
	}

	// 용도를 선택했을 때, 활성화/비활성화를 결정함
	// Service (WEB, WAS, DB)를 선택했을 때 BACKUP 이나 HEARTBEAT 를 선택할 수 없어야 함.
	// WEB, WAS들만 다중선택이 가능하고 나머지는 단일선택만 가능해야 함.
	var prposLength = $("#insertIpBndFrm input[name='prposClCdList']:checked").length;
	if(prposLength > 0){
		var checkValue = document.getElementById($("#insertIpBndFrm input[name='prposClCdList']:checked").val()).value;
		switch (checkValue) {
			case '01': // WEB선택, WAS를 제외한 나머지 Checkbox에 대해 disabled 부여
				fn_changePrposState(1);
				break;
			case '02':
				fn_changePrposState(1);
				break;
			case '03':
				fn_changePrposState(2);
				break;
			case '05':
				fn_changePrposState(3);
				break;
			case '06':
				fn_changePrposState(3);
				break;
			case '07':
				fn_changePrposState(4);
				break;
			case '09':
				fn_changePrposState(5);
				break;
			case '10':
				fn_changePrposState(5);
				break;
			case '11':
				fn_changePrposState(6);
				break;
			default:
				break;
		}
	}
	else {
		fn_changePrposState(0);
	}
}

// 용도 선택에 따른 활성화/비활성화 결정
function fn_changePrposState(type){
	switch (type){
		case 1: // WEB, WAS 선택한 경우
			document.getElementById('01').disabled = false;
			document.getElementById('02').disabled = false;
			document.getElementById('03').disabled = true;
			document.getElementById('05').disabled = true;
			document.getElementById('06').disabled = true;
			document.getElementById('07').disabled = true;
			document.getElementById('09').disabled = true;
			document.getElementById('10').disabled = true;
			document.getElementById('11').disabled = true;
			break;
		case 2: // DB 선택한 경우
			document.getElementById('01').disabled = true;
			document.getElementById('02').disabled = true;
			document.getElementById('03').disabled = false;
			document.getElementById('05').disabled = true;
			document.getElementById('06').disabled = true;
			document.getElementById('07').disabled = true;
			document.getElementById('09').disabled = true;
			document.getElementById('10').disabled = true;
			document.getElementById('11').disabled = true;
			break;
		case 3: // WEB BACKUP NAS, WAS BACKUP NAS 선택한 경우
			document.getElementById('01').disabled = true;
			document.getElementById('02').disabled = true;
			document.getElementById('03').disabled = true;
			document.getElementById('05').disabled = false;
			document.getElementById('06').disabled = false;
			document.getElementById('07').disabled = true;
			document.getElementById('09').disabled = true;
			document.getElementById('10').disabled = true;
			document.getElementById('11').disabled = true;
			break;
		case 4: // DB BACKUP NAS 선택한 경우
			document.getElementById('01').disabled = true;
			document.getElementById('02').disabled = true;
			document.getElementById('03').disabled = true;
			document.getElementById('05').disabled = true;
			document.getElementById('06').disabled = true;
			document.getElementById('07').disabled = false;
			document.getElementById('09').disabled = true;
			document.getElementById('10').disabled = true;
			document.getElementById('11').disabled = true;
			break;
		case 5: // WEB HEARTBEAT, WAS HEARTBEAT 선택한 경우
			document.getElementById('01').disabled = true;
			document.getElementById('02').disabled = true;
			document.getElementById('03').disabled = true;
			document.getElementById('05').disabled = true;
			document.getElementById('06').disabled = true;
			document.getElementById('07').disabled = true;
			document.getElementById('09').disabled = false;
			document.getElementById('10').disabled = false;
			document.getElementById('11').disabled = true;
			break;
		case 6: // DB HEARTBEAT 선택한 경우
			document.getElementById('01').disabled = true;
			document.getElementById('02').disabled = true;
			document.getElementById('03').disabled = true;
			document.getElementById('05').disabled = true;
			document.getElementById('06').disabled = true;
			document.getElementById('07').disabled = true;
			document.getElementById('09').disabled = true;
			document.getElementById('10').disabled = true;
			document.getElementById('11').disabled = false;
			break;
		default:
			document.getElementById('01').disabled = false;
			document.getElementById('02').disabled = false;
			document.getElementById('03').disabled = false;
			document.getElementById('05').disabled = false;
			document.getElementById('06').disabled = false;
			document.getElementById('07').disabled = false;
			document.getElementById('09').disabled = false;
			document.getElementById('10').disabled = false;
			document.getElementById('11').disabled = false;
			break;
	}
}

// 아이피 검사
function fn_inputIpCheck(ip){
	var pattern = /^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/;

	if(pattern.test(ip)){
		var parts = ip.split(".");
		if(parts.length != 4){
			return false;
		}

		if(parseInt(parts[0]) < 1){
			return false;
		}

		if(parseInt(parts[3]) < 1){
			return false;
		}

		for(var i=0; i<parts.length; i++){
			if(i == 0){
				if(parseInt(parts[i]) > 223){
					return false;
				}
			}
			else {
				if(parseInt(parts[i]) > 255){
					return false;
				}
			}
		}
		return true;
	}
	else {
		return false;
	}
}

// 스태틱라우터 아이피 검사
function fn_inputIpCheckBySRout(ip){
	var pattern = /^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/;

	if(pattern.test(ip)){
		var parts = ip.split(".");
		if(parts.length != 4){
			return false;
		}

		if(parseInt(parts[0]) == 0){
			return false;
		}

		for(var i=0; i<parts.length; i++){
			if(i == 0){
				if(parseInt(parts[i]) > 223){
					return false;
				}
			}
			else {
				if(parseInt(parts[i]) > 255){
					return false;
				}
			}
		}
		return true;
	}
	else {
		return false;
	}

}

//서브넷마스크 검사
function fn_subnetMaskCheck(subnetMask){
	var pattern = /^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/;

	if(pattern.test(subnetMask)){
		var parts = subnetMask.split(".");
		if(parts.length != 4){
			return false;
		}

		if(parseInt(parts[0]) == 0){
			return false;
		}
	}
	else {
		return false;
	}
	return true;
}

// 시작IP, 종료IP 대역 동일여부 체크
function fn_compareIp(strtIp, endIp){
	var part_strtIp = strtIp.split(".");
	var part_endIp = endIp.split(".");

	if( parseInt(part_strtIp[0]) != parseInt(part_endIp[0]) ){
		return false;
	}
	else if( parseInt(part_strtIp[1]) != parseInt(part_endIp[1]) ){
		return false;
	}
	else if( parseInt(part_strtIp[2]) != parseInt(part_endIp[2]) ){
		return false;
	}
	else if( parseInt(part_strtIp[3]) > parseInt(part_endIp[3]) ){
		return false;
	}
	else {
		return true;
	}
}

// 스태틱 라우터 아이피 검사
function input_sRoutIp_validation(){
	var checkCnt = $("input[name='sRoutList[].ipBndAddr']").length;
	for( var i=0; i < checkCnt; i++ ) {
		if( !fn_inputIpCheckBySRout($("input[name='sRoutList[].ipBndAddr']").eq(i).val()) ) {
			jAlert("아이피 형식이 맞지 않습니다.", function() {
				$("input[name='sRoutList[].ipBndAddr']").eq(i).focus();
			});
			return false;
		}

		if( !fn_subnetMaskCheck($("input[name='sRoutList[].subnetMask']").eq(i).val()) ) {
			jAlert("서브넷마스크 아이피 형식이 맞지 않습니다.", function() {
				$("input[name='sRoutList[].subnetMask']").eq(i).focus();
			});
			return false;
		}

		if( !fn_inputIpCheck($("input[name='sRoutList[].gtwyNm']").eq(i).val()) ) {
			jAlert("게이트웨이 아이피 형식이 맞지 않습니다.", function() {
				$("input[name='sRoutList[].gtwyNm']").eq(i).focus();
			});
			return false;
		}
	}
	return true;
}

// IP대역 추가
function fn_insertIpBnd() {
	if(!fn_form_validation("insertIpBndFrm")){
		return;
	}

	var insttListlength = $("#insttListTbody input[name='checkInsttId']").length;
	if(insttListlength == 0){
		jAlert("부처를 선택하세요.");
		return;
	}

	// 용도 체크
	if($("#insertIpBndFrm input[name='prposClCdList']:checked").length == 0){
		jAlert("필수항목 : 용도를 선택해주세요");
		return;
	}

	var bndStrtIp = $("#insertIpBndFrm input[name='bndStrtIp']").val();
	var bndEndIp = $("#insertIpBndFrm input[name='bndEndIp']").val();
	var bndsnMask = $("#insertIpBndFrm input[name='subnetMask']").val();
	var bndgtwyIp = $("#insertIpBndFrm input[name='gtwyIpAddr']").val();

	if(!fn_inputIpCheck(bndStrtIp)){
		jAlert("시작IP : 올바른 IP주소 형식으로 입력하세요.", function(){
			$("#insertIpBndFrm input[name='bndStrtIp']").focus();
		});
		return;
	}

	if(!fn_inputIpCheck(bndEndIp)){
		jAlert("종료IP : 올바른 IP주소 형식으로 입력하세요.", function(){
			$("#insertIpBndFrm input[name='bndEndIp']").focus();
		});
		return;
	}

	if(!fn_subnetMaskCheck(bndsnMask)){
		jAlert("서브넷마스크 : 올바른 IP주소 형식으로 입력하세요.", function(){
			$("#insertIpBndFrm input[name='subnetMask']").focus();
		});
		return;
	}

// 	if(($("input[name='sRoutList[].ipBndAddr']").length == 0) && (gtwyIpAddr.value == "")){
// 		jAlert("게이트웨이 주소를 입력하시거나, 스태틱라우터를 설정해주시기 바랍니다.");
// 		return;
// 	}

	if(bndgtwyIp != ""){
		if(!fn_inputIpCheck(bndgtwyIp)){
			jAlert("게이트웨이 주소를 형식에 맞게 입력해주세요.", function() {
				$("input[name='gtwyIpAddr']").focus();
			});
			return;
		}
	}


	// 시작 아이피와 종료 아이피 비교
	if(!fn_compareIp(bndStrtIp, bndEndIp)){
		jAlert("시작과 종료IP 주소를 정확히 입력해주세요.");
		return;
	}

	// 스태틱라우터 아이피 주소 비교
	if(!input_sRoutIp_validation()){
		return;
	}

	var existCheck = [];
	var result = true;
	$("input:hidden[name='checkVmSeq']").each(function() {
		existCheck.push(this.value);
	});

	// 가상스위치 중복등록 검사
	$.each(existCheck, function(i){
		var str = this;
		$.each(existCheck, function(j){
			if(str.toString() == this){
				if(i!=j){
					jAlert("동일한 가상스위치 정보가 존재합니다.");
					existCheck = [];
					result = false;
					return false;
				}
			}
		});
	});

	// 게이트웨이와 스태틱라우터가 동시에 입력되어 있는지 체크
	if(($('#insertIpBndFrm input[name="gtwyIpAddr"]').val() != "") && ($("input[name='sRoutList[].ipBndAddr']").length > 0)){ // 둘다 true면 IP추가되면 안됨.
		jAlert("게이트웨이와 스태틱라우터 정보를 같이 입력할 수 없습니다.");
		return;
	}

	fn_form_rename("sRoutList", "ipBndAddr,subnetMask,gtwyNm");
	fn_form_rename("vrSwtchList", "regionNm,netNm,vrlzSwTyCdNm,rsrcPoolNm,netwkNm,vrSwtchSeq");
	fn_form_rename("ipBndInstVoList", "institutionNm,institutionId");

	jConfirm('입력한 정보로 IP대역을 추가 하시겠습니까?', function(){
		var options = {
			type : 'post',
			dataType : 'json',
			success : insertIpBndInfoResultHandler,
			beforeSend : function() {
				 $.ncmsLoding.startFullScreen();
			},
			complete : function() {
				 $.ncmsLoding.remove();
			},
			error : function(xhr, textStatus, errorThrown) {
				jAlert('오류가 발생하였습니다.');
			}
		};

		$('#insertIpBndFrm').attr('action', 'insertIpBnd.do');
		$('#insertIpBndFrm').ajaxSubmit(options);
	});
}

function insertIpBndInfoResultHandler(result) {
	if (result.success) {
		jInfo("IP대역 추가에 성공하였습니다.", function(){
			goToUrl("selectIpBndList.do");
		});
	} else {
		jAlert(result.messageList);
	}
}

//*** 스태틱라우터 ***//
function fn_insertSRout() {
	// IP대역정보에 게이트웨이 정보가 입력되어 있으면 설정할 수 없다.
	if($('#insertIpBndFrm input[name="gtwyIpAddr"]').val() != ""){
		jAlert("게이트웨이 정보가 입력된 상황에서는 스태틱라우터 설정을 할 수 없습니다.");
		return;
	}

	// 행 추가 한다.
	var html = null;
	html = '<tr>'
			+ '<td>'
			+ '<input type="text" name="sRoutList[].ipBndAddr" class="form-control" value="" maxlength="15" onblur="fn_getSubNetMaskAddress(this)" />'
			+ '</td>'
			+ '<td>'
			+ '<input type="text" name="sRoutList[].subnetMask" class="form-control" value="" maxlength="15"/>'
			+ '</td>'
			+ '<td>'
			+ '<input type="text" name="sRoutList[].gtwyNm" class="form-control" value="" maxlength="15"/>'
			+ '</td>'
			+ '<td>'
			+ '<button type="button" class="btn btn-sm btn-function" name="btnInsertSRout" onclick="fn_deleteSRout(this)" title="가상스위치삭제">삭제</button>'
			+ '</td>' + '</tr>';
	$("#sRoutListTable tbody").append(html);
}

// Static Router 삭제
function fn_deleteSRout(obj) {
	var tr = $(obj).parent().parent();
	tr.remove();
}

//*** 가상스위치 ***//
// 팝업창 중앙에 위치를 위한 값 전달
function getStatus(width, height) {
	var left = (screen.width - width) / 2;
	var top = (screen.height - height) / 2;
	var params = 'width=' + width + ', height=' + height;
	params += ', top=' + top + ', left=' + left;
	params += ', directories=no';
	params += ', location=no';
	params += ', menubar=no';
	params += ', resizeble=no';
	params += ', scrollbars=no';
	params += ', status=no';
	params += ', toolbar=no';

	return params;
}

// 가상스위치 호출 (팝업)
function fn_selecVrSwtchList() {
	var regionId = $("#insertIpBndFrm [name='regionId']").val();
	var netClCd = $("#insertIpBndFrm [name='netClCd']").val();

	if(regionId == ''){ // 센터가 선택되어 있지 않으면, 팝업창이 출력되면 안됨.
		jAlert("가상스위치를 추가하기 위해서는 센터를 선택해주세요.");
		return;
	}
	else if(netClCd == ''){ // 망이 선택되어 있지 않으면, 팝업창이 출력되면 안됨.
		jAlert("가상스위치를 추가하기 위해서는 망구분을 선택해주세요.");
		return;
	}

	var url = contextPath + '/cmn/component/vrSwtch/selectVrSwtchListP.do';
	var target = "selectVrSwtchListP";
	window.open("", target, getStatus(1280, 720));

	fn_form_rename("vrSwtchList", "regionNm,netNm,vrlzSwTyCdNm,rsrcPoolNm,netwkNm,vrSwtchSeq");
	fn_form_rename("ipBndInstVoList", "institutionNm,institutionId");

	$('#insertIpBndFrm').attr("target", target);
	$('#insertIpBndFrm').attr("action", url);
	$('#insertIpBndFrm').submit();
}

// 가상스위치 팝업창에서 전달받은 값 - 테이블 갱신
function setVrSwtchLIst(datas) {
	// 삭제
	//$('#vrSwtchListTbody > tr').remove();

	// 추가
	$.each(datas, function(count, item) {
		var html = '<tr>'
		+ '	<td>'+ this.regionNm + '</td>'
		+ '	<td class="alignL">'+ this.netNm + '</td>'
		+ '	<td class="alignL">'+ this.vrlzSwTyCdNm + '</td>'
		+ '	<td class="alignL">'+ this.rsrcPoolNm + '</td>'
		+ '	<td class="alignL">'+ this.netwkNm
		+ ' <td>'+ '<button type="button" class="btn btn-sm btn-function" name="btnDeleteVrSwtch" onclick="fn_deleteVrSwtch(this)">삭제</button>'
		+ '		<input type="hidden" name="vrSwtchList[].regionNm" value="' + this.regionNm + '" />'
		+ '		<input type="hidden" name="vrSwtchList[].netNm" value="' + this.netNm + '" />'
		+ '		<input type="hidden" name="vrSwtchList[].vrlzSwTyCdNm" value="' + this.vrlzSwTyCdNm + '" />'
		+ '		<input type="hidden" name="vrSwtchList[].rsrcPoolNm" value="' + this.rsrcPoolNm + '" />'
		+ '		<input type="hidden" name="vrSwtchList[].netwkNm" value="' + this.netwkNm + '" />'
		+ '		<input type="hidden" name="vrSwtchList[].vrSwtchSeq" value="' + this.vrSwtchSeq + '" />'
		+ '		<input type="hidden" name="checkVmSeq" value="' + this.vrSwtchSeq + '" />'
		+ '	</td>' + '</tr>';

		var bExists = false;
		var vmSwtchSeq = this.vrSwtchSeq;
		$.each($('#vrSwtchListTbody input:hidden[name="checkVmSeq"]'), function(index, item){
			if($(item).val() == vmSwtchSeq){
				bExists = true;
				return false;
			}
		});
		if(!bExists){
			$('#vrSwtchListTbody').append(html);
		}
	});
}

//가상스위치 삭제
function fn_deleteVrSwtch(obj) {
	var tr = $(obj).parent().parent();
	tr.remove();
}

//부처선택 호출 (팝업)
function fn_selectInsttList() {
	//var url = contextPath+'/cmn/component/instt/selectInsttListP.do';
	//window.open(url, "", getStatus(1440, 900));
	var url = contextPath + '/cmn/component/instt/selectInsttListP.do';
	var params = {
		"searchType" : "M"
	};
	var args = {
		key : "SelectInstt",
		width : 740,
		height : 820
	};
	windowOpen(url, params, args);

	fn_form_rename("ipBndInstVoList", "institutionNm,institutionId");
}

// 부처선택 팝업창에서 선택한 정보 설정
function setInstitution(evt) {
	// 삭제
	if(insttListTbody.rows[0].cells[0].innerText == ""){
		$('#insttListTbody > tr').remove();
	}
	else {
		// 행이 추가될 때, 마지막 셀에 "추가" 버튼이 있을 경우 해당 버튼을 삭제시켜줘야 함.
		var index = insttListTbody.rows.length - 1;
		var text = insttListTbody.rows[index].cells[2].innerText;
		console.log(text);
		if(text == '추가'){ // 추가 버튼이 있는지 확인
			insttListTbody.rows[index].cells[2].innerHTML = "";
		}
	}

	// 추가
	$.each(evt.datas, function(count, item){
		var html = '<tr>' +
		'	<td class="alignL">'+ this.institutionNm+'</td>' +
		'   <td>' + '<button type="button" class="btn btn-sm btn-function" name="btnDeleteInstt" onclick="fn_deleteInstt(this)" title="부처삭제">삭제</button>' +
		'		<input type="hidden" name="ipBndInstVoList[].institutionNm" value="' + this.institutionNm + '" />' +
		'		<input type="hidden" name="ipBndInstVoList[].institutionId" value="' + this.institutionId + '" />' +
		'		<input type="hidden" name="checkInsttId" value="' + this.institutionId + '" />' +
		'	</td>' +
		'	<td></td>' +
		'</tr>';
		var bExists = false;
		var institutionId = this.institutionId;
		$.each($('#insttListTbody input:hidden[name="checkInsttId"]'), function(index, item){
			if($(item).val() == institutionId){
				bExists = true;
				return false;
			}
		});
		if(!bExists){
			$('#insttListTbody').append(html);
		}
 	});

	// 마지막 행 편집하기 -> 마지막 행에는 버튼이 <삭제><추가> 가 존재해야 함.
	var last_index = insttListTbody.rows.length - 1;
	var insertBtn_html = '<button type="button" class="btn btn-sm btn-function" name="btnInsertInstt" onclick="fn_selectInsttList()" title="부처추가">추가</button>';
	insttListTbody.rows[last_index].cells[2].innerHTML = insertBtn_html;
}

// 부처 삭제
function fn_deleteInstt(obj){
	var tr = $(obj).parent().parent();
	tr.remove();

	// 추가버튼이 있는 행을 삭제했을 경우, 추가버튼을 마지막행에 추가해줘야 한다.
	var index = insttListTbody.rows.length - 1;
	if(index == -1){
		var html = '<tr>' +
		'	<td class="alignL"></td>' +
		'	<td></td>' +
		'   <td>' + '<button type="button" class="btn btn-sm btn-function" name="btnInsertInstt" onclick="fn_selectInsttList()" title="부처추가">추가</button>' +
		'	</td>' +
		'</tr>';
		$('#insttListTbody').append(html);
	}
	else {
		var text = insttListTbody.rows[index].cells[2].innerText;
		if(text != '추가'){ // 추가 버튼이 있는지 확인
			var insertBtn_html = '<button type="button" class="btn btn-sm btn-function" name="btnInsertInstt" onclick="fn_selectInsttList()" title="부처추가">추가</button>';
			insttListTbody.rows[index].cells[2].innerHTML = insertBtn_html;
		}
	}
}


// 스태틱라우터 설정 체크 -> 게이트웨이와 동시에 설정 불가능함.
function inputCheck(){
	if($("input[name='sRoutList[].ipBndAddr']").length > 0){
		jAlert("스태틱라우터가 설정되어 있어서 게이트웨이 주소를 입력할 수 없습니다.");
		$('#insertIpBndFrm input[name="gtwyIpAddr"]').val("");
		return;
	}
}

// 서브넷마스크 주소 얻기
function fn_getSubNetMaskAddress(object){
	var ipAddress = object.value;
	var split = ipAddress.split(".");
	var subNetMaskAddress = "";

	if(split.length == 4){
		if(parseInt(split[0]) >= 1 && parseInt(split[0]) <= 126){ // A클래스
			subNetMaskAddress = "255.0.0.0";
		}
		else if(parseInt(split[0]) >= 128 && parseInt(split[0]) <= 191){ // B클래스
			subNetMaskAddress = "255.255.0.0";
		}
		else if(parseInt(split[0]) >= 192 && parseInt(split[0]) <= 223){ // C클래스
			subNetMaskAddress = "255.255.255.0";
		}
	}
	if(object.name == "bndStrtIp" || object.name == "bndEndIp"){ // 시작IP
		$("input[name='subnetMask']").val(subNetMaskAddress);
	}
}

</script>