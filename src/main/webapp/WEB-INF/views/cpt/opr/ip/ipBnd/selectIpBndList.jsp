<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 29.
 * @lastmodified 2016. 10. 29.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 29.     신재훈         v1.0             최초생성
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


<c:set var="listParam"	value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<!-- 검색조건 영역 -->
<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get" onsubmit="return checkIpBndList()">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
		<div class="box box-search">
			<!-- box-header -->
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<!-- 접기 버튼 -->
					<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기" data-original-title="접어두기"></i>
					</button>
				</div>
			</div>

			<!-- box-body -->
			<div class="box-body collapse in search-collapse">
				<div class="form-group">
					<!-- 검색조건 시작  -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchUseYn" title="사용여부">사용여부</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:select path="searchUseYn" cssClass="form-control input-sm" title="사용여부">
									<form:option value="" title="전체">전체</form:option>
									<form:option value="Y" title="사용">사용</form:option>
									<form:option value="N" title="미사용">미사용</form:option>
								</form:select>
							</div>
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchRegion" title="센터">센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion name="searchRegion" id="searchRegion" cssClass="form-control input-sm" title="센터" value="${searchVo.searchRegion}" whole="true" />
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchNet" title="망구분">망구분</label>
						</div>
						<div class="cell-body">
							<form:select path="searchNet" value="${netCd.cd}" id="${netCd.cd}" cssClass="form-control input-sm"  title="망구분">
							<c:forEach var="netCd" items="${netList }">
								<form:option value="${netCd.cd }" title="망구분"><c:out value="${netCd.cdNm}"/></form:option>
							</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchIpBndName" title="IP대역명" >IP대역명</label>
						</div>
						<div class="cell-body">
							<form:input path="searchIpBndName" cssClass="form-control input-sm" title="IP대역명" maxlength="30" />
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchGateway" title="게이트웨이" >게이트웨이</label>
						</div>
						<div class="cell-body">
							<form:input path="searchGateway" cssClass="form-control input-sm onlyIp" title="게이트웨이" maxlength="15"/>
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchStrtIp" title="시작IP">시작IP</label>
						</div>
						<div class="cell-body">
							<form:input path="searchStrtIp" cssClass="form-control input-sm onlyIp" title="시작IP" maxlength="15" />
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchEndIp" title="종료IP">종료IP</label>
						</div>
						<div class="cell-body">
							<form:input path="searchEndIp" cssClass="form-control input-sm onlyIp" title="종료IP" maxlength="15"/>
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchInstitution" title="사용부처">사용부처</label>
						</div>
						<div class="cell-body">
							<form:input path="searchInstitution" cssClass="form-control input-sm" title="사용부처" maxlength="30"/>
						</div>
					</div>
					<div class="form-cell form-cell-100 col-lay-25">
						<div class="cell-title">
							<label for="searchVlan" title="VLAN" >VLAN</label>
						</div>
						<div class="cell-body">
							<form:input path="searchVlan" cssClass="form-control input-sm onlyNumber" title="VLAN" maxlength="30" />
						</div>
					</div>
					<div class="form-cell form-cell-100 col-lay-100">
						<div class="cell-title">
							<label for="searchPrposList"  title="용도">용도</label>
						</div>
						<div class="cell-body">
							<div class="input-group input-group-check">
								<c:choose>
									<c:when test="${searchVo eq null or searchVo.searchPrposList eq null }">
										<c:forEach var="prposClCd" items="${prposList }" varStatus="i">
											<form:checkbox path="searchPrposList[${i.index }]" title="용도" value="${prposClCd.cd}" id="${prposClCd.cd}" checked="checked"/>
											<label for="${prposClCd.cd}"><c:out value="${prposClCd.cdNm}"/></label>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<c:forEach var="prposClCd" items="${prposList }" varStatus="i">
											<form:checkbox path="searchPrposList[${i.index }]" title="용도" value="${prposClCd.cd}" id="${prposClCd.cd}"/>
											<label for="${prposClCd.cd}"><c:out value="${prposClCd.cdNm}"/></label>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</div>
