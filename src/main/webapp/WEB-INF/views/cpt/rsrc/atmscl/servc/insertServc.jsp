<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>서비스 생성 화면</pre>
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
 * 2017. 05. 13.     x         v1.0             최초생성
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

<form:form commandName="servcVo">
<!-- 등록/상세 영역 -->
<div class="col-box-100 detail-col">

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
				<caption>서비스 기본정보</caption>
				<colgroup>
					<col class="col10">
					<col class="col40">
					<col class="col10">
					<col class="col40">
				</colgroup>
				<tbody>
					<tr>
					    <th><span class="text-red">*</span>서비스영역</th>
			            <td colspan="3">
			                <div class="input-group">
	                            <input type="hidden" title="서비스영역SEQ" name="servcAreaSeq" id="servcAreaSeq" />
	                            <input type="hidden" title="서비스영역ID" name="servcAreaId" id="servcAreaId"/>
	                            <input type="hidden" title="센터" name="regionId" id="regionId" />
	                            <input type="hidden" title="존" name="zoneId" id="zoneId" />
	                            <input type="hidden" title="망" name="netClCd" id="netClCd" />
	                            <input type="hidden" title="자원풀" name="rsrcPoolId" id="rsrcPoolId"/>

	                            <input type="text" name="servcAreaNm" id="servcAreaNm" class="form-control essential" placeholder="서비스영역을 선택해주세요" disabled="disabled" title="서비스영역" />
	                            <div class="input-group-btn">
	                                <button type="button" class="btn" data-toggle="tooltip" title="검색" data-original-title="검색" onclick="fn_openServcAreaSearch();">
	                                    <i class="fa fa-search"></i>
	                                </button>
	                            </div>
	                        </div>
			            </td>
			        </tr>
					<tr>
					    <th><label for="servcNm"><span class="text-red">*</span>서비스	명</label></th>
					    <td colspan="3">
					        <form:input path="servcNm"  title="서비스명" cssClass="form-control essential" value="" maxlength="50"/>
					    </td>
					</tr>
					<tr>
					    <th><label for="hstNm"><span class="text-red">*</span>호스트명</label></th>
					    <td>
					        <form:input path="hstNm" title="호스트명" cssClass="form-control essential" value="" maxlength="50"/>
					    </td>
					    <th><span class="text-red">*</span>베이스이미지</th>
	                    <td>
	                        <div class="input-group">
	                            <input type="hidden" title="베이스이미지" name="imgId" id="imgId" />
	                            <input type="hidden" title="베이스이미지버전" name="imgVer" id="imgVer" />
	                            <input type="hidden" title="베이스이미지서비스영역ID" name="baseImgServcAreaId" id="baseImgServcAreaId" />
	                            <input type="hidden" title="베이스이미지서비스영역SEQ" name="baseImgServcAreaSeq" id="baseImgServcAreaSeq" />
	                            <input type="text" name="imgNm" id="imgNm" class="form-control essential" placeholder="베이스이미지를 선택해주세요" disabled="disabled" title="베이스이미지" />
	                            <div class="input-group-btn">
	                                <button type="button" class="btn" data-toggle="tooltip" title="검색" data-original-title="검색" onclick="fn_openBaseImgSearch();">
	                                    <i class="fa fa-search"></i>
	                                </button>
	                            </div>
	                        </div>
	                    </td>
					</tr>
					<tr>
					    <th>비고</th>
					    <td colspan="3">
					        <form:textarea path="rmk" cssClass="form-control" title="비고" rows="3" maxlength="1000" />
					    </td>
					</tr>
	            </tbody>
		    </table>
	    </div>
    </div>
	<!--  기본정보 끝  -->

	<!--  빌드정보 시작  -->
	<div class="box">
        <div class="box-header">
            <h3 class="box-title">빌드 정보</h3>
        </div>

		<div class="box-body no-padding">
		    <table class="table table-horizon">
				<caption>서비스영역 쿼터 정보</caption>
				<colgroup>
					<col class="col10">
					<col class="col40">
					<col class="col10">
					<col class="col40">
				</colgroup>
				<tbody>
				    <tr>
					    <th><label for="gitRepoAddr"><span class="text-red">*</span>Git 소스 URL경로</label></th>
					    <td>
					        <form:input path="gitRepoAddr" title="Git 소스 URL경로" cssClass="form-control essential" value="" maxlength="50"/>
					    </td>
					    <th><label for="gitBrnchNm">Git 브랜치(Branch)</label></th>
					    <td>
					        <form:input path="gitBrnchNm"  title="Git 브랜치" cssClass="form-control" value="" maxlength="50"/>
					    </td>
					</tr>
					<tr>
					    <th><label for="gitBestPath">Git 빌드 최상위경로</label></th>
					    <td>
					        <form:input path="gitBestPath" title="Git 빌드 최상위경로" cssClass="form-control" value="" maxlength="50"/>
					    </td>
					    <th><label for="gitScrtkyId"><span class="text-red">*</span>Git 보안키</label></th>

					    <td>
					    	<div class="input-group-box">
								<div class="input-group-cell pad-right-5">
									 <form:select path="gitScrtkyId" title="보안키 선택" cssClass="form-control essential">
				                  		<form:option value="">--선택하세요--</form:option>
				                  	</form:select>
								</div>
								<div class="input-group-cell pad-right-5">
									 <button class="btn btn-sm btn-function" onclick="openScrtkySearch();return false;">보안키 생성</button>
								</div>
							</div>
					    </td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!--  빌드정보 끝  -->

	<!--  라우트정보 시작  -->
	<div class="box">
        <div class="box-header">
            <h3 class="box-title">라우트 정보</h3>
        </div>

		<div class="box-body no-padding">
		    <table class="table table-horizon">
				<caption>라우트 정보</caption>
				<colgroup>
					<col class="col10">
					<col class="col90">
				</colgroup>
				<tbody>
				    <tr>
					    <th><label for="targtPort"><span class="text-red">*</span>대상 포트</label></th>
					    <td>
					        <form:select path="targtPort" title="포트 선택" cssClass="form-control">
		                  		<form:option value="">--선택하세요--</form:option>
		                  	</form:select>
					    </td>
					</tr>
				</tbody>
			</table>
		</div>
	</div><br>
	<!--  라우트정보 끝  -->

	<!-- 환경변수 시작  -->
	<div class="box detail-list-box">

		<div class="info">
			<h2>배포 환경변수 입력 유의사항</h2>
			<p>- 첫글자는 영문 대문자 또는 소문자만 입력 가능합니다. (한글 불가)</p>
			<p>- 특수문자는 '_' 만 사용가능합니다.</p>
		</div>

        <div class="box-header">
            <h3 class="box-title">배포 환경변수 정보</h3>
            <div class="box-tools">
				<div class="pull-right">
					<button type="button" class="btn btn-sm btn-function" onclick="fn_insertEnv()" title="환경변수 추가">추가</button>
				</div>
			</div>
        </div>

		<div class="box-body no-padding" >
		    <table class="table table-vertical" id="envTable">
				<caption>환경변수 추가</caption>
				<colgroup>
					<col class="col40">
					<col class="col50">
					<col class="col10">
				</colgroup>
				<thead>
					<tr>
						<th>변수명</th>
						<th>변수값</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="sEnvListTBody">
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
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectServcList()"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize onlyOprAdm="true">
				<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="생성" data-original-title="생성"  onclick="fn_insertServc()"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>

