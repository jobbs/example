<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     김동훈         v1.0             최초생성
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
	<form:form commandName="searchVo" method="get">
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
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion name="regionId" id="regionId" title="센터" cssClass="form-control input-sm" byRole="false" value="${searchVo.regionId}" whole="true" />
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>년도</label>
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

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>월</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:select path="month" cssClass="form-control input-sm" title="월">
									<form:option value="">전체</form:option>
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
									<form:option value="1Q">1분기</form:option>
									<form:option value="2Q">2분기</form:option>
									<form:option value="3Q">3분기</form:option>
									<form:option value="4Q">4분기</form:option>
								</form:select>
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
					<button type="submit" class="btn btn-red " onclick="fn_search()">조회</button>
				</div>
			</div>
			<!-- /box-footer -->
		</div>
	</form:form>
</div>

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">
				검색결과<small></small>
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
			<table class="table table-hover table-vertical">
				<caption>자원 사용률 목록</caption>
				<colgroup>
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
						<th rowspan="2" colspan="2">가상서버 수</th>
						<th colspan="12">자원 사용률(%)</th>
					</tr>
					<tr>
						<th>계</th>
						<th>10%이하</th>
						<th>20%이하</th>
						<th>30%이하</th>
						<th>40%이하</th>
						<th>50%이하</th>
						<th>60%이하</th>
						<th>70%이하</th>
						<th>80%이하</th>
						<th>90%이하</th>
						<th>100%이하</th>
						<th>미수집</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${sanUseRtList eq null or empty sanUseRtList }">
							<c:if test='${searchVo.regionId eq null }'>
								<tr>
									<td colspan="14">조회 버튼을 클릭하시기 바랍니다.</td>
								</tr>
							</c:if>
							<c:if test='${searchVo.regionId ne null }'>
								<tr>
									<td colspan="14">검색된 데이터가 없습니다.</td>
								</tr>
							</c:if>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${sanUseRtList }" varStatus="status1">
								<tr>
									<c:if test="${status1.index == 0 }">
										<td rowspan="10">SAN(TB)</td>
									</c:if>
									<td>
										<c:choose>
											<c:when test="${vo.capa eq '999' }">기타</c:when>
											<c:otherwise>
												<c:out value="${vo.capa }" />
											</c:otherwise>
										</c:choose>
									</td>
									<td class="alignR"><fmt:formatNumber value="${vo.total}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt10}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt20}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt30}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt40}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt50}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt60}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt70}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt80}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt90}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt100}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRtNull}" pattern="#,###" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>

	<div class="box list-box">
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical">
				<caption>최빈시 자원 사용률 목록</caption>
				<colgroup>
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
						<th rowspan="2" colspan="2">가상서버 수</th>
						<th colspan="12">최빈시 자원 사용률(%)</th>
					</tr>
					<tr>
						<th>계</th>
						<th>10%이하</th>
						<th>20%이하</th>
						<th>30%이하</th>
						<th>40%이하</th>
						<th>50%이하</th>
						<th>60%이하</th>
						<th>70%이하</th>
						<th>80%이하</th>
						<th>90%이하</th>
						<th>100%이하</th>
						<th>미수집</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${topSanUseRtList eq null or empty topSanUseRtList }">
							<c:if test='${searchVo.regionId eq null }'>
								<tr>
									<td colspan="14">조회 버튼을 클릭하시기 바랍니다.</td>
								</tr>
							</c:if>
							<c:if test='${searchVo.regionId ne null }'>
								<tr>
									<td colspan="14">검색된 데이터가 없습니다.</td>
								</tr>
							</c:if>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${topSanUseRtList }" varStatus="status">
								<tr>
									<c:if test="${status.index == 0 }">
										<td rowspan="10">SAN(TB)</td>
									</c:if>
									<td>
										<c:choose>
											<c:when test="${vo.capa eq '999' }">기타</c:when>
											<c:otherwise>
												<c:out value="${vo.capa }" />
											</c:otherwise>
										</c:choose>
									</td>
									<td class="alignR"><fmt:formatNumber value="${vo.total}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt10}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt20}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt30}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt40}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt50}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt60}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt70}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt80}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt90}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRt100}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.useRtNull}" pattern="#,###" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script type="text/javascript">
	function fn_excelDown() {
		searchVo.action = '<c:url value="selectSanUseRtXlsDown.do" />';
		searchVo.submit();
	}
	function fn_search() {
		searchVo.action = '<c:url value="selectSanUseRtList.do" />';
		searchVo.submit();
	}
</script>