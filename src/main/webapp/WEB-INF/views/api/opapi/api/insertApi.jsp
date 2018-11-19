<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이제율
 * @lastmodifier 이제율
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     이제율         v1.0             최초생성
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

<div class="col-box-100 detail-col">
	<form:form commandName="vo" enctype="multipart/form-data">
		<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
		<!-- box(목록조회 테이블) -->
		<div class="box">

			<div class="box-body no-padding">
		    	<table class="table table-horizon">
			    	<caption>API관리</caption>
			      	<colgroup>
	                	<col class="col20">
	                  	<col class="col30">
	                  	<col class="col20">
	                  	<col class="col30">
	                </colgroup>
	                <tbody>
	                	<tr>
	                    	<th><label for="ApiId"><span class="text-red">*</span>API ID</label></th>
	                    	<td colspan="3">
	                    		<form:input path="ApiId" type="text" title="API ID" class="form-control essential" />
	                    	</td>
	                  	</tr>
	                  	<tr>
	                    	<th><label for="ApiNm"><span class="text-red">*</span>API 명</label></th>
	                    	<td>
	                    		<form:input path="ApiNm" type="text" title="API명" class="form-control essential" />
	                    	</td>
	                    	<th><label for="apiVerCd"><span class="text-red">*</span>버전</label></th>
	                    	<td>
	                    		<nform:selectCode
	                    			parentCd="203"
		                    		parentGrpCd="041"
		                    		name="apiVerCd"
		                    		id="apiVerCd"
		                    		whole="true"
		                    		title="버전"
		                    		wholeText="선택"
		                    		cssClass="form-control essential"/>
	                    	</td>
	                  	</tr>
	                  	<tr>
	                  		<th><label for="methodCd"><span class="text-red">*</span>Method</label></th>
	                    	<td>
		                    	<nform:selectCode
		                    		parentCd="202"
			                    	parentGrpCd="040"
			                    	name="methodCd"
			                    	id="methodCd"
			                    	whole="true"
			                    	title="Method"
			                    	wholeText="선택"
			                    	cssClass="form-control essential" />
	                    	</td>
	                    	<th><label for="stackClCd"><span class="text-red">*</span>스택분류</label></th>
	                    	<td>
		                    	<nform:selectCode
			                    	parentCd="201"
			                    	parentGrpCd="039"
			                    	name="stackClCd"
			                    	id="stackClCd"
			                    	whole="true"
			                    	title="스택분류"
			                    	wholeText="선택"
			                    	cssClass="form-control essential" />
	                    	</td>
	                   	</tr>
	                  	<tr>
	                    	<th><label for="uri"><span class="text-red">*</span>URI</label></th>
	                    	<td colspan="3">
		                    	<form:input path="uri" title="URI" type="text" class="form-control essential" />
	                    	</td>
	                  	</tr>
	                  	<!-- 변환 룰 정보 시작-->
	                  	<tr id="cnvrRole">
	                 		<th><span class="text-red">*</span>변환 룰 </th>
	                    	<td colspan="3">
	                        	<div class="form-group mg-bottom-5">
		                      		<table class="table table-bordered" id="cnvrRoleTable">
		                      			<caption>변환룰</caption>
		                        		<colgroup>
		                          			<col class="col5">
					                        <col class="col5">
					                        <col class="col10"><!--호출 Method-->
					                        <col class="colAuto"><!--호출URI-->
					                        <col class="col20"><!--매니저-->
					                        <col class="col10"><!--버전-->
					                        <col class="col10"><!--파일-->
		                        		</colgroup>
				                		<thead>
					                  		<tr>
							                	<th><input type="checkbox" id="selectAll" title="전체선택"></th>
							                	<th>SEQ</th>
												<th>Method</th>
												<th>URI</th>
												<th>매니저</th>
												<th>API버전</th>
												<th>변환 룰</th>
					                  		</tr>
				                		</thead>
	                          			<tbody id="cnvrRoleListTBody">
	                          			<!-- 추가되는 부분 시작-->
											<tr>
												<td>
													<input type="checkbox" name="delKey" class="delKey" value="" title="항목선택"/>
												</td>
												<td>
													<input type="text" name="cnvrRules[].targtSeq" title="SEQ" value="" class="form-control onlyNumber essential" />
												</td>
												<td>
													<select name="cnvrRules[].targtMethodCd" title="Method" class="form-control essential">
	                    								<option value="">선택</option>
	                    							</select>
												</td>
												<td>
													<input type="text" name="cnvrRules[].targtUri" title="URI" value="" class="form-control essential" />
												</td>
												<td>
													<select name="cnvrRules[].mngrClCd" title="매니저" class="form-control essential" onchange="selectboxMngVer(this, 0)">
	                    								<option value="">선택</option>
	                    							</select>
												</td>
												<td>
													<select id="apiVerCd0" name="cnvrRules[].apiVerCd" title="버전" class="form-control essential">
	                    								<option value="">선택</option>
	                    							</select>
												</td>
												<td>
													<div class="file-form-field input-group">
														<button type="button" class="btn btn-function btn-sm" id="btnCnvrScript0" name="btnCnvrScript" onclick="fn_popupModal(0);">변환 룰</button>
														<textarea id="cnvrScript0" name="cnvrRules[].cnvrScript" title="변환 룰" class="form-control essential" style="display:none"></textarea>
													</div>
												</td>
											</tr>
										<!-- 추가되는 부분 끝-->
										</tbody>
		                        	</table>
		                      	</div>
		                      	<div class="form-group no-margin-bottom alignR">
			                      	<button type="button" class="btn btn-sm btn-function" onclick="fn_insertCnvrRule()">변환 룰 추가</button>
		                        	<button type="button" class="btn btn-sm btn-function" name="btnInsertSRout" onclick="fn_deleteCnvrRole(this)">변환 룰 삭제</button>
		                      	</div>
	                    	</td>
						</tr>
	                  	<!-- 변환 룰 정보 끝-->
					  	<!-- 요청파라미터 정보 시작 -->
						<tr>
	                 		<th><span class="text-red">*</span>요청파라미터</th>
	                    	<td colspan="3">
	                        	<div class="form-group mg-bottom-5">
		                      		<table class="table table-bordered" id="reqParamTable">
		                      			<caption>요청파라미터</caption>
		                        		<colgroup>
		                          			<col class="col5">
					                        <col class="col10"><!--호출파라미터 분류-->
					                        <col class="col15"><!--호출파라미터 항목-->
					                        <col class="col20"><!--호출파라미터 항목명-->
					                        <col class="col10"><!--호출파라미터 타입-->
					                        <col class="col5"><!--호출파라미터 필수여부-->
					                        <col class="colAuto"><!--호출파라미터 설명-->
		                        		</colgroup>
				                		<thead>
					                  		<tr>
							                	<th><input type="checkbox" id="reqSelectAll" title="전체선택"></th>
							                	<th>분류</th>
												<th>항목</th>
												<th>항목명</th>
												<th>타입</th>
												<th>필수여부</th>
												<th>설명</th>
					                  		</tr>
				                		</thead>
	                          			<tbody id="reqParamListTBody">
	                          			<!-- 추가되는 부분 시작-->
											<tr>
												<td>
													<input type="checkbox" name="reqDelKey" class="delKey" title="항목선택"/>
												</td>
												<td>
													<select name="reqParams[].reqParamClCd" title="분류" class="form-control essential">
	                    								<option value="">선택</option>
	                    							</select>
												</td>
												<td>
													<input type="text" name="reqParams[].reqParamIemId" title="항목" class="form-control essential" />
												</td>
												<td>
													<input type="text" name="reqParams[].reqParamIemNm" title="항목명" class="form-control essential" />
												</td>
												<td>
													<select name="reqParams[].reqParamType" title="타입" class="form-control essential">
	                    							</select>
												</td>
												<td>
													<select name="reqParams[].reqParamEssntlAt" title="필수여부" class="form-control essential">
	                    							</select>
												</td>
												<td>
													<input type="text" name="reqParams[].reqParamDc" title="설명" class="form-control essential" />
												</td>
											</tr>
										<!-- 추가되는 부분 끝-->
										</tbody>
		                        	</table>
		                      	</div>
		                      	<div class="form-group no-margin-bottom alignR">
			                      	<button type="button" class="btn btn-sm btn-function" onclick="fn_insertReqParam()">파라미터 추가</button>
		                        	<button type="button" class="btn btn-sm btn-function" name="btnInsertSRout" onclick="fn_deleteReqParam(this)">파라미터 삭제</button>
		                      	</div>
	                    	</td>
						</tr>
					  	<!-- 요청파라미터 정보 끝-->
					  	<!-- 응답결과 정보 시작 -->
					  	<tr>
	                 		<th><span class="text-red">*</span>응답결과</th>
	                    	<td colspan="3">
	                        	<div class="form-group mg-bottom-5">
		                      		<table class="table table-bordered" id="rspnsResultTable">
		                      			<caption>응답결과</caption>
		                        		<colgroup>
		                          			<col class="col5">
					                        <col class="col10"><!--응답결과 항목-->
					                        <col class="col15"><!--응답결과 항목명-->
					                        <col class="col10"><!--응답결과 타입-->
					                        <col class="col5"><!--응답결과 필수여부-->
					                        <col class="colAuto"><!--호출파라미터 설명-->
		                        		</colgroup>
				                		<thead>
					                  		<tr>
							                	<th><input type="checkbox" id="rspnsSelectAll" title="전체선택"></th>
												<th>항목</th>
												<th>항목명</th>
												<th>타입</th>
												<th>필수여부</th>
												<th>설명</th>
					                  		</tr>
				                		</thead>
	                          			<tbody id="rspnsResultListTBody">
	                          			<!-- 추가되는 부분 시작-->
											<tr>
												<td>
													<input type="checkbox" name="rspnsDelKey" class="delKey" title="항목선택"/>
												</td>
												<td>
													<input type="text" name="rspnsResults[].rspnsResultIemId" title="항목" class="form-control essential" />
												</td>
												<td>
													<input type="text" name="rspnsResults[].rspnsResultIemNm" title="항목명" class="form-control essential" />
												</td>
												<td>
													<select name="rspnsResults[].rspnsResultType" title="타입" class="form-control essential">
	                    							</select>
												</td>
												<td>
													<select name="rspnsResults[].rspnsResultEssntlAt" title="필수여부" class="form-control essential">
	                    							</select>
												</td>
												<td>
													<input type="text" name="rspnsResults[].rspnsResultDc" title="설명" class="form-control essential" />
												</td>
											</tr>
										<!-- 추가되는 부분 끝-->
										</tbody>
		                        	</table>
		                      	</div>
		                      	<div class="form-group no-margin-bottom alignR">
			                      	<button type="button" class="btn btn-sm btn-function" onclick="fn_insertRspnsResult()">파라미터 추가</button>
		                        	<button type="button" class="btn btn-sm btn-function" name="btnInsertSRout" onclick="fn_deleteRspnsResult(this)">파라미터 삭제</button>
		                      	</div>
	                    	</td>
						</tr>
					  	<!-- 응답결과 정보 끝-->
	                  	<tr>
	                    	<th><label for="dc">설명</label></th>
	                    	<td colspan="3">
	                    		<form:textarea path="dc" title="설명" class="form-control" rows="3" maxlength="4000" />
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
<div class="col-box-100 detail-col">
	<!-- page-btn-group -->
    <div class="edit-btn-group">
        <div class="pull-left btns">
          <button type="button" class="btn btn-hover-gray" data-toggle="tooltip" data-original-title="뒤로" onclick="goToUrl('selectApiList.do')"><i class="fa fa-arrow-left"></i></button>
        </div>
        <div class="pull-right btns">
          <button type="button" class="btn btn-hover-green" data-toggle="tooltip" title="" data-original-title="저장" onclick="doSubmit();"><i class="fa fa-check"></i></button>
        </div>
    </div>
    <!-- /page-btn-group -->
