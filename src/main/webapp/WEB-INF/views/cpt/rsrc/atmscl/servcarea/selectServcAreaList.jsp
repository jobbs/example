<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 04. 28.
 * @lastmodified 2017. 04. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 04. 28.     x         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100 search-col">
	<form:form id="searchVo" commandName="searchVo" method="GET">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
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

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="센터" for="equalsRegionId">센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion
					          name="regionId"
					          id="regionId"
					          title="센터"
					          whole="true"
					          byRole="false"
					          wholeText="전체"
					          cssClass="form-control input-sm"
					          value="${searchVo.regionId}"
					          onchange="selectZoneByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'byRole' : false,'searchPoolTypeCd':'05'})" />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="존" for="zoneId">존</label>
						</div>
						<div class="cell-body">
							<nform:selectZone
					          name="zoneId"
					          id="zoneId"
					          whole="true"
					          byRole="false"
					          regionId="${searchVo.regionId}"
					          value="${searchVo.zoneId}"
					          wholeText="전체"
					          cssClass="form-control input-sm"
					          onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'byRole' : false,'searchPoolTypeCd':'05'})" />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="망구분" for="netClCd">망구분 </label>
						</div>
						<div class="cell-body">
							<nform:selectCode
					          parentCd="NETCD"
					          parentGrpCd="067"
					          name="netClCd"
					          id="netClCd"
					          whole="true"
					          byRole="false"
					          wholeText="전체"
					          extra1=""
					          extra2=""
					          extra3=""
					          value="${searchVo.netClCd}"
					          extra4=""
					          extra5=""
					          cssClass="form-control input-sm"
					          onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'byRole' : false,'searchPoolTypeCd':'05'})"  />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="자원풀" for="rsrcPoolId">자원풀</label>
						</div>
						<div class="cell-body">
							<nform:selectPool
						          name="rsrcPoolId"
						          id="rsrcPoolId"
						          title="자원풀"
						          wholeText="전체"
						          poolTypeCd="05"
						          cssClass="form-control input-sm"
						          swTypeCd="ATMSCL"
						          regionId="${searchVo.regionId }"
						          zoneId="${searchVo.zoneId}"
						          netClCd="${searchVo.netClCd }"
						          value="${searchVo.rsrcPoolId}"
						          ctlTrgtYn=""/>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="institutionNm">부처</label>
						</div>
						<div class="cell-body">
							<form:input type="text" path="institutionNm" class="form-control input-sm pull-right" maxlength="30" title="부처명" />
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="institutionNm">업무</label>
						</div>
						<div class="cell-body">
							<form:input type="text" path="jobNm" class="form-control input-sm pull-right" maxlength="30" title="업무명" />
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
	                    <div class="cell-title">
	                        <label for="servcAreaNm">서비스영역명</label>
	                    </div>
	                    <div class="cell-body">
	                        <form:input type="text" path="servcAreaNm" class="form-control input-sm pull-right" maxlength="30" title="서비스영역명" />
	                    </div>
	                </div>

	                <div class="form-cell form-cell-50 col-lay-25">
	                    <div class="cell-title">
	                        <label for="servcAreaCompId">서비스영역구성ID</label>
	                    </div>
	                    <div class="cell-body">
	                        <form:input type="text" path="servcAreaCompId" class="form-control input-sm pull-right" maxlength="10" title="서비스영역구성ID" />
	                    </div>
	                </div>

			    </div>

				<div class="box-footer collapse in search-collapse">
					<div class="pull-left">
						<button type="button" class="btn" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
					</div>
					<div class="pull-right">
						<button type="button" class="btn btn-red" onclick="fn_selectServcAreaList();" title="조회">조회</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
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
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_downloadExcel();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
			<form id="servcAreaView" name="servcAreaView" method="post">
				<table class="table table-hover table-vertical table-layout-fixed" id="atmSclServcAreaTable">
					<caption>서비스영역 목록 테이블</caption>
					<thead>
                      <tr>
                        <th>No.</th>
                        <th>부처</th>
                        <th>업무</th>
                        <th>센터</th>
                        <th>존</th>
                        <th>망구분</th>
                        <th>자원풀</th>
                        <th>서비스영역명</th>
                        <th>서비스영역ID</th>
                        <th>서비스영역구성ID</th>
                        <th>생성자</th>
                        <th>생성일자</th>
                        <th>수정자</th>
                        <th>수정일자</th>
                      </tr>
                    </thead>

					<tbody>
						<c:forEach var="vo" items="${list }" varStatus="i">
							<tr>
								<c:url var="detailUrl" value="selectServcArea.do">
									<c:forEach var="curParam" items="${param }">
										<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
									</c:forEach>
									<c:param name="servcAreaSeq" value="${vo.servcAreaSeq }" />
								</c:url>

								<td class="alignC"><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
								<td class="alignL"><c:out value="${vo.institutionNm}" /></td>
								<td class="alignL"><c:out value="${vo.jobNm}" /></td>
								<td class="alignL"><c:out value="${vo.regionNm}" /></td>
								<td class="alignL"><c:out value="${vo.zoneNm}" /></td>
								<td class="alignL"><c:out value="${vo.netNm}" /></td>
								<td class="alignL"><c:out value="${vo.rsrcPoolNm}" /></td>
								<td class="alignL">
								    <a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.servcAreaNm}"/> 상세 화면이동"><c:out value="${vo.servcAreaNm}" /></a>
								</td>
								<td class="alignL"><c:out value="${vo.servcAreaId}" /></td>
								<td class="alignL"><c:out value="${vo.servcAreaCompId}" /></td>
								<td class="alignL"><c:out value="${vo.creUserNm}" /></td>
								<td class="alignC"><c:out value="${vo.creDttm}" /></td>
								<td class="alignL"><c:out value="${vo.updtUserNm}" /></td>
								<td class="alignC"><c:out value="${vo.updtDttm}" /></td>
		                    </tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>

		<div class="box-footer edit-btn-group ">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize onlyOprAdm="true">
				<c:url var="insertUrl" value="insertServcAreaView.do">
                        <c:forEach var="curParam" items="${param }">
                            <c:param name="${curParam.key }" value="${curParam.value }"></c:param>
                        </c:forEach>
                    </c:url>
					<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="서비스영역 생성" onclick="goToUrl('${insertUrl}')"><i class="fa fa-plus"></i></button>
				</menu:authorize>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	$(document).ready(function() {

	});

	// 페이징 이동
	function fn_goPage(page){
		location.href = "<c:url value='selectServcAreaList.do?paginationInfo.currentPageNo=" + page + "&${listParam}'/>";
	}

	// 검색조건 초기화
	function fn_reset() {
		$("#searchVo input[type='text']").val("");
		$("#searchVo select").val("").attr("selected", "selected");
	}

	// 서비스영역 목록조회
	function fn_selectServcAreaList(){

		$("#searchVo").attr("action", "selectServcAreaList.do");
		$("#searchVo").submit();
	}


	// 엑셀 다운로드
	function fn_downloadExcel() {
		if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("다운로드할 데이터가 없습니다");
			return;
		}

		$("#searchVo").attr("action", "selectServcAreaListXlsDwnl.do");
		$("#searchVo").submit();
	}



    $("#atmSclServcAreaTable").DataTable({
        dom : 'Zlfrtip',
        paging : false,
        searching : false,
        info : false,
        aoColumns : [
              {sWidth : "50px" },
              {sWidth : "100px" },
              {sWidth : "110px" },
              {sWidth : "28px" },
        	  {sWidth : "60px" },
        	  {sWidth : "60px" },
        	  {sWidth : "80px" },
              {sWidth : "185px" },
              {sWidth : "133px" },
              {sWidth : "104px" },
              {sWidth : "85px" },
              {sWidth : "90px" },
              {sWidth : "85px" },
              {sWidth : "90px" }
        ],
        order : [ [ 0, "desc" ] ]
    });


</script>
