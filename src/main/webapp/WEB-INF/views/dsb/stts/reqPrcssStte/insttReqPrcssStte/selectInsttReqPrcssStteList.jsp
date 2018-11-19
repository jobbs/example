<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 09. 29.
 * @lastmodified 2016. 09. 29.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 09. 29.     양정순         v1.0             최초생성
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
<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>
<form:form commandName="searchVo" method="get" onsubmit="fn_search(); return false;">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
	<form:hidden path="paginationInfo.currentPageNo" id="currentPageNo" />
	<div class="col-box-100 search-col">
		<form:hidden path="institutionId" />
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
					<div class="form-cell form-cell-50 col-lay-35">
						<div class="cell-title">
							<label title="센터" for="region">센터</label>
						</div>
						<div class="cell-body">
							<div class="input-group input-group-check">
								<form:checkbox path="region" label="전체" value="regionAll" title="센터선택" id="regionAll" cssClass="essentialBy" essentialBy="region" />
								<c:forEach var="regionVo" items="${regionVoList }">
									<form:checkbox cssClass="region essentialBy" path="region" label="${regionVo.regionNm }" value="${regionVo.regionId}" essentialBy="region" />
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
							<label>검색기간</label>
						</div>
						<div class="cell-body">
							<div class="input-group-box">
								<div class="input-group-cell pad-right-5" id="divYY">
									<div class="">
										<form:select path="year" cssClass="form-control input-sm" title="년도">
											<c:forEach var="yearVo" items="${yearCdList }">
												<form:option value="${yearVo.cd}">
													<c:out value="${yearVo.cdNm }" />
												</form:option>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="input-group-cell pad-right-5" id="divMM">
									<div class="">
										<form:select path="searchMmCd" cssClass="form-control input-sm" title="월">
											<form:option value="01">1월</form:option>
											<form:option value="02">2월</form:option>
											<form:option value="03">3월</form:option>
											<form:option value="04">4월</form:option>
											<form:option value="05">5월</form:option>
											<form:option value="06">6월</form:option>
											<form:option value="07">7월</form:option>
											<form:option value="08">8월</form:option>
											<form:option value="09">9월</form:option>
											<form:option value="10">10월</form:option>
											<form:option value="11">11월</form:option>
											<form:option value="12">12월</form:option>
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
					<button type="submit" class="btn btn-red ">조회</button>
				</div>
			</div>
			<!-- /box-footer -->
		</div>
		<!-- /box(검색조건) -->

	</div>
	<!-- /col -->
</form:form>
<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">
				기관별 요청 처리 현황 <small>${searchVo.paginationInfo.currentPageNo }
					/ ${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }" />
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_excelDown()">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>

			</div>
		</div>
		<div class="box-body no-padding list-body">
			<table class="table table-vertical table-hover" id="tableCludReqPrcss">
				<caption>기관별 요청 처리 현황</caption>
				<thead>
					<tr>
						<th>기관명</th>
						<th>계</th>
						<th>가상서버 생성</th>
						<th>가상서버 삭제</th>
						<th>스펙변경</th>
						<th>SAN 추가</th>
						<th>SAN 회수</th>
					</tr>

				</thead>
				<tbody>
					<c:choose>
						<c:when test="${ list eq null or empty list }">
							<c:choose>
								<c:when test="${searchVo.search eq null or empty searchVo.search }">
									<tr>
										<td colspan="7">조회 버튼을 클릭해 주시기 바랍니다.</td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="7">검색된 데이터가 없습니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${list}" varStatus="ri">
								<tr>
									<td class="alignL"><c:out value="${vo.institutionNm }" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.tot}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.vmCreateQty}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.vmRemoveQty}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.specUpdateQty}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.sanAddQty}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.withdrawQty}" pattern="#,###" /></td>
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
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
			<div class="pull-right btns">
				<!-- <button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="엑셀다운로드" onclick="excelDown();"><i class="fa fa-arrow-down"></i></button> -->
			</div>
		</div>
	</div>
	<!-- /box -->
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

		var autoColumns = [ {
			sWidth : "100px"
		}, {
			sWidth : "60px"
		}, {
			sWidth : "60px"
		}, {
			sWidth : "60px"
		}, {
			sWidth : "60px"
		}, {
			sWidth : "60px"
		}, {
			sWidth : "60px"
		}, ];
		<c:if test="${ not empty list }">
		$("#tableCludReqPrcss").DataTable({
			dom : 'Zlfrtip',
			paging : false,
			searching : false,
			info : false,
			bAutoWidth : false,
			aoColumns : autoColumns,
			order : [ [ 1, "asc" ] ]
		});
		</c:if>

	});

	function fn_search() {
		if (!fn_form_validation("searchVo")) {
			return;
		}

		searchVo.action = '<c:url value="selectInsttReqPrcssStteList.do" />';
		searchVo.submit();
	}

	function fn_excelDown() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selectInsttReqPrcssStteListXlsDown.do" />';
		searchVo.submit();
	}
	$(document).bind('selectInstitution', fn_setInstitution);//부처팝업 function설정
	function fn_setInstitution(obj) {

		var instt = obj.datas;
		$('#institutionId').val(instt.institutionId);
		$('#institutionNm').val(instt.institutionNm);

	}
	function goPage(page) {
		$('#currentPageNo').val(page);
		searchVo.action = '<c:url value="selectInsttReqPrcssStteList.do" />';
		searchVo.submit();
	}
</script>
