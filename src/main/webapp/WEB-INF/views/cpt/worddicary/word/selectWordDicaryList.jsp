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

<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get">
	<div class="box box-search">
		<div class="box-header">
			<h3 class="box-title">검색조건</h3>
			<div class="box-tools pull-right">
				<button class="btn btn-red btn-sm" data-toggle="collapse" data-target=".box-search-collapse"><i class="fa fa-minus"></i></button>
			</div>
		</div>

		<div class="box-body collapse in search-collapse">
			<div class="form-group">
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title"><label>한글명</label></div>
					<div class="cell-body">
						<form:input path="searchKr" cssClass="form-control input-sm"/>
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title"><label>영문명</label></div>
					<div class="cell-body">
						<form:input path="searchEn" cssClass="form-control input-sm" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title"><label>영문약어</label></div>
					<div class="cell-body">
						<form:input path="searchAbrv" cssClass="form-control input-sm"/>
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title"><label>금칙어여부</label></div>
					<div class="cell-body">
						<div class="input-group input-group-check">
							<form:checkbox path="searchProhibitYn" value="Y" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="box-footer collapse in search-collapse">
			<div class="pull-right">
				<button type="submit" class="btn btn-red">조회</button>
			</div>
		</div><!-- /box-footer -->
	</div>
	</form:form>
</div>

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">검색결과<small>1 / 5, 총 44건</small></h3>
		</div><!-- /box-header -->

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical" id="noticeTable">
				<colgroup>
					<col class="col7">
					<col class="col10">
					<col class="col10">
					<col class="col10">
					<col class="col10">
					<col class="colAuto">
					<col class="col7">
					<col class="col10">
				</colgroup>
				<thead>
				<tr>
					<th>No.</th>
					<th>한글명</th>
					<th>영문명</th>
					<th>영문약어</th>
					<th>금칙어여부</th>
					<th>설명</th>
					<th>등록자</th>
					<th>등록일</th>
				</tr>
				</thead>

				<tbody>
				<c:choose>
					<c:when test="${list eq null or empty list }">
						<tr>
							<td colspan="7">검색된 데이터가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="vo" items="${list }" varStatus="i">
							<tr>
								<c:url value="updateWordDicary.do" var="updateWordDicaryUrl">
									<c:forEach var="curParam" items="${param }">
										<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
									</c:forEach>
									<c:param name="wordSeq" value="${vo.wordSeq }" />
								</c:url>
								<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
								<td class="alignL"><a href="${updateWordDicaryUrl }"><c:out value="${vo.wordKr }" /></a></td>
								<td class="alignL"><c:out value="${vo.wordEn }" /></td>
								<td class="alignL"><c:out value="${vo.wordAbrv }" /></td>
								<td><c:out value="${vo.prohibitYn }" /></td>
								<td class="alignL"><c:out value="${vo.wordDc }" /></td>
								<td><c:out value="${vo.regId }" /></td>
								<td><fmt:formatDate value="${vo.regDate }" pattern="yyyy-MM-dd" /></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
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
					<c:url var="insertUrl" value="insertWordDicary.do">
						<c:forEach var="curParam" items="${param }">
							<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
						</c:forEach>
					</c:url>
					<button class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="등록" onclick="goToUrl('${insertUrl}')"><i class="fa fa-plus"></i></button>
				</menu:authorize>
			</div>
		</div>
		<!-- /box-footer -->
	</div>
</div>

<script type="text/javascript">
function goPage(page){
	location.href = "selectWordDicaryList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

function goToUrl(url) {
	location.href = url;
}

/* $("#noticeTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	order : [[0, "desc"]]
} ); */
</script>