</div>

<!-- 큰 모달 -->
<div class="modal fade" id="myModal2" role="dialog">
	<div class="modal-dialog modal-xlg">
		<div class="modal-content">
			<div class="modal-header">
				<div class="title pull-left">
					<h4 class="modal-title">변환 룰</h4>
				</div>
				<div class="tools pull-right">
					<button type="button" class="close" data-dismiss="modal"><span>×</span><span class="sr-only">닫기</span></button>
				</div>
			</div>
			<div class="modal-body">
	        	<textarea id="popupCnvrScript" class="box" title="변환 룰" rows="20"></textarea>
	        	<input type="hidden" id="callId"/>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-dark close-window" data-dismiss="modal" onclick="fn_cnvrScriptSet();">저장</button>
				<button type="button" class="btn close-window" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>
<!-- 큰 모달 -->

<script type="text/javascript">

var mngrRowCnt = 1;
var allowExt = ["txt"];

$(document).ready(function(){

	// 변환룰
	settingSelectBox("040", "202", "targtMethodCd", "cnvrRules", "targtMethodCd");						// Method

	// 요청파라미터
	settingSelectBox("080", "REQTYPE", "reqParamClCd", "reqParams", "reqParamClCd");					// 분류
	settingSelectBox("081", "TYPE", "reqParamType", "reqParams", "reqParamType");						// 타입
	settingSelectBox("079", "ESSNTL", "reqParamEssntlAt", "reqParams", "reqParamEssntlAt");				// 필수여부

	// 응답결과
	settingSelectBox("081", "TYPE", "rspnsResultType", "rspnsResults", "rspnsResultType");				// 타입
	settingSelectBox("079", "ESSNTL", "rspnsResultEssntlAt", "rspnsResults", "rspnsResultEssntlAt");	// 필수여부

	// 스택분류에 따른 변환룰 매니저 정보 변경
	$("select[name='stackClCd']").change(function(){
		selectboxMngDy(this);
		if($("select[name='stackClCd']").val() != 'PTL'){
			$('#cnvrRole').children().remove();
			html=''
			+'<th><span class="text-red">*</span>변환 룰 </th>'
			+'<td colspan="3">'
			+'	<div class="form-group mg-bottom-5">'
			+' 		<table class="table table-bordered" id="cnvrRoleTable">'
			+'  			<caption>변환룰</caption>'
			+'    		<colgroup>'
			+'      			<col class="col5">'
			+'                <col class="col5">'
			+'                <col class="col10"><!--호출 Method-->'
			+'                <col class="colAuto"><!--호출URI-->'
			+'                <col class="col20"><!--매니저-->'
			+'                <col class="col10"><!--버전-->'
			+'                <col class="col10"><!--파일-->'
			+'    		</colgroup>'
			+'    		<thead>'
			+'          		<tr>'
			+'                	<th><input type="checkbox" id="selectAll" title="전체선택"></th>'
			+'                	<th>SEQ</th>'
			+'					<th>Method</th>'
			+'					<th>URI</th>'
			+'					<th>매니저</th>'
			+'					<th>API버전</th>'
			+'					<th>변환 룰</th>'
			+'         		</tr>'
			+'   		</thead>'
			+'			<tbody id="cnvrRoleListTBody">'
			+' 			<!-- 추가되는 부분 시작-->'
			+'				<tr>'
			+'					<td>'
			+'						<input type="checkbox" name="delKey" class="delKey" value="" title="항목선택"/>'
			+'					</td>'
			+'					<td>'
			+'						<input type="text" name="cnvrRules[].targtSeq" title="SEQ" value="" class="form-control onlyNumber essential" />'
			+'					</td>'
			+'					<td>'
			+'						<select name="cnvrRules[].targtMethodCd" title="Method" class="form-control essential">'
			+'							<option value="">선택</option>'
			+'						</select>'
			+'					</td>'
			+'					<td>'
			+'						<input type="text" name="cnvrRules[].targtUri" title="URI" value="" class="form-control essential" />'
			+'					</td>'
			+'					<td>'
			+'						<select name="cnvrRules[].mngrClCd" title="매니저" class="form-control essential" onchange="selectboxMngVer(this, 0)">'
			+'							<option value="">선택</option>'
			+'						</select>'
			+'					</td>'
			+'					<td>'
			+'						<select id="apiVerCd0" name="cnvrRules[].apiVerCd" title="버전" class="form-control essential">'
			+'							<option value="">선택</option>'
			+'						</select>'
			+'					</td>'
			+'					<td>'
			+'						<div class="file-form-field input-group">'
			+'							<button type="button" class="btn btn-function btn-sm" id="btnCnvrScript0" name="btnCnvrScript" onclick="fn_popupModal(0);">변환 룰</button>'
			+'							<textarea id="cnvrScript0" name="cnvrRules[].cnvrScript" title="변환 룰" class="form-control essential" style="display:none"></textarea>'
			+'						</div>'
			+'					</td>'
			+'				</tr>'
			+'			<!-- 추가되는 부분 끝-->'
			+'			</tbody>'
			+'   	</table>'
			+' 	</div>'
			+' 	<div class="form-group no-margin-bottom alignR">'
			+'      	<button type="button" class="btn btn-sm btn-function" onclick="fn_insertCnvrRule()">변환 룰 추가</button>'
			+'   	<button type="button" class="btn btn-sm btn-function" name="btnInsertSRout" onclick="fn_deleteCnvrRole(this)">변환 룰 삭제</button>'
			+' 	</div>'
			+'</td>'
			+'';
			$('#cnvrRole').append(html);
			// 변환룰
			settingSelectBox("040", "202", "targtMethodCd", "cnvrRules", "targtMethodCd");						// Method
		}else{
			$('#cnvrRole').children().remove();

		}
	});

	// 체크박스 설정
	$('#selectAll').click(function(){
		$('input:checkbox[name=delKey]').prop('checked', $(this).is(":checked"));
	});

	$("input:checkbox[name=delKey]").each(function(){
		if($("input:checkbox[name=delKey]:checked").length == $("input:checkbox[name=delKey]").length){
			$('#selectAll').prop('checked', true);
		}else{
			$('#selectAll').prop('checked', false);
		}
	});

	$('#reqSelectAll').click(function(){
		$('input:checkbox[name=reqDelKey]').prop('checked', $(this).is(":checked"));
	});

	$("input:checkbox[name=reqDelKey]").each(function(){
		if($("input:checkbox[name=reqDelKey]:checked").length == $("input:checkbox[name=reqDelKey]").length){
			$('#reqSelectAll').prop('checked', true);
		}else{
			$('#reqSelectAll').prop('checked', false);
		}
	});

	$('#rspnsSelectAll').click(function(){
		$('input:checkbox[name=rspnsDelKey]').prop('checked', $(this).is(":checked"));
	});

	$("input:checkbox[name=rspnsDelKey]").each(function(){
		if($("input:checkbox[name=rspnsDelKey]:checked").length == $("input:checkbox[name=rspnsDelKey]").length){
			$('#rspnsSelectAll').prop('checked', true);
		}else{
			$('#rspnsSelectAll').prop('checked', false);
		}
	});

});

