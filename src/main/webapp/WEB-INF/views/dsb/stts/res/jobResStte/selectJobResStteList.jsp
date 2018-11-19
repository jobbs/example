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
	$(document).bind('selectInstitutionMulti',setInstitutions);
	var excelDn="job";
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


	function fn_search() {
		if (!fn_form_validation("searchVo")) {
			return;
		}

		searchVo.action = '<c:url value="selectJobResStteList.do" />';
		searchVo.submit();
	}

	function f_tabView(tabId) {
		$('#' + tabId).show();
		if (tabId == 'tab-a') {
			$('#li-a').addClass('active');
			$('#li-b').removeClass('active');
			$('#li-c').removeClass('active');
			$('#tab-b').hide();
			$('#tab-c').hide();
			excelDn="job";
		}else if(tabId == 'tab-b') {
			$('#li-b').addClass('active');
			$('#li-a').removeClass('active');
			$('#li-c').removeClass('active');
			$('#tab-a').hide();
			$('#tab-c').hide();
			excelDn="vm";
		}else{
			$('#li-c').addClass('active');
			$('#li-a').removeClass('active');
			$('#li-b').removeClass('active');
			$('#tab-a').hide();
			$('#tab-b').hide();
			excelDn="ax";
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
							<div class="form-cell form-cell-50 col-lay-50">
								<div class="cell-title">
									<label title="부처명" for="institutionNm">부처명</label>
								</div>
								<div class="cell-body">
									<div class="input-group">
										<form:input type="text" path="institutionNm" cssClass="form-control input-sm " title="부처명" readonly="true" /><!-- essential -->
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
										<form:select path="searchTrmCd" cssClass="form-control input-sm" title="통보상태" onchange="f_changeSearchTrmCd(this.value)">
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
		<div class="col-box-100 ">
			<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
			<!-- box(목록조회 테이블) -->
			<div class="nav-tabs-custom">
				<ul class="nav nav-tabs">
					<li id="li-a" class="active"><a href="javascript:f_tabView('tab-a')">업무자원현황</a></li>
					<!--  data-toggle="tab" -->
					<li id="li-b"><a href="javascript:f_tabView('tab-b')">업무가상서버현황</a></li>
					<!--  data-toggle="tab" -->
					<li id="li-c"><a href="javascript:f_tabView('tab-c')">자동확장 서비스 현황</a></li>
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
							<div class="box list-box no-margin-top">
								<div class="box-header">
									<!-- <h3 class="box-title">전체 :  건</h3> -->
									<!-- <div class="box-tools">
										<div class="input-group-box">
											<div class="input-group-cell">
												<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="job_excelDown()">
													<i class="fa fa-download"></i>
												</button>
											</div>
										</div>
									</div>
									 -->
								</div>
								<div class="box-body no-padding list-body">
									<table class="table table-hover table-center table-striped table-bordered table-layout-fixed">
										<caption>업무자원현황</caption>
										<colgroup>
											<col width="100px"><!-- 부처명 -->
											<col width="150px"><!-- 업무명 -->
											<col width="50px"><!-- 가상서버수 -->
											<col width="50px">
											<col width="50px">
											<col width="50px">
											<col width="50px">
											<col width="50px"> <!--자동확장수  -->
											<col width="55px">
											<col width="50px"><!-- OS -->
											<col width="55px">
											<col width="50px">
											<col width="80px">
											<col width="80px">
											<col width="50px">
											<col width="100px"> <!-- web -->
											<col width="100px">
											<col width="100px">
											<col width="100px"> <!-- was -->
											<col width="100px">
											<col width="100px">
											<col width="100px"> <!-- db -->
											<col width="100px">
											<col width="100px">
											<col width="100px"> <!-- win -->
											<col width="100px">
											<col width="100px">
											<col width="100px"> <!-- test -->
											<col width="100px">
											<col width="100px">
											<col width="100px"><!-- 자동확장 -->
											<col width="100px">
											<col width="100px">
										</colgroup>
										<thead>
											<tr>
												<th rowspan="2">부처명</th>
												<th rowspan="2">업무명</th>
												<th colspan="5">가상서버수</th>
												<th colspan="2">자동확장수</th>
												<th colspan="6">OS</th>
												<th colspan="3">WEB(할당량/사용률)</th>
												<th colspan="3">WAS(할당량/사용률)</th>
												<th colspan="3">DB(할당량/사용률)</th>
												<th colspan="3">WIN(할당량/사용률)</th>
												<th colspan="3">TEST(할당량/사용률)</th>
												<th colspan="3">자동확장(할당량/사용률)</th>

											</tr>
											<tr>
												<th>WEB</th>
												<th>WAS</th>
												<th>DB</th>
												<th>WIN</th>
												<th>TEST</th>
												<th>서비스수</th>
												<th>POD수</th>
												<th>LINUX</th>
												<th>HP-UX</th>
												<th>AIX</th>
												<th title="WINDOWS">WINDOWS</th>
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
												<th>CPU(Core)</th>
												<th>메모리(GB)</th>
												<th>스토리지(GB)</th>

											</tr>
										</thead>
										<tbody>
											<c:choose>
												<c:when test="${ list eq null or empty list }">
													<tr>
														<td colspan="26">
															<c:choose>
																<c:when test="${searchVo.jobId eq null or empty searchVo.jobId }">
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
													<c:set var="tempInstitutionId" value="" />
													<c:forEach var="vo" items="${list}" varStatus="ri">
														<tr>
															<c:if test="${tempInstitutionId != vo.institutionId}">
														  		<c:set var="tempInstitutionId" value="${vo.institutionId }" />
														  		<td <c:if test="${vo.institutionCnt >1}">rowspan="${vo.institutionCnt}" </c:if> class="alignL notellipsis">
														  		<c:choose>
														  			<c:when test="${vo.institutionNm eq '히히히'}">
														  				미할당
														  			</c:when>
														  			<c:otherwise>
														  				<c:out value="${vo.institutionNm }" />
														  			</c:otherwise>
														  		</c:choose>
														  		</td>
														  	</c:if>
															<td class="alignL notellipsis">
															<c:choose>
														  		<c:when test="${vo.jobNm eq '히히히'}">
														  			미할당
														  		</c:when>
														  		<c:otherwise>
														  			<c:out value="${vo.jobNm }" />
														  		</c:otherwise>
														  	</c:choose>
															<td class="alignR"><fmt:formatNumber value="${vo.web}" pattern="#,###" /></td>
															<td class="alignR"><fmt:formatNumber value="${vo.was}" pattern="#,###" /></td>
															<td class="alignR"><fmt:formatNumber value="${vo.db}" pattern="#,###" /></td>
															<td class="alignR"><fmt:formatNumber value="${vo.win}" pattern="#,###" /></td>
															<td class="alignR"><fmt:formatNumber value="${vo.test}" pattern="#,###" /></td>
															<td class="alignR"><fmt:formatNumber value="${vo.servcCnt }" pattern="#,###" /></td>
															<td class="alignR"><fmt:formatNumber value="${vo.podQty }" pattern="#,###" /></td>
															<td class="alignR"><fmt:formatNumber value="${vo.osLinux}" pattern="#,###" /></td>
															<td class="alignR"><fmt:formatNumber value="${vo.osHp}" pattern="#,###" /></td>
															<td class="alignR"><fmt:formatNumber value="${vo.osAix}" pattern="#,###" /></td>
															<td class="alignR notellipsis"><fmt:formatNumber value="${vo.osWin}" pattern="#,###" /></td>
															<td class="alignR"><fmt:formatNumber value="${vo.osSolaris}" pattern="#,###" /></td>
															<td class="alignR"><fmt:formatNumber value="${vo.osEtc}" pattern="#,###" /></td>
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
															<td class="alignR notellipsis"><fmt:formatNumber value="${vo.cpuCorQty }" pattern="#,###.##" />
																<c:if test="${vo.avgCpuUseRt != null}">(<c:out value="${vo.avgCpuUseRt}" />%)</c:if></td>
															<td class="alignR notellipsis"><fmt:formatNumber value="${vo.memTotCapa }" pattern="#,###.##" />
																<c:if test="${vo.avgMemUseRt != null}">(<c:out value="${vo.avgMemUseRt}" />%)</c:if></td>
															<td class="alignR notellipsis"><fmt:formatNumber value="${vo.strgTotCapa }" pattern="#,###.##" /></td>
														</tr>
													</c:forEach>
												</c:otherwise>
											</c:choose>
										</tbody>
									</table>
								</div>
								<!-- box-body -->
							</div>
							<!--  list-box -->

						</section>
					</div>
					<!-- /tab-pane -->

					<div class="tab-pane" id="tab-b">
						<section>

							<div class="table-header">

								<div class="table-tools"></div>
							</div>
							<div class="box list-box no-margin-top">

								<div class="box-header">
									<!--<h3 class="box-title">전체 : ${searchVo.paginationInfo.totalRecordCount } 건</h3>-->
									<!--  <div class="box-tools">
										<div class="input-group-box">
											<div class="input-group-cell">
												<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="vm_excelDown()">
													<i class="fa fa-download"></i>
												</button>
											</div>
										</div>
									</div>-->
								</div>

								<!--                 <div class="box-header"> -->
								<!-- 			      <h3 class="box-title">업무가상서버현황 <small>1 / 1, 총 1건</small></h3> -->
								<!-- 			    </div> -->
								<div class="box-body no-padding list-body">
									<table class="table table-hover table-center table-striped table-bordered table-layout-fixed">
										<caption>업무가상서버현황</caption>
										<colgroup>
											<col width="120px">
											<col width="120px">
											<col width="40px">
											<col width="60px">
											<col width="60px">
											<col width="60px">
											<col width="60px">
											<col width="80px">
											<col width="80px">
											<col width="90px">
											<col width="120px"> <!-- 가상서버명 -->
											<col width="80px">
											<col width="100px"> <!-- 호스트명 -->
											<col width="80px">
											<col width="80px">
											<col width="80px">
											<col width="80px">
											<col width="60px"> <!-- 센터 -->
											<col width="60px">
											<col width="70px">
											<col width="90px">
											<col width="70px">
											<col width="100px">
											<col width="70px">
										</colgroup>
										<thead>
											<tr>
												<th rowspan="2">부처명</th>
												<th rowspan="2">업무명</th>
												<th rowspan="2">가상<br/>서버수</th>
												<th colspan="3">업무별평균사용률</th>
												<th rowspan="2">용도</th>
												<th colspan="3">용도별 평균 사용률</th>
												<th colspan="7">업무사용률</th>
												<th rowspan="2">센터</th>
												<th rowspan="2">존</th>
												<th rowspan="2">망</th>
												<th rowspan="2">자원풀명</th>
												<th rowspan="2">자원풀용도</th>
												<th rowspan="2">물리서버명</th>
												<th rowspan="2" title="물리서버구성ID">물리서버구성ID</th>
											</tr>
											<tr>
												<th>CPU</th>
												<th>메모리</th>
												<th>스토리지</th>
												<th>CPU(vCore)</th>
												<th>메모리(GB)</th>
												<th>스토리지(GB)</th>
												<th>가상서버명</th>
												<th title="가상서버구성ID">가상서버구성ID</th>
												<th>호스트명</th>
												<th>CPU(vCore)</th>
												<th>메모리(GB)</th>
												<th>스토리지(GB)</th>
												<th title="네트워크(In/Out)(KB/s)">네트워크(In/Out)(KB/s)</th>

											</tr>
										</thead>
										<tbody>
											<c:choose>
												<c:when test="${ listVm eq null or empty listVm }">
													<tr>
														<td colspan="26">검색된 데이터가 없습니다.</td>
													</tr>
												</c:when>
												<c:otherwise>
												  <c:set var="tempInstitutionId" value="" />
												  <c:set var="tempJobId" value="" />
												  <c:set var="tempCd" value="" />
													<c:forEach var="vo" items="${listVm}" varStatus="ri">

														<tr>
														  <c:if test="${tempInstitutionId != vo.institutionId}">
														  	<c:set var="tempInstitutionId" value="${vo.institutionId }" />
														  	<td <c:if test="${vo.institutionCnt >1}">rowspan="${vo.institutionCnt}" </c:if> class="alignL notellipsis"><c:out value="${vo.institutionNm }" /></td>
														  </c:if>
														  <c:if test="${tempJobId != vo.jobId}">
														    	<c:set var="tempJobId" value="${vo.jobId }" />
																<td <c:if test="${vo.jobCnt >1}">rowspan="${vo.jobCnt}" </c:if> class="alignL notellipsis">
																	<a href="javascript:fn_openJobTimeResUseRt('<c:out value="${vo.jobId }" />','<c:out value="${vo.jobNm }" />');"><c:out value="${vo.jobNm }" /></a>
																</td>
																<td <c:if test="${vo.jobCnt >1}">rowspan="${vo.jobCnt}" </c:if> class="alignR "><fmt:formatNumber value="${vo.vmCnt}" pattern="#,###" /></td>
																<td <c:if test="${vo.jobCnt >1}">rowspan="${vo.jobCnt}" </c:if> class="alignR"><c:out value="${vo.jobAvgCpuUseRt }" />%</td>
																<td <c:if test="${vo.jobCnt >1}">rowspan="${vo.jobCnt}" </c:if> class="alignR"><c:out value="${vo.jobAvgMemUseRt }" />%</td>
																<td <c:if test="${vo.jobCnt >1}">rowspan="${vo.jobCnt}" </c:if> class="alignR"><c:out value="${vo.jobAvgStrgUseRt }" />%</td>
															</c:if>
															<c:if test="${tempCd != vo.cd}">
																<c:set var="tempCd" value="${vo.cd }" />
																<td <c:if test="${vo.cdCnt >1}">rowspan="${vo.cdCnt}" </c:if> class="alignL notellipsis"><c:out value="${vo.cdNm }" /></td>
																<td <c:if test="${vo.cdCnt >1}">rowspan="${vo.cdCnt}" </c:if> class="alignR notellipsis">
																	<fmt:formatNumber value="${vo.cdLastVcoreQty}" pattern="#,###" />
																	<c:if test="${vo.cdAvgCpuUseRt != null}">(<c:out value="${vo.cdAvgCpuUseRt }" />%)</c:if>
																</td>
																<td <c:if test="${vo.cdCnt >1}">rowspan="${vo.cdCnt}" </c:if> class="alignR notellipsis">
																	<fmt:formatNumber value="${vo.cdLastMemSumCapa}" pattern="#,###" />
																	<c:if test="${vo.cdAvgMemUseRt != null}">(<c:out value="${vo.cdAvgMemUseRt }" />%)</c:if>
																</td>
																<td <c:if test="${vo.cdCnt >1}">rowspan="${vo.cdCnt}" </c:if> class="alignR notellipsis">
																	<fmt:formatNumber value="${vo.cdLastStrgSumCapa}" pattern="#,###" />
																	<c:if test="${vo.cdAvgStrgUseRt != null}">(<c:out value="${vo.cdAvgStrgUseRt }" />%)</c:if>
																</td>
															</c:if>
															<td class="alignL notellipsis"><a href="javascript:fn_openVmTimeResUseRt('<c:out value="${vo.vmSeq }" />','<c:out value="${vo.vmNm }" />');"><c:out value="${vo.vmNm }" /></a></td>
															<td class="alignL notellipsis"><c:out value="${vo.vmCompId }" /></td>
															<td class="alignL notellipsis"><c:out value="${vo.hstNm }" /></td>
															<td class="alignR notellipsis"><fmt:formatNumber value="${vo.lastVcoreQty}" pattern="#,###" />
																<c:if test="${vo.avgCpuUseRt != null}">(<c:out value="${vo.avgCpuUseRt }" />%)</c:if></td>
															<td class="alignR notellipsis"><fmt:formatNumber value="${vo.lastMemSumCapa}" pattern="#,###" />
																<c:if test="${vo.avgMemUseRt != null}">(<c:out value="${vo.avgMemUseRt }" />%)</c:if></td>
															<td class="alignR notellipsis"><fmt:formatNumber value="${vo.lastStrgSumCapa}" pattern="#,###" />
																<c:if test="${vo.avgStrgUseRt != null}">(<c:out value="${vo.avgStrgUseRt }" />%)</c:if></td>
															<td class="alignR notellipsis"><c:out value="${vo.avgInTrfic }" />
																<c:if test="${vo.avgOutTrfic != null}">/ <c:out value="${vo.avgOutTrfic }" />
																</c:if></td>
															<td class="alignC notellipsis"><c:out value="${vo.regionNm }" /></td>
															<td class="alignC notellipsis"><c:out value="${vo.zoneNm }" /></td>
															<td class="alignC notellipsis"><c:out value="${vo.netNm }" /></td>
															<td class="alignL notellipsis"><c:out value="${vo.rsrcPoolNm }" /></td>
															<td class="alignL notellipsis"><c:out value="${vo.cdNm }" /></td>
															<td class="alignL notellipsis"><c:out value="${vo.pmNm }" /></td>
															<td class="alignC"><c:out value="${vo.pmCompId }" /></td>
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

					<div class="tab-pane" id="tab-c">
						<section>

							<div class="table-header">

								<div class="table-tools"></div>
							</div>
							<div class="box list-box no-margin-top">

								<div class="box-header">
									<!--<h3 class="box-title">전체 : ${searchVo.paginationInfo.totalRecordCount } 건</h3>-->
									<!--  <div class="box-tools">
										<div class="input-group-box">
											<div class="input-group-cell">
												<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="ax_excelDown()">
													<i class="fa fa-download"></i>
												</button>
											</div>
										</div>
									</div>-->
								</div>

								<!--                 <div class="box-header"> -->
								<!-- 			      <h3 class="box-title">업무가상서버현황 <small>1 / 1, 총 1건</small></h3> -->
								<!-- 			    </div> -->
								<div class="box-body no-padding list-body">
									<table class="table table-hover table-center table-striped table-bordered table-layout-fixed">
										<caption>자동확장 서비스 현황</caption>
										<colgroup>
											<col width="120px"><!-- 부처명 -->
											<col width="130px">
											<col width="140px">
											<col width="60px">
											<col width="100px"><!--서비스별할당량/평균사용률(CPU)  -->
											<col width="100px">
											<col width="100px">
											<col width="80px">
											<col width="80px">
											<col width="100px"><!--POD할당량/평균사용률(CPU)  -->
											<col width="100px">
											<col width="100px">
											<col width="80px">
											<col width="80px">
											<col width="230px"><!-- POD명 -->
											<col width="60px">
											<col width="60px">
											<col width="70px"> <!-- 망 -->
											<col width="80px">
											<col width="120px">

										</colgroup>
										<thead>
											<tr>
												<th rowspan="3">부처명</th>
												<th rowspan="3">업무명</th>
												<th rowspan="3">서비스명</th>
												<th rowspan="3">POD수</th>
												<th colspan="5">서비스별할당량/평균사용률</th>
												<th colspan="6">POD할당량/평균사용률</th>
												<th rowspan="3">센터</th>
												<th rowspan="3">존</th>
												<th rowspan="3">망</th>
												<th rowspan="3">자원풀명</th>
												<th rowspan="3">서비스노드명</th>
											</tr>
											<tr>
												<th rowspan="2">CPU</th>
												<th rowspan="2">메모리(GB)</th>
												<th rowspan="2">스토리지(GB)</th>
												<th colspan="2">네트워크(In/Out)</th>
												<th rowspan="2">CPU(Core)</th>
												<th rowspan="2">메모리(GB)</th>
												<th rowspan="2">스토리지(GB)</th>
												<th colspan="2">네트워크(In/Out)</th>
												<th rowspan="2">POD명</th>
											</tr>
											<tr>
											   <th>In(KB/s)</th>
											   <th>Out(KB/s)</th>

											   <th>In(KB/s)</th>
											   <th>Out(KB/s)</th>
											</tr>

										</thead>
										<tbody>
											<c:choose>
												<c:when test="${ listAx eq null or empty listAx }">
													<tr>
														<td colspan="26">검색된 데이터가 없습니다.</td>
													</tr>
												</c:when>
												<c:otherwise>
												  <c:set var="tempAxInstitutionId" value="" />
												  <c:set var="tempAxJobId" value="" />
												  <c:set var="tempAxServcSeq" value="" />
													<c:forEach var="vo" items="${listAx}" varStatus="ri">

														<tr>
														<c:if test="${tempAxInstitutionId != vo.institutionId}">
															<c:set var="tempAxInstitutionId" value="${vo.institutionId }" />
														  <td <c:if test="${vo.institutionCnt >1 or vo.institutionCnt == 0 }">rowspan="${vo.institutionCnt}" </c:if> class="alignL notellipsis">
														  	<c:choose>
														  		<c:when test="${vo.institutionNm eq '히히히'}">
														  			미할당
														  		</c:when>
														  		<c:otherwise>
														  			<c:out value="${vo.institutionNm }" />
														  		</c:otherwise>
														  	</c:choose>
														  </td>
														</c:if>
														<c:if test="${tempAxJobId != vo.jobId}">
															<c:set var="tempAxJobId" value="${vo.jobId }" />
															<td <c:if test="${vo.jobCnt >1}">rowspan="${vo.jobCnt}" </c:if> class="alignL notellipsis">
															<c:choose>
														  		<c:when test="${vo.jobNm eq '히히히'}">
														  			미할당
														  		</c:when>
														  		<c:otherwise>
														  			<c:out value="${vo.jobNm }" />
														  		</c:otherwise>
														  	</c:choose>
															</td>
														</c:if>

														  <c:if test="${tempAxServcSeq != vo.servcSeq}">
														    	<c:set var="tempAxServcSeq" value="${vo.servcSeq }" />
																<td <c:if test="${vo.servcCnt >1}">rowspan="${vo.servcCnt}" </c:if> class="alignL notellipsis">
																	<a href="javascript:fn_openAxTimeResUseRt('<c:out value="${vo.servcSeq }" />','<c:out value="${vo.servcNm }" />');"><c:out value="${vo.servcNm }" /></a>
																</td>
																<td <c:if test="${vo.servcCnt >1}">rowspan="${vo.servcCnt}" </c:if> class="alignR"><fmt:formatNumber value="${vo.podQty}" pattern="#,###" /></td>
																<td <c:if test="${vo.servcCnt >1}">rowspan="${vo.servcCnt}" </c:if> class="alignR"><fmt:formatNumber value="${vo.servcCpuCorQty}" pattern="#,###.##" /><c:if test="${vo.servcAvgCpuUseRt != null}">(<c:out value="${vo.servcAvgCpuUseRt}" />%)</c:if> </td>
																<td <c:if test="${vo.servcCnt >1}">rowspan="${vo.servcCnt}" </c:if> class="alignR"><fmt:formatNumber value="${vo.servcMemTotCapa}" pattern="#,###" /><c:if test="${vo.servcAvgMemUseRt != null}">(<c:out value="${vo.servcAvgMemUseRt }" />%)</c:if></td>
																<td <c:if test="${vo.servcCnt >1}">rowspan="${vo.servcCnt}" </c:if> class="alignR"><fmt:formatNumber value="${vo.servcStrgTotCapa}" pattern="#,###" /></td>
																<td <c:if test="${vo.servcCnt >1}">rowspan="${vo.servcCnt}" </c:if> class="alignR"><fmt:formatNumber value="${vo.servcAvgInTrfic}" pattern="#,###.##" /></td>
																<td <c:if test="${vo.servcCnt >1}">rowspan="${vo.servcCnt}" </c:if> class="alignR"><fmt:formatNumber value="${vo.servcAvgOutTrfic}" pattern="#,###.##" /></td>
															</c:if>
															<td class="alignR"><fmt:formatNumber value="${vo.podCpuCorQty}" pattern="#,###.##" /><c:if test="${vo.podAvgCpuUseRt != null}">(<c:out value="${vo.podAvgCpuUseRt}" />%)</c:if></td>
															<td class="alignR"><fmt:formatNumber value="${vo.podMemTotCapa}" pattern="#,###" /><c:if test="${vo.podAvgMemUseRt != null}">(<c:out value="${vo.podAvgMemUseRt }" />%)</c:if></td>
															<td class="alignR"><fmt:formatNumber value="${vo.podStrgTotCapa}" pattern="#,###" /></td>
															<td class="alignR"><fmt:formatNumber value="${vo.podAvgInTrfic}" pattern="#,###.##" /></td>
															<td class="alignL notellipsis"><fmt:formatNumber value="${vo.podAvgOutTrfic}" pattern="#,###.##" /></td>
															<td class="alignL notellipsis"><c:out value="${vo.podNm }" /></td>
															<td class="alignC notellipsis"><c:out value="${vo.regionNm }" /></td>
															<td class="alignC notellipsis"><c:out value="${vo.zoneNm }" /></td>
															<td class="alignC notellipsis"><c:out value="${vo.netNm }" /></td>
															<td class="alignL notellipsis"><c:out value="${vo.rsrcPoolNm }" /></td>
															<td class="alignL notellipsis"><c:out value="${vo.atmsclNodeNm }" /></td>
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
	$(document).ready(function() {

		function pageInit() {
			$('#searchTrmCd').trigger('change');
			fn_dataTable("tableEvntNtceHistList", 0)//테이블 정렬및 resize
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
		searchVo.action = '<c:url value="selectJobResStteList.do" />';
		searchVo.submit();
	}

	function excelDown() {
		if(excelDn == 'job'){
			if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
				jAlert("엑셀로 다운로드할 데이터가 없습니다.");
				return;
			}
			searchVo.action = '<c:url value="selectJobResStteListXlsDown.do" />';
			searchVo.submit();
		}else if(excelDn == 'vm'){
			if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
				jAlert("엑셀로 다운로드할 데이터가 없습니다.");
				return;
			}
			searchVo.action = '<c:url value="selectVmResStteListXlsDown.do" />';
			searchVo.submit();
		}else{
			<c:if test="${ listAx eq null or empty listAx }">
				jAlert("엑셀로 다운로드할 데이터가 없습니다.");
				return;
			</c:if>
			searchVo.action = '<c:url value="selectAxResStteListXlsDown.do" />';
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
</script>