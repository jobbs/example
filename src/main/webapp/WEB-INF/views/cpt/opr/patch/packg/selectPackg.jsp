<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 14.
 * @lastmodified 2016. 10. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 14.     이화영         v1.0             최초생성
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

<c:url var="vmListXlsDwnl" value="excelDownVmPatchList.do">
	<c:param name="packgNm" value="${packgInfoVo.packgNm }"></c:param>
</c:url>
<c:url var="vmPatchTrgtListXlsDwnl" value="excelDownPatchTrgList.do">
	<c:param name="packgSeq" value="${packgInfoVo.packgSeq }"></c:param>
	<c:param name="packgNm" value="${packgInfoVo.packgNm }"></c:param>
	<c:param name="ver" value="${packgInfoVo.ver }"></c:param>
</c:url>

<form:form commandName="packgSearchVo">
	<form:input path="searchPackgNm" type="hidden" class="form-control" value="${packgInfoVo.packgNm }"/>
	<form:input path="packgSeq" type="hidden" class="form-control" value="${packgInfoVo.packgSeq }"/>
</form:form>
<div class="col-box-100 detail-col">
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">패키지 정보</h3>
		</div><!-- /box-header -->
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>패키지 정보</caption>
				<colgroup>
					<col class="col13">
					<col class="col20">
					<col class="col13">
					<col class="col20">
					<col class="col13">
					<col class="col21">
				</colgroup>
				<tbody>
				<tr>
					<th>센터</th>
					<td><c:out value="${packgInfoVo.regionNm}"/></td>
					<th>망구분</th>
					<td><c:out value="${packgInfoVo.netNm}"/></td>
					<th>레파지토리</th>
					<td><c:out value="${packgInfoVo.repositNm}"/></td>
				</tr>
				<tr>
					<th>패키지 명</th>
					<td><c:out value="${packgInfoVo.packgNm}"/></td>
					<th>버전</th>
					<td><c:out value="${packgInfoVo.ver}"/></td>
					<th>릴리즈</th>
					<td><c:out value="${packgInfoVo.release}"/></td>
				</tr>
				<tr>
					<th>시스템종류</th>
					<td><c:out value="${packgInfoVo.sysKndCd}"/></td>
					<th>라이센스</th>
					<td><c:out value="${packgInfoVo.licnse}"/></td>
					<th>파일크기</th>
					<td><c:out value="${packgInfoVo.fileSize}"/></td>
				</tr>
				<tr>
					<th>사용용도</th>
					<td colspan="3"><c:out value="${packgInfoVo.usePrpos}"/></td>
					<th>등록일시</th>
					<td><c:out value="${packgInfoVo.regDt}"/></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="5"><c:out value="${packgInfoVo.packgCn}"/></td>
				</tr>
				</tbody>
			</table>
		</div><!-- /box-body -->
		<div class="box-footer clearfix">
			<div class="pull-right">
				<button type="button" class="btn btn-sm btn-function" onclick="fn_selectVerHis()">이전 버전보기</button>
			</div>
		</div>
	</div>

	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">가상서버 목록</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_goExcelDownload();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
			<table class="table table-vertical" id="vmPatchTable">
				<caption>가상서버 목록</caption>
				<colgroup>
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
				</colgroup>
     			<thead>
				<tr>
					<th>No.</th>
					<th>부처명</th>
					<th>업무명</th>
					<th>센터</th>
					<th>존</th>
					<th>망구분</th>
					<th>가상화SW</th>
					<th>자원풀</th>
					<th>가상서버명</th>
					<th>가상서버구성ID</th>
					<th>가상서버ID</th>
					<th>호스트명</th>
					<th>IP주소</th>
					<th>OS타입</th>
					<th>생성일자</th>
       			</tr>
       			</thead>
       			<tbody>
       			<c:forEach var="vmPatchVo" items="${vmPatchVoList }" varStatus="i">
       				<tr>
						<td><c:out value="${(vmPatchSearchVo.paginationInfo.totalRecordCount-vmPatchSearchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
						<td class="alignL"><c:out value="${vmPatchVo.institutionNm }" /></td>
						<td class="alignL">
							<c:set var="jobNmList" value="${fn:split(vmPatchVo.jobsNm, ',')}"/>
							<c:forEach var="jobNm" items="${jobNmList}" varStatus="i">
								<nobr><c:out value="${jobNm }" /><c:if test="${fn:length(jobNmList) > (i.index + 1) }"><c:out value=","/></c:if></nobr>
							</c:forEach>
						</td>
						<td class="alignL"><c:out value="${vmPatchVo.regionNm }" /></td>
						<td class="alignL"><c:out value="${vmPatchVo.zoneNm }" /></td>
						<td class="alignL"><c:out value="${vmPatchVo.netNm }" /></td>
						<td class="alignL"><c:out value="${vmPatchVo.vrlzSwTyCdNm }" /></td>
						<td class="alignL"><c:out value="${vmPatchVo.rsrcPoolNm }" /></td>
						<td class="alignL"><c:out value="${vmPatchVo.vmNm }" /></td>
						<td class="alignL"><c:out value="${vmPatchVo.vmCompId }" /></td>
						<td class="alignL"><c:out value="${vmPatchVo.vmId }" /></td>
						<td class="alignL"><c:out value="${vmPatchVo.hstNm }" /></td>
						<td class="alignL"><c:out value="${vmPatchVo.rprsntIpAddr }" /></td>
						<td class="alignL"><c:out value="${vmPatchVo.osTyCdNm }" /></td>
						<td><fmt:formatDate value="${vmPatchVo.regDttm }" pattern="yyyy-MM-dd" /></td>
					</tr>
       			</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">패치대상 가상서버 목록</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_goExcelDownloadPatch();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
			<table class="table table-vertical" id="vmPatchTrgtTable">
				<caption>패치대상 가상서버 목록</caption>
				<colgroup>
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
				</colgroup>
				<thead>
				<tr>
					<th>No.</th>
       				<th>패키지 버전</th>
					<th>부처명</th>
					<th>업무명</th>
					<th>센터</th>
					<th>존</th>
					<th>망구분</th>
					<th>가상화SW</th>
					<th>자원풀</th>
					<th>가상서버명</th>
					<th>가상서버구성ID</th>
					<th>가상서버ID</th>
					<th>호스트명</th>
					<th>IP주소</th>
					<th>OS타입</th>
					<th>생성일자</th>
     				</tr>
     				</thead>
      				<tbody>
      				<c:forEach var="patchTrgtVo" items="${patchTrgtVoList }" varStatus="i">
      					<tr>
						<td><c:out value="${(packgSearchVo.paginationInfo.totalRecordCount-packgSearchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
						<td class="alignL"><c:out value="${patchTrgtVo.ver }" /></td>
						<td class="alignL"><c:out value="${patchTrgtVo.institutionNm }" /></td>
						<td class="alignL"><c:out value="${patchTrgtVo.jobsNm }" /></td>
						<td class="alignL"><c:out value="${patchTrgtVo.regionNm }" /></td>
						<td class="alignL"><c:out value="${patchTrgtVo.zoneNm }" /></td>
						<td class="alignL"><c:out value="${patchTrgtVo.netNm }" /></td>
						<td class="alignL"><c:out value="${patchTrgtVo.vrlzSwTyCdNm }" /></td>
						<td class="alignL"><c:out value="${patchTrgtVo.rsrcPoolNm }" /></td>
						<td class="alignL"><c:out value="${patchTrgtVo.vmNm }" /></td>
						<td class="alignL"><c:out value="${patchTrgtVo.vmCompId }" /></td>
						<td class="alignL"><c:out value="${patchTrgtVo.vmId }" /></td>
						<td class="alignL"><c:out value="${patchTrgtVo.hstNm }" /></td>
						<td class="alignL"><c:out value="${patchTrgtVo.rprsntIpAddr }" /></td>
						<td class="alignL"><c:out value="${patchTrgtVo.osTyCdNm }" /></td>
						<td><c:out value="${patchTrgtVo.regDt}" /></td>
					</tr>
      				</c:forEach>
      				</tbody>
			</table>
		</div>
		<c:if test="${packgSearchVo.paginationInfo.totalRecordCount != '0'}">
			<div class="box-footer">
				<div class="pull-right">
					<button type="button" class="btn btn-sm btn-function" onclick="fn_inserPatch('${packgInfoVo.packgSeq}','${packgInfoVo.packgNm}','${packgInfoVo.ver}','${packgInfoVo.release}')">패치알림 등록</button>
				</div>
			</div>
		</c:if>
	</div>
