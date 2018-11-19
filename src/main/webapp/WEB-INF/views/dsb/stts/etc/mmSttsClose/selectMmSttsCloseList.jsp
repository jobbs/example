<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>월별 통계 마감 화면</pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     양정순         v1.0             최초생성
 * 2017. 05. 21   양정순         v2.0             자동확장 추가
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

<form:form commandName="searchVo" name="frm" id="frm" method="get">
	<input type="hidden" name="search" value="T">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
	<div class="col-box-100 search-col">
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
					<!-- 검색조건 : select -->

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
								onchange="fn_pool()"
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

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="마감월" for="year">마감월</label>
						</div>
						<div class="cell-body">
							<div class="input-group-box">
								<div class="input-group-cell pad-right-5">
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
								<div class="input-group-cell">
									<div class="input-group">
										<form:select path="month" cssClass="form-control input-sm" title="월">
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

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="대상" for="searchServer">대상</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:select path="searchServer" cssClass="form-control input-sm" title="가상/물리 서버">
									<form:option value="PM">물리서버</form:option>
									<form:option value="VM">가상서버</form:option>
									<form:option value="AX">자동확장</form:option>
								</form:select>
							</div>
						</div>
					</div>

					<div class="form-cell form-cell-20 col-lay-25">
						<c:choose>
							<c:when test="${searchVo.searchServer eq 'AX'}">
								<div class="cell-title" id="searchId">
									<label title="PODID" for="searchText">PODID</label>
								</div>
								<div class="cell-body">
									<form:input path="searchText" cssClass="form-control input-sm pull-right" title="PODID" />
								</div>
							</c:when>
							<c:otherwise>
								<div class="cell-title" id="searchId">
									<label title="구성ID" for="searchText">구성ID</label>
								</div>
								<div class="cell-body">
									<form:input path="searchText" cssClass="form-control input-sm pull-right" title="구성ID" />
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			<div class="box-footer collapse in search-collapse">
				<div class="table-btn pull-left">
					<button type="button" class="btn btn-default" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
				</div>
				<div class="pull-right">
					<button onclick="javascript:fn_search();return false;" class="btn btn-red pull-right">조회</button>
				</div>
			</div>
			<!-- /box-footer -->
		</div>
	</div>
</form:form>

