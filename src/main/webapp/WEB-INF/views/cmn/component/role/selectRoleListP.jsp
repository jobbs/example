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

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100">
	<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
	<form:hidden path="searchType"/>
	<div class="box-search">
		<div class="box-body">
			<div class="form-group">
				<div class="form-cell form-cell-50">
					<div class="cell-title">
						<label for="searchRoleCd">권한코드</label>
					</div>
					<div class="cell-body">
						<form:input path="searchRoleCd" cssClass="form-control" title="코드"/>
					</div>
				</div>
				<div class="form-cell form-cell-50">
					<div class="cell-title">
						<label for="searchRoleNm">권한명</label>
					</div>
					<div class="cell-body">
						<form:input path="searchRoleNm" cssClass="form-control" title="명칭"/>
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
			<form action="roleFrm" id="roleFrm">
			<table class="table table-hover table-vertical">
				<caption>롤 목록 테이블</caption>
				<colgroup>
					<col class="col10">
					<col class="col15">
					<col class="colAuto">
					<col class="col20">
				</colgroup>
				<thead>
				<tr>
					<th>
						<c:if test="${searchVo.searchType eq 'M' }">
							<input type="checkbox" id="chkroleAll" title="사용자롤 전체 선택" onclick="doCheckAll(this, 'roleCd')" />
						</c:if>
					</th>
					<th>권한코드</th>
					<th>권한명</th>
					<th>권한타입</th>
				</tr>
				</thead>

				<tbody>
				<c:choose>
					<c:when test="${list eq null or empty list }">
						<tr>
							<td colspan="4">검색된 데이터가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="vo" items="${list }" varStatus="i">
							<tr>
								<td>
									<c:choose>
										<c:when test="${searchVo.searchType eq 'M' }">
											<input type="checkbox" name="roleCd" class="roleCd" value="${vo.roleCd }" title="롤코드 ${vo.roleCd }"/>
										</c:when>
										<c:otherwise>
											<input type="radio" name="roleCd" value="${vo.roleCd }" title="롤코드 ${vo.roleCd }"/>
										</c:otherwise>
									</c:choose>
									<input type="hidden" name="roleNm" value="${vo.roleNm }" />
									<input type="hidden" name="roleTyCd" value="${vo.roleTyCd }" />
									<input type="hidden" name="roleTyNm" value="${vo.roleTyNm }" />
								</td>
								<td><c:out value="${vo.roleCd }" /></td>
								<td class="alignL"><c:out value="${vo.roleNm }" /></td>
								<td class="alignL"><c:out value="${vo.roleTyNm }" /></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
			</form>
		</div>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer clearfix">
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
				<button type="button" class="btn btn-dark" onclick="selectRoles()">선택</button>
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-dark" onclick="selectRole()">선택</button>
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
	location.href = "selectRoleListP.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

function selectRoles(){

	if( $("input:checkbox[name='roleCd']:checked").size() == 0 ) {
		jAlert("권한을 한 항목 이상 선택하여 주시기 바랍니다.");
		return;
	}


	var codes = $('input[name=roleCd]:checked').serializeArray();

	var datas = new Array();
	var data = null;
	$("input:checkbox[name='roleCd']").each(function(index) {
		if( $(this).prop("checked") ) {
			data = new EntityUserRole();
			data.roleCd = $(this).val();
			data.roleNm = $("input:hidden[name='roleNm']:eq(" + index + ")").val();
			data.roleTyCd = $("input:hidden[name='roleTyCd']:eq(" + index + ")").val();
			data.roleTyNm = $("input:hidden[name='roleTyNm']:eq(" + index + ")").val();
			datas.push(data);
		}
	});

	console.log( datas );

	var evt = jQuery.Event('selectRoleMulti', {
		procType:"<c:out value="${searchVo.searchType}" />",
		roles : datas
    });

    var _parent = window.opener;
    _parent.jQuery(_parent.document).trigger(evt);
    window.close();
}

function selectRole(){

	if( $("input:radio[name='roleCd']:checked").size() == 0 ) {
		jAlert("권한을 선택하여 주시기 바랍니다.");
		return;
	}

	var evt = jQuery.Event('selectRole', {
		procType:"<c:out value="${searchVo.searchType}" />",
		roleCd: $('input[name=roleCd]:checked').val()
    });

    var _parent = window.opener;
    _parent.jQuery(_parent.document).trigger(evt);
    window.close();
}

$("#roleFrm input[name='roleCd']").click(function(event) {
	event.stopPropagation();
});

$("#roleFrm input[name='roleCd']").parent().parent().click(function() {
	var $target = $(this).find("input[name='roleCd']");
	if( $target.attr("type") == "radio" ) {
		$target.prop("checked", true);
	} else {
		var checked = $target.prop("checked");
		$target.prop("checked", !checked);
	}
});
</script>