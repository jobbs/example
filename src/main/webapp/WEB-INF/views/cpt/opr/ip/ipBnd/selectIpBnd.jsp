<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 29.
 * @lastmodified 2016. 10. 29.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 29.     신재훈         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="listUrl" value="selectIpBndList.do">
	<c:forEach var="curParam" items="${param }">
		<c:if test="${(curParam.key ne 'bndSeq') and (curParam.key ne 'searchType')}">
			<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
		</c:if>
	</c:forEach>
</c:url>

<c:url var="detailUrl" value="selectIpBnd.do">
	<c:forEach var="curParam" items="${param }">
		<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
	</c:forEach>
	<c:param name="ipBndSeq" value="${ipBndVo.bndSeq }" />
</c:url>

<c:url var="ipListXlsDwnl" value="selectIPListXlsDwnl.do">
	<c:param name="ipBndSeq" value="${ipBndVo.bndSeq }"></c:param>
</c:url>

<div class="col-box-100 detail-col">
	<div class="box">
		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">상세정보</h3>
		</div>
		<!-- /box-header -->
		<!-- box-body -->
		<div class="box-body no-padding">
			<table class="table table-horizon">
			<caption>IP대역기본정보 (IP대역명, 망구분, 사용부처)</caption>
				<colgroup>
					<col class="col8">
					<col class="col17">
					<col class="col8">
					<col class="col17">
					<col class="col8">
					<col class="col17">
					<col class="col8">
					<col class="col17">
				</colgroup>
				<tbody>
					<c:choose>
						<c:when test="${searchVo.searchType eq 'info'}">
							<tr>
								<th>IP대역명</th>
								<td><c:out value="${ipBndVo.ipBndNm}"/></td>
								<th>센터</th>
								<td><c:out value="${ipBndVo.regionNm}"/></td>
								<th>망구분</th>
								<td><c:out value="${ipBndVo.netNm}"/></td>
								<th>사용부처</th>
								<td><c:out value="${ipBndVo.institutionNm}"/></td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<th>IP대역명</th>
								<td><c:out value="${ipBndVo.ipBndNm}"/></td>
								<th>센터</th>
								<td><c:out value="${ipBndVo.regionNm}"/></td>
								<th>망구분</th>
								<td><c:out value="${ipBndVo.netNm}"/></td>
								<th>사용부처</th>
								<td><c:out value="${ipBndVo.institutionNm}"/></td>
							</tr>
							<tr>
								<th>시작IP</th>
								<td><c:out value="${ipBndVo.bndStrtIp}"/></td>
								<th>종료IP</th>
								<td><c:out value="${ipBndVo.bndEndIp}"/></td>
								<th>서브넷마스크</th>
								<td><c:out value="${ipBndVo.subnetMask}"/></td>
								<th>게이트웨이</th>
								<td><c:out value="${ipBndVo.gtwyIpAddr}"/></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->
	</div>
	<!-- Tab 영역 -->
	<div class="nav-tabs-custom">
		<!-- 메뉴 영역 -->
		<ul class="nav nav-tabs">
			<li class="<c:if test="${searchVo.searchType eq 'info' }">active</c:if>"><a href="#tab-info" onclick="fn_changTab('info')" data-toggle="tab">기본정보</a></li>
			<li class="<c:if test="${searchVo.searchType eq 'asgn' }">active</c:if>"><a href="#tab-contents" onclick="fn_changTab('asgn')" data-toggle="tab">할당</a></li>
			<li class="<c:if test="${searchVo.searchType eq 'unasgn' }">active</c:if>"><a href="#tab-unAsgn" onclick="fn_changTab('unasgn')" data-toggle="tab">미할당</a></li>
			<li class="<c:if test="${searchVo.searchType eq 'block' }">active</c:if>"><a href="#tab-block" onclick="fn_changTab('block')" data-toggle="tab">Block</a></li>
			<li class="<c:if test="${searchVo.searchType eq 'static' }">active</c:if>"><a href="#tab-static" onclick="fn_changTab('static')" data-toggle="tab">스태틱라우터 설정</a></li>
		</ul>

		<!-- 컨텐츠 영역 -->
		<div class="tab-content">
			<!-- 할당 -->
			<div class="tab-pane active" id="tab-contents">
				<!-- 기본정보 -->
				<c:if test="${searchVo.searchType eq 'info' }"><jsp:include page="selectIpBndInfo.jsp" flush="false" /></c:if>
				<!-- 할당 -->
				<c:if test="${searchVo.searchType eq 'asgn' }"><jsp:include page="selectIpAsgn.jsp" flush="false" /></c:if>
				<!-- 미할당 -->
				<c:if test="${searchVo.searchType eq 'unasgn' }"><jsp:include page="selectIpUnAsgn.jsp" flush="false" /></c:if>
				<!-- Block -->
				<c:if test="${searchVo.searchType eq 'block' }"><jsp:include page="selectIpBlk.jsp" flush="false" /></c:if>
				<!-- Static Router -->
				<c:if test="${searchVo.searchType eq 'static' }"><jsp:include page="selectSRoutList.jsp" flush="false" /></c:if>
			</div>
		</div>
	</div>
