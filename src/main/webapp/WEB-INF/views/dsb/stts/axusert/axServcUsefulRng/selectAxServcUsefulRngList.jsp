<%--
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 08. 4.
 * @lastmodified 2017. 08. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 08. 4.     양정순         v1.0             최초생성
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


<div class="col-box-100 search-col">
	<form:form commandName="searchVo" name="frm" id="frm" method="post">
		<input type="hidden" name="search" value="T">

		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<!-- 접기 버튼 -->
					<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
					</button>
				</div>
			</div>
			<!-- /box-header -->
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
							<label title="날짜" for="year">날짜</label>
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
			<!-- /box-body -->
			<div class="box-footer collapse in search-collapse">
				<div class="pull-left">
					<button type="reset" class="btn">초기화</button>
				</div>
				<div class="pull-right">
					<button onclick="javascript:fn_search();return false;" class="btn btn-red ">조회</button>
				</div>
			</div>
			<!-- /box-footer -->
		</div>
		<!-- /box(검색조건) -->
	</form:form>
</div>
<!-- /col -->

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">
				Core수 및 MEM(GB)용량별 서비스수
				<!-- <small>1 / 1, 총 1건</small>-->
			</h3>
			<div class="box-tools">
				<div class="pull-right">
					<button class="btn btn-sm btn-function" onclick="fn_excelDown();" data-toggle="tooltip" title="" data-original-title="엑셀다운로드">
						<i class="fa fa-download"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
			<table class="table table-vertical table-bordered table-layout-fixed">
				<caption>Core수 및 MEM(GB)용량별 서비스수</caption>
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
				</colgroup>
				<thead>
					<tr>
						<th rowspan="2" colspan="2">서비스 수</th>
						<th colspan="9">MEM(GB)</th>
					</tr>
					<tr>

						<th>8</th>
						<th>16</th>
						<th>24</th>
						<th>32</th>
						<th>48</th>
						<th>64</th>
						<th>128</th>
						<th>기타</th>
						<th>계</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${ memCntList eq null or empty memCntList }">
							<tr>
								<td class="alignC" colspan="10"><c:choose>
										<c:when test="${searchVo.search eq null or empty searchVo.search }">
						          			조회 버튼을 클릭해 주시기 바랍니다.
						               </c:when>
										<c:otherwise>
					               			검색된 데이터가 없습니다.
					            		</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${memCntList}" varStatus="ri">

								<tr>
									<c:if test="${ri.count == 1 }">
										<td rowspan="10" class="alignL">Core</td>
									</c:if>
									<td class="alignR"><c:out value="${vo.lastVcoreQty }" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapa8}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapa16}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapa24}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapa32}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapa48}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapa64}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapa128}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapaetc}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.total}" pattern="#,###" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- 			    <div class="box-footer"></div> -->
	</div>

	<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
	<!-- box(목록조회 테이블) -->
	<div class="box list-box">

		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">
				스토리지(TB)용량별 서비스수
				<!-- <small>1 / 1, 총 1건</small>-->
			</h3>
			<div class="box-tools">
				<div class="pull-right"></div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
			<table class="table table-vertical table-bordered">
				<caption>스토리지(TB)용량별 서비스수</caption>
				<colgroup>
					<col class="col12">
					<col class="col12">
					<col class="col12">
					<col class="col12">
					<col class="col12">
					<col class="col12">
					<col class="col12">
				</colgroup>
				<thead>
					<tr>
						<th rowspan="3">서비스 수</th>
						<th colspan="7">스토리지(TB)</th>
					</tr>
					<tr>

						<th>0.5이하</th>
						<th>1</th>
						<th>1-2</th>
						<th>2-4</th>
						<th>4-8</th>
						<th>8초과</th>
						<th>계</th>
					</tr>
					<c:choose>
						<c:when test="${ sanCntList eq null or empty sanCntList }">
							<tr>
								<td class="alignC" colspan="7"><c:choose>
										<c:when test="${searchVo.search eq null or empty searchVo.search }">
					           				조회 버튼을 클릭해 주시기 바랍니다.
					       				</c:when>
										<c:otherwise>
					           				검색된 데이터가 없습니다.
					   					</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${sanCntList}" varStatus="ri">
								<tr>

									<td class="alignR"><fmt:formatNumber value="${vo.lastStrgSumCapa0}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastStrgSumCapa1}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastStrgSumCapa2}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastStrgSumCapa3}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastStrgSumCapa4}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastStrgSumCapa}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.total}" pattern="#,###" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</thead>
			</table>
		</div>
		<!-- 			    <div class="box-footer"></div> -->
	</div>

	<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
	<!-- box(목록조회 테이블) -->
	<div class="box list-box">

		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">
				Core수 및 MEM(GB)용량별 서비스 비율
				<!-- <small>1 / 1, 총 1건</small>-->
			</h3>
			<div class="box-tools">
				<div class="pull-right"></div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
			<table class="table table-vertical table-bordered">
				<caption>Core수 및 MEM(GB)용량별 서비스 비율</caption>
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
				</colgroup>
				<thead>
					<tr>
						<th rowspan="2" colspan="2">비율(%)</th>
						<th colspan="9">MEM(GB)</th>
					</tr>
					<tr>
						<th>8</th>
						<th>16</th>
						<th>24</th>
						<th>32</th>
						<th>48</th>
						<th>64</th>
						<th>128</th>
						<th>기타</th>
						<th>계</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${ memCntRtList eq null or empty memCntRtList }">
							<tr>
								<td class="alignC" colspan="10"><c:choose>
										<c:when test="${searchVo.search eq null or empty searchVo.search }">
						           			조회 버튼을 클릭해 주시기 바랍니다.
						        		</c:when>
										<c:otherwise>
					               			검색된 데이터가 없습니다.
					            		</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${memCntRtList}" varStatus="ri">
								<tr>
									<c:if test="${ri.count == 1 }">
										<td rowspan="10" class="alignL">Core</td>
									</c:if>
									<td class="alignR"><c:out value="${vo.lastVcoreQty }" /></td>
									<td class="alignR"><c:out value="${vo.lastMemSumCapa8}" /></td>
									<td class="alignR"><c:out value="${vo.lastMemSumCapa16}" /></td>
									<td class="alignR"><c:out value="${vo.lastMemSumCapa24}" /></td>
									<td class="alignR"><c:out value="${vo.lastMemSumCapa32}" /></td>
									<td class="alignR"><c:out value="${vo.lastMemSumCapa48}" /></td>
									<td class="alignR"><c:out value="${vo.lastMemSumCapa64}" /></td>
									<td class="alignR"><c:out value="${vo.lastMemSumCapa128}" /></td>
									<td class="alignR"><c:out value="${vo.lastMemSumCapaetc}" /></td>
									<td class="alignR"><c:out value="${vo.total}" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</tbody>
			</table>
		</div>
		<!-- 			    <div class="box-footer"></div> -->
	</div>

	<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
	<!-- box(목록조회 테이블) -->
	<div class="box list-box">

		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">
				스토리지(TB)용량별 서비스 비율
				<!-- <small>1 / 1, 총 1건</small>-->
			</h3>
			<div class="box-tools">
				<div class="pull-right"></div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
			<table class="table table-vertical table-bordered">
				<caption>스토리지(TB)용량별 서비스 비율</caption>
				<colgroup>
					<col class="col12">
					<col class="col12">
					<col class="col12">
					<col class="col12">
					<col class="col12">
					<col class="col12">
					<col class="col12">
				</colgroup>
				<thead>
					<tr>
						<th rowspan="3">비율(%)</th>
						<th colspan="7">스토리지(TB)</th>
					</tr>
					<tr>


						<th>0.5이하</th>
						<th>1</th>
						<th>1-2</th>
						<th>2-4</th>
						<th>4-8</th>
						<th>8초과</th>
						<th>계</th>
					</tr>
					<c:choose>
						<c:when test="${ sanCntRtList eq null or empty sanCntRtList }">
							<tr>
								<td class="alignC" colspan="7">
									<c:choose>
										<c:when test="${searchVo.search eq null or empty searchVo.search }">
					           				조회 버튼을 클릭해 주시기 바랍니다.
					       				</c:when>
										<c:otherwise>
					              			검색된 데이터가 없습니다.
					       				</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${sanCntRtList}" varStatus="ri">
								<tr>

									<td class="alignR"><c:out value="${vo.lastStrgSumCapa0}" /></td>
									<td class="alignR"><c:out value="${vo.lastStrgSumCapa1}" /></td>
									<td class="alignR"><c:out value="${vo.lastStrgSumCapa2}" /></td>
									<td class="alignR"><c:out value="${vo.lastStrgSumCapa3}" /></td>
									<td class="alignR"><c:out value="${vo.lastStrgSumCapa4}" /></td>
									<td class="alignR"><c:out value="${vo.lastStrgSumCapa}" /></td>
									<td class="alignR"><c:out value="${vo.total}" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->
		<!-- 			    <div class="box-footer"></div> -->
	</div>
	<!-- /box(목록조회 테이블) -->
</div>
<!-- /col -->

<!-- 페이지 버튼 영역 -->
<!-- /페이지 버튼 영역 -->


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

//조회버튼 클릭시.
function fn_search() {
	$("#frm").attr("target", "_self");
	$("#frm").attr("action", "<c:url value='selectAxServcUsefulRngList.do'/>");
	$("#frm").submit();
	return false;
}

function fn_excelDown(userData){

	if(${memCntList eq null or empty memCntList}) {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}

	$("#frm").attr("target", "_self");
	$("#frm").attr("action", "<c:url value='selectAxServcUsefulRngXlsDown.do'/>");
	$("#frm").submit();
	return false;

}
</script>

