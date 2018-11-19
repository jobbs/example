<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     이화영         v1.0             최초생성
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

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchConfrmYn" title="확인여부">확인여부</label>
					</div>
					<div class="cell-body">
						<form:select path="searchConfrmYn" name="equalsUseYn" title="확인여부" cssClass="form-control input-sm">
							<form:option value="">전체</form:option>
							<form:option value="Y">확인</form:option>
							<form:option value="N">미확인</form:option>
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
							onchange="selectZoneByNetClCd('searchRegionId', 'searchZoneId', 'searchNetClCd', 'searchRsrcPoolId' )" />
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
							onchange="selectPoolByNetClCd('searchRegionId', 'searchZoneId', 'searchNetClCd', 'searchRsrcPoolId', {searchPoolTypeCd : '01','searchCtlTrgtYn' : 'Y'})" />
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchNetClCd" title="망구분">망구분</label>
					</div>
					<div class="cell-body">
						<nform:selectCode
							parentCd="NETCD"
          					parentGrpCd="067"
							name="searchNetClCd"
							id="searchNetClCd"
							title="망"
							cssClass="form-control input-sm"
							whole="true"
							zoneId="${searchVo.searchZoneId}"
							value="${searchVo.searchNetClCd}"
							onchange="selectPoolByNetClCd('searchRegionId', 'searchZoneId','searchNetClCd', 'searchRsrcPoolId', {searchPoolTypeCd : '01','searchCtlTrgtYn' : 'Y'})"  />
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
							title="자원풀"
							cssClass="form-control input-sm"
							whole="true"
							poolTypeCd="01"
							swTypeCd="COM"
							regionId="${searchVo.searchRegionId }"
							zoneId="${searchVo.searchZoneId}"
							netClCd="${searchVo.searchNetClCd }"
							value="${searchVo.searchRsrcPoolId}"
							/>
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

				<!-- 검색조건 : checkbox -->
				<div class="form-cell form-cell-100 col-lay-100">
					<div class="cell-title">
						<label for="vrlzSwTyCd" title="가상화SW">가상화SW</label>
					</div>
					<div class="cell-body">
						<div class="input-group input-group-check">
							<c:choose>
								<c:when test="${searchVo eq null or searchVo.searchVrlzSwTyCdList eq null }">
									<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
										<form:checkbox path="searchVrlzSwTyCdList[${i.index}]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}" checked="checked"/>
										<label for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
										<form:checkbox path="searchVrlzSwTyCdList[${i.index}]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}"/>
										<label for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
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
		    <button type="button" class="btn" onclick="fn_initialize();">초기화</button>
		  </div>
		  <div class="pull-right">
		  	<c:url var="selectVmListUrl" value="selectVmList.do">
			</c:url>
		    <button type="button" class="btn btn-red pull-right" onclick="fn_selectDistrbList();">조회</button>
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
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_selectPackgAlrmListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>
		<!-- box-body -->
		<form:form commandName="packgAlrmVo" method="post">
		<div class="box-body no-padding list-body">
			<table id="packgAlrmTable" class="table table-hover table-vertical table-layout-fixed">
			<caption>패치알림관리 목록</caption>
				<thead>
					<tr>
						<th><nobr><input type="checkbox" id="selectAll" title="전체선택"/></nobr></th>
						<th><nobr>No.</nobr></th>
						<th><nobr>확인여부</nobr></th>
						<th><nobr>알림명</nobr></th>
						<th><nobr>알림일자</nobr></th>
						<c:if test="${searchVo.sysAdm}">
							<th><nobr>담당자명</nobr></th>
						</c:if>
						<th><nobr>가상서버명</nobr></th>
						<th><nobr>대상 패키지명</nobr></th>
						<th><nobr>대상버전</nobr></th>
						<th><nobr>패치버전</nobr></th>
						<th><nobr>부처</nobr></th>
						<th><nobr>업무</nobr></th>
						<th><nobr>센터</nobr></th>
						<th><nobr>존</nobr></th>
						<th><nobr>망구분</nobr></th>
						<th><nobr>가상화SW</nobr></th>
						<th><nobr>자원풀</nobr></th>
						<th><nobr>가상서버구성ID</nobr></th>
						<th><nobr>가상서버ID</nobr></th>
						<th><nobr>호스트명</nobr></th>
						<th><nobr>IP주소</nobr></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="packgAlrmVo" items="${packgAlrmVoList }" varStatus="i">
						<c:url var="detailUrl" value="selectPackgAlrm.do">
							<c:param name="patchAlrmSeq" value="${packgAlrmVo.patchAlrmSeq }" />
							<c:param name="vmSeq" value="${packgAlrmVo.vmSeq }" />
							<c:param name="chargerId" value="${packgAlrmVo.chargerId }" />
							<c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach>
						</c:url>
						<tr>
							<td>
								<input type="checkbox" name="packgAlrmList" class="checkAlrm" value="${packgAlrmVo.vmSeq}" title="항목선택"/>
								<input type="checkbox" name="packgAlrmList1" class="checkAlrmSeq" value="${packgAlrmVo.patchAlrmSeq}" title="항목선택" style="display: none;"/>
								<input type="checkbox" name="packgAlrmList2" class="checkChargerId" value="${packgAlrmVo.chargerId}" title="항목선택" style="display: none;"/>
							</td>
							<td><nobr><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></nobr></td>
							<td><nobr>
									<c:choose>
										<c:when test = "${ packgAlrmVo.confrmYn eq 'Y' }">
											<span class="status status-green">확인</span>
										</c:when>
										<c:otherwise>
											<span class="status status-gray">미확인</span>
										</c:otherwise>
									</c:choose>
							</nobr></td>
							<td class="alignL"><nobr><a href="<c:url value="${detailUrl }" />" title="<c:out value="${packgAlrmVo.patchAlrmNm }"/>"><c:out value="${packgAlrmVo.patchAlrmNm }" /></a></nobr></td>
							<td><nobr><c:out value="${packgAlrmVo.patchAlrmDttm }" /></nobr></td>
							<c:if test="${searchVo.sysAdm}">
								<td><nobr><c:out value="${packgAlrmVo.chargerNm }" /></nobr></td>
							</c:if>
							<td class="alignL"><nobr><c:out value="${packgAlrmVo.vmNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${packgAlrmVo.packgNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${packgAlrmVo.ver }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${packgAlrmVo.maxVer }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${packgAlrmVo.institutionNm }" /></nobr></td>
							<td class="alignL">
								<c:set var="jobNmList" value="${fn:split(packgAlrmVo.jobsNm, ',')}"/>
								<c:forEach var="jobNm" items="${jobNmList}" varStatus="i">
									<nobr><c:out value="${jobNm }" /><c:if test="${fn:length(jobNmList) > (i.index + 1) }"><c:out value=","/></c:if></nobr>
								</c:forEach>
							</td>
							<td><nobr><c:out value="${packgAlrmVo.regionNm }" /></nobr></td>
							<td><nobr><c:out value="${packgAlrmVo.zoneNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${packgAlrmVo.netNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${packgAlrmVo.vrlzSwTyCdNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${packgAlrmVo.rsrcPoolNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${packgAlrmVo.vmCompId }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${packgAlrmVo.vmId }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${packgAlrmVo.hstNm }" /></nobr></td>
							<td><nobr><c:out value="${packgAlrmVo.rprsntIpAddr }" /></nobr></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</form:form>
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize>
					<button type="button" class="btn btn-hover-green" data-toggle="tooltip"	data-original-title="확인" onclick="fn_updatePackgAlrmListSync()">
						<i class="fa fa-play-circle"></i>
					</button>
				</menu:authorize>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

