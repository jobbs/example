<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 11.
 * @lastmodified 2016. 10. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 11.     이화영         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<!-- 검색조건 영역 -->
<div class="col-box-100 search-col">
	<div class="box box-search">
		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">검색조건</h3>
			<div class="box-tools pull-right">
				<!-- 접기 버튼 -->
				<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
					<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
				</button>
			</div>
		</div>
		<form:form commandName="searchVo" method="get">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
		<!-- box-body -->
		<div class="box-body collapse in search-collapse">
			<div class="form-group">

			<c:if test="${searchVo.sysAdm or searchVo.oprAdm}">
				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchRegionId" title="센터">센터</label>
					</div>
					<div class="cell-body">
						<nform:selectRegion
							name="searchRegionId"
							id="searchRegionId"
							title="센터"
							cssClass="form-control input-sm"
							value="${searchVo.searchRegionId}"
							whole="true"
							onchange="selectZoneByNetClCd('searchRegionId', 'searchZoneId', 'searchNetId', 'searchRsrcPoolId' )" />
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchZoneId" title="존">존</label>
					</div>
					<div class="cell-body">
						<nform:selectZone
							name="searchZoneId"
							id="searchZoneId"
							title="존"
							cssClass="form-control input-sm"
							whole="true"
							regionId="${searchVo.searchRegionId}"
							value="${searchVo.searchZoneId}"
							onchange="selectPoolByNetClCd('searchRegionId', 'searchZoneId', 'searchNetId', 'searchRsrcPoolId', {searchPoolTypeCd : '01','searchCtlTrgtYn' : 'Y'})"  />
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchNetId" title="망구분">망구분</label>
					</div>
					<div class="cell-body">
						<nform:selectCode
							parentCd="NETCD"
          					parentGrpCd="067"
							name="searchNetId"
							id="searchNetId"
							title="망구분"
							cssClass="form-control input-sm"
							whole="true"
							zoneId="${searchVo.searchZoneId}"
							value="${searchVo.searchNetId}"
							onchange="selectPoolByNetClCd('searchRegionId', 'searchZoneId','searchNetId', 'searchRsrcPoolId', {searchPoolTypeCd : '01','searchCtlTrgtYn' : 'Y'})"  />
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchRsrcPoolId" title="자원풀">자원풀</label>
					</div>
					<div class="cell-body">
						<nform:selectPool
							name="searchRsrcPoolId"
							id="searchRsrcPoolId"
							poolTypeCd="01"
							swTypeCd="COM"
							title="자원풀"
							cssClass="form-control input-sm"
							whole="true"
							ctlTrgtYn="Y"
							regionId="${searchVo.searchRegionId }"
							zoneId="${searchVo.searchZoneId}"
							netClCd="${searchVo.searchNetId }"
							value="${searchVo.searchRsrcPoolId}"/>
					</div>
				</div>
			</c:if>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchStatCd" title="상태">상태</label>
					</div>
					<div class="cell-body">
						<form:select path="searchStatCd" title="상태" cssClass="form-control input-sm">
							<c:forEach var="statCd" items="${statCdList }">
								<form:option value="${statCd.cd}" ><c:out value="${statCd.cdNm }"/></form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchInstitutionNm" title="부처">부처</label>
					</div>
					<div class="cell-body">
						<form:input path="searchInstitutionNm" title="부처" cssClass="form-control input-sm" value=""/>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchJobNm" title="업무">업무</label>
					</div>
					<div class="cell-body">
						<form:input path="searchJobNm" title="업무" cssClass="form-control input-sm" value=""/>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchVmNm" title="가상서버명">가상서버명</label>
					</div>
					<div class="cell-body">
						<form:input path="searchVmNm" title="가상서버명" cssClass="form-control input-sm" value=""/>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchVmCompId" title="가상서버구성ID">가상서버구성ID</label>
					</div>
					<div class="cell-body">
						<form:input path="searchVmCompId" title="가상서버구성ID" cssClass="form-control input-sm" value=""/>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchHstNm" title="호스트명">호스트명</label>
					</div>
					<div class="cell-body">
						<form:input path="searchHstNm" title="호스트명" cssClass="form-control input-sm" value=""/>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchRprsntIpAddr" title="IP주소">IP주소</label>
					</div>
					<div class="cell-body">
						<form:input path="searchRprsntIpAddr" title="IP주소" cssClass="form-control input-sm" value=""/>
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchOsTyCd" title="OS유형">OS유형</label>
					</div>
					<div class="cell-body">
						<form:select path="searchOsTyCd" title="OS유형" cssClass="form-control input-sm">
							<c:forEach var="osTyCd" items="${osTyCdList }">
								<form:option value="${osTyCd.cd}" ><c:out value="${osTyCd.cdNm }"/></form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchPackgNm" title="패키지명">패키지명</label>
					</div>
					<div class="cell-body">
						<form:input path="searchPackgNm" title="패키지명" cssClass="form-control input-sm" value=""/>
					</div>
				</div>
			<c:if test="${searchVo.sysAdm or searchVo.oprAdm}">
				<!-- 검색조건 : checkbox -->
				<div class="form-cell form-cell-100 col-lay-100">
					<div class="cell-title">
						<label title="가상화SW">가상화SW</label>
					</div>
					<div class="cell-body">
						<div class="input-group input-group-check">
							<c:choose>
								<c:when test="${searchVo eq null or searchVo.existsVrlzSwTyCdList eq null}">
									<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
										<form:checkbox path="existsVrlzSwTyCdList[${i.index }]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}" checked="checked"/>
										<label for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
										<form:checkbox path="existsVrlzSwTyCdList[${i.index }]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}"/>
										<label for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</c:if>
			</div>
		</div>
		<!-- box-footer -->
		<div class="box-footer collapse in search-collapse">
		  <div class="pull-left">
		    <button type="button" class="btn" onclick="fn_initialize();">초기화</button>
		  </div>
		  <div class="pull-right">
		  	<c:url var="selectVmListUrl" value="selectVmList.do">
			</c:url>
		    <button type="button" class="btn btn-red pull-right" onclick="fn_selectVmLPatchist();">조회</button>
		  </div>
		</div>
		</form:form>
	</div>
