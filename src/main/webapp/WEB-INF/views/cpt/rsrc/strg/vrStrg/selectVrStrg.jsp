<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     신재훈         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="listUrl" value="selectVrStrgRsrcPoolList.do">
	<c:forEach var="curParam" items="${param }">
		<c:if test="${(curParam.key ne 'rsrcPoolId') and (curParam.key ne 'searchType')}">
			<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
		</c:if>
	</c:forEach>
</c:url>

<div class="col-box-100 detail-col">
	<div class="row">
		<div class="col-box-33 no-padding-center">
			<div class="col-info">
				<h3 class="col-info-header" style="height:50px; line-height:50px">전체량(A)</h3>
				<div class="col-info-body">
					<div class="col-info-box">
					<h4 class="num"><fmt:formatNumber value="${vrStrgVo.wholeAsgnCapa}" pattern="#,###.###"/> <small>(GB)</small></h4>
					</div>
				</div>
			</div>
		</div>
		<div class="col-box-33 no-padding-center">
			<div class="col-info">
				<h3 class="col-info-header" style="height:50px; line-height:50px">사용량(B)</h3>
				<div class="col-info-body">
					<div class="col-info-box">
					<h4 class="num"><fmt:formatNumber value="${vrStrgVo.strgUseCapa}" pattern="#,###.###"/> <small>(GB)</small></h4>
					</div>
				</div>
			</div>
		</div>
		<div class="col-box-33 no-padding-center">
			<div class="col-info">
				<h3 class="col-info-header" style="height:50px; line-height:50px">VM할당량(C)</h3>
				<div class="col-info-body">
					<div class="col-info-box">
					<h4 class="num"><fmt:formatNumber value="${vrStrgVo.sumVmAsgnCapa}" pattern="#,###.###"/> <small>(GB)</small></h4>
					</div>
				</div>
			</div>
		</div>
		<div class="col-box-33 no-padding-center">
			<div class="col-info">
				<h3 class="col-info-header" style="height:50px; line-height:50px">템플릿할당량(D)</h3>
				<div class="col-info-body">
					<div class="col-info-box">
					<h4 class="num"><fmt:formatNumber value="${vrStrgVo.tmplatAsgnCapa}" pattern="#,###.###"/> <small>(GB)</small></h4>
					</div>
				</div>
			</div>
		</div>
		<div class="col-box-33 no-padding-center">
			<div class="col-info">
				<h3 class="col-info-header" style="height:50px; line-height:50px">VM스냅샷할당량(E)</h3>
				<div class="col-info-body">
					<div class="col-info-box">
					<h4 class="num"><fmt:formatNumber value="${vrStrgVo.sumVmSnapshtAsgnCapa}" pattern="#,###.###"/> <small>(GB)</small></h4>
					</div>
				</div>
			</div>
		</div>
		<div class="col-box-33 no-padding-center">
			<div class="col-info">
				<h3 class="col-info-header">VM가용여유량(F)<br>(F = A - C - D - E)</h3>
				<div class="col-info-body">
					<div class="col-info-box">
					<h4 class="num"><fmt:formatNumber value="${(vrStrgVo.wholeAsgnCapa - vrStrgVo.sumVmAsgnCapa  - vrStrgVo.tmplatAsgnCapa - vrStrgVo.sumVmSnapshtAsgnCapa)}" pattern="#,###.##"/> <small>(GB)</small></h4>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="box detail-list-box">
		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">상세정보</h3>
		</div>
		<!-- /box-header -->
		<!-- box-body -->
		<form id="selectVrStrgFrm" name="selectVrStrgFrm" action="get">
		<input type="hidden" name="selectStrgDmnSeq" value="${vrStrgVo.strgDmnSeq }"/>
		<div class="box-body no-padding">
			<table class="table table-horizon">
			<caption>가상스토리지도메인상세 (센터, 존, 망구분, 자원풀, 스토리지명)</caption>
				<colgroup>
					<col class="col13">
					<col class="col20">
					<col class="col13">
					<col class="col20">
					<col class="col13">
					<col class="col20">
				</colgroup>
				<tbody>
					<tr>
						<th>센터</th><td class="alignL"><c:out value="${vrStrgVo.regionNm}"/></td>
						<th>존</th><td class="alignL"><c:out value="${vrStrgVo.zoneNm}"/></td>
						<th>망구분</th><td class="alignL"><c:out value="${vrStrgVo.netNm}"/></td>
					</tr>
					<tr>
						<th>자원풀</th><td class="alignL"><c:out value="${vrStrgVo.rsrcPoolNm}"/></td>
						<th>스토리지명</th><td rowspan="2" class="alignL"><c:out value="${vrStrgVo.strgDmnNm}"/></td>
					</tr>
				</tbody>
			</table>
		</div>
		</form>
		<!-- /box-body -->
		<!-- box-foot -->
		<div class="box-footer clearfix">
			<div class="pull-right">
				<button type="button" class="btn btn-sm btn-function" title="LUN현황" onclick="fn_selectLunListP()" disabled="disabled">LUN현황</button>
			</div>
		</div>
		<!-- /box-foot -->
	</div>
</div>
<!-- Tab 영역 시작 -->
<div class="col-box-100 detail-col">
	<div class="nav-tabs-custom">
		<!-- 메뉴 영역 -->
		<ul class="nav nav-tabs">
			<li class="<c:if test="${searchVo.searchType eq 'vm' }">active</c:if>"><a href="#tab-contents" onclick="fn_changTab('vm')" data-toggle="tab">가상서버</a></li>
			<li class="<c:if test="${searchVo.searchType eq 'tmplat' }">active</c:if>"><a href="#tab-tmplat" onclick="fn_changTab('tmplat')" data-toggle="tab">템플릿</a></li>
		</ul>
		<!-- 컨텐츠 영역 -->
		<div class="tab-content">
			<div class="tab-pane active" id="tab-contents">
				<c:if test="${(searchVo.searchType eq 'vm') or (vmSearchVo.searchType eq 'vm')}"><jsp:include page="selectVrStrgVm.jsp" flush="false" /></c:if>
				<c:if test="${(searchVo.searchType eq 'tmplat') or (tmplatSearchVo.searchType eq 'tmplat') }"><jsp:include page="selectVrStrgTmplat.jsp" flush="false" /></c:if>
			</div>
		</div>
	</div>
</div>
<!-- Tab 영역 종료 -->
<!-- <div class="col-box-100"> -->
<!-- 	<div class="edit-btn-group"> -->
<!-- 		<div class="pull-left btns"> -->
<%-- 			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button> --%>
<!-- 		</div> -->
<!-- 		<div class="pull-right btns"> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->

<script type="text/javascript">
function fn_changTab(type) {
	location.href="<c:url value="selectVrStrg.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'searchType'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>&searchType=" + type;
}

function goToUrl(url) {
	location.href = url;
}

//팝업창 중앙에 위치를 위한 값 전달
function getStatus(width, height){
	var left = (screen.width - width) / 2;
	var top =  (screen.height - height) / 2;
	var params = 'width='+width+', height='+height;
	params += ', top='+top+', left='+left;
	params += ', directories=no';
	params += ', location=no';
	params += ', menubar=no';
	params += ', resizeble=no';
	params += ', scrollbars=no';
	params += ', status=no';
	params += ', toolbar=no';

	return params;
}

function fn_selectLunListP(){

	var target = "selectLunListP";
	window.open("", target, getStatus(1280, 720));

	$('#selectVrStrgFrm').attr("target", target);
	$('#selectVrStrgFrm').attr("action", "selectLunListP.do");
	$('#selectVrStrgFrm').submit();
}
</script>

