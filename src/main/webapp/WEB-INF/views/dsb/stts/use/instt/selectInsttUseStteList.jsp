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
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

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
									<form:checkbox cssClass="region essentialBy" title="센터선택" path="region" label="${regionVo.regionNm }" value="${regionVo.regionId}" essentialBy="region" />
								</c:forEach>
							</div>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-50">
						<div class="cell-title">
							<label title="기간" for="trm">기간</label>
						</div>
						<div class="cell-body">
							<div class="input-group-box">
								<div class="input-group-cell pad-right-5">
									<div class="input-group">
										<div class="input-group input-group-radio">
											<form:radiobutton path="trm" label="월" value="mm" id="radio-option-a" checked="checked" title="월" data-name="trm1" />
											<form:radiobutton path="trm" label="분기" id="radio-option-b" value="quarter" title="분기" data-name="trm2" />
											<form:radiobutton path="trm" label="연도" id="radio-option-c" value="yy" title="연도" data-name="trm3" />
										</div>
									</div>
								</div>
								<div class="input-group-cell">
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
				기관별 이용 현황 목록 <small>총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">

					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_excelDown()">
							<i class="fa fa-download"></i>
						</button>

						<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".vm-collapse">
							<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body collapse in vm-collapse">
			<table class="table table-vertical table-hover">
				<caption>기관별 이용 현황 목록(가상서버)</caption>
				<colgroup>
					<!--
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
					-->
					<col class="col4">
					<col class="col5">
					<col class="col8">
					<col class="col8">
					<col class="col9">
					<col class="col10">
					<col class="col10">
					<col class="col10">
					<col class="col5">
					<col class="col5">
					<col class="col8">
					<col class="col8">
					<col class="col8">
				</colgroup>
				<thead>
					<tr>
						<th rowspan="3">No.</th>
						<th rowspan="3">센터</th>
						<th rowspan="3">기간</th>
						<th rowspan="3">부처명</th>
						<th colspan="2">이용업무</th>
						<th colspan="4">가상서버</th>
						<th colspan="3">논리자원 할당량</th>
					</tr>
					<tr>
						<th rowspan="2">이용업무수</th>
						<th rowspan="2">비율(%)</th>
						<th rowspan="2">가상서버수</th>
						<th rowspan="2">비율(%)</th>
						<th colspan="2">업무당 가상서버수</th>
						<th rowspan="2">vCore</th>
						<th rowspan="2">MEM(GB)</th>
						<th rowspan="2">SAN(GB)</th>
					</tr>
					<tr>
						<th>최소</th>
						<th>최대</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${ list eq null or empty list }">
							<tr>
								<td colspan="12">
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
							<c:forEach var="vo" items="${list}" varStatus="ri">
								<tr>
									<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-ri.count)+1}" /></td>
									<td class="alignC"><c:out value="${vo.regionNm }" /></td>
									<td><c:out value="${vo.mm }" /></td>
									<td class="alignL"><c:out value="${vo.institutionNm }" /></td>
									<td class="alignR"><c:out value="${vo.jobId }" /></td>
									<td class="alignR"><c:out value="${vo.jobPer }" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.vmSeq}" pattern="#,####" /></td>
									<td class="alignR"><c:out value="${vo.vmPer}" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.jobMin}" pattern="#,####" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.jobMax}" pattern="#,####" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastVcoreQty}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapa}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastStrgSumCapa}" pattern="#,###" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</tbody>
			</table>
		</div>
		<!-- /box-body -->
		<!-- box-footer -->

	</div>
	<!-- /box -->
</div>
<!-- /col -->



<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">
				기관별 이용 현황 목록(자동확장)
				<small>총
					<c:choose>
						<c:when test="${atmSclList eq null or empty atmSclList}">
							0건 </small>
						</c:when>
						<c:otherwise>
							${atmSclList.size()}건 </small>
						</c:otherwise>
					</c:choose>
			</h3>

			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_atmSclExcelDown()">
							<i class="fa fa-download"></i>
						</button>

						<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".atmscl-collapse">
							<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body collapse in atmscl-collapse">
			<table class="table table-vertical table-hover">
				<caption>기관별 이용 현황 목록</caption>
				<colgroup>
					<col class="col4">
					<col class="col5">
					<col class="col8">
					<col class="col8">
					<col class="col9">
					<col class="col10">
					<col class="col10">
					<col class="col10">
					<col class="col5">
					<col class="col5">
					<col class="col8">
					<col class="col8">
					<col class="col8">
				</colgroup>
				<thead>
					<tr>
						<th rowspan="3">No.</th>
						<th rowspan="3">센터</th>
						<th rowspan="3">기간</th>
						<th rowspan="3">부처명</th>
						<th colspan="2">이용업무</th>
						<th colspan="4">서비스영역</th>
						<th colspan="3">Pod 할당량</th>
					</tr>
					<tr>
						<th rowspan="2">이용업무수</th>
						<th rowspan="2">비율(%)</th>
						<th rowspan="2">서비스영역수</th>
						<th rowspan="2">비율(%)</th>
						<th colspan="2">업무당 서비스영역수</th>
						<th rowspan="2">Core</th>
						<th rowspan="2">MEM(GB)</th>
						<th rowspan="2">STORAGE(GB)</th>
					</tr>
					<tr>
						<th>최소</th>
						<th>최대</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${ atmSclList eq null or empty atmSclList }">
							<tr>
								<td colspan="12">
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
							<c:forEach var="vo" items="${atmSclList}" varStatus="ri">
								<tr>
									<td><c:out value="${atmSclList.size()+1-(ri.count)}" /></td>
									<td class="alignC"><c:out value="${vo.regionNm }" /></td>
									<td><c:out value="${vo.mm }" /></td>
									<td class="alignL"><c:out value="${vo.institutionNm }" /></td>
									<td class="alignR"><c:out value="${vo.jobId }" /></td>
									<td class="alignR"><c:out value="${vo.jobPer }" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.servcAreaSeq}" pattern="#,####" /></td>
									<td class="alignR"><c:out value="${vo.servcAreaPer}" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.jobMin}" pattern="#,####" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.jobMax}" pattern="#,####" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.cpuAsgnCapa}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.memTotCapa}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.strgTotCapa}" pattern="#,###" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</tbody>
			</table>
		</div>
		<!-- /box-body -->
		<!-- box-footer -->
	</div>
	<!-- /box -->
</div>

<script type="text/javascript">
	function goPage(page) {
		location.href = "selectInsttUseStteList.do?paginationInfo.currentPageNo="
				+ page + "&${listParam}";
	}

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

		searchVo.action = '<c:url value="selectInsttUseStteList.do" />';
		searchVo.submit();
	}

	function fn_excelDown() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selectInsttUseStteXlsDown.do" />';
		searchVo.submit();
	}


	function fn_atmSclExcelDown() {

		if ("${atmSclList}" == '' ) {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}

		searchVo.action = '<c:url value="selectInsttUseStteAtmSclXlsDown.do" />';
		searchVo.submit();
	}

</script>



