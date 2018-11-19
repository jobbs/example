<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     송승규         v1.0             최초생성
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

<div class="col-box-100 search-col">
	<div class="box box-search">
		<div class="box-header">
			<h3 class="box-title">검색조건</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
					<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
				</button>
			</div>
		</div>
		<form:form id="searchVo" commandName="searchVo" method="get">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
		<div class="box-body collapse in search-collapse">
			<div class="form-group">
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="regionId">센터</label>
					</div>
					<div class="cell-body">
						<nform:selectRegion
				          name="regionId"
				          id="regionId"
				          title="센터"
				          whole="true"
				          wholeText="전체"
				          cssClass="form-control input-sm"
				          value="${searchVo.regionId}"
				          onchange="selectZoneByNetClCd('regionId', 'zoneId', 'netClCd', 'poolId')" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="zoneId">존</label>
					</div>
					<div class="cell-body">
						<nform:selectZone
				          name="zoneId"
				          id="zoneId"
				          whole="true"
				          regionId="${searchVo.regionId}"
				          value="${searchVo.zoneId}"
				          wholeText="전체"
				          cssClass="form-control input-sm"
				          onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'poolId', {'searchSwTypeCd' : 'NET', searchPoolTypeCd : '03','searchCtlTrgtYn' : ''})" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="netClCd">망구분</label>
					</div>
					<div class="cell-body">
						<nform:selectCode
				          parentCd="NETCD"
				          parentGrpCd="067"
				          name="netClCd"
				          id="netClCd"
				          whole="true"
				          wholeText="전체"
				          extra1=""
				          extra2=""
				          extra3=""
				          value="${searchVo.netClCd}"
				          extra4=""
				          extra5=""
				          cssClass="form-control input-sm"
				          onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'poolId', {'searchSwTypeCd' : 'NET', searchPoolTypeCd : '03','searchCtlTrgtYn' : ''})"  />

					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="poolId">자원풀</label>
					</div>
					<div class="cell-body">
						<nform:selectPool
				          name="poolId"
				          id="poolId"
				          title="자원풀"
				          wholeText="전체"
				          poolTypeCd="03"
				          cssClass="form-control input-sm"
				          swTypeCd="NET"
				          regionId="${searchVo.regionId }"
				          zoneId="${searchVo.zoneId}"
				          netClCd="${searchVo.netClCd }"
				          value="${searchVo.poolId}"
				          ctlTrgtYn=""/>
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="statCd">상태</label>
					</div>
					<div class="cell-body">
						<form:select path="statCd" title="상태" cssClass="form-control input-sm">
							<c:forEach var="statCdCode" items="${statCdCode }">
								<form:option value="${statCdCode.cd}" ><c:out value="${statCdCode.cdNm }"/></form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="clstrNm">클러스터명</label>
					</div>
					<div class="cell-body">
						<form:input path="clstrNm" title="클러스터명" cssClass="form-control input-sm" value="${searchVo.clstrNm}" maxlength="100" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="pmNm">물리서버명</label>
					</div>
					<div class="cell-body">
						<form:input path="pmNm" title="물리서버명" cssClass="form-control input-sm" value="${searchVo.pmNm}" maxlength="100" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="pmCompId" title="물리서버구성ID">물리서버구성ID</label>
					</div>
					<div class="cell-body">
						<form:input path="pmCompId" title="물리서버구성ID" cssClass="form-control input-sm" value="${searchVo.pmCompId}" maxlength="10" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="netwkTyClCd">네트워크유형</label>
					</div>
					<div class="cell-body">
						<form:select path="netwkTyClCd" title="네트워크유형" cssClass="form-control input-sm">
							<c:forEach var="netwkTyClCdCode" items="${netwkTyClCdCode }">
								<form:option value="${netwkTyClCdCode.cd}" ><c:out value="${netwkTyClCdCode.cdNm }"/></form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="vmCompId" title="가상서버구성ID">가상서버구성ID</label>
					</div>
					<div class="cell-body">
						<form:input path="vmCompId" title="가상서버구성ID" cssClass="form-control input-sm" value="${searchVo.vmCompId}" maxlength="10" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="vmId">가상서버ID</label>
					</div>
					<div class="cell-body">
						<form:input path="vmId" title="가상서버ID" cssClass="form-control input-sm" value="${searchVo.vmId}" maxlength="100" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="vmNm">가상서버명</label>
					</div>
					<div class="cell-body">
						<form:input path="vmNm" title="가상서버명" cssClass="form-control input-sm" value="${searchVo.vmNm}" maxlength="100" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="hstNm">호스트명</label>
					</div>
					<div class="cell-body">
						<form:input path="hstNm" title="호스트명" cssClass="form-control input-sm" value="${searchVo.hstNm}" maxlength="100" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="rprsntIpAddr">IP주소</label>
					</div>
					<div class="cell-body">
						<form:input path="rprsntIpAddr" title="IP주소" cssClass="form-control input-sm onlyIp" value="${searchVo.rprsntIpAddr}" maxlength="15" />
					</div>
				</div>