</div>

<!-- 그리드 영역 -->
<div class="col-box-100 search-col">
	<div class="box list-box">
		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">검색결과<small>
				${searchVo.paginationInfo.currentPageNo } /
				${searchVo.paginationInfo.totalPageCount },
				총 ${searchVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/>
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_selectVmPatchListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>
		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table id="vmPatchTable" class="table table-hover table-vertical table-layout-fixed">
				<caption>가상서버패키지목록</caption>
				<thead>
					<tr>
						<th><nobr>No.</nobr></th>
						<th><nobr>상태</nobr></th>
						<th><nobr>부처</nobr></th>
						<th><nobr>업무</nobr></th>
						<c:if test="${searchVo.sysAdm or searchVo.oprAdm}">
							<th><nobr>센터</nobr></th>
							<th><nobr>존</nobr></th>
							<th><nobr>망구분</nobr></th>
							<th><nobr>자원풀</nobr></th>
							<th><nobr>가상화SW</nobr></th>
						</c:if>
						<th><nobr>가상서버구성ID</nobr></th>
						<th><nobr>가상서버명</nobr></th>
						<th><nobr>가상서버ID</nobr></th>
						<th><nobr>호스트명</nobr></th>
						<th><nobr>IP주소</nobr></th>
						<th><nobr>OS유형</nobr></th>
						<th><nobr>생성일자</nobr></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vmPatchVo" items="${vmPatchVoList }" varStatus="i">
						<c:url var="detailUrl" value="selectVmPatch.do">
							<c:param name="vmSeq" value="${vmPatchVo.vmSeq }" />
							<c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach>
						</c:url>
						<tr>
							<td><nobr><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></nobr></td>
							<td><nobr>
							<c:if test="${null ne vmPatchVo.statGrpCd}">
								<div class="server-info server
									<c:choose>
										<c:when test='${"01" eq vmPatchVo.statGrpCd}'><c:out value="server-down"/></c:when>
										<c:when test='${"02" eq vmPatchVo.statGrpCd}'><c:out value="server-up"/></c:when>
										<c:when test='${"03" eq vmPatchVo.statGrpCd}'><c:out value="server-inprogress"/></c:when>
										<c:when test='${"04" eq vmPatchVo.statGrpCd}'><c:out value="server-exception"/></c:when>
							   			<c:otherwise></c:otherwise>
									</c:choose>
								">
									<div class="server-info-body alignL">
										<div class="server-info-box alignL">
											<span class="label"></span><h4 class="stat"><c:out value="${vmPatchVo.statGrpCdNm }" /></h4>
										</div>
									</div>
								</div>
							</c:if>
							<%-- <c:choose>
								<c:when test='${"01" eq vmPatchVo.statGrpCd}'>
									<span class="status status-gray"><c:out value="${vmPatchVo.statGrpCdNm }" /></span>
								</c:when>
								<c:when test='${"02" eq vmPatchVo.statGrpCd}'>
									<span class="status status-green"><c:out value="${vmPatchVo.statGrpCdNm }" /></span>
								</c:when>
								<c:when test='${"03" eq vmPatchVo.statGrpCd}'>
									<span class="status status-blue"><c:out value="${vmPatchVo.statGrpCdNm }" /></span>
								</c:when>
								<c:when test='${"04" eq vmPatchVo.statGrpCd}'>
									<span class="status status-red"><c:out value="${vmPatchVo.statGrpCdNm }" /></span>
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose> --%>
							<%-- <c:out value="${vmPatchVo.statGrpCdNm }" /> --%>
							</nobr></td>
							<td class="alignL"><nobr><c:out value="${vmPatchVo.institutionNm }" /></nobr></td>
							<td class="alignL">
								<c:set var="jobNmList" value="${fn:split(vmPatchVo.jobsNm, ',')}"/>
								<c:forEach var="jobNm" items="${jobNmList}" varStatus="i">
									<nobr><c:out value="${jobNm }" /><c:if test="${fn:length(jobNmList) > (i.index + 1) }"><c:out value=","/></c:if></nobr>
								</c:forEach>
							</td>
							<c:if test="${searchVo.sysAdm or searchVo.oprAdm}">
								<td class="alignL"><nobr><c:out value="${vmPatchVo.regionNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmPatchVo.zoneNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmPatchVo.netNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmPatchVo.rsrcPoolNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmPatchVo.vrlzSwTyCdNm }" /></nobr></td>
							</c:if>
							<td class="alignL"><nobr><a href="<c:url value="${detailUrl }" />" title="<c:out value="${vmPatchVo.vmCompId }"/>"><c:out value="${vmPatchVo.vmCompId }" /></a></nobr></td>
							<td class="alignL"><nobr><a href="<c:url value="${detailUrl }" />" title="<c:out value="${vmPatchVo.vmNm }"/>"><c:out value="${vmPatchVo.vmNm }" /></a></nobr></td>
							<td class="alignL"><nobr><a href="<c:url value="${detailUrl }" />" title="<c:out value="${vmPatchVo.vmId }"/>"><c:out value="${vmPatchVo.vmId }" /></a></nobr></td>
							<td class="alignL"><nobr><c:out value="${vmPatchVo.hstNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${vmPatchVo.rprsntIpAddr }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${vmPatchVo.osTyCdNm }" /></nobr></td>
							<td><nobr><fmt:formatDate value="${vmPatchVo.regDttm }" pattern="yyyy-MM-dd" /></nobr></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
		</div>
	</div>
</div>

<script type="text/javascript">

// 검색조건 초기화
function fn_initialize(){
	$('#searchVo input[type="text"]').val('');
	$('#searchVo select').val('').attr('selected', 'selected');
	$('#searchVo input[type="checkbox"][name="searchVrlzSwTyCdList"]').prop('checked', 'checked');
}

//조회
function fn_selectVmLPatchist(){
	$('#searchVo').attr('target', '_self');
	$('#searchVo').attr('action', '<c:url var="select" value="selectVmPatchList.do"/>');
	$('#searchVo').submit();
}

//페이지 이동
function fn_goPage(page){
	location.href = "selectVmPatchList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

//목록의 정보를 Excel로 다운로드 한다.
function fn_selectVmPatchListXlsDwnl() {
	if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}
	$('#searchVo').attr('target', '_self');
	$('#searchVo').attr('action', '<c:url value="selectVmPatchListXlsDwnl.do"/>');
	$('#searchVo').submit();
}

$("#vmPatchTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	             {sWidth : "30px" },//No
	             {sWidth : "90px" },//상태
	             {sWidth : "80px" },//부처
	             {sWidth : "100px" },//업무
	             <c:choose>
		             <c:when test="${searchVo.sysAdm or searchVo.oprAdm}">
			             {sWidth : "40px" },//센터
			             {sWidth : "40px" },//존
			             {sWidth : "60px" },//망
		             	 {sWidth : "90px" },//자원풀
		             	 {sWidth : "90px" },//가상화SW
		             	{sWidth : "100px" },//가상서버구성ID
		             	 {sWidth : "150px" },//가상서버명
		             </c:when>
		             <c:otherwise>
		             	{sWidth : "100px" },//가상서버구성ID
		             	{sWidth : "430px" },//가상서버명
		             </c:otherwise>
	             </c:choose>
	             {sWidth : "150px" },//가상서버ID
	             {sWidth : "100px" },//호스트명
	             {sWidth : "100px" },//IP주소
	             {sWidth : "50px" },//OS유형
	             {sWidth : "90px" }//생성일자
	],
	order : [[0, "desc"]]
} );

</script>