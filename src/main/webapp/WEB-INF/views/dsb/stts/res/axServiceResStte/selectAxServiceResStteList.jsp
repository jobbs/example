<%--
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 5. 22.
 * @lastmodified 2017. 5. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 5. 22.     양정순         v1.0             최초생성
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
<%-- 기존 조회조건  --%>
<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>
<script>

	function fn_search() {
		if (!fn_form_validation("searchVo")) {
			return;
		}

		searchVo.action = '<c:url value="selectAxServiceResStteList.do" />';
		searchVo.submit();
	}

	function fn_openAxServiceTimeResUseRt(servcSeq, servcNm) {
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
		var params = getContainerData($('#searchVo'));
		params.servcSeq = servcSeq;
		params.servcNm = servcNm;
		//alert(params.jobNm);
		popup('<c:url value="selectAxServiceTimeResUseRtP.do" />' + '?'
				+ $.param(params), 'AxServiceTimeResUseRt', 1200, 1000);
	}
</script>

<!-- /컨텐츠 타이틀 -->

<!-- section.content의 하위 요소는 .row → .col → .box 순으로 진행됩니다. -->
	<!-- 수평 요소를 감싸주는 row 요소 -->

		<!-- col-box : 기본적으로 해당 가로사이즈(%)를 유지합니다. -->
		<div class="col-box-100">
			<form:form commandName="searchVo" method="get" onsubmit="fn_search(); return false;">
				<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
				<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
				<!-- box(검색조건) -->
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
							onchange="selectZoneByNetClCd('regionId', 'zoneId', 'netId', 'rsrcPoolId',{searchPoolTypeCd : '05','searchCtlTrgtYn' : 'N'})"
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
							onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netId', 'rsrcPoolId', {searchPoolTypeCd : '05','searchCtlTrgtYn' : 'N'})"
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
							onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netId', 'rsrcPoolId', {searchPoolTypeCd : '05','searchCtlTrgtYn' : 'N'})"
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
							poolTypeCd="05"
							value="${searchVo.rsrcPoolId}"
							regionId="${searchVo.regionId}"
							zoneId="${searchVo.zoneId}"
							netClCd="${searchVo.netId}"
							cssClass="form-control input-sm"
							title="자원풀"
							ctlTrgtYn=""
							/>

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
						<!-- /box-body -->
					</div>
					<!-- /box-body (검색조건) -->
					<div class="box-footer collapse in search-collapse">
						<div class="pull-left">
							<button type="button" class="btn btn-default" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
						</div>
						<div class="pull-right">
							<button type="submit" class="btn btn-red ">조회</button>
						</div>
					</div>
					<!-- /box-footer -->
				</div>
				<!--  box -->
			</form:form>
		</div>
		<!-- /col -->



		<!-- col-box : 기본적으로 해당 가로사이즈(%)를 유지합니다. -->
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
		<div class="box-body list-body no-padding">
			<table class="table table-hover table-vertical" id="AxNodeResStteTable">
				<caption>자동확장 서비스별 자원현황</caption>
					<colgroup>
						<col class="col7">
						<col class="col7">
						<col class="col7">
						<col class="col10">
						<col class="col10">
						<col class="col10">
						<col class="col10">
						<col class="col10">
						<col class="col10">
						<col class="col10">
						<col class="col10">
					</colgroup>
				<thead>
					<tr>
                        <th rowspan="3">센터</th>
						<th rowspan="3">존</th>
						<th rowspan="3">망</th>
						<th rowspan="3">자원풀</th>
						<th rowspan="3">서비스명</th>
						<th rowspan="3">POD수</th>
						<th colspan="5">자동확장자원(할당량/사용률)</th>
					</tr>
					<tr>
						<th rowspan="2">CPU</th>
						<th rowspan="2">메모리(GB)</th>
						<th rowspan="2">스토리지(GB)</th>
						<th colspan="2">네트워크(In/Out)</th>
					</tr>
					<tr>
					  	<th>In(KB/s)</th>
						<th>Out(KB/s)</th>
					</tr>
				</thead>
			<tbody>
					<c:choose>
						<c:when test="${ list eq null or empty list }"><%--
							<tr>
								<td colspan="11">
									<c:choose>
										<c:when test="${searchVo.servcSeq eq null or empty searchVo.servcSeq }">
								           조회 버튼을 클릭해 주시기 바랍니다.
								        </c:when>
										<c:otherwise>
							               검색된 데이터가 없습니다.
							            </c:otherwise>
									</c:choose>
								</td>
							</tr>
			        --%></c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${list}" varStatus="ri">
								<tr>
									<td class="alignC"><c:out value="${vo.regionNm }" /></td>
									<td class="alignC"><c:out value="${vo.zoneNm }" /></td>
									<td class="alignC"><c:out value="${vo.netNm }" /></td>
									<td class="ellipsis alignL"><c:out value="${vo.rsrcPoolNm }" /></td>
									<td class="alignL"><div class="ellipsis"><a href="javascript:fn_openAxServiceTimeResUseRt('<c:out value="${vo.servcSeq }"/>','<c:out value="${vo.servcNm }"/>')"><c:out value="${vo.servcNm }" /></a></div></td><!-- notellipsis -->
									<td class="alignR"><fmt:formatNumber value="${vo.podQty }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.cpu }" pattern="#,###.##" />(<fmt:formatNumber value="${vo.cpuRt }" pattern="#,###.##" />%)</td>
									<td class="alignR"><fmt:formatNumber value="${vo.mem }" pattern="#,###.##" />(<fmt:formatNumber value="${vo.memRt }" pattern="#,###.##" />%)</td>
									<td class="alignR"><fmt:formatNumber value="${vo.strg }" pattern="#,###.##" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.netwkIn }" pattern="#,###.##" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.netwkOut }" pattern="#,###.##" /></td>
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
			//fn_dataTable("tableEvntNtceHistList", 0)//테이블 정렬및 resize
			//fn_setRegion2PoolCombo('regionId','zoneId','netId','rsrcPoolId');//리전/존/망/자원풀 select 셋팅
		}
		pageInit();

		var emptymsg = "검색된 데이터가 없습니다.";

