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
 * 2017. 6. 22.     양정순         v2.0             자동확장 수정
 *
 --%>
<%@page	import=" java.util.*"  %>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/chart/chart.js" />"></script>
<%-- 기존 조회조건  --%>
<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>
<script>
	$(document).bind('selectInstitution',setInstitutions);
	var excelDn="vm";
	function setInstitutions(evt) {
		var vmSeq = [];
		var vmNm = [];

		// 전달받은 값
		$.each(evt.datas, function(index){
			vmNm.push(this.vmNm);
			vmSeq.push(this.vmSeq);
		});
		$('#vmListNm').val(vmNm);
		$('#vmListId').val(vmSeq);
		//console.log('vmListNm : ' + vmNm);
		//console.log('vmListId : ' + vmSeq);
	}


	function fn_search() {
		if (!fn_form_validation("searchVo")) {
			return;
		}

		searchVo.action = '<c:url value="selectJobResStteListByOnnara.do" />';
		searchVo.submit();
	}

	function f_tabView(tabId) {
		$('#' + tabId).show();
		if(tabId == 'tab-a') {
			$('#li-a').addClass('active');
			$('#li-b').removeClass('active');
			$('#tab-b').hide();
			excelDn="vm";
			fn_chartResize();
		}else{
			$('#li-b').addClass('active');
			$('#li-a').removeClass('active');
			$('#tab-a').hide();
			excelDn="ax";
			fn_chartResize();
		}

	}
	function fn_openJobTimeResUseRt(jobId, jobNm) {
		var params = getContainerData($('#searchVo'));
		params.jobNm = jobNm;
		params.jobId = jobId;
		//alert(params.jobNm);
		popup('<c:url value="selectJobTimeResUseRtP.do" />' + '?'
				+ $.param(params), 'JobTimeResUseRt', 1200, 1000);
	}
	function fn_openVmTimeResUseRt(vmSeq, vmNm) {
		var params = getContainerData($('#searchVo'));
		params.vmNm = vmNm;
		params.vmSeq = vmSeq;
		//alert(params.jobNm);
		popup('<c:url value="selectJobTimeResUseRtP.do" />' + '?'
				+ $.param(params), 'JobTimeResUseRt', 1200, 1000);
	}
	function fn_openAxTimeResUseRt(servcSeq, servcNm) {
		var params = getContainerData($('#searchVo'));
		params.servcNm = servcNm;
		params.servcSeq = servcSeq;
		//alert(params.jobNm);
		popup('<c:url value="selectAxTimeResUseRtP.do" />' + '?'
				+ $.param(params), 'AxTimeResUseRt', 1200, 1000);
	}



</script>

<!-- /컨텐츠 타이틀 -->

