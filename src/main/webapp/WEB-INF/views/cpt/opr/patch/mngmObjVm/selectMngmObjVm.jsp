<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 31.
 * @lastmodified 2016. 10. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 31.     최경철         v1.0             최초생성
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

<div class="col-box-100 detail-col">
	<div class="info no-margin-bottom">
	    <h2>알려드립니다.</h2>
	    <p><span class="text-red">※</span> 관리대상 가상서버 등록시 "cloud-user" 계정이 존재할 때만 등록하시기 바랍니다.</p>
	</div>

	<form:form id="mngmObjVmSearchVo" commandName="mngmObjVmSearchVo" method="get" enctype="multipart/form-data">
	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">기본정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
	  		<table class="table table-horizon">
	  		<caption>대상관리 가상서버 기본정보 테이블</caption>
				<colgroup>
					<col class="col5">
					<col class="col10">
					<col class="col5">
					<col class="col15">
					<col class="col5">
					<col class="col15">
					<col class="col15">
					<col class="col5">
					<col class="col15">
					<col class="col5">
				</colgroup>
				<tbody>
					<tr>
						<th>센터</th>
						<td><c:out value="${mngmObjVmVo.regionNm }" /></td>
						<th>망구분</th>
						<td><c:out value="${mngmObjVmVo.netNm }" /></td>
						<th>부처</th>
						<td><c:out value="${mngmObjVmVo.insttNm }" /></td>
						<th>관리대상 가상서버수</th>
						<td><c:out value="${mngmObjVmVo.mngmVmCnt }" /></td>
						<th>전체 가상서버수</th>
						<td><c:out value="${mngmObjVmVo.vmCnt }" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- 수평형 테이블 -->
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">가상서버 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
					<form:hidden path="insttId" id="insttId"/>
					<form:hidden path="netClCd" id="netClCd"/>
					<form:hidden path="regionId" id="regionId"/>
					<form:select path="searchPackgMngTrgtYn" cssClass="form-control input-sm" title="대상여부" onchange="fn_selectMngmObjVm();">
						<form:option value="">전체</form:option>
						<form:option value="Y">대상</form:option>
						<form:option value="N">비대상</form:option>
					</form:select>
				</div>
			</div>
		</div>

		<!-- box-body -->
		<div class="box-body no-padding detail-list-body">
			<table class="table table-vertical table-layout-fixed" id="vmInfoTable">
			<caption>가상서버 정보 테이블</caption>
				<thead>
					<tr>
						<th><input type="checkbox" id="selectAll" title="체크여부"></th>
						<th><nobr>대상여부</nobr></th>
						<th><nobr>상태</nobr></th>
						<th><nobr>업무명</nobr></th>
						<th><nobr>가상서버명</nobr></th>
						<th><nobr>가상서버 구성ID</nobr></th>
						<th><nobr>가상서버ID</nobr></th>
						<th><nobr>호스트명</nobr></th>
						<th><nobr>IP주소</nobr></th>
						<th><nobr>OS타입</nobr></th>
						<th><nobr>가동시간</nobr></th>
						<th><nobr>동기화일자</nobr></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vmVo" items="${vmList }" varStatus="i">
						<tr>
							<td><input type="checkbox" name="updtCheck" title="체크여부" class="updtCheck" value="${vmVo.vmSeq }"></td>
							<td>
							<nobr>
								<c:choose>
									<c:when test="${vmVo.packgMngTrgtYn ne null && vmVo.packgMngTrgtYn eq 'Y'}">
										<span class="status status-green">대상</span>
									</c:when>
									<c:otherwise>
										<span class="status status-gray">비대상</span>
									</c:otherwise>
								</c:choose>
							</nobr>
							</td>
							<td>
							<nobr>
							<c:if test="${null ne vmVo.statGrpCd}">
								<div class="server-info server
									<c:choose>
										<c:when test='${"01" eq vmVo.statGrpCd}'><c:out value="server-down"/></c:when>
										<c:when test='${"02" eq vmVo.statGrpCd}'><c:out value="server-up"/></c:when>
										<c:when test='${"03" eq vmVo.statGrpCd}'><c:out value="server-inprogress"/></c:when>
										<c:when test='${"04" eq vmVo.statGrpCd}'><c:out value="server-exception"/></c:when>
							   			<c:otherwise></c:otherwise>
									</c:choose>
								">
									<div class="server-info-body alignL">
										<div class="server-info-box alignL">
											<span class="label"></span><h4 class="stat"><c:out value="${vmVo.statGrpCdNm }" /></h4>
										</div>
									</div>
								</div>
							</c:if>
							</nobr>
							</td>
							<td class="alignL">
								<c:set var="jobNmList" value="${fn:split(vmVo.jobsNm, ',')}"/>
								<c:forEach var="jobNm" items="${jobNmList}" varStatus="i">
									<nobr><c:out value="${jobNm }" /><c:if test="${fn:length(jobNmList) > (i.index + 1) }"><c:out value=","/></c:if></nobr>
								</c:forEach>
							</td>
							<td class="alignL"><nobr><c:out value="${vmVo.vmNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${vmVo.vmCompId }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${vmVo.vmId }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${vmVo.hstNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${vmVo.rprsntIpAddr }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${vmVo.osTyCdNm }" /></nobr></td>
							<td class="alignL"><c:out value="${vmVo.uptime }" /></td>
							<td class="alignL"><fmt:formatDate value="${vmVo.syncDttm }" pattern="yyyy-MM-dd" />
							<input type="hidden" name="rprsntIpAddr" value="${vmVo.rprsntIpAddr }"/>
							<input type="hidden" name="packgMngTrgtYn" value="${vmVo.packgMngTrgtYn }"/>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</form:form>