<!--
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="osTyCd">OS유형</label>
					</div>
					<div class="cell-body">
						<form:select path="osTyCd" title="OS유형" cssClass="form-control input-sm">
							<c:forEach var="osTyCdCode" items="${osTyCdCode }">
								<form:option value="${osTyCdCode.cd}" ><c:out value="${osTyCdCode.cdNm }"/></form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
-->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="institutionNm">부처</label>
					</div>
					<div class="cell-body">
						<form:input path="institutionNm" title="부처" cssClass="form-control input-sm" value="${searchVo.institutionNm}" maxlength="30" />
					</div>
				</div>
				<div class="form-cell form-cell-100 col-lay-100">
					<div class="cell-title">
						<label for="vrlzSwTyCdList">가상화SW</label>
					</div>
					<div class="cell-body">
						<div class="input-group input-group-check">
							<c:choose>
								<c:when test="${searchVo eq null or searchVo.vrlzSwTyCdList eq null }">
									<c:forEach var="vrlzSwTyCdCode" items="${vrlzSwTyCdCode }" varStatus="i">
										<form:checkbox path="vrlzSwTyCdList[${i.index }]" title="가상화SW ${vrlzSwTyCdCode.cdNm}" value="${vrlzSwTyCdCode.cd}" id="${vrlzSwTyCdCode.cd}" checked="checked"/>
										<label for="${vrlzSwTyCdCode.cd}"><c:out value="${vrlzSwTyCdCode.cdNm}"/></label>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach var="vrlzSwTyCdCode" items="${vrlzSwTyCdCode }" varStatus="i">
										<form:checkbox path="vrlzSwTyCdList[${i.index }]" title="가상화SW ${vrlzSwTyCdCode.cdNm}" value="${vrlzSwTyCdCode.cd}" id="${vrlzSwTyCdCode.cd}"/>
										<label for="${vrlzSwTyCdCode.cd}"><c:out value="${vrlzSwTyCdCode.cdNm}"/></label>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="box-footer collapse in search-collapse">
			<div class="pull-left">
				<button type="button" class="btn" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
			</div>
			<div class="pull-right">
				<button type="button" class="btn btn-red pull-right" onclick="fn_selectNetVmList();" title="조회">조회</button>
			</div>
		</div>
		</form:form>
	</div>
