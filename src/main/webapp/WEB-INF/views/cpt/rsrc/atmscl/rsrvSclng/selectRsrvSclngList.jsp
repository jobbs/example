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
	<form:form commandName="rsrvSclngSearchVo" method="GET">
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
							<label title="센터" for="regionId">센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion name="regionId" id="regionId" cssClass="form-control input-sm" title="센터" value="${rsrvSclngVo.regionId}" whole="true"
							  byRole="false" onchange="selectZoneByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'byRole' : false})" />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="존" for="zoneId">존</label>
						</div>
						<div class="cell-body">
							<nform:selectZone name="zoneId" id="zoneId" class="form-control input-sm"	title="존" whole="true" regionId="${rsrvSclngVo.regionId}"
							value="${rsrvSclngVo.zoneId}"  byRole="false" onchange="selectPoolByNetClCd('regionId', 'zoneId','netClCd', 'rsrcPoolId' , {'searchPoolTypeCd' : '05', 'byRole' : false})" />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="망구분" for="netClCd">망구분 </label>
						</div>
						<div class="cell-body">
						<nform:selectCode name="netClCd" id="netClCd" title="망" cssClass="form-control input-sm"
								whole="true"
								parentCd="NETCD"
          						parentGrpCd="067"
								zoneId="${rsrvSclngVo.zoneId}"
							 	value="${rsrvSclngVo.netClCd}"
							 	byRole="false"
								onchange="selectPoolByNetClCd('regionId', 'zoneId','netClCd', 'rsrcPoolId', {'searchPoolTypeCd' : '05', 'byRole' : false  } )" />
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
						          regionId="${rsrvSclngVo.regionId }"
						          zoneId="${rsrvSclngVo.zoneId}"
						          netClCd="${rsrvSclngVo.netClCd }"
						          value="${rsrvSclngVo.rsrcPoolId}"
						          ctlTrgtYn=""/>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="institutionNm">부처</label>
						</div>
						<div class="cell-body">
							<form:input path="institutionNm" title="부처" cssClass="form-control input-sm " value=""  />
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="jobNm">업무</label>
						</div>
						<div class="cell-body">
							<form:input path="jobNm" title="업무"  cssClass="form-control input-sm " value="" />
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="scalrNm">예약명</label>
						</div>
						<div class="cell-body">
							<form:input path="scalrNm" title="예약명"  cssClass="form-control input-sm " value="" />
						</div>
					</div>
                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="useYn">사용여부</label>
						</div>
						<div class="cell-body">
								<form:select path="useYn"  class="form-control input-sm" title="사용여부" >
									<form:option value="">전체</form:option>
									<form:option value="Y">사용</form:option>
									<form:option value="N">미사용</form:option>
								</form:select>
						</div>
					</div>
					<div class="form-cell form-cell-100 col-lay-50">
						<div class="cell-title">
							<label for="rsrvStrtDt" title="예약시작일">예약시작일</label>
						</div>
						<div class="cell-body">
							<div class="input-group period period-start">
								<form:input path="rsrvStrtDt" title="예약시작일"  cssClass="form-control input-sm datepicker onlyDate" value="" onchange="initDate(this, 'rsrvEndDt', 'S')" maxlength="60"/>
							</div>
							<div class="input-group period period-end">
								<form:input path="rsrvEndDt" title="예약종료일"  cssClass="form-control input-sm datepicker onlyDate" value="" onchange="initDate(this, 'rsrvStrtDt', 'E')" maxlength="60"/>
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
						<c:url var="selectRsrvSclngListUrl" value="selectRsrvSclngList.do"></c:url>
						<button type="button" class="btn btn-red" onclick="fn_selectRsrvSclngList();" title="조회">조회</button>
					</div>
				</div>

			</div>

	</form:form>
</div>


