<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 6.
 * @lastmodified 2016. 10. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 6.     신재훈         v1.0             최초생성
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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:url var="selectUrl" value="/cpt/opr/ip/ipBnd/selectNetwkIntfcListP.do"></c:url>
<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100">
	<!-- 검색조건 영역 -->
	<div class="box-search">
		<!-- box-header -->
		<form:form commandName="vmSearchVo" method="get">
			<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
			<form:hidden path="selectNetClCd" value="${vmSearchVo.equalsNetClCd }" />
			<form:hidden path="selectRegionId" value="${vmSearchVo.equalsRegionId }" />
			<div class="box-body">
				<div class="form-group">
					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="equalsRegionId">센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion name="equalsRegionId" id="equalsRegionId" cssClass="form-control input-sm" title="센터" value="${vmSearchVo.equalsRegionId}" whole="true" onchange="selectZoneDy(this, 'equalsZoneId' )" />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="equalsNetClCd">망구분</label>
						</div>
						<div class="cell-body">
							<form:select path="equalsNetClCd" cssClass="form-control input-sm" title="망">
							<c:forEach var="netCd" items="${netList}">
								<c:choose>
									<c:when test="${netCd.cd eq vmSearchVo.equalsNetId}">
										<form:option value="${netCd.cd}" selected="selected"><c:out value="${netCd.cdNm}"></c:out></form:option>
									</c:when>
									<c:otherwise>
										<form:option value="${netCd.cd}"><c:out value="${netCd.cdNm}"></c:out></form:option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							</form:select>
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="equalsStatGrpCd">상태</label>
						</div>
						<div class="cell-body">
							<form:select path="equalsStatGrpCd" title="상태" cssClass="form-control input-sm">
							<c:forEach var="statCd" items="${statCdList }">
								<form:option value="${statCd.cd}" ><c:out value="${statCd.cdNm }"/></form:option>
							</c:forEach>
						</form:select>
						</div>
					</div>
					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="containsVmNm">가상서버명</label>
						</div>
						<div class="cell-body">
							<form:input path="containsVmNm" cssClass="form-control input-sm" value="" title="가상서버명"/>
						</div>
					</div>

					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="containsVmId">가상서버ID</label>
						</div>
						<div class="cell-body">
							<form:input path="containsVmId" cssClass="form-control input-sm" value="" title="가상서버ID"/>
						</div>
					</div>

					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="containsVmCompId">가상서버구성ID</label>
						</div>
						<div class="cell-body">
							<form:input path="containsVmCompId" cssClass="form-control input-sm" value="" title="가상서버구성ID"/>
						</div>
					</div>

					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="containsHstNm">호스트명</label>
						</div>
						<div class="cell-body">
							<form:input path="containsHstNm" cssClass="form-control input-sm" value="" title="호스트명"/>
						</div>
					</div>

					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="containsRprsntIpAddr">IP주소</label>
						</div>
						<div class="cell-body">
							<form:input path="containsRprsntIpAddr" cssClass="form-control onlyIp" value="" maxlength="15" title="IP주소"/>
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="equalsOsTyCd">OS유형</label>
						</div>
						<div class="cell-body">
							<form:select path="equalsOsTyCd" cssClass="form-control input-sm" title="OS유형">
								<c:forEach var="osTyCd" items="${osTyCdList }">
									<form:option value="${osTyCd.cd}">
										<c:out value="${osTyCd.cdNm }" />
									</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>

					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="containsInstitutionNm">부처명</label>
						</div>
						<div class="cell-body">
							<form:input path="containsInstitutionNm" cssClass="form-control input-sm" value="" title="부처명"/>
						</div>
					</div>

					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="existsContainsJobNm">업무명</label>
						</div>
						<div class="cell-body">
							<form:input path="existsContainsJobNm" cssClass="form-control input-sm" value="" title="업무명" />
						</div>
					</div>

					<!-- 검색조건 : checkbox -->
					<div class="form-cell form-cell-100 col-lay-100">
						<div class="cell-title">
							<label for="vrlzSwTyCd">가상화SW</label>
						</div>
						<div class="cell-body">
							<div class="input-group input-group-check">
							<c:choose>
								<c:when test="${vmSearchVo eq null or vmSearchVo.existsVrlzSwTyCdList eq null }">
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
					<!--  검색조건 완료 -->
					<div class="form-cell form-cell-100 alignR pad-top-5">
						<button class="btn btn-red btn-sm" type="button" onclick="fn_selectVmList()" title="조회">조회</button>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<!-- 가상서버 테이블 영역 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">
				검색결과<small> ${vmSearchVo.paginationInfo.currentPageNo }
					/ ${vmSearchVo.paginationInfo.totalPageCount }, 총
					${vmSearchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="vmSearchVo" value="${vmSearchVo }" />
				</div>
			</div>
		</div>
		<!-- /box-header -->
		<!-- box-body -->
		<form:form commandName="vmVo" name="vmListFrm" id="vmListFrm"  method="get">
			<div class="box-body no-padding" style="overflow-x:auto;">
<%-- 			<input type="hidden" name="ipList" value="${ipList }" /> --%>
				<table class="table table-vertical table-hover table-layout-fixed" id="vmListTable">
				<caption>가상서버목록(상태, 부처, 업무, 센터, 존, 망구분, 자원풀, 가상서버명, 가상서버ID, 가상서버구성ID, 호스트명, IP주소, OS유형, 가상화SW, 생성일시)</caption>
					<thead>
						<tr>
							<th><nobr></nobr></th>
							<th><nobr>상태</nobr></th>
							<th><nobr>부처</nobr></th>
							<th><nobr>업무</nobr></th>
							<th><nobr>센터</nobr></th>
							<th><nobr>존</nobr></th>
							<th><nobr>망구분</nobr></th>
							<th><nobr>자원풀</nobr></th>
							<th><nobr>가상서버명</nobr></th>
							<th><nobr>가상서버구성ID</nobr></th>
							<th><nobr>가상서버ID</nobr></th>
							<th><nobr>호스트명</nobr></th>
							<th><nobr>IP주소</nobr></th>
							<th><nobr>OS유형</nobr></th>
							<th><nobr>가상화SW</nobr></th>
							<th><nobr>생성일시</nobr></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vmVo" items="${vmVoList }" varStatus="i">
							<tr>
								<td><nobr>
									<form:radiobutton path="vmSeq" id="vmRadioBtn" value="${vmVo.vmSeq }" onchange="onchangeRow()"/>
								</nobr></td>
								<td class="alignL"><nobr>
									<c:if test="${null ne vmVo.statGrpCd}">
										<div class="server-info server
											<c:choose>
												<c:when test='${"01" eq vmVo.statGrpCd}'><c:out value="server-down"/></c:when>
												<c:when test='${"02" eq vmVo.statGrpCd}'><c:out value="server-up"/></c:when>
												<c:when test='${"03" eq vmVo.statGrpCd}'><c:out value="server-inprogress"/></c:when>
												<c:when test='${"04" eq vmVo.statGrpCd}'><c:out value="server-exception"/></c:when>
									   			<c:otherwise></c:otherwise>
											</c:choose>
										">
											<div class="server-info-body alignL">
												<div class="server-info-box alignL">
													<span class="label"></span><h4 class="stat"><c:out value="${vmVo.statGrpCdNm }" /></h4>
												</div>
											</div>
										</div>
									</c:if>
								</nobr></td>
								<td class="alignL"><nobr>
									<c:out value="${vmVo.institutionNm }" />
								</nobr></td>
								<td class="alignL">
									<c:forEach var="vmJobVo" items="${vmVo.vmJobVoList }" varStatus="i">
									<nobr>
										<c:out value="${vmJobVo.jobNm }" />
											<c:if test="${fn:length(vmVo.vmJobVoList) > (i.index + 1) }">
										<c:out value="," />
										</c:if>
									</nobr>
									</c:forEach>
								</td>
								<td class="alignL"><nobr><c:out value="${vmVo.regionNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmVo.zoneNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmVo.netNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmVo.rsrcPoolNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmVo.vmNm }" /></nobr></td>
								<td><nobr><c:out value="${vmVo.vmCompId }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmVo.vmId }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmVo.hstNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmVo.rprsntIpAddr }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmVo.osTyCdNm }" /></nobr></td>
								<td class="alignL"><nobr><c:out value="${vmVo.vrlzSwTyCdNm }" /></nobr></td>
								<td><nobr><fmt:formatDate value="${vmVo.regDttm }" pattern="yyyy-MM-dd HH:mm" /></nobr>
								<form:hidden path="testId" id="testId" value="${vmVo.regionNm }"/>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- 			<div class="box-footer clearfix"> -->
				<div class="box-footer edit-btn-group">
					<ul class="pagination">
						<ui:pagination paginationInfo="${vmSearchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
					</ul>
				</div>
			</div>
		</form:form>
		<!-- /box-body -->
	</div>
	<!-- NIC 테이블 영역 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">네트워크 인터페이스</h3>
		</div>
		<!-- /box-header -->
		<!-- box-body -->
		<div class="box-body no-padding" id="netwkInfoDiv"></div>
	</div>
</div>
<div class="col-box-100">
	<div class="button">
		<button type="button" class="btn btn-dark" onclick="fn_selectVmNIC()" title="선택">선택</button>
		<button type="button" class="btn close-window" onclick="fn_close()" title="닫기">닫기</button>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	// 센터, 망 수정불가 상태로 변경
	$("#equalsRegionId").attr('disabled', true);
	$("#equalsNetClCd").attr('disabled', true);
});