<!-- section.content의 하위 요소는 .row → .col → .box 순으로 진행됩니다. -->
	<!-- 수평 요소를 감싸주는 row 요소 -->
		<!-- col-box : 기본적으로 해당 가로사이즈(%)를 유지합니다. -->
		<div class="col-box-100">
			<form:form commandName="searchVo" method="get" onsubmit="fn_search(); return false;">
				<form:hidden path="vmListId" />
				<form:hidden path="institutionId" />
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
							<div class="form-cell form-cell-75 col-lay-75">
								<div class="cell-title">
									<label title="가상서버명" for="vmListNm">가상서버</label>
								</div>
								<div class="cell-body">
									<div class="input-group">
										<form:input type="text" path="vmListNm" cssClass="form-control input-sm " title="가상서버명" readonly="true" /><!-- essential -->
										<div class="input-group-btn">
											<button class="btn btn-sm" onclick="openInsttMultiSearchByOnnara(); return false;">
												<i class="fa fa-search"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
							<div class="form-cell form-cell-25 col-lay-25"></div>
							<!-- 분석기준 -->
							<div class="form-cell form-cell-50 col-lay-50">
								<div class="cell-title">
									<label title="분석기준" for="searchTrmCd">분석기준</label>
								</div>
								<div class="cell-body">
									<div class="input-group-box">
										<form:select path="searchTrmCd" cssClass="form-control input-sm" title="분석기준" onchange="f_changeSearchTrmCd(this.value)" style="width:100px">
											<form:option value="DD">일</form:option>
											<form:option value="DW">주</form:option>
											<form:option value="MM">월</form:option>
											<form:option value="DI">직접입력</form:option>
										</form:select>

										<div class="input-group-cell pad-right-5" id="divDD">
											<div class="input-group period">
												<form:input path="date" cssClass="form-control input-sm datepicker onlyDate" title="날짜" />
											</div>
										</div>
										<div class="input-group-cell pad-right-5" id="divDW">
											<div class="input-group">
												<form:input type="text" path="weeklyDatePicker" cssClass="form-control input-sm" title="주간" readonly="true" style="width:200px; font-size:13px"/><!-- essential -->
											</div>
										</div>
										<div class="input-group-cell pad-right-5" id="divDI">
											<div class="input-group period period-start">
												<form:input path="strtDt" cssClass="form-control input-sm datepicker onlyDate" maxlength="" title="시작일자" style="width:100px" onchange="initDate(this, 'endDt', 'S')" />
											</div>
											<div class="input-group period period-end">
												<form:input path="endDt" cssClass="form-control input-sm datepicker onlyDate" title="종료일자" style="width:100px" onchange="initDate(this, 'strtDt', 'E')" />
											</div>
										</div>
										<div class="input-group-cell pad-right-5" id="divYY">
											<form:select path="year" cssClass="form-control input-sm"
												title="날짜">
												<c:forEach var="yearVo" items="${yearCdList }">
													<form:option value="${yearVo.cd}">
														<c:out value="${yearVo.cdNm }" />
													</form:option>
												</c:forEach>
											</form:select>
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
									</div>
								</div>
							</div>

							<!-- 시간(단위) -->
							<div class="form-cell form-cell-25 col-lay-25" style="text-align:left">
								<div class="cell-title">
									<label title="분석간격" for="colctCd">분석간격</label>
								</div>
								<div class="cell-body">
									<div class="input-group input-group-radio">
										<form:radiobutton path="colctCd" title="분석간격" cssClass="essential" label="10분" checked="checked" value="MI" id="10m"/>
										<form:radiobutton path="colctCd" title="분석간격" cssClass="essential" label="1시간" value="HH" id="1h"/>
										<form:radiobutton path="colctCd" title="분석간격" cssClass="essential" label="1일" value="DD" id="1d"/>
									</div>
								</div>
							</div>

							<!-- CPU, Memory 선택 -->
							<div class="form-cell form-cell-25 col-lay-25">
								<div class="cell-title">
									<label title="분석대상" for="searchType">분석대상</label>
								</div>
								<div class="cell-body">
									<div class="input-group-box">
										<form:select path="searchType" cssClass="form-control input-sm" title="분석대상">
											<form:option value="A">전체</form:option>
											<form:option value="C">CPU</form:option>
											<form:option value="M">Memory</form:option>
										</form:select>
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
		<div class="col-box-100 ">
			<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
			<!-- box(목록조회 테이블) -->
			<div class="nav-tabs-custom">
				<ul class="nav nav-tabs">
					<li id="li-a" class="active"><a href="javascript:f_tabView('tab-a')">업무가상서버현황</a></li>
					<!--  data-toggle="tab" -->
					<li id="li-b"><a href="javascript:f_tabView('tab-b')">자동확장 서비스 현황</a></li>
					<!--  data-toggle="tab" -->
					<div class="pull-right pad-right-10 pad-top-5">
						<button id="exDn" class=" btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="excelDown()">
							<i class="fa fa-download"></i>
  						</button>
  					</div>
				</ul>
				<!-- /nav-tabs -->
				<div class="tab-content">
					<!-- tab-pane : .tab-content 페이지 중 하나입니다. -->
					<!-- tab-pane 화면은 상단 .nav-tabs(탭메뉴)내 a태그 클릭시 하단 .tab-pane요소의 active클래스의 유무로 화면에 나타나게 됩니다. -->
					<div class="tab-pane active" id="tab-a">
						<section>
							<div class="box">
								<div class="box-header">
									<h3 class="box-title">사용률</h3>
								</div><!-- /box-header -->
								<div class="box-body collapse in" id="graph-b">
									<div class="chart">
										<div>(%)</div>
											<canvas id="vmlineChart" style="height:200px;"></canvas>
										<div class="chartLegend"></div>
									</div>
								</div><!-- /box-body -->
							</div>
							<div class="table-header">
								<div class="table-tools"></div>
							</div>
							<div class="box list-box no-margin-top">
								<div class="box-header"></div>
								<div class="box-body no-padding list-body">
									<table class="table table-hover table-center table-striped table-bordered table-layout-fixed">
										<caption>업무가상서버현황</caption>
										<colgroup>
											<col width="80px"/>
											<c:forEach var="vo" items="${vmList }" varStatus="i">
												<col width="50px"/>
											</c:forEach>
										</colgroup>
										<thead>
											<tr>
												<th rowspan="2"></th>
												<c:set var="temp_vm_comp_id" value="" ></c:set>
												<c:choose>
													<c:when test="${searchVo.searchType eq 'A'}">
														<c:forEach var="vo" items="${vmList }" varStatus="i">
															<c:set var="vm_comp_id" value="${fn:split(vo.vm_comp_id, '||')[0]}"></c:set>
															<c:if test="${temp_vm_comp_id != vm_comp_id}">
																<c:set var="temp_vm_comp_id" value="${fn:split(vo.vm_comp_id, '||')[0]}" ></c:set>
																<th colspan="2" title="<c:out value="${fn:split(vo.vm_comp_id, '||')[0]}"/>"><c:out value="${fn:split(vo.vm_comp_id, '||')[0]}"/></th>
															</c:if>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<c:forEach var="vo" items="${vmList }" varStatus="i">
															<c:set var="vm_comp_id" value="${fn:split(vo.vm_comp_id, '||')[0]}"></c:set>
															<th title="<c:out value="${fn:split(vo.vm_comp_id, '||')[0]}"/>"><c:out value="${fn:split(vo.vm_comp_id, '||')[0]}"/></th>
														</c:forEach>
													</c:otherwise>
												</c:choose>
											</tr>
											<tr>
												<c:forEach var="vo" items="${vmList }" varStatus="i">
													<c:set var="vm_value_type" value="${fn:split(vo.vm_comp_id, '||')[1]}"></c:set>
													<th title="<c:out value="${fn:split(vo.vm_comp_id, '||')[1]}"/>">
														<div id="<c:out value="${fn:replace(vo.vm_comp_id, '||', '')}"/>" class="chartLegend"><span><i></i></span><c:out value="${fn:split(vo.vm_comp_id, '||')[1]}"/></div>
													</th>
												</c:forEach>
											</tr>
										</thead>
										<tbody>
											<c:choose>
												<c:when test="${vmList eq null or empty vmList }">
													<tr><td>검색된 데이터가 없습니다.</td></tr>
												</c:when>
												<c:otherwise>
													<c:forEach var="map" items="${useRtTopVmList }" varStatus="i">
														<tr>
