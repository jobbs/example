<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 4.
 * @lastmodified 2016. 12. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 4.     양정순         v1.0             최초생성
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

<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>
<form:form commandName="searchVo" method="get" onsubmit="fn_search(); return false;">
	<input type="hidden" name="search" value="T">
	<input type="hidden" name="cmd" id="cmd">
	<input type="hidden" name="regionId" id="regionId">

	<div class="col-box-100 search-col">

		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
		<form:hidden path="institutionId" />
		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기"></i>
					</button>
				</div>
			</div>

			<div class="box-body collapse in search-collapse">
				<div class="form-group">
					<div class="form-cell form-cell-50 col-lay-50">
						<div class="cell-title">
							<label title="센터" for="region">센터</label>
						</div>
						<div class="cell-body">
							<div class="input-group input-group-check">
								<form:checkbox path="region" label="전체" value="regionAll" title="센터선택" id="regionAll" cssClass="essentialBy" essentialBy="region" />
								<c:forEach var="regionVo" items="${regionVoList }">
									<form:checkbox cssClass="region essentialBy" path="region" title="센터선택" label="${regionVo.regionNm }" value="${regionVo.regionId}" essentialBy="region" />
								</c:forEach>
							</div>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="부처명" for="institutionNm">부처명</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:input type="text" path="institutionNm" cssClass="form-control input-sm " title="부처명" readonly="true" />
								<div class="input-group-btn">
									<button class="btn btn-sm" onclick="openInsttSearch(); return false;">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="년도" for="year">년도</label>
						</div>
						<div class="cell-body">
							<div class="input-group-box">
								<div class="input-group-cell pad-right-5">
									<div class="input-group">
										<form:select path="year" cssClass="form-control input-sm" title="연도">
											<c:forEach var="yearVo" items="${yearCdList }">
												<form:option value="${yearVo.cd}">
													<c:out value="${yearVo.cdNm }" />
												</form:option>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="cell-title">
									<label title="분기" for="quarter"></label>
								</div>
								<div class="input-group-cell">
									<div class="input-group">
										<form:select path="quarter" cssClass="form-control input-sm">
											<form:option value="">전체</form:option>
											<form:option value="1">1분기</form:option>
											<form:option value="2">2분기</form:option>
											<form:option value="3">3분기</form:option>
											<form:option value="4">4분기</form:option>
										</form:select>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="box-footer collapse in search-collapse">
					<div class="table-btn pull-left">
						<button type="reset" class="btn btn-default">초기화</button>
					</div>
					<div class="pull-right">
						<button type="submit" class="btn btn-red ">조회</button>
					</div>
				</div>
				<!-- /box-footer -->
			</div>

		</div>
	</div>
