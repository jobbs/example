<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     최경철         v1.0             최초생성
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
					<i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기" data-original-title="접어두기"></i>
				</button>
			</div>
		</div>

		<form:form commandName="netPmSearchVo" method="get">
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
								value="${netPmSearchVo.searchRegionId}"
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
								regionId="${netPmSearchVo.searchRegionId}"
								value="${netPmSearchVo.searchZoneId}"
								onchange="selectPoolByNetClCd('searchRegionId', 'searchZoneId', 'searchNetClCd', 'searchRsrcPoolId', {'searchPoolTypeCd':'03', 'searchCtlTrgtYn' : 'N'} )" />
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
								zoneId="${netPmSearchVo.searchZoneId}"
								value="${netPmSearchVo.searchNetClCd}"
								onchange="selectPoolByNetClCd('searchRegionId', 'searchZoneId', 'searchNetClCd', 'searchRsrcPoolId', {'searchPoolTypeCd':'03', 'searchCtlTrgtYn' : 'N'} )" />
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
								poolTypeCd="03"
								ctlTrgtYn="N"
								regionId="${netPmSearchVo.searchRegionId }"
								zoneId="${netPmSearchVo.searchZoneId}"
								netClCd="${netPmSearchVo.searchNetClCd }"
								value="${netPmSearchVo.searchRsrcPoolId}" />
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
						<label title="IP주소">IP주소</label>
					</div>
					<div class="cell-body">
						<form:input path="searchRprsntIpAddr" name="searchRprsntIpAddr" title="IP주소" cssClass="form-control input-sm onlyIp" value=""/>
					</div>
				</div>

				<!-- 검색조건 : checkbox -->
				<div class="form-cell form-cell-100 col-lay-100">
					<div class="cell-title">
						<label title="가상화SW">가상화SW</label>
					</div>
					<div class="cell-body">
						<div class="input-group input-group-check">
							<c:choose>
								<c:when test="${netPmSearchVo eq null or netPmSearchVo.searchVrlzSwTyCdList eq null}">
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

			</div>

		</div>

		<!-- box-footer -->
		<div class="box-footer collapse in search-collapse">
		  <div class="pull-left">
		    <button type="button" class="btn" title="초기화" onclick="fn_initialize();">초기화</button>
		  </div>
		  <div class="pull-right">
		  	<c:url var="selectNetPmListUrl" value="selectNetPmList.do">
			</c:url>
		    <button type="button" class="btn btn-red pull-right" title="조회" onclick="fn_selectNetPmList();">조회</button>
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
				${netPmSearchVo.paginationInfo.currentPageNo } /
				${netPmSearchVo.paginationInfo.totalPageCount },
				총 ${netPmSearchVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="netPmSearchVo" value="${netPmSearchVo }"/>
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="엑셀다운로드" data-original-title="엑셀다운로드" onclick="fn_selectNetPmListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table id="netPmTable" class="table table-hover table-vertical table-layout-fixed">
			<caption>네트워크 물리서버 목록 테이블</caption>
				<thead>
					<tr>
						<th><nobr>No.</nobr></th>
						<th><nobr>상태</nobr></th>
						<th><nobr>센터</nobr></th>
						<th><nobr>존</nobr></th>
						<th><nobr>망구분</nobr></th>
						<th><nobr>자원풀</nobr></th>
						<th><nobr>물리서버 구성ID</nobr></th>
						<th><nobr>물리서버명</nobr></th>
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
					<c:forEach var="netPmVo" items="${netPmVoList }" varStatus="i">
						<c:url var="selectNetPmUrl" value="selectNetPm.do">
							<c:param name="pmSeq" value="${netPmVo.pmSeq }" />
							<c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach>
						</c:url>
						<tr>
							<td><nobr><c:out value="${(netPmSearchVo.paginationInfo.totalRecordCount-netPmSearchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></nobr></td>
							<td>
							<nobr>
							<c:if test="${null ne netPmVo.statCd}">
								<div class="server-info server
									<c:choose>
										<c:when test='${"01" eq netPmVo.statCd}'><c:out value="server-down"/></c:when>
										<c:when test='${"02" eq netPmVo.statCd}'><c:out value="server-up"/></c:when>
										<c:when test='${"03" eq netPmVo.statCd}'><c:out value="server-maintain"/></c:when>
										<c:when test='${"04" eq netPmVo.statCd}'><c:out value="server-inprogress"/></c:when>
										<c:when test='${"05" eq netPmVo.statCd}'><c:out value="server-exception"/></c:when>
							   			<c:otherwise></c:otherwise>
									</c:choose>
								">
									<div class="server-info-body alignL">
										<div class="server-info-box alignL">
											<span class="label"></span><h4 class="stat"><c:out value="${netPmVo.statCdNm }" /></h4>
									   </div>
									</div>
								</div>
							</c:if>
							</nobr>
							</td>
							<td class="alignL"><nobr><c:out value="${netPmVo.regionNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${netPmVo.zoneNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${netPmVo.netClCdNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${netPmVo.rsrcPoolNm }" /></nobr></td>
							<td class="alignL"><nobr>
								<a href="<c:url value="${selectNetPmUrl }" />" title="<c:out value="${netPmVo.pmCompId }"/>"><c:out value="${netPmVo.pmCompId }" /></a>
							</nobr></td>
							<td class="alignL"><nobr>
								<a href="<c:url value="${selectNetPmUrl }" />" title="<c:out value="${netPmVo.pmNm }"/>"><c:out value="${netPmVo.pmNm }" /></a>
							</nobr></td>
							<td class="alignL"><nobr><c:out value="${netPmVo.rprsntIpAddr }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${netPmVo.vrlzSwTyCdNm }" /></nobr></td>
							<td class="alignR"><nobr><c:out value="${netPmVo.vmCnt }" /></nobr></td>
							<td class="notellipsis">
								<span class="label label-green"><fmt:formatNumber value="${netPmVo.cpuUseRt}" pattern="0"/></span>
								<div class="progress">
									<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${netPmVo.cpuUseRt}" pattern="0"/>%"></div>
								</div>
							</td>
							<td class="alignR"><nobr><fmt:formatNumber value="${netPmVo.cpuVrlzRt}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><c:out value="${netPmVo.totCpuVcoreQty }"/></nobr></td>
							<td class="alignR"><nobr><c:out value="${netPmVo.cpuCoreQty }"/></nobr></td>
							<td class="notellipsis">
								<span class="label label-green"><fmt:formatNumber value="${netPmVo.memUseRt}" pattern="0"/></span>
								<div class="progress">
									<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${netPmVo.memUseRt}" pattern="0"/>%"></div>
								</div>
							</td>
							<td class="alignR"><nobr><fmt:formatNumber value="${netPmVo.memVrlzRt}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${netPmVo.totMemAsgnCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${netPmVo.memCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${netPmVo.totStrgAsgnCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${netPmVo.netwkIn }" pattern="0.0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${netPmVo.netwkOut }" pattern="0.0"/></nobr></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${netPmSearchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
		</div>

	</div>

</div>

<script type="text/javascript">

// 검색조건 초기화
function fn_initialize(){
	$('#netPmSearchVo input[type="text"]').val('');
	$('#netPmSearchVo select').val('').attr('selected', 'selected');
	$('#netPmSearchVo input[type="checkbox"][name="searchVrlzSwTyCdList"]').prop('checked', 'checked');
}

// 조회
function fn_selectNetPmList(){
	$('#netPmSearchVo').attr('target', '_self');
	$('#netPmSearchVo').attr('action', '<c:url var="select" value="selectNetPmList.do"/>');
	$('#netPmSearchVo').submit();
}

// 페이지 이동
function fn_goPage(page){
	location.href = '<c:url value="selectNetPmList.do"/>?paginationInfo.currentPageNo=' + page + '&${listParam}';
}

// 목록의 정보를 Excel로 다운로드 한다.
function fn_selectNetPmListXlsDwnl() {
	if("${netPmSearchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("다운로드 할 데이터가 없습니다.");
		return;
	}
	$('#netPmSearchVo').attr('target', '_self');
	$('#netPmSearchVo').attr('action', '<c:url value="selectNetPmListXlsDwnl.do"/>');
	$('#netPmSearchVo').submit();
}

$("table").DataTable( {
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
	                {sWidth : "87px" },
	                {sWidth : "185px" },
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
} );

</script>