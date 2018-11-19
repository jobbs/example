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

<form:form commandName="searchVo" method="get">
<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
<input type="hidden" name="search" value="T">

<!-- col-box : 기본적으로 해당 가로사이즈(%)를 유지합니다. -->
<div class="col-box-100 search-col">
	<div class="box box-search">
		<div class="box-header">
			<h3 class="box-title">검색조건</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
					<i class="fa fa-chevron-up" data-toggle="tooltip" data-original-title="접어두기"></i>
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
							onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netId', 'rsrcPoolId', {searchPoolTypeCd : 'AUTO','searchCtlTrgtYn' : 'Y'})"
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
							value="${searchVo.rsrcPoolId}"
							regionId="${searchVo.regionId}"
							zoneId="${searchVo.zoneId}"
							netClCd="${searchVo.netId}"
							cssClass="form-control input-sm"
							title="자원풀" />

					</div>
				</div>

				<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
				<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
				<div class="form-cell form-cell-100 col-lay-50">
					<div class="cell-title">
						<label title="분석기준" for="searchTrmCd">분석기준</label>
					</div>
					<div class="cell-body">
						<div class="input-group-box">
							<div class="input-group-cell pad-right-5">
								<div class="input-group">
									<form:select path="searchTrmCd" cssClass="form-control input-sm" title="통보상태" onchange="f_changeSearchTrmCd(this.value)">
										<form:option value="DD">일</form:option>
										<form:option value="MM">월</form:option>
										<form:option value="QQ">분기</form:option>
										<form:option value="YY">년</form:option>
										<form:option value="DI">직접입력</form:option>
									</form:select>
								</div>
							</div>
							<div class="input-group-cell pad-right-5" id="divDD">
								<div class="input-group period">
									<form:input
										path="date"
										cssClass="form-control input-sm datepicker onlyDate"
										title="날짜" />
								</div>
							</div>
							<div class="input-group-cell pad-right-5" id="divDI">
								<div class="input-group period period-start">
									<form:input
										path="strtDt"
										cssClass="form-control input-sm datepicker onlyDate"
										maxlength=""
										title="시작일자"
										onchange="initDate(this, 'endDt', 'S')" />
								</div>
								<div class="input-group period period-end">
									<form:input
										path="endDt"
										cssClass="form-control input-sm datepicker onlyDate"
										title="종료일자"
										onchange="initDate(this, 'strtDt', 'E')" />
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
							<div class="input-group-cell pad-right-5" id="divQQ">
								<form:select path="searchQqCd" cssClass="form-control input-sm" title="분기">
									<form:option value="01">1분기</form:option>
									<form:option value="02">2분기</form:option>
									<form:option value="03">3분기</form:option>
									<form:option value="04">4분기</form:option>
								</form:select>
							</div>
						</div>
						<!-- /input-group-box -->
					</div>
				</div>
			</div>
		</div>
		<!-- /box-body -->
		<div class="box-footer collapse in search-collapse">
			<div class="pull-left">
				<button type="button" class="btn" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
			</div>
			<div class="pull-right">
				<button type="submit" class="btn btn-red" onclick="fn_search();return false;">조회</button>
			</div>
		</div>
		<!-- /box-footer -->
	</div>
	<!-- /box(검색조건) -->
</div>
<!-- /col -->
</form:form>

<div class="col-box-100 detail-col">
	<div class="col-cell-group">

		<div class="col-cell-row">

			<div class="col-cell-100 col-lay-10 col-lay-no-padding-right">
				<div class="box detail-list-box">
					<div class="box-header">
						<h3 class="box-title">자원풀</h3>
					</div>
					<!-- /box-header -->
					<div class="box-body no-padding">
						<table class="table table-vertical">
							<caption>자원풀</caption>
							<tbody>
								<tr>
									<th>자원풀(개)</th>
								</tr>
								<tr>
