<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>물리스토리지목록</pre>
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 25.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 25.     김봉민         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<c:set var="listParam"	value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<!-- 검색조건 영역 -->
<div class="col-box-100 search-col">
	<div class="box box-search">
		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">검색조건</h3>
			<div class="box-tools pull-right">
				<button class="btn btn-sm" data-toggle="collapse"
					data-target=".search-collapse">
					<i class="fa fa-chevron-up" data-toggle="tooltip" title=""
						data-original-title="접어두기"></i>
				</button>
			</div>
		</div>

		<!-- box-body -->
		<form:form commandName="searchVo" method="get" id="frm" onsubmit="return checkSearchValidate();">
			<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
			<form:hidden path="srchPhyStrgId" />

			<div class="box-body collapse in search-collapse">
				<div class="form-group">
					<!-- 검색조건 : 센터 -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="regionId">센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion name="regionId" id="regionId" cssClass="form-control input-sm" title="센터" value="${searchVo.regionId}" whole="true"
							  byRole="false" onchange="selectZoneByNetClCd('regionId', 'zoneId','netClCd', 'rsrcPoolId')" />
						</div>
					</div>

					<!-- 검색조건 : 존 -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="zoneId">존</label>
						</div>
						<div class="cell-body">
							<nform:selectZone name="zoneId" id="zoneId" class="form-control input-sm"	title="존" whole="true" regionId="${searchVo.regionId}"
							value="${searchVo.zoneId}"  byRole="false" onchange="selectPoolByNetClCd('regionId', 'zoneId','netClCd', 'rsrcPoolId' , {'searchPoolTypeCd' : '02', 'byRole' : false})" />
						</div>
					</div>

					<!-- 검색조건 : 망-->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="netClCd">망구분</label>
						</div>
						<div class="cell-body">
							<nform:selectCode name="netClCd" id="netClCd" title="망" cssClass="form-control input-sm"
								whole="true"
								parentCd="NETCD"
          						parentGrpCd="067"
								zoneId="${searchVo.zoneId}"
							 	value="${searchVo.netClCd}"
							 	byRole="false"
								onchange="selectPoolByNetClCd('regionId', 'zoneId','netClCd', 'rsrcPoolId', {'searchPoolTypeCd' : '02', 'byRole' : false  } )" />
						</div>
					</div>

					<!-- 검색조건 : 자원풀 -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="rsrcPoolId">자원풀</label>
						</div>
						<div class="cell-body">
							<nform:selectPool name="rsrcPoolId" id="rsrcPoolId" title="자원풀" cssClass="form-control input-sm"
							 whole="true"
							 poolTypeCd="02"
							 regionId="${searchVo.regionId }"
							 zoneId="${searchVo.zoneId}"
							 netClCd="${searchVo.netClCd }"
							 value="${searchVo.rsrcPoolId}"/>
						</div>
					</div>
						<!-- 물리스토리지 구성ID  -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="물리스토리지구성ID" for="compId" >물리스토리지 구성ID</label>
						</div>
						<div class="cell-body">
							<form:input path="compId" class="form-control input-sm" title="물리스토리지구성ID" />
						</div>
					</div>
						<!-- 물리스토리지명  -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="물리스토리지명" for="phyStrgNm">물리스토리지명</label>
						</div>
						<div class="cell-body">
							<form:input path="phyStrgNm" class="form-control input-sm" title="물리스토리지명"  />
						</div>
					</div>
						<!-- 가상화 유형  -->
					<div class="form-cell form-cell-100 col-lay-100">
						<div class="cell-title">
							<label title="가상화SW">가상화SW</label>
						</div>
						<div class="cell-body">
							<div class="input-group input-group-check">
								<c:choose>
									<c:when test="${searchVo eq null or searchVo.vrlzSwTyCdList eq null}">
										<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
											<form:checkbox path="vrlzSwTyCdList[${i.index}]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}" checked="checked"  data-name="vrlzSwTyCdList"  />
											<label for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}" /></label>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList}" varStatus="i">
											<form:checkbox path="vrlzSwTyCdList[${i.index}]" name="searchVrlzSwTyCdList" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}"  data-name="vrlzSwTyCdList" disabled="disabled"/>
											<label for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}" /></label>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- box-footer -->
			<div class="box-footer collapse in search-collapse">
				<div class="pull-left">
					<button type="submit" class="btn" title="초기화" onclick="fn_searchAreaReset(); return false;">초기화</button>
				</div>
				<div class="pull-right">
					<button type="submit" class="btn btn-red pull-right" onclick="fn_search(); return false;" title="조회">조회</button>
				</div>
			</div>
		</form:form>
	</div>
</div>
<!-- /검색조건 영역 -->