</div>

<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectMngmObjVmList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize onlyOprAdm="true">
				<c:choose>
					<c:when test="${mngmObjVmSearchVo.searchPackgMngTrgtYn ne null && mngmObjVmSearchVo.searchPackgMngTrgtYn eq 'Y'}">
						<button type="button" class="btn btn-sm btn-hover-red" data-toggle="tooltip" title="삭제" data-original-title="삭제" onclick="fn_deleteMngmObjVm();"><i class="fa fa-minus"></i></button>
						<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" title="동기화" data-original-title="동기화" onclick='fn_sync();'><i class="fa fa-refresh"></i></button>
					</c:when>
					<c:when test="${mngmObjVmSearchVo.searchPackgMngTrgtYn ne null && mngmObjVmSearchVo.searchPackgMngTrgtYn eq 'N'}">
						<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" title="등록" data-original-title="등록" onclick="fn_insertMngmObjVm();"><i class="fa fa-plus"></i></button>
					</c:when>
					<c:otherwise>
						<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" title="등록" data-original-title="등록" onclick="fn_insertMngmObjVm();"><i class="fa fa-plus"></i></button>
						<button type="button" class="btn btn-sm btn-hover-red" data-toggle="tooltip" title="삭제" data-original-title="삭제" onclick="fn_deleteMngmObjVm();"><i class="fa fa-minus"></i></button>
						<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" title="동기화" data-original-title="동기화" onclick='fn_sync();'><i class="fa fa-refresh"></i></button>
					</c:otherwise>
				</c:choose>
			</menu:authorize>
		</div>
	</div>
</div>

<script type="text/javascript">

//뒤로
function fn_selectMngmObjVmList(page){
 	location.href = '<c:url value="selectMngmObjVmList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'netClCd' and pageParam.key ne 'insttId' and pageParam.key ne 'searchPackgMngTrgtYn' and pageParam.key ne 'regionId'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

//조회
function fn_selectMngmObjVm(){
	$('#mngmObjVmSearchVo').attr('target', '_self');
	$('#mngmObjVmSearchVo').attr('action', '<c:url var="select" value="selectMngmObjVm.do"/>');
	$('#mngmObjVmSearchVo input[name="rprsntIpAddr"],#mngmObjVmSearchVo input[name="packgMngTrgtYn"],#mngmObjVmSearchVo input[name="updtCheck"]').remove();
	$('#mngmObjVmSearchVo').submit();
}

$(document).ready(function() {
	$('#selectAll').click(function(){
		$('.updtCheck').prop('checked', $(this).is(":checked"));
	});

	$('.updtCheck').click(function(){
		if($('.updtCheck:checked').length == $('.updtCheck').length){
			$('#selectAll').prop('checked', true);
		}
		else {
			$('#selectAll').prop('checked', false);
		}
	});
});

// 가상서버 패키지 관리대상 등록
function fn_insertMngmObjVm(){

	var checked = 0;
	var isIpExsit = true;
	var isPackgYn = false;
	$("input[name='updtCheck']").each(function() {
		if ($(this).prop("checked")) {
			var $trIp = $(this).closest('tr').find("input[name='rprsntIpAddr']");
			var $trPackgYn = $(this).closest('tr').find("input[name='packgMngTrgtYn']");

			var ip = $trIp.val();
			var packgYn = $trPackgYn.val();

			if(packgYn != '' && packgYn == 'Y') {
				isPackgYn = true;
				return;
			}

			if(ip == '') {
				isIpExsit = false;
				return;
			}
			checked++;
		}
	});

	if(isPackgYn){
		jAlert("이미 패키지관리대상인 정보는 등록할 수 없습니다.");
		return;
	}

	if(!isIpExsit){
		jAlert("IP주소가 없는 정보는 등록할 수 없습니다.");
		return;
	}

	if (checked == 0) {
		jAlert("적용대상을 선택하시기 바랍니다.");
		return;
	}

	jConfirm('선택한 가상서버를 패키지관리대상으로 등록하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: updateMngmObjVmResultHandler,
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

		$('#mngmObjVmSearchVo').attr('action', 'updateMngmObjVm.do');
		$('#mngmObjVmSearchVo').ajaxSubmit(options);

	});
}