<script type="text/javascript">

// 뒤로 버튼 클릭 시
function fn_selectServcList(){
	location.href = '<c:url value="selectServcList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'servcSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

// 생성 버튼 클릭 시
function fn_insertServc(){

	if(!fn_form_validation("servcVo")){
		return;
	}


	if(!fn_checkHstNmStr($('#hstNm').val())) {

		jAlert('호스트명을 다시 입력해 주세요. \n - 영문소문자, 숫자, "-", "." 으로 구성하여 입력해주세요. \n - 시작과 끝은 문자나 숫자로 입력해 주세요.', function() {
			$("#hstNm").focus();
		});

		return;
	}

	if(!fn_checkEnvList()) {
		return;
	}

	fn_form_rename("distrbEnvConfList", "envVarNm,envVarVl");


	jConfirm('서비스를 생성 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: insertServcResultHandler,
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

		$('#servcVo').attr('action', '<c:url value="insertServc.do"/>');
		$('#servcVo').ajaxSubmit(options);

	});
}

// 생성 결과 콜백
function insertServcResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo(result.messageList, function(){
			fn_selectServcList();
		});
	}
	else{
		alert_message(result.messageList)
	}
}


//서비스영역 선택 팝업
function fn_openServcAreaSearch(){

	var url = 'selectServcAreaListPView.do';
	var width = 1280;
	var height = 760;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {width:width , height:height, posX : posX , posY : posY};
	windowOpen(url, '', args);
}

