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
	<form:form commandName="bldSearchVo" method="GET">
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
					<nform:selectRegion name="regionId" id="regionId" cssClass="form-control input-sm" title="센터" value="${bldVo.regionId}" whole="true"
							  byRole="false" onchange="selectZoneByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'byRole' : false})" />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="존" for="zoneId">존</label>
						</div>
						<div class="cell-body">
						<nform:selectZone name="zoneId" id="zoneId" class="form-control input-sm"	title="존" whole="true" regionId="${bldVo.regionId}"
							value="${bldVo.zoneId}"  byRole="false" onchange="selectPoolByNetClCd('regionId', 'zoneId','netClCd', 'rsrcPoolId' , {'searchPoolTypeCd' : '05', 'byRole' : false})" />
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
								zoneId="${bldVo.zoneId}"
							 	value="${bldVo.netClCd}"
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
						          regionId="${bldVo.regionId }"
						          zoneId="${bldVo.zoneId}"
						          netClCd="${bldVo.netClCd }"
						          value="${bldVo.rsrcPoolId}"
						          ctlTrgtYn=""/>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="부처" for="institutionNm">부처</label>
						</div>
						<div class="cell-body">
								<form:input path="institutionNm" title="부처" cssClass="form-control input-sm" value=""  />
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
							<label for="lastBldVer">빌드버전</label>
						</div>
						<div class="cell-body">
							<form:input path="lastBldVer" title="빌드버전"  cssClass="form-control input-sm" value="" />
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="bldStatCd">빌드상태</label>
						</div>
						<div class="cell-body">

								<form:select path="bldStatCd"  class="form-control input-sm" title="빌드상태" >
									<form:option value="">전체</form:option>
									<c:forEach var="cdList" items="${selectCodeList}">
										<form:option value="${cdList.cd }">${cdList.cdNm }</form:option>
									</c:forEach>
								</form:select>

						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-50">
						<div class="cell-title">
							<label for="servcNm">서비스명</label>
						</div>
						<div class="cell-body">
							<form:input path="servcNm" title="서비스명"  cssClass="form-control input-sm pull-right" value="" />
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-50">
						<div class="cell-title">
							<label for="creImgNm">빌드이미지명</label>
						</div>
						<div class="cell-body">
							<form:input path="creImgNm" title="빌드이미지명" cssClass="form-control input-sm" value="" />
						</div>
					</div>
				</div>
			</div>


				<div class="box-footer collapse in search-collapse">
					<div class="pull-left">
						<button type="button" class="btn" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
					</div>
					<div class="pull-right">
						<c:url var="selectBldListUrl" value="selectBldList.do"></c:url>
						<button type="button" class="btn btn-red" onclick="fn_selectBldList();" title="조회">조회</button>
					</div>
				</div>

			</div>

	</form:form>
</div>