$(document).ready(function(){
	$('#selectAll').click(function(){
		$('.checkAlrm').prop('checked', $(this).is(":checked"));
	});

	$('.checkAlrm').click(function(){
		if($('.checkAlrm:checked').length == $('.checkAlrm').length){
			$('#selectAll').prop('checked', true);
		}
		else {
			$('#selectAll').prop('checked', false);
		}
	});
});

//검색조건 초기화
function fn_initialize(){
	$('#searchVo input[type="text"]').val('');
	$('#searchVo select').val('').attr('selected', 'selected');
	$('#searchVo input[type="checkbox"][name="searchVrlzSwTyCdList"]').prop('checked', 'checked');
}

//조회
function fn_selectDistrbList(){
	$('#searchVo').attr('target', '_self');
	$('#searchVo').attr('action', '<c:url var="select" value="selectPackgAlrmList.do"/>');
	$('#searchVo').submit();
}

//페이지 이동
function fn_goPage(page){
	location.href = "selectPackgAlrmList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

//목록의 정보를 Excel로 다운로드 한다.
function fn_selectPackgAlrmListXlsDwnl() {
	if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}
	$('#searchVo').attr('target', '_self');
	$('#searchVo').attr('action', '<c:url value="selectPackgAlrmListXlsDwnl.do"/>');
	$('#searchVo').submit();
}


function fn_updatePackgAlrmListSync() {
	var checked = 0;
	$("input[class='checkAlrm']").each(function() {
		if ($(this).prop("checked")) {
			checked++;
		}
	});

	if (checked == 0) {
		jAlert("확인할 패치 알림을 선택하시기 바랍니다.");
		return;
	}

	jConfirm("선택한 패치알림을 확인하시겠습니까?", function() {
		var options = {
				type : 'post',
				dataType : 'json',
				success : fn_successHandler,
				beforeSend : function() {

				},
				error : function(xhr, textStatus, errorThrown) {
					jAlert('패치알림 확인 중 오류 발생');
				}
			};

			$('#packgAlrmVo').attr("action", "updatePackgAlrm.do");
			$('#packgAlrmVo').ajaxSubmit(options);
	});
}

//결과 메시지
function fn_successHandler(result) {
	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo(result.messageList, function(){
			location.href = '<c:url value="selectPackgAlrmList.do"/>';
		});
	}
	else{
		alert_message(result.messageList);
	}
}

$("input:checkbox[class='checkAlrm']").click(function() {
	$(this).siblings().prop( "checked", $(this).prop("checked") );
});

$("#packgAlrmTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	            {sWidth : "30px" },
	            {sWidth : "30px" },//No
	            {sWidth : "60px" },//확인여부
	            {sWidth : "180px" },//알림명
	            {sWidth : "85px" },//알림일자
	            <c:if test="${searchVo.sysAdm}">
	            	{sWidth : "85px" },//담당자명
	            </c:if>
	            {sWidth : "210px" },//가상서버명
	            {sWidth : "150px" },//대상패키지명
	            {sWidth : "100px" },//대상버전
	            {sWidth : "100px" },//패치버전
	            {sWidth : "80px" },//부처
	            {sWidth : "100px" },//업무
	            {sWidth : "40px" },//센터
	            {sWidth : "40px" },//존
	            {sWidth : "60px" },//망구분
	            {sWidth : "60px" },//가상화SW
	            {sWidth : "100px" },//자원풀
	            {sWidth : "120px" },//가상서버ID
	            {sWidth : "120px" },//가상서버구성ID
	            {sWidth : "120px" },//호스트명
	            {sWidth : "120px" }//IP주소
	 ],
	order : [[0, "desc"]]
} );
</script>