// 가상서버 패키지 관리대상 삭제
function fn_deleteMngmObjVm(){

	var checked = 0;
	var isPackgYn = true;
	$("input[name='updtCheck']").each(function() {
		if ($(this).prop("checked")) {

			var $trPackgYn = $(this).closest('tr').find("input[name='packgMngTrgtYn']");
			var packgYn = $trPackgYn.val();

			if(packgYn == '' || packgYn == 'N') {
				isPackgYn = false;
				return;
			}

			checked++;
		}
	});

	if(!isPackgYn){
		jAlert("패키지관리대상이 아닌 정보는 삭제할 수 없습니다.");
		return;
	}

	if (checked == 0) {
		jAlert("적용대상을 선택하시기 바랍니다.");
		return;
	}

	jConfirm('선택한 가상서버를 패키지관리대상으로 삭제하시겠습니까?', function(){
		$('#searchPackgMngTrgtYn').val('Y');

		var options = {
			type: 'post',
			dataType: 'json',
			success: updateMngmObjVmResultHandler,
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

		$('#mngmObjVmSearchVo').attr('action', 'updateMngmObjVm.do');
		$('#mngmObjVmSearchVo').ajaxSubmit(options);

	});
}

//동기화
function fn_sync() {
	var checked = 0;
	var isPackgYn = true;
	$("input[name='updtCheck']").each(function() {
		if ($(this).prop("checked")) {

			var $trPackgYn = $(this).closest('tr').find("input[name='packgMngTrgtYn']");
			var packgYn = $trPackgYn.val();

			if(packgYn == '' || packgYn == 'N') {
				isPackgYn = false;
				return;
			}

			checked++;
		}
	});

	if(!isPackgYn){
		jAlert("패키지관리대상이 아닌 정보는 동기화 할 수 없습니다.");
		return;
	}

	if (checked == 0) {
		jAlert("적용대상을 선택하시기 바랍니다.");
		return;
	}

	jConfirm("선택한 가상서버를 동기화 하시겠습니까?", function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: fn_syncCallBack,
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

		$('#mngmObjVmSearchVo').attr("action", "updateMngmObjVmSync.do");
		$('#mngmObjVmSearchVo').ajaxSubmit(options);
	});
}

// 동기화콜백
function fn_syncCallBack(result){

	if(result.success){
		jInfo(result.messageList, function(){
			if(result.procType == "update") {
				location.reload();
			}
		});
	}else{
		jAlert(result.messageList);
	}
}

function updateMngmObjVmResultHandler(result){
	if(result.success){
		jInfo(result.messageList, function(){
			location.reload();
		});
	}
	else{
		jAlert(result.messageList);
	}
}

$("#mngmObjVmSearchVo input[name='updtCheck']").click(function(event) {
	event.stopPropagation();
});


$("#vmInfoTable tbody tr").click(function() {
	var $target = $("input[name='updtCheck']",this);
	$target.trigger('click');

});


$("#vmInfoTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
		{sWidth : "35px" }, //CHECK
		{sWidth : "50px" }, //대상여부
		{sWidth : "94px" }, //상태
		{sWidth : "80px" }, //업무*
		{sWidth : "151px" }, //가상서버명
		{sWidth : "85px" }, //가상서버구성ID
		{sWidth : "100px" }, //가상서버ID
		{sWidth : "125px" }, //호스트명
		{sWidth : "100px" }, //IP주소
		{sWidth : "53px" }, //OS유형
		{sWidth : "110px" },//가동시간
		{sWidth : "75px" } //동기화일자
	]

});



</script>