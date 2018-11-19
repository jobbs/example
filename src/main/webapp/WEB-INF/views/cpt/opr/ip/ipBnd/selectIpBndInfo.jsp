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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>

<c:url var="listUrl" value="selectIpBndList.do">
	<c:forEach var="curParam" items="${param }">
		<c:if test="${(curParam.key ne 'bndSeq') and (curParam.key ne 'searchType')}">
			<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
		</c:if>
	</c:forEach>
</c:url>

<c:url var="detailUrl" value="selectIpBnd.do">
	<c:forEach var="curParam" items="${param }">
		<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
	</c:forEach>
	<c:param name="ipBndSeq" value="${ipBndVo.bndSeq }" />
</c:url>

<form:form id="selectIpBndFrm" name="selectIpBndFrm" commandName="ipBndVo">
	<div class="box">
		<form:hidden path="regionId" value="${ipBndVo.regionId }" />
		<form:hidden path="bndSeq" value="${ipBndVo.bndSeq }" />
		<form:hidden path="ipBndUseYn" value="${ipBndVo.useYn }" />
		<form:hidden path="institutionId" id="institutionId" />
		<!-- box-header -->
		<div class="box-header">
			<h4 class="box-title">기본정보</h4>
		</div>
		<!-- /box-header -->
		<!-- box-body -->
		<div class="box-body no-padding">
			<table class="table table-horizon">
			<caption>IP대역기본정보(IP대역명, 사용여부, 망구분, 시작IP, 종료IP, 서브넷마스크, 게이트웨이, VLAN, 사용부처, 용도)</caption>
				<colgroup>
					<col class="col10">
					<col class="col23">
					<col class="col10">
					<col class="col23">
					<col class="col10">
					<col class="col23">
				</colgroup>
				<tbody>
					<tr>
						<th><span class="text-red">*</span>IP대역명</th>
						<td><form:input path="ipBndNm" value="${ipBndVo.ipBndNm }" 	cssClass="form-control essential" title="IP대역명" maxlength="50" />
						</td>
						<th>사용여부</th>
						<td><c:choose>
								<c:when test="${ipBndVo.useYn eq 'Y' or ipBndVo.useYn eq 'y'}">
									<div class="input-group input-group-radio">
										<form:radiobutton path="useYn" title="사용여부" cssClass="essential" label="사용" value="Y" checked="checked"/>
										<form:radiobutton path="useYn" title="사용여부" cssClass="essential" label="미사용" value="N" />
									</div>
								</c:when>
								<c:otherwise>
									<div class="input-group input-group-radio">
										<form:radiobutton path="useYn" title="사용여부" cssClass="essential" label="사용" value="Y" />
										<form:radiobutton path="useYn" title="사용여부" cssClass="essential" label="미사용" value="N" checked="checked"/>
									</div>
								</c:otherwise>
							</c:choose></td>
						<th>망구분</th>
						<td>
							<form:select path="netClCd" cssClass="form-control input-sm" title="망구분" onchange="fn_checkPrpos()">
							<c:forEach var="netCd" items="${netList}">
								<c:choose>
									<c:when test="${netCd.cd eq ipBndVo.netClCd}">
										<form:option value="${netCd.cd}" selected="selected" title="망구분"><c:out value="${netCd.cdNm}"></c:out></form:option>
									</c:when>
									<c:otherwise>
										<form:option value="${netCd.cd}" title="망구분"><c:out value="${netCd.cdNm}"></c:out></form:option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							</form:select>
						</td>
					</tr>
					<tr>
						<th>시작IP</th>
						<td><form:input path="bndStrtIp" value="${ipBndVo.bndStrtIp }" cssClass="form-control" maxlength="15" readonly="true" title="시작IP" /></td>
						<th>종료IP</th>
						<td><form:input path="bndEndIp" value="${ipBndVo.bndEndIp }" cssClass="form-control" maxlength="15" readonly="true" title="종료IP" /></td>
						<th><span class="text-red">*</span>서브넷마스크</th>
						<td><form:input path="subnetMask" value="${ipBndVo.subnetMask }" cssClass="form-control onlyIp essential" maxlength="15" title="서브넷마스크" /></td>
					</tr>
					<tr>
						<th>게이트웨이</th>
						<td><form:input path="gtwyIpAddr" value="${ipBndVo.gtwyIpAddr }" cssClass="form-control onlyIp" maxlength="15" title="게이트웨이" onchange="inputCheck()" /></td>
						<th><span class="text-red">*</span>VLAN</th>
						<td colspan="3"><form:input path="vlan" value="${ipBndVo.vlan }" cssClass="form-control onlyNumber essential" maxlength="30" title="VLAN" /></td>
					</tr>
					<tr>
						<th><span class="text-red">*</span>사용부처</th>
						<td class="alignL" colspan="5">
							<div class="input-group">
								<table class="table table-hover table-vertical  table-layout-fixed " id="insttListTable" >
								<colgroup>
									<col class="col92">
									<col class="col4">
									<col class="col4">
								</colgroup>
								<tbody id="insttListTbody">
									<c:forEach var="insttVo" items="${instituionList }" varStatus="i">
									<tr>
										<td class="alignL"><c:out value="${insttVo.institutionNm}" /> <input type="hidden" name="ipBndInstVoList[].institutionNm" value="${insttVo.institutionNm}" /></td>
										<td><button type="button" class="btn btn-sm btn-function" name="btnDeleteInstt" onclick="fn_deleteInstt(this)" title="부처삭제">삭제</button>
										<input type="hidden" name="ipBndInstVoList[].institutionId" value="${insttVo.institutionId}" />
										<input type="hidden" name="checkInsttId" value="${insttVo.institutionId}" />
										</td>
										<td></td>
									</tr>
									</c:forEach>
									<c:if test="${instituionList != null || instituionList.length == 0 }">
										<td></td>
										<td></td>
										<td><button type="button" class="btn btn-sm btn-function" name="btnInsertInstt" onclick="fn_selectInsttList()" title="부처추가">추가</button></td>
									</c:if>
								</tbody>
								</table>