</form:form>
<div class="col-box-100 search-col">
	<div class="box list-box">

		<div class="box-header">
			<h3 class="box-title">
				검색결과<small> ${searchVo.paginationInfo.currentPageNo } /
					${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }" />
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_excelDown();">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /box-header -->

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical">
				<caption>기관별 자원 회수 현황</caption>
				<colgroup>
					<col class="col3">
					<col class="colAuto">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
					<col class="col7">
				</colgroup>
				<thead>
					<tr>
						<th rowspan="2">번호</th>
						<th rowspan="2">기관명</th>
						<th colspan="4">반납요구량</th>
						<th colspan="4">반납량</th>
						<th colspan="4">반납률(%)</th>
					</tr>
					<tr>
						<th>가상서버</th>
						<th>vCore</th>
						<th>MEM</th>
						<th>SAN</th>
						<th>가상서버</th>
						<th>vCore</th>
						<th>MEM</th>
						<th>SAN</th>
						<th>가상서버</th>
						<th>vCore</th>
						<th>MEM</th>
						<th>SAN</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${list eq null or empty list }">
							<tr>
								<td colspan="14">검색된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${list }" varStatus="i">
								<tr>
									<td class="alignC"><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
									<td class="alignL"><a href="" onclick="fn_View('<c:out value="${vo.institutionId }" />');return false;"><c:out value="${vo.institutionNm }" /></a></td>
									<td class="alignR"><c:out value="${vo.returnReqQtyVm }" /></td>
									<td class="alignR"><c:out value="${vo.returnReqQtyVcore }" /></td>
									<td class="alignR"><c:out value="${vo.returnReqQtyMem }" /></td>
									<td class="alignR"><c:out value="${vo.returnReqQtySan }" /></td>
									<td class="alignR"><c:out value="${vo.returnQtyVm }" /></td>
									<td class="alignR"><c:out value="${vo.returnQtyVcore }" /></td>
									<td class="alignR"><c:out value="${vo.returnQtyMem }" /></td>
									<td class="alignR"><c:out value="${vo.returnQtySan }" /></td>
									<td class="alignR"><c:out value="${vo.returnRtVm }" /></td>
									<td class="alignR"><c:out value="${vo.returnRtVcore }" /></td>
									<td class="alignR"><c:out value="${vo.returnRtMem }" /></td>
									<td class="alignR"><c:out value="${vo.returnRtSan }" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
			<div class="pull-left btns"></div>
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertWthdrwStPerInstView.do">
					</c:url>
					<button class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가" onclick="fn_goToUrl('${insertUrl}')">
						<i class="fa fa-plus"></i>
					</button>
				</menu:authorize>
			</div>

			<!-- 			<div class="pull-right btns"> -->
			<%-- 				<menu:authorize> --%>
			<!-- 					<button class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="엑셀 다운로드" onclick="excelDown();"><i class="fa fa-download"></i></button> -->
			<%-- 				</menu:authorize> --%>
			<!-- 			</div> -->
		</div>
		<!-- /box-footer -->
	</div>
	<!-- /box(목록조회 테이블) -->
</div>
<!-- /col -->

<script type="text/javascript">
$(document).ready(function() {


	$('#regionAll').click(function() {

		$('.region').prop('checked', $(this).is(":checked"));
	});
	<c:if test="${searchVo.search eq null or empty searchVo.search }">
		$('#regionAll').trigger('click');
	</c:if>
	$('.region').click(function() {
		if ($('.region:checked').length == $('.region').length) {
			$('#regionAll').prop('checked', true);
		} else {
			$('#regionAll').prop('checked', false);
		}
	});

});

function fn_View(institutionId){

	var year = "${searchVo.year}";
	$('#year').val(year);

	$('#institutionId').val(institutionId);

	$('#cmd').val('U');

	var regions=[];
	<c:forEach var="region" items="${searchVo.region }">
		regions.push('${region}')
	</c:forEach>
	$('[name=region').each(function(){
		for(var i=0;i<=regions.length;i++){
			if(this.value==regions[i]){
				this.checked=true;
			}
		}
	});

	searchVo.action='<c:url value="insertWthdrwStPerInstView.do" />';
	searchVo.submit();
}
//조회버튼 클릭시.
function fn_search() {
	//debugger;
	if(!fn_form_validation("searchVo")){

		return;
	}
	searchVo.action='<c:url value="selectWthdrwStPerInstList.do" />';
	searchVo.submit();


}

function goPage(page){
	location.href = "selectWthdrwStPerInstList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

$(document).bind('selectInstitution',fn_setInstitution);//부처팝업 function설정
function fn_setInstitution(obj) {

	var instt = obj.datas;
	$('#institutionId').val(instt.institutionId);
	$('#institutionNm').val(instt.institutionNm);

}

function fn_excelDown(){
	if(${list eq null or empty list}) {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}
	searchVo.action='<c:url value="selectWthdrwStPerInstXlsDown.do" />';
	searchVo.submit();
}

function fn_goToUrl(url){
	searchVo.action=url;
	$('#cmd').val('I');
	searchVo.submit();
}
</script>

