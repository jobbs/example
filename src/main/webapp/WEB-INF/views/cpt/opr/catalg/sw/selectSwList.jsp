<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2017. 1. 11.
 * @lastmodified 2017. 1. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 1. 11.     이화영         v1.0             최초생성
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

<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
	<div class="box box-search">
		<div class="box-header">
			<h3 class="box-title">검색조건</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
					<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
				</button>
			</div>
		</div>

		<div class="box-body collapse in search-collapse">
			<div class="form-group">
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchSwNm" title="소프트웨어명">소프트웨어명</label>
					</div>
					<div class="cell-body">
						<div class="input-group">
							<form:input path="searchSwNm" title="소프트웨어명" cssClass="form-control input-sm pull-right" />
						</div>
					</div>
				</div>

				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchSwVer" title="소프트웨어 버전">소프트웨어 버전</label>
					</div>
					<div class="cell-body">
						<div class="input-group">
							<form:input path="searchSwVer" title="소프트웨어 버전" cssClass="form-control input-sm pull-right" />
						</div>
					</div>
				</div>

				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchSwMnfctCo" title="소프트웨어 제조사">소프트웨어 제조사</label>
					</div>
					<div class="cell-body">
						<div class="input-group">
							<form:input path="searchSwMnfctCo" title="소프트웨어 제조사" cssClass="form-control input-sm pull-right" />
						</div>
					</div>
				</div>

			</div>
		</div>

		<div class="box-footer collapse in search-collapse">
			<div class="pull-left">
		        <button class="btn" onclick="javascript:fn_initialize();return false;">초기화</button>
	      </div>
	      <div class="pull-right">
		  	<c:url var="selectSwListUrl" value="selectSwList.do"/>
		    <button type="button" class="btn btn-red pull-right" onclick="fn_selectSwList();">조회</button>
		  </div>
		</div><!-- /box-footer -->
		</form:form>
	</div>

	<menu:authorize onlyOprAdm="true">
		<div class="info">
	    	<p>- 소프트웨어 업로드를 위한 템플릿 다운로드 <a href="<c:url value='selectSwXlsDwnload.do'/>" title="SW업로드샘플.xlsx">[SW업로드샘플.xlsx]</a></p>
	    	<p>- 업로드 할 엑셀파일(*.xls,*.xlsx)을 선택한 후, [엑셀업로드] 버튼을 클릭하시기 바랍니다.</p>
	 	</div>

	 	<div class="box">
			<div class="box-header"></div>
			<div class="box-body">
				<div class="input-group-box full">
					<form id="uploadSw" action="insertSwXlsUpload.do" method="post" enctype="multipart/form-data">
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

		<div class="box-header">
			<h3 class="box-title">소프트웨어 목록<small>
				${searchVo.paginationInfo.currentPageNo } /${searchVo.paginationInfo.totalPageCount },총 ${searchVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
	     			<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/>
	     			<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_selectSwListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
	  		</div><!-- /box-header -->
		</div><!-- /box-header -->

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<form id="swListFrm" name="swListFrm" method="post">
				<table class="table table-hover table-vertical table-layout-fixed"  id="swTable">
				<caption>소프트웨어 목록 테이블</caption>
					<thead>
						<tr>
							<th><input type="checkbox" id="selectAll" title="전체선택"></th>
							<th>No.</th>
							<th>소프트웨어 명</th>
							<th>소프트웨어 버전</th>
							<th>소프트웨어 제조사</th>
							<th>등록자</th>
							<th>등록일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${list }" varStatus="i">
							<c:url var="detailUrl" value="selectSw.do">
								<c:forEach var="curParam" items="${param }">
									<c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach>
								</c:forEach>
								<c:param name="swSeq" value="${vo.swSeq }" />
							</c:url>
							<tr>
								<td><input type="checkbox" name="updtCheck" class="updtCheck" value="${vo.swSeq }" title="항목선택"/></td>
								<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
								<td class="alignL"><a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.swNm}"/>"><c:out value="${vo.swNm }" /></a></td>
								<td class="alignL"><a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.swVer}"/>"><c:out value="${vo.swVer }" /></a></td>
								<td class="alignL"><c:out value="${vo.swMnfctCo }" /></td>
								<td><c:out value="${vo.creUserNm}"/></td>
								<td><fmt:formatDate value="${vo.creDttm }" pattern="yyyy-MM-dd" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertSw.do">
						<c:forEach var="curParam" items="${param }">
							<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
						</c:forEach>
					</c:url>
					<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가" onclick="goToUrl('${insertUrl}')"><i class="fa fa-plus"></i></button>
					<button type="button" class="btn btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="deleteCheck();"><i class="fa fa-minus"></i></button>
				</menu:authorize>
			</div>
		</div>
		<!-- /box-footer -->
	</div>
