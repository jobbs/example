<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     신재훈         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<c:url var="selectUrl" value="/cpt/rsrc/strg/vrStrg/selectVrStrgList.do"></c:url>
<c:set var="listParam"	value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<!-- 검색조건 영역 -->
<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
		<div class="box box-search">
			<!-- box-header -->
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<!-- 접기 버튼 -->
					<button type="button" class="btn btn-sm" data-toggle="collapse"
						data-target=".search-collapse">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
					</button>
				</div>
			</div>
			<!-- box-body -->
			<div class="box-body collapse in search-collapse">
				<div class="form-group">
					<!-- 검색조건 : 센터 -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchRegionId">센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion name="searchRegionId" id="searchRegionId" cssClass="form-control input-sm" title="센터"
							value="${searchVo.searchRegionId}" whole="true"  byRole="false" onchange="selectZoneByNetClCd('searchRegionId', 'searchZoneId','searchNetClCd', 'searchRsrcPoolId')" />
						</div>
					</div>

					<!-- 검색조건 : 존 -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchZoneId">존</label>
						</div>
						<div class="cell-body">
							<nform:selectZone name="searchZoneId" id="searchZoneId" class="form-control input-sm" title="존" whole="true"
							regionId="${searchVo.searchRegionId}" value="${searchVo.searchZoneId}"  byRole="false"
							onchange="selectPoolByNetClCd('searchRegionId', 'searchZoneId','searchNetClCd', 'searchRsrcPoolId' , {'searchPoolTypeCd' : '01', 'byRole' : false})" />
						</div>
					</div>

					<!-- 검색조건 : 망-->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchNetClCd">망구분</label>
						</div>
						<div class="cell-body">
							<nform:selectCode name="searchNetClCd" id="searchNetClCd" title="망구분" cssClass="form-control input-sm"
								whole="true"
								parentCd="NETCD"
          						parentGrpCd="067"
								zoneId="${searchVo.searchZoneId}"
							 	value="${searchVo.searchNetClCd}"
							 	byRole="false"
								onchange="selectPoolByNetClCd('searchRegionId', 'searchZoneId','searchNetClCd', 'searchRsrcPoolId', {'searchPoolTypeCd' : '01', 'byRole' : false  } )" />
						</div>
					</div>

					<!-- 검색조건 : 자원풀 -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchRsrcPoolId">자원풀</label>
						</div>
						<div class="cell-body">
							<nform:selectPool name="searchRsrcPoolId" id="searchRsrcPoolId" title="자원풀" cssClass="form-control input-sm"
								whole="true"
								poolTypeCd="01"
								regionId="${searchVo.searchRegionId }"
								zoneId="${searchVo.searchZoneId}"
								netClCd="${searchVo.searchNetClCd }"
								value="${searchVo.searchRsrcPoolId}"/>
						</div>
					</div>
					<!-- 검색조건 : checkbox -->
					<div class="form-cell form-cell-100 col-lay-100">
						<div class="cell-title">
							<label for="searchVrlzSwTyCdList">가상화SW</label>
						</div>
						<div class="cell-body">
							<div class="input-group input-group-check">
							<c:choose>
								<c:when test="${searchVo eq null or searchVo.searchVrlzSwTyCdList eq null }">
									<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
										<form:checkbox path="searchVrlzSwTyCdList[${i.index }]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}" checked="checked"/>
										<label for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
										<form:checkbox path="searchVrlzSwTyCdList[${i.index }]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}"/>
										<label for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
									</c:forEach>
								</c:otherwise>
							</c:choose>
							</div>
						</div>
					</div>
					<!-- 검색조건 종료  -->
				</div>
				<!-- box-footer -->
				<div class="box-footer collapse in search-collapse">
					<div class="pull-left">
						<button type="reset" class="btn" onclick="fn_initComponent('searchVo')" title="초기화">초기화</button>
					</div>
					<div class="pull-right">
						<button type="button" class="btn btn-red pull-right" onclick="fn_selectVrStrgRsrcPoolList()" title="조회">조회</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</div>