<div class="col-box-100 search-col">
	<div class="box list-box">

		<div class="box-header">
			<h3 class="box-title">
				검색결과<small> ${searchVo.paginationInfo.currentPageNo } /
					${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage
						formId="searchVo"
						value="${searchVo }" />
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="excelDown();">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /box-header -->

		<!-- box-body -->
		<c:choose>
			<c:when test="${searchVo.searchServer eq 'AX'}">
				<div class="box-body no-padding list-body">
					<table class="table table-hover table-layout-fixed table-vertical" id="mmSttsCloseTable">
						<caption>월별통계 마감 조회</caption>

						<thead>
							<tr>
								<th>마감월</th>
								<th>대상</th>
								<th>센터</th>
								<th>존</th>
								<th>망구분</th>
								<th>자원풀</th>
								<th>서비스명</th>
								<th>PODID</th>
								<th>POD명</th>
								<th>cpu사용율(%)<br>(전월대비 증감)
								</th>
								<th>논리적 코어 개수<br>(전월대비 증감)
								</th>
								<th>스토리지 총용량(Gbyte)<br>(전월대비 증감)
								</th>
								<th>메모리 총용량(Gbyte)<br>(전월대비 증감)
								</th>
								<th>메모리 사용율(%)<br>(전월대비 증감)
								</th>
						</thead>

						<tbody>

							<c:forEach var="vo" items="${list }" varStatus="i">
								<c:url var="detailUrl" value="selectAxCloseList.do">
									<c:forEach var="curParam" items="${param }">
										<c:if test="${curParam.key ne 'prvPageNo' and curParam.key ne 'closeMonth' and curParam.key ne 'servcSeq' and curParam.key ne 'podId' and curParam.key ne 'paginationInfo.currentPageNo'}">
											<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
										</c:if>
									</c:forEach>
									<c:param name="servcSeq" value="${vo.servcSeq }" />
									<c:param name="podId" value="${vo.podId }" />
									<c:param name="prvPageNo" value="${searchVo.paginationInfo.currentPageNo }" />
									<c:param name="closeMonth" value="${searchVo.year}${searchVo.month}" />
								</c:url>

								<tr>
									<td><c:out value="${vo.colctDt }" /></td>
									<td><c:out value="${vo.srvrCl }" /></td>
									<td class="alignL"><c:out value="${vo.regionNm }" /></td>
									<td class="alignL"><c:out value="${vo.zoneNm }" /></td>
									<td class="alignL"><c:out value="${vo.netNm }" /></td>
									<td class="alignL"><c:out value="${vo.rsrcPoolNm }" /></td>
									<td class="alignL"><c:out value="${vo.servcNm }" /></td>
									<td class="alignL ellipsis"><a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.podId}"/>"><c:out value="${vo.podId }" /></a></td>
									<td class="alignL ellipsis"><a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.podNm}"/>"><c:out value="${vo.podNm }" /></a></td>
									<td class="alignR"><c:out value="${vo.avgCpuUseRt }" /></td>
									<td class="alignR"><c:out value="${vo.cpuCorQty }" /></td>
									<td class="alignR"><c:out value="${vo.strgTotCapa }" /></td>
									<td class="alignR"><c:out value="${vo.memTotCapa }" /></td>
									<td class="alignR"><c:out value="${vo.avgMemUseRt }" /></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</c:when>
			<c:otherwise>

				<div class="box-body no-padding list-body">
					<table class="table table-hover table-vertical" id="mmSttsCloseTable">
						<caption>월별통계 마감 조회</caption>
						<colgroup>
							<col width="40px">
							<col width="60px">
							<col width="40px">
							<col width="30px">
							<col width="60px">
							<col class="colAuto">
							<col class="colAuto">
							<col class="colAuto">
							<col class="colAuto">
							<col class="colAuto">
							<col class="colAuto">
							<col class="colAuto">
							<col class="colAuto">
							<col class="colAuto">
							<col class="colAuto">
							<col class="colAuto">
						</colgroup>
						<thead>
							<tr>
								<th>마감월</th>
								<th>대상</th>
								<th>센터</th>
								<th>존</th>
								<th>망구분</th>
								<th>자원풀</th>
								<th>클러스터</th>
								<th>구성ID</th>
								<th>서버ID</th>
								<th>서버명</th>
								<th>cpu사용율(%)<br>(전월대비 증감)
								</th>
								<th>논리적 코어 개수<br>(전월대비 증감)
								</th>
								<th>디스크 총용량(Gbyte)<br>(전월대비 증감)
								</th>
								<th>FileSystems 사용량(Gbyte)<br>(전월대비 증감)
								</th>
								<th>메모리 총용량(Gbyte)<br>(전월대비 증감)
								</th>
								<th>메모리 사용율(%)<br>(전월대비 증감)
								</th>
						</thead>

						<tbody>

							<c:forEach var="vo" items="${list }" varStatus="i">
								<c:url var="detailUrl" value="selectVmCloseList.do">
									<c:forEach var="curParam" items="${param }">
										<c:if test="${curParam.key ne 'prvPageNo' and curParam.key ne 'closeMonth'}">
											<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
										</c:if>
									</c:forEach>
									<c:param name="pmSeq" value="${vo.pmSeq }" />
									<c:param name="prvPageNo" value="${searchVo.paginationInfo.currentPageNo }" />
									<c:param name="closeMonth" value="${searchVo.year}${searchVo.month}" />
								</c:url>

								<tr>
									<td><c:out value="${vo.colctDt }" /></td>
									<td><c:out value="${vo.srvrCl }" /></td>
									<td class="alignL"><c:out value="${vo.regionNm }" /></td>
									<td class="alignL"><c:out value="${vo.zoneNm }" /></td>
									<td class="alignL"><c:out value="${vo.netNm }" /></td>
									<td class="alignL"><c:out value="${vo.rsrcPoolNm }" /></td>
									<td class="alignL"><c:out value="${vo.clstrNm }" /></td>
									<td class="alignL"><c:out value="${vo.pmCompId }" /></td>
									<td class="alignL ellipsis"><a href="<c:url value="${detailUrl }" />"><c:out value="${vo.pmId }" /></a></td>
									<td class="alignL ellipsis"><c:out value="${vo.pmNm }" /></td>
									<td class="alignR"><c:out value="${vo.avgCpuUseRt }" /></td>
									<td class="alignR"><c:out value="${vo.avgCpuCorQty }" /></td>
									<td class="alignR"><c:out value="${vo.avgStrgSumCapa }" /></td>
									<td class="alignR"><c:out value="${vo.avgStrgUseCapa }" /></td>
									<td class="alignR"><c:out value="${vo.avgMemSumCapa }" /></td>
									<td class="alignR"><c:out value="${vo.avgMemUseRt }" /></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
		</div>
		<!-- /box-footer -->
	</div>
