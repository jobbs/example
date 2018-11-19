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
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<form:form commandName="vo">
<div class="col-box-100 detail-col">
	<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
	<!-- box(목록조회 테이블) -->
	<div class="box">

		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>사용신청</caption>
				<colgroup>
					<col class="col20">
					<col class="col30">
					<col class="col20">
					<col class="col30">
				</colgroup>
				<tbody>
					<tr>
						<th><label for="regionId"><span class="text-red">*</span>API-Gateway</label></th>
						<td>
							<nform:selectRegion
								path="regionId"
								name="regionId"
								id="regionId"
								title="API-Gateway"
								cssClass="form-control essential"
								wholeText="선택"
								byRole="false" />
						</td>
						<th><label for="sysCd"><span class="text-red">*</span>신청시스템</label></th>
						<td>
							<nform:selectCode
								parentCd="208"
								parentGrpCd="046"
								name="sysCd"
								id="sysCd"
								whole="true"
								title="신청시스템"
								wholeText="선택"
								cssClass="form-control essential" />
						</td>
					</tr>
					<tr id="ips">
                 		<th><span class="text-red">*</span>IP </th>
                    	<td colspan="3">
                        	<div class="form-group mg-bottom-5">

	                      		<table class="table table-vertical" id="IpTable">
	                      			<caption>IP</caption>
	                        		<colgroup>
	                          			<col class="col5">
				                        <col class="colAuto"><!--IP-->
	                        		</colgroup>
			                		<thead>
				                  		<tr>
				                  			<th><input type="checkbox" id="selectAll" title="전체선택"></th>
											<th>IP</th>
				                  		</tr>
			                		</thead>
                          			<tbody id="ipListTBody">
                          			<!-- 추가되는 부분 시작-->
										<tr>
											<td>
												<input type="checkbox" name="delKey" class="delKey" value="" title="항목선택"/>
											</td>
											<td>
												<input type="text" name="ipAddr" title="IP" value="" class="form-control onlyIp essential"  maxlength="15" />
											</td>
										</tr>
									<!-- 추가되는 부분 끝-->
									</tbody>
	                        	</table>
	                      	</div>
	                      	<div class="form-group no-margin-bottom alignR">
		                      	<button type="button" class="btn btn-sm btn-function" onclick="fn_insertIp()">IP 추가</button>
	                        	<button type="button" class="btn btn-sm btn-function" name="btnInsertSRout" onclick="fn_deleteIp(this)">IP 삭제</button>
	                      	</div>
                    	</td>
					</tr>
					<tr>
						<th><label for="passwd"><span class="text-red">*</span>비밀번호</label></th>
						<td>
							<form:input path="passwd" title="비밀번호" type="password"	class="form-control essential" maxlength="60" autocomplete="off" />
						</td>
						<th><label for="passwdChk"><span class="text-red">*</span>비밀번호확인</label></th>
						<td>
							<form:input path="passwdChk" title="비밀번호확인" type="password" class="form-control essential" maxlength="60" autocomplete="off" />
						</td>
					</tr>
					<tr>
						<th><label for="reqReasn"><span class="text-red">*</span>사유(상세)</label></th>
						<td colspan="3">
							<form:textarea id="reqReasn" title="사유(상세)" path="reqReasn" class="form-control essential" rows="3" />
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->
		<div class="box-footer clearfix">
			<div class="pull-right"></div>
		</div>
		<!-- /box-footer -->
	</div>
	<!-- /box -->
</div>

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">API 목록</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" onclick="openApiSearch()">API조회</button>
					</div>
				</div>
			</div>
		</div><!-- /box-header -->
		<!-- box-body -->
		<div class="box-body no-padding detail-list-body">
			<table class="table table-hover table-vertical table-layout-fixed ">
				<caption>API목록</caption>
				<colgroup>
					<col class="col3">
					<col class="col10">
					<col class="col20">
					<col class="colAuto">
					<col class="col5">
				</colgroup>
				<thead>
					<tr>
						<th style="border-bottom: 0px">No.</th>
						<th style="border-bottom: 0px">스택분류</th>
						<th style="border-bottom: 0px">API명</th>
						<th style="border-bottom: 0px" colspan="2">설명</th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="box-body no-padding detail-list-body" style="max-height: 305px; min-height: 30px; overflow-y: auto; overflow-X: hidden;">
			<table class="table table-hover table-vertical">
				<colgroup>
					<col class="col3">
					<col class="col10">
					<col class="col20">
					<col class="colAuto">
					<col class="col5">
				</colgroup>
				<tbody id="apiBody">
					<tr>
						<td colspan="5">선택한 데이터가 없습니다.</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- /box-body   -->
	</div>
</div>
</form:form>

<div class="col-box-100 detail-col">
	<!-- page-btn-group -->
	<div class="edit-btn-group">
		<div class="pull-right btns">
			<button type="button" class="btn btn-hover-green" data-toggle="tooltip"
				data-original-title="저장" onclick="doSubmit();"><i class="fa fa-check"></i>
			</button>
		</div>
	</div>
	<!-- /page-btn-group -->
</div>

<script type="text/javascript">

//체크박스 설정
$(document).ready(function() {
	$('#selectAll').click(function() {
		$('.delKey').prop('checked', $(this).is(":checked"));
	});

	$('.delKey').click(function() {
		if ($('.delKey:checked').length == $('.delKey').length) {
			$('#selectAll').prop('checked', true);
		} else {
			$('#selectAll').prop('checked', false);
		}
	});
});


