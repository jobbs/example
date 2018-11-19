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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100 detail-col">
<form:form commandName="userMngVo">
	<form:hidden path="useReqId" value="${userMngVo._id}" />
	<form:hidden path="sysCd" value="${userMngVo.sysCd}" />
	<form:hidden path="rev" value="${userMngVo._rev}" />
	<form:hidden path="statCd" value="${userMngVo.statCd}" />
	<c:forEach var="vo" items="${userMngVo.authrMapng}" varStatus="i">
		<input type="checkbox" name="authrMapng" value="${vo}" style="display: none" title="권한매핑">
	</c:forEach>

	<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
	<!-- box(목록조회 테이블) -->
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>사용관리 상세</caption>
				<colgroup>
					<col class="col20">
					<col class="col30">
					<col class="col20">
					<col class="col30">
				</colgroup>
				<tbody>
					<tr>
						<th>신청자명</th>
						<td><c:out value="${userMngVo.reqUsrNm }" /></td>
						<th><label for="regionId">API-Gateway</label></th>
						<td>
							<c:out value="${userMngVo.regionNm}" />
							<input type="hidden" id="regionId" name="regionId" value="${userMngVo.regionId}" />
						</td>
					</tr>
					<tr>
						<th>시스템</th>
						<td><c:out value="${userMngVo.sysNm}" /></td>
						<th>상태</th>
						<td>
							<c:choose>
								<c:when test="${userMngVo.statCd =='01'}">미승인</c:when>
								<c:when test="${userMngVo.statCd =='02'}">승인</c:when>
								<c:otherwise>반려</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>접근 키</th>
						<td><span class="pad-right-5"><c:out value="${userMngVo.accssKey }" /></span> <form:hidden path="accssKey" /></td>
						<th><span class="text-red">*</span><label for="passwd">기존 비밀번호</label></th>
						<td><form:input path="passwd" type="password" title="기존 비밀번호" class="form-control essential" maxlength="60" readonly="true" /></td>
					</tr>
					<tr>
						<th><label for="changePasswd">비밀번호 변경</label></th>
						<td><form:input path="changePasswd" title="비밀번호 변경" type="password" class="form-control" maxlength="60" /></td>
						<th><label for="passwdChk">비밀번호 변경 확인</label></th>
						<td><form:input path="passwdChk" title="비밀번호 변경 확인" type="password" class="form-control" maxlength="60" /></td>
					</tr>
					<tr>
						<th><span class="text-red">*</span><label for="ipAddr">IP</label></th>

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
                          				<c:forEach var="ip" items="${userMngVo.ipAddr}" varStatus="i">
										<tr>
											<td>
												<input type="checkbox" name="delKey" class="delKey" value="" title="항목선택"/>
											</td>
											<td>
												<input type="text" name="ipAddr" title="IP" value="${ip}" class="form-control onlyIp essential"  maxlength="15" />
											</td>
										</tr>
										</c:forEach>
									<!-- 추가되는 부분 끝-->
									</tbody>
	                        	</table>
	                      	</div>
	                      	<div class="form-group no-margin-bottom alignR">
		                      	<button type="button" class="btn btn-sm btn-function" onclick="fn_insertIp()">IP 추가</button>
	                        	<button type="button" class="btn btn-sm btn-function" name="btnInsertSRout" onclick="fn_deleteIp(this)">IP 삭제</button>
	                      	</div>
							<!--<form:input path="ipAddr" type="text" class="form-control essential" maxlength="60" title="IP"/>-->
						</td>
					</tr>
					<tr>
						<th><span class="text-red">*</span><label for="reqReasn">사유</label></th>
						<td colspan="3">
							<form:textarea path="reqReasn" title="사유" class="form-control essential" rows="3" maxlength="4000" />
						</td>
					</tr>
					<tr>
						<th><label for="rjctReasn">반려 사유</label></th>
						<td colspan="3">
							<form:textarea path="rjctReasn" title="반려 사유" class="form-control" rows="3" maxlength="4000" readonly="true" />
						</td>
					</tr>
					<tr>
                 		<th>API 목록</th>
                    	<td colspan="3">
                    		<div class="form-group no-margin-bottom">
                    			<table class="table table-hover table-vertical table-layout-fixed">
								<caption>API 목록</caption>
									<colgroup>
										<col class="col3">
										<col class="col10">
										<col class="col20">
										<col class="colAuto">
									</colgroup>
									<thead>
										<tr>
											<th style="border-bottom: 0px; border-right: 1px solid #ddd">No.</th>
											<th style="border-bottom: 0px; border-right: 1px solid #ddd">스택분류</th>
											<th style="border-bottom: 0px; border-right: 1px solid #ddd">API명</th>
											<th style="border-bottom: 0px; border-right: 1px solid #ddd">설명</th>
										</tr>
									</thead>
								</table>
							</div>
                    		<div class="form-group mg-bottom-5" style="max-height: 305px; min-height: 30px; overflow-y: auto; overflow-X: hidden;">
								<table class="table table-hover table-vertical table-layout-fixed">
									<colgroup>
										<col class="col6">
										<col class="col10">
										<col class="col20">
										<col class="colAuto">
									</colgroup>
									<tbody>
										<c:choose>
											<c:when test="${userMngVo.apis eq null  or empty userMngVo.apis}">
												<tr>
													<td colspan="4">검색된 데이터가 없습니다.</td>
												</tr>
											</c:when>
											<c:otherwise>
												<c:forEach var="apiVo" items="${userMngVo.apis}" varStatus="i">
												<tr>
													<td>
														<c:out value="${i.count }" />
														<input type="hidden" name="apis[].apiId" value="${apiVo.apiId }"/>
													</td>
													<td>
														<c:out value="${apiVo.stackClNm }" />
														<input type="hidden" name="apis[].stackClNm" value="${apiVo.stackClNm }"/>
													</td>
													<td class="alignL">
														<c:out value="${apiVo.apiNm }" />
														<input type="hidden" name="apis[].apiNm" value="${apiVo.apiNm }"/>
													</td>
													<td class="alignL">
														<c:out value="${apiVo.dc }" />
														<input type="hidden" name="apis[].dc" value="${apiVo.dc }"/>
													</td>
												</tr>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</tbody>
								</table>
	                      	</div>
                    	</td>
	                </tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- /box-body -->
