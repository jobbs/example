<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 11. 16.
 * @lastmodified 2016. 11. 16.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 16.     박희택         v1.0             최초생성
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

<div class="col-box-100 detail-col">
	<!-- box(목록조회 테이블) -->
	<div class="box">

		<div class="box-header">
			<h3 class="box-title">API 정보</h3>
		</div>
 			<div class="box-body no-padding">
			<table class="table table-horizon">
   				<caption>API목록</caption>
				<colgroup>
					<col class="col20">
					<col class="col30">
					<col class="col20">
					<col class="col30">
				</colgroup>
				<tbody>
					<tr>
 						<th><label for="dc">설명</label></th>
 						<td colspan="3"><c:out value="${apiVo.dc}" /></td>
             		</tr>
            		<tr>
						<th><label for="ApiNm">API 명</label></th>
              			<td><c:out value="${apiVo.apiNm }" /></td>
   						<th><label for="apiVerCd">버전</label></th>
   						<td><c:out value="${apiVo.apiVerNm }" /></td>
               		</tr>
           			<tr>
           				<th><label for="methodCd">Method</label></th>
             			<td><c:out value="${apiVo.methodNm }" /></td>
						<th><label for="stackClCd">스택분류</label></th>
						<td><c:out value="${apiVo.stackClNm}" /></td>
					</tr>
					<tr>
 						<th><label for="uri">URI</label></th>
 						<td colspan="3"><c:out value="${apiVo.uri}" /></td>
					</tr>
          		</tbody>
   			</table>
		</div><!-- /box-body -->
	</div><!-- /box -->
</div>

<div class="col-box-100 search-col">
	<!-- box(목록조회 테이블) -->
	<div class="box">

		<div class="box-header">
			<h3 class="box-title">요청파라미터</h3>
		</div>
			<div class="box-body no-padding">
			<table class="table table-bordered" id="apiTable">
				<caption>요청파라미터</caption>
                <colgroup>
                  <col class="col6"> 	<!--스택분류-->
                  <col class="col20"> 	<!--항목-->
                  <col class="col20">  	<!--항목명-->
                  <col class="col5"> 	<!--타입-->
                  <col class="col4">	<!--필수여부-->
                  <col class="colAuto">	<!--설명-->
                </colgroup>
                <thead>
                	<tr>
	                    <th nowrap>스택분류</th>
	                    <th>항목</th>
	                    <th>항목명</th>
	                    <th>타입</th>
	                    <th nowrap>필수여부</th>
	                    <th>설명</th>
                  	</tr>
                </thead>
                <tbody>
					<c:forEach var="reqParamVo" items="${apiVo.reqParams }" varStatus="i">
						<tr>
							<td class="alignC"><c:out value="${reqParamVo.reqParamClNm}" /></td>
							<td class="alignL"><c:out value="${reqParamVo.reqParamIemId}" /></td>
							<td class="alignL"><c:out value="${reqParamVo.reqParamIemNm}" /></td>
							<td class="alignC"><c:out value="${reqParamVo.reqParamTypeNm}" /></td>
							<td class="alignC"><c:out value="${reqParamVo.reqParamEssntlAtNm}" /></td>
							<td class="alignL"><c:out value="${reqParamVo.reqParamDc}" /></td>
						</tr>
					</c:forEach>
                </tbody>
           	</table>
		</div><!-- /box-body -->
	</div><!-- /box -->
</div>

<div class="col-box-100 search-col">
	<!-- box(목록조회 테이블) -->
	<div class="box">

		<div class="box-header">
			<h3 class="box-title">응답결과</h3>
		</div>
			<div class="box-body no-padding">
			<table class="table table-bordered">
				<caption>응답결과</caption>
                <colgroup>
                  <col class="col20"> 	<!--항목-->
                  <col class="col20">  	<!--항목명-->
                  <col class="col5"> 	<!--타입-->
                  <col class="col4">	<!--필수여부-->
                  <col class="colAuto">	<!--설명-->
                </colgroup>
                <thead>
                	<tr>
	                    <th>항목</th>
	                    <th>항목명</th>
	                    <th>타입</th>
	                    <th nowrap>필수여부</th>
	                    <th>설명</th>
                  	</tr>
                </thead>
                <tbody>
					<c:forEach var="rspnsResultVo" items="${apiVo.rspnsResults }" varStatus="i">
						<tr>
							<td class="alignL"><c:out value="${rspnsResultVo.rspnsResultIemId}" /></td>
							<td class="alignL"><c:out value="${rspnsResultVo.rspnsResultIemNm}" /></td>
							<td class="alignC"><c:out value="${rspnsResultVo.rspnsResultTypeNm}" /></td>
							<td class="alignC"><c:out value="${rspnsResultVo.rspnsResultEssntlAtNm}" /></td>
							<td class="alignL"><c:out value="${rspnsResultVo.rspnsResultDc}" /></td>
						</tr>
					</c:forEach>
                </tbody>
           	</table>
		</div><!-- /box-body -->
	</div><!-- /box -->
</div>

<div class="col-box-100 detail-col">
	<!-- page-btn-group -->
	<div class="edit-btn-group">
		<c:url var="listUrl" value="selectListList.do">
			<c:forEach var="curParam" items="${param}">
				<c:if test="${curParam.key ne 'keyId'}">
					<c:param name="${curParam.key}" value="${curParam.value}"></c:param>
				</c:if>
			</c:forEach>
		</c:url>

		<div class="pull-left btns">
			<button type="button" class="btn btn-hover-gray" data-toggle="tooltip" data-original-title="뒤로" onclick="goToUrl('${listUrl}')">
				<i class="fa fa-arrow-left"></i>
			</button>
		</div>
	</div>
	<!-- /page-btn-group -->
</div>

<script type="text/javascript">

</script>