function loadSuccessHandler(data){
	$('#netwkInfoDiv').html(data);
}

//페이지 이동
function fn_goPage(page){
	location.href = "selectVmListP.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

//검색조건 초기화
function fn_initialize(){
	$('#vmSearchVo input[type="text"]').val('');
	$('#vmSearchVo select').val('').attr('selected', 'selected');
	$('#vmSearchVo input[type="checkbox"][name="existsVrlzSwTyCdList"]').prop('checked', 'checked');
}

// 조회
function fn_selectVmList(){
	$('#vmSearchVo').attr('target', '_self');
	$('#vmSearchVo').attr('action', '<c:url var="select" value="selectVmListP.do"/>');
	$('#vmSearchVo').submit();
}

// 가상서버 선택 와 네트워크인터페이스
function fn_selectVmNIC(){
	if($('input:radio[id="vmRadioBtn"]:checked').length == 0){
		jAlert("선택된 가상서버가 없습니다.");
		return;
	}

	if($('input:radio[name="netwkIntfcSeq"]:checked').length == 0){
		jAlert("선택된 네트워크 인터페이스가 없습니다.");
		return;
	}

	jConfirm('선택한 가상서버의 NIC에 수동할당 하시겠습니까?', function() {
		var vmSequence = $('input:radio[id="vmRadioBtn"]:checked').val();
		var netwkId = $('input:radio[name="netwkIntfcSeq"]:checked').val();

		window.opener.getSelected(vmSequence, netwkId);
		window.close();
	});
}

function fn_close(){
	window.close();
}

$("#vmListFrm input:radio[id='vmRadioBtn']").click(function(event) {
	event.stopPropagation();
});

$("#vmListFrm input:radio[id='vmRadioBtn']").parent().parent().parent().click(function() {
	var $target = $(this).find("input[id='vmRadioBtn']");
	if( $target.attr("type") == "radio" ) {
		$target.prop("checked", true);
		onchangeRow();
	} else {
		var checked = $target.prop("checked");
		$target.prop("checked", !checked);
	}
});

$("#vmListTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	               {sWidth : "35px" },
	               {sWidth : "99px" },
	               {sWidth : "62px" },
	               {sWidth : "51px" },
	               {sWidth : "52px" },
	               {sWidth : "42px" },
	               {sWidth : "54px" },
	               {sWidth : "63px" },
	               {sWidth : "120px" },
	               {sWidth : "88px" },
	               {sWidth : "109px" },
	               {sWidth : "89px" },
	               {sWidth : "95px" },
	               {sWidth : "55px" },
	               {sWidth : "97px" },
	               {sWidth : "110px" }

	],
	order : [ [ 0, "desc" ] ]
});

function onchangeRow(){
	var vmSeq = $('input:radio[id="vmRadioBtn"]:checked').val();
	var url = '${selectUrl}';
	if( vmSeq != null ){
		$.get(url,{'vmSeq':vmSeq},loadSuccessHandler,'html');
	}
}

$("#nicFrm input:radio[name='netwkIntfcSeq']").parent().parent().click(function() {
	var $target = $(this).find("input[name='netwkIntfcSeq']");
	if( $target.attr("type") == "radio" ) {
		$target.prop("checked", true);
	} else {
		var checked = $target.prop("checked");
		$target.prop("checked", !checked);
	}
});


</script>