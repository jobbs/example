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
										<form:select path="year" cssClass="form-control input-sm"
											title="연도">
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
				자원 보유 및 할당 현황 목록
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
					<table class="table table-vertical table-hover">
						<caption>자원 보유 및 할당 현황 목록-자원풀별</caption>
						<colgroup>
							<col class="col3">
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
							<col class="col6">
							<col class="col6">
							<col class="col6">
						</colgroup>
						<thead>
							<tr>
								<th rowspan="2">No.</th>
								<th rowspan="2">자원풀<br>코드
								</th>
								<th rowspan="2">클러스터수</th>
								<th rowspan="2">클러스터</th>
								<th colspan="4">물리자원 보유량</th>
								<th colspan="4">논리자원 할당량</th>
								<th rowspan="2">서버<br>가상화율<br>(%)
								</th>
								<th colspan="3">자원 할당률(%)</th>
							</tr>
							<tr>
								<th>서버수</th>
								<th>Core</th>
								<th>MEM<br>(GB)
								</th>
								<th>SAN<br>(GB)
								</th>
								<th>가상<br>서버수
								</th>
								<th>vCore</th>
								<th>MEM(GB)</th>
								<th>SAN(GB)</th>
								<th>CPU</th>
								<th>MEM</th>
								<th>SAN(GB)</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${ list eq null or empty list }">

									<tr>
										<td colspan="16">
										   <c:choose>
											 <c:when test="${searchVo.search eq null or empty searchVo.search }">
								              조회 버튼을 클릭해 주시기 바랍니다.
								        	 </c:when>
											<c:otherwise>
							                 검색된 데이터가 없습니다.
							            	</c:otherwise>
										</c:choose></td>
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
											<td class="alignR"><fmt:formatNumber value="${vo.vmLastAsgnStrgCapa}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.vrlzRt}" pattern="#,###.#" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.vcoreRt}" pattern="#,###.#" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.memRt}" pattern="#,###.#" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.sanRt}" pattern="#,###.#" /></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>

						</tbody>
					</table>
				</c:if>
				<c:if test="${searchVo.dtlGubun == 'sumy'}">

					<table class="table table-vertical table-hover">
						<caption>자원 보유 및 할당 현황 목록-클러스터별</caption>
						<colgroup>
							<col class="col3">
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
							<col class="col6">
							<col class="col6">
						</colgroup>
						<thead>
							<tr>
								<th rowspan="2">No.</th>
								<th rowspan="2">자원풀<br>코드
								</th>
								<th rowspan="2">클러스터수</th>
								<th colspan="4">물리자원 보유량</th>
								<th colspan="4">논리자원 할당량</th>
								<th rowspan="2">서버<br>가상화율<br>(%)
								</th>
								<th colspan="3">자원 할당률(%)</th>
							</tr>
							<tr>
								<th>서버수</th>
								<th>Core</th>
								<th>MEM<br>(GB)
								</th>
								<th>SAN<br>(GB)
								</th>
								<th>가상<br>서버수
								</th>
								<th>vCore</th>
								<th>MEM(GB)</th>
								<th>SAN(GB)</th>
								<th>CPU</th>
								<th>MEM</th>
								<th>SAN(GB)</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${ list eq null or empty list }">
									<tr>
										<td colspan="15">
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
											<td class="alignR"><fmt:formatNumber value="${vo.pmSeq}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastCpuCorQty}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapa}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastStrgSumCapa}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastVSrvrQty}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastAsgnVcorQty}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastAsgnMemCapa}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.vmLastAsgnStrgCapa}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.vrlzRt}" pattern="#,###.#" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.vcoreRt}" pattern="#,###.#" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.memRt}" pattern="#,###.#" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.sanRt}" pattern="#,###.#" /></td>
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

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">
				자동확장-자원 보유 및 할당현황 목록
				<!-- <small>1 / 1, 총 1건</small>-->
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_excelDownAx()">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
					<table class="table table-vertical table-hover">
						<caption>자동확장-자원 보유 및 할당현황 목록</caption>
						<colgroup>
							<col class="colAuto">
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
							<col class="col6">
							<col class="col6">
							<col class="col6">
							<col class="col6">
							<col class="col6">
							<col class="col6">
						</colgroup>
						<thead>
							<tr>
								<th rowspan="2">No.</th>
								<th rowspan="2">자원풀</th>
								<th colspan="4">자원 보유량(노드 영역)</th>
								<th colspan="3">자원 할당량(서비스 영역)</th>
								<th colspan="2">자원 할당률(%)</th>
								<th colspan="3">자원 사용량(POD 영역)</th>
								<th colspan="2">노드 자원 사용률(%)</th>
								<th colspan="3">쿼타 자원 사용률(%)</th>
							</tr>
							<tr>
								<th>서버수<br>(A)</th><!--자원 보유량-->
								<th>Core<br>(B)</th>
								<th>MEM(GB)<br>(C)</th>
								<th>스토리지(GB)<br>(D)</th>
								<th>POD수<br>(E)</th><!--자원 할당량-->
								<th>Core<br>(F)</th>
								<th>MEM(GB)<br>(G)</th>
								<th>CPU<br>(H=F/B*100)</th><!--자원 할당률(%)-->
								<th>MEM<br>(I=G/C*100)</th>
								<th>POD수<br>(J)</th><!--자원 사용량-->
								<th>Core<br>(K)</th>
								<th>MEM(GB)<br>(L)</th>
								<th>CPU<br>(M=K/B*100)</th><!--노드 자원 사용률(%)-->
								<th>MEM<br>(N=L/C*100)</th>
								<th>POD<br>(O=J/E*100)</th><!--쿼타 자원 사용률(%)-->
								<th>CPU<br>(P=K/F*100)</th>
								<th>MEM<br>(Q=L/G*100)</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${ axList eq null or empty axList }">
									<tr>
										<td colspan="19">
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
									<c:forEach var="vo" items="${axList}" varStatus="ri">
										<tr>
											<td class="alignC"><c:out value="${axList.size()+1-(ri.count)}" /></td>
											<td class="alignL"><c:out value="${vo.rsrcPoolNm }" /></td>
											<td class="alignR"><c:out value="${vo.nodeQty}" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.cpuCorQty}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.memTotCapa}" pattern="#,###.##" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.strgTotCapa}" pattern="#,###.##" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.quotaPodQty}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.quotaCpuCorQty}" pattern="#,###.##" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.quotaMemTotCapa}" pattern="#,###.##" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.asgnCpuRt}" pattern="#,###.##" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.asgnMemRt}" pattern="#,###.##" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.lastPodQty}" pattern="#,###" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.cpuUseCapa}" pattern="#,###.##" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.memUseCapa}" pattern="#,###.##" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.nodeUseCpuRt}" pattern="#,###.##" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.nodeUseMemRt}" pattern="#,###.##" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.quotaUsePodRt}" pattern="#,###.##" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.quotaUseCpuRt}" pattern="#,###.##" /></td>
											<td class="alignR"><fmt:formatNumber value="${vo.quotaUseMemRt}" pattern="#,###.##" /></td>
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

		searchVo.action = '<c:url value="selectRsrcAsgnStteClstrList.do" />';
		searchVo.submit();
	}

	function fn_excelDown() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selectRsrcAsgnStteClstrXlsDown.do" />';
		searchVo.submit();
	}
	function fn_excelDownAx() {
		if ("${axList}" == '[]') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selectRsrcAsgnStteClstrAxXlsDown.do" />';
		searchVo.submit();
	}
</script>

