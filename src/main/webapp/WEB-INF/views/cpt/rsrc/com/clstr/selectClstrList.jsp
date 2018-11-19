<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>클러스터 목록 화면</pre>
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     심원보         v1.0             최초생성
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

<c:set var="clstrSearchVoClass" value="ncis.cpt.rsrc.com.vo.ClstrSearchVo"/>
<c:set var="groupClass" value="ncis.cpt.rsrc.com.validation.SearchValidation"/>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>
<!-- 검색조건 영역 -->
<div class="col-box-100 search-col">

	<div class="box box-search">

		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">검색조건</h3>
			<div class="box-tools pull-right">
				<!-- 접기 버튼 -->
				<button type="button" class="btn btn-sm" title="접어두기" data-toggle="collapse" data-target=".search-collapse">
					<i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기" data-original-title="접어두기" ></i>
				</button>
			</div>
		</div>

		<form:form commandName="clstrSearchVo" method="get">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
		<!-- box-body -->
		<div class="box-body collapse in search-collapse">

			<div class="form-group">

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="센터" for="equalsRegionId">센터</label>
					</div>
					<div class="cell-body">
						<nform:selectRegion
				          name="equalsRegionId"
				          id="equalsRegionId"
				          title="센터"
				          whole="true"
				          wholeText="전체"
				          cssClass="form-control input-sm"
				          value="${clstrSearchVo.equalsRegionId}"
				          onchange="selectZoneByNetClCd('equalsRegionId', 'equalsZoneId', 'equalsNetClCd', 'equalsRsrcPoolId')" />
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="존" for="equalsZoneId">존</label>
					</div>
					<div class="cell-body">
						<nform:selectZone
				          name="equalsZoneId"
				          id="equalsZoneId"
				          whole="true"
				          regionId="${clstrSearchVo.equalsRegionId}"
				          poolTypeCd='01'
				          value="${clstrSearchVo.equalsZoneId}"
				          wholeText="전체"
				          cssClass="form-control input-sm"
				          onchange="selectPoolByNetClCd('equalsRegionId', 'equalsZoneId', 'equalsNetClCd', 'equalsRsrcPoolId',{searchPoolTypeCd : '01','searchCtlTrgtYn' : 'Y'})" />
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="망구분" for="equalsNetClCd">망구분</label>
					</div>
					<div class="cell-body">
						<nform:selectCode
					          parentCd="NETCD"
					          parentGrpCd="067"
					          name="equalsNetClCd"
					          id="equalsNetClCd"
					          whole="true"
					          poolTypeCd='01'
					          wholeText="전체"
					          extra1=""
					          extra2=""
					          extra3=""
					          value="${clstrSearchVo.equalsNetClCd}"
					          extra4=""
					          extra5=""
					          cssClass="form-control input-sm"
					          onchange="selectPoolByNetClCd('equalsRegionId', 'equalsZoneId', 'equalsNetClCd', 'equalsRsrcPoolId', {searchPoolTypeCd : '01','searchCtlTrgtYn' : 'Y'})"  />

					</div>


				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="자원풀" for="equalsRsrcPoolId">자원풀</label>
					</div>
					<div class="cell-body">
						<nform:selectPool
						          name="equalsRsrcPoolId"
						          id="equalsRsrcPoolId"
						          title="자원풀"
						          wholeText="전체"
						          poolTypeCd="01"
						          cssClass="form-control input-sm"
						          swTypeCd="COM"
						          regionId="${clstrSearchVo.equalsRegionId }"
						          zoneId="${clstrSearchVo.equalsZoneId}"
						          netClCd="${clstrSearchVo.equalsNetClCd }"
						          value="${clstrSearchVo.equalsRsrcPoolId}"
						          ctlTrgtYn=""/>
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="사용여부" for="equalsUseYn">사용여부</label>
					</div>
					<div class="cell-body">
						<form:select path="equalsUseYn" name="equalsUseYn" title="사용여부" cssClass="form-control input-sm">
							<form:option value="">전체</form:option>
							<form:option value="Y">사용</form:option>
							<form:option value="N">미사용</form:option>
						</form:select>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="클러스터ID" for="containsClstrId">클러스터ID</label>
					</div>
					<div class="cell-body">
						<form:input path="containsClstrId" name="containsClstrId" title="클러스터ID" cssClass="form-control input-sm" value="" maxlength="${ivu.getMaxlength(clstrSearchVoClass, 'containsClstrId', groupClass)}" />
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="클러스터명" for="containsClstrNm">클러스터명</label>
					</div>
					<div class="cell-body">
						<form:input path="containsClstrNm" name="containsClstrNm" title="클러스터명" cssClass="form-control input-sm" value="" maxlength="${ivu.getMaxlength(clstrSearchVoClass, 'containsClstrNm', groupClass)}" />
					</div>
				</div>

				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
					</div>
					<div class="cell-body">
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
								<c:when test="${clstrSearchVo eq null or clstrSearchVo.existsVrlzSwTyCdList eq null}">
									<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
										<form:checkbox path="existsVrlzSwTyCdList[${i.index }]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}" data-name="existsVrlzSwTyCdList" checked="checked"/>
										<label title="" for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
										<form:checkbox path="existsVrlzSwTyCdList[${i.index }]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}" data-name="existsVrlzSwTyCdList"/>
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
		    <button type="button" title="초기화" class="btn" onclick="fn_initialize();">초기화</button>
		  </div>
		  <div class="pull-right">
		  	<c:url var="selectClstrListUrl" value="selectClstrList.do">
			</c:url>
		    <button type="button" title="조회" class="btn btn-red pull-right" onclick="fn_selectClstrList();">조회</button>
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
				${clstrSearchVo.paginationInfo.currentPageNo } /
				${clstrSearchVo.paginationInfo.totalPageCount },
				총 ${clstrSearchVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="clstrSearchVo" value="${clstrSearchVo }"/>
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="엑셀다운로드" data-original-title="엑셀다운로드" onclick="fn_selectClstrListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table id="clstrTable" class="table table-hover table-vertical table-layout-fixed">
				<caption>클러스터 목록</caption>
				<thead>
					<tr>
						<th><nobr title="선택">선택</nobr></th>
						<th><nobr title="사용여부">사용여부</nobr></th>
						<th><nobr title="센터">센터</nobr></th>
						<th><nobr title="존">존</nobr></th>
						<th><nobr title="망구분">망구분</nobr></th>
						<th><nobr title="자원풀">자원풀</nobr></th>
						<th><nobr title="클러스터ID">클러스터ID</nobr></th>
						<th><nobr title="클러스터명">클러스터명</nobr></th>
						<th><nobr title="가상화SW">가상화SW</nobr></th>
						<th><nobr title="물리서버수">물리서버수</nobr></th>
						<th><nobr title="가상서버수">가상서버수</nobr></th>
						<th><nobr title="CPU 사용률 (%)">CPU<br>사용률<br>(%)</nobr></th>
						<th><nobr title="CPU 가상화율 (%)">CPU<br>가상화율<br>(%)</nobr></th>
						<th><nobr title="CPU vCore">CPU<br>vCore</nobr></th>
						<th><nobr title="CPU Core">CPU<br>Core</nobr></th>
						<th><nobr title="메모리 사용률 (%)">메모리<br>사용률<br>(%)</nobr></th>
						<th><nobr title="메모리 가상화율 (%)">메모리<br>가상화율<br>(%)</nobr></th>
						<th><nobr title="메모리 할당량 (GB)">메모리<br>할당량<br>(GB)</nobr></th>
						<th><nobr title="메모리 전체량 (GB)">메모리<br>전체량<br>(GB)</nobr></th>
						<th><nobr title="스토리지 (TB)">스토리지<br>할당량<br>(TB)</nobr></th>
						<th><nobr title="네트워크 In (KB/S)">네트워크<br>In<br>(KB/S)</nobr></th>
						<th><nobr title="네트워크 Out (KB/S)">네트워크<br>Out<br>(KB/S)</nobr></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="clstrVo" items="${clstrVoList }" varStatus="i">
						<c:url var="selectClstrUrl" value="selectClstr.do">
							<c:param name="clstrSeq" value="${clstrVo.clstrSeq }" />
							<c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach>
						</c:url>
						<tr>
							<td><nobr><input type="radio" name="clstr_row" title="선택여부" value="${clstrVo.clstrSeq }" <c:if test='${"Y" ne clstrVo.ctlTrgtYn }'><c:out value="disabled"/></c:if>/></nobr></td>
							<td>
								<nobr>
									<c:choose>
										<c:when test="${ clstrVo.useYn eq 'Y' }">
											<span title="사용" class="status status-green">사용</span>
										</c:when>
										<c:otherwise>
											<span title="미사용" class="status status-gray">미사용</span>
										</c:otherwise>
									</c:choose>
								</nobr>
							</td>
							<td class="alignL"><nobr title="<c:out value="${clstrVo.regionNm }" />"><c:out value="${clstrVo.regionNm }" /></nobr></td>
							<td class="alignL"><nobr title="<c:out value="${clstrVo.zoneNm }" />"><c:out value="${clstrVo.zoneNm }" /></nobr></td>
							<%-- <td class="alignL"><nobr title="<c:out value="${clstrVo.netNm }" />"><c:out value="${clstrVo.netNm }" /></nobr></td> 망구분으로 변경--%>
							<td class="alignL"><nobr title="<c:out value="${clstrVo.netClCdNm }" />"><c:out value="${clstrVo.netClCdNm }" /></nobr></td>
							<td class="alignL"><nobr title="<c:out value="${clstrVo.rsrcPoolNm }" />"><c:out value="${clstrVo.rsrcPoolNm }" /></nobr></td>
							<td class="alignL"><nobr>
								<c:if test="${clstrVo.clstrId ne null}">
									<a href="<c:url value="${selectClstrUrl }" />" title="<c:out value="${clstrVo.clstrId }"/>"><c:out value="${clstrVo.clstrId }" /></a>
								</c:if>
							</nobr></td>
							<td class="alignL"><nobr>
								<c:if test="${clstrVo.clstrNm ne null}">
									<a href="<c:url value="${selectClstrUrl }" />" title="<c:out value="${clstrVo.clstrNm }"/>"><c:out value="${clstrVo.clstrNm }" /></a>
								</c:if>
							</nobr></td>
							<td class="alignL"><nobr title="<c:out value="${clstrVo.vrlzSwTyCdNm }" />"><c:out value="${clstrVo.vrlzSwTyCdNm }" /></nobr></td>
							<td class="alignR"><nobr title="<c:out value="${clstrVo.pmCnt }" />"><c:out value="${clstrVo.pmCnt }" /></nobr></td>
							<td class="alignR"><nobr title="<c:out value="${clstrVo.vmCnt }" />"><c:out value="${clstrVo.vmCnt }" /></nobr></td>
							<td class="notellipsis">
								<span title="<fmt:formatNumber value="${clstrVo.avgCpuUseRt}" pattern="0"/>" class="label label-green"><fmt:formatNumber value="${clstrVo.avgCpuUseRt}" pattern="0"/></span>
								<div title="<fmt:formatNumber value="${clstrVo.avgCpuUseRt}" pattern="0"/>" class="progress">
									<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${clstrVo.avgCpuUseRt}" pattern="0"/>%"></div>
								</div>
							</td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${clstrVo.cpuVrlzRt}" pattern="0"/>"><fmt:formatNumber value="${clstrVo.cpuVrlzRt}" pattern="0"/></nobr></td>
							<%-- <td class="alignR"><nobr title=""><c:out value="${clstrVo.totCpuEnt }"/></nobr></td> --%>
							<td class="alignR"><nobr title="<c:out value="${clstrVo.totCpuVcoreQty }"/>"><c:out value="${clstrVo.totCpuVcoreQty }"/></nobr></td>
							<td class="alignR"><nobr title="<c:out value="${clstrVo.totCpuCoreQty }"/>"><c:out value="${clstrVo.totCpuCoreQty }"/></nobr></td>
							<td class="notellipsis">
								<span title="<fmt:formatNumber value="${clstrVo.avgMemUseRt}" pattern="0"/>" class="label label-green"><fmt:formatNumber value="${clstrVo.avgMemUseRt}" pattern="0"/></span>
								<div title="<fmt:formatNumber value="${clstrVo.avgMemUseRt}" pattern="0"/>" class="progress">
									<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${clstrVo.avgMemUseRt}" pattern="0"/>%"></div>
								</div>
							</td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${clstrVo.memVrlzRt}" pattern="0"/>"><fmt:formatNumber value="${clstrVo.memVrlzRt}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${clstrVo.totMemAsgnCapa}" pattern="0"/>"><fmt:formatNumber value="${clstrVo.totMemAsgnCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${clstrVo.totMemCapa}" pattern="0"/>"><fmt:formatNumber value="${clstrVo.totMemCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${clstrVo.totStrgAsgnCapa / 1024 }" pattern="0.0"/>"><fmt:formatNumber value="${clstrVo.totStrgAsgnCapa / 1024 }" pattern="0.0"/></nobr></td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${clstrVo.totNetwkIn }" pattern="0.0"/>"><fmt:formatNumber value="${clstrVo.totNetwkIn }" pattern="0.0"/></nobr></td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${clstrVo.totNetwkOut }" pattern="0.0"/>"><fmt:formatNumber value="${clstrVo.totNetwkOut }" pattern="0.0"/></nobr></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${clstrSearchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize onlyOprAdm="true">
					<button type="button" class="btn btn-sm btn-hover-blue" data-toggle="tooltip" title="생성 요청" data-original-title="생성 요청" onclick="fn_insertClstrCreReq();"><i class="fa fa-plus"></i></button>
					<button type="button" class="btn btn-sm btn-hover-red" data-toggle="tooltip" title="삭제 요청" data-original-title="삭제 요청" onclick="fn_insertClstrDelReq();"><i class="fa fa-minus"></i></button>
				</menu:authorize>
			</div>
		</div>

	</div>

</div>

<script type="text/javascript">

// 검색조건 초기화
function fn_initialize(){
	$('#clstrSearchVo input[type="text"]').val('');
	$('#clstrSearchVo select').val('').attr('selected', 'selected');
	$('#clstrSearchVo input[type="checkbox"][data-name="existsVrlzSwTyCdList"]').prop('checked', 'checked');
}

// 조회
function fn_selectClstrList(){
	$('#clstrSearchVo').attr('target', '_self');
	$('#clstrSearchVo').attr('action', '<c:url var="select" value="selectClstrList.do"/>');
	$('#clstrSearchVo').submit();
}

// 클러스터 생성요청
function fn_insertClstrCreReq(){
	location.href = '<c:url value="insertClstrCreReq.do"><c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach></c:url>';
}

// 클러스터 삭제요청
function fn_insertClstrDelReq(){
	if($('.list-box table input[type="radio"]:checked').length == 0){
		jAlert("선택된 클러스터가 없습니다.");
		return;
	}
	location.href = '<c:url value="insertClstrDelReq.do"><c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach></c:url><c:choose><c:when test="${param eq null or param.isEmpty()}"><c:out value="?"/></c:when><c:otherwise><c:out value="&" escapeXml="false"/></c:otherwise></c:choose>clstrSeq=' + $('.list-box table input[type="radio"]:checked').val();
}

// 페이지 이동
function fn_goPage(page){
	location.href = '<c:url value="selectClstrList.do"/>?paginationInfo.currentPageNo=' + page + '&${listParam}';
}

// 목록의 정보를 Excel로 다운로드 한다.
function fn_selectClstrListXlsDwnl() {
	if("${clstrSearchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}
	$('#clstrSearchVo').attr('target', '_self');
	$('#clstrSearchVo').attr('action', '<c:url value="selectClstrListXlsDwnl.do"/>');
	$('#clstrSearchVo').submit();

}

$("#clstrTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
   		{sWidth : "28px" }, //선택
   		{sWidth : "50px" }, //사용여부
   		{sWidth : "28px" }, //센터
   		{sWidth : "25px" }, //존
   		{sWidth : "60px" }, //망
   		{sWidth : "100px" }, //자원풀*
   		{sWidth : "100px" }, //클러스터ID*
   		{sWidth : "140px" }, //클러스터명*
   		{sWidth : "100px" }, //가상화SW
   		{sWidth : "60px" }, //물리서버수
   		{sWidth : "60px" }, //가상서버수
   		{sWidth : "40px" }, //CPU 사용률
   		{sWidth : "50px" }, //CPU 가상화율
   		{sWidth : "40px" }, //CPU vCore
   		{sWidth : "40px" }, //CPU Core
   		{sWidth : "40px" }, //메모리 사용률
   		{sWidth : "50px" }, //메모리 가상화율
   		{sWidth : "40px" }, //메모리 할당량
   		{sWidth : "40px" }, //메모리 전체량
   		{sWidth : "50px" }, //스토리지
   		{sWidth : "50px" }, //네트워크In
   		{sWidth : "50px" }, //네트워크Out
   	],
	order : [],
});

</script>
