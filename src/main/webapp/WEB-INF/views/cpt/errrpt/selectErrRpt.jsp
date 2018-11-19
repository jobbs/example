<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 07.
 * @lastmodified 2016. 10. 07.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 07.     박봉춘         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:set var="listParam" value="${cf:queryString(param, '') }"></c:set>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">결함내용</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<colgroup>
					<col width="130px;"/>
					<col width="*"/>
				</colgroup>
				<tbody>
				<tr>
					<th>카테고리</th>
					<td><c:out value="${vo.errCateNm }" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><c:out value="${vo.errTitle }" /></td>
				</tr>
				<tr>
					<th>결함구분</th>
					<td><c:out value="${vo.errTyNm }" /></td>
				</tr>
				<tr>
					<th>진행상태</th>
					<td>
						<c:choose>
							<c:when test="${vo.procssStatCd eq 'REG' }">
							<span class="status status-gray"><c:out value="${vo.procssStatNm }" /></span>
							</c:when>
							<c:when test="${vo.procssStatCd eq 'CNFRM' }">
							<span class="status status-aqua"><c:out value="${vo.procssStatNm }" /></span>
							</c:when>
							<c:when test="${vo.procssStatCd eq 'ACTING' }">
							<span class="status status-yellow"><c:out value="${vo.procssStatNm }" /></span>
							</c:when>
							<c:when test="${vo.procssStatCd eq 'ACTCMP' }">
							<span class="status status-green"><c:out value="${vo.procssStatNm }" /></span>
							</c:when>
						</c:choose>
					</td>
				</tr>
				<tr>
					<th>담당자</th>
					<td><c:out value="${vo.chargeNm }" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td class="editor"><c:out value="${vo.errCont }" escapeXml="false"/></td>
				</tr>
				<tr>
					<th>등록자</th>
					<td><c:out value="${vo.regUsrNm }" /></td>
				</tr>
				<c:choose>
					<c:when test="${fn:length(vo.errRptFiles) > 0 }">
					<tr>
						<th>첨부파일</th>
						<td>
							<c:forEach var="file" items="${vo.errRptFiles }">
								<c:url var="downUrl" value="downfile.do">
									<c:param name="seq" value="${file.seq }"/>
								</c:url>
								<a href="<c:out value="${downUrl }" />"><c:out value="${file.originFileName }"/></a>
							</c:forEach>
						</td>
					</tr>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</div>

<!-- 페이지 버튼 -->
<div class="col-box-100">
	<div class="edit-btn-group">

		<c:url var="updateUrl" value="updateErrRpt.do">
			<c:forEach var="curParam" items="${param }">
				<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
			</c:forEach>
		</c:url>
		<c:url var="listUrl" value="selectErrRptList.do">
			<c:forEach var="curParam" items="${param }">
				<c:if test="${curParam.key ne 'errRptSeq'}">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:if>
			</c:forEach>
		</c:url>
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right">

		<menu:modAuthorize regId="${vo.regUsrId }">
			<button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="수정" onclick="goToUrl('${updateUrl}')"><i class="fa fa-eraser"></i></button>
			<button class="btn btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="doDelete()"><i class="fa fa-times"></i></button>
		</menu:modAuthorize>
		</div>
	</div>
</div>

