<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 09. 30.
 * @lastmodified 2016. 09. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 09. 30.     이화영         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get">
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
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title"><label for="searchPrpcssNm" title="프로세스명">프로세스명</label></div>
                    <div class="cell-body">
						<div class="input-group">
							<form:input path="searchPrpcssNm" title="프로세스 명" cssClass="form-control input-sm pull-right" />
						</div>
                    </div>
				</div>
			</div>
		</div>
		<div class="box-footer collapse in search-collapse">
			<div class="pull-left">
		        <button class="btn" onclick="javascript:fn_searchAreaReset();return false;">초기화</button>
	      </div>
	      <div class="pull-right">
		  	<c:url var="selectPrcssListUrl" value="selectPrcssList.do">
			</c:url>
		    <button type="button" class="btn btn-red pull-right" onclick="fn_selectPrcssList();">조회</button>
		  </div>
		</div><!-- /box-footer -->
	</div>
	</form:form>
</div>

<div class="col-box-100 search-col">
	<div class="box list-box">

		<div class="box-header">
			<h3 class="box-title">프로세스 목록<small>
				${searchVo.paginationInfo.currentPageNo } /${searchVo.paginationInfo.totalPageCount },총 ${searchVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
	     			<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/>
	     			<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_selectPrcssListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
	  		</div><!-- /box-header -->
		</div><!-- /box-header -->

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical table-layout-fixed"  id="noticeTable">
				<caption>프로세스 목록</caption>
				<thead>
				<tr>
					<th>No.</th>
					<th>프로세스ID</th>
					<th>프로세스명</th>
					<th>설명</th>
					<th>등록자</th>
					<th>등록일자</th>
				</tr>
				</thead>

				<tbody>
					<c:forEach var="vo" items="${list }" varStatus="i">
						<c:url var="detailUrl" value="selectPrcss.do">
							<c:forEach var="curParam" items="${param }">
								<c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach>
							</c:forEach>
							<c:param name="procssSeq" value="${vo.procssSeq }" />
						</c:url>

						<tr>
							<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
							<td><a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.procssSeq}"/>"><c:out value="${vo.procssSeq}"/></a></td>
							<td class="alignL"><c:out value="${vo.procssNm}" /></td>
							<td class="alignL"><c:out value="${vo.prcssDc}" /></td>
							<td><c:out value="${vo.regUserNm}" /></td>
							<td><c:out value="${vo.regDt}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
		</div>
		<!-- /box-footer -->
	</div>
</div>

<script type="text/javascript">

//조회
function fn_selectPrcssList(){
	$('#searchVo').attr('target', '_self');
	$('#searchVo').attr('action', '<c:url var="select" value="selectPrcssList.do"/>');
	$('#searchVo').submit();
}



function goPage(page){
	location.href = "selectPrcssList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

function goToUrl(url) {
	location.href = url;
}

function fn_searchAreaReset() {
	searchPrpcssNm.value = '';
}

//목록의 정보를 Excel로 다운로드 한다.
function fn_selectPrcssListXlsDwnl() {
	if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}
	$('#searchVo').attr('target', '_self');
	$('#searchVo').attr('action', '<c:url value="selectPrcssListXlsDwnl.do"/>');
	$('#searchVo').submit();
}

$("#noticeTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	             {sWidth : "30px" },//No
	             {sWidth : "100px" },//프로세스ID
	             {sWidth : "170px" },//프로세스명
	             {sWidth : "245px" },//설명
	             {sWidth : "80px" },//등록자
	             {sWidth : "90px" }//등록일자
	],
	order : [[0, "desc"]]
} );
</script>