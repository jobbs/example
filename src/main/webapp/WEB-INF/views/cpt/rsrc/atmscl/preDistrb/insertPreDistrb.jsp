<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>사전 배포 생성 요청 화면</pre>
 *
 * @author 안수근
 *
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

<form:form commandName="preDistrbVo">
	<form:hidden path="imgId" title="대상이미지ID"/>
	<form:hidden path="imgNm" title="이미지명"/>
	<form:hidden path="rsrcPoolId" title="자원풀ID"/>
	<form:hidden path="regionId" title="센터ID"/>
	<form:hidden path="netClCd" title="망CD"/>
	<form:hidden path="zoneId" title="존ID"/>
	<form:hidden path="imgRepoDtlAddr" title="이미지 저장소 상새주소"/>
	<form:hidden path="servcAreaId" title="서비스영역ID"/>
	<form:hidden path="servcAreaSeq" title="서비스영역SEQ"/>
<!-- 등록/상세 영역 -->
<div class="col-box-100 detail-col">

	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">사전배포 등록</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
	  		<table class="table table-horizon">
	  			<caption>사전배포 정보</caption>
	    		<colgroup>
					<col class="col10">
					<col class="col20">
					<col class="col10">
					<col class="col20">
					<col class="col10">
					<col class="col20">
	      		</colgroup>
				<tbody>
		          <tr>
						<th>부처명</th>
						<td><span id="institutionNm"></span></td>
						<th>업무명</th>
						<td><span id="jobNm"></span></td>
						<th>센터</th>
						<td><span id="regionNm"></span></td>
				 </tr>
				  <tr>
						<th>존</th>
						<td><span id="zoneNm"></span></td>
						<th>망구분</th>
						<td><span id="netNm"></span></td>
						<th>자원풀</th>
						<td><span id="rsrcPoolNm"></span></td>

					</tr>
					<tr>
						<th>버전</th>
						<td><span id="imgVer"></span></td>
						<th>생성일</th>
						<td colspan="3"><span id="creDttm"></span></td>
					</tr>
					<tr>
						<th><span class="text-red">*</span>대상이미지</th>
						<td colspan="5">
							<div class="input-group">
								<form:input path="imgNm"  title="대상이미지" cssClass="form-control essential" disabled="true" value=""/>
								<div class="input-group-btn">
									<button type="button" class="btn" onclick="openImgListSearch()">이미지조회</button>
								</div>
							</div>
						</td>
		            </tr>
					<tr>
						<th>이미지 저장소</th>
						<td colspan="7"><span id="imgRepoDtlAddrInfo"></span></td>
					</tr>
		            <tr>
		          		<th>비고</th>
						<td colspan="7">
							<form:input path="rmk" title="비고" cssClass="form-control" value=""/>
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
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" data-original-title="뒤로" onclick="fn_selectPreDistrbList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize>
				<button class="btn btn-sm btn-hover-green" data-toggle="tooltip"  data-original-title="생성"  onclick="fn_insertPreDistrb();"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	$("#infoLineO").hide();
	$("#infoLineT").hide();
	$("#infoLineTh").hide();
	$("#infoLineF").hide();
});
$(document).bind('selectPreDistrb', setPreDistrb);

//업무선택 팝업창에서 선택한 정보 설정
function setPreDistrb(evt) {
	var val = evt.datas;
	if (val != null || val != undefined){
	$('#preDistrbVo input[name="imgNm"]').val(val.imgNm);
	$('#preDistrbVo input:hidden[name="servcAreaSeq"]').val(val.servcAreaSeq);
	$('#preDistrbVo input:hidden[name="imgId"]').val(val.imgId);
	$('#preDistrbVo input:hidden[name="rsrcPoolId"]').val(val.rsrcPoolId);
	$('#preDistrbVo input:hidden[name="regionId"]').val(val.regionId);
	$('#preDistrbVo input:hidden[name="zoneId"]').val(val.zoneId);
	$('#preDistrbVo input:hidden[name="netClCd"]').val(val.netClCd);
	$('#preDistrbVo input:hidden[name="servcAreaId"]').val(val.servcAreaId);
	$('#preDistrbVo input:hidden[name="imgRepoDtlAddr"]').val(val.imgRepoDtlAddr);
	//대상 이미지 기본정보 셋팅
	$('#imgVer').text(val.imgVer);
	$('#institutionNm').text(val.institutionNm);
	$('#jobNm').text(val.jobNm);
	$('#regionNm').text(val.regionNm);
	$('#netNm').text(val.netNm);
	$('#rsrcPoolNm').text(val.rsrcPoolNm);
	$('#creDttm').text(val.creDttm);
	$('#servcNm').text(val.servcNm);
	$('#zoneNm').text(val.zoneNm);
	$('#imgRepoDtlAddrInfo').text(val.imgRepoDtlAddr);

/* 	$("#infoLineO").show();
	$("#infoLineT").show();
	$("#infoLineTh").show();
	$("#infoLineF").show(); */
	}


}

//뒤로
function fn_selectPreDistrbList(){
	location.href = '<c:url value="selectPreDistrbList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'servcSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}
//요청 버튼 클릭 시
function fn_insertPreDistrb(){

	if(!fn_form_validation("preDistrbVo")){
		return;
	}

	jConfirm('사전배포 등록 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: insertPreDistrbResultHandler,
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

		$('#preDistrbVo').attr('action', '<c:url value="insertPreDistrb.do"/>');
		$('#preDistrbVo').ajaxSubmit(options);

	});
}

//생성 결과 콜백
function insertPreDistrbResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo(result.messageList, function(){
			fn_selectPreDistrbList();
		});
	}
	else{
		alert_message(result.messageList)
	}
}
function openImgListSearch() {
	var url = '<c:url value="selectPreDistrbListViewP.do"/>';
	var params = {"searchType" : "S"};
	var args = {key:"이미지선택", width:1280,height:800};
	windowOpen(url, params, args);
}
</script>