</div>
<!-- <div class="col-box-100"> -->
<!-- 	<div class="edit-btn-group"> -->
<!-- 		<div class="pull-left btns"> -->
<%-- 			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button> --%>
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->

<script type="text/javascript">
function fn_changTab(type) {
	location.href="<c:url value="selectIpBnd.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'searchType'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>&searchType=" + type;
}

function goToUrl(url) {
	location.href = url;
}

function fn_selectIpListXlsDwnl(){
	jConfirm('IP목록을 엑셀파일로 다운로드 받으시겠습니까?', function() {
		goToUrl('${ipListXlsDwnl}');
	});
}

// IP 체크
function fn_inputIpCheck(ip){
	var pattern = /^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/;

	if(pattern.test(ip)){
		// split into units with dots '.'
		var parts = ip.split(".");
		if(parts.length != 4){
			return false;
		}

		if(parseInt(parseFloat(parts[0])) == 0){
			return false;
		}

		if(parseInt(parseFloat(parts[3])) == 0){
			return false;
		}

		for(var i=0; i<parts.length; i++){
			if(i == 0){
				if(parseInt(parseFloat(parts[i])) > 223){
					return false;
				}
			}
			else {
				if(parseInt(parseFloat(parts[i])) > 255){
					return false;
				}
			}
		}
		return true;
	}
	else {
		return false;
	}
}

//서브넷마스크 검사
function fn_subnetMaskCheck(subnetMask){
	var pattern = /^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/;

	if(pattern.test(subnetMask)){
		var parts = subnetMask.split(".");
		if(parts.length != 4){
			return false;
		}

		if(parseInt(parseFloat(parts[0])) == 0){
			return false;
		}

		for(var i=0; i<parts.length; i++){
			if(parseInt(parseFloat(parts[i])) > 255){
				return false;
			}
		}
	}
	else {
		return false;
	}
	return true;
}


// NAT 체크
function nat_ip_validation(){
	var checkCnt = $('input[id*=natIpAddr]').length;
	for( var i=0; i < checkCnt; i++ ) {
		if($('input[id*=natIpAddr]').eq(i).val().length > 0){
			if( !fn_inputIpCheck($('input[id*=natIpAddr]').eq(i).val()) ) {
				jAlert("IP(NAT) 형식이 맞지 않습니다.", function() {
					$('input[id*=natIpAddr]').eq(i).focus();
				});
				return false;
			}
		}
	}
	return true;
}

function getSRoutCnt(){
	// TODO 수정필요
	return $("#sRoutListTable input[name='sRoutList[].ipBndAddr']").length;
}

</script>