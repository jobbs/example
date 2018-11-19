<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     양정순         v1.0             최초생성
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
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>

<script>


	$(document).bind('selectInstitutionMulti',setInstitutions);
	function setInstitutions(evt) {
		var institutionNm=[];
		var institutionId=[];
		$.each(evt.datas, function(index) {

			//$('#institutionId').val(this.institutionId);
			//$('#institutionNm').val(this.institutionNm);
			//$('#institutionId').val(this.institutionId);
			institutionId.push(this.institutionId);
			institutionNm.push(this.institutionNm);
			console.log("institutionId : " + this.institutionId);
			console.log("institutionNm : " + this.institutionNm);
			console.log("regionId : " + this.regionId);
			console.log("regionNm : " + this.regionNm);

		});

		$('#institutionNm').val(institutionNm);
		$('#institutionId').val(institutionId);
		console.log("institutionId : " + institutionId);
		console.log("institutionNm : " + institutionNm);
	}

</script>
<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<form:form commandName="searchVo" method="get" onsubmit="fn_search(); return false;">
	<form:hidden path="institutionId" />
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />

	<div class="col-box-100 search-col">
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

			<div class="box-body collapse in search-collapse" id="demo">
				<div class="form-group">

					<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-50">
						<div class="cell-title">
							<label title="부처명" for="institutionNm">부처명</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:input type="text" path="institutionNm" cssClass="form-control input-sm" title="부처명" readonly="true" />
								<div class="input-group-btn">
									<button class="btn btn-sm" onclick="openInsttMultiSearch(); return false;">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-50">
						<div class="cell-title">
							<label title="분석기준" for="searchTrmCd">분석기준</label>
						</div>
						<div class="cell-body">
							<div class="input-group-box">
								<form:select path="searchTrmCd" cssClass="form-control input-sm" title="분석기준" onchange="f_changeSearchTrmCd(this.value)">
									<form:option value="DD">일</form:option>
									<form:option value="MM">월</form:option>
									<form:option value="QQ">분기</form:option>
									<form:option value="HH">반기</form:option>
									<form:option value="YY">년</form:option>
									<form:option value="DI">직접입력</form:option>
								</form:select>


								<div class="input-group-cell pad-right-5" id="divDD">
									<div class="input-group period">
										<form:input path="date" cssClass="form-control input-sm datepicker onlyDate" title="날짜" />
									</div>
								</div>
								<div class="input-group-cell pad-right-5" id="divDI">
									<div class="input-group period period-start">
										<form:input path="strtDt" cssClass="form-control input-sm datepicker onlyDate" maxlength="" title="시작일자" onchange="initDate(this, 'endDt', 'S')" />
									</div>
									<div class="input-group period period-end">
										<form:input path="endDt" cssClass="form-control input-sm datepicker onlyDate" title="종료일자" onchange="initDate(this, 'strtDt', 'E')" />
									</div>
								</div>
								<div class="input-group-cell pad-right-5" id="divYY">
									<div class="">
										<form:select path="year" cssClass="form-control input-sm" title="날짜">
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
								<div class="input-group-cell pad-right-5" id="divQQ">
									<div class="">
										<form:select path="searchQqCd" cssClass="form-control input-sm" title="분기">
											<form:option value="01">1분기</form:option>
											<form:option value="02">2분기</form:option>
											<form:option value="03">3분기</form:option>
											<form:option value="04">4분기</form:option>
										</form:select>
									</div>
								</div>
								<div class="input-group-cell pad-right-5" id="divHH">
									<div class="">
										<form:select path="searchHhCd" cssClass="form-control input-sm" title="반기">
											<form:option value="01">상반기</form:option>
											<form:option value="02">하반기</form:option>
										</form:select>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<!-- /form-group -->
			</div>
			<!-- /box-body -->
			<div class="box-footer collapse in search-collapse">
				<div class="pull-left">
					<button type="button" class="btn" onclick="fn_reset();">초기화</button>
				</div>
				<div class="pull-right">
					<button type="submit" class="btn btn-red" onclick="fn_search();">조회</button>

				</div>
			</div>
			<!-- /box-footer -->
		</div>
		<!-- /box(검색조건) -->