// select box 세팅
function settingSelectBox(grpCd, val, target, arrayNm, itemNm){

	var url = contextPath+'/api/cmn/component/selectboxList.do';
	var obj = $("select[name='"+arrayNm+"[]."+itemNm+"']");

	$.get(url, { "parentGrpCd" : grpCd, "parentCd" : val}, function(result) {
		if( result.success) {
			var datas = result.data;

			if( datas != null ) {
				obj.children("option:eq(0)").next().remove();
				//create Option
				for(var i = 0; i < datas.length; i++ ) {
					obj.append("<option value='" + datas[i].cd + "'>" + datas[i].cdNm + "</option>");
				}
			}
			$("#" + target).change();
		}
	}, "json");
}

// 매니저분류 변경
function selectboxMngDy(source) {

	var url = contextPath+'/api/cmn/component/selectboxMngrList.do';
	var val = $(source).val();

	if(val != ""){
		$.get(url, { "parentGrpCd" : "039", "parentCd" : val, "isWhole" : false}, function(result) {
			printOptions( result.data );
		});
	}else{
		$("select[name='cnvrRules[].mngrClCd']").each(function(idx) {
			$(this).children("option").eq(0).nextAll().remove();
			$(this).change();
		});
	}
}

//매니저분류 코드조회 결과 세팅
function printOptions(datas) {

	var mngrOptions = "";

	for( var i=0; i < datas.length; i++ ) {
		mngrOptions += "<option value='" + datas[i].cd + "'>" + datas[i].cdNm + "</option>";
	}

	$("select[name='cnvrRules[].mngrClCd']").each(function(idx) {

		$(this).children("option").remove();
		$(this).append(mngrOptions);
		$(this).change();
	});
}