</div>

<script type="text/javascript">

$(document).ready(function(){
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

//검색조건 초기화
function fn_initialize(){
	$('#searchVo input[type="text"]').val('');
}

function fn_selectSwList(){
	$('#searchVo').attr('target', '_self');
	$('#searchVo').attr('action', '<c:url var="select" value="selectSwList.do"/>');
	$('#searchVo').submit();
}

//페이지 이동
function fn_goPage(page){
	location.href = "selectSwList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

//목록의 정보를 Excel로 다운로드 한다.
function fn_selectSwListXlsDwnl() {
	if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}
	$('#searchVo').attr('target', '_self');
	$('#searchVo').attr('action', '<c:url value="selectSwListXlsDwnl.do"/>');
	$('#searchVo').submit();
}

$("#swTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	             {sWidth : "30px" },//checkbox
	             {sWidth : "30px" },//No.
	             {sWidth : "190px" },//소프트웨어명
	             {sWidth : "130px" },//소프트웨어버전
	             {sWidth : "190px" },//소프트웨어제조사
	             {sWidth : "80px" },//등록자
	             {sWidth : "80px" }//등록일자
	],
	order : [ [ 0, "desc" ] ]
} );

function deleteCheck(){
	var checked = 0;
	$("input[name='updtCheck']").each(function() {
		if( $(this).prop("checked") ) {
			checked++;
		}
	});

	if( checked == 0 ) {
		jAlert("삭제대상을 선택하시기 바랍니다.");
		return;
	}
	jConfirm('소프트웨어를 삭제하시겠습니까?',fn_deleteSw)
}

//선택소프트웨어 삭제
function fn_deleteSw(){
	var options = {
		type: 'post',
		dataType: 'json',
		success: fn_deleteSwCallBack,
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
	$('#swListFrm').attr("action", "deleteListSw.do");
	$('#swListFrm').ajaxSubmit(options);
}

//소프트웨어삭제 콜백
function fn_deleteSwCallBack(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo(result.messageList, function(){
			goToUrl("selectSwList.do");
		});
	}
	else{
		alert_message(result.messageList);
	}
}

function fn_checkForm() {

	if (uploadSw.files.value == "") {
		jAlert("업로드 파일을 선택해주세요.");
		return false;
	} else {
		if (!fn_checkFileType(uploadSw.files.value)) {
			jAlert("확장자가 xls나 xlsx인 파일만 업로드가 가능합니다.");
			return false;
		}
	}

	var options = {
		type: 'post',
		dataType: 'json',
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

	jConfirm("파일을 업로드 하시겠습니까?", function(){
		$('#uploadSw').ajaxSubmit(options);
	});
}

function fn_checkFileType(file) {
	var fileFormat = file.substring(file.length - 4)
	var fileFormat1 = file.substring(file.length - 5)

	fileFormat = fileFormat.toLowerCase();
	fileFormat1 = fileFormat1.toLowerCase();

	if (fileFormat == ".xls" || fileFormat1 == ".xlsx") {
		return true;
	} else {
		return false;
	}

}

function fn_pageMove(result) {
	if (result.success) {
		jAlert("중복된 소프트웨어를 제외하고 업로드되었습니다.", function(){
			if (result.procType == "insert") {
				location.href = "<c:url value='selectSwList.do?paginationInfo.currentPageNo=1&${listParam}'/>";
			}
		});
	} else {
		jAlert(result.messageList);
	}
}
</script>