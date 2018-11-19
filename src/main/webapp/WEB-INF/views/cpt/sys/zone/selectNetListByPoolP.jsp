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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<div class="col-box-100">
	<div class="box">

		<div class="box-header">
			<h3 class="box-title">존 정보</h3>
		</div><!-- /box-header -->

		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>존 정보 테이블</caption>
				<colgroup>
					<col class="col20">
					<col class="col30">
					<col class="col20">
					<col class="col30">
				</colgroup>
				<tbody>
				<tr>
					<th>센터ID</th>
					<td><c:out value="${zone.region.regionId }" /></td>
					<th>센터명</th>
					<td><c:out value="${zone.region.regionNm }" /></td>
				</tr>
				<tr>
					<th>존ID</th>
					<td><c:out value="${zone.zoneId }" /></td>
					<th>존명</th>
					<td><c:out value="${zone.zoneNm }" /></td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="box">

		<div class="box-header">
			<h3 class="box-title">망 정보</h3>
		</div><!-- /box-header -->

		<div class="box-body no-padding">
			<form action="netFrm" id="netFrm">
			<table class="table table-hover table-vertical">
				<caption>망정보 테이블</caption>
				<colgroup>
					<col class="col10">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
				</colgroup>
				<thead>
				<tr>
					<th></th>
					<th>망ID</th>
					<th>망명</th>
					<th>망구분코드</th>
					<th>망구분명</th>
				</tr>
				</thead>
				<tbody>
				<c:choose>
				 	<c:when test="${nets eq null or empty nets }">
						<tr>
							<td colspan="5" class="alignC">센터와 존에 해당하는 망정보 중 자원풀의 망구분 정보와 일치하는 망이 없습니다.</td>
						</tr>
				 	</c:when>
					<c:otherwise>
						<c:forEach var="net" items="${nets }" varStatus="i">
						<tr>
							<td>
								<input type="radio" name="netId" value="${net.netId }"/>
								<input type="hidden" name="netNm" value="${net.netNm }" />
								<input type="hidden" name="netClCd" value="${net.netClCd }" />
								<input type="hidden" name="netClNm" value="${net.netClNm }" />
							</td>
							<td><c:out value="${net.netId  }" /></td>
							<td><c:out value="${net.netNm  }" /></td>
							<td><c:out value="${net.netClCd  }" /></td>
							<td><c:out value="${net.netClNm  }" /></td>
						</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
			</form>
		</div>
	</div>
</div>

<div class="col-box-100">
	<div class="button">
		<menu:authorize>
		<button type="button" class="btn btn-dark" onclick="selectNet()">선택</button>
		</menu:authorize>
		<button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
	</div>
</div>

<menu:authorize>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>
<script type="text/javascript">
function selectNet(){

	if( $("input:radio[name='netId']:checked").size() == 0 ) {
		jAlert("망을 선택하여 주시기 바랍니다.");
		return;
	}

	var data = null;
	$("input:radio[name='netId']").each(function(index) {
		if( $(this).prop("checked") ) {
			data = new EntityNet();
			data.regionId = "${zone.region.regionId }";
			data.zoneId = "${zone.zoneId }";
			data.netId = $(this).val();
			data.netNm = $("input:hidden[name='netNm']:eq(" + index + ")").val();
			data.netClCd = $("input:hidden[name='netClCd']:eq(" + index + ")").val();
			data.netClNm = $("input:hidden[name='netClNm']:eq(" + index + ")").val();
		}
	});

	var evt = jQuery.Event('selectNet', {
		"procType" : "selectNet",
		"datas" : data
    });

    var _parent = window.opener;
    _parent.jQuery(_parent.document).trigger(evt);
    window.close();
}

$("#netFrm input[name='netId']").click(function(event) {
	event.stopPropagation();
});

$("#netFrm input[name='netId']").parent().parent().click(function() {
	var $target = $(this).find("input[name='netId']");
	if( $target.attr("type") == "radio" ) {
		$target.prop("checked", true);
	} else {
		var checked = $target.prop("checked");
		$target.prop("checked", !checked);
	}
});
</script>
</menu:authorize>