<%-- 															<td class="ellipsis"><c:out value="${map['dt']}"/></td> --%>
															<td class="ellipsis">
															<c:choose>
																<c:when test="${map['dt'] eq 'AMIN'}">
																	<c:out value="${fn:replace(map['dt'], 'AMIN', '최소')}"/>
																</c:when>
																<c:when test="${map['dt'] eq 'BAVG'}">
																	<c:out value="${fn:replace(map['dt'], 'BAVG', '평균')}"/>
																</c:when>
																<c:when test="${map['dt'] eq 'CMAX'}">
																	<c:out value="${fn:replace(map['dt'], 'CMAX', '최대')}"/>
																</c:when>
																<c:otherwise></c:otherwise>
															</c:choose>
															</td>
															<c:forEach var="vmItem" items="${vmList }">
																<c:set var="vmSeq" value="${vmItem.vm_seq}"/>
																<td class="alignR">${map[vmSeq]}</td>
															</c:forEach>
														</tr>
													</c:forEach>
													<c:forEach var="map" items="${useRtVmList }" varStatus="i">
														<tr>
															<td class="ellipsis"><c:out value="${map['dt']}"/></td>
																<c:forEach var="vmItem" items="${vmList }">
																	<c:set var="vmSeq" value="${vmItem.vm_seq}"/>
																	<td class="alignR">${map[vmSeq]}</td>
																</c:forEach>
														</tr>
													</c:forEach>
												</c:otherwise>
											</c:choose>
										</tbody>
									</table>
								</div>
								<!-- box-body -->
								<!-- <div class="box-footer edit-btn-group">
									<ul class="pagination">
										<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
									</ul>
									<div class="pull-right btns">

									</div>
								</div>-->
							</div>
							<!-- box -->
						</section>
					</div>
					<!-- /tab-pane -->
					<!-- /tab-pane -->

					<div class="tab-pane" id="tab-b">
						<section>
							<div class="box">
								<div class="box-header">
									<h3 class="box-title">사용률</h3>
								</div><!-- /box-header -->
								<div class="box-body collapse in" id="graph-b">
									<div class="chart">
										<div>(%)</div>
											<canvas id="axlineChart" style="height:200px;"></canvas>
										<div class="chartLegend"></div>
									</div>
								</div><!-- /box-body -->
							</div>
							<div class="table-header">
								<div class="table-tools"></div>
							</div>
							<div class="box list-box no-margin-top">
								<div class="box-header"></div>
								<div class="box-body no-padding list-body">
									<table class="table table-hover table-center table-striped table-bordered table-layout-fixed">
										<caption>자동확장 서비스 현황</caption>
										<colgroup>
											<col width="80px"/>
											<c:forEach var="vo" items="${axList }" varStatus="i">
												<col width="50px"/>
											</c:forEach>
										</colgroup>
										<thead>
											<tr>
												<th rowspan="3"></th>
												<c:set var="temp_servc_nm" value="" ></c:set>
												<c:forEach var="vo" items="${axList }" varStatus="i">
													<c:set var="servc_nm" value="${vo.servc_nm}"></c:set>
													<c:if test="${temp_servc_nm != servc_nm}">
														<c:set var="temp_servc_nm" value="${vo.servc_nm}" ></c:set>
														<th colspan="${vo.pod_cnt}" title="<c:out value="${vo.servc_nm}"/>"><c:out value="${vo.servc_nm}"/></th>
													</c:if>
												</c:forEach>
											</tr>
											<tr>
												<c:set var="temp_pod_nm" value="" ></c:set>
												<c:choose>
													<c:when test="${searchVo.searchType eq 'A'}">
														<c:forEach var="vo" items="${axList }" varStatus="i">
															<c:set var="pod_nm" value="${fn:split(vo.pod_nm, '||')[0]}"></c:set>
															<c:if test="${temp_pod_nm != pod_nm}">
																<c:set var="temp_pod_nm" value="${fn:split(vo.pod_nm, '||')[0]}" ></c:set>
																<th colspan="2" title="<c:out value="${fn:split(vo.pod_nm, '||')[0]}"/>"><c:out value="${fn:split(vo.pod_nm, '||')[0]}"/></th>
															</c:if>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<c:forEach var="vo" items="${axList }" varStatus="i">
															<c:set var="pod_nm" value="${fn:split(vo.pod_nm, '||')[0]}"></c:set>
															<th title="<c:out value="${fn:split(vo.pod_nm, '||')[0]}"/>"><c:out value="${fn:split(vo.pod_nm, '||')[0]}"/></th>
														</c:forEach>
													</c:otherwise>
												</c:choose>
											</tr>
											<tr>
												<c:forEach var="vo" items="${axList }" varStatus="i">
													<c:set var="pod_value_type" value="${fn:split(vo.pod_nm, '||')[1]}"></c:set>
													<th title="<c:out value="${fn:split(vo.pod_nm, '||')[1]}"/>"><div id="<c:out value="${fn:replace(vo.pod_nm, '||', '')}"/>" class="chartLegend"><span><i></i></span><c:out value="${fn:split(vo.pod_nm, '||')[1]}"/></div>
													</th>
												</c:forEach>
											</tr>
										</thead>
										<tbody>
											<c:choose>
												<c:when test="${axList eq null or empty axList }">
													<tr><td>검색된 데이터가 없습니다.</td></tr>
												</c:when>
												<c:otherwise>
													<c:forEach var="map" items="${useRtTopAxList }" varStatus="i">
														<tr>
															<td class="ellipsis">
															<c:choose>
																<c:when test="${map['dt'] eq 'AMIN'}">
																	<c:out value="${fn:replace(map['dt'], 'AMIN', '최소')}"/>
																</c:when>
																<c:when test="${map['dt'] eq 'BAVG'}">
																	<c:out value="${fn:replace(map['dt'], 'BAVG', '평균')}"/>
																</c:when>
																<c:when test="${map['dt'] eq 'CMAX'}">
																	<c:out value="${fn:replace(map['dt'], 'CMAX', '최대')}"/>
																</c:when>
																<c:otherwise></c:otherwise>
															</c:choose>
															</td>
															<c:forEach var="axItem" items="${axList }">
																<c:set var="podId" value="${axItem.pod_id}"/>
																<td class="alignR">${map[podId]}</td>
															</c:forEach>
														</tr>
													</c:forEach>
													<c:forEach var="map" items="${useRtAxList }" varStatus="i">
														<tr>
															<td class="ellipsis"><c:out value="${map['dt']}"/></td>
																<c:forEach var="axItem" items="${axList }">
																	<c:set var="podId" value="${axItem.pod_id}"/>
																	<td class="alignR">${map[podId]}</td>
																</c:forEach>
														</tr>
													</c:forEach>
												</c:otherwise>
											</c:choose>
										</tbody>
									</table>
								</div>
								<!-- box-body -->
								<!-- <div class="box-footer edit-btn-group">
									<ul class="pagination">
										<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
									</ul>
									<div class="pull-right btns">

									</div>
								</div>-->
							</div>
							<!-- box -->
						</section>
					</div>
					<!-- /tab-pane -->
				</div>
				<!-- /tab-content -->
			</div>
			<!-- /nav-tabs-custom -->
		</div>
		<!-- /col -->