</div>
<div class="col-box-100 search-col">
	<div class="box list-box">
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
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_selectNetVmListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
			<table id="netVmTable" class="table table-hover table-vertical table-layout-fixed">
				<caption>네트워크 가상서버 목록 테이블</caption>
				<thead>
					<tr>
						<th><nobr>No.</nobr></th>
						<th><nobr>상태</nobr></th>
						<th><nobr>부처</nobr></th>
						<th><nobr>네트워크<br/>유형</nobr></th>
						<th><nobr>센터</nobr></th>
						<th><nobr>존</nobr></th>
						<th><nobr>망구분</nobr></th>
						<th><nobr>자원풀</nobr></th>
						<th><nobr>클러스터명</nobr></th>
						<th><nobr>물리서버명</nobr></th>
						<th><nobr>물리서버구성ID</nobr></th>
						<th><nobr>가상서버명</nobr></th>
						<th><nobr>가상서버구성ID</nobr></th>
						<th><nobr>가상서버ID</nobr></th>
						<th><nobr>호스트명</nobr></th>
						<th><nobr>IP주소</nobr></th>
						<th><nobr>가상화SW</nobr></th>
						<th><nobr>CPU<br>사용률<br>(%)</nobr></th>
						<th><nobr>CPU<br>vCore</nobr></th>
						<th><nobr>메모리<br>사용률<br>(%)</nobr></th>
						<th><nobr>메모리<br>할당량<br>(GB)</nobr></th>
						<th><nobr>스토리지<br>(GB)</nobr></th>
						<th><nobr>네트워크<br>In<br>(KB/S)</nobr></th>
						<th><nobr>네트워크<br>Out<br>(KB/S)</nobr></th>
						<th><nobr>기동일시</nobr></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="netVmVo" items="${netVmList }" varStatus="i">
						<c:url var="detailUrl" value="selectNetVm.do">
							<c:param name="vmSeq" value="${netVmVo.vmSeq }" />
							<c:forEach var="curParam" items="${param}">
								<c:param name="${curParam.key}" value="${curParam.value}" />
							</c:forEach>
						</c:url>
						<tr>
							<td><input type="hidden" name="seq" value="<c:out value="${netVmVo.vmSeq }" />"><nobr><c:out value="${netVmList.size() - i.index }" /></nobr></td>
							<td>
								<div class="server-info server <c:choose>
																	<c:when test='${"01" eq netVmVo.statCd}'><c:out value="server-down"/></c:when>
																	<c:when test='${"02" eq netVmVo.statCd}'><c:out value="server-up"/></c:when>
																	<c:when test='${"03" eq netVmVo.statCd}'><c:out value="server-inprogress"/></c:when>
																	<c:when test='${"04" eq netVmVo.statCd}'><c:out value="server-exception"/></c:when>
																	<c:otherwise></c:otherwise>
																</c:choose>">
									<div class="server-info-body alignL">
										<div class="server-info-box alignL">
											<span class="label"></span><h4 class="stat"><c:out value="${netVmVo.statCdNm }" /></h4>
										</div>
									</div>
								</div>
							</td>
