<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     양정순         v1.0             최초생성
 *
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-box-100 search-col">
  <form:form commandName="searchVo" method="get" onsubmit="fn_search(); return false;">
    <input type="hidden" name="search" value="T">
    <input type="hidden" id="institutionIdT">

    <div class="box box-search">
      <div class="box-header">
        <h3 class="box-title">검색조건</h3>
        <div class="box-tools pull-right">
          <button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
            <i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
          </button>
        </div>
      </div>
      <!-- /box-header -->
      <div class="box-body collapse in search-collapse" id="demo">
        <div class="form-group">

          <!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
          <!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
          <div class="form-cell form-cell-25 col-lay-25">
            <div class="cell-title">
              <label>부처명</label>
            </div>
            <div class="cell-body">
              <div class="input-group">
                <form:input type="text" path="institutionNm" cssClass="form-control input-sm " title="부처명" /><!-- essential -->
                <div class="input-group-btn">
                  <button class="btn btn-sm" onclick="openInsttSearch(); return false;">
                    <i class="fa fa-search"></i>
                  </button>
                </div>
              </div>
            </div>
          </div>

        </div>
      </div>
      <!-- /box-body -->
      <div class="box-footer collapse in search-collapse">
        <div class="pull-left">
          <button type="button" class="btn" onclick="fn_initialize();">초기화</button>
        </div>
        <div class="pull-right">
          <button type="submit" class="btn btn-red ">조회</button>
        </div>
      </div>
      <!-- /box-footer -->
    </div>
    <!-- /box(검색조건) -->
  </form:form>
</div>
<!-- /col -->

<div class="col-box-100 search-col">
  <div class="box list-box">
    <div class="box-header">
      <h3 class="box-title">
        업무별 자원현황목록
        <!-- <small>1 / 1, 총 1건</small>-->
      </h3>
      <div class="box-tools">
        <div class="input-group-box">
          <div class="input-group-cell pad-right">
            <button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_excelDown()">
              <i class="fa fa-download"></i>
            </button>
          </div>
        </div>
      </div>
    </div>
    <div class="box-body no-padding list-body">
      <table class="table table-vertical table-hover">
        <caption>업무별 자원현황목록</caption>
        <colgroup>
          <col class="col20">
          <col class="col20">
          <col class="col20">
          <col class="col20">
          <col class="col20">
        </colgroup>
        <thead>
          <tr>
            <th>부처명</th>
            <th>업무명</th>
            <th>컴퓨팅</th>
            <th>네트워크</th>
            <th>자동확장 서비스</th>
          </tr>
        </thead>
        <tbody>
          <c:choose>
            <c:when test="${ list eq null or empty list }">
              <tr>
                <td colspan="5">
                  <c:choose>
                    <c:when test="${searchVo.search eq null or empty searchVo.search }">
                             조회 버튼을 클릭해 주시기 바랍니다.
                        </c:when>
                    <c:otherwise>
                              검색된 데이터가 없습니다.
                         </c:otherwise>
                  </c:choose>
                </td>
              </tr>
            </c:when>
            <c:otherwise>
              <c:forEach var="vo" items="${list}" varStatus="ri">
                <tr>
                  <td class="alignL"><c:out value="${vo.institutionNm }" /></td>
                  <td class="alignL"><a href="javascript:f_openPop('<c:out value="${vo.jobId }" />','<c:out value="${vo.institutionId }" />','<c:out value="${vo.jobNm }" />');"><c:out value="${vo.jobNm }" /></a></td>
                  <td class="alignR"><fmt:formatNumber value="${vo.com}" pattern="#,###" /></td>
                  <td class="alignR"><fmt:formatNumber value="${vo.netwk}" pattern="#,###" /></td>
                  <c:choose>
                    <c:when test="${vo.autoCom > 0}">
                      <td class="alignR"><fmt:formatNumber value="${vo.autoCom}" pattern="#,###" /></td>
                    </c:when>
                    <c:otherwise>
                      <td class="alignR"><fmt:formatNumber value="0" pattern="#,###" /></td>
                    </c:otherwise>
                  </c:choose>

                </tr>
              </c:forEach>
            </c:otherwise>
          </c:choose>
        </tbody>
      </table>
    </div>
    <!-- /box-body -->
    <div class="box-footer edit-btn-group">
      <div class="pull-left btns"></div>
      <ul class="pagination"></ul>
    </div>
  </div>
  <!-- /box -->
</div>
<!-- /col -->


<script type="text/javascript">
  //----------------------------------------------------------------------
  //부처에 대한 단일 선택
  $(document).bind('selectInstitution', setInstitution);
  //업무에 대한 단일 선택 이벤터 함수
  function setInstitution(evt) {
    var job = evt.datas;
    $("#institutionNm").val(job.institutionNm);

    $("#institutionIdT").val(job.institutionId);

    console.log("institutionId : " + job.institutionId);
    console.log("institutionNm : " + job.institutionNm);
    console.log("regionId : " + job.regionId);
    console.log("regionNm : " + job.regionNm);
  }

  // 검색조건 초기화
  function fn_initialize() {
    $('#searchVo input[type="text"]').val('');

  }

  function fn_search() {
    if (!fn_form_validation("searchVo")) {
      return;
    }

    searchVo.action = '<c:url value="selectJobRsrcStteList.do" />';
    searchVo.submit();
  }

  function fn_excelDown() {
    if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
      jAlert("엑셀로 다운로드할 데이터가 없습니다.");
      return;
    }
    searchVo.action = '<c:url value="selectJobRsrcStteXlsDown.do" />';
    searchVo.submit();
  }

  function f_openPop(jobId, institutionId, jobNm) {
    //window.open('./가상서버 목록.html','');
    //alert(jobId);
    location.href = '<c:url value="selectJobRsrcStteVmList.do" />?jobId='
        + jobId + '&institutionId=' + institutionId + '&jobNm=' + jobNm;
  }
</script>