//API버전 변경
function selectboxMngVer(obj, idx) {

	var url = contextPath+'/api/cmn/component/selectboxMngrList.do';
	var val = $(obj).val();

	if( val != "" ) {
		$.get(url, { "parentGrpCd" : "039", "parentCd" : val, "isWhole" : false}, function(result) {
			mngrVerPrintOptions( result.data, idx );
		});
	}else{
		$("#apiVerCd" + idx).children("option").eq(0).nextAll().remove();
	}

}

//API버전 코드조회 결과 세팅
function mngrVerPrintOptions(datas, idx) {

	$("#apiVerCd" + idx).children("option").remove();

	var mngrOptions = "";

	for( var i=0; i < datas.length; i++ ) {
		mngrOptions += "<option value='" + datas[i].cd + "'>" + datas[i].cdNm + "</option>";
	}

	$("#apiVerCd" + idx).append(mngrOptions);

	//$("select[id='apiVerCd']").eq(idx).append(mngrOptions);
}

//저장
function doSubmit(result){

	if(!fn_form_validation("vo")){
		return;
	}

	var totReqCnt = $("input[name='reqDelKey']").size();
	var totRspnsCnt = $("input[name='rspnsDelKey']").size();
	if(totReqCnt < 1){
		parent.jAlert("요청파라미터는 1개이상 존재해야 합니다.");
		return;
	}
	if(totRspnsCnt < 1){
		parent.jAlert("응답결과는 1개이상 존재해야 합니다.");
		return;
	}

	if($("select[name='stackClCd']").val() != "PTL"){
		fn_form_rename("cnvrRules","targtSeq,targtMethodCd,targtUri,mngrClCd,apiVerCd,cnvrScript");
	}
	fn_form_rename("reqParams","reqParamClCd,reqParamIemId,reqParamIemNm,reqParamType,reqParamEssntlAt,reqParamDc");
	fn_form_rename("rspnsResults","rspnsResultIemId,rspnsResultIemNm,rspnsResultType,rspnsResultEssntlAt,rspnsResultDc");

	jConfirm('Api를 저장하시겠습니까?', function(){
		var options = {
			type: 'post',
			dataType: 'json',
			url : contextPath+'/api/opapi/api/insertApi.do',
			success: fn_pageMove,
			beforeSend : function() {
			    $.ncmsLoding.startFullScreen();
		  	},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				alert('오류 발생');
			}
		};

		$('#vo').ajaxSubmit(options);
	});
}