<%-- 									<td><c:out value="${ClstResStteCvo.clCnt }" /></td> --%>
									<td><c:out value="${ClstResStteCvo.pmResInfoVo.clCnt }" /></td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- /box-body -->
				</div>
				<!-- /box(가로 버튼 그룹) -->
			</div>
			<!-- /col-cell -->


			<div class="col-cell-100 col-lay-50 col-lay-no-padding-right">
				<div class="box detail-list-box">
					<div class="box-header">
						<h3 class="box-title">물리서버(수량)</h3>
					</div>
					<!-- /box-header -->
					<div class="box-body no-padding">
						<table class="table table-vertical">
							<caption>물리서버(수량)</caption>
							<tbody>
								<tr>
									<th>총수량</th>
									<th>RHEV</th>
									<th>VMware</th>
									<th>IBM VM</th>
									<th>HP VM</th>
									<th>OPENSTACK</th>
									<th>DOCKER</th>
									<th>ORACLE VM</th>
								</tr>
								<tr>
									<td><fmt:formatNumber value="${ClstResStteCvo.pmResInfoVo.pmCnt }" pattern="#,###" /></td>
									<td><fmt:formatNumber value="${ClstResStteCvo.pmResInfoVo.rhevCnt }" pattern="#,###" /></td>
									<td><fmt:formatNumber value="${ClstResStteCvo.pmResInfoVo.vmwareCnt }" pattern="#,###" /></td>
									<td><fmt:formatNumber value="${ClstResStteCvo.pmResInfoVo.ibmCnt }" pattern="#,###" /></td>
									<td><fmt:formatNumber value="${ClstResStteCvo.pmResInfoVo.hpCnt }" pattern="#,###" /></td>
									<td><fmt:formatNumber value="${ClstResStteCvo.pmResInfoVo.openstackCnt }" pattern="#,###" /></td>
									<td><fmt:formatNumber value="${ClstResStteCvo.pmResInfoVo.dockerCnt }" pattern="#,###" /></td>
									<td><fmt:formatNumber value="${ClstResStteCvo.pmResInfoVo.ovmCnt }" pattern="#,###" /></td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- /box-body -->
				</div>
				<!-- /box(가로 버튼 그룹) -->
			</div>
			<!-- /col-cell -->

			<div class="col-cell-100 col-lay-40">
				<div class="box detail-list-box">
					<div class="box-header">
						<h3 class="box-title">물리서버(자원 )</h3>
					</div>
					<!-- /box-header -->
					<div class="box-body no-padding">
						<table class="table table-vertical">
							<caption>물리서버(자원 )</caption>
							<tbody>
								<tr>
									<th>CPU</th>
									<th>메모리</th>
									<th>스토리지</th>
								</tr>
								<tr>
									<td><fmt:formatNumber value="${ClstResStteCvo.pmResInfoVo.lastCpuCorQty }" pattern="#,###" />Core</td>
									<td><fmt:formatNumber value="${ClstResStteCvo.pmResInfoVo.lastMemSumCapa }" pattern="#,###" />GB</td>
									<td><fmt:formatNumber value="${ClstResStteCvo.pmResInfoVo.lastStrgSumCapa }" pattern="#,###" />TB</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- /box-body -->
				</div>
				<!-- /box(가로 버튼 그룹) -->
			</div>
			<!-- /col-cell -->

		</div>

		<div class="col-cell-row">


			<div class="col-cell-100 col-lay-30 col-lay-no-padding-right">
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
									<th>LINUX</th>
									<th>HP-UX</th>
									<th>AIX</th>
									<th>WIN</th>
									<th>SOLARIS</th>
									<th>기타</th>
								</tr>
								<tr>
									<td><fmt:formatNumber value="${ClstResStteCvo.vmResInfoVo.total }" pattern="#,###" /></td>
									<td><fmt:formatNumber value="${ClstResStteCvo.vmResInfoVo.linuxCnt }" pattern="#,###" /></td>
									<td><fmt:formatNumber value="${ClstResStteCvo.vmResInfoVo.hpCnt }" pattern="#,###" /></td>
									<td><fmt:formatNumber value="${ClstResStteCvo.vmResInfoVo.aixCnt }" pattern="#,###" /></td>
									<td><fmt:formatNumber value="${ClstResStteCvo.vmResInfoVo.winCnt }" pattern="#,###" /></td>
									<td><fmt:formatNumber value="${ClstResStteCvo.vmResInfoVo.solarisCnt }" pattern="#,###" /></td>
									<td><fmt:formatNumber value="${ClstResStteCvo.vmResInfoVo.etcCnt }" pattern="#,###" /></td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- /box-body -->
				</div>
				<!-- /box(가로 버튼 그룹) -->
			</div>
			<!-- /col-cell -->

			<div class="col-cell-100 col-lay-20 col-lay-no-padding-right">
				<div class="box detail-list-box">
					<div class="box-header">
						<h3 class="box-title">자원 할당량</h3>
					</div>
					<!-- /box-header -->
					<div class="box-body no-padding">
						<table class="table table-vertical">
							<caption>자원 할당량</caption>
							<tbody>
								<tr>
									<th>CPU</th>
									<th>메모리</th>
									<th>스토리지</th>
								</tr>
								<tr>
									<td><fmt:formatNumber value="${ClstResStteCvo.vmResInfoVo.lastAsgnVcorQty }" pattern="#,###" />vCore</td>
									<td><fmt:formatNumber value="${ClstResStteCvo.vmResInfoVo.lastAsgnMemCapa }" pattern="#,###" />GB</td>
									<td><fmt:formatNumber value="${ClstResStteCvo.vmResInfoVo.lastAsgnStrgCapa }" pattern="#,###.#" />TB</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- /box-body -->
				</div>
				<!-- /box(가로 버튼 그룹) -->
			</div>
			<!-- /col-cell -->

			<div class="col-cell-100 col-lay-15">
				<div class="box detail-list-box">
					<div class="box-header">
						<h3 class="box-title">가상화율</h3>
					</div>
					<!-- /box-header -->
					<div class="box-body no-padding">
						<table class="table table-vertical">
							<caption>가상화율</caption>
							<tbody>
								<tr>
									<th>CPU</th>
									<th>MEM</th>
								</tr>
								<tr>
									<td><fmt:formatNumber value="${empty ClstResStteCvo.pmResInfoVo ? null : ClstResStteCvo.pmResInfoVo.lastCpuCorQty == 0 ? 0 : ClstResStteCvo.vmResInfoVo.lastAsgnVcorQty/ClstResStteCvo.pmResInfoVo.lastCpuCorQty*100 }" pattern="#,###.#" />%</td>
									<td><fmt:formatNumber value="${empty ClstResStteCvo.pmResInfoVo ? null : ClstResStteCvo.pmResInfoVo.lastMemSumCapa == 0 ? 0 : ClstResStteCvo.vmResInfoVo.lastAsgnMemCapa/ClstResStteCvo.pmResInfoVo.lastMemSumCapa*100 }" pattern="#,###.#" />%</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- /box-body -->
				</div>
				<!-- /box(가로 버튼 그룹) -->
			</div>
			<!-- /col-cell -->
			<div class="col-cell-100 col-lay-35">
				<div class="box detail-list-box">
					<div class="box-header">
						<h3 class="box-title">자동확장</h3>
					</div>
					<!-- /box-header -->
					<div class="box-body no-padding">
						<table class="table table-vertical">
							<caption>자동확장</caption>
							<tbody>
								<tr>
									<th>서비스</th>
									<th>POD</th>
									<th>CPU</th>
									<th>MEM</th>
									<th>스토리지</th>
								</tr>
								<tr>
									<td><fmt:formatNumber value="${ClstResStteCvo.axCntVo.servcCnt }" pattern="#,###" />개</td>
									<td><fmt:formatNumber value="${ClstResStteCvo.axCntVo.podQty }" pattern="#,###" />개</td>
									<td><fmt:formatNumber value="${ClstResStteCvo.axCntVo.cpuCorQty }" pattern="#,###.##" />Core</td>
									<td><fmt:formatNumber value="${ClstResStteCvo.axCntVo.memTotCapa }" pattern="#,###.##" />GB</td>
									<td><fmt:formatNumber value="${ClstResStteCvo.axCntVo.strgTotCapa }" pattern="#,###.##" />GB</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- /box-body -->
				</div>
				<!-- /box(가로 버튼 그룹) -->
			</div>

		</div>
		<!-- /col-cell-row -->
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
		<div class="box-body list-body no-padding">
			<table class="table table-hover table-vertical table-layout-fixed" id="ClstResStteTable">
				<caption>자원풀자원현황</caption>
				<colgroup>
					<col width="50px">
					<col width="50px">
					<col width="70px">
					<col width="110px">
					<col width="70px">
					<col width="100px"><!--클러스터용도-->
					<col width="50px">
					<col width="80px">
					<col width="80px">
					<col width="80px">
					<col width="90px">
					<col width="60px">
					<col width="60px">
					<col width="60px">
					<col width="60px">
					<col width="60px">
					<col width="60px">
					<col width="80px"><!-- 자원할당량 -->
					<col width="80px">
					<col width="80px">
					<col width="80px">
					<col width="60px">
					<col width="60px">
					<col width="60px">
					<col width="100px">
					<col width="100px">
					<col width="100px">
				</colgroup>
				<thead>
					<tr>
						<th rowspan="3">센터</th>
						<th rowspan="3">존</th>
						<th rowspan="3">망</th>
						<th rowspan="3">자원풀명</th>
						<th rowspan="3">클러스터명</th>
						<th rowspan="3">클러스터<br>용도</th>
						<th colspan="4">물리서버</th>
						<th rowspan="3">하이퍼바이저</th>
						<th colspan="7">가상서버</th>
						<th colspan="3">자원할당량</th>
						<th colspan="2">가상화율</th>
						<th colspan="5">자동자원확장</th>
					</tr>
					<tr>
						<th rowspan="2">수량</th>
						<th rowspan="2">CPU(코어)</th>
						<th rowspan="2">메모리(GB)</th>
						<th rowspan="2">스토리지(TB)</th>
						<th rowspan="2">총수량</th>
						<th rowspan="2">LINUX</th>
						<th rowspan="2">HP-UX</th>
						<th rowspan="2">AIX</th>
						<th rowspan="2">WIN</th>
						<th rowspan="2">SOLARIS</th>
						<th rowspan="2">기타</th>
						<th rowspan="2">CPU(vCore)</th>
						<th rowspan="2">메모리(GB)</th>
						<th rowspan="2">스토리지(TB)</th>
						<th rowspan="2">CPU(%)</th>
						<th rowspan="2">메모리(%)</th>
						<th colspan="2">수량</th>
						<th colspan="3">자원할당량</th>
					</tr>
					<tr>
						<th>서비스수</th>
						<th>POD수</th>
						<th>CPU(Core)</th>
						<th>메모리(GB)</th>
						<th>스토리지(GB)</th>
					</tr>

				</thead>
				<tbody>
					<c:choose>
						<c:when
							test="${ ClstResStteCvo.clstResInfoList eq null or empty ClstResStteCvo.clstResInfoList }">
							<tr>
								<td colspan="27">
									<c:choose>
										<c:when
											test="${searchVo.search eq null or empty searchVo.search }">
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
							<c:forEach var="vo" items="${ClstResStteCvo.clstResInfoList}" varStatus="ri">
								<tr>
									<td class="alignC"><c:out value="${vo.regionNm }" /></td>
									<td class="alignC"><c:out value="${vo.zoneNm }" /></td>
									<td class="alignC"><c:out value="${vo.netNm }" /></td>
									<td class="notellipsis alignL"><nobr><c:out value="${vo.rsrcPoolNm }" /></nobr></td>
									<td class="notellipsis alignL"><c:out value="${vo.clstrNm }" /></td>
									<td class="alignL"><c:out value="${vo.prposNm }" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.pmCnt }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastCpuCorQty }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastMemSumCapa }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastStrgSumCapa }" pattern="#,###.##" /></td>
									<td class="alignL"><c:out value="${vo.hipervisor }" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.vmCnt }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.linuxCnt }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.hpCnt }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.aixCnt }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.winCnt }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.solarisCnt }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.etcCnt }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastAsgnVcorQty }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastAsgnMemCapa }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.lastAsgnStrgCapa }" pattern="#,###.##" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.cpuVirtRt }" pattern="#,###.##" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.memVirtRt }" pattern="#,###.##" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.servcCnt }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.podQty }" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.cpuCorQty }" pattern="#,###.##" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.memTotCapa }" pattern="#,###.##" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.strgTotCapa }" pattern="#,###.##" /></td>
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
		location.href = "selectClstResStteList.do?paginationInfo.currentPageNo="
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
		searchVo.action = '<c:url value="selectClstResStteList.do" />';
		searchVo.submit();
	}

	function fn_excelDown() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selectClstResStteListXlsDown.do" />';
		searchVo.submit();
	}
</script>
