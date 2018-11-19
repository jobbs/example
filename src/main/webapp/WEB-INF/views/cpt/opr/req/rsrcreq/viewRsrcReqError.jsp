<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>


<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">오류가 발생했습니다.(자원요청 상세정보가 존재하지 않습니다.) 관리자에게 문의하시기 바랍니다.</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>SLB 기본정보</caption>
					<colgroup>
						<col class="col15">
						<col class="col85">
					</colgroup>
					<tbody>
						<tr><th>오류메시지</th><td class="alignL"><c:out value="${errormsg}"/></td></tr>
					</tbody>
				</table>
		</div>
	</div>
</div>

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
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
		</div>
	</div>
</div>