// 콜백 / 화면이동
function fn_pageMove(result){

	alert_message(result.messageList, function() {
		if(result.success){
			if(result.procType == "insert") {
				location.href = "selectApiList.do";
			}
		}
	}, (result.success?"INFO":""));
}


// 변환룰 행추가
function fn_insertCnvrRule() {

	// 행 추가 한다.
	var html =''
		    +'<tr>'
			+'<td>'
			+'		<input type="checkbox" name="delKey" class="delKey" value="" />'
			+'</td>'
			+'<td>'
			+'		<input type="text" name="cnvrRules[].targtSeq" value="" title="SEQ" class="form-control onlyNumber essential" />'
			+'</td>'
			+'<td>'
			+'		<select name="cnvrRules[].targtMethodCd" title="Method" class="form-control essential">'
			+'		</select>'
			+'</td>'
			+'<td>'
			+'		<input type="text" name="cnvrRules[].targtUri" title="URI" value="" class="form-control essential" />'
			+'</td>'
			+'<td>'
			+'		<select name="cnvrRules[].mngrClCd" title="매니저" class="form-control essential" onchange="selectboxMngVer(this, ' + mngrRowCnt + ')">'
			+'		</select>'
			+'</td>'
			+'<td>'
			+'		<select name="cnvrRules[].apiVerCd" title="버전" id="apiVerCd' + mngrRowCnt + '" class="form-control essential">'
			+'		</select>'
			+'	</td>'
			+'<td>'
			+'	<div class="file-form-field input-group">'
			+'		<button type="button" class="btn btn-function btn-sm" id="btnCnvrScript' + mngrRowCnt + '" name="btnCnvrScript" onclick="fn_popupModal(' + mngrRowCnt + ');">변환 룰</button>'
			+'		<textarea id="cnvrScript' + mngrRowCnt + '" name="cnvrRules[].cnvrScript" title="변환 룰" class="form-control essential" style="display:none"></textarea>'
			+'	</div>'
			+'</td></tr>'
			+'</tr>'
			+'';

	$('#cnvrRoleListTBody').append(html);
	mngrRowCnt++;
	fn_addOptionSet();

}