<!-- 스토리지 도메인 목록 테이블 -->
<div class="col-box-100 search-col">
	<form id="rsrcPoolFrm" name="rsrcPoolFrm">
	<div class="box list-box">
		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">
				가상스토리지 검색결과<small> ${searchVo.paginationInfo.currentPageNo }
					/ ${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo}" />
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" onclick="fn_selectVrStrgRsrcPoolListXlsDwnl()" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" data-placement="left">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /box-header -->
		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical" id="rsrcPoolListTable">
			<caption>자원풀목록 (센터, 존, 망구분, 자원풀, 가상화SW, 자원풀(GB)((총할당량(A), 총사용량(B), 총VM할당량(C), 총템플릿할당량(D), 총VM가용여유량(E = A - C - D)), 스토리지도메인명, 가상스토리지도메인용량(GB)(할당량(A), 사용량(B), VM할당량(C), 템플릿할당량(D), VM가용여유량(E = A - C - D)))</caption>
				<colgroup>
					<col class="col3">
					<col class="col3">
					<col class="col3">
					<col class="col4">
					<col class="col10">
					<col class="col5">
					<col class="col5">
					<col class="col5">
					<col class="col5">
					<col class="col5">
					<col class="col5">
					<col class="col5">
					<col class="col9">
					<col class="col5">
					<col class="col5">
					<col class="col5">
					<col class="col5">
					<col class="col5">
					<col class="col5">
				</colgroup>
				<thead>
					<tr>
						<th rowspan="2">No</th>
						<th rowspan="2">센터</th>
						<th rowspan="2">존</th>
						<th rowspan="2">망구분</th>
						<th rowspan="2">자원풀</th>
						<th rowspan="2">가상화SW</th>
						<th colspan="6">자원풀(GB)</th>
						<th colspan="7">가상스토리지(GB)</th>
					</tr>
					<tr>
						<th>총 할당량(A)</th>
						<th>총 사용량(B)</th>
						<th>총 VM할당량(C)</th>
						<th>총 템플릿할당량(D)</th>
						<th>VM스냅샷할당량(E)</th>
						<th>총 VM가용여유량(F)<br>(F = A - C - D - E)</th>
						<th>스토리지도메인명</th>
						<th>할당량(G)</th>
						<th>사용량(H)</th>
						<th>VM할당량(I)</th>
						<th>템플릿할당량(J)</th>
						<th>VM스냅샷할당량(K)</th>
						<th>VM가용여유량(L)<br>(L = G - I - J - K)</th>
					</tr>
				</thead>
				<tbody>
				<c:choose>
		        	<c:when test="${rsrcPoolVrStrgList eq null or empty rsrcPoolVrStrgList }">
						<tr>
							<td colspan="18">검색된 데이터가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:set var="tempRsrcPoolId" value=""/>
						<c:forEach var="vo" items="${rsrcPoolVrStrgList }" varStatus="i">
						<c:url var="detailUrl" value="selectVrStrg.do">
							<c:forEach var="curParam" items="${param }">
								<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
							</c:forEach>
							<c:param name="searchStrgDmnSeq" value="${vo.strgDmnSeq }" />
						</c:url>
						<tr>
							<c:if test="${tempRsrcPoolId != vo.rsrcPoolId }">
	          					<c:set var="tempRsrcPoolId" value="${vo.rsrcPoolId }"/>
	          					<td rowspan="${vo.cnt}"><c:out value="${(searchVo.paginationInfo.totalRecordCount-vo.rnk)+1}" /></td>
								<td rowspan="${vo.cnt}" class="alignL"><c:out value="${vo.regionNm }"/></td>
								<td rowspan="${vo.cnt}" class="alignL"><c:out value="${vo.zoneNm }"/></td>
								<td rowspan="${vo.cnt}" class="alignL"><c:out value="${vo.netNm }"/></td>
								<td rowspan="${vo.cnt}" class="alignL"><c:out value="${vo.rsrcPoolNm }"/></td>
								<td rowspan="${vo.cnt}" class="alignL"><c:out value="${vo.vrlzSwTyCdNm }"/></td>
								<td rowspan="${vo.cnt}" class="alignR" ><fmt:formatNumber pattern="#,###.###" value="${vo.sumWholeAsgnCapa }" /></td>
								<td rowspan="${vo.cnt}" class="alignR" ><fmt:formatNumber pattern="#,###.###" value="${vo.sumStrgUseCapa }" /></td>
								<td rowspan="${vo.cnt}" class="alignR" ><fmt:formatNumber pattern="#,###.###" value="${vo.sumVmAsgnCapa }" /></td>
								<td rowspan="${vo.cnt}" class="alignR" ><fmt:formatNumber pattern="#,###.###" value="${vo.sumTmplatAsgnCapa }" /></td>
								<td rowspan="${vo.cnt}" class="alignR" ><fmt:formatNumber pattern="#,###.###" value="${vo.sumVmSnapshtAsgnCapa }" /></td>
								<td rowspan="${vo.cnt}" class="alignR" >
									<fmt:formatNumber pattern="#,###.###" value="${(vo.sumWholeAsgnCapa - vo.sumVmAsgnCapa - vo.sumTmplatAsgnCapa - vo.sumVmSnapshtAsgnCapa)}" />
								</td>
	       					</c:if>
							<td class="alignL">
								<a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.strgDmnNm}"/>"><c:out value="${cf:ellipsis(vo.strgDmnNm, 60) }" /></a>
							</td>
							<td rowspan="1" class="alignR"><fmt:formatNumber pattern="#,###.###" value="${vo.wholeAsgnCapa }" /></td>
							<td rowspan="1" class="alignR"><fmt:formatNumber pattern="#,###.###" value="${vo.strgUseCapa }" /></td>
							<td rowspan="1" class="alignR"><fmt:formatNumber pattern="#,###.###" value="${vo.vmAsgnCapaSingle }" /></td>
							<td rowspan="1" class="alignR"><fmt:formatNumber pattern="#,###.###" value="${vo.tmplatAsgnCapa }" /></td>
							<td rowspan="1" class="alignR"><fmt:formatNumber pattern="#,###.###" value="${vo.vmSnapshtAsgnCapaSingle }" /></td>
							<td rowspan="1" class="alignR">
								<fmt:formatNumber pattern="#,###.###" value="${(vo.wholeAsgnCapa - vo.vmAsgnCapaSingle - vo.tmplatAsgnCapa - vo.vmSnapshtAsgnCapaSingle)}" />
							</td>
						</tr>
						</c:forEach>
					</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }"	type="common" jsFunction="fn_goPage" />
			</ul>
			<c:url var="listUrl" value="selectVrStrgRsrcPoolList.do">
				<c:forEach var="curParam" items="${param }">
					<c:if test="${curParam.key ne 'rsrcPoolId'}">
						<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
					</c:if>
				</c:forEach>
			</c:url>
			<div class="pull-right btns">
			</div>
		</div>
		<!-- /box-footer -->
	</div>
	</form>
</div>
<!-- box-footer -->
<div class="box-footer clearfix">
</div>
<!-- /box-footer -->

<script type="text/javascript">
// 초기화
function fn_initComponent(){
	$('#searchVo select').val('').attr('selected', 'selected');
	$('#searchVo input[type="checkbox"][name="searchVrlzSwTyCdList"]').prop('checked', 'checked');
}

function fn_goPage(page){
	location.href = "selectVrStrgRsrcPoolList.do?paginationInfo.currentPageNo="+ page + "&${listParam}";
}

// 조회
function fn_selectVrStrgRsrcPoolList(){
	$('#searchVo').attr('action', '<c:url var="select" value="selectVrStrgRsrcPoolList.do"/>');
	$('#searchVo').submit();
}

// 자원풀 엑셀다운로드
function fn_selectVrStrgRsrcPoolListXlsDwnl(){
	if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("다운로드 할 데이터가 없습니다");
		return;
	}

	$("#searchVo").attr("action", '<c:url value="selectVrStrgRsrcPoolListXlsDwnl.do"/>');
	$("#searchVo").submit();
}

</script>