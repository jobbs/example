<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 25.
 * @lastmodified 2016. 10. 25.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 25.     최경철         v1.0             최초생성
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

<c:url var="vmSnapListXlsDwnl" value="selectVmSnapListXlsDwnl.do">
	<c:param name="vmSeq" value="${vmVo.vmSeq }"></c:param>
</c:url>

<!-- 그리드 영역 -->
<form id="procssFrm">
	<input type="hidden" name=procssInstSeq id="procssInstSeq" value="${vmProcssVo.procssInstSeq}" />
</form>
<form id="selectVmSnapFrm">
<%-- <form:hidden path="procssInstSeq" value="${vmProcssVo.procssInstSeq}" /> --%>
<input type="hidden" name="vmSeq" value="${vmVo.vmSeq}" />
<input type="hidden" name="vrlzSwTyCd" value="${vmVo.vrlzSwTyCd}" />
<div class="col-box-100 detail-col">

	<div class="box detail-list-box">

		<!-- box-header -->
		<div class="box-header">
		    <c:choose>
		    	<c:when test='${vmVo.vrlzSwTyCd eq "09"}'>
		    	    <h3 class="box-title" style="color:red;"><small>OVM 은 스냅샷 기능을 지원하지 않습니다.</small></h3>
		    	</c:when>
		    	<c:otherwise>
		    		<h3 class="box-title">스냅샷(${vmSnapVoCount })<small>스냅샷은 최대 5개까지 생성 가능합니다.</small></h3>
		    	<div class="box-tools">
				<div class="pull-right">
					<menu:authorize>
						<button type="button" id="procssStatBtn" title="진행상태조회" class="btn btn-sm btn-function" onclick="javascript:fn_procssStatOpen(); return false;"><i class="fa fa-file-o"></i>진행상태조회</button>
					</menu:authorize>
					<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="엑셀다운로드" data-original-title="엑셀다운로드" onclick="fn_selectVmSnapListXlsDwnl();"><i class="fa fa-download"></i></button>
				</div>
			  </div>
		    	</c:otherwise>
		    </c:choose>
		</div>
		<c:set var="ctlTrgtYn" value="${vmVo.ctlTrgtYn}"/><%-- 제어여부가 N이면 버튼 감추기위해 추가 --%>
		<!-- box-body -->
		<div class="box-body no-padding detail-list-body">
			<table id="vmSnapTable" class="table table-hover table-vertical table-layout-fixed">
			<caption>스냅샷 정보 테이블</caption>
				<thead>
					<tr>
						<th>선택</th>
						<th>생성일시</th>
						<th>스냅샷명</th>
						<th>용량(GB)</th>
						<th>비고</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vmSnapVo" items="${vmSnapVoList }" varStatus="i">

						<tr>
							<td><input type="radio" name="snapshtSeq" title="선택여부" class="essential" value="${vmSnapVo.snapshtSeq }" <c:if test='${"N" eq ctlTrgtYn }'><c:out value="disabled"/></c:if> /></td>
							<td><c:out value="${vmSnapVo.snapshtCreDt}"/></td>
							<td class="alignL"><c:out value="${vmSnapVo.snapshtNm }" /></td>
							<td class="alignR"><fmt:formatNumber value="${vmSnapVo.snapshtAsgnCapa }" pattern="#,###.##"/></td>
							<td class="alignL"><c:out value="${vmSnapVo.rmk }" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


	</div>
</div>
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectVmList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<c:choose>
		    	<c:when test='${vmVo.vrlzSwTyCd eq "09"}'>
		    	</c:when>
		    	<c:otherwise>		
		<div class="pull-right btns">
			<menu:authorize>
				<c:if test='${"Y" eq ctlTrgtYn }'><%-- 제어여부가 N이면 버튼 감추기위해 추가 --%>
				<button type="button" class="btn btn-sm btn-hover-blue" data-toggle="tooltip" title="생성" data-original-title="생성" onclick="fn_insertVmSnap();"><i class="fa fa-plus"></i></button>
				<button type="button" class="btn btn-sm btn-hover-blue" data-toggle="tooltip" title="복원" data-original-title="복원" onclick="fn_procVmSnapRestor();"><i class="fa fa-rotate-right"></i></button>
				<button type="button" class="btn btn-sm btn-hover-red" data-toggle="tooltip" title="삭제" data-original-title="삭제" onclick="fn_deleteVmSnap();"><i class="fa fa-minus"></i></button>
				</c:if>
			</menu:authorize>
		</div>
		</c:otherwise>
		</c:choose>
	</div>
