<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>물리스토리지 상세-SAN</pre>
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     김봉민         v1.0             최초생성
 * 2016. 12. 05.     김봉민         v1.1             (추가)물리스토리지 구성ID 수정
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

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<form:form commandName="pstrgVo" id="frm">
	<form:hidden path="phyStrgId"/>
	<form:hidden path="phyStrgNm"/>
	<form:hidden path="regionId"/>
	<form:hidden path="rsrcPoolId"/>

<div class="col-box-33 no-padding-right">
  <div class="col-info">
    <h3 class="col-info-header">할당량</h3>
    <div class="col-info-body">
       <div class="col-info-box">
        <h4 class="num"><fmt:formatNumber value="${pstrgVo.strgAsgnCapa}" pattern="#,###.##"/> <small>(GB)</small></h4>
       </div>
    </div>
  </div>
</div>

<div class="col-box-33 no-padding-right">
  <div class="col-info">
    <h3 class="col-info-header">사용량</h3>
    <div class="col-info-body">
       <div class="col-info-box">
        <h4 class="num"><fmt:formatNumber value="${pstrgVo.strgUsefulCapa}" pattern="#,###.##"/><small>(GB)</small></h4>
       </div>
    </div>
  </div>
</div>

<div class="col-box-33">
  <div class="col-info">
    <h3 class="col-info-header">가용량</h3>
    <div class="col-info-body">
       <div class="col-info-box">
        <h4 class="num"><fmt:formatNumber value="${pstrgVo.strgUseCapa}" pattern="#,###.##"/><small>(GB)</small></h4>
       </div>
    </div>
  </div>
</div>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-header"><h3 class="box-title">기본정보</h3></div>
		<div class="box-body no-padding">
			<table class="table table-horizon" id="tblVrStrgList">
				<caption>물리스토리지 상세 기본 정보</caption>
				<colgroup>
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
				</colgroup>
       			<tbody>
					<tr><th>센터</th><td><c:out value="${pstrgVo.regionNm}"/></td>
		        		<th>존</th><td><c:out value="${pstrgVo.zoneNm}"/></td>
		        		<th>망구분</th><td><c:out value="${pstrgVo.netClNm}" /></td>
		        		<th>자원풀</th><td><c:out value="${pstrgVo.rsrcPoolNm}" /></td></tr>
       				<tr><th><span class="text-red">*</span>물리스토리지 구성ID</th><td><form:input path="compId"  value="${pstrgVo.compId}"
       																						class="form-control essential"
       							  															maxlength="10"  placeholder="예)ST12345678"></form:input>
       						</td>
	           			<th>물리스토리지명</th><td><c:out value="${pstrgVo.phyStrgNm}" /></td>
    	       			<th>가상화SW</th><td><c:out value="${pstrgVo.vrlzSwTyNm}" /></td>
        		   		<th>시리얼번호</th><td><c:out value="${pstrgVo.serialNo}" /></td></tr>
          			<tr><th>사용부처</th><td><c:out value="${pstrgVo.institutionNm}" /></td>
           				<th>부처담당자</th><td><c:out value="${pstrgVo.oprChargerNm}"/></td>
           				<th>분류</th><td><c:out value="${pstrgVo.compClNm}" /></td>
           				<th>장비고유식별번호</th><td><c:out value="${pstrgVo.eqpUniqIdNo}" /></td></tr>
        		</tbody>
			</table>
		</div>
	</div>
</div><!-- /col-box-100 -->

</form:form>

<form:form commandName="searchVo" method="get" id="frm">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
	<form:hidden path="searchPhyStrgId"/>
</form:form>

<div class="col-box-100 detail-col">
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">가상스토리지 목록<small>${searchVo.paginationInfo.currentPageNo } /${searchVo.paginationInfo.totalPageCount },총 ${searchVo.paginationInfo.totalRecordCount }건</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="frm" value="${searchVo}"/>
					<div class="input-group-cell">
   						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_goExcelDownload();"><i class="fa fa-download"></i></button>
   					</div> <!-- /input-group-box  -->
				</div>
			</div> <!--/box-tools  -->
		</div>

		<div class="box-body no-padding detail-list-body" >
			<table class="table table-hover table-vertical table-layout-fixed " id="dtlTable">
			<caption>물리스토리지와 연관된 가상스토리지 목록(센터,존,망,자원풀,가상화SW,스토리지토메인,전체량,사용량,VM할당량,여유량)</caption>
				<thead>
            		<tr><th>No.</th>
		             	<th>센터</th>
		             	<th>존</th>
		             	<th>망</th>
		             	<th>자원풀</th>
		             	<th>가상화SW</th>
		            	<th>스토리지도메인명</th>
		            	<th>전체량(GB)</th>
		            	<th>사용량(GB)</th>
		            	<th>VM할당량(GB)</th>
		            	<th>여유량(GB)</th></tr>
         		</thead>
				<tbody>
					<c:forEach var="vo" items="${vrStrgList}" varStatus="i">
						<tr><td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
							<td class="alignC"><c:out value="${vo.regionNm}"/></td>
			               	<td class="alignC"><c:out value="${vo.zoneNm}"/></td>
			               	<td class="alignC"><c:out value="${vo.netNm}"/></td>
			               	<td class="alignL"><c:out value="${vo.rsrcPoolNm}"/></td>
			               	<td class="alignL"><c:out value="${vo.vrlzSwTyCdNm}"/></td>
			               	<td class="alignL"><c:out value="${vo.strgDmnNm}"/></td>
			               	<td class="alignR"><fmt:formatNumber value="${vo.sumWholeAsgnCapa}" pattern="#,###.##"/></td>
			               	<td class="alignR"><fmt:formatNumber value="${vo.sumStrgUseCapa}" pattern="#,###.##"/> </td>
			               	<td class="alignR"><fmt:formatNumber value="${vo.sumVmAsgnCapa}" pattern="#,###.##"/> </td>
			               	<td class="alignR"><fmt:formatNumber value="${vo.sumStrMrgnCapa}" pattern="#,###.##"/></td></tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
