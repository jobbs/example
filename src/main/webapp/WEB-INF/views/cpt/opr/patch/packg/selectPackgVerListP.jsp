<!--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 17.
 * @lastmodified 2016. 10. 17.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 17.     이화영         v1.0             최초생성
 *
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100">
	<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
	<form:hidden path="packgSeq" />
	<form:hidden path="searchType"/>
	<div class="box-search">
		<div class="box-body">
			<div class="form-group">
				<div class="form-cell form-cell-50">
					<div class="cell-title"><label for="searchPackgNm">패키지명</label></div>
					<div class="cell-body">
						<form:input path="searchPackgNm" title="패키지명" cssClass="form-control input-sm pull-right" readonly="true" />
					</div>
				</div>
				<div class="form-cell form-cell-50">
					<div class="cell-title"><label for="searchVer">버전</label></div>
					<div class="cell-body">
						<form:input path="searchVer" title="버전" cssClass="form-control input-sm pull-right" />
					</div>
				</div>
				<div class="form-cell form-cell-100 alignR pad-top-5">
					<button class="btn btn-red btn-sm" type="submit">조회</button>
				</div>
			</div>

		</div>
	</div>
	</form:form>

	<div class="box">
		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">
				검색결과<small> ${searchVo.paginationInfo.currentPageNo }
					/ ${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }" />
				</div>
			</div>
		</div>
		<!-- /box-header -->
		<!-- box-body -->
		<c:choose>
			<c:when test="${searchVo.searchType eq 'S' }">
				<div class="box-body no-padding">
					<table id="packgVerTable" class="table table-hover table-vertical">
						<caption>패키지버전 목록</caption>
						<colgroup>
							<col class="col5">
							<col class="col7">
							<col class="col31">
							<col class="col10">
							<col class="col31">
							<col class="col16">
						</colgroup>
						<thead>
						<tr>
							<th></th>
							<th>No.</th>
							<th>패키지명</th>
							<th>버전</th>
							<th>릴리즈</th>
							<th>등록일자</th>
						</tr>
						</thead>
						<tbody>
							<c:forEach var="packgVo" items="${packgVoList }" varStatus="i">
								<tr>
									<td>
										<input type="radio" name="packgSeq" value="${packgVo.packgSeq }"/>
										<input type="hidden" name="applcPackgSeq" value="${packgVo.packgSeq }">
										<input type="hidden" name="applcPackgNm" value="${packgVo.packgNm }">
										<input type="hidden" name="applcPackgVer" value="${packgVo.ver }">
										<input type="hidden" name="applcRelease" value="${packgVo.release }">
									</td>
									<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
									<td class="alignL"><c:out value="${packgVo.packgNm }" /></td>
									<td><c:out value="${packgVo.ver }" /></td>
									<td class="alignL"><c:out value="${packgVo.release }" /></td>
									<td><c:out value="${packgVo.regDt }" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="box-footer">
					<ul class="pagination">
						<ui:pagination paginationInfo="${searchVo.paginationInfo }"	type="common" jsFunction="goPage" />
					</ul>
				</div>
			</c:when>
			<c:otherwise>
				<div class="box-body no-padding">
					<table id="packgVerTable" class="table table-hover table-vertical">
						<caption>패키지버전 목록</caption>
						<colgroup>
							<col class="col7">
							<col class="col34">
							<col class="col10">
							<col class="col34">
							<col class="col15">
						</colgroup>
						<thead>
						<tr>
							<th>No.</th>
							<th>패키지명</th>
							<th>버전</th>
							<th>릴리즈</th>
							<th>등록일자</th>
						</tr>
						</thead>
						<tbody>
							<c:forEach var="packgVo" items="${packgVoList }" varStatus="i">
								<tr>
									<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
									<td class="alignL"><c:out value="${packgVo.packgNm }" /></td>
									<td><c:out value="${packgVo.ver }" /></td>
									<td class="alignL"><c:out value="${packgVo.release }" /></td>
									<td><c:out value="${packgVo.regDt }" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="box-footer">
					<ul class="pagination">
						<ui:pagination paginationInfo="${searchVo.paginationInfo }"	type="common" jsFunction="goPage" />
					</ul>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</div>

<!-- popup 버튼 -->

	<div class="col-box-100">
	  <div class="button">
	  	<c:if test="${searchVo.searchType eq 'S' }">
	  		<button type="button" class="btn btn-dark" onclick="fn_selectPackgVer()">이 항목 선택하기</button>
	  	</c:if>
	  	<button type="button" class="btn close-window" >닫기</button>
	   </div>
	</div>

<!-- /popup 버튼 -->

<script type="text/javascript">

$('#packgVerTable tr').click(function(e){
		var $target = $(this).find("td input");
	if( $target.attr("type") == "radio" ) {
		$target.prop("checked", true);
	} else {
		var checked = $target.prop("checked");
		$target.prop("checked", !checked);
	}
});

function goPage(page){
	location.href = "selectPackgVerListP.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

$("#packgVerTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	order : [[0, "desc"]]
} );

function fn_selectPackgVer(){
	var data = null;
	$("input:radio[name='packgSeq']").each(function(index) {
		if( $(this).prop("checked") ) {
			data = EntityPackg;
			data.applcPackgSeq = $(this).val();
			data.applcRelease = $("input:hidden[name='applcRelease']:eq(" + index + ")").val();
			data.applcPackgNm = $("input:hidden[name='applcPackgNm']:eq(" + index + ")").val();
			data.applcPackgVer = $("input:hidden[name='applcPackgVer']:eq(" + index + ")").val();
		}
	});

	var evt = jQuery.Event('selectPackgNmVer', {
		"datas" : data
    });

    var _parent = window.opener;
    _parent.jQuery(_parent.document).trigger(evt);
    window.close();

}

function EntityPackg(){
	this.applcPackgSeq;
	this.applcRelease
	this.applcPackgNm;
	this.applcPackgVer;
}
</script>