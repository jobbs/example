<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     이화영         v1.0             최초생성
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
		<form:form commandName="searchVo" method="get">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
		<!-- box-body -->
		<div class="box-body collapse in search-collapse">
			<div class="form-group">

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchRegionId" title="센터">센터</label>
					</div>
					<%-- <div class="cell-body">
					 	<form:select path="searchRegionId" title="센터" cssClass="form-control input-sm" onchange="selectNetCh(this, 'searchNetId' )" >
							<form:option value="">전체</form:option>
							<c:forEach var="regionVo" items="${regionVoList}">
								<form:option value="${regionVo.regionId}"><c:out value="${regionVo.regionNm }"/></form:option>
							</c:forEach>
						</form:select>
					</div> --%>
					<div class="cell-body">
						<nform:selectRegion name="searchRegionId" id="searchRegionId" cssClass="form-control input-sm" title="센터" value="${searchVo.searchRegionId}" onchange="selectRepositCh(this, 'searchRepositId' )" whole="true" />
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchNetClCd" title="망구분">망구분</label>
					</div>
					<div class="cell-body">
						<form:select path="searchNetClCd" title="망구분" cssClass="form-control input-sm" onchange="selectRepositCh(this, 'searchRepositId' )" >
							<c:forEach var="netVo" items="${netVoList}">
								<form:option value="${netVo.cd}"><c:out value="${netVo.cdNm }"/></form:option>
							</c:forEach>
						</form:select>
					</div>
					<%-- <div class="cell-body">
							<form:select path="searchNet" value="${netCd.cd}" id="${netCd.cd}" cssClass="form-control input-sm"  title="망">
							<c:forEach var="netCd" items="${netList }">
								<form:option value="${netCd.cd }" title="망"><c:out value="${netCd.cdNm}"/></form:option>
							</c:forEach>
							</form:select>
						</div> --%>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchRepositId" title="레파지토리">레파지토리</label>
					</div>
					<div class="cell-body">
						<form:select path="searchRepositId" title="레파지토리" cssClass="form-control input-sm" >
							<form:option value="">전체</form:option>
							<c:forEach var="repositVo" items="${repositVoList}">
								<form:option value="${repositVo.repositId}"><c:out value="${repositVo.repositNm }"/></form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchPackgNm" title="패키지명">패키지명</label>
					</div>
					<div class="cell-body">
						<form:input path="searchPackgNm" title="패키지명" cssClass="form-control input-sm" value=""/>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchVer" title="버전">버전</label>
					</div>
					<div class="cell-body">
						<form:input path="searchVer" title="버전" cssClass="form-control input-sm" value=""/>
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-100 col-lay-50">
	            	<div class="cell-title"><label for="searchStartRegDt" title="등록일자">등록일자</label></div>
		            <div class="cell-body">
						<div class="input-group period period-start">
		              		<form:input path="searchStartRegDt" cssClass="form-control input-sm pull-right datepicker" title="등록 시작일자" onchange="initDate(this, 'searchEndRegDt', 'S')" />
		              	</div>
		              	<div class="input-group period period-end">
							<form:input path="searchEndRegDt" cssClass="form-control input-sm pull-right datepicker" title="등록 종료일자" onchange="initDate(this, 'searchStartRegDt', 'E')" />
		              	</div>
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
		  	<c:url var="selectVmListUrl" value="selectVmList.do"/>
		    <button type="button" class="btn btn-red pull-right" onclick="fn_selectPackgList();">조회</button>
		  </div>
		</div>
		</form:form>
	</div>
</div>

