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
	<form:form commandName="preDistrbSearchVo" method="GET">
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
							<nform:selectRegion name="regionId" id="regionId" cssClass="form-control input-sm" title="센터" value="${preDistrbSearchVo.regionId}" whole="true"
							  byRole="false" onchange="selectZoneByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'byRole' : false})" />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="존" for="zoneId">존</label>
						</div>
						<div class="cell-body">
							<nform:selectZone name="zoneId" id="zoneId" class="form-control input-sm"	title="존" whole="true" regionId="${preDistrbSearchVo.regionId}"
							value="${preDistrbSearchVo.zoneId}"  byRole="false" onchange="selectPoolByNetClCd('regionId', 'zoneId','netClCd', 'rsrcPoolId' , {'searchPoolTypeCd' : '05', 'byRole' : false})" />
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
								zoneId="${preDistrbSearchVo.zoneId}"
							 	value="${preDistrbSearchVo.netClCd}"
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
						          regionId="${preDistrbSearchVo.regionId }"
						          zoneId="${preDistrbSearchVo.zoneId}"
						          netClCd="${preDistrbSearchVo.netClCd }"
						          value="${preDistrbSearchVo.rsrcPoolId}"
						          ctlTrgtYn=""/>
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="institutionNm">부처</label>
						</div>
						<div class="cell-body">
							<form:input path="institutionNm" title="부처" cssClass="form-control input-sm" value="" />
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="jobNm">업무</label>
						</div>
						<div class="cell-body">
							<form:input path="jobNm" title="업무"  cssClass="form-control input-sm" value=""/>
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="imgNm">이미지명</label>
						</div>
						<div class="cell-body">
							<form:input path="imgNm" title="이미지명"  cssClass="form-control input-sm" value=""/>
						</div>
					</div>

				</div>
			</div>


				<div class="box-footer collapse in search-collapse">
					<div class="pull-left">
						<button type="button" class="btn" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
					</div>
					<div class="pull-right">
						<c:url var="selectPreDistrbListUrl" value="selectPreDistrbList.do"></c:url>
						<button type="button" class="btn btn-red" onclick="fn_selectPreDistrbList();" title="조회">조회</button>
					</div>
				</div>

			</div>

	</form:form>
</div>


<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">검색결과<small>
				${preDistrbVo.paginationInfo.currentPageNo } /
				${preDistrbVo.paginationInfo.totalPageCount },
				총 ${preDistrbVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="preDistrbSearchVo" value="${preDistrbSearchVo}"/>
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="엑셀다운로드" data-original-title="엑셀다운로드" onclick="fn_selectPreDistrbListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">

				<table class="table table-hover table-vertical table-layout-fixed" id="preDistrbListTable">
					<caption>사전 배포 목록 테이블</caption>

						<thead>
					<tr>
						<th>No.</th>
						<th>상태</th>
						<th>부처</th>
						<th>업무</th>
						<th>센터</th>
						<th>존</th>
						<th>망</th>
						<th>자원풀</th>
						<th>서비스영역명</th>
						<th>서비스명</th>
						<th>이미지명</th>
						<th>등록자</th>
						<th>등록일시</th>

                    </tr>
				</thead>
					<tbody>

						<c:forEach var="vo" items="${list}" varStatus="i">
							<tr>
								<c:url var="detailUrl" value="selectPreDistrb.do">
									<c:forEach var="curParam" items="${param }">
										<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
									</c:forEach>
									<c:param name="preDistrbReqSeq" value="${vo.preDistrbReqSeq }" />
									<c:param name="servcAreaSeq" value="${vo.servcAreaSeq }" />
								</c:url>
									<td class="alignC"><c:out value="${(preDistrbVo.paginationInfo.totalRecordCount-preDistrbVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
									<td class="alignC">
										 <c:choose>
											<c:when test="${vo.distrbStatCd eq '01'}">
												<span title="${vo.distrbStatNm }" class="status status-blue"><c:out value="${vo.distrbStatNm }"/></span>
											</c:when>
											<c:when test="${vo.distrbStatCd eq '02'}">
												<span title="${vo.distrbStatNm }" class="status status-green"><c:out value="${vo.distrbStatNm }"/></span>
											</c:when>
											<c:when test="${vo.distrbStatCd eq '03'}">
												<span title="${vo.distrbStatNm }" class="status status-red"><c:out value="${vo.distrbStatNm }"/></span>
											</c:when>
											<c:when test="${vo.distrbStatCd eq '04'}">
												<span title="${vo.distrbStatNm }" class="status status-yellow"><c:out value="${vo.distrbStatNm }"/></span>
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
		                           		<a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.servcAreaNm}" /> 상세 화면이동"><c:out value="${vo.servcAreaNm}" /></a>
		                           	</td>
		                           	<td class="alignL">
		                       	    	<a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.servcNm}" /> 상세 화면이동"><c:out value="${vo.servcNm}" /></a>
		                           	</td>
		                           	<td class="alignL">
		                           		<a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.imgNm}" /> 상세 화면이동"><c:out value="${vo.imgNm}" /></a>
		                           	</td>
		                           	<td class="alignL"><c:out value="${vo.creUserNm}"/></td>
		                           	<td class="alignC"><c:out value="${vo.distrbReqDttm}" /></td>

		                       </tr>
						</c:forEach>
					</tbody>
				</table>

		</div>



		<div class="box-footer edit-btn-group ">
			<ul class="pagination">
				<ui:pagination paginationInfo="${preDistrbVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize onlyOprChr="true">
				<c:url var="insertUrl" value="insertPreDistrbView.do">
                        <c:forEach var="curParam" items="${param }">
                            <c:param name="${curParam.key }" value="${curParam.value }"></c:param>
                        </c:forEach>
                    </c:url>
					<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가" onclick="goToUrl('${insertUrl}')"><i class="fa fa-plus"></i></button>
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
		location.href = "<c:url value='selectPreDistrbList.do?paginationInfo.currentPageNo=" + page + "&${listParam}'/>";
	}

	// 검색조건 초기화
	function fn_reset() {
		$("#preDistrbSearchVo input[type='text']").val("");
		$("#preDistrbSearchVo select").val("").attr("selected", "selected");
	}

	// 사전배포 목록조회
	function fn_selectPreDistrbList(){

		$("#preDistrbSearchVo").attr('target', '_self');
		$("#preDistrbSearchVo").attr("action", "<c:url value='selectPreDistrbList.do'/>");
		$("#preDistrbSearchVo").submit();
	}
	//엑셀 다운로드
	function fn_selectPreDistrbListXlsDwnl(){
		if("${preDistrbSearchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		$('#preDistrbSearchVo').attr('target', '_self');
		$('#preDistrbSearchVo').attr('action', '<c:url value="selectPreDistrbListXlsDwnl.do"/>');
		$('#preDistrbSearchVo').submit();
	}



    $("#preDistrbListTable").DataTable({
    	dom : 'Zlfrtip',
        paging : false,
        searching : false,
        info : false,
        aoColumns : [
              {sWidth : "30px" },
              {sWidth : "60px" },
              {sWidth : "110px" },
              {sWidth : "110px" },
              {sWidth : "40px" },
              {sWidth : "40px" },
              {sWidth : "60px" },
              {sWidth : "80px" },
              {sWidth : "110px" },
              {sWidth : "110px" },
              {sWidth : "200px" },
              {sWidth : "60px" },
              {sWidth : "140px" }
        ],
        order : [ [ 0, "desc" ] ]
    });


</script>