<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">검색결과<small>
				${bldVo.paginationInfo.currentPageNo } /
				${bldVo.paginationInfo.totalPageCount },
				총 ${bldVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="bldSearchVo" value="${bldSearchVo }"/>
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="엑셀다운로드" data-original-title="엑셀다운로드" onclick="fn_selectBldListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">

				<table class="table table-hover table-vertical table-layout-fixed" id="bldListTable">
					<caption>빌드 목록 테이블</caption>

                    <thead>
						<tr>
							<th>No.</th>
							<th>빌드상태</th>
							<th>부처</th>
							<th>업무</th>
							<th>센터</th>
							<th>존</th>
							<th>망구분</th>
							<th>자원풀</th>
							<th>서비스명</th>
							<th>빌드이미지명</th>
							<th>빌드버전</th>
							<th>생성일</th>
                    	</tr>
					</thead>

					<tbody>
						<c:forEach var="vo" items="${list}" varStatus="i">
							<tr>
								<c:url var="detailUrl" value="selectDetailBld.do">
									<c:param name="servcSeq" value="${vo.servcSeq }" />
									<c:param name="servcAreaSeq" value="${vo.servcAreaSeq }" />
									<c:param name="bldId" value="${vo.bldId }" />
									<c:forEach var="curParam" items="${param }">
										<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
									</c:forEach>
								</c:url>
									<td class="alignC"><c:out value="${(bldVo.paginationInfo.totalRecordCount-bldVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
									<td class="alignC">
									<c:choose>
										<c:when test='${"01" eq vo.bldStatCd}'>
											<span title="${vo.bldStatNm }" class="status status-blue"><c:out value="${vo.bldStatNm}"/></span>
										</c:when>
										<c:when test='${"02" eq vo.bldStatCd}'>
											<span title="${vo.bldStatNm }" class="status status-green"><c:out value="${vo.bldStatNm}"/></span>
										</c:when>
										<c:when test='${"03" eq vo.bldStatCd}'>
											<span title="${vo.bldStatNm }" class="status status-red"><c:out value="${vo.bldStatNm}"/></span>
										</c:when>
										<c:when test='${"04" eq vo.bldStatCd}'>
											<span title="${vo.bldStatNm }" class="status status-aqua"><c:out value="${vo.bldStatNm}"/></span>
										</c:when>
										<c:when test='${"05" eq vo.bldStatCd}'>
											<span title="${vo.bldStatNm }" class="status status-aqua"><c:out value="${vo.bldStatNm}"/></span>
										</c:when>
										<c:when test='${"06" eq vo.bldStatCd}'>
											<span title="${vo.bldStatNm }" class="status status-aqua"><c:out value="${vo.bldStatNm}"/></span>
										</c:when>
										<c:when test='${"07" eq vo.bldStatCd}'>
											<span title="${vo.bldStatNm }" class="status status-red"><c:out value="${vo.bldStatNm}"/></span>
										</c:when>
										<c:when test='${"08" eq vo.bldStatCd}'>
											<span title="${vo.bldStatNm }" class="status status-aqua"><c:out value="${vo.bldStatNm}"/></span>
										</c:when>
										<c:otherwise></c:otherwise>
										</c:choose>
		                           	</td>

									<td class="alignL"><c:out value="${vo.institutionNm}" /></td>
									<td class="alignL"><c:out value="${vo.jobNm}" /></td>
		                        	<td class="alignC"><c:out value="${vo.regionNm}" /></td>
		                          	<td class="alignC"><c:out value="${vo.zoneNm}" /></td>
		                           	<td class="alignC"><c:out value="${vo.netNm}" /></td>
		                           	<td class="alignL"><c:out value="${vo.rsrcPoolNm}" /></td>
		                           	<td class="alignL">
		                           		<a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.creImgNm}" /> 상세 화면이동"><c:out value="${vo.servcNm}"/></a>
		                           	</td>
		                           	<td class="alignL">
		                           		<a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.creImgNm}" /> 상세 화면이동"><c:out value="${vo.creImgNm}" /></a>
		                           	</td>
		                           	<td class="alignR"><c:out value="${vo.lastBldVer}" /></td>
		                           	<td class="alignC"><c:out value="${vo.creDttm}" /></td>

		                       </tr>
						</c:forEach>
					</tbody>
				</table>

		</div>



		<div class="box-footer edit-btn-group ">
			<ul class="pagination">
				<ui:pagination paginationInfo="${bldVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
		</div>
	</div>
</div>


<script type="text/javascript">
	$(document).ready(function() {

	});

	// 페이징 이동
	function fn_goPage(page){
		location.href = "<c:url value='selectBldList.do?paginationInfo.currentPageNo=" + page + "&${listParam}'/>";
	}

	// 검색조건 초기화
	function fn_reset() {
		$("#bldSearchVo input[type='text']").val("");
		$("#bldSearchVo select").val("").attr("selected", "selected");
	}

	// 서비스영역 목록조회
	function fn_selectBldList(){

		$("#bldSearchVo").attr('target', '_self');
		$("#bldSearchVo").attr("action", "<c:url value='selectBldList.do'/>");
		$("#bldSearchVo").submit();
	}

	// 목록의 정보를 Excel로 다운로드 한다.
	function fn_selectBldListXlsDwnl() {
		if("${bldSearchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		$('#bldSearchVo').attr('target', '_self');
		$('#bldSearchVo').attr('action', '<c:url value="selectBldListXlsDwnl.do"/>');
		$('#bldSearchVo').submit();

	}


    $("#bldListTable").DataTable({
        dom : 'Zlfrtip',
        paging : false,
    	searching : false,
    	info : false,
    	bAutoWidth : false,
        aoColumns : [
              {sWidth : "50px" }, 	// No
              {sWidth : "65px" }, 	// 상태
              {sWidth : "110px" }, 	// 부처
              {sWidth : "110px" }, 	// 업무
              {sWidth : "50px" }, 	// 센터
              {sWidth : "50px" },	// 존
              {sWidth : "80px" },	// 망구분
              {sWidth : "110px" },	// 자원풀
              {sWidth : "140px" },	// 서비스명
              {sWidth : "140px" },	// 빌드이미지명
              {sWidth : "65px" }, 	// 버전
              {sWidth : "110px" }	// 생성일
        ],
        order : [ [ 0, "desc" ] ]
    });


</script>