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
	<form:form commandName="atmsclDistrbSearchVo" method="GET">
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
							<nform:selectRegion name="regionId" id="regionId" cssClass="form-control input-sm" title="센터" value="${atmsclDistrbVo.regionId}" whole="true"
							  byRole="false" onchange="selectZoneByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'byRole' : false})" />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="존" for="zoneId">존</label>
						</div>
						<div class="cell-body">
							<nform:selectZone name="zoneId" id="zoneId" class="form-control input-sm"	title="존" whole="true" regionId="${atmsclDistrbVo.regionId}"
							value="${atmsclDistrbVo.zoneId}"  byRole="false" onchange="selectPoolByNetClCd('regionId', 'zoneId','netClCd', 'rsrcPoolId' , {'searchPoolTypeCd' : '05', 'byRole' : false})" />
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
								zoneId="${atmsclDistrbVo.zoneId}"
							 	value="${atmsclDistrbVo.netClCd}"
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
						          regionId="${atmsclDistrbVo.regionId }"
						          zoneId="${atmsclDistrbVo.zoneId}"
						          netClCd="${atmsclDistrbVo.netClCd }"
						          value="${atmsclDistrbVo.rsrcPoolId}"
						          ctlTrgtYn=""/>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="institutionNm">부처</label>
						</div>
						<div class="cell-body">
							<form:input path="institutionNm"  title="부처" cssClass="form-control input-sm" value="" />
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="jobNm">업무</label>
						</div>
						<div class="cell-body">
							<form:input path="jobNm" title="업무"  cssClass="form-control input-sm" value="" />
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="lastDistrbVer">배포버전</label>
						</div>
						<div class="cell-body">
							<form:input path="lastDistrbVer" title="배포버전"  cssClass="form-control input-sm" value="" />
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="statCd">배포상태</label>
						</div>
						<div class="cell-body">
							<form:select path="statCd"  class="form-control input-sm" title="배포상태" >
								<form:option value="">전체</form:option>
								<c:forEach var="cdList" items="${selectCodeList}">
									<form:option value="${cdList.cd}">${cdList.cdNm }</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="servcAreaNm">서비스영역명</label>
						</div>
						<div class="cell-body">
							<form:input path="servcAreaNm" title="서비스영역명"  cssClass="form-control input-sm" value=""/>
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="servcNm">서비스명</label>
						</div>
						<div class="cell-body">
							<form:input path="servcNm" title="서비스명"  cssClass="form-control input-sm" value="" />
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="imgTag">배포이미지명</label>
						</div>
						<div class="cell-body">
							<form:input path="imgNm" title="배포이미지명" cssClass="form-control input-sm" value="" />
						</div>
					</div>
				</div>
			</div>


				<div class="box-footer collapse in search-collapse">
					<div class="pull-left">
						<button type="button" class="btn" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
					</div>
					<div class="pull-right">
						<c:url var="selectAtmsclDistrbListUrl" value="selectAtmsclDistrbList.do"></c:url>
						<button type="button" class="btn btn-red" onclick="fn_selectAtmsclDistrbList();" title="조회">조회</button>
					</div>
				</div>

			</div>

	</form:form>
</div>