</div>
</form:form>
<!-- /col -->



<div class="col-box-100 detail-col">
	<div class="col-cell-group clearfix">
		<div class="col-cell-20 col-lay-10 no-padding-right">
			<div class="detail-list-box box">
				<div class="box-header">
					<h3 class="box-title">부처업무</h3>
				</div>
				<!-- /box-header -->
				<div class="box-body no-padding">
					<table class="table table-vertical">
						<caption>부처업무</caption>
						<tbody>
							<tr>
								<th>업무</th>
							</tr>
							<tr>
								<td><c:out value="${GovDeptResStteCvo.govDeptResInfoVo.jobCnt }" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- /box-body -->
			</div>
			<!-- /box -->
		</div>
		<!-- /col-cell -->

		<div class="col-cell-20 col-lay-15 no-padding-right">
			<div class="detail-list-box box">
				<div class="box-header">
					<h3 class="box-title">가상서버(수량)</h3>
				</div>
				<!-- /box-header -->
				<div class="box-body no-padding">
					<table class="table table-vertical">
						<caption>가상서버(수량)</caption>
						<tbody>
							<tr>
								<th>총수량</th>
							</tr>
							<tr>
								<td><c:out value="${GovDeptResStteCvo.govDeptResInfoVo.vmCnt }" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- /box-body -->
			</div>
			<!-- /box -->
		</div>
		<!-- /col-cell -->

		<div class="col-cell-40 col-lay-30 col-lay-no-padding-right">
			<div class="detail-list-box box">
				<div class="box-header">
					<h3 class="box-title">OS</h3>
				</div>
				<!-- /box-header -->
				<div class="box-body no-padding">
					<table class="table table-vertical">
						<caption>OS</caption>
						<tbody>
							<tr>
								<th>LINUX</th>
								<th>HP-UX</th>
								<th>AIX</th>
								<th>WIN</th>
								<th>SOLARIS</th>
								<th>ETC</th>
							</tr>
							<tr>
								<td><c:out value="${GovDeptResStteCvo.govDeptResInfoVo.linuxCnt }" /></td>
								<td><c:out value="${GovDeptResStteCvo.govDeptResInfoVo.hpCnt }" /></td>
								<td><c:out value="${GovDeptResStteCvo.govDeptResInfoVo.aixCnt }" /></td>
								<td><c:out value="${GovDeptResStteCvo.govDeptResInfoVo.winCnt }" /></td>
								<td><c:out value="${GovDeptResStteCvo.govDeptResInfoVo.solarisCnt }" /></td>
								<td><c:out value="${GovDeptResStteCvo.govDeptResInfoVo.etcCnt }" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- /box-body -->
			</div>
			<!-- /box -->
		</div>
		<!-- /col-cell -->

		<div class="col-cell-70 col-lay-30 no-padding-right">
			<div class="detail-list-box box">
				<div class="box-header">
					<h3 class="box-title">자원할당량</h3>
				</div>
				<!-- /box-header -->
				<div class="box-body no-padding">
					<table class="table table-vertical">
						<caption>자원할당량</caption>
						<tbody>
							<tr>
								<th>vCore</th>
								<th>메모리</th>
								<th>스토리지</th>
							</tr>
							<tr>
								<td><c:out value="${GovDeptResStteCvo.govDeptResInfoVo.lastVcoreQty }" /></td>
								<td><c:out value="${GovDeptResStteCvo.govDeptResInfoVo.lastMemSumCapa }" />GB</td>
								<td><c:out value="${GovDeptResStteCvo.govDeptResInfoVo.lastStrgSumCapa }" />TB</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- /box-body -->
			</div>
			<!-- /box -->
		</div>
		<!-- /col-cell -->

		<div class="col-cell-70 col-lay-55 no-padding-right" style="padding-left: 12%;">
			<div class="detail-list-box box">
				<div class="box-header">
					<h3 class="box-title">자동확장</h3>
				</div>
				<!-- /box-header -->
				<div class="box-body no-padding">
					<table class="table table-vertical">
						<caption>자원할당현황</caption>
						<tbody>
							<tr>
								<th>서비스</th>
								<th>POD</th>
								<th>CPU</th>
								<th>메모리</th>
								<th>스토리지</th>
							</tr>
							<tr>
								<td><fmt:formatNumber value="${GovDeptResStteCvo.govAxCntVo.servcCnt }" pattern="#,###" />개</td>
								<td><fmt:formatNumber value="${GovDeptResStteCvo.govAxCntVo.podQty }" pattern="#,###" />개</td>
								<td><fmt:formatNumber value="${GovDeptResStteCvo.govAxCntVo.cpuAsgnCapa }" pattern="#,###.##" />Core</td>
								<td><fmt:formatNumber value="${GovDeptResStteCvo.govAxCntVo.memTotCapa }" pattern="#,###.##" />GB</td>
								<td><fmt:formatNumber value="${GovDeptResStteCvo.govAxCntVo.strgTotCapa }" pattern="#,###.##" />GB</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- /box-body -->
			</div>
			<!-- /box -->
		</div>
		<!-- /col-cell -->

	</div>
	<!-- /col-cell-group -->