<script>
	var vmLineChartLine;
	var axLineChartLine;
	var vmLineChart;
	var axLineChart;
	$(function () {
		chartDraw();
	});

	function chartDraw(){
		var vmValArr =[];
		var maxVmUseRt=0;
		<c:forEach var="vmItem" items="${vmList }">
			<c:forEach var="useRtVmItem" items="${useRtVmList }">
				<fmt:formatNumber var="useRtVm" type="number" value="${useRtVmItem[vmItem.vm_seq]}"/>
				vmValArr.push(<c:out value='${useRtVm}'/>);
			</c:forEach>
		</c:forEach>

		maxVmUseRt = Math.max.apply(null,vmValArr);

		var vmAreaChartData = {
	      labels: [
	               	<c:forEach var="useRtVmItem" items="${useRtVmList }" varStatus="i">
	               		<c:if test="${i.count>1}">,</c:if>
	               		<c:choose>
		           			<c:when test='${searchVo.colctCd eq "MI" or searchVo.colctCd eq "HH"}'>
		           			"${fn:substringAfter(useRtVmItem.dt,' ')}"
		           			</c:when>
		           			<c:otherwise>"<c:out value='${useRtVmItem.dt}'/>"</c:otherwise>
	           			</c:choose>
	      			</c:forEach>
	               ],
	      datasets: [
			<c:forEach var="vmItem" items="${vmList }" varStatus="i">
				<c:if test="${i.count>1}">
					,
				</c:if>
					{
						label:"<c:out value='${fn:replace(vmItem.vm_comp_id, "||", " ")}'/>",
						data: [
						<c:forEach var="useRtVmItem" items="${useRtVmList }" varStatus="j">
							<c:if test="${j.count>1}">	,		</c:if>
							<fmt:formatNumber var="useRtVm" type="number" value="${useRtVmItem[vmItem.vm_seq]}"/>
							<c:choose>
								<c:when test="${empty useRtVmItem[vmItem.vm_seq]}">""</c:when>
								<c:otherwise><c:out value='${useRtVm}'/></c:otherwise>
							</c:choose>

						</c:forEach>
						]
					}
			</c:forEach>

	      ]
	    };
		setChartColor(vmAreaChartData,'line');

		var vmAreaChartOptions = {
			scaleOverride : true,
			scaleSteps: 5,
			scaleStepWidth : 20,
			showScale: true,
			scaleShowGridLines: true,
			scaleGridLineColor: "rgba(0,0,0,.05)",
			scaleGridLineWidth: 1,
			scaleShowHorizontalLines: true,
			scaleShowVerticalLines: true,
			bezierCurve: true,
			bezierCurveTension: 0.3,
			pointDot: false,
			pointDotRadius: 2,
			pointDotStrokeWidth: 2,
			pointHitDetectionRadius: 40,
			maintainAspectRatio: true,
			responsive: true
	    };
		$('#vmlineChart ~ .chartLegend').empty();
		vmAreaChartData.datasets.forEach(function(label, i){
			var arealegendItem = $('<span></span>').append('<i></i>' + label['label']);
			arealegendItem.find('i').css('background', vmAreaChartData.datasets[i].strokeColor);
			$('#vmlineChart ~ .chartLegend').append(arealegendItem);

			var labelItem = label['label'].replace(/ /g,'');
			$('#'+labelItem).find('i').css('background', vmAreaChartData.datasets[i].strokeColor);
		});

		//-------------
	    //- LINE CHART -
	    //--------------
		var vmLineChartCanvas = $("#vmlineChart").get(0).getContext("2d");
		<c:if test="${fn:length(vmList) > 0}">
			vmLineChart = new Chart(vmLineChartCanvas);
		    var vmLineChartOptions = vmAreaChartOptions;
		    //vmLineChartOptions.datasetFill = false;
		    vmLineChartOptions.scaleStepWidth=Math.floor(fn_getMaxScaleStepWidth(maxVmUseRt)/vmAreaChartOptions.scaleSteps);
		    vmLineChartLine = vmLineChart.Line(vmAreaChartData, vmLineChartOptions);
		</c:if>

		//10분단위일경우 시간단위로만 label을 출력함.
	    <c:if test="${searchVo.colctCd eq 'MI'}">
		    for(var i=0; i<vmAreaChartData.labels.length; i++){
		    	if(vmAreaChartData.labels[i].substring(3,5)!='00'){
		    		vmAreaChartData.labels[i]="";//값을 "" 으로 변경
		    	}
		    }
	    </c:if>

	    var axValArr =[];
		var maxAxUseRt=0;
		<c:forEach var="axItem" items="${axList }">
			<c:forEach var="useRtAxItem" items="${useRtAxList }">
				<fmt:formatNumber var="useRtAx" type="number" value="${useRtAxItem[axItem.pod_id]}"/>
				<c:choose>
					<c:when test="${empty useRtAx}">axValArr.push(0);</c:when>
					<c:otherwise>axValArr.push(<c:out value='${useRtAx}'/>);</c:otherwise>
				</c:choose>
	//				axValArr.push(<c:out value='${useRtAx}'/>);
			</c:forEach>
		</c:forEach>

		maxAxUseRt = Math.max.apply(null,axValArr);

	    var axAreaChartData = {
		      labels: [
		               	<c:forEach var="useRtAxItem" items="${useRtAxList }" varStatus="i">
		               		<c:if test="${i.count>1}">,</c:if>
		               		<c:choose>
			           			<c:when test='${searchVo.colctCd eq "MI" or searchVo.colctCd eq "HH"}'>
			           			"${fn:substringAfter(useRtAxItem.dt,' ')}"
			           			</c:when>
			           			<c:otherwise>"<c:out value='${useRtAxItem.dt}'/>"</c:otherwise>
		           			</c:choose>
		      			</c:forEach>
		               ],
		      datasets: [
				<c:forEach var="axItem" items="${axList }" varStatus="i">
					<c:if test="${i.count>1}">
						,
					</c:if>
						{
						label:"<c:out value='${fn:replace(axItem.pod_nm, "||", " ")}'/>",
						data: [
							<c:forEach var="useRtAxItem" items="${useRtAxList }" varStatus="j">
								<c:if test="${j.count>1}">	,		</c:if>
								<fmt:formatNumber var="useRtAx" type="number" value="${useRtAxItem[axItem.pod_id]}"/>
								<c:choose>
									<c:when test="${empty useRtAxItem[axItem.pod_id]}">""</c:when>
									<c:otherwise><c:out value='${useRtAx}'/></c:otherwise>
								</c:choose>
							</c:forEach>
							]
						}
				</c:forEach>

		      ]
		    };

		    setChartColor(axAreaChartData,'line');

	    var axAreaChartOptions = {
			scaleOverride : true,
			scaleSteps: 5,
			scaleStepWidth : 20,
			showScale: true,
			scaleShowGridLines: true,
			scaleGridLineColor: "rgba(0,0,0,.05)",
			scaleGridLineWidth: 1,
			scaleShowHorizontalLines: true,
			scaleShowVerticalLines: true,
			bezierCurve: true,
			bezierCurveTension: 0.3,
			pointDot: false,
			pointDotRadius: 2,
			pointDotStrokeWidth: 2,
			pointHitDetectionRadius: 40,
			maintainAspectRatio: true,
			responsive: true
	    };
	    $('#axlineChart ~ .chartLegend').empty();
	    axAreaChartData.datasets.forEach(function(label, i){
			var arealegendItem = $('<span></span>').append('<i></i>' + label['label']);
			arealegendItem.find('i').css('background', axAreaChartData.datasets[i].strokeColor);
			$('#axlineChart ~ .chartLegend').append(arealegendItem);

			var labelItem = label['label'].replace(/ /g,'');
			$('#'+labelItem).find('i').css('background', axAreaChartData.datasets[i].strokeColor);
		});

		//-------------
	    //- LINE CHART -
	    //--------------
	    var axLineChartCanvas = $("#axlineChart").get(0).getContext("2d");
	    <c:if test="${fn:length(axList) > 0}">
		    axLineChart = new Chart(axLineChartCanvas);
		    var axLineChartOptions = axAreaChartOptions;
		    //axLineChartOptions.datasetFill = false;
		    axLineChartOptions.scaleStepWidth=Math.floor(fn_getMaxScaleStepWidth(maxAxUseRt)/axAreaChartOptions.scaleSteps);
		    axLineChartLine = axLineChart.Line(axAreaChartData, axLineChartOptions);
	    </c:if>

		//10분단위일경우 시간단위로만 label을 출력함.
	    <c:if test="${searchVo.colctCd eq 'MI'}">
		    for(var i=0; i<axAreaChartData.labels.length; i++){
		    	if(axAreaChartData.labels[i].substring(3,5)!='00'){
		    		axAreaChartData.labels[i]="";//값을 "" 으로 변경
		    	}
		    }
	    </c:if>

	    function fn_getMaxScaleStepWidth(val){
			var retVal = (Math.floor(val/10)+1)*10;
			if(retVal>100){
				retVAl=100;
			}
			return retVal;
		}
	}

	//윈도우 resize 시, chart redraw 하도록
	//console.log(__resizeCheck + ' __resizeCheck');
	if (typeof __resizeCheck == 'undefined'|| __resizeCheck<1) {
		typeof __resizeCheck == 'undefined' ? (__resizeCheck=1) : __resizeCheck++;
		//console.log(__resizeCheck + ' __resizeCheck');
		$(window).off('resize',fn_chartResize);
		$(window).resize(fn_chartResize);
		/*
		$(window).resize(function(evt) {
			fn_chartResize(evt);
		}); */
	}
	//$(window).resize(fn_chartResize);
	function fn_chartResize(evt) {
	    if (vmLineChartLine != null) vmLineChartLine.destroy();
	    if (axLineChartLine != null) axLineChartLine.destroy();
	    _winHeight = $(window).height();
	    $('#vmlineChart').css('height', _winHeight>=850? '200px': '150px');
		$('#axlineChart').css('height', _winHeight>=850? '200px': '150px');
		setTimeout(function() {
	    	 _winHeight = $(window).height();
	 	    $('#vmlineChart').css('height', _winHeight>=850? '200px': '150px');
	 		$('#axlineChart').css('height', _winHeight>=850? '200px': '150px');
	    	//$('#vmlineChart, #axlineChart').height('200px');
	    	chartDraw();
	    	if(window.console) console.log(new Date().toLocaleString()+ ' resize event');
	    }, 200);

	}
	$(document).ready(function() {
		function pageInit() {
			$('#searchTrmCd').trigger('change');
			fn_dataTable("tableEvntNtceHistList", 0)//테이블 정렬및 resize
			//fn_setRegion2PoolCombo('regionId','zoneId','netId','rsrcPoolId');//리전/존/망/자원풀 select 셋팅
		}
		pageInit();

		$("#endDt").datepicker("option", "beforeShow", function(){
			var stxt = $("#strtDt").val().split("-");
			stxt[1] = stxt[1] -1;
			var sdate = new Date(stxt[0], stxt[1], stxt[2]);
			var mdate = new Date(stxt[0], stxt[1], stxt[2]);
			mdate.setDate(sdate.getDate()+6);
			$("#endDt").datepicker("option", "maxDate", mdate);
		});

		_winHeight = $(window).height();
		$('#vmlineChart').css('height', _winHeight>=850? '200px': '150px');
		$('#axlineChart').css('height', _winHeight>=850? '200px': '150px');
		//fn_chartResize();
		//fn_chartResize();
		//fn_chartResize();

//		isVmData = false, isAxData = true 일때만 tab-b 선택되도록 해야 함.
// 		var isVmData = false;
// 		var isAxData = false;
// 		<c:if test="${fn:length(vmList) > 0}">
// 			isVmData = true;
// 		</c:if>
// 		<c:if test="${fn:length(axList) > 0}">
// 			isAxData = true;
// 		</c:if>
// 		if(!isVmData && isAxData){
// 			$('#tab-b').show();
// 			$('#li-b').addClass('active');
// 			$('#li-a').removeClass('active');
// 			$('#tab-a').hide();
// 			excelDn="ax";
// 			fn_chartResize();
// 		}

		// 최초 페이지 로딩 시 적용하도록 함 (전월 선택)
		var s_MmCd = "${searchVo.searchMmCd}";
		if('' == s_MmCd){
			getBeforeMonth();
		}
	});

	// 검색조건 초기화
	function fn_reset() {
		//$("#searchVo input[type='text']").val("");
		$("#institutionNm").val("");
		$("#vmListNm").val("");
		$("#vmListId").val("");
		$("#weeklyDatePicker").val("");

		f_changeSearchTrmCd('DD');
		$('#searchTrmCd').val("DD").attr("selected","selected");
		$('#strtDt').val("");
		$('#endDt').val("");
		$('#year option:eq(0)').attr("selected","selected");
		$('#searchMmCd option:eq(0)').attr("selected","selected");
// 		$('#searchQqCd option:eq(0)').attr("selected","selected");
		$('#1h').prop("checked", "checked");
		$('#searchType').val("A").attr("selected","selected");
		$('#searchType option:eq(0)').attr("selected","selected");

		$('#date').val(getTodayDate());
		getBeforeMonth();
	}

	function f_changeSearchTrmCd(val) {
		var s_colctCd = "${searchVo.colctCd}";

		if (val == 'DD') {//일
			$('#divDD').show();
			$('#divMM').hide();
			$('#divYY').hide();
			$('#divDW').hide();
			$('#divDI').hide();
			$('#10m').prop("disabled", false);
			$('#1h').prop("disabled", false);
			$('#1d').prop("disabled", true);

			if('MI' != s_colctCd){
				if(($('#1d').prop("checked") == true) || ($('#10m').prop("checked") == true)){
		 			$('#1h').prop("checked", "checked");
				}
			}
		} else if (val == 'MM') {//월
			$('#divDD').hide();
			$('#divMM').show();
			$('#divYY').show();
			$('#divDW').hide();
			$('#divDI').hide();
			$('#10m').prop("disabled", true);
			$('#1h').prop("disabled", true);
			$('#1d').prop("disabled", false);

			if(($('#1h').prop("checked") == true) || ($('#10m').prop("checked") == true)){
				$('#1d').prop("checked", "checked");
			}
		} else if (val == 'DW') {//주
			$('#divDD').hide();
			$('#divMM').hide();
			$('#divYY').hide();
			$('#divDW').show();
			$('#divDI').hide();
			$('#10m').prop("disabled", false);
			$('#1h').prop("disabled", false);
			$('#1d').prop("disabled", false);

			if(s_colctCd != 'MI' && s_colctCd != 'DD'){
				if(($('#10m').prop("checked") == true) || ($('#1d').prop("checked") == true)){
		 			$('#1h').prop("checked", "checked");
				}
			}
		} else if (val == 'DI') {//직접입력
			$('#divDD').hide();
			$('#divMM').hide();
			$('#divYY').hide();
			$('#divDW').hide();
			$('#divDI').show();
			$('#10m').prop("disabled", false);
			$('#1h').prop("disabled", false);
			$('#1d').prop("disabled", false);

			if(s_colctCd != 'MI' && s_colctCd != 'DD'){
				if(($('#10m').prop("checked") == true) || ($('#1d').prop("checked") == true)){
		 			$('#1h').prop("checked", "checked");
				}
			}
		}
	}

	function goPage(page) {
		location.href = "selectJobResStteListByOnnara.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
	}

	function fn_search() {
		if (!fn_form_validation("searchVo")) {
			return;
		}
		var val = $('#searchTrmCd').val();
		var vmNm = $('#vmListNm').val();

		if(vmNm == ''){ // 전체검색하려는 경우
			alert('조회할 가상서버를 선택해 주시기 바랍니다.', function(){
				$('#vmListNm').focus();
			});
			return false;
		}

		if (val == 'DD') {//일
			if ($('#date').val() == '') {
				jAlert('검색일자를 입력하시기 바랍니다.', function() {
					$('#date').focus();
				});
				return false;
			}
		} else if (val == 'DW') {//일
			if ($('#weeklyDatePicker').val() == '') {
				jAlert('검색일자를 입력하시기 바랍니다.', function() {
					$('#weeklyDatePicker').focus();
				});
				return false;
			}
		} else if (val == 'DI') {//일
			if ($('#strtDt').val() == '') {
				jAlert('검색시작일자를 입력하시기 바랍니다.', function() {
					$('#strtDt').focus();
				});
				return false;
			}
			if ($('#endDt').val() == '') {
				jAlert('검색종료일자를 입력하시기 바랍니다.', function() {
					$('#endDt').focus();
				});
				return false;
			}
		}

 		// 날짜 비교
		var strtDate = $("#strtDt").val().split("-");
		var endDate = $("#endDt").val().split("-");

		strtDate[1] = (Number(strtDate[1])-1) + "";
		endDate[1] = (Number(endDate[1])-1) + "";

		var from_dt = new Date(strtDate[0], strtDate[1], strtDate[2]);
		var to_dt = new Date(endDate[0], endDate[1], endDate[2]);
		var diff = to_dt.getTime() - from_dt.getTime();
		var currDay = 24 * 60 * 60 * 1000;

		//console.log('to_dt.getTime() = ' + to_dt.getTime());
		//console.log('from_dt.getTime() = ' + from_dt.getTime());
		//console.log('diff = ' + diff);
		//console.log('currDay = ' + currDay);
		//console.log('parseInt(diff/currDay) = '+ parseInt(diff/currDay));

		if(parseInt(diff/currDay) < 0){
			alert("시작날짜가 종료날짜보다 늦을 수 없습니다.");
			return false;
		}

		if(parseInt(diff/currDay) > 6){
			alert("날짜 간격은 7일을 넘을 수 없습니다.");
			return false;
		}

		searchVo.target = '_self';
		searchVo.action = '<c:url value="selectJobResStteListByOnnara.do" />';
		searchVo.submit();
	}

	function excelDown() {
		if(excelDn == 'vm'){
			<c:if test="${ vmList eq null or empty vmList }">
				jAlert("엑셀로 다운로드할 데이터가 없습니다.");
				return;
			</c:if>

			searchVo.action = '<c:url value="selectJobResStteListByOnnaraVmXlsDown.do" />';
			searchVo.submit();
		}else if(excelDn == 'ax'){
			<c:if test="${ axList eq null or empty axList }">
				jAlert("엑셀로 다운로드할 데이터가 없습니다.");
				return;
			</c:if>
			searchVo.action = '<c:url value="selectJobResStteListByOnnaraAxXlsDown.do" />';
			searchVo.submit();
		}
	}

	function job_excelDown() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selectJobResStteListXlsDown.do" />';
		searchVo.submit();
	}

	function vm_excelDown() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selectVmResStteListXlsDown.do" />';
		searchVo.submit();
	}
	function ax_excelDown() {
		<c:if test="${ listAx eq null or empty listAx }">
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		</c:if>
		searchVo.action = '<c:url value="selectAxResStteListXlsDown.do" />';
		searchVo.submit();
	}
	function openInsttMultiSearchByOnnara(){
		var searchOnnara = 'Y';
		var url = contextPath+"/cmn/component/dsb/selectInsttDetailListP.do?searchOnnara="+searchOnnara;
		var params = {"searchType" : "M"};
		var args = {key:"selectInstitutionMulti", width:740,height:820};
		windowOpen(url, params, args);
	}

	$(function(){
		var startDate;
		var endDate;
		$("#weeklyDatePicker").datepicker({
			showOtherMonths: true,
			selectOhterMonths: true,
			selectWeek:true,
			onSelect:function(dateText, inst){
				var date = $(this).datepicker('getDate');
				startDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() - date.getDay());
				endDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() - date.getDay() + 6);
				var dateFormat = 'yy-mm-dd';
				startDate = $.datepicker.formatDate(dateFormat, startDate, inst.settings);
				endDate = $.datepicker.formatDate(dateFormat, endDate, inst.settings);
				$("#weeklyDatePicker").val(startDate+'  ~  '+endDate);
				setTimeout("applyWeeklyHighlight()", 100);
			},
			beforeShow: function(){
				setTimeout("applyWeeklyHighlight()", 100);
			}
		});
	});

	function applyWeeklyHighlight(){
		$('.ui-datepicker-calendar tr').each(function(){
			if($(this).parent().get(0).tagName == 'TBODY'){
				$(this).mouseover(function(){
					$(this).find('a').css({
						'background': '$808080',
						'border': '1px solid #dddddd'
					});
					$(this).find('a').removeClass('ui-sate-default');
					$(this).css('background', '#ffffcc');
				});
				$(this).mouseout(function(){
					$(this).css('background', '#ffffff');
					$(this).find('a').css('background', '');
					$(this).find('a').addClass('ui-state-default');
				});
			}
		});
	}

	function getTodayDate(){
		var today = new Date();
		var dd = today.getDate()-1;
		var mm = today.getMonth()+1;
		var yyyy = today.getFullYear();

		if(dd < 10){
			dd = "0" + dd;
		}

		if(mm < 10){
			mm = "0" + mm;
		}

		today = yyyy + "-" + mm + "-" + dd;
		return today;
	}

	function getBeforeMonth(){
		var date = new Date();
		var firstDayOfMonth = new Date(date.getFullYear(), date.getMonth(), 1);
		var lastMonth = new Date(firstDayOfMonth.setDate(firstDayOfMonth.getDate()-1));

		var year = lastMonth.getFullYear();
		var month = lastMonth.getMonth() + 1;

		$("#year").val(year).attr("selected","selected");
		$("#searchMmCd").val(month).attr("selected","selected");
	}
</script>