<!-- 							<div class="input-group"> -->
<%-- 								<form:select path="searchPrpos" cssClass="form-control input-sm"> --%>
<%-- 									<c:forEach var="prposCd" items="${prposList}" --%>
<%-- 										varStatus="prposCdVar"> --%>
<%-- 										<form:option value="${prposCd.cd}">${prposCd.cdNm}</form:option> --%>
<%-- 									</c:forEach> --%>
<%-- 								</form:select> --%>
<!-- 							</div> -->
						</div>
					</div>
					<!-- 검색조건 종료  -->
				</div>
				<!-- box-footer -->
				<div class="box-footer collapse in search-collapse">
					<div class="pull-left">
						<button type="reset" class="btn" onclick="fn_searchAreaReset('searchVo')" title="초기화">초기화</button>
					</div>
					<div class="pull-right">
						<button type="button" class="btn btn-red pull-right" onclick="fn_selectIpBndList()" title="조회">조회</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>

	<menu:authorize onlyOprAdm="true">
		<div class="info">
		    <p>- IP대역관리 업로드를 위한 템플릿 다운로드 <a href="<c:url value='selectCsvDwnload.do'/>" title="IP대역관리 업로드샘플.csv">[IP대역관리 업로드샘플.csv]</a></p>
	    	<p>- <font color=red><strong>(최대 500건)</strong> 반드시 업로드 할 엑셀파일(*.csv)은 샘플 포맷과 맞춰서 작성후</font> 선택하여, [엑셀업로드] 버튼을 클릭하시기 바랍니다.</p>
	 	</div>

	 	<div class="box">
			<div class="box-header"></div>
			<div class="box-body">
				<div class="input-group-box full">
					<form id="uploadCsv" action="insertCsvUpload.do" method="post" enctype="multipart/form-data">
						<div class="input-group-cell pad-right-5">
							<div class="file-form" id="fileDiv">
								<div class="file-form-field input-group" id="fieldDiv">
									<input type="text" class="form-control file-name" value="파일선택" disabled="disabled" title="파일선택">
									<p class="input-group-btn"><label for="file-1" class="file-label btn" title="찾아보기">찾아보기</label></p>
									<input type="file" class="form-control file-hidden" name="files" id="file-1" title="찾아보기">
									<script>
									$(function(){
										var fileTarget = $("#file-1");

										fileTarget.change(function (){
											if(window.FileReader){
												var fileName = $(this)[0].files[0].name;
											}
									 	else{
									 		var fileName = $(this).val().split("/").pop().split("\\").pop();
									 	}
											fileTarget.siblings(".file-name").val(fileName);
										});
									});
									</script>
								</div>
							</div>
						</div>
						<div class="input-group-cell fix-cell">
							<button type="button" class="btn btn-function" style="cursor: hand;" onclick="javascript:fn_checkForm();" title="엑셀 업로드">엑셀 업로드</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</menu:authorize>
</div>