<%-- 								<form:input name="institutionNm" path="institutionNm" value="${ipBndVo.institutionNm }" cssClass="form-control essential" maxlength="30" placeholder="부처를 선택해주세요." readonly="true" title="사용부처"/> --%>
<%-- 								<menu:authorize> --%>
<!-- 									<div class="input-group-btn" style="vertical-align: bottom"> -->
<!-- 									<button type="button" class="btn btn" title="부처검색" onclick="fn_selectInsttList()" style="border-left-style: 1px solid black; border-left: 1px solid #ddd;"><i class="fa fa-search"></i></button> -->
<!-- 									</div> -->
<%-- 								</menu:authorize> --%>
							</div>
						</td>
					</tr>
					<tr>
						<th><span class="text-red">*</span>용도</th>
						<td class="alignL" colspan="5">
							<div class="input-group input-group-check">
							<c:forEach var="prposClCd" items="${prposClCdList }">
							<c:set var="contains" value="false" />
							<c:forEach var="ipBndPrposVo" items="${ipBndVo.ipBndPrposVoList }">
								<c:if test="${ipBndPrposVo.prposClCd eq prposClCd.cd}">
									<c:set var="contains" value="true" />
								</c:if>
							</c:forEach>
							<c:choose>
								<c:when test="${contains}">
									<form:checkbox path="prposClCdList" value="${prposClCd.cd}" id="${prposClCd.cd}" checked="checked" title="용도" onclick="fn_checkPrpos()"/>
								</c:when>
								<c:otherwise>
									<form:checkbox path="prposClCdList" value="${prposClCd.cd}" id="${prposClCd.cd}" title="용도" onclick="fn_checkPrpos()"/>
								</c:otherwise>
							</c:choose>
							<label for="${prposClCd.cd}"><c:out	value="${prposClCd.cdNm}" /></label>
							</c:forEach>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->
	</div>
	<div class="box detail-list-box">
		<div class="box-header">
			<h4 class="box-title">
				가상스위치 연결 설정<small> </small>
			</h4>
			<div class="box-tools">
				<div class="input-group pull-right">
					<menu:authorize>
					<button type="button" class="btn btn-sm btn-function" onclick="fn_selectVrSwtchList()" title="추가">추가</button>
					</menu:authorize>
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
			<table class="table table-bordered" id="vrSwtchListTable" >
			<caption>가상스위치목록(센터, 망구분, 가상화SW, 네트워크명)</caption>
				<colgroup>
					<col class="col8">
					<col class="col12">
					<col class="col15">
					<col class="col18">
					<col class="col15">
					<col class="col20">
					<col class="col8">
				</colgroup>
				<thead>
					<tr>
						<th>센터</th>
						<th>망구분</th>
						<th>가상화SW</th>
						<th>자원풀</th>
						<th>데이터센터</th>
						<th>네트워크명</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="vrSwtchListTbody">
					<c:forEach var="vrSwtchVo" items="${vrSwtchlist }" varStatus="i">
						<tr>
							<td><c:out value="${vrSwtchVo.regionNm}" /> <input type="hidden" name="vrSwtchList[].regionNm" value="${vrSwtchVo.regionNm}" /></td>
							<td class="alignL"><c:out value="${vrSwtchVo.netNm}" /> <input type="hidden" name="vrSwtchList[].netNm" value="${vrSwtchVo.netNm}" /></td>
							<td class="alignL"><c:out value="${vrSwtchVo.vrlzSwTyCdNm}" /> <input type="hidden" name="vrSwtchList[].vrlzSwTyCdNm" value="${vrSwtchVo.vrlzSwTyCdNm}" /></td>
							<td class="alignL"><c:out value="${vrSwtchVo.rsrcPoolNm}" /> <input type="hidden" name="vrSwtchList[].rsrcPoolNm" value="${vrSwtchVo.rsrcPoolNm}" /></td>
							<td class="alignL"><c:out value="${vrSwtchVo.dataCntrNm}" /> <input type="hidden" name="vrSwtchList[].dataCntrNm" value="${vrSwtchVo.dataCntrNm}" /></td>
							<td class="alignL"><c:out value="${vrSwtchVo.netwkNm}" /> <input type="hidden" name="vrSwtchList[].netwkNm" value="${vrSwtchVo.netwkNm}" /></td>
							<td><button type="button" class="btn btn-sm btn-function" name="btnDeleteVrSwtch" onclick="fn_deleteVrSwtch(this)" title="가상스위치삭제">삭제</button>
							<input type="hidden" name="vrSwtchList[].vrSwtchSeq" value="${vrSwtchVo.vrSwtchSeq}" />
							<input type="hidden" name="checkVmSeq" 	value="${vrSwtchVo.vrSwtchSeq}" />
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="box">
		<div class="box-footer edit-btn-group">
			<div class="pull-left btns">
				<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
			</div>
			<div class="pull-right btns">
				<menu:authorize>
				<button type="button" class="btn btn-hover-green" data-toggle="tooltip" data-original-title="정보저장" onclick="fn_updateIpBnd()"><i class="fa fa-check"></i></button>
				<button type="button" class="btn btn-hover-red" data-toggle="tooltip" data-original-title="대역삭제" onclick="fn_deleteIpBnd()"><i class="fa fa-times"></i></button>
				</menu:authorize>
			</div>
		</div>
	</div>
