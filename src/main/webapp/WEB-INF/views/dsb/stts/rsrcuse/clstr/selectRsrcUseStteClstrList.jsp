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
					<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
					</button>
				</div>
			</div>
			<!-- /box-header -->
			<div class="box-body collapse in search-collapse">
				<div class="form-group">
					<div class="form-cell form-cell-35 col-lay-35">
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

					<div class="form-cell form-cell-40 col-lay-40">
						<div class="cell-title">
							<label title="자원풀별/클러스터별" for="dtlGubun">자원풀별/클러스터별</label>
						</div>
						<div class="cell-body">
							<div class="input-group input-group-radio">
								<form:radiobutton path="dtlGubun" label="간략(자원풀별 합계)" value="sumy" id="radio-option-a" checked="checked" title="간략(자원풀별 합계)" />
								<form:radiobutton path="dtlGubun" label="상세(클러스터별)" id="radio-option-b" value="dtl" title="상세(클러스터별)" />
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
				자원사용 현황 목록
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
			<c:if
				test="${searchVo.dtlGubun ne null and !empty searchVo.dtlGubun}">
				<c:if test="${searchVo.dtlGubun == 'dtl'}">

					<table class="table table-hover table-vertical table-layout-fixed">
						<caption>자원 사용 현황- 클러스터별 상세</caption>
						<colgroup>
							<col width="40px">
							<col width="150px">
							<col width="70px">
							<col width="80px">
							<col width="50px">
							<col width="50px">
							<col width="50px">
							<col width="50px">
							<col width="50px">
							<col width="50px">
							<col width="50px">
							<col width="60px">
							<col width="60px">
							<col width="60px">
							<col width="60px">
							<col width="70px">
							<col width="70px">
							<col width="70px">
							<col width="70px">
							<col width="70px">
							<col width="70px">
							<col width="70px">
							<col width="70px">
						</colgroup>
						<thead>
							<tr>
								<th rowspan="3">No.</th>
								<th rowspan="3">자원풀<br>(명칭)
								</th>
								<th rowspan="3">클러스터수</th>
								<th rowspan="3">클러스터</th>
								<th colspan="4">물리자원 보유량</th>
								<th colspan="4">논리자원 할당량</th>
								<th colspan="4">자동확장 할당량</th>
								<th colspan="7">최빈시 자원 사용률(%) 평균</th>
							</tr>
							<tr>
								<th rowspan="2">서버수</th>
								<th rowspan="2">Core</th>
								<th rowspan="2">MEM<br>(GB)
								</th>
								<th rowspan="2">SAN<br>(GB)
								</th>
								<th rowspan="2">가상<br>서버수
								</th>
								<th rowspan="2">vCore</th>
								<th rowspan="2">MEM<br>(GB)
								</th>
								<th rowspan="2">SAN<br>(GB)
								</th>
								<th rowspan="2">서비스수
								</th>
								<th rowspan="2">Core
								</th>
								<th rowspan="2">MEM<br>(GB)
								</th>
								<th rowspan="2">스토리지<br>(GB)
								</th>
								<th colspan="2">물리서버</th>
								<th colspan="3">가상서버</th>
								<th colspan="2">자동확장</th>
							</tr>
							<tr>
								<th>CPU</th>
								<th>MEM</th>
								<th>CPU</th>
								<th>MEM</th>
								<th>SAN</th>
								<th>CPU</th>
								<th>MEM</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${ list eq null or empty list }">
									<tr>
										<td colspan="23">
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
											<td class="alignC"><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-ri.count)+1}" /></td>
											<td class="alignL"><c:out value="${vo.rsrcPoolNm }" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.clstrSeq}" pattern="#,###" /></td>
											<td class="alignL"><c:out value="${vo.clstrNm }" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.pmSeq}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastCpuCorQty}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapa}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastStrgSumCapa}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastVSrvrQty}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastAsgnVcorQty}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastAsgnMemCapa}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastAsgnStrgCapa}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.autoLastServc}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.autoLastCoreQty}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.autoLastMemCapa}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.autoLastStrgCpa}" pattern="#,###" /></td>
											<td class="alignR"><c:out value="${vo.maxCpuUseRt}" /></td>
											<td class="alignR"><c:out value="${vo.maxMemUseRt}" /></td>
											<td class="alignR"><c:out value="${vo.vmMaxCpuUseRt}" /></td>
											<td class="alignR"><c:out value="${vo.vmMaxMemUseRt}" /></td>
											<td class="alignR"><c:out value="${vo.vmMaxStrgUseRt}" /></td>
											<td class="alignR"><c:out value="${vo.autoMaxCpuUseRt}" /></td>
											<td class="alignR"><c:out value="${vo.autoMaxMemUseRt}" /></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</c:if>
				<c:if test="${searchVo.dtlGubun == 'sumy'}">
					<table class="table table-hover table-vertical table-layout-fixed">
						<caption>자원 사용 현황- 클러스터별 간략</caption>
						<colgroup>
							<col width="40px">
							<col width="150px">
							<col width="70px">
							<col width="50px">
							<col width="50px">
							<col width="50px">
							<col width="50px">
							<col width="50px">
							<col width="50px">
							<col width="50px">
							<col width="50px">
							<col width="60px">
							<col width="60px">
							<col width="60px">
							<col width="60px">
							<col width="70px">
							<col width="70px">
							<col width="70px">
							<col width="70px">
							<col width="70px">
							<col width="70px">
							<col width="70px">
						</colgroup>
						<thead>
							<tr>
								<th rowspan="3">No.</th>
								<th rowspan="3">자원풀<br>코드
								</th>
								<th rowspan="3">클러스터수</th>
								<th colspan="4">물리자원 보유량</th>
								<th colspan="4">논리자원 할당량</th>
								<th colspan="4">자동확장 할당량</th>
								<th colspan="7">최빈시 자원 사용률(%) 평균</th>
							</tr>
							<tr>
								<th rowspan="2">서버수</th>
								<th rowspan="2">Core</th>
								<th rowspan="2">MEM<br>(GB)
								</th>
								<th rowspan="2">SAN<br>(GB)
								</th>
								<th rowspan="2">가상<br>서버수
								</th>
								<th rowspan="2">vCore</th>
								<th rowspan="2">MEM<br>(GB)
								</th>
								<th rowspan="2">SAN<br>(GB)
								</th>
								<th rowspan="2">서비스수
								</th>
								<th rowspan="2">Core
								</th>
								<th rowspan="2">MEM<br>(GB)
								</th>
								<th rowspan="2">스토리지<br>(GB)
								</th>
								<th colspan="2">물리서버</th>
								<th colspan="3">가상서버</th>
								<th colspan="2">자동확장</th>
							</tr>
							<tr>
								<th>CPU</th>
								<th>MEM</th>
								<th>CPU</th>
								<th>MEM</th>
								<th>SAN</th>
								<th>CPU</th>
								<th>MEM</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${ list eq null or empty list }">
									<tr>
										<td colspan="22">
											<c:choose>
												<c:when	test="${searchVo.search eq null or empty searchVo.search }">
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
											<td class="alignC"><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-ri.count)+1}" /></td>
											<td class="alignL"><c:out value="${vo.rsrcPoolNm }" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.clstrSeq}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.pmSeq}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastCpuCorQty}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapa}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastStrgSumCapa}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastVSrvrQty}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastAsgnVcorQty}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastAsgnMemCapa}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastAsgnStrgCapa}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.autoLastServc}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.autoLastCoreQty}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.autoLastMemCapa}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.autoLastStrgCpa}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.maxCpuUseRt}" pattern="#,##0.0" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.maxMemUseRt}" pattern="#,##0.0" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.vmMaxCpuUseRt}" pattern="#,##0.0" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.vmMaxMemUseRt}" pattern="#,##0.0" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.vmMaxStrgUseRt}" pattern="#,##0.0" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.autoMaxCpuUseRt}" pattern="#,##0.0" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.autoMaxMemUseRt}" pattern="#,##0.0" /></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</c:if>
			</c:if>
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

		searchVo.action = '<c:url value="selectRsrcUseStteClstrList.do" />';
		searchVo.submit();
	}

	function fn_excelDown() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}

		searchVo.action = '<c:url value="selectRsrcUseStteClstrXlsDown.do" />';
		searchVo.submit();
	}
</script>