<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">검색결과<small>
				${atmsclDistrbVo.paginationInfo.currentPageNo } /
				${atmsclDistrbVo.paginationInfo.totalPageCount },
				총 ${atmsclDistrbVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="atmsclDistrbSearchVo" value="${atmsclDistrbSearchVo}"/>
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="엑셀다운로드" data-original-title="엑셀다운로드" onclick="fn_selectAtmsclDistrbListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
				<table class="table table-hover table-vertical table-layout-fixed" id="atmsclDistrbListTable">
					<caption>배포 목록 테이블</caption>

	          	 <thead>
					<tr>
						<th>No.</th>
						<th>배포상태</th>
						<th>부처</th>
						<th>업무</th>
						<th>센터</th>
						<th>존</th>
						<th>망구분</th>
						<th>자원풀</th>
						<th>서비스영역명</th>
						<th>서비스명</th>
						<th>배포이미지명</th>
						<th>배포버전</th>
						<th>생성일</th>
                    </tr>
				</thead>

					<tbody>
						<c:forEach var="vo" items="${list}" varStatus="i">
							<tr>
								<c:url var="detailUrl" value="selectDetailAtmsclDistrb.do">
									<c:forEach var="curParam" items="${param }">
										<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
									</c:forEach>
									<c:param name="servcSeq" value="${vo.servcSeq }" />
									<c:param name="servcAreaSeq" value="${vo.servcAreaSeq }" />
									<c:param name="rsrcPoolId" value="${vo.rsrcPoolId }" />
									<c:param name="distrbConfId" value="${vo.distrbConfId }" />
									<c:param name="imgId" value="${vo.imgId}" />
									<c:param name="servcAreaId" value="${vo.servcAreaId}" />
								</c:url>

									<td class="alignC"><c:out value="${(atmsclDistrbVo.paginationInfo.totalRecordCount-atmsclDistrbVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
									<td class="alignC">
										 <c:choose>
											<c:when test="${vo.statCd eq '01'}">
												<span title="${vo.statNm }" class="status status-blue"><c:out value="${vo.statNm }"/></span>
											</c:when>
											<c:when test="${vo.statCd eq '02'}">
												<span title="${vo.statNm }" class="status status-green"><c:out value="${vo.statNm }"/></span>
											</c:when>
											<c:when test="${vo.statCd eq '03'}">
												<span title="${vo.statNm }" class="status status-red"><c:out value="${vo.statNm }"/></span>
											</c:when>
											<c:when test="${vo.statNm eq '04'}">
												<span title="${vo.statNm }" class="status status-aqua"><c:out value="${vo.statNm }"/></span>
											</c:when>
											<c:when test="${vo.statNm eq '05'}">
												<span title="${vo.statNm }" class="status status-aqua"><c:out value="${vo.statNm }"/></span>
											</c:when>
											<c:when test="${vo.statNm eq '06'}">
												<span title="${vo.statNm }" class="status status-aqua"><c:out value="${vo.statNm }"/></span>
											</c:when>
											<c:when test="${vo.statNm eq '07'}">
												<span title="${vo.statNm }" class="status status-aqua"><c:out value="${vo.statNm }"/></span>
											</c:when>

											<c:otherwise><span title="${selectCodeList[7].cdNm}" class="status status-aqua"><c:out value="${selectCodeList[7].cdNm}"/></span></c:otherwise>
										</c:choose>
									</td>
									<td class="alignL"><c:out value="${vo.institutionNm}" /></td>
									<td class="alignL"><c:out value="${vo.jobNm}" /></td>
		                        	<td class="alignC"><c:out value="${vo.regionNm}" /></td>
		                          	<td class="alignC"><c:out value="${vo.zoneNm}" /></td>
		                           	<td class="alignC"><c:out value="${vo.netNm}" /></td>
		                           	<td class="alignL"><c:out value="${vo.rsrcPoolNm}" /></td>
		                           	<td class="alignL"><c:out value="${vo.servcAreaNm}"/></td>
		                           	<td class="alignL">
		                           		<a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.servcNm}" /> 상세 화면이동"><c:out value="${vo.servcNm}" /></a>
		                           	</td>
		                           	<td class="alignL"><c:out value="${vo.imgNm}"/></td>
		                           	<td class="alignR"><c:out value="${vo.lastDistrbVer}" /></td>

		                           	<td class="alignC"><c:out value="${vo.creDttm}" /></td>

		                       </tr>
						</c:forEach>
					</tbody>
				</table>
		</div>



		<div class="box-footer edit-btn-group ">
			<ul class="pagination">
				<ui:pagination paginationInfo="${atmsclDistrbVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
		</div>
	</div>
</div>


<script type="text/javascript">
	$(document).ready(function() {
/* 	var data = ${list};
	alert(data.size); */
	});

	// 페이징 이동
	function fn_goPage(page){
		location.href = "<c:url value='selectAtmsclDistrbList.do?paginationInfo.currentPageNo=" + page + "&${listParam}'/>";
	}

	// 검색조건 초기화
	function fn_reset() {
		$("#atmsclDistrbSearchVo input[type='text']").val("");
		$("#atmsclDistrbSearchVo select").val("").attr("selected", "selected");
	}

	// 배포 목록조회
	function fn_selectAtmsclDistrbList(){

		$("#atmsclDistrbSearchVo").attr('target', '_self');
		$("#atmsclDistrbSearchVo").attr("action", "<c:url value='selectAtmsclDistrbList.do'/>");
		$("#atmsclDistrbSearchVo").submit();
	}
	//엑셀 다운로드
	function fn_selectAtmsclDistrbListXlsDwnl(){
		if("${atmsclDistrbSearchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		$('#atmsclDistrbSearchVo').attr('target', '_self');
		$('#atmsclDistrbSearchVo').attr('action', '<c:url value="selectAtmsclDistrbListXlsDwnl.do"/>');
		$('#atmsclDistrbSearchVo').submit();
	}


    $("#atmsclDistrbListTable").DataTable({
        dom : 'Zlfrtip',
        paging : false,
    	searching : false,
    	info : false,
    	bAutoWidth : false,
        aoColumns : [
              {sWidth : "50px" },	// No
              {sWidth : "65px" },	// 상태
              {sWidth : "110px" }, 	// 부처
              {sWidth : "110px" }, 	// 업무
              {sWidth : "50px" }, 	// 센터
              {sWidth : "50px" },	// 존
              {sWidth : "80px" },	// 망구분
              {sWidth : "110px" },	// 자원풀
              {sWidth : "140px" },	// 서비스영역명
              {sWidth : "140px" },	// 서비스명
              {sWidth : "140px" },	// 배포이미지명
              {sWidth : "65px" },	// 버전
              {sWidth : "110px" }	// 생성일
        ],
        order : [ [ 0, "desc" ] ]
    });


</script>