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

<div class="col-box-40 search-col no-padding-right">
	<div class="box">
		<!-- box-body -->
		<div class="box-header">
		  <h3 class="box-title">롤 목록</h3>
		</div>
		<form name="role" id="role" method="post">
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical table-layout-fixed" id="roleTbl">
				<caption>롤 목록 테이블</caption>
				<colgroup>
					<col class="70px">
					<col class="70px">
					<col class="80px">
					<menu:authorize>
					<col class="100px">
					</menu:authorize>
				</colgroup>
				<thead>
				<tr>
					<th>롤ID</th>
					<th>롤명</th>
					<th>롤타입</th>
					<menu:authorize>
						<th></th>
					</menu:authorize>
				</tr>
				</thead>

				<tbody>
				<menu:authorize>
				<tr>
					<td><input type="text" name="roleCd" id="roleCd" class="form-control essential" style="text-transform: uppercase" title="롤ID" maxlength="6"/></td>
					<td><input type="text" name="roleNm" id="roleNm" class="form-control essential" title="롤명" /></td>
					<td>
						<%--<nform:selectCode
							parentCd="AUTHCD"
							parentGrpCd="090"
							whole="false"
							name="roleTyCd"
							id="roleTyCd"
							cssClass="form-control essential" /> --%>
						<select name="roleTyCd" id="roleTyCd" class="form-control essential" title="롤타입">
							<option value="">선택</option>
							<c:forEach items="${codes }" var="code">
							<option value="${code.cd }">${code.cdNm }</option>
							</c:forEach>
						</select>
					</td>
					<td>
						<input type="hidden" name="useYn" value="Y"/>
						<input type="hidden" id="actionType" value="insert" />

						<button type="button" class="btn btn-blue btn-sm btn_submit" onclick="doSubmit()">저장</button>
						<button type="button" class="btn btn-sm" onclick="initRoleForm()">취소</button>

					</td>
				</tr>
				</menu:authorize>
				<c:choose>
					<c:when test="${list eq null or empty list }">
						<tr>
							<td colspan="3">검색된 데이터가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="vo" items="${list }" varStatus="i">
							<c:if test="${vo.roleCd ne 'SYSADM' }">
							<tr id="<c:out value="${vo.roleCd }" />Tr">
								<td>
									<a href="javascript:void(0)" onclick="doMenuList('<c:out value="${vo.roleCd }" />')" title="<c:out value="${vo.roleNm}"/> 메뉴 출력"><c:out value="${vo.roleCd }" /></a>
								</td>
								<td class="alignL">
									<a href="javascript:void(0)" onclick="doMenuList('<c:out value="${vo.roleCd }" />')" title="<c:out value="${vo.roleNm}"/> 메뉴 출력"><c:out value="${vo.roleNm }" /></a>
								</td>
								<td class="alignL">
									<c:out value="${vo.roleTyNm }" />
									<input type="hidden" value="${vo.roleTyCd }" />
								</td>
								<menu:authorize>
								<td>
									<button type="button" class="btn btn-default btn-sm" onclick="doModify(this)">수정</button>
									<c:if test="${vo.roleCd ne 'OPRADM' and vo.roleCd ne 'OPRCHR' }">
										<button type="button" class="btn btn-red btn-sm" onclick="doDelete('<c:out value="${vo.roleCd }" />')">삭제</button>
									</c:if>
								</td>
								</menu:authorize>
							</tr>
							</c:if>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer clearfix">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
		</div>
		<!-- /box-footer -->
		</form>
	</div>
</div>

