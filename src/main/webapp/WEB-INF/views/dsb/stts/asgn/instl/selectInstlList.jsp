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
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	<form:hidden path="rsrcPoolId" />

	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
	<div class="col-box-100 search-col">
		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<button type="button" class="btn btn-sm" data-toggle="collapse"
						data-target=".search-collapse">
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

					<div class="form-cell form-cell-25 col-lay-25">
						<div class="cell-title">
							<label title="자원풀코드 생성 연도" for="year">자원풀코드 생성 연도</label>
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
								<div class="input-group-cell">
									<div class="input-group">
										<form:select path="mm" cssClass="form-control input-sm" title="월">
											<c:forEach var="mmList" items="${mmList }">
												<form:option value="${mmList}">${mmList}월</form:option>
											</c:forEach>
										</form:select>
									</div>
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
					<button type="submit" class="btn btn-red">조회</button>
				</div>
			</div>
			<!-- /box-footer -->
		</div>
	</div>
</form:form>

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">
				검색결과<small></small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
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
		<div class="box-body no-padding list-body" style="overflow: hidden;">
			<table class="table table-hover table-vertical" id="instlTable">
				<caption>자원풀 구축 현황</caption>
				<colgroup>
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="col10">
					<col class="colAuto">
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>Zone</th>
						<th>망</th>
						<th>자원풀 코드</th>
						<th>가상화 SW</th>
						<th>최초 구축</th>
						<th>HW 종류</th>
					</tr>
					<tr>
				</thead>
				<tbody>

					<c:choose>
						<c:when test="${list eq null or empty list }">
							<tr>
								<td colspan="7">검색된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${list }" varStatus="i">
								<tr>
									<td class="alignC"><c:out value="${vo.rn}" /></td>
									<td class="alignL"><c:out value="${vo.zoneNm }" /></td>
									<td class="alignL"><c:out value="${vo.netNm }" /></td>
									<td class="alignL"><a href="" onclick="fn_View('<c:out value="${vo.rsrcPoolId }" />');return false;"><c:out value="${vo.rsrcPoolNm }" /></a></td>
									<td class="alignL"><c:out value="${vo.cdNm }" /></td>
									<td class="alignL"><c:out value="${vo.instlYear }" />년</td>
									<td class="alignL"><c:out value="${vo.hwKnd }" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->

		<div class="box-footer edit-btn-group">
			<div class="pull-left btns"></div>

			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertInstlView.do">
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

function fn_View(rsrcPoolId){

	var year = "${searchVo.year}";
	$('#year').val(year);
	$('#rsrcPoolId').val(rsrcPoolId);
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

	searchVo.action='<c:url value="insertInstlView.do" />';
	searchVo.submit();
}

//조회버튼 클릭시.
function fn_search() {
	//debugger;
	if(!fn_form_validation("searchVo")){

		return;
	}
	searchVo.action='<c:url value="selectInstlList.do" />';
	searchVo.submit();


}

function fn_excelDown(){
	if(${list eq null or empty list}) {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}
	searchVo.action='<c:url value="selectInstlXlsDown.do" />';
	searchVo.submit();

}

function fn_goToUrl(url){
	searchVo.action=url;
	$('#cmd').val('I');
	searchVo.submit();
}

</script>

