<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 29.
 * @lastmodified 2016. 10. 29.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 29.     신재훈         v1.0             최초생성
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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100">
	<!-- 검색조건 영역 -->
	<div class="box-search">
		<!-- box-header -->
		<form:form commandName="lunSearchVo" method="get">
			<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
			<form:hidden path="selectStrgDmnSeq" value="${selectStrgDmnSeq}"/>
			<div class="box-body">
				<div class="form-group">
					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchClstrCompId">클러스터구성ID</label>
						</div>
						<div class="cell-body">
							<form:input path="searchClstrCompId" cssClass="form-control input-sm" value="" title="클러스터구성ID"/>
						</div>
					</div>

					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchClstrNm">클러스터명</label>
						</div>
						<div class="cell-body">
							<form:input path="searchClstrNm" cssClass="form-control input-sm" value="" title="클러스터명"/>
						</div>
					</div>

					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchPmCompId">물리서버구성ID</label>
						</div>
						<div class="cell-body">
							<form:input path="searchPmCompId" cssClass="form-control input-sm" value="" title="물리서버구성ID"/>
						</div>
					</div>

					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchPmNm">물리서버명</label>
						</div>
						<div class="cell-body">
							<form:input path="searchPmNm" cssClass="form-control input-sm" value="" title="물리서버명"/>
						</div>
					</div>
					<!--  검색조건 완료 -->
					<div class="form-cell form-cell-100 alignR pad-top-5">
						<button class="btn btn-red btn-sm" type="button" onclick="fn_searchLunList()" title="조회">조회</button>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<!-- LUN 테이블 영역 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">
				LUN 목록 <small> ${lunSearchVo.paginationInfo.currentPageNo }
					/ ${lunSearchVo.paginationInfo.totalPageCount }, 총
					${lunSearchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="lunSearchVo" value="${lunSearchVo }" />
				</div>
			</div>
		</div>
		<!-- /box-header -->
		<!-- box-body -->
		<div class="box-body no-padding">
			<table class="table table-vertical table-hover" id="lunListTable">
			<caption>LUN현황목록 (LUN ID, LUN명, 용량, 스토리지타입, 정의여부, 클러스터구성ID, 클러스터명, 물리서버구성ID, 물리서버명, 물리스토리지명)</caption>
				<colgroup>
					<col class="col7">
					<col class="col15">
					<col class="col8">
					<col class="col10">
					<col class="col15">
					<col class="col15">
					<col class="col15">
					<col class="col15">
				</colgroup>
				<thead>
					<tr>
						<th>LUN ID</th>
						<th>LUN 명</th>
						<th>용량</th>
						<th>스토리지타입</th>
						<th>클러스터구성ID</th>
						<th>클러스터명</th>
						<th>물리서버구성ID</th>
						<th>물리서버명</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="lunVo" items="${lunList }" varStatus="i">
						<tr>
							<td class="alignL"><c:out value="${lunVo.lunId }" /></td>
							<td class="alignL"><c:out value="${lunVo.lunNm }" /></td>
							<td class="alignL"><c:out value="${lunVo.capa }" /></td>
							<td class="alignL"><c:out value="${lunVo.strgTyCdNm }" /></td>
							<td class="alignL"><c:out value="${lunVo.clstrCompId }" /></td>
							<td class="alignL"><c:out value="${lunVo.clstrNm }" /></td>
							<td class="alignL"><c:out value="${lunVo.pmCompId }" /></td>
							<td class="alignL"><c:out value="${lunVo.pmNm }" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 			<div class="box-footer clearfix"> -->
			<div class="box-footer edit-btn-group">
				<ul class="pagination">
					<ui:pagination paginationInfo="${lunSearchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
				</ul>
			</div>
		</div>
		<!-- /box-body -->
	</div>
</div>
<div class="col-box-100">
	<div class="button">
		<button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
	</div>
</div>

<script type="text/javascript">

// 초기화
function fn_lunInitComponent(){
	$('#lunSearchVo input[type="text"]').val('');
}

// 조회
function fn_searchLunList(){
	$('#lunSearchVo').attr('target', '_self');
	$('#lunSearchVo').attr('action', '<c:url var="select" value="selectLunListP.do"/>');
	$('#lunSearchVo').submit();
}


$("#lunListTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	order : [ [ 0, "desc" ] ]
});
</script>