<%-- 							<td class="alignL"><nobr><c:out value="${netVmVo.statCdNm }" /></nobr></td> --%>
							<td class="alignL"><nobr title="${netVmVo.institutionNm }"><c:out value="${netVmVo.institutionNm }" /></nobr></td>
							<td><nobr><c:out value="${netVmVo.netwkTyClCdNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${netVmVo.regionNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${netVmVo.zoneNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${netVmVo.netClCdNm }" /></nobr></td>
							<%-- 망구분으로 변경 <td class="alignL"><nobr><c:out value="${netVmVo.netNm }" /></nobr></td> --%>
							<td class="alignL"><nobr title="${netVmVo.rsrcPoolNm }"><c:out value="${netVmVo.rsrcPoolNm }" /></nobr></td>
							<td class="alignL"><nobr title="${netVmVo.clstrNm }"><c:out value="${netVmVo.clstrNm }" /></nobr></td>
							<td class="alignL"><nobr title="${netVmVo.pmNm }"><c:out value="${netVmVo.pmNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${netVmVo.pmCompId }" /></nobr></td>
							<td class="alignL"><nobr>
								<a href="<c:url value="${detailUrl }" />" title="<c:out value="${netVmVo.vmNm }"/> 상세 화면이동"><c:out value="${netVmVo.vmNm }" /></a>
							</nobr></td>
							<td><nobr><c:out value="${netVmVo.vmCompId }" /></nobr></td>
							<td class="alignL"><nobr>
								<a href="<c:url value="${detailUrl }" />" title="<c:out value="${netVmVo.vmId }"/> 상세 화면이동"><c:out value="${netVmVo.vmId }" /></a>
							</nobr></td>
							<td class="alignL"><nobr title="${netVmVo.hstNm }"><c:out value="${netVmVo.hstNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${netVmVo.rprsntIpAddr }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${netVmVo.vrlzSwTyCdNm }" /></nobr></td>
							<td>
								<span class="label label-green"><fmt:formatNumber value="${netVmVo.cpuUseRt}" pattern="0"/></span>
								<br>
								<div class="progress">
									<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${netVmVo.cpuUseRt}" pattern="0"/>%"></div>
								</div>
							</td>
							<td class="alignR"><nobr><c:out value="${netVmVo.cpuVcoreQty }"/></nobr></td>
							<td>
								<span class="label label-green"><fmt:formatNumber value="${netVmVo.memUseRt}" pattern="0"/></span>
								<br>
								<div class="progress">
									<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${netVmVo.memUseRt}" pattern="0"/>%"></div>
								</div>
							</td>
							<td class="alignR"><nobr><fmt:formatNumber value="${netVmVo.memAsgnCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${netVmVo.strgAsgnCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${netVmVo.netwkIn }" pattern="0.0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${netVmVo.netwkOut }" pattern="0.0"/></nobr></td>
							<td><nobr><fmt:formatDate value="${netVmVo.strtupDttm }" pattern="yyyy-MM-dd HH:mm:ss" /></nobr></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize onlyOprAdm="true">
					<button type="button" class="btn btn-sm btn-hover-blue" data-toggle="tooltip" title="" data-original-title="SLB 생성 요청" onclick="fn_insertSLBCreReq();"><i class="fa fa-plus"></i></button>
				</menu:authorize>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">

	// 검색조건 초기화
	function fn_reset(){
		$('#searchVo input[type="text"]').val('');
		$('#searchVo select').val('').attr('selected', 'selected');
		$('#searchVo input[type="checkbox"]').prop('checked', 'checked');
	}

	// 조회
	function fn_selectNetVmList(){

		$("#searchVo").attr("action", "selectNetVmList.do");
		$("#searchVo").submit();
	}

	// SLB
	function fn_insertSLBCreReq(){

		location.href = '<c:url value="insertSlbReq.do"><c:forEach var="curParam" items="${param}"><c:param name="${curParam.key}" value="${curParam.value}" /></c:forEach></c:url>';
	}

	// 페이지 이동
	function fn_goPage(page){
		location.href = "<c:url value='selectNetVmList.do?paginationInfo.currentPageNo=" + page + "&${listParam}'/>";
	}

	// 목록의 정보를 Excel로 다운로드 한다.
	function fn_selectNetVmListXlsDwnl() {
		if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}

		$('#searchVo').attr('action', 'selectNetVmListXlsDwnl.do');
		$('#searchVo').submit();
	}

	$("#netVmTable").DataTable( {
		dom: 'Zlfrtip' ,
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [
					{sWidth : "25px" },
					{sWidth : "94px" },
					{sWidth : "92px" },
					{sWidth : "50px" },
					{sWidth : "30px" },
					{sWidth : "30px" },
					{sWidth : "55px" },
					{sWidth : "120px" }, // 자원풀
					{sWidth : "80px" }, // 클러스터명
					{sWidth : "120px" }, // 물리서버명
					{sWidth : "82px" },  // 물리서버구성ID
					{sWidth : "150px" }, // 가상서버명
					{sWidth : "82px" },  // 가상서버구성ID
					{sWidth : "90px" },
					{sWidth : "80px" },
					{sWidth : "100px" },
					{sWidth : "100px" },
					{sWidth : "40px" },
					{sWidth : "40px" },
					{sWidth : "40px" },
					{sWidth : "40px" },
					{sWidth : "50px" },
					{sWidth : "50px" },
					{sWidth : "50px" },
					{sWidth : "130px" }
					],
		order : [[ 0, "desc"]]
	});
</script>