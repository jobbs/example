<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     송승규         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/selectbox.js" />"></script>

<div class="col-box-100 detail-col">
	<form:form id="slbVo" commandName="vo">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">요청정보</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>SLB 생성 요청정보</caption>
				<colgroup>
						<col class="col20">
						<col class="col30">
						<col class="col20">
						<col class="col30">
				</colgroup>
				<tbody>
					<tr>
						<th><label for="regionId"><span class="text-red">*</span>센터</label></th>
						<td>
							<nform:selectRegion name="regionId" id="regionId" title="센터" cssClass="form-control essential" value="${vo.regionId}" whole="true" onchange="selectZoneDy(this, 'zoneId' )" />
						</td>
						<th><label for="zoneId"><span class="text-red">*</span>존</label></th>
						<td>
							<nform:selectZone name="zoneId" id="zoneId" title="존" cssClass="form-control essential" whole="true" regionId="${vo.regionId}" value="${vo.zoneId}" onchange="selectNetDy(this, 'netId' )" />
						</td>
					</tr>
					<tr>
						<th><label for="netId"><span class="text-red">*</span>망</label></th>
						<td>
							<nform:selectNet name="netId" id="netId" title="망" cssClass="form-control essential" whole="true" zoneId="${vo.zoneId}" value="${vo.netId}" onchange="selectPoolDy(this, 'regionId', 'zoneId', 'poolId', {searchSwTypeCd : 'NET'})" />
						</td>
						<th><label for="poolId"><span class="text-red">*</span>자원풀</label></th>
						<td>
							<nform:selectPool name="poolId" id="poolId" title="자원풀" cssClass="form-control essential" whole="true" poolTypeCd="03" swTypeCd="NET" regionId="${vo.regionId }" zoneId="${vo.zoneId}" netId="${vo.netId }" value="${vo.poolId}"/>
						</td>
					</tr>
					<tr>
						<th><label for="sbjct"><span class="text-red">*</span>제목</label></th>
						<td>
							<form:input path="sbjct" name="sbjct" cssClass="form-control essential" title="제목" value="" maxlength="500"/>
						</td>
						<th><label for="reqInstitutionNm"><span class="text-red">*</span>부처명</label></th>
						<td>
							<div class="input-group">
								<form:input path="reqInstitutionId" name="reqInstitutionId" cssClass="form-control essential" title="부처" value="" type="hidden" />
								<input id="reqInstitutionNm" name="reqInstitutionNm" class="form-control essential" title="부처명" value="" type="text" readonly="readonly" />
								<div class="input-group-btn">
									<button id="InstBtn" type="button" class="btn" onclick="openInsttSearch()"><i class="fa fa-search"></i></button>
								</div>
							</div>
						</td>
          			</tr>
          			<tr>
						<th><label for="ticktNo"><span class="text-red">*</span>티켓번호</label></th>
						<td>
							<form:input path="ticktNo" name="ticktNo" cssClass="form-control essential" title="티켓번호" value="" maxlength="20"/>
						</td><td></td><td></td>
          			</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">SLB 설정 정보</h3>
			<div class="box-tools">
<!--
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" onclick="fn_addSlb();">행 추가</button>
						<button type="button" class="btn btn-sm btn-function" onclick="fn_delSlb();">행 삭제</button>
					</div>
				</div>
