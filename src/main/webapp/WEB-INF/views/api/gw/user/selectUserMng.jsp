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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo')}"></c:set>

<div class="col-box-100 detail-col">
<form:form commandName="userMngVo" enctype="multipart/form-data">
	<form:hidden path="useReqId" value="${userMngVo._id}" />
	<form:hidden path="rev" value="${userMngVo._rev}" />
	<form:hidden path="reqUsrNm" value="${userMngVo.reqUsrNm}" />
	<form:hidden path="regionId" value="${userMngVo.regionId}" />
	<form:hidden path="sysCd" value="${userMngVo.sysCd}" />
	<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
	<!-- box(목록조회 테이블) -->
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>사용자관리 상세</caption>
				<colgroup>
					<col class="col20">
					<col class="col30">
					<col class="col20">
					<col class="col30">
				</colgroup>
				<tbody>
					<tr>
						<th><span class="text-red">*</span>신청자명</th>
						<td><c:out value="${userMngVo.reqUsrNm}" /></td>
						<th><label for="regionId"><span class="text-red">*</span>API-Gateway</label></th>
						<td><c:out value="${userMngVo.regionNm}" /></td>
					</tr>
					<tr>
						<th><span class="text-red">*</span>시스템</th>
						<td><c:out value="${userMngVo.sysNm }" /></td>
						<th><span class="text-red">*</span>상태</th>
						<td>
							<form:radiobutton path="statCd" name="statCd" cssClass="essential" title="상태" label="미승인" value="01" />
							<form:radiobutton path="statCd" name="statCd" cssClass="essential" title="상태" label="승인" value="02" />
							<form:radiobutton path="statCd" name="statCd" cssClass="essential" title="상태" label="반려" value="03" />
						</td>
					</tr>
					<tr>
						<th><span class="text-red">*</span>접근키</th>
						<td><span class="pad-right-5"><c:out value="${userMngVo.accssKey }" /></span>
							<form:hidden path="accssKey" />
							<button type="button" class="btn btn-function" data-original-title="재발급" onclick="jConfirm('접근키를 재발급 하시겠습니까?', fn_reIssuedUserMng)">재발급</button>
						</td>
						<th><label for="passwd">비밀번호 재설정</label></th>
						<td>
							<div class="input-group-box full">
								<div class="input-group-cell pad-right-5">
									<div class="input-group">
										<form:input path="passwd" title="비밀번호 재설정" type="password" class="form-control" maxlength="60" readonly="true" />
									</div>
								</div>
								<div class="input-group-cell fix-cell">
									<div class="input-group input-group-check">
										<button type="button" class="btn btn-function" data-original-title="재설정" onclick="jConfirm('비밀번호를 재설정 하시겠습니까?', fn_passwdChange)">재설정</button>
									</div>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<th><label for="ipAddr"><span class="text-red">*</span>IP</label></th>
						<td colspan="3">
							<table class="table table-vertical" id="IpTable">
                      			<caption>IP</caption>
                        		<colgroup>
			                        <col class="colAuto"><!--IP-->
                        		</colgroup>
		                		<thead>
			                  		<tr>
										<th>IP</th>
			                  		</tr>
		                		</thead>
                         			<tbody id="ipListTBody">
                         			<!-- 추가되는 부분 시작-->
                         			<c:forEach var="ip" items="${userMngVo.ipAddr}" varStatus="i">
									<tr>
										<td>
											<input type="text" name="ipAddr" title="IP" value="${ip}" class="form-control essential"  maxlength="15" readonly="true" />
										</td>
									</tr>
									</c:forEach>
								<!-- 추가되는 부분 끝-->
								</tbody>
                        	</table>
						</td>
					</tr>
					<tr>
						<th><span class="text-red">*</span>권한 매핑</th>
						<td colspan="3">
							<!-- 셔틀 영역 -->
							<div class="suttle-box suttle-horizon" style="min-height: 300px">
								<div class="col-cell-45 no-padding">
									<div class="box">
										<div class="box-header">
											<h3 class="box-title">미할당 권한</h3>
											<div class="box-tools input-group-box">
												<div class="input-group-cell pad-right-5">
													<div class="input-group"></div>
												</div>
												<div class="input-group-cell">
													<div class="input-group">
														<input type="text" name="searchNm" id="searchNm" title="권한검색" class="form-control input-sm">
														<div class="input-group-btn">
															<button type="button" class="btn btn-sm" onclick="fn_searchAuthr();return false;"><i class="fa fa-search"></i></button>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="box-body no-padding" style="max-height: 250px; overflow-y: auto;">
											<table class="table table-hover table-vertical" id="searchTable">
												<caption>권한 검색</caption>
												<colgroup>
													<col class="col5">
													<col class="colAuto">
												</colgroup>
												<thead>
													<tr>
														<th></th>
														<th>권한명</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td colspan="2">검색된 데이터가 없습니다.</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>

								<!-- 이동 버튼 -->
								<div class="col-cell-10 no-padding suttle-btns">
									<div class="suttle-button" id="suttle-button1">
										<div class="btn-group-vertical">
											<button type="button" class="btn" onclick="fn_allRight()"><i class="fa fa-angle-double-right"></i></button>
											<button type="button" class="btn" onclick="fn_right()"><i class="fa fa-angle-right"></i></button>
											<button type="button" class="btn" onclick="fn_left()"><i class="fa fa-angle-left"></i></button>
											<button type="button" class="btn" onclick="fn_allLeft()"><i class="fa fa-angle-double-left"></i></button>
										</div>
									</div>
								</div>

								<div class="col-cell-45 no-padding">
									<div class="box">
										<div class="box-header">
											<h3 class="box-title">할당 권한</h3>
										</div>
										<div class="box-body no-padding" style="max-height: 250px; min-height: 30px; overflow-y: auto;">
											<table class="table table-hover table-vertical" id="dspthTable">
												<caption>적용대상</caption>
												<colgroup>
													<col class="col5">
													<col class="colAuto">
												</colgroup>
												<thead>
													<tr>
														<th></th>
														<th>권한명</th>
													</tr>
												</thead>
												<tbody id="targetTbody">
													<c:choose>
														<c:when test="${userMngVo.authrMapng eq null or empty userMngVo.authrMapng }">
															<tr>
																<td colspan="2">검색된 데이터가 없습니다.</td>
															</tr>
														</c:when>
														<c:otherwise>
															<c:forEach var="vo" items="${userMngVo.authrMapng }" varStatus="i">
																<tr onclick='fn_checkUser(this)'>
																	<td><input type="checkbox" name="authrMapng" title="항목선택" alt="${fn:substringAfter(vo,'&')}" value="${vo}" /></td>
																	<td>${fn:substringAfter(vo,'&')}</td>
																</tr>
															</c:forEach>
														</c:otherwise>
													</c:choose>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div> <!-- 셔틀영역 끝 -->
						</td>
					</tr>
					<tr>
						<th><label for="reqReasn">사유</label></th>
						<td colspan="3"><form:textarea path="reqReasn" title="사유" class="form-control" rows="3" maxlength="4000" readonly="true" /></td>
					</tr>
					<tr>
						<th><label for="rjctReasn"><span class="text-red">*</span>반려사유</label></th>
						<td colspan="3"><form:textarea path="rjctReasn" title="반려사유" class="form-control" rows="3" maxlength="4000" /></td>
					</tr>
					<tr>
                 		<th>API 목록 </th>
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
										<col class="col3">
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