<div class="col-box-100 search-col">
	<div class="box list-box">
		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">
				검색결과<small> ${searchVo.paginationInfo.currentPageNo }
					/ ${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo}" />
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function"
							onclick="fn_selctIpBndListXlsDwnl();" data-toggle="tooltip"
							title="" data-original-title="엑셀다운로드" data-placement="left">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /box-header -->
		<!-- box-body -->
		<form id="ipBndListFrm" name="ipBndListFrm" method="post">
			<div class="box-body no-padding list-body">
				<table class="table table-hover table-vertical table-layout-fixed" id="ipBndTable" >
				<caption>IP대역목록(사용여부,센터,망구분,용도,IP대역명,사용부처,시작IP,종료IP,게이트웨이,서브넷마스크,VLAN, 할당IP수, 미할당IP수, BlockIP수)</caption>
					<thead>
						<tr>
							<th><input type="checkbox" id="selectall" title="전체선택"></th>
							<th>사용여부</th>
							<th>센터</th>
							<th>망구분</th>
							<th>IP 대역명</th>
							<th>사용부처</th>
							<th>용도</th>
							<th>시작 IP</th>
							<th>종료 IP</th>
							<th>게이트웨이</th>
							<th>서브넷마스크</th>
							<th>VLAN</th>
							<th>할당 IP수</th>
							<th>미할당 IP수</th>
							<th>Block IP수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ipBndVo" items="${list }" varStatus="i">
							<c:url var="detailUrl" value="selectIpBnd.do">
								<c:forEach var="curParam" items="${param }">
									<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
								</c:forEach>
								<c:param name="bndSeq" value="${ipBndVo.bndSeq }" />
							</c:url>
							<tr>
								<td>
									<c:choose>
										<c:when test="${ ipBndVo.useYn eq 'Y' }">
										<input type="checkbox" class="checkBndIps" name="checkBndIps" value="${ipBndVo.bndSeq }" title="항목선택">
										</c:when>
										<c:otherwise>
										<input type="checkbox" class="checkBndIps" disabled="disabled">
										</c:otherwise>
									</c:choose>
								</td>
								<td>
									<nobr>
										<c:choose>
											<c:when test="${ ipBndVo.useYn eq 'Y' }">
												<span title="사용" class="status status-green">사용</span>
											</c:when>
											<c:otherwise>
												<span title="미사용" class="status status-gray">미사용</span>
											</c:otherwise>
										</c:choose>
									</nobr>
								</td>
								<td class="alignC"><c:out value="${ipBndVo.regionNm }" /></td>
								<td class="alignC"><c:out value="${ipBndVo.netNm }" /></td>
								<td class="alignL"><a href="<c:url value="${detailUrl }" />" title="<c:out value="${ipBndVo.ipBndNm}"/>"><c:out value="${cf:ellipsis(ipBndVo.ipBndNm, 60) }" /></a></td>
								<td class="alignL"><c:out value="${ipBndVo.institutionNm }" /></td>
								<td class="alignL"><c:out value="${ipBndVo.prposNm }" /></td>
								<td class="alignL"><c:out value="${ipBndVo.bndStrtIp }" /></td>
								<td class="alignL"><c:out value="${ipBndVo.bndEndIp }" /></td>
								<td class="alignL"><c:out value="${ipBndVo.gtwyIpAddr }" /></td>
								<td class="alignL"><c:out value="${ipBndVo.subnetMask }" /></td>
								<td class="alignL"><c:out value="${ipBndVo.vlan }" /></td>
								<td class="alignR"><c:out value="${ipBndVo.asgnIpQty }" /></td>
								<td class="alignR"><c:out value="${ipBndVo.unasgnIpQty }" /></td>
								<td class="alignR"><c:out value="${ipBndVo.blkIpQty }" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</form>
		<!-- /box-body -->
		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
			<c:url var="listUrl" value="selectIpBndList.do">
				<c:forEach var="curParam" items="${param }">
					<c:if test="${curParam.key ne 'bndSeq'}">
						<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
					</c:if>
				</c:forEach>
			</c:url>
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertIpBndView.do">
						<c:forEach var="curParam" items="${param }">
							<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
						</c:forEach>
					</c:url>
					<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가" onclick="fn_goToUrl('${insertUrl}')">
						<i class="fa fa-plus"></i>
					</button>
					<button type="button" class="btn btn-hover-green" data-toggle="tooltip"	data-original-title="동기화" onclick="fn_updateIpBndListSync()">
						<i class="fa fa-play-circle"></i>
					</button>
				</menu:authorize>
			</div>
		</div>
		<!-- /box-footer -->
	</div>
</div>
<script type="text/javascript">
function fn_goPage(page) {
	location.href = "selectIpBndList.do?paginationInfo.currentPageNo="+ page + "&${listParam}";
}

function fn_goToUrl(url) {
	location.href = url;
}

$(document).ready(function() {
	$('#selectall').click(function() {
		$('.checkBndIps').prop('checked', $(this).is(":checked"));
	});

	$('.checkBndIps').click(function() {
		if ($('.checkBndIps:checked').length == $('.checkBndIps').length) {
			$('#selectall').prop('checked', true);
		} else {
			$('#selectall').prop('checked', false);
		}
	});
});

function checkIpBndList(){
	// 입력항목에 한글입력여부 검사 (시작IP, 종료IP, VLAN)
	var gtwyIp = $('#searchVo input[name="searchGateway"]').val();
	var strtIp = $('#searchVo input[name="searchStrtIp"]').val();
	var endIp = $('#searchVo input[name="searchEndIp"]').val();
	var vlan = $('#searchVo input[name="searchVlan"]').val();
	var pattern = /[\u3131-\u314e|\u314f-\u3163|\uac00-\ud7a3]/g;

	if(pattern.test(gtwyIp) || pattern.test(strtIp) || pattern.test(endIp) || pattern.test(vlan)){
		jAlert("검색조건중 게이트웨이, 시작IP, 종료IP, VLAN 에는 한글이 입력될 수 없습니다.");
		return false;
	}
	else {
		return true;
	}
}

