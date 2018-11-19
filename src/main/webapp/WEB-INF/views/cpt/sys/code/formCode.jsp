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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>

<c:set var="detailParam" value="${cf:queryString(param, '') }"></c:set>

<div class="box">

	<div class="box-header">
		<h3 class="box-title">상위 코드정보</h3>
	</div><!-- /box-header -->

	<div class="box-body no-padding">
		<table class="table table-horizon">
			<caption>상위코드 정보 테이블</caption>
			<colgroup>
				<col class="col20">
				<col class="col30">
				<col class="col20">
				<col class="col30">
			</colgroup>
			<tbody>
			<tr>
				<th>코드</th>
				<td><c:out value="${code.parent.cd }" /></td>
				<th>그룹코드</th>
				<td><c:out value="${code.parent.grpCd }" /></td>
			</tr>
			<tr>
				<th>코드명</th>
				<td colspan="3"><c:out value="${code.parent.cdNm }" /></td>
			</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="box">

	<form:form commandName="code">
	<form:hidden path="parentCd" />
	<form:hidden path="parentGrpCd" />

	<div class="box-header">
		<h3 class="box-title">코드정보</h3>
	</div><!-- /box-header -->

	<div class="box-body no-padding">
		<table class="table table-horizon">
			<caption>코드정보 등록 테이블</caption>
			<colgroup>
				<col class="col20">
				<col class="col30">
				<col class="col20">
				<col class="col30">
			</colgroup>
			<tbody>
			<tr>
				<th>
					<c:if test="${code.cd eq null }">
						<span class="text-red">*</span>
					</c:if>
					코드
				</th>
				<td>
					<c:choose>
						<c:when test="${code.cd ne null }">
							<c:out value="${code.cd }" />
							<form:hidden path="cd" />
						</c:when>
						<c:otherwise>
							<form:input path="cd" cssClass="form-control essential" title="코드" maxlength="30" style="ime-mode:inactive" />
						</c:otherwise>
					</c:choose>
				</td>

				<th>그룹코드</th>
				<td>
					<c:choose>
						<c:when test="${code.grpCd eq '000' }">
							자동입력
						</c:when>
						<c:otherwise>
							<c:out value="${code.grpCd }" />
						</c:otherwise>
					</c:choose>
					<form:hidden path="grpCd" />
				</td>
			</tr>
			<tr>
				<th><span class="text-red">*</span> 코드명</th>
				<td><form:input path="cdNm" cssClass="form-control essential" title="코드명" style="ime-mode:active" maxlength="100" /></td>
				<th>사용여부</th>
				<td>
					<form:radiobutton path="useYn" label="사용" value="Y"/>
					<form:radiobutton path="useYn" label="미사용" value="N"/>
				</td>
			</tr>
			<tr>
				<th>설명</th>
				<td colspan="3"><form:input path="cdDesc" cssClass="form-control" title="설명" maxlength="1000" /></td>
			</tr>
			<tr>
				<th>기타필드1</th>
				<td><form:input path="varVl1" cssClass="form-control" title="기타필드1" maxlength="30" /></td>
				<th>기타필드2</th>
				<td><form:input path="varVl2" cssClass="form-control" title="기타필드2" maxlength="30" /></td>
			</tr>
			<tr>
				<th>기타필드3</th>
				<td><form:input path="varVl3" cssClass="form-control" title="기타필드3" maxlength="30" /></td>
				<th>기타필드4</th>
				<td><form:input path="varVl4" cssClass="form-control" title="기타필드4" maxlength="30" /></td>
			</tr>
			<tr>
				<th>기타필드5</th>
				<td colspan="3"><form:input path="varVl5" cssClass="form-control" title="기타필드5" maxlength="30" /></td>
			</tr>
			</tbody>
		</table>
	</div>
	</form:form>
</div>

<div class="edit-btn-group">
	<c:if test="${searchVo.searchType eq 'S' }">
	<div class="pull-left btns">
		<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="doDetail()"><i class="fa fa-arrow-left"></i></button>
	</div>
	</c:if>
	<div class="pull-right">
		<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="" data-original-title="저장" onclick="jConfirm('코드를 저장하시겠습니까?', doSubmit)"><i class="fa fa-check"></i></button>
    </div>
</div>

<script type="text/javascript">

function doDetail() {
	$.get("selectCode.do","${detailParam }", loadSuccessHandler,'html');
}


function doSubmit(){

	if(!fn_form_validation("code"))
		return;

	<c:choose>
		<c:when test="${code.cd ne null }">
		var url = "<c:url value="updateCode.do" />";
		</c:when>
		<c:otherwise>
		var url = "<c:url value="insertCode.do" />";
		</c:otherwise>
	</c:choose>

	$.ncmsLoding.startFullScreen();
	$.post(url,$('#code').serialize(), submitSuccessHandler,'json').always(function() {
				$.ncmsLoding.remove();
			});
}

$('[data-toggle="tooltip"]').tooltip();

</script>