</div><!-- col -->

<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="fn_selectPackgList();"><i class="fa fa-arrow-left"></i></button>
		</div>
    </div>
</div>

<script type="text/javascript">

//뒤로
function fn_selectPackgList(){
	location.href = '<c:url value="selectPackgList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'packgSeq' && pageParam.key ne 'packgNm' && pageParam.key ne 'ver'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

$("#vmPatchTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	order : [[0, "desc"]]
} );

$("#vmPatchTrgtTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	order : [[0, "desc"]]
} );

//목록의 정보를 Excel로 다운로드 한다.
function fn_goExcelDownload() {
	if("${vmPatchSearchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}
	goToUrl('${vmListXlsDwnl}');
}

function fn_goExcelDownloadPatch() {
	if("${packgSearchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}
	goToUrl('${vmPatchTrgtListXlsDwnl}');
}

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

//이전버전보기
function fn_selectVerHis(){
	var url = 'selectPackgVerListP.do';
	var target = "selectPackgVerListP";
	window.open("", target, getStatus(740, 820));

	$('#packgSearchVo').attr("target", target);
	$('#packgSearchVo').attr("action", url);
	$('#packgSearchVo').submit();
}

//패키지 알림등록 화면 호출
function fn_inserPatch(packgSeq, packgNm, ver, release){
	var url = 'insertPatchAlrmPView.do';
	var packgSeq = packgSeq;
	var packgNm = packgNm;
	var ver = ver;
	var release = release;
	var params = { packgSeq : packgSeq , packgNm : packgNm , ver : ver, release : release};

	var width = 740;
	var height = 450;;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {key:"packgNm", width:width , height:height, posX : posX , posY : posY};
	windowOpen(url, params, args);
}
</script>