-->
			</div>
		</div>
		<div class="box-body no-padding" style="overflow-x:auto">
			<table class="table table-hover table-vertical" id="slbTable">
				<caption>SLB 설정 정보 테이블</caption>
				<colgroup>
					<col class="col12">
					<col class="col7">
					<col class="col5">
					<col class="col15">
					<col class="col10">
					<col class="colAuto">
					<col class="col8">
					<col class="col8">
					<col class="col8">
					<col class="col6">
					<col class="colAuto">
				</colgroup>
				<thead>
					<tr>
						<th><nobr><span class="text-red">*</span>VIP</nobr></th>
						<th><nobr><span class="text-red">*</span>리스너<br>프로토콜</nobr></th>
						<th><nobr><span class="text-red">*</span>리스너<br>포트</nobr></th>
						<th><nobr><span class="text-red">*</span>유형</nobr></th>
						<th><nobr><span class="text-red">*</span>풀 세션<br>유지유형</nobr></th>
						<th><nobr><span class="text-red">*</span>풀 세션<br>유지값</nobr></th>
						<th><nobr><span class="text-red" title="TCP/HTTP/HTTPS">*</span>상태확인<br>(METHOD)</th>
						<th><nobr><span class="text-red">*</span>상태확인<br>주기<br>(초)</nobr></th>
						<th><nobr><span class="text-red">*</span>상태확인<br>타임아웃<br>(초)</nobr></th>
						<th><nobr><span class="text-red">*</span>최대<br>시도<br>횟수</nobr></th>
						<th><nobr><span class="text-red">*</span>상태확인<br>HTTP URL</nobr></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input name="reqNetList[0].vipAddr" type="text" class="form-control essential onlyIp" title="VIP주소" maxlength="15" onblur="fn_setVipAddr();"></td>
						<td>
							<select name="reqNetList[0].prtcl" class="form-control" title="프로토콜">
								<c:forEach var="prtclCode" items="${prtclCode}" varStatus="i">
									<option class='form-control input-sm' value="${prtclCode.cd}">${prtclCode.cdNm}</option>
								</c:forEach>
							</select>
						</td>
						<td><input name="reqNetList[0].port" type="text" class="form-control essential onlyInteger" title="포트" maxlength="60"></td>
						<td>
							<select name="reqNetList[0].slbTyCd" class="form-control" title="유형">
								<c:forEach var="slbTyCdCode" items="${slbTyCdCode}" varStatus="i">
									<option class='form-control input-sm' value="${slbTyCdCode.cd}">${slbTyCdCode.cdNm}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							<select name="reqNetList[0].sessMntncTyCd" class="form-control" title="세션유지유형" onchange="fn_setSessionVal(this)">
								<c:forEach var="sessMntncTyCdCode" items="${sessMntncTyCdCode}" varStatus="i">
									<option class='form-control input-sm' value="${sessMntncTyCdCode.cd}">${sessMntncTyCdCode.cdNm}</option>
								</c:forEach>
							</select>
						</td>
						<td><input name="reqNetList[0].sessMntncVl" type="text" class="form-control" title="세션 유지값" maxlength="200" readonly="readonly"></td>
						<!-- TODO:  상태확인 statConfrm  combo로 변경 필요.. -->
						<td><!-- <input name="reqNetList[0].statConfrm" type="text" class="form-control essential" title="상태확인 METHOD: TCP/HTTP/HTTPS" maxlength="20"> -->
							<select name="reqNetList[0].statConfrm" class="form-control essential" title="상태확인 METHOD: TCP/HTTP/HTTPS" onchange="fn_setStateMethod(this);">
								<option value="">선택하세요</option>
								<option value="TCP">TCP</option>
								<option value="HTTP">HTTP</option>
								<option value="HTTPS">HTTPS</option>
							</select>
						</td>
						<td><input name="reqNetList[0].statConfrmCycle" type="text" class="form-control essential onlyInteger" title="상태확인 주기(초)" maxlength="6"></td>
						<td><input name="reqNetList[0].statConfrmTOut" type="text" class="form-control essential onlyInteger" title="상태확인 타임아웃(초)" maxlength="6"></td>
						<td><input name="reqNetList[0].maxTryCnt" type="text" class="form-control essential onlyInteger" title="최대 시도 횟수" maxlength="6"></td>
						<td><input name="reqNetList[0].statConfrmHttpUrl" type="text" class="form-control" title="상태확인 HTTP URL" maxlength="500" readonly="readonly"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">SLB 적용대상 정보</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" title="가상서버 선택 팝업" onclick="fn_selectVmList();">가상서버 선택</button>
						<button type="button" class="btn btn-sm btn-function" title="행 삭제" onclick="fn_delSlbIp();">행 삭제</button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical" id="slbIpTable">
				<caption>SLB 적용대상 정보 테이블</caption>
				<colgroup>
					<col class="col3">
					<col class="col12">
					<col class="col12">
					<col class="col6">
					<col class="col10">
					<col class="colAuto">
				</colgroup>
				<thead>
					<tr>
						<th><nobr>선택</nobr></th>
						<th><nobr><span class="text-red">*</span>VIP</nobr></th>
						<th><nobr><span class="text-red">*</span>IP</nobr></th>
						<th><nobr><span class="text-red">*</span>포트</nobr></th>
						<th><nobr><span class="text-red">*</span>가중치<br>(로드밸런싱)</nobr></th>
						<th><nobr>설명</nobr></th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
	</form:form>
