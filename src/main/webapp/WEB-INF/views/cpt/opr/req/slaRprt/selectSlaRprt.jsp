<!--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 04.
 * @lastmodified 2016. 10. 04.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 04.     이화영         v1.0             최초생성
 *
-->
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
	<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
	<form:hidden path="rsrcReqTyCd"/>
	<div class="box box-search">
		<div class="box-header">
			<h3 class="box-title">검색조건</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
					<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
				</button>
			</div>
		</div>

		<div class="box-body collapse in search-collapse">
			<div class="form-group">

				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title"><label for="searchRegion">센터</label></div>
					<div class="cell-body">
						<div class="input-group">
							<nform:selectRegion
					        name="searchRegion"
					        id="searchRegion"
					        cssClass="form-control input-sm pull-right"
					        whole="true"
					        value="${searchVo.searchRegion}"
					        title="센터"/>
						</div>
					</div>
				</div>

				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title"><label for="institutionNm">부처명</label></div>
					<div class="cell-body">
						<div class="input-group">
							<form:input path="institutionNm" title="부처명" cssClass="form-control input-sm pull-right" readonly="true" />
							<form:hidden path="institutionId"/>
							<div class="input-group-btn"><button type="button" class="btn btn-sm" onclick="fn_selectInsttList()"><i class="fa fa-search"></i></button></div>
						</div>
					</div>
				</div>

				<div class="form-cell form-cell-50 col-lay-25">
			        <div class="cell-title">
			            <label title="구분" for="searchrSrcReqClCd">구분</label>
			        </div>
			        <div class="cell-body">
			            <nform:selectCode
			                parentCd="151"
			                parentGrpCd="098"
			                name="searchrSrcReqClCd"
			                id="searchrSrcReqClCd"
			                whole="true"
			                cssClass="form-control input-sm"
			                value="${searchVo.searchrSrcReqClCd}"
			                onchange="selectRsrcReqTyCd(this, 'searchrSrcReqTyCd')" />
				    </div>
				</div>

				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title"><label for="searchrSrcReqTyCd">요청유형</label></div>
					<div class="cell-body">
						<div class="input-group">
							<nform:selectCode
						       parentCd="107"
						       parentGrpCd="008"
						       name="searchrSrcReqTyCd"
						       id="searchrSrcReqTyCd"
						       whole="true"
						       value="${searchVo.searchrSrcReqTyCd}"
						       cssClass="form-control input-sm"
						       title="요청유형"/>
						</div>
					</div>
				</div>

				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title"><label for="searchTime">시간단위</label></div>
					<div class="cell-body">
						<div class="input-group">
							<nform:selectCode
						       parentCd="112"
						       parentGrpCd="013"
						       name="searchTime"
						       id="searchTime"
						       value="${searchVo.searchTime}"
						       whole="false"
						       cssClass="form-control input-sm"
						       title="시간단위"/>
						</div>
					</div>
				</div>

	          <div class="form-cell form-cell-100 col-lay-50">
	            	<div class="cell-title"><label>요청일자</label></div>
		            <div class="cell-body">
						<div class="input-group period period-start">
		              		<form:input path="searchStartRegDt" cssClass="form-control input-sm pull-right datepicker" title="요청 시작일자" onchange="initDate(this, 'searchEndRegDt', 'S')" />
		              	</div>
		              	<div class="input-group period period-end">
							<form:input path="searchEndRegDt" cssClass="form-control input-sm pull-right datepicker" title="요청 종료일자" onchange="initDate(this, 'searchStartRegDt', 'E')" />
		              	</div>
		            </div>
	          	</div>
			</div>
		</div>
		<div class="box-footer collapse in search-collapse">
			<div class="pull-left">
		        <button type="button" class="btn" onclick="fn_searchAreaReset();">초기화</button>
	      	</div>
			<div class="pull-right">
				<button type="button" class="btn btn-red" onclick="fn_searchForm('')">조회</button>
			</div>
		</div>
	</div>
	</form:form>
