<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 11. 29.
 * @lastmodified 2016. 11. 29.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 29.     박희택         v1.0             최초생성
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

<div class="col-box-100">
	<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
	<div class="box-search">
		<div class="box-body">
			<div class="form-group">
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchStackClCd">스택분류</label>
					</div>
					<div class="cell-body">
						<div class="input-group">
							<nform:selectCode parentCd="201"
							parentGrpCd="039"
							name="searchStackClCd"
							id="searchStackClCd"
							title="스택분류"
							whole="true"
							value="${searchVo.searchStackClCd }"
							cssClass="form-control input-sm" />
						</div>
					</div>
				</div>
				<div class="form-cell form-cell-50">
					<div class="cell-title">
						<label for="searchApiNm">API 명</label>
					</div>
					<div class="cell-body">
						<form:input path="searchApiNm" title="API 명" type="text" class="form-control input-sm" />
					</div>
				</div>
				<div class="form-cell form-cell-50">
					<div class="cell-title">
						<label for="searchDc">설명</label>
					</div>
					<div class="cell-body">
						<form:input path="searchDc" title="설명" type="text" class="form-control input-sm" />
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
		<!-- box-body -->
		<div class="box-body no-padding">
			<form:form commandName="apiVo" method="get">
			<table class="table table-hover table-vertical table-layout-fixed" id="apiTable">
				<caption>API목록</caption>
				<colgroup>
					<col class="col4">
					<col class="col5">
					<col class="col13">
					<col class="col25">
					<col class="colAuto">
				</colgroup>
				<thead>
					<tr>
						<th><input type="checkbox" id="chkApiAll" title="사용자롤 전체 선택" onclick="doCheckAll(this, 'apiId')" /></th>
						<th>No.</th>
						<th>스택분류</th>
						<th>API명</th>
						<th>설명</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${list eq null or empty list }">
							<tr>
								<td colspan="5">조회된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="apiVo" items="${list}" varStatus="i">
				          		<tr>
									<td>
										<input type="checkbox" name="apiId" class="apiId" value="${apiVo.apiId}" title="API코드 ${apiVo.apiId}"/>
										<input type="hidden" name="stackClNm" value="${apiVo.stackClNm}" style="display: none;" />
										<input type="hidden" name=apiNm value="${apiVo.apiNm}" style="display: none;" />
										<input type="hidden" name=dc value="${apiVo.dc}" style="display: none;" />
									</td>
									<td><c:out value="${((searchVo.paginationInfo.currentPageNo-1)*searchVo.paginationInfo.recordCountPerPage+i.count)}" /></td>
									<%-- <td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td> --%>
									<td><c:out value="${apiVo.stackClNm}" /></td>
				          			<td class="alignL"><c:out value="${apiVo.apiNm}" /></td>
				          			<td class="alignL"><c:out value="${apiVo.dc}" /></td>
				          		</tr>
				          	</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			</form:form>
		</div>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer clearfix">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo}" type="common" jsFunction="goPage" />
			</ul>
			<div class="btns pull-right">
				<button type="button" class="btn btn-default" onclick="selectApiM()">선택</button>
			</div>
		</div>
		<!-- /box-footer -->
	</div>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>

<script type="text/javascript">
function doCheckAll(obj, clazz) {
	$("." + clazz).prop("checked", $(obj).prop("checked"));
}

function goPage(page){
	location.href = "selectApiListP.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

function selectApiM(){

	if( $("input:checkbox[name='apiId']:checked").size() == 0 ) {
		jAlert("API를 한항목 이상 선택하여 주시기 바랍니다.");
		return;
	}

	var datas = new Array();
	var data = null;
	$("input:checkbox[name='apiId']").each(function(index) {
		if( $(this).prop("checked") ) {
			data = new EntityApi();
			data.apiId = $(this).val();
			data.stackClNm = $("input:hidden[name='stackClNm']:eq(" + index + ")").val();
			data.apiNm = $("input:hidden[name='apiNm']:eq(" + index + ")").val();
			data.dc = $("input:hidden[name='dc']:eq(" + index + ")").val();
			datas.push(data);
		}
	});

	var evt = jQuery.Event('selectApiMulti', {
		"datas" : datas
    });

    var _parent = window.opener;
    _parent.jQuery(_parent.document).trigger(evt);
	window.close();
}
</script>