function fn_searchAreaReset(id) {
	$('#searchVo input[type="text"]').val('');
	$('#searchVo select').val('').attr('selected', 'selected');
	$('#searchVo input[type="checkbox"][name="searchPrposList"]').prop('checked', 'checked');
}

// 결과 메시지
function fn_successHandler(result) {
	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo(result.messageList, function(){
			fn_goToUrl('${listUrl}');
		});
	}
	else{
		alert_message(result.messageList);
	}
}

// 조회
function fn_selectIpBndList() {
	$('#searchVo').attr('target', '_self');
	$('#searchVo').attr('action', '<c:url var="select" value="selectIpBndList.do"/>');
	$('#searchVo').submit();
}

// IP 대역 동기화
function fn_updateIpBndListSync() {
	var checked = 0;
	$("input[name='checkBndIps']").each(function() {
		if ($(this).prop("checked")) {
			checked++;
		}
	});

	if (checked == 0) {
		jAlert("동기화를 진행할 대역을 선택하시기 바랍니다.");
		return;
	}

	jConfirm("선택한 대역의 동기화를 진행하시겠습니까?", function() {
		var options = {
				type : 'post',
				dataType : 'json',
				success : fn_successHandler,
				beforeSend : function() {
					$.ncmsLoding.startFullScreen();
				},
				complete : function() {
					$.ncmsLoding.remove();
				},
				error : function(xhr, textStatus, errorThrown) {
					jAlert('동기화 중 오류 발생');
				}
			};

			$('#ipBndListFrm').attr("action", "updateIpBndListSync.do");
			$('#ipBndListFrm').ajaxSubmit(options);
	});
}

function fn_selctIpBndListXlsDwnl() {
	if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("다운로드 할 데이터가 없습니다");
		return;
	}

	$("#searchVo").attr("action", '<c:url value="selectIPBndListXlsDwnl.do"/>');
	$("#searchVo").submit();
}


$("#ipBndTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	               {sWidth : "35px" },
	               {sWidth : "50px" },
	               {sWidth : "35px" },
	               {sWidth : "60px" },
	               {sWidth : "140px" },
	               {sWidth : "80px" },
	               {sWidth : "65px" },
	               {sWidth : "95px" },
	               {sWidth : "95px" },
	               {sWidth : "90px" },
	               {sWidth : "95px" },
	               {sWidth : "39px" },
	               {sWidth : "55px" },
	               {sWidth : "60px" },
	               {sWidth : "57px" }
	],
	order : [ [ 0, "desc" ] ]
});

function fn_checkForm() {

	if (uploadCsv.files.value == "") {
		jAlert("업로드 파일을 선택해주세요.");
		return false;
	} else {
		if (!fn_checkFileType(uploadCsv.files.value)) {
			jAlert("확장자가 csv인 파일만 업로드가 가능합니다.");
			return false;
		}
	}

	var options = {
		type: 'post',
		dataType: 'json',
		success: insertIpBndInfoResultHandler,
		beforeSend : function() {
			$.ncmsLoding.startFullScreen();
		},
		complete : function() {
			$.ncmsLoding.remove();
		},
		error: function(xhr, textStatus, errorThrown){
			alert('오류가 발생하였습니다.');
		}
	};

	jConfirm("파일을 업로드 하시겠습니까?", function(){
		$('#uploadCsv').ajaxSubmit(options);
	});
}

function insertIpBndInfoResultHandler(result) {
	if (result.success) {
		jInfo("중복된 IP대역을 제외하고 파일추가에 성공하였습니다.", function(){
			goToUrl("selectIpBndList.do");
		});
	} else {
		jAlert(result.messageList);
	}
}

function fn_checkFileType(file) {
	var fileFormat = file.substring(file.length - 4)
	var fileFormat1 = file.substring(file.length - 5)

	fileFormat = fileFormat.toLowerCase();
	fileFormat1 = fileFormat1.toLowerCase();

	if (fileFormat == ".csv") {
		return true;
	} else {
		return false;
	}

}
</script>