// selectbox option 세팅
function fn_addOptionSet(){

	$("select[name='cnvrRules[].targtMethodCd']").last().append( $("select[name='cnvrRules[].targtMethodCd']").first().children("option").clone() );
	$("select[name='cnvrRules[].mngrClCd']").last().append( $("select[name='cnvrRules[].mngrClCd']").first().children("option").clone() );
	$("select[name='cnvrRules[].apiVerCd']").last().append( $("select[name='cnvrRules[].apiVerCd']").first().children("option").clone() );

	$("select[name='cnvrRules[].targtMethodCd']").last().children("option").eq(0).attr('selected','selected');
	$("select[name='cnvrRules[].mngrClCd']").last().children("option").eq(0).attr('selected','selected');
	$("select[name='cnvrRules[].apiVerCd']").last().children("option").eq(0).attr('selected','selected');
}


//변환룰 행삭제
function fn_deleteCnvrRole(){

	var obj = $("input[name='cnvrRules[].targtSeq']");
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
		parent.jAlert("변환룰은 1개이상 존재해야 합니다.");
		return;
	}

	$("input[name='delKey']").each(function() {
		if( $(this).prop("checked") ) {
			$(this).parent().parent().remove();
		}
	});
}

//요청파라미터 행추가
function fn_insertReqParam() {

	// 행 추가 한다.
	var html =''
			+'<tr>'
			+'	<td>'
			+'		<input type="checkbox" name="reqDelKey" class="delKey" title="항목선택"/>'
			+'	</td>'
			+'	<td>'
			+'		<select name="reqParams[].reqParamClCd" title="분류" class="form-control essential">'
			+'		</select>'
			+'	</td>'
			+'	<td>'
			+'		<input type="text" name="reqParams[].reqParamIemId" title="항목" class="form-control essential" />'
			+'	</td>'
			+'	<td>'
			+'		<input type="text" name="reqParams[].reqParamIemNm" title="항목명" class="form-control essential" />'
			+'	</td>'
			+'	<td>'
			+'		<select name="reqParams[].reqParamType" title="타입" class="form-control essential">'
			+'		</select>'
			+'	</td>'
			+'	<td>'
			+'		<select name="reqParams[].reqParamEssntlAt" title="필수여부" class="form-control essential">'
			+'		</select>'
			+'	</td>'
			+'	<td>'
			+'		<input type="text" name="reqParams[].reqParamDc" title="설명" class="form-control essential" />'
			+'	</td>'
			+'</tr>'
			+'';

	$('#reqParamListTBody').append(html);
	fn_reqAddOptionSet();

}

