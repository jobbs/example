<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 21.
 * @lastmodified 2016. 10. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 21.     이화영         v1.0             최초생성
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

<script type="text/javascript" src="<c:url value="/resources/js/common/validation.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/FileUtils.js" />" charset="UTF-8"></script>

<c:url var="distrbListXlsDwnl" value="excelDownDistrbList.do"></c:url>
<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<!-- 검색조건 영역 -->
<div class="col-box-100 search-col">
	<div class="box box-search">
		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">검색조건</h3>
			<div class="box-tools pull-right">
				<!-- 접기 버튼 -->
				<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
					<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
				</button>
			</div>
		</div>
		<form:form commandName="distrbSearchVo" method="get">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
		<!-- box-body -->
		<div class="box-body collapse in search-collapse">
			<div class="form-group">
				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchTicketId" title="티켓번호">티켓번호</label>
					</div>
					<div class="cell-body">
						<form:input path="searchTicketId" title="티켓번호" cssClass="form-control input-sm" value=""/>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchDistrbReasn" title="배포사유">배포사유</label>
					</div>
					<div class="cell-body">
						<nform:selectCode
							parentCd="137"
							parentGrpCd="053"
							name="searchDistrbReasn"
							id="searchDistrbReasn"
							whole="true"
							value="${distrbSearchVo.searchDistrbReasn}"
							cssClass="form-control" />
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchVmCompId" title="가상서버구성ID">가상서버구성ID</label>
					</div>
					<div class="cell-body">
						<form:input path="searchVmCompId" title="가상서버구성ID" cssClass="form-control input-sm" value=""/>
					</div>
				</div>
			</div>
		</div>
		<!-- box-footer -->
		<div class="box-footer collapse in search-collapse">
		  <div class="pull-left">
		    <button type="button" class="btn" onclick="fn_initialize();">초기화</button>
		  </div>
		  <div class="pull-right">
		  	<c:url var="selectVmListUrl" value="selectVmList.do">
			</c:url>
		    <button type="button" class="btn btn-red pull-right" onclick="fn_selectDistrbList();">조회</button>
		  </div>
		</div>
		</form:form>
	</div>
</div>

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">배포 이력<small>
			${distrbSearchVo.paginationInfo.currentPageNo } /
			${distrbSearchVo.paginationInfo.totalPageCount },
			총 ${distrbSearchVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="distrbSearchVo" value="${distrbSearchVo }"/>
		     			<div class="input-group-cell pad-right">
							<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_goExcelDownload();"><i class="fa fa-download"></i></button>
						</div>
					</div>
  				</div>
     			<!-- box-body -->
			<div class="box-body no-padding list-body">
				<form:form commandName="distrbSearchVo" method="get">
				<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
 					<table class="table table-vertical table-layout-fixed" id="disrbTable">
 					<caption>배포 이력 목록</caption>
     					<thead>
     						<tr>
         						<th>No.</th>
								<th>티켓번호</th>
								<th>배포사유</th>
								<th>배포내용</th>
								<th>배포경로</th>
								<th>가상서버구성ID</th>
								<th>배포실행자</th>
								<th>배포일시</th>
       						</tr>
       					</thead>
       					<tbody>
	        				<c:forEach var="distrbVo" items="${distrbVoList }" varStatus="i">
	        					<tr>
									<td><c:out value="${(distrbSearchVo.paginationInfo.totalRecordCount-distrbSearchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
									<td class="alignL"><c:out value="${distrbVo.ticketId }" /></td>
									<td><c:out value="${distrbVo.distrbReasnNm }" /></td>
									<td class="alignL">${cf:nl2br(distrbVo.rmk ) }</td>
									<td class="alignL"><c:out value="${distrbVo.distrbPath }" /></td>
									<td class="alignC"><c:out value="${distrbVo.vmCompId }" /></td>
									<td><c:out value="${distrbVo.distrbExeUserNm }" /></td>
									<td><c:out value="${distrbVo.distrbDttm }" /></td>
								</tr>
	        				</c:forEach>
       					</tbody>
     				</table>
     			</form:form>
 			</div>
		</div>
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${distrbSearchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
			<div class="pull-right btns">
				<c:url var="insertUrl" value="insertDisrb.do">
					<c:forEach var="curParam" items="${param }">
						<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
					</c:forEach>
				</c:url>
				<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가" onclick="goToUrl('${insertUrl}')"><i class="fa fa-plus"></i></button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
//검색조건 초기화
function fn_initialize(){
	$('#distrbSearchVo input[type="text"]').val('');
	$('#distrbSearchVo select').val('').attr('selected', 'selected');
}

//조회
function fn_selectDistrbList(){
	$('#distrbSearchVo').attr('target', '_self');
	$('#distrbSearchVo').attr('action', '<c:url var="select" value="selectDistrbList.do"/>');
	$('#distrbSearchVo').submit();
}

$("#disrbTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	                {sWidth : "40px" },//No
	                {sWidth : "110px" },//티켓번호
	                {sWidth : "80px" },//배포사유
	                {sWidth : "260px" },//배포내용
	                {sWidth : "180px" },//배포경로
	                {sWidth : "100px" },//가상서버구성ID
	                {sWidth : "70px" },//배포실행자
	                {sWidth : "100px" }//배포일시
	 ],
	order : [[0, "desc"]]
} );

//페이지 이동
function fn_goPage(page){
	location.href = "selectDistrbList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

function fn_goExcelDownload(){
	if("${distrbSearchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}
	goToUrl('${distrbListXlsDwnl}');
}
</script>