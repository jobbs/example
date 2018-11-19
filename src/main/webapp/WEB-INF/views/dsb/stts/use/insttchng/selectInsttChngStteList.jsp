<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     양정순         v1.0             최초생성
 *
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get" onsubmit="fn_search(); return false;">
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
							<label title="날짜" for="year">년도</label>
						</div>
						<div class="cell-body">
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
	</form:form>
</div>
<!-- /col -->

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">
				기관별 변동 현황 목록
				<!-- <small>1 / 1, 총 1건</small>-->
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_excelDown()">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
			<table class="table table-vertical table-hover table-layou-fixed">
				<caption>기관별 변동 현황 목록</caption>
				<colgroup>
					<col class="col5">
					<col class="col5">
					<col class="col18">
					<col class="col6">
					<col class="col6">
					<col class="col6">
					<col class="col6">
					<col class="col6">
					<col class="col6">
					<col class="col6">
					<col class="col6">
					<col class="col6">
					<col class="col6">
					<col class="col6">
					<col class="col6">
				</colgroup>
				<thead>
					<tr>
						<th rowspan="2">No</th>
						<th rowspan="2">센터</th>
						<th rowspan="2">부처명</th>
						<th colspan="4">업무수</th>
						<th colspan="4">가상서버수</th>
						<th colspan="4">서비스수</th>
					</tr>
					<tr>
						<th>1분기</th>
						<th>2분기</th>
						<th>3분기</th>
						<th>4분기</th>
						<th>1분기</th>
						<th>2분기</th>
						<th>3분기</th>
						<th>4분기</th>
						<th>1분기</th>
						<th>2분기</th>
						<th>3분기</th>
						<th>4분기</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${ list eq null or empty list }">
							<tr>
								<td colspan="15">
									<c:choose>
										<c:when
											test="${searchVo.search eq null or empty searchVo.search }">
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
							<c:forEach var="vo" items="${list}" varStatus="ri">
								<tr>
									<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-ri.count)+1}" /></td>
									<td class="align"><c:out value="${vo.regionNm }" /></td>
									<td class="alignL"><c:out value="${vo.institutionNm }" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.jobId1}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.jobId2}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.jobId3}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.jobId4}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.vmSeq1}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.vmSeq2}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.vmSeq3}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.vmSeq4}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.servcSeq1}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.servcSeq2}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.servcSeq3}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.servcSeq4}" pattern="#,###" /></td>
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
			<ul class="pagination"></ul>
			<div class="pull-right btns"></div>
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
	});

	function fn_search() {
		if (!fn_form_validation("searchVo")) {
			return;
		}

		searchVo.action = '<c:url value="selectInsttChngStteList.do" />';
		searchVo.submit();
	}

	function fn_excelDown() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selecInsttChngStteXlsDown.do" />';
		searchVo.submit();
	}
</script>