//selectbox option 세팅
function fn_reqAddOptionSet(){
	$("select[name='reqParams[].reqParamClCd']").last().append( $("select[name='reqParams[].reqParamClCd']").first().children("option").clone() );
	$("select[name='reqParams[].reqParamType']").last().append( $("select[name='reqParams[].reqParamType']").first().children("option").clone() );
	$("select[name='reqParams[].reqParamEssntlAt']").last().append( $("select[name='reqParams[].reqParamEssntlAt']").first().children("option").clone() );

	$("select[name='reqParams[].reqParamClCd']").last().children("option").eq(0).attr('selected','selected');
	$("select[name='reqParams[].reqParamType']").last().children("option").eq(0).attr('selected','selected');
	$("select[name='reqParams[].reqParamEssntlAt']").last().children("option").eq(0).attr('selected','selected');
}

//요청파라미터 행삭제
function fn_deleteReqParam(){

	var obj = $("input[name='reqParams[].reqParamClCd']");
	var checked = 0;
	var totCnt = $("input[name='reqDelKey']").size();
	var deleteNo = new Array();


	$("input[name='reqDelKey']").each(function() {
		if( $(this).prop("checked") ) {
			checked++;
		}
	});

	if( checked == 0 ) {
		parent.jAlert("삭제대상을 선택하시기 바랍니다.");
		return;
	}else if(totCnt == checked){
		parent.jAlert("요청파라미터는 1개이상 존재해야 합니다.");
		return;
	}

	$("input[name='reqDelKey']").each(function() {
		if( $(this).prop("checked") ) {
			$(this).parent().parent().remove();
		}
	});
}

