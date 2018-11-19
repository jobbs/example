<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자원요청상세  SLB 생성</pre>
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 6.
 * @lastmodified 2016. 10. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 6.     김봉민         v1.0             최초생성
 *
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<script type="text/javascript" src="<c:url value="/resources/js/common/validation.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>
<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100 detail-col">

	<form:form commandName="rrVo" name="rsrcReqSlbCreFrm" id="rsrcReqSlbCreFrm" method="post" action="">
		<form:hidden path="rsrcReqNo" />
		<form:hidden path="rsrcReqSeq" />
		<form:hidden path="rsrcReqTyCd" />
		<form:hidden path="schRsrcReqNo" value="${rrVo.rsrcReqNo}" />
	</form:form>

	<!-- 자원요청 기본정보  -->
	<%@ include file="selectRsrcReqInfo.jsp" %>

	<div class="box detail-list-box">
		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">SLB설정 정보</h3>
		</div>
		<!-- /box-header -->
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>SLB설정 상세 정보</caption>
				<colgroup>
					<col class="col12">
					<col class="col5">
					<col class="col4">
					<col class="col18">
					<col class="col10">
					<col class="col10">
					<col class="col6">
					<col class="col6">
					<col class="col6">
					<col class="col6">
					<col class="colAuto">
				</colgroup>
				<tbody>
					<tr>
						<th rowspan="2">VIP</th>
						<th colspan="2">리스너 정보</th>
						<th colspan="3">풀 정보</th>
						<th colspan="5">모니터링 정보</th>
					</tr>
					<tr>
						<th>프로토콜</th>
						<th>포트</th>
						<th>유형</th>
						<th>세션 유지유형</th>
						<th>세션 유지값</th>
						<th>상태확인</th>
						<th>상태확인<br>주기(초)
						</th>
						<th>상태확인<br> 타임아웃(초)
						</th>
						<th>최대시도<br>횟수
						</th>
						<th>상태확인 HTTP URL</th>
					</tr>

					<c:choose>
						<c:when test="${rrnwVoList eq null or empty rrnwVoList }">
							<tr>
								<td colspan="11">검색된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="netwkVo" items="${rrnwVoList}"
								varStatus="netwkVar">
								<tr>
									<td><c:out value="${netwkVo.vipAddr}" /></td>
									<td><c:out value="${netwkVo.prtclNm}" /></td>
									<td><c:out value="${netwkVo.port}" /></td>
									<td><c:out value="${netwkVo.slbTyNm}" /></td>
									<td><c:out value="${netwkVo.sessMntncTyNm}" /></td>
									<td><c:out value="${netwkVo.sessMntncVl}" /></td>
									<td><c:out value="${netwkVo.statConfrm}" /></td>
									<td><c:out value="${netwkVo.statConfrmCycle}" /></td>
									<td><c:out value="${netwkVo.statConfrmTOut}" /></td>
									<td><c:out value="${netwkVo.maxTryCnt}" /></td>
									<td><c:out value="${netwkVo.statConfrmHttpUrl}" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->
	</div>

	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">SLB 적용대상 정보</h3>
		</div>
		<!-- box-body -->
		<div class="box-body no-padding">
			<table class="table table-horizon table-vertical table-layout-fixed"  id="tblSlbIp">
				<caption>SLB적용대상정보</caption>
				<thead>
					<tr><th>No.</th>
						<th>VIP</th>
						<th>IP</th>
						<th>포트</th>
						<th>가중치<br><small>(로드밸런싱)</small></th>
						<th>설명</th></tr>
				<tbody>
					<c:forEach var="vo" items="${rrnwSlbciqVoList}" varStatus="i">
						<tr><td class="alignC"><c:out value="${i.count}" /></td>
							<td class="alignC"><c:out value="${vo.vipAddr}" /></td>
							<td class="alignC"><c:out value="${vo.ipAddr}" /></td>
							<td class="alignC"><c:out value="${vo.port}" /></td>
							<td class="alignC"><c:out value="${vo.wvl}" /></td>
							<td><c:out value="${vo.dc}" /></td></tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->
	</div>