</div>

<!-- page-btn-group -->
<div class="box-footer edit-btn-group">
	<div class="pull-left btns">
		<c:url var="listUrl" value="selectPhystrgList.do">
			<c:forEach var="curParam" items="${param }">
				<c:if test="${curParam.key ne 'boardSeq'}">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:if>
			</c:forEach>
		</c:url>
		<div class="pull-left btns">
			<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
		</div>
	</div><!-- /page-btn-group -->

	<div class="pull-right btns">
			<menu:authorize>
				<button type="button" class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="" data-original-title="저장" onclick="fn_updatePStrgInfo(); return false;"><i class="fa fa-check"></i></button>
			</menu:authorize>
	</div>

	<ul class="pagination"><ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="fn_goPage" /></ul>
	</div><!-- box-footer -->
</div><!-- /box -->

<script type="text/javascript">

var srcCompId = "";
$(function() {
	srcCompId = "${pstrgVo.compId}";
	$('#compId').focus();
});

/**
 * 숫자 검사
 */
function isInt(value){
	return !isNaN(value) && (function(x){return (x|0) ===x;})(parseFloat(value));
}

/**
 * 물리스토리지 구성 ID 검사 (10자리 확인 , 시작 ST(2),  나머지는 숫자 8자리)
 */
function validateCompId(compId){
	var msg = '';
	if(compId == null || compId == ''){
		msg = "물리스토리지 구성ID를 입력하세요.";
	}else if(srcCompId == compId){
		msg =  "설정된 물리스토리지 구성ID입니다.";
	}else if(compId.length != 10){
		msg =  "구성ID는 10자리입니다. 길이="+ compId.length;
	}else if(compId.substring(0,2) != 'ST'){
		msg =  "물리스토리지 구성 ID는 ST로 시작해야 합니다. = " +  compId;
	}else if(!isInt(compId.substring(2,10))){
		msg =  "물리스토리지 구성 ID의 뒷 8자리는 숫자이어야 합니다. " +  compId;
	}
	return msg;
}

/**
 * 구성 ID 수정
 */
function fn_updatePStrgInfo(){
	var compId = $('#compId').val();

	var message = validateCompId(compId);
	if( message != ''){
		jAlert(message, function(){
			console.log('message='+message);
			$('#compId').focus();
		});
		return false;
	}

	jConfirm('물리서버 정보를 변경 하시겠습니까?', function(){
		if(!fn_form_validation("pstrgVo")){
			return;
		}

		var options = {
			type: 'post',
			dataType: 'json',
			success: function(result){
				if(result.success){
					jInfo(result.messageList, function (){
						srcCompId = compId;
					});
				}else{
					jAlert(result.messageList);
				}
			},
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

		$('#frm').attr('action', 'updatePStrgCommInfo.do');
		$('#frm').ajaxSubmit(options);
	});
}
/**
 *엑셀 다운로드
 */
function fn_goExcelDownload(){
	if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}

	$('#frm').attr('action', 'selectVrStrgListInPhystrgXlsDwnl.do');
	$('#frm').submit();
}

$("#dtlTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [	{sWidth : "60px" },		//No
	                {sWidth : "60px" },		//센터
	                {sWidth : "60px" },		//존
	                {sWidth : "60px" },		//망
	                {sWidth : "80px" },		//자원풀
	                {sWidth : "80px" },		//가상화SW
	                {sWidth : "150px" },	//스토리지도메인명
	                {sWidth : "100px" },	//할당량
	                {sWidth : "100px" },	//사용량
	                {sWidth : "100px" },	//가용량
	                {sWidth : "100px" }		//여유량
	 ],
	order : [[0, "desc"]]
} );
</script>