</div>
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="fn_selectNetVmList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize>
				<button type="button" class="btn btn-sm btn-hover-blue" data-toggle="tooltip" title="" data-original-title="저장" onclick="fn_insertCheck();"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>
<script type="text/javascript">

	$(document).ready(function() {
	});

	function fn_setSessionVal(obj) {
		var $statVal = $(obj).parent().parent().find("input[name*='\]\.sessMntncVl']");
		if(window.console) console.log($statVal);
		if(window.console) console.log(obj.value);

		if (obj.value == '03') {
			$statVal.addClass('essential');
			$statVal.attr('readonly', false);
		} else {
			$statVal.removeClass('essential');
			$statVal.attr('readonly', true);
		}
	}

	// 상태확인에 따른 HTTP URL 설정
	function fn_setStateMethod(obj) {
		var $httpUrl = $(obj).parent().parent().find("input[name*='\]\.statConfrmHttpUrl']");
		if(window.console) console.log($httpUrl);
		if(window.console) console.log(obj.value);

		if (obj.value == 'HTTP' || obj.value == 'HTTPS') {
			$httpUrl.addClass('essential');
			$httpUrl.attr('readonly', false);
		} else {
			$httpUrl.removeClass('essential');
			$httpUrl.attr('readonly', true);
		}
	}

	//뒤로
	function fn_selectNetVmList(){

		location.href = '<c:url value="selectNetVmList.do"><c:forEach var="curParam" items="${param}"><c:if test="${curParam.key ne 'vmSeq'}"><c:param name="${curParam.key}" value="${curParam.value}" /></c:if></c:forEach></c:url>';
	}

	// VIP set
	function fn_setVipAddr(){

		$('#slbIpTable tbody tr').each(function(index,item){
			$('#slbIpTable input[name="reqSlbList[].vipAddr"]').val($('#slbTable input[name="reqNetList[0].vipAddr"]').val());
		});
	}

	// 가중치 체크
	function fn_checkWvl(){

		var checkWvl = 0;

		var checkBool = true;

		$("input[name='reqSlbList[].wvl']").each( function() {
			checkWvl += parseInt($(this).val());
		} );

		if(checkWvl > 100){
			jAlert("가중치의 합은 100을 초과할 수 없습니다.", function(){
				//$('#slbIpTable input[name="reqSlbList['+index+'].wvl"]').focus();
			});
			checkBool = false;
		}

		return checkBool;
	}

	function fn_selectVmList(){

		// 센터, 존, 망, 부처 선택 후, 가상서버 선택 필요.
		if ($('#regionId').val()=='') {
			jAlert('센터를 선택한 후 [가상서버 선택] 버튼을 클릭하시기 바랍니다.', function() {
				$('#regionId').focus();
			});
			return;
		}
		if ($('#zoneId').val()=='') {
			jAlert('존을 선택한 후 [가상서버 선택] 버튼을 클릭하시기 바랍니다.', function() {
				$('#zoneId').focus();
			});
			return;
		}
		if ($('#netId').val()=='') {
			jAlert('망을 선택한 후 [가상서버 선택] 버튼을 클릭하시기 바랍니다.', function() {
				$('#netId').focus();
			});
			return;
		}
		if ($('#reqInstitutionNm').val()=='' ) {
			jAlert('부처를 선택한 후 [가상서버 선택] 버튼을 클릭하시기 바랍니다.', function() {
				$('#reqInstitutionNm').focus();
			});
			return;
		}

		var url = '<c:url value="selectComVmListP.do?equalsRegionId='+$('#regionId').val()+'&equalsZoneId='+$('#zoneId').val()+'&equalsNetId='+$('#netId').val()+'&containsInstitutionNm='+$('#reqInstitutionNm').val()+'"/>';
		var args = {key:"SelectSLB_VM", width:1280,height:720};
		windowOpen(url, "", args);

	}

	// SLB 설정정보 행 추가
	function fn_addSlb(){

		var index = $('#slbTable tbody tr').length;

		$('#slbTable').append(
			"<tr>"
				+"<td><input type='checkbox' name='delCheckSlb' class='delCheckSlb'></td>"
				+"<td><input name='reqNetList["+index+"].vipAddr' type='text' class='form-control essential onlyIp' title='VIP주소' maxlength='15'></td>"
				+"<td>"
					+"<select name='reqNetList["+index+"].prtcl' class='form-control'>"
						+"<c:forEach var='prtclCode' items='${prtclCode}' varStatus='i'>"
							+"<option class='form-control input-sm' value='${prtclCode.cd}'>${prtclCode.cdNm}</option>"
						+"</c:forEach>"
					+"</select>"
				+"</td>"
				+"<td><input name='reqNetList["+index+"].port' type='text' class='form-control essential' title='포트' maxlength='60'></td>"
				+"<td>"
					+"<select name='reqNetList["+index+"].slbTyCd' class='form-control'>"
						+"<c:forEach var='slbTyCdCode' items='${slbTyCdCode}' varStatus='i'>"
							+"<option class='form-control input-sm' value='${slbTyCdCode.cd}'>${slbTyCdCode.cdNm}</option>"
						+"</c:forEach>"
					+"</select>"
				+"</td>"
				+"<td>"
					+"<select name='reqNetList["+index+"].sessMntncTyCd' class='form-control'>"
						+"<c:forEach var='sessMntncTyCdCode' items='${sessMntncTyCdCode}' varStatus='i'>"
							+"<option class='form-control input-sm' value='${sessMntncTyCdCode.cd}'>${sessMntncTyCdCode.cdNm}</option>"
						+"</c:forEach>"
					+"</select>"
				+"</td>"
				+"<td><input name='reqNetList["+index+"].sessMntncVl' type='text' class='form-control essential' title='세션 유지값' maxlength='200'></td>"
				//+"<td><input name='reqNetList["+index+"].statConfrm' type='text' class='form-control essential' title='상태확인' maxlength='20'></td>"
				+ '<select name="reqNetList['+index+'].statConfrm" class="form-control essential" title="상태확인 METHOD: TCP/HTTP/HTTPS" onchange="fn_setStateMethod(this);">'
				+ '    <option value="">선택하세요</option>'
				+ '    <option value="TCP">TCP</option>'
				+ '    <option value="HTTP">HTTP</option>'
				+ '    <option value="HTTPS">HTTPS</option>'
				+ '</select>'
				+"<td><input name='reqNetList["+index+"].statConfrmCycle' type='text' class='form-control essential onlyInteger' title='상태확인 주기(초)' maxlength='6'></td>"
				+"<td><input name='reqNetList["+index+"].statConfrmTOut' type='text' class='form-control essential onlyInteger' title='상태확인 타임아웃(초)' maxlength='6'></td>"
				+"<td><input name='reqNetList["+index+"].maxTryCnt' type='text' class='form-control essential onlyInteger' title='최대 시도 횟수' maxlength='6'></td>"
				+"<td><input name='reqNetList["+index+"].statConfrmHttpUrl' type='text' class='form-control essential' title='상태확인 HTTP URL' maxlength='500'></td>"
			+"</tr>"
		);
	}

	// SLB 적용대상 정보 행 추가
	function fn_addSlbIp(datas){

		var index = $('#slbIpTable tbody tr').length;

		$.each($('#slbIpTable tbody tr'), function(idx){
			var str = $('#slbIpTable input[name="reqSlbList['+parseInt(idx)+'].ipAddr"]').val();
			$.each(datas, function(i){
				if(str == this.rprsntIpAddr){
					datas.remove(this);
				}
			});
		});

		$.each(datas, function(i){
			var str = this.rprsntIpAddr
			var cnt = 0;
			$.each(datas, function(j){
				if(str == this.rprsntIpAddr){
					if(cnt!=0){
						datas.remove(this);
					}
					cnt++;
				}
			});
		});

		$.each(datas, function(i){

			$('#slbIpTable').append(
					"<tr>"
						+"<td><input type='checkbox' name='delCheckIp' title='선택' class='delCheckIp'></td>"
						+"<td><input name='reqSlbList[].vipAddr' type='text' class='form-control essential onlyIp' title='VIP주소' maxlength='15' readonly='readonly' value="+$('#slbTable input[name="reqNetList[0].vipAddr"]').val()+" ></td>"
						+"<td><input name='reqSlbList[].ipAddr' type='text' class='form-control essential onlyIp' title='IP주소' maxlength='15' readonly='readonly' value='"+this.rprsntIpAddr+"'></td>"
						+"<td><input name='reqSlbList[].port' type='text' class='form-control essential onlyInteger' title='포트' maxlength='4'></td>"
						+"<td><input name='reqSlbList[].wvl' type='text' data-name='wvl' class='form-control essential onlyInteger' title='가중치' onblur='fn_checkWvl();' maxlength='3' ></td>"
						+"<td><input name='reqSlbList[].dc' type='text' class='form-control' title='설명' maxlength='4000'>"
						+"<input name='reqSlbList[].vmSeq' type='hidden' class='form-control' value='"+this.vmSeq+"'></td>"
					+"</tr>"
			);
		});

// 		$('#slbIpTable').find('input[data-name="wvl"]').blur(function(){
// 			fn_checkWvl();
// 		});
	}

	// SLB 설정정보 행 삭제
	function fn_delSlb(){

		var checked = 0;

		$("input[name='delCheckSlb']").each(function() {
			if ($(this).prop("checked")) {
				checked++;
			};
		});

		if (checked == 0) {
			jAlert("삭제대상을 선택하시기 바랍니다.");
			return;
		}

		$("input[name='delCheckSlb']").each(function(index,item) {
			if ($(this).prop("checked")) {
				$(this).closest('tr').remove();
			};
		});

	}

	// SLB 적용 대상정보 행 삭제
	function fn_delSlbIp(){

		var checked = 0;

		$("input[name='delCheckIp']").each(function() {
			if ($(this).prop("checked")) {
				checked++;
			};
		});

		if (checked == 0) {
			jAlert("삭제대상을 선택하시기 바랍니다.");
			return;
		}

		$("input[name='delCheckIp']").each(function(index,item) {
			if ($(this).prop("checked")) {
				$(this).closest('tr').remove();
			};
		});

	}

	$(document).bind('selectInstitution',setInstitution);
	function setInstitution(evt) {
		var val = evt.datas;
		$('#slbVo input[name="reqInstitutionNm"]').val(val.institutionNm);
		$('#slbVo input:hidden[name="reqInstitutionId"]').val(val.institutionId);
	}

	function fn_insertCheck(){

		if(!fn_form_validation("slbVo")){
			return;
		}

		if( $('#slbIpTable tbody tr').size() <= 0 ) {
			jAlert('SLB 적용대상을 한 건이상 입력하여 주시기바랍니다.');
			return;
		}

		if(fn_checkWvl()){
			fn_insertSlb();
		}
	}

	// SLB 설정요청
	function fn_insertSlb(){

		jConfirm('SLB 설정을 요청하시겠습니까?', function(){

			fn_form_rename("reqSlbList","vipAddr,ipAddr,port,wvl,dc,vmSeq");

			var options = {
				type: 'post',
				dataType: 'json',
				success: insertSlbCallBack,
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

			$('#slbVo').attr('action', 'insertSlb.do');
			$('#slbVo').ajaxSubmit(options);

		});
	}

	function insertSlbCallBack(result){

		if(result.success){
			jAlert("저장되었습니다.", function(){
				if(result.procType == "insert") {
					location.href = '<c:url value="selectNetVmList.do"/>';
				}
			});
		}
		else{
			jAlert(result.messageList);
		}
	}
</script>