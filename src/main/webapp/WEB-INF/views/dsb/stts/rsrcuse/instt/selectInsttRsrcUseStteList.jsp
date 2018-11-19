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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
							<label title="년도" for="year">년도</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:select path="year" cssClass="form-control input-sm" title="년도">
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
				논리자원 할당량 목록
				<!-- <small>1 / 1, 총 1건</small>-->
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fnAsgn_excelDown()">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
			<table class="table table-vertical table-hover">
				<caption>논리자원 할당량 목록</caption>
				<colgroup>
					<col class="col4">
					<col class="col10">
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
						<th rowspan="3">No.</th>
						<th rowspan="3">부처</th>
						<th colspan="12">논리자원 할당량</th>
					</tr>
					<tr>
						<th colspan="4">vCore</th>
						<th colspan="4">MEM(GB)</th>
						<th colspan="4">SAN(GB)</th>
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
						<c:when test="${ listAsgn eq null or empty listAsgn }">
							<tr>
								<td colspan="13">
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
							<c:forEach var="vo" items="${listAsgn}" varStatus="ri">
								<tr>
									<td class="alignC"><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-ri.count)+1}" /></td>
									<td class="alignL"><c:out value="${vo.institutionNm }" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastVcoreQty1}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastVcoreQty2}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastVcoreQty3}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastVcoreQty4}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapa1}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapa2}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapa3}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapa4}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastStrgSumCapa1}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastStrgSumCapa2}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastStrgSumCapa3}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastStrgSumCapa4}" pattern="#,###" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->
		<!-- 			<div class="box-footer"></div> -->
	</div>
	<!-- /box -->

	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">
				가상서버 최빈시 자원 사용률 목록
				<!-- <small>1 / 1, 총 1건</small>-->
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fnMax_excelDown()">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>

		<div class="box-body no-padding list-body">
			<table class="table table-vertical table-hover">
				<caption>가상서버 최빈시 자원 사용률 목록</caption>
				<colgroup>
					<col class="col4">
					<col class="col10">
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
						<th rowspan="3">No.</th>
						<th rowspan="3">부처</th>
						<th colspan="12">가상서버 최빈시 자원 사용률 평균(%)</th>
					</tr>
					<tr>
						<th colspan="4">vCore</th>
						<th colspan="4">MEM</th>
						<th colspan="4">SAN</th>
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
						<c:when test="${ listMax eq null or empty listMax }">
							<tr>
								<td colspan="14">
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
							<c:forEach var="vo" items="${listMax}" varStatus="ri">
								<tr>
									<td class="alignC"><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-ri.count)+1}" /></td>
									<td class="alignL"><c:out value="${vo.institutionNm }" /></td>
									<td class="alignR"><c:out value="${vo.maxCpuUseRt1}" /></td>
									<td class="alignR"><c:out value="${vo.maxCpuUseRt2}" /></td>
									<td class="alignR"><c:out value="${vo.maxCpuUseRt3}" /></td>
									<td class="alignR"><c:out value="${vo.maxCpuUseRt4}" /></td>
									<td class="alignR"><c:out value="${vo.maxMemUseRt1}" /></td>
									<td class="alignR"><c:out value="${vo.maxMemUseRt2}" /></td>
									<td class="alignR"><c:out value="${vo.maxMemUseRt3}" /></td>
									<td class="alignR"><c:out value="${vo.maxMemUseRt4}" /></td>
									<td class="alignR"><c:out value="${vo.maxStrgUseRt1}" /></td>
									<td class="alignR"><c:out value="${vo.maxStrgUseRt2}" /></td>
									<td class="alignR"><c:out value="${vo.maxStrgUseRt3}" /></td>
									<td class="alignR"><c:out value="${vo.maxStrgUseRt4}" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</tbody>
			</table>
		</div>
		<!-- /box-body -->
		<!-- 		<div class="box-footer"></div> -->
	</div>
	<!-- /box -->

	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">
				자동확장 할당량 목록
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fnRxAsgn_excelDown()">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>

		<div class="box-body no-padding list-body">
			<table class="table table-vertical table-hover">
				<caption>자동확장 할당량 목록</caption>
				<colgroup>
					<col class="col4">
					<col class="col10">
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
						<th rowspan="3">No.</th>
						<th rowspan="3">부처</th>
						<th colspan="12">자동확장 할당량</th>
					</tr>
					<tr>
						<th colspan="4">CPU</th>
						<th colspan="4">MEM(GB)</th>
						<th colspan="4">스토리지(GB)</th>
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
						<c:when test="${ listRxAsgn eq null or empty listRxAsgn }">
							<tr>
								<td colspan="14">
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
							<c:forEach var="vo" items="${listRxAsgn}" varStatus="i">
								<tr>

									<td class="alignC"><c:out value="${(fn:length(listRxAsgn)-i.count)+1}" /></td>
									<td class="alignL"><c:out value="${vo.institutionNm }" /></td>
									<c:choose>
										<c:when test="${vo.cpuAsgnCapa1 eq 0 || vo.cpuAsgnCapa1 eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.cpuAsgnCapa1}" /></td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${vo.cpuAsgnCapa2 eq 0 || vo.cpuAsgnCapa2 eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.cpuAsgnCapa2}" /></td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${vo.cpuAsgnCapa3 eq 0 || vo.cpuAsgnCapa3 eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.cpuAsgnCapa3}" /></td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${vo.cpuAsgnCapa4 eq 0 || vo.cpuAsgnCapa4 eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.cpuAsgnCapa4}" /></td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.memTotCapa1 eq 0 || vo.memTotCapa1 eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.memTotCapa1}" /></td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${vo.memTotCapa2 eq 0 || vo.memTotCapa2 eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.memTotCapa2}" /></td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${vo.memTotCapa3 eq 0 || vo.memTotCapa3 eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.memTotCapa3}" /></td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${vo.memTotCapa4 eq 0 || vo.memTotCapa4 eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.memTotCapa4}" /></td>
										</c:otherwise>
									</c:choose>

										<c:choose>
										<c:when test="${vo.strgTotCapa1 eq 0 || vo.strgTotCapa1 eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.strgTotCapa1}" /></td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${vo.strgTotCapa2 eq 0 || vo.strgTotCapa2 eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.strgTotCapa2}" /></td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${vo.strgTotCapa3 eq 0 || vo.strgTotCapa3 eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.strgTotCapa3}" /></td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${vo.strgTotCapa4 eq 0 || vo.strgTotCapa4 eq '0.00' }">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.strgTotCapa4}" /></td>
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
		<!-- 		<div class="box-footer"></div> -->
	</div>
	<!-- /box -->

	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">
				자동확장 최빈시 자원 사용률 목록
				<!-- <small>1 / 1, 총 1건</small>-->
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fnRxMax_excelDown()">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>

		<div class="box-body no-padding list-body">
			<table class="table table-vertical table-hover">
				<caption>자동확장 최빈시 자원 사용률 목록</caption>
				<colgroup>
					<col class="col4">
					<col class="col10">
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
						<th rowspan="3">No.</th>
						<th rowspan="3">부처</th>
						<th colspan="12">자동확장 최빈시 자원 사용률 평균(%)</th>
					</tr>
					<tr>
						<th colspan="4">CPU</th>
						<th colspan="4">MEM</th>
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
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${ listRxMax eq null or empty listRxMax }">
							<tr>
								<td colspan="14">
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

							<c:forEach var="vo" items="${listRxMax}" varStatus="i">
								<tr>
									<td class="alignC"><c:out value="${(fn:length(listRxMax)-i.count)+1}" /></td>
									<td class="alignL"><c:out value="${vo.institutionNm }" /></td>
							<c:choose>
										<c:when test="${vo.maxCpuUseRt1 eq 0 || vo.maxCpuUseRt1 eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.maxCpuUseRt1}" /></td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${vo.maxCpuUseRt2 eq 0 || vo.maxCpuUseRt2 eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.maxCpuUseRt2}" /></td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${vo.maxCpuUseRt3 eq 0 || vo.maxCpuUseRt3 eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.maxCpuUseRt3}" /></td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${vo.maxCpuUseRt4 eq 0 || vo.maxCpuUseRt4 eq '0.00'}">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.maxCpuUseRt4}" /></td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${vo.maxMemUseRt1 eq 0 || vo.maxMemUseRt1 eq '0.00' }">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.maxMemUseRt1}" /></td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${vo.maxMemUseRt2 eq 0 || vo.maxMemUseRt2 eq '0.00' }">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.maxMemUseRt2}" /></td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${vo.maxMemUseRt3 eq 0 || vo.maxMemUseRt3 eq '0.00' }">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.maxMemUseRt3}" /></td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${vo.maxMemUseRt4 eq 0 || vo.maxMemUseRt4 eq 0.00 }">
											<td class="alignR"><c:out value="-" /></td>
										</c:when>
										<c:otherwise>
											<td class="alignR"><c:out value="${vo.maxMemUseRt4}" /></td>
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
		<!-- 		<div class="box-footer"></div> -->
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

		searchVo.action = '<c:url value="selectInsttRsrcUseStteList.do" />';
		searchVo.submit();
	}
	function fnAsgn_excelDown() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selectInsttRsrcUseStteAsgnXlsDown.do" />';
		searchVo.submit();
	}

	function fnMax_excelDown() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selectInsttRsrcUseStteMaxXlsDown.do" />';
		searchVo.submit();
	}
	function fnRxAsgn_excelDown(){
		var size ='${fn:length(listRxAsgn)}';
		if(size == 0 || size == 'undefined' || size == null){
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selectRxAsgnListXlsDown.do" />';
		searchVo.submit();
	}
	function fnRxMax_excelDown(){
		var size = '${fn:length(listRxMax)}';
		if(size == 0 || size == 'undefined' || size == null){
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selectRxMaxListXlsDown.do" />';
		searchVo.submit();
	}
</script>