<c:choose>
	<c:when test="${ (list eq null or empty list) and (searchVo.strtDt eq null) }">
		emptymsg = "조회 버튼을 클릭해 주시기 바랍니다.";
	</c:when>
</c:choose>

		$('#AxNodeResStteTable colgroup').remove();
		tb = $('#AxNodeResStteTable').DataTable( {
			dom: 'Zlfrtip',
			paging : false,
			searching : false,
			info : false,
			bAutoWidth : false,
			responsive: true,
			aoColumns : [
				{sWidth : "60px" }, // 센터
				{sWidth : "80px"  }, // 존
				{sWidth : "80px" }, // 망
				{sWidth : "100px" }, // 자원풀
				{sWidth : "200px" }, // 서비스명
				{sWidth : "60px" }, // POD수
				{sWidth : "90px" }, // CPU
				{sWidth : "90px" }, // 메모리
				{sWidth : "80px" }, // 스토리지
				{sWidth : "70px" }, // 네트워크IN
				{sWidth : "70px" } // 네트워크OUT
			],
			order : [],
			fixedColumns: true,
			oLanguage:{sEmptyTable: emptymsg}
		});
/*
		$(window).bind('resize', function() {
			$('#AxNodeResStteTable').css('width', '100%');
			tb.columns.adjust().draw();
			$('table').dataTable().fnSettings()._colResize.s.colsize_first=true;
		});
 */
	});

	// 검색조건 초기화
	function fn_reset() {
		//$("#searchVo input[type='text']").val("");
		$("#regionId").val("").attr("selected", "selected");
		$("#zoneId").val("").attr("selected", "selected");
		$("#netId").val("").attr("selected", "selected");
		$("#rsrcPoolId").val("").attr("selected", "selected");

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
		location.href = "selectAxServiceResStteList.do?paginationInfo.currentPageNo="
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
		searchVo.action = '<c:url value="selectAxServiceResStteList.do" />';
		searchVo.submit();
	}

	function fn_excelDown() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selectAxServiceResStteListXlsDown.do" />';
		searchVo.submit();
	}

</script>