//응답결과 행추가
function fn_insertRspnsResult() {

	// 행 추가 한다.
	var html =''
			+'<tr>'
			+'	<td>'
			+'		<input type="checkbox" name="rspnsDelKey" class="delKey" title="항목선택"/>'
			+'	</td>'
			+'	<td>'
			+'		<input type="text" name="rspnsResults[].rspnsResultIemId" title="항목" class="form-control essential" />'
			+'	</td>'
			+'	<td>'
			+'		<input type="text" name="rspnsResults[].rspnsResultIemNm" title="항목명" class="form-control essential" />'
			+'	</td>'
			+'	<td>'
			+'		<select name="rspnsResults[].rspnsResultType" title="타입" class="form-control essential">'
			+'		</select>'
			+'	</td>'
			+'	<td>'
			+'		<select name="rspnsResults[].rspnsResultEssntlAt" title="필수여부" class="form-control essential">'
			+'	</select>'
			+'	</td>'
			+'	<td>'
			+'		<input type="text" name="rspnsResults[].rspnsResultDc" title="설명" class="form-control essential" />'
			+'	</td>'
			+'</tr>'
			+'';

	$('#rspnsResultListTBody').append(html);
	fn_rspnsAddOptionSet();
}

//selectbox option 세팅
function fn_rspnsAddOptionSet(){
	$("select[name='rspnsResults[].rspnsResultType']").last().append( $("select[name='rspnsResults[].rspnsResultType']").first().children("option").clone() );
	$("select[name='rspnsResults[].rspnsResultEssntlAt']").last().append( $("select[name='rspnsResults[].rspnsResultEssntlAt']").first().children("option").clone() );

	$("select[name='rspnsResults[].rspnsResultType']").last().children("option").eq(0).attr('selected','selected');
	$("select[name='rspnsResults[].rspnsResultEssntlAt']").last().children("option").eq(0).attr('selected','selected');
}

//응답결과 행삭제
function fn_deleteRspnsResult(){

	var obj = $("input[name='rspnsResults[].rspnsResultIemId']");
	var checked = 0;
	var totCnt = $("input[name='rspnsDelKey']").size();
	var deleteNo = new Array();


	$("input[name='rspnsDelKey']").each(function() {
		if( $(this).prop("checked") ) {
			checked++;
		}
	});

	if( checked == 0 ) {
		parent.jAlert("삭제대상을 선택하시기 바랍니다.");
		return;
	}else if(totCnt == checked){
		parent.jAlert("응답결과는 1개이상 존재해야 합니다.");
		return;
	}

	$("input[name='rspnsDelKey']").each(function() {
		if( $(this).prop("checked") ) {
			$(this).parent().parent().remove();
		}
	});
}

// scipt값을 세팅해줌
function fn_cnvrScriptSet(){
	var id = $("#callId").val();
	var val = $("#popupCnvrScript").val();

	$("#"+id).val(val);
	$("#callId").val("");
	$("#popupCnvrScript").val("");
}

// modalpopup을 띄움
function fn_popupModal(idx){
	var id ="cnvrScript"+idx;

	$("#callId").val($("#"+id).attr("id"));
	$("#popupCnvrScript").val($("#"+id).val());
	$('div.modal').modal();
}


</script>