<!-- 그리드 영역 -->
<div class="col-box-100 search-col">
	<div class="box list-box">
		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">검색결과<small>
				${searchVo.paginationInfo.currentPageNo } /
				${searchVo.paginationInfo.totalPageCount },
				총 ${searchVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/>
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_selectPackgListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>
		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table id="packgTable" class="table table-hover table-vertical table-layout-fixed">
				<caption>패키지관리 목록</caption>
				<thead>
					<tr>
						<th><nobr>No.</nobr></th>
						<th><nobr>센터</nobr></th>
						<th><nobr>망구분</nobr></th>
						<th><nobr>레파지토리</nobr></th>
						<th><nobr>패키지명</nobr></th>
						<!-- <th><nobr>내용</nobr></th> -->
						<th><nobr>버전</nobr></th>
						<th><nobr>릴리즈</nobr></th>
						<th><nobr>등록일자</nobr></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="packgVo" items="${packgVoList }" varStatus="i">
						<c:url var="detailUrl" value="selectPackg.do">
							<c:param name="packgSeq" value="${packgVo.packgSeq }" />
							<c:param name="packgNm" value="${packgVo.packgNm }" />
							<c:param name="ver" value="${packgVo.ver }" />
							<c:param name="release" value="${packgVo.release }" />
							<c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach>
						</c:url>
						<tr>
							<td><nobr><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${packgVo.regionNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${packgVo.netNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${packgVo.repositNm }" /></nobr></td>
							<td class="alignL"><nobr><a href="<c:url value="${detailUrl }" />" title="<c:out value="${packgVo.packgNm }"/>"><c:out value="${packgVo.packgNm }" /></a></nobr></td>
							<%-- <td class="alignL"><nobr><a href="<c:url value="${detailUrl }" />" title="<c:out value="${packgVo.packgNm }"/>"><c:out value="${cf:ellipsis(packgVo.packgCn, 80) }" /></a></nobr></td> --%>
							<td class="alignL"><nobr><c:out value="${packgVo.ver }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${packgVo.release }" /></nobr></td>
							<td><nobr><c:out value="${packgVo.regDt }" /></nobr></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
		</div>
	</div>
</div>
<script type="text/javascript">
//검색조건 초기화
function fn_initialize(){
	$('#searchVo input[type="text"]').val('');
	$('#searchVo select').val('').attr('selected', 'selected');
	//$("#searchNetId > option:eq(0)").nextAll().remove();
	//$("#searchRepositId > option:eq(0)").nextAll().remove();
}

//조회
function fn_selectPackgList(){
	$('#searchVo').attr('target', '_self');
	$('#searchVo').attr('action', '<c:url var="select" value="selectPackgList.do"/>');
	$('#searchVo').submit();
}

//페이지 이동
function fn_goPage(page){
	location.href = "selectPackgList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}


$("#packgTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	            {sWidth : "40px" },//No
	            {sWidth : "40px" },//센터
	            {sWidth : "60px" },//망구분
	            {sWidth : "100px" },//레파지토리
	            {sWidth : "150px" },//패키지명
	            {sWidth : "80px" },//버전
	            {sWidth : "80px" },//릴리즈
	            {sWidth : "100px" }//등록일자
	],
	order : [[0, "desc"]]
} );

/* function selectNetCh(source, target) {
	var url = contextPath+'/cpt/opr/patch/packg/selectPackgNetList.do';
	var val = $(source).val();

	$.get(url, { "regionId" : val }, function(result) {
		if( result.success) {
			var datas = result.data;
			$("#" + target + " > option").remove();

			//create Option
			for(var i = 0; i < datas.length; i++ ) {
				$("#" + target).append("<option value='" + datas[i].cd + "'>" + datas[i].cdNm + "</option>");
			}
			$("#" + target).change();
		}
	}, "json");
} */

function selectRepositCh(source, target) {
	var url = contextPath+'/cpt/opr/patch/packg/selectPackgRepositList.do';
	var netClCd = $("#searchNetClCd").val();
	var regionId = $("#searchRegionId").val();

	if( netClCd != "" || regionId!= "" ) {
		$.get(url, { "searchRegionId" : regionId, "searchNetClCd" : netClCd }, function(result) {
			if( result.success) {
				var datas = result.data;

				$("#" + target + " > option:eq(0)").nextAll().remove();

				//create Option
				if( datas != null ) {
					for(var i = 0; i < datas.length; i++ ) {
						$("#" + target).append("<option value='" + datas[i].repositId + "'>" + datas[i].repositNm + "</option>");
					}
				}
				$("#" + target).change();
			}
		}, "json");
	}else{
		$("#" + target + " > option:eq(0)").nextAll().remove();
		$("#" + target).change();
	}
}

//목록의 정보를 Excel로 다운로드 한다.
function fn_selectPackgListXlsDwnl() {
	if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}
	$('#searchVo').attr('target', '_self');
	$('#searchVo').attr('action', '<c:url value="selecthPackgListXlsDwnl.do"/>');
	$('#searchVo').submit();
}



/*
function selectRepositoryDy(source, region) {

	var url = contextPath+'/cpt/opr/patch/packg/selectPackgRepositList.do';
	var val = $(source).val();
	var regionId = $("#" + region).val();
	$.get(url, { "regionId" : regionId ,"netId" : val }, function(result) {
		if( result.success) {
			var datas = result.data;

			$("#searchRepositId > option:eq(0)").nextAll().remove();

			//create Option
			for(var i = 0; i < datas.length; i++ ) {
				$("#searchRepositId").append("<option value='" + datas[i].repositId + "'>" + datas[i].repositNm + "</option>");
			}

			$("#searchRepositId").change();
		}
	}, "json");
} */
</script>