</div>

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">SLA리포트</h3>
		</div><!-- /box-header -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical">
				<caption>SLA리포트</caption>
				<colgroup>
				  <col class="col10">
                  <col class="col9">
                  <col class="col9">
                  <col class="col6">
                  <col class="col6">
                  <col class="col6">
                  <col class="col6">
                  <col class="col6">
                  <col class="col6">
                  <col class="col6">
                  <col class="col6">
                  <col class="col6">
                  <col class="col6">
                  <col class="col6">
                  <col class="col6">
				</colgroup>
				<thead>
				<tr>
					<th>구분</th>
					<th>처리율<br>(평균시간)</th>
					<th>계</th>
					<th>가상서버<br>생성</th>
					<th>가상서버<br>삭제</th>
					<th>가상서버<br>스펙변경</th>
					<th>SLB설정</th>
					<th>물리서버<br>추가</th>
					<th>물리서버<br>삭제</th>
					<th>클러스터<br>추가</th>
					<th>클러스터<br>삭제</th>
					<th>가상서버<br>스토리지추가</th>
					<th>서비스영역<br>생성</th>
					<th>서비스영역<br>변경</th>
					<th>서비스영역<br>삭제</th>
				</tr>
				</thead>
				<tbody>
				<c:choose>
					<c:when test="${slaRprtVo eq null or empty slaRprtVo }">
						<tr>
							<td colspan="11">검색된 데이터가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:url var="detailUrl" value="selectSlaRprt.do">
							<c:forEach var="curParam" items="${param }">
								<c:if test="${curParam.key ne 'rsrcReqTyCd' and curParam.key ne 'paginationInfo.currentPageNo'}">
									<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
								</c:if>
							</c:forEach>
						</c:url>
						<tr>
							<td>처리건수(처리/요청)</td>
							<c:choose>
								<c:when test="${slaRprtVo.avgCnt eq '0'}">
									<td>0%</td>
								</c:when>
								<c:otherwise>
									<td><fmt:formatNumber value="${(slaRprtVo.totalCnt/slaRprtVo.avgCnt)*100}" maxFractionDigits="2" />%</td>
								</c:otherwise>
							</c:choose>
							<td><c:out value="${slaRprtVo.totalCnt}"/>/<c:out value="${slaRprtVo.avgCnt}"/></td>
							<td><a href="javascript:void(0)" onclick="fn_searchForm('01')" title="가상서버 생성"><c:out value="${slaRprtVo.vmCre1}"/>/<c:out value="${slaRprtVo.vmCre2}"/></a></td>
							<td><a href="javascript:void(0)" onclick="fn_searchForm('02')" title="가상서버 삭제"><c:out value="${slaRprtVo.vmDle1}"/>/<c:out value="${slaRprtVo.vmDle2}"/></a></td>
							<td><a href="javascript:void(0)" onclick="fn_searchForm('03')" title="가상서버 스펙변경"><c:out value="${slaRprtVo.spec1}"/>/<c:out value="${slaRprtVo.spec2}"/></a></td>
							<td><a href="javascript:void(0)" onclick="fn_searchForm('04')" title="SLB 설정"><c:out value="${slaRprtVo.slb1}"/>/<c:out value="${slaRprtVo.slb2}"/></a></td>
							<td><a href="javascript:void(0)" onclick="fn_searchForm('05')" title="물리서버 추가"><c:out value="${slaRprtVo.pmCre1}"/>/<c:out value="${slaRprtVo.pmCre2}"/></a></td>
							<td><a href="javascript:void(0)" onclick="fn_searchForm('06')" title="물리서버 삭제"><c:out value="${slaRprtVo.pmDle1}"/>/<c:out value="${slaRprtVo.pmDle2}"/></a></td>
							<td><a href="javascript:void(0)" onclick="fn_searchForm('07')" title="클러스터 추가"><c:out value="${slaRprtVo.clstrCre1}"/>/<c:out value="${slaRprtVo.clstrCre2}"/></a></td>
							<td><a href="javascript:void(0)" onclick="fn_searchForm('08')" title="클러스터 삭제"><c:out value="${slaRprtVo.clstrDel1}"/>/<c:out value="${slaRprtVo.clstrDel2}"/></a></td>
							<td><a href="javascript:void(0)" onclick="fn_searchForm('09')" title="가상서버스토리지추가"><c:out value="${slaRprtVo.vmStrCre1}"/>/<c:out value="${slaRprtVo.vmStrCre2}"/></a></td>
							<td><a href="javascript:void(0)" onclick="fn_searchForm('11')" title="서비스영역추가"><c:out value="${slaRprtVo.servcAreaCre1}"/>/<c:out value="${slaRprtVo.servcAreaCre2}"/></a></td>
							<td><a href="javascript:void(0)" onclick="fn_searchForm('12')" title="서비스영역변경"><c:out value="${slaRprtVo.servcAreaCng1}"/>/<c:out value="${slaRprtVo.servcAreaCng2}"/></a></td>
							<td><a href="javascript:void(0)" onclick="fn_searchForm('13')" title="서비스영역삭제"><c:out value="${slaRprtVo.servcAreaDel1}"/>/<c:out value="${slaRprtVo.servcAreaDel2}"/></a></td>
						</tr>
						<tr>
							<c:choose>
								<c:when test="${searchVo.searchTime eq '03' }">
									<td>평균처리시간(분)</td>
								</c:when>
								<c:when test="${searchVo.searchTime eq '02' }">
									<td>평균처리시간(시)</td>
								</c:when>
								<c:otherwise>
									<td>평균처리시간(일)</td>
								</c:otherwise>
							</c:choose>
							<td><fmt:formatNumber value="${slaRprtVo.avg}" pattern="#.#"></fmt:formatNumber>
							<td><fmt:formatNumber value="${slaRprtVo.total}" pattern="#.#"></fmt:formatNumber>
							<td><fmt:formatNumber value="${slaRprtVo.vmCreTime}" pattern="#.#"></fmt:formatNumber>
							<td><fmt:formatNumber value="${slaRprtVo.vmDleTime}" pattern="#.#"></fmt:formatNumber>
							<td><fmt:formatNumber value="${slaRprtVo.specTime}" pattern="#.#"></fmt:formatNumber>
							<td><fmt:formatNumber value="${slaRprtVo.slbTime}" pattern="#.#"></fmt:formatNumber>
							<td><fmt:formatNumber value="${slaRprtVo.pmCreTime}" pattern="#.#"></fmt:formatNumber>
							<td><fmt:formatNumber value="${slaRprtVo.pmDleTime}" pattern="#.#"></fmt:formatNumber>
							<td><fmt:formatNumber value="${slaRprtVo.clstrCreTime}" pattern="#.#"></fmt:formatNumber>
							<td><fmt:formatNumber value="${slaRprtVo.clstrDelTime}" pattern="#.#"></fmt:formatNumber>
							<td><fmt:formatNumber value="${slaRprtVo.vmStrCreTime}" pattern="#.#"></fmt:formatNumber>
							<td><fmt:formatNumber value="${slaRprtVo.servcAreaCreTime}" pattern="#.#"></fmt:formatNumber>
							<td><fmt:formatNumber value="${slaRprtVo.servcAreaCngTime}" pattern="#.#"></fmt:formatNumber>
							<td><fmt:formatNumber value="${slaRprtVo.servcAreaDelTime}" pattern="#.#"></fmt:formatNumber>
						</tr>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->
	</div>

	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">검색결과<small>
				${rsrcReqMngSearchVo.paginationInfo.currentPageNo } /
				${rsrcReqMngSearchVo.paginationInfo.totalPageCount },
				총 ${rsrcReqMngSearchVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
	     			<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/>
	     			<div class="input-group-cell pad-right">
							<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_goExcelDownload();"><i class="fa fa-download"></i></button>
					</div>
				</div>
	  		</div><!-- /box-header -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical table-layout-fixed"  id="rsrcReqTable">
		        <thead>
		          <tr>
		            <th>No.</th>
		            <th>구분</th>
		            <th>상태</th>
		            <th>제목</th>
		            <th>티켓번호</th>
		            <th>요청번호</th>
		            <th>요청유형</th>
		            <th>요청기관</th>
		            <th>요청자</th>
		            <th>요청일시</th>
		            <th>실행자</th>
		            <th>완료일시</th>
		          </tr>
		        </thead>
				<tbody>
					<c:forEach var="vo" items="${list }" varStatus="i">
						<tr>
							<td class="alignC"><c:out value="${(rsrcReqMngSearchVo.paginationInfo.totalRecordCount-rsrcReqMngSearchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
							<td class="alignC"><c:out value="${vo.rsrcReqClNm}" /></td>
				            <td class="alignC"><span class="status <c:choose>
		                								<c:when test="${'01' eq vo.rsrcReqPrcssStatCd}"><c:out value="status-blue"/></c:when>
		                								<c:when test="${'02' eq vo.rsrcReqPrcssStatCd}"><c:out value="status-yellow"/></c:when>
		                								<c:when test="${'03' eq vo.rsrcReqPrcssStatCd}"><c:out value="status-green"/></c:when>
		                								<c:when test="${'04' eq vo.rsrcReqPrcssStatCd}"><c:out value="status-aqua"/></c:when>
		                								<c:when test="${'05' eq vo.rsrcReqPrcssStatCd}"><c:out value="status-red"/></c:when>
		                								<c:when test="${'06' eq vo.rsrcReqPrcssStatCd}"><c:out value="status-gray"/></c:when>
														<c:otherwise><c:out value="status-gray"/></c:otherwise>
		                							</c:choose>
						                			status-red "><c:out value="${vo.rsrcReqPrcssStatNm}"/>
						                		</span></td>
							<td class="alignL"><c:out value="${cf:ellipsis(vo.sbjct, 60) }" /></td>
							<td class="alignL"><c:out value="${vo.ticktNo}" /></td>
							<td class="alignL"><c:out value="${vo.rsrcReqNo}" /></td>
							<td class="alignC"><c:out value="${vo.rsrcReqTyNm}" /></td>
							<td class="alignL"><c:out value="${vo.reqInstitutionNm}" /></td>
							<td class="alignC"><c:out value="${vo.rsrcReqUsrNm}" /></td>
							<td class="alignC"><c:out value="${vo.rsrcReqDttm}" /></td>
							<td class="alignC"><c:out value="${vo.exeUserNm}" /></td>
							<td class="alignC"><c:out value="${vo.comptDttm}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${rsrcReqMngSearchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
		</div>
		<!-- /box-footer -->
	</div>
</div>
</div>

<script type="text/javascript">

$(document).ready(function(){

	$(document).ready(function() {
	    $("#searchrSrcReqClCd").change();
	});
});

function goPage(page){
	location.href = "selectSlaRprt.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

function goToUrl(url) {
	location.href = url;
}

function fn_searchForm(cd) {
	$("#rsrcReqTyCd").val(cd);
	$("#searchVo").attr("action", "selectSlaRprt.do");
	$("#searchVo").submit();
}

function fn_searchAreaReset() {
	$('#searchVo input[type="text"]').val('');
	$("#searchVo #institutionId").val('');
	$("#searchVo #searchRegion").val("").attr("selected","selected");
	$("#searchVo #searchrSrcReqTyCd").val("").attr("selected","selected");
	$("#searchVo #searchTime").val("03").attr("selected","selected");
}

//목록의 정보를 Excel로 다운로드 한다.
function fn_goExcelDownload() {
	if("${rsrcReqMngSearchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}
	$('#searchVo').attr('target', '_self');
	$('#searchVo').attr('action', '<c:url value="selectSLAListXlsDwnl.do"/>');
	$('#searchVo').submit();
}

//부처선택 호출 (팝업)
function fn_selectInsttList(){
	var url = contextPath+'/cmn/component/instt/selectInsttListP.do';
	var params = {"searchType" : "S"};
	var args = {key:"SelectInstt", width:740,height:820};
	windowOpen(url, params, args);
}

$(document).bind('selectInstitution',setInstitution);
function setInstitution(evt) {
	var val = evt.datas;
	$('#searchVo input[name="institutionNm"]').val(val.institutionNm);
	$('#searchVo input[name="institutionId"]').val(val.institutionId);
}


//요청유형을 조회한다.
function selectRsrcReqTyCd(obj, target) {

    var url = "<c:url value='/cpt/opr/req/slaRprt/selectRsrcReqTyCdList.do'/>";
    var val = $(obj).val();

    var searchParams = { "searchrSrcReqClCd" : val };
    var targetVal = $('#searchrSrcReqTyCd').val();

    $.get(url, searchParams, function(result) {
        if( result.success) {
            var datas = result.data;
            $("#" + target + " > option").remove();
            if( datas != null ) {
                //create Option
                for(var i = 0; i < datas.length; i++ ) {
                	if(targetVal == datas[i].cd ) {
                    	$("#" + target).append("<option value='" + datas[i].cd +  "' selected='selected'>" + datas[i].cdNm + "</option>");
                	}else {
                		$("#" + target).append("<option value='" + datas[i].cd + "'>" + datas[i].cdNm + "</option>");
                	}
                }
            }

            $("#" + target).change();
        }
    }, "json");
}


$("#rsrcReqTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
			{sWidth : "45px" },		//No
			{sWidth : "65px" },     //자원요청구분
			{sWidth : "65px" },		//상태
			{sWidth : "200px" },    //제목
			{sWidth : "100px" },	//티켓번호
			{sWidth : "100px" },	//요청번호
			{sWidth : "120px" },	//요청유형
			{sWidth : "100px" },	//요청부서
			{sWidth : "80px" },	    //요청자
			{sWidth : "140px" },	//요청일시
			{sWidth : "80px" },		//실행자
			{sWidth : "140px" }		//완료일시
	 ],
	order : [ [ 0, "desc" ] ]
});
</script>