<div class="col-box-100 detail-col">
	<!-- page-btn-group -->
	<div class="edit-btn-group">
		<c:url var="listUrl" value="selectUserMngList.do">
			<c:forEach var="curParam" items="${param}">
				<c:if test="${curParam.key ne 'useReqId'}">
					<c:param name="${curParam.key}" value="${curParam.value}"></c:param>
				</c:if>
			</c:forEach>
		</c:url>

		<div class="pull-left btns">
			<button type="button" class="btn btn-hover-gray" data-toggle="tooltip" data-original-title="뒤로"
				onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i>
			</button>
		</div>
		<div class="pull-right btns">
			<menu:authorize>
			<button type="button" class="btn btn-hover-green" data-toggle="tooltip"
				data-original-title="저장" onclick="fn_updateUserMng();"><i class="fa fa-check"></i>
			</button>
			<button type="button" class="btn btn-hover-red" data-toggle="tooltip" data-original-title="삭제"
				onclick="jConfirm('사용자정보를 삭제하시겠습니까?', fn_deleteUserMng)"><i class="fa fa-times"></i>
			</button>
			</menu:authorize>
		</div>
	</div>
	<!-- /page-btn-group -->
</div>

<!-- 신청이력 list 부분 -->
<div class="col-box-100 search-col">
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">검색결과<small>
				${searchVo.paginationInfo.currentPageNo } /
				${searchVo.paginationInfo.totalPageCount },
				총 ${searchVo.paginationInfo.totalRecordCount }건</small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<c:url var="url" value="/api/gw/user/selectUserMng.do" />
	    			<nform:selectRecodeCntPerPage formId="searchVo" targetUrl="${url}" value="${searchVo}"/>
    				<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-hover-green"
							data-toggle="tooltip" title="" data-original-title="엑셀다운로드"
							onclick="fn_downloadExcel();"><i class="fa fa-download"></i>
						</button>
					</div>
				</div>
	 		</div><!-- /box-header -->
		</div>

		<!-- box-body -->
		<div class="box-body no-padding detail-list-body">
		<form:form commandName="searchVo" method="get">
			<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
			<form:hidden path="useReqId" value="${userMngVo._id }"/>
			<table class="table table-hover table-vertical table-layout-fixed" id="reqstHstryTable">
			<caption>사용자관리 신청이력</caption>
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
								<c:out value="${reqstHstryVo.reqHstryNm}" />
							</td>
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
	</div>		<!-- /box-body   -->