//서비스영역 선택 콜백
function fn_selectedServcArea(servcArea){
	$('#servcAreaSeq').val(servcArea.servcAreaSeq);
	$('#servcAreaId').val(servcArea.servcAreaId);
	$('#servcAreaNm').val(servcArea.servcAreaNm);
	$('#rsrcPoolId').val(servcArea.rsrcPoolId);
	$('#regionId').val(servcArea.regionId);
	$('#zoneId').val(servcArea.zoneId);
	$('#netClCd').val(servcArea.netClCd);

	fn_setScrtky(servcArea.servcAreaSeq);
}

//베이스이미지 선택 팝업
function fn_openBaseImgSearch(){

	if($('#servcAreaId').val()=='') {
		//alert("서비스영역을 선택해 주세요.");
		jAlert("서비스영역을 선택해 주세요.");
		return;
	}

	var params = {
		      "regionId" : $('#regionId').val(),
		      "zoneId" : $('#zoneId').val(),
		      "netClCd" : $('#netClCd').val(),
		      "rsrcPoolId" : $('#rsrcPoolId').val()};

	var url = 'selectBaseImgListPView.do';
	var width = 1280;
	var height = 520;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {width:width , height:height, posX : posX , posY : posY};
	windowOpen(url, params, args);
}

//베이스이미지 선택 콜백
function fn_selectedBaseImg(baseImg){

	$('#imgId').val(baseImg.imgId);
	$('#imgNm').val(baseImg.imgNm);
	$('#imgVer').val(baseImg.imgVer);
	$('#baseImgServcAreaId').val(baseImg.baseImgServcAreaId);
	$('#baseImgServcAreaSeq').val(baseImg.baseImgServcAreaSeq);

	fn_getTargetPortInfo();
}

//대상포트 정보를 셋팅한다.
function fn_getTargetPortInfo() {

	var imgId = $("#imgId").val(); //자원풀ID
	var rsrcPoolId = $("#rsrcPoolId").val(); //용도
	var servcAreaSeq = $("#baseImgServcAreaSeq").val(); //베이스이미지서비스영역SEQ

	$.ajax({
		type : "POST"
		,url : "<c:url value='/cpt/rsrc/atmscl/servc/selectTargetPortList.do'/>"
		,data : "rsrcPoolId="+rsrcPoolId+"&imgId="+imgId+"&servcAreaSeq="+servcAreaSeq
		,beforeSend: function() {}
		,error: function(xhr, textStatus, errorThrown){
			alert('오류 발생!');
		}
		,success :
			function(data) {
					//alert(JSON.stringify(data));
					var dataObj = data.data;
					var selectTag = "";
					if(dataObj!="") {
						var selectTag = "";
						$.each(dataObj,function(i){
							selectTag+='<option value="'+dataObj[i].portInfo+'">'+dataObj[i].portInfo+'</option>';
						});

						$("#targtPort").html(selectTag);
					}
			}
	});

}