</form:form>

<script type="text/javascript">
var compareVrSwtchCnt = 0; // 가상스위치 판단여부
var compareInsttRowCnt = 0; // 부처 판단여부
var orgVrSwtchArr;
var orgInsttArr;
var preNetClCd;

$(document).bind('selectInstitutionMulti',setInstitution);
$(document).ready(function(){
	makeVrSwtchClone();
	fn_checkPrpos(document.getElementById($("#selectIpBndFrm input[name='prposClCdList']:checked").val()).value);

	$("#selectIpBndFrm select[name='netClCd']").focus(function(){
		$(this).data('lastValue', $(this).val());
	});

	$("#selectIpBndFrm select[name='netClCd']").change(function(e){
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
					$("#selectIpBndFrm select[name='netClCd']").val(lastNetClCd).prop("selected", true);
				}
			});
		}
		else {
			// 마지막 선택값 저장
			$(this).data('lastValue', newNetClCd);
		}
	});

	// 부처목록의 마지막행에 추가 버튼 추가
	var index = insttListTbody.rows.length - 1;
	var text = insttListTbody.rows[index].cells[2].innerText;
	if(text != '추가'){ // 추가 버튼이 있는지 확인
		var insertBtn_html = '<button type="button" class="btn btn-sm btn-function" name="btnInsertInstt" onclick="fn_selectInsttList()" title="부처추가">추가</button>';
		insttListTbody.rows[index].cells[2].innerHTML = insertBtn_html;
	}
});