</div>
<!-- /col -->


<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">전체 :
				${searchVo.paginationInfo.totalRecordCount } 건</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<%-- 					     <nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/> --%>
					<div class="input-group-cell">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_excelDown()">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /box-header -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical table-layout-fixed" id="GovDeptStte">
				<caption>부처자원현황</caption>
				<colgroup>
					<col width="120px"><!-- 부처명  -->
					<col width="40px">
					<col width="40px"><!-- 가상서버수(WEB)  -->
					<col width="40px"><!-- 가상서버수(WAS)  -->
					<col width="40px"><!-- 가상서버수(DB)  -->
					<col width="40px"><!-- 가상서버수(WIN)  -->
					<col width="40px"><!-- 가상서버수(TEST)  -->
					<col width="40px"><!-- 가상서버수(ETC)  -->
					<col width="50px">
					<col width="50px">
					<col width="40px"> <!-- OS  -->
					<col width="45px">
					<col width="40px">
					<col width="40px">
					<col width="40px">
					<col width="40px">
					<col width="100px"> <!-- WEB  -->
					<col width="100px">
					<col width="100px">
					<col width="100px"><!-- WAS  -->
					<col width="100px">
					<col width="100px">
					<col width="100px"><!-- DB  -->
					<col width="100px">
					<col width="100px">
					<col width="100px"><!-- WIN  -->
					<col width="100px">
					<col width="100px">
					<col width="100px"><!-- TEST  -->
					<col width="100px">
					<col width="100px">
					<col width="100px"><!-- ETC  -->
					<col width="100px">
					<col width="100px">
					<col width="100px"><!-- 자동확장  -->
					<col width="100px">
					<col width="100px">
				</colgroup>
				<thead>
					<tr>
						<th rowspan="2">부처명</th>
						<th rowspan="2">업무수</th>
						<th colspan="6">가상서버수</th>
						<th colspan="2">자동확장수</th>
						<th colspan="6">OS</th>
						<th colspan="3">WEB(할당량/사용률)</th>
						<th colspan="3">WAS(할당량/사용률)</th>
						<th colspan="3">DB(할당량/사용률)</th>
						<th colspan="3">WIN(할당량/사용률)</th>
						<th colspan="3">TEST(할당량/사용률)</th>
						<th colspan="3">ETC(할당량/사용률)</th>
						<th colspan="3">자동확장(할당량/사용률)</th>
					</tr>
					<tr>
						<th>WEB</th>
						<th>WAS</th>
						<th>DB</th>
						<th>WIN</th>
						<th>TEST</th>
						<th>ETC</th>
						<th>서비스수</th>
						<th>POD수</th>
						<th>LINUX</th>
						<th>HP-UX</th>
						<th>AIX</th>
						<th>WIN</th>
						<th>SOLARIS</th>
						<th>ETC</th>
						<th>CPU(vCore)</th>
						<th>메모리(GB)</th>
						<th>스토리지(TB)</th>
						<th>CPU(vCore)</th>
						<th>메모리(GB)</th>
						<th>스토리지(TB)</th>
						<th>CPU(vCore)</th>
						<th>메모리(GB)</th>
						<th>스토리지(TB)</th>
						<th>CPU(vCore)</th>
						<th>메모리(GB)</th>
						<th>스토리지(TB)</th>
						<th>CPU(vCore)</th>
						<th>메모리(GB)</th>
						<th>스토리지(TB)</th>
						<th>CPU(vCore)</th>
						<th>메모리(GB)</th>
						<th>스토리지(TB)</th>
						<th>CPU(Core)</th>
						<th>메모리(GB)</th>
						<th>스토리지(GB)</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${ GovDeptResStteCvo.gvDeptResStteList eq null or empty GovDeptResStteCvo.gvDeptResStteList }">
							<tr>
								<td colspan="31">
									<c:choose>
										<c:when
											test="${searchVo.institutionId eq null or empty searchVo.institutionId }">
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
							<c:forEach var="vo" items="${GovDeptResStteCvo.gvDeptResStteList}" varStatus="ri">

								<tr>
									<td class="alignL"><c:out value="${vo.institutionNm }" /></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.jobCnt}" pattern="#,###" /></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.webCnt}" pattern="#,###" /></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.wasCnt}" pattern="#,###" /></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.dbCnt}" pattern="#,###" /></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.winCnt}" pattern="#,###" /></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.testCnt}" pattern="#,###" /></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.etcCnt}" pattern="#,###" /></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.servcCnt }" pattern="#,###" /></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.podQty }" pattern="#,###" /></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.osLinuxCnt}" pattern="#,###" /></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.osHpCnt}" pattern="#,###" /></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.osAixCnt}" pattern="#,###" /></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.osWinCnt}" pattern="#,###" /></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.osSolarisCnt}" pattern="#,###" /></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.osEtcCnt}" pattern="#,###" /></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.webVcore}" pattern="#,###" />
										<c:if test="${vo.webCpuRt != null}"> (<c:out value="${vo.webCpuRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.webMem}" pattern="#,###" />
										<c:if test="${vo.webMemRt != null}">(<c:out value="${vo.webMemRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.webStrg}" pattern="#,###.##" />
										<c:if test="${vo.webStrgRt != null}">(<c:out value="${vo.webStrgRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.wasVcore}" pattern="#,###" />
										<c:if test="${vo.wasCpuRt != null}">(<c:out value="${vo.wasCpuRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.wasMem}" pattern="#,###" />
										<c:if test="${vo.wasMemRt != null}">(<c:out value="${vo.wasMemRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.wasStrg}" pattern="#,###.##" />
										<c:if test="${vo.wasStrgRt != null}">(<c:out value="${vo.wasStrgRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.dbVcore}" pattern="#,###" />
										<c:if test="${vo.dbCpuRt != null}">(<c:out value="${vo.dbCpuRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.dbMem}" pattern="#,###" />
										<c:if test="${vo.dbMemRt != null}">(<c:out value="${vo.dbMemRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.dbStrg}" pattern="#,###.##" />
										<c:if test="${vo.dbStrgRt != null}">(<c:out value="${vo.dbStrgRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.winVcore}" pattern="#,###" />
										<c:if test="${vo.winCpuRt != null}">(<c:out value="${vo.winCpuRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.winMem}" pattern="#,###" />
										<c:if test="${vo.winMemRt != null}">(<c:out value="${vo.winMemRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.winStrg}" pattern="#,###.##" />
										<c:if test="${vo.winStrgRt != null}">(<c:out value="${vo.winStrgRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.testVcore}" pattern="#,###" />
										<c:if test="${vo.testCpuRt != null}">(<c:out value="${vo.testCpuRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.testMem}" pattern="#,###" />
										<c:if test="${vo.testMemRt != null}">(<c:out value="${vo.testMemRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.testStrg}" pattern="#,###.##" />
										<c:if test="${vo.testStrgRt != null}">(<c:out value="${vo.testStrgRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.etcVcore}" pattern="#,###" />
										<c:if test="${vo.etcCpuRt != null}">(<c:out value="${vo.etcCpuRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.etcMem}" pattern="#,###" />
										<c:if test="${vo.etcMemRt != null}">(<c:out value="${vo.etcMemRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.etcStrg}" pattern="#,###.##" />
										<c:if test="${vo.etcStrgRt != null}">(<c:out value="${vo.etcStrgRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.ocpCpuAsgnCapa }" pattern="#,###.##" />
										<c:if test="${vo.ocpAvgCpuUseRt != null}">(<c:out value="${vo.ocpAvgCpuUseRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.ocpMemTotCapa }" pattern="#,###.##" />
										<c:if test="${vo.ocpAvgMemUseRt != null}">(<c:out value="${vo.ocpAvgMemUseRt}" />%)</c:if></td>
									<td class="alignR notellipsis"><fmt:formatNumber value="${vo.ocpStrgTotCapa }" pattern="#,###.##" /></td>

								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->

	</div>
	<!-- /box -->
</div>
<!-- /col -->
<script>
	$(document).ready(function() {

		function pageInit() {
			$('#searchTrmCd').trigger('change');
			//fn_dataTable("tableEvntNtceHistList",0)//테이블 정렬및 resize
			//fn_setRegion2PoolCombo('regionId','zoneId','netId','rsrcPoolId');//리전/존/망/자원풀 select 셋팅
		}
		pageInit();

	});

	// 검색조건 초기화
	function fn_reset() {
		//$("#searchVo input[type='text']").val("");
		$("#institutionNm").val("");

		f_changeSearchTrmCd('DD');
		$('#searchTrmCd').val("DD").attr("selected","selected");
		$('#date').val($.datepicker.formatDate('yy-mm-dd',new Date()-1));
		$('#strtDt').val("");
		$('#endDt').val("");
		$('#year option:eq(0)').attr("selected","selected");
		$('#searchMmCd option:eq(0)').attr("selected","selected");
		$('#searchQqCd option:eq(0)').attr("selected","selected");
	}

	function f_changeSearchTrmCd(val) {
		if (val == 'DD') {//일
			$('#divDD').show();
			$('#divMM').hide();
			$('#divQQ').hide();
			$('#divHH').hide();
			$('#divYY').hide();
			$('#divDI').hide();
		} else if (val == 'MM') {//월
			$('#divDD').hide();
			$('#divMM').show();
			$('#divQQ').hide();
			$('#divHH').hide();
			$('#divYY').show();
			$('#divDI').hide();
		} else if (val == 'QQ') {//분기
			$('#divDD').hide();
			$('#divMM').hide();
			$('#divQQ').show();
			$('#divHH').hide();
			$('#divYY').show();
			$('#divDI').hide();
		} else if (val == 'HH') {//반기
			$('#divDD').hide();
			$('#divMM').hide();
			$('#divQQ').hide();
			$('#divHH').show();
			$('#divYY').show();
			$('#divDI').hide();
		} else if (val == 'YY') {//년
			$('#divDD').hide();
			$('#divMM').hide();
			$('#divQQ').hide();
			$('#divHH').hide();
			$('#divYY').show();
			$('#divDI').hide();
		} else if (val == 'DI') {//직접입력
			$('#divDD').hide();
			$('#divMM').hide();
			$('#divQQ').hide();
			$('#divHH').hide();
			$('#divYY').hide();
			$('#divDI').show();
			//$('#strtDt').val('');
			//$('#endDt').val('');
		}
	}

	function goPage(page) {
		location.href = "selectJobResStteList.do?paginationInfo.currentPageNo="
				+ page + "&${listParam}";
	}

	function fn_search() {
		if (!fn_form_validation("searchVo")) {
			return;
		}
		var val = $('#searchTrmCd').val();

		if (val == 'DD') {//일
			if ($('#date').val() == '') {
				jAlert('검색일자를 입력하시기 바랍니다.', function() {
					$('#date').focus();
				})
				return false;
			}
		} else if (val == 'DI') {//일
			if ($('#strtDt').val() == '') {
				jAlert('검색시작일자를 입력하시기 바랍니다.', function() {
					$('#strtDt').focus();
				})
				return false;
			}
			if ($('#endDt').val() == '') {
				jAlert('검색종료일자를 입력하시기 바랍니다.', function() {
					$('#endDt').focus();
				})
				return false;
			}
		}
		searchVo.action = '<c:url value="selectGovDeptResStteList.do" />';
		searchVo.submit();
	}
	function fn_excelDown() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selectGovDeptResStteListXlsDown.do" />';
		searchVo.submit();
	}
</script>

