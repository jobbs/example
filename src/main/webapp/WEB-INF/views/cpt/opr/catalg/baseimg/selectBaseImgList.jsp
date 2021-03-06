<%--
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 05. 19.
 * @lastmodified 2017. 05. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 05. 19.     x          v1.0             최초생성
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
							<label title="센터" for="regionId">센터</label>
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
					          onchange="selectZoneByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'byRole' : false, 'searchSwTypeCd' : 'ATMSCL','searchPoolTypeCd':'05'})" />
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
					          onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'byRole' : false, 'searchSwTypeCd' : 'ATMSCL','searchPoolTypeCd':'05'})" />
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
					          wholeText="전체"
					          extra1=""
					          extra2=""
					          extra3=""
					          value="${searchVo.netClCd}"
					          extra4=""
					          extra5=""
					          cssClass="form-control input-sm"
					          onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'searchCtlTrgtYn' : '','byRole' : false, 'searchSwTypeCd' : 'ATMSCL','searchPoolTypeCd':'05'})"  />
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
			                <label title="이미지유형" for=imgTyCd>이미지유형</label>
			            </div>
			            <div class="cell-body">
			                <nform:selectCode
			                            parentCd="300"
			                            parentGrpCd="099"
			                            name="imgTyCd"
			                            id="imgTyCd"
			                            whole="true"
			                            cssClass="form-control input-sm"
			                            value="${searchVo.imgTyCd}"  />
			            </div>
			        </div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="imgNm">이미지명</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:input path="imgNm" type="text" class="form-control input-sm pull-right" maxlength="60" title="이미지명" />
							</div>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
						  <label for="useYn">사용여부</label>
						</div>
						<div class="cell-body">
							<form:select path="useYn" cssClass="form-control input-sm">
								<form:option value="">전체</form:option>
								<form:option value="Y">사용</form:option>
								<form:option value="N">미사용</form:option>
							</form:select>
						</div>
			        </div>
				</div>
			</div>

			<div class="box-footer collapse in search-collapse">
				<div class="pull-left">
					<button type="button" class="btn" onClick="fn_reset();" title="검색조건 초기화">초기화</button>
				</div>
				<div class="pull-right">
					<button type="button" class="btn btn-red" onClick="fn_selectBaseImgList();" title="조회">조회</button>
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
				<table class="table table-hover table-vertical table-layout-fixed" id="baseImgTable">
					<caption>베이스 이미지 목록 테이블</caption>
					<thead>
						<tr>
							<th>No.</th>
							<th>사용여부</th>
							<th>센터</th>
							<th>존</th>
							<th>망구분</th>
							<th>자원풀</th>
							<th>이미지유형</th>
							<th>이미지명</th>
							<th>용량(GB)</th>
							<th>생성자</th>
							<th>생성일시</th>
							<th>수정자</th>
							<th>수정일시</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${list eq null or empty list }">
							</c:when>
							<c:otherwise>
								<c:forEach var="baseImgVo" items="${list }" varStatus="i">
									<c:url var="detailUrl" value="selectBaseImg.do">
										<c:forEach var="curParam" items="${param }">
											<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
										</c:forEach>
										<c:param name="baseImgRsrcPoolId" value="${baseImgVo.rsrcPoolId }" />
										<c:param name="imgId" value="${baseImgVo.imgId }" />
										<c:param name="servcAreaSeq" value="${baseImgVo.servcAreaSeq }" />
									</c:url>
									<tr>
										<td class="alignC"><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
										<td>
											<c:choose>
												<c:when test = "${ baseImgVo.useYn eq 'Y' }">
													<span class="status status-green">사용</span>
												</c:when>
												<c:otherwise>
													<span class="status status-gray">미사용</span>
												</c:otherwise>
											</c:choose>
										</td>
										<td class="alignL"><c:out value="${baseImgVo.regionNm}" /></td>
										<td class="alignL"><c:out value="${baseImgVo.zoneNm}" /></td>
										<td class="alignL"><c:out value="${baseImgVo.netNm}" /></td>
										<td class="alignL"><c:out value="${baseImgVo.rsrcPoolNm}" /></td>
										<td class="alignL"><c:out value="${baseImgVo.imgTyCdNm }" /></td>
										<td class="alignL"><a href="<c:url value="${detailUrl }" />" title="<c:out value="${baseImgVo.imgNm}"/> 상세 화면이동"><c:out value="${baseImgVo.imgNm }" /></a></td>
										<td class="alignR"><c:out value="${baseImgVo.imgCapa }" /></td>
										<td><c:out value="${baseImgVo.creUserNm }" /></td>
										<td><c:out value="${baseImgVo.creDttm }" /></td>
										<td><c:out value="${baseImgVo.updtUserNm }" /></td>
										<td><c:out value="${baseImgVo.updtDttm }" /></td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
		</div>
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
		</div>
	</div>
</div>
<script type="text/javascript">

	// 페이징 이동
	function fn_goPage(page){
		location.href = "<c:url value='selectBaseImgList.do?paginationInfo.currentPageNo=" + page + "&${listParam}'/>";
	}

	// 검색조건 초기화
	function fn_reset() {
		$("#searchVo input[type='text']").val("");
		$("#searchVo select").val("").attr("selected","selected");
	}

	function fn_selectBaseImgList(){

		$("#searchVo").attr("action", "selectBaseImgList.do");
		$("#searchVo").submit();
	}

	// 엑셀 다운로드
	function fn_downloadExcel() {
		if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("다운로드할 데이터가 없습니다");
			return;
		}

		$("#searchVo").attr("action", "selectBaseImgListXlsDwnl.do");
		$("#searchVo").submit();
	}

	// 리스트 테이블 정렬
	$("#baseImgTable").DataTable( {
		dom: 'Zlfrtip' ,
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [
					{sWidth : "30px" },
					{sWidth : "70px" },
					{sWidth : "40px" },
		      		{sWidth : "60px" },
		      		{sWidth : "60px" },
		      		{sWidth : "80px" },
					{sWidth : "100px" },
					{sWidth : "170px" },
					{sWidth : "60px" },
					{sWidth : "50px" },
					{sWidth : "80px" },
					{sWidth : "50px" },
					{sWidth : "80px" }
					],
		order : [ [ 0, "desc" ] ]
	} );
</script>