<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">검색결과<small>
				${rsrvSclngVo.paginationInfo.currentPageNo } /
				${rsrvSclngVo.paginationInfo.totalPageCount },
				총 ${rsrvSclngVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="rsrvSclngSearchVo" value="${rsrvSclngSearchVo}"/>
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="엑셀다운로드" data-original-title="엑셀다운로드" onclick="fn_selectRsrvSclngListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">

				<table class="table table-hover table-vertical table-layout-fixed" id="rsrvSclngListTable">
					<caption>스케일 예약설정 목록 테이블</caption>


				<thead>
					<tr>
						<th>No.</th>
						<th>사용여부</th>
						<th>부처</th>
						<th>업무</th>
						<th>센터</th>
						<th>존</th>
						<th>망구분</th>
						<th>자원풀</th>
						<th>서비스명</th>
						<th>예약명</th>
						<th>배포이미지명</th>
						<th>예약시작일자</th>
						<th>예약종료일자</th>
						<th>Pod 수</th>
                    </tr>
				</thead>


					<tbody>
						<c:forEach var="vo" items="${list}" varStatus="i">
							<tr>
								<c:url var="detailUrl" value="selectAtmSclRsrvSclng.do">
									<c:forEach var="curParam" items="${param }">
										<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
									</c:forEach>
									<c:param name="servcSeq" value="${vo.servcSeq }" />
									<c:param name="scalrId" value="${vo.scalrId }" />
								</c:url>

									<td class="alignC"><c:out value="${(rsrvSclngVo.paginationInfo.totalRecordCount-rsrvSclngVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
									<td class="alignC">
										<c:choose>
											<c:when test="${vo.useYn =='Y'}">
												<span title="사용" class="status status-green">사용</span>
											</c:when>
											<c:when test="${vo.useYn =='N'}">
												<span title="미사용" class="status status-gray">미사용</span>
											</c:when>
										</c:choose>
									</td>
									<td class="alignL"><c:out value="${vo.institutionNm}" /></td>
									<td class="alignL"><c:out value="${vo.jobNm}" /></td>
									<td class="alignC"><c:out value="${vo.regionNm}" /></td>
		                          	<td class="alignC"><c:out value="${vo.zoneNm}" /></td>
		                           	<td class="alignC"><c:out value="${vo.netNm}" /></td>
		                           	<td class="alignL"><c:out value="${vo.rsrcPoolNm}" /></td>
		                           	<td class="alignL">
		                           	<a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.servcNm}" /> 상세 화면이동"><c:out value="${vo.servcNm}"/></a>
		                           	</td>
		                           	<td class="alignL">
		                           		<a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.scalrNm}" /> 상세 화면이동"><c:out value="${vo.scalrNm}" /></a>
		                           	</td>
		                           	<td class="alignL"><c:out value="${vo.imgNm}" /></td>

		                           	<td class="alignC">
		                           		<fmt:parseDate var="parsedStrtDate" value="${vo.rsrvStrtDt}" pattern="yyyyMMdd" />
		                           		<fmt:formatDate var="rsrvStrtDtFormat" value="${parsedStrtDate}" pattern="yyyy-MM-dd"/>
		                           		<c:out value="${rsrvStrtDtFormat}" />
		                           	</td>
		                           	<td class="alignC">
		                           		<fmt:parseDate var="parsedEndDate" value="${vo.rsrvEndDt}" pattern="yyyyMMdd" />
		                           		<fmt:formatDate var="rsrvEndDtFormat" value="${parsedEndDate}" pattern="yyyy-MM-dd"/>
		                           		<c:out value="${rsrvEndDtFormat}" />
		                           	</td>
		                           	<td class="alignR"><c:out value="${vo.maxPodQty}" /></td>



		                       </tr>
						</c:forEach>
					</tbody>
				</table>

		</div>



		<div class="box-footer edit-btn-group ">
			<ul class="pagination">
				<ui:pagination paginationInfo="${rsrvSclngVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertRsrvSclngView.do"/>
					<button type="button" class="btn btn-sm btn-hover-blue" data-toggle="tooltip" data-original-title="생성" onclick="goToUrl('${insertUrl}')"><i class="fa fa-plus"></i></button>
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
		location.href = "<c:url value='selectRsrvSclngList.do?paginationInfo.currentPageNo=" + page + "&${listParam}'/>";
	}

	// 검색조건 초기화
	function fn_reset() {
		$("#rsrvSclngSearchVo input[type='text']").val("");
		$("#rsrvSclngSearchVo select").val("").attr("selected", "selected");
	}

	// 배포 목록조회
	function fn_selectRsrvSclngList(){
		var nowDate = new Date();
		var year = nowDate.getFullYear();
		var month = nowDate.getMonth()+1;
		var day = nowDate.getDate();
		var startDate = $("#rsrvStrtDt").val();
		var endDate = $("#rsrvEndDt").val();

		var startDateArr = startDate.split("-");
		var endDateArr = endDate.split("-");

		var startDateCompare = new Date(startDateArr[0],startDateArr[1],startDateArr[2]);
		var endDateCompare = new Date(endDateArr[0],endDateArr[1],endDateArr[2]);

		if(startDateCompare.getTime() > endDateCompare.getTime()){
			jAlert("예약 시작일이 예약종료일 보다 큽니다.. ");
			return;
		}


		$("#rsrvSclngSearchVo").attr('target', '_self');
		$("#rsrvSclngSearchVo").attr("action", "<c:url value='selectRsrvSclngList.do'/>");
		$("#rsrvSclngSearchVo").submit();
	}
	//엑셀 다운로드
	function fn_selectRsrvSclngListXlsDwnl(){
		if("${rsrvSclngSearchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		$('#rsrvSclngSearchVo').attr('target', '_self');
		$('#rsrvSclngSearchVo').attr('action', '<c:url value="selectRsrvSclngListXlsDwnl.do"/>');
		$('#rsrvSclngSearchVo').submit();
	}
	//스케일 예약설정 요청
	function fn_insertRsrvSclng(){
		location.href = '<c:url value="insertRsrvSclngView.do" />';
	}



    $("#rsrvSclngListTable").DataTable({
        dom : 'Zlfrtip',
        paging : false,
        searching : false,
        info : false,
        aoColumns : [
              {sWidth : "50px" }, //No
              {sWidth : "70px" }, //사용여부
              {sWidth : "90px" }, //부처명
              {sWidth : "90px" }, //업무명
              {sWidth : "50px" }, //센터
              {sWidth : "50px" }, //존
              {sWidth : "90px" }, //망
              {sWidth : "90px" }, //자원풀
              {sWidth : "130px" },
              {sWidth : "140px" },
              {sWidth : "200px" },
              {sWidth : "90px" },
              {sWidth : "90px" },
              {sWidth : "50px" },

        ],
        order : [ [ 0, "desc" ] ]
    });

</script>