</form:form>
</div>

<menu:authorize>
<div class="col-box-100 detail-col">
	<!-- page-btn-group -->
	<div class="edit-btn-group">
		<div class="pull-right btns">

			<button type="button" class="btn btn-hover-green" data-toggle="tooltip" data-original-title="신청"
				onclick="fn_updateUseMng();"><i class="fa fa-check"></i>
			</button>
		</div>
	</div>
	<!-- /page-btn-group -->
</div>
</menu:authorize>

<!-- 신청이력 list 부분 -->
<div class="col-box-100 search-col">
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">검색결과<small>
					${searchVo.paginationInfo.currentPageNo } /
					${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건
				</small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<c:url var="url" value="/api/gw/use/selectUseMng.do" />
					<nform:selectRecodeCntPerPage formId="searchVo" targetUrl="${url }" value="${searchVo }" />
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-hover-green"
							data-toggle="tooltip" title="" data-original-title="엑셀다운로드"
							onclick="fn_downloadExcel();"><i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
			<!-- /box-header -->
		</div>

		<!-- box-body -->
		<div class="box-body no-padding detail-list-body">
		<form:form commandName="searchVo" method="get">
			<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
			<form:hidden path="useReqId" value="${userMngVo._id}" />
			<table class="table table-hover table-vertical table-layout-fixed" id="reqstHstryTable">
				<caption>사용관리 신청이력</caption>
				<thead>
					<tr>
						<th>No.</th>
						<th>신청이력</th>
						<th>상태</th>
						<th>신청자명</th>
						<th>담당자명</th>
						<th>신청일자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="reqstHstryVo" items="${list }" varStatus="i">
						<tr>
							<td>
								<c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" />
							</td>
							<td class="alignL">
								<c:out value="${reqstHstryVo.reqHstryNm}" /></td>
							<c:choose>
								<c:when test="${reqstHstryVo.reqHstrystatCd eq '01'}">
									<td>미승인</td>
								</c:when>
								<c:when test="${reqstHstryVo.reqHstrystatCd eq '02'}">
									<td>승인</td>
								</c:when>
								<c:otherwise>
									<td>반려</td>
								</c:otherwise>
							</c:choose>
							<td><c:out value="${reqstHstryVo.reqhstryUsrNm }" /></td>
							<td><c:out value="${reqstHstryVo.chargerNm }" /></td>
							<td><c:out value="${reqstHstryVo.reqHstryDt }" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form:form>
		</div>
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
		</div>
	</div>
	<!-- /box-body   -->
</div>

<script type="text/javascript">

//페이징 이동
function fn_goPage(page) {
	location.href = "selectUseMng.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

//엑셀 다운로드
function fn_downloadExcel() {
	if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("다운로드할 데이터가 없습니다");
		return;
	}

	$("#searchVo").attr("action", contextPath + "/api/gw/user/selectReqstHstryListXlsDwnl.do");
	$("#searchVo").submit();
}

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

//사용자정보 수정 처리
function fn_updateUseMng() {
	if (!fn_form_validation("userMngVo")) {
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

	if ("" != $("#changePasswd").val()) {
		if ($("#changePasswd").val() != $("#passwdChk").val()) {
			jAlert("변경한 비밀번호가 일치하지 않습니다.");
			return;
		}
	}

	$("input[name='authrMapng']").each(function() {
		// 존재하는 모든 checkbox checked
		$("input:checkbox[name='authrMapng']").prop("checked", true);
	});

	if($("input[name='apis[].apiId']").length > 0){
		fn_form_rename("apis","apiId,stackClNm,apiNm,dc");
	}

	jConfirm('사용관리 정보를 수정하시겠습니까?', function(){
		$.ncmsLoding.startFullScreen();
		$.post('updateUseMng.do', $('#userMngVo').serialize(), fn_pageMove,	'json').always(function() {
			$.ncmsLoding.remove();
		});
	});
}

// 콜백 / 화면이동
function fn_pageMove(result) {
	alert_message(result.messageList, function() {
		if (result.success) {
			if (result.procType == "update") {
				location.href = "selectUseMngLogin.do?useReqId=" + "${userMngVo.useReqId}";
			}
		}
	}, (result.success ? "INFO" : ""));
}

//테이블 정렬
$("#reqstHstryTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,

	//colgroup 대신 여기에 입력
	aoColumns : [
	   { sWidth : "40px" },
	   { sWidth : "450px" },
	   { sWidth : "40px"},
	   { sWidth : "80px"},
	   { sWidth : "80px"},
	   { sWidth : "80px"}
	],
	order : [ [ 0, "desc" ] ]
});
</script>