var cnt =1;
// API정보 조회(체크박스 선택)
function openApiSearch() {

	var url = contextPath+'/api/gw/req/selectApiListP.do';
	var params = {"searchType" : "M"};
	var args = {key:"SelectAPiMulti", width:750,height:900};
	windowOpen(url, params, args);
}


//IP 행추가
function fn_insertIp() {

	// 행 추가 한다.
	var html =''
			+'<tr>'
			+'<td>'
			+'	<input type="checkbox" name="delKey" class="delKey" value="" title=""/>'
			+'</td>'
			+'<td>'
			+'	<input type="text" name="ipAddr" title="IP" value="" class="form-control onlyIp essential"  maxlength="15"/>'
			+'</td>'
			+'</tr>'
			+'';

	$('#ipListTBody').append(html);

}

//IP 행삭제
function fn_deleteIp(){

	var checked = 0;
	var totCnt = $("input[name='delKey']").size();
	var deleteNo = new Array();


	$("input[name='delKey']").each(function() {
		if( $(this).prop("checked") ) {
			checked++;
		}
	});

	if( checked == 0 ) {
		parent.jAlert("삭제대상을 선택하시기 바랍니다.");
		return;
	}else if(totCnt == checked){
		parent.jAlert("IP는 1개이상 존재해야 합니다.");
		return;
	}

	$("input[name='delKey']").each(function() {
		if( $(this).prop("checked") ) {
			$(this).parent().parent().remove();
		}
	});
}


//Role 검색 선택시 처리할 이벤트 핸들러
$(document).bind('selectApiMulti',setRoles);

function setRoles(evt) {
	// 행 추가 한다.

	var html ='';
		$.each(evt.datas, function(index) {
			var exist = false;
			if($("input[name='apis[].apiId']").length > 0){
				for(var i=0; i<$("input[name='apis[].apiId']").length; i++){
					if(this.apiId == $("input[name='apis[].apiId']").eq(i).val()){	// 중복일 경우 추가하지 않음
						exist = true;
					}
				}
			}

			if(!exist){
				if($("input[name='apis[].apiId']").length == 0){
					$("#apiBody").children().remove();
				}
				html+='<tr>';
				html+='<td>'+cnt+'';
				html+='		<input type="hidden" name="apis[].apiId" value="'+this.apiId+'"/>';
				html+='</td>';
				html+='<td>'+this.stackClNm+'';
				html+='';
				html+='		<input type="hidden" name="apis[].stackClNm" value="'+this.stackClNm+'"/>';
				html+='</td>';
				html+='<td class="alignL">'+this.apiNm+'';
				html+='		<input type="hidden" name="apis[].apiNm" value="'+this.apiNm+'"/>';
				html+='</td>';
				html+='<td class="alignL">'+this.dc+'';
				html+='		<input type="hidden" name="apis[].dc" value="'+this.dc+'"/>';
				html+='</td>';
				html+='<td>';
				html+='<button class="btn btn-default btn-sm" onclick="doDeleteApi(this)">삭제</button>';
				html+='</td>';
				html+='</tr>';
				cnt++;
			}
		});

	$("#apiBody").append(html);

}

// API 삭제
function doDeleteApi(no) {
	$(no).parent().parent().remove();
	if($("input[name='apis[].apiId']").length == 0){
		html = ''
		+'<tr>'
		+'	<td colspan="5">선택한 데이터가 없습니다.</td>'
		+'</tr>';
		cnt = 1;
		$("#apiBody").append(html);
	}
}

//저장
function doSubmit(result){
	// validatoin 체크
	if(!fn_form_validation("vo")){
		return;
	}

	// ip 중복체크
	var ipChk = false;
	var length = $("input[name='ipAddr']").size();

	for( var j = 0; j < length; j++ ) {

		var ipAddr = $("input[name='ipAddr']").eq(j);
		var ipCnt=0;
		for(var i=0; i<$("input[name='ipAddr']").size(); i++){
			if(ipAddr.val() == $("input[name='ipAddr']:eq("+i+")").val()){
				ipCnt++;
			}
		}

		if(ipCnt > 1){
			ipChk = true;
			break;
		}
	}
	if(ipChk){
		jAlert("중복된 IP가 존재합니다.");
		return;
	}

	// 비밀번호 일치여부 체크
	if($("#passwd").val() != $("#passwdChk").val()){
		parent.jAlert("비밀번호와 비밀번호확인이 일치하지 않습니다.");
		return;
	}

	if($("input[name='apis[].apiId']").length > 0){
		fn_form_rename("apis","apiId,stackClNm,apiNm,dc");
	}

	jConfirm('사용신청내역을 저장하시겠습니까?', function(){
		// 호출
		$.ncmsLoding.startFullScreen();
		$.post('insertUseReq.do', $('#vo').serialize(), fn_pageMove, 'json').always(function() {
			$.ncmsLoding.remove();
		});
	});
}

// 콜백 / 화면이동
function fn_pageMove(result){

	alert_message(result.messageList, function() {
		if(result.success){
			if(result.procType == "insert") {
				// 로그인 화면으로 이동
				location.href = contextPath+"/api/gw/use/selectUseLogin.do";
			}
		}
	}, (result.success?"INFO":""));
}

</script>