// 페이지 로딩 후 가상스위치 정보 복사
function makeVrSwtchClone(){
	orgVrSwtchArr = new Array();
	orgInsttArr = new Array();

	$("#vrSwtchListTable input[name='checkVmSeq']").each(function(){
		orgVrSwtchArr.push((this).value);
	});

	$("#insttListTable input[name='checkInsttId']").each(function(){
		orgInsttArr.push((this).value);
	});

}

// 페이지 이동
function fn_goToUrl(url){
	location.href = url;
}

function fn_checkPrpos(value){

	// 관리망의 경우 여려개 WEB/WAS/DB 어떤 용도를 선택해도 상관없도록 수정. 2018.05.21
	var netClCd = $("#selectIpBndFrm select[name='netClCd']").val();
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
	// 	var checkValue = document.getElementById($("#insertIpBndFrm input[name='prposClCdList']:checked").val()).value;
	var prposLength = $("#selectIpBndFrm input[name='prposClCdList']:checked").length;

	if(prposLength > 0){
		if(null == value){
			value = document.getElementById($("#selectIpBndFrm input[name='prposClCdList']:checked").val()).value;
		}
		switch (value) {
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

// 팝업창 중앙에 위치를 위한 값 전달
function getStatus(width, height){
	var left = (screen.width - width) / 2;
	var top =  (screen.height - height) / 2;
	var params = 'width='+width+', height='+height;
	params += ', top='+top+', left='+left;
	params += ', directories=no';
	params += ', location=no';
	params += ', menubar=no';
	params += ', resizeble=no';
	params += ', scrollbars=no';
	params += ', status=no';
	params += ', toolbar=no';

	return params;
}

// 부처선택 호출 (팝업)
function fn_selectInsttList(){
	//var url = contextPath+'/cmn/component/instt/selectInsttListP.do';
	//window.open(url, "", getStatus(1440, 900));
	var url = contextPath+'/cmn/component/instt/selectInsttListP.do';
	var params = {"searchType" : "M"};
	var args = {key:"SelectInstt", width:740,height:820};
	windowOpen(url, params, args);

	fn_form_rename("ipBndInstVoList", "institutionNm,institutionId");
}

// 가상스위치 호출 (팝업)
function fn_selectVrSwtchList(){
	var url = contextPath+'/cmn/component/vrSwtch/selectVrSwtchListP.do';
	//window.open(url, "", getStatus(1440, 900));
	var target = "selectVrSwtchListP";
	window.open("", target, getStatus(1280, 720));

	fn_form_rename("vrSwtchList", "regionNm,netNm,vrlzSwTyCdNm,rsrcPoolNm,netwkNm,vrSwtchSeq,dataCntrNm");
	fn_form_rename("ipBndInstVoList", "institutionNm,institutionId");

	$('#selectIpBndFrm').attr("target", target);
	$('#selectIpBndFrm').attr("action", url);
	$('#selectIpBndFrm').submit();
}

// 가상스위치 팝업창에서 전달받은 값 - 테이블 갱신
function setVrSwtchLIst(datas){
	// 삭제
	//$('#vrSwtchListTbody > tr').remove();

	// 추가
	$.each(datas, function(count, item){
		var html = '<tr>' +
		'	<td>'+ this.regionNm+'</td>' +
		'	<td class="alignL">'+ this.netNm+'</td>' +
		'	<td class="alignL">'+ this.vrlzSwTyCdNm+'</td>' +
		'	<td class="alignL">'+ this.rsrcPoolNm + '</td>' +
		'	<td class="alignL">'+ this.dataCntrNm + '</td>' +
		'	<td class="alignL">' + this.netwkNm +
		'   <td>' + '<button type="button" class="btn btn-sm btn-function" name="btnDeleteVrSwtch" onclick="fn_deleteVrSwtch(this)" title="가상스위치삭제">삭제</button>' +
		'		<input type="hidden" name="vrSwtchList[].regionNm" value="' + this.regionNm + '" />' +
		'		<input type="hidden" name="vrSwtchList[].netNm" value="' + this.netNm + '" />' +
		'		<input type="hidden" name="vrSwtchList[].vrlzSwTyCdNm" value="' + this.vrlzSwTyCdNm + '" />' +
		'		<input type="hidden" name="vrSwtchList[].rsrcPoolNm" value="' + this.rsrcPoolNm + '" />' +
		'		<input type="hidden" name="vrSwtchList[].netwkNm" value="' + this.netwkNm + '" />' +
		'		<input type="hidden" name="vrSwtchList[].vrSwtchSeq" value="' + this.vrSwtchSeq + '" />' +
		'		<input type="hidden" name="vrSwtchList[].dataCntrNm" value="' + this.dataCntrNm + '" />' +
		'		<input type="hidden" name="checkVmSeq" value="' + this.vrSwtchSeq + '" />' +
		'	</td>' +
		'</tr>';
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

// 부처 추가
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

//Ip check
function fn_ipCheck(ip){
	var pattern = /^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/;

	if(pattern.test(ip)){
		// split into units with dots '.'
		var parts = ip.split(".");
		if(parts.length != 4){
			return false;
		}

		if(parseInt(parts[0]) == 0){
			return false;
		}

		if(parseInt(parts[3]) == 0){
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



// 대역명 비교  - 대역명 비교 확인
function fn_isIpBndNmChangeCheck(){

	if($("#selectIpBndFrm input[name='ipBndNm']").val() != $("#selectIpBndFrm input[name='ipBndNm']")[0].defaultValue){
		return true;
	}

	return false;
}


// 정보변경내역 확인
function fn_isIpBndInfoChangeCheck(){
	var change = false;

	// 사용여부 비교
	if($("#selectIpBndFrm input[name='useYn']")[0].checked != $("#selectIpBndFrm input[name='useYn']")[0].defaultChecked){
		change = true;
	}

	// 망 선택값 비교
	if($("#selectIpBndFrm select[name='netClCd']").val() != $("#selectIpBndFrm select[name='netClCd'] option[selected]").val()){
		change = true;
	}

	// 서브넷마스크 비교
	if($("#selectIpBndFrm input[name='subnetMask']").val() != $("#selectIpBndFrm input[name='subnetMask']")[0].defaultValue){
		change = true;
	}

	// 게이트웨이 비교
	if($("#selectIpBndFrm input[name='gtwyIpAddr']").val() != $("#selectIpBndFrm input[name='gtwyIpAddr']")[0].defaultValue){
		change = true;
	}

	// Vlan 비교
	if($("#selectIpBndFrm input[name='vlan']").val() != $("#selectIpBndFrm input[name='vlan']")[0].defaultValue){
		change = true;
	}

//	// 부처 비교
//	if(fn_isInsttChangeCheck()){
//		change = true;
//	}

	// 용도 비교
	var length = $("#selectIpBndFrm input[name='prposClCdList']").length;
	for(var i=0; i<length; i++){
		if($("#selectIpBndFrm input[name='prposClCdList']")[i].checked != $("#selectIpBndFrm input[name='prposClCdList']")[i].defaultChecked){
			change = true;
		}
	}
	return change;
}

// 부처 정보 변경 여부 확인
function fn_isInsttChangeCheck(){
	var insttChange = false;

	// 가상스위치 비교
	var preInsttListLength = orgInsttArr.length;
	var insttListlength = $("#insttListTbody input[name='checkInsttId']").length;

	if(preInsttListLength != insttListlength){ // 크기가 다르다면 무조건 부처 정보는 변경되었음.
		insttChange = true;
	}
	else { // 크기가 같다면 checkInsttId 비교!
		$.each(orgInsttArr, function(i, id){
			var insttId = id;
			$.each($('#insttListTbody input:hidden[name="checkInsttId"]'), function(index, item){
				if($(item).val() == insttId){
					compareInsttRowCnt++;
				}
			});
		});
		if(compareInsttRowCnt != preInsttListLength){
			insttChange = true;
		}
	}
	compareInsttRowCnt = 0;
	return insttChange;

}

// 가상스위치 정보 변경 여부 확인
function fn_isVrSwtchChangeCheck(){
	var vrSwtchChange = false;

	// 가상스위치 비교
	var preVrSwtchListLength = orgVrSwtchArr.length;
	var vrSwtchListlength = $("#vrSwtchListTbody input[name='checkVmSeq']").length;

	if(preVrSwtchListLength != vrSwtchListlength){ // 크기가 다르다면 무조건 가상스위치 정보는 변경되었음.
		vrSwtchChange = true;
	}
	else { // 크기가 같다면 vrSwtchSeq 비교!
		$.each(orgVrSwtchArr, function(i, seq){
			var vmSwtchSeq = seq;
			$.each($('#vrSwtchListTbody input:hidden[name="checkVmSeq"]'), function(index, item){
				if($(item).val() == vmSwtchSeq){
					compareVrSwtchCnt++;
				}
			});
		});
		if(compareVrSwtchCnt != preVrSwtchListLength){
			vrSwtchChange = true;
		}
	}
	compareVrSwtchCnt = 0;
	return vrSwtchChange;
}

// IP대역 정보 수정
function fn_updateIpBnd(){
	// 정보변경 여부 판단
	var isChangeBndNm = fn_isIpBndNmChangeCheck();
	var isChangeBndInfo = fn_isIpBndInfoChangeCheck();
	var isChangeInsttInfo = fn_isInsttChangeCheck();
	var isChangeVrSwtch = fn_isVrSwtchChangeCheck();

	// 할당된 아이피가 1개라도 존재하면 IP대역은 수정할 수 없음. 단, IP대역명 , 사용부처 , 가상스위치 정보만 변경되었을 경우에는 가능함.
	if(${ipAsgnCnt} > 0){
		if(isChangeBndInfo){
			jAlert("할당된 아이피가 존재하므로, IP대역 정보수정을 할 수 없습니다.");
			return;
		}
	}

	if(!fn_form_validation("selectIpBndFrm")){
		return;
	}

	var insttListlength = $("#insttListTbody input[name='checkInsttId']").length;
	if(insttListlength == 0){
		jAlert("부처를 선택하세요.");
		return;
	}

	var snMask = $("#selectIpBndFrm input[name='subnetMask']").val();
	var gtwyIp = $("#selectIpBndFrm input[name='gtwyIpAddr']").val();

	if(!fn_subnetMaskCheck(snMask)){
		jAlert("서브넷마스크 주소를 형식에 맞게 입력해주세요.", function() {
			$("input[name='subnetMask']").focus();
		});
		return;
	}

	if((gtwyIp != "")){
		if(!fn_ipCheck(gtwyIp)){
			jAlert("게이트웨이 주소를 형식에 맞게 입력해주세요.", function() {
				$("input[name='gtwyIpAddr']").focus();
			});
			return;
		}
	}

	// 두 정보가 존재하지 않아도 됨. 둘중에 하나라도 정보가 존재하면 상관없음.
// 	if(($("input[name='sRoutList[].ipBndAddr']").length == 0) && (gtwyIpAddr.value == "")){
// 		jAlert("게이트웨이 주소를 입력하시거나, 스태틱라우터를 설정해주시기 바랍니다.");
// 		return;
// 	}

	if(!isChangeBndNm && !isChangeBndInfo && !isChangeInsttInfo && !isChangeVrSwtch){
		jAlert("변경된 정보가 존재하지 않습니다.");
		return;
	}

	var existCheck = [];
	var result = true;
	$("input:hidden[name='checkVmSeq']").each(function() {
		existCheck.push(this.value);
	});

	fn_form_rename("vrSwtchList", "regionNm,netNm,vrlzSwTyCdNm,rsrcPoolNm,netwkNm,vrSwtchSeq,dataCntrNm");
	fn_form_rename("ipBndInstVoList", "institutionNm,institutionId");

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
	if(($('#selectIpBndFrm input[name="gtwyIpAddr"]').val() != "") && ($("input[name='sRoutList[].ipBndAddr']").length > 0)){ // 둘다 true면 IP추가되면 안됨.
		jAlert("게이트웨이와 스태틱라우터 정보를 같이 입력할 수 없습니다.");
		return;
	}

	if(result){
		jConfirm('입력한 정보로 IP대역을 수정 하시겠습니까?', function() {
			var options = {
					type: 'post',
					dataType: 'json',
					success: updateIpBndInfoResultHandler,
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

				$('#selectIpBndFrm').attr('action', 'updateIpBnd.do');
				$('#selectIpBndFrm').ajaxSubmit(options);
		});
	}
}

function updateIpBndInfoResultHandler(result){
	if(result.success){
		jInfo("기본정보 수정에 성공하였습니다.", function(){
			fn_goToUrl('${detailUrl}');
		});
	}
	else{
		jAlert("기본정보 수정에 실패하였습니다."+result.messageList);
	}
}


//IP대역 삭제
function fn_deleteIpBnd(){
	var strtIp = $("#selectIpBndFrm input[name='bndStrtIp']").val();
	var endIp = $("#selectIpBndFrm input[name='bndEndIp']").val();

	// 사용여부 확인
	var useYn = $("#selectIpBndFrm input[name='ipBndUseYn']").val();
	if(useYn == 'Y'){
		jAlert("사용중인 IP대역은 삭제할 수 없습니다.");
		return;
	}
	else {
		jConfirm("해당 IP대역을 삭제하시겠습니까?", function() {
			var url = "<c:url value="deleteIpBnd.do" />";
			$.ncmsLoding.startFullScreen();
			$.post(url, {"bndSeq": ${ipBndVo.bndSeq}, "ipBndUseYn": useYn, "strtIp": strtIp, "endIp": endIp}, function(result) {
				alert_message(result.messageList);
				if( result.success) {
					jInfo("정상 처리되었습니다.", function(){
						fn_goToUrl('${listUrl}');
					});
				}
			}, "json").always(function() {
				$.ncmsLoding.remove();
			});
		});
	}
}


function inputCheck(){
	if(${sRoutListCnt} > 0){
		jAlert("스태틱라우터가 설정되어 있어서 게이트웨이 주소를 입력할 수 없습니다.");
		$('#selectIpBndFrm input[name="gtwyIpAddr"]').val("");
		return;
	}
}
</script>
