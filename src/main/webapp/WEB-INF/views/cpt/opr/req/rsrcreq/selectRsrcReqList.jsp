<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>
<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100 search-col">
	<div class="box box-search">
    <div class="box-header">
      <h3 class="box-title">검색조건</h3>
      <div class="box-tools pull-right">
        <button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse"><i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기"></i></button>
      </div>
    </div><!-- /box-header -->

   <form:form commandName="searchVo" name="frm" id="frm" method="get" action="">
		<form:hidden path="schRsrcReqNo" />
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
    <!-- box-body -->
    <div class="box-body collapse in search-collapse">
      <div class="form-group">
        <div class="form-cell form-cell-50 col-lay-25">
            <div class="cell-title">
                <label title="구분" for="rsrcReqClCd">구분</label>
            </div>
            <div class="cell-body">
                <nform:selectCode
                            parentCd="151"
                            parentGrpCd="098"
                            name="rsrcReqClCd"
                            id="rsrcReqClCd"
                            whole="true"
                            cssClass="form-control input-sm"
                            value="${searchVo.rsrcReqClCd}"
                            onchange="selectRsrcReqTyCd(this, 'rsrcReqTyCd')" />
            </div>
        </div>

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
            <div class="cell-title">
              <label for="rsrcReqPrcssStatCd">상태</label>
            </div>
            <div class="cell-body">
                <nform:selectCode
                            parentCd="106"
                            parentGrpCd="007"
                            name="rsrcReqPrcssStatCd"
                            id="rsrcReqPrcssStatCd"
                            whole="true"
                            value="${searchVo.rsrcReqPrcssStatCd}"
                            cssClass="form-control input-sm" />
            </div>
          </div>

		<div class="form-cell form-cell-50 col-lay-25">
		  <div class="cell-title">
		    <label for="rsrcReqTyCd">요청유형</label>
		  </div>
		  <div class="cell-body">
		  	<nform:selectCode
		           parentCd="107"
		           parentGrpCd="008"
		           name="rsrcReqTyCd"
		           id="rsrcReqTyCd"
		           whole="true"
		           value="${searchVo.rsrcReqTyCd}"
		           cssClass="form-control input-sm" />
		  </div>
		</div>

          <div class="form-cell form-cell-50 col-lay-25">
            <div class="cell-title">
              <label for="rsrcReqUsrNm">요청자</label>
            </div>
            <div class="cell-body input-group">
              <form:input path="rsrcReqUsrNm" cssClass="form-control  input-sm" />
            </div>
          </div>

          <div class="form-cell form-cell-50 col-lay-25">
            <div class="cell-title">
              <label for="ticktNo">티켓번호</label>
            </div>
            <div class="cell-body">
              <form:input path="ticktNo" cssClass="form-control input-sm pull-right" />
            </div>
          </div>

          <div class="form-cell form-cell-50 col-lay-25">
            <div class="cell-title">
              <label for="rsrcReqNo">요청번호</label>
            </div>
            <div class="cell-body">
              <form:input path="rsrcReqNo" cssClass="form-control input-sm pull-right" />
            </div>
          </div>

         <div class="form-cell form-cell-50 col-lay-25">
          <div class="cell-title">
            <label for="sbjct">제목</label>
          </div>
          <div class="cell-body">
            <form:input path="sbjct" cssClass="form-control input-sm pull-right" />
          </div>
        </div>

        <div class="form-cell form-cell-50 col-lay-25">
          <div class="cell-title">
            <label for="exeUserNm">실행자</label>
          </div>
          <div class="cell-body">
            <form:input path="exeUserNm" cssClass="form-control input-sm pull-right" />
          </div>
        </div>


        <div class="form-cell form-cell-50 col-lay-25">
          <div class="cell-title">
            <label for="haCompYn">HA여부</label>
          </div>
          <div class="cell-body">
          	<form:select path="haCompYn" cssClass="form-control input-sm">
             	<form:option value="">전체</form:option>
             	<form:option value="N">N</form:option>
							<form:option value="Y">Y</form:option>
						</form:select>
          </div>
        </div>

        <div class="form-cell form-cell-100 col-lay-50">
          <div class="cell-title">
            <label>요청일자</label>
          </div>
          <div class="cell-body">
					<div class="input-group period period-start">
            	<form:input path="rsrcReqDtStrt" cssClass="form-control input-sm  datepicker" title="요청 시작일자" onchange="initDate(this, 'rsrcReqDtEnd', 'S')" />
            </div>
            <div class="input-group period period-end">
            	<form:input path="rsrcReqDtEnd" cssClass="form-control input-sm  datepicker" title="요청 종료일자" onchange="initDate(this, 'rsrcReqDtStrt', 'E')" />
            </div>
          </div>
        </div>


        </div>

      </div><!-- /box-body -->
	</form:form>

    <div class="box-footer collapse in search-collapse">
      <div class="pull-left">
        <button class="btn" onclick="javascript:fn_searchAreaReset();return false;">초기화</button>
      </div>
      <div class="pull-right">
        <button onclick="javascript:fn_search();return false;" class="btn btn-red pull-right">조회</button>
      </div>
    </div><!-- /box-footer -->

  </div><!-- /box(검색조건) -->
