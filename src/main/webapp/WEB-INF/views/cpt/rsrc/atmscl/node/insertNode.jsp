<%--
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre>노드 생성 화면</pre>
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

<form:form commandName="nodeVo">
<form:hidden path="netId" title="망ID"  />


<!-- 등록/상세 영역 -->
<div class="col-box-100 detail-col">

	<!--
	<div class="info no-margin-bottom">
	    <h2>알려드립니다.</h2>
	    <p><span class="text-red">※</span> 노드생성을 위한 사전작업을 수행 후 생성하시기 바립니다.</p>
	</div>
	-->

    <!--  기본정보 시작  -->
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">기본정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>

		<div class="box-body no-padding">
	        <table class="table table-horizon">
				<caption>노드 생성정보</caption>
				<colgroup>
					<col class="col20">
					<col class="col30">
					<col class="col20">
					<col class="col30">
				</colgroup>
				<tbody>
					<tr>
						<th><span class="text-red">*</span>센터</th>
						<td>
							<nform:selectRegion path="regionId" name="regionId" id="regionId" title="센터" cssClass="form-control essential" wholeText="센터을 선택해주세요" onchange="selectZoneDy(this, 'zoneId' )" />
						</td>
						<th><span class="text-red">*</span>존</th>
						<td>
							<nform:selectZone path="zoneId" name="zoneId" id="zoneId" title="존" cssClass="form-control essential" wholeText="존을 선택해주세요" onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'searchPoolTypeCd':'05'})" />
						</td>
					</tr>
					<tr>
						<th><span class="text-red">*</span>망구분</th>
						<td>
							<nform:selectCode
					          parentCd="NETCD"
					          parentGrpCd="067"
					          name="netClCd"
					          id="netClCd" title="망" cssClass="form-control essential" wholeText="망을 선택해주세요" onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'searchPoolTypeCd':'05'})" />
						</td>
						<th><span class="text-red">*</span>자원풀</th>
						<td>
							<nform:selectPool path="rsrcPoolId" name="rsrcPoolId" id="rsrcPoolId" title="자원풀" cssClass="form-control essential" poolTypeCd="05" wholeText="자원풀을 선택해주세요" />
						</td>
					</tr>
	            </tbody>
		    </table>
	    </div>
    </div>

	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">상세정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>

		<div class="box-body no-padding">
	        <table class="table table-horizon">
				<caption>상세정보</caption>
				<colgroup>
					<col class="col13">
					<col class="col20">
					<col class="col13">
					<col class="col20">
					<col class="col14">
					<col class="col20">
				</colgroup>
				<tbody>
					<tr>
						<th><label for="atmSclVmNm"><span class="text-red">*</span>설치대상 가상서버</label></th>
					    <td colspan="3">
					    	<div class="input-group">
					        	<form:input path="atmSclVmNm" title="설치대상 가상서버" cssClass="form-control essential"  maxlength="50" readonly="true"/>
					        	<div class="input-group-btn pad-left-5">
					        		<button id="vmListOpenkBtn" class="btn btn-default" onclick="javascript:fn_vmListOpen();return false;" data-toggle="tooltip" data-original-title="가상서버선택">
					        			<i class="fa fa-search"></i>
					        		</button>
					        	</div>
                        		<div class="input-group-btn">
                        			<button id="initVmBtn" class="btn btn-default" onclick="fn_vmInfoClear();return false;" data-toggle="tooltip" data-original-title="초기화">
                        				<i class="fa fa-eraser"></i>
                        			</button>
                        		</div>
					    	</div>
					    </td>

					    <th><label for="rprsntIpAddr"><span class="text-red">*</span>설치대상 가상서버 IP</label></th>
		                <td>
		                    <div class="input-group-box full">
		                    	<form:input path="rprsntIpAddr" class="form-control" readonly="true" title="설치대상 가상서버 IP" maxlength="100"/>
		                    	<div class="input-group-cell pad-right-5 fix-cell">
						              	<div class="input-group input-group-check pad-left-5">
		                    			<input type="checkbox" id="rprsntIpAddrCheck" name="rprsntIpAddrCheck" onclick="javascript:fn_rprsntIpAddrCheck();"/><label for="rprsntIpAddrCheck">직접입력</label>
		                    		</div>
		                    	</div>
		                    </div>
		                  </td>
					</tr>
					<tr>
						<th><label for="atmsclNodeNm"><span class="text-red">*</span>노드 도메인명</label></th>
						<td>
					        <form:input path="atmsclNodeNm" class="essential form-control" title="노드 도메인명"  />
					    </td>
					    <th><label for="atmsclNodeIpAddr"><span class="text-red">*</span>레지스트리 IP</label></th>
						<td>
					        <form:input path="atmsclNodeIpAddr" id="atmsclNodeIpAddr" class="essential form-control" title="레지스트리 IP"  />
					    </td>
					    <th><label for="vmRootPassWd"><span class="text-red">*</span>레지스트리 비밀번호</label></th>
					    <td>
					        <form:input path="vmRootPassWd" type="passWord" class="essential form-control" title="레지스트리 비밀번호"  />
					    </td>
					</tr>
	            </tbody>
		    </table>
	    </div>
    </div>

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
				<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="생성" data-original-title="생성"  onclick="fn_insertNode()"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>

