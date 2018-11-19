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
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:set var="listParam" value="${cf:queryStringMulti(param, 'paginationInfo.currentPageNo,cd,grpCd', ',') }"></c:set>
<c:set var="updateParam" value="${cf:queryString(param, '') }"></c:set>


<c:url var="updateUrl" value="updateCode.do"></c:url>

<div class="box">
	<div class="box-header">
		<h3 class="box-title">상위 코드정보</h3>
	</div><!-- /box-header -->

	<div class="box-body no-padding">
		<table class="table table-horizon">
			<caption>상위 코드 정보 테이블</caption>
			<colgroup>
				<col class="col20">
				<col class="col30">
				<col class="col20">
				<col class="col30">
			</colgroup>
			<tbody>
			<tr>
				<th>코드</th>
				<td><c:out value="${vo.parent.cd }" /></td>
				<th>그룹코드</th>
				<td><c:out value="${vo.parent.grpCd }" /></td>
			</tr>
			<tr>
				<th>코드명</th>
				<td colspan="3"><c:out value="${vo.parent.cdNm }" /></td>
			</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="box">
	<div class="box-header">
		<h3 class="box-title">코드정보</h3>
	</div><!-- /box-header -->

	<div class="box-body no-padding">
		<table class="table table-horizon">
			<caption>코드 정보 테이블</caption>
			<colgroup>
				<col class="col20">
				<col class="col30">
				<col class="col20">
				<col class="col30">
			</colgroup>
			<tbody>
			<tr>
				<th>코드</th>
				<td><c:out value="${vo.cd }" /></td>
				<th>그룹코드</th>
				<td><c:out value="${vo.grpCd }" /></td>
			</tr>
			<tr>
				<th>코드명</th>
				<td><c:out value="${vo.cdNm }" /></td>
				<th>사용여부</th>
				<td><c:out value="${vo.useYn }" /></td>
			</tr>
			<tr>
				<th>설명</th>
				<td colspan="3"><c:out value="${vo.cdDesc }" /></td>
			</tr>
			<tr>
				<th>기타필드1</th>
				<td><c:out value="${vo.varVl1 }" /></td>
				<th>기타필드2</th>
				<td><c:out value="${vo.varVl2 }" /></td>
			</tr>
			<tr>
				<th>기타필드3</th>
				<td><c:out value="${vo.varVl3 }" /></td>
				<th>기타필드4</th>
				<td><c:out value="${vo.varVl4 }" /></td>
			</tr>
			<tr>
				<th>기타필드5</th>
				<td colspan="3"><c:out value="${vo.varVl5 }" /></td>
			</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="edit-btn-group">
	<c:if test="${searchVo.searchType eq 'S' }">
	<div class="pull-left btns">
		<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="doList()"><i class="fa fa-arrow-left"></i></button>
	</div>
	</c:if>
	<menu:authorize>
	<div class="pull-right btns">
		<button class="btn btn-sm btn-hover-yellow" data-toggle="tooltip" data-original-title="코드수정" onclick="doUpdateForm('<c:out value="${vo.cd}" />','<c:out value="${vo.grpCd}" />')"><i class="fa fa-eraser"></i></button>
	</div>
	</menu:authorize>
</div>

<script type="text/javascript">
function doList() {
	$.get("selectCodeSearchList.do","${listParam }", loadSuccessHandler,'html');
}

function doUpdateForm(cd, grpCd) {
	$.get("updateCode.do","${updateParam }", loadSuccessHandler,'html');
}

$('[data-toggle="tooltip"]').tooltip();
</script>