</div><!-- /col -->


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
	     			<nform:selectRecodeCntPerPage formId="frm" value="${searchVo }"/>
	     			<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_goExcelDownload();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
  	    </div><!-- /box-header -->


		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<form id=rsrcReqView name="rsrcReqView" method="post">
			<table class="table table-hover table-vertical table-layout-fixed" id="rsrcReqTable">
				<caption>자원요청목록</caption>
        		<thead>
		          <tr>
		            <th>No.</th>
		            <th>상태</th>
		            <th>구분</th>
		            <th>제목</th>
		            <th>티켓번호</th>
		            <th>요청번호</th>
		            <th>요청유형</th>
		            <th>요청부처</th>
		            <th>요청자</th>
		            <th>요청일시</th>
		            <th>실행자</th>
		            <th>완료일시</th>
		          </tr>
		        </thead>
				<tbody>
					<c:forEach var="vo" items="${list}" varStatus="i">
						<tr>
							<td class="alignC"><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
		                	<td class="alignC"><nobr>
		                		<!-- 요청 01: 처리중:02, 완료 03: 반려: 04 , 오류:05, 요청삭제,기타:06 -->
		                		<span class="status <c:choose>
		                								<c:when test="${'01' eq vo.rsrcReqPrcssStatCd}"><c:out value="status-blue"/></c:when>
		                								<c:when test="${'02' eq vo.rsrcReqPrcssStatCd}"><c:out value="status-yellow"/></c:when>
		                								<c:when test="${'03' eq vo.rsrcReqPrcssStatCd}"><c:out value="status-green"/></c:when>
		                								<c:when test="${'04' eq vo.rsrcReqPrcssStatCd}"><c:out value="status-aqua"/></c:when>
		                								<c:when test="${'05' eq vo.rsrcReqPrcssStatCd}"><c:out value="status-red"/></c:when>
		                								<c:when test="${'06' eq vo.rsrcReqPrcssStatCd}"><c:out value="status-gray"/></c:when>
		                								<c:when test="${'07' eq vo.rsrcReqPrcssStatCd}"><c:out value="status-green"/></c:when>
														<c:otherwise><c:out value="status-gray"/></c:otherwise>
		                							</c:choose>
		                			status-red "><c:out value="${vo.rsrcReqPrcssStatNm}"/>
		                		</span></nobr>
		                	</td>
		                	<td class="alignL"><c:out value="${vo.rsrcReqClNm}" /></td>
			                <td class="alignL"> <a href="#" title="<c:out value="${vo.sbjct}"/>" onclick="javascript:fn_goRsrcReqDtl('<c:out value="${vo.rsrcReqNo}"/>','<c:out value="${vo.rsrcReqTyCd}"/>'); return false;"> <c:out value="${cf:ellipsis(vo.sbjct, 60) }" /></a></td>
			                <td class="alignL"><c:out value="${vo.ticktNo}" /></td>
			                <td class="alignL"><c:out value="${vo.rsrcReqNo}" /></td>
			                <td class="alignL"><c:out value="${vo.rsrcReqTyNm}" /></td>
			                <td class="alignL"><c:out value="${vo.reqInstitutionNm}" /></td>
			                <td class="alignC"><c:out value="${vo.rsrcReqUsrNm}" /></td>
			                <td class="alignC"><c:out value="${vo.rsrcReqDttm}" /></td>
			                <td class="alignC"><c:out value="${vo.exeUserNm}" /></td>
			                <td class="alignC"><c:out value="${vo.comptDttm}" /></td></tr>
					</c:forEach>
				</tbody>
			</table>
			</form>
		</div>
		<!-- /box-body   -->

		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo}" type="common" jsFunction="fn_goPage" />
			</ul>

			<div class="pull-right btns">
                <menu:authorize onlyOprAdm="true">
                <c:url var="insertUrl" value="insertRsrcReqAtmSclView.do">
                        <c:forEach var="curParam" items="${param }">
                            <c:param name="${curParam.key }" value="${curParam.value }"></c:param>
                        </c:forEach>
                    </c:url>


                    <button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="자동확장 요청" onclick="goToUrl('${insertUrl}')"><i class="fa fa-plus"></i></button>
                </menu:authorize>
            </div>

		</div>
		<!-- /box-footer -->
	</div>
</div>


<script type="text/javascript">