//보안키 생성 팝업화면 호출
function openScrtkySearch() {
	if($('#servcAreaId').val()=='') {
		jAlert("서비스영역을 선택해 주세요.");
		return;
	}

	var servcAreaSeq = $('#servcAreaSeq').val();
	var servcAreaId = $('#servcAreaId').val();
	var regionId = $('#regionId').val();
	var zoneId = $('#zoneId').val();
	var netClCd = $('#netClCd').val();
	var rsrcPoolId = $('#rsrcPoolId').val();

	var params = {"servcAreaSeq" : servcAreaSeq,
			      "servcAreaId" : servcAreaId,
			      "regionId" : regionId,
			      "zoneId" : zoneId,
			      "netClCd" : netClCd,
			      "rsrcPoolId" : rsrcPoolId};

	var url = 'insertScrtkyP.do';
	var width = 1000;
	var height = 400;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {width:width , height:height, posX : posX , posY : posY};
	windowOpen(url, params, args);
}


//보안키 정보를 셋팅힌다.
function fn_setScrtky(servcAreaSeq) {
	$.ajax({
		type : "POST"
		,url : 'selectScrtKyList.do'
		,data : "servcAreaSeq="+servcAreaSeq
		,beforeSend: function() {}
		,error: function(xhr, textStatus, errorThrown){
			alert('오류 발생!');
		}
		,success :
			function(data) {
					//alert(JSON.stringify(data));
					var dataObj = data.data;
					var selectTag = "";
					if(dataObj!="") {
						var selectTag = "";
						$.each(dataObj,function(i){
								selectTag+='<option value="'+dataObj[i].scrtkyId+'">'+dataObj[i].scrtkyId+'</option>';
						});

						$("#gitScrtkyId").html(selectTag);
					}
			}
	});
}


//환경변수 추가
function fn_insertEnv() {

	// 행 추가 한다.
	var html = null;
	html = '<tr>'
			+ '<td>'
			+ '<input type="text" title="변수명" name="distrbEnvConfList[].envVarNm" class="form-control" value="" maxlength="100" />'
			+ '</td>'
			+ '<td>'
			+ '<input type="text" title="변수값" name="distrbEnvConfList[].envVarVl" class="form-control" value="" maxlength="100"/>'
			+ '</td>'
			+ '<td>'
			+ '<button type="button" class="btn btn-sm btn-function" name="btnInsertEnv" onclick="fn_deleteEnv(this)" title="환경변수삭제">삭제</button>'
			+ '</td>' + '</tr>';

	$("#envTable tbody").append(html);
}


//환경변수 삭제
function fn_deleteEnv(obj) {
	var tr = $(obj).parent().parent();
	tr.remove();
}


//호스트명 체크
function fn_checkHstNmStr(checkstr) {
	var reg = /^[a-z0-9]([-a-z0-9]*[a-z0-9])?(\.[a-z0-9]([-a-z0-9]*[a-z0-9])?)*$/
	return reg.test(checkstr);
}


//환경변수 체크
function fn_checkEnvConfListStr(checkstr) {
	var reg = /^[A-Za-z_][A-Za-z0-9_]*$/
	return reg.test(checkstr);
}


//환경변수 체크

function fn_checkEnvList(){
	var checkCnt = $("input[name='distrbEnvConfList[].envVarNm']").length;

	for( var i=0; i < checkCnt; i++ ) {
		if( !fn_checkEnvConfListStr($("input[name='distrbEnvConfList[].envVarNm']").eq(i).val()) ) {
			jAlert("환경변수명을 다시 입력해 주세요.\n(배포 환경변수 입력 유의사항을 확인해 주세요.)", function() {
				$("input[name='distrbEnvConfList[].envVarNm']").eq(i).focus();
			});
			return false;
		}
	}
	return true;
}



</script>
