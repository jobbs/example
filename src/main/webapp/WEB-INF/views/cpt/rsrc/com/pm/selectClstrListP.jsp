<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 20.
 * @lastmodified 2016. 10. 20.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 20.     최경철         v1.0             최초생성
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


<table id="clstrInfoTable" class="table table-hover table-vertical table-layout-fixed">
	<caption>클러스터 정보 테이블</caption>
	<thead>
		<tr>
			<th><nobr>선택</nobr></th>
			<th><nobr>센터</nobr></th>
			<th><nobr>존</nobr></th>
			<th><nobr>망구분</nobr></th>
			<th><nobr>자원풀</nobr></th>
			<th><nobr>클러스터ID</nobr></th>
			<th><nobr>클러스터명</nobr></th>
			<th><nobr>물리서버수</nobr></th>
			<th><nobr>가상서버수</nobr></th>
			<th><nobr>CPU<br>사용률(%)</nobr></th>
			<th><nobr>CPU<br>vCore</nobr></th>
			<th><nobr>CPU<br>가상화율(%)<br>(Ent/Core)</nobr></th>
			<th><nobr>메모리<br>사용률(%)</nobr></th>
			<th><nobr>메모리<br>가상화율(%)<br>(GB/GB)</nobr></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="clstrVo" items="${clstrVoList }" varStatus="i">
			<c:if test='${null ne clstrVo.ctlTrgtYn and "Y" eq clstrVo.ctlTrgtYn}'>
				<tr>
					<td><input type="radio" name="clstrSeq" title="선택여부" class="essential" value="${clstrVo.clstrSeq }" ></td>
					<td class="alignL"><nobr title="<c:out value="${clstrVo.regionNm }" />"><c:out value="${clstrVo.regionNm }" /></nobr></td>
					<td class="alignL"><nobr title="<c:out value="${clstrVo.zoneNm }" />"><c:out value="${clstrVo.zoneNm }" /></nobr></td>
					<td class="alignL"><nobr title="<c:out value="${clstrVo.netClCdNm }" />"><c:out value="${clstrVo.netClCdNm }" /></nobr></td>
					<td class="alignL"><nobr title="<c:out value="${clstrVo.rsrcPoolNm }" />"><c:out value="${clstrVo.rsrcPoolNm }" /></nobr></td>
					<td class="alignL"><nobr><c:out value="${clstrVo.clstrId }" /></nobr></td>
					<td class="alignL"><nobr><c:out value="${clstrVo.clstrNm }" /></nobr></td>
					<td class="alignR"><nobr><c:out value="${clstrVo.pmCnt }" /></nobr></td>
					<td class="alignR"><nobr><c:out value="${clstrVo.vmCnt }" /></nobr></td>
					<td class="notellipsis">
						<span class="label label-green"><fmt:formatNumber value="${clstrVo.avgCpuUseRt}" pattern="0"/></span>
						<div class="progress">
							<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${clstrVo.avgCpuUseRt}" pattern="0"/>%"></div>
						</div>
					</td>
					<td class="alignR"><nobr><c:out value="${clstrVo.totCpuVcoreQty }"/></nobr></td>
					<td class="alignR"><nobr><fmt:formatNumber value="${clstrVo.cpuVrlzRt}" pattern="0"/> (<c:out value="${clstrVo.totCpuEnt }"/>/<c:out value="${clstrVo.totCpuCoreQty }"/>)</nobr></td>
					<td class="notellipsis">
						<span class="label label-green"><fmt:formatNumber value="${clstrVo.avgMemUseRt}" pattern="0"/></span>
						<div class="progress">
							<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${clstrVo.avgMemUseRt}" pattern="0"/>%"></div>
						</div>
					</td>
					<td class="alignR"><nobr><fmt:formatNumber value="${clstrVo.memVrlzRt}" pattern="0"/> (<c:out value="${clstrVo.totMemAsgnCapa }"/>/<c:out value="${clstrVo.totMemCapa }"/>)</nobr></td>
				</tr>
			</c:if>
		</c:forEach>
	</tbody>
</table>

<script type="text/javascript">

$("#frm input[name='clstrSeq']").click(function(event) {
	event.stopPropagation();
});

$("#frm input[name='clstrSeq']").parent().parent().click(function() {
	var $target = $(this).find("input[name='clstrSeq']");
	if( $target.attr("type") == "radio" ) {
		$target.prop("checked", true);
	} else {
		var checked = $target.prop("checked");
		$target.prop("checked", !checked);
	}
});

$("#clstrInfoTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	                {sWidth : "41px" },
	                {sWidth : "28px" }, //센터
	           		{sWidth : "25px" }, //존
	           		{sWidth : "60px" }, //망
	           		{sWidth : "100px" }, //자원풀*
	                {sWidth : "70px" },
	                {sWidth : "176px" },
	                {sWidth : "61px" },
	                {sWidth : "61px" },
	                {sWidth : "60px" },
	                {sWidth : "43px" },
	                {sWidth : "76px" },
	                {sWidth : "59px" },
	                {sWidth : "74px" }
	 ]
});

</script>