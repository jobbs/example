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
					<i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기" data-original-title="접어두기"></i>
				</button>
			</div>
		</div>

		<form:form commandName="mngmObjVmSearchVo" method="get">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
		<form:hidden path="searchInsttId" id="searchInsttId"/>
		<!-- box-body -->
		<div class="box-body collapse in search-collapse">

			<div class="form-group">

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="센터">센터</label>
					</div>
					<div class="cell-body">
						<nform:selectRegion name="searchRegionId" id="searchRegionId" cssClass="form-control input-sm" byRole="false" title="센터" value="${mngmObjVmSearchVo.searchRegionId}" whole="true" />
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="망구분">망구분</label>
					</div>
					<div class="cell-body">
						<form:select path="searchNetClCd" value="${netCd.cd}" id="${netCd.cd}" cssClass="form-control input-sm" title="망구분" >
							<c:forEach var="netCd" items="${netList }">
								<form:option value="${netCd.cd }"><c:out value="${netCd.cdNm}"/></form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="부처">부처</label>
					</div>
					<div class="cell-body">
						<div class="input-group">
							<form:input name="searchInsttNm" path="searchInsttNm" title="부처명/업무" value="${mngmObjVmSearchVo.searchInsttNm }" cssClass="form-control input-sm essential" maxlength="30" placeholder="부처를 선택해주세요." readonly="true" />
							<menu:authorize>
								<div class="input-group-btn"><button type="button" class="btn btn-sm" title="부처검색" onclick="fn_selectInsttList()"><i class="fa fa-search"></i></button></div>
							</menu:authorize>
						</div>
					</div>
				</div>


			</div>

		</div>

		<!-- box-footer -->
		<div class="box-footer collapse in search-collapse">
		  <div class="pull-left">
		    <button type="button" class="btn" title="초기화" onclick="fn_initialize();">초기화</button>
		  </div>
		  <div class="pull-right">
		  	<c:url var="selectPmListUrl" value="selectMngmObjVmList.do">
			</c:url>
		    <button type="button" class="btn btn-red pull-right" title="조회" onclick="fn_selectMngmObjVmList();">조회</button>
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
				${mngmObjVmSearchVo.paginationInfo.currentPageNo } /
				${mngmObjVmSearchVo.paginationInfo.totalPageCount },
				총 ${mngmObjVmSearchVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="mngmObjVmSearchVo" value="${mngmObjVmSearchVo }"/>
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="엑셀다운로드" data-original-title="엑셀다운로드" onclick="fn_selectMngmObjVmListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table id="mngmObjVmTable" class="table table-hover table-vertical table-layout-fixed">
			<caption>대상관리 가상서버 목록 테이블</caption>
				<thead>
					<tr>
						<th><nobr>No.</nobr></th>
						<th><nobr>센터</nobr></th>
						<th><nobr>망구분</nobr></th>
						<th><nobr>부처</nobr></th>
						<th><nobr>관리대상 가상서버수</nobr></th>
						<th><nobr>전체 가상서버수</nobr></th>
				</thead>
				<tbody>
					<c:forEach var="mngmObjVmVo" items="${mngmObjVmVoList }" varStatus="i">
						<c:url var="selectMngmObjVmUrl" value="selectMngmObjVm.do">
							<c:param name="insttId" value="${mngmObjVmVo.insttId }" />
							<c:param name="netClCd" value="${mngmObjVmVo.netClCd }" />
							<c:param name="regionId" value="${mngmObjVmVo.regionId }" />
							<c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach>
						</c:url>
						<tr>
							<td><c:out value="${(mngmObjVmSearchVo.paginationInfo.totalRecordCount-mngmObjVmSearchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
							<td class="alignL"><nobr><c:out value="${mngmObjVmVo.regionNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${mngmObjVmVo.netNm }" /></nobr></td>
							<td class="alignL"><nobr>
								<c:choose>
									<c:when test="${mngmObjVmVo.insttNm ne null && mngmObjVmVo.insttNm ne ''}">
										<a href="<c:url value="${selectMngmObjVmUrl }" />" title="<c:out value="${mngmObjVmVo.insttNm }"/>"><c:out value="${mngmObjVmVo.insttNm }" /></a>
									</c:when>
									<c:otherwise>
										<c:out value="미할당" />
									</c:otherwise>
								</c:choose>
							</nobr></td>
							<td class="alignR"><nobr><c:out value="${mngmObjVmVo.mngmVmCnt }" /></nobr></td>
							<td class="alignR"><nobr><c:out value="${mngmObjVmVo.vmCnt }" /></nobr></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${mngmObjVmSearchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
		</div>

	</div>

</div>


<script type="text/javascript">

//부처선택 호출 (팝업)
function fn_selectInsttList(){
	var url = contextPath+'/cmn/component/instt/selectInsttListP.do';
	var params = {"searchType" : "S"};
	var args = {key:"SelectInstt", width:740,height:820};
	windowOpen(url, params, args);
}

$(document).bind('selectInstitution',setInstitution);
function setInstitution(evt) {
	var val = evt.datas;
	$('#mngmObjVmSearchVo input[name="searchInsttNm"]').val(val.institutionNm);
	$('#mngmObjVmSearchVo input:hidden[id="searchInsttId"]').val(val.institutionId);
}

//검색조건 초기화
function fn_initialize(){
	$('#mngmObjVmSearchVo input[type="text"]').val('');
	$('#mngmObjVmSearchVo select').val('').attr('selected', 'selected');
	$('#mngmObjVmSearchVo input[name="searchInsttNm"]').val('');
	$('#mngmObjVmSearchVo input:hidden[id="searchInsttId"]').val('');
}

// 조회
function fn_selectMngmObjVmList(){
	$('#mngmObjVmSearchVo').attr('target', '_self');
	$('#mngmObjVmSearchVo').attr('action', '<c:url var="select" value="selectMngmObjVmList.do"/>');
	$('#mngmObjVmSearchVo').submit();
}

// 페이지 이동
function fn_goPage(page){
	location.href = '<c:url value="selectMngmObjVmList.do"/>?paginationInfo.currentPageNo=' + page + '&${listParam}';
}

// 목록의 정보를 Excel로 다운로드 한다.
function fn_selectMngmObjVmListXlsDwnl() {
	if("${mngmObjVmSearchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("다운로드 할 데이터가 없습니다.");
		return;
	}
	$('#mngmObjVmSearchVo').attr('target', '_self');
	$('#mngmObjVmSearchVo').attr('action', '<c:url value="selectMngmObjVmListXlsDwnl.do"/>');
	$('#mngmObjVmSearchVo').submit();
}

$("#mngmObjVmTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	                {sWidth : "89px" },
	                {sWidth : "100px" },
	                {sWidth : "100px" },
	                {sWidth : "244px" },
	                {sWidth : "113px" },
	                {sWidth : "94px" }
	 ],

	order : [[0, "desc"]]
});

</script>