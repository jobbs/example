<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>
 	물리서버 목록 조회
 </pre>
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     최경철         v1.0             최초생성
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

<c:url var="insertPmCreUrl" value="insertPmCreReq.do">
	<c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach>
</c:url>

<c:if test='${!pmSearchVo.netPmSltAt }'>
<c:set var="pollCl" value="01"></c:set>
</c:if>
<c:if test='${pmSearchVo.netPmSltAt }'>
<c:set var="pollCl" value="CN"></c:set>
</c:if>

<!-- 검색조건 영역 -->
<div class="col-box-100 search-col">

	<div class="box box-search">

		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">검색조건</h3>
			<div class="box-tools pull-right">
				<!-- 접기 버튼 -->
				<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
					<i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기" data-original-title="접어두기"></i>
				</button>
			</div>
		</div>

		<form:form commandName="pmSearchVo" method="get">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
		<!-- box-body -->
		<div class="box-body collapse in search-collapse">

			<div class="form-group">

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="센터">센터</label>
					</div>
					<div class="cell-body">
						<nform:selectRegion
								name="searchRegionId"
								id="searchRegionId"
								title="센터"
								cssClass="form-control input-sm"
								value="${pmSearchVo.searchRegionId}"
								onchange="selectZoneByNetClCd('searchRegionId', 'searchZoneId', 'searchNetClCd', 'searchRsrcPoolId')" />
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="존">존</label>
					</div>
					<div class="cell-body">
						<nform:selectZone
								name="searchZoneId"
								id="searchZoneId"
								title="존"
								cssClass="form-control input-sm"
								whole="true"
								regionId="${pmSearchVo.searchRegionId}"
								value="${pmSearchVo.searchZoneId}"
								onchange="selectPoolByNetClCd('searchRegionId', 'searchZoneId', 'searchNetClCd', 'searchRsrcPoolId', {'searchPoolTypeCd':'01', 'searchCtlTrgtYn' : 'N', 'netVmSltAt' : 'netPmSltAt'} )" />
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="망구분">망구분</label>
					</div>
					<div class="cell-body">
						<nform:selectCode
								parentCd="NETCD"
          						parentGrpCd="067"
								name="searchNetClCd"
								id="searchNetClCd"
								title="망구분"
								cssClass="form-control input-sm"
								zoneId="${pmSearchVo.searchZoneId}"
								value="${pmSearchVo.searchNetClCd}"
								onchange="selectPoolByNetClCd('searchRegionId', 'searchZoneId', 'searchNetClCd', 'searchRsrcPoolId', {'searchPoolTypeCd':'01', 'searchCtlTrgtYn' : 'N', 'netVmSltAt' : 'netPmSltAt'} )" />
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="자원풀">자원풀</label>
					</div>
					<div class="cell-body">
						<nform:selectPool
								name="searchRsrcPoolId"
								id="searchRsrcPoolId"
								title="자원풀"
								cssClass="form-control input-sm"
								poolTypeCd="${pollCl}"
								ctlTrgtYn="N"
								regionId="${pmSearchVo.searchRegionId }"
								zoneId="${pmSearchVo.searchZoneId}"
								netClCd="${pmSearchVo.searchNetClCd }"
								netVmSltAt="${pmSearchVo.netPmSltAt }"
								value="${pmSearchVo.searchRsrcPoolId}" />
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="상태">상태</label>
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
						<label title="클러스터명" for="containsClstrNm">클러스터명</label>
					</div>
					<div class="cell-body">
						<form:input path="containsClstrNm" name="containsClstrNm" title="클러스터명" cssClass="form-control input-sm" value=""/>
					</div>
				</div>
				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="물리서버 구성ID">물리서버 구성ID</label>
					</div>
					<div class="cell-body">
						<form:input path="searchPmCompId" name="searchPmCompId" title="물리서버 구성ID" cssClass="form-control input-sm" value=""/>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="물리서버명">물리서버명</label>
					</div>
					<div class="cell-body">
						<form:input path="searchPmNm" name="searchPmNm" title="물리서버명" cssClass="form-control input-sm" value=""/>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="물리서버 ID">물리서버 ID</label>
					</div>
					<div class="cell-body">
						<form:input path="searchPmId" name="searchPmId" title="물리서버 ID" cssClass="form-control input-sm" value=""/>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="IP주소">물리서버 IP주소</label>
					</div>
					<div class="cell-body">
						<form:input path="searchRprsntIpAddr" name="searchRprsntIpAddr" title="IP주소" cssClass="form-control input-sm onlyIp" value=""/>
					</div>
				</div>

				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
					</div>
					<div class="cell-body">
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
					</div>
					<div class="cell-body">
					</div>
				</div>

				<!-- 검색조건 : checkbox -->
				<div class="form-cell form-cell-50 col-lay-50">
					<div class="cell-title">
						<label title="가상화SW">가상화SW</label>
					</div>
					<div class="cell-body">
						<div class="input-group input-group-check">
							<c:choose>
								<c:when test="${pmSearchVo eq null or pmSearchVo.searchVrlzSwTyCdList eq null}">
									<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
										<form:checkbox path="searchVrlzSwTyCdList[${i.index}]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}" checked="checked"/>
										<label title="" for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
										<form:checkbox path="searchVrlzSwTyCdList[${i.index}]" name="searchVrlzSwTyCdList" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}"/>
										<label title="" for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
									</c:forEach>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
				</div>

				<div class="form-cell form-cell-50 col-lay-50">
					<div class="cell-title">
						<label title="NFV물리서버 조회여부" for="netPmSltAt">NFV물리서버  조회여부</label>
					</div>
					<div class="cell-body">
						<div class="input-group input-group-check">
						<form:checkbox path="netPmSltAt" title="NFV물리서버조회여부" value="true" id="netPmSltAt" data-name="netPmSltAt" onchange="selectPoolByNetClCd('searchRegionId', 'searchZoneId', 'searchNetClCd', 'searchRsrcPoolId', {'searchPoolTypeCd':'01', 'searchCtlTrgtYn' : 'N', 'netVmSltAt' : 'netPmSltAt'})"/>
						</div>
					</div>
				</div>

			</div>

		</div>

		<!-- box-footer -->
		<div class="box-footer collapse in search-collapse">
		  <div class="pull-left">
		    <button type="button" class="btn" title="초기화" onclick="fn_initialize();">초기화</button>
		  </div>
		  <div class="pull-right">
		  	<c:url var="selectPmListUrl" value="selectPmList.do">
			</c:url>
		    <button type="button" class="btn btn-red pull-right" title="조회" onclick="fn_selectPmList();">조회</button>
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
				${pmSearchVo.paginationInfo.currentPageNo } /
				${pmSearchVo.paginationInfo.totalPageCount },
				총 ${pmSearchVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="pmSearchVo" value="${pmSearchVo }"/>
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="엑셀다운로드" data-original-title="엑셀다운로드" onclick="fn_selectPmListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table id="pmTable" class="table table-hover table-vertical table-layout-fixed">
			<caption>물리서버 목록 테이블</caption>
				<thead>
					<tr>
						<th><nobr>선택</nobr></th>
						<th><nobr>상태</nobr></th>
						<th><nobr>센터</nobr></th>
						<th><nobr>존</nobr></th>
						<th><nobr>망구분</nobr></th>
						<th><nobr>자원풀</nobr></th>
						<th><nobr>클러스터</nobr></th>
						<th><nobr>물리서버 구성ID</nobr></th>
						<th><nobr>물리서버명</nobr></th>
						<th><nobr>물리서버 ID</nobr></th>
						<th><nobr>IP주소</nobr></th>
						<th><nobr>가상화SW</nobr></th>
						<th><nobr>가상서버수</nobr></th>
						<th><nobr>CPU<br>사용률<br>(%)</nobr></th>
						<th><nobr>CPU<br>가상화율<br>(%)</nobr></th>
						<th><nobr>CPU<br>vCore</nobr></th>
						<th><nobr>CPU<br>Core</nobr></th>
						<th><nobr>메모리<br>사용률<br>(%)</nobr></th>
						<th><nobr>메모리<br>가상화율<br>(%)</nobr></th>
						<th><nobr>메모리<br>할당량<br>(GB)</nobr></th>
						<th><nobr>메모리<br>전체량<br>(GB)</nobr></th>
						<th><nobr>스토리지<br>(GB)</nobr></th>
						<th><nobr>네트워크<br>In<br>(KB/S)</nobr></th>
						<th><nobr>네트워크<br>Out<br>(KB/S)</nobr></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pmVo" items="${pmVoList }" varStatus="i">
						<c:url var="selectPmUrl" value="selectPm.do">
							<c:param name="pmSeq" value="${pmVo.pmSeq }" />
							<c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach>
						</c:url>
						<c:url var="selectNetPmUrl" value="/cpt/rsrc/net/pm/selectNetPm.do">
							<c:param name="pmSeq" value="${pmVo.pmSeq }" />
							<c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach>
						</c:url>
						<tr>
							<td>
							<nobr>
								<c:choose>
									<c:when test='${null ne pmVo.ctlTrgtYn and "Y" eq pmVo.ctlTrgtYn and "01" eq pmVo.pmClCd}'>
										<input type="radio" name="pm_row" title="선택여부" value="${pmVo.pmSeq }" >
									</c:when>
						   			<c:otherwise>
						   				<input type="radio" name="pm_row" title="선택여부" value="${pmVo.pmSeq }" disabled="disabled">
						   			</c:otherwise>
								</c:choose>
							</nobr>
							</td>
							<td>
							<nobr>
							<c:if test="${null ne pmVo.statCd}">
								<div class="server-info server
									<c:choose>
										<c:when test='${"01" eq pmVo.statCd}'><c:out value="server-down"/></c:when>
										<c:when test='${"02" eq pmVo.statCd}'><c:out value="server-up"/></c:when>
										<c:when test='${"03" eq pmVo.statCd}'><c:out value="server-maintain"/></c:when>
										<c:when test='${"04" eq pmVo.statCd}'><c:out value="server-inprogress"/></c:when>
										<c:when test='${"05" eq pmVo.statCd}'><c:out value="server-exception"/></c:when>
							   			<c:otherwise></c:otherwise>
									</c:choose>
								">
									<div class="server-info-body alignL">
										<div class="server-info-box alignL">
											<span class="label"></span><h4 class="stat"><c:out value="${pmVo.statCdNm }" /></h4>
									   </div>
									</div>
								</div>
							</c:if>
							</nobr>
							</td>
							<td class="alignL"><nobr><c:out value="${pmVo.regionNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${pmVo.zoneNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${pmVo.netClCdNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${pmVo.rsrcPoolNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${pmVo.clstrNm }" /></nobr></td>
							<td class="alignL"><nobr>
								<c:choose>
									<c:when test="${'01' eq pmVo.pmClCd}">
										<a href="<c:url value="${selectPmUrl }" />" title="<c:out value="${pmVo.pmCompId }"/>"><c:out value="${pmVo.pmCompId }" /></a>
									</c:when>
									<c:otherwise>
										<a href="<c:url value="${selectNetPmUrl }" />" title="<c:out value="${pmVo.pmCompId }"/>"><c:out value="${pmVo.pmCompId }" /></a>
									</c:otherwise>
								</c:choose>
							</nobr></td>
							<td class="alignL"><nobr>
								<c:choose>
									<c:when test="${'01' eq pmVo.pmClCd}">
										<a href="<c:url value="${selectPmUrl }" />" title="<c:out value="${pmVo.pmNm }"/>"><c:out value="${pmVo.pmNm }" /></a>
									</c:when>
									<c:otherwise>
										<a href="<c:url value="${selectNetPmUrl }" />" title="<c:out value="${pmVo.pmNm }"/>"><c:out value="${pmVo.pmNm }" /></a>
									</c:otherwise>
								</c:choose>
							</nobr></td>
							<td class="alignL"><nobr>
								<c:choose>
									<c:when test="${'01' eq pmVo.pmClCd}">
										<a href="<c:url value="${selectPmUrl }" />" title="<c:out value="${pmVo.pmId }"/>"><c:out value="${pmVo.pmId }" /></a>
									</c:when>
									<c:otherwise>
										<a href="<c:url value="${selectNetPmUrl }" />" title="<c:out value="${pmVo.pmId }"/>"><c:out value="${pmVo.pmId }" /></a>
									</c:otherwise>
								</c:choose>
							</nobr></td>
							<td class="alignL"><nobr><c:out value="${pmVo.rprsntIpAddr }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${pmVo.vrlzSwTyCdNm }" /></nobr></td>
							<td class="alignR"><nobr><c:out value="${pmVo.vmCnt }" /></nobr></td>
							<td class="notellipsis">
								<span class="label label-green"><fmt:formatNumber value="${pmVo.cpuUseRt}" pattern="0"/></span>
								<div class="progress">
									<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${pmVo.cpuUseRt}" pattern="0"/>%"></div>
								</div>
							</td>
							<td class="alignR"><nobr><fmt:formatNumber value="${pmVo.cpuVrlzRt}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><c:out value="${pmVo.totCpuVcoreQty }"/></nobr></td>
							<td class="alignR"><nobr><c:out value="${pmVo.cpuCoreQty }"/></nobr></td>
							<td class="notellipsis">
								<span class="label label-green"><fmt:formatNumber value="${pmVo.memUseRt}" pattern="0"/></span>
								<div class="progress">
									<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${pmVo.memUseRt}" pattern="0"/>%"></div>
								</div>
							</td>
							<td class="alignR"><nobr><fmt:formatNumber value="${pmVo.memVrlzRt}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${pmVo.totMemAsgnCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${pmVo.memCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${pmVo.totStrgAsgnCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${pmVo.netwkIn }" pattern="0.0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${pmVo.netwkOut }" pattern="0.0"/></nobr></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${pmSearchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize onlyOprAdm="true">
					<button type="button" class="btn btn-sm btn-hover-blue" data-toggle="tooltip" title="생성요청" data-original-title="생성 요청" onclick="fn_insertPmCreReq();"><i class="fa fa-plus"></i></button>
					<button type="button" class="btn btn-sm btn-hover-red" data-toggle="tooltip" title="삭제요청" data-original-title="삭제 요청" onclick="fn_insertPmDelReq();"><i class="fa fa-minus"></i></button>
				</menu:authorize>
			</div>
		</div>

	</div>

</div>

<script type="text/javascript">

// 검색조건 초기화
function fn_initialize(){
	$('#pmSearchVo input[type="text"]').val('');
	$('#pmSearchVo select').val('').attr('selected', 'selected');
	$('#pmSearchVo input[type="checkbox"][name="searchVrlzSwTyCdList"]').prop('checked', 'checked');
	$('#pmSearchVo input[type="checkbox"][data-name="netPmSltAt"]').prop('checked', '');
}

// 조회
function fn_selectPmList(){
	$('#pmSearchVo').attr('target', '_self');
	$('#pmSearchVo').attr('action', '<c:url var="select" value="selectPmList.do"/>');
	$('#pmSearchVo').submit();
}

// 물리서버 생성요청
function fn_insertPmCreReq(){
	location.href = '${insertPmCreUrl}';
}

// 물리서버 삭제요청
function fn_insertPmDelReq(){
	if($('.list-box table input[type="radio"]:checked').length == 0){
		jAlert("선택된 물리서버가 없습니다.");
		return;
	}


	location.href = '<c:url value="insertPmDelReq.do"><c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach></c:url><c:choose><c:when test="${param eq null or param.isEmpty()}"><c:out value="?"/></c:when><c:otherwise><c:out value="&" escapeXml="false"/></c:otherwise></c:choose>pmSeq=' + $('.list-box table input[type="radio"]:checked').val();
}

// 페이지 이동
function fn_goPage(page){
	location.href = '<c:url value="selectPmList.do"/>?paginationInfo.currentPageNo=' + page + '&${listParam}';
}

// 목록의 정보를 Excel로 다운로드 한다.
function fn_selectPmListXlsDwnl() {
	if("${pmSearchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("다운로드 할 데이터가 없습니다.");
		return;
	}
	$('#pmSearchVo').attr('target', '_self');
	$('#pmSearchVo').attr('action', '<c:url value="selectPmListXlsDwnl.do"/>');
	$('#pmSearchVo').submit();
}

$("#pmTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	                {sWidth : "35px" },
	                {sWidth : "94px" },
	                {sWidth : "35px" },
	                {sWidth : "35px" },
	                {sWidth : "65px" },
	                {sWidth : "90px" },
	                {sWidth : "50px" },
	                {sWidth : "87px" },
	                {sWidth : "135px" },
	                {sWidth : "87px" },
	                {sWidth : "97px" },
	                {sWidth : "80px" },
	                {sWidth : "60px" },
	                {sWidth : "38px" },
	                {sWidth : "48px" },
	                {sWidth : "38px" },
	                {sWidth : "35px" },
	                {sWidth : "38px" },
	                {sWidth : "48px" },
	                {sWidth : "38px" },
	                {sWidth : "38px" },
	                {sWidth : "48px" },
	                {sWidth : "48px" },
	                {sWidth : "48px" }
	 ],

	order : [[0, "desc"]]
});

</script>
