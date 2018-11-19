<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     신재훈         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<!-- 스토리지 도메인 목록 테이블 -->
<!-- box-header -->
<div class="box-header">
	<h3 class="box-title">스토리지 도메인 목록</h3>
	<div class="box-tools">
		<div class="input-group-box">
			<div class="input-group-cell pad-right">
				<button type="button" class="btn btn-sm btn-function" onclick="fn_selectVrStrgXlsDwnl()" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" data-placement="left">
					<i class="fa fa-download"></i>
				</button>
			</div>
		</div>
	</div>
</div>
<!-- /box-header -->
<!-- box-body -->
<div class="box-body no-padding list-body">
	<form id="vrStrgFrm" name="vrStrgFrm">
	<input type="hidden" id="checkRsrcPoolId" name="checkRsrcPoolId"/>
	<table class="table table-hover table-vertical" id="vrStrgListTable">
	<caption>가상스토리지도메인목록 (센터, 존, 망구분, 자원풀, 가상화SW, 스토리지도메인명, 전체할당량(GB), 사용량(GB), VM할당량(GB), 여유량(GB))</caption>
		<colgroup>
			<col class="col5">
			<col class="colAuto">
			<col class="colAuto">
			<col class="colAuto">
			<col class="colAuto">
			<col class="colAuto">
			<col class="colAuto">
			<col class="colAuto">
			<col class="colAuto">
			<col class="colAuto">
			<col class="colAuto">
		</colgroup>
		<thead>
			<tr>
				<th></th>
				<th>센터</th>
				<th>존</th>
				<th>망구분</th>
				<th>자원풀</th>
				<th>가상화SW</th>
				<th>스토리지도메인명</th>
				<th>전체 할당량(GB)</th>
				<th>사용량(GB)</th>
				<th>VM 할당량(GB)</th>
				<th>여유량(GB)</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vrStrgVo" items="${vrStrgList }" varStatus="i">
			<c:url var="detailUrl" value="selectVrStrg.do">
				<c:forEach var="curParam" items="${param }">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:forEach>
				<c:param name="searchStrgDmnSeq" value="${vrStrgVo.strgDmnSeq }" />
			</c:url>
			<tr>
				<td>
					<input type="radio" id="strgDmnRadioBtn" name="strgDmnSeq" value="${vrStrgVo.strgDmnSeq }"/>
					<input type="hidden" id="rsrcPoolId" name="rsrcPoolId" value="${vrStrgVo.rsrcPoolId }"/>
				</td>
				<td>
					<c:out value="${vrStrgVo.regionNm }" />
				</td>
				<td>
					<c:out value="${vrStrgVo.zoneNm }" />
				</td>
				<td>
					<c:out value="${vrStrgVo.netNm }" />
				</td>
				<td>
					<c:out value="${vrStrgVo.rsrcPoolNm }" />
				</td>
				<td>
					<c:out value="${vrStrgVo.vrlzSwTyCdNm }" />
				</td>
				<td>
					<a href="<c:url value="${detailUrl }" />"title="<c:out value="${vrStrgVo.strgDmnNm}"/>"><c:out value="${cf:ellipsis(vrStrgVo.strgDmnNm, 60) }" /></a>
				</td>
				<td>
					<c:out value="${vrStrgVo.wholeAsgnCapa }" />
				</td>
				<td>
					<c:out value="${vrStrgVo.strgUseCapa }" />
				</td>
				<td>
					<c:out value="${vrStrgVo.vmAsgnCapa }" />
				</td>
				<td>
					<c:out value="${vrStrgVo.strMrgnCapa }" />
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>
</div>
<!-- box-footer -->
<div class="box-footer clearfix">
	<div class="pull-right">
		<button type="button" class="btn btn-sm btn-function" onclick="fn_selectVrStrgLunList()" title="LUN현황" disabled="disabled">LUN현황</button>
	</div>
</div>
<!-- /box-footer -->

<script type="text/javascript">

function fn_selectVrStrgXlsDwnl(){
	var rsrcPoolId = $('#vrStrgFrm input:hidden[name="rsrcPoolId"]').val();
	$('#vrStrgFrm input:hidden[name="checkRsrcPoolId"]').val(rsrcPoolId);

	jConfirm("스토리지 목록을 다운로드 하시겠습니까?", function() {
		$("#vrStrgFrm").attr("action", "selectVrStrgListXlsDwnl.do");
		$("#vrStrgFrm").submit();
	});
}



$("#vrStrgListTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	order : [ [ 0, "desc" ] ]
});
</script>