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

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<%-- <script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script> --%>
<%-- <script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script> --%>
<%-- <script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script> --%>


<%-- 기존 조회조건  --%>
<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>
<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
	<div class="col-box-100 search-col">
		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<!-- 접기 버튼 -->
					<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse" onclick="return false;">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
					</button>
				</div>
			</div>
			<!-- /box-header -->
			<div class="box-body collapse in search-collapse">
				<div class="form-group">
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion
								name="regionId"
								id="regionId"
								whole="true"
								value="${searchVo.regionId}"
								wholeText="전체"
								cssClass="form-control input-sm"
								byRole="false"
								onchange="selectZoneByNetClCd('regionId', 'zoneId', 'netId', 'rsrcPoolId')"
								title="센터" />
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>존</label>
						</div>
						<div class="cell-body">
							<nform:selectZone
								name="zoneId"
								id="zoneId"
								whole="true"
								value="${searchVo.zoneId}"
								regionId="${searchVo.regionId}"
								wholeText="전체"
								cssClass="form-control input-sm"
								onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netId', 'rsrcPoolId', {searchPoolTypeCd : 'CN','searchCtlTrgtYn' : 'Y'})"
								title="존" />
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>망구분</label>
						</div>
						<div class="cell-body">

							<nform:selectCode
								parentCd="NETCD"
								parentGrpCd="067"
								name="netId"
								id="netId"
								whole="true"
								title="망구분"
								wholeText="전체"
								value="${searchVo.netId}"
								onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netId', 'rsrcPoolId', {searchPoolTypeCd : 'CN','searchCtlTrgtYn' : 'Y'})"
								cssClass="form-control" />
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>자원풀</label>
						</div>
						<div class="cell-body">
							<nform:selectPool
								name="rsrcPoolId"
								id="rsrcPoolId"
								wholeText="전체"
								poolTypeCd="CN"
								swTypeCd="COM"
								value="${searchVo.rsrcPoolId}"
								regionId="${searchVo.regionId}"
								zoneId="${searchVo.zoneId}"
								netClCd="${searchVo.netId}"
								cssClass="form-control input-sm"
								title="자원풀" />

						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>물리서버명</label>
						</div>
						<div class="cell-body">
							<form:input path="pmNm" cssClass="form-control input-sm" maxlength="" title="물리서버명" />
						</div>
					</div>
					<div class="form-cell form-cell-100 col-lay-50">
						<div class="cell-title">
							<label>검색기간</label>
						</div>
						<div class="cell-body">
							<div class="input-group-box">
								<div class="input-group-cell pad-right-5">
									<div class="input-group">
										<form:select path="searchTrmCd" cssClass="form-control input-sm" title="검색기간" onchange="f_changeSearchTrmCd(this.value)">
											<form:option value="DD">일</form:option>
											<form:option value="MM">월</form:option>
											<form:option value="QQ">분기</form:option>
											<form:option value="HH">반기</form:option>
											<form:option value="YY">년</form:option>
											<form:option value="DI">직접입력</form:option>
										</form:select>
									</div>
								</div>
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
								<div class="input-group-cell pad-right-5" id="divQQ">
									<div class="">
										<form:select path="searchQqCd"
											cssClass="form-control input-sm" title="분기">
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
					<div class="form-cell form-cell-50 col-lay-25"></div>
				</div>
			</div>
			<!-- /box-body -->
			<div class="box-footer collapse in search-collapse">
				<div class="pull-left">
					<button type="reset" class="btn">초기화</button>
				</div>
				<div class="pull-right">
					<button type="submit" class="btn btn-red" onclick="fn_search(); ">조회</button>
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
				물리서버 자원 현황 목록 <small>${searchVo.paginationInfo.currentPageNo }
					/ ${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage
						formId="searchVo"
						value="${searchVo }" />
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="excelDown()">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body ">
			<table class="table table-bordered table-layout-fixed" id="tableEvntNtceHistList">
				<caption>물리서버 자원현황 목록</caption>
				<colgroup>
					<col width="40px">
					<col width="30px">
					<col width="60px">
					<col width="80px">
					<col width="90px">
					<!-- 클러스터명 -->
					<col width="200px">
					<!-- 물리서버명 -->
					<col width="80px">
					<col width="40px">
					<col width="70px">
					<col width="70px">
					<!-- 메모리(물리서버가상화율 -->
					<col width="90px">
					<col width="90px">
					<col width="100px">
					<col width="200px">
					<!-- 가상서버명 -->
					<col width="100px">
					<col width="160px">
					<col width="120px">
					<!-- 부처명 -->
					<col width="150px">
					<!-- 업무명 -->
					<col width="85px">
					<col width="85px">
					<col width="85px">
				</colgroup>
				<thead>
					<tr>
						<th rowspan="2">센터</th>
						<th rowspan="2">존</th>
						<th rowspan="2">망구분</th>
						<th rowspan="2">자원풀명</th>
						<th rowspan="2">클러스터명</th>
						<th rowspan="2">물리서버명</th>
						<th rowspan="2">물리서버<br>구성ID
						</th>
						<th rowspan="2">가상<br>서버수
						</th>
						<th colspan="2">물리서버 가상화율</th>
						<th colspan="3">물리서버 할당량/사용률</th>
						<th colspan="8">가상서버 할당량/사용률</th>
					</tr>
					<tr>
						<th>CPU</th>
						<th>메모리</th>
						<th>CPU(vCore)</th>
						<th>메모리(GB)</th>
						<th>스토리지(GB)</th>
						<th>가상서버명</th>
						<th>가상서버 구성ID</th>
						<th>호스트명</th>
						<th>부처명</th>
						<th>업무명</th>
						<th>CPU<br />(vCore)
						</th>
						<th>메모리<br />(GB)
						</th>
						<th>스토리지<br />(GB)
						</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${  searchVo.regionId eq null}">
							<tr>
								<td colspan="21">조회 버튼을 클릭해 주시기 바랍니다.</td>
							</tr>
						</c:when>
						<c:when test="${list eq null or empty list }">
							<tr>
								<td colspan="21">검색된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:set var="tempPmSeq" value="" />
							<c:forEach var="vo" items="${list }" varStatus="i">
								<tr>
									<c:if test="${tempPmSeq != vo.pmSeq }">
										<c:set var="tempPmSeq" value="${vo.pmSeq }" />
										<td <c:if test="${vo.vmCnt >1}">rowspan="${vo.vmCnt}" </c:if> class=" notellipsis"><c:out value="${vo.regionNm }" /></td>
										<td <c:if test="${vo.vmCnt >1}">rowspan="${vo.vmCnt}" </c:if> class=" notellipsis"><c:out value="${vo.zoneNm }" /></td>
										<td <c:if test="${vo.vmCnt >1}">rowspan="${vo.vmCnt}" </c:if> class="alignL notellipsis"><c:out value="${vo.netNm }" /></td>
										<td <c:if test="${vo.vmCnt >1}">rowspan="${vo.vmCnt}" </c:if> class="alignL notellipsis" title="<c:out value="${vo.rsrcPoolNm }"/>"><c:out value="${vo.rsrcPoolNm }" /></td>
										<td <c:if test="${vo.vmCnt >1}">rowspan="${vo.vmCnt}" </c:if> class="alignL notellipsis">
										    <a href="javascript:fn_openClstrTimeResUseRt('<c:out value="${vo.clstrSeq }"/>','<c:out value="${vo.clstrNm }"/>')"><c:out value="${vo.clstrNm }" /></a></td>
										<td <c:if test="${vo.vmCnt >1}">rowspan="${vo.vmCnt}" </c:if> class="alignL notellipsis" title="<c:out value="${vo.pmNm }"/>">
											<a href="javascript:fn_openPmTimeResUseRt('<c:out value="${vo.pmSeq }"/>','<c:out value="${vo.pmNm }"/>')"><c:out value="${vo.pmNm }" /></a>
										</td>
										<td <c:if test="${vo.vmCnt >1}">rowspan="${vo.vmCnt}" </c:if>><c:out value="${vo.pmCompId }" /></td>
										<td <c:if test="${vo.vmCnt >1}">rowspan="${vo.vmCnt}" </c:if> class="alignR notellipsis">
											<c:choose>
												<c:when test="${empty vo.pmLastVSrvrQty}">
													<c:out value="${vo.vmCnt }" />
												</c:when>
												<c:otherwise>
													<c:out value="${vo.vmCnt }" />
												</c:otherwise>
											</c:choose>
										</td>
										<td <c:if test="${vo.vmCnt >1}">rowspan="${vo.vmCnt}" </c:if> class="alignR notellipsis"><c:out value="${vo.pmCpuVRt }" />%</td>
										<td <c:if test="${vo.vmCnt >1}">rowspan="${vo.vmCnt}" </c:if> class="alignR notellipsis"><c:out value="${vo.pmMemVRt }" />%</td>
										<td <c:if test="${vo.vmCnt >1}">rowspan="${vo.vmCnt}" </c:if> class="alignR notellipsis"><c:out value="${vo.pmLastAsgnVcorQty}" /> (<c:out value="${vo.pmAvgCpuUseRt}" />%)</td>
										<td <c:if test="${vo.vmCnt >1}">rowspan="${vo.vmCnt}" </c:if> class="alignR notellipsis"><c:out value="${vo.pmLastAsgnMemCapa}" /> GB (<c:out value="${vo.pmMemUseRt}" />%)</td>
										<td <c:if test="${vo.vmCnt >1}">rowspan="${vo.vmCnt}" </c:if> class="alignR notellipsis"><c:out value="${vo.pmLastStrgSumCapa}" /> GB (<c:out value="${vo.pmStrgUseRt}" />%)</td>
									</c:if>

									<td class="alignL  notellipsis" title="<c:out value="${vo.vmNm}"/>"><c:out value="${vo.vmNm}" /></td>
									<td class=" notellipsis"><c:out value="${vo.vmCompId}" /></td>
									<td class="alignL notellipsis" title="<c:out value="${vo.hstNm}"/>"><c:out value="${vo.hstNm}" /></td>
									<td class="alignL notellipsis" title="<c:out value="${vo.institutionNm}"/>"><c:out value="${vo.institutionNm}" /></td>
									<td class="alignL notellipsis" title="<c:out value="${vo.jobNm}"/>"><c:out value="${vo.jobNm}" /></td>
									<td class="alignR notellipsis"><c:out value="${vo.vmLastVcoreQty}" /> (<c:out value="${vo.vmAvgCpuUseRt}" />%)</td>
									<td class="alignR notellipsis"><c:out value="${vo.vmLastMemSumCapa}" />GB (<c:out value="${vo.vmMemUseRt}" />%)</td>
									<td class="alignR notellipsis"><c:out value="${vo.vmLastStrgSumCapa}" />GB (<c:out value="${vo.vmStrgUseRt}" />%)</td>
								</tr>

							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
			<div class="pull-right btns">
				<!-- <button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="엑셀다운로드" onclick="excelDown();"><i class="fa fa-arrow-down"></i></button> -->
			</div>
		</div>
	</div>
	<!-- /box(목록조회 테이블) -->
</div>
<!-- /col -->

<script>
	$(document).ready(function() {

		function pageInit() {
			$('#searchTrmCd').trigger('change');
			//$('#netId').trigger('change');
			//fn_dataTable1("tableEvntNtceHistList",0)//테이블 정렬및 resize
			//fn_setRegion2PoolCombo('regionId','zoneId','netId','rsrcPoolId');//리전/존/망/자원풀 select 셋팅
		}
		pageInit();

	});

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
	function changeNetId() {
		if ($('#regionId').val() != '' && $('#zoneId').val() != '') {
			selectPoolDy($('#netId'), 'regionId', 'zoneId', 'rsrcPoolId')
		} else {
			$('#rsrcPoolId option').each(function() {
				if ($('#rsrcPoolId option').length != 1) {//전체를 제외하고 삭제
					$('#rsrcPoolId option:last').remove();
				}

			});
		}

	}
	function goPage(page) {
		location.href = "selectPmResStteList.do?paginationInfo.currentPageNo="
				+ page + "&${listParam}";
	}
	function excelDown() {
		searchVo.action = '<c:url value="selectPmResStteListXlsDown.do" />';
		searchVo.submit();
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
		searchVo.action = '<c:url value="selectPmResStteList.do" />';
		searchVo.submit();
	}
	function fn_openPmTimeResUseRt(pmSeq, pmNm) {
		var params = getContainerData($('#searchVo'));
		params.pmNm = pmNm;

		popup('<c:url value="selectPmTimeResUseRtP.do" />' + '?'
				+ $.param(params) + '&pmSeq=' + pmSeq, 'PmTimeResUseRt', 1200,
				1000);
	}
	function fn_openClstrTimeResUseRt(clstrSeq, clstrNm) {
		var params = getContainerData($('#searchVo'));
		params.clstrNm=clstrNm;
		popup('<c:url value="selectClstrTimeResUseRtP.do" />' + '?'
				+ $.param(params) + '&clstrSeq=' + clstrSeq, 'ClstrTimeResUseRt', 1200,
				1000);
	}
	function excelDown() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selectPmResStteListXlsDown.do" />';
		searchVo.submit();
	}
</script>