<div class="col-box-60 search-col">
	<div class="box content_area">
		<div class="box-header">
		  <h3 class="box-title">메뉴 목록</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-hover table-vertical">
				<caption>롤에 속한 메뉴 권한 목록 테이블</caption>
				<colgroup>
					<col class="colAuto">
					<col class="col15">
					<col class="col15">
					<col class="col15">
				</colgroup>
				<thead>
				<tr>
					<th>메뉴</th>
					<th>읽기</th>
					<th>쓰기</th>
					<th>실행</th>
				</tr>
				</thead>
				<tbody>
				<tr>
					<td colspan="4">롤을 선택하여 주시기 바랍니다.</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<script type="text/javascript">
	function goPage(page) {
		location.href = "selectRoleList.do?paginationInfo.currentPageNo="
				+ page + "&${listParam}";
	}

	function doMenuList(code) {

		initRoleForm()

		$("#roleTbl > tbody > tr > td").css("background-color", "");
		$("#" + code + "Tr > td").css("background-color", "#f5f5f5");

		$.ncmsLoding.start($('.content_area'));
		$(".content_area").load("<c:url value="selectRoleMenuList.do" />?roleCd=" + code);
	}

	function doModify(obj) {
		var roleCd = $(obj).parent().prev().prev().prev().text();
		var roleNm = $(obj).parent().prev().prev().text();
		var roleTyCd = $(obj).parent().prev().find("input").val();

		$("#roleCd").val($.trim(roleCd));
		$("#roleCd").attr("readonly", true);

		$("#roleNm").val($.trim(roleNm));

		$("#roleTyCd").val(roleTyCd);

		$(".btn_submit").text("수정");
		$("#actionType").val("update");
	}

	var deleteRoleCode = "";
	function doDelete(code) {
		deleteRoleCode = code;
		jConfirm(
				"메뉴를 삭제할 시 메뉴 또는 사용자에 맵핑되어 있는 권한이 모두 삭제 됩니다.<br /><br />메뉴를 삭제하시겠습니까?",
				function() {
					var url = "<c:url value="deleteRole.do" />";

					$.ncmsLoding.startFullScreen();

					$.post(url,
							{ "roleCd" : code },
							function(result) {
								alert_message(result.messageList, function() {
									if (result.success) {
										$("#" + code + "Tr").remove();
									}

									var html = '<div class="box-header">';
									html += '<h3 class="box-title">메뉴 목록</h3>';
									html += '		</div>';
									html += '		<div class="box-body no-padding">';
									html += '			<table class="table table-hover table-vertical">';
									html += '				<caption>롤에 속한 메뉴 권한 목록 테이블</caption>';
									html += '				<colgroup>';
									html += '					<col class="colAuto">';
									html += '					<col class="col15">';
									html += '					<col class="col15">';
									html += '					<col class="col15">';
									html += '				</colgroup>';
									html += '				<thead>';
									html += '				<tr>';
									html += '					<th>메뉴</th>';
									html += '					<th>읽기</th>';
									html += '					<th>쓰기</th>';
									html += '					<th>실행</th>';
									html += '				</tr>';
									html += '				</thead>';
									html += '				<tbody>';
									html += '				<tr>';
									html += '					<td colspan="4">롤을 선택하여 주시기 바랍니다.</td>';
									html += '				</tr>';
									html += '				</tbody>';
									html += '			</table>';
									html += '		</div>';


									$(".content_area").html(html);

								});
							},
							"json"
						)
						.always(function() {
							$.ncmsLoding.remove();
						});
				});
	}

	function doSubmit() {

		if (!fn_form_validation("role")) {
			return;
		}

		var url = "";
		if ($("#actionType").val() == "insert") {
			url = "<c:url value="insertRole.do" />";
		} else {
			url = "<c:url value="updateRole.do" />";
		}

		$.ncmsLoding.startFullScreen();
		$.post(
				url,
				$('#role').serialize(),
				function(result) {
					alert_message(result.messageList, function() {
						if (result.success) {

							var roleCd = $("#roleCd").val().toUpperCase();
							var roleNm = $("#roleNm").val();
							var roleTyCd = $("#roleTyCd option:selected").val();
							var roleTyNm = $("#roleTyCd option:selected").text();

							if ($("#actionType").val() == "insert") {
								var html = '<tr id="' + roleCd + 'Tr">';
								html += '	<td>';
								html += '		<a href="javascript:void(0)" onclick="doMenuList(\'' + roleCd + '\')" title="' + roleNm	+ ' 메뉴 출력">' + roleCd + '</a>';
								html += '	</td>';
								html += '	<td class="alignL">';
								html += '		<a href="javascript:void(0)" onclick="doMenuList(\'' + roleCd + '\')" title="' + roleNm + ' 메뉴 출력">' + roleNm + '</a>';
								html += '	</td>';
								html += '	<td class="alignL">' + roleTyNm;
								html += '		<input type="hidden" value="' + roleTyCd + '" />';
								html += '	</td>';
								html += '	<td>';
								html += '		<button type="button" class="btn btn-default btn-sm" onclick="doModify(this)">수정</button>';
								html += '		<button type="button" class="btn btn-red btn-sm" onclick="doDelete(\'' + roleCd + '\')">삭제</button>';
								html += '	</td>';
								html += '</tr>';

								$("#roleTbl > tbody").append(html);
							} else {
								$("#" + roleCd + "Tr > td:eq(1) > a").text(roleNm);
								$("#" + roleCd + "Tr > td:eq(2)").html(roleTyNm + '<input type="hidden" value="' + roleTyCd + '" />');
							}

							initRoleForm();
						}
					});
				},
				'json'
			).always(function() {
				$.ncmsLoding.remove();
			});
	}

	function initRoleForm() {
		$("#roleNm").val("");
		$("#roleCd").val("");
		$("#roleCd").attr("readonly", false);
		$("#roleTyCd option:eq(0)").prop("selected","selected");
		$(".btn_submit").text("입력");
		$("#actionType").val("insert");
	}
</script>