</div>
<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<c:url var="listUrl" value="selectRsrcReqList.do">
			<c:forEach var="curParam" items="${param }">
				<c:if test="${curParam.key ne 'boardSeq'}">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:if>
			</c:forEach>
		</c:url>

		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip"
				title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')">
				<i class="fa fa-arrow-left"></i>
			</button>
		</div>
		<c:choose>
			<c:when test="${rrVo.rsrcReqPrcssStatCd eq '01'}">
				<div class="pull-right btns">
					<menu:authorize authType="act" onlyOprAdm="true">
						<button class="btn btn-sm btn-hover-green" data-toggle="tooltip"
							title="" data-original-title="실행"
							onclick="javascript:fn_updateRrscReqSlbConfReqExe();">
							<i class="fa fa-play-circle"></i>
						</button>
						<button class="btn btn-sm btn-hover-red" data-toggle="tooltip"
							title="" data-original-title="반려"
							onclick="javascript:fn_updateRrscReqSlbConfReqRjct();">
							<i class="fa fa-times"></i>
						</button>
					</menu:authorize>

					<menu:modAuthorize regId="${rrVo.regUserId }">
						<button id = "deleteRsrcReqBtn" class="btn btn-sm btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="javascript:fn_deleteRsrcReq()"><i class="fa fa-minus"></i></button>
					</menu:modAuthorize>
				</div>
			</c:when>
		</c:choose>
	</div>
</div>
<!-- /페이지 버튼 영역 -->

<script type="text/javascript">

	/**
	 * 초기 구동
	 */
	$(function() {
		var testYn = "${rrVo.testYn }"; //테스트여부
		if(testYn != 'Y') {
			$("#deleteRsrcReqBtn").hide();  //삭제버튼을 감춘다.
		}
	});

	/**
	 * 실행
	 */
	function fn_updateRrscReqSlbConfReqExe() {
		jConfirm("실행하시겠습니까", function(result) {

			$.ncmsLoding.startFullScreen();
			$.post('updateRsrcReqSlbCreExe.do',
					$('#rsrcReqSlbCreFrm').serialize(), function(result) {
						if (result.success) {
							jInfo(result.messageList, function() {
								fn_reloadPage();
							});
						} else {
							jAlert(result.messageList);
						}
					}, 'json').always(function() {
				$.ncmsLoding.remove();
			});
		});
	}

	//삭제 버튼 클릭 시
	function fn_deleteRsrcReq() {
		jConfirm('삭제 하시겠습니까?', function(){
			$.ncmsLoding.startFullScreen();
			$.post('updateRsrcReqDeleteYn.do', $('#rsrcReqSlbCreFrm').serialize(), function(result) {

				jInfo(result.messageList, function() {
					if( result.success) {
						goToUrl('${listUrl}');
					}
				});

			}, 'json').always(function(){$.ncmsLoding.remove();});
		});
	}

	function fn_reloadPage() {
		location.reload();
		//$("#rsrcReqSlbCreFrm").attr("action","<c:url value='/cpt/opr/req/rsrcreq/formRsrcReqSlbCre.do'/>");
		//$("#rsrcReqSlbCreFrm").submit();
	}
	/**
	 * 반려
	 */
	function fn_updateRrscReqSlbConfReqRjct() {
		var url = 'selectRsrcReqRjctP.do';
		var rsrcReqNo = $('#rsrcReqSlbCreFrm #rsrcReqNo').val();
		var rsrcReqSeq = $('#rsrcReqSlbCreFrm #rsrcReqSeq').val();
		var rsrcReqTyCd = $('#rsrcReqSlbCreFrm #rsrcReqTyCd').val();
		var params = {
			rsrcReqNo : rsrcReqNo,
			rsrcReqSeq : rsrcReqSeq,
			rsrcReqTyCd : rsrcReqTyCd
		};
		var width = 740;
		var height = 290;
		var posY = (screen.width - width) / 2;
		var posX = (screen.height - height) / 2;
		var args = {
			key : "RsrcReqRjct",
			width : width,
			height : height,
			posX : posX,
			posY : posY
		};
		windowOpen(url, params, args);
		return false;
	}

	$("#tblSlbIp").DataTable({
		dom : 'Zlfrtip',
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [
				{sWidth : "40px" },		//No
				{sWidth : "110px" },		//VIP
				{sWidth : "110px" },		//IP
				{sWidth : "40px" },		//포트
				{sWidth : "100px" },		//가중치(로드밸런싱)
				{sWidth : "350px" },		//설명
		 ],
		order : [ [ 0, "asc" ] ]
	});
</script>