</div>

<script type="text/javascript">
$(document).ready(function(){
	// 최초값 체크
	if('${userMngVo.statCd}' == "03"){
		$("#rjctReasn").removeAttr("readonly");
	}else{
		$("#rjctReasn").attr("readonly","readonly");
	}

	// 체크박스 변경시
	$("input:radio[name='statCd']").change(function(){
		if($(this).val() == "03"){
			$("#rjctReasn").removeAttr("readonly");
		}else{
			$("#rjctReasn").attr("readonly","readonly");
			$("#rjctReasn").val("");
		}
	});

	fn_searchAuthr();
});

//OpenApi조회
function fn_searchAuthr(){
	$.ncmsLoding.startFullScreen();
	$.post(	'<c:url value="/api/gw/user/selectAuthrList.do"/>',
		{
		 "searchNm": $('#searchNm').val()
		},
		function(result) {
			if( result.success) {
				$('#searchTable tbody').empty();
				var len = result.data.length;
				var str="";
				var eqChk = true;
				if(len>0){
					for(var i=0; len>i; i++){
						$("input:checkbox[name='authrMapng']").each(function(){
							if((result.data[i].authrId+"&"+result.data[i].authrNm) == $(this).val()){
								eqChk = false;
							}
						});

						if(eqChk){
							str += "<tr onclick='fn_checkUser(this)'>" + "<td><input type='checkbox' name='authrNm' title='항목선택' alt='"
								+ result.data[i].authrNm + "' value='" + result.data[i].authrId + "&" + result.data[i].authrNm
								+ "'/></td>" + "<td>" + result.data[i].authrNm + "</td></tr>";
						}
						eqChk = true;
					}
				}else{
					str="<tr><td colspan='2'>검색된 데이터가 없습니다.</td></tr>"
				}
				$('#searchTable tbody').html(str);
			}
		}, "json").always(function() {
				$.ncmsLoding.remove();
		 	});

	return false;
}

function fn_checkUser(tr){
	$(':checkbox',$(tr)).trigger('click');
}

