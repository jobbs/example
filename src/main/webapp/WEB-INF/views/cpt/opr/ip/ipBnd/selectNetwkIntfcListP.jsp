<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 6.
 * @lastmodified 2016. 10. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 6.     신재훈         v1.0             최초생성
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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<form id="nicFrm" name="nicFrm">
<table class="table table-vertical table-hover" id="nicListTable">
<caption>NIC목록 (네트워크명, 용도, IP주소, MAC주소)</caption>
	<thead>
		<tr>
			<th></th>
			<th>네트워크인터페이스명</th>
			<th>용도</th>
			<th>IP주소</th>
			<th>MAC주소</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="NetwkIntfcVo" items="${netwkIntfcList }" varStatus="i">
			<tr>
				<td><input type="radio" name="netwkIntfcSeq" value="${NetwkIntfcVo.netwkIntfcSeq }"></td>
				<td class="alignL"><c:out value="${NetwkIntfcVo.netwkIntfcNm }" /></td>
				<td><c:out value="${NetwkIntfcVo.nicPrposCdNm }" /></td>
				<td><c:out value="${NetwkIntfcVo.ipAddr }" /></td>
				<td><c:out value="${NetwkIntfcVo.macAddr }" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</form>
<script type="text/javascript">

$("#nicFrm input:radio[name='netwkIntfcSeq']").click(function(event) {
	event.stopPropagation();
});

$("#nicFrm input:radio[name='netwkIntfcSeq']").parent().parent().click(function() {
	var $target = $(this).find("input[name='netwkIntfcSeq']");
	if( $target.attr("type") == "radio" ) {
		$target.prop("checked", true);
	} else {
		var checked = $target.prop("checked");
		$target.prop("checked", !checked);
	}
});

$("#nicListTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	               {sWidth : "35px" },
	               {sWidth : "150px" },
	               {sWidth : "150px" },
	               {sWidth : "150px" },
	               {sWidth : "150px" }
	],
	order : [ [ 0, "desc" ] ]
});
</script>