</div>

<script type="text/javascript">


$('#searchServer').on('change', function() {
	$('#netId').val('').trigger('change');
	  if(this.value == 'AX'){
		  $('#searchId').html('<label title="PODID" for="searchText">PODID</label>');
		  $('#searchText').attr('title','PODID');
	  }
	  else{
		  $('#searchId').html('<label title="구성ID" for="searchText">구성ID</label>');
		  $('#searchText').attr('title','구성ID');
	  }
})

// 검색조건 초기화
	function fn_reset() {
		//$("#searchVo input[type='text']").val("");
		var now = new Date();
		var mon = (now.getMonth()+1) > 9 ? ''+(now.getMonth()+1):'0'+(now.getMonth()+1);
		$("#regionId").val("").attr("selected", "selected");
		$("#zoneId").val("").attr("selected", "selected");
		$("#netId").val("").attr("selected", "selected");
		$("#rsrcPoolId").val("").attr("selected", "selected");

		$('#year option:eq(0)').attr("selected","selected");
		$('#month').val(mon);
		$('#searchServer option:eq(0)').attr("selected","selected");
		$("#searchText").val("");
	}

function fn_pool(){
	var  searchServer = $('#searchServer option:selected').val();
	console.log("searchServer=>"+searchServer);
	if(searchServer == "AX"){
		selectPoolByNetClCd('regionId', 'zoneId', 'netId', 'rsrcPoolId', {searchPoolTypeCd : '05','searchCtlTrgtYn' : 'Y'});
	}else{
		selectPoolByNetClCd('regionId', 'zoneId', 'netId', 'rsrcPoolId', {searchPoolTypeCd : 'CN','searchCtlTrgtYn' : 'Y'});
	}
}

function goPage(page){
	location.href = "selectMmSttsCloseList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

//조회버튼 클릭시.
function fn_search() {
	$("#frm").attr("target", "_self");
	$("#frm").attr("action", "<c:url value='selectMmSttsCloseList.do'/>");
	$("#frm").submit();
	return false;
}

function excelDown(){
	if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}

	$("#frm").attr("target", "_self");
	$("#frm").attr("action", "<c:url value='selectMmSttsCloseXlsDown.do'/>");
	$("#frm").submit();
	return false;
}

function goToUrl(url) {
	location.href = url;
}


$("#mmSttsCloseTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	<c:choose>
		<c:when test="${searchVo.searchServer eq 'AX'}">
		aoColumns : [
					 {sWidth : "70px"},
		             {sWidth : "60px"},
		             {sWidth :"40px"},
		             {sWidth :"30px"},
		             {sWidth :"80px"},<!-- 망구분 -->
		             {sWidth :"80px"},
		             {sWidth :"90px"},
		             {sWidth :"210px"},
		             {sWidth :"210px"},<!--pod명 -->
		             {sWidth :"100px"},<!--  -->
		             {sWidth :"100px"},<!--  -->
		             {sWidth :"100px"},<!--  -->
		             {sWidth :"100px"},<!--  -->
		             {sWidth :"100px"},<!--  -->
		             ],
		</c:when>
	</c:choose>

	<c:choose>
	<c:when test="${ list eq null or empty list }">
	  <c:choose>
	     <c:when test="${searchVo.search eq null or empty searchVo.search }">
	       oLanguage:{sEmptyTable:"조회 버튼을 클릭해 주시기 바랍니다."},
	     </c:when>
		   <c:otherwise>
		     oLanguage:{sEmptyTable:"검색된 데이터가 없습니다."},
		   </c:otherwise>
		</c:choose>
	</c:when>
	</c:choose>

});

</script>