//이동
function fn_allRight(){
	//$('#searchTable checkbox');
	//$('input:checkbox','#searchTable').parent().parent().appendTo($('#dspthTable tbody tr'));
	if($('input:checkbox','#dspthTable').length==0 &&$('input:checkbox','#searchTable').length!=0){//검색된 데이터가 없습니다. 삭제처리
		$('#dspthTable tbody').empty();
	}
	$('input:checkbox','#searchTable').each(function(){
		var id = this.value;
		var isOK=true;
		//debugger;
		$('input:checkbox','#dspthTable').each(function(){
			//debugger;
			if(this.value==id){
				isOK=false;
				return false;
			}
		});

		// 1개이상 추가 못함 : 추가
		/* if($('input:checkbox','#dspthTable').length == 1){
			jAlert("권한은 1개이상 적용할 수 없습니다.");
			return;
		} */

		if(isOK){
			var html = '<tr onclick="fn_checkUser(this)"><td><input type="checkbox" name="authrMapng" title="항목선택" alt="'+$(this).attr("alt")+'" value="' + $(this).val() + '"></td><td>' + $(this).attr("alt") + '</td></tr>'
			$('#dspthTable tbody').append(html);

			$(this).parent().parent().remove();
		}
		this.checked=false;
	});
}
function fn_right(){
	//$('#searchTable checkbox');
	//$('input:checkbox','#searchTable').parent().parent().appendTo($('#dspthTable tbody tr'));
	if($('input:checkbox','#dspthTable').length==0 &&$('input:checkbox','#searchTable').length!=0){//검색된 데이터가 없습니다. 삭제처리
		$('#dspthTable tbody').empty();
	}
	$('input:checkbox:checked','#searchTable').each(function(){
		var id = this.value;
		var isOK=true;
		//debugger;
		$('input:checkbox','#dspthTable').each(function(){
			//debugger;
			if(this.value==id){
				isOK=false;
				return false;
			}
		});

		// 1개이상 추가 못함 : 추가
		/* if($('input:checkbox','#dspthTable').length == 1){
			jAlert("권한은 1개이상 적용할 수 없습니다.");
			return;
		} */

		if(isOK){
			var html = '<tr onclick="fn_checkUser(this)"><td><input type="checkbox" name="authrMapng" title="항목선택" alt="'+$(this).attr("alt")+'" value="' + $(this).val() + '"></td><td>' + $(this).attr("alt") + '</td></tr>'
			$('#dspthTable tbody').append(html);
		}

		$(this).parent().parent().remove();

		this.checked=false;
	});
}
function fn_left(){
	//$('#searchTable checkbox');
	//$('input:checkbox','#searchTable').parent().parent().appendTo($('#dspthTable tbody tr'));
	if($('input:checkbox','#searchTable').length==0 &&$('input:checkbox','#dspthTable').length!=0){//검색된 데이터가 없습니다. 삭제처리
		$('#searchTable tbody').empty();
	}
	$('input:checkbox:checked','#dspthTable').each(function(){
		var id = this.value;
		var isOK=true;
		//debugger;
		$('input:checkbox','#searchTable').each(function(){
			//debugger;
			if(this.value==id){
				isOK=false;
				return false;
			}
		});
		if(isOK){
			var html = '<tr onclick="fn_checkUser(this)"><td><input type="checkbox" name="authrNm" title="항목선택" alt="'+$(this).attr("alt")+'" value="' + $(this).val() + '"></td><td>' + $(this).attr("alt") + '</td></tr>'
			$('#searchTable tbody').append(html);
		}

		$(this).parent().parent().remove();

		this.checked=false;
	});
}
function fn_allLeft(){
	//$('#searchTable checkbox');
	//$('input:checkbox','#searchTable').parent().parent().appendTo($('#dspthTable tbody tr'));
	if($('input:checkbox','#searchTable').length==0 &&$('input:checkbox','#dspthTable').length!=0){//검색된 데이터가 없습니다. 삭제처리
		$('#searchTable tbody').empty();
	}
	$('input:checkbox','#dspthTable').each(function(){
		var id = this.value;
		var isOK=true;
		//debugger;
		$('input:checkbox','#searchTable').each(function(){
			//debugger;
			if(this.value==id){
				isOK=false;
				return false;
			}
		});

		if(isOK){
			var html = '<tr onclick="fn_checkUser(this)"><td><input type="checkbox" name="authrNm" title="항목선택" alt="'+$(this).attr("alt")+'" value="' + $(this).val() + '"></td><td>' + $(this).attr("alt") + '</td></tr>'
			$('#searchTable tbody').append(html);
			$(this).parent().parent().remove();
		}
		this.checked=false;
	});
}