<!-- 그리드 영역 -->
<div class="col-box-100 search-col">
	<div class="box list-box">
		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">
				검색결과<small>${searchVo.paginationInfo.currentPageNo }
					/${searchVo.paginationInfo.totalPageCount },총
					${searchVo.paginationInfo.totalRecordCount }건</small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="frm" value="${searchVo }" />
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-hover-green"
							data-toggle="tooltip" title="" data-original-title="엑셀다운로드"
							onclick="fn_goExcelDownload();">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
			<!-- /box-tools -->
		</div>
		<!-- /box-header -->

		<!-- box-body -->
		<div class="box-body no-padding list-body" >
			<table class="table table-hover table-vertical table-layout-fixed" id="pstrgTbl">
				<caption>물리스토리지 목록(센터,존,망,자원풀,분류,물리스토리지,물리스토리지구성ID, 가상화SW,
					할당량,사용량,가용량)</caption>
				<thead>
					<tr>
						<th>No.</th>
						<th>센터</th>
						<th>존</th>
						<th>망구분</th>
						<th>자원풀</th>
						<th>분류</th>
						<th>물리스토리지명</th>
						<th>물리스토리지 구성ID</th>
						<th>가상화 SW</th>
						<th>할당량(GB)</th>
						<th>사용량(GB)</th>
						<th>가용량(GB)</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list}" varStatus="i">
						<tr>
							<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
							<td class="alignC"><c:out value="${vo.regionNm}" /></td>
							<td class="alignC"><c:out value="${vo.zoneNm}" /></td>
							<td class="alignC"><c:out value="${vo.netClNm}" /></td>
							<td class="alignC"><c:out value="${vo.rsrcPoolNm}" /></td>
							<td class="alignL"><c:out value="${vo.compClNm}" /></td>
							<td class="alignL">
								<a href="#" title="<c:out value='${vo.phyStrgNm}'/>" onclick="fn_goPhyStrgDtl('<c:out value="${vo.phyStrgId}"/>' ,'<c:out value="${vo.compClCd}"/>')"><c:out value='${vo.phyStrgNm}' /></a>
							</td>
							<td class="alignL"><c:out value="${vo.compId}" /></td>
							<td class="alignL"><c:out value="${vo.vrlzSwTyNm}" /></td>
							<td class="alignR"><fmt:formatNumber value="${vo.strgAsgnCapa}" pattern="#,###.##" /></td>
							<td class="alignR"><fmt:formatNumber value="${vo.strgUsefulCapa}" pattern="#,###.##" /></td>
							<td class="alignR"><fmt:formatNumber value="${vo.strgUseCapa}" pattern="#,###.##" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- /table -->
		</div>

		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }"
					type="common" jsFunction="fn_goPage" />
			</ul>
		</div>
		<!-- /box-footer -->
	</div>
</div>
<!-- /그리드 영역 -->

<script type="text/javascript">
	//검색 조건 초기화
	function fn_searchAreaReset() {
		$('#frm input[type="text"]').val('');
		$('#frm select').val('').attr('selected', 'selected');
		$('#frm input[type="checkbox"][name="vrlzSwTyCdList"]').prop('checked','checked');
	}

	/**
	 Vaidate
	*/
	function checkSearchValidate(){
		return true;
	}

	/**
	 * 검색
	 */
	function fn_search() {
		$("#frm").attr("action", "selectPhystrgList.do");
		$("#frm").submit();
	}

	/**
	 *엑셀 다운로드
	 */
	function fn_goExcelDownload() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}

		$('#frm').attr('action', 'selectPhystrgListXlsDwnl.do');
		$('#frm').submit();
	}

	/**
	 *	페이징 이동
	 */
	function fn_goPage(page) {
		location.href = "selectPhystrgList.do?paginationInfo.currentPageNo="
				+ page + "&${listParam}";
	}

	/**
	 * 상세 이동
	 */
	function fn_goPhyStrgDtl(phyStrgId, compClCd) {
		var url = "formPhystrgDtlSan.do";
		if (compClCd == '01') {
			//jAlert("SAN - 인터페이스 정의가 확실하게 되어 있지 않습니다.");
			url = "formPhystrgDtlSan.do";
		//}else if (compClCd == '02') { //NAS
		//	jAlert("NAS - 인터페이스 정의가 확실하게 되어 있지 않습니다.");
		//	url = "formPhystrgDtlNas.do";
		//} else if (compClCd == '03') { //DFS
		//	jAlert("DFS - 인터페이스 정의가 확실하게 되어 있지 않습니다.");
		//	url = "formPhystrgDtlDfs.do";
		}else {
			//jAlert("정의되지 않음 물리스토리지입니다. - 물리스토리지-가상스토리지 목록으로 이동합니다.");d
		}

		$("#frm").attr("target", "_self");
		$("#frm #srchPhyStrgId").val(phyStrgId);
		$("#frm").attr("action", "<c:url value='"+url+"'/>");
		$("#frm").submit();
		return false;
	}

	$("#pstrgTbl").DataTable({
		dom : 'Zlfrtip',
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [	{sWidth : "60px" },		//No
		                {sWidth : "60px" },		//센터
		                {sWidth : "60px" },		//존
		                {sWidth : "60px" },		//망
		                {sWidth : "80px" },		//자원풀
		                {sWidth : "60px" },		//뷴류
		                {sWidth : "150px" },		//물리스토리지 명
		                {sWidth : "150px" },	//물리스토리지 구성ID
		                {sWidth : "80px" },		//가상화 Sw
		                {sWidth : "100px" },	//할당량
		                {sWidth : "100px" },	//사용량
		                {sWidth : "100px" },	//가용량
		 ],
		order : [ [ 0, "desc" ] ]
	});


</script>