<script type="text/javascript">

// 뒤로 버튼 클릭 시
function fn_selectServcAreaList(){
	location.href = '<c:url value="selectNodeList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'seq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}


//가상서버 선택 팝업
function fn_vmListOpen(){

	var regionId = $('#regionId').val();
	var zoneId = $('#zoneId').val();
	var netClCd = $('#netClCd').val();
	//var rsrcPoolId = $('#rsrcPoolId').val();

	if(regionId == '' || zoneId == '' || netClCd == '') {
		jAlert('기본정보를 선택해 주세요.');
		return;
	}

	var params = {"equalsRegionId" : regionId, "equalsZoneId" : zoneId, "equalsNetClCd" : netClCd };
	var url = 'selectAtmSclVmListPView.do';

	var width = 1400;
	var height = 740;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {width:width , height:height, posX : posX , posY : posY};
	windowOpen(url, params, args);
}


//가상서버 선택 초기화
function fn_vmInfoClear(target){
	$('#atmSclVmNm').val('');
}


//가상서버 팝업창에서 전달받은 값 - 테이블 갱신
$(document).bind('atmSclVmList',setAtmSclVmList);
function setAtmSclVmList(datas) {

	$("#rprsntIpAddr").attr('readonly',true);
	$('#rprsntIpAddrCheck').prop("checked", false);

	$.each(datas, function() {
		$('#atmSclVmNm').val(this.regionNm+"/"+this.zoneNm+"/"+this.netNm+"/"+this.rsrcPoolNm+"/"+this.vmNm);
		//$('#rsrcPoolId').val(this.rsrcPoolId);
		$('#netId').val(this.netId);
		$('#rprsntIpAddr').val(this.rprsntIpAddr); //가상서버 IP
	});
}

// 생성 버튼 클릭 시
function fn_insertNode(){

	if(!fn_form_validation("nodeVo")){
		return;
	}

	if(!fn_inputIpCheck($('#rprsntIpAddr').val())) {

		jAlert("설치대상 가상서버 IP 형식이 맞지 않습니다.", function(){
			$('#rprsntIpAddr').focus();
		});

		return;
	}

	if(!fn_inputIpCheck($('#atmsclNodeIpAddr').val())) {

		jAlert("레지스트리 IP 형식이 맞지 않습니다.", function(){
			$('#atmsclNodeIpAddr').focus();
		});

		return;
	}

	jConfirm('노드를 생성 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: insertNodeResultHandler,
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

		$('#nodeVo').attr('action', '<c:url value="insertNode.do"/>');
		$('#nodeVo').ajaxSubmit(options);

	});
}

// 생성 결과 콜백
function insertNodeResultHandler(result){

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


//아이피 검사
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


//가상서버IP 직접입력
function fn_rprsntIpAddrCheck(){

	if($('#atmSclVmNm').val() == '') {
		jAlert("설치대상 가상서버를 선택해 주세요.");
		$('#rprsntIpAddrCheck').prop("checked", false);
		return;
	}

	if($('#rprsntIpAddrCheck').prop("checked")==true){
		$("#rprsntIpAddr").attr('readonly',false);

	}else{
		$("#rprsntIpAddr").attr('readonly',true);
	}
}


</script>