//페이징 이동
function fn_goPage(page){
	location.href = "selectUserMng.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

//엑셀 다운로드
function fn_downloadExcel() {
	if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("다운로드할 데이터가 없습니다");
		return;
	}

	$("#searchVo").attr("action", "selectReqstHstryListXlsDwnl.do");
	$("#searchVo").submit();
}

//사용자정보 수정 처리
function fn_updateUserMng(){
	// api 매핑여부 체크
	var checked = 0;

	$("input[name='authrMapng']").each(function() {
		// 존재하는 모든 checkbox checked
		$("input:checkbox[name='authrMapng']").prop("checked",true);
		if( $(this).prop("checked") ) {
			checked++;
		}
	});

	if($("input:radio[name='statCd']:checked").val() == "03"){
		if($("#rjctReasn").val() == ""){
			parent.jAlert("반려선택 시 반려사유를 입력해야 합니다.");
			return;
		}
	}

	if($("input:radio[name='statCd']:checked").val() != "02"){
		checked++;
	}

	if( checked == 0 ) {
		parent.jAlert("API 매핑대상을 선택하시기 바랍니다.");
		return;
	}

	if(!fn_form_validation("userMngVo")){
		return;
	}

	if($("input[name='apis[].apiId']").length > 0){
		fn_form_rename("apis","apiId,stackClNm,apiNm,dc");
	}

	jConfirm('사용자관리 정보를 수정하시겠습니까?', function(){
		$.ncmsLoding.startFullScreen();
		$.post('updateUserMng.do', $('#userMngVo').serialize(), fn_pageMove, 'json').always(function() {
			$.ncmsLoding.remove();
		});
	});
}

// 콜백 / 화면이동
function fn_pageMove(result){
	alert_message(result.messageList, function() {
		if(result.success){
			if(result.procType == "update") {
				goToUrl('${listUrl}');
			}
		}
	}, (result.success?"INFO":""));
}

// 사용자정보 삭제 처리
function fn_deleteUserMng(){
	$.ncmsLoding.startFullScreen();
	if($("input[name='apis[].apiId']").length > 0){
		fn_form_rename("apis","apiId,stackClNm,apiNm,dc");
	}
	$.post('deleteUserMng.do', $('#userMngVo').serialize(), fn_pageMove2, 'json').always(function() {
		$.ncmsLoding.remove();
	});
}

// 콜백 / 화면이동
function fn_pageMove2(result){
	alert_message(result.messageList, function() {
		if(result.success){
			if(result.procType == "delete") {
				goToUrl('${listUrl}');
			}
		}
	}, (result.success?"INFO":""));
}

//비밀번호 재설정 : 입력창을 열어주고 필수 체크로 변경
function fn_passwdChange(){
	$("#passwd").attr("class","form-control essential");
	$("#passwd").removeAttr("readonly");
	$("#passwd").val("");
}

// 키 재발급
function fn_reIssuedUserMng(){
	if(('${userMngVo.accssKey}' == null) ||('${userMngVo.accssKey}' == "")){
		parent.jAlert("발급된 키가 없습니다.");
		return;
	}

	// 승인 일떄만 가능
	if($("input:radio[name='statCd']:checked").val() != "02"){
		parent.jAlert("상태가 승인일 때만 키 재발급이 가능합니다.");
		return;
	}

	if($("input[name='apis[].apiId']").length > 0){
		fn_form_rename("apis","apiId,stackClNm,apiNm,dc");
	}

	$.ncmsLoding.startFullScreen();
	$.post('reIssuedUserMng.do', $('#userMngVo').serialize(), fn_pageMove3, 'json').always(function() {
		$.ncmsLoding.remove();
	 });
}

// 콜백 / 화면이동
function fn_pageMove3(result){
	alert_message(result.messageList, function() {
		if(result.success){
			if(result.procType == "reIssued") {
				goToUrl('${listUrl}');
			}
		}
	}, (result.success?"INFO":""));
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
	   { sWidth : "400px" 	 },
	   { sWidth : "60px"},
	   { sWidth : "80px"},
	   { sWidth : "80px"},
	   { sWidth : "80px"}
	],
	order : [ [ 0, "desc" ] ]
});
</script>