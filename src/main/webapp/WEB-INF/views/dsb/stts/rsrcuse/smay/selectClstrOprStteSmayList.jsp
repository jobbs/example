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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>




<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get" onsubmit="fn_search(); return false;">
		<input type="hidden" name="search" value="T">

		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
					</button>
				</div>
			</div>
			<!-- /box-header -->
			<div class="box-body collapse in search-collapse">
				<div class="form-group">
					<div class="form-cell form-cell-25 col-lay-25">
						<div class="cell-title">
							<label title="년도" for="year">년도</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:select path="year" cssClass="form-control input-sm">
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
				물리/가상 자원풀 운영 현황 목록
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
			<table class="table table-vertical table-hover">
				<caption>물리/가상 자원풀 운영 현황 목록</caption>
				<colgroup>
					<col class="colAuto">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
				</colgroup>
				<thead>
					<tr>
						<th rowspan="2" colspan="2">구분</th>
						<th colspan="3">계</th>
						<th colspan="3">대전</th>
						<th colspan="3">광주</th>
					</tr>
					<tr>
						<th>보유량</th>
						<th>할당량</th>
						<th>할당률(%)</th>
						<th>보유량</th>
						<th>할당량</th>
						<th>할당률(%)</th>
						<th>보유량</th>
						<th>할당량</th>
						<th>할당률(%)</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${ list eq null or empty list }">
							<tr>
								<td colspan="11">
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
									<c:if test="${ri.count == 1 }">
										<td rowspan="4" class="alignL"><c:out value="${vo.yy }" /></td>
									</c:if>
									<td class="alignL"><c:out value="${vo.gubun }" /></td>
										<c:choose>
										<c:when test="${vo.totHold eq 0 || vo.totHold eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><fmt:formatNumber value="${vo.totHold}" pattern="#,###" /></td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.totAsgn eq 0 || vo.totAsgn eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><fmt:formatNumber value="${vo.totAsgn}" pattern="#,###" /></td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.totAsgnRt eq 0 || vo.totAsgnRt eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><fmt:formatNumber value="${vo.totAsgnRt}" pattern="#,###.##" /></td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.djHold eq 0 || vo.djHold eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><fmt:formatNumber value="${vo.djHold}" pattern="#,###" /></td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.djAsgn eq 0 || vo.djAsgn eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><fmt:formatNumber value="${vo.djAsgn}" pattern="#,###" /></td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.djAsgnRt eq 0 || vo.djAsgnRt eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><fmt:formatNumber value="${vo.djAsgnRt}" pattern="#,###.##" /></td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.gjHold eq 0 || vo.gjHold eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><fmt:formatNumber value="${vo.gjHold}" pattern="#,###" /></td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.gjAsgn eq 0 || vo.gjAsgn eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><fmt:formatNumber value="${vo.gjAsgn}" pattern="#,###" /></td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.gjAsgnRt eq 0 || vo.gjAsgnRt eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><fmt:formatNumber value="${vo.gjAsgnRt}" pattern="#,###.##" /></td>
										</c:otherwise>
									</c:choose>
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
		</div>
	</div>
	<!-- /box -->
</div>
<!-- /col -->

<!-- /col -->

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">
				자동확장 자원풀 운영 현황 목록
				<!-- <small>1 / 1, 총 1건</small>-->
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_excelRsAutoDown()">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
			<table class="table table-vertical table-hover">
				<caption>자동확장 자원풀 운영 현황 목록</caption>
				<colgroup>
					<col class="colAuto">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
					<col class="col9">
				</colgroup>
				<thead>
					<tr>
						<th rowspan="2" colspan="2">구분</th>
						<th colspan="3">계</th>
						<th colspan="3">대전</th>
						<th colspan="3">광주</th>
					</tr>
					<tr>
						<th>보유량</th>
						<th>할당량</th>
						<th>할당률(%)</th>
						<th>보유량</th>
						<th>할당량</th>
						<th>할당률(%)</th>
						<th>보유량</th>
						<th>할당량</th>
						<th>할당률(%)</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${ rsList eq null or empty rsList }">
							<tr>
								<td colspan="11">
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
							<c:forEach var="vo" items="${rsList}" varStatus="ri">
								<tr>
									<c:if test="${ri.count == 1 }">
										<td rowspan="4" class="alignL"><c:out value="${vo.yy }" /></td>
									</c:if>
									<td class="alignL"><c:out value="${vo.gubun }" /></td>
									<c:choose>
										<c:when test="${vo.totAtmsclNode eq 0 || vo.totAtmsclNode eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><fmt:formatNumber value="${vo.totAtmsclNode}" pattern="#,###" /></td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.totPodQtyAsgn eq 0 || vo.totPodQtyAsgn eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR">${vo.totPodQtyAsgn}</td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.totAtmsclNodeRt eq 0 || vo.totAtmsclNodeRt eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><fmt:formatNumber value="${vo.totAtmsclNodeRt}" pattern="#,###.##" /></td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.djAtmsclNode eq 0 || vo.djAtmsclNode eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><fmt:formatNumber value="${vo.djAtmsclNode}" pattern="#,###" /></td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.djPodAsgn eq 0 || vo.djPodAsgn eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR">${vo.djPodAsgn}</td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.djAtmsclNodeRt eq 0 || vo.djAtmsclNodeRt eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><fmt:formatNumber value="${vo.djAtmsclNodeRt}" pattern="#,###.##" /></td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.gjAtmsclNode eq 0 || vo.gjAtmsclNode eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><fmt:formatNumber value="${vo.gjAtmsclNode}" pattern="#,###" /></td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.gjPodAsgn eq 0 || vo.gjPodAsgn eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR">${vo.gjPodAsgn}</td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.gjAtmsclNodeRt eq 0 || vo.gjAtmsclNodeRt eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><fmt:formatNumber value="${vo.gjAtmsclNodeRt}" pattern="#,###.##" /></td>
										</c:otherwise>
									</c:choose>
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
		</div>
	</div>
	<!-- /box -->
</div>
<!-- /col -->



<script type="text/javascript">
	function fn_search() {
		if (!fn_form_validation("searchVo")) {
			return;
		}

		searchVo.action = '<c:url value="selectClstrOprStteSmayList.do" />';
		searchVo.submit();
	}

	function fn_excelDown() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selectClstrOprStteSmayXlsDown.do" />';
		searchVo.submit();
	}
	function fn_excelRsAutoDown() {
		if ("${fn:length(rsList)}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selectClstrOprStteSmayRsAutoXlsDown.do" />';
		searchVo.submit();
	}
</script>