<div class="col-box-100 detail-col">
	<form name="errRptprocss" id="errRptprocss" method="post">
	<input type="hidden" name="errRptSeq" value="${vo.errRptSeq }" />
	<input type="hidden" name="errRptProcssSeq" id="errRptProcssSeq" />
	<input type="hidden" name="procType" id="procType" value="INSERT" />
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">처리현황</h3>
		</div>

		<div class="box-body no-padding">
			<table class="table table-horizon">
				<colgroup>
					<col width="130px;"/>
					<col width="*"/>
				</colgroup>
				<tbody>
				<tr>
					<th>처리상태</th>
					<td>
						<nform:selectCode parentCd="ERRSTT" parentGrpCd="070" name="procssStatCd" id="procssStatCd" cssClass="form-control input-sm" />
					</td>
				</tr>
				<tr>
					<th>처리내용</th>
					<td><textarea id="procssCont" name="procssCont" class="form-control essential" title="처리내용"></textarea></td>
				</tbody>
				</tbody>
			</table>
		</div>
		<div class="box-footer clearfix">
		  <div class="pull-right">
		      <button type="button" class="btn btn-sm btn-function" onclick="doInsertProcss()">저장</button>
		  </div>
		</div>
	</div>
	</form>
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-vertical" id="procssTbl">
				<colgroup>
					<col width="100px;"/>
					<col width="*"/>
					<col width="150px;"/>
					<col width="150px;"/>
					<col width="80px;"/>
				</colgroup>
				<thead>
					<th>처리상태</th>
					<th>처리내용</th>
					<th>처리일시</th>
					<th>처리자</th>
					<th></th>
				<tbody>
				<c:forEach items="${vo.errRptRpocsses }" var="errRptProcss" varStatus="idx">
				<tr>
					<td>
						<c:choose>
							<c:when test="${errRptProcss.procssStatCd eq 'REG' }">
							<span class="status status-gray"><c:out value="${errRptProcss.procssStatNm }" /></span>
							</c:when>
							<c:when test="${errRptProcss.procssStatCd eq 'CNFRM' }">
							<span class="status status-aqua"><c:out value="${errRptProcss.procssStatNm }" /></span>
							</c:when>
							<c:when test="${errRptProcss.procssStatCd eq 'ACTING' }">
							<span class="status status-yellow"><c:out value="${errRptProcss.procssStatNm }" /></span>
							</c:when>
							<c:when test="${errRptProcss.procssStatCd eq 'ACTCMP' }">
							<span class="status status-green"><c:out value="${errRptProcss.procssStatNm }" /></span>
							</c:when>
						</c:choose>
					</td>
					<td class="alignL">
						${cf:nl2br(errRptProcss.procssCont) }
					</td>
					<td><fmt:formatDate value="${errRptProcss.regDttm }" pattern="yyyy-MM-dd HH:mm" /></td>
					<td><c:out value="${errRptProcss.regUsrId }" /></td>
					<td>
						<c:if test="${idx.count eq 1}">
							<menu:authorize>
							<button type="button" class="btn btn-default btn-sm" onclick="doUpdateErrRptProcss('${errRptProcss.errRptProcssSeq}')">수정</button>
							<button type="button" class="btn btn-red btn-sm" onclick="doProcssDelete('<c:out value="${errRptProcss.errRptProcssSeq }" />')">삭제</button>
							</menu:authorize>
						</c:if>
					</td>
				</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<script type="text/javascript">

function doInsertProcss() {

	jConfirm("처래 내용을 저장하시겠습니까?", function() {
		var url = "";
		if( $("#procType") == "INSERT" ) {
			url = "insertErrRptProcss.do";
		} else {
			url = "updateErrRptProcss.do";
		}

		$.post(url, $("#errRptprocss").serialize(), function(result) {

			alert_message(result.messageList, function() {
				if( result.success) {
					location.reload();
				}
			});

		}, "json");
	});


}

function goErrRptProcss() {
	location.href = 'insertErrRptProcss.do?${listParam }'
}

function doDelete(){

	jConfirm("오류사항을 삭제하시겠습니까?", function() {
		$.post("deleteErrRpt.do", {"errRptSeq": ${vo.errRptSeq}}, function(result) {

			alert_message(result.messageList, function() {
				if( result.success) {
					goToUrl('${listUrl}');
				}
			});

		}, "json");
	});
}

function doUpdateErrRptProcss(errRptProcssSeq) {
	$.get("selectErrRptProcss.do", {"errRptProcssSeq": errRptProcssSeq}, function(result) {

		alert_message(result.messageList, function() {
			if( result.success) {
				var data = result.data;

				$("#procType").val("UPDATE");
				$("#errRptProcssSeq").val(errRptProcssSeq);
				$("#procssStatCd").val(data.procssStatCd);
				$("#procssCont").val(data.procssCont);
			}
		});

	},"json");
}

function doProcssDelete(errRptProcssSeq) {
	jConfirm("처리현황을 삭제하시겠습니까?", function() {
		$.post("deleteErrRptProcss.do", {"errRptProcssSeq": errRptProcssSeq}, function(result) {

			alert_message(result.messageList, function() {
				if( result.success) {
					location.reload();
				}
			});

		}, "json");
	});
}

$("#procssTbl").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	order : [[3, "desc"]]
} );

</script>