</div>
</form>

<script type="text/javascript">

$(function() {

	fn_btnInit($("#procssInstSeq").val());
});

//진행상태조회 버튼 셋팅
function fn_btnInit(procssVal) {

	if(procssVal == "") {
		$("#procssStatBtn").hide();
	}else {
		$("#procssStatBtn").show();
	}
}

function fn_selectVmList(page){
	location.href = '<c:url value="selectVmList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'vmSeq' and pageParam.key ne 'searchType'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

//스냅샷가능여부 체크
function checkVmSnap() {

	var rtnFlag = true;
	var vrlzSwTyCd = "${vmVo.vrlzSwTyCd }"; //가상화SW유형코드

	if(vrlzSwTyCd == "03") {
		jAlert("HP Integrity VM 가상화SW는 스냅샷 기능을 사용할 수 없습니다.");
		rtnFlag = false;
	}

	return rtnFlag
}

// 스냅샷 생성화면 호출
function fn_insertVmSnap(){
	if(checkVmSnap()) {
		var url = 'insertVmSnap.do';
		var target = 'insertVmSnap';
		window.open("", target, getStatus(720, 420));


		$('#selectVmSnapFrm').attr("target", target);
		$('#selectVmSnapFrm').attr("action", url);
		$('#selectVmSnapFrm').submit();
	}
}

function fn_insertVmSnap_reload(){
	location.reload();
}

// 스냅샷 복원
function fn_procVmSnapRestor(){
	if(checkVmSnap()) {

		if($('input:radio[name="snapshtSeq"]:checked').length == 0){
			jAlert("스냅샷 정보를 선택해주세요.");
			return;
		}

		jConfirm('스냅샷을 복원 하시겠습니까?', function(){


			var options = {
				type: 'post',
				dataType: 'json',
				success: vmSnapResultHandler,
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

			$('#selectVmSnapFrm').attr('action', 'procVmSnapRestor.do');
			$('#selectVmSnapFrm').ajaxSubmit(options);

		});
	}
}

// 스냅샷 삭제
function fn_deleteVmSnap(){

	if(checkVmSnap()) {

		if($('input:radio[name="snapshtSeq"]:checked').length == 0){
			jAlert("스냅샷 정보를 선택해주세요.");
			return;
		}

		jConfirm('스냅샷을 삭제 하시겠습니까?', function(){


			var options = {
				type: 'post',
				dataType: 'json',
				success: vmSnapResultHandler,
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

			$('#selectVmSnapFrm').attr('action', 'deleteVmSnap.do');
			$('#selectVmSnapFrm').ajaxSubmit(options);

		});
	}

}

function vmSnapResultHandler(result){

	if(result.success){
		jInfo(result.messageList, function(){
			location.reload();
		});
	}
	else{
		jAlert(result.messageList);
	}
}

// 엑셀 다운로드
function fn_selectVmSnapListXlsDwnl(){

	if("${vmSnapVoCount}" == '0') {
		jAlert("다운로드 할 데이터가 없습니다.");
		return;
	}

	goToUrl('${vmSnapListXlsDwnl}');
}

$("#vmSnapTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	                {sWidth : "50px" },
	                {sWidth : "80px" },
	                {sWidth : "219px" },
	                {sWidth : "75px" },
	                {sWidth : "315px" }
	 ],

	 order : [[1, "desc"]]
});

//팝업창 중앙에 위치를 위한 값 전달
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

$("#selectVmSnapFrm input[name='snapshtSeq']").click(function(event) {
	event.stopPropagation();
});

$("#selectVmSnapFrm input[name='snapshtSeq']").parent().parent().click(function() {
	var $target = $(this).find("input[name='snapshtSeq']");
	if( $target.attr("type") == "radio" ) {
		$target.prop("checked", true);
	} else {
		var checked = $target.prop("checked");
		$target.prop("checked", !checked);
	}
});

/**
 *  실행내역
 */
function fn_procssStatOpen(){

	var procssInstseq = $("#procssInstSeq").val();

	var params = { 'procssInstSeq' : procssInstseq };
	var url = "<c:url value='/cpt/opr/req/rsrcreq/selectRsrcReqExeListMigrP.do'/>";
	var args = {key:"selectRsrcReqExeListMigrP", width: 1280 , height: 720 };
	windowOpen(url, params, args);

}


</script>