<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
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
				<div class="form-cell form-cell-50 col-lay-30">
					<div class="cell-title"><label for="searchUserNm">사용자명</label></div>
					<div class="cell-body">
						<form:input path="searchUserNm" cssClass="form-control input-sm" title="사용자명" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-30">
					<div class="cell-title"><label for="searchUserId">사용자ID</label></div>
					<div class="cell-body">
						<form:input path="searchUserId" cssClass="form-control input-sm" title="사용자ID" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-30">
					<div class="cell-title"><label for="searchRoleCd">권한</label></div>
					<div class="cell-body">
						<form:select path="searchRoleCd" cssClass="form-control input-sm" title="권한">
							<form:option value="">전체</form:option>
							<form:options items="${roles }" itemLabel="roleNm" itemValue="roleCd" />
						</form:select>

					</div>
				</div>
				<div class="form-cell form-cell-100 col-lay-60" style="white-space:nowrap; ">
					<div class="cell-title"><label for="startRnctDt">접속일자</label></div>
					<div class="cell-body">
						<div class="input-group period period-start">
							<form:input path="startRnctDt" cssClass="form-control input-sm datepicker" title="날짜" onchange="initDate(this, 'endRnctDt', 'S')"/>
						</div>
						<div class="input-group period period-end">
							<form:input path="endRnctDt" cssClass="form-control input-sm datepicker" title="날짜" onchange="initDate(this, 'startRnctDt', 'E')"/>
						</div>
						<p class="comment">( nTOPS 기준 )</p>
					</div>
				</div>
				<div class="form-cell form-cell-100 col-lay-40">
					<div class="cell-title"><label for="lngTrmNotAccs" title="장기미접속">장기미접속</label></div>
					<div class="cell-body">
						<div class="input-group input-group-check">
							<form:checkbox path="lngTrmNotAccs" id="lngTrmNotAccs" value="Y" />
						</div>
						<p class="comment">( nTOPS 기준 )</p>
					</div>
				</div>
			</div>
		</div>
		<div class="box-footer collapse in search-collapse">
			<div class="pull-left">
				<button type="button" class="btn" onclick="formReset('searchVo')">초기화</button>
			</div>
			<div class="pull-right">
				<button type="button" class="btn btn-red" onclick="doSearch()">조회</button>
			</div>
		</div><!-- /box-footer -->
	</div>
	</form:form>
</div>
<div class="col-box-100">
	<div class="info">
		<h2>알려드립니다.</h2>
		<p>- 해당정보는 nTOPS와 연계된 정보입니다.</p>
	</div>
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
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="doDownloadExcel()"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical table-layout-fixed" id="userTable">
				<caption>사용자 목록 테이블</caption>
				<thead>
					<tr>
						<th>No.</th>
						<th>사용자ID</th>
						<th>사용자명</th>
						<th>부처</th>
						<th>직위</th>
						<th>전화번호</th>
						<th>권한</th>
						<th>nTOPS 최근접속일시</th>
						<th>nCMS 최근접속일시</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list }" varStatus="i">
						<c:url var="detailUrl" value="selectUser.do">
							<c:forEach var="curParam" items="${param }">
								<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
							</c:forEach>
							<c:param name="userId" value="${vo.userId }" />
						</c:url>
						<tr>
							<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
							<td class="alignL">
								<c:choose>
									<c:when test="${vo.userStat eq 'E' }"><a href="javascript:alertStat();"/>
									</c:when>
									<c:otherwise>
										<a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.userId}"/>">
									</c:otherwise>
								</c:choose><c:out value="${vo.userId }" /></a>
							</td>
							<td>
							<c:choose>
									<c:when test="${vo.userStat eq 'E' }"><a href="javascript:alertStat();"/>
									</c:when>
									<c:otherwise>
										<a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.userId}"/>">
									</c:otherwise>
								</c:choose>
								<c:out value="${vo.userNm }" /></a>
							</td>
							<td class="alignL"><c:out value="${vo.institutionNm }" /></td>
							<td class="alignL"><c:out value="${vo.ofcpsNm }" /></td>
							<td><c:out value="${vo.telno }" /></td>
							<td class="alignL"><c:out value="${vo.roleNm }" /></td>
							<td>
								<c:choose>
									<c:when test="${vo.rcntLoginDttm ne null and vo.rcntLoginDttm ne '' }">
										<fmt:formatDate value="${vo.rcntLoginDttm }" pattern="yyyy-MM-dd HH:mm" />
									</c:when>
									<c:otherwise>
										-
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<c:choose>
									<c:when test="${vo.ncmsRcntLoginDttm ne null }">
										<fmt:formatDate value="${vo.ncmsRcntLoginDttm }" pattern="yyyy-MM-dd HH:mm" />
									</c:when>
									<c:otherwise>
										-
									</c:otherwise>
								</c:choose>
							</td>
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
			 <div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertUser.do">
						<c:forEach var="curParam" items="${param }">
							<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
						</c:forEach>
					</c:url>
					<button class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가" onclick="goToUrl('${insertUrl}')">
						<i class="fa fa-plus"></i>
					</button>
				</menu:authorize>
			</div>
		</div>
		<!-- /box-footer -->
	</div>
</div>

<script type="text/javascript">
function goPage(page){
	location.href = "selectUserList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

function alertStat()
{
	alert("장기미접속자의 정보는 조회할 수 없습니다.");
}

function doSearch() {
	$("#searchVo").attr("action", "selectUserList.do");
	$("#searchVo").submit();
}

function doDownloadExcel() {

	if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		alert("다운로드 할 데이터가 없습니다.");
		return;
	}

	location.href = "selectDownloadUser.do?" + $("#searchVo").serialize();


	//$("#searchVo").attr("action", "selectDownloadUser.do");
	//$("#searchVo").submit();
}

$("#userTable").DataTable( {
	dom: 'Zlfrtip',
	aoColumns : [
	               {sWidth : "50px" }, //NO
	               {sWidth : "80px" }, //사용자ID
	               {sWidth : "70px" }, //사용자명
	               {sWidth : "110px" }, //부처
	               {sWidth : "90px" },  //작위
	               {sWidth : "100px" }, //전화번호
	               {sWidth : "160px" }, //160px
	               {sWidth : "125px" },
	               {sWidth : "125px" }
	],
	order : [[0, "desc"]]
} );
</script>