$(document).ready(function(){

	$(document).ready(function() {
	    $("#rsrcReqClCd").change();
	});
});


//페이지를 이동시킨다.
function fn_goPage(page){
	location.href = "selectRsrcReqList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

//조회버튼 클릭시.
function fn_search() {

	// 요청번호
	var tmp = $.trim($("#frm input[name='rsrcReqNo']").val());
	if(tmp != '') $("#frm input[name='rsrcReqNo']").val(tmp);
	// 요청자
	tmp = $.trim($("#frm input[name='rsrcReqUsrNm']").val());
	if(tmp != '') $("#frm input[name='rsrcReqUsrNm']").val(tmp);
	// 티켓번호
	tmp = $.trim($("#frm input[name='ticktNo']").val());
	if(tmp != '') $("#frm input[name='ticktNo']").val(tmp);
	// 실행자
	tmp = $.trim($("#frm input[name='exeUserNm']").val());
	if(tmp != '') $("#frm input[name='exeUserNm']").val(tmp);
	// 제목
	tmp = $.trim($("#frm input[name='sbjct']").val());
	if(tmp != '') $("#frm input[name='sbjct']").val(tmp);


	$("#frm").attr("target", "_self");
	$("#frm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/selectRsrcReqList.do'/>");
	$("#frm").submit();
	return false;
}

//목록의 정보를 Excel로 다운로드 한다.
function fn_goExcelDownload() {

	if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		alert("다운로드 할 데이터가 없습니다.");
		return;
	}

	$("#frm").attr("target", "_self");
	$("#frm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/excelDownRsrcReqList.do'/>");
	$("#frm").submit();
	return false;
	//location.href = "downfileExcel.do";
}

//초기화 버튼 클릭 시
function fn_searchAreaReset() {
	$("#frm").find("input[type='text']").val("");
	//$("#frm").find("input[type='hidden']").val("");
	$('#frm select').val('').attr('selected', 'selected');
}

//요청유형에 따라 상세페이지로 이동한다.
function fn_goRsrcReqDtl(rsrcReqNo, rsrcReqTyCd) {
	$("#frm").attr("target", "_self");
	$("#frm #schRsrcReqNo").val(rsrcReqNo);  //자원요청번호

	if(rsrcReqTyCd == "01") { //가상서버 생성
		$("#frm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/selectRsrcReqVmCre.do'/>");
	}else if(rsrcReqTyCd == "02") { //가상서버 삭제
		$("#frm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/formRsrcReqVmDel.do'/>");
	}else if(rsrcReqTyCd == "03") { //가상서버 스펙변경
		$("#frm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/formRsrcReqVmSpecChng.do'/>");
	}else if(rsrcReqTyCd == "04") {  //SLB설정
		$("#frm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/formRsrcReqSlbCre.do'/>");
	}else if(rsrcReqTyCd == "05") { //물리서버추가
		$("#frm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/formRsrcReqPhySrvAdd.do'/>");
	}else if(rsrcReqTyCd == "06") {  //물리서버삭제
		$("#frm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/formRsrcReqPhySrvDel.do'/>");
	}else if(rsrcReqTyCd == "07") {  //클러스터추가
		$("#frm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/formRsrcReqClstAdd.do'/>");
	}else if(rsrcReqTyCd == "08") {  //클러스터삭제
		$("#frm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/formRsrcReqClstDel.do'/>");
	}else if(rsrcReqTyCd == "09") {  //스토리지 삭제
		$("#frm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/formRsrcReqVmSpecChng.do'/>");
	}else if(rsrcReqTyCd == "11" || rsrcReqTyCd == "12" || rsrcReqTyCd == "13" ) {  //자동확장 (서비스영역생성, 서비스영역변경, 서비스영역삭제)
        $("#frm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/updateRsrcReqAtmScl.do'/>");
    }

	$("#frm").submit();
	return false;
}


//요청유형을 조회한다.
function selectRsrcReqTyCd(obj, target) {

    var url = "<c:url value='/cpt/opr/req/rsrcreq/selectRsrcReqTyCdList.do'/>";
    var val = $(obj).val();

    var searchParams = { "rsrcReqClCd" : val };
    var targetVal = $('#rsrcReqTyCd').val();

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
			{sWidth : "50px" },		//No
			{sWidth : "65px" },		//상태
			{sWidth : "100px" },    //자원요청구분
			{sWidth : "200px" },    //제목
			{sWidth : "100px" },	//티켓번호
			{sWidth : "100px" },	//요청번호
			{sWidth : "125px" },	//요청유형
			{sWidth : "100px" },	//요청부서
			{sWidth : "100px" },	//요청자
			{sWidth : "140px" },	//요청일시
			{sWidth : "80px" },		//실행자
			{sWidth : "140px" }		//완료일시
	 ],
	order : [ [ 0, "desc" ] ]
});

</script>

