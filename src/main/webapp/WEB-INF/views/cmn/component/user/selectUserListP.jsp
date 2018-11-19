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

<div class="col-box-100">
	<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
	<form:hidden path="searchType"/>
	<div class="box-search">
		<div class="box-body">
			<div class="form-group">
				<div class="form-cell form-cell-50">
					<div class="cell-title"><label for="searchUserId">사용자ID</label></div>
					<div class="cell-body">
						<form:input path="searchUserId" cssClass="form-control input-sm pull-right" title="사용자ID"/>
					</div>
				</div>
				<div class="form-cell form-cell-50">
					<div class="cell-title"><label for="searchUserNm">이름</label></div>
					<div class="cell-body">
						<form:input path="searchUserNm" cssClass="form-control input-sm pull-right" title="이름"/>
					</div>
				</div>
				
				<div class="form-cell form-cell-50">
                    <div class="cell-title"><label for="searchInstitutionNm">부처</label></div>
                    <div class="cell-body">
                        <form:input path="searchInstitutionNm" cssClass="form-control input-sm pull-right" title="부처"/>
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
		<div class="box-body no-padding">
			<form action="userFrm" id="userFrm">
			<table class="table table-hover table-vertical">
				<caption>사용자 목록 테이블</caption>
				<colgroup>
					<col class="col10">
					<col class="col15">
					<col class="col15">
					<col class="colAuto">
					<col class="col15">
				</colgroup>
				<thead>
				<tr>
					<th>
						<c:if test="${searchVo.searchType eq 'M' }">
							<input type="checkbox" id="chkUserAll" title="부처 전체 선택" onclick="doCheckAll(this, 'userId')" />
						</c:if>
					</th>
					<th>사용자ID</th>
					<th>이름</th>
					<th>부처</th>
					<th>직위</th>
				</tr>
				</thead>

				<tbody>
				<c:forEach var="vo" items="${list }" varStatus="i">
					<tr>
						<td>
							<c:choose>
								<c:when test="${searchVo.searchType eq 'M' }">
									<input type="checkbox" name="userId" class="userId" value="${vo.userId }" />
								</c:when>
								<c:otherwise>
									<input type="radio" name="userId" value="${vo.userId }"/>
								</c:otherwise>
							</c:choose>
							<input type="hidden" name="userNm" value="${vo.userNm }" style="display: none;" />
							<input type="hidden" name=institutionId value="${vo.institutionId }" style="display: none;" />
							<input type="hidden" name=institutionNm value="${vo.institutionNm }" style="display: none;" />
							<input type="hidden" name="ofcpsId" value="${vo.ofcpsId }" style="display: none;" />
							<input type="hidden" name="ofcpsNm" value="${vo.ofcpsNm }" style="display: none;" />
							<input type="hidden" name="telno" value="${vo.telno }" style="display: none;" />
							<input type="hidden" name="mobile" value="${vo.mobile }" style="display: none;" />
							<input type="hidden" name="email" value="${vo.email }" style="display: none;" />
						</td>
						<td><c:out value="${vo.userId }" /></td>
						<td><c:out value="${vo.userNm }" /></td>
						<td class="alignL"><c:out value="${vo.institutionNm }" /></td>
						<td><c:out value="${vo.ofcpsNm }" /></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</form>
		</div>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
		</div>
		<!-- /box-footer -->
	</div>
</div>

<div class="col-box-100">
	<div class="button">
		<c:choose>
			<c:when test="${searchVo.searchType eq 'M' }">
				<button type="button" class="btn btn-dark" onclick="selectUserM()">선택</button>
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-dark" onclick="selectUserS()">선택</button>
			</c:otherwise>
		</c:choose>
		<button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
	</div>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>

<script type="text/javascript">
function doCheckAll(obj, clazz) {
	$("." + clazz).prop("checked", $(obj).prop("checked"));
}

function goPage(page){
	location.href = "selectUserListP.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

function selectUserM(){

	if( $("input:checkbox[name='userId']:checked").size() == 0 ) {
		jAlert("사용자를 한항목 이상 선택하여 주시기 바랍니다.");
		return;
	}

	var datas = new Array();
	var data = null;
	$("input:checkbox[name='userId']").each(function(index) {
		if( $(this).prop("checked") ) {
			data = new EntityUser();
			data.jobId = $(this).val();
			data.userNm = $("input:hidden[name='userNm']:eq(" + index + ")").val();
			data.institutionId = $("input:hidden[name='institutionId']:eq(" + index + ")").val();
			data.institutionNm = $("input:hidden[name='institutionNm']:eq(" + index + ")").val();
			data.ofcpsId = $("input:hidden[name='ofcpsId']:eq(" + index + ")").val();
			data.ofcpsNm = $("input:hidden[name='ofcpsNm']:eq(" + index + ")").val();
			data.telno = $("input:hidden[name='telno']:eq(" + index + ")").val();
			data.mobile = $("input:hidden[name='mobile']:eq(" + index + ")").val();
			data.email = $("input:hidden[name='email']:eq(" + index + ")").val();
			datas.push(data);
		}
	});

	var evt = jQuery.Event('selectUserMulti', {
		procType:"<c:out value="${searchVo.searchType}" />",
		"datas" : datas
    });

    var _parent = window.opener;
    _parent.jQuery(_parent.document).trigger(evt);
	window.close();
}

function selectUserS(){

	if( $("input:radio[name='userId']:checked").size() == 0 ) {
		jAlert("사용자를 선택하여 주시기 바랍니다.");
		return;
	}

	var data = null;
	$("input:radio[name='userId']").each(function(index) {
		if( $(this).prop("checked") ) {
			data = new EntityUser();
			data.userId = $(this).val();
			data.userNm = $("input:hidden[name='userNm']:eq(" + index + ")").val();
			data.institutionId = $("input:hidden[name='institutionId']:eq(" + index + ")").val();
			data.institutionNm = $("input:hidden[name='institutionNm']:eq(" + index + ")").val();
			data.ofcpsId = $("input:hidden[name='ofcpsId']:eq(" + index + ")").val();
			data.ofcpsNm = $("input:hidden[name='ofcpsNm']:eq(" + index + ")").val();
			data.telno = $("input:hidden[name='telno']:eq(" + index + ")").val();
			data.mobile = $("input:hidden[name='mobile']:eq(" + index + ")").val();
			data.email = $("input:hidden[name='email']:eq(" + index + ")").val();
		}
	});
	var evt = jQuery.Event('selectUser', {
		procType:"<c:out value="${searchVo.searchType}" />",
		"datas" : data
    });

    var _parent = window.opener;
    _parent.jQuery(_parent.document).trigger(evt);
    window.close();
}

$("#userTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	order : [[0, "desc"]]
} );

$("#userFrm input[name='userId']").click(function(event) {
	event.stopPropagation();
});

$("#userFrm input[name='userId']").parent().parent().click(function() {
	var $target = $(this).find("input[name='userId']");
	if( $target.attr("type") == "radio" ) {
		$target.prop("checked", true);
	} else {
		var checked = $target.prop("checked");
		$target.prop("checked", !checked);
	}
});
</script>